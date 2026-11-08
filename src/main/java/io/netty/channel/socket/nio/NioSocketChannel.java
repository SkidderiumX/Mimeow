/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.OneTimeTask;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.SelectorProvider;

public class NioSocketChannel
extends AbstractNioByteChannel
implements SocketChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private final SocketChannelConfig config;

    private static java.nio.channels.SocketChannel newSocket(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openSocketChannel();
        }
        catch (IOException iOException) {
            throw new ChannelException("Failed to open a socket.", iOException);
        }
    }

    public NioSocketChannel() {
        this(NioSocketChannel.newSocket(DEFAULT_SELECTOR_PROVIDER));
    }

    public NioSocketChannel(SelectorProvider selectorProvider) {
        this(NioSocketChannel.newSocket(selectorProvider));
    }

    public NioSocketChannel(java.nio.channels.SocketChannel socketChannel) {
        this(null, socketChannel);
    }

    public NioSocketChannel(Channel channel, java.nio.channels.SocketChannel socketChannel) {
        super(channel, socketChannel);
        this.config = new NioSocketChannelConfig(this, socketChannel.socket());
    }

    @Override
    public ServerSocketChannel parent() {
        return (ServerSocketChannel)super.parent();
    }

    @Override
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override
    public SocketChannelConfig config() {
        return this.config;
    }

    @Override
    protected java.nio.channels.SocketChannel javaChannel() {
        return (java.nio.channels.SocketChannel)super.javaChannel();
    }

    @Override
    public boolean isActive() {
        java.nio.channels.SocketChannel socketChannel = this.javaChannel();
        return socketChannel.isOpen() && socketChannel.isConnected();
    }

    @Override
    public boolean isInputShutdown() {
        return super.isInputShutdown();
    }

    @Override
    public InetSocketAddress localAddress() {
        return (InetSocketAddress)super.localAddress();
    }

    @Override
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress)super.remoteAddress();
    }

    @Override
    public boolean isOutputShutdown() {
        return this.javaChannel().socket().isOutputShutdown() || !this.isActive();
    }

    @Override
    public ChannelFuture shutdownOutput() {
        return this.shutdownOutput(this.newPromise());
    }

    @Override
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        NioEventLoop nioEventLoop = this.eventLoop();
        if (nioEventLoop.inEventLoop()) {
            try {
                this.javaChannel().socket().shutdownOutput();
                channelPromise.setSuccess();
            }
            catch (Throwable throwable) {
                channelPromise.setFailure(throwable);
            }
        } else {
            nioEventLoop.execute(new OneTimeTask(){

                @Override
                public void run() {
                    NioSocketChannel.this.shutdownOutput(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override
    protected SocketAddress localAddress0() {
        return this.javaChannel().socket().getLocalSocketAddress();
    }

    @Override
    protected SocketAddress remoteAddress0() {
        return this.javaChannel().socket().getRemoteSocketAddress();
    }

    @Override
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.javaChannel().socket().bind(socketAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            this.javaChannel().socket().bind(socketAddress2);
        }
        boolean bl = false;
        try {
            boolean bl2 = this.javaChannel().connect(socketAddress);
            if (!bl2) {
                this.selectionKey().interestOps(8);
            }
            bl = true;
            boolean bl3 = bl2;
            return bl3;
        }
        finally {
            if (!bl) {
                this.doClose();
            }
        }
    }

    @Override
    protected void doFinishConnect() throws Exception {
        if (!this.javaChannel().finishConnect()) {
            throw new Error();
        }
    }

    @Override
    protected void doDisconnect() throws Exception {
        this.doClose();
    }

    @Override
    protected void doClose() throws Exception {
        this.javaChannel().close();
    }

    @Override
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
        return byteBuf.writeBytes(this.javaChannel(), byteBuf.writableBytes());
    }

    @Override
    protected int doWriteBytes(ByteBuf byteBuf) throws Exception {
        int n = byteBuf.readableBytes();
        return byteBuf.readBytes(this.javaChannel(), n);
    }

    @Override
    protected long doWriteFileRegion(FileRegion fileRegion) throws Exception {
        long l = fileRegion.transfered();
        return fileRegion.transferTo(this.javaChannel(), l);
    }

    @Override
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        block10: {
            boolean bl;
            boolean bl2;
            do {
                int n;
                if ((n = channelOutboundBuffer.size()) == 0) {
                    this.clearOpWrite();
                    break block10;
                }
                long l = 0L;
                bl2 = false;
                bl = false;
                ByteBuffer[] byteBufferArray = channelOutboundBuffer.nioBuffers();
                int n2 = channelOutboundBuffer.nioBufferCount();
                long l2 = channelOutboundBuffer.nioBufferSize();
                java.nio.channels.SocketChannel socketChannel = this.javaChannel();
                block0 : switch (n2) {
                    case 0: {
                        super.doWrite(channelOutboundBuffer);
                        return;
                    }
                    case 1: {
                        int n3;
                        ByteBuffer byteBuffer = byteBufferArray[0];
                        for (n3 = this.config().getWriteSpinCount() - 1; n3 >= 0; --n3) {
                            int n4 = socketChannel.write(byteBuffer);
                            if (n4 == 0) {
                                bl = true;
                                break block0;
                            }
                            l += (long)n4;
                            if ((l2 -= (long)n4) != 0L) continue;
                            bl2 = true;
                            break block0;
                        }
                        break;
                    }
                    default: {
                        int n3;
                        for (n3 = this.config().getWriteSpinCount() - 1; n3 >= 0; --n3) {
                            long l3 = socketChannel.write(byteBufferArray, 0, n2);
                            if (l3 == 0L) {
                                bl = true;
                                break block0;
                            }
                            l += l3;
                            if ((l2 -= l3) != 0L) continue;
                            bl2 = true;
                            break block0;
                        }
                    }
                }
                channelOutboundBuffer.removeBytes(l);
            } while (bl2);
            this.incompleteWrite(bl);
        }
    }

    private final class NioSocketChannelConfig
    extends DefaultSocketChannelConfig {
        private NioSocketChannelConfig(NioSocketChannel nioSocketChannel2, Socket socket) {
            super(nioSocketChannel2, socket);
        }

        @Override
        protected void autoReadCleared() {
            NioSocketChannel.this.setReadPending(false);
        }
    }
}

