/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
public class AtomicLongMap<K> {
    private final ConcurrentHashMap<K, AtomicLong> map;
    private transient Map<K, Long> asMap;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<? extends K> atomicLongMap = AtomicLongMap.create();
        atomicLongMap.putAll(map);
        return atomicLongMap;
    }

    public long get(K k) {
        AtomicLong atomicLong = this.map.get(k);
        return atomicLong == null ? 0L : atomicLong.get();
    }

    public long incrementAndGet(K k) {
        return this.addAndGet(k, 1L);
    }

    public long decrementAndGet(K k) {
        return this.addAndGet(k, -1L);
    }

    public long addAndGet(K k, long l) {
        long l2;
        block0: while (true) {
            long l3;
            AtomicLong atomicLong;
            if ((atomicLong = this.map.get(k)) == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(l))) == null) {
                return l;
            }
            do {
                if ((l3 = atomicLong.get()) != 0L) continue;
                if (!this.map.replace(k, atomicLong, new AtomicLong(l))) continue block0;
                return l;
            } while (!atomicLong.compareAndSet(l3, l2 = l3 + l));
            break;
        }
        return l2;
    }

    public long getAndIncrement(K k) {
        return this.getAndAdd(k, 1L);
    }

    public long getAndDecrement(K k) {
        return this.getAndAdd(k, -1L);
    }

    public long getAndAdd(K k, long l) {
        long l2;
        block0: while (true) {
            long l3;
            AtomicLong atomicLong;
            if ((atomicLong = this.map.get(k)) == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(l))) == null) {
                return 0L;
            }
            do {
                if ((l2 = atomicLong.get()) != 0L) continue;
                if (!this.map.replace(k, atomicLong, new AtomicLong(l))) continue block0;
                return 0L;
            } while (!atomicLong.compareAndSet(l2, l3 = l2 + l));
            break;
        }
        return l2;
    }

    public long put(K k, long l) {
        long l2;
        block0: while (true) {
            AtomicLong atomicLong;
            if ((atomicLong = this.map.get(k)) == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(l))) == null) {
                return 0L;
            }
            do {
                if ((l2 = atomicLong.get()) != 0L) continue;
                if (!this.map.replace(k, atomicLong, new AtomicLong(l))) continue block0;
                return 0L;
            } while (!atomicLong.compareAndSet(l2, l));
            break;
        }
        return l2;
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<K, Long> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public long remove(K k) {
        long l;
        AtomicLong atomicLong = this.map.get(k);
        if (atomicLong == null) {
            return 0L;
        }
        while ((l = atomicLong.get()) != 0L && !atomicLong.compareAndSet(l, 0L)) {
        }
        this.map.remove(k, atomicLong);
        return l;
    }

    public void removeAllZeros() {
        for (Object e : this.map.keySet()) {
            AtomicLong atomicLong = this.map.get(e);
            if (atomicLong == null || atomicLong.get() != 0L) continue;
            this.map.remove(e, atomicLong);
        }
    }

    public long sum() {
        long l = 0L;
        for (AtomicLong atomicLong : this.map.values()) {
            l += atomicLong.get();
        }
        return l;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.asMap;
        return map == null ? (this.asMap = this.createAsMap()) : map;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>(){

            @Override
            public Long apply(AtomicLong atomicLong) {
                return atomicLong.get();
            }
        }));
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }

    long putIfAbsent(K k, long l) {
        long l2;
        block2: {
            AtomicLong atomicLong;
            do {
                if ((atomicLong = this.map.get(k)) == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(l))) == null) {
                    return 0L;
                }
                l2 = atomicLong.get();
                if (l2 != 0L) break block2;
            } while (!this.map.replace(k, atomicLong, new AtomicLong(l)));
            return 0L;
        }
        return l2;
    }

    boolean replace(K k, long l, long l2) {
        if (l == 0L) {
            return this.putIfAbsent(k, l2) == 0L;
        }
        AtomicLong atomicLong = this.map.get(k);
        return atomicLong == null ? false : atomicLong.compareAndSet(l, l2);
    }

    boolean remove(K k, long l) {
        AtomicLong atomicLong = this.map.get(k);
        if (atomicLong == null) {
            return false;
        }
        long l2 = atomicLong.get();
        if (l2 != l) {
            return false;
        }
        if (l2 == 0L || atomicLong.compareAndSet(l2, 0L)) {
            this.map.remove(k, atomicLong);
            return true;
        }
        return false;
    }
}

