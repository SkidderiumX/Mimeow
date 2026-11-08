/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

public abstract class AbstractFuture<V>
implements ListenableFuture<V> {
    private final Sync<V> sync = new Sync();
    private final ExecutionList executionList = new ExecutionList();

    protected AbstractFuture() {
    }

    @Override
    public V get(long l, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        return this.sync.get(timeUnit.toNanos(l));
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        return this.sync.get();
    }

    @Override
    public boolean isDone() {
        return this.sync.isDone();
    }

    @Override
    public boolean isCancelled() {
        return this.sync.isCancelled();
    }

    @Override
    public boolean cancel(boolean bl) {
        if (!this.sync.cancel(bl)) {
            return false;
        }
        this.executionList.execute();
        if (bl) {
            this.interruptTask();
        }
        return true;
    }

    protected void interruptTask() {
    }

    protected final boolean wasInterrupted() {
        return this.sync.wasInterrupted();
    }

    @Override
    public void addListener(Runnable runnable2, Executor executor) {
        this.executionList.add(runnable2, executor);
    }

    protected boolean set(@Nullable V v) {
        boolean bl = this.sync.set(v);
        if (bl) {
            this.executionList.execute();
        }
        return bl;
    }

    protected boolean setException(Throwable throwable) {
        boolean bl = this.sync.setException(Preconditions.checkNotNull(throwable));
        if (bl) {
            this.executionList.execute();
        }
        return bl;
    }

    static final CancellationException cancellationExceptionWithCause(@Nullable String string, @Nullable Throwable throwable) {
        CancellationException cancellationException = new CancellationException(string);
        cancellationException.initCause(throwable);
        return cancellationException;
    }

    public static final class Sync<V>
    extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 0L;
        static final int RUNNING = 0;
        static final int COMPLETING = 1;
        static final int COMPLETED = 2;
        static final int CANCELLED = 4;
        static final int INTERRUPTED = 8;
        private V value;
        private Throwable exception;

        Sync() {
        }

        @Override
        protected int tryAcquireShared(int n) {
            if (this.isDone()) {
                return 1;
            }
            return -1;
        }

        @Override
        protected boolean tryReleaseShared(int n) {
            this.setState(n);
            return true;
        }

        V get(long l) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
            if (!this.tryAcquireSharedNanos(-1, l)) {
                throw new TimeoutException("Timeout waiting for task.");
            }
            return this.getValue();
        }

        V get() throws CancellationException, ExecutionException, InterruptedException {
            this.acquireSharedInterruptibly(-1);
            return this.getValue();
        }

        private V getValue() throws CancellationException, ExecutionException {
            int n = this.getState();
            switch (n) {
                case 2: {
                    if (this.exception != null) {
                        throw new ExecutionException(this.exception);
                    }
                    return this.value;
                }
                case 4: 
                case 8: {
                    throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.exception);
                }
            }
            throw new IllegalStateException("Error, synchronizer in invalid state: " + n);
        }

        boolean isDone() {
            return (this.getState() & 0xE) != 0;
        }

        boolean isCancelled() {
            return (this.getState() & 0xC) != 0;
        }

        boolean wasInterrupted() {
            return this.getState() == 8;
        }

        boolean set(@Nullable V v) {
            return this.complete(v, null, 2);
        }

        boolean setException(Throwable throwable) {
            return this.complete(null, throwable, 2);
        }

        boolean cancel(boolean bl) {
            return this.complete(null, null, bl ? 8 : 4);
        }

        private boolean complete(@Nullable V v, @Nullable Throwable throwable, int n) {
            boolean bl = this.compareAndSetState(0, 1);
            if (bl) {
                this.value = v;
                this.exception = (n & 0xC) != 0 ? new CancellationException("Future.cancel() was called.") : throwable;
                this.releaseShared(n);
            } else if (this.getState() == 1) {
                this.acquireShared(-1);
            }
            return bl;
        }
    }
}

