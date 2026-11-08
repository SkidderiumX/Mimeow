/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ForwardingConcurrentMap;
import com.google.common.collect.GenericMapMaker;
import com.google.common.collect.Iterators;
import com.google.common.collect.MapMaker;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class MapMakerInternalMap<K, V>
extends AbstractMap<K, V>
implements ConcurrentMap<K, V>,
Serializable {
    static final int MAXIMUM_CAPACITY = 0x40000000;
    static final int MAX_SEGMENTS = 65536;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_THRESHOLD = 63;
    static final int DRAIN_MAX = 16;
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
    private static final Logger logger = Logger.getLogger(MapMakerInternalMap.class.getName());
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V>[] segments;
    final int concurrencyLevel;
    final Equivalence<Object> keyEquivalence;
    final Equivalence<Object> valueEquivalence;
    final Strength keyStrength;
    final Strength valueStrength;
    final int maximumSize;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Queue<MapMaker.RemovalNotification<K, V>> removalNotificationQueue;
    final MapMaker.RemovalListener<K, V> removalListener;
    final transient EntryFactory entryFactory;
    final Ticker ticker;
    static final ValueReference<Object, Object> UNSET = new ValueReference<Object, Object>(){

        @Override
        public Object get() {
            return null;
        }

        @Override
        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        @Override
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @Nullable Object object, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        @Override
        public boolean isComputingReference() {
            return false;
        }

        @Override
        public Object waitForValue() {
            return null;
        }

        @Override
        public void clear(ValueReference<Object, Object> valueReference) {
        }
    };
    static final Queue<? extends Object> DISCARDING_QUEUE = new AbstractQueue<Object>(){

        @Override
        public boolean offer(Object object) {
            return true;
        }

        @Override
        public Object peek() {
            return null;
        }

        @Override
        public Object poll() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Iterator<Object> iterator() {
            return Iterators.emptyIterator();
        }
    };
    transient Set<K> keySet;
    transient Collection<V> values;
    transient Set<Map.Entry<K, V>> entrySet;
    private static final long serialVersionUID = 5L;

    MapMakerInternalMap(MapMaker mapMaker) {
        int n;
        int n2;
        this.concurrencyLevel = Math.min(mapMaker.getConcurrencyLevel(), 65536);
        this.keyStrength = mapMaker.getKeyStrength();
        this.valueStrength = mapMaker.getValueStrength();
        this.keyEquivalence = mapMaker.getKeyEquivalence();
        this.valueEquivalence = this.valueStrength.defaultEquivalence();
        this.maximumSize = mapMaker.maximumSize;
        this.expireAfterAccessNanos = mapMaker.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = mapMaker.getExpireAfterWriteNanos();
        this.entryFactory = EntryFactory.getFactory(this.keyStrength, this.expires(), this.evictsBySize());
        this.ticker = mapMaker.getTicker();
        this.removalListener = mapMaker.getRemovalListener();
        this.removalNotificationQueue = this.removalListener == GenericMapMaker.NullListener.INSTANCE ? MapMakerInternalMap.discardingQueue() : new ConcurrentLinkedQueue();
        int n3 = Math.min(mapMaker.getInitialCapacity(), 0x40000000);
        if (this.evictsBySize()) {
            n3 = Math.min(n3, this.maximumSize);
        }
        int n4 = 0;
        for (n2 = 1; !(n2 >= this.concurrencyLevel || this.evictsBySize() && n2 * 2 > this.maximumSize); n2 <<= 1) {
            ++n4;
        }
        this.segmentShift = 32 - n4;
        this.segmentMask = n2 - 1;
        this.segments = this.newSegmentArray(n2);
        int n5 = n3 / n2;
        if (n5 * n2 < n3) {
            ++n5;
        }
        for (n = 1; n < n5; n <<= 1) {
        }
        if (this.evictsBySize()) {
            int n6 = this.maximumSize / n2 + 1;
            int n7 = this.maximumSize % n2;
            for (int i = 0; i < this.segments.length; ++i) {
                if (i == n7) {
                    --n6;
                }
                this.segments[i] = this.createSegment(n, n6);
            }
        } else {
            for (int i = 0; i < this.segments.length; ++i) {
                this.segments[i] = this.createSegment(n, -1);
            }
        }
    }

    boolean evictsBySize() {
        return this.maximumSize != -1;
    }

    boolean expires() {
        return this.expiresAfterWrite() || this.expiresAfterAccess();
    }

    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0L;
    }

    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0L;
    }

    boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    static <K, V> ValueReference<K, V> unset() {
        return UNSET;
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return DISCARDING_QUEUE;
    }

    static int rehash(int n) {
        n += n << 15 ^ 0xFFFFCD7D;
        n ^= n >>> 10;
        n += n << 3;
        n ^= n >>> 6;
        n += (n << 2) + (n << 14);
        return n ^ n >>> 16;
    }

    @GuardedBy(value="Segment.this")
    @VisibleForTesting
    ReferenceEntry<K, V> newEntry(K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
        return this.segmentFor(n).newEntry(k, n, referenceEntry);
    }

    @GuardedBy(value="Segment.this")
    @VisibleForTesting
    ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        int n = referenceEntry.getHash();
        return this.segmentFor(n).copyEntry(referenceEntry, referenceEntry2);
    }

    @GuardedBy(value="Segment.this")
    @VisibleForTesting
    ValueReference<K, V> newValueReference(ReferenceEntry<K, V> referenceEntry, V v) {
        int n = referenceEntry.getHash();
        return this.valueStrength.referenceValue(this.segmentFor(n), referenceEntry, v);
    }

    int hash(Object object) {
        int n = this.keyEquivalence.hash(object);
        return MapMakerInternalMap.rehash(n);
    }

    void reclaimValue(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> referenceEntry = valueReference.getEntry();
        int n = referenceEntry.getHash();
        this.segmentFor(n).reclaimValue(referenceEntry.getKey(), n, valueReference);
    }

    void reclaimKey(ReferenceEntry<K, V> referenceEntry) {
        int n = referenceEntry.getHash();
        this.segmentFor(n).reclaimKey(referenceEntry, n);
    }

    @VisibleForTesting
    boolean isLive(ReferenceEntry<K, V> referenceEntry) {
        return this.segmentFor(referenceEntry.getHash()).getLiveValue(referenceEntry) != null;
    }

    Segment<K, V> segmentFor(int n) {
        return this.segments[n >>> this.segmentShift & this.segmentMask];
    }

    Segment<K, V> createSegment(int n, int n2) {
        return new Segment(this, n, n2);
    }

    V getLiveValue(ReferenceEntry<K, V> referenceEntry) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        if (v == null) {
            return null;
        }
        if (this.expires() && this.isExpired(referenceEntry)) {
            return null;
        }
        return v;
    }

    boolean isExpired(ReferenceEntry<K, V> referenceEntry) {
        return this.isExpired(referenceEntry, this.ticker.read());
    }

    boolean isExpired(ReferenceEntry<K, V> referenceEntry, long l) {
        return l - referenceEntry.getExpirationTime() > 0L;
    }

    @GuardedBy(value="Segment.this")
    static <K, V> void connectExpirables(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextExpirable(referenceEntry2);
        referenceEntry2.setPreviousExpirable(referenceEntry);
    }

    @GuardedBy(value="Segment.this")
    static <K, V> void nullifyExpirable(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> referenceEntry2 = MapMakerInternalMap.nullEntry();
        referenceEntry.setNextExpirable(referenceEntry2);
        referenceEntry.setPreviousExpirable(referenceEntry2);
    }

    void processPendingNotifications() {
        MapMaker.RemovalNotification<K, V> removalNotification;
        while ((removalNotification = this.removalNotificationQueue.poll()) != null) {
            try {
                this.removalListener.onRemoval(removalNotification);
            }
            catch (Exception exception) {
                logger.log(Level.WARNING, "Exception thrown by removal listener", exception);
            }
        }
    }

    @GuardedBy(value="Segment.this")
    static <K, V> void connectEvictables(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextEvictable(referenceEntry2);
        referenceEntry2.setPreviousEvictable(referenceEntry);
    }

    @GuardedBy(value="Segment.this")
    static <K, V> void nullifyEvictable(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> referenceEntry2 = MapMakerInternalMap.nullEntry();
        referenceEntry.setNextEvictable(referenceEntry2);
        referenceEntry.setPreviousEvictable(referenceEntry2);
    }

    final Segment<K, V>[] newSegmentArray(int n) {
        return new Segment[n];
    }

    @Override
    public boolean isEmpty() {
        int n;
        long l = 0L;
        Segment<K, V>[] segmentArray = this.segments;
        for (n = 0; n < segmentArray.length; ++n) {
            if (segmentArray[n].count != 0) {
                return false;
            }
            l += (long)segmentArray[n].modCount;
        }
        if (l != 0L) {
            for (n = 0; n < segmentArray.length; ++n) {
                if (segmentArray[n].count != 0) {
                    return false;
                }
                l -= (long)segmentArray[n].modCount;
            }
            if (l != 0L) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        Segment<K, V>[] segmentArray = this.segments;
        long l = 0L;
        for (int i = 0; i < segmentArray.length; ++i) {
            l += (long)segmentArray[i].count;
        }
        return Ints.saturatedCast(l);
    }

    @Override
    public V get(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n = this.hash(object);
        return this.segmentFor(n).get(object, n);
    }

    ReferenceEntry<K, V> getEntry(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n = this.hash(object);
        return this.segmentFor(n).getEntry(object, n);
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        int n = this.hash(object);
        return this.segmentFor(n).containsKey(object, n);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        Segment<K, V>[] segmentArray = this.segments;
        long l = -1L;
        for (int i = 0; i < 3; ++i) {
            long l2 = 0L;
            for (Segment segment : segmentArray) {
                int n = segment.count;
                AtomicReferenceArray atomicReferenceArray = segment.table;
                for (int j = 0; j < atomicReferenceArray.length(); ++j) {
                    for (ReferenceEntry referenceEntry = atomicReferenceArray.get(j); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                        V v = segment.getLiveValue(referenceEntry);
                        if (v == null || !this.valueEquivalence.equivalent(object, v)) continue;
                        return true;
                    }
                }
                l2 += (long)segment.modCount;
            }
            if (l2 == l) break;
            l = l2;
        }
        return false;
    }

    @Override
    public V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int n = this.hash(k);
        return this.segmentFor(n).put(k, n, v, false);
    }

    @Override
    public V putIfAbsent(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int n = this.hash(k);
        return this.segmentFor(n).put(k, n, v, true);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V remove(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n = this.hash(object);
        return this.segmentFor(n).remove(object, n);
    }

    @Override
    public boolean remove(@Nullable Object object, @Nullable Object object2) {
        if (object == null || object2 == null) {
            return false;
        }
        int n = this.hash(object);
        return this.segmentFor(n).remove(object, n, object2);
    }

    @Override
    public boolean replace(K k, @Nullable V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int n = this.hash(k);
        return this.segmentFor(n).replace(k, n, v, v2);
    }

    @Override
    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int n = this.hash(k);
        return this.segmentFor(n).replace(k, n, v);
    }

    @Override
    public void clear() {
        for (Segment<K, V> segment : this.segments) {
            segment.clear();
        }
    }

    @Override
    public Set<K> keySet() {
        KeySet keySet = this.keySet;
        return keySet != null ? keySet : (this.keySet = new KeySet());
    }

    @Override
    public Collection<V> values() {
        Values values2 = this.values;
        return values2 != null ? values2 : (this.values = new Values());
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySet entrySet = this.entrySet;
        return entrySet != null ? entrySet : (this.entrySet = new EntrySet());
    }

    Object writeReplace() {
        return new SerializationProxy<K, V>(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
    }

    private static final class SerializationProxy<K, V>
    extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3L;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long l, long l2, int n, int n2, MapMaker.RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, l, l2, n, n2, removalListener, concurrentMap);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            this.writeMapTo(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            MapMaker mapMaker = this.readMapMaker(objectInputStream);
            this.delegate = mapMaker.makeMap();
            this.readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }
    }

    public static abstract class AbstractSerializationProxy<K, V>
    extends ForwardingConcurrentMap<K, V>
    implements Serializable {
        private static final long serialVersionUID = 3L;
        final Strength keyStrength;
        final Strength valueStrength;
        final Equivalence<Object> keyEquivalence;
        final Equivalence<Object> valueEquivalence;
        final long expireAfterWriteNanos;
        final long expireAfterAccessNanos;
        final int maximumSize;
        final int concurrencyLevel;
        final MapMaker.RemovalListener<? super K, ? super V> removalListener;
        transient ConcurrentMap<K, V> delegate;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long l, long l2, int n, int n2, MapMaker.RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = l;
            this.expireAfterAccessNanos = l2;
            this.maximumSize = n;
            this.concurrencyLevel = n2;
            this.removalListener = removalListener;
            this.delegate = concurrentMap;
        }

        @Override
        protected ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            int n = objectInputStream.readInt();
            MapMaker mapMaker = ((MapMaker)new MapMaker().initialCapacity(n).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence((Equivalence)this.keyEquivalence)).concurrencyLevel(this.concurrencyLevel);
            mapMaker.removalListener(this.removalListener);
            if (this.expireAfterWriteNanos > 0L) {
                mapMaker.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
            }
            if (this.expireAfterAccessNanos > 0L) {
                mapMaker.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
            }
            if (this.maximumSize != -1) {
                mapMaker.maximumSize(this.maximumSize);
            }
            return mapMaker;
        }

        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Object object;
            while ((object = objectInputStream.readObject()) != null) {
                Object object2 = objectInputStream.readObject();
                this.delegate.put(object, object2);
            }
        }
    }

    public final class EntrySet
    extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            Object k = entry.getKey();
            if (k == null) {
                return false;
            }
            Object v = MapMakerInternalMap.this.get(k);
            return v != null && MapMakerInternalMap.this.valueEquivalence.equivalent(entry.getValue(), v);
        }

        @Override
        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            Object k = entry.getKey();
            return k != null && MapMakerInternalMap.this.remove(k, entry.getValue());
        }

        @Override
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override
        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    public final class Values
    extends AbstractCollection<V> {
        Values() {
        }

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override
        public boolean contains(Object object) {
            return MapMakerInternalMap.this.containsValue(object);
        }

        @Override
        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    public final class KeySet
    extends AbstractSet<K> {
        KeySet() {
        }

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override
        public boolean contains(Object object) {
            return MapMakerInternalMap.this.containsKey(object);
        }

        @Override
        public boolean remove(Object object) {
            return MapMakerInternalMap.this.remove(object) != null;
        }

        @Override
        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    public final class EntryIterator
    extends HashIterator<Map.Entry<K, V>> {
        EntryIterator() {
        }

        @Override
        public Map.Entry<K, V> next() {
            return this.nextEntry();
        }
    }

    public final class WriteThroughEntry
    extends AbstractMapEntry<K, V> {
        final K key;
        V value;

        WriteThroughEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                return this.key.equals(entry.getKey()) && this.value.equals(entry.getValue());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        @Override
        public V setValue(V v) {
            Object v2 = MapMakerInternalMap.this.put(this.key, v);
            this.value = v;
            return v2;
        }
    }

    public final class ValueIterator
    extends HashIterator<V> {
        ValueIterator() {
        }

        @Override
        public V next() {
            return this.nextEntry().getValue();
        }
    }

    public final class KeyIterator
    extends HashIterator<K> {
        KeyIterator() {
        }

        @Override
        public K next() {
            return this.nextEntry().getKey();
        }
    }

    public abstract class HashIterator<E>
    implements Iterator<E> {
        int nextSegmentIndex;
        int nextTableIndex;
        Segment<K, V> currentSegment;
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;
        ReferenceEntry<K, V> nextEntry;
        WriteThroughEntry nextExternal;
        WriteThroughEntry lastReturned;

        HashIterator() {
            this.nextSegmentIndex = MapMakerInternalMap.this.segments.length - 1;
            this.nextTableIndex = -1;
            this.advance();
        }

        @Override
        public abstract E next();

        final void advance() {
            this.nextExternal = null;
            if (this.nextInChain()) {
                return;
            }
            if (this.nextInTable()) {
                return;
            }
            while (this.nextSegmentIndex >= 0) {
                this.currentSegment = MapMakerInternalMap.this.segments[this.nextSegmentIndex--];
                if (this.currentSegment.count == 0) continue;
                this.currentTable = this.currentSegment.table;
                this.nextTableIndex = this.currentTable.length() - 1;
                if (!this.nextInTable()) continue;
                return;
            }
        }

        boolean nextInChain() {
            if (this.nextEntry != null) {
                this.nextEntry = this.nextEntry.getNext();
                while (this.nextEntry != null) {
                    if (this.advanceTo(this.nextEntry)) {
                        return true;
                    }
                    this.nextEntry = this.nextEntry.getNext();
                }
            }
            return false;
        }

        boolean nextInTable() {
            while (this.nextTableIndex >= 0) {
                if ((this.nextEntry = this.currentTable.get(this.nextTableIndex--)) == null || !this.advanceTo(this.nextEntry) && !this.nextInChain()) continue;
                return true;
            }
            return false;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean advanceTo(ReferenceEntry<K, V> referenceEntry) {
            try {
                Object k = referenceEntry.getKey();
                Object v = MapMakerInternalMap.this.getLiveValue(referenceEntry);
                if (v != null) {
                    this.nextExternal = new WriteThroughEntry(k, v);
                    boolean bl = true;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.currentSegment.postReadCleanup();
            }
        }

        @Override
        public boolean hasNext() {
            return this.nextExternal != null;
        }

        WriteThroughEntry nextEntry() {
            if (this.nextExternal == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.nextExternal;
            this.advance();
            return this.lastReturned;
        }

        @Override
        public void remove() {
            CollectPreconditions.checkRemove(this.lastReturned != null);
            MapMakerInternalMap.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    public static final class CleanupMapTask
    implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?> mapMakerInternalMap) {
            this.mapReference = new WeakReference(mapMakerInternalMap);
        }

        @Override
        public void run() {
            MapMakerInternalMap mapMakerInternalMap = (MapMakerInternalMap)this.mapReference.get();
            if (mapMakerInternalMap == null) {
                throw new CancellationException();
            }
            for (Segment segment : mapMakerInternalMap.segments) {
                segment.runCleanup();
            }
        }
    }

    public static final class ExpirationQueue<K, V>
    extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>(){
            ReferenceEntry<K, V> nextExpirable = this;
            ReferenceEntry<K, V> previousExpirable = this;

            @Override
            public long getExpirationTime() {
                return Long.MAX_VALUE;
            }

            @Override
            public void setExpirationTime(long l) {
            }

            @Override
            public ReferenceEntry<K, V> getNextExpirable() {
                return this.nextExpirable;
            }

            @Override
            public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
                this.nextExpirable = referenceEntry;
            }

            @Override
            public ReferenceEntry<K, V> getPreviousExpirable() {
                return this.previousExpirable;
            }

            @Override
            public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
                this.previousExpirable = referenceEntry;
            }
        };

        ExpirationQueue() {
        }

        @Override
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            MapMakerInternalMap.connectExpirables(referenceEntry.getPreviousExpirable(), referenceEntry.getNextExpirable());
            MapMakerInternalMap.connectExpirables(this.head.getPreviousExpirable(), referenceEntry);
            MapMakerInternalMap.connectExpirables(referenceEntry, this.head);
            return true;
        }

        @Override
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> referenceEntry = this.head.getNextExpirable();
            return referenceEntry == this.head ? null : referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> referenceEntry = this.head.getNextExpirable();
            if (referenceEntry == this.head) {
                return null;
            }
            this.remove(referenceEntry);
            return referenceEntry;
        }

        @Override
        public boolean remove(Object object) {
            ReferenceEntry referenceEntry = (ReferenceEntry)object;
            ReferenceEntry referenceEntry2 = referenceEntry.getPreviousExpirable();
            ReferenceEntry referenceEntry3 = referenceEntry.getNextExpirable();
            MapMakerInternalMap.connectExpirables(referenceEntry2, referenceEntry3);
            MapMakerInternalMap.nullifyExpirable(referenceEntry);
            return referenceEntry3 != NullEntry.INSTANCE;
        }

        @Override
        public boolean contains(Object object) {
            ReferenceEntry referenceEntry = (ReferenceEntry)object;
            return referenceEntry.getNextExpirable() != NullEntry.INSTANCE;
        }

        @Override
        public boolean isEmpty() {
            return this.head.getNextExpirable() == this.head;
        }

        @Override
        public int size() {
            int n = 0;
            for (ReferenceEntry<K, V> referenceEntry = this.head.getNextExpirable(); referenceEntry != this.head; referenceEntry = referenceEntry.getNextExpirable()) {
                ++n;
            }
            return n;
        }

        @Override
        public void clear() {
            ReferenceEntry<K, V> referenceEntry = this.head.getNextExpirable();
            while (referenceEntry != this.head) {
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry.getNextExpirable();
                MapMakerInternalMap.nullifyExpirable(referenceEntry);
                referenceEntry = referenceEntry2;
            }
            this.head.setNextExpirable(this.head);
            this.head.setPreviousExpirable(this.head);
        }

        @Override
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>((ReferenceEntry)this.peek()){

                @Override
                protected ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry referenceEntry2 = referenceEntry.getNextExpirable();
                    return referenceEntry2 == ExpirationQueue.this.head ? null : referenceEntry2;
                }
            };
        }
    }

    public static final class EvictionQueue<K, V>
    extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>(){
            ReferenceEntry<K, V> nextEvictable = this;
            ReferenceEntry<K, V> previousEvictable = this;

            @Override
            public ReferenceEntry<K, V> getNextEvictable() {
                return this.nextEvictable;
            }

            @Override
            public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
                this.nextEvictable = referenceEntry;
            }

            @Override
            public ReferenceEntry<K, V> getPreviousEvictable() {
                return this.previousEvictable;
            }

            @Override
            public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
                this.previousEvictable = referenceEntry;
            }
        };

        EvictionQueue() {
        }

        @Override
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            MapMakerInternalMap.connectEvictables(referenceEntry.getPreviousEvictable(), referenceEntry.getNextEvictable());
            MapMakerInternalMap.connectEvictables(this.head.getPreviousEvictable(), referenceEntry);
            MapMakerInternalMap.connectEvictables(referenceEntry, this.head);
            return true;
        }

        @Override
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> referenceEntry = this.head.getNextEvictable();
            return referenceEntry == this.head ? null : referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> referenceEntry = this.head.getNextEvictable();
            if (referenceEntry == this.head) {
                return null;
            }
            this.remove(referenceEntry);
            return referenceEntry;
        }

        @Override
        public boolean remove(Object object) {
            ReferenceEntry referenceEntry = (ReferenceEntry)object;
            ReferenceEntry referenceEntry2 = referenceEntry.getPreviousEvictable();
            ReferenceEntry referenceEntry3 = referenceEntry.getNextEvictable();
            MapMakerInternalMap.connectEvictables(referenceEntry2, referenceEntry3);
            MapMakerInternalMap.nullifyEvictable(referenceEntry);
            return referenceEntry3 != NullEntry.INSTANCE;
        }

        @Override
        public boolean contains(Object object) {
            ReferenceEntry referenceEntry = (ReferenceEntry)object;
            return referenceEntry.getNextEvictable() != NullEntry.INSTANCE;
        }

        @Override
        public boolean isEmpty() {
            return this.head.getNextEvictable() == this.head;
        }

        @Override
        public int size() {
            int n = 0;
            for (ReferenceEntry<K, V> referenceEntry = this.head.getNextEvictable(); referenceEntry != this.head; referenceEntry = referenceEntry.getNextEvictable()) {
                ++n;
            }
            return n;
        }

        @Override
        public void clear() {
            ReferenceEntry<K, V> referenceEntry = this.head.getNextEvictable();
            while (referenceEntry != this.head) {
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry.getNextEvictable();
                MapMakerInternalMap.nullifyEvictable(referenceEntry);
                referenceEntry = referenceEntry2;
            }
            this.head.setNextEvictable(this.head);
            this.head.setPreviousEvictable(this.head);
        }

        @Override
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>((ReferenceEntry)this.peek()){

                @Override
                protected ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry referenceEntry2 = referenceEntry.getNextEvictable();
                    return referenceEntry2 == EvictionQueue.this.head ? null : referenceEntry2;
                }
            };
        }
    }

    public static class Segment<K, V>
    extends ReentrantLock {
        final MapMakerInternalMap<K, V> map;
        volatile int count;
        int modCount;
        int threshold;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        final int maxSegmentSize;
        final ReferenceQueue<K> keyReferenceQueue;
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AtomicInteger readCount = new AtomicInteger();
        @GuardedBy(value="Segment.this")
        final Queue<ReferenceEntry<K, V>> evictionQueue;
        @GuardedBy(value="Segment.this")
        final Queue<ReferenceEntry<K, V>> expirationQueue;

        Segment(MapMakerInternalMap<K, V> mapMakerInternalMap, int n, int n2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = n2;
            this.initTable(this.newEntryArray(n));
            this.keyReferenceQueue = mapMakerInternalMap.usesKeyReferences() ? new ReferenceQueue() : null;
            this.valueReferenceQueue = mapMakerInternalMap.usesValueReferences() ? new ReferenceQueue() : null;
            this.recencyQueue = mapMakerInternalMap.evictsBySize() || mapMakerInternalMap.expiresAfterAccess() ? new ConcurrentLinkedQueue() : MapMakerInternalMap.discardingQueue();
            this.evictionQueue = mapMakerInternalMap.evictsBySize() ? new EvictionQueue() : MapMakerInternalMap.discardingQueue();
            this.expirationQueue = mapMakerInternalMap.expires() ? new ExpirationQueue() : MapMakerInternalMap.discardingQueue();
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int n) {
            return new AtomicReferenceArray<ReferenceEntry<K, V>>(n);
        }

        void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = atomicReferenceArray.length() * 3 / 4;
            if (this.threshold == this.maxSegmentSize) {
                ++this.threshold;
            }
            this.table = atomicReferenceArray;
        }

        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> newEntry(K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return this.map.entryFactory.newEntry(this, k, n, referenceEntry);
        }

        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && !valueReference.isComputingReference()) {
                return null;
            }
            ReferenceEntry<K, V> referenceEntry3 = this.map.entryFactory.copyEntry(this, referenceEntry, referenceEntry2);
            referenceEntry3.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v, referenceEntry3));
            return referenceEntry3;
        }

        @GuardedBy(value="Segment.this")
        void setValue(ReferenceEntry<K, V> referenceEntry, V v) {
            ValueReference<K, V> valueReference = this.map.valueStrength.referenceValue(this, referenceEntry, v);
            referenceEntry.setValueReference(valueReference);
            this.recordWrite(referenceEntry);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void tryDrainReferenceQueues() {
            if (this.tryLock()) {
                try {
                    this.drainReferenceQueues();
                }
                finally {
                    this.unlock();
                }
            }
        }

        @GuardedBy(value="Segment.this")
        void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                this.drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                this.drainValueReferenceQueue();
            }
        }

        @GuardedBy(value="Segment.this")
        void drainKeyReferenceQueue() {
            Reference<K> reference;
            int n = 0;
            while ((reference = this.keyReferenceQueue.poll()) != null) {
                ReferenceEntry referenceEntry = (ReferenceEntry)((Object)reference);
                this.map.reclaimKey(referenceEntry);
                if (++n != 16) continue;
                break;
            }
        }

        @GuardedBy(value="Segment.this")
        void drainValueReferenceQueue() {
            Reference<V> reference;
            int n = 0;
            while ((reference = this.valueReferenceQueue.poll()) != null) {
                ValueReference valueReference = (ValueReference)((Object)reference);
                this.map.reclaimValue(valueReference);
                if (++n != 16) continue;
                break;
            }
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                this.clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                this.clearValueReferenceQueue();
            }
        }

        void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        void recordRead(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.expiresAfterAccess()) {
                this.recordExpirationTime(referenceEntry, this.map.expireAfterAccessNanos);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @GuardedBy(value="Segment.this")
        void recordLockedRead(ReferenceEntry<K, V> referenceEntry) {
            this.evictionQueue.add(referenceEntry);
            if (this.map.expiresAfterAccess()) {
                this.recordExpirationTime(referenceEntry, this.map.expireAfterAccessNanos);
                this.expirationQueue.add(referenceEntry);
            }
        }

        @GuardedBy(value="Segment.this")
        void recordWrite(ReferenceEntry<K, V> referenceEntry) {
            this.drainRecencyQueue();
            this.evictionQueue.add(referenceEntry);
            if (this.map.expires()) {
                long l = this.map.expiresAfterAccess() ? this.map.expireAfterAccessNanos : this.map.expireAfterWriteNanos;
                this.recordExpirationTime(referenceEntry, l);
                this.expirationQueue.add(referenceEntry);
            }
        }

        @GuardedBy(value="Segment.this")
        void drainRecencyQueue() {
            ReferenceEntry<K, V> referenceEntry;
            while ((referenceEntry = this.recencyQueue.poll()) != null) {
                if (this.evictionQueue.contains(referenceEntry)) {
                    this.evictionQueue.add(referenceEntry);
                }
                if (!this.map.expiresAfterAccess() || !this.expirationQueue.contains(referenceEntry)) continue;
                this.expirationQueue.add(referenceEntry);
            }
        }

        void recordExpirationTime(ReferenceEntry<K, V> referenceEntry, long l) {
            referenceEntry.setExpirationTime(this.map.ticker.read() + l);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void tryExpireEntries() {
            if (this.tryLock()) {
                try {
                    this.expireEntries();
                }
                finally {
                    this.unlock();
                }
            }
        }

        @GuardedBy(value="Segment.this")
        void expireEntries() {
            ReferenceEntry<K, V> referenceEntry;
            this.drainRecencyQueue();
            if (this.expirationQueue.isEmpty()) {
                return;
            }
            long l = this.map.ticker.read();
            while ((referenceEntry = this.expirationQueue.peek()) != null && this.map.isExpired(referenceEntry, l)) {
                if (!this.removeEntry(referenceEntry, referenceEntry.getHash(), MapMaker.RemovalCause.EXPIRED)) {
                    throw new AssertionError();
                }
            }
        }

        void enqueueNotification(ReferenceEntry<K, V> referenceEntry, MapMaker.RemovalCause removalCause) {
            this.enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), removalCause);
        }

        void enqueueNotification(@Nullable K k, int n, @Nullable V v, MapMaker.RemovalCause removalCause) {
            if (this.map.removalNotificationQueue != DISCARDING_QUEUE) {
                MapMaker.RemovalNotification<K, V> removalNotification = new MapMaker.RemovalNotification<K, V>(k, v, removalCause);
                this.map.removalNotificationQueue.offer(removalNotification);
            }
        }

        @GuardedBy(value="Segment.this")
        boolean evictEntries() {
            if (this.map.evictsBySize() && this.count >= this.maxSegmentSize) {
                this.drainRecencyQueue();
                ReferenceEntry<K, V> referenceEntry = this.evictionQueue.remove();
                if (!this.removeEntry(referenceEntry, referenceEntry.getHash(), MapMaker.RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                return true;
            }
            return false;
        }

        ReferenceEntry<K, V> getFirst(int n) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(n & atomicReferenceArray.length() - 1);
        }

        ReferenceEntry<K, V> getEntry(Object object, int n) {
            if (this.count != 0) {
                for (ReferenceEntry<K, V> referenceEntry = this.getFirst(n); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                    if (referenceEntry.getHash() != n) continue;
                    K k = referenceEntry.getKey();
                    if (k == null) {
                        this.tryDrainReferenceQueues();
                        continue;
                    }
                    if (!this.map.keyEquivalence.equivalent(object, k)) continue;
                    return referenceEntry;
                }
            }
            return null;
        }

        ReferenceEntry<K, V> getLiveEntry(Object object, int n) {
            ReferenceEntry<K, V> referenceEntry = this.getEntry(object, n);
            if (referenceEntry == null) {
                return null;
            }
            if (this.map.expires() && this.map.isExpired(referenceEntry)) {
                this.tryExpireEntries();
                return null;
            }
            return referenceEntry;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        V get(Object object, int n) {
            try {
                ReferenceEntry<K, V> referenceEntry = this.getLiveEntry(object, n);
                if (referenceEntry == null) {
                    V v = null;
                    return v;
                }
                V v = referenceEntry.getValueReference().get();
                if (v != null) {
                    this.recordRead(referenceEntry);
                } else {
                    this.tryDrainReferenceQueues();
                }
                V v2 = v;
                return v2;
            }
            finally {
                this.postReadCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean containsKey(Object object, int n) {
            try {
                if (this.count != 0) {
                    ReferenceEntry<K, V> referenceEntry = this.getLiveEntry(object, n);
                    if (referenceEntry == null) {
                        boolean bl = false;
                        return bl;
                    }
                    boolean bl = referenceEntry.getValueReference().get() != null;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.postReadCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @VisibleForTesting
        boolean containsValue(Object object) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int n = atomicReferenceArray.length();
                    for (int i = 0; i < n; ++i) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            V v = this.getLiveValue(referenceEntry);
                            if (v == null || !this.map.valueEquivalence.equivalent(object, v)) continue;
                            boolean bl = true;
                            return bl;
                        }
                    }
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.postReadCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        V put(K k, int n, V v, boolean bl) {
            this.lock();
            try {
                K k2;
                ReferenceEntry<K, V> referenceEntry;
                ReferenceEntry<K, V> referenceEntry2;
                this.preWriteCleanup();
                int n2 = this.count + 1;
                if (n2 > this.threshold) {
                    this.expand();
                    n2 = this.count + 1;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n3 = n & atomicReferenceArray.length() - 1;
                for (referenceEntry2 = referenceEntry = atomicReferenceArray.get(n3); referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    k2 = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != n || k2 == null || !this.map.keyEquivalence.equivalent(k, k2)) continue;
                    ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                    V v2 = valueReference.get();
                    if (v2 == null) {
                        ++this.modCount;
                        this.setValue(referenceEntry2, v);
                        if (!valueReference.isComputingReference()) {
                            this.enqueueNotification(k, n, v2, MapMaker.RemovalCause.COLLECTED);
                            n2 = this.count;
                        } else if (this.evictEntries()) {
                            n2 = this.count + 1;
                        }
                        this.count = n2;
                        V v3 = null;
                        return v3;
                    }
                    if (bl) {
                        this.recordLockedRead(referenceEntry2);
                        V v4 = v2;
                        return v4;
                    }
                    ++this.modCount;
                    this.enqueueNotification(k, n, v2, MapMaker.RemovalCause.REPLACED);
                    this.setValue(referenceEntry2, v);
                    V v5 = v2;
                    return v5;
                }
                ++this.modCount;
                referenceEntry2 = this.newEntry(k, n, referenceEntry);
                this.setValue(referenceEntry2, v);
                atomicReferenceArray.set(n3, referenceEntry2);
                if (this.evictEntries()) {
                    n2 = this.count + 1;
                }
                this.count = n2;
                k2 = null;
                return (V)k2;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }

        @GuardedBy(value="Segment.this")
        void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int n = atomicReferenceArray.length();
            if (n >= 0x40000000) {
                return;
            }
            int n2 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray2 = this.newEntryArray(n << 1);
            this.threshold = atomicReferenceArray2.length() * 3 / 4;
            int n3 = atomicReferenceArray2.length() - 1;
            for (int i = 0; i < n; ++i) {
                int n4;
                ReferenceEntry<K, V> referenceEntry;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(i);
                if (referenceEntry2 == null) continue;
                ReferenceEntry<K, V> referenceEntry3 = referenceEntry2.getNext();
                int n5 = referenceEntry2.getHash() & n3;
                if (referenceEntry3 == null) {
                    atomicReferenceArray2.set(n5, referenceEntry2);
                    continue;
                }
                ReferenceEntry<K, V> referenceEntry4 = referenceEntry2;
                int n6 = n5;
                for (referenceEntry = referenceEntry3; referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                    n4 = referenceEntry.getHash() & n3;
                    if (n4 == n6) continue;
                    n6 = n4;
                    referenceEntry4 = referenceEntry;
                }
                atomicReferenceArray2.set(n6, referenceEntry4);
                for (referenceEntry = referenceEntry2; referenceEntry != referenceEntry4; referenceEntry = referenceEntry.getNext()) {
                    n4 = referenceEntry.getHash() & n3;
                    ReferenceEntry<K, V> referenceEntry5 = atomicReferenceArray2.get(n4);
                    ReferenceEntry<K, V> referenceEntry6 = this.copyEntry(referenceEntry, referenceEntry5);
                    if (referenceEntry6 != null) {
                        atomicReferenceArray2.set(n4, referenceEntry6);
                        continue;
                    }
                    this.removeCollectedEntry(referenceEntry);
                    --n2;
                }
            }
            this.table = atomicReferenceArray2;
            this.count = n2;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean replace(K k, int n, V v, V v2) {
            this.lock();
            try {
                ReferenceEntry<K, V> referenceEntry;
                this.preWriteCleanup();
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n2 = n & atomicReferenceArray.length() - 1;
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry = atomicReferenceArray.get(n2); referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K k2 = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != n || k2 == null || !this.map.keyEquivalence.equivalent(k, k2)) continue;
                    ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                    V v3 = valueReference.get();
                    if (v3 == null) {
                        int n3;
                        if (this.isCollected(valueReference)) {
                            n3 = this.count - 1;
                            ++this.modCount;
                            this.enqueueNotification(k2, n, v3, MapMaker.RemovalCause.COLLECTED);
                            ReferenceEntry<K, V> referenceEntry3 = this.removeFromChain(referenceEntry, referenceEntry2);
                            n3 = this.count - 1;
                            atomicReferenceArray.set(n2, referenceEntry3);
                            this.count = n3;
                        }
                        n3 = 0;
                        return n3 != 0;
                    }
                    if (this.map.valueEquivalence.equivalent(v, v3)) {
                        ++this.modCount;
                        this.enqueueNotification(k, n, v3, MapMaker.RemovalCause.REPLACED);
                        this.setValue(referenceEntry2, v2);
                        boolean bl = true;
                        return bl;
                    }
                    this.recordLockedRead(referenceEntry2);
                    boolean bl = false;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        V replace(K k, int n, V v) {
            this.lock();
            try {
                ReferenceEntry<K, V> referenceEntry;
                ReferenceEntry<K, V> referenceEntry2;
                this.preWriteCleanup();
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n2 = n & atomicReferenceArray.length() - 1;
                for (referenceEntry2 = referenceEntry = atomicReferenceArray.get(n2); referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K k2 = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != n || k2 == null || !this.map.keyEquivalence.equivalent(k, k2)) continue;
                    ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                    V v2 = valueReference.get();
                    if (v2 == null) {
                        if (this.isCollected(valueReference)) {
                            int n3 = this.count - 1;
                            ++this.modCount;
                            this.enqueueNotification(k2, n, v2, MapMaker.RemovalCause.COLLECTED);
                            ReferenceEntry<K, V> referenceEntry3 = this.removeFromChain(referenceEntry, referenceEntry2);
                            n3 = this.count - 1;
                            atomicReferenceArray.set(n2, referenceEntry3);
                            this.count = n3;
                        }
                        V v3 = null;
                        return v3;
                    }
                    ++this.modCount;
                    this.enqueueNotification(k, n, v2, MapMaker.RemovalCause.REPLACED);
                    this.setValue(referenceEntry2, v);
                    V v4 = v2;
                    return v4;
                }
                referenceEntry2 = null;
                return (V)referenceEntry2;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        V remove(Object object, int n) {
            this.lock();
            try {
                ReferenceEntry<K, V> referenceEntry;
                ReferenceEntry<K, V> referenceEntry2;
                this.preWriteCleanup();
                int n2 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n3 = n & atomicReferenceArray.length() - 1;
                for (referenceEntry2 = referenceEntry = atomicReferenceArray.get(n3); referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    MapMaker.RemovalCause removalCause;
                    K k = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != n || k == null || !this.map.keyEquivalence.equivalent(object, k)) continue;
                    ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                    V v = valueReference.get();
                    if (v != null) {
                        removalCause = MapMaker.RemovalCause.EXPLICIT;
                    } else if (this.isCollected(valueReference)) {
                        removalCause = MapMaker.RemovalCause.COLLECTED;
                    } else {
                        V v2 = null;
                        return v2;
                    }
                    ++this.modCount;
                    this.enqueueNotification(k, n, v, removalCause);
                    ReferenceEntry<K, V> referenceEntry3 = this.removeFromChain(referenceEntry, referenceEntry2);
                    n2 = this.count - 1;
                    atomicReferenceArray.set(n3, referenceEntry3);
                    this.count = n2;
                    V v3 = v;
                    return v3;
                }
                referenceEntry2 = null;
                return (V)referenceEntry2;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean remove(Object object, int n, Object object2) {
            this.lock();
            try {
                ReferenceEntry<K, V> referenceEntry;
                this.preWriteCleanup();
                int n2 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n3 = n & atomicReferenceArray.length() - 1;
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry = atomicReferenceArray.get(n3); referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    MapMaker.RemovalCause removalCause;
                    K k = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != n || k == null || !this.map.keyEquivalence.equivalent(object, k)) continue;
                    ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                    V v = valueReference.get();
                    if (this.map.valueEquivalence.equivalent(object2, v)) {
                        removalCause = MapMaker.RemovalCause.EXPLICIT;
                    } else if (this.isCollected(valueReference)) {
                        removalCause = MapMaker.RemovalCause.COLLECTED;
                    } else {
                        boolean bl = false;
                        return bl;
                    }
                    ++this.modCount;
                    this.enqueueNotification(k, n, v, removalCause);
                    ReferenceEntry<K, V> referenceEntry3 = this.removeFromChain(referenceEntry, referenceEntry2);
                    n2 = this.count - 1;
                    atomicReferenceArray.set(n3, referenceEntry3);
                    this.count = n2;
                    boolean bl = removalCause == MapMaker.RemovalCause.EXPLICIT;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void clear() {
            if (this.count != 0) {
                this.lock();
                try {
                    int n;
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    if (this.map.removalNotificationQueue != DISCARDING_QUEUE) {
                        for (n = 0; n < atomicReferenceArray.length(); ++n) {
                            for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(n); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                                if (referenceEntry.getValueReference().isComputingReference()) continue;
                                this.enqueueNotification(referenceEntry, MapMaker.RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (n = 0; n < atomicReferenceArray.length(); ++n) {
                        atomicReferenceArray.set(n, null);
                    }
                    this.clearReferenceQueues();
                    this.evictionQueue.clear();
                    this.expirationQueue.clear();
                    this.readCount.set(0);
                    ++this.modCount;
                    this.count = 0;
                }
                finally {
                    this.unlock();
                    this.postWriteCleanup();
                }
            }
        }

        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> removeFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            this.evictionQueue.remove(referenceEntry2);
            this.expirationQueue.remove(referenceEntry2);
            int n = this.count;
            ReferenceEntry<K, V> referenceEntry3 = referenceEntry2.getNext();
            for (ReferenceEntry<K, V> referenceEntry4 = referenceEntry; referenceEntry4 != referenceEntry2; referenceEntry4 = referenceEntry4.getNext()) {
                ReferenceEntry<K, V> referenceEntry5 = this.copyEntry(referenceEntry4, referenceEntry3);
                if (referenceEntry5 != null) {
                    referenceEntry3 = referenceEntry5;
                    continue;
                }
                this.removeCollectedEntry(referenceEntry4);
                --n;
            }
            this.count = n;
            return referenceEntry3;
        }

        void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            this.enqueueNotification(referenceEntry, MapMaker.RemovalCause.COLLECTED);
            this.evictionQueue.remove(referenceEntry);
            this.expirationQueue.remove(referenceEntry);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int n) {
            this.lock();
            try {
                ReferenceEntry<K, V> referenceEntry2;
                int n2 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n3 = n & atomicReferenceArray.length() - 1;
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2 = atomicReferenceArray.get(n3); referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 != referenceEntry) continue;
                    ++this.modCount;
                    this.enqueueNotification(referenceEntry3.getKey(), n, referenceEntry3.getValueReference().get(), MapMaker.RemovalCause.COLLECTED);
                    ReferenceEntry<K, V> referenceEntry4 = this.removeFromChain(referenceEntry2, referenceEntry3);
                    n2 = this.count - 1;
                    atomicReferenceArray.set(n3, referenceEntry4);
                    this.count = n2;
                    boolean bl = true;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean reclaimValue(K k, int n, ValueReference<K, V> valueReference) {
            this.lock();
            try {
                ReferenceEntry<K, V> referenceEntry;
                int n2 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n3 = n & atomicReferenceArray.length() - 1;
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry = atomicReferenceArray.get(n3); referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K k2 = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != n || k2 == null || !this.map.keyEquivalence.equivalent(k, k2)) continue;
                    ValueReference<K, V> valueReference2 = referenceEntry2.getValueReference();
                    if (valueReference2 == valueReference) {
                        ++this.modCount;
                        this.enqueueNotification(k, n, valueReference.get(), MapMaker.RemovalCause.COLLECTED);
                        ReferenceEntry<K, V> referenceEntry3 = this.removeFromChain(referenceEntry, referenceEntry2);
                        n2 = this.count - 1;
                        atomicReferenceArray.set(n3, referenceEntry3);
                        this.count = n2;
                        boolean bl = true;
                        return bl;
                    }
                    boolean bl = false;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.unlock();
                if (!this.isHeldByCurrentThread()) {
                    this.postWriteCleanup();
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean clearValue(K k, int n, ValueReference<K, V> valueReference) {
            this.lock();
            try {
                ReferenceEntry<K, V> referenceEntry;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int n2 = n & atomicReferenceArray.length() - 1;
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry = atomicReferenceArray.get(n2); referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K k2 = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != n || k2 == null || !this.map.keyEquivalence.equivalent(k, k2)) continue;
                    ValueReference<K, V> valueReference2 = referenceEntry2.getValueReference();
                    if (valueReference2 == valueReference) {
                        ReferenceEntry<K, V> referenceEntry3 = this.removeFromChain(referenceEntry, referenceEntry2);
                        atomicReferenceArray.set(n2, referenceEntry3);
                        boolean bl = true;
                        return bl;
                    }
                    boolean bl = false;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }

        @GuardedBy(value="Segment.this")
        boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int n, MapMaker.RemovalCause removalCause) {
            ReferenceEntry<K, V> referenceEntry2;
            int n2 = this.count - 1;
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int n3 = n & atomicReferenceArray.length() - 1;
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2 = atomicReferenceArray.get(n3); referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 != referenceEntry) continue;
                ++this.modCount;
                this.enqueueNotification(referenceEntry3.getKey(), n, referenceEntry3.getValueReference().get(), removalCause);
                ReferenceEntry<K, V> referenceEntry4 = this.removeFromChain(referenceEntry2, referenceEntry3);
                n2 = this.count - 1;
                atomicReferenceArray.set(n3, referenceEntry4);
                this.count = n2;
                return true;
            }
            return false;
        }

        boolean isCollected(ValueReference<K, V> valueReference) {
            if (valueReference.isComputingReference()) {
                return false;
            }
            return valueReference.get() == null;
        }

        V getLiveValue(ReferenceEntry<K, V> referenceEntry) {
            if (referenceEntry.getKey() == null) {
                this.tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                this.tryDrainReferenceQueues();
                return null;
            }
            if (this.map.expires() && this.map.isExpired(referenceEntry)) {
                this.tryExpireEntries();
                return null;
            }
            return v;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 0x3F) == 0) {
                this.runCleanup();
            }
        }

        @GuardedBy(value="Segment.this")
        void preWriteCleanup() {
            this.runLockedCleanup();
        }

        void postWriteCleanup() {
            this.runUnlockedCleanup();
        }

        void runCleanup() {
            this.runLockedCleanup();
            this.runUnlockedCleanup();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void runLockedCleanup() {
            if (this.tryLock()) {
                try {
                    this.drainReferenceQueues();
                    this.expireEntries();
                    this.readCount.set(0);
                }
                finally {
                    this.unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (!this.isHeldByCurrentThread()) {
                this.map.processPendingNotifications();
            }
        }
    }

    public static final class StrongValueReference<K, V>
    implements ValueReference<K, V> {
        final V referent;

        StrongValueReference(V v) {
            this.referent = v;
        }

        @Override
        public V get() {
            return this.referent;
        }

        @Override
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override
        public boolean isComputingReference() {
            return false;
        }

        @Override
        public V waitForValue() {
            return this.get();
        }

        @Override
        public void clear(ValueReference<K, V> valueReference) {
        }
    }

    public static final class SoftValueReference<K, V>
    extends SoftReference<V>
    implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override
        public void clear(ValueReference<K, V> valueReference) {
            this.clear();
        }

        @Override
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference<K, V>(referenceQueue, v, referenceEntry);
        }

        @Override
        public boolean isComputingReference() {
            return false;
        }

        @Override
        public V waitForValue() {
            return (V)this.get();
        }
    }

    public static final class WeakValueReference<K, V>
    extends WeakReference<V>
    implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override
        public void clear(ValueReference<K, V> valueReference) {
            this.clear();
        }

        @Override
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference<K, V>(referenceQueue, v, referenceEntry);
        }

        @Override
        public boolean isComputingReference() {
            return false;
        }

        @Override
        public V waitForValue() {
            return (V)this.get();
        }
    }

    public static final class WeakExpirableEvictableEntry<K, V>
    extends WeakEntry<K, V>
    implements ReferenceEntry<K, V> {
        volatile long time = Long.MAX_VALUE;
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        WeakExpirableEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, n, referenceEntry);
        }

        @Override
        public long getExpirationTime() {
            return this.time;
        }

        @Override
        public void setExpirationTime(long l) {
            this.time = l;
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    public static final class WeakEvictableEntry<K, V>
    extends WeakEntry<K, V>
    implements ReferenceEntry<K, V> {
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        WeakEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, n, referenceEntry);
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    public static final class WeakExpirableEntry<K, V>
    extends WeakEntry<K, V>
    implements ReferenceEntry<K, V> {
        volatile long time = Long.MAX_VALUE;
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();

        WeakExpirableEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, n, referenceEntry);
        }

        @Override
        public long getExpirationTime() {
            return this.time;
        }

        @Override
        public void setExpirationTime(long l) {
            this.time = l;
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }
    }

    public static class WeakEntry<K, V>
    extends WeakReference<K>
    implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = MapMakerInternalMap.unset();

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.hash = n;
            this.next = referenceEntry;
        }

        @Override
        public K getKey() {
            return (K)this.get();
        }

        @Override
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setExpirationTime(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override
        public void setValueReference(ValueReference<K, V> valueReference) {
            ValueReference<K, V> valueReference2 = this.valueReference;
            this.valueReference = valueReference;
            valueReference2.clear(valueReference);
        }

        @Override
        public int getHash() {
            return this.hash;
        }

        @Override
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    public static final class SoftExpirableEvictableEntry<K, V>
    extends SoftEntry<K, V>
    implements ReferenceEntry<K, V> {
        volatile long time = Long.MAX_VALUE;
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        SoftExpirableEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, n, referenceEntry);
        }

        @Override
        public long getExpirationTime() {
            return this.time;
        }

        @Override
        public void setExpirationTime(long l) {
            this.time = l;
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    public static final class SoftEvictableEntry<K, V>
    extends SoftEntry<K, V>
    implements ReferenceEntry<K, V> {
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        SoftEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, n, referenceEntry);
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    public static final class SoftExpirableEntry<K, V>
    extends SoftEntry<K, V>
    implements ReferenceEntry<K, V> {
        volatile long time = Long.MAX_VALUE;
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();

        SoftExpirableEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, n, referenceEntry);
        }

        @Override
        public long getExpirationTime() {
            return this.time;
        }

        @Override
        public void setExpirationTime(long l) {
            this.time = l;
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }
    }

    public static class SoftEntry<K, V>
    extends SoftReference<K>
    implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = MapMakerInternalMap.unset();

        SoftEntry(ReferenceQueue<K> referenceQueue, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.hash = n;
            this.next = referenceEntry;
        }

        @Override
        public K getKey() {
            return (K)this.get();
        }

        @Override
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setExpirationTime(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override
        public void setValueReference(ValueReference<K, V> valueReference) {
            ValueReference<K, V> valueReference2 = this.valueReference;
            this.valueReference = valueReference;
            valueReference2.clear(valueReference);
        }

        @Override
        public int getHash() {
            return this.hash;
        }

        @Override
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    public static final class StrongExpirableEvictableEntry<K, V>
    extends StrongEntry<K, V>
    implements ReferenceEntry<K, V> {
        volatile long time = Long.MAX_VALUE;
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        StrongExpirableEvictableEntry(K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(k, n, referenceEntry);
        }

        @Override
        public long getExpirationTime() {
            return this.time;
        }

        @Override
        public void setExpirationTime(long l) {
            this.time = l;
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    public static final class StrongEvictableEntry<K, V>
    extends StrongEntry<K, V>
    implements ReferenceEntry<K, V> {
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        StrongEvictableEntry(K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(k, n, referenceEntry);
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    public static final class StrongExpirableEntry<K, V>
    extends StrongEntry<K, V>
    implements ReferenceEntry<K, V> {
        volatile long time = Long.MAX_VALUE;
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        @GuardedBy(value="Segment.this")
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();

        StrongExpirableEntry(K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(k, n, referenceEntry);
        }

        @Override
        public long getExpirationTime() {
            return this.time;
        }

        @Override
        public void setExpirationTime(long l) {
            this.time = l;
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }
    }

    public static class StrongEntry<K, V>
    implements ReferenceEntry<K, V> {
        final K key;
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = MapMakerInternalMap.unset();

        StrongEntry(K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
            this.key = k;
            this.hash = n;
            this.next = referenceEntry;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setExpirationTime(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override
        public void setValueReference(ValueReference<K, V> valueReference) {
            ValueReference<K, V> valueReference2 = this.valueReference;
            this.valueReference = valueReference;
            valueReference2.clear(valueReference);
        }

        @Override
        public int getHash() {
            return this.hash;
        }

        @Override
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    public static abstract class AbstractReferenceEntry<K, V>
    implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setExpirationTime(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    private static enum NullEntry implements ReferenceEntry<Object, Object>
    {
        INSTANCE;


        @Override
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override
        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        @Override
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override
        public int getHash() {
            return 0;
        }

        @Override
        public Object getKey() {
            return null;
        }

        @Override
        public long getExpirationTime() {
            return 0L;
        }

        @Override
        public void setExpirationTime(long l) {
        }

        @Override
        public ReferenceEntry<Object, Object> getNextExpirable() {
            return this;
        }

        @Override
        public void setNextExpirable(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override
        public ReferenceEntry<Object, Object> getPreviousExpirable() {
            return this;
        }

        @Override
        public void setPreviousExpirable(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override
        public ReferenceEntry<Object, Object> getNextEvictable() {
            return this;
        }

        @Override
        public void setNextEvictable(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override
        public ReferenceEntry<Object, Object> getPreviousEvictable() {
            return this;
        }

        @Override
        public void setPreviousEvictable(ReferenceEntry<Object, Object> referenceEntry) {
        }
    }

    public static interface ReferenceEntry<K, V> {
        public ValueReference<K, V> getValueReference();

        public void setValueReference(ValueReference<K, V> var1);

        public ReferenceEntry<K, V> getNext();

        public int getHash();

        public K getKey();

        public long getExpirationTime();

        public void setExpirationTime(long var1);

        public ReferenceEntry<K, V> getNextExpirable();

        public void setNextExpirable(ReferenceEntry<K, V> var1);

        public ReferenceEntry<K, V> getPreviousExpirable();

        public void setPreviousExpirable(ReferenceEntry<K, V> var1);

        public ReferenceEntry<K, V> getNextEvictable();

        public void setNextEvictable(ReferenceEntry<K, V> var1);

        public ReferenceEntry<K, V> getPreviousEvictable();

        public void setPreviousEvictable(ReferenceEntry<K, V> var1);
    }

    public static interface ValueReference<K, V> {
        public V get();

        public V waitForValue() throws ExecutionException;

        public ReferenceEntry<K, V> getEntry();

        public ValueReference<K, V> copyFor(ReferenceQueue<V> var1, @Nullable V var2, ReferenceEntry<K, V> var3);

        public void clear(@Nullable ValueReference<K, V> var1);

        public boolean isComputingReference();
    }

    public static enum EntryFactory {
        STRONG{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry<K, V>(k, n, referenceEntry);
            }
        }
        ,
        STRONG_EXPIRABLE{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongExpirableEntry<K, V>(k, n, referenceEntry);
            }

            @Override
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntry3 = super.copyEntry(segment, referenceEntry, referenceEntry2);
                this.copyExpirableEntry(referenceEntry, referenceEntry3);
                return referenceEntry3;
            }
        }
        ,
        STRONG_EVICTABLE{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongEvictableEntry<K, V>(k, n, referenceEntry);
            }

            @Override
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntry3 = super.copyEntry(segment, referenceEntry, referenceEntry2);
                this.copyEvictableEntry(referenceEntry, referenceEntry3);
                return referenceEntry3;
            }
        }
        ,
        STRONG_EXPIRABLE_EVICTABLE{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongExpirableEvictableEntry<K, V>(k, n, referenceEntry);
            }

            @Override
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntry3 = super.copyEntry(segment, referenceEntry, referenceEntry2);
                this.copyExpirableEntry(referenceEntry, referenceEntry3);
                this.copyEvictableEntry(referenceEntry, referenceEntry3);
                return referenceEntry3;
            }
        }
        ,
        WEAK{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k, n, referenceEntry);
            }
        }
        ,
        WEAK_EXPIRABLE{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakExpirableEntry(segment.keyReferenceQueue, k, n, referenceEntry);
            }

            @Override
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntry3 = super.copyEntry(segment, referenceEntry, referenceEntry2);
                this.copyExpirableEntry(referenceEntry, referenceEntry3);
                return referenceEntry3;
            }
        }
        ,
        WEAK_EVICTABLE{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakEvictableEntry(segment.keyReferenceQueue, k, n, referenceEntry);
            }

            @Override
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntry3 = super.copyEntry(segment, referenceEntry, referenceEntry2);
                this.copyEvictableEntry(referenceEntry, referenceEntry3);
                return referenceEntry3;
            }
        }
        ,
        WEAK_EXPIRABLE_EVICTABLE{

            @Override
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int n, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakExpirableEvictableEntry(segment.keyReferenceQueue, k, n, referenceEntry);
            }

            @Override
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntry3 = super.copyEntry(segment, referenceEntry, referenceEntry2);
                this.copyExpirableEntry(referenceEntry, referenceEntry3);
                this.copyEvictableEntry(referenceEntry, referenceEntry3);
                return referenceEntry3;
            }
        };

        static final int EXPIRABLE_MASK = 1;
        static final int EVICTABLE_MASK = 2;
        static final EntryFactory[][] factories;

        static EntryFactory getFactory(Strength strength, boolean bl, boolean bl2) {
            int n = (bl ? 1 : 0) | (bl2 ? 2 : 0);
            return factories[strength.ordinal()][n];
        }

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> var1, K var2, int var3, @Nullable ReferenceEntry<K, V> var4);

        @GuardedBy(value="Segment.this")
        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return this.newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        @GuardedBy(value="Segment.this")
        <K, V> void copyExpirableEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setExpirationTime(referenceEntry.getExpirationTime());
            MapMakerInternalMap.connectExpirables(referenceEntry.getPreviousExpirable(), referenceEntry2);
            MapMakerInternalMap.connectExpirables(referenceEntry2, referenceEntry.getNextExpirable());
            MapMakerInternalMap.nullifyExpirable(referenceEntry);
        }

        @GuardedBy(value="Segment.this")
        <K, V> void copyEvictableEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            MapMakerInternalMap.connectEvictables(referenceEntry.getPreviousEvictable(), referenceEntry2);
            MapMakerInternalMap.connectEvictables(referenceEntry2, referenceEntry.getNextEvictable());
            MapMakerInternalMap.nullifyEvictable(referenceEntry);
        }

        static {
            factories = new EntryFactory[][]{{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE}, new EntryFactory[0], {WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE}};
        }
    }

    public static enum Strength {
        STRONG{

            @Override
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new StrongValueReference(v);
            }

            @Override
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        }
        ,
        SOFT{

            @Override
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new SoftValueReference(segment.valueReferenceQueue, v, referenceEntry);
            }

            @Override
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        }
        ,
        WEAK{

            @Override
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new WeakValueReference(segment.valueReferenceQueue, v, referenceEntry);
            }

            @Override
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };


        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> var1, ReferenceEntry<K, V> var2, V var3);

        abstract Equivalence<Object> defaultEquivalence();
    }
}

