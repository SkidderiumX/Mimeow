/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class RegularImmutableSortedMap<K, V>
extends ImmutableSortedMap<K, V> {
    private final transient RegularImmutableSortedSet<K> keySet;
    private final transient ImmutableList<V> valueList;

    RegularImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
    }

    RegularImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        super(immutableSortedMap);
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
    }

    @Override
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet();
    }

    @Override
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override
    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    @Override
    public V get(@Nullable Object object) {
        int n = this.keySet.indexOf(object);
        return n == -1 ? null : (V)this.valueList.get(n);
    }

    private ImmutableSortedMap<K, V> getSubMap(int n, int n2) {
        if (n == 0 && n2 == this.size()) {
            return this;
        }
        if (n == n2) {
            return RegularImmutableSortedMap.emptyMap(this.comparator());
        }
        return RegularImmutableSortedMap.from(this.keySet.getSubSet(n, n2), this.valueList.subList(n, n2));
    }

    @Override
    public ImmutableSortedMap<K, V> headMap(K k, boolean bl) {
        return this.getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(k), bl));
    }

    @Override
    public ImmutableSortedMap<K, V> tailMap(K k, boolean bl) {
        return this.getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(k), bl), this.size());
    }

    @Override
    ImmutableSortedMap<K, V> createDescendingMap() {
        return new RegularImmutableSortedMap<K, V>((RegularImmutableSortedSet)this.keySet.descendingSet(), this.valueList.reverse(), this);
    }

    private class EntrySet
    extends ImmutableMapEntrySet<K, V> {
        private EntrySet() {
        }

        @Override
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.asList().iterator();
        }

        @Override
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableAsList<Map.Entry<K, V>>(){
                private final ImmutableList<K> keyList;
                {
                    this.keyList = ((ImmutableCollection)((Object)RegularImmutableSortedMap.this.keySet())).asList();
                }

                @Override
                public Map.Entry<K, V> get(int n) {
                    return Maps.immutableEntry(this.keyList.get(n), RegularImmutableSortedMap.this.valueList.get(n));
                }

                @Override
                ImmutableCollection<Map.Entry<K, V>> delegateCollection() {
                    return EntrySet.this;
                }
            };
        }

        @Override
        ImmutableMap<K, V> map() {
            return RegularImmutableSortedMap.this;
        }
    }
}

