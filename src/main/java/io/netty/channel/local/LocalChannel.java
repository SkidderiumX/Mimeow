/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.local;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalChannelRegistry;
import io.netty.channel.local.LocalServerChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.InternalThreadLocalMap;
import java.net.SocketAddress;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class LocalChannel
extends AbstractChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final int MAX_READER_STACK_DEPTH = 8;
    private final ChannelConfig config = new DefaultChannelConfig(this);
    private final Queue<Object> inboundBuffer = new ArrayDeque<Object>();
    private final Runnable readTask = new Runnable(){

        @Override
        public void run() {
            Object e;
            ChannelPipeline channelPipeline = LocalChannel.this.pipeline();
            while ((e = LocalChannel.this.inboundBuffer.poll()) != null) {
                channelPipeline.fireChannelRead(e);
            }
            channelPipeline.fireChannelReadComplete();
        }
    };
    private final Runnable shutdownHook = new Runnable(){

        @Override
        public void run() {
            LocalChannel.this.unsafe().close(LocalChannel.this.unsafe().voidPromise());
        }
    };
    private volatile int state;
    private volatile LocalChannel peer;
    private volatile LocalAddress localAddress;
    private volatile LocalAddress remoteAddress;
    private volatile ChannelPromise connectPromise;
    private volatile boolean readInProgress;
    private volatile boolean registerInProgress;

    public LocalChannel() {
        super(null);
    }

    LocalChannel(LocalServerChannel localServerChannel, LocalChannel localChannel) {
        super(localServerChannel);
        this.peer = localChannel;
        this.localAddress = localServerChannel.localAddress();
        this.remoteAddress = localChannel.localAddress();
    }

    @Override
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override
    public ChannelConfig config() {
        return this.config;
    }

    @Override
    public LocalServerChannel parent() {
        return (LocalServerChannel)super.parent();
    }

    @Override
    public LocalAddress localAddress() {
        return (LocalAddress)super.localAddress();
    }

    @Override
    public LocalAddress remoteAddress() {
        return (LocalAddress)super.remoteAddress();
    }

    @Override
    public boolean isOpen() {
        return this.state < 3;
    }

    @Override
    public boolean isActive() {
        return this.state == 2;
    }

    @Override
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new LocalUnsafe();
    }

    @Override
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof SingleThreadEventLoop;
    }

    @Override
    protected SocketAddress localAddress0() {
        return this.localAddress;
    }

    @Override
    protected SocketAddress remoteAddress0() {
        return this.remoteAddress;
    }

    @Override
    protected void doRegister() throws Exception {
        if (this.peer != null && this.parent() != null) {
            final LocalChannel localChannel = this.peer;
            this.registerInProgress = true;
            this.state = 2;
            localChannel.remoteAddress = this.parent().localAddress();
            localChannel.state = 2;
            localChannel.eventLoop().execute(new Runnable(){

                @Override
                public void run() {
                    LocalChannel.this.registerInProgress = false;
                    localChannel.pipeline().fireChannelActive();
                    localChannel.connectPromise.setSuccess();
                }
            });
        }
        ((SingleThreadEventExecutor)((Object)this.eventLoop())).addShutdownHook(this.shutdownHook);
    }

    @Override
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, socketAddress);
        this.state = 1;
    }

    @Override
    protected void doDisconnect() throws Exception {
        this.doClose();
    }

    @Override
    protected void doClose() throws Exception {
        LocalChannel localChannel;
        if (this.state <= 2) {
            if (this.localAddress != null) {
                if (this.parent() == null) {
                    LocalChannelRegistry.unregister(this.localAddress);
                }
                this.localAddress = null;
            }
            this.state = 3;
        }
        if ((localChannel = this.peer) != null && localChannel.isActive()) {
            EventLoop eventLoop = localChannel.eventLoop();
            if (eventLoop.inEventLoop() && !this.registerInProgress) {
                localChannel.unsafe().close(this.unsafe().voidPromise());
            } else {
                localChannel.eventLoop().execute(new Runnable(){

                    @Override
                    public void run() {
                        localChannel.unsafe().close(LocalChannel.this.unsafe().voidPromise());
                    }
                });
            }
            this.peer = null;
        }
    }

    @Override
    protected void doDeregister() throws Exception {
        ((SingleThreadEventExecutor)((Object)this.eventLoop())).removeShutdownHook(this.shutdownHook);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void doBeginRead() throws Exception {
        if (this.readInProgress) {
            return;
        }
        ChannelPipeline channelPipeline = this.pipeline();
        Queue<Object> queue = this.inboundBuffer;
        if (queue.isEmpty()) {
            this.readInProgress = true;
            return;
        }
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        Integer n = internalThreadLocalMap.localChannelReaderStackDepth();
        if (n < 8) {
            internalThreadLocalMap.setLocalChannelReaderStackDepth(n + 1);
            try {
                Object object;
                while ((object = queue.poll()) != null) {
                    channelPipeline.fireChannelRead(object);
                }
                channelPipeline.fireChannelReadComplete();
            }
            finally {
                internalThreadLocalMap.setLocalChannelReaderStackDepth(n);
            }
        } else {
            this.eventLoop().execute(this.readTask);
        }
    }

    @Override
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        if (this.state < 2) {
            throw new NotYetConnectedException();
        }
        if (this.state > 2) {
            throw new ClosedChannelException();
        }
        final LocalChannel localChannel = this.peer;
        final ChannelPipeline channelPipeline = localChannel.pipeline();
        EventLoop eventLoop = localChannel.eventLoop();
        if (eventLoop == this.eventLoop()) {
            Object object;
            while ((object = channelOutboundBuffer.current()) != null) {
                localChannel.inboundBuffer.add(object);
                ReferenceCountUtil.retain(object);
                channelOutboundBuffer.remove();
            }
            LocalChannel.finishPeerRead(localChannel, channelPipeline);
        } else {
            final Object[] objectArray = new Object[channelOutboundBuffer.size()];
            for (int i = 0; i < objectArray.length; ++i) {
                objectArray[i] = ReferenceCountUtil.retain(channelOutboundBuffer.current());
                channelOutboundBuffer.remove();
            }
            eventLoop.execute(new Runnable(){

                @Override
                public void run() {
                    Collections.addAll(localChannel.inboundBuffer, objectArray);
                    LocalChannel.finishPeerRead(localChannel, channelPipeline);
                }
            });
        }
    }

    private static void finishPeerRead(LocalChannel localChannel, ChannelPipeline channelPipeline) {
        if (localChannel.readInProgress) {
            Object object;
            localChannel.readInProgress = false;
            while ((object = localChannel.inboundBuffer.poll()) != null) {
                channelPipeline.fireChannelRead(object);
            }
            channelPipeline.fireChannelReadComplete();
        }
    }

    private class LocalUnsafe
    extends AbstractChannel.AbstractUnsafe {
        private LocalUnsafe() {
            super(LocalChannel.this);
        }

        @Override
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            Channel channel;
            if (!channelPromise.setUncancellable() || !this.ensureOpen(channelPromise)) {
                return;
            }
            if (LocalChannel.this.state == 2) {
                AlreadyConnectedException alreadyConnectedException = new AlreadyConnectedException();
                this.safeSetFailure(channelPromise, alreadyConnectedException);
                LocalChannel.this.pipeline().fireExceptionCaught(alreadyConnectedException);
                return;
            }
            if (LocalChannel.this.connectPromise != null) {
                throw new ConnectionPendingException();
            }
            LocalChannel.this.connectPromise = channelPromise;
            if (LocalChannel.this.state != 1 && socketAddress2 == null) {
                socketAddress2 = new LocalAddress(LocalChannel.this);
            }
            if (socketAddress2 != null) {
                try {
                    LocalChannel.this.doBind(socketAddress2);
                }
                catch (Throwable throwable) {
                    this.safeSetFailure(channelPromise, throwable);
                    this.close(this.voidPromise());
                    return;
                }
            }
            if (!((channel = LocalChannelRegistry.get(socketAddress)) instanceof LocalServerChannel)) {
                ChannelException channelException = new ChannelException("connection refused");
                this.safeSetFailure(channelPromise, channelException);
                this.close(this.voidPromise());
                return;
            }
            LocalServerChannel localServerChannel = (LocalServerChannel)channel;
            LocalChannel.this.peer = localServerChannel.serve(LocalChannel.this);
        }
    }
}

