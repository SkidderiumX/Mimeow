package com.google.common.util.concurrent;

import com.google.common.collect.*;
import java.lang.reflect.*;
import com.google.common.base.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.util.concurrent.*;
import com.google.common.annotations.*;

public class MoreExecutors
{
    private MoreExecutors() {
    }
    
    @Beta
    public static ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor, final long n, final TimeUnit timeUnit) {
        return new Application().getExitingExecutorService(threadPoolExecutor, n, timeUnit);
    }
    
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, final long n, final TimeUnit timeUnit) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, n, timeUnit);
    }
    
    @Beta
    public static void addDelayedShutdownHook(final ExecutorService executorService, final long n, final TimeUnit timeUnit) {
        new Application().addDelayedShutdownHook(executorService, n, timeUnit);
    }
    
    @Beta
    public static ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor) {
        return new Application().getExitingExecutorService(threadPoolExecutor);
    }
    
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }
    
    private static void useDaemonThreadFactory(final ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }
    
    public static ListeningExecutorService sameThreadExecutor() {
        return new SameThreadExecutorService();
    }
    
    public static ListeningExecutorService listeningDecorator(final ExecutorService executorService) {
        return (executorService instanceof ListeningExecutorService) ? ((ListeningExecutorService)executorService) : ((executorService instanceof ScheduledExecutorService) ? new ScheduledListeningDecorator((ScheduledExecutorService)executorService) : new ListeningDecorator(executorService));
    }
    
    public static ListeningScheduledExecutorService listeningDecorator(final ScheduledExecutorService scheduledExecutorService) {
        return (scheduledExecutorService instanceof ListeningScheduledExecutorService) ? ((ListeningScheduledExecutorService)scheduledExecutorService) : new ScheduledListeningDecorator(scheduledExecutorService);
    }
    
    static <T> T invokeAnyImpl(final ListeningExecutorService listeningExecutorService, final Collection<? extends Callable<T>> collection, final boolean b, long n) throws InterruptedException, ExecutionException, TimeoutException {
        Preconditions.checkNotNull(listeningExecutorService);
        int size = collection.size();
        Preconditions.checkArgument(size > 0);
        final ArrayList<Object> arrayListWithCapacity = Lists.newArrayListWithCapacity(size);
        final LinkedBlockingQueue<Object> linkedBlockingQueue = Queues.newLinkedBlockingQueue();
        try {
            Object o = null;
            long n2 = b ? System.nanoTime() : 0L;
            final Iterator iterator = collection.iterator();
            arrayListWithCapacity.add(submitAndAddQueueListener(listeningExecutorService, (Callable<Object>)iterator.next(), (BlockingQueue<Future<Object>>)linkedBlockingQueue));
            --size;
            int n3 = 1;
            while (true) {
                Future future = linkedBlockingQueue.poll();
                if (future == null) {
                    if (size > 0) {
                        --size;
                        arrayListWithCapacity.add(submitAndAddQueueListener(listeningExecutorService, (Callable<Object>)iterator.next(), (BlockingQueue<Future<Object>>)linkedBlockingQueue));
                        ++n3;
                    }
                    else {
                        if (n3 == 0) {
                            if (o == null) {
                                o = new ExecutionException((Throwable)null);
                            }
                            throw o;
                        }
                        if (b) {
                            future = linkedBlockingQueue.poll(n, TimeUnit.NANOSECONDS);
                            if (future == null) {
                                throw new TimeoutException();
                            }
                            final long nanoTime = System.nanoTime();
                            n -= nanoTime - n2;
                            n2 = nanoTime;
                        }
                        else {
                            future = linkedBlockingQueue.take();
                        }
                    }
                }
                if (future != null) {
                    --n3;
                    try {
                        return (T)future.get();
                    }
                    catch (final ExecutionException ex) {
                        o = ex;
                    }
                    catch (final RuntimeException cause) {
                        o = new ExecutionException(cause);
                    }
                }
            }
        }
        finally {
            final Iterator<Future> iterator2 = arrayListWithCapacity.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().cancel(true);
            }
        }
    }
    
    private static <T> ListenableFuture<T> submitAndAddQueueListener(final ListeningExecutorService listeningExecutorService, final Callable<T> callable, final BlockingQueue<Future<T>> blockingQueue) {
        final ListenableFuture<T> submit = listeningExecutorService.submit(callable);
        submit.addListener(new Runnable() {
            @Override
            public void run() {
                blockingQueue.add(submit);
            }
        }, sameThreadExecutor());
        return submit;
    }
    
    @Beta
    public static ThreadFactory platformThreadFactory() {
        if (!isAppEngine()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
        }
        catch (final IllegalAccessException cause) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", cause);
        }
        catch (final ClassNotFoundException cause2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", cause2);
        }
        catch (final NoSuchMethodException cause3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", cause3);
        }
        catch (final InvocationTargetException ex) {
            throw Throwables.propagate(ex.getCause());
        }
    }
    
    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", (Class<?>[])new Class[0]).invoke(null, new Object[0]) != null;
        }
        catch (final ClassNotFoundException ex) {
            return false;
        }
        catch (final InvocationTargetException ex2) {
            return false;
        }
        catch (final IllegalAccessException ex3) {
            return false;
        }
        catch (final NoSuchMethodException ex4) {
            return false;
        }
    }
    
    static Thread newThread(final String name, final Runnable runnable) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(runnable);
        final Thread thread = platformThreadFactory().newThread(runnable);
        try {
            thread.setName(name);
        }
        catch (final SecurityException ex) {}
        return thread;
    }
    
    static Executor renamingDecorator(final Executor executor, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executor;
        }
        return new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                executor.execute(Callables.threadRenaming(runnable, supplier));
            }
        };
    }
    
    static ExecutorService renamingDecorator(final ExecutorService executorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executorService;
        }
        return new WrappingExecutorService(executorService) {
            @Override
            protected <T> Callable<T> wrapTask(final Callable<T> callable) {
                return Callables.threadRenaming(callable, supplier);
            }
            
            @Override
            protected Runnable wrapTask(final Runnable runnable) {
                return Callables.threadRenaming(runnable, supplier);
            }
        };
    }
    
    static ScheduledExecutorService renamingDecorator(final ScheduledExecutorService scheduledExecutorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return scheduledExecutorService;
        }
        return new WrappingScheduledExecutorService(scheduledExecutorService) {
            @Override
            protected <T> Callable<T> wrapTask(final Callable<T> callable) {
                return Callables.threadRenaming(callable, supplier);
            }
            
            @Override
            protected Runnable wrapTask(final Runnable runnable) {
                return Callables.threadRenaming(runnable, supplier);
            }
        };
    }
    
    @Beta
    public static boolean shutdownAndAwaitTermination(final ExecutorService executorService, final long sourceDuration, final TimeUnit sourceUnit) {
        Preconditions.checkNotNull(sourceUnit);
        executorService.shutdown();
        try {
            final long n = TimeUnit.NANOSECONDS.convert(sourceDuration, sourceUnit) / 2L;
            if (!executorService.awaitTermination(n, TimeUnit.NANOSECONDS)) {
                executorService.shutdownNow();
                executorService.awaitTermination(n, TimeUnit.NANOSECONDS);
            }
        }
        catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }
    
    private static class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService
    {
        final ScheduledExecutorService delegate;
        
        ScheduledListeningDecorator(final ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.delegate = Preconditions.checkNotNull(scheduledExecutorService);
        }
        
        @Override
        public ListenableScheduledFuture<?> schedule(final Runnable runnable, final long n, final TimeUnit timeUnit) {
            final ListenableFutureTask<Object> create = ListenableFutureTask.create(runnable, (Object)null);
            return new ListenableScheduledTask<Object>(create, this.delegate.schedule(create, n, timeUnit));
        }
        
        @Override
        public <V> ListenableScheduledFuture<V> schedule(final Callable<V> callable, final long n, final TimeUnit timeUnit) {
            final ListenableFutureTask<V> create = ListenableFutureTask.create(callable);
            return new ListenableScheduledTask<V>((ListenableFuture<Object>)create, this.delegate.schedule(create, n, timeUnit));
        }
        
        @Override
        public ListenableScheduledFuture<?> scheduleAtFixedRate(final Runnable runnable, final long n, final long n2, final TimeUnit timeUnit) {
            final NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask<Object>((ListenableFuture<Object>)neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, n, n2, timeUnit));
        }
        
        @Override
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(final Runnable runnable, final long n, final long n2, final TimeUnit timeUnit) {
            final NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask<Object>((ListenableFuture<Object>)neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, n, n2, timeUnit));
        }
        
        private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable
        {
            private final Runnable delegate;
            
            public NeverSuccessfulListenableFutureTask(final Runnable runnable) {
                this.delegate = Preconditions.checkNotNull(runnable);
            }
            
            @Override
            public void run() {
                try {
                    this.delegate.run();
                }
                catch (final Throwable exception) {
                    this.setException(exception);
                    throw Throwables.propagate(exception);
                }
            }
        }
        
        private static final class ListenableScheduledTask<V> extends SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V>
        {
            private final ScheduledFuture<?> scheduledDelegate;
            
            public ListenableScheduledTask(final ListenableFuture<V> listenableFuture, final ScheduledFuture<?> scheduledDelegate) {
                super(listenableFuture);
                this.scheduledDelegate = scheduledDelegate;
            }
            
            @Override
            public boolean cancel(final boolean b) {
                final boolean cancel = super.cancel(b);
                if (cancel) {
                    this.scheduledDelegate.cancel(b);
                }
                return cancel;
            }
            
            @Override
            public long getDelay(final TimeUnit timeUnit) {
                return this.scheduledDelegate.getDelay(timeUnit);
            }
            
            @Override
            public int compareTo(final Delayed delayed) {
                return this.scheduledDelegate.compareTo(delayed);
            }
        }
    }
    
    private static class ListeningDecorator extends AbstractListeningExecutorService
    {
        private final ExecutorService delegate;
        
        ListeningDecorator(final ExecutorService executorService) {
            this.delegate = Preconditions.checkNotNull(executorService);
        }
        
        @Override
        public boolean awaitTermination(final long n, final TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(n, timeUnit);
        }
        
        @Override
        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }
        
        @Override
        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }
        
        @Override
        public void shutdown() {
            this.delegate.shutdown();
        }
        
        @Override
        public List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }
        
        @Override
        public void execute(final Runnable runnable) {
            this.delegate.execute(runnable);
        }
    }
    
    private static class SameThreadExecutorService extends AbstractListeningExecutorService
    {
        private final Lock lock;
        private final Condition termination;
        private int runningTasks;
        private boolean shutdown;
        
        private SameThreadExecutorService() {
            this.lock = new ReentrantLock();
            this.termination = this.lock.newCondition();
            this.runningTasks = 0;
            this.shutdown = false;
        }
        
        @Override
        public void execute(final Runnable runnable) {
            this.startTask();
            try {
                runnable.run();
            }
            finally {
                this.endTask();
            }
        }
        
        @Override
        public boolean isShutdown() {
            this.lock.lock();
            try {
                return this.shutdown;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Override
        public void shutdown() {
            this.lock.lock();
            try {
                this.shutdown = true;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Override
        public List<Runnable> shutdownNow() {
            this.shutdown();
            return Collections.emptyList();
        }
        
        @Override
        public boolean isTerminated() {
            this.lock.lock();
            try {
                return this.shutdown && this.runningTasks == 0;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Override
        public boolean awaitTermination(final long duration, final TimeUnit timeUnit) throws InterruptedException {
            long n = timeUnit.toNanos(duration);
            this.lock.lock();
            try {
                while (!this.isTerminated()) {
                    if (n <= 0L) {
                        return false;
                    }
                    n = this.termination.awaitNanos(n);
                }
                return true;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        private void startTask() {
            this.lock.lock();
            try {
                if (this.isShutdown()) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                ++this.runningTasks;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        private void endTask() {
            this.lock.lock();
            try {
                --this.runningTasks;
                if (this.isTerminated()) {
                    this.termination.signalAll();
                }
            }
            finally {
                this.lock.unlock();
            }
        }
    }
    
    @VisibleForTesting
    static class Application
    {
        final ExecutorService getExitingExecutorService(final ThreadPoolExecutor executor, final long n, final TimeUnit timeUnit) {
            useDaemonThreadFactory(executor);
            final ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(executor);
            this.addDelayedShutdownHook(unconfigurableExecutorService, n, timeUnit);
            return unconfigurableExecutorService;
        }
        
        final ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor executor, final long n, final TimeUnit timeUnit) {
            useDaemonThreadFactory(executor);
            final ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(executor);
            this.addDelayedShutdownHook(unconfigurableScheduledExecutorService, n, timeUnit);
            return unconfigurableScheduledExecutorService;
        }
        
        final void addDelayedShutdownHook(final ExecutorService obj, final long n, final TimeUnit timeUnit) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(timeUnit);
            this.addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + obj, new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.shutdown();
                        obj.awaitTermination(n, timeUnit);
                    }
                    catch (final InterruptedException ex) {}
                }
            }));
        }
        
        final ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor) {
            return this.getExitingExecutorService(threadPoolExecutor, 120L, TimeUnit.SECONDS);
        }
        
        final ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return this.getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
        }
        
        @VisibleForTesting
        void addShutdownHook(final Thread hook) {
            Runtime.getRuntime().addShutdownHook(hook);
        }
    }
}
