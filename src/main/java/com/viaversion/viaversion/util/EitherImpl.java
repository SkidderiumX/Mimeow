/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.util.Either;
import java.util.Objects;

public class EitherImpl<X, Y>
implements Either<X, Y> {
    private final X left;
    private final Y right;

    protected EitherImpl(X x, Y y) {
        this.left = x;
        this.right = y;
        Preconditions.checkArgument(x == null || y == null, "Either.left and Either.right are both present");
        Preconditions.checkArgument(x != null || y != null, "Either.left and Either.right are both null");
    }

    @Override
    public boolean isLeft() {
        return this.left != null;
    }

    @Override
    public boolean isRight() {
        return this.right != null;
    }

    @Override
    public X left() {
        return this.left;
    }

    @Override
    public Y right() {
        return this.right;
    }

    public String toString() {
        return "Either{" + String.valueOf(this.left) + ", " + String.valueOf(this.right) + "}";
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        EitherImpl eitherImpl = (EitherImpl)object;
        if (!Objects.equals(this.left, eitherImpl.left)) {
            return false;
        }
        return Objects.equals(this.right, eitherImpl.right);
    }

    public int hashCode() {
        int n = this.left != null ? this.left.hashCode() : 0;
        n = 31 * n + (this.right != null ? this.right.hashCode() : 0);
        return n;
    }
}

