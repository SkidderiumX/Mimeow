/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public abstract class ForwardingCheckedFuture<V, X extends Exception>
extends ForwardingListenableFuture<V>
implements CheckedFuture<V, X> {
    @Override
    public V checkedGet() throws X {
        return this.delegate().checkedGet();
    }

    @Override
    public V checkedGet(long l, TimeUnit timeUnit) throws TimeoutException, X {
        return this.delegate().checkedGet(l, timeUnit);
    }

    @Override
    protected abstract CheckedFuture<V, X> delegate();

    @Beta
    public static abstract class SimpleForwardingCheckedFuture<V, X extends Exception>
    extends ForwardingCheckedFuture<V, X> {
        private final CheckedFuture<V, X> delegate;

        protected SimpleForwardingCheckedFuture(CheckedFuture<V, X> checkedFuture) {
            this.delegate = Preconditions.checkNotNull(checkedFuture);
        }

        @Override
        protected final CheckedFuture<V, X> delegate() {
            return this.delegate;
        }
    }
}

