/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.GwtTransient;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public class StandardTable<R, C, V>
extends AbstractTable<R, C, V>
implements Serializable {
    @GwtTransient
    final Map<R, Map<C, V>> backingMap;
    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;
    private transient Set<C> columnKeySet;
    private transient Map<R, Map<C, V>> rowMap;
    private transient ColumnMap columnMap;
    private static final long serialVersionUID = 0L;

    StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        return object != null && object2 != null && super.contains(object, object2);
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        for (Map<C, V> map : this.backingMap.values()) {
            if (!Maps.safeContainsKey(map, object)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return object != null && Maps.safeContainsKey(this.backingMap, object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return object != null && super.containsValue(object);
    }

    @Override
    public V get(@Nullable Object object, @Nullable Object object2) {
        return object == null || object2 == null ? null : (V)super.get(object, object2);
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public int size() {
        int n = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            n += map.size();
        }
        return n;
    }

    @Override
    public void clear() {
        this.backingMap.clear();
    }

    private Map<C, V> getOrCreate(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map == null) {
            map = this.factory.get();
            this.backingMap.put(r, map);
        }
        return map;
    }

    @Override
    public V put(R r, C c, V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(v);
        return this.getOrCreate(r).put(c, v);
    }

    @Override
    public V remove(@Nullable Object object, @Nullable Object object2) {
        if (object == null || object2 == null) {
            return null;
        }
        Map<C, V> map = Maps.safeGet(this.backingMap, object);
        if (map == null) {
            return null;
        }
        V v = map.remove(object2);
        if (map.isEmpty()) {
            this.backingMap.remove(object);
        }
        return v;
    }

    private Map<R, V> removeColumn(Object object) {
        LinkedHashMap<R, V> linkedHashMap = new LinkedHashMap<R, V>();
        Iterator<Map.Entry<R, Map<C, V>>> iterator2 = this.backingMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<R, Map<C, V>> entry = iterator2.next();
            V v = entry.getValue().remove(object);
            if (v == null) continue;
            linkedHashMap.put(entry.getKey(), v);
            if (!entry.getValue().isEmpty()) continue;
            iterator2.remove();
        }
        return linkedHashMap;
    }

    private boolean containsMapping(Object object, Object object2, Object object3) {
        return object3 != null && object3.equals(this.get(object, object2));
    }

    private boolean removeMapping(Object object, Object object2, Object object3) {
        if (this.containsMapping(object, object2, object3)) {
            this.remove(object, object2);
            return true;
        }
        return false;
    }

    @Override
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new CellIterator();
    }

    @Override
    public Map<C, V> row(R r) {
        return new Row(r);
    }

    @Override
    public Map<R, V> column(C c) {
        return new Column(c);
    }

    @Override
    public Set<R> rowKeySet() {
        return this.rowMap().keySet();
    }

    @Override
    public Set<C> columnKeySet() {
        ColumnKeySet columnKeySet = this.columnKeySet;
        return columnKeySet == null ? (this.columnKeySet = new ColumnKeySet()) : columnKeySet;
    }

    Iterator<C> createColumnKeyIterator() {
        return new ColumnKeyIterator();
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }

    @Override
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, Map<C, V>>> map = this.rowMap;
        return map == null ? (this.rowMap = this.createRowMap()) : map;
    }

    Map<R, Map<C, V>> createRowMap() {
        return new RowMap();
    }

    @Override
    public Map<C, Map<R, V>> columnMap() {
        ColumnMap columnMap = this.columnMap;
        return columnMap == null ? (this.columnMap = new ColumnMap()) : columnMap;
    }

    private class ColumnMap
    extends Maps.ImprovedAbstractMap<C, Map<R, V>> {
        private ColumnMap() {
        }

        @Override
        public Map<R, V> get(Object object) {
            return StandardTable.this.containsColumn(object) ? StandardTable.this.column(object) : null;
        }

        @Override
        public boolean containsKey(Object object) {
            return StandardTable.this.containsColumn(object);
        }

        @Override
        public Map<R, V> remove(Object object) {
            return StandardTable.this.containsColumn(object) ? StandardTable.this.removeColumn(object) : null;
        }

        @Override
        public Set<Map.Entry<C, Map<R, V>>> createEntrySet() {
            return new ColumnMapEntrySet();
        }

        @Override
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }

        @Override
        Collection<Map<R, V>> createValues() {
            return new ColumnMapValues();
        }

        private class ColumnMapValues
        extends Maps.Values<C, Map<R, V>> {
            ColumnMapValues() {
                super(ColumnMap.this);
            }

            @Override
            public boolean remove(Object object) {
                for (Map.Entry entry : ColumnMap.this.entrySet()) {
                    if (!((Map)entry.getValue()).equals(object)) continue;
                    StandardTable.this.removeColumn(entry.getKey());
                    return true;
                }
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean bl = false;
                for (Object c : Lists.newArrayList(StandardTable.this.columnKeySet().iterator())) {
                    if (!collection.contains(StandardTable.this.column(c))) continue;
                    StandardTable.this.removeColumn(c);
                    bl = true;
                }
                return bl;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean bl = false;
                for (Object c : Lists.newArrayList(StandardTable.this.columnKeySet().iterator())) {
                    if (collection.contains(StandardTable.this.column(c))) continue;
                    StandardTable.this.removeColumn(c);
                    bl = true;
                }
                return bl;
            }
        }

        public class ColumnMapEntrySet
        extends TableSet<Map.Entry<C, Map<R, V>>> {
            ColumnMapEntrySet() {
            }

            @Override
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.asMapEntryIterator(StandardTable.this.columnKeySet(), new Function<C, Map<R, V>>(){

                    @Override
                    public Map<R, V> apply(C c) {
                        return StandardTable.this.column(c);
                    }
                });
            }

            @Override
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }

            @Override
            public boolean contains(Object object) {
                Map.Entry entry;
                if (object instanceof Map.Entry && StandardTable.this.containsColumn((entry = (Map.Entry)object).getKey())) {
                    Object k = entry.getKey();
                    return ColumnMap.this.get(k).equals(entry.getValue());
                }
                return false;
            }

            @Override
            public boolean remove(Object object) {
                if (this.contains(object)) {
                    Map.Entry entry = (Map.Entry)object;
                    StandardTable.this.removeColumn(entry.getKey());
                    return true;
                }
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                return Sets.removeAllImpl(this, collection.iterator());
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean bl = false;
                for (Object c : Lists.newArrayList(StandardTable.this.columnKeySet().iterator())) {
                    if (collection.contains(Maps.immutableEntry(c, StandardTable.this.column(c)))) continue;
                    StandardTable.this.removeColumn(c);
                    bl = true;
                }
                return bl;
            }
        }
    }

    public class RowMap
    extends Maps.ImprovedAbstractMap<R, Map<C, V>> {
        RowMap() {
        }

        @Override
        public boolean containsKey(Object object) {
            return StandardTable.this.containsRow(object);
        }

        @Override
        public Map<C, V> get(Object object) {
            return StandardTable.this.containsRow(object) ? StandardTable.this.row(object) : null;
        }

        @Override
        public Map<C, V> remove(Object object) {
            return object == null ? null : StandardTable.this.backingMap.remove(object);
        }

        @Override
        protected Set<Map.Entry<R, Map<C, V>>> createEntrySet() {
            return new EntrySet();
        }

        public class EntrySet
        extends TableSet<Map.Entry<R, Map<C, V>>> {
            EntrySet() {
            }

            @Override
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.asMapEntryIterator(StandardTable.this.backingMap.keySet(), new Function<R, Map<C, V>>(){

                    @Override
                    public Map<C, V> apply(R r) {
                        return StandardTable.this.row(r);
                    }
                });
            }

            @Override
            public int size() {
                return StandardTable.this.backingMap.size();
            }

            @Override
            public boolean contains(Object object) {
                if (object instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)object;
                    return entry.getKey() != null && entry.getValue() instanceof Map && Collections2.safeContains(StandardTable.this.backingMap.entrySet(), entry);
                }
                return false;
            }

            @Override
            public boolean remove(Object object) {
                if (object instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)object;
                    return entry.getKey() != null && entry.getValue() instanceof Map && StandardTable.this.backingMap.entrySet().remove(entry);
                }
                return false;
            }
        }
    }

    private class ColumnKeyIterator
    extends AbstractIterator<C> {
        final Map<C, V> seen;
        final Iterator<Map<C, V>> mapIterator;
        Iterator<Map.Entry<C, V>> entryIterator;

        private ColumnKeyIterator() {
            this.seen = StandardTable.this.factory.get();
            this.mapIterator = StandardTable.this.backingMap.values().iterator();
            this.entryIterator = Iterators.emptyIterator();
        }

        @Override
        protected C computeNext() {
            while (true) {
                if (this.entryIterator.hasNext()) {
                    Map.Entry entry = this.entryIterator.next();
                    if (this.seen.containsKey(entry.getKey())) continue;
                    this.seen.put(entry.getKey(), entry.getValue());
                    return entry.getKey();
                }
                if (!this.mapIterator.hasNext()) break;
                this.entryIterator = this.mapIterator.next().entrySet().iterator();
            }
            return this.endOfData();
        }
    }

    private class ColumnKeySet
    extends TableSet<C> {
        private ColumnKeySet() {
        }

        @Override
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override
        public int size() {
            return Iterators.size(this.iterator());
        }

        @Override
        public boolean remove(Object object) {
            if (object == null) {
                return false;
            }
            boolean bl = false;
            Iterator iterator2 = StandardTable.this.backingMap.values().iterator();
            while (iterator2.hasNext()) {
                Map map = iterator2.next();
                if (!map.keySet().remove(object)) continue;
                bl = true;
                if (!map.isEmpty()) continue;
                iterator2.remove();
            }
            return bl;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            boolean bl = false;
            Iterator iterator2 = StandardTable.this.backingMap.values().iterator();
            while (iterator2.hasNext()) {
                Map map = iterator2.next();
                if (!Iterators.removeAll(map.keySet().iterator(), collection)) continue;
                bl = true;
                if (!map.isEmpty()) continue;
                iterator2.remove();
            }
            return bl;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            boolean bl = false;
            Iterator iterator2 = StandardTable.this.backingMap.values().iterator();
            while (iterator2.hasNext()) {
                Map map = iterator2.next();
                if (!map.keySet().retainAll(collection)) continue;
                bl = true;
                if (!map.isEmpty()) continue;
                iterator2.remove();
            }
            return bl;
        }

        @Override
        public boolean contains(Object object) {
            return StandardTable.this.containsColumn(object);
        }
    }

    private class Column
    extends Maps.ImprovedAbstractMap<R, V> {
        final C columnKey;

        Column(C c) {
            this.columnKey = Preconditions.checkNotNull(c);
        }

        @Override
        public V put(R r, V v) {
            return StandardTable.this.put(r, this.columnKey, v);
        }

        @Override
        public V get(Object object) {
            return StandardTable.this.get(object, this.columnKey);
        }

        @Override
        public boolean containsKey(Object object) {
            return StandardTable.this.contains(object, this.columnKey);
        }

        @Override
        public V remove(Object object) {
            return StandardTable.this.remove(object, this.columnKey);
        }

        boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> predicate) {
            boolean bl = false;
            Iterator iterator2 = StandardTable.this.backingMap.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Map map = entry.getValue();
                Object v = map.get(this.columnKey);
                if (v == null || !predicate.apply(Maps.immutableEntry(entry.getKey(), v))) continue;
                map.remove(this.columnKey);
                bl = true;
                if (!map.isEmpty()) continue;
                iterator2.remove();
            }
            return bl;
        }

        @Override
        Set<Map.Entry<R, V>> createEntrySet() {
            return new EntrySet();
        }

        @Override
        Set<R> createKeySet() {
            return new KeySet();
        }

        @Override
        Collection<V> createValues() {
            return new Values();
        }

        private class Values
        extends Maps.Values<R, V> {
            Values() {
                super(Column.this);
            }

            @Override
            public boolean remove(Object object) {
                return object != null && Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(object)));
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        private class KeySet
        extends Maps.KeySet<R, V> {
            KeySet() {
                super(Column.this);
            }

            @Override
            public boolean contains(Object object) {
                return StandardTable.this.contains(object, Column.this.columnKey);
            }

            @Override
            public boolean remove(Object object) {
                return StandardTable.this.remove(object, Column.this.columnKey) != null;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        private class EntrySetIterator
        extends AbstractIterator<Map.Entry<R, V>> {
            final Iterator<Map.Entry<R, Map<C, V>>> iterator;

            private EntrySetIterator() {
                this.iterator = StandardTable.this.backingMap.entrySet().iterator();
            }

            @Override
            protected Map.Entry<R, V> computeNext() {
                while (this.iterator.hasNext()) {
                    final Map.Entry entry = this.iterator.next();
                    if (!entry.getValue().containsKey(Column.this.columnKey)) continue;
                    return new AbstractMapEntry<R, V>(){

                        @Override
                        public R getKey() {
                            return entry.getKey();
                        }

                        @Override
                        public V getValue() {
                            return ((Map)entry.getValue()).get(Column.this.columnKey);
                        }

                        @Override
                        public V setValue(V v) {
                            return ((Map)entry.getValue()).put(Column.this.columnKey, Preconditions.checkNotNull(v));
                        }
                    };
                }
                return (Map.Entry)this.endOfData();
            }
        }

        private class EntrySet
        extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            private EntrySet() {
            }

            @Override
            public Iterator<Map.Entry<R, V>> iterator() {
                return new EntrySetIterator();
            }

            @Override
            public int size() {
                int n = 0;
                for (Map map : StandardTable.this.backingMap.values()) {
                    if (!map.containsKey(Column.this.columnKey)) continue;
                    ++n;
                }
                return n;
            }

            @Override
            public boolean isEmpty() {
                return !StandardTable.this.containsColumn(Column.this.columnKey);
            }

            @Override
            public void clear() {
                Column.this.removeFromColumnIf(Predicates.alwaysTrue());
            }

            @Override
            public boolean contains(Object object) {
                if (object instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)object;
                    return StandardTable.this.containsMapping(entry.getKey(), Column.this.columnKey, entry.getValue());
                }
                return false;
            }

            @Override
            public boolean remove(Object object) {
                if (object instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)object;
                    return StandardTable.this.removeMapping(entry.getKey(), Column.this.columnKey, entry.getValue());
                }
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Predicates.not(Predicates.in(collection)));
            }
        }
    }

    public class Row
    extends Maps.ImprovedAbstractMap<C, V> {
        final R rowKey;
        Map<C, V> backingRowMap;

        Row(R r) {
            this.rowKey = Preconditions.checkNotNull(r);
        }

        Map<C, V> backingRowMap() {
            Map map;
            if (this.backingRowMap == null || this.backingRowMap.isEmpty() && StandardTable.this.backingMap.containsKey(this.rowKey)) {
                this.backingRowMap = this.computeBackingRowMap();
                map = this.backingRowMap;
            } else {
                map = this.backingRowMap;
            }
            return map;
        }

        Map<C, V> computeBackingRowMap() {
            return StandardTable.this.backingMap.get(this.rowKey);
        }

        void maintainEmptyInvariant() {
            if (this.backingRowMap() != null && this.backingRowMap.isEmpty()) {
                StandardTable.this.backingMap.remove(this.rowKey);
                this.backingRowMap = null;
            }
        }

        @Override
        public boolean containsKey(Object object) {
            Map map = this.backingRowMap();
            return object != null && map != null && Maps.safeContainsKey(map, object);
        }

        @Override
        public V get(Object object) {
            Map map = this.backingRowMap();
            return object != null && map != null ? (Object)Maps.safeGet(map, object) : null;
        }

        @Override
        public V put(C c, V v) {
            Preconditions.checkNotNull(c);
            Preconditions.checkNotNull(v);
            if (this.backingRowMap != null && !this.backingRowMap.isEmpty()) {
                return this.backingRowMap.put(c, v);
            }
            return StandardTable.this.put(this.rowKey, c, v);
        }

        @Override
        public V remove(Object object) {
            Map map = this.backingRowMap();
            if (map == null) {
                return null;
            }
            Object v = Maps.safeRemove(map, object);
            this.maintainEmptyInvariant();
            return v;
        }

        @Override
        public void clear() {
            Map map = this.backingRowMap();
            if (map != null) {
                map.clear();
            }
            this.maintainEmptyInvariant();
        }

        @Override
        protected Set<Map.Entry<C, V>> createEntrySet() {
            return new RowEntrySet();
        }

        private final class RowEntrySet
        extends Maps.EntrySet<C, V> {
            private RowEntrySet() {
            }

            @Override
            Map<C, V> map() {
                return Row.this;
            }

            @Override
            public int size() {
                Map map = Row.this.backingRowMap();
                return map == null ? 0 : map.size();
            }

            @Override
            public Iterator<Map.Entry<C, V>> iterator() {
                Map map = Row.this.backingRowMap();
                if (map == null) {
                    return Iterators.emptyModifiableIterator();
                }
                final Iterator iterator2 = map.entrySet().iterator();
                return new Iterator<Map.Entry<C, V>>(){

                    @Override
                    public boolean hasNext() {
                        return iterator2.hasNext();
                    }

                    @Override
                    public Map.Entry<C, V> next() {
                        final Map.Entry entry = (Map.Entry)iterator2.next();
                        return new ForwardingMapEntry<C, V>(){

                            @Override
                            protected Map.Entry<C, V> delegate() {
                                return entry;
                            }

                            @Override
                            public V setValue(V v) {
                                return super.setValue(Preconditions.checkNotNull(v));
                            }

                            @Override
                            public boolean equals(Object object) {
                                return this.standardEquals(object);
                            }
                        };
                    }

                    @Override
                    public void remove() {
                        iterator2.remove();
                        Row.this.maintainEmptyInvariant();
                    }
                };
            }
        }
    }

    private class CellIterator
    implements Iterator<Table.Cell<R, C, V>> {
        final Iterator<Map.Entry<R, Map<C, V>>> rowIterator;
        Map.Entry<R, Map<C, V>> rowEntry;
        Iterator<Map.Entry<C, V>> columnIterator;

        private CellIterator() {
            this.rowIterator = StandardTable.this.backingMap.entrySet().iterator();
            this.columnIterator = Iterators.emptyModifiableIterator();
        }

        @Override
        public boolean hasNext() {
            return this.rowIterator.hasNext() || this.columnIterator.hasNext();
        }

        @Override
        public Table.Cell<R, C, V> next() {
            if (!this.columnIterator.hasNext()) {
                this.rowEntry = this.rowIterator.next();
                this.columnIterator = this.rowEntry.getValue().entrySet().iterator();
            }
            Map.Entry entry = this.columnIterator.next();
            return Tables.immutableCell(this.rowEntry.getKey(), entry.getKey(), entry.getValue());
        }

        @Override
        public void remove() {
            this.columnIterator.remove();
            if (this.rowEntry.getValue().isEmpty()) {
                this.rowIterator.remove();
            }
        }
    }

    private abstract class TableSet<T>
    extends Sets.ImprovedAbstractSet<T> {
        private TableSet() {
        }

        @Override
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }

        @Override
        public void clear() {
            StandardTable.this.backingMap.clear();
        }
    }
}

