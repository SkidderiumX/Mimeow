/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMultiset;
import java.util.Comparator;
import java.util.NavigableSet;

@GwtCompatible(emulated=true)
public class UnmodifiableSortedMultiset<E>
extends Multisets.UnmodifiableMultiset<E>
implements SortedMultiset<E> {
    private transient UnmodifiableSortedMultiset<E> descendingMultiset;
    private static final long serialVersionUID = 0L;

    UnmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        super(sortedMultiset);
    }

    @Override
    protected SortedMultiset<E> delegate() {
        return (SortedMultiset)super.delegate();
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.delegate().comparator();
    }

    @Override
    NavigableSet<E> createElementSet() {
        return Sets.unmodifiableNavigableSet(this.delegate().elementSet());
    }

    @Override
    public NavigableSet<E> elementSet() {
        return (NavigableSet)super.elementSet();
    }

    @Override
    public SortedMultiset<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset == null) {
            unmodifiableSortedMultiset = new UnmodifiableSortedMultiset(this.delegate().descendingMultiset());
            unmodifiableSortedMultiset.descendingMultiset = this;
            this.descendingMultiset = unmodifiableSortedMultiset;
            return this.descendingMultiset;
        }
        return unmodifiableSortedMultiset;
    }

    @Override
    public Multiset.Entry<E> firstEntry() {
        return this.delegate().firstEntry();
    }

    @Override
    public Multiset.Entry<E> lastEntry() {
        return this.delegate().lastEntry();
    }

    @Override
    public Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().headMultiset(e, boundType));
    }

    @Override
    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().subMultiset(e, boundType, e2, boundType2));
    }

    @Override
    public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().tailMultiset(e, boundType));
    }
}

