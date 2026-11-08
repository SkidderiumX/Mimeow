/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

public class ListenableFutureTask<V>
extends FutureTask<V>
implements ListenableFuture<V> {
    private final ExecutionList executionList = new ExecutionList();

    public static <V> ListenableFutureTask<V> create(Callable<V> callable) {
        return new ListenableFutureTask<V>(callable);
    }

    public static <V> ListenableFutureTask<V> create(Runnable runnable2, @Nullable V v) {
        return new ListenableFutureTask<V>(runnable2, v);
    }

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
    }

    ListenableFutureTask(Runnable runnable2, @Nullable V v) {
        super(runnable2, v);
    }

    @Override
    public void addListener(Runnable runnable2, Executor executor) {
        this.executionList.add(runnable2, executor);
    }

    @Override
    protected void done() {
        this.executionList.execute();
    }
}

