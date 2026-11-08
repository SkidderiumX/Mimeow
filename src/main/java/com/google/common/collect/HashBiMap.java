/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.Maps;
import com.google.common.collect.Serialization;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class HashBiMap<K, V>
extends AbstractMap<K, V>
implements BiMap<K, V>,
Serializable {
    private static final double LOAD_FACTOR = 1.0;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient int size;
    private transient int mask;
    private transient int modCount;
    private transient BiMap<V, K> inverse;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0L;

    public static <K, V> HashBiMap<K, V> create() {
        return HashBiMap.create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int n) {
        return new HashBiMap<K, V>(n);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> hashBiMap = HashBiMap.create(map.size());
        hashBiMap.putAll(map);
        return hashBiMap;
    }

    private HashBiMap(int n) {
        this.init(n);
    }

    private void init(int n) {
        CollectPreconditions.checkNonnegative(n, "expectedSize");
        int n2 = Hashing.closedTableSize(n, 1.0);
        this.hashTableKToV = this.createTable(n2);
        this.hashTableVToK = this.createTable(n2);
        this.mask = n2 - 1;
        this.modCount = 0;
        this.size = 0;
    }

    private void delete(BiEntry<K, V> biEntry) {
        int n = biEntry.keyHash & this.mask;
        BiEntry<K, V> biEntry2 = null;
        BiEntry<K, V> biEntry3 = this.hashTableKToV[n];
        while (true) {
            if (biEntry3 == biEntry) {
                if (biEntry2 == null) {
                    this.hashTableKToV[n] = biEntry.nextInKToVBucket;
                    break;
                }
                biEntry2.nextInKToVBucket = biEntry.nextInKToVBucket;
                break;
            }
            biEntry2 = biEntry3;
            biEntry3 = biEntry3.nextInKToVBucket;
        }
        int n2 = biEntry.valueHash & this.mask;
        biEntry2 = null;
        BiEntry<K, V> biEntry4 = this.hashTableVToK[n2];
        while (true) {
            if (biEntry4 == biEntry) {
                if (biEntry2 == null) {
                    this.hashTableVToK[n2] = biEntry.nextInVToKBucket;
                    break;
                }
                biEntry2.nextInVToKBucket = biEntry.nextInVToKBucket;
                break;
            }
            biEntry2 = biEntry4;
            biEntry4 = biEntry4.nextInVToKBucket;
        }
        --this.size;
        ++this.modCount;
    }

    private void insert(BiEntry<K, V> biEntry) {
        int n = biEntry.keyHash & this.mask;
        biEntry.nextInKToVBucket = this.hashTableKToV[n];
        this.hashTableKToV[n] = biEntry;
        int n2 = biEntry.valueHash & this.mask;
        biEntry.nextInVToKBucket = this.hashTableVToK[n2];
        this.hashTableVToK[n2] = biEntry;
        ++this.size;
        ++this.modCount;
    }

    private static int hash(@Nullable Object object) {
        return Hashing.smear(object == null ? 0 : object.hashCode());
    }

    private BiEntry<K, V> seekByKey(@Nullable Object object, int n) {
        BiEntry<K, V> biEntry = this.hashTableKToV[n & this.mask];
        while (biEntry != null) {
            if (n == biEntry.keyHash && Objects.equal(object, biEntry.key)) {
                return biEntry;
            }
            biEntry = biEntry.nextInKToVBucket;
        }
        return null;
    }

    private BiEntry<K, V> seekByValue(@Nullable Object object, int n) {
        BiEntry<K, V> biEntry = this.hashTableVToK[n & this.mask];
        while (biEntry != null) {
            if (n == biEntry.valueHash && Objects.equal(object, biEntry.value)) {
                return biEntry;
            }
            biEntry = biEntry.nextInVToKBucket;
        }
        return null;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.seekByKey(object, HashBiMap.hash(object)) != null;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.seekByValue(object, HashBiMap.hash(object)) != null;
    }

    @Override
    @Nullable
    public V get(@Nullable Object object) {
        BiEntry<K, V> biEntry = this.seekByKey(object, HashBiMap.hash(object));
        return (V)(biEntry == null ? null : biEntry.value);
    }

    @Override
    public V put(@Nullable K k, @Nullable V v) {
        return this.put(k, v, false);
    }

    @Override
    public V forcePut(@Nullable K k, @Nullable V v) {
        return this.put(k, v, true);
    }

    private V put(@Nullable K k, @Nullable V v, boolean bl) {
        int n = HashBiMap.hash(k);
        int n2 = HashBiMap.hash(v);
        BiEntry<K, V> biEntry = this.seekByKey(k, n);
        if (biEntry != null && n2 == biEntry.valueHash && Objects.equal(v, biEntry.value)) {
            return v;
        }
        BiEntry<K, V> biEntry2 = this.seekByValue(v, n2);
        if (biEntry2 != null) {
            if (bl) {
                this.delete(biEntry2);
            } else {
                throw new IllegalArgumentException("value already present: " + v);
            }
        }
        if (biEntry != null) {
            this.delete(biEntry);
        }
        BiEntry<K, V> biEntry3 = new BiEntry<K, V>(k, n, v, n2);
        this.insert(biEntry3);
        this.rehashIfNecessary();
        return (V)(biEntry == null ? null : biEntry.value);
    }

    @Nullable
    private K putInverse(@Nullable V v, @Nullable K k, boolean bl) {
        int n = HashBiMap.hash(v);
        int n2 = HashBiMap.hash(k);
        BiEntry<K, V> biEntry = this.seekByValue(v, n);
        if (biEntry != null && n2 == biEntry.keyHash && Objects.equal(k, biEntry.key)) {
            return k;
        }
        BiEntry<K, V> biEntry2 = this.seekByKey(k, n2);
        if (biEntry2 != null) {
            if (bl) {
                this.delete(biEntry2);
            } else {
                throw new IllegalArgumentException("value already present: " + k);
            }
        }
        if (biEntry != null) {
            this.delete(biEntry);
        }
        BiEntry<K, V> biEntry3 = new BiEntry<K, V>(k, n2, v, n);
        this.insert(biEntry3);
        this.rehashIfNecessary();
        return (K)(biEntry == null ? null : biEntry.key);
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] biEntryArray = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, biEntryArray.length, 1.0)) {
            int n = biEntryArray.length * 2;
            this.hashTableKToV = this.createTable(n);
            this.hashTableVToK = this.createTable(n);
            this.mask = n - 1;
            this.size = 0;
            for (int i = 0; i < biEntryArray.length; ++i) {
                BiEntry<K, V> biEntry = biEntryArray[i];
                while (biEntry != null) {
                    BiEntry biEntry2 = biEntry.nextInKToVBucket;
                    this.insert(biEntry);
                    biEntry = biEntry2;
                }
            }
            ++this.modCount;
        }
    }

    private BiEntry<K, V>[] createTable(int n) {
        return new BiEntry[n];
    }

    @Override
    public V remove(@Nullable Object object) {
        BiEntry<K, V> biEntry = this.seekByKey(object, HashBiMap.hash(object));
        if (biEntry == null) {
            return null;
        }
        this.delete(biEntry);
        return (V)biEntry.value;
    }

    @Override
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        ++this.modCount;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Set<K> keySet() {
        return new KeySet();
    }

    @Override
    public Set<V> values() {
        return this.inverse().keySet();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override
    public BiMap<V, K> inverse() {
        return this.inverse == null ? (this.inverse = new Inverse()) : this.inverse;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int n = Serialization.readCount(objectInputStream);
        this.init(n);
        Serialization.populateMap(this, objectInputStream, n);
    }

    private static final class InverseSerializedForm<K, V>
    implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> hashBiMap) {
            this.bimap = hashBiMap;
        }

        Object readResolve() {
            return this.bimap.inverse();
        }
    }

    private final class Inverse
    extends AbstractMap<V, K>
    implements BiMap<V, K>,
    Serializable {
        private Inverse() {
        }

        BiMap<K, V> forward() {
            return HashBiMap.this;
        }

        @Override
        public int size() {
            return HashBiMap.this.size;
        }

        @Override
        public void clear() {
            this.forward().clear();
        }

        @Override
        public boolean containsKey(@Nullable Object object) {
            return this.forward().containsValue(object);
        }

        @Override
        public K get(@Nullable Object object) {
            BiEntry biEntry = HashBiMap.this.seekByValue(object, HashBiMap.hash(object));
            return biEntry == null ? null : biEntry.key;
        }

        @Override
        public K put(@Nullable V v, @Nullable K k) {
            return HashBiMap.this.putInverse(v, k, false);
        }

        @Override
        public K forcePut(@Nullable V v, @Nullable K k) {
            return HashBiMap.this.putInverse(v, k, true);
        }

        @Override
        public K remove(@Nullable Object object) {
            BiEntry biEntry = HashBiMap.this.seekByValue(object, HashBiMap.hash(object));
            if (biEntry == null) {
                return null;
            }
            HashBiMap.this.delete(biEntry);
            return biEntry.key;
        }

        @Override
        public BiMap<K, V> inverse() {
            return this.forward();
        }

        @Override
        public Set<V> keySet() {
            return new InverseKeySet();
        }

        @Override
        public Set<K> values() {
            return this.forward().keySet();
        }

        @Override
        public Set<Map.Entry<V, K>> entrySet() {
            return new Maps.EntrySet<V, K>(){

                @Override
                Map<V, K> map() {
                    return Inverse.this;
                }

                @Override
                public Iterator<Map.Entry<V, K>> iterator() {
                    return new Itr<Map.Entry<V, K>>(){

                        @Override
                        Map.Entry<V, K> output(BiEntry<K, V> biEntry) {
                            return new InverseEntry(biEntry);
                        }

                        public class InverseEntry
                        extends AbstractMapEntry<V, K> {
                            BiEntry<K, V> delegate;

                            InverseEntry(BiEntry<K, V> biEntry) {
                                this.delegate = biEntry;
                            }

                            @Override
                            public V getKey() {
                                return this.delegate.value;
                            }

                            @Override
                            public K getValue() {
                                return this.delegate.key;
                            }

                            @Override
                            public K setValue(K k) {
                                Object object = this.delegate.key;
                                int n = HashBiMap.hash(k);
                                if (n == this.delegate.keyHash && Objects.equal(k, object)) {
                                    return k;
                                }
                                Preconditions.checkArgument(HashBiMap.this.seekByKey(k, n) == null, "value already present: %s", k);
                                HashBiMap.this.delete(this.delegate);
                                BiEntry biEntry = new BiEntry(k, n, this.delegate.value, this.delegate.valueHash);
                                HashBiMap.this.insert(biEntry);
                                expectedModCount = HashBiMap.this.modCount;
                                return object;
                            }
                        }
                    };
                }
            };
        }

        Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }

        private final class InverseKeySet
        extends Maps.KeySet<V, K> {
            InverseKeySet() {
                super(Inverse.this);
            }

            @Override
            public boolean remove(@Nullable Object object) {
                BiEntry biEntry = HashBiMap.this.seekByValue(object, HashBiMap.hash(object));
                if (biEntry == null) {
                    return false;
                }
                HashBiMap.this.delete(biEntry);
                return true;
            }

            @Override
            public Iterator<V> iterator() {
                return new Itr<V>(){

                    @Override
                    V output(BiEntry<K, V> biEntry) {
                        return biEntry.value;
                    }
                };
            }
        }
    }

    private final class EntrySet
    extends Maps.EntrySet<K, V> {
        private EntrySet() {
        }

        @Override
        Map<K, V> map() {
            return HashBiMap.this;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Itr<Map.Entry<K, V>>(){

                @Override
                Map.Entry<K, V> output(BiEntry<K, V> biEntry) {
                    return new MapEntry(biEntry);
                }

                public class MapEntry
                extends AbstractMapEntry<K, V> {
                    BiEntry<K, V> delegate;

                    MapEntry(BiEntry<K, V> biEntry) {
                        this.delegate = biEntry;
                    }

                    @Override
                    public K getKey() {
                        return this.delegate.key;
                    }

                    @Override
                    public V getValue() {
                        return this.delegate.value;
                    }

                    @Override
                    public V setValue(V v) {
                        Object object = this.delegate.value;
                        int n = HashBiMap.hash(v);
                        if (n == this.delegate.valueHash && Objects.equal(v, object)) {
                            return v;
                        }
                        Preconditions.checkArgument(HashBiMap.this.seekByValue(v, n) == null, "value already present: %s", v);
                        HashBiMap.this.delete(this.delegate);
                        BiEntry biEntry = new BiEntry(this.delegate.key, this.delegate.keyHash, v, n);
                        HashBiMap.this.insert(biEntry);
                        expectedModCount = HashBiMap.this.modCount;
                        if (toRemove == this.delegate) {
                            toRemove = biEntry;
                        }
                        this.delegate = biEntry;
                        return object;
                    }
                }
            };
        }
    }

    private final class KeySet
    extends Maps.KeySet<K, V> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override
        public Iterator<K> iterator() {
            return new Itr<K>(){

                @Override
                K output(BiEntry<K, V> biEntry) {
                    return biEntry.key;
                }
            };
        }

        @Override
        public boolean remove(@Nullable Object object) {
            BiEntry biEntry = HashBiMap.this.seekByKey(object, HashBiMap.hash(object));
            if (biEntry == null) {
                return false;
            }
            HashBiMap.this.delete(biEntry);
            return true;
        }
    }

    public abstract class Itr<T>
    implements Iterator<T> {
        int nextBucket = 0;
        BiEntry<K, V> next = null;
        BiEntry<K, V> toRemove = null;
        int expectedModCount = HashBiMap.access$000(HashBiMap.this);

        Itr() {
        }

        private void checkForConcurrentModification() {
            if (HashBiMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            this.checkForConcurrentModification();
            if (this.next != null) {
                return true;
            }
            while (this.nextBucket < HashBiMap.this.hashTableKToV.length) {
                if (HashBiMap.this.hashTableKToV[this.nextBucket] != null) {
                    this.next = HashBiMap.this.hashTableKToV[this.nextBucket++];
                    return true;
                }
                ++this.nextBucket;
            }
            return false;
        }

        @Override
        public T next() {
            this.checkForConcurrentModification();
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            BiEntry biEntry = this.next;
            this.next = biEntry.nextInKToVBucket;
            this.toRemove = biEntry;
            return this.output(biEntry);
        }

        @Override
        public void remove() {
            this.checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != null);
            HashBiMap.this.delete(this.toRemove);
            this.expectedModCount = HashBiMap.this.modCount;
            this.toRemove = null;
        }

        abstract T output(BiEntry<K, V> var1);
    }

    private static final class BiEntry<K, V>
    extends ImmutableEntry<K, V> {
        final int keyHash;
        final int valueHash;
        @Nullable
        BiEntry<K, V> nextInKToVBucket;
        @Nullable
        BiEntry<K, V> nextInVToKBucket;

        BiEntry(K k, int n, V v, int n2) {
            super(k, v);
            this.keyHash = n;
            this.valueHash = n2;
        }
    }
}

