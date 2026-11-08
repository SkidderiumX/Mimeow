/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

@Beta
@GwtCompatible(emulated=true)
public abstract class ForwardingSortedMultiset<E>
extends ForwardingMultiset<E>
implements SortedMultiset<E> {
    protected ForwardingSortedMultiset() {
    }

    @Override
    protected abstract SortedMultiset<E> delegate();

    @Override
    public NavigableSet<E> elementSet() {
        return (NavigableSet)super.elementSet();
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.delegate().comparator();
    }

    @Override
    public SortedMultiset<E> descendingMultiset() {
        return this.delegate().descendingMultiset();
    }

    @Override
    public Multiset.Entry<E> firstEntry() {
        return this.delegate().firstEntry();
    }

    protected Multiset.Entry<E> standardFirstEntry() {
        Iterator iterator2 = this.entrySet().iterator();
        if (!iterator2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = iterator2.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    @Override
    public Multiset.Entry<E> lastEntry() {
        return this.delegate().lastEntry();
    }

    protected Multiset.Entry<E> standardLastEntry() {
        Iterator<Multiset.Entry<E>> iterator2 = this.descendingMultiset().entrySet().iterator();
        if (!iterator2.hasNext()) {
            return null;
        }
        Multiset.Entry<E> entry = iterator2.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    @Override
    public Multiset.Entry<E> pollFirstEntry() {
        return this.delegate().pollFirstEntry();
    }

    protected Multiset.Entry<E> standardPollFirstEntry() {
        Iterator iterator2 = this.entrySet().iterator();
        if (!iterator2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = iterator2.next();
        entry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        iterator2.remove();
        return entry;
    }

    @Override
    public Multiset.Entry<E> pollLastEntry() {
        return this.delegate().pollLastEntry();
    }

    protected Multiset.Entry<E> standardPollLastEntry() {
        Iterator<Multiset.Entry<E>> iterator2 = this.descendingMultiset().entrySet().iterator();
        if (!iterator2.hasNext()) {
            return null;
        }
        Multiset.Entry<E> entry = iterator2.next();
        entry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        iterator2.remove();
        return entry;
    }

    @Override
    public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.delegate().headMultiset(e, boundType);
    }

    @Override
    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return this.delegate().subMultiset(e, boundType, e2, boundType2);
    }

    protected SortedMultiset<E> standardSubMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return this.tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    @Override
    public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.delegate().tailMultiset(e, boundType);
    }

    protected abstract class StandardDescendingMultiset
    extends DescendingMultiset<E> {
        @Override
        SortedMultiset<E> forwardMultiset() {
            return ForwardingSortedMultiset.this;
        }
    }

    protected class StandardElementSet
    extends SortedMultisets.NavigableElementSet<E> {
        public StandardElementSet() {
            super(ForwardingSortedMultiset.this);
        }
    }
}

