package okhttp3.internal.concurrent;

import kotlin.jvm.*;
import java.util.logging.*;
import okhttp3.internal.*;
import kotlin.*;
import java.util.*;
import org.jetbrains.annotations.*;
import kotlin.collections.*;
import kotlin.jvm.internal.*;
import java.util.concurrent.*;

@Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%" }, d2 = { "Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp" })
@SourceDebugExtension({ "SMAP\nTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner\n+ 2 Util.kt\nokhttp3/internal/Util\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n608#2,4:315\n608#2,4:319\n615#2,4:323\n608#2,4:327\n608#2,4:331\n1#3:335\n*S KotlinDebug\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner\n*L\n79#1:315,4\n97#1:319,4\n108#1:323,4\n126#1:327,4\n152#1:331,4\n*E\n" })
public class TaskRunner
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Backend backend;
    private int nextQueueName;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    @NotNull
    private final List<TaskQueue> busyQueues;
    @NotNull
    private final List<TaskQueue> readyQueues;
    @NotNull
    private final Runnable runnable;
    @JvmField
    @NotNull
    public static final TaskRunner INSTANCE;
    @NotNull
    private static final Logger logger;
    
    public TaskRunner(@NotNull final Backend backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.backend = backend;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList<TaskQueue>();
        this.readyQueues = new ArrayList<TaskQueue>();
        this.runnable = (Runnable)new TaskRunner$runnable.TaskRunner$runnable$1(this);
    }
    
    @NotNull
    public final Backend getBackend() {
        return this.backend;
    }
    
    public final void kickCoordinator$okhttp(@NotNull final TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this));
        }
        if (taskQueue.getActiveTask$okhttp() == null) {
            if (!taskQueue.getFutureTasks$okhttp().isEmpty()) {
                Util.addIfAbsent(this.readyQueues, taskQueue);
            }
            else {
                this.readyQueues.remove(taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.coordinatorNotify(this);
        }
        else {
            this.backend.execute(this.runnable);
        }
    }
    
    private final void beforeRun(final Task activeTask$okhttp) {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this));
        }
        activeTask$okhttp.setNextExecuteNanoTime$okhttp(-1L);
        final TaskQueue queue$okhttp = activeTask$okhttp.getQueue$okhttp();
        Intrinsics.checkNotNull(queue$okhttp);
        final TaskQueue taskQueue = queue$okhttp;
        taskQueue.getFutureTasks$okhttp().remove(activeTask$okhttp);
        this.readyQueues.remove(taskQueue);
        taskQueue.setActiveTask$okhttp(activeTask$okhttp);
        this.busyQueues.add(taskQueue);
    }
    
    private final void runTask(final Task task) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this));
        }
        final Thread currentThread = Thread.currentThread();
        final String name = currentThread.getName();
        currentThread.setName(task.getName());
        long runOnce = -1L;
        try {
            runOnce = task.runOnce();
        }
        finally {
            synchronized (this) {
                this.afterRun(task, runOnce);
                final Unit instance = Unit.INSTANCE;
            }
            currentThread.setName(name);
        }
    }
    
    private final void afterRun(final Task task, final long n) {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this));
        }
        final TaskQueue queue$okhttp = task.getQueue$okhttp();
        Intrinsics.checkNotNull(queue$okhttp);
        final TaskQueue taskQueue = queue$okhttp;
        if (taskQueue.getActiveTask$okhttp() != task) {
            throw new IllegalStateException("Check failed.".toString());
        }
        final boolean cancelActiveTask$okhttp = taskQueue.getCancelActiveTask$okhttp();
        taskQueue.setCancelActiveTask$okhttp(false);
        taskQueue.setActiveTask$okhttp(null);
        this.busyQueues.remove(taskQueue);
        if (n != -1L && !cancelActiveTask$okhttp && !taskQueue.getShutdown$okhttp()) {
            taskQueue.scheduleAndDecide$okhttp(task, n, true);
        }
        if (!taskQueue.getFutureTasks$okhttp().isEmpty()) {
            this.readyQueues.add(taskQueue);
        }
    }
    
    @Nullable
    public final Task awaitTaskToRun() {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this));
        }
        while (!this.readyQueues.isEmpty()) {
            final long nanoTime = this.backend.nanoTime();
            long min = Long.MAX_VALUE;
            Task task = null;
            boolean b = false;
            final Iterator<TaskQueue> iterator = this.readyQueues.iterator();
            while (iterator.hasNext()) {
                final Task task2 = iterator.next().getFutureTasks$okhttp().get(0);
                final long max = Math.max(0L, task2.getNextExecuteNanoTime$okhttp() - nanoTime);
                if (max > 0L) {
                    min = Math.min(max, min);
                }
                else {
                    if (task != null) {
                        b = true;
                        break;
                    }
                    task = task2;
                }
            }
            if (task != null) {
                this.beforeRun(task);
                if (b || (!this.coordinatorWaiting && !this.readyQueues.isEmpty())) {
                    this.backend.execute(this.runnable);
                }
                return task;
            }
            if (this.coordinatorWaiting) {
                if (min < this.coordinatorWakeUpAt - nanoTime) {
                    this.backend.coordinatorNotify(this);
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = nanoTime + min;
            try {
                this.backend.coordinatorWait(this, min);
            }
            catch (final InterruptedException ex) {
                this.cancelAll();
            }
            finally {
                this.coordinatorWaiting = false;
            }
        }
        return null;
    }
    
    @NotNull
    public final TaskQueue newQueue() {
        final int n;
        synchronized (this) {
            n = this.nextQueueName;
            this.nextQueueName = n + 1;
        }
        return new TaskQueue(this, "Q" + n);
    }
    
    @NotNull
    public final List<TaskQueue> activeQueues() {
        synchronized (this) {
            return CollectionsKt___CollectionsKt.plus((Collection<? extends TaskQueue>)this.busyQueues, (Iterable<? extends TaskQueue>)this.readyQueues);
        }
    }
    
    public final void cancelAll() {
        for (int n = this.busyQueues.size() - 1; -1 < n; --n) {
            this.busyQueues.get(n).cancelAllAndDecide$okhttp();
        }
        for (int n2 = this.readyQueues.size() - 1; -1 < n2; --n2) {
            final TaskQueue taskQueue = this.readyQueues.get(n2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(n2);
            }
        }
    }
    
    public static final /* synthetic */ Logger access$getLogger$cp() {
        return TaskRunner.logger;
    }
    
    static {
        Companion = new Companion(null);
        INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Util.okHttpName + " TaskRunner", true)));
        final Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(TaskRunner::class.java.name)");
        logger = logger2;
    }
    
    @Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e" }, d2 = { "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "okhttp" })
    public interface Backend
    {
        void beforeTask(@NotNull final TaskRunner p0);
        
        long nanoTime();
        
        void coordinatorNotify(@NotNull final TaskRunner p0);
        
        void coordinatorWait(@NotNull final TaskRunner p0, final long p1);
        
        void execute(@NotNull final Runnable p0);
    }
    
    @Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t" }, d2 = { "Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final Logger getLogger() {
            return TaskRunner.access$getLogger$cp();
        }
    }
    
    @Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014" }, d2 = { "Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp" })
    @SourceDebugExtension({ "SMAP\nTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$RealBackend\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,314:1\n560#2:315\n*S KotlinDebug\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$RealBackend\n*L\n281#1:315\n*E\n" })
    public static final class RealBackend implements Backend
    {
        @NotNull
        private final ThreadPoolExecutor executor;
        
        public RealBackend(@NotNull final ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), threadFactory);
        }
        
        @Override
        public void beforeTask(@NotNull final TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        }
        
        @Override
        public long nanoTime() {
            return System.nanoTime();
        }
        
        @Override
        public void coordinatorNotify(@NotNull final TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }
        
        @Override
        public void coordinatorWait(@NotNull final TaskRunner taskRunner, final long n) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            final long timeoutMillis = n / 1000000L;
            final long n2 = n - timeoutMillis * 1000000L;
            if (timeoutMillis > 0L || n > 0L) {
                taskRunner.wait(timeoutMillis, (int)n2);
            }
        }
        
        @Override
        public void execute(@NotNull final Runnable command) {
            Intrinsics.checkNotNullParameter(command, "runnable");
            this.executor.execute(command);
        }
        
        public final void shutdown() {
            this.executor.shutdown();
        }
    }
}
