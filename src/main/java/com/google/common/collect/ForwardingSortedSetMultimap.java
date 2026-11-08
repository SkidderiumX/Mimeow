/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingSetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap<K, V>
extends ForwardingSetMultimap<K, V>
implements SortedSetMultimap<K, V> {
    protected ForwardingSortedSetMultimap() {
    }

    @Override
    protected abstract SortedSetMultimap<K, V> delegate();

    @Override
    public SortedSet<V> get(@Nullable K k) {
        return this.delegate().get(k);
    }

    @Override
    public SortedSet<V> removeAll(@Nullable Object object) {
        return this.delegate().removeAll(object);
    }

    @Override
    public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return this.delegate().replaceValues(k, iterable);
    }

    @Override
    public Comparator<? super V> valueComparator() {
        return this.delegate().valueComparator();
    }
}

