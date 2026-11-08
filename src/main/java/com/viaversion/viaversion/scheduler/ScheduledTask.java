/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.scheduler;

import com.viaversion.viaversion.api.scheduler.Task;
import com.viaversion.viaversion.api.scheduler.TaskStatus;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledTask
implements Task {
    private final ScheduledFuture<?> future;

    public ScheduledTask(ScheduledFuture<?> scheduledFuture) {
        this.future = scheduledFuture;
    }

    @Override
    public TaskStatus status() {
        if (this.future.getDelay(TimeUnit.MILLISECONDS) > 0L) {
            return TaskStatus.SCHEDULED;
        }
        return this.future.isDone() ? TaskStatus.STOPPED : TaskStatus.RUNNING;
    }

    @Override
    public void cancel() {
        this.future.cancel(false);
    }
}

