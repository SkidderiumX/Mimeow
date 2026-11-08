/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.concurrent.ScheduledFutureTask;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class SingleThreadEventExecutor
extends AbstractEventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SingleThreadEventExecutor.class);
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_STARTED = 2;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_TERMINATED = 5;
    private static final Runnable WAKEUP_TASK = new Runnable(){

        @Override
        public void run() {
        }
    };
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER;
    private final EventExecutorGroup parent;
    private final Queue<Runnable> taskQueue;
    final Queue<ScheduledFutureTask<?>> delayedTaskQueue = new PriorityQueue();
    private final Thread thread;
    private final Semaphore threadLock = new Semaphore(0);
    private final Set<Runnable> shutdownHooks = new LinkedHashSet<Runnable>();
    private final boolean addTaskWakesUp;
    private long lastExecutionTime;
    private volatile int state = 1;
    private volatile long gracefulShutdownQuietPeriod;
    private volatile long gracefulShutdownTimeout;
    private long gracefulShutdownStartTime;
    private final Promise<?> terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
    private static final long SCHEDULE_PURGE_INTERVAL;

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean bl) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        this.parent = eventExecutorGroup;
        this.addTaskWakesUp = bl;
        this.thread = threadFactory.newThread(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                boolean bl = false;
                SingleThreadEventExecutor.this.updateLastExecutionTime();
                try {
                    SingleThreadEventExecutor.this.run();
                    bl = true;
                }
                catch (Throwable throwable) {
                    logger.warn("Unexpected exception from an event executor: ", throwable);
                }
                finally {
                    int n;
                    while ((n = STATE_UPDATER.get(SingleThreadEventExecutor.this)) < 3 && !STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, n, 3)) {
                    }
                    if (bl && SingleThreadEventExecutor.this.gracefulShutdownStartTime == 0L) {
                        logger.error("Buggy " + EventExecutor.class.getSimpleName() + " implementation; " + SingleThreadEventExecutor.class.getSimpleName() + ".confirmShutdown() must be called " + "before run() implementation terminates.");
                    }
                    while (!SingleThreadEventExecutor.this.confirmShutdown()) {
                    }
                }
                try {
                    SingleThreadEventExecutor.this.cleanup();
                    return;
                }
                finally {
                    STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                    SingleThreadEventExecutor.this.threadLock.release();
                    if (!SingleThreadEventExecutor.this.taskQueue.isEmpty()) {
                        logger.warn("An event executor terminated with non-empty task queue (" + SingleThreadEventExecutor.this.taskQueue.size() + ')');
                    }
                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                }
            }
        });
        this.taskQueue = this.newTaskQueue();
    }

    protected Queue<Runnable> newTaskQueue() {
        return new LinkedBlockingQueue<Runnable>();
    }

    @Override
    public EventExecutorGroup parent() {
        return this.parent;
    }

    protected void interruptThread() {
        this.thread.interrupt();
    }

    protected Runnable pollTask() {
        Runnable runnable2;
        assert (this.inEventLoop());
        while ((runnable2 = this.taskQueue.poll()) == WAKEUP_TASK) {
        }
        return runnable2;
    }

    protected Runnable takeTask() {
        Runnable runnable2;
        assert (this.inEventLoop());
        if (!(this.taskQueue instanceof BlockingQueue)) {
            throw new UnsupportedOperationException();
        }
        BlockingQueue blockingQueue = (BlockingQueue)this.taskQueue;
        do {
            ScheduledFutureTask<?> scheduledFutureTask;
            if ((scheduledFutureTask = this.delayedTaskQueue.peek()) == null) {
                Runnable runnable3 = null;
                try {
                    runnable3 = (Runnable)blockingQueue.take();
                    if (runnable3 == WAKEUP_TASK) {
                        runnable3 = null;
                    }
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                return runnable3;
            }
            long l = scheduledFutureTask.delayNanos();
            runnable2 = null;
            if (l > 0L) {
                try {
                    runnable2 = (Runnable)blockingQueue.poll(l, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException interruptedException) {
                    return null;
                }
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

    protected Runnable peekTask() {
        assert (this.inEventLoop());
        return this.taskQueue.peek();
    }

    protected boolean hasTasks() {
        assert (this.inEventLoop());
        return !this.taskQueue.isEmpty();
    }

    protected boolean hasScheduledTasks() {
        assert (this.inEventLoop());
        ScheduledFutureTask<?> scheduledFutureTask = this.delayedTaskQueue.peek();
        return scheduledFutureTask != null && scheduledFutureTask.deadlineNanos() <= ScheduledFutureTask.nanoTime();
    }

    public final int pendingTasks() {
        return this.taskQueue.size();
    }

    protected void addTask(Runnable runnable2) {
        if (runnable2 == null) {
            throw new NullPointerException("task");
        }
        if (this.isShutdown()) {
            SingleThreadEventExecutor.reject();
        }
        this.taskQueue.add(runnable2);
    }

    protected boolean removeTask(Runnable runnable2) {
        if (runnable2 == null) {
            throw new NullPointerException("task");
        }
        return this.taskQueue.remove(runnable2);
    }

    protected boolean runAllTasks() {
        this.fetchFromDelayedQueue();
        Runnable runnable2 = this.pollTask();
        if (runnable2 == null) {
            return false;
        }
        do {
            try {
                runnable2.run();
            }
            catch (Throwable throwable) {
                logger.warn("A task raised an exception.", throwable);
            }
        } while ((runnable2 = this.pollTask()) != null);
        this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        return true;
    }

    protected boolean runAllTasks(long l) {
        long l2;
        block4: {
            this.fetchFromDelayedQueue();
            Runnable runnable2 = this.pollTask();
            if (runnable2 == null) {
                return false;
            }
            long l3 = ScheduledFutureTask.nanoTime() + l;
            long l4 = 0L;
            do {
                try {
                    runnable2.run();
                }
                catch (Throwable throwable) {
                    logger.warn("A task raised an exception.", throwable);
                }
                if ((++l4 & 0x3FL) == 0L && (l2 = ScheduledFutureTask.nanoTime()) >= l3) break block4;
            } while ((runnable2 = this.pollTask()) != null);
            l2 = ScheduledFutureTask.nanoTime();
        }
        this.lastExecutionTime = l2;
        return true;
    }

    protected long delayNanos(long l) {
        ScheduledFutureTask<?> scheduledFutureTask = this.delayedTaskQueue.peek();
        if (scheduledFutureTask == null) {
            return SCHEDULE_PURGE_INTERVAL;
        }
        return scheduledFutureTask.delayNanos(l);
    }

    protected void updateLastExecutionTime() {
        this.lastExecutionTime = ScheduledFutureTask.nanoTime();
    }

    protected abstract void run();

    protected void cleanup() {
    }

    protected void wakeup(boolean bl) {
        if (!bl || STATE_UPDATER.get(this) == 3) {
            this.taskQueue.add(WAKEUP_TASK);
        }
    }

    @Override
    public boolean inEventLoop(Thread thread2) {
        return thread2 == this.thread;
    }

    public void addShutdownHook(final Runnable runnable2) {
        if (this.inEventLoop()) {
            this.shutdownHooks.add(runnable2);
        } else {
            this.execute(new Runnable(){

                @Override
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.add(runnable2);
                }
            });
        }
    }

    public void removeShutdownHook(final Runnable runnable2) {
        if (this.inEventLoop()) {
            this.shutdownHooks.remove(runnable2);
        } else {
            this.execute(new Runnable(){

                @Override
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.remove(runnable2);
                }
            });
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean runShutdownHooks() {
        boolean bl = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList<Runnable> arrayList = new ArrayList<Runnable>(this.shutdownHooks);
            this.shutdownHooks.clear();
            for (Runnable runnable2 : arrayList) {
                try {
                    runnable2.run();
                }
                catch (Throwable throwable) {
                    logger.warn("Shutdown hook raised an exception.", throwable);
                }
                finally {
                    bl = true;
                }
            }
        }
        if (bl) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        return bl;
    }

    @Override
    public Future<?> shutdownGracefully(long l, long l2, TimeUnit timeUnit) {
        boolean bl;
        int n;
        int n2;
        if (l < 0L) {
            throw new IllegalArgumentException("quietPeriod: " + l + " (expected >= 0)");
        }
        if (l2 < l) {
            throw new IllegalArgumentException("timeout: " + l2 + " (expected >= quietPeriod (" + l + "))");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (this.isShuttingDown()) {
            return this.terminationFuture();
        }
        boolean bl2 = this.inEventLoop();
        do {
            if (this.isShuttingDown()) {
                return this.terminationFuture();
            }
            bl = true;
            n2 = STATE_UPDATER.get(this);
            if (bl2) {
                n = 3;
                continue;
            }
            switch (n2) {
                case 1: 
                case 2: {
                    n = 3;
                    break;
                }
                default: {
                    n = n2;
                    bl = false;
                }
            }
        } while (!STATE_UPDATER.compareAndSet(this, n2, n));
        this.gracefulShutdownQuietPeriod = timeUnit.toNanos(l);
        this.gracefulShutdownTimeout = timeUnit.toNanos(l2);
        if (n2 == 1) {
            this.thread.start();
        }
        if (bl) {
            this.wakeup(bl2);
        }
        return this.terminationFuture();
    }

    @Override
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override
    @Deprecated
    public void shutdown() {
        boolean bl;
        int n;
        int n2;
        if (this.isShutdown()) {
            return;
        }
        boolean bl2 = this.inEventLoop();
        do {
            if (this.isShuttingDown()) {
                return;
            }
            bl = true;
            n2 = STATE_UPDATER.get(this);
            if (bl2) {
                n = 4;
                continue;
            }
            switch (n2) {
                case 1: 
                case 2: 
                case 3: {
                    n = 4;
                    break;
                }
                default: {
                    n = n2;
                    bl = false;
                }
            }
        } while (!STATE_UPDATER.compareAndSet(this, n2, n));
        if (n2 == 1) {
            this.thread.start();
        }
        if (bl) {
            this.wakeup(bl2);
        }
    }

    @Override
    public boolean isShuttingDown() {
        return STATE_UPDATER.get(this) >= 3;
    }

    @Override
    public boolean isShutdown() {
        return STATE_UPDATER.get(this) >= 4;
    }

    @Override
    public boolean isTerminated() {
        return STATE_UPDATER.get(this) == 5;
    }

    protected boolean confirmShutdown() {
        if (!this.isShuttingDown()) {
            return false;
        }
        if (!this.inEventLoop()) {
            throw new IllegalStateException("must be invoked from an event loop");
        }
        this.cancelDelayedTasks();
        if (this.gracefulShutdownStartTime == 0L) {
            this.gracefulShutdownStartTime = ScheduledFutureTask.nanoTime();
        }
        if (this.runAllTasks() || this.runShutdownHooks()) {
            if (this.isShutdown()) {
                return true;
            }
            this.wakeup(true);
            return false;
        }
        long l = ScheduledFutureTask.nanoTime();
        if (this.isShutdown() || l - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout) {
            return true;
        }
        if (l - this.lastExecutionTime <= this.gracefulShutdownQuietPeriod) {
            this.wakeup(true);
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            return false;
        }
        return true;
    }

    private void cancelDelayedTasks() {
        ScheduledFutureTask[] scheduledFutureTaskArray;
        if (this.delayedTaskQueue.isEmpty()) {
            return;
        }
        for (ScheduledFutureTask scheduledFutureTask : scheduledFutureTaskArray = this.delayedTaskQueue.toArray(new ScheduledFutureTask[this.delayedTaskQueue.size()])) {
            scheduledFutureTask.cancel(false);
        }
        this.delayedTaskQueue.clear();
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (this.inEventLoop()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        if (this.threadLock.tryAcquire(l, timeUnit)) {
            this.threadLock.release();
        }
        return this.isTerminated();
    }

    @Override
    public void execute(Runnable runnable2) {
        if (runnable2 == null) {
            throw new NullPointerException("task");
        }
        boolean bl = this.inEventLoop();
        if (bl) {
            this.addTask(runnable2);
        } else {
            this.startThread();
            this.addTask(runnable2);
            if (this.isShutdown() && this.removeTask(runnable2)) {
                SingleThreadEventExecutor.reject();
            }
        }
        if (!this.addTaskWakesUp && this.wakesUpForTask(runnable2)) {
            this.wakeup(bl);
        }
    }

    protected boolean wakesUpForTask(Runnable runnable2) {
        return true;
    }

    protected static void reject() {
        throw new RejectedExecutionException("event executor terminated");
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
                    SingleThreadEventExecutor.this.delayedTaskQueue.add(scheduledFutureTask);
                }
            });
        }
        return scheduledFutureTask;
    }

    private void startThread() {
        if (STATE_UPDATER.get(this) == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            this.delayedTaskQueue.add(new ScheduledFutureTask<Object>((EventExecutor)this, this.delayedTaskQueue, Executors.callable(new PurgeTask(), null), ScheduledFutureTask.deadlineNanos(SCHEDULE_PURGE_INTERVAL), -SCHEDULE_PURGE_INTERVAL));
            this.thread.start();
        }
    }

    static {
        AtomicIntegerFieldUpdater<Object> atomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(SingleThreadEventExecutor.class, "state");
        if (atomicIntegerFieldUpdater == null) {
            atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
        }
        STATE_UPDATER = atomicIntegerFieldUpdater;
        SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1L);
    }

    private final class PurgeTask
    implements Runnable {
        private PurgeTask() {
        }

        @Override
        public void run() {
            Iterator iterator2 = SingleThreadEventExecutor.this.delayedTaskQueue.iterator();
            while (iterator2.hasNext()) {
                ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask)iterator2.next();
                if (!scheduledFutureTask.isCancelled()) continue;
                iterator2.remove();
            }
        }
    }
}

