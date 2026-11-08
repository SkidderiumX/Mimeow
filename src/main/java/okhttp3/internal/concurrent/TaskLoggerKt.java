/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a5\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0012"}, d2={"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", "T", "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"})
public class TaskLoggerKt {
    public static final void taskLog(@NotNull Task task, @NotNull TaskQueue taskQueue, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(taskQueue, "queue");
        Intrinsics.checkNotNullParameter(function0, "messageBlock");
        boolean bl = false;
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            TaskLoggerKt.log(task, taskQueue, function0.invoke());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T logElapsed(@NotNull Task task, @NotNull TaskQueue taskQueue, @NotNull Function0<? extends T> function0) {
        T t;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(taskQueue, "queue");
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean bl = false;
        long l = -1L;
        boolean bl2 = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (bl2) {
            l = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            TaskLoggerKt.log(task, taskQueue, "starting");
        }
        boolean bl3 = false;
        try {
            T t2 = function0.invoke();
            bl3 = true;
            t = t2;
        }
        catch (Throwable throwable) {
            InlineMarker.finallyStart(1);
            if (bl2) {
                long l2 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - l;
                if (bl3) {
                    TaskLoggerKt.log(task, taskQueue, "finished run in " + TaskLoggerKt.formatDuration(l2));
                } else {
                    TaskLoggerKt.log(task, taskQueue, "failed a run in " + TaskLoggerKt.formatDuration(l2));
                }
            }
            InlineMarker.finallyEnd(1);
            throw throwable;
        }
        InlineMarker.finallyStart(1);
        if (bl2) {
            long l3 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - l;
            TaskLoggerKt.log(task, taskQueue, "finished run in " + TaskLoggerKt.formatDuration(l3));
        }
        InlineMarker.finallyEnd(1);
        return t;
    }

    private static final void log(Task task, TaskQueue taskQueue, String string) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder stringBuilder = new StringBuilder().append(taskQueue.getName$okhttp()).append(' ');
        String string2 = "%-22s";
        Object[] objectArray = new Object[]{string};
        String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string3, "format(format, *args)");
        logger.fine(stringBuilder.append(string3).append(": ").append(task.getName()).toString());
    }

    @NotNull
    public static final String formatDuration(long l) {
        String string = l <= -999500000L ? (l - (long)500000000) / (long)1000000000 + " s " : (l <= -999500L ? (l - (long)500000) / (long)1000000 + " ms" : (l <= 0L ? (l - (long)500) / (long)1000 + " \u00b5s" : (l < 999500L ? (l + (long)500) / (long)1000 + " \u00b5s" : (l < 999500000L ? (l + (long)500000) / (long)1000000 + " ms" : (l + (long)500000000) / (long)1000000000 + " s "))));
        String string2 = "%6s";
        Object[] objectArray = new Object[]{string};
        String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string3, "format(format, *args)");
        return string3;
    }
}

