/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.PromiseTask;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ScheduledFutureTask<V>
extends PromiseTask<V>
implements ScheduledFuture<V> {
    private static final AtomicLong nextTaskId = new AtomicLong();
    private static final long START_TIME = System.nanoTime();
    private final long id = nextTaskId.getAndIncrement();
    private final Queue<ScheduledFutureTask<?>> delayedTaskQueue;
    private long deadlineNanos;
    private final long periodNanos;

    static long nanoTime() {
        return System.nanoTime() - START_TIME;
    }

    static long deadlineNanos(long l) {
        return ScheduledFutureTask.nanoTime() + l;
    }

    ScheduledFutureTask(EventExecutor eventExecutor, Queue<ScheduledFutureTask<?>> queue, Runnable runnable2, V v, long l) {
        this(eventExecutor, queue, ScheduledFutureTask.toCallable(runnable2, v), l);
    }

    ScheduledFutureTask(EventExecutor eventExecutor, Queue<ScheduledFutureTask<?>> queue, Callable<V> callable, long l, long l2) {
        super(eventExecutor, callable);
        if (l2 == 0L) {
            throw new IllegalArgumentException("period: 0 (expected: != 0)");
        }
        this.delayedTaskQueue = queue;
        this.deadlineNanos = l;
        this.periodNanos = l2;
    }

    ScheduledFutureTask(EventExecutor eventExecutor, Queue<ScheduledFutureTask<?>> queue, Callable<V> callable, long l) {
        super(eventExecutor, callable);
        this.delayedTaskQueue = queue;
        this.deadlineNanos = l;
        this.periodNanos = 0L;
    }

    @Override
    protected EventExecutor executor() {
        return super.executor();
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public long delayNanos() {
        return Math.max(0L, this.deadlineNanos() - ScheduledFutureTask.nanoTime());
    }

    public long delayNanos(long l) {
        return Math.max(0L, this.deadlineNanos() - (l - START_TIME));
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.delayNanos(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask)delayed;
        long l = this.deadlineNanos() - scheduledFutureTask.deadlineNanos();
        if (l < 0L) {
            return -1;
        }
        if (l > 0L) {
            return 1;
        }
        if (this.id < scheduledFutureTask.id) {
            return -1;
        }
        if (this.id == scheduledFutureTask.id) {
            throw new Error();
        }
        return 1;
    }

    @Override
    public void run() {
        assert (this.executor().inEventLoop());
        try {
            if (this.periodNanos == 0L) {
                if (this.setUncancellableInternal()) {
                    Object v = this.task.call();
                    this.setSuccessInternal(v);
                }
            } else if (!this.isCancelled()) {
                this.task.call();
                if (!this.executor().isShutdown()) {
                    long l = this.periodNanos;
                    this.deadlineNanos = l > 0L ? (this.deadlineNanos += l) : ScheduledFutureTask.nanoTime() - l;
                    if (!this.isCancelled()) {
                        this.delayedTaskQueue.add(this);
                    }
                }
            }
        }
        catch (Throwable throwable) {
            this.setFailureInternal(throwable);
        }
    }

    @Override
    protected StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, ',');
        stringBuilder.append(" id: ");
        stringBuilder.append(this.id);
        stringBuilder.append(", deadline: ");
        stringBuilder.append(this.deadlineNanos);
        stringBuilder.append(", period: ");
        stringBuilder.append(this.periodNanos);
        stringBuilder.append(')');
        return stringBuilder;
    }
}

