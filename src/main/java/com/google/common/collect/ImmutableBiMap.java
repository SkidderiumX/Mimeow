/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BiMap;
import com.google.common.collect.EmptyImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.SingletonImmutableBiMap;
import java.util.Map;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableBiMap<K, V>
extends ImmutableMap<K, V>
implements BiMap<K, V> {
    private static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    public static <K, V> ImmutableBiMap<K, V> of() {
        return EmptyImmutableBiMap.INSTANCE;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        return new SingletonImmutableBiMap<K, V>(k, v);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        return new RegularImmutableBiMap(ImmutableBiMap.entryOf(k, v), ImmutableBiMap.entryOf(k2, v2));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return new RegularImmutableBiMap(ImmutableBiMap.entryOf(k, v), ImmutableBiMap.entryOf(k2, v2), ImmutableBiMap.entryOf(k3, v3));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableBiMap(ImmutableBiMap.entryOf(k, v), ImmutableBiMap.entryOf(k2, v2), ImmutableBiMap.entryOf(k3, v3), ImmutableBiMap.entryOf(k4, v4));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableBiMap(ImmutableBiMap.entryOf(k, v), ImmutableBiMap.entryOf(k2, v2), ImmutableBiMap.entryOf(k3, v3), ImmutableBiMap.entryOf(k4, v4), ImmutableBiMap.entryOf(k5, v5));
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        Map.Entry<?, ?>[] entryArray;
        if (map instanceof ImmutableBiMap && !(entryArray = (Map.Entry<?, ?>[])map).isPartialView()) {
            return entryArray;
        }
        entryArray = map.entrySet().toArray(EMPTY_ENTRY_ARRAY);
        switch (entryArray.length) {
            case 0: {
                return ImmutableBiMap.of();
            }
            case 1: {
                Map.Entry<?, ?> entry = entryArray[0];
                return ImmutableBiMap.of(entry.getKey(), entry.getValue());
            }
        }
        return new RegularImmutableBiMap(entryArray);
    }

    ImmutableBiMap() {
    }

    @Override
    public abstract ImmutableBiMap<V, K> inverse();

    @Override
    public ImmutableSet<V> values() {
        return ((ImmutableMap)((Object)this.inverse())).keySet();
    }

    @Override
    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }

    private static class SerializedForm
    extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0L;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override
        Object readResolve() {
            Builder<Object, Object> builder = new Builder<Object, Object>();
            return this.createMap(builder);
        }
    }

    public static final class Builder<K, V>
    extends ImmutableMap.Builder<K, V> {
        @Override
        public Builder<K, V> put(K k, V v) {
            super.put(k, v);
            return this;
        }

        @Override
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll(map);
            return this;
        }

        @Override
        public ImmutableBiMap<K, V> build() {
            switch (this.size) {
                case 0: {
                    return ImmutableBiMap.of();
                }
                case 1: {
                    return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
                }
            }
            return new RegularImmutableBiMap(this.size, this.entries);
        }
    }
}

