/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.DefaultProgressivePromise;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FailedFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ProgressivePromise;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseTask;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.concurrent.SucceededFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

public abstract class AbstractEventExecutor
extends AbstractExecutorService
implements EventExecutor {
    @Override
    public EventExecutor next() {
        return this;
    }

    @Override
    public boolean inEventLoop() {
        return this.inEventLoop(Thread.currentThread());
    }

    @Override
    public Iterator<EventExecutor> iterator() {
        return new EventExecutorIterator();
    }

    @Override
    public Future<?> shutdownGracefully() {
        return this.shutdownGracefully(2L, 15L, TimeUnit.SECONDS);
    }

    @Override
    @Deprecated
    public abstract void shutdown();

    @Override
    @Deprecated
    public List<Runnable> shutdownNow() {
        this.shutdown();
        return Collections.emptyList();
    }

    @Override
    public <V> Promise<V> newPromise() {
        return new DefaultPromise(this);
    }

    @Override
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new DefaultProgressivePromise(this);
    }

    @Override
    public <V> Future<V> newSucceededFuture(V v) {
        return new SucceededFuture<V>(this, v);
    }

    @Override
    public <V> Future<V> newFailedFuture(Throwable throwable) {
        return new FailedFuture(this, throwable);
    }

    @Override
    public Future<?> submit(Runnable runnable2) {
        return (Future)super.submit(runnable2);
    }

    @Override
    public <T> Future<T> submit(Runnable runnable2, T t) {
        return (Future)super.submit(runnable2, t);
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return (Future)super.submit(callable);
    }

    @Override
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable2, T t) {
        return new PromiseTask<T>(this, runnable2, t);
    }

    @Override
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new PromiseTask<T>(this, callable);
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable runnable2, long l, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long l, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable2, long l, long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable2, long l, long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    private final class EventExecutorIterator
    implements Iterator<EventExecutor> {
        private boolean nextCalled;

        private EventExecutorIterator() {
        }

        @Override
        public boolean hasNext() {
            return !this.nextCalled;
        }

        @Override
        public EventExecutor next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.nextCalled = true;
            return AbstractEventExecutor.this;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("read-only");
        }
    }
}

