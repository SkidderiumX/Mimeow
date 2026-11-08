/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.HttpConnectionMetricsImpl;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.impl.io.SessionInputBufferImpl;
import org.apache.http.impl.io.SessionOutputBufferImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.NetUtils;

@NotThreadSafe
public class BHttpConnectionBase
implements HttpConnection,
HttpInetConnection {
    private final SessionInputBufferImpl inbuffer;
    private final SessionOutputBufferImpl outbuffer;
    private final HttpConnectionMetricsImpl connMetrics;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private volatile boolean open;
    private volatile Socket socket;

    protected BHttpConnectionBase(int n, int n2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        Args.positive(n, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.inbuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, n, -1, messageConstraints != null ? messageConstraints : MessageConstraints.DEFAULT, charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, n, n2, charsetEncoder);
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        this.incomingContentStrategy = contentLengthStrategy != null ? contentLengthStrategy : LaxContentLengthStrategy.INSTANCE;
        this.outgoingContentStrategy = contentLengthStrategy2 != null ? contentLengthStrategy2 : StrictContentLengthStrategy.INSTANCE;
    }

    protected void ensureOpen() throws IOException {
        Asserts.check(this.open, "Connection is not open");
        if (!this.inbuffer.isBound()) {
            this.inbuffer.bind(this.getSocketInputStream(this.socket));
        }
        if (!this.outbuffer.isBound()) {
            this.outbuffer.bind(this.getSocketOutputStream(this.socket));
        }
    }

    protected InputStream getSocketInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    protected OutputStream getSocketOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

    protected void bind(Socket socket) throws IOException {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.open = true;
        this.inbuffer.bind(null);
        this.outbuffer.bind(null);
    }

    protected SessionInputBuffer getSessionInputBuffer() {
        return this.inbuffer;
    }

    protected SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    protected void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public boolean isOpen() {
        return this.open;
    }

    protected Socket getSocket() {
        return this.socket;
    }

    protected OutputStream createOutputStream(long l, SessionOutputBuffer sessionOutputBuffer) {
        if (l == -2L) {
            return new ChunkedOutputStream(2048, sessionOutputBuffer);
        }
        if (l == -1L) {
            return new IdentityOutputStream(sessionOutputBuffer);
        }
        return new ContentLengthOutputStream(sessionOutputBuffer, l);
    }

    protected OutputStream prepareOutput(HttpMessage httpMessage) throws HttpException {
        long l = this.outgoingContentStrategy.determineLength(httpMessage);
        return this.createOutputStream(l, this.outbuffer);
    }

    protected InputStream createInputStream(long l, SessionInputBuffer sessionInputBuffer) {
        if (l == -2L) {
            return new ChunkedInputStream(sessionInputBuffer);
        }
        if (l == -1L) {
            return new IdentityInputStream(sessionInputBuffer);
        }
        return new ContentLengthInputStream(sessionInputBuffer, l);
    }

    protected HttpEntity prepareInput(HttpMessage httpMessage) throws HttpException {
        Header header;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long l = this.incomingContentStrategy.determineLength(httpMessage);
        InputStream inputStream2 = this.createInputStream(l, this.inbuffer);
        if (l == -2L) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(inputStream2);
        } else if (l == -1L) {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(inputStream2);
        } else {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(l);
            basicHttpEntity.setContent(inputStream2);
        }
        Header header2 = httpMessage.getFirstHeader("Content-Type");
        if (header2 != null) {
            basicHttpEntity.setContentType(header2);
        }
        if ((header = httpMessage.getFirstHeader("Content-Encoding")) != null) {
            basicHttpEntity.setContentEncoding(header);
        }
        return basicHttpEntity;
    }

    public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        }
        return null;
    }

    public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        }
        return -1;
    }

    public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        }
        return -1;
    }

    public void setSocketTimeout(int n) {
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(n);
            }
            catch (SocketException socketException) {
                // empty catch block
            }
        }
    }

    public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            }
            catch (SocketException socketException) {
                return -1;
            }
        }
        return -1;
    }

    public void shutdown() throws IOException {
        this.open = false;
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        if (!this.open) {
            return;
        }
        this.open = false;
        Socket socket = this.socket;
        try {
            this.inbuffer.clear();
            this.outbuffer.flush();
            try {
                try {
                    socket.shutdownOutput();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                try {
                    socket.shutdownInput();
                }
                catch (IOException iOException) {
                }
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
        }
        finally {
            socket.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int fillInputBuffer(int n) throws IOException {
        int n2 = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(n);
            int n3 = this.inbuffer.fillBuffer();
            return n3;
        }
        finally {
            this.socket.setSoTimeout(n2);
        }
    }

    protected boolean awaitInput(int n) throws IOException {
        if (this.inbuffer.hasBufferedData()) {
            return true;
        }
        this.fillInputBuffer(n);
        return this.inbuffer.hasBufferedData();
    }

    public boolean isStale() {
        if (!this.isOpen()) {
            return true;
        }
        try {
            int n = this.fillInputBuffer(1);
            return n < 0;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            return false;
        }
        catch (IOException iOException) {
            return true;
        }
    }

    protected void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    protected void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    public String toString() {
        if (this.socket != null) {
            StringBuilder stringBuilder = new StringBuilder();
            SocketAddress socketAddress = this.socket.getRemoteSocketAddress();
            SocketAddress socketAddress2 = this.socket.getLocalSocketAddress();
            if (socketAddress != null && socketAddress2 != null) {
                NetUtils.formatAddress(stringBuilder, socketAddress2);
                stringBuilder.append("<->");
                NetUtils.formatAddress(stringBuilder, socketAddress);
            }
            return stringBuilder.toString();
        }
        return "[Not bound]";
    }
}

