/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.CartesianList;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.Platform;
import com.google.common.collect.Synchronized;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class Sets {
    private Sets() {
    }

    @GwtCompatible(serializable=true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E e, E ... EArray) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(e, EArray));
    }

    @GwtCompatible(serializable=true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet)iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            if (collection.isEmpty()) {
                return ImmutableSet.of();
            }
            return ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
        }
        Iterator<E> iterator2 = iterable.iterator();
        if (iterator2.hasNext()) {
            EnumSet<Enum> enumSet = EnumSet.of((Enum)iterator2.next());
            Iterators.addAll(enumSet, iterator2);
            return ImmutableEnumSet.asImmutable(enumSet);
        }
        return ImmutableSet.of();
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> clazz) {
        EnumSet<E> enumSet = EnumSet.noneOf(clazz);
        Iterables.addAll(enumSet, iterable);
        return enumSet;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet();
    }

    public static <E> HashSet<E> newHashSet(E ... EArray) {
        HashSet<E> hashSet = Sets.newHashSetWithExpectedSize(EArray.length);
        Collections.addAll(hashSet, EArray);
        return hashSet;
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int n) {
        return new HashSet(Maps.capacity(n));
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet<E>(Collections2.cast(iterable)) : Sets.newHashSet(iterable.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> iterator2) {
        HashSet<E> hashSet = Sets.newHashSet();
        Iterators.addAll(hashSet, iterator2);
        return hashSet;
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Sets.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> iterable) {
        Set<E> set = Sets.newConcurrentHashSet();
        Iterables.addAll(set, iterable);
        return set;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int n) {
        return new LinkedHashSet(Maps.capacity(n));
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<E>(Collections2.cast(iterable));
        }
        LinkedHashSet<E> linkedHashSet = Sets.newLinkedHashSet();
        Iterables.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet();
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> iterable) {
        TreeSet<E> treeSet = Sets.newTreeSet();
        Iterables.addAll(treeSet, iterable);
        return treeSet;
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
        return new TreeSet<E>(Preconditions.checkNotNull(comparator));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Sets.newSetFromMap(Maps.newIdentityHashMap());
    }

    @GwtIncompatible(value="CopyOnWriteArraySet")
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet();
    }

    @GwtIncompatible(value="CopyOnWriteArraySet")
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> iterable) {
        Collection<? extends E> collection = iterable instanceof Collection ? Collections2.cast(iterable) : Lists.newArrayList(iterable);
        return new CopyOnWriteArraySet<E>(collection);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet)collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        Class clazz = ((Enum)collection.iterator().next()).getDeclaringClass();
        return Sets.makeComplementByHand(collection, clazz);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> clazz) {
        Preconditions.checkNotNull(collection);
        return collection instanceof EnumSet ? EnumSet.complementOf((EnumSet)collection) : Sets.makeComplementByHand(collection, clazz);
    }

    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> collection, Class<E> clazz) {
        EnumSet<E> enumSet = EnumSet.allOf(clazz);
        enumSet.removeAll(collection);
        return enumSet;
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Platform.newSetFromMap(map);
    }

    public static <E> SetView<E> union(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        final SetView<? extends E> setView = Sets.difference(set2, set);
        return new SetView<E>(){

            @Override
            public int size() {
                return set.size() + setView.size();
            }

            @Override
            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            @Override
            public Iterator<E> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(set.iterator(), setView.iterator()));
            }

            @Override
            public boolean contains(Object object) {
                return set.contains(object) || set2.contains(object);
            }

            @Override
            public <S extends Set<E>> S copyInto(S s) {
                s.addAll(set);
                s.addAll(set2);
                return s;
            }

            @Override
            public ImmutableSet<E> immutableCopy() {
                return ((ImmutableSet.Builder)((ImmutableSet.Builder)new ImmutableSet.Builder().addAll((Iterable)set)).addAll((Iterable)set2)).build();
            }
        };
    }

    public static <E> SetView<E> intersection(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        final Predicate<?> predicate = Predicates.in(set2);
        return new SetView<E>(){

            @Override
            public Iterator<E> iterator() {
                return Iterators.filter(set.iterator(), predicate);
            }

            @Override
            public int size() {
                return Iterators.size(this.iterator());
            }

            @Override
            public boolean isEmpty() {
                return !this.iterator().hasNext();
            }

            @Override
            public boolean contains(Object object) {
                return set.contains(object) && set2.contains(object);
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }
        };
    }

    public static <E> SetView<E> difference(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        final Predicate<?> predicate = Predicates.not(Predicates.in(set2));
        return new SetView<E>(){

            @Override
            public Iterator<E> iterator() {
                return Iterators.filter(set.iterator(), predicate);
            }

            @Override
            public int size() {
                return Iterators.size(this.iterator());
            }

            @Override
            public boolean isEmpty() {
                return set2.containsAll(set);
            }

            @Override
            public boolean contains(Object object) {
                return set.contains(object) && !set2.contains(object);
            }
        };
    }

    public static <E> SetView<E> symmetricDifference(Set<? extends E> set, Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return Sets.difference(Sets.union(set, set2), Sets.intersection(set, set2));
    }

    public static <E> Set<E> filter(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return Sets.filter((SortedSet)set, predicate);
        }
        if (set instanceof FilteredSet) {
            FilteredSet filteredSet = (FilteredSet)set;
            Predicate<? super E> predicate2 = Predicates.and(filteredSet.predicate, predicate);
            return new FilteredSet<E>((Set)filteredSet.unfiltered, predicate2);
        }
        return new FilteredSet<E>(Preconditions.checkNotNull(set), Preconditions.checkNotNull(predicate));
    }

    public static <E> SortedSet<E> filter(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return Platform.setsFilterSortedSet(sortedSet, predicate);
    }

    static <E> SortedSet<E> filterSortedIgnoreNavigable(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (sortedSet instanceof FilteredSet) {
            FilteredSet filteredSet = (FilteredSet)((Object)sortedSet);
            Predicate<? super E> predicate2 = Predicates.and(filteredSet.predicate, predicate);
            return new FilteredSortedSet<E>((SortedSet)filteredSet.unfiltered, predicate2);
        }
        return new FilteredSortedSet<E>(Preconditions.checkNotNull(sortedSet), Preconditions.checkNotNull(predicate));
    }

    @GwtIncompatible(value="NavigableSet")
    public static <E> NavigableSet<E> filter(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        if (navigableSet instanceof FilteredSet) {
            FilteredSet filteredSet = (FilteredSet)((Object)navigableSet);
            Predicate<? super E> predicate2 = Predicates.and(filteredSet.predicate, predicate);
            return new FilteredNavigableSet<E>((NavigableSet)filteredSet.unfiltered, predicate2);
        }
        return new FilteredNavigableSet<E>(Preconditions.checkNotNull(navigableSet), Preconditions.checkNotNull(predicate));
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> list) {
        return CartesianSet.create(list);
    }

    public static <B> Set<List<B>> cartesianProduct(Set<? extends B> ... setArray) {
        return Sets.cartesianProduct(Arrays.asList(setArray));
    }

    @GwtCompatible(serializable=false)
    public static <E> Set<Set<E>> powerSet(Set<E> set) {
        return new PowerSet<E>(set);
    }

    static int hashCodeImpl(Set<?> set) {
        int n = 0;
        for (Object obj : set) {
            n += obj != null ? obj.hashCode() : 0;
            n = ~(~n);
        }
        return n;
    }

    static boolean equalsImpl(Set<?> set, @Nullable Object object) {
        if (set == object) {
            return true;
        }
        if (object instanceof Set) {
            Set set2 = (Set)object;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            }
            catch (NullPointerException nullPointerException) {
                return false;
            }
            catch (ClassCastException classCastException) {
                return false;
            }
        }
        return false;
    }

    @GwtIncompatible(value="NavigableSet")
    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        if (navigableSet instanceof ImmutableSortedSet || navigableSet instanceof UnmodifiableNavigableSet) {
            return navigableSet;
        }
        return new UnmodifiableNavigableSet<E>(navigableSet);
    }

    @GwtIncompatible(value="NavigableSet")
    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> navigableSet) {
        return Synchronized.navigableSet(navigableSet);
    }

    static boolean removeAllImpl(Set<?> set, Iterator<?> iterator2) {
        boolean bl = false;
        while (iterator2.hasNext()) {
            bl |= set.remove(iterator2.next());
        }
        return bl;
    }

    static boolean removeAllImpl(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset)collection).elementSet();
        }
        if (collection instanceof Set && collection.size() > set.size()) {
            return Iterators.removeAll(set.iterator(), collection);
        }
        return Sets.removeAllImpl(set, collection.iterator());
    }

    @GwtIncompatible(value="NavigableSet")
    public static class DescendingSet<E>
    extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> forward;

        DescendingSet(NavigableSet<E> navigableSet) {
            this.forward = navigableSet;
        }

        @Override
        protected NavigableSet<E> delegate() {
            return this.forward;
        }

        @Override
        public E lower(E e) {
            return this.forward.higher(e);
        }

        @Override
        public E floor(E e) {
            return this.forward.ceiling(e);
        }

        @Override
        public E ceiling(E e) {
            return this.forward.floor(e);
        }

        @Override
        public E higher(E e) {
            return this.forward.lower(e);
        }

        @Override
        public E pollFirst() {
            return this.forward.pollLast();
        }

        @Override
        public E pollLast() {
            return this.forward.pollFirst();
        }

        @Override
        public NavigableSet<E> descendingSet() {
            return this.forward;
        }

        @Override
        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }

        @Override
        public NavigableSet<E> subSet(E e, boolean bl, E e2, boolean bl2) {
            return this.forward.subSet(e2, bl2, e, bl).descendingSet();
        }

        @Override
        public NavigableSet<E> headSet(E e, boolean bl) {
            return this.forward.tailSet(e, bl).descendingSet();
        }

        @Override
        public NavigableSet<E> tailSet(E e, boolean bl) {
            return this.forward.headSet(e, bl).descendingSet();
        }

        @Override
        public Comparator<? super E> comparator() {
            Comparator comparator = this.forward.comparator();
            if (comparator == null) {
                return Ordering.natural().reverse();
            }
            return DescendingSet.reverse(comparator);
        }

        private static <T> Ordering<T> reverse(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override
        public E first() {
            return this.forward.last();
        }

        @Override
        public SortedSet<E> headSet(E e) {
            return this.standardHeadSet(e);
        }

        @Override
        public E last() {
            return this.forward.first();
        }

        @Override
        public SortedSet<E> subSet(E e, E e2) {
            return this.standardSubSet(e, e2);
        }

        @Override
        public SortedSet<E> tailSet(E e) {
            return this.standardTailSet(e);
        }

        @Override
        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }

        @Override
        public Object[] toArray() {
            return this.standardToArray();
        }

        @Override
        public <T> T[] toArray(T[] TArray) {
            return this.standardToArray(TArray);
        }

        @Override
        public String toString() {
            return this.standardToString();
        }
    }

    @GwtIncompatible(value="NavigableSet")
    public static final class UnmodifiableNavigableSet<E>
    extends ForwardingSortedSet<E>
    implements NavigableSet<E>,
    Serializable {
        private final NavigableSet<E> delegate;
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private static final long serialVersionUID = 0L;

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = Preconditions.checkNotNull(navigableSet);
        }

        @Override
        protected SortedSet<E> delegate() {
            return Collections.unmodifiableSortedSet(this.delegate);
        }

        @Override
        public E lower(E e) {
            return this.delegate.lower(e);
        }

        @Override
        public E floor(E e) {
            return this.delegate.floor(e);
        }

        @Override
        public E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        @Override
        public E higher(E e) {
            return this.delegate.higher(e);
        }

        @Override
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
            if (unmodifiableNavigableSet == null) {
                unmodifiableNavigableSet = this.descendingSet = new UnmodifiableNavigableSet<E>(this.delegate.descendingSet());
                unmodifiableNavigableSet.descendingSet = this;
            }
            return unmodifiableNavigableSet;
        }

        @Override
        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        @Override
        public NavigableSet<E> subSet(E e, boolean bl, E e2, boolean bl2) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(e, bl, e2, bl2));
        }

        @Override
        public NavigableSet<E> headSet(E e, boolean bl) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(e, bl));
        }

        @Override
        public NavigableSet<E> tailSet(E e, boolean bl) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(e, bl));
        }
    }

    private static final class PowerSet<E>
    extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> inputSet;

        PowerSet(Set<E> set) {
            ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
            int n = 0;
            for (E e : Preconditions.checkNotNull(set)) {
                builder.put(e, n++);
            }
            this.inputSet = builder.build();
            Preconditions.checkArgument(this.inputSet.size() <= 30, "Too many elements to create power set: %s > 30", this.inputSet.size());
        }

        @Override
        public int size() {
            return 1 << this.inputSet.size();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Iterator<Set<E>> iterator() {
            return new AbstractIndexedListIterator<Set<E>>(this.size()){

                @Override
                protected Set<E> get(int n) {
                    return new SubSet(PowerSet.this.inputSet, n);
                }
            };
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (object instanceof Set) {
                Set set = (Set)object;
                return ((AbstractCollection)((Object)this.inputSet.keySet())).containsAll(set);
            }
            return false;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof PowerSet) {
                PowerSet powerSet = (PowerSet)object;
                return this.inputSet.equals(powerSet.inputSet);
            }
            return super.equals(object);
        }

        @Override
        public int hashCode() {
            return ((ImmutableSet)this.inputSet.keySet()).hashCode() << this.inputSet.size() - 1;
        }

        @Override
        public String toString() {
            return "powerSet(" + this.inputSet + ")";
        }
    }

    private static final class SubSet<E>
    extends AbstractSet<E> {
        private final ImmutableMap<E, Integer> inputSet;
        private final int mask;

        SubSet(ImmutableMap<E, Integer> immutableMap, int n) {
            this.inputSet = immutableMap;
            this.mask = n;
        }

        @Override
        public Iterator<E> iterator() {
            return new UnmodifiableIterator<E>(){
                final ImmutableList<E> elements;
                int remainingSetBits;
                {
                    this.elements = ((ImmutableCollection)((Object)SubSet.this.inputSet.keySet())).asList();
                    this.remainingSetBits = SubSet.this.mask;
                }

                @Override
                public boolean hasNext() {
                    return this.remainingSetBits != 0;
                }

                @Override
                public E next() {
                    int n = Integer.numberOfTrailingZeros(this.remainingSetBits);
                    if (n == 32) {
                        throw new NoSuchElementException();
                    }
                    this.remainingSetBits &= ~(1 << n);
                    return this.elements.get(n);
                }
            };
        }

        @Override
        public int size() {
            return Integer.bitCount(this.mask);
        }

        @Override
        public boolean contains(@Nullable Object object) {
            Integer n = this.inputSet.get(object);
            return n != null && (this.mask & 1 << n) != 0;
        }
    }

    private static final class CartesianSet<E>
    extends ForwardingCollection<List<E>>
    implements Set<List<E>> {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;

        static <E> Set<List<E>> create(List<? extends Set<? extends E>> list) {
            ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
            for (Set<E> collection2 : list) {
                ImmutableSet<E> immutableSet = ImmutableSet.copyOf(collection2);
                if (immutableSet.isEmpty()) {
                    return ImmutableSet.of();
                }
                builder.add(immutableSet);
            }
            ImmutableCollection immutableCollection = builder.build();
            ImmutableList immutableList = new ImmutableList<List<E>>((ImmutableList)immutableCollection){
                final /* synthetic */ ImmutableList val$axes;
                {
                    this.val$axes = immutableList;
                }

                @Override
                public int size() {
                    return this.val$axes.size();
                }

                @Override
                public List<E> get(int n) {
                    return ((ImmutableSet)this.val$axes.get(n)).asList();
                }

                @Override
                boolean isPartialView() {
                    return true;
                }
            };
            return new CartesianSet(immutableCollection, new CartesianList(immutableList));
        }

        private CartesianSet(ImmutableList<ImmutableSet<E>> immutableList, CartesianList<E> cartesianList) {
            this.axes = immutableList;
            this.delegate = cartesianList;
        }

        @Override
        protected Collection<List<E>> delegate() {
            return this.delegate;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof CartesianSet) {
                CartesianSet cartesianSet = (CartesianSet)object;
                return this.axes.equals(cartesianSet.axes);
            }
            return super.equals(object);
        }

        @Override
        public int hashCode() {
            int n;
            int n2 = this.size() - 1;
            for (n = 0; n < this.axes.size(); ++n) {
                n2 *= 31;
                n2 = ~(~n2);
            }
            n = 1;
            for (Set set : this.axes) {
                n = 31 * n + this.size() / set.size() * set.hashCode();
                n = ~(~n);
            }
            return ~(~(n += n2));
        }
    }

    @GwtIncompatible(value="NavigableSet")
    private static class FilteredNavigableSet<E>
    extends FilteredSortedSet<E>
    implements NavigableSet<E> {
        FilteredNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
            super(navigableSet, predicate);
        }

        NavigableSet<E> unfiltered() {
            return (NavigableSet)this.unfiltered;
        }

        @Override
        @Nullable
        public E lower(E e) {
            return Iterators.getNext(this.headSet(e, false).descendingIterator(), null);
        }

        @Override
        @Nullable
        public E floor(E e) {
            return Iterators.getNext(this.headSet(e, true).descendingIterator(), null);
        }

        @Override
        public E ceiling(E e) {
            return Iterables.getFirst(this.tailSet(e, true), null);
        }

        @Override
        public E higher(E e) {
            return Iterables.getFirst(this.tailSet(e, false), null);
        }

        @Override
        public E pollFirst() {
            return Iterables.removeFirstMatching(this.unfiltered(), this.predicate);
        }

        @Override
        public E pollLast() {
            return Iterables.removeFirstMatching(this.unfiltered().descendingSet(), this.predicate);
        }

        @Override
        public NavigableSet<E> descendingSet() {
            return Sets.filter(this.unfiltered().descendingSet(), this.predicate);
        }

        @Override
        public Iterator<E> descendingIterator() {
            return Iterators.filter(this.unfiltered().descendingIterator(), this.predicate);
        }

        @Override
        public E last() {
            return this.descendingIterator().next();
        }

        @Override
        public NavigableSet<E> subSet(E e, boolean bl, E e2, boolean bl2) {
            return Sets.filter(this.unfiltered().subSet(e, bl, e2, bl2), this.predicate);
        }

        @Override
        public NavigableSet<E> headSet(E e, boolean bl) {
            return Sets.filter(this.unfiltered().headSet(e, bl), this.predicate);
        }

        @Override
        public NavigableSet<E> tailSet(E e, boolean bl) {
            return Sets.filter(this.unfiltered().tailSet(e, bl), this.predicate);
        }
    }

    private static class FilteredSortedSet<E>
    extends FilteredSet<E>
    implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        @Override
        public Comparator<? super E> comparator() {
            return ((SortedSet)this.unfiltered).comparator();
        }

        @Override
        public SortedSet<E> subSet(E e, E e2) {
            return new FilteredSortedSet<E>(((SortedSet)this.unfiltered).subSet(e, e2), this.predicate);
        }

        @Override
        public SortedSet<E> headSet(E e) {
            return new FilteredSortedSet<E>(((SortedSet)this.unfiltered).headSet(e), this.predicate);
        }

        @Override
        public SortedSet<E> tailSet(E e) {
            return new FilteredSortedSet<E>(((SortedSet)this.unfiltered).tailSet(e), this.predicate);
        }

        @Override
        public E first() {
            return this.iterator().next();
        }

        @Override
        public E last() {
            SortedSet sortedSet = (SortedSet)this.unfiltered;
            Object e;
            while (!this.predicate.apply(e = sortedSet.last())) {
                sortedSet = sortedSet.headSet(e);
            }
            return e;
        }
    }

    private static class FilteredSet<E>
    extends Collections2.FilteredCollection<E>
    implements Set<E> {
        FilteredSet(Set<E> set, Predicate<? super E> predicate) {
            super(set, predicate);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return Sets.equalsImpl(this, object);
        }

        @Override
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public static abstract class SetView<E>
    extends AbstractSet<E> {
        private SetView() {
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf(this);
        }

        public <S extends Set<E>> S copyInto(S s) {
            s.addAll(this);
            return s;
        }
    }

    public static abstract class ImprovedAbstractSet<E>
    extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return Sets.removeAllImpl(this, collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll(Preconditions.checkNotNull(collection));
        }
    }
}

