/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.SparseImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ImmutableTable<R, C, V>
extends AbstractTable<R, C, V> {
    private static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable<Object, Object, Object>(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return EMPTY;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r, C c, V v) {
        return new SingletonImmutableTable<R, C, V>(r, c, v);
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> table) {
        if (table instanceof ImmutableTable) {
            ImmutableTable immutableTable = (ImmutableTable)table;
            return immutableTable;
        }
        int n = table.size();
        switch (n) {
            case 0: {
                return ImmutableTable.of();
            }
            case 1: {
                Table.Cell<R, C, V> cell = Iterables.getOnlyElement(table.cellSet());
                return ImmutableTable.of(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (Table.Cell<R, C, V> cell : table.cellSet()) {
            builder.add(ImmutableTable.cellOf(cell.getRowKey(), cell.getColumnKey(), cell.getValue()));
        }
        return RegularImmutableTable.forCells(builder.build());
    }

    public static <R, C, V> Builder<R, C, V> builder() {
        return new Builder();
    }

    static <R, C, V> Table.Cell<R, C, V> cellOf(R r, C c, V v) {
        return Tables.immutableCell(Preconditions.checkNotNull(r), Preconditions.checkNotNull(c), Preconditions.checkNotNull(v));
    }

    ImmutableTable() {
    }

    @Override
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet)super.cellSet();
    }

    @Override
    abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();

    @Override
    final UnmodifiableIterator<Table.Cell<R, C, V>> cellIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public ImmutableCollection<V> values() {
        return (ImmutableCollection)super.values();
    }

    @Override
    abstract ImmutableCollection<V> createValues();

    @Override
    final Iterator<V> valuesIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public ImmutableMap<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        return Objects.firstNonNull((ImmutableMap)((ImmutableMap)this.columnMap()).get(c), ImmutableMap.of());
    }

    @Override
    public ImmutableSet<C> columnKeySet() {
        return ((ImmutableMap)this.columnMap()).keySet();
    }

    @Override
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override
    public ImmutableMap<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        return Objects.firstNonNull((ImmutableMap)((ImmutableMap)this.rowMap()).get(r), ImmutableMap.of());
    }

    @Override
    public ImmutableSet<R> rowKeySet() {
        return ((ImmutableMap)this.rowMap()).keySet();
    }

    @Override
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        return this.get(object, object2) != null;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return ((ImmutableCollection)this.values()).contains(object);
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final V remove(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    public static final class Builder<R, C, V> {
        private final List<Table.Cell<R, C, V>> cells = Lists.newArrayList();
        private Comparator<? super R> rowComparator;
        private Comparator<? super C> columnComparator;

        public Builder<R, C, V> orderRowsBy(Comparator<? super R> comparator) {
            this.rowComparator = Preconditions.checkNotNull(comparator);
            return this;
        }

        public Builder<R, C, V> orderColumnsBy(Comparator<? super C> comparator) {
            this.columnComparator = Preconditions.checkNotNull(comparator);
            return this;
        }

        public Builder<R, C, V> put(R r, C c, V v) {
            this.cells.add(ImmutableTable.cellOf(r, c, v));
            return this;
        }

        public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof Tables.ImmutableCell) {
                Preconditions.checkNotNull(cell.getRowKey());
                Preconditions.checkNotNull(cell.getColumnKey());
                Preconditions.checkNotNull(cell.getValue());
                Table.Cell<R, C, V> cell2 = cell;
                this.cells.add(cell2);
            } else {
                this.put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }

        public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> table) {
            for (Table.Cell<R, C, V> cell : table.cellSet()) {
                this.put(cell);
            }
            return this;
        }

        public ImmutableTable<R, C, V> build() {
            int n = this.cells.size();
            switch (n) {
                case 0: {
                    return ImmutableTable.of();
                }
                case 1: {
                    return new SingletonImmutableTable<R, C, V>(Iterables.getOnlyElement(this.cells));
                }
            }
            return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
        }
    }
}

