/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntLongImmutablePair;
import java.util.Comparator;

public interface IntLongPair
extends Pair<Integer, Long> {
    public int leftInt();

    @Override
    @Deprecated
    default public Integer left() {
        return this.leftInt();
    }

    default public IntLongPair left(int n) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public IntLongPair left(Integer n) {
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

    default public IntLongPair first(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntLongPair first(Integer n) {
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

    default public IntLongPair key(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntLongPair key(Integer n) {
        return this.key((int)n);
    }

    public long rightLong();

    @Override
    @Deprecated
    default public Long right() {
        return this.rightLong();
    }

    default public IntLongPair right(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public IntLongPair right(Long l) {
        return this.right((long)l);
    }

    default public long secondLong() {
        return this.rightLong();
    }

    @Override
    @Deprecated
    default public Long second() {
        return this.secondLong();
    }

    default public IntLongPair second(long l) {
        return this.right(l);
    }

    @Deprecated
    default public IntLongPair second(Long l) {
        return this.second((long)l);
    }

    default public long valueLong() {
        return this.rightLong();
    }

    @Override
    @Deprecated
    default public Long value() {
        return this.valueLong();
    }

    default public IntLongPair value(long l) {
        return this.right(l);
    }

    @Deprecated
    default public IntLongPair value(Long l) {
        return this.value((long)l);
    }

    public static IntLongPair of(int n, long l) {
        return new IntLongImmutablePair(n, l);
    }

    public static Comparator<IntLongPair> lexComparator() {
        return (intLongPair, intLongPair2) -> {
            int n = Integer.compare(intLongPair.leftInt(), intLongPair2.leftInt());
            if (n != 0) {
                return n;
            }
            return Long.compare(intLongPair.rightLong(), intLongPair2.rightLong());
        };
    }
}

