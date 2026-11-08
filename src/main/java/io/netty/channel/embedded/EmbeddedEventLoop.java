/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.embedded;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.Future;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class EmbeddedEventLoop
extends AbstractEventExecutor
implements EventLoop {
    private final Queue<Runnable> tasks = new ArrayDeque<Runnable>(2);

    EmbeddedEventLoop() {
    }

    @Override
    public void execute(Runnable runnable2) {
        if (runnable2 == null) {
            throw new NullPointerException("command");
        }
        this.tasks.add(runnable2);
    }

    void runTasks() {
        Runnable runnable2;
        while ((runnable2 = this.tasks.poll()) != null) {
            runnable2.run();
        }
    }

    @Override
    public Future<?> shutdownGracefully(long l, long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Future<?> terminationFuture() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isShuttingDown() {
        return false;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        Thread.sleep(timeUnit.toMillis(l));
        return false;
    }

    @Override
    public ChannelFuture register(Channel channel) {
        return this.register(channel, new DefaultChannelPromise(channel, this));
    }

    @Override
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        channel.unsafe().register(this, channelPromise);
        return channelPromise;
    }

    @Override
    public boolean inEventLoop() {
        return true;
    }

    @Override
    public boolean inEventLoop(Thread thread2) {
        return true;
    }

    @Override
    public EventLoop next() {
        return this;
    }

    @Override
    public EventLoopGroup parent() {
        return this;
    }
}

