/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class SingletonImmutableSet<E>
extends ImmutableSet<E> {
    final transient E element;
    private transient int cachedHashCode;

    SingletonImmutableSet(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    SingletonImmutableSet(E e, int n) {
        this.element = e;
        this.cachedHashCode = n;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return this.element.equals(object);
    }

    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
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

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Set) {
            Set set = (Set)object;
            return set.size() == 1 && this.element.equals(set.iterator().next());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int n = this.cachedHashCode;
        if (n == 0) {
            this.cachedHashCode = n = this.element.hashCode();
        }
        return n;
    }

    @Override
    boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    @Override
    public String toString() {
        String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }
}

