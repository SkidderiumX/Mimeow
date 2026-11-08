/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredMultimapValues;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public class FilteredEntryMultimap<K, V>
extends AbstractMultimap<K, V>
implements FilteredMultimap<K, V> {
    final Multimap<K, V> unfiltered;
    final Predicate<? super Map.Entry<K, V>> predicate;

    FilteredEntryMultimap(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        this.unfiltered = Preconditions.checkNotNull(multimap);
        this.predicate = Preconditions.checkNotNull(predicate);
    }

    @Override
    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    @Override
    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return this.predicate;
    }

    @Override
    public int size() {
        return this.entries().size();
    }

    private boolean satisfies(K k, V v) {
        return this.predicate.apply(Maps.immutableEntry(k, v));
    }

    static <E> Collection<E> filterCollection(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof Set) {
            return Sets.filter((Set)collection, predicate);
        }
        return Collections2.filter(collection, predicate);
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.asMap().get(object) != null;
    }

    @Override
    public Collection<V> removeAll(@Nullable Object object) {
        return Objects.firstNonNull(this.asMap().remove(object), this.unmodifiableEmptyCollection());
    }

    Collection<V> unmodifiableEmptyCollection() {
        return this.unfiltered instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    @Override
    public void clear() {
        this.entries().clear();
    }

    @Override
    public Collection<V> get(K k) {
        return FilteredEntryMultimap.filterCollection(this.unfiltered.get(k), new ValuePredicate(k));
    }

    @Override
    Collection<Map.Entry<K, V>> createEntries() {
        return FilteredEntryMultimap.filterCollection(this.unfiltered.entries(), this.predicate);
    }

    @Override
    Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    Map<K, Collection<V>> createAsMap() {
        return new AsMap();
    }

    @Override
    public Set<K> keySet() {
        return this.asMap().keySet();
    }

    boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator<Map.Entry<K, Collection<V>>> iterator2 = this.unfiltered.asMap().entrySet().iterator();
        boolean bl = false;
        while (iterator2.hasNext()) {
            Map.Entry<K, Collection<V>> entry = iterator2.next();
            K k = entry.getKey();
            Collection<V> collection = FilteredEntryMultimap.filterCollection(entry.getValue(), new ValuePredicate(k));
            if (collection.isEmpty() || !predicate.apply(Maps.immutableEntry(k, collection))) continue;
            if (collection.size() == entry.getValue().size()) {
                iterator2.remove();
            } else {
                collection.clear();
            }
            bl = true;
        }
        return bl;
    }

    @Override
    Multiset<K> createKeys() {
        return new Keys();
    }

    public class Keys
    extends Multimaps.Keys<K, V> {
        Keys() {
            super(FilteredEntryMultimap.this);
        }

        @Override
        public int remove(@Nullable Object object, int n) {
            CollectPreconditions.checkNonnegative(n, "occurrences");
            if (n == 0) {
                return this.count(object);
            }
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(object);
            if (collection == null) {
                return 0;
            }
            Object object2 = object;
            int n2 = 0;
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                Object v = iterator2.next();
                if (!FilteredEntryMultimap.this.satisfies(object2, v) || ++n2 > n) continue;
                iterator2.remove();
            }
            return n2;
        }

        @Override
        public Set<Multiset.Entry<K>> entrySet() {
            return new Multisets.EntrySet<K>(){

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
                    return FilteredEntryMultimap.this.keySet().size();
                }

                private boolean removeEntriesIf(final Predicate<? super Multiset.Entry<K>> predicate) {
                    return FilteredEntryMultimap.this.removeEntriesIf(new Predicate<Map.Entry<K, Collection<V>>>(){

                        @Override
                        public boolean apply(Map.Entry<K, Collection<V>> entry) {
                            return predicate.apply(Multisets.immutableEntry(entry.getKey(), entry.getValue().size()));
                        }
                    });
                }

                @Override
                public boolean removeAll(Collection<?> collection) {
                    return this.removeEntriesIf(Predicates.in(collection));
                }

                @Override
                public boolean retainAll(Collection<?> collection) {
                    return this.removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }
            };
        }
    }

    public class AsMap
    extends Maps.ImprovedAbstractMap<K, Collection<V>> {
        AsMap() {
        }

        @Override
        public boolean containsKey(@Nullable Object object) {
            return this.get(object) != null;
        }

        @Override
        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        @Override
        public Collection<V> get(@Nullable Object object) {
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(object);
            if (collection == null) {
                return null;
            }
            Object object2 = object;
            return (collection = FilteredEntryMultimap.filterCollection(collection, new ValuePredicate(object2))).isEmpty() ? null : collection;
        }

        @Override
        public Collection<V> remove(@Nullable Object object) {
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(object);
            if (collection == null) {
                return null;
            }
            Object object2 = object;
            ArrayList arrayList = Lists.newArrayList();
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                Object v = iterator2.next();
                if (!FilteredEntryMultimap.this.satisfies(object2, v)) continue;
                iterator2.remove();
                arrayList.add(v);
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            if (FilteredEntryMultimap.this.unfiltered instanceof SetMultimap) {
                return Collections.unmodifiableSet(Sets.newLinkedHashSet(arrayList));
            }
            return Collections.unmodifiableList(arrayList);
        }

        @Override
        Set<K> createKeySet() {
            return new Maps.KeySet<K, Collection<V>>(this){

                @Override
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(collection)));
                }

                @Override
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }

                @Override
                public boolean remove(@Nullable Object object) {
                    return AsMap.this.remove(object) != null;
                }
            };
        }

        @Override
        Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new Maps.EntrySet<K, Collection<V>>(){

                @Override
                Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                @Override
                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>(){
                        final Iterator<Map.Entry<K, Collection<V>>> backingIterator;
                        {
                            this.backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        }

                        @Override
                        protected Map.Entry<K, Collection<V>> computeNext() {
                            while (this.backingIterator.hasNext()) {
                                Map.Entry entry = this.backingIterator.next();
                                Object k = entry.getKey();
                                Collection collection = FilteredEntryMultimap.filterCollection(entry.getValue(), new ValuePredicate(k));
                                if (collection.isEmpty()) continue;
                                return Maps.immutableEntry(k, collection);
                            }
                            return (Map.Entry)this.endOfData();
                        }
                    };
                }

                @Override
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.in(collection));
                }

                @Override
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }

                @Override
                public int size() {
                    return Iterators.size(this.iterator());
                }
            };
        }

        @Override
        Collection<Collection<V>> createValues() {
            return new Maps.Values<K, Collection<V>>(this){

                @Override
                public boolean remove(@Nullable Object object) {
                    if (object instanceof Collection) {
                        Collection collection = (Collection)object;
                        Iterator iterator2 = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        while (iterator2.hasNext()) {
                            Map.Entry entry = iterator2.next();
                            Object k = entry.getKey();
                            Collection collection2 = FilteredEntryMultimap.filterCollection(entry.getValue(), new ValuePredicate(k));
                            if (collection2.isEmpty() || !collection.equals(collection2)) continue;
                            if (collection2.size() == entry.getValue().size()) {
                                iterator2.remove();
                            } else {
                                collection2.clear();
                            }
                            return true;
                        }
                    }
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
                }

                @Override
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }
            };
        }
    }

    public final class ValuePredicate
    implements Predicate<V> {
        private final K key;

        ValuePredicate(K k) {
            this.key = k;
        }

        @Override
        public boolean apply(@Nullable V v) {
            return FilteredEntryMultimap.this.satisfies(this.key, v);
        }
    }
}

