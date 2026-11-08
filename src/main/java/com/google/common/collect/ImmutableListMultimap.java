/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.EmptyImmutableListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class ImmutableListMultimap<K, V>
extends ImmutableMultimap<K, V>
implements ListMultimap<K, V> {
    private transient ImmutableListMultimap<V, K> inverse;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0L;

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        Builder<K, V> builder = ImmutableListMultimap.builder();
        builder.put((Object)k, (Object)v);
        return builder.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        Builder<K, V> builder = ImmutableListMultimap.builder();
        builder.put((Object)k, (Object)v);
        builder.put((Object)k2, (Object)v2);
        return builder.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder<K, V> builder = ImmutableListMultimap.builder();
        builder.put((Object)k, (Object)v);
        builder.put((Object)k2, (Object)v2);
        builder.put((Object)k3, (Object)v3);
        return builder.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder<K, V> builder = ImmutableListMultimap.builder();
        builder.put((Object)k, (Object)v);
        builder.put((Object)k2, (Object)v2);
        builder.put((Object)k3, (Object)v3);
        builder.put((Object)k4, (Object)v4);
        return builder.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder<K, V> builder = ImmutableListMultimap.builder();
        builder.put((Object)k, (Object)v);
        builder.put((Object)k2, (Object)v2);
        builder.put((Object)k3, (Object)v3);
        builder.put((Object)k4, (Object)v4);
        builder.put((Object)k5, (Object)v5);
        return builder.build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        Object object;
        if (multimap.isEmpty()) {
            return ImmutableListMultimap.of();
        }
        if (multimap instanceof ImmutableListMultimap && !((ImmutableMultimap)(object = (ImmutableListMultimap)multimap)).isPartialView()) {
            return object;
        }
        object = ImmutableMap.builder();
        int n = 0;
        for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
            ImmutableList<V> immutableList = ImmutableList.copyOf(entry.getValue());
            if (immutableList.isEmpty()) continue;
            ((ImmutableMap.Builder)object).put(entry.getKey(), immutableList);
            n += immutableList.size();
        }
        return new ImmutableListMultimap(((ImmutableMap.Builder)object).build(), n);
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int n) {
        super(immutableMap, n);
    }

    @Override
    public ImmutableList<V> get(@Nullable K k) {
        ImmutableList immutableList = (ImmutableList)this.map.get(k);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<K, V> immutableListMultimap = this.inverse;
        return immutableListMultimap == null ? (this.inverse = this.invert()) : immutableListMultimap;
    }

    private ImmutableListMultimap<V, K> invert() {
        Builder<K, V> builder = ImmutableListMultimap.builder();
        for (Map.Entry entry : this.entries()) {
            builder.put(entry.getValue(), entry.getKey());
        }
        ImmutableMultimap immutableMultimap = builder.build();
        ((ImmutableListMultimap)immutableMultimap).inverse = this;
        return immutableMultimap;
    }

    @Override
    @Deprecated
    public ImmutableList<V> removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ImmutableMap immutableMap;
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        if (n < 0) {
            throw new InvalidObjectException("Invalid key count " + n);
        }
        ImmutableMap.Builder<Object, ImmutableList<Object>> builder = ImmutableMap.builder();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            Object object = objectInputStream.readObject();
            int n3 = objectInputStream.readInt();
            if (n3 <= 0) {
                throw new InvalidObjectException("Invalid value count " + n3);
            }
            Object[] objectArray = new Object[n3];
            for (int j = 0; j < n3; ++j) {
                objectArray[j] = objectInputStream.readObject();
            }
            builder.put(object, ImmutableList.copyOf(objectArray));
            n2 += n3;
        }
        try {
            immutableMap = builder.build();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw (InvalidObjectException)new InvalidObjectException(illegalArgumentException.getMessage()).initCause(illegalArgumentException);
        }
        ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set((ImmutableMultimap)this, immutableMap);
        ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set((ImmutableMultimap)this, n2);
    }

    public static final class Builder<K, V>
    extends ImmutableMultimap.Builder<K, V> {
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
        public Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            super.putAll(k, iterable);
            return this;
        }

        @Override
        public Builder<K, V> putAll(K k, V ... VArray) {
            super.putAll(k, VArray);
            return this;
        }

        @Override
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            super.putAll(multimap);
            return this;
        }

        @Override
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            super.orderKeysBy(comparator);
            return this;
        }

        @Override
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            super.orderValuesBy(comparator);
            return this;
        }

        @Override
        public ImmutableListMultimap<K, V> build() {
            return (ImmutableListMultimap)super.build();
        }
    }
}

