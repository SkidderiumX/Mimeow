/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableMapKeySet;
import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableMap<K, V>
implements Map<K, V>,
Serializable {
    private static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableCollection<V> values;
    private transient ImmutableSetMultimap<K, V> multimapView;

    public static <K, V> ImmutableMap<K, V> of() {
        return ImmutableBiMap.of();
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        return ImmutableBiMap.of(k, v);
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3), ImmutableMap.entryOf(k4, v4));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3), ImmutableMap.entryOf(k4, v4), ImmutableMap.entryOf(k5, v5));
    }

    static <K, V> ImmutableMapEntry.TerminalEntry<K, V> entryOf(K k, V v) {
        CollectPreconditions.checkEntryNotNull(k, v);
        return new ImmutableMapEntry.TerminalEntry<K, V>(k, v);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    static void checkNoConflict(boolean bl, String string, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!bl) {
            throw new IllegalArgumentException("Multiple entries with same " + string + ": " + entry + " and " + entry2);
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        Map.Entry<?, ?>[] entryArray;
        if (map instanceof ImmutableMap && !(map instanceof ImmutableSortedMap)) {
            entryArray = (Map.Entry<?, ?>[])map;
            if (!entryArray.isPartialView()) {
                return entryArray;
            }
        } else if (map instanceof EnumMap) {
            return ImmutableMap.copyOfEnumMapUnsafe(map);
        }
        entryArray = map.entrySet().toArray(EMPTY_ENTRY_ARRAY);
        switch (entryArray.length) {
            case 0: {
                return ImmutableMap.of();
            }
            case 1: {
                Map.Entry<?, ?> entry = entryArray[0];
                return ImmutableMap.of(entry.getKey(), entry.getValue());
            }
        }
        return new RegularImmutableMap(entryArray);
    }

    private static <K, V> ImmutableMap<K, V> copyOfEnumMapUnsafe(Map<? extends K, ? extends V> map) {
        return ImmutableMap.copyOfEnumMap((EnumMap)map);
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(Map<K, ? extends V> map) {
        EnumMap<K, V> enumMap = new EnumMap<K, V>(map);
        for (Map.Entry<K, V> entry : enumMap.entrySet()) {
            CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    ImmutableMap() {
    }

    @Override
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final V remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.get(object) != null;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return ((ImmutableCollection)this.values()).contains(object);
    }

    @Override
    public abstract V get(@Nullable Object var1);

    @Override
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        return immutableSet == null ? (this.entrySet = this.createEntrySet()) : immutableSet;
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    @Override
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        return immutableSet == null ? (this.keySet = this.createKeySet()) : immutableSet;
    }

    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        return immutableCollection == null ? (this.values = new ImmutableMapValues(this)) : immutableCollection;
    }

    @Beta
    public ImmutableSetMultimap<K, V> asMultimap() {
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        return immutableSetMultimap == null ? (this.multimapView = this.createMultimapView()) : immutableSetMultimap;
    }

    private ImmutableSetMultimap<K, V> createMultimapView() {
        ImmutableMap<K, ImmutableSet<V>> immutableMap = this.viewMapValuesAsSingletonSets();
        return new ImmutableSetMultimap<K, V>(immutableMap, immutableMap.size(), null);
    }

    private ImmutableMap<K, ImmutableSet<V>> viewMapValuesAsSingletonSets() {
        return new MapViewOfValuesAsSingletonSets(this);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Maps.equalsImpl(this, object);
    }

    abstract boolean isPartialView();

    @Override
    public int hashCode() {
        return ((ImmutableSet)this.entrySet()).hashCode();
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static class SerializedForm
    implements Serializable {
        private final Object[] keys;
        private final Object[] values;
        private static final long serialVersionUID = 0L;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            int n = 0;
            for (Map.Entry entry : immutableMap.entrySet()) {
                this.keys[n] = entry.getKey();
                this.values[n] = entry.getValue();
                ++n;
            }
        }

        Object readResolve() {
            Builder<Object, Object> builder = new Builder<Object, Object>();
            return this.createMap(builder);
        }

        Object createMap(Builder<Object, Object> builder) {
            for (int i = 0; i < this.keys.length; ++i) {
                builder.put(this.keys[i], this.values[i]);
            }
            return builder.build();
        }
    }

    private static final class MapViewOfValuesAsSingletonSets<K, V>
    extends ImmutableMap<K, ImmutableSet<V>> {
        private final ImmutableMap<K, V> delegate;

        MapViewOfValuesAsSingletonSets(ImmutableMap<K, V> immutableMap) {
            this.delegate = Preconditions.checkNotNull(immutableMap);
        }

        @Override
        public int size() {
            return this.delegate.size();
        }

        @Override
        public boolean containsKey(@Nullable Object object) {
            return this.delegate.containsKey(object);
        }

        @Override
        public ImmutableSet<V> get(@Nullable Object object) {
            V v = this.delegate.get(object);
            return v == null ? null : ImmutableSet.of(v);
        }

        @Override
        boolean isPartialView() {
            return false;
        }

        @Override
        ImmutableSet<Map.Entry<K, ImmutableSet<V>>> createEntrySet() {
            return new ImmutableMapEntrySet<K, ImmutableSet<V>>(){

                @Override
                ImmutableMap<K, ImmutableSet<V>> map() {
                    return MapViewOfValuesAsSingletonSets.this;
                }

                @Override
                public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> iterator() {
                    final Iterator iterator2 = ((ImmutableSet)MapViewOfValuesAsSingletonSets.this.delegate.entrySet()).iterator();
                    return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>(){

                        @Override
                        public boolean hasNext() {
                            return iterator2.hasNext();
                        }

                        @Override
                        public Map.Entry<K, ImmutableSet<V>> next() {
                            final Map.Entry entry = (Map.Entry)iterator2.next();
                            return new AbstractMapEntry<K, ImmutableSet<V>>(){

                                @Override
                                public K getKey() {
                                    return entry.getKey();
                                }

                                @Override
                                public ImmutableSet<V> getValue() {
                                    return ImmutableSet.of(entry.getValue());
                                }
                            };
                        }
                    };
                }
            };
        }
    }

    public static class Builder<K, V> {
        ImmutableMapEntry.TerminalEntry<K, V>[] entries;
        int size;

        public Builder() {
            this(4);
        }

        Builder(int n) {
            this.entries = new ImmutableMapEntry.TerminalEntry[n];
            this.size = 0;
        }

        private void ensureCapacity(int n) {
            if (n > this.entries.length) {
                this.entries = ObjectArrays.arraysCopyOf(this.entries, ImmutableCollection.Builder.expandedCapacity(this.entries.length, n));
            }
        }

        public Builder<K, V> put(K k, V v) {
            this.ensureCapacity(this.size + 1);
            ImmutableMapEntry.TerminalEntry<K, V> terminalEntry = ImmutableMap.entryOf(k, v);
            this.entries[this.size++] = terminalEntry;
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return this.put(entry.getKey(), entry.getValue());
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            this.ensureCapacity(this.size + map.size());
            for (Map.Entry<K, V> entry : map.entrySet()) {
                this.put(entry);
            }
            return this;
        }

        public ImmutableMap<K, V> build() {
            switch (this.size) {
                case 0: {
                    return ImmutableMap.of();
                }
                case 1: {
                    return ImmutableMap.of(this.entries[0].getKey(), this.entries[0].getValue());
                }
            }
            return new RegularImmutableMap(this.size, this.entries);
        }
    }
}

