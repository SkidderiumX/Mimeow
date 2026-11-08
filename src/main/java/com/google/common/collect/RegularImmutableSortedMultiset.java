/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.primitives.Ints;
import javax.annotation.Nullable;

public class RegularImmutableSortedMultiset<E>
extends ImmutableSortedMultiset<E> {
    private final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int[] counts;
    private final transient long[] cumulativeCounts;
    private final transient int offset;
    private final transient int length;

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, int[] nArray, long[] lArray, int n, int n2) {
        this.elementSet = regularImmutableSortedSet;
        this.counts = nArray;
        this.cumulativeCounts = lArray;
        this.offset = n;
        this.length = n2;
    }

    @Override
    Multiset.Entry<E> getEntry(int n) {
        return Multisets.immutableEntry(this.elementSet.asList().get(n), this.counts[this.offset + n]);
    }

    @Override
    public Multiset.Entry<E> firstEntry() {
        return this.getEntry(0);
    }

    @Override
    public Multiset.Entry<E> lastEntry() {
        return this.getEntry(this.length - 1);
    }

    @Override
    public int count(@Nullable Object object) {
        int n = this.elementSet.indexOf(object);
        return n == -1 ? 0 : this.counts[n + this.offset];
    }

    @Override
    public int size() {
        long l = this.cumulativeCounts[this.offset + this.length] - this.cumulativeCounts[this.offset];
        return Ints.saturatedCast(l);
    }

    @Override
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.getSubMultiset(0, this.elementSet.headIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    @Override
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.getSubMultiset(this.elementSet.tailIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }

    ImmutableSortedMultiset<E> getSubMultiset(int n, int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.length);
        if (n == n2) {
            return RegularImmutableSortedMultiset.emptyMultiset(this.comparator());
        }
        if (n == 0 && n2 == this.length) {
            return this;
        }
        RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet)this.elementSet.getSubSet(n, n2);
        return new RegularImmutableSortedMultiset<E>(regularImmutableSortedSet, this.counts, this.cumulativeCounts, this.offset + n, n2 - n);
    }

    @Override
    boolean isPartialView() {
        return this.offset > 0 || this.length < this.counts.length;
    }
}

