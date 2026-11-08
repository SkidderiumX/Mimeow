/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class AbstractScheduledService
implements Service {
    private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService delegate = new AbstractService(){
        private volatile Future<?> runningTask;
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock = new ReentrantLock();
        private final Runnable task = new Runnable(){

            @Override
            public void run() {
                lock.lock();
                try {
                    AbstractScheduledService.this.runOneIteration();
                }
                catch (Throwable throwable) {
                    try {
                        AbstractScheduledService.this.shutDown();
                    }
                    catch (Exception exception) {
                        logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
                    }
                    this.notifyFailed(throwable);
                    throw Throwables.propagate(throwable);
                }
                finally {
                    lock.unlock();
                }
            }
        };

        @Override
        protected final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), new Supplier<String>(){

                @Override
                public String get() {
                    return AbstractScheduledService.this.serviceName() + " " + (Object)((Object)this.state());
                }
            });
            this.executorService.execute(new Runnable(){

                @Override
                public void run() {
                    lock.lock();
                    try {
                        AbstractScheduledService.this.startUp();
                        runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, executorService, task);
                        this.notifyStarted();
                    }
                    catch (Throwable throwable) {
                        this.notifyFailed(throwable);
                        throw Throwables.propagate(throwable);
                    }
                    finally {
                        lock.unlock();
                    }
                }
            });
        }

        @Override
        protected final void doStop() {
            this.runningTask.cancel(false);
            this.executorService.execute(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    try {
                        lock.lock();
                        try {
                            if (this.state() != Service.State.STOPPING) {
                                return;
                            }
                            AbstractScheduledService.this.shutDown();
                        }
                        finally {
                            lock.unlock();
                        }
                        this.notifyStopped();
                    }
                    catch (Throwable throwable) {
                        this.notifyFailed(throwable);
                        throw Throwables.propagate(throwable);
                    }
                }
            });
        }
    };

    protected AbstractScheduledService() {
    }

    protected abstract void runOneIteration() throws Exception;

    protected void startUp() throws Exception {
    }

    protected void shutDown() throws Exception {
    }

    protected abstract Scheduler scheduler();

    protected ScheduledExecutorService executor() {
        final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory(){

            @Override
            public Thread newThread(Runnable runnable2) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable2);
            }
        });
        this.addListener(new Service.Listener(){

            @Override
            public void terminated(Service.State state) {
                scheduledExecutorService.shutdown();
            }

            @Override
            public void failed(Service.State state, Throwable throwable) {
                scheduledExecutorService.shutdown();
            }
        }, MoreExecutors.sameThreadExecutor());
        return scheduledExecutorService;
    }

    protected String serviceName() {
        return this.getClass().getSimpleName();
    }

    public String toString() {
        return this.serviceName() + " [" + (Object)((Object)this.state()) + "]";
    }

    @Override
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override
    public final void awaitRunning(long l, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(l, timeUnit);
    }

    @Override
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override
    public final void awaitTerminated(long l, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(l, timeUnit);
    }

    @Beta
    public static abstract class CustomScheduler
    extends Scheduler {
        @Override
        final Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable2) {
            ReschedulableCallable reschedulableCallable = new ReschedulableCallable(abstractService, scheduledExecutorService, runnable2);
            reschedulableCallable.reschedule();
            return reschedulableCallable;
        }

        protected abstract Schedule getNextSchedule() throws Exception;

        @Beta
        protected static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public Schedule(long l, TimeUnit timeUnit) {
                this.delay = l;
                this.unit = Preconditions.checkNotNull(timeUnit);
            }
        }

        private class ReschedulableCallable
        extends ForwardingFuture<Void>
        implements Callable<Void> {
            private final Runnable wrappedRunnable;
            private final ScheduledExecutorService executor;
            private final AbstractService service;
            private final ReentrantLock lock = new ReentrantLock();
            @GuardedBy(value="lock")
            private Future<Void> currentFuture;

            ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable2) {
                this.wrappedRunnable = runnable2;
                this.executor = scheduledExecutorService;
                this.service = abstractService;
            }

            @Override
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                this.reschedule();
                return null;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void reschedule() {
                this.lock.lock();
                try {
                    if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                        Schedule schedule2 = CustomScheduler.this.getNextSchedule();
                        this.currentFuture = this.executor.schedule(this, schedule2.delay, schedule2.unit);
                    }
                }
                catch (Throwable throwable) {
                    this.service.notifyFailed(throwable);
                }
                finally {
                    this.lock.unlock();
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean cancel(boolean bl) {
                this.lock.lock();
                try {
                    boolean bl2 = this.currentFuture.cancel(bl);
                    return bl2;
                }
                finally {
                    this.lock.unlock();
                }
            }

            @Override
            protected Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel is supported by this future");
            }
        }
    }

    public static abstract class Scheduler {
        public static Scheduler newFixedDelaySchedule(final long l, final long l2, final TimeUnit timeUnit) {
            return new Scheduler(){

                @Override
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable2) {
                    return scheduledExecutorService.scheduleWithFixedDelay(runnable2, l, l2, timeUnit);
                }
            };
        }

        public static Scheduler newFixedRateSchedule(final long l, final long l2, final TimeUnit timeUnit) {
            return new Scheduler(){

                @Override
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable2) {
                    return scheduledExecutorService.scheduleAtFixedRate(runnable2, l, l2, timeUnit);
                }
            };
        }

        abstract Future<?> schedule(AbstractService var1, ScheduledExecutorService var2, Runnable var3);

        private Scheduler() {
        }
    }
}

