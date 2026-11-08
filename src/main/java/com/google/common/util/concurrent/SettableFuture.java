/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import javax.annotation.Nullable;

public class SettableFuture<V>
extends AbstractFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture<V>();
    }

    private SettableFuture() {
    }

    @Override
    public boolean set(@Nullable V v) {
        return super.set(v);
    }

    @Override
    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }
}

