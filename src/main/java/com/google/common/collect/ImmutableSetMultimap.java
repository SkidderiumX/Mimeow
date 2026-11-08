/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.EmptyImmutableSetMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class ImmutableSetMultimap<K, V>
extends ImmutableMultimap<K, V>
implements SetMultimap<K, V> {
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSetMultimap<V, K> inverse;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    @GwtIncompatible(value="not needed in emulated source.")
    private static final long serialVersionUID = 0L;

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        Builder<K, V> builder = ImmutableSetMultimap.builder();
        builder.put((Object)k, (Object)v);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        Builder<K, V> builder = ImmutableSetMultimap.builder();
        builder.put((Object)k, (Object)v);
        builder.put((Object)k2, (Object)v2);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder<K, V> builder = ImmutableSetMultimap.builder();
        builder.put((Object)k, (Object)v);
        builder.put((Object)k2, (Object)v2);
        builder.put((Object)k3, (Object)v3);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder<K, V> builder = ImmutableSetMultimap.builder();
        builder.put((Object)k, (Object)v);
        builder.put((Object)k2, (Object)v2);
        builder.put((Object)k3, (Object)v3);
        builder.put((Object)k4, (Object)v4);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder<K, V> builder = ImmutableSetMultimap.builder();
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

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        return ImmutableSetMultimap.copyOf(multimap, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap, Comparator<? super V> comparator) {
        Object object;
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return ImmutableSetMultimap.of();
        }
        if (multimap instanceof ImmutableSetMultimap && !((ImmutableMultimap)(object = (ImmutableSetMultimap)multimap)).isPartialView()) {
            return object;
        }
        object = ImmutableMap.builder();
        int n = 0;
        for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
            K k = entry.getKey();
            Collection<? extends V> collection = entry.getValue();
            ImmutableSet<V> immutableSet = ImmutableSetMultimap.valueSet(comparator, collection);
            if (immutableSet.isEmpty()) continue;
            ((ImmutableMap.Builder)object).put(k, immutableSet);
            n += immutableSet.size();
        }
        return new ImmutableSetMultimap(((ImmutableMap.Builder)object).build(), n, comparator);
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int n, @Nullable Comparator<? super V> comparator) {
        super(immutableMap, n);
        this.emptySet = ImmutableSetMultimap.emptySet(comparator);
    }

    @Override
    public ImmutableSet<V> get(@Nullable K k) {
        ImmutableSet immutableSet = (ImmutableSet)this.map.get(k);
        return Objects.firstNonNull(immutableSet, this.emptySet);
    }

    @Override
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.inverse;
        return immutableSetMultimap == null ? (this.inverse = this.invert()) : immutableSetMultimap;
    }

    private ImmutableSetMultimap<V, K> invert() {
        Builder<K, V> builder = ImmutableSetMultimap.builder();
        for (Map.Entry entry : this.entries()) {
            builder.put(entry.getValue(), entry.getKey());
        }
        ImmutableMultimap immutableMultimap = builder.build();
        ((ImmutableSetMultimap)immutableMultimap).inverse = this;
        return immutableMultimap;
    }

    @Override
    @Deprecated
    public ImmutableSet<V> removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        return immutableSet == null ? (this.entries = new EntrySet(this)) : immutableSet;
    }

    private static <V> ImmutableSet<V> valueSet(@Nullable Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? ImmutableSet.copyOf(collection) : ImmutableSortedSet.copyOf(comparator, collection);
    }

    private static <V> ImmutableSet<V> emptySet(@Nullable Comparator<? super V> comparator) {
        return comparator == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet(comparator);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.valueComparator());
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @Nullable
    Comparator<? super V> valueComparator() {
        return this.emptySet instanceof ImmutableSortedSet ? ((ImmutableSortedSet)this.emptySet).comparator() : null;
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ImmutableMap immutableMap;
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator)objectInputStream.readObject();
        int n = objectInputStream.readInt();
        if (n < 0) {
            throw new InvalidObjectException("Invalid key count " + n);
        }
        ImmutableMap.Builder<Object, ImmutableSet<Object>> builder = ImmutableMap.builder();
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
            ImmutableSet<Object> immutableSet = ImmutableSetMultimap.valueSet(comparator, Arrays.asList(objectArray));
            if (immutableSet.size() != objectArray.length) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + object);
            }
            builder.put(object, immutableSet);
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
        ImmutableMultimap.FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, ImmutableSetMultimap.emptySet(comparator));
    }

    private static final class EntrySet<K, V>
    extends ImmutableSet<Map.Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> multimap;

        EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.multimap = immutableSetMultimap;
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override
        public int size() {
            return this.multimap.size();
        }

        @Override
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override
        boolean isPartialView() {
            return false;
        }
    }

    public static final class Builder<K, V>
    extends ImmutableMultimap.Builder<K, V> {
        public Builder() {
            this.builderMultimap = new BuilderMultimap();
        }

        @Override
        public Builder<K, V> put(K k, V v) {
            this.builderMultimap.put(Preconditions.checkNotNull(k), Preconditions.checkNotNull(v));
            return this;
        }

        @Override
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            this.builderMultimap.put(Preconditions.checkNotNull(entry.getKey()), Preconditions.checkNotNull(entry.getValue()));
            return this;
        }

        @Override
        public Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            Collection collection = this.builderMultimap.get(Preconditions.checkNotNull(k));
            for (V v : iterable) {
                collection.add(Preconditions.checkNotNull(v));
            }
            return this;
        }

        @Override
        public Builder<K, V> putAll(K k, V ... VArray) {
            return this.putAll((Object)k, Arrays.asList(VArray));
        }

        @Override
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
                this.putAll((Object)entry.getKey(), entry.getValue());
            }
            return this;
        }

        @Override
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            this.keyComparator = Preconditions.checkNotNull(comparator);
            return this;
        }

        @Override
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            super.orderValuesBy(comparator);
            return this;
        }

        @Override
        public ImmutableSetMultimap<K, V> build() {
            if (this.keyComparator != null) {
                BuilderMultimap builderMultimap = new BuilderMultimap();
                ArrayList arrayList = Lists.newArrayList(this.builderMultimap.asMap().entrySet());
                Collections.sort(arrayList, Ordering.from(this.keyComparator).onKeys());
                for (Map.Entry entry : arrayList) {
                    builderMultimap.putAll(entry.getKey(), (Iterable)entry.getValue());
                }
                this.builderMultimap = builderMultimap;
            }
            return ImmutableSetMultimap.copyOf(this.builderMultimap, this.valueComparator);
        }
    }

    private static class BuilderMultimap<K, V>
    extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        @Override
        Collection<V> createCollection() {
            return Sets.newLinkedHashSet();
        }
    }
}

