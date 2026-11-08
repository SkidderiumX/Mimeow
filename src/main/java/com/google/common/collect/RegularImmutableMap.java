/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class RegularImmutableMap<K, V>
extends ImmutableMap<K, V> {
    private final transient ImmutableMapEntry<K, V>[] entries;
    private final transient ImmutableMapEntry<K, V>[] table;
    private final transient int mask;
    private static final double MAX_LOAD_FACTOR = 1.2;
    private static final long serialVersionUID = 0L;

    RegularImmutableMap(ImmutableMapEntry.TerminalEntry<?, ?> ... terminalEntryArray) {
        this(terminalEntryArray.length, terminalEntryArray);
    }

    RegularImmutableMap(int n, ImmutableMapEntry.TerminalEntry<?, ?>[] terminalEntryArray) {
        this.entries = this.createEntryArray(n);
        int n2 = Hashing.closedTableSize(n, 1.2);
        this.table = this.createEntryArray(n2);
        this.mask = n2 - 1;
        for (int i = 0; i < n; ++i) {
            ImmutableMapEntry.TerminalEntry<?, ?> terminalEntry = terminalEntryArray[i];
            Object k = terminalEntry.getKey();
            int n3 = Hashing.smear(k.hashCode()) & this.mask;
            ImmutableMapEntry<K, V> immutableMapEntry = this.table[n3];
            ImmutableMapEntry immutableMapEntry2 = immutableMapEntry == null ? terminalEntry : new NonTerminalMapEntry((ImmutableMapEntry<?, ?>)terminalEntry, immutableMapEntry);
            this.table[n3] = immutableMapEntry2;
            this.entries[i] = immutableMapEntry2;
            this.checkNoConflictInBucket(k, immutableMapEntry2, immutableMapEntry);
        }
    }

    RegularImmutableMap(Map.Entry<?, ?>[] entryArray) {
        int n = entryArray.length;
        this.entries = this.createEntryArray(n);
        int n2 = Hashing.closedTableSize(n, 1.2);
        this.table = this.createEntryArray(n2);
        this.mask = n2 - 1;
        for (int i = 0; i < n; ++i) {
            Map.Entry<?, ?> entry = entryArray[i];
            Object obj = entry.getKey();
            Object obj2 = entry.getValue();
            CollectPreconditions.checkEntryNotNull(obj, obj2);
            int n3 = Hashing.smear(obj.hashCode()) & this.mask;
            ImmutableMapEntry<K, V> immutableMapEntry = this.table[n3];
            ImmutableMapEntry immutableMapEntry2 = immutableMapEntry == null ? new ImmutableMapEntry.TerminalEntry(obj, obj2) : new NonTerminalMapEntry(obj, obj2, immutableMapEntry);
            this.table[n3] = immutableMapEntry2;
            this.entries[i] = immutableMapEntry2;
            this.checkNoConflictInBucket(obj, immutableMapEntry2, immutableMapEntry);
        }
    }

    private void checkNoConflictInBucket(K k, ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2) {
        while (immutableMapEntry2 != null) {
            RegularImmutableMap.checkNoConflict(!k.equals(immutableMapEntry2.getKey()), "key", immutableMapEntry, immutableMapEntry2);
            immutableMapEntry2 = immutableMapEntry2.getNextInKeyBucket();
        }
    }

    private ImmutableMapEntry<K, V>[] createEntryArray(int n) {
        return new ImmutableMapEntry[n];
    }

    @Override
    public V get(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n = Hashing.smear(object.hashCode()) & this.mask;
        for (ImmutableMapEntry<K, V> immutableMapEntry = this.table[n]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInKeyBucket()) {
            Object k = immutableMapEntry.getKey();
            if (!object.equals(k)) continue;
            return immutableMapEntry.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return this.entries.length;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet();
    }

    private class EntrySet
    extends ImmutableMapEntrySet<K, V> {
        private EntrySet() {
        }

        @Override
        ImmutableMap<K, V> map() {
            return RegularImmutableMap.this;
        }

        @Override
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.asList().iterator();
        }

        @Override
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new RegularImmutableAsList(this, RegularImmutableMap.this.entries);
        }
    }

    private static final class NonTerminalMapEntry<K, V>
    extends ImmutableMapEntry<K, V> {
        private final ImmutableMapEntry<K, V> nextInKeyBucket;

        NonTerminalMapEntry(K k, V v, ImmutableMapEntry<K, V> immutableMapEntry) {
            super(k, v);
            this.nextInKeyBucket = immutableMapEntry;
        }

        NonTerminalMapEntry(ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2) {
            super(immutableMapEntry);
            this.nextInKeyBucket = immutableMapEntry2;
        }

        @Override
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        @Override
        @Nullable
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return null;
        }
    }
}

