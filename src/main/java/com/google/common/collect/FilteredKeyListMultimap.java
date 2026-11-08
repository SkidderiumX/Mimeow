/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.ListMultimap;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public class FilteredKeyListMultimap<K, V>
extends FilteredKeyMultimap<K, V>
implements ListMultimap<K, V> {
    FilteredKeyListMultimap(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    @Override
    public ListMultimap<K, V> unfiltered() {
        return (ListMultimap)super.unfiltered();
    }

    @Override
    public List<V> get(K k) {
        return (List)super.get(k);
    }

    @Override
    public List<V> removeAll(@Nullable Object object) {
        return (List)super.removeAll(object);
    }

    @Override
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (List)super.replaceValues(k, iterable);
    }
}

