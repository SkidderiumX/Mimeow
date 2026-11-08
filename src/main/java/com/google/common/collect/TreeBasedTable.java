/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.StandardRowSortedTable;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
@Beta
public class TreeBasedTable<R, C, V>
extends StandardRowSortedTable<R, C, V> {
    private final Comparator<? super C> columnComparator;
    private static final long serialVersionUID = 0L;

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable(Ordering.natural(), Ordering.natural());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<R, C, V>(comparator, comparator2);
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<R, C, V>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll((Table)treeBasedTable);
        return treeBasedTable2;
    }

    TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public Comparator<? super R> rowComparator() {
        return this.rowKeySet().comparator();
    }

    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override
    public SortedMap<C, V> row(R r) {
        return new TreeRow(r);
    }

    @Override
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    @Override
    Iterator<C> createColumnKeyIterator() {
        final Comparator<C> comparator = this.columnComparator();
        final UnmodifiableIterator<C> unmodifiableIterator = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new Function<Map<C, V>, Iterator<C>>(){

            @Override
            public Iterator<C> apply(Map<C, V> map) {
                return map.keySet().iterator();
            }
        }), comparator);
        return new AbstractIterator<C>(){
            C lastValue;

            @Override
            protected C computeNext() {
                while (unmodifiableIterator.hasNext()) {
                    Object e = unmodifiableIterator.next();
                    boolean bl = this.lastValue != null && comparator.compare(e, this.lastValue) == 0;
                    if (bl) continue;
                    this.lastValue = e;
                    return this.lastValue;
                }
                this.lastValue = null;
                return this.endOfData();
            }
        };
    }

    private class TreeRow
    extends StandardTable.Row
    implements SortedMap<C, V> {
        @Nullable
        final C lowerBound;
        @Nullable
        final C upperBound;
        transient SortedMap<C, V> wholeRow;

        TreeRow(R r) {
            this(r, null, null);
        }

        TreeRow(@Nullable R r, @Nullable C c, C c2) {
            super(r);
            this.lowerBound = c;
            this.upperBound = c2;
            Preconditions.checkArgument(c == null || c2 == null || this.compare(c, c2) <= 0);
        }

        @Override
        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet(this);
        }

        @Override
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        int compare(Object object, Object object2) {
            Comparator comparator = this.comparator();
            return comparator.compare(object, object2);
        }

        boolean rangeContains(@Nullable Object object) {
            return !(object == null || this.lowerBound != null && this.compare(this.lowerBound, object) > 0 || this.upperBound != null && this.compare(this.upperBound, object) <= 0);
        }

        @Override
        public SortedMap<C, V> subMap(C c, C c2) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)) && this.rangeContains(Preconditions.checkNotNull(c2)));
            return new TreeRow(this.rowKey, c, c2);
        }

        @Override
        public SortedMap<C, V> headMap(C c) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)));
            return new TreeRow(this.rowKey, this.lowerBound, c);
        }

        @Override
        public SortedMap<C, V> tailMap(C c) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)));
            return new TreeRow(this.rowKey, c, this.upperBound);
        }

        @Override
        public C firstKey() {
            Map map = this.backingRowMap();
            if (map == null) {
                throw new NoSuchElementException();
            }
            return this.backingRowMap().firstKey();
        }

        @Override
        public C lastKey() {
            Map map = this.backingRowMap();
            if (map == null) {
                throw new NoSuchElementException();
            }
            return this.backingRowMap().lastKey();
        }

        SortedMap<C, V> wholeRow() {
            if (this.wholeRow == null || this.wholeRow.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.rowKey)) {
                this.wholeRow = (SortedMap)TreeBasedTable.this.backingMap.get(this.rowKey);
            }
            return this.wholeRow;
        }

        SortedMap<C, V> backingRowMap() {
            return (SortedMap)super.backingRowMap();
        }

        SortedMap<C, V> computeBackingRowMap() {
            SortedMap sortedMap = this.wholeRow();
            if (sortedMap != null) {
                if (this.lowerBound != null) {
                    sortedMap = sortedMap.tailMap(this.lowerBound);
                }
                if (this.upperBound != null) {
                    sortedMap = sortedMap.headMap(this.upperBound);
                }
                return sortedMap;
            }
            return null;
        }

        @Override
        void maintainEmptyInvariant() {
            if (this.wholeRow() != null && this.wholeRow.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.rowKey);
                this.wholeRow = null;
                this.backingRowMap = null;
            }
        }

        @Override
        public boolean containsKey(Object object) {
            return this.rangeContains(object) && super.containsKey(object);
        }

        @Override
        public V put(C c, V v) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)));
            return super.put(c, v);
        }
    }

    private static class Factory<C, V>
    implements Supplier<TreeMap<C, V>>,
    Serializable {
        final Comparator<? super C> comparator;
        private static final long serialVersionUID = 0L;

        Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override
        public TreeMap<C, V> get() {
            return new TreeMap(this.comparator);
        }
    }
}

