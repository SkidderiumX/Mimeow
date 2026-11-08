/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.longs.LongIntPair;
import java.io.Serializable;
import java.util.Objects;

public class LongIntMutablePair
implements LongIntPair,
Serializable {
    private static final long serialVersionUID = 0L;
    protected long left;
    protected int right;

    public LongIntMutablePair(long l, int n) {
        this.left = l;
        this.right = n;
    }

    public static LongIntMutablePair of(long l, int n) {
        return new LongIntMutablePair(l, n);
    }

    @Override
    public long leftLong() {
        return this.left;
    }

    @Override
    public LongIntMutablePair left(long l) {
        this.left = l;
        return this;
    }

    @Override
    public int rightInt() {
        return this.right;
    }

    @Override
    public LongIntMutablePair right(int n) {
        this.right = n;
        return this;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof LongIntPair) {
            return this.left == ((LongIntPair)object).leftLong() && this.right == ((LongIntPair)object).rightInt();
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return HashCommon.long2int(this.left) * 19 + this.right;
    }

    public String toString() {
        return "<" + this.leftLong() + "," + this.rightInt() + ">";
    }
}

