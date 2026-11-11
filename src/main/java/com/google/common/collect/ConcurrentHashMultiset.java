/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class ConcurrentHashMultiset<E>
extends AbstractMultiset<E>
implements Serializable {
    private final transient ConcurrentMap<E, AtomicInteger> countMap;
    private transient EntrySet entrySet;
    private static final long serialVersionUID = 1L;

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> concurrentHashMultiset = ConcurrentHashMultiset.create();
        Iterables.addAll(concurrentHashMultiset, iterable);
        return concurrentHashMultiset;
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(MapMaker mapMaker) {
        return new ConcurrentHashMultiset(mapMaker.makeMap());
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty());
        this.countMap = concurrentMap;
    }

    @Override
    public int count(@Nullable Object object) {
        AtomicInteger atomicInteger = Maps.safeGet(this.countMap, object);
        return atomicInteger == null ? 0 : atomicInteger.get();
    }

    @Override
    public int size() {
        long l = 0L;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            l += (long)atomicInteger.get();
        }
        return Ints.saturatedCast(l);
    }

    @Override
    public Object[] toArray() {
        return this.snapshot().toArray();
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        return this.snapshot().toArray(TArray);
    }

    private List<E> snapshot() {
        ArrayList<E> arrayList = Lists.newArrayListWithExpectedSize(this.size());
        for (Multiset.Entry<E> entry : this.entrySet()) {
            E e = entry.getElement();
            for (int i = entry.getCount(); i > 0; --i) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    @Override
    public int add(E e, int n) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        Preconditions.checkNotNull(e);
        if (n == 0) {
            return this.count(e);
        }
        Preconditions.checkArgument(n > 0, "Invalid occurrences: %s", n);
        do {
            int n2;
            if ((atomicInteger = Maps.safeGet(this.countMap, e)) == null && (atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(n))) == null) {
                return 0;
            }
            while ((n2 = atomicInteger.get()) != 0) {
                try {
                    int n3 = IntMath.checkedAdd(n2, n);
                    if (!atomicInteger.compareAndSet(n2, n3)) continue;
                    return n2;
                }
                catch (ArithmeticException arithmeticException) {
                    throw new IllegalArgumentException("Overflow adding " + n + " occurrences to a count of " + n2);
                }
            }
        } while (this.countMap.putIfAbsent(e, atomicInteger2 = new AtomicInteger(n)) != null && !this.countMap.replace(e, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override
    public int remove(@Nullable Object object, int n) {
        int n2;
        if (n == 0) {
            return this.count(object);
        }
        Preconditions.checkArgument(n > 0, "Invalid occurrences: %s", n);
        AtomicInteger atomicInteger = Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            return 0;
        }
        while ((n2 = atomicInteger.get()) != 0) {
            int n3 = Math.max(0, n2 - n);
            if (!atomicInteger.compareAndSet(n2, n3)) continue;
            if (n3 == 0) {
                this.countMap.remove(object, atomicInteger);
            }
            return n2;
        }
        return 0;
    }

    public boolean removeExactly(@Nullable Object object, int n) {
        int n2;
        int n3;
        if (n == 0) {
            return true;
        }
        Preconditions.checkArgument(n > 0, "Invalid occurrences: %s", n);
        AtomicInteger atomicInteger = Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            return false;
        }
        do {
            if ((n3 = atomicInteger.get()) >= n) continue;
            return false;
        } while (!atomicInteger.compareAndSet(n3, n2 = n3 - n));
        if (n2 == 0) {
            this.countMap.remove(object, atomicInteger);
        }
        return true;
    }

    @Override
    public int setCount(E e, int n) {
        int n2;
        AtomicInteger atomicInteger;
        Preconditions.checkNotNull(e);
        CollectPreconditions.checkNonnegative(n, "count");
        block0: while (true) {
            if ((atomicInteger = Maps.safeGet(this.countMap, e)) == null) {
                if (n == 0) {
                    return 0;
                }
                atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(n));
                if (atomicInteger == null) {
                    return 0;
                }
            }
            do {
                if ((n2 = atomicInteger.get()) != 0) continue;
                if (n == 0) {
                    return 0;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(n);
                if (this.countMap.putIfAbsent(e, atomicInteger2) != null && !this.countMap.replace(e, atomicInteger, atomicInteger2)) continue block0;
                return 0;
            } while (!atomicInteger.compareAndSet(n2, n));
            break;
        }
        if (n == 0) {
            this.countMap.remove(e, atomicInteger);
        }
        return n2;
    }

    @Override
    public boolean setCount(E e, int n, int n2) {
        Preconditions.checkNotNull(e);
        CollectPreconditions.checkNonnegative(n, "oldCount");
        CollectPreconditions.checkNonnegative(n2, "newCount");
        AtomicInteger atomicInteger = Maps.safeGet(this.countMap, e);
        if (atomicInteger == null) {
            if (n != 0) {
                return false;
            }
            if (n2 == 0) {
                return true;
            }
            return this.countMap.putIfAbsent(e, new AtomicInteger(n2)) == null;
        }
        int n3 = atomicInteger.get();
        if (n3 == n) {
            if (n3 == 0) {
                if (n2 == 0) {
                    this.countMap.remove(e, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(n2);
                return this.countMap.putIfAbsent(e, atomicInteger2) == null || this.countMap.replace(e, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(n3, n2)) {
                if (n2 == 0) {
                    this.countMap.remove(e, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    Set<E> createElementSet() {
        final Set set = this.countMap.keySet();
        return new ForwardingSet<E>(){

            @Override
            protected Set<E> delegate() {
                return set;
            }

            @Override
            public boolean contains(@Nullable Object object) {
                return object != null && Collections2.safeContains(set, object);
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return this.standardContainsAll(collection);
            }

            @Override
            public boolean remove(Object object) {
                return object != null && Collections2.safeRemove(set, object);
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return this.standardRemoveAll(collection);
            }
        };
    }

    @Override
    public Set<Multiset.Entry<E>> entrySet() {
        EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            this.entrySet = entrySet = new EntrySet();
        }
        return entrySet;
    }

    @Override
    int distinctElements() {
        return this.countMap.size();
    }

    @Override
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override
    Iterator<Multiset.Entry<E>> entryIterator() {
        final AbstractIterator abstractIterator = new AbstractIterator<Multiset.Entry<E>>(){
            private Iterator<Map.Entry<E, AtomicInteger>> mapEntries;
            {
                this.mapEntries = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
            }

            @Override
            protected Multiset.Entry<E> computeNext() {
                Map.Entry entry;
                int n;
                do {
                    if (this.mapEntries.hasNext()) continue;
                    return (Multiset.Entry)this.endOfData();
                } while ((n = (entry = this.mapEntries.next()).getValue().get()) == 0);
                return Multisets.immutableEntry(entry.getKey(), n);
            }
        };
        return new ForwardingIterator<Multiset.Entry<E>>(){
            private Multiset.Entry<E> last;

            @Override
            protected Iterator<Multiset.Entry<E>> delegate() {
                return abstractIterator;
            }

            @Override
            public Multiset.Entry<E> next() {
                this.last = (Multiset.Entry)super.next();
                return this.last;
            }

            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.last != null);
                ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
                this.last = null;
            }
        };
    }

    @Override
    public void clear() {
        this.countMap.clear();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        ConcurrentMap concurrentMap = (ConcurrentMap)objectInputStream.readObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, concurrentMap);
    }

    private class EntrySet
    extends AbstractMultiset.EntrySet {
        private EntrySet() {
        }

        @Override
        ConcurrentHashMultiset<E> multiset() {
            return ConcurrentHashMultiset.this;
        }

        @Override
        public Object[] toArray() {
            return this.snapshot().toArray();
        }

        @Override
        public Object[] toArray(Object[] TArray) {
            return this.snapshot().toArray(TArray);
        }

        private List<Multiset.Entry<E>> snapshot() {
            ArrayList arrayList = Lists.newArrayListWithExpectedSize(this.size());
            Iterators.addAll(arrayList, this.iterator());
            return arrayList;
        }
    }

    private static class FieldSettersHolder {
        static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");

        private FieldSettersHolder() {
        }
    }
}

