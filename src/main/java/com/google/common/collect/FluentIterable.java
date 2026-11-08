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
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class FluentIterable<E>
implements Iterable<E> {
    private final Iterable<E> iterable;

    protected FluentIterable() {
        this.iterable = this;
    }

    FluentIterable(Iterable<E> iterable) {
        this.iterable = Preconditions.checkNotNull(iterable);
    }

    public static <E> FluentIterable<E> from(final Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable<E>)iterable : new FluentIterable<E>(iterable){

            @Override
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> fluentIterable) {
        return Preconditions.checkNotNull(fluentIterable);
    }

    public String toString() {
        return Iterables.toString(this.iterable);
    }

    public final int size() {
        return Iterables.size(this.iterable);
    }

    public final boolean contains(@Nullable Object object) {
        return Iterables.contains(this.iterable, object);
    }

    @CheckReturnValue
    public final FluentIterable<E> cycle() {
        return FluentIterable.from(Iterables.cycle(this.iterable));
    }

    @CheckReturnValue
    public final FluentIterable<E> filter(Predicate<? super E> predicate) {
        return FluentIterable.from(Iterables.filter(this.iterable, predicate));
    }

    @CheckReturnValue
    @GwtIncompatible(value="Class.isInstance")
    public final <T> FluentIterable<T> filter(Class<T> clazz) {
        return FluentIterable.from(Iterables.filter(this.iterable, clazz));
    }

    public final boolean anyMatch(Predicate<? super E> predicate) {
        return Iterables.any(this.iterable, predicate);
    }

    public final boolean allMatch(Predicate<? super E> predicate) {
        return Iterables.all(this.iterable, predicate);
    }

    public final Optional<E> firstMatch(Predicate<? super E> predicate) {
        return Iterables.tryFind(this.iterable, predicate);
    }

    public final <T> FluentIterable<T> transform(Function<? super E, T> function) {
        return FluentIterable.from(Iterables.transform(this.iterable, function));
    }

    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> function) {
        return FluentIterable.from(Iterables.concat(this.transform(function)));
    }

    public final Optional<E> first() {
        Iterator<E> iterator2 = this.iterable.iterator();
        return iterator2.hasNext() ? Optional.of(iterator2.next()) : Optional.absent();
    }

    public final Optional<E> last() {
        E e;
        if (this.iterable instanceof List) {
            List list = (List)this.iterable;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.of(list.get(list.size() - 1));
        }
        Iterator<E> iterator2 = this.iterable.iterator();
        if (!iterator2.hasNext()) {
            return Optional.absent();
        }
        if (this.iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet)this.iterable;
            return Optional.of(sortedSet.last());
        }
        do {
            e = iterator2.next();
        } while (iterator2.hasNext());
        return Optional.of(e);
    }

    @CheckReturnValue
    public final FluentIterable<E> skip(int n) {
        return FluentIterable.from(Iterables.skip(this.iterable, n));
    }

    @CheckReturnValue
    public final FluentIterable<E> limit(int n) {
        return FluentIterable.from(Iterables.limit(this.iterable, n));
    }

    public final boolean isEmpty() {
        return !this.iterable.iterator().hasNext();
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(this.iterable);
    }

    @Beta
    public final ImmutableList<E> toSortedList(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(this.iterable);
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(this.iterable);
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, this.iterable);
    }

    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> function) {
        return Maps.toMap(this.iterable, function);
    }

    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> function) {
        return Multimaps.index(this.iterable, function);
    }

    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> function) {
        return Maps.uniqueIndex(this.iterable, function);
    }

    @GwtIncompatible(value="Array.newArray(Class, int)")
    public final E[] toArray(Class<E> clazz) {
        return Iterables.toArray(this.iterable, clazz);
    }

    public final <C extends Collection<? super E>> C copyInto(C c) {
        Preconditions.checkNotNull(c);
        if (this.iterable instanceof Collection) {
            c.addAll(Collections2.cast(this.iterable));
        } else {
            for (E e : this.iterable) {
                c.add(e);
            }
        }
        return c;
    }

    public final E get(int n) {
        return Iterables.get(this.iterable, n);
    }

    private static class FromIterableFunction<E>
    implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        @Override
        public FluentIterable<E> apply(Iterable<E> iterable) {
            return FluentIterable.from(iterable);
        }
    }
}

