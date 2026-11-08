/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.util.concurrent.ThreadFactory;

public abstract class SingleThreadEventLoop
extends SingleThreadEventExecutor
implements EventLoop {
    protected SingleThreadEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory, boolean bl) {
        super(eventLoopGroup, threadFactory, bl);
    }

    @Override
    public EventLoopGroup parent() {
        return (EventLoopGroup)super.parent();
    }

    @Override
    public EventLoop next() {
        return (EventLoop)super.next();
    }

    @Override
    public ChannelFuture register(Channel channel) {
        return this.register(channel, new DefaultChannelPromise(channel, this));
    }

    @Override
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        if (channelPromise == null) {
            throw new NullPointerException("promise");
        }
        channel.unsafe().register(this, channelPromise);
        return channelPromise;
    }

    @Override
    protected boolean wakesUpForTask(Runnable runnable2) {
        return !(runnable2 instanceof NonWakeupRunnable);
    }

    public static interface NonWakeupRunnable
    extends Runnable {
    }
}

