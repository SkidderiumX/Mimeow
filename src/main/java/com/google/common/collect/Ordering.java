/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AllEqualOrdering;
import com.google.common.collect.ByFunctionOrdering;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ComparatorOrdering;
import com.google.common.collect.CompoundOrdering;
import com.google.common.collect.ExplicitOrdering;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.LexicographicalOrdering;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.NullsFirstOrdering;
import com.google.common.collect.NullsLastOrdering;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Platform;
import com.google.common.collect.ReverseOrdering;
import com.google.common.collect.UsingToStringOrdering;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Ordering<T>
implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    @GwtCompatible(serializable=true)
    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    @GwtCompatible(serializable=true)
    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering<T>)comparator : new ComparatorOrdering<T>(comparator);
    }

    @Deprecated
    @GwtCompatible(serializable=true)
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return Preconditions.checkNotNull(ordering);
    }

    @GwtCompatible(serializable=true)
    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering<T>(list);
    }

    @GwtCompatible(serializable=true)
    public static <T> Ordering<T> explicit(T t, T ... TArray) {
        return Ordering.explicit(Lists.asList(t, TArray));
    }

    @GwtCompatible(serializable=true)
    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    @GwtCompatible(serializable=true)
    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }

    protected Ordering() {
    }

    @GwtCompatible(serializable=true)
    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    @GwtCompatible(serializable=true)
    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible(serializable=true)
    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    @GwtCompatible(serializable=true)
    public <F> Ordering<F> onResultOf(Function<F, ? extends T> function) {
        return new ByFunctionOrdering<F, T>(function, this);
    }

    <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return this.onResultOf(Maps.keyFunction());
    }

    @GwtCompatible(serializable=true)
    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering<U>(this, Preconditions.checkNotNull(comparator));
    }

    @GwtCompatible(serializable=true)
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    @GwtCompatible(serializable=true)
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    @Override
    public abstract int compare(@Nullable T var1, @Nullable T var2);

    public <E extends T> E min(Iterator<E> iterator2) {
        E e = iterator2.next();
        while (iterator2.hasNext()) {
            e = this.min(e, iterator2.next());
        }
        return e;
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return this.min(iterable.iterator());
    }

    public <E extends T> E min(@Nullable E e, @Nullable E e2) {
        return this.compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E min(@Nullable E e, @Nullable E e2, @Nullable E e3, E ... EArray) {
        E e4 = this.min(this.min(e, e2), e3);
        for (E e5 : EArray) {
            e4 = this.min(e4, e5);
        }
        return e4;
    }

    public <E extends T> E max(Iterator<E> iterator2) {
        E e = iterator2.next();
        while (iterator2.hasNext()) {
            e = this.max(e, iterator2.next());
        }
        return e;
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return this.max(iterable.iterator());
    }

    public <E extends T> E max(@Nullable E e, @Nullable E e2) {
        return this.compare(e, e2) >= 0 ? e : e2;
    }

    public <E extends T> E max(@Nullable E e, @Nullable E e2, @Nullable E e3, E ... EArray) {
        E e4 = this.max(this.max(e, e2), e3);
        for (E e5 : EArray) {
            e4 = this.max(e4, e5);
        }
        return e4;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int n) {
        Collection collection;
        if (iterable instanceof Collection && (long)(collection = (Collection)iterable).size() <= 2L * (long)n) {
            Object[] objectArray = collection.toArray();
            Arrays.sort(objectArray, this);
            if (objectArray.length > n) {
                objectArray = ObjectArrays.arraysCopyOf(objectArray, n);
            }
            return Collections.unmodifiableList(Arrays.asList(objectArray));
        }
        return this.leastOf(iterable.iterator(), n);
    }

    public <E extends T> List<E> leastOf(Iterator<E> iterator2, int n) {
        E e;
        Preconditions.checkNotNull(iterator2);
        CollectPreconditions.checkNonnegative(n, "k");
        if (n == 0 || !iterator2.hasNext()) {
            return ImmutableList.of();
        }
        if (n >= 0x3FFFFFFF) {
            ArrayList<E> arrayList = Lists.newArrayList(iterator2);
            Collections.sort(arrayList, this);
            if (arrayList.size() > n) {
                arrayList.subList(n, arrayList.size()).clear();
            }
            arrayList.trimToSize();
            return Collections.unmodifiableList(arrayList);
        }
        int n2 = n * 2;
        Object[] objectArray = new Object[n2];
        Object object = iterator2.next();
        objectArray[0] = object;
        int n3 = 1;
        while (n3 < n && iterator2.hasNext()) {
            e = iterator2.next();
            objectArray[n3++] = e;
            object = this.max(object, e);
        }
        while (iterator2.hasNext()) {
            int n4;
            e = iterator2.next();
            if (this.compare(e, object) >= 0) continue;
            objectArray[n3++] = e;
            if (n3 != n2) continue;
            int n5 = 0;
            int n6 = n2 - 1;
            int n7 = 0;
            while (n5 < n6) {
                n4 = n5 + n6 + 1 >>> 1;
                int n8 = this.partition(objectArray, n5, n6, n4);
                if (n8 > n) {
                    n6 = n8 - 1;
                    continue;
                }
                if (n8 >= n) break;
                n5 = Math.max(n8, n5 + 1);
                n7 = n8;
            }
            n3 = n;
            object = objectArray[n7];
            for (n4 = n7 + 1; n4 < n3; ++n4) {
                object = this.max(object, objectArray[n4]);
            }
        }
        Arrays.sort(objectArray, 0, n3, this);
        n3 = Math.min(n3, n);
        return Collections.unmodifiableList(Arrays.asList(ObjectArrays.arraysCopyOf(objectArray, n3)));
    }

    private <E extends T> int partition(E[] EArray, int n, int n2, int n3) {
        E e = EArray[n3];
        EArray[n3] = EArray[n2];
        EArray[n2] = e;
        int n4 = n;
        for (int i = n; i < n2; ++i) {
            if (this.compare(EArray[i], e) >= 0) continue;
            ObjectArrays.swap(EArray, n4, i);
            ++n4;
        }
        ObjectArrays.swap(EArray, n2, n4);
        return n4;
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int n) {
        return this.reverse().leastOf(iterable, n);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> iterator2, int n) {
        return this.reverse().leastOf(iterator2, n);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] objectArray = Iterables.toArray(iterable);
        Arrays.sort(objectArray, this);
        return Lists.newArrayList(Arrays.asList(objectArray));
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        Object[] objectArray;
        for (Object object : objectArray = Iterables.toArray(iterable)) {
            Preconditions.checkNotNull(object);
        }
        Arrays.sort(objectArray, this);
        return ImmutableList.asImmutableList(objectArray);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<T> iterator2 = iterable.iterator();
        if (iterator2.hasNext()) {
            T t = iterator2.next();
            while (iterator2.hasNext()) {
                T t2 = iterator2.next();
                if (this.compare(t, t2) > 0) {
                    return false;
                }
                t = t2;
            }
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<T> iterator2 = iterable.iterator();
        if (iterator2.hasNext()) {
            T t = iterator2.next();
            while (iterator2.hasNext()) {
                T t2 = iterator2.next();
                if (this.compare(t, t2) >= 0) {
                    return false;
                }
                t = t2;
            }
        }
        return true;
    }

    public int binarySearch(List<? extends T> list, @Nullable T t) {
        return Collections.binarySearch(list, t, this);
    }

    @VisibleForTesting
    public static class IncomparableValueException
    extends ClassCastException {
        final Object value;
        private static final long serialVersionUID = 0L;

        IncomparableValueException(Object object) {
            super("Cannot compare value: " + object);
            this.value = object;
        }
    }

    @VisibleForTesting
    public static class ArbitraryOrdering
    extends Ordering<Object> {
        private Map<Object, Integer> uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new Function<Object, Integer>(){
            final AtomicInteger counter = new AtomicInteger(0);

            @Override
            public Integer apply(Object object) {
                return this.counter.getAndIncrement();
            }
        });

        ArbitraryOrdering() {
        }

        @Override
        public int compare(Object object, Object object2) {
            int n;
            if (object == object2) {
                return 0;
            }
            if (object == null) {
                return -1;
            }
            if (object2 == null) {
                return 1;
            }
            int n2 = this.identityHashCode(object);
            if (n2 != (n = this.identityHashCode(object2))) {
                return n2 < n ? -1 : 1;
            }
            int n3 = this.uids.get(object).compareTo(this.uids.get(object2));
            if (n3 == 0) {
                throw new AssertionError();
            }
            return n3;
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }

        int identityHashCode(Object object) {
            return System.identityHashCode(object);
        }
    }

    private static class ArbitraryOrderingHolder {
        static final Ordering<Object> ARBITRARY_ORDERING = new ArbitraryOrdering();

        private ArbitraryOrderingHolder() {
        }
    }
}

