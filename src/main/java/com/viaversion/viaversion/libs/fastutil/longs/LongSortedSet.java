/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.longs.LongBidirectionalIterable;
import com.viaversion.viaversion.libs.fastutil.longs.LongBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongComparator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import java.util.SortedSet;

public interface LongSortedSet
extends LongSet,
SortedSet<Long>,
LongBidirectionalIterable {
    public LongBidirectionalIterator iterator(long var1);

    @Override
    public LongBidirectionalIterator iterator();

    @Override
    default public LongSpliterator spliterator() {
        return LongSpliterators.asSpliteratorFromSorted(this.iterator(), Size64.sizeOf(this), 341, this.comparator());
    }

    public LongSortedSet subSet(long var1, long var3);

    public LongSortedSet headSet(long var1);

    public LongSortedSet tailSet(long var1);

    public LongComparator comparator();

    public long firstLong();

    public long lastLong();

    @Deprecated
    default public LongSortedSet subSet(Long l, Long l2) {
        return this.subSet((long)l, (long)l2);
    }

    @Deprecated
    default public LongSortedSet headSet(Long l) {
        return this.headSet((long)l);
    }

    @Deprecated
    default public LongSortedSet tailSet(Long l) {
        return this.tailSet((long)l);
    }

    @Override
    @Deprecated
    default public Long first() {
        return this.firstLong();
    }

    @Override
    @Deprecated
    default public Long last() {
        return this.lastLong();
    }
}

