/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.longs.LongLongImmutablePair;
import java.util.Comparator;

public interface LongLongPair
extends Pair<Long, Long> {
    public long leftLong();

    @Override
    @Deprecated
    default public Long left() {
        return this.leftLong();
    }

    default public LongLongPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public LongLongPair left(Long l) {
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

    default public LongLongPair first(long l) {
        return this.left(l);
    }

    @Deprecated
    default public LongLongPair first(Long l) {
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

    default public LongLongPair key(long l) {
        return this.left(l);
    }

    @Deprecated
    default public LongLongPair key(Long l) {
        return this.key((long)l);
    }

    public long rightLong();

    @Override
    @Deprecated
    default public Long right() {
        return this.rightLong();
    }

    default public LongLongPair right(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public LongLongPair right(Long l) {
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

    default public LongLongPair second(long l) {
        return this.right(l);
    }

    @Deprecated
    default public LongLongPair second(Long l) {
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

    default public LongLongPair value(long l) {
        return this.right(l);
    }

    @Deprecated
    default public LongLongPair value(Long l) {
        return this.value((long)l);
    }

    public static LongLongPair of(long l, long l2) {
        return new LongLongImmutablePair(l, l2);
    }

    public static Comparator<LongLongPair> lexComparator() {
        return (longLongPair, longLongPair2) -> {
            int n = Long.compare(longLongPair.leftLong(), longLongPair2.leftLong());
            if (n != 0) {
                return n;
            }
            return Long.compare(longLongPair.rightLong(), longLongPair2.rightLong());
        };
    }
}

