/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.EmptyImmutableSortedMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMapFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedMap;
import com.google.common.collect.RegularImmutableSortedSet;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableSortedMap<K, V>
extends ImmutableSortedMapFauxverideShim<K, V>
implements NavigableMap<K, V> {
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new EmptyImmutableSortedMap<Comparable, Object>(NATURAL_ORDER);
    private transient ImmutableSortedMap<K, V> descendingMap;
    private static final long serialVersionUID = 0L;

    static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return ImmutableSortedMap.of();
        }
        return new EmptyImmutableSortedMap(comparator);
    }

    static <K, V> ImmutableSortedMap<K, V> fromSortedEntries(Comparator<? super K> comparator, int n, Map.Entry<K, V>[] entryArray) {
        if (n == 0) {
            return ImmutableSortedMap.emptyMap(comparator);
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (int i = 0; i < n; ++i) {
            Map.Entry<K, V> entry = entryArray[i];
            builder.add(entry.getKey());
            builder2.add(entry.getValue());
        }
        return new RegularImmutableSortedMap(new RegularImmutableSortedSet<K>(builder.build(), comparator), builder2.build());
    }

    static <K, V> ImmutableSortedMap<K, V> from(ImmutableSortedSet<K> immutableSortedSet, ImmutableList<V> immutableList) {
        if (immutableSortedSet.isEmpty()) {
            return ImmutableSortedMap.emptyMap(immutableSortedSet.comparator());
        }
        return new RegularImmutableSortedMap((RegularImmutableSortedSet)immutableSortedSet, immutableList);
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return NATURAL_EMPTY_MAP;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v) {
        return ImmutableSortedMap.from(ImmutableSortedSet.of(k), ImmutableList.of(v));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableSortedMap.fromEntries(Ordering.natural(), false, 2, ImmutableSortedMap.entryOf(k, v), ImmutableSortedMap.entryOf(k2, v2));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableSortedMap.fromEntries(Ordering.natural(), false, 3, ImmutableSortedMap.entryOf(k, v), ImmutableSortedMap.entryOf(k2, v2), ImmutableSortedMap.entryOf(k3, v3));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableSortedMap.fromEntries(Ordering.natural(), false, 4, ImmutableSortedMap.entryOf(k, v), ImmutableSortedMap.entryOf(k2, v2), ImmutableSortedMap.entryOf(k3, v3), ImmutableSortedMap.entryOf(k4, v4));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableSortedMap.fromEntries(Ordering.natural(), false, 5, ImmutableSortedMap.entryOf(k, v), ImmutableSortedMap.entryOf(k2, v2), ImmutableSortedMap.entryOf(k3, v3), ImmutableSortedMap.entryOf(k4, v4), ImmutableSortedMap.entryOf(k5, v5));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedMap.copyOfInternal(map, ordering);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return ImmutableSortedMap.copyOfInternal(map, Preconditions.checkNotNull(comparator));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<Object> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        return ImmutableSortedMap.copyOfInternal(sortedMap, comparator);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        Map.Entry[] entryArray;
        boolean bl = false;
        if (map instanceof SortedMap) {
            entryArray = (Map.Entry[])map;
            Comparator comparator2 = entryArray.comparator();
            boolean bl2 = comparator2 == null ? comparator == NATURAL_ORDER : (bl = comparator.equals(comparator2));
        }
        if (bl && map instanceof ImmutableSortedMap && !(entryArray = (ImmutableSortedMap)map).isPartialView()) {
            return entryArray;
        }
        entryArray = map.entrySet().toArray(new Map.Entry[0]);
        return ImmutableSortedMap.fromEntries(comparator, bl, entryArray.length, entryArray);
    }

    static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean bl, int n, Map.Entry<K, V> ... entryArray) {
        for (int i = 0; i < n; ++i) {
            Map.Entry<K, V> entry = entryArray[i];
            entryArray[i] = ImmutableSortedMap.entryOf(entry.getKey(), entry.getValue());
        }
        if (!bl) {
            ImmutableSortedMap.sortEntries(comparator, n, entryArray);
            ImmutableSortedMap.validateEntries(n, entryArray, comparator);
        }
        return ImmutableSortedMap.fromSortedEntries(comparator, n, entryArray);
    }

    private static <K, V> void sortEntries(Comparator<? super K> comparator, int n, Map.Entry<K, V>[] entryArray) {
        Arrays.sort(entryArray, 0, n, Ordering.from(comparator).onKeys());
    }

    private static <K, V> void validateEntries(int n, Map.Entry<K, V>[] entryArray, Comparator<? super K> comparator) {
        for (int i = 1; i < n; ++i) {
            ImmutableSortedMap.checkNoConflict(comparator.compare(entryArray[i - 1].getKey(), entryArray[i].getKey()) != 0, "key", entryArray[i - 1], entryArray[i]);
        }
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder(comparator);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    ImmutableSortedMap() {
    }

    ImmutableSortedMap(ImmutableSortedMap<K, V> immutableSortedMap) {
        this.descendingMap = immutableSortedMap;
    }

    @Override
    public int size() {
        return ((AbstractCollection)this.values()).size();
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return ((ImmutableCollection)this.values()).contains(object);
    }

    @Override
    boolean isPartialView() {
        return this.keySet().isPartialView() || ((ImmutableCollection)this.values()).isPartialView();
    }

    @Override
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override
    public abstract ImmutableSortedSet<K> keySet();

    @Override
    public abstract ImmutableCollection<V> values();

    @Override
    public Comparator<? super K> comparator() {
        return ((ImmutableSortedSet)this.keySet()).comparator();
    }

    @Override
    public K firstKey() {
        return (K)((ImmutableSortedSet)this.keySet()).first();
    }

    @Override
    public K lastKey() {
        return (K)((ImmutableSortedSet)this.keySet()).last();
    }

    @Override
    public ImmutableSortedMap<K, V> headMap(K k) {
        return this.headMap((Object)k, false);
    }

    @Override
    public abstract ImmutableSortedMap<K, V> headMap(K var1, boolean var2);

    @Override
    public ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return this.subMap((Object)k, true, (Object)k2, false);
    }

    @Override
    public ImmutableSortedMap<K, V> subMap(K k, boolean bl, K k2, boolean bl2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(k2);
        Preconditions.checkArgument(this.comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return ((ImmutableSortedMap)this.headMap((Object)k2, bl2)).tailMap((Object)k, bl);
    }

    @Override
    public ImmutableSortedMap<K, V> tailMap(K k) {
        return this.tailMap((Object)k, true);
    }

    @Override
    public abstract ImmutableSortedMap<K, V> tailMap(K var1, boolean var2);

    @Override
    public Map.Entry<K, V> lowerEntry(K k) {
        return ((ImmutableSortedMap)this.headMap((Object)k, false)).lastEntry();
    }

    @Override
    public K lowerKey(K k) {
        return Maps.keyOrNull(this.lowerEntry(k));
    }

    @Override
    public Map.Entry<K, V> floorEntry(K k) {
        return ((ImmutableSortedMap)this.headMap((Object)k, true)).lastEntry();
    }

    @Override
    public K floorKey(K k) {
        return Maps.keyOrNull(this.floorEntry(k));
    }

    @Override
    public Map.Entry<K, V> ceilingEntry(K k) {
        return ((ImmutableSortedMap)this.tailMap((Object)k, true)).firstEntry();
    }

    @Override
    public K ceilingKey(K k) {
        return Maps.keyOrNull(this.ceilingEntry(k));
    }

    @Override
    public Map.Entry<K, V> higherEntry(K k) {
        return ((ImmutableSortedMap)this.tailMap((Object)k, false)).firstEntry();
    }

    @Override
    public K higherKey(K k) {
        return Maps.keyOrNull(this.higherEntry(k));
    }

    @Override
    public Map.Entry<K, V> firstEntry() {
        return this.isEmpty() ? null : (Map.Entry)((ImmutableCollection)((Object)this.entrySet())).asList().get(0);
    }

    @Override
    public Map.Entry<K, V> lastEntry() {
        return this.isEmpty() ? null : (Map.Entry)((ImmutableCollection)((Object)this.entrySet())).asList().get(this.size() - 1);
    }

    @Override
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        if (immutableSortedMap == null) {
            immutableSortedMap = this.descendingMap = this.createDescendingMap();
        }
        return immutableSortedMap;
    }

    abstract ImmutableSortedMap<K, V> createDescendingMap();

    @Override
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet();
    }

    @Override
    public ImmutableSortedSet<K> descendingKeySet() {
        return ((ImmutableSortedSet)this.keySet()).descendingSet();
    }

    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }

    private static class SerializedForm
    extends ImmutableMap.SerializedForm {
        private final Comparator<Object> comparator;
        private static final long serialVersionUID = 0L;

        SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override
        Object readResolve() {
            Builder<Object, Object> builder = new Builder<Object, Object>(this.comparator);
            return this.createMap(builder);
        }
    }

    public static class Builder<K, V>
    extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;

        public Builder(Comparator<? super K> comparator) {
            this.comparator = Preconditions.checkNotNull(comparator);
        }

        @Override
        public Builder<K, V> put(K k, V v) {
            super.put(k, v);
            return this;
        }

        @Override
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put(entry);
            return this;
        }

        @Override
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll(map);
            return this;
        }

        @Override
        public ImmutableSortedMap<K, V> build() {
            return ImmutableSortedMap.fromEntries(this.comparator, false, this.size, this.entries);
        }
    }
}

