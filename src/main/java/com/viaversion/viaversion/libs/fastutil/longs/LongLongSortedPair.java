/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.SortedPair;
import com.viaversion.viaversion.libs.fastutil.longs.LongLongImmutableSortedPair;
import com.viaversion.viaversion.libs.fastutil.longs.LongLongPair;
import java.io.Serializable;

public interface LongLongSortedPair
extends LongLongPair,
SortedPair<Long>,
Serializable {
    public static LongLongSortedPair of(long l, long l2) {
        return LongLongImmutableSortedPair.of(l, l2);
    }

    default public boolean contains(long l) {
        return l == this.leftLong() || l == this.rightLong();
    }

    @Override
    @Deprecated
    default public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        return this.contains((Long)object);
    }
}

