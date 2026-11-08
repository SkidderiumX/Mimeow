/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractSortedSetMultimap;
import java.util.Collection;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
public abstract class AbstractSortedKeySortedSetMultimap<K, V>
extends AbstractSortedSetMultimap<K, V> {
    AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap)super.asMap();
    }

    @Override
    SortedMap<K, Collection<V>> backingMap() {
        return (SortedMap)super.backingMap();
    }

    @Override
    public SortedSet<K> keySet() {
        return (SortedSet)super.keySet();
    }
}

