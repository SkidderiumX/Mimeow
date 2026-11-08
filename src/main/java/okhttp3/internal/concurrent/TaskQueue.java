package okhttp3.internal.concurrent;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.util.logging.*;
import kotlin.*;
import kotlin.jvm.functions.*;
import java.util.concurrent.*;
import java.util.*;
import okhttp3.internal.*;

@Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b$J8\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*H\u0086\b\u00f8\u0001\u0000J\u0006\u0010+\u001a\u00020,J.\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*H\u0086\b\u00f8\u0001\u0000J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064" }, d2 = { "Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$okhttp", "()Z", "setCancelActiveTask$okhttp", "(Z)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "getName$okhttp", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$okhttp", "setShutdown$okhttp", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp" })
@SourceDebugExtension({ "SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TaskLogger.kt\nokhttp3/internal/concurrent/TaskLoggerKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Util.kt\nokhttp3/internal/Util\n*L\n1#1,218:1\n1#2:219\n25#3,4:220\n25#3,4:224\n25#3,4:228\n25#3,4:232\n25#3,4:251\n350#4,7:236\n615#5,4:243\n615#5,4:247\n*S KotlinDebug\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n*L\n65#1:220,4\n68#1:224,4\n153#1:228,4\n159#1:232,4\n208#1:251,4\n165#1:236,7\n179#1:243,4\n189#1:247,4\n*E\n" })
public class TaskQueue
{
    @NotNull
    private final TaskRunner taskRunner;
    @NotNull
    private final String name;
    private boolean shutdown;
    @Nullable
    private Task activeTask;
    @NotNull
    private final List<Task> futureTasks;
    private boolean cancelActiveTask;
    
    public TaskQueue(@NotNull final TaskRunner taskRunner, @NotNull final String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList<Task>();
    }
    
    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }
    
    @NotNull
    public final String getName$okhttp() {
        return this.name;
    }
    
    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }
    
    public final void setShutdown$okhttp(final boolean shutdown) {
        this.shutdown = shutdown;
    }
    
    @Nullable
    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }
    
    public final void setActiveTask$okhttp(@Nullable final Task activeTask) {
        this.activeTask = activeTask;
    }
    
    @NotNull
    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }
    
    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }
    
    public final void setCancelActiveTask$okhttp(final boolean cancelActiveTask) {
        this.cancelActiveTask = cancelActiveTask;
    }
    
    @NotNull
    public final List<Task> getScheduledTasks() {
        final TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            return kotlin.collections.CollectionsKt.toList((Iterable)this.futureTasks);
        }
    }
    
    public final void schedule(@NotNull final Task task, final long n) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.taskRunner) {
            if (this.shutdown) {
                if (task.getCancelable()) {
                    if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                        TaskLoggerKt.access$log(task, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                }
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
            else {
                if (this.scheduleAndDecide$okhttp(task, n, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                final Unit instance = Unit.INSTANCE;
            }
        }
    }
    
    public final void schedule(@NotNull final String s, final long n, @NotNull final Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        this.schedule((Task)new TaskQueue$schedule.TaskQueue$schedule$2(s, (Function0)function0), n);
    }
    
    public final void execute(@NotNull final String s, final long n, final boolean b, @NotNull final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        this.schedule((Task)new TaskQueue$execute.TaskQueue$execute$1(s, b, (Function0)function0), n);
    }
    
    @NotNull
    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            final Task activeTask = this.activeTask;
            if (activeTask instanceof AwaitIdleTask) {
                return ((AwaitIdleTask)activeTask).getLatch();
            }
            for (final Task task : this.futureTasks) {
                if (task instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask)task).getLatch();
                }
            }
            final AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (this.scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }
    
    public final boolean scheduleAndDecide$okhttp(@NotNull final Task task, final long n, final boolean b) {
        Intrinsics.checkNotNullParameter(task, "task");
        task.initQueue$okhttp(this);
        final long nanoTime = this.taskRunner.getBackend().nanoTime();
        final long nextExecuteNanoTime$okhttp = nanoTime + n;
        final int index = this.futureTasks.indexOf(task);
        if (index != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= nextExecuteNanoTime$okhttp) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(index);
        }
        task.setNextExecuteNanoTime$okhttp(nextExecuteNanoTime$okhttp);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            TaskLoggerKt.access$log(task, this, b ? ("run again after " + TaskLoggerKt.formatDuration(nextExecuteNanoTime$okhttp - nanoTime)) : ("scheduled after " + TaskLoggerKt.formatDuration(nextExecuteNanoTime$okhttp - nanoTime)));
        }
        final List<Task> futureTasks = this.futureTasks;
        int n2 = 0;
        final Iterator<Task> iterator = futureTasks.iterator();
        while (true) {
            while (iterator.hasNext()) {
                if (iterator.next().getNextExecuteNanoTime$okhttp() - nanoTime > n) {
                    final int n3 = n2;
                    int size = n3;
                    if (size == -1) {
                        size = this.futureTasks.size();
                    }
                    this.futureTasks.add(size, task);
                    return size == 0;
                }
                ++n2;
            }
            final int n3 = -1;
            continue;
        }
    }
    
    public final void cancelAll() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this));
        }
        synchronized (this.taskRunner) {
            if (this.cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    public final void shutdown() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this));
        }
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (this.cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    public final boolean cancelAllAndDecide$okhttp() {
        if (this.activeTask != null) {
            final Task activeTask = this.activeTask;
            Intrinsics.checkNotNull(activeTask);
            if (activeTask.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean b = false;
        for (int n = this.futureTasks.size() - 1; -1 < n; --n) {
            if (this.futureTasks.get(n).getCancelable()) {
                final Task task = this.futureTasks.get(n);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "canceled");
                }
                b = true;
                this.futureTasks.remove(n);
            }
        }
        return b;
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.name;
    }
    
    @Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp" })
    private static final class AwaitIdleTask extends Task
    {
        @NotNull
        private final CountDownLatch latch;
        
        public AwaitIdleTask() {
            super(Util.okHttpName + " awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }
        
        @NotNull
        public final CountDownLatch getLatch() {
            return this.latch;
        }
        
        @Override
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }
}
