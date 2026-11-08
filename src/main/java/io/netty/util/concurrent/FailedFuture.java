/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.CompleteFuture;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.PlatformDependent;

public class FailedFuture<V>
extends CompleteFuture<V> {
    private final Throwable cause;

    public FailedFuture(EventExecutor eventExecutor, Throwable throwable) {
        super(eventExecutor);
        if (throwable == null) {
            throw new NullPointerException("cause");
        }
        this.cause = throwable;
    }

    @Override
    public Throwable cause() {
        return this.cause;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public Future<V> sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override
    public Future<V> syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override
    public V getNow() {
        return null;
    }
}

