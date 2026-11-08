/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Cut;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible(value="NavigableMap")
public class TreeRangeMap<K extends Comparable, V>
implements RangeMap<K, V> {
    private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound = Maps.newTreeMap();
    private static final RangeMap EMPTY_SUB_RANGE_MAP = new RangeMap(){

        @Nullable
        public Object get(Comparable comparable) {
            return null;
        }

        @Nullable
        public Map.Entry<Range, Object> getEntry(Comparable comparable) {
            return null;
        }

        public Range span() {
            throw new NoSuchElementException();
        }

        public void put(Range range, Object object) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        public void putAll(RangeMap rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override
        public void clear() {
        }

        public void remove(Range range) {
            Preconditions.checkNotNull(range);
        }

        public Map<Range, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        public RangeMap subRangeMap(Range range) {
            Preconditions.checkNotNull(range);
            return this;
        }
    };

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<K, V>();
    }

    private TreeRangeMap() {
    }

    @Override
    @Nullable
    public V get(K k) {
        Map.Entry<Range<K>, V> entry = this.getEntry(k);
        return entry == null ? null : (V)entry.getValue();
    }

    @Override
    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K k) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry = this.entriesByLowerBound.floorEntry(Cut.belowValue(k));
        if (entry != null && entry.getValue().contains(k)) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public void put(Range<K> range, V v) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(v);
            this.remove(range);
            this.entriesByLowerBound.put(range.lowerBound, new RangeMapEntry<K, V>(range, v));
        }
    }

    @Override
    public void putAll(RangeMap<K, V> rangeMap) {
        for (Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        this.entriesByLowerBound.clear();
    }

    @Override
    public Range<K> span() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry = this.entriesByLowerBound.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry2 = this.entriesByLowerBound.lastEntry();
        if (entry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(((Range)entry.getValue().getKey()).lowerBound, ((Range)entry2.getValue().getKey()).upperBound);
    }

    private void putRangeMapEntry(Cut<K> cut, Cut<K> cut2, V v) {
        this.entriesByLowerBound.put(cut, new RangeMapEntry<K, V>(cut, cut2, v));
    }

    @Override
    public void remove(Range<K> range) {
        RangeMapEntry rangeMapEntry;
        Map.Entry<Range<Object>, Object> entry;
        if (range.isEmpty()) {
            return;
        }
        Map.Entry entry2 = this.entriesByLowerBound.lowerEntry(range.lowerBound);
        if (entry2 != null && ((RangeMapEntry)(entry = entry2.getValue())).getUpperBound().compareTo(range.lowerBound) > 0) {
            if (((RangeMapEntry)entry).getUpperBound().compareTo(range.upperBound) > 0) {
                this.putRangeMapEntry(range.upperBound, ((RangeMapEntry)entry).getUpperBound(), entry2.getValue().getValue());
            }
            this.putRangeMapEntry(((RangeMapEntry)entry).getLowerBound(), range.lowerBound, entry2.getValue().getValue());
        }
        if ((entry = this.entriesByLowerBound.lowerEntry(range.upperBound)) != null && (rangeMapEntry = (RangeMapEntry)entry.getValue()).getUpperBound().compareTo(range.upperBound) > 0) {
            this.putRangeMapEntry(range.upperBound, rangeMapEntry.getUpperBound(), ((RangeMapEntry)entry.getValue()).getValue());
            this.entriesByLowerBound.remove(range.lowerBound);
        }
        this.entriesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override
    public Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges();
    }

    @Override
    public RangeMap<K, V> subRangeMap(Range<K> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new SubRangeMap(range);
    }

    private RangeMap<K, V> emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof RangeMap) {
            RangeMap rangeMap = (RangeMap)object;
            return this.asMapOfRanges().equals(rangeMap.asMapOfRanges());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }

    @Override
    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }

    private class SubRangeMap
    implements RangeMap<K, V> {
        private final Range<K> subRange;

        SubRangeMap(Range<K> range) {
            this.subRange = range;
        }

        @Override
        @Nullable
        public V get(K k) {
            return this.subRange.contains(k) ? (Object)TreeRangeMap.this.get(k) : null;
        }

        @Override
        @Nullable
        public Map.Entry<Range<K>, V> getEntry(K k) {
            Map.Entry entry;
            if (this.subRange.contains(k) && (entry = TreeRangeMap.this.getEntry(k)) != null) {
                return Maps.immutableEntry(entry.getKey().intersection(this.subRange), entry.getValue());
            }
            return null;
        }

        @Override
        public Range<K> span() {
            Cut cut;
            Map.Entry entry = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
            if (entry != null && ((RangeMapEntry)entry.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) > 0) {
                cut = this.subRange.lowerBound;
            } else {
                cut = TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
                if (cut == null || cut.compareTo(this.subRange.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            }
            Map.Entry entry2 = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
            if (entry2 == null) {
                throw new NoSuchElementException();
            }
            Cut<Object> cut2 = ((RangeMapEntry)entry2.getValue()).getUpperBound().compareTo(this.subRange.upperBound) >= 0 ? this.subRange.upperBound : ((RangeMapEntry)entry2.getValue()).getUpperBound();
            return Range.create(cut, cut2);
        }

        @Override
        public void put(Range<K> range, V v) {
            Preconditions.checkArgument(this.subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.subRange);
            TreeRangeMap.this.put(range, v);
        }

        @Override
        public void putAll(RangeMap<K, V> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            Range range = rangeMap.span();
            Preconditions.checkArgument(this.subRange.encloses(range), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", range, this.subRange);
            TreeRangeMap.this.putAll(rangeMap);
        }

        @Override
        public void clear() {
            TreeRangeMap.this.remove(this.subRange);
        }

        @Override
        public void remove(Range<K> range) {
            if (range.isConnected(this.subRange)) {
                TreeRangeMap.this.remove(range.intersection(this.subRange));
            }
        }

        @Override
        public RangeMap<K, V> subRangeMap(Range<K> range) {
            if (!range.isConnected(this.subRange)) {
                return TreeRangeMap.this.emptySubRangeMap();
            }
            return TreeRangeMap.this.subRangeMap(range.intersection(this.subRange));
        }

        @Override
        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap();
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof RangeMap) {
                RangeMap rangeMap = (RangeMap)object;
                return this.asMapOfRanges().equals(rangeMap.asMapOfRanges());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.asMapOfRanges().hashCode();
        }

        @Override
        public String toString() {
            return this.asMapOfRanges().toString();
        }

        public class SubRangeMapAsMap
        extends AbstractMap<Range<K>, V> {
            SubRangeMapAsMap() {
            }

            @Override
            public boolean containsKey(Object object) {
                return this.get(object) != null;
            }

            @Override
            public V get(Object object) {
                try {
                    if (object instanceof Range) {
                        Range range = (Range)object;
                        if (!SubRangeMap.this.subRange.encloses(range) || range.isEmpty()) {
                            return null;
                        }
                        RangeMapEntry rangeMapEntry = null;
                        if (range.lowerBound.compareTo(((SubRangeMap)SubRangeMap.this).subRange.lowerBound) == 0) {
                            Map.Entry entry = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
                            if (entry != null) {
                                rangeMapEntry = (RangeMapEntry)entry.getValue();
                            }
                        } else {
                            rangeMapEntry = (RangeMapEntry)TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                        }
                        if (rangeMapEntry != null && ((Range)rangeMapEntry.getKey()).isConnected(SubRangeMap.this.subRange) && ((Range)rangeMapEntry.getKey()).intersection(SubRangeMap.this.subRange).equals(range)) {
                            return rangeMapEntry.getValue();
                        }
                    }
                }
                catch (ClassCastException classCastException) {
                    return null;
                }
                return null;
            }

            @Override
            public V remove(Object object) {
                Object v = this.get(object);
                if (v != null) {
                    Range range = (Range)object;
                    TreeRangeMap.this.remove(range);
                    return v;
                }
                return null;
            }

            @Override
            public void clear() {
                SubRangeMap.this.clear();
            }

            private boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> predicate) {
                ArrayList arrayList = Lists.newArrayList();
                for (Map.Entry entry : this.entrySet()) {
                    if (!predicate.apply(entry)) continue;
                    arrayList.add(entry.getKey());
                }
                for (Range range : arrayList) {
                    TreeRangeMap.this.remove(range);
                }
                return !arrayList.isEmpty();
            }

            @Override
            public Set<Range<K>> keySet() {
                return new Maps.KeySet<Range<K>, V>(this){

                    @Override
                    public boolean remove(@Nullable Object object) {
                        return SubRangeMapAsMap.this.remove(object) != null;
                    }

                    @Override
                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.keyFunction()));
                    }
                };
            }

            @Override
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new Maps.EntrySet<Range<K>, V>(){

                    @Override
                    Map<Range<K>, V> map() {
                        return SubRangeMapAsMap.this;
                    }

                    @Override
                    public Iterator<Map.Entry<Range<K>, V>> iterator() {
                        if (SubRangeMap.this.subRange.isEmpty()) {
                            return Iterators.emptyIterator();
                        }
                        Cut cut = Objects.firstNonNull(TreeRangeMap.this.entriesByLowerBound.floorKey(((SubRangeMap)SubRangeMap.this).subRange.lowerBound), ((SubRangeMap)SubRangeMap.this).subRange.lowerBound);
                        final Iterator iterator2 = TreeRangeMap.this.entriesByLowerBound.tailMap(cut, true).values().iterator();
                        return new AbstractIterator<Map.Entry<Range<K>, V>>(){

                            @Override
                            protected Map.Entry<Range<K>, V> computeNext() {
                                RangeMapEntry rangeMapEntry;
                                while (iterator2.hasNext() && (rangeMapEntry = (RangeMapEntry)iterator2.next()).getLowerBound().compareTo(((SubRangeMap)SubRangeMap.this).subRange.upperBound) < 0) {
                                    if (rangeMapEntry.getUpperBound().compareTo(((SubRangeMap)SubRangeMap.this).subRange.lowerBound) <= 0) continue;
                                    return Maps.immutableEntry(((Range)rangeMapEntry.getKey()).intersection(SubRangeMap.this.subRange), rangeMapEntry.getValue());
                                }
                                return (Map.Entry)this.endOfData();
                            }
                        };
                    }

                    @Override
                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(collection)));
                    }

                    @Override
                    public int size() {
                        return Iterators.size(this.iterator());
                    }

                    @Override
                    public boolean isEmpty() {
                        return !this.iterator().hasNext();
                    }
                };
            }

            @Override
            public Collection<V> values() {
                return new Maps.Values<Range<K>, V>(this){

                    @Override
                    public boolean removeAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(collection), Maps.valueFunction()));
                    }

                    @Override
                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.valueFunction()));
                    }
                };
            }
        }
    }

    private final class AsMapOfRanges
    extends AbstractMap<Range<K>, V> {
        private AsMapOfRanges() {
        }

        @Override
        public boolean containsKey(@Nullable Object object) {
            return this.get(object) != null;
        }

        @Override
        public V get(@Nullable Object object) {
            if (object instanceof Range) {
                Range range = (Range)object;
                RangeMapEntry rangeMapEntry = (RangeMapEntry)TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                if (rangeMapEntry != null && ((Range)rangeMapEntry.getKey()).equals(range)) {
                    return rangeMapEntry.getValue();
                }
            }
            return null;
        }

        @Override
        public Set<Map.Entry<Range<K>, V>> entrySet() {
            return new AbstractSet<Map.Entry<Range<K>, V>>(){

                @Override
                public Iterator<Map.Entry<Range<K>, V>> iterator() {
                    return TreeRangeMap.this.entriesByLowerBound.values().iterator();
                }

                @Override
                public int size() {
                    return TreeRangeMap.this.entriesByLowerBound.size();
                }
            };
        }
    }

    private static final class RangeMapEntry<K extends Comparable, V>
    extends AbstractMapEntry<Range<K>, V> {
        private final Range<K> range;
        private final V value;

        RangeMapEntry(Cut<K> cut, Cut<K> cut2, V v) {
            this(Range.create(cut, cut2), v);
        }

        RangeMapEntry(Range<K> range, V v) {
            this.range = range;
            this.value = v;
        }

        @Override
        public Range<K> getKey() {
            return this.range;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        public boolean contains(K k) {
            return this.range.contains(k);
        }

        Cut<K> getLowerBound() {
            return this.range.lowerBound;
        }

        Cut<K> getUpperBound() {
            return this.range.upperBound;
        }
    }
}

