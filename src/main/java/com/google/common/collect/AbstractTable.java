/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.TransformedIterator;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class AbstractTable<R, C, V>
implements Table<R, C, V> {
    private transient Set<Table.Cell<R, C, V>> cellSet;
    private transient Collection<V> values;

    AbstractTable() {
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return Maps.safeContainsKey(this.rowMap(), object);
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        return Maps.safeContainsKey(this.columnMap(), object);
    }

    @Override
    public Set<R> rowKeySet() {
        return this.rowMap().keySet();
    }

    @Override
    public Set<C> columnKeySet() {
        return this.columnMap().keySet();
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        for (Map map : this.rowMap().values()) {
            if (!map.containsValue(object)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        Map map = Maps.safeGet(this.rowMap(), object);
        return map != null && Maps.safeContainsKey(map, object2);
    }

    @Override
    public V get(@Nullable Object object, @Nullable Object object2) {
        Map map = Maps.safeGet(this.rowMap(), object);
        return map == null ? null : (V)Maps.safeGet(map, object2);
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        Iterators.clear(this.cellSet().iterator());
    }

    @Override
    public V remove(@Nullable Object object, @Nullable Object object2) {
        Map map = Maps.safeGet(this.rowMap(), object);
        return map == null ? null : (V)Maps.safeRemove(map, object2);
    }

    @Override
    public V put(R r, C c, V v) {
        return this.row(r).put(c, v);
    }

    @Override
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell<R, C, V> cell : table.cellSet()) {
            this.put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override
    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> set = this.cellSet;
        return set == null ? (this.cellSet = this.createCellSet()) : set;
    }

    Set<Table.Cell<R, C, V>> createCellSet() {
        return new CellSet();
    }

    abstract Iterator<Table.Cell<R, C, V>> cellIterator();

    @Override
    public Collection<V> values() {
        Collection<V> collection = this.values;
        return collection == null ? (this.values = this.createValues()) : collection;
    }

    Collection<V> createValues() {
        return new Values();
    }

    Iterator<V> valuesIterator() {
        return new TransformedIterator<Table.Cell<R, C, V>, V>(this.cellSet().iterator()){

            @Override
            V transform(Table.Cell<R, C, V> cell) {
                return cell.getValue();
            }
        };
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Tables.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        return this.cellSet().hashCode();
    }

    public String toString() {
        return this.rowMap().toString();
    }

    public class Values
    extends AbstractCollection<V> {
        Values() {
        }

        @Override
        public Iterator<V> iterator() {
            return AbstractTable.this.valuesIterator();
        }

        @Override
        public boolean contains(Object object) {
            return AbstractTable.this.containsValue(object);
        }

        @Override
        public void clear() {
            AbstractTable.this.clear();
        }

        @Override
        public int size() {
            return AbstractTable.this.size();
        }
    }

    public class CellSet
    extends AbstractSet<Table.Cell<R, C, V>> {
        CellSet() {
        }

        @Override
        public boolean contains(Object object) {
            if (object instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell)object;
                Map map = Maps.safeGet(AbstractTable.this.rowMap(), cell.getRowKey());
                return map != null && Collections2.safeContains(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()));
            }
            return false;
        }

        @Override
        public boolean remove(@Nullable Object object) {
            if (object instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell)object;
                Map map = Maps.safeGet(AbstractTable.this.rowMap(), cell.getRowKey());
                return map != null && Collections2.safeRemove(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()));
            }
            return false;
        }

        @Override
        public void clear() {
            AbstractTable.this.clear();
        }

        @Override
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return AbstractTable.this.cellIterator();
        }

        @Override
        public int size() {
            return AbstractTable.this.size();
        }
    }
}

