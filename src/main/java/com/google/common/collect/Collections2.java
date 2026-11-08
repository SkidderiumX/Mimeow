/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public class Collections2 {
    static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");

    private Collections2() {
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof FilteredCollection) {
            return ((FilteredCollection)collection).createCombined(predicate);
        }
        return new FilteredCollection<E>(Preconditions.checkNotNull(collection), Preconditions.checkNotNull(predicate));
    }

    static boolean safeContains(Collection<?> collection, @Nullable Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(object);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    static boolean safeRemove(Collection<?> collection, @Nullable Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(object);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection<F, T>(collection, function);
    }

    static boolean containsAllImpl(Collection<?> collection, Collection<?> collection2) {
        return Iterables.all(collection2, Predicates.in(collection));
    }

    static String toStringImpl(final Collection<?> collection) {
        StringBuilder stringBuilder = Collections2.newStringBuilderForCollection(collection.size()).append('[');
        STANDARD_JOINER.appendTo(stringBuilder, Iterables.transform(collection, new Function<Object, Object>(){

            @Override
            public Object apply(Object object) {
                return object == collection ? "(this Collection)" : object;
            }
        }));
        return stringBuilder.append(']').toString();
    }

    static StringBuilder newStringBuilderForCollection(int n) {
        CollectPreconditions.checkNonnegative(n, "size");
        return new StringBuilder((int)Math.min((long)n * 8L, 0x40000000L));
    }

    static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection)iterable;
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return Collections2.orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection<E>(iterable, comparator);
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new PermutationCollection<E>(ImmutableList.copyOf(collection));
    }

    private static boolean isPermutation(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        HashMultiset<?> hashMultiset = HashMultiset.create(list);
        HashMultiset<?> hashMultiset2 = HashMultiset.create(list2);
        return hashMultiset.equals(hashMultiset2);
    }

    private static boolean isPositiveInt(long l) {
        return l >= 0L && l <= Integer.MAX_VALUE;
    }

    private static class PermutationIterator<E>
    extends AbstractIterator<List<E>> {
        final List<E> list;
        final int[] c;
        final int[] o;
        int j;

        PermutationIterator(List<E> list) {
            this.list = new ArrayList<E>(list);
            int n = list.size();
            this.c = new int[n];
            this.o = new int[n];
            Arrays.fill(this.c, 0);
            Arrays.fill(this.o, 1);
            this.j = Integer.MAX_VALUE;
        }

        @Override
        protected List<E> computeNext() {
            if (this.j <= 0) {
                return (List)this.endOfData();
            }
            ImmutableList<E> immutableList = ImmutableList.copyOf(this.list);
            this.calculateNextPermutation();
            return immutableList;
        }

        void calculateNextPermutation() {
            block4: {
                int n;
                this.j = this.list.size() - 1;
                int n2 = 0;
                if (this.j == -1) {
                    return;
                }
                while (true) {
                    if ((n = this.c[this.j] + this.o[this.j]) < 0) {
                        this.switchDirection();
                        continue;
                    }
                    if (n != this.j + 1) break;
                    if (this.j != 0) {
                        ++n2;
                        this.switchDirection();
                        continue;
                    }
                    break block4;
                    break;
                }
                Collections.swap(this.list, this.j - this.c[this.j] + n2, this.j - n + n2);
                this.c[this.j] = n;
            }
        }

        void switchDirection() {
            this.o[this.j] = -this.o[this.j];
            --this.j;
        }
    }

    private static final class PermutationCollection<E>
    extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;

        PermutationCollection(ImmutableList<E> immutableList) {
            this.inputList = immutableList;
        }

        @Override
        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Iterator<List<E>> iterator() {
            return new PermutationIterator<E>(this.inputList);
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (object instanceof List) {
                List list = (List)object;
                return Collections2.isPermutation(this.inputList, list);
            }
            return false;
        }

        @Override
        public String toString() {
            return "permutations(" + this.inputList + ")";
        }
    }

    private static final class OrderedPermutationIterator<E>
    extends AbstractIterator<List<E>> {
        List<E> nextPermutation;
        final Comparator<? super E> comparator;

        OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator) {
            this.nextPermutation = Lists.newArrayList(list);
            this.comparator = comparator;
        }

        @Override
        protected List<E> computeNext() {
            if (this.nextPermutation == null) {
                return (List)this.endOfData();
            }
            ImmutableList<E> immutableList = ImmutableList.copyOf(this.nextPermutation);
            this.calculateNextPermutation();
            return immutableList;
        }

        void calculateNextPermutation() {
            int n = this.findNextJ();
            if (n == -1) {
                this.nextPermutation = null;
                return;
            }
            int n2 = this.findNextL(n);
            Collections.swap(this.nextPermutation, n, n2);
            int n3 = this.nextPermutation.size();
            Collections.reverse(this.nextPermutation.subList(n + 1, n3));
        }

        int findNextJ() {
            for (int i = this.nextPermutation.size() - 2; i >= 0; --i) {
                if (this.comparator.compare(this.nextPermutation.get(i), this.nextPermutation.get(i + 1)) >= 0) continue;
                return i;
            }
            return -1;
        }

        int findNextL(int n) {
            E e = this.nextPermutation.get(n);
            for (int i = this.nextPermutation.size() - 1; i > n; --i) {
                if (this.comparator.compare(e, this.nextPermutation.get(i)) >= 0) continue;
                return i;
            }
            throw new AssertionError((Object)"this statement should be unreachable");
        }
    }

    private static final class OrderedPermutationCollection<E>
    extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;
        final Comparator<? super E> comparator;
        final int size;

        OrderedPermutationCollection(Iterable<E> iterable, Comparator<? super E> comparator) {
            this.inputList = Ordering.from(comparator).immutableSortedCopy(iterable);
            this.comparator = comparator;
            this.size = OrderedPermutationCollection.calculateSize(this.inputList, comparator);
        }

        private static <E> int calculateSize(List<E> list, Comparator<? super E> comparator) {
            long l = 1L;
            int n = 1;
            int n2 = 1;
            while (n < list.size()) {
                int n3 = comparator.compare(list.get(n - 1), list.get(n));
                if (n3 < 0) {
                    l *= LongMath.binomial(n, n2);
                    n2 = 0;
                    if (!Collections2.isPositiveInt(l)) {
                        return Integer.MAX_VALUE;
                    }
                }
                ++n;
                ++n2;
            }
            if (!Collections2.isPositiveInt(l *= LongMath.binomial(n, n2))) {
                return Integer.MAX_VALUE;
            }
            return (int)l;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator<E>(this.inputList, this.comparator);
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (object instanceof List) {
                List list = (List)object;
                return Collections2.isPermutation(this.inputList, list);
            }
            return false;
        }

        @Override
        public String toString() {
            return "orderedPermutationCollection(" + this.inputList + ")";
        }
    }

    public static class TransformedCollection<F, T>
    extends AbstractCollection<T> {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;

        TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.fromCollection = Preconditions.checkNotNull(collection);
            this.function = Preconditions.checkNotNull(function);
        }

        @Override
        public void clear() {
            this.fromCollection.clear();
        }

        @Override
        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        @Override
        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        @Override
        public int size() {
            return this.fromCollection.size();
        }
    }

    public static class FilteredCollection<E>
    extends AbstractCollection<E> {
        final Collection<E> unfiltered;
        final Predicate<? super E> predicate;

        FilteredCollection(Collection<E> collection, Predicate<? super E> predicate) {
            this.unfiltered = collection;
            this.predicate = predicate;
        }

        FilteredCollection<E> createCombined(Predicate<? super E> predicate) {
            return new FilteredCollection<E>(this.unfiltered, Predicates.and(this.predicate, predicate));
        }

        @Override
        public boolean add(E e) {
            Preconditions.checkArgument(this.predicate.apply(e));
            return this.unfiltered.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            for (E e : collection) {
                Preconditions.checkArgument(this.predicate.apply(e));
            }
            return this.unfiltered.addAll(collection);
        }

        @Override
        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (Collections2.safeContains(this.unfiltered, object)) {
                Object object2 = object;
                return this.predicate.apply(object2);
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return Collections2.containsAllImpl(this, collection);
        }

        @Override
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }

        @Override
        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override
        public boolean remove(Object object) {
            return this.contains(object) && this.unfiltered.remove(object);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in(collection)));
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.not(Predicates.in(collection))));
        }

        @Override
        public int size() {
            return Iterators.size(this.iterator());
        }

        @Override
        public Object[] toArray() {
            return Lists.newArrayList(this.iterator()).toArray();
        }

        @Override
        public <T> T[] toArray(T[] TArray) {
            return Lists.newArrayList(this.iterator()).toArray(TArray);
        }
    }
}

