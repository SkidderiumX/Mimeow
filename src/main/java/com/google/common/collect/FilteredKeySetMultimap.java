/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public class FilteredKeySetMultimap<K, V>
extends FilteredKeyMultimap<K, V>
implements FilteredSetMultimap<K, V> {
    FilteredKeySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
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
    public Set<Map.Entry<K, V>> entries() {
        return (Set)super.entries();
    }

    @Override
    Set<Map.Entry<K, V>> createEntries() {
        return new EntrySet();
    }

    public class EntrySet
    extends FilteredKeyMultimap.Entries
    implements Set<Map.Entry<K, V>> {
        EntrySet() {
            super(FilteredKeySetMultimap.this);
        }

        @Override
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return Sets.equalsImpl(this, object);
        }
    }
}

