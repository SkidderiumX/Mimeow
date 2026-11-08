/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import javax.annotation.Nullable;

public class DescendingImmutableSortedSet<E>
extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.forward = immutableSortedSet;
    }

    @Override
    public int size() {
        return this.forward.size();
    }

    @Override
    public UnmodifiableIterator<E> iterator() {
        return this.forward.descendingIterator();
    }

    @Override
    ImmutableSortedSet<E> headSetImpl(E e, boolean bl) {
        return ((ImmutableSortedSet)this.forward.tailSet((Object)e, bl)).descendingSet();
    }

    @Override
    ImmutableSortedSet<E> subSetImpl(E e, boolean bl, E e2, boolean bl2) {
        return ((ImmutableSortedSet)this.forward.subSet((Object)e2, bl2, (Object)e, bl)).descendingSet();
    }

    @Override
    ImmutableSortedSet<E> tailSetImpl(E e, boolean bl) {
        return ((ImmutableSortedSet)this.forward.headSet((Object)e, bl)).descendingSet();
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet<E> descendingSet() {
        return this.forward;
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public UnmodifiableIterator<E> descendingIterator() {
        return this.forward.iterator();
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public E lower(E e) {
        return this.forward.higher(e);
    }

    @Override
    public E floor(E e) {
        return this.forward.ceiling(e);
    }

    @Override
    public E ceiling(E e) {
        return this.forward.floor(e);
    }

    @Override
    public E higher(E e) {
        return this.forward.lower(e);
    }

    @Override
    int indexOf(@Nullable Object object) {
        int n = this.forward.indexOf(object);
        if (n == -1) {
            return n;
        }
        return this.size() - 1 - n;
    }

    @Override
    boolean isPartialView() {
        return this.forward.isPartialView();
    }
}

