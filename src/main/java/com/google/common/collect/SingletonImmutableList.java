/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class SingletonImmutableList<E>
extends ImmutableList<E> {
    final transient E element;

    SingletonImmutableList(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    @Override
    public E get(int n) {
        Preconditions.checkElementIndex(n, 1);
        return this.element;
    }

    @Override
    public int indexOf(@Nullable Object object) {
        return this.element.equals(object) ? 0 : -1;
    }

    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override
    public int lastIndexOf(@Nullable Object object) {
        return this.indexOf(object);
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public ImmutableList<E> subList(int n, int n2) {
        Preconditions.checkPositionIndexes(n, n2, 1);
        return n == n2 ? ImmutableList.of() : this;
    }

    @Override
    public ImmutableList<E> reverse() {
        return this;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.element.equals(object);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof List) {
            List list = (List)object;
            return list.size() == 1 && this.element.equals(list.get(0));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 + this.element.hashCode();
    }

    @Override
    public String toString() {
        String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    int copyIntoArray(Object[] objectArray, int n) {
        objectArray[n] = this.element;
        return n + 1;
    }
}

