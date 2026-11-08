/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractListeningExecutorService
extends AbstractExecutorService
implements ListeningExecutorService {
    protected final <T> ListenableFutureTask<T> newTaskFor(Runnable runnable2, T t) {
        return ListenableFutureTask.create(runnable2, t);
    }

    protected final <T> ListenableFutureTask<T> newTaskFor(Callable<T> callable) {
        return ListenableFutureTask.create(callable);
    }

    @Override
    public ListenableFuture<?> submit(Runnable runnable2) {
        return (ListenableFuture)super.submit(runnable2);
    }

    @Override
    public <T> ListenableFuture<T> submit(Runnable runnable2, @Nullable T t) {
        return (ListenableFuture)super.submit(runnable2, t);
    }

    @Override
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return (ListenableFuture)super.submit(callable);
    }
}

