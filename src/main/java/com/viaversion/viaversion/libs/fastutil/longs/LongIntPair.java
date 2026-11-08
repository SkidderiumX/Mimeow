/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.longs.LongIntImmutablePair;
import java.util.Comparator;

public interface LongIntPair
extends Pair<Long, Integer> {
    public long leftLong();

    @Override
    @Deprecated
    default public Long left() {
        return this.leftLong();
    }

    default public LongIntPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public LongIntPair left(Long l) {
        return this.left((long)l);
    }

    default public long firstLong() {
        return this.leftLong();
    }

    @Override
    @Deprecated
    default public Long first() {
        return this.firstLong();
    }

    default public LongIntPair first(long l) {
        return this.left(l);
    }

    @Deprecated
    default public LongIntPair first(Long l) {
        return this.first((long)l);
    }

    default public long keyLong() {
        return this.firstLong();
    }

    @Override
    @Deprecated
    default public Long key() {
        return this.keyLong();
    }

    default public LongIntPair key(long l) {
        return this.left(l);
    }

    @Deprecated
    default public LongIntPair key(Long l) {
        return this.key((long)l);
    }

    public int rightInt();

    @Override
    @Deprecated
    default public Integer right() {
        return this.rightInt();
    }

    default public LongIntPair right(int n) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public LongIntPair right(Integer n) {
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

    default public LongIntPair second(int n) {
        return this.right(n);
    }

    @Deprecated
    default public LongIntPair second(Integer n) {
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

    default public LongIntPair value(int n) {
        return this.right(n);
    }

    @Deprecated
    default public LongIntPair value(Integer n) {
        return this.value((int)n);
    }

    public static LongIntPair of(long l, int n) {
        return new LongIntImmutablePair(l, n);
    }

    public static Comparator<LongIntPair> lexComparator() {
        return (longIntPair, longIntPair2) -> {
            int n = Long.compare(longIntPair.leftLong(), longIntPair2.leftLong());
            if (n != 0) {
                return n;
            }
            return Integer.compare(longIntPair.rightInt(), longIntPair2.rightInt());
        };
    }
}

