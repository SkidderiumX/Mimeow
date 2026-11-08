/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class ExecutionList {
    @VisibleForTesting
    static final Logger log = Logger.getLogger(ExecutionList.class.getName());
    @GuardedBy(value="this")
    private RunnableExecutorPair runnables;
    @GuardedBy(value="this")
    private boolean executed;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(Runnable runnable2, Executor executor) {
        Preconditions.checkNotNull(runnable2, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        ExecutionList executionList = this;
        synchronized (executionList) {
            if (!this.executed) {
                this.runnables = new RunnableExecutorPair(runnable2, executor, this.runnables);
                return;
            }
        }
        ExecutionList.executeListener(runnable2, executor);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void execute() {
        RunnableExecutorPair runnableExecutorPair;
        Object object = this;
        synchronized (object) {
            if (this.executed) {
                return;
            }
            this.executed = true;
            runnableExecutorPair = this.runnables;
            this.runnables = null;
        }
        object = null;
        while (runnableExecutorPair != null) {
            RunnableExecutorPair runnableExecutorPair2 = runnableExecutorPair;
            runnableExecutorPair = runnableExecutorPair.next;
            runnableExecutorPair2.next = object;
            object = runnableExecutorPair2;
        }
        while (object != null) {
            ExecutionList.executeListener(((RunnableExecutorPair)object).runnable, ((RunnableExecutorPair)object).executor);
            object = ((RunnableExecutorPair)object).next;
        }
    }

    private static void executeListener(Runnable runnable2, Executor executor) {
        try {
            executor.execute(runnable2);
        }
        catch (RuntimeException runtimeException) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable2 + " with executor " + executor, runtimeException);
        }
    }

    private static final class RunnableExecutorPair {
        final Runnable runnable;
        final Executor executor;
        @Nullable
        RunnableExecutorPair next;

        RunnableExecutorPair(Runnable runnable2, Executor executor, RunnableExecutorPair runnableExecutorPair) {
            this.runnable = runnable2;
            this.executor = executor;
            this.next = runnableExecutorPair;
        }
    }
}

