/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntLongPair;
import java.io.Serializable;
import java.util.Objects;

public class IntLongMutablePair
implements IntLongPair,
Serializable {
    private static final long serialVersionUID = 0L;
    protected int left;
    protected long right;

    public IntLongMutablePair(int n, long l) {
        this.left = n;
        this.right = l;
    }

    public static IntLongMutablePair of(int n, long l) {
        return new IntLongMutablePair(n, l);
    }

    @Override
    public int leftInt() {
        return this.left;
    }

    @Override
    public IntLongMutablePair left(int n) {
        this.left = n;
        return this;
    }

    @Override
    public long rightLong() {
        return this.right;
    }

    @Override
    public IntLongMutablePair right(long l) {
        this.right = l;
        return this;
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

