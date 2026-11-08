/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Map;

@GwtCompatible
public class SingletonImmutableTable<R, C, V>
extends ImmutableTable<R, C, V> {
    final R singleRowKey;
    final C singleColumnKey;
    final V singleValue;

    SingletonImmutableTable(R r, C c, V v) {
        this.singleRowKey = Preconditions.checkNotNull(r);
        this.singleColumnKey = Preconditions.checkNotNull(c);
        this.singleValue = Preconditions.checkNotNull(v);
    }

    SingletonImmutableTable(Table.Cell<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }

    @Override
    public ImmutableMap<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        return this.containsColumn(c) ? ImmutableMap.of(this.singleRowKey, this.singleValue) : ImmutableMap.of();
    }

    @Override
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
    }

    @Override
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return ImmutableSet.of(SingletonImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override
    ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.singleValue);
    }
}

