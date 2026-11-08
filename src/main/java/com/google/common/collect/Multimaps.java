/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractListMultimap;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.AbstractSortedSetMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntrySetMultimap;
import com.google.common.collect.FilteredKeyListMultimap;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredKeySetMultimap;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.TransformedIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class Multimaps {
    private Multimaps() {
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
        return new CustomMultimap<K, V>(map, supplier);
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new CustomListMultimap<K, V>(map, supplier);
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap<K, V>(map, supplier);
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
        return new CustomSortedSetMultimap<K, V>(map, supplier);
    }

    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> multimap, M m) {
        Preconditions.checkNotNull(m);
        for (Map.Entry<V, K> entry : multimap.entries()) {
            m.put(entry.getValue(), entry.getKey());
        }
        return m;
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap) {
        return Synchronized.multimap(multimap, null);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> multimap) {
        if (multimap instanceof UnmodifiableMultimap || multimap instanceof ImmutableMultimap) {
            return multimap;
        }
        return new UnmodifiableMultimap<K, V>(multimap);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> immutableMultimap) {
        return Preconditions.checkNotNull(immutableMultimap);
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> setMultimap) {
        return Synchronized.setMultimap(setMultimap, null);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
        if (setMultimap instanceof UnmodifiableSetMultimap || setMultimap instanceof ImmutableSetMultimap) {
            return setMultimap;
        }
        return new UnmodifiableSetMultimap<K, V>(setMultimap);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return Preconditions.checkNotNull(immutableSetMultimap);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return Synchronized.sortedSetMultimap(sortedSetMultimap, null);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        if (sortedSetMultimap instanceof UnmodifiableSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new UnmodifiableSortedSetMultimap<K, V>(sortedSetMultimap);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> listMultimap) {
        return Synchronized.listMultimap(listMultimap, null);
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
        if (listMultimap instanceof UnmodifiableListMultimap || listMultimap instanceof ImmutableListMultimap) {
            return listMultimap;
        }
        return new UnmodifiableListMultimap<K, V>(listMultimap);
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> immutableListMultimap) {
        return Preconditions.checkNotNull(immutableListMultimap);
    }

    private static <V> Collection<V> unmodifiableValueCollection(Collection<V> collection) {
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

    private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> collection) {
        if (collection instanceof Set) {
            return Maps.unmodifiableEntrySet((Set)collection);
        }
        return new Maps.UnmodifiableEntries<K, V>(Collections.unmodifiableCollection(collection));
    }

    @Beta
    public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> listMultimap) {
        return listMultimap.asMap();
    }

    @Beta
    public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> setMultimap) {
        return setMultimap.asMap();
    }

    @Beta
    public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }

    @Beta
    public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> multimap) {
        return multimap.asMap();
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map) {
        return new MapMultimap<K, V>(map);
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> multimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        Maps.EntryTransformer entryTransformer = Maps.asEntryTransformer(function);
        return Multimaps.transformEntries(multimap, entryTransformer);
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesMultimap<K, V1, V2>(multimap, entryTransformer);
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        Maps.EntryTransformer entryTransformer = Maps.asEntryTransformer(function);
        return Multimaps.transformEntries(listMultimap, entryTransformer);
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesListMultimap<K, V1, V2>(listMultimap, entryTransformer);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> iterable, Function<? super V, K> function) {
        return Multimaps.index(iterable.iterator(), function);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> iterator2, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        while (iterator2.hasNext()) {
            V v = iterator2.next();
            Preconditions.checkNotNull(v, iterator2);
            builder.put((Object)function.apply(v), (Object)v);
        }
        return builder.build();
    }

    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        if (multimap instanceof SetMultimap) {
            return Multimaps.filterKeys((SetMultimap)multimap, predicate);
        }
        if (multimap instanceof ListMultimap) {
            return Multimaps.filterKeys((ListMultimap)multimap, predicate);
        }
        if (multimap instanceof FilteredKeyMultimap) {
            FilteredKeyMultimap filteredKeyMultimap = (FilteredKeyMultimap)multimap;
            return new FilteredKeyMultimap(filteredKeyMultimap.unfiltered, Predicates.and(filteredKeyMultimap.keyPredicate, predicate));
        }
        if (multimap instanceof FilteredMultimap) {
            FilteredMultimap filteredMultimap = (FilteredMultimap)multimap;
            return Multimaps.filterFiltered(filteredMultimap, Maps.keyPredicateOnEntries(predicate));
        }
        return new FilteredKeyMultimap<K, V>(multimap, predicate);
    }

    public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        if (setMultimap instanceof FilteredKeySetMultimap) {
            FilteredKeySetMultimap filteredKeySetMultimap = (FilteredKeySetMultimap)setMultimap;
            return new FilteredKeySetMultimap(filteredKeySetMultimap.unfiltered(), Predicates.and(filteredKeySetMultimap.keyPredicate, predicate));
        }
        if (setMultimap instanceof FilteredSetMultimap) {
            FilteredSetMultimap filteredSetMultimap = (FilteredSetMultimap)setMultimap;
            return Multimaps.filterFiltered(filteredSetMultimap, Maps.keyPredicateOnEntries(predicate));
        }
        return new FilteredKeySetMultimap<K, V>(setMultimap, predicate);
    }

    public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        if (listMultimap instanceof FilteredKeyListMultimap) {
            FilteredKeyListMultimap filteredKeyListMultimap = (FilteredKeyListMultimap)listMultimap;
            return new FilteredKeyListMultimap(filteredKeyListMultimap.unfiltered(), Predicates.and(filteredKeyListMultimap.keyPredicate, predicate));
        }
        return new FilteredKeyListMultimap<K, V>(listMultimap, predicate);
    }

    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> multimap, Predicate<? super V> predicate) {
        return Multimaps.filterEntries(multimap, Maps.valuePredicateOnEntries(predicate));
    }

    public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> setMultimap, Predicate<? super V> predicate) {
        return Multimaps.filterEntries(setMultimap, Maps.valuePredicateOnEntries(predicate));
    }

    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return Multimaps.filterEntries((SetMultimap)multimap, predicate);
        }
        return multimap instanceof FilteredMultimap ? Multimaps.filterFiltered((FilteredMultimap)multimap, predicate) : new FilteredEntryMultimap<K, V>(Preconditions.checkNotNull(multimap), predicate);
    }

    public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        return setMultimap instanceof FilteredSetMultimap ? Multimaps.filterFiltered((FilteredSetMultimap)setMultimap, predicate) : new FilteredEntrySetMultimap<K, V>(Preconditions.checkNotNull(setMultimap), predicate);
    }

    private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> filteredMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Predicate<? super Map.Entry<K, V>> predicate2 = Predicates.and(filteredMultimap.entryPredicate(), predicate);
        return new FilteredEntryMultimap<K, V>(filteredMultimap.unfiltered(), predicate2);
    }

    private static <K, V> SetMultimap<K, V> filterFiltered(FilteredSetMultimap<K, V> filteredSetMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Predicate<? super Map.Entry<K, V>> predicate2 = Predicates.and(filteredSetMultimap.entryPredicate(), predicate);
        return new FilteredEntrySetMultimap<K, V>(filteredSetMultimap.unfiltered(), predicate2);
    }

    static boolean equalsImpl(Multimap<?, ?> multimap, @Nullable Object object) {
        if (object == multimap) {
            return true;
        }
        if (object instanceof Multimap) {
            Multimap multimap2 = (Multimap)object;
            return multimap.asMap().equals(multimap2.asMap());
        }
        return false;
    }

    public static final class AsMap<K, V>
    extends Maps.ImprovedAbstractMap<K, Collection<V>> {
        private final Multimap<K, V> multimap;

        AsMap(Multimap<K, V> multimap) {
            this.multimap = Preconditions.checkNotNull(multimap);
        }

        @Override
        public int size() {
            return this.multimap.keySet().size();
        }

        @Override
        protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new EntrySet();
        }

        void removeValuesForKey(Object object) {
            this.multimap.keySet().remove(object);
        }

        @Override
        public Collection<V> get(Object object) {
            return this.containsKey(object) ? this.multimap.get(object) : null;
        }

        @Override
        public Collection<V> remove(Object object) {
            return this.containsKey(object) ? this.multimap.removeAll(object) : null;
        }

        @Override
        public Set<K> keySet() {
            return this.multimap.keySet();
        }

        @Override
        public boolean isEmpty() {
            return this.multimap.isEmpty();
        }

        @Override
        public boolean containsKey(Object object) {
            return this.multimap.containsKey(object);
        }

        @Override
        public void clear() {
            this.multimap.clear();
        }

        public class EntrySet
        extends Maps.EntrySet<K, Collection<V>> {
            EntrySet() {
            }

            @Override
            Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            @Override
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.asMapEntryIterator(AsMap.this.multimap.keySet(), new Function<K, Collection<V>>(){

                    @Override
                    public Collection<V> apply(K k) {
                        return AsMap.this.multimap.get(k);
                    }
                });
            }

            @Override
            public boolean remove(Object object) {
                if (!this.contains(object)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry)object;
                AsMap.this.removeValuesForKey(entry.getKey());
                return true;
            }
        }
    }

    public static abstract class Entries<K, V>
    extends AbstractCollection<Map.Entry<K, V>> {
        Entries() {
        }

        abstract Multimap<K, V> multimap();

        @Override
        public int size() {
            return this.multimap().size();
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                return this.multimap().containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override
        public boolean remove(@Nullable Object object) {
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                return this.multimap().remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override
        public void clear() {
            this.multimap().clear();
        }
    }

    public static class Keys<K, V>
    extends AbstractMultiset<K> {
        final Multimap<K, V> multimap;

        Keys(Multimap<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override
        Iterator<Multiset.Entry<K>> entryIterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>(this.multimap.asMap().entrySet().iterator()){

                @Override
                Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> entry) {
                    return new Multisets.AbstractEntry<K>(){

                        @Override
                        public K getElement() {
                            return entry.getKey();
                        }

                        @Override
                        public int getCount() {
                            return ((Collection)entry.getValue()).size();
                        }
                    };
                }
            };
        }

        @Override
        int distinctElements() {
            return this.multimap.asMap().size();
        }

        @Override
        Set<Multiset.Entry<K>> createEntrySet() {
            return new KeysEntrySet();
        }

        @Override
        public boolean contains(@Nullable Object object) {
            return this.multimap.containsKey(object);
        }

        @Override
        public Iterator<K> iterator() {
            return Maps.keyIterator(this.multimap.entries().iterator());
        }

        @Override
        public int count(@Nullable Object object) {
            Collection<V> collection = Maps.safeGet(this.multimap.asMap(), object);
            return collection == null ? 0 : collection.size();
        }

        @Override
        public int remove(@Nullable Object object, int n) {
            CollectPreconditions.checkNonnegative(n, "occurrences");
            if (n == 0) {
                return this.count(object);
            }
            Collection<V> collection = Maps.safeGet(this.multimap.asMap(), object);
            if (collection == null) {
                return 0;
            }
            int n2 = collection.size();
            if (n >= n2) {
                collection.clear();
            } else {
                Iterator<V> iterator2 = collection.iterator();
                for (int i = 0; i < n; ++i) {
                    iterator2.next();
                    iterator2.remove();
                }
            }
            return n2;
        }

        @Override
        public void clear() {
            this.multimap.clear();
        }

        @Override
        public Set<K> elementSet() {
            return this.multimap.keySet();
        }

        public class KeysEntrySet
        extends Multisets.EntrySet<K> {
            KeysEntrySet() {
            }

            @Override
            Multiset<K> multiset() {
                return Keys.this;
            }

            @Override
            public Iterator<Multiset.Entry<K>> iterator() {
                return Keys.this.entryIterator();
            }

            @Override
            public int size() {
                return Keys.this.distinctElements();
            }

            @Override
            public boolean isEmpty() {
                return Keys.this.multimap.isEmpty();
            }

            @Override
            public boolean contains(@Nullable Object object) {
                if (object instanceof Multiset.Entry) {
                    Multiset.Entry entry = (Multiset.Entry)object;
                    Collection collection = Keys.this.multimap.asMap().get(entry.getElement());
                    return collection != null && collection.size() == entry.getCount();
                }
                return false;
            }

            @Override
            public boolean remove(@Nullable Object object) {
                if (object instanceof Multiset.Entry) {
                    Multiset.Entry entry = (Multiset.Entry)object;
                    Collection collection = Keys.this.multimap.asMap().get(entry.getElement());
                    if (collection != null && collection.size() == entry.getCount()) {
                        collection.clear();
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private static final class TransformedEntriesListMultimap<K, V1, V2>
    extends TransformedEntriesMultimap<K, V1, V2>
    implements ListMultimap<K, V2> {
        TransformedEntriesListMultimap(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        @Override
        List<V2> transform(K k, Collection<V1> collection) {
            return Lists.transform((List)collection, Maps.asValueToValueFunction(this.transformer, k));
        }

        @Override
        public List<V2> get(K k) {
            return this.transform((Object)k, this.fromMultimap.get(k));
        }

        @Override
        public List<V2> removeAll(Object object) {
            return this.transform(object, this.fromMultimap.removeAll(object));
        }

        @Override
        public List<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    private static class TransformedEntriesMultimap<K, V1, V2>
    extends AbstractMultimap<K, V2> {
        final Multimap<K, V1> fromMultimap;
        final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMultimap(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.fromMultimap = Preconditions.checkNotNull(multimap);
            this.transformer = Preconditions.checkNotNull(entryTransformer);
        }

        Collection<V2> transform(K k, Collection<V1> collection) {
            Function<? super V1, V2> function = Maps.asValueToValueFunction(this.transformer, k);
            if (collection instanceof List) {
                return Lists.transform((List)collection, function);
            }
            return Collections2.transform(collection, function);
        }

        @Override
        Map<K, Collection<V2>> createAsMap() {
            return Maps.transformEntries(this.fromMultimap.asMap(), new Maps.EntryTransformer<K, Collection<V1>, Collection<V2>>(){

                @Override
                public Collection<V2> transformEntry(K k, Collection<V1> collection) {
                    return TransformedEntriesMultimap.this.transform(k, collection);
                }
            });
        }

        @Override
        public void clear() {
            this.fromMultimap.clear();
        }

        @Override
        public boolean containsKey(Object object) {
            return this.fromMultimap.containsKey(object);
        }

        @Override
        Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        @Override
        public Collection<V2> get(K k) {
            return this.transform(k, this.fromMultimap.get(k));
        }

        @Override
        public boolean isEmpty() {
            return this.fromMultimap.isEmpty();
        }

        @Override
        public Set<K> keySet() {
            return this.fromMultimap.keySet();
        }

        @Override
        public Multiset<K> keys() {
            return this.fromMultimap.keys();
        }

        @Override
        public boolean put(K k, V2 V2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object object, Object object2) {
            return this.get(object).remove(object2);
        }

        @Override
        public Collection<V2> removeAll(Object object) {
            return this.transform(object, this.fromMultimap.removeAll(object));
        }

        @Override
        public Collection<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return this.fromMultimap.size();
        }

        @Override
        Collection<V2> createValues() {
            return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
        }
    }

    private static class MapMultimap<K, V>
    extends AbstractMultimap<K, V>
    implements SetMultimap<K, V>,
    Serializable {
        final Map<K, V> map;
        private static final long serialVersionUID = 7845222491160860175L;

        MapMultimap(Map<K, V> map) {
            this.map = Preconditions.checkNotNull(map);
        }

        @Override
        public int size() {
            return this.map.size();
        }

        @Override
        public boolean containsKey(Object object) {
            return this.map.containsKey(object);
        }

        @Override
        public boolean containsValue(Object object) {
            return this.map.containsValue(object);
        }

        @Override
        public boolean containsEntry(Object object, Object object2) {
            return this.map.entrySet().contains(Maps.immutableEntry(object, object2));
        }

        @Override
        public Set<V> get(final K k) {
            return new Sets.ImprovedAbstractSet<V>(){

                @Override
                public Iterator<V> iterator() {
                    return new Iterator<V>(){
                        int i;

                        @Override
                        public boolean hasNext() {
                            return this.i == 0 && MapMultimap.this.map.containsKey(k);
                        }

                        @Override
                        public V next() {
                            if (!this.hasNext()) {
                                throw new NoSuchElementException();
                            }
                            ++this.i;
                            return MapMultimap.this.map.get(k);
                        }

                        @Override
                        public void remove() {
                            CollectPreconditions.checkRemove(this.i == 1);
                            this.i = -1;
                            MapMultimap.this.map.remove(k);
                        }
                    };
                }

                @Override
                public int size() {
                    return MapMultimap.this.map.containsKey(k) ? 1 : 0;
                }
            };
        }

        @Override
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object object, Object object2) {
            return this.map.entrySet().remove(Maps.immutableEntry(object, object2));
        }

        @Override
        public Set<V> removeAll(Object object) {
            HashSet<V> hashSet = new HashSet<V>(2);
            if (!this.map.containsKey(object)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(object));
            return hashSet;
        }

        @Override
        public void clear() {
            this.map.clear();
        }

        @Override
        public Set<K> keySet() {
            return this.map.keySet();
        }

        @Override
        public Collection<V> values() {
            return this.map.values();
        }

        @Override
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override
        Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        @Override
        Map<K, Collection<V>> createAsMap() {
            return new AsMap(this);
        }

        @Override
        public int hashCode() {
            return this.map.hashCode();
        }
    }

    private static class UnmodifiableSortedSetMultimap<K, V>
    extends UnmodifiableSetMultimap<K, V>
    implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        @Override
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap)super.delegate();
        }

        @Override
        public SortedSet<V> get(K k) {
            return Collections.unmodifiableSortedSet(this.delegate().get(k));
        }

        @Override
        public SortedSet<V> removeAll(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Comparator<? super V> valueComparator() {
            return this.delegate().valueComparator();
        }
    }

    private static class UnmodifiableSetMultimap<K, V>
    extends UnmodifiableMultimap<K, V>
    implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        UnmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }

        @Override
        public SetMultimap<K, V> delegate() {
            return (SetMultimap)super.delegate();
        }

        @Override
        public Set<V> get(K k) {
            return Collections.unmodifiableSet(this.delegate().get(k));
        }

        @Override
        public Set<Map.Entry<K, V>> entries() {
            return Maps.unmodifiableEntrySet(this.delegate().entries());
        }

        @Override
        public Set<V> removeAll(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableListMultimap<K, V>
    extends UnmodifiableMultimap<K, V>
    implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        UnmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }

        @Override
        public ListMultimap<K, V> delegate() {
            return (ListMultimap)super.delegate();
        }

        @Override
        public List<V> get(K k) {
            return Collections.unmodifiableList(this.delegate().get(k));
        }

        @Override
        public List<V> removeAll(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable {
        final Multimap<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;
        transient Multiset<K> keys;
        transient Set<K> keySet;
        transient Collection<V> values;
        transient Map<K, Collection<V>> map;
        private static final long serialVersionUID = 0L;

        UnmodifiableMultimap(Multimap<K, V> multimap) {
            this.delegate = Preconditions.checkNotNull(multimap);
        }

        @Override
        protected Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<Object>> map = this.map;
            if (map == null) {
                map = this.map = Collections.unmodifiableMap(Maps.transformValues(this.delegate.asMap(), new Function<Collection<V>, Collection<V>>(){

                    @Override
                    public Collection<V> apply(Collection<V> collection) {
                        return Multimaps.unmodifiableValueCollection(collection);
                    }
                }));
            }
            return map;
        }

        @Override
        public Collection<Map.Entry<K, V>> entries() {
            Collection collection = this.entries;
            if (collection == null) {
                this.entries = collection = Multimaps.unmodifiableEntries(this.delegate.entries());
            }
            return collection;
        }

        @Override
        public Collection<V> get(K k) {
            return Multimaps.unmodifiableValueCollection(this.delegate.get(k));
        }

        @Override
        public Multiset<K> keys() {
            Multiset<K> multiset = this.keys;
            if (multiset == null) {
                this.keys = multiset = Multisets.unmodifiableMultiset(this.delegate.keys());
            }
            return multiset;
        }

        @Override
        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set == null) {
                this.keySet = set = Collections.unmodifiableSet(this.delegate.keySet());
            }
            return set;
        }

        @Override
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object object, Object object2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection<V> removeAll(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection == null) {
                this.values = collection = Collections.unmodifiableCollection(this.delegate.values());
            }
            return collection;
        }
    }

    private static class CustomSortedSetMultimap<K, V>
    extends AbstractSortedSetMultimap<K, V> {
        transient Supplier<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;
        @GwtIncompatible(value="not needed in emulated source")
        private static final long serialVersionUID = 0L;

        CustomSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
            this.valueComparator = supplier.get().comparator();
        }

        @Override
        protected SortedSet<V> createCollection() {
            return this.factory.get();
        }

        @Override
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier)objectInputStream.readObject();
            this.valueComparator = this.factory.get().comparator();
            Map map = (Map)objectInputStream.readObject();
            this.setMap(map);
        }
    }

    private static class CustomSetMultimap<K, V>
    extends AbstractSetMultimap<K, V> {
        transient Supplier<? extends Set<V>> factory;
        @GwtIncompatible(value="not needed in emulated source")
        private static final long serialVersionUID = 0L;

        CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
        }

        @Override
        protected Set<V> createCollection() {
            return this.factory.get();
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier)objectInputStream.readObject();
            Map map = (Map)objectInputStream.readObject();
            this.setMap(map);
        }
    }

    private static class CustomListMultimap<K, V>
    extends AbstractListMultimap<K, V> {
        transient Supplier<? extends List<V>> factory;
        @GwtIncompatible(value="java serialization not supported")
        private static final long serialVersionUID = 0L;

        CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
        }

        @Override
        protected List<V> createCollection() {
            return this.factory.get();
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier)objectInputStream.readObject();
            Map map = (Map)objectInputStream.readObject();
            this.setMap(map);
        }
    }

    private static class CustomMultimap<K, V>
    extends AbstractMapBasedMultimap<K, V> {
        transient Supplier<? extends Collection<V>> factory;
        @GwtIncompatible(value="java serialization not supported")
        private static final long serialVersionUID = 0L;

        CustomMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
        }

        @Override
        protected Collection<V> createCollection() {
            return this.factory.get();
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier)objectInputStream.readObject();
            Map map = (Map)objectInputStream.readObject();
            this.setMap(map);
        }
    }
}

