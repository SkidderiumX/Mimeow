/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

public class AsyncSettableFuture<V>
extends ForwardingListenableFuture<V> {
    private final NestedFuture<V> nested = new NestedFuture();
    private final ListenableFuture<V> dereferenced = Futures.dereference(this.nested);

    public static <V> AsyncSettableFuture<V> create() {
        return new AsyncSettableFuture<V>();
    }

    private AsyncSettableFuture() {
    }

    @Override
    protected ListenableFuture<V> delegate() {
        return this.dereferenced;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return this.nested.setFuture(Preconditions.checkNotNull(listenableFuture));
    }

    public boolean setValue(@Nullable V v) {
        return this.setFuture(Futures.immediateFuture(v));
    }

    public boolean setException(Throwable throwable) {
        return this.setFuture(Futures.immediateFailedFuture(throwable));
    }

    public boolean isSet() {
        return this.nested.isDone();
    }

    private static final class NestedFuture<V>
    extends AbstractFuture<ListenableFuture<? extends V>> {
        private NestedFuture() {
        }

        boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
            boolean bl = this.set(listenableFuture);
            if (this.isCancelled()) {
                listenableFuture.cancel(this.wasInterrupted());
            }
            return bl;
        }
    }
}

