/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public class FilteredEntrySetMultimap<K, V>
extends FilteredEntryMultimap<K, V>
implements FilteredSetMultimap<K, V> {
    FilteredEntrySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        super(setMultimap, predicate);
    }

    @Override
    public SetMultimap<K, V> unfiltered() {
        return (SetMultimap)this.unfiltered;
    }

    @Override
    public Set<V> get(K k) {
        return (Set)super.get(k);
    }

    @Override
    public Set<V> removeAll(Object object) {
        return (Set)super.removeAll(object);
    }

    @Override
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set)super.replaceValues(k, iterable);
    }

    @Override
    Set<Map.Entry<K, V>> createEntries() {
        return Sets.filter(this.unfiltered().entries(), this.entryPredicate());
    }

    @Override
    public Set<Map.Entry<K, V>> entries() {
        return (Set)super.entries();
    }
}

