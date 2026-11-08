/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.TransformedIterator;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class Iterators {
    static final UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = new UnmodifiableListIterator<Object>(){

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return -1;
        }
    };
    private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new Iterator<Object>(){

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    };

    private Iterators() {
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return Iterators.emptyListIterator();
    }

    static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return EMPTY_LIST_ITERATOR;
    }

    static <T> Iterator<T> emptyModifiableIterator() {
        return EMPTY_MODIFIABLE_ITERATOR;
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<T> iterator2) {
        Preconditions.checkNotNull(iterator2);
        if (iterator2 instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator)iterator2;
        }
        return new UnmodifiableIterator<T>(){

            @Override
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            @Override
            public T next() {
                return iterator2.next();
            }
        };
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return Preconditions.checkNotNull(unmodifiableIterator);
    }

    public static int size(Iterator<?> iterator2) {
        int n = 0;
        while (iterator2.hasNext()) {
            iterator2.next();
            ++n;
        }
        return n;
    }

    public static boolean contains(Iterator<?> iterator2, @Nullable Object object) {
        return Iterators.any(iterator2, Predicates.equalTo(object));
    }

    public static boolean removeAll(Iterator<?> iterator2, Collection<?> collection) {
        return Iterators.removeIf(iterator2, Predicates.in(collection));
    }

    public static <T> boolean removeIf(Iterator<T> iterator2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean bl = false;
        while (iterator2.hasNext()) {
            if (!predicate.apply(iterator2.next())) continue;
            iterator2.remove();
            bl = true;
        }
        return bl;
    }

    public static boolean retainAll(Iterator<?> iterator2, Collection<?> collection) {
        return Iterators.removeIf(iterator2, Predicates.not(Predicates.in(collection)));
    }

    public static boolean elementsEqual(Iterator<?> iterator2, Iterator<?> iterator3) {
        while (iterator2.hasNext()) {
            Object obj;
            if (!iterator3.hasNext()) {
                return false;
            }
            Object obj2 = iterator2.next();
            if (Objects.equal(obj2, obj = iterator3.next())) continue;
            return false;
        }
        return !iterator3.hasNext();
    }

    public static String toString(Iterator<?> iterator2) {
        return Collections2.STANDARD_JOINER.appendTo(new StringBuilder().append('['), iterator2).append(']').toString();
    }

    public static <T> T getOnlyElement(Iterator<T> iterator2) {
        T t = iterator2.next();
        if (!iterator2.hasNext()) {
            return t;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected one element but was: <" + t);
        for (int i = 0; i < 4 && iterator2.hasNext(); ++i) {
            stringBuilder.append(", " + iterator2.next());
        }
        if (iterator2.hasNext()) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Nullable
    public static <T> T getOnlyElement(Iterator<? extends T> iterator2, @Nullable T t) {
        return iterator2.hasNext() ? Iterators.getOnlyElement(iterator2) : t;
    }

    @GwtIncompatible(value="Array.newInstance(Class, int)")
    public static <T> T[] toArray(Iterator<? extends T> iterator2, Class<T> clazz) {
        ArrayList<? extends T> arrayList = Lists.newArrayList(iterator2);
        return Iterables.toArray(arrayList, clazz);
    }

    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> iterator2) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(iterator2);
        boolean bl = false;
        while (iterator2.hasNext()) {
            bl |= collection.add(iterator2.next());
        }
        return bl;
    }

    public static int frequency(Iterator<?> iterator2, @Nullable Object object) {
        return Iterators.size(Iterators.filter(iterator2, Predicates.equalTo(object)));
    }

    public static <T> Iterator<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterator<T>(){
            Iterator<T> iterator = Iterators.emptyIterator();
            Iterator<T> removeFrom;

            @Override
            public boolean hasNext() {
                if (!this.iterator.hasNext()) {
                    this.iterator = iterable.iterator();
                }
                return this.iterator.hasNext();
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                this.removeFrom = this.iterator;
                return this.iterator.next();
            }

            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.removeFrom != null);
                this.removeFrom.remove();
                this.removeFrom = null;
            }
        };
    }

    public static <T> Iterator<T> cycle(T ... TArray) {
        return Iterators.cycle(Lists.newArrayList(TArray));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> iterator2, Iterator<? extends T> iterator3) {
        return Iterators.concat(ImmutableList.of(iterator2, iterator3).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> iterator2, Iterator<? extends T> iterator3, Iterator<? extends T> iterator4) {
        return Iterators.concat(ImmutableList.of(iterator2, iterator3, iterator4).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> iterator2, Iterator<? extends T> iterator3, Iterator<? extends T> iterator4, Iterator<? extends T> iterator5) {
        return Iterators.concat(ImmutableList.of(iterator2, iterator3, iterator4, iterator5).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> ... iteratorArray) {
        return Iterators.concat(ImmutableList.copyOf(iteratorArray).iterator());
    }

    public static <T> Iterator<T> concat(final Iterator<? extends Iterator<? extends T>> iterator2) {
        Preconditions.checkNotNull(iterator2);
        return new Iterator<T>(){
            Iterator<? extends T> current = Iterators.emptyIterator();
            Iterator<? extends T> removeFrom;

            @Override
            public boolean hasNext() {
                boolean bl;
                while (!(bl = Preconditions.checkNotNull(this.current).hasNext()) && iterator2.hasNext()) {
                    this.current = (Iterator)iterator2.next();
                }
                return bl;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                this.removeFrom = this.current;
                return this.current.next();
            }

            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.removeFrom != null);
                this.removeFrom.remove();
                this.removeFrom = null;
            }
        };
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> iterator2, int n) {
        return Iterators.partitionImpl(iterator2, n, false);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> iterator2, int n) {
        return Iterators.partitionImpl(iterator2, n, true);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> iterator2, final int n, final boolean bl) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkArgument(n > 0);
        return new UnmodifiableIterator<List<T>>(){

            @Override
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            @Override
            public List<T> next() {
                int n2;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] objectArray = new Object[n];
                for (n2 = 0; n2 < n && iterator2.hasNext(); ++n2) {
                    objectArray[n2] = iterator2.next();
                }
                for (int i = n2; i < n; ++i) {
                    objectArray[i] = null;
                }
                List<Object> list = Collections.unmodifiableList(Arrays.asList(objectArray));
                return bl || n2 == n ? list : list.subList(0, n2);
            }
        };
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> iterator2, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>(){

            @Override
            protected T computeNext() {
                while (iterator2.hasNext()) {
                    Object e = iterator2.next();
                    if (!predicate.apply(e)) continue;
                    return e;
                }
                return this.endOfData();
            }
        };
    }

    @GwtIncompatible(value="Class.isInstance")
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> iterator2, Class<T> clazz) {
        return Iterators.filter(iterator2, Predicates.instanceOf(clazz));
    }

    public static <T> boolean any(Iterator<T> iterator2, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterator2, predicate) != -1;
    }

    public static <T> boolean all(Iterator<T> iterator2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (iterator2.hasNext()) {
            T t = iterator2.next();
            if (predicate.apply(t)) continue;
            return false;
        }
        return true;
    }

    public static <T> T find(Iterator<T> iterator2, Predicate<? super T> predicate) {
        return (T)Iterators.filter(iterator2, predicate).next();
    }

    @Nullable
    public static <T> T find(Iterator<? extends T> iterator2, Predicate<? super T> predicate, @Nullable T t) {
        return Iterators.getNext(Iterators.filter(iterator2, predicate), t);
    }

    public static <T> Optional<T> tryFind(Iterator<T> iterator2, Predicate<? super T> predicate) {
        UnmodifiableIterator<T> unmodifiableIterator = Iterators.filter(iterator2, predicate);
        return unmodifiableIterator.hasNext() ? Optional.of(unmodifiableIterator.next()) : Optional.absent();
    }

    public static <T> int indexOf(Iterator<T> iterator2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int n = 0;
        while (iterator2.hasNext()) {
            T t = iterator2.next();
            if (predicate.apply(t)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public static <F, T> Iterator<T> transform(Iterator<F> iterator2, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new TransformedIterator<F, T>(iterator2){

            @Override
            T transform(F f) {
                return function.apply(f);
            }
        };
    }

    public static <T> T get(Iterator<T> iterator2, int n) {
        Iterators.checkNonnegative(n);
        int n2 = Iterators.advance(iterator2, n);
        if (!iterator2.hasNext()) {
            throw new IndexOutOfBoundsException("position (" + n + ") must be less than the number of elements that remained (" + n2 + ")");
        }
        return iterator2.next();
    }

    static void checkNonnegative(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("position (" + n + ") must not be negative");
        }
    }

    @Nullable
    public static <T> T get(Iterator<? extends T> iterator2, int n, @Nullable T t) {
        Iterators.checkNonnegative(n);
        Iterators.advance(iterator2, n);
        return Iterators.getNext(iterator2, t);
    }

    @Nullable
    public static <T> T getNext(Iterator<? extends T> iterator2, @Nullable T t) {
        return iterator2.hasNext() ? iterator2.next() : t;
    }

    public static <T> T getLast(Iterator<T> iterator2) {
        T t;
        do {
            t = iterator2.next();
        } while (iterator2.hasNext());
        return t;
    }

    @Nullable
    public static <T> T getLast(Iterator<? extends T> iterator2, @Nullable T t) {
        return iterator2.hasNext() ? Iterators.getLast(iterator2) : t;
    }

    public static int advance(Iterator<?> iterator2, int n) {
        int n2;
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkArgument(n >= 0, "numberToAdvance must be nonnegative");
        for (n2 = 0; n2 < n && iterator2.hasNext(); ++n2) {
            iterator2.next();
        }
        return n2;
    }

    public static <T> Iterator<T> limit(final Iterator<T> iterator2, final int n) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkArgument(n >= 0, "limit is negative");
        return new Iterator<T>(){
            private int count;

            @Override
            public boolean hasNext() {
                return this.count < n && iterator2.hasNext();
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                ++this.count;
                return iterator2.next();
            }

            @Override
            public void remove() {
                iterator2.remove();
            }
        };
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> iterator2) {
        Preconditions.checkNotNull(iterator2);
        return new UnmodifiableIterator<T>(){

            @Override
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            @Override
            public T next() {
                Object e = iterator2.next();
                iterator2.remove();
                return e;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    @Nullable
    static <T> T pollNext(Iterator<T> iterator2) {
        if (iterator2.hasNext()) {
            T t = iterator2.next();
            iterator2.remove();
            return t;
        }
        return null;
    }

    static void clear(Iterator<?> iterator2) {
        Preconditions.checkNotNull(iterator2);
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
    }

    public static <T> UnmodifiableIterator<T> forArray(T ... TArray) {
        return Iterators.forArray(TArray, 0, TArray.length, 0);
    }

    static <T> UnmodifiableListIterator<T> forArray(final T[] TArray, final int n, int n2, int n3) {
        Preconditions.checkArgument(n2 >= 0);
        int n4 = n + n2;
        Preconditions.checkPositionIndexes(n, n4, TArray.length);
        Preconditions.checkPositionIndex(n3, n2);
        if (n2 == 0) {
            return Iterators.emptyListIterator();
        }
        return new AbstractIndexedListIterator<T>(n2, n3){

            @Override
            protected T get(int n2) {
                return TArray[n + n2];
            }
        };
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(final @Nullable T t) {
        return new UnmodifiableIterator<T>(){
            boolean done;

            @Override
            public boolean hasNext() {
                return !this.done;
            }

            @Override
            public T next() {
                if (this.done) {
                    throw new NoSuchElementException();
                }
                this.done = true;
                return t;
            }
        };
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new UnmodifiableIterator<T>(){

            @Override
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override
            public T next() {
                return enumeration.nextElement();
            }
        };
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> iterator2) {
        Preconditions.checkNotNull(iterator2);
        return new Enumeration<T>(){

            @Override
            public boolean hasMoreElements() {
                return iterator2.hasNext();
            }

            @Override
            public T nextElement() {
                return iterator2.next();
            }
        };
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> iterator2) {
        if (iterator2 instanceof PeekingImpl) {
            PeekingImpl peekingImpl = (PeekingImpl)iterator2;
            return peekingImpl;
        }
        return new PeekingImpl<T>(iterator2);
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return Preconditions.checkNotNull(peekingIterator);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator<T>(iterable, comparator);
    }

    static <T> ListIterator<T> cast(Iterator<T> iterator2) {
        return (ListIterator)iterator2;
    }

    private static class MergingIterator<T>
    extends UnmodifiableIterator<T> {
        final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            Comparator comparator2 = new Comparator<PeekingIterator<T>>(){

                @Override
                public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                    return comparator.compare(peekingIterator.peek(), peekingIterator2.peek());
                }
            };
            this.queue = new PriorityQueue<PeekingIterator<T>>(2, comparator2);
            for (Iterator<T> iterator2 : iterable) {
                if (!iterator2.hasNext()) continue;
                this.queue.add(Iterators.peekingIterator(iterator2));
            }
        }

        @Override
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override
        public T next() {
            PeekingIterator<T> peekingIterator = this.queue.remove();
            T t = peekingIterator.next();
            if (peekingIterator.hasNext()) {
                this.queue.add(peekingIterator);
            }
            return t;
        }
    }

    private static class PeekingImpl<E>
    implements PeekingIterator<E> {
        private final Iterator<? extends E> iterator;
        private boolean hasPeeked;
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> iterator2) {
            this.iterator = Preconditions.checkNotNull(iterator2);
        }

        @Override
        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        @Override
        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E e = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return e;
        }

        @Override
        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }

        @Override
        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return this.peekedElement;
        }
    }
}

