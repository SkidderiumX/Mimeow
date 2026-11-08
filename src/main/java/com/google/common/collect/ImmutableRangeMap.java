/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.RegularImmutableSortedMap;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible(value="NavigableMap")
public class ImmutableRangeMap<K extends Comparable<?>, V>
implements RangeMap<K, V> {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    private final ImmutableList<Range<K>> ranges;
    private final ImmutableList<V> values;

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<K, V>(ImmutableList.of(range), ImmutableList.of(v));
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap)rangeMap;
        }
        Map<Range<K>, V> map = rangeMap.asMapOfRanges();
        ImmutableList.Builder builder = new ImmutableList.Builder(map.size());
        ImmutableList.Builder builder2 = new ImmutableList.Builder(map.size());
        for (Map.Entry<Range<K>, V> entry : map.entrySet()) {
            builder.add(entry.getKey());
            builder2.add(entry.getValue());
        }
        return new ImmutableRangeMap<K, V>(builder.build(), builder2.build());
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder();
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    @Override
    @Nullable
    public V get(K k) {
        int n = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (n == -1) {
            return null;
        }
        Range range = (Range)this.ranges.get(n);
        return range.contains(k) ? (V)this.values.get(n) : null;
    }

    @Override
    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K k) {
        int n = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (n == -1) {
            return null;
        }
        Range range = (Range)this.ranges.get(n);
        return range.contains(k) ? Maps.immutableEntry(range, this.values.get(n)) : null;
    }

    @Override
    public Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        Range range = (Range)this.ranges.get(0);
        Range range2 = (Range)this.ranges.get(this.ranges.size() - 1);
        return Range.create(range.lowerBound, range2.upperBound);
    }

    @Override
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(RangeMap<K, V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING);
        return new RegularImmutableSortedMap(regularImmutableSortedSet, this.values);
    }

    @Override
    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range) {
        int n;
        if (Preconditions.checkNotNull(range).isEmpty()) {
            return ImmutableRangeMap.of();
        }
        if (this.ranges.isEmpty() || range.encloses(this.span())) {
            return this;
        }
        int n2 = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (n2 >= (n = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER))) {
            return ImmutableRangeMap.of();
        }
        final int n3 = n2;
        final int n4 = n - n2;
        ImmutableList immutableList = new ImmutableList<Range<K>>(){

            @Override
            public int size() {
                return n4;
            }

            @Override
            public Range<K> get(int n) {
                Preconditions.checkElementIndex(n, n4);
                if (n == 0 || n == n4 - 1) {
                    return ((Range)ImmutableRangeMap.this.ranges.get(n + n3)).intersection(range);
                }
                return (Range)ImmutableRangeMap.this.ranges.get(n + n3);
            }

            @Override
            boolean isPartialView() {
                return true;
            }
        };
        final ImmutableRangeMap immutableRangeMap = this;
        return new ImmutableRangeMap<K, V>(immutableList, (ImmutableList)this.values.subList(n2, n)){

            @Override
            public ImmutableRangeMap<K, V> subRangeMap(Range<K> range2) {
                if (range.isConnected(range2)) {
                    return immutableRangeMap.subRangeMap(range2.intersection(range));
                }
                return ImmutableRangeMap.of();
            }
        };
    }

    @Override
    public int hashCode() {
        return ((ImmutableMap)this.asMapOfRanges()).hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof RangeMap) {
            RangeMap rangeMap = (RangeMap)object;
            return ((ImmutableMap)this.asMapOfRanges()).equals(rangeMap.asMapOfRanges());
        }
        return false;
    }

    @Override
    public String toString() {
        return ((ImmutableMap)this.asMapOfRanges()).toString();
    }

    public static final class Builder<K extends Comparable<?>, V> {
        private final RangeSet<K> keyRanges = TreeRangeSet.create();
        private final RangeMap<K, V> rangeMap = TreeRangeMap.create();

        public Builder<K, V> put(Range<K> range, V v) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(v);
            Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
            if (!this.keyRanges.complement().encloses(range)) {
                for (Map.Entry<Range<K>, V> entry : this.rangeMap.asMapOfRanges().entrySet()) {
                    Range<K> range2 = entry.getKey();
                    if (!range2.isConnected(range) || range2.intersection(range).isEmpty()) continue;
                    throw new IllegalArgumentException("Overlapping ranges: range " + range + " overlaps with entry " + entry);
                }
            }
            this.keyRanges.add(range);
            this.rangeMap.put(range, v);
            return this;
        }

        public Builder<K, V> putAll(RangeMap<K, ? extends V> rangeMap) {
            for (Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
                this.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableRangeMap<K, V> build() {
            Map<Range<K>, V> map = this.rangeMap.asMapOfRanges();
            ImmutableList.Builder builder = new ImmutableList.Builder(map.size());
            ImmutableList.Builder builder2 = new ImmutableList.Builder(map.size());
            for (Map.Entry<Range<K>, V> entry : map.entrySet()) {
                builder.add(entry.getKey());
                builder2.add(entry.getValue());
            }
            return new ImmutableRangeMap(builder.build(), builder2.build());
        }
    }
}

