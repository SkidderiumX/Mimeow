/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class ImmutableMapKeySet<K, V>
extends ImmutableSet<K> {
    private final ImmutableMap<K, V> map;

    ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public UnmodifiableIterator<K> iterator() {
        return this.asList().iterator();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.map.containsKey(object);
    }

    @Override
    ImmutableList<K> createAsList() {
        final ImmutableList immutableList = ((ImmutableCollection)((Object)this.map.entrySet())).asList();
        return new ImmutableAsList<K>(){

            @Override
            public K get(int n) {
                return ((Map.Entry)immutableList.get(n)).getKey();
            }

            @Override
            ImmutableCollection<K> delegateCollection() {
                return ImmutableMapKeySet.this;
            }
        };
    }

    @Override
    boolean isPartialView() {
        return true;
    }

    @Override
    @GwtIncompatible(value="serialization")
    Object writeReplace() {
        return new KeySetSerializedForm<K>(this.map);
    }

    @GwtIncompatible(value="serialization")
    private static class KeySetSerializedForm<K>
    implements Serializable {
        final ImmutableMap<K, ?> map;
        private static final long serialVersionUID = 0L;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.keySet();
        }
    }
}

