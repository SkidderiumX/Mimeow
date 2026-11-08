/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongArraySet;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSets;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import java.util.Set;

public interface LongSet
extends LongCollection,
Set<Long> {
    @Override
    public LongIterator iterator();

    @Override
    default public LongSpliterator spliterator() {
        return LongSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(this), 321);
    }

    public boolean remove(long var1);

    @Override
    @Deprecated
    default public boolean remove(Object object) {
        return LongCollection.super.remove(object);
    }

    @Override
    @Deprecated
    default public boolean add(Long l) {
        return LongCollection.super.add(l);
    }

    @Override
    @Deprecated
    default public boolean contains(Object object) {
        return LongCollection.super.contains(object);
    }

    @Override
    @Deprecated
    default public boolean rem(long l) {
        return this.remove(l);
    }

    public static LongSet of() {
        return LongSets.UNMODIFIABLE_EMPTY_SET;
    }

    public static LongSet of(long l) {
        return LongSets.singleton(l);
    }

    public static LongSet of(long l, long l2) {
        LongArraySet longArraySet = new LongArraySet(2);
        longArraySet.add(l);
        if (!longArraySet.add(l2)) {
            throw new IllegalArgumentException("Duplicate element: " + l2);
        }
        return LongSets.unmodifiable(longArraySet);
    }

    public static LongSet of(long l, long l2, long l3) {
        LongArraySet longArraySet = new LongArraySet(3);
        longArraySet.add(l);
        if (!longArraySet.add(l2)) {
            throw new IllegalArgumentException("Duplicate element: " + l2);
        }
        if (!longArraySet.add(l3)) {
            throw new IllegalArgumentException("Duplicate element: " + l3);
        }
        return LongSets.unmodifiable(longArraySet);
    }

    public static LongSet of(long ... lArray) {
        switch (lArray.length) {
            case 0: {
                return LongSet.of();
            }
            case 1: {
                return LongSet.of(lArray[0]);
            }
            case 2: {
                return LongSet.of(lArray[0], lArray[1]);
            }
            case 3: {
                return LongSet.of(lArray[0], lArray[1], lArray[2]);
            }
        }
        AbstractLongSet abstractLongSet = lArray.length <= 4 ? new LongArraySet(lArray.length) : new LongOpenHashSet(lArray.length);
        for (long l : lArray) {
            if (abstractLongSet.add(l)) continue;
            throw new IllegalArgumentException("Duplicate element: " + l);
        }
        return LongSets.unmodifiable(abstractLongSet);
    }
}

