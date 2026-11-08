/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.ints.IntBidirectionalIterable;
import com.viaversion.viaversion.libs.fastutil.ints.IntBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntComparator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterators;
import java.util.SortedSet;

public interface IntSortedSet
extends IntSet,
SortedSet<Integer>,
IntBidirectionalIterable {
    public IntBidirectionalIterator iterator(int var1);

    @Override
    public IntBidirectionalIterator iterator();

    @Override
    default public IntSpliterator spliterator() {
        return IntSpliterators.asSpliteratorFromSorted(this.iterator(), Size64.sizeOf(this), 341, this.comparator());
    }

    public IntSortedSet subSet(int var1, int var2);

    public IntSortedSet headSet(int var1);

    public IntSortedSet tailSet(int var1);

    public IntComparator comparator();

    public int firstInt();

    public int lastInt();

    @Deprecated
    default public IntSortedSet subSet(Integer n, Integer n2) {
        return this.subSet((int)n, (int)n2);
    }

    @Deprecated
    default public IntSortedSet headSet(Integer n) {
        return this.headSet((int)n);
    }

    @Deprecated
    default public IntSortedSet tailSet(Integer n) {
        return this.tailSet((int)n);
    }

    @Override
    @Deprecated
    default public Integer first() {
        return this.firstInt();
    }

    @Override
    @Deprecated
    default public Integer last() {
        return this.lastInt();
    }
}

