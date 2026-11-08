/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class RegularImmutableMultiset<E>
extends ImmutableMultiset<E> {
    private final transient ImmutableMap<E, Integer> map;
    private final transient int size;

    RegularImmutableMultiset(ImmutableMap<E, Integer> immutableMap, int n) {
        this.map = immutableMap;
        this.size = n;
    }

    @Override
    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override
    public int count(@Nullable Object object) {
        Integer n = this.map.get(object);
        return n == null ? 0 : n;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public ImmutableSet<E> elementSet() {
        return this.map.keySet();
    }

    @Override
    Multiset.Entry<E> getEntry(int n) {
        Map.Entry entry = (Map.Entry)((ImmutableCollection)((Object)this.map.entrySet())).asList().get(n);
        return Multisets.immutableEntry(entry.getKey(), (Integer)entry.getValue());
    }

    @Override
    public int hashCode() {
        return this.map.hashCode();
    }
}

