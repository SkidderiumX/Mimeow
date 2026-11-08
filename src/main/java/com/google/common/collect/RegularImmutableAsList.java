/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;

@GwtCompatible(emulated=true)
public class RegularImmutableAsList<E>
extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objectArray) {
        this(immutableCollection, ImmutableList.asImmutableList(objectArray));
    }

    @Override
    ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override
    public UnmodifiableListIterator<E> listIterator(int n) {
        return this.delegateList.listIterator(n);
    }

    @Override
    @GwtIncompatible(value="not present in emulated superclass")
    int copyIntoArray(Object[] objectArray, int n) {
        return this.delegateList.copyIntoArray(objectArray, n);
    }

    @Override
    public E get(int n) {
        return this.delegateList.get(n);
    }
}

