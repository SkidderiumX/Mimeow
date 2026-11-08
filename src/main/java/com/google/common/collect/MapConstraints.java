/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public class MapConstraints {
    private MapConstraints() {
    }

    public static MapConstraint<Object, Object> notNull() {
        return NotNullMapConstraint.INSTANCE;
    }

    public static <K, V> Map<K, V> constrainedMap(Map<K, V> map, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedMap<K, V>(map, mapConstraint);
    }

    public static <K, V> Multimap<K, V> constrainedMultimap(Multimap<K, V> multimap, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedMultimap<K, V>(multimap, mapConstraint);
    }

    public static <K, V> ListMultimap<K, V> constrainedListMultimap(ListMultimap<K, V> listMultimap, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedListMultimap<K, V>(listMultimap, mapConstraint);
    }

    public static <K, V> SetMultimap<K, V> constrainedSetMultimap(SetMultimap<K, V> setMultimap, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedSetMultimap<K, V>(setMultimap, mapConstraint);
    }

    public static <K, V> SortedSetMultimap<K, V> constrainedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedSortedSetMultimap<K, V>(sortedSetMultimap, mapConstraint);
    }

    private static <K, V> Map.Entry<K, V> constrainedEntry(final Map.Entry<K, V> entry, final MapConstraint<? super K, ? super V> mapConstraint) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkNotNull(mapConstraint);
        return new ForwardingMapEntry<K, V>(){

            @Override
            protected Map.Entry<K, V> delegate() {
                return entry;
            }

            @Override
            public V setValue(V v) {
                mapConstraint.checkKeyValue(this.getKey(), v);
                return entry.setValue(v);
            }
        };
    }

    private static <K, V> Map.Entry<K, Collection<V>> constrainedAsMapEntry(final Map.Entry<K, Collection<V>> entry, final MapConstraint<? super K, ? super V> mapConstraint) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkNotNull(mapConstraint);
        return new ForwardingMapEntry<K, Collection<V>>(){

            @Override
            protected Map.Entry<K, Collection<V>> delegate() {
                return entry;
            }

            @Override
            public Collection<V> getValue() {
                return Constraints.constrainedTypePreservingCollection((Collection)entry.getValue(), new Constraint<V>(){

                    @Override
                    public V checkElement(V v) {
                        mapConstraint.checkKeyValue(this.getKey(), v);
                        return v;
                    }
                });
            }
        };
    }

    private static <K, V> Set<Map.Entry<K, Collection<V>>> constrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedAsMapEntries<K, V>(set, mapConstraint);
    }

    private static <K, V> Collection<Map.Entry<K, V>> constrainedEntries(Collection<Map.Entry<K, V>> collection, MapConstraint<? super K, ? super V> mapConstraint) {
        if (collection instanceof Set) {
            return MapConstraints.constrainedEntrySet((Set)collection, mapConstraint);
        }
        return new ConstrainedEntries<K, V>(collection, mapConstraint);
    }

    private static <K, V> Set<Map.Entry<K, V>> constrainedEntrySet(Set<Map.Entry<K, V>> set, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedEntrySet<K, V>(set, mapConstraint);
    }

    public static <K, V> BiMap<K, V> constrainedBiMap(BiMap<K, V> biMap, MapConstraint<? super K, ? super V> mapConstraint) {
        return new ConstrainedBiMap<K, V>(biMap, null, mapConstraint);
    }

    private static <K, V> Collection<V> checkValues(K k, Iterable<? extends V> iterable, MapConstraint<? super K, ? super V> mapConstraint) {
        ArrayList arrayList = Lists.newArrayList(iterable);
        for (Object e : arrayList) {
            mapConstraint.checkKeyValue(k, e);
        }
        return arrayList;
    }

    private static <K, V> Map<K, V> checkMap(Map<? extends K, ? extends V> map, MapConstraint<? super K, ? super V> mapConstraint) {
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<K, V>(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            mapConstraint.checkKeyValue(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    private static class ConstrainedSortedSetMultimap<K, V>
    extends ConstrainedSetMultimap<K, V>
    implements SortedSetMultimap<K, V> {
        ConstrainedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, MapConstraint<? super K, ? super V> mapConstraint) {
            super(sortedSetMultimap, mapConstraint);
        }

        @Override
        public SortedSet<V> get(K k) {
            return (SortedSet)super.get((Object)k);
        }

        @Override
        public SortedSet<V> removeAll(Object object) {
            return (SortedSet)super.removeAll(object);
        }

        @Override
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            return (SortedSet)super.replaceValues((Object)k, (Iterable)iterable);
        }

        @Override
        public Comparator<? super V> valueComparator() {
            return ((SortedSetMultimap)this.delegate()).valueComparator();
        }
    }

    private static class ConstrainedSetMultimap<K, V>
    extends ConstrainedMultimap<K, V>
    implements SetMultimap<K, V> {
        ConstrainedSetMultimap(SetMultimap<K, V> setMultimap, MapConstraint<? super K, ? super V> mapConstraint) {
            super(setMultimap, mapConstraint);
        }

        @Override
        public Set<V> get(K k) {
            return (Set)super.get(k);
        }

        @Override
        public Set<Map.Entry<K, V>> entries() {
            return (Set)super.entries();
        }

        @Override
        public Set<V> removeAll(Object object) {
            return (Set)super.removeAll(object);
        }

        @Override
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            return (Set)super.replaceValues(k, iterable);
        }
    }

    private static class ConstrainedListMultimap<K, V>
    extends ConstrainedMultimap<K, V>
    implements ListMultimap<K, V> {
        ConstrainedListMultimap(ListMultimap<K, V> listMultimap, MapConstraint<? super K, ? super V> mapConstraint) {
            super(listMultimap, mapConstraint);
        }

        @Override
        public List<V> get(K k) {
            return (List)super.get(k);
        }

        @Override
        public List<V> removeAll(Object object) {
            return (List)super.removeAll(object);
        }

        @Override
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            return (List)super.replaceValues(k, iterable);
        }
    }

    public static class ConstrainedAsMapEntries<K, V>
    extends ForwardingSet<Map.Entry<K, Collection<V>>> {
        private final MapConstraint<? super K, ? super V> constraint;
        private final Set<Map.Entry<K, Collection<V>>> entries;

        ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, MapConstraint<? super K, ? super V> mapConstraint) {
            this.entries = set;
            this.constraint = mapConstraint;
        }

        @Override
        protected Set<Map.Entry<K, Collection<V>>> delegate() {
            return this.entries;
        }

        @Override
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> iterator2 = this.entries.iterator();
            return new ForwardingIterator<Map.Entry<K, Collection<V>>>(){

                @Override
                public Map.Entry<K, Collection<V>> next() {
                    return MapConstraints.constrainedAsMapEntry((Map.Entry)iterator2.next(), ConstrainedAsMapEntries.this.constraint);
                }

                @Override
                protected Iterator<Map.Entry<K, Collection<V>>> delegate() {
                    return iterator2;
                }
            };
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
        public boolean contains(Object object) {
            return Maps.containsEntryImpl(this.delegate(), object);
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return this.standardContainsAll(collection);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return this.standardEquals(object);
        }

        @Override
        public int hashCode() {
            return this.standardHashCode();
        }

        @Override
        public boolean remove(Object object) {
            return Maps.removeEntryImpl(this.delegate(), object);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return this.standardRemoveAll(collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return this.standardRetainAll(collection);
        }
    }

    public static class ConstrainedEntrySet<K, V>
    extends ConstrainedEntries<K, V>
    implements Set<Map.Entry<K, V>> {
        ConstrainedEntrySet(Set<Map.Entry<K, V>> set, MapConstraint<? super K, ? super V> mapConstraint) {
            super(set, mapConstraint);
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

    private static class ConstrainedEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>> {
        final MapConstraint<? super K, ? super V> constraint;
        final Collection<Map.Entry<K, V>> entries;

        ConstrainedEntries(Collection<Map.Entry<K, V>> collection, MapConstraint<? super K, ? super V> mapConstraint) {
            this.entries = collection;
            this.constraint = mapConstraint;
        }

        @Override
        protected Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            final Iterator<Map.Entry<K, V>> iterator2 = this.entries.iterator();
            return new ForwardingIterator<Map.Entry<K, V>>(){

                @Override
                public Map.Entry<K, V> next() {
                    return MapConstraints.constrainedEntry((Map.Entry)iterator2.next(), ConstrainedEntries.this.constraint);
                }

                @Override
                protected Iterator<Map.Entry<K, V>> delegate() {
                    return iterator2;
                }
            };
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
        public boolean contains(Object object) {
            return Maps.containsEntryImpl(this.delegate(), object);
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return this.standardContainsAll(collection);
        }

        @Override
        public boolean remove(Object object) {
            return Maps.removeEntryImpl(this.delegate(), object);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return this.standardRemoveAll(collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return this.standardRetainAll(collection);
        }
    }

    private static class ConstrainedAsMapValues<K, V>
    extends ForwardingCollection<Collection<V>> {
        final Collection<Collection<V>> delegate;
        final Set<Map.Entry<K, Collection<V>>> entrySet;

        ConstrainedAsMapValues(Collection<Collection<V>> collection, Set<Map.Entry<K, Collection<V>>> set) {
            this.delegate = collection;
            this.entrySet = set;
        }

        @Override
        protected Collection<Collection<V>> delegate() {
            return this.delegate;
        }

        @Override
        public Iterator<Collection<V>> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> iterator2 = this.entrySet.iterator();
            return new Iterator<Collection<V>>(){

                @Override
                public boolean hasNext() {
                    return iterator2.hasNext();
                }

                @Override
                public Collection<V> next() {
                    return (Collection)((Map.Entry)iterator2.next()).getValue();
                }

                @Override
                public void remove() {
                    iterator2.remove();
                }
            };
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
        public boolean contains(Object object) {
            return this.standardContains(object);
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return this.standardContainsAll(collection);
        }

        @Override
        public boolean remove(Object object) {
            return this.standardRemove(object);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return this.standardRemoveAll(collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return this.standardRetainAll(collection);
        }
    }

    private static class ConstrainedMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable {
        final MapConstraint<? super K, ? super V> constraint;
        final Multimap<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;
        transient Map<K, Collection<V>> asMap;

        public ConstrainedMultimap(Multimap<K, V> multimap, MapConstraint<? super K, ? super V> mapConstraint) {
            this.delegate = Preconditions.checkNotNull(multimap);
            this.constraint = Preconditions.checkNotNull(mapConstraint);
        }

        @Override
        protected Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override
        public Map<K, Collection<V>> asMap() {
            ForwardingMap forwardingMap = this.asMap;
            if (forwardingMap == null) {
                final Map<K, Collection<V>> map = this.delegate.asMap();
                this.asMap = forwardingMap = new ForwardingMap<K, Collection<V>>(){
                    Set<Map.Entry<K, Collection<V>>> entrySet;
                    Collection<Collection<V>> values;

                    @Override
                    protected Map<K, Collection<V>> delegate() {
                        return map;
                    }

                    @Override
                    public Set<Map.Entry<K, Collection<V>>> entrySet() {
                        Set set = this.entrySet;
                        if (set == null) {
                            this.entrySet = set = MapConstraints.constrainedAsMapEntries(map.entrySet(), ConstrainedMultimap.this.constraint);
                        }
                        return set;
                    }

                    @Override
                    public Collection<V> get(Object object) {
                        try {
                            Collection collection = ConstrainedMultimap.this.get(object);
                            return collection.isEmpty() ? null : collection;
                        }
                        catch (ClassCastException classCastException) {
                            return null;
                        }
                    }

                    @Override
                    public Collection<Collection<V>> values() {
                        Collection collection = this.values;
                        if (collection == null) {
                            this.values = collection = new ConstrainedAsMapValues(this.delegate().values(), this.entrySet());
                        }
                        return collection;
                    }

                    @Override
                    public boolean containsValue(Object object) {
                        return this.values().contains(object);
                    }
                };
            }
            return forwardingMap;
        }

        @Override
        public Collection<Map.Entry<K, V>> entries() {
            Collection collection = this.entries;
            if (collection == null) {
                this.entries = collection = MapConstraints.constrainedEntries(this.delegate.entries(), this.constraint);
            }
            return collection;
        }

        @Override
        public Collection<V> get(final K k) {
            return Constraints.constrainedTypePreservingCollection(this.delegate.get(k), new Constraint<V>(){

                @Override
                public V checkElement(V v) {
                    ConstrainedMultimap.this.constraint.checkKeyValue(k, v);
                    return v;
                }
            });
        }

        @Override
        public boolean put(K k, V v) {
            this.constraint.checkKeyValue(k, v);
            return this.delegate.put(k, v);
        }

        @Override
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            return this.delegate.putAll(k, MapConstraints.checkValues(k, iterable, this.constraint));
        }

        @Override
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            boolean bl = false;
            for (Map.Entry<K, V> entry : multimap.entries()) {
                bl |= this.put(entry.getKey(), entry.getValue());
            }
            return bl;
        }

        @Override
        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            return this.delegate.replaceValues(k, MapConstraints.checkValues(k, iterable, this.constraint));
        }
    }

    private static class InverseConstraint<K, V>
    implements MapConstraint<K, V> {
        final MapConstraint<? super V, ? super K> constraint;

        public InverseConstraint(MapConstraint<? super V, ? super K> mapConstraint) {
            this.constraint = Preconditions.checkNotNull(mapConstraint);
        }

        @Override
        public void checkKeyValue(K k, V v) {
            this.constraint.checkKeyValue(v, k);
        }
    }

    private static class ConstrainedBiMap<K, V>
    extends ConstrainedMap<K, V>
    implements BiMap<K, V> {
        volatile BiMap<V, K> inverse;

        ConstrainedBiMap(BiMap<K, V> biMap, @Nullable BiMap<V, K> biMap2, MapConstraint<? super K, ? super V> mapConstraint) {
            super(biMap, mapConstraint);
            this.inverse = biMap2;
        }

        @Override
        protected BiMap<K, V> delegate() {
            return (BiMap)super.delegate();
        }

        @Override
        public V forcePut(K k, V v) {
            this.constraint.checkKeyValue(k, v);
            return this.delegate().forcePut(k, v);
        }

        @Override
        public BiMap<V, K> inverse() {
            if (this.inverse == null) {
                this.inverse = new ConstrainedBiMap<K, V>(this.delegate().inverse(), this, new InverseConstraint(this.constraint));
            }
            return this.inverse;
        }

        @Override
        public Set<V> values() {
            return this.delegate().values();
        }
    }

    public static class ConstrainedMap<K, V>
    extends ForwardingMap<K, V> {
        private final Map<K, V> delegate;
        final MapConstraint<? super K, ? super V> constraint;
        private transient Set<Map.Entry<K, V>> entrySet;

        ConstrainedMap(Map<K, V> map, MapConstraint<? super K, ? super V> mapConstraint) {
            this.delegate = Preconditions.checkNotNull(map);
            this.constraint = Preconditions.checkNotNull(mapConstraint);
        }

        @Override
        protected Map<K, V> delegate() {
            return this.delegate;
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set set = this.entrySet;
            if (set == null) {
                this.entrySet = set = MapConstraints.constrainedEntrySet(this.delegate.entrySet(), this.constraint);
            }
            return set;
        }

        @Override
        public V put(K k, V v) {
            this.constraint.checkKeyValue(k, v);
            return this.delegate.put(k, v);
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            this.delegate.putAll(MapConstraints.checkMap(map, this.constraint));
        }
    }

    private static enum NotNullMapConstraint implements MapConstraint<Object, Object>
    {
        INSTANCE;


        @Override
        public void checkKeyValue(Object object, Object object2) {
            Preconditions.checkNotNull(object);
            Preconditions.checkNotNull(object2);
        }

        @Override
        public String toString() {
            return "Not null";
        }
    }
}

