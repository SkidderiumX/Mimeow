/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableMultiset<E>
extends ImmutableCollection<E>
implements Multiset<E> {
    private static final ImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset(ImmutableMap.of(), 0);
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    public static <E> ImmutableMultiset<E> of() {
        return EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return ImmutableMultiset.copyOfInternal(e);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return ImmutableMultiset.copyOfInternal(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return ImmutableMultiset.copyOfInternal(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return ImmutableMultiset.copyOfInternal(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return ImmutableMultiset.copyOfInternal(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E ... EArray) {
        return ((Builder)((Builder)((Builder)((Builder)((Builder)((Builder)((Builder)new Builder().add((Object)e)).add((Object)e2)).add((Object)e3)).add((Object)e4)).add((Object)e5)).add((Object)e6)).add((Object[])EArray)).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] EArray) {
        return ImmutableMultiset.copyOf(Arrays.asList(EArray));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        Multiset<Object> multiset;
        if (iterable instanceof ImmutableMultiset && !(multiset = (ImmutableMultiset)iterable).isPartialView()) {
            return multiset;
        }
        multiset = iterable instanceof Multiset ? Multisets.cast(iterable) : LinkedHashMultiset.create(iterable);
        return ImmutableMultiset.copyOfInternal(multiset);
    }

    private static <E> ImmutableMultiset<E> copyOfInternal(E ... EArray) {
        return ImmutableMultiset.copyOf(Arrays.asList(EArray));
    }

    private static <E> ImmutableMultiset<E> copyOfInternal(Multiset<? extends E> multiset) {
        return ImmutableMultiset.copyFromEntries(multiset.entrySet());
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> collection) {
        long l = 0L;
        ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
        for (Multiset.Entry<E> entry : collection) {
            int n = entry.getCount();
            if (n <= 0) continue;
            builder.put(entry.getElement(), n);
            l += (long)n;
        }
        if (l == 0L) {
            return ImmutableMultiset.of();
        }
        return new RegularImmutableMultiset(builder.build(), Ints.saturatedCast(l));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> iterator2) {
        LinkedHashMultiset linkedHashMultiset = LinkedHashMultiset.create();
        Iterators.addAll(linkedHashMultiset, iterator2);
        return ImmutableMultiset.copyOfInternal(linkedHashMultiset);
    }

    ImmutableMultiset() {
    }

    @Override
    public UnmodifiableIterator<E> iterator() {
        final Iterator iterator2 = ((ImmutableSet)this.entrySet()).iterator();
        return new UnmodifiableIterator<E>(){
            int remaining;
            E element;

            @Override
            public boolean hasNext() {
                return this.remaining > 0 || iterator2.hasNext();
            }

            @Override
            public E next() {
                if (this.remaining <= 0) {
                    Multiset.Entry entry = (Multiset.Entry)iterator2.next();
                    this.element = entry.getElement();
                    this.remaining = entry.getCount();
                }
                --this.remaining;
                return this.element;
            }
        };
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.count(object) > 0;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return this.elementSet().containsAll(collection);
    }

    @Override
    @Deprecated
    public final int add(E e, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final int remove(Object object, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final int setCount(E e, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean setCount(E e, int n, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    @GwtIncompatible(value="not present in emulated superclass")
    int copyIntoArray(Object[] objectArray, int n) {
        for (Multiset.Entry entry : this.entrySet()) {
            Arrays.fill(objectArray, n, n + entry.getCount(), entry.getElement());
            n += entry.getCount();
        }
        return n;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Multisets.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }

    @Override
    public String toString() {
        return ((AbstractCollection)((Object)this.entrySet())).toString();
    }

    @Override
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<Multiset.Entry<E>>> immutableSet = this.entrySet;
        return immutableSet == null ? (this.entrySet = this.createEntrySet()) : immutableSet;
    }

    private final ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return this.isEmpty() ? ImmutableSet.of() : new EntrySet();
    }

    abstract Multiset.Entry<E> getEntry(int var1);

    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }

    public static class Builder<E>
    extends ImmutableCollection.Builder<E> {
        final Multiset<E> contents;

        public Builder() {
            this(LinkedHashMultiset.create());
        }

        Builder(Multiset<E> multiset) {
            this.contents = multiset;
        }

        @Override
        public Builder<E> add(E e) {
            this.contents.add(Preconditions.checkNotNull(e));
            return this;
        }

        public Builder<E> addCopies(E e, int n) {
            this.contents.add(Preconditions.checkNotNull(e), n);
            return this;
        }

        public Builder<E> setCount(E e, int n) {
            this.contents.setCount(Preconditions.checkNotNull(e), n);
            return this;
        }

        @Override
        public Builder<E> add(E ... EArray) {
            super.add(EArray);
            return this;
        }

        @Override
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                Multiset<E> multiset = Multisets.cast(iterable);
                for (Multiset.Entry<E> entry : multiset.entrySet()) {
                    this.addCopies(entry.getElement(), entry.getCount());
                }
            } else {
                super.addAll(iterable);
            }
            return this;
        }

        @Override
        public Builder<E> addAll(Iterator<? extends E> iterator2) {
            super.addAll(iterator2);
            return this;
        }

        @Override
        public ImmutableMultiset<E> build() {
            return ImmutableMultiset.copyOf(this.contents);
        }
    }

    private static class SerializedForm
    implements Serializable {
        final Object[] elements;
        final int[] counts;
        private static final long serialVersionUID = 0L;

        SerializedForm(Multiset<?> multiset) {
            int n = multiset.entrySet().size();
            this.elements = new Object[n];
            this.counts = new int[n];
            int n2 = 0;
            for (Multiset.Entry<?> entry : multiset.entrySet()) {
                this.elements[n2] = entry.getElement();
                this.counts[n2] = entry.getCount();
                ++n2;
            }
        }

        Object readResolve() {
            LinkedHashMultiset linkedHashMultiset = LinkedHashMultiset.create(this.elements.length);
            for (int i = 0; i < this.elements.length; ++i) {
                linkedHashMultiset.add(this.elements[i], this.counts[i]);
            }
            return ImmutableMultiset.copyOf(linkedHashMultiset);
        }
    }

    public static class EntrySetSerializedForm<E>
    implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    private final class EntrySet
    extends ImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0L;

        private EntrySet() {
        }

        @Override
        boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override
        public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
            return this.asList().iterator();
        }

        @Override
        ImmutableList<Multiset.Entry<E>> createAsList() {
            return new ImmutableAsList<Multiset.Entry<E>>(){

                @Override
                public Multiset.Entry<E> get(int n) {
                    return ImmutableMultiset.this.getEntry(n);
                }

                @Override
                ImmutableCollection<Multiset.Entry<E>> delegateCollection() {
                    return EntrySet.this;
                }
            };
        }

        @Override
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override
        public boolean contains(Object object) {
            if (object instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry)object;
                if (entry.getCount() <= 0) {
                    return false;
                }
                int n = ImmutableMultiset.this.count(entry.getElement());
                return n == entry.getCount();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }
}

