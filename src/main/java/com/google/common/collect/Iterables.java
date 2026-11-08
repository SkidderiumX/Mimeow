/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.TransformedIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class Iterables {
    private Iterables() {
    }

    public static <T> Iterable<T> unmodifiableIterable(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof UnmodifiableIterable || iterable instanceof ImmutableCollection) {
            return iterable;
        }
        return new UnmodifiableIterable(iterable);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> immutableCollection) {
        return Preconditions.checkNotNull(immutableCollection);
    }

    public static int size(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection)iterable).size() : Iterators.size(iterable.iterator());
    }

    public static boolean contains(Iterable<?> iterable, @Nullable Object object) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            return Collections2.safeContains(collection, object);
        }
        return Iterators.contains(iterable.iterator(), object);
    }

    public static boolean removeAll(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection)iterable).removeAll(Preconditions.checkNotNull(collection)) : Iterators.removeAll(iterable.iterator(), collection);
    }

    public static boolean retainAll(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection)iterable).retainAll(Preconditions.checkNotNull(collection)) : Iterators.retainAll(iterable.iterator(), collection);
    }

    public static <T> boolean removeIf(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (iterable instanceof RandomAccess && iterable instanceof List) {
            return Iterables.removeIfFromRandomAccessList((List)iterable, Preconditions.checkNotNull(predicate));
        }
        return Iterators.removeIf(iterable.iterator(), predicate);
    }

    private static <T> boolean removeIfFromRandomAccessList(List<T> list, Predicate<? super T> predicate) {
        int n;
        int n2 = 0;
        for (n = 0; n < list.size(); ++n) {
            T t = list.get(n);
            if (predicate.apply(t)) continue;
            if (n > n2) {
                try {
                    list.set(n2, t);
                }
                catch (UnsupportedOperationException unsupportedOperationException) {
                    Iterables.slowRemoveIfForRemainingElements(list, predicate, n2, n);
                    return true;
                }
            }
            ++n2;
        }
        list.subList(n2, list.size()).clear();
        return n != n2;
    }

    private static <T> void slowRemoveIfForRemainingElements(List<T> list, Predicate<? super T> predicate, int n, int n2) {
        int n3;
        for (n3 = list.size() - 1; n3 > n2; --n3) {
            if (!predicate.apply(list.get(n3))) continue;
            list.remove(n3);
        }
        for (n3 = n2 - 1; n3 >= n; --n3) {
            list.remove(n3);
        }
    }

    @Nullable
    static <T> T removeFirstMatching(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator<T> iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            T t = iterator2.next();
            if (!predicate.apply(t)) continue;
            iterator2.remove();
            return t;
        }
        return null;
    }

    public static boolean elementsEqual(Iterable<?> iterable, Iterable<?> iterable2) {
        if (iterable instanceof Collection && iterable2 instanceof Collection) {
            Collection collection = (Collection)iterable;
            Collection collection2 = (Collection)iterable2;
            if (collection.size() != collection2.size()) {
                return false;
            }
        }
        return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return Iterators.getOnlyElement(iterable.iterator());
    }

    @Nullable
    public static <T> T getOnlyElement(Iterable<? extends T> iterable, @Nullable T t) {
        return Iterators.getOnlyElement(iterable.iterator(), t);
    }

    @GwtIncompatible(value="Array.newInstance(Class, int)")
    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> clazz) {
        Collection<T> collection = Iterables.toCollection(iterable);
        T[] TArray = ObjectArrays.newArray(clazz, collection.size());
        return collection.toArray(TArray);
    }

    static Object[] toArray(Iterable<?> iterable) {
        return Iterables.toCollection(iterable).toArray();
    }

    private static <E> Collection<E> toCollection(Iterable<E> iterable) {
        return iterable instanceof Collection ? (ArrayList<E>)iterable : Lists.newArrayList(iterable.iterator());
    }

    public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            Collection<? extends T> collection2 = Collections2.cast(iterable);
            return collection.addAll(collection2);
        }
        return Iterators.addAll(collection, Preconditions.checkNotNull(iterable).iterator());
    }

    public static int frequency(Iterable<?> iterable, @Nullable Object object) {
        if (iterable instanceof Multiset) {
            return ((Multiset)iterable).count(object);
        }
        if (iterable instanceof Set) {
            return ((Set)iterable).contains(object) ? 1 : 0;
        }
        return Iterators.frequency(iterable.iterator(), object);
    }

    public static <T> Iterable<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.cycle(iterable);
            }

            @Override
            public String toString() {
                return iterable.toString() + " (cycled)";
            }
        };
    }

    public static <T> Iterable<T> cycle(T ... TArray) {
        return Iterables.cycle(Lists.newArrayList(TArray));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return Iterables.concat(ImmutableList.of(iterable, iterable2));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return Iterables.concat(ImmutableList.of(iterable, iterable2, iterable3));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return Iterables.concat(ImmutableList.of(iterable, iterable2, iterable3, iterable4));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> ... iterableArray) {
        return Iterables.concat(ImmutableList.copyOf(iterableArray));
    }

    public static <T> Iterable<T> concat(final Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.concat(Iterables.iterators(iterable));
            }
        };
    }

    private static <T> Iterator<Iterator<? extends T>> iterators(Iterable<? extends Iterable<? extends T>> iterable) {
        return new TransformedIterator<Iterable<? extends T>, Iterator<? extends T>>(iterable.iterator()){

            @Override
            Iterator<? extends T> transform(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int n) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n > 0);
        return new FluentIterable<List<T>>(){

            @Override
            public Iterator<List<T>> iterator() {
                return Iterators.partition(iterable.iterator(), n);
            }
        };
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> iterable, final int n) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n > 0);
        return new FluentIterable<List<T>>(){

            @Override
            public Iterator<List<T>> iterator() {
                return Iterators.paddedPartition(iterable.iterator(), n);
            }
        };
    }

    public static <T> Iterable<T> filter(final Iterable<T> iterable, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.filter(iterable.iterator(), predicate);
            }
        };
    }

    @GwtIncompatible(value="Class.isInstance")
    public static <T> Iterable<T> filter(final Iterable<?> iterable, final Class<T> clazz) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(clazz);
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.filter(iterable.iterator(), clazz);
            }
        };
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.find(iterable.iterator(), predicate);
    }

    @Nullable
    public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, @Nullable T t) {
        return Iterators.find(iterable.iterator(), predicate, t);
    }

    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.transform(iterable.iterator(), function);
            }
        };
    }

    public static <T> T get(Iterable<T> iterable, int n) {
        Preconditions.checkNotNull(iterable);
        return (T)(iterable instanceof List ? ((List)iterable).get(n) : Iterators.get(iterable.iterator(), n));
    }

    @Nullable
    public static <T> T get(Iterable<? extends T> iterable, int n, @Nullable T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.checkNonnegative(n);
        if (iterable instanceof List) {
            List<T> list = Lists.cast(iterable);
            return n < list.size() ? list.get(n) : t;
        }
        Iterator<? extends T> iterator2 = iterable.iterator();
        Iterators.advance(iterator2, n);
        return Iterators.getNext(iterator2, t);
    }

    @Nullable
    public static <T> T getFirst(Iterable<? extends T> iterable, @Nullable T t) {
        return Iterators.getNext(iterable.iterator(), t);
    }

    public static <T> T getLast(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List)iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return Iterables.getLastInNonemptyList(list);
        }
        return Iterators.getLast(iterable.iterator());
    }

    @Nullable
    public static <T> T getLast(Iterable<? extends T> iterable, @Nullable T t) {
        if (iterable instanceof Collection) {
            Collection<T> collection = Collections2.cast(iterable);
            if (collection.isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return Iterables.getLastInNonemptyList(Lists.cast(iterable));
            }
        }
        return Iterators.getLast(iterable.iterator(), t);
    }

    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> skip(final Iterable<T> iterable, final int n) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n >= 0, "number to skip cannot be negative");
        if (iterable instanceof List) {
            final List list = (List)iterable;
            return new FluentIterable<T>(){

                @Override
                public Iterator<T> iterator() {
                    int n2 = Math.min(list.size(), n);
                    return list.subList(n2, list.size()).iterator();
                }
            };
        }
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                final Iterator iterator2 = iterable.iterator();
                Iterators.advance(iterator2, n);
                return new Iterator<T>(){
                    boolean atStart = true;

                    @Override
                    public boolean hasNext() {
                        return iterator2.hasNext();
                    }

                    @Override
                    public T next() {
                        Object e = iterator2.next();
                        this.atStart = false;
                        return e;
                    }

                    @Override
                    public void remove() {
                        CollectPreconditions.checkRemove(!this.atStart);
                        iterator2.remove();
                    }
                };
            }
        };
    }

    public static <T> Iterable<T> limit(final Iterable<T> iterable, final int n) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n >= 0, "limit is negative");
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.limit(iterable.iterator(), n);
            }
        };
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> iterable) {
        if (iterable instanceof Queue) {
            return new FluentIterable<T>(){

                @Override
                public Iterator<T> iterator() {
                    return new ConsumingQueueIterator((Queue)iterable);
                }

                @Override
                public String toString() {
                    return "Iterables.consumingIterable(...)";
                }
            };
        }
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.consumingIterator(iterable.iterator());
            }

            @Override
            public String toString() {
                return "Iterables.consumingIterable(...)";
            }
        };
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection)iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    @Beta
    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> iterable, final Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        FluentIterable fluentIterable = new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return Iterators.mergeSorted(Iterables.transform(iterable, Iterables.toIterator()), comparator);
            }
        };
        return new UnmodifiableIterable(fluentIterable);
    }

    private static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new Function<Iterable<? extends T>, Iterator<? extends T>>(){

            @Override
            public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }

    private static class ConsumingQueueIterator<T>
    extends AbstractIterator<T> {
        private final Queue<T> queue;

        private ConsumingQueueIterator(Queue<T> queue) {
            this.queue = queue;
        }

        @Override
        public T computeNext() {
            try {
                return this.queue.remove();
            }
            catch (NoSuchElementException noSuchElementException) {
                return this.endOfData();
            }
        }
    }

    private static final class UnmodifiableIterable<T>
    extends FluentIterable<T> {
        private final Iterable<T> iterable;

        private UnmodifiableIterable(Iterable<T> iterable) {
            this.iterable = iterable;
        }

        @Override
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        @Override
        public String toString() {
            return this.iterable.toString();
        }
    }
}

