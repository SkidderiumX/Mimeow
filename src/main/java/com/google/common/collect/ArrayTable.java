/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public class ArrayTable<R, C, V>
extends AbstractTable<R, C, V>
implements Serializable {
    private final ImmutableList<R> rowList;
    private final ImmutableList<C> columnList;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final V[][] array;
    private transient ColumnMap columnMap;
    private transient RowMap rowMap;
    private static final long serialVersionUID = 0L;

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<R, C, V>(iterable, iterable2);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<R, C, V>((ArrayTable)table) : new ArrayTable<R, C, V>(table);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.checkArgument(!this.rowList.isEmpty());
        Preconditions.checkArgument(!this.columnList.isEmpty());
        this.rowKeyToIndex = ArrayTable.index(this.rowList);
        this.columnKeyToIndex = ArrayTable.index(this.columnList);
        Object[][] objectArray = new Object[this.rowList.size()][this.columnList.size()];
        this.array = objectArray;
        this.eraseAll();
    }

    private static <E> ImmutableMap<E, Integer> index(List<E> list) {
        ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
        for (int i = 0; i < list.size(); ++i) {
            builder.put(list.get(i), i);
        }
        return builder.build();
    }

    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        this.putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        this.rowList = arrayTable.rowList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        Object[][] objectArray = new Object[this.rowList.size()][this.columnList.size()];
        this.array = objectArray;
        this.eraseAll();
        for (int i = 0; i < this.rowList.size(); ++i) {
            System.arraycopy(arrayTable.array[i], 0, objectArray[i], 0, arrayTable.array[i].length);
        }
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    public V at(int n, int n2) {
        Preconditions.checkElementIndex(n, this.rowList.size());
        Preconditions.checkElementIndex(n2, this.columnList.size());
        return this.array[n][n2];
    }

    public V set(int n, int n2, @Nullable V v) {
        Preconditions.checkElementIndex(n, this.rowList.size());
        Preconditions.checkElementIndex(n2, this.columnList.size());
        V v2 = this.array[n][n2];
        this.array[n][n2] = v;
        return v2;
    }

    @GwtIncompatible(value="reflection")
    public V[][] toArray(Class<V> clazz) {
        Object[][] objectArray = (Object[][])Array.newInstance(clazz, this.rowList.size(), this.columnList.size());
        for (int i = 0; i < this.rowList.size(); ++i) {
            System.arraycopy(this.array[i], 0, objectArray[i], 0, this.array[i].length);
        }
        return objectArray;
    }

    @Override
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        for (Object[] objectArray : this.array) {
            Arrays.fill(objectArray, null);
        }
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        return this.containsRow(object) && this.containsColumn(object2);
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        return this.columnKeyToIndex.containsKey(object);
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return this.rowKeyToIndex.containsKey(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        V[][] VArray = this.array;
        int n = VArray.length;
        for (int i = 0; i < n; ++i) {
            V[] VArray2;
            for (V v : VArray2 = VArray[i]) {
                if (!Objects.equal(object, v)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(@Nullable Object object, @Nullable Object object2) {
        Integer n = this.rowKeyToIndex.get(object);
        Integer n2 = this.columnKeyToIndex.get(object2);
        return n == null || n2 == null ? null : (V)this.at(n, n2);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V put(R r, C c, @Nullable V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Integer n = this.rowKeyToIndex.get(r);
        Preconditions.checkArgument(n != null, "Row %s not in %s", r, this.rowList);
        Integer n2 = this.columnKeyToIndex.get(c);
        Preconditions.checkArgument(n2 != null, "Column %s not in %s", c, this.columnList);
        return this.set(n, n2, v);
    }

    @Override
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override
    @Deprecated
    public V remove(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    public V erase(@Nullable Object object, @Nullable Object object2) {
        Integer n = this.rowKeyToIndex.get(object);
        Integer n2 = this.columnKeyToIndex.get(object2);
        if (n == null || n2 == null) {
            return null;
        }
        return this.set(n, n2, null);
    }

    @Override
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @Override
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(this.size()){

            @Override
            protected Table.Cell<R, C, V> get(final int n) {
                return new Tables.AbstractCell<R, C, V>(){
                    final int rowIndex;
                    final int columnIndex;
                    {
                        this.rowIndex = n / ArrayTable.this.columnList.size();
                        this.columnIndex = n % ArrayTable.this.columnList.size();
                    }

                    @Override
                    public R getRowKey() {
                        return ArrayTable.this.rowList.get(this.rowIndex);
                    }

                    @Override
                    public C getColumnKey() {
                        return ArrayTable.this.columnList.get(this.columnIndex);
                    }

                    @Override
                    public V getValue() {
                        return ArrayTable.this.at(this.rowIndex, this.columnIndex);
                    }
                };
            }
        };
    }

    @Override
    public Map<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        Integer n = this.columnKeyToIndex.get(c);
        return n == null ? ImmutableMap.of() : new Column(n);
    }

    @Override
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override
    public Map<C, Map<R, V>> columnMap() {
        ColumnMap columnMap = this.columnMap;
        return columnMap == null ? (this.columnMap = new ColumnMap()) : columnMap;
    }

    @Override
    public Map<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        Integer n = this.rowKeyToIndex.get(r);
        return n == null ? ImmutableMap.of() : new Row(n);
    }

    @Override
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override
    public Map<R, Map<C, V>> rowMap() {
        RowMap rowMap = this.rowMap;
        return rowMap == null ? (this.rowMap = new RowMap()) : rowMap;
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }

    private class RowMap
    extends ArrayMap<R, Map<C, V>> {
        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        @Override
        String getKeyRole() {
            return "Row";
        }

        @Override
        Map<C, V> getValue(int n) {
            return new Row(n);
        }

        @Override
        Map<C, V> setValue(int n, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private class Row
    extends ArrayMap<C, V> {
        final int rowIndex;

        Row(int n) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = n;
        }

        @Override
        String getKeyRole() {
            return "Column";
        }

        @Override
        V getValue(int n) {
            return ArrayTable.this.at(this.rowIndex, n);
        }

        @Override
        V setValue(int n, V v) {
            return ArrayTable.this.set(this.rowIndex, n, v);
        }
    }

    private class ColumnMap
    extends ArrayMap<C, Map<R, V>> {
        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        @Override
        String getKeyRole() {
            return "Column";
        }

        @Override
        Map<R, V> getValue(int n) {
            return new Column(n);
        }

        @Override
        Map<R, V> setValue(int n, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private class Column
    extends ArrayMap<R, V> {
        final int columnIndex;

        Column(int n) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = n;
        }

        @Override
        String getKeyRole() {
            return "Row";
        }

        @Override
        V getValue(int n) {
            return ArrayTable.this.at(n, this.columnIndex);
        }

        @Override
        V setValue(int n, V v) {
            return ArrayTable.this.set(n, this.columnIndex, v);
        }
    }

    private static abstract class ArrayMap<K, V>
    extends Maps.ImprovedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        private ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.keyIndex = immutableMap;
        }

        @Override
        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        K getKey(int n) {
            return (K)((ImmutableCollection)((Object)this.keyIndex.keySet())).asList().get(n);
        }

        abstract String getKeyRole();

        @Nullable
        abstract V getValue(int var1);

        @Nullable
        abstract V setValue(int var1, V var2);

        @Override
        public int size() {
            return this.keyIndex.size();
        }

        @Override
        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        @Override
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new Maps.EntrySet<K, V>(){

                @Override
                Map<K, V> map() {
                    return ArrayMap.this;
                }

                @Override
                public Iterator<Map.Entry<K, V>> iterator() {
                    return new AbstractIndexedListIterator<Map.Entry<K, V>>(this.size()){

                        @Override
                        protected Map.Entry<K, V> get(final int n) {
                            return new AbstractMapEntry<K, V>(){

                                @Override
                                public K getKey() {
                                    return ArrayMap.this.getKey(n);
                                }

                                @Override
                                public V getValue() {
                                    return ArrayMap.this.getValue(n);
                                }

                                @Override
                                public V setValue(V v) {
                                    return ArrayMap.this.setValue(n, v);
                                }
                            };
                        }
                    };
                }
            };
        }

        @Override
        public boolean containsKey(@Nullable Object object) {
            return this.keyIndex.containsKey(object);
        }

        @Override
        public V get(@Nullable Object object) {
            Integer n = this.keyIndex.get(object);
            if (n == null) {
                return null;
            }
            return this.getValue(n);
        }

        @Override
        public V put(K k, V v) {
            Integer n = this.keyIndex.get(k);
            if (n == null) {
                throw new IllegalArgumentException(this.getKeyRole() + " " + k + " not in " + this.keyIndex.keySet());
            }
            return this.setValue(n, v);
        }

        @Override
        public V remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }
}

