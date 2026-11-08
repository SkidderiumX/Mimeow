/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntLongPair;
import java.io.Serializable;
import java.util.Objects;

public class IntLongImmutablePair
implements IntLongPair,
Serializable {
    private static final long serialVersionUID = 0L;
    protected final int left;
    protected final long right;

    public IntLongImmutablePair(int n, long l) {
        this.left = n;
        this.right = l;
    }

    public static IntLongImmutablePair of(int n, long l) {
        return new IntLongImmutablePair(n, l);
    }

    @Override
    public int leftInt() {
        return this.left;
    }

    @Override
    public long rightLong() {
        return this.right;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof IntLongPair) {
            return this.left == ((IntLongPair)object).leftInt() && this.right == ((IntLongPair)object).rightLong();
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return this.left * 19 + HashCommon.long2int(this.right);
    }

    public String toString() {
        return "<" + this.leftInt() + "," + this.rightLong() + ">";
    }
}

