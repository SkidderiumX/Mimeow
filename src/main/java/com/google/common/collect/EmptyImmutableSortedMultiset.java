/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Comparator;
import javax.annotation.Nullable;

public class EmptyImmutableSortedMultiset<E>
extends ImmutableSortedMultiset<E> {
    private final ImmutableSortedSet<E> elementSet;

    EmptyImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
    }

    @Override
    public Multiset.Entry<E> firstEntry() {
        return null;
    }

    @Override
    public Multiset.Entry<E> lastEntry() {
        return null;
    }

    @Override
    public int count(@Nullable Object object) {
        return 0;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override
    Multiset.Entry<E> getEntry(int n) {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(boundType);
        return this;
    }

    @Override
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(boundType);
        return this;
    }

    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.emptyIterator();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof Multiset) {
            Multiset multiset = (Multiset)object;
            return multiset.isEmpty();
        }
        return false;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    int copyIntoArray(Object[] objectArray, int n) {
        return n;
    }

    @Override
    public ImmutableList<E> asList() {
        return ImmutableList.of();
    }
}

