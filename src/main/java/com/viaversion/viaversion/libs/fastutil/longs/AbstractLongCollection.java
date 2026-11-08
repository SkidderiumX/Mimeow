/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongConsumer;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongPredicate;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class AbstractLongCollection
extends AbstractCollection<Long>
implements LongCollection {
    protected AbstractLongCollection() {
    }

    @Override
    public abstract LongIterator iterator();

    @Override
    public boolean add(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(long l) {
        LongIterator longIterator = this.iterator();
        while (longIterator.hasNext()) {
            if (l != longIterator.nextLong()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean rem(long l) {
        LongIterator longIterator = this.iterator();
        while (longIterator.hasNext()) {
            if (l != longIterator.nextLong()) continue;
            longIterator.remove();
            return true;
        }
        return false;
    }

    @Override
    @Deprecated
    public boolean add(Long l) {
        return LongCollection.super.add(l);
    }

    @Override
    @Deprecated
    public boolean contains(Object object) {
        return LongCollection.super.contains(object);
    }

    @Override
    @Deprecated
    public boolean remove(Object object) {
        return LongCollection.super.remove(object);
    }

    @Override
    public long[] toArray(long[] lArray) {
        int n = this.size();
        if (lArray == null) {
            lArray = new long[n];
        } else if (lArray.length < n) {
            lArray = Arrays.copyOf(lArray, n);
        }
        LongIterators.unwrap(this.iterator(), lArray);
        return lArray;
    }

    @Override
    public long[] toLongArray() {
        int n = this.size();
        if (n == 0) {
            return LongArrays.EMPTY_ARRAY;
        }
        long[] lArray = new long[n];
        LongIterators.unwrap(this.iterator(), lArray);
        return lArray;
    }

    @Override
    @Deprecated
    public long[] toLongArray(long[] lArray) {
        return this.toArray(lArray);
    }

    @Override
    public final void forEach(LongConsumer longConsumer) {
        LongCollection.super.forEach(longConsumer);
    }

    @Override
    public final boolean removeIf(LongPredicate longPredicate) {
        return LongCollection.super.removeIf(longPredicate);
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        boolean bl = false;
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            if (!this.add(longIterator.nextLong())) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean addAll(Collection<? extends Long> collection) {
        if (collection instanceof LongCollection) {
            return this.addAll((LongCollection)collection);
        }
        return super.addAll(collection);
    }

    @Override
    public boolean containsAll(LongCollection longCollection) {
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            if (this.contains(longIterator.nextLong())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof LongCollection) {
            return this.containsAll((LongCollection)collection);
        }
        return super.containsAll(collection);
    }

    @Override
    public boolean removeAll(LongCollection longCollection) {
        boolean bl = false;
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            if (!this.rem(longIterator.nextLong())) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection instanceof LongCollection) {
            return this.removeAll((LongCollection)collection);
        }
        return super.removeAll(collection);
    }

    @Override
    public boolean retainAll(LongCollection longCollection) {
        boolean bl = false;
        LongIterator longIterator = this.iterator();
        while (longIterator.hasNext()) {
            if (longCollection.contains(longIterator.nextLong())) continue;
            longIterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection instanceof LongCollection) {
            return this.retainAll((LongCollection)collection);
        }
        return super.retainAll(collection);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        LongIterator longIterator = this.iterator();
        int n = this.size();
        boolean bl = true;
        stringBuilder.append("{");
        while (n-- != 0) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            long l = longIterator.nextLong();
            stringBuilder.append(String.valueOf(l));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

