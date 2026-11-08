/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;

@GwtCompatible(serializable=true, emulated=true)
public class RegularImmutableSet<E>
extends ImmutableSet<E> {
    private final Object[] elements;
    @VisibleForTesting
    final transient Object[] table;
    private final transient int mask;
    private final transient int hashCode;

    RegularImmutableSet(Object[] objectArray, int n, Object[] objectArray2, int n2) {
        this.elements = objectArray;
        this.table = objectArray2;
        this.mask = n2;
        this.hashCode = n;
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        int n = Hashing.smear(object.hashCode());
        Object object2;
        while ((object2 = this.table[n & this.mask]) != null) {
            if (object2.equals(object)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    @Override
    public int size() {
        return this.elements.length;
    }

    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.forArray(this.elements);
    }

    @Override
    int copyIntoArray(Object[] objectArray, int n) {
        System.arraycopy(this.elements, 0, objectArray, n, this.elements.length);
        return n + this.elements.length;
    }

    @Override
    ImmutableList<E> createAsList() {
        return new RegularImmutableAsList(this, this.elements);
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    boolean isHashCodeFast() {
        return true;
    }
}

