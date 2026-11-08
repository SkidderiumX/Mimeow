/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class AbstractSetMultimap<K, V>
extends AbstractMapBasedMultimap<K, V>
implements SetMultimap<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override
    abstract Set<V> createCollection();

    @Override
    Set<V> createUnmodifiableEmptyCollection() {
        return ImmutableSet.of();
    }

    @Override
    public Set<V> get(@Nullable K k) {
        return (Set)super.get(k);
    }

    @Override
    public Set<Map.Entry<K, V>> entries() {
        return (Set)super.entries();
    }

    @Override
    public Set<V> removeAll(@Nullable Object object) {
        return (Set)super.removeAll(object);
    }

    @Override
    public Set<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        return (Set)super.replaceValues(k, iterable);
    }

    @Override
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override
    public boolean put(@Nullable K k, @Nullable V v) {
        return super.put(k, v);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return super.equals(object);
    }
}

