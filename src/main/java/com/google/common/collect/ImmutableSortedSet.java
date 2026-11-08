/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.DescendingImmutableSortedSet;
import com.google.common.collect.EmptyImmutableSortedSet;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSetFauxverideShim;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedIterable;
import com.google.common.collect.SortedIterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableSortedSet<E>
extends ImmutableSortedSetFauxverideShim<E>
implements NavigableSet<E>,
SortedIterable<E> {
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new EmptyImmutableSortedSet<Comparable>(NATURAL_ORDER);
    final transient Comparator<? super E> comparator;
    @GwtIncompatible(value="NavigableSet")
    transient ImmutableSortedSet<E> descendingSet;

    private static <E> ImmutableSortedSet<E> emptySet() {
        return NATURAL_EMPTY_SET;
    }

    static <E> ImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        if (NATURAL_ORDER.equals(comparator)) {
            return ImmutableSortedSet.emptySet();
        }
        return new EmptyImmutableSortedSet<E>(comparator);
    }

    public static <E> ImmutableSortedSet<E> of() {
        return ImmutableSortedSet.emptySet();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e) {
        return new RegularImmutableSortedSet<E>(ImmutableList.of(e), Ordering.natural());
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2) {
        return ImmutableSortedSet.construct(Ordering.natural(), 2, e, e2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3) {
        return ImmutableSortedSet.construct(Ordering.natural(), 3, e, e2, e3);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4) {
        return ImmutableSortedSet.construct(Ordering.natural(), 4, e, e2, e3, e4);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return ImmutableSortedSet.construct(Ordering.natural(), 5, e, e2, e3, e4, e5);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E ... EArray) {
        Comparable[] comparableArray = new Comparable[6 + EArray.length];
        comparableArray[0] = e;
        comparableArray[1] = e2;
        comparableArray[2] = e3;
        comparableArray[3] = e4;
        comparableArray[4] = e5;
        comparableArray[5] = e6;
        System.arraycopy(EArray, 0, comparableArray, 6, EArray.length);
        return ImmutableSortedSet.construct(Ordering.natural(), comparableArray.length, comparableArray);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] EArray) {
        return ImmutableSortedSet.construct(Ordering.natural(), EArray.length, (Object[])EArray.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedSet.copyOf(ordering, iterable);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedSet.copyOf(ordering, collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> iterator2) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedSet.copyOf(ordering, iterator2);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> iterator2) {
        return ((Builder)new Builder<E>(comparator).addAll((Iterator)iterator2)).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Object object;
        Preconditions.checkNotNull(comparator);
        boolean bl = SortedIterables.hasSameComparator(comparator, iterable);
        if (bl && iterable instanceof ImmutableSortedSet && !((ImmutableCollection)(object = (ImmutableSortedSet)iterable)).isPartialView()) {
            return object;
        }
        object = Iterables.toArray(iterable);
        return ImmutableSortedSet.construct(comparator, ((Object[])object).length, object);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return ImmutableSortedSet.copyOf(comparator, collection);
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<E> comparator = SortedIterables.comparator(sortedSet);
        ImmutableList<E> immutableList = ImmutableList.copyOf(sortedSet);
        if (immutableList.isEmpty()) {
            return ImmutableSortedSet.emptySet(comparator);
        }
        return new RegularImmutableSortedSet<E>(immutableList, comparator);
    }

    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int n, E ... EArray) {
        if (n == 0) {
            return ImmutableSortedSet.emptySet(comparator);
        }
        ObjectArrays.checkElementsNotNull((Object[])EArray, n);
        Arrays.sort(EArray, 0, n, comparator);
        int n2 = 1;
        for (int i = 1; i < n; ++i) {
            E e = EArray[i];
            E e2 = EArray[n2 - 1];
            if (comparator.compare(e, e2) == 0) continue;
            EArray[n2++] = e;
        }
        Arrays.fill(EArray, n2, n, null);
        return new RegularImmutableSortedSet<E>(ImmutableList.asImmutableList(EArray, n2), comparator);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<E>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    int unsafeCompare(Object object, Object object2) {
        return ImmutableSortedSet.unsafeCompare(this.comparator, object, object2);
    }

    static int unsafeCompare(Comparator<?> comparator, Object object, Object object2) {
        Comparator<?> comparator2 = comparator;
        return comparator2.compare(object, object2);
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override
    public abstract UnmodifiableIterator<E> iterator();

    @Override
    public ImmutableSortedSet<E> headSet(E e) {
        return this.headSet((Object)e, false);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet<E> headSet(E e, boolean bl) {
        return this.headSetImpl(Preconditions.checkNotNull(e), bl);
    }

    @Override
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return this.subSet((Object)e, true, (Object)e2, false);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet<E> subSet(E e, boolean bl, E e2, boolean bl2) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(e2);
        Preconditions.checkArgument(this.comparator.compare(e, e2) <= 0);
        return this.subSetImpl(e, bl, e2, bl2);
    }

    @Override
    public ImmutableSortedSet<E> tailSet(E e) {
        return this.tailSet((Object)e, true);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet<E> tailSet(E e, boolean bl) {
        return this.tailSetImpl(Preconditions.checkNotNull(e), bl);
    }

    abstract ImmutableSortedSet<E> headSetImpl(E var1, boolean var2);

    abstract ImmutableSortedSet<E> subSetImpl(E var1, boolean var2, E var3, boolean var4);

    abstract ImmutableSortedSet<E> tailSetImpl(E var1, boolean var2);

    @Override
    @GwtIncompatible(value="NavigableSet")
    public E lower(E e) {
        return Iterators.getNext(((ImmutableSortedSet)this.headSet((Object)e, false)).descendingIterator(), null);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public E floor(E e) {
        return Iterators.getNext(((ImmutableSortedSet)this.headSet((Object)e, true)).descendingIterator(), null);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public E ceiling(E e) {
        return Iterables.getFirst(this.tailSet((Object)e, true), null);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public E higher(E e) {
        return Iterables.getFirst(this.tailSet((Object)e, false), null);
    }

    @Override
    public E first() {
        return this.iterator().next();
    }

    @Override
    public E last() {
        return this.descendingIterator().next();
    }

    @Override
    @Deprecated
    @GwtIncompatible(value="NavigableSet")
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    @GwtIncompatible(value="NavigableSet")
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet == null) {
            immutableSortedSet = this.descendingSet = this.createDescendingSet();
            immutableSortedSet.descendingSet = this;
        }
        return immutableSortedSet;
    }

    @GwtIncompatible(value="NavigableSet")
    ImmutableSortedSet<E> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public abstract UnmodifiableIterator<E> descendingIterator();

    abstract int indexOf(@Nullable Object var1);

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override
    Object writeReplace() {
        return new SerializedForm<E>(this.comparator, this.toArray());
    }

    private static class SerializedForm<E>
    implements Serializable {
        final Comparator<? super E> comparator;
        final Object[] elements;
        private static final long serialVersionUID = 0L;

        public SerializedForm(Comparator<? super E> comparator, Object[] objectArray) {
            this.comparator = comparator;
            this.elements = objectArray;
        }

        Object readResolve() {
            return ((Builder)new Builder<E>(this.comparator).add(this.elements)).build();
        }
    }

    public static final class Builder<E>
    extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;

        public Builder(Comparator<? super E> comparator) {
            this.comparator = Preconditions.checkNotNull(comparator);
        }

        @Override
        public Builder<E> add(E e) {
            super.add((Object)e);
            return this;
        }

        @Override
        public Builder<E> add(E ... EArray) {
            super.add((Object[])EArray);
            return this;
        }

        @Override
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable)iterable);
            return this;
        }

        @Override
        public Builder<E> addAll(Iterator<? extends E> iterator2) {
            super.addAll((Iterator)iterator2);
            return this;
        }

        @Override
        public ImmutableSortedSet<E> build() {
            Object[] objectArray = this.contents;
            ImmutableSortedSet<Object> immutableSortedSet = ImmutableSortedSet.construct(this.comparator, this.size, objectArray);
            this.size = immutableSortedSet.size();
            return immutableSortedSet;
        }
    }
}

