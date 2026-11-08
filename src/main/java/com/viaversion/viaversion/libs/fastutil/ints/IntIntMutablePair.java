/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntIntPair;
import java.io.Serializable;
import java.util.Objects;

public class IntIntMutablePair
implements IntIntPair,
Serializable {
    private static final long serialVersionUID = 0L;
    protected int left;
    protected int right;

    public IntIntMutablePair(int n, int n2) {
        this.left = n;
        this.right = n2;
    }

    public static IntIntMutablePair of(int n, int n2) {
        return new IntIntMutablePair(n, n2);
    }

    @Override
    public int leftInt() {
        return this.left;
    }

    @Override
    public IntIntMutablePair left(int n) {
        this.left = n;
        return this;
    }

    @Override
    public int rightInt() {
        return this.right;
    }

    @Override
    public IntIntMutablePair right(int n) {
        this.right = n;
        return this;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof IntIntPair) {
            return this.left == ((IntIntPair)object).leftInt() && this.right == ((IntIntPair)object).rightInt();
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return this.left * 19 + this.right;
    }

    public String toString() {
        return "<" + this.leftInt() + "," + this.rightInt() + ">";
    }
}

