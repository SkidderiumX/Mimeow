/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.interfaces.ISSLChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLSocketChannel2
implements ByteChannel,
WrappedByteChannel,
ISSLChannel {
    protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);
    private final Logger log = LoggerFactory.getLogger(SSLSocketChannel2.class);
    protected ExecutorService exec;
    protected List<Future<?>> tasks;
    protected ByteBuffer inData;
    protected ByteBuffer outCrypt;
    protected ByteBuffer inCrypt;
    protected SocketChannel socketChannel;
    protected SelectionKey selectionKey;
    protected SSLEngine sslEngine;
    protected SSLEngineResult readEngineResult;
    protected SSLEngineResult writeEngineResult;
    protected int bufferallocations = 0;
    private byte[] saveCryptData = null;

    public SSLSocketChannel2(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) throws IOException {
        if (socketChannel == null || sSLEngine == null || executorService == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.socketChannel = socketChannel;
        this.sslEngine = sSLEngine;
        this.exec = executorService;
        this.readEngineResult = this.writeEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
        this.tasks = new ArrayList(3);
        if (selectionKey != null) {
            selectionKey.interestOps(selectionKey.interestOps() | 4);
            this.selectionKey = selectionKey;
        }
        this.createBuffers(sSLEngine.getSession());
        this.socketChannel.write(this.wrap(emptybuffer));
        this.processHandshake(false);
    }

    private void consumeFutureUninterruptible(Future<?> future) {
        try {
            while (true) {
                try {
                    future.get();
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    continue;
                }
                break;
            }
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException(executionException);
        }
    }

    private synchronized void processHandshake(boolean bl) throws IOException {
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        if (!this.tasks.isEmpty()) {
            Iterator<Future<?>> iterator2 = this.tasks.iterator();
            while (iterator2.hasNext()) {
                Future<?> future = iterator2.next();
                if (future.isDone()) {
                    iterator2.remove();
                    continue;
                }
                if (this.isBlocking()) {
                    this.consumeFutureUninterruptible(future);
                }
                return;
            }
        }
        if (bl && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (!this.isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                this.inCrypt.compact();
                int n = this.socketChannel.read(this.inCrypt);
                if (n == -1) {
                    throw new IOException("connection closed unexpectedly by peer");
                }
                this.inCrypt.flip();
            }
            this.inData.compact();
            this.unwrap();
            if (this.readEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                this.createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        this.consumeDelegatedTasks();
        if (this.tasks.isEmpty() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            this.socketChannel.write(this.wrap(emptybuffer));
            if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                this.createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        assert (this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
        this.bufferallocations = 1;
    }

    private synchronized ByteBuffer wrap(ByteBuffer byteBuffer) throws SSLException {
        this.outCrypt.compact();
        this.writeEngineResult = this.sslEngine.wrap(byteBuffer, this.outCrypt);
        this.outCrypt.flip();
        return this.outCrypt;
    }

    private synchronized ByteBuffer unwrap() throws SSLException {
        int n;
        if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            try {
                this.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        do {
            n = this.inData.remaining();
            this.readEngineResult = this.sslEngine.unwrap(this.inCrypt, this.inData);
        } while (this.readEngineResult.getStatus() == SSLEngineResult.Status.OK && (n != this.inData.remaining() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP));
        this.inData.flip();
        return this.inData;
    }

    protected void consumeDelegatedTasks() {
        Runnable runnable2;
        while ((runnable2 = this.sslEngine.getDelegatedTask()) != null) {
            this.tasks.add(this.exec.submit(runnable2));
        }
    }

    protected void createBuffers(SSLSession sSLSession) {
        this.saveCryptedData();
        int n = sSLSession.getPacketBufferSize();
        int n2 = Math.max(sSLSession.getApplicationBufferSize(), n);
        if (this.inData == null) {
            this.inData = ByteBuffer.allocate(n2);
            this.outCrypt = ByteBuffer.allocate(n);
            this.inCrypt = ByteBuffer.allocate(n);
        } else {
            if (this.inData.capacity() != n2) {
                this.inData = ByteBuffer.allocate(n2);
            }
            if (this.outCrypt.capacity() != n) {
                this.outCrypt = ByteBuffer.allocate(n);
            }
            if (this.inCrypt.capacity() != n) {
                this.inCrypt = ByteBuffer.allocate(n);
            }
        }
        if (this.inData.remaining() != 0 && this.log.isTraceEnabled()) {
            this.log.trace(new String(this.inData.array(), this.inData.position(), this.inData.remaining()));
        }
        this.inData.rewind();
        this.inData.flip();
        if (this.inCrypt.remaining() != 0 && this.log.isTraceEnabled()) {
            this.log.trace(new String(this.inCrypt.array(), this.inCrypt.position(), this.inCrypt.remaining()));
        }
        this.inCrypt.rewind();
        this.inCrypt.flip();
        this.outCrypt.rewind();
        this.outCrypt.flip();
        ++this.bufferallocations;
    }

    @Override
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.isHandShakeComplete()) {
            this.processHandshake(false);
            return 0;
        }
        int n = this.socketChannel.write(this.wrap(byteBuffer));
        if (this.writeEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
            throw new EOFException("Connection is closed");
        }
        return n;
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        int n;
        this.tryRestoreCryptedData();
        do {
            int n2;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            if (!this.isHandShakeComplete()) {
                if (this.isBlocking()) {
                    while (!this.isHandShakeComplete()) {
                        this.processHandshake(true);
                    }
                } else {
                    this.processHandshake(true);
                    if (!this.isHandShakeComplete()) {
                        return 0;
                    }
                }
            }
            if ((n2 = this.readRemaining(byteBuffer)) != 0) {
                return n2;
            }
            assert (this.inData.position() == 0);
            this.inData.clear();
            if (!this.inCrypt.hasRemaining()) {
                this.inCrypt.clear();
            } else {
                this.inCrypt.compact();
            }
            if ((this.isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.socketChannel.read(this.inCrypt) == -1) {
                return -1;
            }
            this.inCrypt.flip();
            this.unwrap();
            n = this.transfereTo(this.inData, byteBuffer);
        } while (n == 0 && this.isBlocking());
        return n;
    }

    private int readRemaining(ByteBuffer byteBuffer) throws SSLException {
        if (this.inData.hasRemaining()) {
            return this.transfereTo(this.inData, byteBuffer);
        }
        if (!this.inData.hasRemaining()) {
            this.inData.clear();
        }
        this.tryRestoreCryptedData();
        if (this.inCrypt.hasRemaining()) {
            this.unwrap();
            int n = this.transfereTo(this.inData, byteBuffer);
            if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
                return -1;
            }
            if (n > 0) {
                return n;
            }
        }
        return 0;
    }

    public boolean isConnected() {
        return this.socketChannel.isConnected();
    }

    @Override
    public void close() throws IOException {
        this.sslEngine.closeOutbound();
        this.sslEngine.getSession().invalidate();
        try {
            if (this.socketChannel.isOpen()) {
                this.socketChannel.write(this.wrap(emptybuffer));
            }
        }
        finally {
            this.socketChannel.close();
        }
    }

    private boolean isHandShakeComplete() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    public SelectableChannel configureBlocking(boolean bl) throws IOException {
        return this.socketChannel.configureBlocking(bl);
    }

    public boolean connect(SocketAddress socketAddress) throws IOException {
        return this.socketChannel.connect(socketAddress);
    }

    public boolean finishConnect() throws IOException {
        return this.socketChannel.finishConnect();
    }

    public Socket socket() {
        return this.socketChannel.socket();
    }

    public boolean isInboundDone() {
        return this.sslEngine.isInboundDone();
    }

    @Override
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override
    public boolean isNeedWrite() {
        return this.outCrypt.hasRemaining() || !this.isHandShakeComplete();
    }

    @Override
    public void writeMore() throws IOException {
        this.write(this.outCrypt);
    }

    @Override
    public boolean isNeedRead() {
        return this.saveCryptData != null || this.inData.hasRemaining() || this.inCrypt.hasRemaining() && this.readEngineResult.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW && this.readEngineResult.getStatus() != SSLEngineResult.Status.CLOSED;
    }

    @Override
    public int readMore(ByteBuffer byteBuffer) throws SSLException {
        return this.readRemaining(byteBuffer);
    }

    private int transfereTo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int n;
        int n2 = byteBuffer.remaining();
        if (n2 > (n = byteBuffer2.remaining())) {
            int n3 = Math.min(n2, n);
            for (int i = 0; i < n3; ++i) {
                byteBuffer2.put(byteBuffer.get());
            }
            return n3;
        }
        byteBuffer2.put(byteBuffer);
        return n2;
    }

    @Override
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    @Override
    public SSLEngine getSSLEngine() {
        return this.sslEngine;
    }

    private void saveCryptedData() {
        if (this.inCrypt != null && this.inCrypt.remaining() > 0) {
            int n = this.inCrypt.remaining();
            this.saveCryptData = new byte[n];
            this.inCrypt.get(this.saveCryptData);
        }
    }

    private void tryRestoreCryptedData() {
        if (this.saveCryptData != null) {
            this.inCrypt.clear();
            this.inCrypt.put(this.saveCryptData);
            this.inCrypt.flip();
            this.saveCryptData = null;
        }
    }
}

