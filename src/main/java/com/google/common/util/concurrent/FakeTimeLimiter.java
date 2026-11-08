/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.TimeLimiter;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
public class FakeTimeLimiter
implements TimeLimiter {
    @Override
    public <T> T newProxy(T t, Class<T> clazz, long l, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(timeUnit);
        return t;
    }

    @Override
    public <T> T callWithTimeout(Callable<T> callable, long l, TimeUnit timeUnit, boolean bl) throws Exception {
        Preconditions.checkNotNull(timeUnit);
        return callable.call();
    }
}

