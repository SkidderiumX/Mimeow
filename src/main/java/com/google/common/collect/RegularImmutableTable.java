package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
public abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V>
{
    RegularImmutableTable() {
    }
    
    abstract Table.Cell<R, C, V> getCell(final int p0);
    
    @Override
    final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return this.isEmpty() ? ImmutableSet.of() : new CellSet();
    }
    
    abstract V getValue(final int p0);
    
    @Override
    final ImmutableCollection<V> createValues() {
        return (ImmutableCollection<V>)(this.isEmpty() ? ImmutableList.of() : new Values());
    }
    
    static <R, C, V> RegularImmutableTable<R, C, V> forCells(final List<Table.Cell<R, C, V>> list, @Nullable final Comparator<? super R> comparator, @Nullable final Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort((List<Object>)list, (Comparator<? super Object>)new Comparator<Table.Cell<R, C, V>>() {
                @Override
                public int compare(final Table.Cell<R, C, V> cell, final Table.Cell<R, C, V> cell2) {
                    final int n = (comparator == null) ? 0 : comparator.compare(cell.getRowKey(), cell2.getRowKey());
                    if (n != 0) {
                        return n;
                    }
                    return (comparator2 == null) ? 0 : comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
                }
            });
        }
        return forCellsInternal(list, comparator, comparator2);
    }
    
    static <R, C, V> RegularImmutableTable<R, C, V> forCells(final Iterable<Table.Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }
    
    private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(final Iterable<Table.Cell<R, C, V>> iterable, @Nullable final Comparator<? super R> c, @Nullable final Comparator<? super C> c2) {
        final ImmutableSet.Builder<Object> builder = (ImmutableSet.Builder<Object>)ImmutableSet.builder();
        final ImmutableSet.Builder<Object> builder2 = (ImmutableSet.Builder<Object>)ImmutableSet.builder();
        final ImmutableList<Object> copy = ImmutableList.copyOf((Iterable<?>)iterable);
        for (final Table.Cell cell : copy) {
            builder.add(cell.getRowKey());
            builder2.add(cell.getColumnKey());
        }
        ImmutableSet<Object> set = (ImmutableSet<Object>)builder.build();
        if (c != null) {
            final ArrayList<Object> arrayList = Lists.newArrayList((Iterable<?>)set);
            Collections.sort(arrayList, (Comparator<? super Object>)c);
            set = ImmutableSet.copyOf((Collection<?>)arrayList);
        }
        ImmutableSet<Object> set2 = (ImmutableSet<Object>)builder2.build();
        if (c2 != null) {
            final ArrayList<Object> arrayList2 = Lists.newArrayList((Iterable<?>)set2);
            Collections.sort(arrayList2, (Comparator<? super Object>)c2);
            set2 = ImmutableSet.copyOf((Collection<?>)arrayList2);
        }
        return (RegularImmutableTable<R, C, V>)((copy.size() > set.size() * (long)set2.size() / 2L) ? new DenseImmutableTable<R, C, V>((ImmutableList<Table.Cell<Object, Object, Object>>)copy, set, set2) : new SparseImmutableTable<R, C, V>((ImmutableList<Table.Cell<Object, Object, Object>>)copy, set, set2));
    }
    
    private final class Values extends ImmutableList<V>
    {
        @Override
        public int size() {
            return RegularImmutableTable.this.size();
        }
        
        @Override
        public V get(final int n) {
            return RegularImmutableTable.this.getValue(n);
        }
        
        @Override
        boolean isPartialView() {
            return true;
        }
    }
    
    private final class CellSet extends ImmutableSet<Table.Cell<R, C, V>>
    {
        @Override
        public int size() {
            return RegularImmutableTable.this.size();
        }
        
        @Override
        public UnmodifiableIterator<Table.Cell<R, C, V>> iterator() {
            return this.asList().iterator();
        }
        
        @Override
        ImmutableList<Table.Cell<R, C, V>> createAsList() {
            return new ImmutableAsList<Table.Cell<R, C, V>>() {
                @Override
                public Table.Cell<R, C, V> get(final int n) {
                    return RegularImmutableTable.this.getCell(n);
                }
                
                @Override
                ImmutableCollection<Table.Cell<R, C, V>> delegateCollection() {
                    return CellSet.this;
                }
            };
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            if (o instanceof Table.Cell) {
                final Table.Cell cell = (Table.Cell)o;
                final Object value = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
                return value != null && value.equals(cell.getValue());
            }
            return false;
        }
        
        @Override
        boolean isPartialView() {
            return false;
        }
    }
}
