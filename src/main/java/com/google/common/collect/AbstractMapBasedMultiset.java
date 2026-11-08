/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Count;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class AbstractMapBasedMultiset<E>
extends AbstractMultiset<E>
implements Serializable {
    private transient Map<E, Count> backingMap;
    private transient long size;
    @GwtIncompatible(value="not needed in emulated source.")
    private static final long serialVersionUID = -2250766705698539974L;

    protected AbstractMapBasedMultiset(Map<E, Count> map) {
        this.backingMap = Preconditions.checkNotNull(map);
        this.size = super.size();
    }

    void setBackingMap(Map<E, Count> map) {
        this.backingMap = map;
    }

    @Override
    public Set<Multiset.Entry<E>> entrySet() {
        return super.entrySet();
    }

    @Override
    Iterator<Multiset.Entry<E>> entryIterator() {
        final Iterator<Map.Entry<E, Count>> iterator2 = this.backingMap.entrySet().iterator();
        return new Iterator<Multiset.Entry<E>>(){
            Map.Entry<E, Count> toRemove;

            @Override
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            @Override
            public Multiset.Entry<E> next() {
                Map.Entry entry;
                this.toRemove = entry = (Map.Entry)iterator2.next();
                return new Multisets.AbstractEntry<E>(){

                    @Override
                    public E getElement() {
                        return entry.getKey();
                    }

                    @Override
                    public int getCount() {
                        Count count;
                        Count count2 = (Count)entry.getValue();
                        if ((count2 == null || count2.get() == 0) && (count = (Count)AbstractMapBasedMultiset.this.backingMap.get(this.getElement())) != null) {
                            return count.get();
                        }
                        return count2 == null ? 0 : count2.get();
                    }
                };
            }

            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                AbstractMapBasedMultiset.this.size -= this.toRemove.getValue().getAndSet(0);
                iterator2.remove();
                this.toRemove = null;
            }
        };
    }

    @Override
    public void clear() {
        for (Count count : this.backingMap.values()) {
            count.set(0);
        }
        this.backingMap.clear();
        this.size = 0L;
    }

    @Override
    int distinctElements() {
        return this.backingMap.size();
    }

    @Override
    public int size() {
        return Ints.saturatedCast(this.size);
    }

    @Override
    public Iterator<E> iterator() {
        return new MapBasedMultisetIterator();
    }

    @Override
    public int count(@Nullable Object object) {
        Count count = Maps.safeGet(this.backingMap, object);
        return count == null ? 0 : count.get();
    }

    @Override
    public int add(@Nullable E e, int n) {
        int n2;
        if (n == 0) {
            return this.count(e);
        }
        Preconditions.checkArgument(n > 0, "occurrences cannot be negative: %s", n);
        Count count = this.backingMap.get(e);
        if (count == null) {
            n2 = 0;
            this.backingMap.put(e, new Count(n));
        } else {
            n2 = count.get();
            long l = (long)n2 + (long)n;
            Preconditions.checkArgument(l <= Integer.MAX_VALUE, "too many occurrences: %s", l);
            count.getAndAdd(n);
        }
        this.size += (long)n;
        return n2;
    }

    @Override
    public int remove(@Nullable Object object, int n) {
        int n2;
        if (n == 0) {
            return this.count(object);
        }
        Preconditions.checkArgument(n > 0, "occurrences cannot be negative: %s", n);
        Count count = this.backingMap.get(object);
        if (count == null) {
            return 0;
        }
        int n3 = count.get();
        if (n3 > n) {
            n2 = n;
        } else {
            n2 = n3;
            this.backingMap.remove(object);
        }
        count.addAndGet(-n2);
        this.size -= (long)n2;
        return n3;
    }

    @Override
    public int setCount(@Nullable E e, int n) {
        int n2;
        CollectPreconditions.checkNonnegative(n, "count");
        if (n == 0) {
            Count count = this.backingMap.remove(e);
            n2 = AbstractMapBasedMultiset.getAndSet(count, n);
        } else {
            Count count = this.backingMap.get(e);
            n2 = AbstractMapBasedMultiset.getAndSet(count, n);
            if (count == null) {
                this.backingMap.put(e, new Count(n));
            }
        }
        this.size += (long)(n - n2);
        return n2;
    }

    private static int getAndSet(Count count, int n) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(n);
    }

    @GwtIncompatible(value="java.io.ObjectStreamException")
    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }

    private class MapBasedMultisetIterator
    implements Iterator<E> {
        final Iterator<Map.Entry<E, Count>> entryIterator;
        Map.Entry<E, Count> currentEntry;
        int occurrencesLeft;
        boolean canRemove;

        MapBasedMultisetIterator() {
            this.entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return this.occurrencesLeft > 0 || this.entryIterator.hasNext();
        }

        @Override
        public E next() {
            if (this.occurrencesLeft == 0) {
                this.currentEntry = this.entryIterator.next();
                this.occurrencesLeft = this.currentEntry.getValue().get();
            }
            --this.occurrencesLeft;
            this.canRemove = true;
            return this.currentEntry.getKey();
        }

        @Override
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            int n = this.currentEntry.getValue().get();
            if (n <= 0) {
                throw new ConcurrentModificationException();
            }
            if (this.currentEntry.getValue().addAndGet(-1) == 0) {
                this.entryIterator.remove();
            }
            AbstractMapBasedMultiset.this.size--;
            this.canRemove = false;
        }
    }
}

