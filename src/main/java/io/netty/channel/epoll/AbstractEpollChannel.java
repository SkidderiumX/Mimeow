/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.EventLoop;
import io.netty.channel.epoll.EpollEventLoop;
import io.netty.channel.epoll.Native;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.OneTimeTask;
import java.net.InetSocketAddress;
import java.nio.channels.UnresolvedAddressException;

public abstract class AbstractEpollChannel
extends AbstractChannel {
    private static final ChannelMetadata DATA = new ChannelMetadata(false);
    private final int readFlag;
    protected int flags;
    protected volatile boolean active;
    volatile int fd;
    int id;

    AbstractEpollChannel(int n, int n2) {
        this(null, n, n2, false);
    }

    AbstractEpollChannel(Channel channel, int n, int n2, boolean bl) {
        super(channel);
        this.fd = n;
        this.readFlag = n2;
        this.flags |= n2;
        this.active = bl;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public ChannelMetadata metadata() {
        return DATA;
    }

    @Override
    protected void doClose() throws Exception {
        this.active = false;
        this.doDeregister();
        int n = this.fd;
        this.fd = -1;
        Native.close(n);
    }

    @Override
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress)super.remoteAddress();
    }

    @Override
    public InetSocketAddress localAddress() {
        return (InetSocketAddress)super.localAddress();
    }

    @Override
    protected void doDisconnect() throws Exception {
        this.doClose();
    }

    @Override
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    @Override
    public boolean isOpen() {
        return this.fd != -1;
    }

    @Override
    protected void doDeregister() throws Exception {
        ((EpollEventLoop)this.eventLoop()).remove(this);
    }

    @Override
    protected void doBeginRead() throws Exception {
        ((AbstractEpollUnsafe)this.unsafe()).readPending = true;
        if ((this.flags & this.readFlag) == 0) {
            this.flags |= this.readFlag;
            this.modifyEvents();
        }
    }

    final void clearEpollIn() {
        if (this.isRegistered()) {
            EventLoop eventLoop = this.eventLoop();
            final AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollUnsafe)this.unsafe();
            if (eventLoop.inEventLoop()) {
                abstractEpollUnsafe.clearEpollIn0();
            } else {
                eventLoop.execute(new OneTimeTask(){

                    @Override
                    public void run() {
                        if (!AbstractEpollChannel.this.config().isAutoRead() && !abstractEpollUnsafe.readPending) {
                            abstractEpollUnsafe.clearEpollIn0();
                        }
                    }
                });
            }
        } else {
            this.flags &= ~this.readFlag;
        }
    }

    protected final void setEpollOut() {
        if ((this.flags & 2) == 0) {
            this.flags |= 2;
            this.modifyEvents();
        }
    }

    protected final void clearEpollOut() {
        if ((this.flags & 2) != 0) {
            this.flags &= 0xFFFFFFFD;
            this.modifyEvents();
        }
    }

    private void modifyEvents() {
        if (this.isOpen()) {
            ((EpollEventLoop)this.eventLoop()).modify(this);
        }
    }

    @Override
    protected void doRegister() throws Exception {
        EpollEventLoop epollEventLoop = (EpollEventLoop)this.eventLoop();
        epollEventLoop.add(this);
    }

    @Override
    protected abstract AbstractEpollUnsafe newUnsafe();

    protected final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        return this.newDirectBuffer(byteBuf, byteBuf);
    }

    protected final ByteBuf newDirectBuffer(Object object, ByteBuf byteBuf) {
        int n = byteBuf.readableBytes();
        if (n == 0) {
            ReferenceCountUtil.safeRelease(object);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocator = this.alloc();
        if (byteBufAllocator.isDirectBufferPooled()) {
            return AbstractEpollChannel.newDirectBuffer0(object, byteBuf, byteBufAllocator, n);
        }
        ByteBuf byteBuf2 = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBuf2 == null) {
            return AbstractEpollChannel.newDirectBuffer0(object, byteBuf, byteBufAllocator, n);
        }
        byteBuf2.writeBytes(byteBuf, byteBuf.readerIndex(), n);
        ReferenceCountUtil.safeRelease(object);
        return byteBuf2;
    }

    private static ByteBuf newDirectBuffer0(Object object, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, int n) {
        ByteBuf byteBuf2 = byteBufAllocator.directBuffer(n);
        byteBuf2.writeBytes(byteBuf, byteBuf.readerIndex(), n);
        ReferenceCountUtil.safeRelease(object);
        return byteBuf2;
    }

    protected static void checkResolvable(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    protected abstract class AbstractEpollUnsafe
    extends AbstractChannel.AbstractUnsafe {
        protected boolean readPending;

        protected AbstractEpollUnsafe() {
            super(AbstractEpollChannel.this);
        }

        abstract void epollInReady();

        void epollRdHupReady() {
        }

        @Override
        protected void flush0() {
            if (this.isFlushPending()) {
                return;
            }
            super.flush0();
        }

        void epollOutReady() {
            super.flush0();
        }

        private boolean isFlushPending() {
            return (AbstractEpollChannel.this.flags & 2) != 0;
        }

        protected final void clearEpollIn0() {
            if ((AbstractEpollChannel.this.flags & AbstractEpollChannel.this.readFlag) != 0) {
                AbstractEpollChannel.this.flags &= ~AbstractEpollChannel.this.readFlag;
                AbstractEpollChannel.this.modifyEvents();
            }
        }
    }
}

