/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.Hash;
import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrayList;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollections;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;

public class LongOpenHashSet
extends AbstractLongSet
implements Serializable,
Cloneable,
Hash {
    private static final long serialVersionUID = 0L;
    private static final boolean ASSERTS = false;
    protected transient long[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected transient int n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;
    protected final float f;

    public LongOpenHashSet(int n, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        }
        if (n < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = f;
        this.minN = this.n = HashCommon.arraySize(n, f);
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, f);
        this.key = new long[this.n + 1];
    }

    public LongOpenHashSet(int n) {
        this(n, 0.75f);
    }

    public LongOpenHashSet() {
        this(16, 0.75f);
    }

    public LongOpenHashSet(Collection<? extends Long> collection, float f) {
        this(collection.size(), f);
        this.addAll(collection);
    }

    public LongOpenHashSet(Collection<? extends Long> collection) {
        this(collection, 0.75f);
    }

    public LongOpenHashSet(LongCollection longCollection, float f) {
        this(longCollection.size(), f);
        this.addAll(longCollection);
    }

    public LongOpenHashSet(LongCollection longCollection) {
        this(longCollection, 0.75f);
    }

    public LongOpenHashSet(LongIterator longIterator, float f) {
        this(16, f);
        while (longIterator.hasNext()) {
            this.add(longIterator.nextLong());
        }
    }

    public LongOpenHashSet(LongIterator longIterator) {
        this(longIterator, 0.75f);
    }

    public LongOpenHashSet(Iterator<?> iterator2, float f) {
        this(LongIterators.asLongIterator(iterator2), f);
    }

    public LongOpenHashSet(Iterator<?> iterator2) {
        this(LongIterators.asLongIterator(iterator2));
    }

    public LongOpenHashSet(long[] lArray, int n, int n2, float f) {
        this(n2 < 0 ? 0 : n2, f);
        LongArrays.ensureOffsetLength(lArray, n, n2);
        for (int i = 0; i < n2; ++i) {
            this.add(lArray[n + i]);
        }
    }

    public LongOpenHashSet(long[] lArray, int n, int n2) {
        this(lArray, n, n2, 0.75f);
    }

    public LongOpenHashSet(long[] lArray, float f) {
        this(lArray, 0, lArray.length, f);
    }

    public LongOpenHashSet(long[] lArray) {
        this(lArray, 0.75f);
    }

    public static LongOpenHashSet of() {
        return new LongOpenHashSet();
    }

    public static LongOpenHashSet of(long l) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet(1, 0.75f);
        longOpenHashSet.add(l);
        return longOpenHashSet;
    }

    public static LongOpenHashSet of(long l, long l2) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet(2, 0.75f);
        longOpenHashSet.add(l);
        if (!longOpenHashSet.add(l2)) {
            throw new IllegalArgumentException("Duplicate element: " + l2);
        }
        return longOpenHashSet;
    }

    public static LongOpenHashSet of(long l, long l2, long l3) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet(3, 0.75f);
        longOpenHashSet.add(l);
        if (!longOpenHashSet.add(l2)) {
            throw new IllegalArgumentException("Duplicate element: " + l2);
        }
        if (!longOpenHashSet.add(l3)) {
            throw new IllegalArgumentException("Duplicate element: " + l3);
        }
        return longOpenHashSet;
    }

    public static LongOpenHashSet of(long ... lArray) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet(lArray.length, 0.75f);
        for (long l : lArray) {
            if (longOpenHashSet.add(l)) continue;
            throw new IllegalArgumentException("Duplicate element " + l);
        }
        return longOpenHashSet;
    }

    public static LongOpenHashSet toSet(LongStream longStream) {
        return longStream.collect(LongOpenHashSet::new, LongOpenHashSet::add, LongOpenHashSet::addAll);
    }

    public static LongOpenHashSet toSetWithExpectedSize(LongStream longStream, int n2) {
        if (n2 <= 16) {
            return LongOpenHashSet.toSet(longStream);
        }
        return longStream.collect(new LongCollections.SizeDecreasingSupplier<LongOpenHashSet>(n2, n -> n <= 16 ? new LongOpenHashSet() : new LongOpenHashSet(n)), LongOpenHashSet::add, LongOpenHashSet::addAll);
    }

    private int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    public void ensureCapacity(int n) {
        int n2 = HashCommon.arraySize(n, this.f);
        if (n2 > this.n) {
            this.rehash(n2);
        }
    }

    private void tryCapacity(long l) {
        int n = (int)Math.min(0x40000000L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil((float)l / this.f))));
        if (n > this.n) {
            this.rehash(n);
        }
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        if ((double)this.f <= 0.5) {
            this.ensureCapacity(longCollection.size());
        } else {
            this.tryCapacity(this.size() + longCollection.size());
        }
        return super.addAll(longCollection);
    }

    @Override
    public boolean addAll(Collection<? extends Long> collection) {
        if ((double)this.f <= 0.5) {
            this.ensureCapacity(collection.size());
        } else {
            this.tryCapacity(this.size() + collection.size());
        }
        return super.addAll(collection);
    }

    @Override
    public boolean add(long l) {
        if (l == 0L) {
            if (this.containsNull) {
                return false;
            }
            this.containsNull = true;
        } else {
            long[] lArray = this.key;
            int n = (int)HashCommon.mix(l) & this.mask;
            long l2 = lArray[n];
            if (l2 != 0L) {
                if (l2 == l) {
                    return false;
                }
                while ((l2 = lArray[n = n + 1 & this.mask]) != 0L) {
                    if (l2 != l) continue;
                    return false;
                }
            }
            lArray[n] = l;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return true;
    }

    protected final void shiftKeys(int n) {
        long[] lArray = this.key;
        while (true) {
            long l;
            int n2 = n;
            n = n2 + 1 & this.mask;
            while (true) {
                if ((l = lArray[n]) == 0L) {
                    lArray[n2] = 0L;
                    return;
                }
                int n3 = (int)HashCommon.mix(l) & this.mask;
                if (n2 <= n ? n2 >= n3 || n3 > n : n2 >= n3 && n3 > n) break;
                n = n + 1 & this.mask;
            }
            lArray[n2] = l;
        }
    }

    private boolean removeEntry(int n) {
        --this.size;
        this.shiftKeys(n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.n] = 0L;
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }

    @Override
    public boolean remove(long l) {
        if (l == 0L) {
            if (this.containsNull) {
                return this.removeNullEntry();
            }
            return false;
        }
        long[] lArray = this.key;
        int n = (int)HashCommon.mix(l) & this.mask;
        long l2 = lArray[n];
        if (l2 == 0L) {
            return false;
        }
        if (l == l2) {
            return this.removeEntry(n);
        }
        do {
            if ((l2 = lArray[n = n + 1 & this.mask]) != 0L) continue;
            return false;
        } while (l != l2);
        return this.removeEntry(n);
    }

    @Override
    public boolean contains(long l) {
        if (l == 0L) {
            return this.containsNull;
        }
        long[] lArray = this.key;
        int n = (int)HashCommon.mix(l) & this.mask;
        long l2 = lArray[n];
        if (l2 == 0L) {
            return false;
        }
        if (l == l2) {
            return true;
        }
        do {
            if ((l2 = lArray[n = n + 1 & this.mask]) != 0L) continue;
            return false;
        } while (l != l2);
        return true;
    }

    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNull = false;
        Arrays.fill(this.key, 0L);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public LongIterator iterator() {
        return new SetIterator();
    }

    @Override
    public LongSpliterator spliterator() {
        return new SetSpliterator();
    }

    @Override
    public void forEach(LongConsumer longConsumer) {
        long[] lArray = this.key;
        if (this.containsNull) {
            longConsumer.accept(lArray[this.n]);
        }
        int n = this.n;
        while (n-- != 0) {
            if (lArray[n] == 0L) continue;
            longConsumer.accept(lArray[n]);
        }
    }

    public boolean trim() {
        return this.trim(this.size);
    }

    public boolean trim(int n) {
        int n2 = HashCommon.nextPowerOfTwo((int)Math.ceil((float)n / this.f));
        if (n2 >= this.n || this.size > HashCommon.maxFill(n2, this.f)) {
            return true;
        }
        try {
            this.rehash(n2);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            return false;
        }
        return true;
    }

    protected void rehash(int n) {
        long[] lArray = this.key;
        int n2 = n - 1;
        long[] lArray2 = new long[n + 1];
        int n3 = this.n;
        int n4 = this.realSize();
        while (n4-- != 0) {
            while (lArray[--n3] == 0L) {
            }
            int n5 = (int)HashCommon.mix(lArray[n3]) & n2;
            if (lArray2[n5] != 0L) {
                while (lArray2[n5 = n5 + 1 & n2] != 0L) {
                }
            }
            lArray2[n5] = lArray[n3];
        }
        this.n = n;
        this.mask = n2;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lArray2;
    }

    public LongOpenHashSet clone() {
        LongOpenHashSet longOpenHashSet;
        try {
            longOpenHashSet = (LongOpenHashSet)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        longOpenHashSet.key = (long[])this.key.clone();
        longOpenHashSet.containsNull = this.containsNull;
        return longOpenHashSet;
    }

    @Override
    public int hashCode() {
        int n = 0;
        long[] lArray = this.key;
        int n2 = this.realSize();
        int n3 = 0;
        while (n2-- != 0) {
            while (lArray[n3] == 0L) {
                ++n3;
            }
            n += HashCommon.long2int(lArray[n3]);
            ++n3;
        }
        return n;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LongIterator longIterator = this.iterator();
        objectOutputStream.defaultWriteObject();
        int n = this.size;
        while (n-- != 0) {
            objectOutputStream.writeLong(longIterator.nextLong());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        this.key = new long[this.n + 1];
        long[] lArray = this.key;
        int n = this.size;
        while (n-- != 0) {
            int n2;
            long l = objectInputStream.readLong();
            if (l == 0L) {
                n2 = this.n;
                this.containsNull = true;
            } else {
                n2 = (int)HashCommon.mix(l) & this.mask;
                if (lArray[n2] != 0L) {
                    while (lArray[n2 = n2 + 1 & this.mask] != 0L) {
                    }
                }
            }
            lArray[n2] = l;
        }
    }

    private void checkTable() {
    }

    private final class SetIterator
    implements LongIterator {
        int pos;
        int last;
        int c;
        boolean mustReturnNull;
        LongArrayList wrapped;

        private SetIterator() {
            this.pos = LongOpenHashSet.this.n;
            this.last = -1;
            this.c = LongOpenHashSet.this.size;
            this.mustReturnNull = LongOpenHashSet.this.containsNull;
        }

        @Override
        public boolean hasNext() {
            return this.c != 0;
        }

        @Override
        public long nextLong() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            long[] lArray = LongOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = LongOpenHashSet.this.n;
                return lArray[LongOpenHashSet.this.n];
            }
            do {
                if (--this.pos >= 0) continue;
                this.last = Integer.MIN_VALUE;
                return this.wrapped.getLong(-this.pos - 1);
            } while (lArray[this.pos] == 0L);
            this.last = this.pos;
            return lArray[this.last];
        }

        private final void shiftKeys(int n) {
            long[] lArray = LongOpenHashSet.this.key;
            while (true) {
                long l;
                int n2 = n;
                n = n2 + 1 & LongOpenHashSet.this.mask;
                while (true) {
                    if ((l = lArray[n]) == 0L) {
                        lArray[n2] = 0L;
                        return;
                    }
                    int n3 = (int)HashCommon.mix(l) & LongOpenHashSet.this.mask;
                    if (n2 <= n ? n2 >= n3 || n3 > n : n2 >= n3 && n3 > n) break;
                    n = n + 1 & LongOpenHashSet.this.mask;
                }
                if (n < n2) {
                    if (this.wrapped == null) {
                        this.wrapped = new LongArrayList(2);
                    }
                    this.wrapped.add(lArray[n]);
                }
                lArray[n2] = l;
            }
        }

        @Override
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == LongOpenHashSet.this.n) {
                LongOpenHashSet.this.containsNull = false;
                LongOpenHashSet.this.key[LongOpenHashSet.this.n] = 0L;
            } else if (this.pos >= 0) {
                this.shiftKeys(this.last);
            } else {
                LongOpenHashSet.this.remove(this.wrapped.getLong(-this.pos - 1));
                this.last = -1;
                return;
            }
            --LongOpenHashSet.this.size;
            this.last = -1;
        }

        @Override
        public void forEachRemaining(LongConsumer longConsumer) {
            long[] lArray = LongOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = LongOpenHashSet.this.n;
                longConsumer.accept(lArray[LongOpenHashSet.this.n]);
                --this.c;
            }
            while (this.c != 0) {
                if (--this.pos < 0) {
                    this.last = Integer.MIN_VALUE;
                    longConsumer.accept(this.wrapped.getLong(-this.pos - 1));
                    --this.c;
                    continue;
                }
                if (lArray[this.pos] == 0L) continue;
                this.last = this.pos;
                longConsumer.accept(lArray[this.last]);
                --this.c;
            }
        }
    }

    private final class SetSpliterator
    implements LongSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        int pos = 0;
        int max;
        int c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.max = LongOpenHashSet.this.n;
            this.c = 0;
            this.mustReturnNull = LongOpenHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int n, int n2, boolean bl, boolean bl2) {
            this.max = LongOpenHashSet.this.n;
            this.c = 0;
            this.mustReturnNull = LongOpenHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = n;
            this.max = n2;
            this.mustReturnNull = bl;
            this.hasSplit = bl2;
        }

        @Override
        public boolean tryAdvance(LongConsumer longConsumer) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                ++this.c;
                longConsumer.accept(LongOpenHashSet.this.key[LongOpenHashSet.this.n]);
                return true;
            }
            long[] lArray = LongOpenHashSet.this.key;
            while (this.pos < this.max) {
                if (lArray[this.pos] != 0L) {
                    ++this.c;
                    longConsumer.accept(lArray[this.pos++]);
                    return true;
                }
                ++this.pos;
            }
            return false;
        }

        @Override
        public void forEachRemaining(LongConsumer longConsumer) {
            long[] lArray = LongOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                longConsumer.accept(lArray[LongOpenHashSet.this.n]);
                ++this.c;
            }
            while (this.pos < this.max) {
                if (lArray[this.pos] != 0L) {
                    longConsumer.accept(lArray[this.pos]);
                    ++this.c;
                }
                ++this.pos;
            }
        }

        @Override
        public int characteristics() {
            return this.hasSplit ? 257 : 321;
        }

        @Override
        public long estimateSize() {
            if (!this.hasSplit) {
                return LongOpenHashSet.this.size - this.c;
            }
            return Math.min((long)(LongOpenHashSet.this.size - this.c), (long)((double)LongOpenHashSet.this.realSize() / (double)LongOpenHashSet.this.n * (double)(this.max - this.pos)) + (long)(this.mustReturnNull ? 1 : 0));
        }

        @Override
        public SetSpliterator trySplit() {
            if (this.pos >= this.max - 1) {
                return null;
            }
            int n = this.max - this.pos >> 1;
            if (n <= 1) {
                return null;
            }
            int n2 = this.pos + n;
            int n3 = this.pos;
            int n4 = n2;
            SetSpliterator setSpliterator = new SetSpliterator(n3, n4, this.mustReturnNull, true);
            this.pos = n2;
            this.mustReturnNull = false;
            this.hasSplit = true;
            return setSpliterator;
        }

        @Override
        public long skip(long l) {
            if (l < 0L) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + l);
            }
            if (l == 0L) {
                return 0L;
            }
            long l2 = 0L;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                ++l2;
                --l;
            }
            long[] lArray = LongOpenHashSet.this.key;
            while (this.pos < this.max && l > 0L) {
                if (lArray[this.pos++] == 0L) continue;
                ++l2;
                --l;
            }
            return l2;
        }
    }
}

