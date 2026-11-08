/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceLongImmutablePair;

public interface ReferenceLongPair<K>
extends Pair<K, Long> {
    public long rightLong();

    @Override
    @Deprecated
    default public Long right() {
        return this.rightLong();
    }

    default public ReferenceLongPair<K> right(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public ReferenceLongPair<K> right(Long l) {
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

    default public ReferenceLongPair<K> second(long l) {
        return this.right(l);
    }

    @Deprecated
    default public ReferenceLongPair<K> second(Long l) {
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

    default public ReferenceLongPair<K> value(long l) {
        return this.right(l);
    }

    @Deprecated
    default public ReferenceLongPair<K> value(Long l) {
        return this.value((long)l);
    }

    public static <K> ReferenceLongPair<K> of(K k, long l) {
        return new ReferenceLongImmutablePair<K>(k, l);
    }
}

