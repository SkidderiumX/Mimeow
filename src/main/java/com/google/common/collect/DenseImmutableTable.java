/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
public class DenseImmutableTable<R, C, V>
extends RegularImmutableTable<R, C, V> {
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<R, Map<C, V>> rowMap;
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] rowCounts;
    private final int[] columnCounts;
    private final V[][] values;
    private final int[] iterationOrderRow;
    private final int[] iterationOrderColumn;

    private static <E> ImmutableMap<E, Integer> makeIndex(ImmutableSet<E> immutableSet) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int n = 0;
        for (Object e : immutableSet) {
            builder.put(e, n);
            ++n;
        }
        return builder.build();
    }

    DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        Object[][] objectArray = new Object[immutableSet.size()][immutableSet2.size()];
        this.values = objectArray;
        this.rowKeyToIndex = DenseImmutableTable.makeIndex(immutableSet);
        this.columnKeyToIndex = DenseImmutableTable.makeIndex(immutableSet2);
        this.rowCounts = new int[this.rowKeyToIndex.size()];
        this.columnCounts = new int[this.columnKeyToIndex.size()];
        int[] nArray = new int[immutableList.size()];
        int[] nArray2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); ++i) {
            int n;
            Table.Cell cell = (Table.Cell)immutableList.get(i);
            Object r = cell.getRowKey();
            Object c = cell.getColumnKey();
            int n2 = this.rowKeyToIndex.get(r);
            V v = this.values[n2][n = this.columnKeyToIndex.get(c).intValue()];
            Preconditions.checkArgument(v == null, "duplicate key: (%s, %s)", r, c);
            this.values[n2][n] = cell.getValue();
            int n3 = n2;
            this.rowCounts[n3] = this.rowCounts[n3] + 1;
            int n4 = n;
            this.columnCounts[n4] = this.columnCounts[n4] + 1;
            nArray[i] = n2;
            nArray2[i] = n;
        }
        this.iterationOrderRow = nArray;
        this.iterationOrderColumn = nArray2;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    @Override
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return this.columnMap;
    }

    @Override
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return this.rowMap;
    }

    @Override
    public V get(@Nullable Object object, @Nullable Object object2) {
        Integer n = this.rowKeyToIndex.get(object);
        Integer n2 = this.columnKeyToIndex.get(object2);
        return n == null || n2 == null ? null : (V)this.values[n][n2];
    }

    @Override
    public int size() {
        return this.iterationOrderRow.length;
    }

    @Override
    Table.Cell<R, C, V> getCell(int n) {
        int n2 = this.iterationOrderRow[n];
        int n3 = this.iterationOrderColumn[n];
        Object e = ((ImmutableCollection)((Object)this.rowKeySet())).asList().get(n2);
        Object e2 = ((ImmutableCollection)((Object)this.columnKeySet())).asList().get(n3);
        V v = this.values[n2][n3];
        return DenseImmutableTable.cellOf(e, e2, v);
    }

    @Override
    V getValue(int n) {
        return this.values[this.iterationOrderRow[n]][this.iterationOrderColumn[n]];
    }

    private final class ColumnMap
    extends ImmutableArrayMap<C, Map<R, V>> {
        private ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }

        @Override
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        @Override
        Map<R, V> getValue(int n) {
            return new Column(n);
        }

        @Override
        boolean isPartialView() {
            return false;
        }
    }

    private final class RowMap
    extends ImmutableArrayMap<R, Map<C, V>> {
        private RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }

        @Override
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        @Override
        Map<C, V> getValue(int n) {
            return new Row(n);
        }

        @Override
        boolean isPartialView() {
            return false;
        }
    }

    private final class Column
    extends ImmutableArrayMap<R, V> {
        private final int columnIndex;

        Column(int n) {
            super(DenseImmutableTable.this.columnCounts[n]);
            this.columnIndex = n;
        }

        @Override
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        @Override
        V getValue(int n) {
            return DenseImmutableTable.this.values[n][this.columnIndex];
        }

        @Override
        boolean isPartialView() {
            return true;
        }
    }

    private final class Row
    extends ImmutableArrayMap<C, V> {
        private final int rowIndex;

        Row(int n) {
            super(DenseImmutableTable.this.rowCounts[n]);
            this.rowIndex = n;
        }

        @Override
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        @Override
        V getValue(int n) {
            return DenseImmutableTable.this.values[this.rowIndex][n];
        }

        @Override
        boolean isPartialView() {
            return true;
        }
    }

    private static abstract class ImmutableArrayMap<K, V>
    extends ImmutableMap<K, V> {
        private final int size;

        ImmutableArrayMap(int n) {
            this.size = n;
        }

        abstract ImmutableMap<K, Integer> keyToIndex();

        private boolean isFull() {
            return this.size == this.keyToIndex().size();
        }

        K getKey(int n) {
            return (K)((ImmutableCollection)((Object)this.keyToIndex().keySet())).asList().get(n);
        }

        @Nullable
        abstract V getValue(int var1);

        @Override
        ImmutableSet<K> createKeySet() {
            return this.isFull() ? this.keyToIndex().keySet() : super.createKeySet();
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public V get(@Nullable Object object) {
            Integer n = this.keyToIndex().get(object);
            return n == null ? null : (V)this.getValue(n);
        }

        @Override
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>(){

                @Override
                ImmutableMap<K, V> map() {
                    return ImmutableArrayMap.this;
                }

                @Override
                public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                    return new AbstractIterator<Map.Entry<K, V>>(){
                        private int index = -1;
                        private final int maxIndex;
                        {
                            this.maxIndex = ImmutableArrayMap.this.keyToIndex().size();
                        }

                        @Override
                        protected Map.Entry<K, V> computeNext() {
                            ++this.index;
                            while (this.index < this.maxIndex) {
                                Object v = ImmutableArrayMap.this.getValue(this.index);
                                if (v != null) {
                                    return Maps.immutableEntry(ImmutableArrayMap.this.getKey(this.index), v);
                                }
                                ++this.index;
                            }
                            return (Map.Entry)this.endOfData();
                        }
                    };
                }
            };
        }
    }
}

