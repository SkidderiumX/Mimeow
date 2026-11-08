/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.util.EitherImpl;

public interface Either<X, Y> {
    public static <X, Y> Either<X, Y> left(X x) {
        Preconditions.checkNotNull(x);
        return new EitherImpl<X, Object>(x, null);
    }

    public static <X, Y> Either<X, Y> right(Y y) {
        Preconditions.checkNotNull(y);
        return new EitherImpl<Object, Y>(null, y);
    }

    public boolean isLeft();

    public boolean isRight();

    public X left();

    public Y right();
}

