/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class HashBasedTable<R, C, V>
extends StandardTable<R, C, V> {
    private static final long serialVersionUID = 0L;

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable(new HashMap(), new Factory(0));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int n, int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedCellsPerRow");
        HashMap hashMap = Maps.newHashMapWithExpectedSize(n);
        return new HashBasedTable(hashMap, new Factory(n2));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(Table<? extends R, ? extends C, ? extends V> table) {
        HashBasedTable<R, C, V> hashBasedTable = HashBasedTable.create();
        hashBasedTable.putAll((Table)table);
        return hashBasedTable;
    }

    HashBasedTable(Map<R, Map<C, V>> map, Factory<C, V> factory) {
        super(map, factory);
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        return super.contains(object, object2);
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        return super.containsColumn(object);
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return super.containsRow(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return super.containsValue(object);
    }

    @Override
    public V get(@Nullable Object object, @Nullable Object object2) {
        return super.get(object, object2);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return super.equals(object);
    }

    @Override
    public V remove(@Nullable Object object, @Nullable Object object2) {
        return super.remove(object, object2);
    }

    private static class Factory<C, V>
    implements Supplier<Map<C, V>>,
    Serializable {
        final int expectedSize;
        private static final long serialVersionUID = 0L;

        Factory(int n) {
            this.expectedSize = n;
        }

        @Override
        public Map<C, V> get() {
            return Maps.newHashMapWithExpectedSize(this.expectedSize);
        }
    }
}

