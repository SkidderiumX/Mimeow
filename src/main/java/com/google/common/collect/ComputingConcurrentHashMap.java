/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class ComputingConcurrentHashMap<K, V>
extends MapMakerInternalMap<K, V> {
    final Function<? super K, ? extends V> computingFunction;
    private static final long serialVersionUID = 4L;

    ComputingConcurrentHashMap(MapMaker mapMaker, Function<? super K, ? extends V> function) {
        super(mapMaker);
        this.computingFunction = Preconditions.checkNotNull(function);
    }

    @Override
    MapMakerInternalMap.Segment<K, V> createSegment(int n, int n2) {
        return new ComputingSegment(this, n, n2);
    }

    @Override
    ComputingSegment<K, V> segmentFor(int n) {
        return (ComputingSegment)super.segmentFor(n);
    }

    V getOrCompute(K k) throws ExecutionException {
        int n = this.hash(Preconditions.checkNotNull(k));
        return ((ComputingSegment)this.segmentFor(n)).getOrCompute(k, n, this.computingFunction);
    }

    @Override
    Object writeReplace() {
        return new ComputingSerializationProxy<K, V>(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
    }

    public static final class ComputingSerializationProxy<K, V>
    extends MapMakerInternalMap.AbstractSerializationProxy<K, V> {
        final Function<? super K, ? extends V> computingFunction;
        private static final long serialVersionUID = 4L;

        ComputingSerializationProxy(MapMakerInternalMap.Strength strength, MapMakerInternalMap.Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long l, long l2, int n, int n2, MapMaker.RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap, Function<? super K, ? extends V> function) {
            super(strength, strength2, equivalence, equivalence2, l, l2, n, n2, removalListener, concurrentMap);
            this.computingFunction = function;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            this.writeMapTo(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            MapMaker mapMaker = this.readMapMaker(objectInputStream);
            this.delegate = mapMaker.makeComputingMap(this.computingFunction);
            this.readEntries(objectInputStream);
        }

        Object readResolve() {
            return this.delegate;
        }
    }

    private static final class ComputingValueReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V> {
        final Function<? super K, ? extends V> computingFunction;
        @GuardedBy(value="ComputingValueReference.this")
        volatile MapMakerInternalMap.ValueReference<K, V> computedReference = MapMakerInternalMap.unset();

        public ComputingValueReference(Function<? super K, ? extends V> function) {
            this.computingFunction = function;
        }

        @Override
        public V get() {
            return null;
        }

        @Override
        public MapMakerInternalMap.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override
        public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @Nullable V v, MapMakerInternalMap.ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override
        public boolean isComputingReference() {
            return true;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public V waitForValue() throws ExecutionException {
            if (this.computedReference == MapMakerInternalMap.UNSET) {
                boolean bl = false;
                try {
                    ComputingValueReference computingValueReference = this;
                    synchronized (computingValueReference) {
                        while (this.computedReference == MapMakerInternalMap.UNSET) {
                            try {
                                this.wait();
                            }
                            catch (InterruptedException interruptedException) {
                                bl = true;
                            }
                        }
                    }
                }
                finally {
                    if (bl) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            return this.computedReference.waitForValue();
        }

        @Override
        public void clear(MapMakerInternalMap.ValueReference<K, V> valueReference) {
            this.setValueReference(valueReference);
        }

        V compute(K k, int n) throws ExecutionException {
            V v;
            try {
                v = this.computingFunction.apply(k);
            }
            catch (Throwable throwable) {
                this.setValueReference(new ComputationExceptionReference(throwable));
                throw new ExecutionException(throwable);
            }
            this.setValueReference(new ComputedReference(v));
            return v;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void setValueReference(MapMakerInternalMap.ValueReference<K, V> valueReference) {
            ComputingValueReference computingValueReference = this;
            synchronized (computingValueReference) {
                if (this.computedReference == MapMakerInternalMap.UNSET) {
                    this.computedReference = valueReference;
                    this.notifyAll();
                }
            }
        }
    }

    private static final class ComputedReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V> {
        final V value;

        ComputedReference(@Nullable V v) {
            this.value = v;
        }

        @Override
        public V get() {
            return this.value;
        }

        @Override
        public MapMakerInternalMap.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override
        public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, MapMakerInternalMap.ReferenceEntry<K, V> referenceEntry) {
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
        public void clear(MapMakerInternalMap.ValueReference<K, V> valueReference) {
        }
    }

    private static final class ComputationExceptionReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V> {
        final Throwable t;

        ComputationExceptionReference(Throwable throwable) {
            this.t = throwable;
        }

        @Override
        public V get() {
            return null;
        }

        @Override
        public MapMakerInternalMap.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override
        public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, MapMakerInternalMap.ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override
        public boolean isComputingReference() {
            return false;
        }

        @Override
        public V waitForValue() throws ExecutionException {
            throw new ExecutionException(this.t);
        }

        @Override
        public void clear(MapMakerInternalMap.ValueReference<K, V> valueReference) {
        }
    }

    public static final class ComputingSegment<K, V>
    extends MapMakerInternalMap.Segment<K, V> {
        ComputingSegment(MapMakerInternalMap<K, V> mapMakerInternalMap, int n, int n2) {
            super(mapMakerInternalMap, n, n2);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        V getOrCompute(K k, int n, Function<? super K, ? extends V> function) throws ExecutionException {
            try {
                ComputingValueReference<? super K, ? extends V> computingValueReference;
                MapMakerInternalMap.ReferenceEntry<Object, Object> referenceEntry;
                Object v;
                do {
                    if ((referenceEntry = this.getEntry(k, n)) != null && (v = this.getLiveValue(referenceEntry)) != null) {
                        this.recordRead(referenceEntry);
                        computingValueReference = (ComputingValueReference<? super K, ? extends V>)v;
                        return (V)computingValueReference;
                    }
                    if (referenceEntry == null || !referenceEntry.getValueReference().isComputingReference()) {
                        boolean bl;
                        block22: {
                            bl = true;
                            computingValueReference = null;
                            this.lock();
                            try {
                                MapMakerInternalMap.ReferenceEntry<Object, Object> referenceEntry2;
                                this.preWriteCleanup();
                                int n2 = this.count - 1;
                                AtomicReferenceArray atomicReferenceArray = this.table;
                                int n3 = n & atomicReferenceArray.length() - 1;
                                for (referenceEntry = referenceEntry2 = (MapMakerInternalMap.ReferenceEntry<Object, Object>)atomicReferenceArray.get(n3); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                                    Object k2 = referenceEntry.getKey();
                                    if (referenceEntry.getHash() != n || k2 == null || !this.map.keyEquivalence.equivalent(k, k2)) continue;
                                    MapMakerInternalMap.ValueReference valueReference = referenceEntry.getValueReference();
                                    if (valueReference.isComputingReference()) {
                                        bl = false;
                                        break;
                                    }
                                    Object v2 = referenceEntry.getValueReference().get();
                                    if (v2 == null) {
                                        this.enqueueNotification(k2, n, v2, MapMaker.RemovalCause.COLLECTED);
                                    } else if (this.map.expires() && this.map.isExpired(referenceEntry)) {
                                        this.enqueueNotification(k2, n, v2, MapMaker.RemovalCause.EXPIRED);
                                    } else {
                                        this.recordLockedRead(referenceEntry);
                                        Object v3 = v2;
                                        return v3;
                                    }
                                    this.evictionQueue.remove(referenceEntry);
                                    this.expirationQueue.remove(referenceEntry);
                                    this.count = n2;
                                    break;
                                }
                                if (!bl) break block22;
                                computingValueReference = new ComputingValueReference<K, V>(function);
                                if (referenceEntry == null) {
                                    referenceEntry = this.newEntry(k, n, referenceEntry2);
                                    referenceEntry.setValueReference(computingValueReference);
                                    atomicReferenceArray.set(n3, referenceEntry);
                                } else {
                                    referenceEntry.setValueReference(computingValueReference);
                                }
                            }
                            finally {
                                this.unlock();
                                this.postWriteCleanup();
                            }
                        }
                        if (bl) {
                            V v4 = this.compute(k, n, referenceEntry, computingValueReference);
                            return v4;
                        }
                    }
                    Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive computation");
                } while ((v = referenceEntry.getValueReference().waitForValue()) == null);
                this.recordRead(referenceEntry);
                computingValueReference = (ComputingValueReference<? super K, ? extends V>)v;
                return (V)computingValueReference;
            }
            finally {
                this.postReadCleanup();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        V compute(K k, int n, MapMakerInternalMap.ReferenceEntry<K, V> referenceEntry, ComputingValueReference<K, V> computingValueReference) throws ExecutionException {
            Object v = null;
            long l = System.nanoTime();
            long l2 = 0L;
            try {
                MapMakerInternalMap.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                synchronized (referenceEntry2) {
                    v = computingValueReference.compute(k, n);
                    l2 = System.nanoTime();
                }
                if (v != null && (referenceEntry2 = this.put(k, n, v, true)) != null) {
                    this.enqueueNotification(k, n, v, MapMaker.RemovalCause.REPLACED);
                }
                referenceEntry2 = v;
                return (V)referenceEntry2;
            }
            finally {
                if (l2 == 0L) {
                    l2 = System.nanoTime();
                }
                if (v == null) {
                    this.clearValue(k, n, computingValueReference);
                }
            }
        }
    }
}

