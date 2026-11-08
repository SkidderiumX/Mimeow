/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectLongImmutablePair;
import java.util.Comparator;

public interface ObjectLongPair<K>
extends Pair<K, Long> {
    public long rightLong();

    @Override
    @Deprecated
    default public Long right() {
        return this.rightLong();
    }

    default public ObjectLongPair<K> right(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public ObjectLongPair<K> right(Long l) {
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

    default public ObjectLongPair<K> second(long l) {
        return this.right(l);
    }

    @Deprecated
    default public ObjectLongPair<K> second(Long l) {
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

    default public ObjectLongPair<K> value(long l) {
        return this.right(l);
    }

    @Deprecated
    default public ObjectLongPair<K> value(Long l) {
        return this.value((long)l);
    }

    public static <K> ObjectLongPair<K> of(K k, long l) {
        return new ObjectLongImmutablePair<K>(k, l);
    }

    public static <K> Comparator<ObjectLongPair<K>> lexComparator() {
        return (objectLongPair, objectLongPair2) -> {
            int n = ((Comparable)objectLongPair.left()).compareTo(objectLongPair2.left());
            if (n != 0) {
                return n;
            }
            return Long.compare(objectLongPair.rightLong(), objectLongPair2.rightLong());
        };
    }
}

