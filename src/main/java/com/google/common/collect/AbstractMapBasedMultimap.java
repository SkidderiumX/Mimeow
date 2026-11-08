/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class AbstractMapBasedMultimap<K, V>
extends AbstractMultimap<K, V>
implements Serializable {
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;
    private static final long serialVersionUID = 2447537837011683357L;

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }

    final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<Collection<V>> collection : map.values()) {
            Preconditions.checkArgument(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return this.unmodifiableCollectionSubclass(this.createCollection());
    }

    abstract Collection<V> createCollection();

    Collection<V> createCollection(@Nullable K k) {
        return this.createCollection();
    }

    Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override
    public int size() {
        return this.totalSize;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean put(@Nullable K k, @Nullable V v) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            collection = this.createCollection(k);
            if (collection.add(v)) {
                ++this.totalSize;
                this.map.put(k, collection);
                return true;
            }
            throw new AssertionError((Object)"New Collection violated the Collection spec");
        }
        if (collection.add(v)) {
            ++this.totalSize;
            return true;
        }
        return false;
    }

    private Collection<V> getOrCreateCollection(@Nullable K k) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            collection = this.createCollection(k);
            this.map.put(k, collection);
        }
        return collection;
    }

    @Override
    public Collection<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        Iterator<V> iterator2 = iterable.iterator();
        if (!iterator2.hasNext()) {
            return this.removeAll(k);
        }
        Collection<V> collection = this.getOrCreateCollection(k);
        Collection<V> collection2 = this.createCollection();
        collection2.addAll(collection);
        this.totalSize -= collection.size();
        collection.clear();
        while (iterator2.hasNext()) {
            if (!collection.add(iterator2.next())) continue;
            ++this.totalSize;
        }
        return this.unmodifiableCollectionSubclass(collection2);
    }

    @Override
    public Collection<V> removeAll(@Nullable Object object) {
        Collection<V> collection = this.map.remove(object);
        if (collection == null) {
            return this.createUnmodifiableEmptyCollection();
        }
        Collection<V> collection2 = this.createCollection();
        collection2.addAll(collection);
        this.totalSize -= collection.size();
        collection.clear();
        return this.unmodifiableCollectionSubclass(collection2);
    }

    Collection<V> unmodifiableCollectionSubclass(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet)collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set)collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List)collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    @Override
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override
    public Collection<V> get(@Nullable K k) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            collection = this.createCollection(k);
        }
        return this.wrapCollection(k, collection);
    }

    Collection<V> wrapCollection(@Nullable K k, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new WrappedSortedSet(k, (SortedSet)collection, null);
        }
        if (collection instanceof Set) {
            return new WrappedSet(k, (Set)collection);
        }
        if (collection instanceof List) {
            return this.wrapList(k, (List)collection, null);
        }
        return new WrappedCollection(k, collection, null);
    }

    private List<V> wrapList(@Nullable K k, List<V> list, @Nullable WrappedCollection wrappedCollection) {
        return list instanceof RandomAccess ? new RandomAccessWrappedList(k, list, wrappedCollection) : new WrappedList(k, list, wrappedCollection);
    }

    private Iterator<V> iteratorOrListIterator(Collection<V> collection) {
        return collection instanceof List ? ((List)collection).listIterator() : collection.iterator();
    }

    @Override
    Set<K> createKeySet() {
        return this.map instanceof SortedMap ? new SortedKeySet((SortedMap)this.map) : new KeySet(this.map);
    }

    private int removeValuesForKey(Object object) {
        Collection<V> collection = Maps.safeRemove(this.map, object);
        int n = 0;
        if (collection != null) {
            n = collection.size();
            collection.clear();
            this.totalSize -= n;
        }
        return n;
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }

    @Override
    Iterator<V> valueIterator() {
        return new Itr<V>(){

            @Override
            V output(K k, V v) {
                return v;
            }
        };
    }

    @Override
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new Itr<Map.Entry<K, V>>(){

            @Override
            Map.Entry<K, V> output(K k, V v) {
                return Maps.immutableEntry(k, v);
            }
        };
    }

    @Override
    Map<K, Collection<V>> createAsMap() {
        return this.map instanceof SortedMap ? new SortedAsMap((SortedMap)this.map) : new AsMap(this.map);
    }

    @GwtIncompatible(value="NavigableAsMap")
    public class NavigableAsMap
    extends SortedAsMap
    implements NavigableMap<K, Collection<V>> {
        NavigableAsMap(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap)super.sortedMap();
        }

        @Override
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry entry = this.sortedMap().lowerEntry(k);
            return entry == null ? null : this.wrapEntry(entry);
        }

        @Override
        public K lowerKey(K k) {
            return this.sortedMap().lowerKey(k);
        }

        @Override
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry entry = this.sortedMap().floorEntry(k);
            return entry == null ? null : this.wrapEntry(entry);
        }

        @Override
        public K floorKey(K k) {
            return this.sortedMap().floorKey(k);
        }

        @Override
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry entry = this.sortedMap().ceilingEntry(k);
            return entry == null ? null : this.wrapEntry(entry);
        }

        @Override
        public K ceilingKey(K k) {
            return this.sortedMap().ceilingKey(k);
        }

        @Override
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry entry = this.sortedMap().higherEntry(k);
            return entry == null ? null : this.wrapEntry(entry);
        }

        @Override
        public K higherKey(K k) {
            return this.sortedMap().higherKey(k);
        }

        @Override
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry entry = this.sortedMap().firstEntry();
            return entry == null ? null : this.wrapEntry(entry);
        }

        @Override
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry entry = this.sortedMap().lastEntry();
            return entry == null ? null : this.wrapEntry(entry);
        }

        @Override
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return this.pollAsMapEntry(this.entrySet().iterator());
        }

        @Override
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return this.pollAsMapEntry(this.descendingMap().entrySet().iterator());
        }

        Map.Entry<K, Collection<V>> pollAsMapEntry(Iterator<Map.Entry<K, Collection<V>>> iterator2) {
            if (!iterator2.hasNext()) {
                return null;
            }
            Map.Entry entry = iterator2.next();
            Collection collection = AbstractMapBasedMultimap.this.createCollection();
            collection.addAll(entry.getValue());
            iterator2.remove();
            return Maps.immutableEntry(entry.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(collection));
        }

        @Override
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(this.sortedMap().descendingMap());
        }

        @Override
        public NavigableSet<K> keySet() {
            return (NavigableSet)super.keySet();
        }

        @Override
        NavigableSet<K> createKeySet() {
            return new NavigableKeySet(this.sortedMap());
        }

        @Override
        public NavigableSet<K> navigableKeySet() {
            return this.keySet();
        }

        @Override
        public NavigableSet<K> descendingKeySet() {
            return this.descendingMap().navigableKeySet();
        }

        @Override
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return this.subMap(k, true, k2, false);
        }

        @Override
        public NavigableMap<K, Collection<V>> subMap(K k, boolean bl, K k2, boolean bl2) {
            return new NavigableAsMap(this.sortedMap().subMap(k, bl, k2, bl2));
        }

        @Override
        public NavigableMap<K, Collection<V>> headMap(K k) {
            return this.headMap(k, false);
        }

        @Override
        public NavigableMap<K, Collection<V>> headMap(K k, boolean bl) {
            return new NavigableAsMap(this.sortedMap().headMap(k, bl));
        }

        @Override
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return this.tailMap(k, true);
        }

        @Override
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean bl) {
            return new NavigableAsMap(this.sortedMap().tailMap(k, bl));
        }
    }

    private class SortedAsMap
    extends AsMap
    implements SortedMap<K, Collection<V>> {
        SortedSet<K> sortedKeySet;

        SortedAsMap(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap)this.submap;
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.sortedMap().comparator();
        }

        @Override
        public K firstKey() {
            return this.sortedMap().firstKey();
        }

        @Override
        public K lastKey() {
            return this.sortedMap().lastKey();
        }

        @Override
        public SortedMap<K, Collection<V>> headMap(K k) {
            return new SortedAsMap(this.sortedMap().headMap(k));
        }

        @Override
        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new SortedAsMap(this.sortedMap().subMap(k, k2));
        }

        @Override
        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new SortedAsMap(this.sortedMap().tailMap(k));
        }

        @Override
        public SortedSet<K> keySet() {
            SortedSet sortedSet = this.sortedKeySet;
            return sortedSet == null ? (this.sortedKeySet = this.createKeySet()) : sortedSet;
        }

        @Override
        SortedSet<K> createKeySet() {
            return new SortedKeySet(this.sortedMap());
        }
    }

    private class AsMap
    extends Maps.ImprovedAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> submap;

        AsMap(Map<K, Collection<V>> map) {
            this.submap = map;
        }

        @Override
        protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new AsMapEntries();
        }

        @Override
        public boolean containsKey(Object object) {
            return Maps.safeContainsKey(this.submap, object);
        }

        @Override
        public Collection<V> get(Object object) {
            Collection collection = Maps.safeGet(this.submap, object);
            if (collection == null) {
                return null;
            }
            Object object2 = object;
            return AbstractMapBasedMultimap.this.wrapCollection(object2, collection);
        }

        @Override
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override
        public int size() {
            return this.submap.size();
        }

        @Override
        public Collection<V> remove(Object object) {
            Collection collection = this.submap.remove(object);
            if (collection == null) {
                return null;
            }
            Collection collection2 = AbstractMapBasedMultimap.this.createCollection();
            collection2.addAll(collection);
            AbstractMapBasedMultimap.this.totalSize -= collection.size();
            collection.clear();
            return collection2;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return this == object || this.submap.equals(object);
        }

        @Override
        public int hashCode() {
            return this.submap.hashCode();
        }

        @Override
        public String toString() {
            return this.submap.toString();
        }

        @Override
        public void clear() {
            if (this.submap == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.clear(new AsMapIterator());
            }
        }

        Map.Entry<K, Collection<V>> wrapEntry(Map.Entry<K, Collection<V>> entry) {
            Object k = entry.getKey();
            return Maps.immutableEntry(k, AbstractMapBasedMultimap.this.wrapCollection(k, entry.getValue()));
        }

        public class AsMapIterator
        implements Iterator<Map.Entry<K, Collection<V>>> {
            final Iterator<Map.Entry<K, Collection<V>>> delegateIterator;
            Collection<V> collection;

            AsMapIterator() {
                this.delegateIterator = AsMap.this.submap.entrySet().iterator();
            }

            @Override
            public boolean hasNext() {
                return this.delegateIterator.hasNext();
            }

            @Override
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry entry = this.delegateIterator.next();
                this.collection = entry.getValue();
                return AsMap.this.wrapEntry(entry);
            }

            @Override
            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.this.totalSize -= this.collection.size();
                this.collection.clear();
            }
        }

        public class AsMapEntries
        extends Maps.EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            @Override
            Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            @Override
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }

            @Override
            public boolean contains(Object object) {
                return Collections2.safeContains(AsMap.this.submap.entrySet(), object);
            }

            @Override
            public boolean remove(Object object) {
                if (!this.contains(object)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry)object;
                AbstractMapBasedMultimap.this.removeValuesForKey(entry.getKey());
                return true;
            }
        }
    }

    private abstract class Itr<T>
    implements Iterator<T> {
        final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
        K key;
        Collection<V> collection;
        Iterator<V> valueIterator;

        Itr() {
            this.keyIterator = AbstractMapBasedMultimap.this.map.entrySet().iterator();
            this.key = null;
            this.collection = null;
            this.valueIterator = Iterators.emptyModifiableIterator();
        }

        abstract T output(K var1, V var2);

        @Override
        public boolean hasNext() {
            return this.keyIterator.hasNext() || this.valueIterator.hasNext();
        }

        @Override
        public T next() {
            if (!this.valueIterator.hasNext()) {
                Map.Entry entry = this.keyIterator.next();
                this.key = entry.getKey();
                this.collection = entry.getValue();
                this.valueIterator = this.collection.iterator();
            }
            return this.output(this.key, this.valueIterator.next());
        }

        @Override
        public void remove() {
            this.valueIterator.remove();
            if (this.collection.isEmpty()) {
                this.keyIterator.remove();
            }
            AbstractMapBasedMultimap.this.totalSize--;
        }
    }

    @GwtIncompatible(value="NavigableSet")
    public class NavigableKeySet
    extends SortedKeySet
    implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap)super.sortedMap();
        }

        @Override
        public K lower(K k) {
            return this.sortedMap().lowerKey(k);
        }

        @Override
        public K floor(K k) {
            return this.sortedMap().floorKey(k);
        }

        @Override
        public K ceiling(K k) {
            return this.sortedMap().ceilingKey(k);
        }

        @Override
        public K higher(K k) {
            return this.sortedMap().higherKey(k);
        }

        @Override
        public K pollFirst() {
            return Iterators.pollNext(this.iterator());
        }

        @Override
        public K pollLast() {
            return Iterators.pollNext(this.descendingIterator());
        }

        @Override
        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(this.sortedMap().descendingMap());
        }

        @Override
        public Iterator<K> descendingIterator() {
            return this.descendingSet().iterator();
        }

        @Override
        public NavigableSet<K> headSet(K k) {
            return this.headSet((K)k, false);
        }

        @Override
        public NavigableSet<K> headSet(K k, boolean bl) {
            return new NavigableKeySet(this.sortedMap().headMap(k, bl));
        }

        @Override
        public NavigableSet<K> subSet(K k, K k2) {
            return this.subSet((K)k, true, (K)k2, false);
        }

        @Override
        public NavigableSet<K> subSet(K k, boolean bl, K k2, boolean bl2) {
            return new NavigableKeySet(this.sortedMap().subMap(k, bl, k2, bl2));
        }

        @Override
        public NavigableSet<K> tailSet(K k) {
            return this.tailSet((K)k, true);
        }

        @Override
        public NavigableSet<K> tailSet(K k, boolean bl) {
            return new NavigableKeySet(this.sortedMap().tailMap(k, bl));
        }
    }

    private class SortedKeySet
    extends KeySet
    implements SortedSet<K> {
        SortedKeySet(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap)super.map();
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.sortedMap().comparator();
        }

        @Override
        public K first() {
            return this.sortedMap().firstKey();
        }

        @Override
        public SortedSet<K> headSet(K k) {
            return new SortedKeySet(this.sortedMap().headMap(k));
        }

        @Override
        public K last() {
            return this.sortedMap().lastKey();
        }

        @Override
        public SortedSet<K> subSet(K k, K k2) {
            return new SortedKeySet(this.sortedMap().subMap(k, k2));
        }

        @Override
        public SortedSet<K> tailSet(K k) {
            return new SortedKeySet(this.sortedMap().tailMap(k));
        }
    }

    private class KeySet
    extends Maps.KeySet<K, Collection<V>> {
        KeySet(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override
        public Iterator<K> iterator() {
            final Iterator iterator2 = this.map().entrySet().iterator();
            return new Iterator<K>(){
                Map.Entry<K, Collection<V>> entry;

                @Override
                public boolean hasNext() {
                    return iterator2.hasNext();
                }

                @Override
                public K next() {
                    this.entry = (Map.Entry)iterator2.next();
                    return this.entry.getKey();
                }

                @Override
                public void remove() {
                    CollectPreconditions.checkRemove(this.entry != null);
                    Collection collection = this.entry.getValue();
                    iterator2.remove();
                    AbstractMapBasedMultimap.this.totalSize -= collection.size();
                    collection.clear();
                }
            };
        }

        @Override
        public boolean remove(Object object) {
            int n = 0;
            Collection collection = (Collection)this.map().remove(object);
            if (collection != null) {
                n = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.this.totalSize -= n;
            }
            return n > 0;
        }

        @Override
        public void clear() {
            Iterators.clear(this.iterator());
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return this.map().keySet().containsAll(collection);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return this == object || this.map().keySet().equals(object);
        }

        @Override
        public int hashCode() {
            return this.map().keySet().hashCode();
        }
    }

    private class RandomAccessWrappedList
    extends WrappedList
    implements RandomAccess {
        RandomAccessWrappedList(K k, @Nullable List<V> list, WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }
    }

    private class WrappedList
    extends WrappedCollection
    implements List<V> {
        WrappedList(K k, @Nullable List<V> list, WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }

        List<V> getListDelegate() {
            return (List)this.getDelegate();
        }

        @Override
        public boolean addAll(int n, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int n2 = this.size();
            boolean bl = this.getListDelegate().addAll(n, collection);
            if (bl) {
                int n3 = this.getDelegate().size();
                AbstractMapBasedMultimap.this.totalSize += n3 - n2;
                if (n2 == 0) {
                    this.addToMap();
                }
            }
            return bl;
        }

        @Override
        public V get(int n) {
            this.refreshIfEmpty();
            return this.getListDelegate().get(n);
        }

        @Override
        public V set(int n, V v) {
            this.refreshIfEmpty();
            return this.getListDelegate().set(n, v);
        }

        @Override
        public void add(int n, V v) {
            this.refreshIfEmpty();
            boolean bl = this.getDelegate().isEmpty();
            this.getListDelegate().add(n, v);
            AbstractMapBasedMultimap.this.totalSize++;
            if (bl) {
                this.addToMap();
            }
        }

        @Override
        public V remove(int n) {
            this.refreshIfEmpty();
            Object v = this.getListDelegate().remove(n);
            AbstractMapBasedMultimap.this.totalSize--;
            this.removeIfEmpty();
            return v;
        }

        @Override
        public int indexOf(Object object) {
            this.refreshIfEmpty();
            return this.getListDelegate().indexOf(object);
        }

        @Override
        public int lastIndexOf(Object object) {
            this.refreshIfEmpty();
            return this.getListDelegate().lastIndexOf(object);
        }

        @Override
        public ListIterator<V> listIterator() {
            this.refreshIfEmpty();
            return new WrappedListIterator();
        }

        @Override
        public ListIterator<V> listIterator(int n) {
            this.refreshIfEmpty();
            return new WrappedListIterator(n);
        }

        @Override
        public List<V> subList(int n, int n2) {
            this.refreshIfEmpty();
            return AbstractMapBasedMultimap.this.wrapList(this.getKey(), this.getListDelegate().subList(n, n2), this.getAncestor() == null ? this : this.getAncestor());
        }

        /*
         * Signature claims super is com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection.WrappedIterator, not com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator - discarding signature.
         */
        private class WrappedListIterator
        extends WrappedCollection.WrappedIterator
        implements ListIterator {
            WrappedListIterator() {
            }

            public WrappedListIterator(int n) {
                super(WrappedList.this.getListDelegate().listIterator(n));
            }

            private ListIterator<V> getDelegateListIterator() {
                return (ListIterator)this.getDelegateIterator();
            }

            @Override
            public boolean hasPrevious() {
                return this.getDelegateListIterator().hasPrevious();
            }

            public V previous() {
                return this.getDelegateListIterator().previous();
            }

            @Override
            public int nextIndex() {
                return this.getDelegateListIterator().nextIndex();
            }

            @Override
            public int previousIndex() {
                return this.getDelegateListIterator().previousIndex();
            }

            public void set(V v) {
                this.getDelegateListIterator().set(v);
            }

            public void add(V v) {
                boolean bl = WrappedList.this.isEmpty();
                this.getDelegateListIterator().add(v);
                AbstractMapBasedMultimap.this.totalSize++;
                if (bl) {
                    WrappedList.this.addToMap();
                }
            }
        }
    }

    @GwtIncompatible(value="NavigableSet")
    public class WrappedNavigableSet
    extends WrappedSortedSet
    implements NavigableSet<V> {
        WrappedNavigableSet(K k, @Nullable NavigableSet<V> navigableSet, WrappedCollection wrappedCollection) {
            super(k, navigableSet, wrappedCollection);
        }

        NavigableSet<V> getSortedSetDelegate() {
            return (NavigableSet)super.getSortedSetDelegate();
        }

        @Override
        public V lower(V v) {
            return this.getSortedSetDelegate().lower(v);
        }

        @Override
        public V floor(V v) {
            return this.getSortedSetDelegate().floor(v);
        }

        @Override
        public V ceiling(V v) {
            return this.getSortedSetDelegate().ceiling(v);
        }

        @Override
        public V higher(V v) {
            return this.getSortedSetDelegate().higher(v);
        }

        @Override
        public V pollFirst() {
            return Iterators.pollNext(this.iterator());
        }

        @Override
        public V pollLast() {
            return Iterators.pollNext(this.descendingIterator());
        }

        private NavigableSet<V> wrap(NavigableSet<V> navigableSet) {
            return new WrappedNavigableSet(this.key, navigableSet, this.getAncestor() == null ? this : this.getAncestor());
        }

        @Override
        public NavigableSet<V> descendingSet() {
            return this.wrap(this.getSortedSetDelegate().descendingSet());
        }

        @Override
        public Iterator<V> descendingIterator() {
            return new WrappedCollection.WrappedIterator(this.getSortedSetDelegate().descendingIterator());
        }

        @Override
        public NavigableSet<V> subSet(V v, boolean bl, V v2, boolean bl2) {
            return this.wrap(this.getSortedSetDelegate().subSet(v, bl, v2, bl2));
        }

        @Override
        public NavigableSet<V> headSet(V v, boolean bl) {
            return this.wrap(this.getSortedSetDelegate().headSet(v, bl));
        }

        @Override
        public NavigableSet<V> tailSet(V v, boolean bl) {
            return this.wrap(this.getSortedSetDelegate().tailSet(v, bl));
        }
    }

    private class WrappedSortedSet
    extends WrappedCollection
    implements SortedSet<V> {
        WrappedSortedSet(K k, @Nullable SortedSet<V> sortedSet, WrappedCollection wrappedCollection) {
            super(k, sortedSet, wrappedCollection);
        }

        SortedSet<V> getSortedSetDelegate() {
            return (SortedSet)this.getDelegate();
        }

        @Override
        public Comparator<? super V> comparator() {
            return this.getSortedSetDelegate().comparator();
        }

        @Override
        public V first() {
            this.refreshIfEmpty();
            return this.getSortedSetDelegate().first();
        }

        @Override
        public V last() {
            this.refreshIfEmpty();
            return this.getSortedSetDelegate().last();
        }

        @Override
        public SortedSet<V> headSet(V v) {
            this.refreshIfEmpty();
            return new WrappedSortedSet(this.getKey(), this.getSortedSetDelegate().headSet(v), this.getAncestor() == null ? this : this.getAncestor());
        }

        @Override
        public SortedSet<V> subSet(V v, V v2) {
            this.refreshIfEmpty();
            return new WrappedSortedSet(this.getKey(), this.getSortedSetDelegate().subSet(v, v2), this.getAncestor() == null ? this : this.getAncestor());
        }

        @Override
        public SortedSet<V> tailSet(V v) {
            this.refreshIfEmpty();
            return new WrappedSortedSet(this.getKey(), this.getSortedSetDelegate().tailSet(v), this.getAncestor() == null ? this : this.getAncestor());
        }
    }

    private class WrappedSet
    extends WrappedCollection
    implements Set<V> {
        WrappedSet(K k, Set<V> set) {
            super(k, set, null);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int n = this.size();
            boolean bl = Sets.removeAllImpl((Set)this.delegate, collection);
            if (bl) {
                int n2 = this.delegate.size();
                AbstractMapBasedMultimap.this.totalSize += n2 - n;
                this.removeIfEmpty();
            }
            return bl;
        }
    }

    private class WrappedCollection
    extends AbstractCollection<V> {
        final K key;
        Collection<V> delegate;
        final WrappedCollection ancestor;
        final Collection<V> ancestorDelegate;

        WrappedCollection(K k, @Nullable Collection<V> collection, WrappedCollection wrappedCollection) {
            this.key = k;
            this.delegate = collection;
            this.ancestor = wrappedCollection;
            this.ancestorDelegate = wrappedCollection == null ? null : wrappedCollection.getDelegate();
        }

        void refreshIfEmpty() {
            Collection collection;
            if (this.ancestor != null) {
                this.ancestor.refreshIfEmpty();
                if (this.ancestor.getDelegate() != this.ancestorDelegate) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.delegate.isEmpty() && (collection = (Collection)AbstractMapBasedMultimap.this.map.get(this.key)) != null) {
                this.delegate = collection;
            }
        }

        void removeIfEmpty() {
            if (this.ancestor != null) {
                this.ancestor.removeIfEmpty();
            } else if (this.delegate.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.key);
            }
        }

        K getKey() {
            return this.key;
        }

        void addToMap() {
            if (this.ancestor != null) {
                this.ancestor.addToMap();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.key, this.delegate);
            }
        }

        @Override
        public int size() {
            this.refreshIfEmpty();
            return this.delegate.size();
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object == this) {
                return true;
            }
            this.refreshIfEmpty();
            return this.delegate.equals(object);
        }

        @Override
        public int hashCode() {
            this.refreshIfEmpty();
            return this.delegate.hashCode();
        }

        @Override
        public String toString() {
            this.refreshIfEmpty();
            return this.delegate.toString();
        }

        Collection<V> getDelegate() {
            return this.delegate;
        }

        @Override
        public Iterator<V> iterator() {
            this.refreshIfEmpty();
            return new WrappedIterator();
        }

        @Override
        public boolean add(V v) {
            this.refreshIfEmpty();
            boolean bl = this.delegate.isEmpty();
            boolean bl2 = this.delegate.add(v);
            if (bl2) {
                AbstractMapBasedMultimap.this.totalSize++;
                if (bl) {
                    this.addToMap();
                }
            }
            return bl2;
        }

        WrappedCollection getAncestor() {
            return this.ancestor;
        }

        @Override
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int n = this.size();
            boolean bl = this.delegate.addAll(collection);
            if (bl) {
                int n2 = this.delegate.size();
                AbstractMapBasedMultimap.this.totalSize += n2 - n;
                if (n == 0) {
                    this.addToMap();
                }
            }
            return bl;
        }

        @Override
        public boolean contains(Object object) {
            this.refreshIfEmpty();
            return this.delegate.contains(object);
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            this.refreshIfEmpty();
            return this.delegate.containsAll(collection);
        }

        @Override
        public void clear() {
            int n = this.size();
            if (n == 0) {
                return;
            }
            this.delegate.clear();
            AbstractMapBasedMultimap.this.totalSize -= n;
            this.removeIfEmpty();
        }

        @Override
        public boolean remove(Object object) {
            this.refreshIfEmpty();
            boolean bl = this.delegate.remove(object);
            if (bl) {
                AbstractMapBasedMultimap.this.totalSize--;
                this.removeIfEmpty();
            }
            return bl;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int n = this.size();
            boolean bl = this.delegate.removeAll(collection);
            if (bl) {
                int n2 = this.delegate.size();
                AbstractMapBasedMultimap.this.totalSize += n2 - n;
                this.removeIfEmpty();
            }
            return bl;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            int n = this.size();
            boolean bl = this.delegate.retainAll(collection);
            if (bl) {
                int n2 = this.delegate.size();
                AbstractMapBasedMultimap.this.totalSize += n2 - n;
                this.removeIfEmpty();
            }
            return bl;
        }

        public class WrappedIterator
        implements Iterator<V> {
            final Iterator<V> delegateIterator;
            final Collection<V> originalDelegate;

            WrappedIterator() {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = AbstractMapBasedMultimap.this.iteratorOrListIterator(WrappedCollection.this.delegate);
            }

            WrappedIterator(Iterator<V> iterator2) {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = iterator2;
            }

            void validateIterator() {
                WrappedCollection.this.refreshIfEmpty();
                if (WrappedCollection.this.delegate != this.originalDelegate) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                this.validateIterator();
                return this.delegateIterator.hasNext();
            }

            @Override
            public V next() {
                this.validateIterator();
                return this.delegateIterator.next();
            }

            @Override
            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.this.totalSize--;
                WrappedCollection.this.removeIfEmpty();
            }

            Iterator<V> getDelegateIterator() {
                this.validateIterator();
                return this.delegateIterator;
            }
        }
    }
}

