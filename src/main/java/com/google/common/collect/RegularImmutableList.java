/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableListIterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class RegularImmutableList<E>
extends ImmutableList<E> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] array;

    RegularImmutableList(Object[] objectArray, int n, int n2) {
        this.offset = n;
        this.size = n2;
        this.array = objectArray;
    }

    RegularImmutableList(Object[] objectArray) {
        this(objectArray, 0, objectArray.length);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    boolean isPartialView() {
        return this.size != this.array.length;
    }

    @Override
    int copyIntoArray(Object[] objectArray, int n) {
        System.arraycopy(this.array, this.offset, objectArray, n, this.size);
        return n + this.size;
    }

    @Override
    public E get(int n) {
        Preconditions.checkElementIndex(n, this.size);
        return (E)this.array[n + this.offset];
    }

    @Override
    public int indexOf(@Nullable Object object) {
        if (object == null) {
            return -1;
        }
        for (int i = 0; i < this.size; ++i) {
            if (!this.array[this.offset + i].equals(object)) continue;
            return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(@Nullable Object object) {
        if (object == null) {
            return -1;
        }
        for (int i = this.size - 1; i >= 0; --i) {
            if (!this.array[this.offset + i].equals(object)) continue;
            return i;
        }
        return -1;
    }

    @Override
    ImmutableList<E> subListUnchecked(int n, int n2) {
        return new RegularImmutableList<E>(this.array, this.offset + n, n2 - n);
    }

    @Override
    public UnmodifiableListIterator<E> listIterator(int n) {
        return Iterators.forArray(this.array, this.offset, this.size, n);
    }
}

