/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedIterable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class ImmutableSortedAsList<E>
extends RegularImmutableAsList<E>
implements SortedIterable<E> {
    ImmutableSortedAsList(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super(immutableSortedSet, immutableList);
    }

    @Override
    ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet)super.delegateCollection();
    }

    @Override
    public Comparator<? super E> comparator() {
        return ((ImmutableSortedSet)this.delegateCollection()).comparator();
    }

    @Override
    @GwtIncompatible(value="ImmutableSortedSet.indexOf")
    public int indexOf(@Nullable Object object) {
        int n = ((ImmutableSortedSet)this.delegateCollection()).indexOf(object);
        return n >= 0 && this.get(n).equals(object) ? n : -1;
    }

    @Override
    @GwtIncompatible(value="ImmutableSortedSet.indexOf")
    public int lastIndexOf(@Nullable Object object) {
        return this.indexOf(object);
    }

    @Override
    public boolean contains(Object object) {
        return this.indexOf(object) >= 0;
    }

    @Override
    @GwtIncompatible(value="super.subListUnchecked does not exist; inherited subList is valid if slow")
    ImmutableList<E> subListUnchecked(int n, int n2) {
        return new RegularImmutableSortedSet(super.subListUnchecked(n, n2), this.comparator()).asList();
    }
}

