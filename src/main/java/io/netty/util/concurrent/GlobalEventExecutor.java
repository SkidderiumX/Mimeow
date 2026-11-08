/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FailedFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.concurrent.ScheduledFutureTask;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalEventExecutor
extends AbstractEventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalEventExecutor.class);
    private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1L);
    public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();
    final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
    final Queue<ScheduledFutureTask<?>> delayedTaskQueue = new PriorityQueue();
    final ScheduledFutureTask<Void> purgeTask = new ScheduledFutureTask<Object>((EventExecutor)this, this.delayedTaskQueue, Executors.callable(new PurgeTask(), null), ScheduledFutureTask.deadlineNanos(SCHEDULE_PURGE_INTERVAL), -SCHEDULE_PURGE_INTERVAL);
    private final ThreadFactory threadFactory = new DefaultThreadFactory(this.getClass());
    private final TaskRunner taskRunner = new TaskRunner();
    private final AtomicBoolean started = new AtomicBoolean();
    volatile Thread thread;
    private final Future<?> terminationFuture = new FailedFuture(this, new UnsupportedOperationException());

    private GlobalEventExecutor() {
        this.delayedTaskQueue.add(this.purgeTask);
    }

    @Override
    public EventExecutorGroup parent() {
        return null;
    }

    Runnable takeTask() {
        Runnable runnable2;
        BlockingQueue<Runnable> blockingQueue = this.taskQueue;
        do {
            ScheduledFutureTask<?> scheduledFutureTask;
            if ((scheduledFutureTask = this.delayedTaskQueue.peek()) == null) {
                Runnable runnable3 = null;
                try {
                    runnable3 = blockingQueue.take();
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                return runnable3;
            }
            long l = scheduledFutureTask.delayNanos();
            if (l > 0L) {
                try {
                    runnable2 = blockingQueue.poll(l, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException interruptedException) {
                    return null;
                }
            } else {
                runnable2 = (Runnable)blockingQueue.poll();
            }
            if (runnable2 != null) continue;
            this.fetchFromDelayedQueue();
            runnable2 = (Runnable)blockingQueue.poll();
        } while (runnable2 == null);
        return runnable2;
    }

    private void fetchFromDelayedQueue() {
        ScheduledFutureTask<?> scheduledFutureTask;
        long l = 0L;
        while ((scheduledFutureTask = this.delayedTaskQueue.peek()) != null) {
            if (l == 0L) {
                l = ScheduledFutureTask.nanoTime();
            }
            if (scheduledFutureTask.deadlineNanos() > l) break;
            this.delayedTaskQueue.remove();
            this.taskQueue.add(scheduledFutureTask);
        }
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    private void addTask(Runnable runnable2) {
        if (runnable2 == null) {
            throw new NullPointerException("task");
        }
        this.taskQueue.add(runnable2);
    }

    @Override
    public boolean inEventLoop(Thread thread2) {
        return thread2 == this.thread;
    }

    @Override
    public Future<?> shutdownGracefully(long l, long l2, TimeUnit timeUnit) {
        return this.terminationFuture();
    }

    @Override
    public Future<?> terminationFuture() {
        return this.terminationFuture;
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
    public boolean awaitTermination(long l, TimeUnit timeUnit) {
        return false;
    }

    public boolean awaitInactivity(long l, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        Thread thread2 = this.thread;
        if (thread2 == null) {
            throw new IllegalStateException("thread was not started");
        }
        thread2.join(timeUnit.toMillis(l));
        return !thread2.isAlive();
    }

    @Override
    public void execute(Runnable runnable2) {
        if (runnable2 == null) {
            throw new NullPointerException("task");
        }
        this.addTask(runnable2);
        if (!this.inEventLoop()) {
            this.startThread();
        }
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable runnable2, long l, TimeUnit timeUnit) {
        if (runnable2 == null) {
            throw new NullPointerException("command");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (l < 0L) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: >= 0)", l));
        }
        return this.schedule(new ScheduledFutureTask<Object>((EventExecutor)this, this.delayedTaskQueue, runnable2, null, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(l))));
    }

    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long l, TimeUnit timeUnit) {
        if (callable == null) {
            throw new NullPointerException("callable");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (l < 0L) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: >= 0)", l));
        }
        return this.schedule(new ScheduledFutureTask<V>(this, this.delayedTaskQueue, callable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(l))));
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable2, long l, long l2, TimeUnit timeUnit) {
        if (runnable2 == null) {
            throw new NullPointerException("command");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (l < 0L) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", l));
        }
        if (l2 <= 0L) {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", l2));
        }
        return this.schedule(new ScheduledFutureTask<Object>((EventExecutor)this, this.delayedTaskQueue, Executors.callable(runnable2, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(l)), timeUnit.toNanos(l2)));
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable2, long l, long l2, TimeUnit timeUnit) {
        if (runnable2 == null) {
            throw new NullPointerException("command");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (l < 0L) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", l));
        }
        if (l2 <= 0L) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", l2));
        }
        return this.schedule(new ScheduledFutureTask<Object>((EventExecutor)this, this.delayedTaskQueue, Executors.callable(runnable2, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(l)), -timeUnit.toNanos(l2)));
    }

    private <V> ScheduledFuture<V> schedule(final ScheduledFutureTask<V> scheduledFutureTask) {
        if (scheduledFutureTask == null) {
            throw new NullPointerException("task");
        }
        if (this.inEventLoop()) {
            this.delayedTaskQueue.add(scheduledFutureTask);
        } else {
            this.execute(new Runnable(){

                @Override
                public void run() {
                    GlobalEventExecutor.this.delayedTaskQueue.add(scheduledFutureTask);
                }
            });
        }
        return scheduledFutureTask;
    }

    private void startThread() {
        if (this.started.compareAndSet(false, true)) {
            Thread thread2 = this.threadFactory.newThread(this.taskRunner);
            thread2.start();
            this.thread = thread2;
        }
    }

    private final class PurgeTask
    implements Runnable {
        private PurgeTask() {
        }

        @Override
        public void run() {
            Iterator iterator2 = GlobalEventExecutor.this.delayedTaskQueue.iterator();
            while (iterator2.hasNext()) {
                ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask)iterator2.next();
                if (!scheduledFutureTask.isCancelled()) continue;
                iterator2.remove();
            }
        }
    }

    public final class TaskRunner
    implements Runnable {
        TaskRunner() {
        }

        @Override
        public void run() {
            while (true) {
                Runnable runnable2;
                if ((runnable2 = GlobalEventExecutor.this.takeTask()) != null) {
                    try {
                        runnable2.run();
                    }
                    catch (Throwable throwable) {
                        logger.warn("Unexpected exception from the global event executor: ", throwable);
                    }
                    if (runnable2 != GlobalEventExecutor.this.purgeTask) continue;
                }
                if (!GlobalEventExecutor.this.taskQueue.isEmpty() || GlobalEventExecutor.this.delayedTaskQueue.size() != 1) continue;
                boolean bl = GlobalEventExecutor.this.started.compareAndSet(true, false);
                assert (bl);
                if (GlobalEventExecutor.this.taskQueue.isEmpty() && GlobalEventExecutor.this.delayedTaskQueue.size() == 1 || !GlobalEventExecutor.this.started.compareAndSet(false, true)) break;
            }
        }
    }
}

