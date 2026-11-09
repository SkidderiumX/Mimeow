/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
public class SparseImmutableTable<R, C, V>
extends RegularImmutableTable<R, C, V> {
    private final ImmutableMap<R, Map<C, V>> rowMap;
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] iterationOrderRow;
    private final int[] iterationOrderColumn;

    SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap.Builder builder;
        HashMap hashMap = Maps.newHashMap();
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        for (Object object222 : immutableSet) {
            hashMap.put(object222, linkedHashMap.size());
            linkedHashMap.put(object222, new LinkedHashMap());
        }
        LinkedHashMap linkedHashMap2 = Maps.newLinkedHashMap();
        for (Object object32 : immutableSet2) {
            linkedHashMap2.put(object32, new LinkedHashMap());
        }
        int[] nArray = new int[immutableList.size()];
        int[] nArray2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); ++i) {
            builder = (Table.Cell)immutableList.get(i);
            Object object4 = builder.getRowKey();
            Object c = builder.getColumnKey();
            Object v = builder.getValue();
            nArray[i] = (Integer)hashMap.get(object4);
            Map map = (Map)linkedHashMap.get(object4);
            nArray2[i] = map.size();
            Object v2 = map.put(c, v);
            if (v2 != null) {
                throw new IllegalArgumentException("Duplicate value for row=" + object4 + ", column=" + c + ": " + v + ", " + v2);
            }
            ((Map)linkedHashMap2.get(c)).put(object4, v);
        }
        this.iterationOrderRow = nArray;
        this.iterationOrderColumn = nArray2;
        ImmutableMap.Builder builder2 = ImmutableMap.builder();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            builder2.put(entry.getKey(), ImmutableMap.copyOf((Map)entry.getValue()));
        }
        this.rowMap = builder2.build();
        builder = ImmutableMap.builder();
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map)entry.getValue()));
        }
        this.columnMap = builder.build();
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
    public int size() {
        return this.iterationOrderRow.length;
    }

    @Override
    Table.Cell<R, C, V> getCell(int n) {
        int n2 = this.iterationOrderRow[n];
        Map.Entry entry = (Map.Entry)((ImmutableCollection)((Object)this.rowMap.entrySet())).asList().get(n2);
        ImmutableMap immutableMap = (ImmutableMap)entry.getValue();
        int n3 = this.iterationOrderColumn[n];
        Map.Entry entry2 = (Map.Entry)((ImmutableCollection)((Object)immutableMap.entrySet())).asList().get(n3);
        return SparseImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override
    V getValue(int n) {
        int n2 = this.iterationOrderRow[n];
        ImmutableMap immutableMap = (ImmutableMap)((ImmutableCollection)this.rowMap.values()).asList().get(n2);
        int n3 = this.iterationOrderColumn[n];
        return (V)((ImmutableCollection)immutableMap.values()).asList().get(n3);
    }
}

