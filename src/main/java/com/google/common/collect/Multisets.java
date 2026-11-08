/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TransformedIterator;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableSortedMultiset;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public class Multisets {
    private static final Ordering<Multiset.Entry<?>> DECREASING_COUNT_ORDERING = new Ordering<Multiset.Entry<?>>(){

        @Override
        public int compare(Multiset.Entry<?> entry, Multiset.Entry<?> entry2) {
            return Ints.compare(entry2.getCount(), entry.getCount());
        }
    };

    private Multisets() {
    }

    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        if (multiset instanceof UnmodifiableMultiset || multiset instanceof ImmutableMultiset) {
            Multiset<? extends E> multiset2 = multiset;
            return multiset2;
        }
        return new UnmodifiableMultiset<E>(Preconditions.checkNotNull(multiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> immutableMultiset) {
        return Preconditions.checkNotNull(immutableMultiset);
    }

    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset<E>(Preconditions.checkNotNull(sortedMultiset));
    }

    public static <E> Multiset.Entry<E> immutableEntry(@Nullable E e, int n) {
        return new ImmutableEntry<E>(e, n);
    }

    @Beta
    public static <E> Multiset<E> filter(Multiset<E> multiset, Predicate<? super E> predicate) {
        if (multiset instanceof FilteredMultiset) {
            FilteredMultiset filteredMultiset = (FilteredMultiset)multiset;
            Predicate<? super E> predicate2 = Predicates.and(filteredMultiset.predicate, predicate);
            return new FilteredMultiset<E>(filteredMultiset.unfiltered, predicate2);
        }
        return new FilteredMultiset<E>(multiset, predicate);
    }

    static int inferDistinctElements(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset)iterable).elementSet().size();
        }
        return 11;
    }

    @Beta
    public static <E> Multiset<E> union(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>(){

            @Override
            public boolean contains(@Nullable Object object) {
                return multiset.contains(object) || multiset2.contains(object);
            }

            @Override
            public boolean isEmpty() {
                return multiset.isEmpty() && multiset2.isEmpty();
            }

            @Override
            public int count(Object object) {
                return Math.max(multiset.count(object), multiset2.count(object));
            }

            @Override
            Set<E> createElementSet() {
                return Sets.union(multiset.elementSet(), multiset2.elementSet());
            }

            @Override
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator iterator2 = multiset.entrySet().iterator();
                final Iterator iterator3 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>(){

                    @Override
                    protected Multiset.Entry<E> computeNext() {
                        if (iterator2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry)iterator2.next();
                            Object e = entry.getElement();
                            int n = Math.max(entry.getCount(), multiset2.count(e));
                            return Multisets.immutableEntry(e, n);
                        }
                        while (iterator3.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry)iterator3.next();
                            Object e = entry.getElement();
                            if (multiset.contains(e)) continue;
                            return Multisets.immutableEntry(e, entry.getCount());
                        }
                        return (Multiset.Entry)this.endOfData();
                    }
                };
            }

            @Override
            int distinctElements() {
                return this.elementSet().size();
            }
        };
    }

    public static <E> Multiset<E> intersection(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>(){

            @Override
            public int count(Object object) {
                int n = multiset.count(object);
                return n == 0 ? 0 : Math.min(n, multiset2.count(object));
            }

            @Override
            Set<E> createElementSet() {
                return Sets.intersection(multiset.elementSet(), multiset2.elementSet());
            }

            @Override
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator iterator2 = multiset.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>(){

                    @Override
                    protected Multiset.Entry<E> computeNext() {
                        while (iterator2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry)iterator2.next();
                            Object e = entry.getElement();
                            int n = Math.min(entry.getCount(), multiset2.count(e));
                            if (n <= 0) continue;
                            return Multisets.immutableEntry(e, n);
                        }
                        return (Multiset.Entry)this.endOfData();
                    }
                };
            }

            @Override
            int distinctElements() {
                return this.elementSet().size();
            }
        };
    }

    @Beta
    public static <E> Multiset<E> sum(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>(){

            @Override
            public boolean contains(@Nullable Object object) {
                return multiset.contains(object) || multiset2.contains(object);
            }

            @Override
            public boolean isEmpty() {
                return multiset.isEmpty() && multiset2.isEmpty();
            }

            @Override
            public int size() {
                return multiset.size() + multiset2.size();
            }

            @Override
            public int count(Object object) {
                return multiset.count(object) + multiset2.count(object);
            }

            @Override
            Set<E> createElementSet() {
                return Sets.union(multiset.elementSet(), multiset2.elementSet());
            }

            @Override
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator iterator2 = multiset.entrySet().iterator();
                final Iterator iterator3 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>(){

                    @Override
                    protected Multiset.Entry<E> computeNext() {
                        if (iterator2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry)iterator2.next();
                            Object e = entry.getElement();
                            int n = entry.getCount() + multiset2.count(e);
                            return Multisets.immutableEntry(e, n);
                        }
                        while (iterator3.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry)iterator3.next();
                            Object e = entry.getElement();
                            if (multiset.contains(e)) continue;
                            return Multisets.immutableEntry(e, entry.getCount());
                        }
                        return (Multiset.Entry)this.endOfData();
                    }
                };
            }

            @Override
            int distinctElements() {
                return this.elementSet().size();
            }
        };
    }

    @Beta
    public static <E> Multiset<E> difference(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>(){

            @Override
            public int count(@Nullable Object object) {
                int n = multiset.count(object);
                return n == 0 ? 0 : Math.max(0, n - multiset2.count(object));
            }

            @Override
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator iterator2 = multiset.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>(){

                    @Override
                    protected Multiset.Entry<E> computeNext() {
                        while (iterator2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry)iterator2.next();
                            Object e = entry.getElement();
                            int n = entry.getCount() - multiset2.count(e);
                            if (n <= 0) continue;
                            return Multisets.immutableEntry(e, n);
                        }
                        return (Multiset.Entry)this.endOfData();
                    }
                };
            }

            @Override
            int distinctElements() {
                return Iterators.size(this.entryIterator());
            }
        };
    }

    public static boolean containsOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        for (Multiset.Entry<?> entry : multiset2.entrySet()) {
            int n = multiset.count(entry.getElement());
            if (n >= entry.getCount()) continue;
            return false;
        }
        return true;
    }

    public static boolean retainOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        return Multisets.retainOccurrencesImpl(multiset, multiset2);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator<Multiset.Entry<E>> iterator2 = multiset.entrySet().iterator();
        boolean bl = false;
        while (iterator2.hasNext()) {
            Multiset.Entry<E> entry = iterator2.next();
            int n = multiset2.count(entry.getElement());
            if (n == 0) {
                iterator2.remove();
                bl = true;
                continue;
            }
            if (n >= entry.getCount()) continue;
            multiset.setCount(entry.getElement(), n);
            bl = true;
        }
        return bl;
    }

    public static boolean removeOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        return Multisets.removeOccurrencesImpl(multiset, multiset2);
    }

    private static <E> boolean removeOccurrencesImpl(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        boolean bl = false;
        Iterator<Multiset.Entry<E>> iterator2 = multiset.entrySet().iterator();
        while (iterator2.hasNext()) {
            Multiset.Entry<E> entry = iterator2.next();
            int n = multiset2.count(entry.getElement());
            if (n >= entry.getCount()) {
                iterator2.remove();
                bl = true;
                continue;
            }
            if (n <= 0) continue;
            multiset.remove(entry.getElement(), n);
            bl = true;
        }
        return bl;
    }

    static boolean equalsImpl(Multiset<?> multiset, @Nullable Object object) {
        if (object == multiset) {
            return true;
        }
        if (object instanceof Multiset) {
            Multiset multiset2 = (Multiset)object;
            if (multiset.size() != multiset2.size() || multiset.entrySet().size() != multiset2.entrySet().size()) {
                return false;
            }
            for (Multiset.Entry entry : multiset2.entrySet()) {
                if (multiset.count(entry.getElement()) == entry.getCount()) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    static <E> boolean addAllImpl(Multiset<E> multiset, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof Multiset) {
            Multiset<E> multiset2 = Multisets.cast(collection);
            for (Multiset.Entry<E> entry : multiset2.entrySet()) {
                multiset.add(entry.getElement(), entry.getCount());
            }
        } else {
            Iterators.addAll(multiset, collection.iterator());
        }
        return true;
    }

    static boolean removeAllImpl(Multiset<?> multiset, Collection<?> collection) {
        Collection<?> collection2 = collection instanceof Multiset ? ((Multiset)collection).elementSet() : collection;
        return multiset.elementSet().removeAll(collection2);
    }

    static boolean retainAllImpl(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        Collection<?> collection2 = collection instanceof Multiset ? ((Multiset)collection).elementSet() : collection;
        return multiset.elementSet().retainAll(collection2);
    }

    static <E> int setCountImpl(Multiset<E> multiset, E e, int n) {
        CollectPreconditions.checkNonnegative(n, "count");
        int n2 = multiset.count(e);
        int n3 = n - n2;
        if (n3 > 0) {
            multiset.add(e, n3);
        } else if (n3 < 0) {
            multiset.remove(e, -n3);
        }
        return n2;
    }

    static <E> boolean setCountImpl(Multiset<E> multiset, E e, int n, int n2) {
        CollectPreconditions.checkNonnegative(n, "oldCount");
        CollectPreconditions.checkNonnegative(n2, "newCount");
        if (multiset.count(e) == n) {
            multiset.setCount(e, n2);
            return true;
        }
        return false;
    }

    static <E> Iterator<E> iteratorImpl(Multiset<E> multiset) {
        return new MultisetIteratorImpl<E>(multiset, multiset.entrySet().iterator());
    }

    static int sizeImpl(Multiset<?> multiset) {
        long l = 0L;
        for (Multiset.Entry<?> entry : multiset.entrySet()) {
            l += (long)entry.getCount();
        }
        return Ints.saturatedCast(l);
    }

    static <T> Multiset<T> cast(Iterable<T> iterable) {
        return (Multiset)iterable;
    }

    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        ImmutableList<Multiset.Entry<E>> immutableList = DECREASING_COUNT_ORDERING.immutableSortedCopy(multiset.entrySet());
        return ImmutableMultiset.copyFromEntries(immutableList);
    }

    public static final class MultisetIteratorImpl<E>
    implements Iterator<E> {
        private final Multiset<E> multiset;
        private final Iterator<Multiset.Entry<E>> entryIterator;
        private Multiset.Entry<E> currentEntry;
        private int laterCount;
        private int totalCount;
        private boolean canRemove;

        MultisetIteratorImpl(Multiset<E> multiset, Iterator<Multiset.Entry<E>> iterator2) {
            this.multiset = multiset;
            this.entryIterator = iterator2;
        }

        @Override
        public boolean hasNext() {
            return this.laterCount > 0 || this.entryIterator.hasNext();
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.laterCount == 0) {
                this.currentEntry = this.entryIterator.next();
                this.totalCount = this.laterCount = this.currentEntry.getCount();
            }
            --this.laterCount;
            this.canRemove = true;
            return this.currentEntry.getElement();
        }

        @Override
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.totalCount == 1) {
                this.entryIterator.remove();
            } else {
                this.multiset.remove(this.currentEntry.getElement());
            }
            --this.totalCount;
            this.canRemove = false;
        }
    }

    public static abstract class EntrySet<E>
    extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        EntrySet() {
        }

        abstract Multiset<E> multiset();

        @Override
        public boolean contains(@Nullable Object object) {
            if (object instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry)object;
                if (entry.getCount() <= 0) {
                    return false;
                }
                int n = this.multiset().count(entry.getElement());
                return n == entry.getCount();
            }
            return false;
        }

        @Override
        public boolean remove(Object object) {
            if (object instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry)object;
                Object e = entry.getElement();
                int n = entry.getCount();
                if (n != 0) {
                    Multiset multiset = this.multiset();
                    return multiset.setCount(e, n, 0);
                }
            }
            return false;
        }

        @Override
        public void clear() {
            this.multiset().clear();
        }
    }

    public static abstract class ElementSet<E>
    extends Sets.ImprovedAbstractSet<E> {
        ElementSet() {
        }

        abstract Multiset<E> multiset();

        @Override
        public void clear() {
            this.multiset().clear();
        }

        @Override
        public boolean contains(Object object) {
            return this.multiset().contains(object);
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return this.multiset().containsAll(collection);
        }

        @Override
        public boolean isEmpty() {
            return this.multiset().isEmpty();
        }

        @Override
        public Iterator<E> iterator() {
            return new TransformedIterator<Multiset.Entry<E>, E>(this.multiset().entrySet().iterator()){

                @Override
                E transform(Multiset.Entry<E> entry) {
                    return entry.getElement();
                }
            };
        }

        @Override
        public boolean remove(Object object) {
            int n = this.multiset().count(object);
            if (n > 0) {
                this.multiset().remove(object, n);
                return true;
            }
            return false;
        }

        @Override
        public int size() {
            return this.multiset().entrySet().size();
        }
    }

    public static abstract class AbstractEntry<E>
    implements Multiset.Entry<E> {
        AbstractEntry() {
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry)object;
                return this.getCount() == entry.getCount() && Objects.equal(this.getElement(), entry.getElement());
            }
            return false;
        }

        @Override
        public int hashCode() {
            Object e = this.getElement();
            return (e == null ? 0 : e.hashCode()) ^ this.getCount();
        }

        @Override
        public String toString() {
            String string = String.valueOf(this.getElement());
            int n = this.getCount();
            return n == 1 ? string : string + " x " + n;
        }
    }

    private static final class FilteredMultiset<E>
    extends AbstractMultiset<E> {
        final Multiset<E> unfiltered;
        final Predicate<? super E> predicate;

        FilteredMultiset(Multiset<E> multiset, Predicate<? super E> predicate) {
            this.unfiltered = Preconditions.checkNotNull(multiset);
            this.predicate = Preconditions.checkNotNull(predicate);
        }

        @Override
        public UnmodifiableIterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override
        Set<E> createElementSet() {
            return Sets.filter(this.unfiltered.elementSet(), this.predicate);
        }

        @Override
        Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), new Predicate<Multiset.Entry<E>>(){

                @Override
                public boolean apply(Multiset.Entry<E> entry) {
                    return FilteredMultiset.this.predicate.apply(entry.getElement());
                }
            });
        }

        @Override
        Iterator<Multiset.Entry<E>> entryIterator() {
            throw new AssertionError((Object)"should never be called");
        }

        @Override
        int distinctElements() {
            return this.elementSet().size();
        }

        @Override
        public int count(@Nullable Object object) {
            int n = this.unfiltered.count(object);
            if (n > 0) {
                Object object2 = object;
                return this.predicate.apply(object2) ? n : 0;
            }
            return 0;
        }

        @Override
        public int add(@Nullable E e, int n) {
            Preconditions.checkArgument(this.predicate.apply(e), "Element %s does not match predicate %s", e, this.predicate);
            return this.unfiltered.add(e, n);
        }

        @Override
        public int remove(@Nullable Object object, int n) {
            CollectPreconditions.checkNonnegative(n, "occurrences");
            if (n == 0) {
                return this.count(object);
            }
            return this.contains(object) ? this.unfiltered.remove(object, n) : 0;
        }

        @Override
        public void clear() {
            this.elementSet().clear();
        }
    }

    public static final class ImmutableEntry<E>
    extends AbstractEntry<E>
    implements Serializable {
        @Nullable
        final E element;
        final int count;
        private static final long serialVersionUID = 0L;

        ImmutableEntry(@Nullable E e, int n) {
            this.element = e;
            this.count = n;
            CollectPreconditions.checkNonnegative(n, "count");
        }

        @Override
        @Nullable
        public E getElement() {
            return this.element;
        }

        @Override
        public int getCount() {
            return this.count;
        }
    }

    public static class UnmodifiableMultiset<E>
    extends ForwardingMultiset<E>
    implements Serializable {
        final Multiset<? extends E> delegate;
        transient Set<E> elementSet;
        transient Set<Multiset.Entry<E>> entrySet;
        private static final long serialVersionUID = 0L;

        UnmodifiableMultiset(Multiset<? extends E> multiset) {
            this.delegate = multiset;
        }

        @Override
        protected Multiset<E> delegate() {
            return this.delegate;
        }

        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            return set == null ? (this.elementSet = this.createElementSet()) : set;
        }

        @Override
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<Multiset.Entry<E>>> set = this.entrySet;
            return set == null ? (this.entrySet = Collections.unmodifiableSet(this.delegate.entrySet())) : set;
        }

        @Override
        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        @Override
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int add(E e, int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int remove(Object object, int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int setCount(E e, int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean setCount(E e, int n, int n2) {
            throw new UnsupportedOperationException();
        }
    }
}

