/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class Synchronized {
    private Synchronized() {
    }

    private static <E> Collection<E> collection(Collection<E> collection, @Nullable Object object) {
        return new SynchronizedCollection(collection, object);
    }

    @VisibleForTesting
    static <E> Set<E> set(Set<E> set, @Nullable Object object) {
        return new SynchronizedSet<E>(set, object);
    }

    private static <E> SortedSet<E> sortedSet(SortedSet<E> sortedSet, @Nullable Object object) {
        return new SynchronizedSortedSet<E>(sortedSet, object);
    }

    private static <E> List<E> list(List<E> list, @Nullable Object object) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList<E>(list, object) : new SynchronizedList<E>(list, object);
    }

    static <E> Multiset<E> multiset(Multiset<E> multiset, @Nullable Object object) {
        if (multiset instanceof SynchronizedMultiset || multiset instanceof ImmutableMultiset) {
            return multiset;
        }
        return new SynchronizedMultiset<E>(multiset, object);
    }

    static <K, V> Multimap<K, V> multimap(Multimap<K, V> multimap, @Nullable Object object) {
        if (multimap instanceof SynchronizedMultimap || multimap instanceof ImmutableMultimap) {
            return multimap;
        }
        return new SynchronizedMultimap<K, V>(multimap, object);
    }

    static <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> listMultimap, @Nullable Object object) {
        if (listMultimap instanceof SynchronizedListMultimap || listMultimap instanceof ImmutableListMultimap) {
            return listMultimap;
        }
        return new SynchronizedListMultimap<K, V>(listMultimap, object);
    }

    static <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> setMultimap, @Nullable Object object) {
        if (setMultimap instanceof SynchronizedSetMultimap || setMultimap instanceof ImmutableSetMultimap) {
            return setMultimap;
        }
        return new SynchronizedSetMultimap<K, V>(setMultimap, object);
    }

    static <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @Nullable Object object) {
        if (sortedSetMultimap instanceof SynchronizedSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new SynchronizedSortedSetMultimap<K, V>(sortedSetMultimap, object);
    }

    private static <E> Collection<E> typePreservingCollection(Collection<E> collection, @Nullable Object object) {
        if (collection instanceof SortedSet) {
            return Synchronized.sortedSet((SortedSet)collection, object);
        }
        if (collection instanceof Set) {
            return Synchronized.set((Set)collection, object);
        }
        if (collection instanceof List) {
            return Synchronized.list((List)collection, object);
        }
        return Synchronized.collection(collection, object);
    }

    private static <E> Set<E> typePreservingSet(Set<E> set, @Nullable Object object) {
        if (set instanceof SortedSet) {
            return Synchronized.sortedSet((SortedSet)set, object);
        }
        return Synchronized.set(set, object);
    }

    @VisibleForTesting
    static <K, V> Map<K, V> map(Map<K, V> map, @Nullable Object object) {
        return new SynchronizedMap<K, V>(map, object);
    }

    static <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> sortedMap, @Nullable Object object) {
        return new SynchronizedSortedMap<K, V>(sortedMap, object);
    }

    static <K, V> BiMap<K, V> biMap(BiMap<K, V> biMap, @Nullable Object object) {
        if (biMap instanceof SynchronizedBiMap || biMap instanceof ImmutableBiMap) {
            return biMap;
        }
        return new SynchronizedBiMap(biMap, object, null);
    }

    @GwtIncompatible(value="NavigableSet")
    static <E> NavigableSet<E> navigableSet(NavigableSet<E> navigableSet, @Nullable Object object) {
        return new SynchronizedNavigableSet<E>(navigableSet, object);
    }

    @GwtIncompatible(value="NavigableSet")
    static <E> NavigableSet<E> navigableSet(NavigableSet<E> navigableSet) {
        return Synchronized.navigableSet(navigableSet, null);
    }

    @GwtIncompatible(value="NavigableMap")
    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> navigableMap) {
        return Synchronized.navigableMap(navigableMap, null);
    }

    @GwtIncompatible(value="NavigableMap")
    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> navigableMap, @Nullable Object object) {
        return new SynchronizedNavigableMap<K, V>(navigableMap, object);
    }

    @GwtIncompatible(value="works but is needed only for NavigableMap")
    private static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(@Nullable Map.Entry<K, V> entry, @Nullable Object object) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry<K, V>(entry, object);
    }

    static <E> Queue<E> queue(Queue<E> synchronizedQueue, @Nullable Object object) {
        return synchronizedQueue instanceof SynchronizedQueue ? synchronizedQueue : new SynchronizedQueue(synchronizedQueue, object);
    }

    @GwtIncompatible(value="Deque")
    static <E> Deque<E> deque(Deque<E> deque, @Nullable Object object) {
        return new SynchronizedDeque<E>(deque, object);
    }

    @GwtIncompatible(value="Deque")
    private static final class SynchronizedDeque<E>
    extends SynchronizedQueue<E>
    implements Deque<E> {
        private static final long serialVersionUID = 0L;

        SynchronizedDeque(Deque<E> deque, @Nullable Object object) {
            super(deque, object);
        }

        @Override
        Deque<E> delegate() {
            return (Deque)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void addFirst(E e) {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().addFirst(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void addLast(E e) {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().addLast(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean offerFirst(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().offerFirst(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean offerLast(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().offerLast(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E removeFirst() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().removeFirst();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E removeLast() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().removeLast();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E pollFirst() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().pollFirst();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E pollLast() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().pollLast();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E getFirst() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().getFirst();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E getLast() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().getLast();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E peekFirst() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().peekFirst();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E peekLast() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().peekLast();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean removeFirstOccurrence(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().removeFirstOccurrence(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean removeLastOccurrence(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().removeLastOccurrence(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void push(E e) {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().push(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E pop() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().pop();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Iterator<E> descendingIterator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().descendingIterator();
            }
        }
    }

    private static class SynchronizedQueue<E>
    extends SynchronizedCollection<E>
    implements Queue<E> {
        private static final long serialVersionUID = 0L;

        SynchronizedQueue(Queue<E> queue, @Nullable Object object) {
            super(queue, object);
        }

        @Override
        Queue<E> delegate() {
            return (Queue)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E element() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().element();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean offer(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().offer(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E peek() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().peek();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E poll() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().poll();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E remove() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().remove();
            }
        }
    }

    @GwtIncompatible(value="works but is needed only for NavigableMap")
    private static class SynchronizedEntry<K, V>
    extends SynchronizedObject
    implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0L;

        SynchronizedEntry(Map.Entry<K, V> entry, @Nullable Object object) {
            super(entry, object);
        }

        @Override
        Map.Entry<K, V> delegate() {
            return (Map.Entry)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean equals(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().hashCode();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public K getKey() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().getKey();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public V getValue() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().getValue();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public V setValue(V v) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().setValue(v);
            }
        }
    }

    @GwtIncompatible(value="NavigableMap")
    @VisibleForTesting
    public static class SynchronizedNavigableMap<K, V>
    extends SynchronizedSortedMap<K, V>
    implements NavigableMap<K, V> {
        transient NavigableSet<K> descendingKeySet;
        transient NavigableMap<K, V> descendingMap;
        transient NavigableSet<K> navigableKeySet;
        private static final long serialVersionUID = 0L;

        SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, @Nullable Object object) {
            super(navigableMap, object);
        }

        @Override
        NavigableMap<K, V> delegate() {
            return (NavigableMap)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> ceilingEntry(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().ceilingEntry(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public K ceilingKey(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().ceilingKey(k);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableSet<K> descendingKeySet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.descendingKeySet == null) {
                    this.descendingKeySet = Synchronized.navigableSet(this.delegate().descendingKeySet(), this.mutex);
                    return this.descendingKeySet;
                }
                return this.descendingKeySet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableMap<K, V> descendingMap() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.descendingMap == null) {
                    this.descendingMap = Synchronized.navigableMap(this.delegate().descendingMap(), this.mutex);
                    return this.descendingMap;
                }
                return this.descendingMap;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> firstEntry() {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().firstEntry(), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> floorEntry(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().floorEntry(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public K floorKey(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().floorKey(k);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableMap<K, V> headMap(K k, boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.navigableMap(this.delegate().headMap(k, bl), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> higherEntry(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().higherEntry(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public K higherKey(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().higherKey(k);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> lastEntry() {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().lastEntry(), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> lowerEntry(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().lowerEntry(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public K lowerKey(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().lowerKey(k);
            }
        }

        @Override
        public Set<K> keySet() {
            return this.navigableKeySet();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableSet<K> navigableKeySet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.navigableKeySet == null) {
                    this.navigableKeySet = Synchronized.navigableSet(this.delegate().navigableKeySet(), this.mutex);
                    return this.navigableKeySet;
                }
                return this.navigableKeySet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> pollFirstEntry() {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().pollFirstEntry(), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map.Entry<K, V> pollLastEntry() {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.nullableSynchronizedEntry(this.delegate().pollLastEntry(), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableMap<K, V> subMap(K k, boolean bl, K k2, boolean bl2) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.navigableMap(this.delegate().subMap(k, bl, k2, bl2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableMap<K, V> tailMap(K k, boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.navigableMap(this.delegate().tailMap(k, bl), this.mutex);
            }
        }

        @Override
        public SortedMap<K, V> headMap(K k) {
            return this.headMap(k, false);
        }

        @Override
        public SortedMap<K, V> subMap(K k, K k2) {
            return this.subMap(k, true, k2, false);
        }

        @Override
        public SortedMap<K, V> tailMap(K k) {
            return this.tailMap(k, true);
        }
    }

    @GwtIncompatible(value="NavigableSet")
    @VisibleForTesting
    public static class SynchronizedNavigableSet<E>
    extends SynchronizedSortedSet<E>
    implements NavigableSet<E> {
        transient NavigableSet<E> descendingSet;
        private static final long serialVersionUID = 0L;

        SynchronizedNavigableSet(NavigableSet<E> navigableSet, @Nullable Object object) {
            super(navigableSet, object);
        }

        @Override
        NavigableSet<E> delegate() {
            return (NavigableSet)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E ceiling(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().ceiling(e);
            }
        }

        @Override
        public Iterator<E> descendingIterator() {
            return this.delegate().descendingIterator();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableSet<E> descendingSet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.descendingSet == null) {
                    NavigableSet navigableSet = Synchronized.navigableSet(this.delegate().descendingSet(), this.mutex);
                    this.descendingSet = navigableSet;
                    return navigableSet;
                }
                return this.descendingSet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E floor(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().floor(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableSet<E> headSet(E e, boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.navigableSet(this.delegate().headSet(e, bl), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E higher(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().higher(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E lower(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().lower(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E pollFirst() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().pollFirst();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E pollLast() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().pollLast();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableSet<E> subSet(E e, boolean bl, E e2, boolean bl2) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.navigableSet(this.delegate().subSet(e, bl, e2, bl2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public NavigableSet<E> tailSet(E e, boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.navigableSet(this.delegate().tailSet(e, bl), this.mutex);
            }
        }

        @Override
        public SortedSet<E> headSet(E e) {
            return this.headSet(e, false);
        }

        @Override
        public SortedSet<E> subSet(E e, E e2) {
            return this.subSet(e, true, e2, false);
        }

        @Override
        public SortedSet<E> tailSet(E e) {
            return this.tailSet(e, true);
        }
    }

    private static class SynchronizedAsMapValues<V>
    extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0L;

        SynchronizedAsMapValues(Collection<Collection<V>> collection, @Nullable Object object) {
            super(collection, object);
        }

        @Override
        public Iterator<Collection<V>> iterator() {
            final Iterator iterator2 = super.iterator();
            return new ForwardingIterator<Collection<V>>(){

                @Override
                protected Iterator<Collection<V>> delegate() {
                    return iterator2;
                }

                @Override
                public Collection<V> next() {
                    return Synchronized.typePreservingCollection((Collection)super.next(), SynchronizedAsMapValues.this.mutex);
                }
            };
        }
    }

    private static class SynchronizedAsMap<K, V>
    extends SynchronizedMap<K, Collection<V>> {
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        transient Collection<Collection<V>> asMapValues;
        private static final long serialVersionUID = 0L;

        SynchronizedAsMap(Map<K, Collection<V>> map, @Nullable Object object) {
            super(map, object);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<V> get(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                Collection collection = (Collection)super.get(object);
                return collection == null ? null : Synchronized.typePreservingCollection(collection, this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.asMapEntrySet == null) {
                    this.asMapEntrySet = new SynchronizedAsMapEntries(this.delegate().entrySet(), this.mutex);
                }
                return this.asMapEntrySet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<Collection<V>> values() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.asMapValues == null) {
                    this.asMapValues = new SynchronizedAsMapValues(this.delegate().values(), this.mutex);
                }
                return this.asMapValues;
            }
        }

        @Override
        public boolean containsValue(Object object) {
            return this.values().contains(object);
        }
    }

    @VisibleForTesting
    public static class SynchronizedBiMap<K, V>
    extends SynchronizedMap<K, V>
    implements BiMap<K, V>,
    Serializable {
        private transient Set<V> valueSet;
        private transient BiMap<V, K> inverse;
        private static final long serialVersionUID = 0L;

        private SynchronizedBiMap(BiMap<K, V> biMap, @Nullable Object object, @Nullable BiMap<V, K> biMap2) {
            super(biMap, object);
            this.inverse = biMap2;
        }

        @Override
        BiMap<K, V> delegate() {
            return (BiMap)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<V> values() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.valueSet == null) {
                    this.valueSet = Synchronized.set(this.delegate().values(), this.mutex);
                }
                return this.valueSet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public V forcePut(K k, V v) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().forcePut(k, v);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public BiMap<V, K> inverse() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.inverse == null) {
                    this.inverse = new SynchronizedBiMap<K, V>(this.delegate().inverse(), this.mutex, this);
                }
                return this.inverse;
            }
        }
    }

    public static class SynchronizedSortedMap<K, V>
    extends SynchronizedMap<K, V>
    implements SortedMap<K, V> {
        private static final long serialVersionUID = 0L;

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, @Nullable Object object) {
            super(sortedMap, object);
        }

        @Override
        SortedMap<K, V> delegate() {
            return (SortedMap)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Comparator<? super K> comparator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().comparator();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public K firstKey() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().firstKey();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedMap<K, V> headMap(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.sortedMap(this.delegate().headMap(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public K lastKey() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().lastKey();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedMap<K, V> subMap(K k, K k2) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.sortedMap(this.delegate().subMap(k, k2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedMap<K, V> tailMap(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.sortedMap(this.delegate().tailMap(k), this.mutex);
            }
        }
    }

    private static class SynchronizedMap<K, V>
    extends SynchronizedObject
    implements Map<K, V> {
        transient Set<K> keySet;
        transient Collection<V> values;
        transient Set<Map.Entry<K, V>> entrySet;
        private static final long serialVersionUID = 0L;

        SynchronizedMap(Map<K, V> map, @Nullable Object object) {
            super(map, object);
        }

        @Override
        Map<K, V> delegate() {
            return (Map)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void clear() {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().clear();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean containsKey(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().containsKey(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean containsValue(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().containsValue(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.set(this.delegate().entrySet(), this.mutex);
                }
                return this.entrySet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public V get(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().get(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean isEmpty() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().isEmpty();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<K> keySet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.set(this.delegate().keySet(), this.mutex);
                }
                return this.keySet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public V put(K k, V v) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().put(k, v);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().putAll(map);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public V remove(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().remove(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int size() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().size();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<V> values() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.values == null) {
                    this.values = Synchronized.collection(this.delegate().values(), this.mutex);
                }
                return this.values;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().hashCode();
            }
        }
    }

    private static class SynchronizedAsMapEntries<K, V>
    extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0L;

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, @Nullable Object object) {
            super(set, object);
        }

        @Override
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            final Iterator iterator2 = super.iterator();
            return new ForwardingIterator<Map.Entry<K, Collection<V>>>(){

                @Override
                protected Iterator<Map.Entry<K, Collection<V>>> delegate() {
                    return iterator2;
                }

                @Override
                public Map.Entry<K, Collection<V>> next() {
                    final Map.Entry entry = (Map.Entry)super.next();
                    return new ForwardingMapEntry<K, Collection<V>>(){

                        @Override
                        protected Map.Entry<K, Collection<V>> delegate() {
                            return entry;
                        }

                        @Override
                        public Collection<V> getValue() {
                            return Synchronized.typePreservingCollection((Collection)entry.getValue(), SynchronizedAsMapEntries.this.mutex);
                        }
                    };
                }
            };
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Object[] toArray() {
            Object object = this.mutex;
            synchronized (object) {
                return ObjectArrays.toArrayImpl(this.delegate());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public <T> T[] toArray(T[] TArray) {
            Object object = this.mutex;
            synchronized (object) {
                return ObjectArrays.toArrayImpl(this.delegate(), TArray);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean contains(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return Maps.containsEntryImpl(this.delegate(), object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean containsAll(Collection<?> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return Collections2.containsAllImpl(this.delegate(), collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            Object object2 = this.mutex;
            synchronized (object2) {
                return Sets.equalsImpl(this.delegate(), object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean remove(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return Maps.removeEntryImpl(this.delegate(), object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean removeAll(Collection<?> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return Iterators.removeAll(this.delegate().iterator(), collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean retainAll(Collection<?> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return Iterators.retainAll(this.delegate().iterator(), collection);
            }
        }
    }

    private static class SynchronizedSortedSetMultimap<K, V>
    extends SynchronizedSetMultimap<K, V>
    implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @Nullable Object object) {
            super(sortedSetMultimap, object);
        }

        @Override
        SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedSet<V> get(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.sortedSet(this.delegate().get(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedSet<V> removeAll(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().removeAll(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().replaceValues(k, iterable);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Comparator<? super V> valueComparator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().valueComparator();
            }
        }
    }

    private static class SynchronizedSetMultimap<K, V>
    extends SynchronizedMultimap<K, V>
    implements SetMultimap<K, V> {
        transient Set<Map.Entry<K, V>> entrySet;
        private static final long serialVersionUID = 0L;

        SynchronizedSetMultimap(SetMultimap<K, V> setMultimap, @Nullable Object object) {
            super(setMultimap, object);
        }

        @Override
        SetMultimap<K, V> delegate() {
            return (SetMultimap)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<V> get(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.set(this.delegate().get(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<V> removeAll(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().removeAll(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().replaceValues(k, iterable);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<Map.Entry<K, V>> entries() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.set(this.delegate().entries(), this.mutex);
                }
                return this.entrySet;
            }
        }
    }

    private static class SynchronizedListMultimap<K, V>
    extends SynchronizedMultimap<K, V>
    implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        SynchronizedListMultimap(ListMultimap<K, V> listMultimap, @Nullable Object object) {
            super(listMultimap, object);
        }

        @Override
        ListMultimap<K, V> delegate() {
            return (ListMultimap)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public List<V> get(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.list(this.delegate().get(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public List<V> removeAll(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().removeAll(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().replaceValues(k, iterable);
            }
        }
    }

    private static class SynchronizedMultimap<K, V>
    extends SynchronizedObject
    implements Multimap<K, V> {
        transient Set<K> keySet;
        transient Collection<V> valuesCollection;
        transient Collection<Map.Entry<K, V>> entries;
        transient Map<K, Collection<V>> asMap;
        transient Multiset<K> keys;
        private static final long serialVersionUID = 0L;

        @Override
        Multimap<K, V> delegate() {
            return (Multimap)super.delegate();
        }

        SynchronizedMultimap(Multimap<K, V> multimap, @Nullable Object object) {
            super(multimap, object);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int size() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().size();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean isEmpty() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().isEmpty();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean containsKey(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().containsKey(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean containsValue(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().containsValue(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean containsEntry(Object object, Object object2) {
            Object object3 = this.mutex;
            synchronized (object3) {
                return this.delegate().containsEntry(object, object2);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<V> get(K k) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.typePreservingCollection(this.delegate().get(k), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean put(K k, V v) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().put(k, v);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().putAll(k, iterable);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().putAll(multimap);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().replaceValues(k, iterable);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean remove(Object object, Object object2) {
            Object object3 = this.mutex;
            synchronized (object3) {
                return this.delegate().remove(object, object2);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<V> removeAll(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().removeAll(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void clear() {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().clear();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<K> keySet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.typePreservingSet(this.delegate().keySet(), this.mutex);
                }
                return this.keySet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<V> values() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.valuesCollection == null) {
                    this.valuesCollection = Synchronized.collection(this.delegate().values(), this.mutex);
                }
                return this.valuesCollection;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Collection<Map.Entry<K, V>> entries() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.entries == null) {
                    this.entries = Synchronized.typePreservingCollection(this.delegate().entries(), this.mutex);
                }
                return this.entries;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Map<K, Collection<V>> asMap() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.asMap == null) {
                    this.asMap = new SynchronizedAsMap(this.delegate().asMap(), this.mutex);
                }
                return this.asMap;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Multiset<K> keys() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.keys == null) {
                    this.keys = Synchronized.multiset(this.delegate().keys(), this.mutex);
                }
                return this.keys;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().hashCode();
            }
        }
    }

    private static class SynchronizedMultiset<E>
    extends SynchronizedCollection<E>
    implements Multiset<E> {
        transient Set<E> elementSet;
        transient Set<Multiset.Entry<E>> entrySet;
        private static final long serialVersionUID = 0L;

        SynchronizedMultiset(Multiset<E> multiset, @Nullable Object object) {
            super(multiset, object);
        }

        @Override
        Multiset<E> delegate() {
            return (Multiset)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int count(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().count(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int add(E e, int n) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().add(e, n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int remove(Object object, int n) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().remove(object, n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int setCount(E e, int n) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().setCount(e, n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean setCount(E e, int n, int n2) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().setCount(e, n, n2);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<E> elementSet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.elementSet == null) {
                    this.elementSet = Synchronized.typePreservingSet(this.delegate().elementSet(), this.mutex);
                }
                return this.elementSet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Set<Multiset.Entry<E>> entrySet() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.typePreservingSet(this.delegate().entrySet(), this.mutex);
                }
                return this.entrySet;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().hashCode();
            }
        }
    }

    private static class SynchronizedRandomAccessList<E>
    extends SynchronizedList<E>
    implements RandomAccess {
        private static final long serialVersionUID = 0L;

        SynchronizedRandomAccessList(List<E> list, @Nullable Object object) {
            super(list, object);
        }
    }

    private static class SynchronizedList<E>
    extends SynchronizedCollection<E>
    implements List<E> {
        private static final long serialVersionUID = 0L;

        SynchronizedList(List<E> list, @Nullable Object object) {
            super(list, object);
        }

        @Override
        List<E> delegate() {
            return (List)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void add(int n, E e) {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().add(n, e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean addAll(int n, Collection<? extends E> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().addAll(n, collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E get(int n) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().get(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int indexOf(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().indexOf(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int lastIndexOf(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().lastIndexOf(object);
            }
        }

        @Override
        public ListIterator<E> listIterator() {
            return this.delegate().listIterator();
        }

        @Override
        public ListIterator<E> listIterator(int n) {
            return this.delegate().listIterator(n);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E remove(int n) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().remove(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E set(int n, E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().set(n, e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public List<E> subList(int n, int n2) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.list(this.delegate().subList(n, n2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().hashCode();
            }
        }
    }

    public static class SynchronizedSortedSet<E>
    extends SynchronizedSet<E>
    implements SortedSet<E> {
        private static final long serialVersionUID = 0L;

        SynchronizedSortedSet(SortedSet<E> sortedSet, @Nullable Object object) {
            super(sortedSet, object);
        }

        @Override
        SortedSet<E> delegate() {
            return (SortedSet)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Comparator<? super E> comparator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().comparator();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedSet<E> subSet(E e, E e2) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.sortedSet(this.delegate().subSet(e, e2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedSet<E> headSet(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.sortedSet(this.delegate().headSet(e), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public SortedSet<E> tailSet(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return Synchronized.sortedSet(this.delegate().tailSet(e), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E first() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().first();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public E last() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().last();
            }
        }
    }

    public static class SynchronizedSet<E>
    extends SynchronizedCollection<E>
    implements Set<E> {
        private static final long serialVersionUID = 0L;

        SynchronizedSet(Set<E> set, @Nullable Object object) {
            super(set, object);
        }

        @Override
        Set<E> delegate() {
            return (Set)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().hashCode();
            }
        }
    }

    @VisibleForTesting
    public static class SynchronizedCollection<E>
    extends SynchronizedObject
    implements Collection<E> {
        private static final long serialVersionUID = 0L;

        private SynchronizedCollection(Collection<E> collection, @Nullable Object object) {
            super(collection, object);
        }

        @Override
        Collection<E> delegate() {
            return (Collection)super.delegate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean add(E e) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().add(e);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().addAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void clear() {
            Object object = this.mutex;
            synchronized (object) {
                this.delegate().clear();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean contains(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().contains(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean containsAll(Collection<?> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().containsAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean isEmpty() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().isEmpty();
            }
        }

        @Override
        public Iterator<E> iterator() {
            return this.delegate().iterator();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean remove(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.delegate().remove(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean removeAll(Collection<?> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().removeAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean retainAll(Collection<?> collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().retainAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int size() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().size();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Object[] toArray() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().toArray();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public <T> T[] toArray(T[] TArray) {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate().toArray(TArray);
            }
        }
    }

    public static class SynchronizedObject
    implements Serializable {
        final Object delegate;
        final Object mutex;
        @GwtIncompatible(value="not needed in emulated source")
        private static final long serialVersionUID = 0L;

        SynchronizedObject(Object object, @Nullable Object object2) {
            this.delegate = Preconditions.checkNotNull(object);
            this.mutex = object2 == null ? this : object2;
        }

        Object delegate() {
            return this.delegate;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public String toString() {
            Object object = this.mutex;
            synchronized (object) {
                return this.delegate.toString();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Object object = this.mutex;
            synchronized (object) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }
}

