/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class RegularImmutableBiMap<K, V>
extends ImmutableBiMap<K, V> {
    static final double MAX_LOAD_FACTOR = 1.2;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    private final transient ImmutableMapEntry<K, V>[] valueTable;
    private final transient ImmutableMapEntry<K, V>[] entries;
    private final transient int mask;
    private final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;

    RegularImmutableBiMap(ImmutableMapEntry.TerminalEntry<?, ?> ... terminalEntryArray) {
        this(terminalEntryArray.length, terminalEntryArray);
    }

    RegularImmutableBiMap(int n, ImmutableMapEntry.TerminalEntry<?, ?>[] terminalEntryArray) {
        int n2 = Hashing.closedTableSize(n, 1.2);
        this.mask = n2 - 1;
        ImmutableMapEntry<K, V>[] immutableMapEntryArray = RegularImmutableBiMap.createEntryArray(n2);
        ImmutableMapEntry<K, V>[] immutableMapEntryArray2 = RegularImmutableBiMap.createEntryArray(n2);
        ImmutableMapEntry<K, V>[] immutableMapEntryArray3 = RegularImmutableBiMap.createEntryArray(n);
        int n3 = 0;
        for (int i = 0; i < n; ++i) {
            ImmutableMapEntry immutableMapEntry;
            ImmutableMapEntry immutableMapEntry2;
            ImmutableMapEntry immutableMapEntry3;
            ImmutableMapEntry.TerminalEntry<?, ?> terminalEntry = terminalEntryArray[i];
            Object k = terminalEntry.getKey();
            Object v = terminalEntry.getValue();
            int n4 = k.hashCode();
            int n5 = v.hashCode();
            int n6 = Hashing.smear(n4) & this.mask;
            int n7 = Hashing.smear(n5) & this.mask;
            for (immutableMapEntry3 = immutableMapEntry2 = immutableMapEntryArray[n6]; immutableMapEntry3 != null; immutableMapEntry3 = immutableMapEntry3.getNextInKeyBucket()) {
                RegularImmutableBiMap.checkNoConflict(!k.equals(immutableMapEntry3.getKey()), "key", terminalEntry, immutableMapEntry3);
            }
            for (immutableMapEntry = immutableMapEntry3 = immutableMapEntryArray2[n7]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInValueBucket()) {
                RegularImmutableBiMap.checkNoConflict(!v.equals(immutableMapEntry.getValue()), "value", terminalEntry, immutableMapEntry);
            }
            immutableMapEntry = immutableMapEntry2 == null && immutableMapEntry3 == null ? terminalEntry : new NonTerminalBiMapEntry(terminalEntry, immutableMapEntry2, immutableMapEntry3);
            immutableMapEntryArray[n6] = immutableMapEntry;
            immutableMapEntryArray2[n7] = immutableMapEntry;
            immutableMapEntryArray3[i] = immutableMapEntry;
            n3 += n4 ^ n5;
        }
        this.keyTable = immutableMapEntryArray;
        this.valueTable = immutableMapEntryArray2;
        this.entries = immutableMapEntryArray3;
        this.hashCode = n3;
    }

    RegularImmutableBiMap(Map.Entry<?, ?>[] entryArray) {
        int n = entryArray.length;
        int n2 = Hashing.closedTableSize(n, 1.2);
        this.mask = n2 - 1;
        ImmutableMapEntry<K, V>[] immutableMapEntryArray = RegularImmutableBiMap.createEntryArray(n2);
        ImmutableMapEntry<K, V>[] immutableMapEntryArray2 = RegularImmutableBiMap.createEntryArray(n2);
        ImmutableMapEntry<K, V>[] immutableMapEntryArray3 = RegularImmutableBiMap.createEntryArray(n);
        int n3 = 0;
        for (int i = 0; i < n; ++i) {
            ImmutableMapEntry<K, V> immutableMapEntry;
            ImmutableMapEntry<K, V> immutableMapEntry2;
            ImmutableMapEntry<K, V> immutableMapEntry3;
            Map.Entry<?, ?> entry = entryArray[i];
            Object obj = entry.getKey();
            Object obj2 = entry.getValue();
            CollectPreconditions.checkEntryNotNull(obj, obj2);
            int n4 = obj.hashCode();
            int n5 = obj2.hashCode();
            int n6 = Hashing.smear(n4) & this.mask;
            int n7 = Hashing.smear(n5) & this.mask;
            for (immutableMapEntry3 = immutableMapEntry2 = immutableMapEntryArray[n6]; immutableMapEntry3 != null; immutableMapEntry3 = immutableMapEntry3.getNextInKeyBucket()) {
                RegularImmutableBiMap.checkNoConflict(!obj.equals(immutableMapEntry3.getKey()), "key", entry, immutableMapEntry3);
            }
            for (immutableMapEntry = immutableMapEntry3 = immutableMapEntryArray2[n7]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInValueBucket()) {
                RegularImmutableBiMap.checkNoConflict(!obj2.equals(immutableMapEntry.getValue()), "value", entry, immutableMapEntry);
            }
            immutableMapEntry = immutableMapEntry2 == null && immutableMapEntry3 == null ? new ImmutableMapEntry.TerminalEntry(obj, obj2) : new NonTerminalBiMapEntry(obj, obj2, immutableMapEntry2, immutableMapEntry3);
            immutableMapEntryArray[n6] = immutableMapEntry;
            immutableMapEntryArray2[n7] = immutableMapEntry;
            immutableMapEntryArray3[i] = immutableMapEntry;
            n3 += n4 ^ n5;
        }
        this.keyTable = immutableMapEntryArray;
        this.valueTable = immutableMapEntryArray2;
        this.entries = immutableMapEntryArray3;
        this.hashCode = n3;
    }

    private static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int n) {
        return new ImmutableMapEntry[n];
    }

    @Override
    @Nullable
    public V get(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n = Hashing.smear(object.hashCode()) & this.mask;
        for (ImmutableMapEntry<K, V> immutableMapEntry = this.keyTable[n]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInKeyBucket()) {
            if (!object.equals(immutableMapEntry.getKey())) continue;
            return immutableMapEntry.getValue();
        }
        return null;
    }

    @Override
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet<K, V>(){

            @Override
            ImmutableMap<K, V> map() {
                return RegularImmutableBiMap.this;
            }

            @Override
            public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                return this.asList().iterator();
            }

            @Override
            ImmutableList<Map.Entry<K, V>> createAsList() {
                return new RegularImmutableAsList(this, RegularImmutableBiMap.this.entries);
            }

            @Override
            boolean isHashCodeFast() {
                return true;
            }

            @Override
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }
        };
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public int size() {
        return this.entries.length;
    }

    @Override
    public ImmutableBiMap<V, K> inverse() {
        Inverse inverse = this.inverse;
        return inverse == null ? (this.inverse = new Inverse()) : inverse;
    }

    private static class InverseSerializedForm<K, V>
    implements Serializable {
        private final ImmutableBiMap<K, V> forward;
        private static final long serialVersionUID = 1L;

        InverseSerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            this.forward = immutableBiMap;
        }

        Object readResolve() {
            return this.forward.inverse();
        }
    }

    private final class Inverse
    extends ImmutableBiMap<V, K> {
        private Inverse() {
        }

        @Override
        public int size() {
            return this.inverse().size();
        }

        @Override
        public ImmutableBiMap<K, V> inverse() {
            return RegularImmutableBiMap.this;
        }

        @Override
        public K get(@Nullable Object object) {
            if (object == null) {
                return null;
            }
            int n = Hashing.smear(object.hashCode()) & RegularImmutableBiMap.this.mask;
            for (ImmutableMapEntry immutableMapEntry = RegularImmutableBiMap.this.valueTable[n]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInValueBucket()) {
                if (!object.equals(immutableMapEntry.getValue())) continue;
                return immutableMapEntry.getKey();
            }
            return null;
        }

        @Override
        ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        @Override
        boolean isPartialView() {
            return false;
        }

        @Override
        Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }

        public final class InverseEntrySet
        extends ImmutableMapEntrySet<V, K> {
            InverseEntrySet() {
            }

            @Override
            ImmutableMap<V, K> map() {
                return Inverse.this;
            }

            @Override
            boolean isHashCodeFast() {
                return true;
            }

            @Override
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }

            @Override
            public UnmodifiableIterator<Map.Entry<V, K>> iterator() {
                return this.asList().iterator();
            }

            @Override
            ImmutableList<Map.Entry<V, K>> createAsList() {
                return new ImmutableAsList<Map.Entry<V, K>>(){

                    @Override
                    public Map.Entry<V, K> get(int n) {
                        ImmutableMapEntry immutableMapEntry = RegularImmutableBiMap.this.entries[n];
                        return Maps.immutableEntry(immutableMapEntry.getValue(), immutableMapEntry.getKey());
                    }

                    @Override
                    ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }
                };
            }
        }
    }

    private static final class NonTerminalBiMapEntry<K, V>
    extends ImmutableMapEntry<K, V> {
        @Nullable
        private final ImmutableMapEntry<K, V> nextInKeyBucket;
        @Nullable
        private final ImmutableMapEntry<K, V> nextInValueBucket;

        NonTerminalBiMapEntry(K k, V v, @Nullable ImmutableMapEntry<K, V> immutableMapEntry, @Nullable ImmutableMapEntry<K, V> immutableMapEntry2) {
            super(k, v);
            this.nextInKeyBucket = immutableMapEntry;
            this.nextInValueBucket = immutableMapEntry2;
        }

        NonTerminalBiMapEntry(ImmutableMapEntry<K, V> immutableMapEntry, @Nullable ImmutableMapEntry<K, V> immutableMapEntry2, @Nullable ImmutableMapEntry<K, V> immutableMapEntry3) {
            super(immutableMapEntry);
            this.nextInKeyBucket = immutableMapEntry2;
            this.nextInValueBucket = immutableMapEntry3;
        }

        @Override
        @Nullable
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        @Override
        @Nullable
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }
}

