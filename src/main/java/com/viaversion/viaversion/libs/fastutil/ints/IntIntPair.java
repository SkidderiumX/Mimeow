/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntIntImmutablePair;
import java.util.Comparator;

public interface IntIntPair
extends Pair<Integer, Integer> {
    public int leftInt();

    @Override
    @Deprecated
    default public Integer left() {
        return this.leftInt();
    }

    default public IntIntPair left(int n) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public IntIntPair left(Integer n) {
        return this.left((int)n);
    }

    default public int firstInt() {
        return this.leftInt();
    }

    @Override
    @Deprecated
    default public Integer first() {
        return this.firstInt();
    }

    default public IntIntPair first(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntIntPair first(Integer n) {
        return this.first((int)n);
    }

    default public int keyInt() {
        return this.firstInt();
    }

    @Override
    @Deprecated
    default public Integer key() {
        return this.keyInt();
    }

    default public IntIntPair key(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntIntPair key(Integer n) {
        return this.key((int)n);
    }

    public int rightInt();

    @Override
    @Deprecated
    default public Integer right() {
        return this.rightInt();
    }

    default public IntIntPair right(int n) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public IntIntPair right(Integer n) {
        return this.right((int)n);
    }

    default public int secondInt() {
        return this.rightInt();
    }

    @Override
    @Deprecated
    default public Integer second() {
        return this.secondInt();
    }

    default public IntIntPair second(int n) {
        return this.right(n);
    }

    @Deprecated
    default public IntIntPair second(Integer n) {
        return this.second((int)n);
    }

    default public int valueInt() {
        return this.rightInt();
    }

    @Override
    @Deprecated
    default public Integer value() {
        return this.valueInt();
    }

    default public IntIntPair value(int n) {
        return this.right(n);
    }

    @Deprecated
    default public IntIntPair value(Integer n) {
        return this.value((int)n);
    }

    public static IntIntPair of(int n, int n2) {
        return new IntIntImmutablePair(n, n2);
    }

    public static Comparator<IntIntPair> lexComparator() {
        return (intIntPair, intIntPair2) -> {
            int n = Integer.compare(intIntPair.leftInt(), intIntPair2.leftInt());
            if (n != 0) {
                return n;
            }
            return Integer.compare(intIntPair.rightInt(), intIntPair2.rightInt());
        };
    }
}

