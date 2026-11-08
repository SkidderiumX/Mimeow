/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public abstract class ForwardingListenableFuture<V>
extends ForwardingFuture<V>
implements ListenableFuture<V> {
    protected ForwardingListenableFuture() {
    }

    @Override
    protected abstract ListenableFuture<V> delegate();

    @Override
    public void addListener(Runnable runnable2, Executor executor) {
        this.delegate().addListener(runnable2, executor);
    }

    public static abstract class SimpleForwardingListenableFuture<V>
    extends ForwardingListenableFuture<V> {
        private final ListenableFuture<V> delegate;

        protected SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = Preconditions.checkNotNull(listenableFuture);
        }

        @Override
        protected final ListenableFuture<V> delegate() {
            return this.delegate;
        }
    }
}

