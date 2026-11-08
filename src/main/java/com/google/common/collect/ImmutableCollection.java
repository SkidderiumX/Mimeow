/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class ImmutableCollection<E>
extends AbstractCollection<E>
implements Serializable {
    private transient ImmutableList<E> asList;

    ImmutableCollection() {
    }

    @Override
    public abstract UnmodifiableIterator<E> iterator();

    @Override
    public final Object[] toArray() {
        int n = this.size();
        if (n == 0) {
            return ObjectArrays.EMPTY_ARRAY;
        }
        Object[] objectArray = new Object[this.size()];
        this.copyIntoArray(objectArray, 0);
        return objectArray;
    }

    @Override
    public final <T> T[] toArray(T[] TArray) {
        Preconditions.checkNotNull(TArray);
        int n = this.size();
        if (TArray.length < n) {
            TArray = ObjectArrays.newArray(TArray, n);
        } else if (TArray.length > n) {
            TArray[n] = null;
        }
        this.copyIntoArray(TArray, 0);
        return TArray;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return object != null && super.contains(object);
    }

    @Override
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        return immutableList == null ? (this.asList = this.createAsList()) : immutableList;
    }

    ImmutableList<E> createAsList() {
        switch (this.size()) {
            case 0: {
                return ImmutableList.of();
            }
            case 1: {
                return ImmutableList.of(this.iterator().next());
            }
        }
        return new RegularImmutableAsList(this, this.toArray());
    }

    abstract boolean isPartialView();

    int copyIntoArray(Object[] objectArray, int n) {
        for (Object e : this) {
            objectArray[n++] = e;
        }
        return n;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(this.toArray());
    }

    public static abstract class ArrayBasedBuilder<E>
    extends Builder<E> {
        Object[] contents;
        int size;

        ArrayBasedBuilder(int n) {
            CollectPreconditions.checkNonnegative(n, "initialCapacity");
            this.contents = new Object[n];
            this.size = 0;
        }

        private void ensureCapacity(int n) {
            if (this.contents.length < n) {
                this.contents = ObjectArrays.arraysCopyOf(this.contents, ArrayBasedBuilder.expandedCapacity(this.contents.length, n));
            }
        }

        @Override
        public ArrayBasedBuilder<E> add(E e) {
            Preconditions.checkNotNull(e);
            this.ensureCapacity(this.size + 1);
            this.contents[this.size++] = e;
            return this;
        }

        @Override
        public Builder<E> add(E ... EArray) {
            ObjectArrays.checkElementsNotNull((Object[])EArray);
            this.ensureCapacity(this.size + EArray.length);
            System.arraycopy(EArray, 0, this.contents, this.size, EArray.length);
            this.size += EArray.length;
            return this;
        }

        @Override
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection)iterable;
                this.ensureCapacity(this.size + collection.size());
            }
            super.addAll(iterable);
            return this;
        }
    }

    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        static int expandedCapacity(int n, int n2) {
            if (n2 < 0) {
                throw new AssertionError((Object)"cannot store more than MAX_VALUE elements");
            }
            int n3 = n + (n >> 1) + 1;
            if (n3 < n2) {
                n3 = Integer.highestOneBit(n2 - 1) << 1;
            }
            if (n3 < 0) {
                n3 = Integer.MAX_VALUE;
            }
            return n3;
        }

        Builder() {
        }

        public abstract Builder<E> add(E var1);

        public Builder<E> add(E ... EArray) {
            for (E e : EArray) {
                this.add(e);
            }
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> iterable) {
            for (E e : iterable) {
                this.add(e);
            }
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> iterator2) {
            while (iterator2.hasNext()) {
                this.add(iterator2.next());
            }
            return this;
        }

        public abstract ImmutableCollection<E> build();
    }
}

