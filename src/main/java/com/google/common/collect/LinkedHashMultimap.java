/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class LinkedHashMultimap<K, V>
extends AbstractSetMultimap<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    @VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0;
    @VisibleForTesting
    transient int valueSetCapacity = 2;
    private transient ValueEntry<K, V> multimapHeaderEntry;
    @GwtIncompatible(value="java serialization not supported")
    private static final long serialVersionUID = 1L;

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<K, V>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int n, int n2) {
        return new LinkedHashMultimap<K, V>(Maps.capacity(n), Maps.capacity(n2));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> linkedHashMultimap = LinkedHashMultimap.create(multimap.keySet().size(), 2);
        linkedHashMultimap.putAll((Multimap)multimap);
        return linkedHashMultimap;
    }

    private static <K, V> void succeedsInValueSet(ValueSetLink<K, V> valueSetLink, ValueSetLink<K, V> valueSetLink2) {
        valueSetLink.setSuccessorInValueSet(valueSetLink2);
        valueSetLink2.setPredecessorInValueSet(valueSetLink);
    }

    private static <K, V> void succeedsInMultimap(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    private static <K, V> void deleteFromValueSet(ValueSetLink<K, V> valueSetLink) {
        LinkedHashMultimap.succeedsInValueSet(valueSetLink.getPredecessorInValueSet(), valueSetLink.getSuccessorInValueSet());
    }

    private static <K, V> void deleteFromMultimap(ValueEntry<K, V> valueEntry) {
        LinkedHashMultimap.succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
    }

    private LinkedHashMultimap(int n, int n2) {
        super(new LinkedHashMap(n));
        CollectPreconditions.checkNonnegative(n2, "expectedValuesPerKey");
        this.valueSetCapacity = n2;
        this.multimapHeaderEntry = new ValueEntry<Object, Object>(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    @Override
    Set<V> createCollection() {
        return new LinkedHashSet(this.valueSetCapacity);
    }

    @Override
    Collection<V> createCollection(K k) {
        return new ValueSet(k, this.valueSetCapacity);
    }

    @Override
    public Set<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        return super.replaceValues((Object)k, (Iterable)iterable);
    }

    @Override
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }

    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new Iterator<Map.Entry<K, V>>(){
            ValueEntry<K, V> nextEntry;
            ValueEntry<K, V> toRemove;
            {
                this.nextEntry = ((LinkedHashMultimap)LinkedHashMultimap.this).multimapHeaderEntry.successorInMultimap;
            }

            @Override
            public boolean hasNext() {
                return this.nextEntry != LinkedHashMultimap.this.multimapHeaderEntry;
            }

            @Override
            public Map.Entry<K, V> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                ValueEntry valueEntry = this.nextEntry;
                this.toRemove = valueEntry;
                this.nextEntry = this.nextEntry.successorInMultimap;
                return valueEntry;
            }

            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                LinkedHashMultimap.this.remove(this.toRemove.getKey(), this.toRemove.getValue());
                this.toRemove = null;
            }
        };
    }

    @Override
    Iterator<V> valueIterator() {
        return Maps.valueIterator(this.entryIterator());
    }

    @Override
    public void clear() {
        super.clear();
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.valueSetCapacity);
        objectOutputStream.writeInt(this.keySet().size());
        for (Object object : this.keySet()) {
            objectOutputStream.writeObject(object);
        }
        objectOutputStream.writeInt(this.size());
        for (Object object : this.entries()) {
            objectOutputStream.writeObject(object.getKey());
            objectOutputStream.writeObject(object.getValue());
        }
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int n;
        objectInputStream.defaultReadObject();
        this.multimapHeaderEntry = new ValueEntry<Object, Object>(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
        this.valueSetCapacity = objectInputStream.readInt();
        int n2 = objectInputStream.readInt();
        LinkedHashMap<Object, Collection<V>> linkedHashMap = new LinkedHashMap<Object, Collection<V>>(Maps.capacity(n2));
        for (n = 0; n < n2; ++n) {
            Object object = objectInputStream.readObject();
            linkedHashMap.put(object, this.createCollection(object));
        }
        n = objectInputStream.readInt();
        for (int i = 0; i < n; ++i) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            ((Collection)linkedHashMap.get(object)).add(object2);
        }
        this.setMap(linkedHashMap);
    }

    @VisibleForTesting
    public final class ValueSet
    extends Sets.ImprovedAbstractSet<V>
    implements ValueSetLink<K, V> {
        private final K key;
        @VisibleForTesting
        ValueEntry<K, V>[] hashTable;
        private int size = 0;
        private int modCount = 0;
        private ValueSetLink<K, V> firstEntry;
        private ValueSetLink<K, V> lastEntry;

        ValueSet(K k, int n) {
            this.key = k;
            this.firstEntry = this;
            this.lastEntry = this;
            int n2 = Hashing.closedTableSize(n, 1.0);
            ValueEntry[] valueEntryArray = new ValueEntry[n2];
            this.hashTable = valueEntryArray;
        }

        private int mask() {
            return this.hashTable.length - 1;
        }

        @Override
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.lastEntry;
        }

        @Override
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.firstEntry;
        }

        @Override
        public void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.lastEntry = valueSetLink;
        }

        @Override
        public void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.firstEntry = valueSetLink;
        }

        @Override
        public Iterator<V> iterator() {
            return new Iterator<V>(){
                ValueSetLink<K, V> nextEntry;
                ValueEntry<K, V> toRemove;
                int expectedModCount;
                {
                    this.nextEntry = ValueSet.this.firstEntry;
                    this.expectedModCount = ValueSet.this.modCount;
                }

                private void checkForComodification() {
                    if (ValueSet.this.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override
                public boolean hasNext() {
                    this.checkForComodification();
                    return this.nextEntry != ValueSet.this;
                }

                @Override
                public V next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    ValueEntry valueEntry = (ValueEntry)this.nextEntry;
                    Object v = valueEntry.getValue();
                    this.toRemove = valueEntry;
                    this.nextEntry = valueEntry.getSuccessorInValueSet();
                    return v;
                }

                @Override
                public void remove() {
                    this.checkForComodification();
                    CollectPreconditions.checkRemove(this.toRemove != null);
                    ValueSet.this.remove(this.toRemove.getValue());
                    this.expectedModCount = ValueSet.this.modCount;
                    this.toRemove = null;
                }
            };
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean contains(@Nullable Object object) {
            int n = Hashing.smearedHash(object);
            ValueEntry valueEntry = this.hashTable[n & this.mask()];
            while (valueEntry != null) {
                if (valueEntry.matchesValue(object, n)) {
                    return true;
                }
                valueEntry = valueEntry.nextInValueBucket;
            }
            return false;
        }

        @Override
        public boolean add(@Nullable V v) {
            ValueEntry valueEntry;
            int n = Hashing.smearedHash(v);
            int n2 = n & this.mask();
            ValueEntry valueEntry2 = valueEntry = this.hashTable[n2];
            while (valueEntry2 != null) {
                if (valueEntry2.matchesValue(v, n)) {
                    return false;
                }
                valueEntry2 = valueEntry2.nextInValueBucket;
            }
            valueEntry2 = new ValueEntry(this.key, v, n, valueEntry);
            LinkedHashMultimap.succeedsInValueSet(this.lastEntry, valueEntry2);
            LinkedHashMultimap.succeedsInValueSet(valueEntry2, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry2);
            LinkedHashMultimap.succeedsInMultimap(valueEntry2, LinkedHashMultimap.this.multimapHeaderEntry);
            this.hashTable[n2] = valueEntry2;
            ++this.size;
            ++this.modCount;
            this.rehashIfNecessary();
            return true;
        }

        private void rehashIfNecessary() {
            if (Hashing.needsResizing(this.size, this.hashTable.length, 1.0)) {
                ValueEntry[] valueEntryArray = new ValueEntry[this.hashTable.length * 2];
                this.hashTable = valueEntryArray;
                int n = valueEntryArray.length - 1;
                for (ValueSetLink valueSetLink = this.firstEntry; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
                    ValueEntry valueEntry = (ValueEntry)valueSetLink;
                    int n2 = valueEntry.smearedValueHash & n;
                    valueEntry.nextInValueBucket = valueEntryArray[n2];
                    valueEntryArray[n2] = valueEntry;
                }
            }
        }

        @Override
        public boolean remove(@Nullable Object object) {
            int n = Hashing.smearedHash(object);
            int n2 = n & this.mask();
            ValueEntry valueEntry = null;
            ValueEntry valueEntry2 = this.hashTable[n2];
            while (valueEntry2 != null) {
                if (valueEntry2.matchesValue(object, n)) {
                    if (valueEntry == null) {
                        this.hashTable[n2] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    --this.size;
                    ++this.modCount;
                    return true;
                }
                valueEntry = valueEntry2;
                valueEntry2 = valueEntry2.nextInValueBucket;
            }
            return false;
        }

        @Override
        public void clear() {
            Arrays.fill(this.hashTable, null);
            this.size = 0;
            for (ValueSetLink valueSetLink = this.firstEntry; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
                ValueEntry valueEntry = (ValueEntry)valueSetLink;
                LinkedHashMultimap.deleteFromMultimap(valueEntry);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            ++this.modCount;
        }
    }

    @VisibleForTesting
    public static final class ValueEntry<K, V>
    extends ImmutableEntry<K, V>
    implements ValueSetLink<K, V> {
        final int smearedValueHash;
        @Nullable
        ValueEntry<K, V> nextInValueBucket;
        ValueSetLink<K, V> predecessorInValueSet;
        ValueSetLink<K, V> successorInValueSet;
        ValueEntry<K, V> predecessorInMultimap;
        ValueEntry<K, V> successorInMultimap;

        ValueEntry(@Nullable K k, @Nullable V v, int n, @Nullable ValueEntry<K, V> valueEntry) {
            super(k, v);
            this.smearedValueHash = n;
            this.nextInValueBucket = valueEntry;
        }

        boolean matchesValue(@Nullable Object object, int n) {
            return this.smearedValueHash == n && Objects.equal(this.getValue(), object);
        }

        @Override
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        @Override
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        @Override
        public void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.predecessorInValueSet = valueSetLink;
        }

        @Override
        public void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.successorInValueSet = valueSetLink;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }
    }

    private static interface ValueSetLink<K, V> {
        public ValueSetLink<K, V> getPredecessorInValueSet();

        public ValueSetLink<K, V> getSuccessorInValueSet();

        public void setPredecessorInValueSet(ValueSetLink<K, V> var1);

        public void setSuccessorInValueSet(ValueSetLink<K, V> var1);
    }
}

