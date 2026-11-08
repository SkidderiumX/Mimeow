/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.Hash;
import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongSortedSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollections;
import com.viaversion.viaversion.libs.fastutil.longs.LongComparator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongListIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSortedSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
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

public class LongLinkedOpenHashSet
extends AbstractLongSortedSet
implements Serializable,
Cloneable,
Hash {
    private static final long serialVersionUID = 0L;
    private static final boolean ASSERTS = false;
    protected transient long[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected transient int first = -1;
    protected transient int last = -1;
    protected transient long[] link;
    protected transient int n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;
    protected final float f;
    private static final int SPLITERATOR_CHARACTERISTICS = 337;

    public LongLinkedOpenHashSet(int n, float f) {
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
        this.link = new long[this.n + 1];
    }

    public LongLinkedOpenHashSet(int n) {
        this(n, 0.75f);
    }

    public LongLinkedOpenHashSet() {
        this(16, 0.75f);
    }

    public LongLinkedOpenHashSet(Collection<? extends Long> collection, float f) {
        this(collection.size(), f);
        this.addAll(collection);
    }

    public LongLinkedOpenHashSet(Collection<? extends Long> collection) {
        this(collection, 0.75f);
    }

    public LongLinkedOpenHashSet(LongCollection longCollection, float f) {
        this(longCollection.size(), f);
        this.addAll(longCollection);
    }

    public LongLinkedOpenHashSet(LongCollection longCollection) {
        this(longCollection, 0.75f);
    }

    public LongLinkedOpenHashSet(LongIterator longIterator, float f) {
        this(16, f);
        while (longIterator.hasNext()) {
            this.add(longIterator.nextLong());
        }
    }

    public LongLinkedOpenHashSet(LongIterator longIterator) {
        this(longIterator, 0.75f);
    }

    public LongLinkedOpenHashSet(Iterator<?> iterator2, float f) {
        this(LongIterators.asLongIterator(iterator2), f);
    }

    public LongLinkedOpenHashSet(Iterator<?> iterator2) {
        this(LongIterators.asLongIterator(iterator2));
    }

    public LongLinkedOpenHashSet(long[] lArray, int n, int n2, float f) {
        this(n2 < 0 ? 0 : n2, f);
        LongArrays.ensureOffsetLength(lArray, n, n2);
        for (int i = 0; i < n2; ++i) {
            this.add(lArray[n + i]);
        }
    }

    public LongLinkedOpenHashSet(long[] lArray, int n, int n2) {
        this(lArray, n, n2, 0.75f);
    }

    public LongLinkedOpenHashSet(long[] lArray, float f) {
        this(lArray, 0, lArray.length, f);
    }

    public LongLinkedOpenHashSet(long[] lArray) {
        this(lArray, 0.75f);
    }

    public static LongLinkedOpenHashSet of() {
        return new LongLinkedOpenHashSet();
    }

    public static LongLinkedOpenHashSet of(long l) {
        LongLinkedOpenHashSet longLinkedOpenHashSet = new LongLinkedOpenHashSet(1, 0.75f);
        longLinkedOpenHashSet.add(l);
        return longLinkedOpenHashSet;
    }

    public static LongLinkedOpenHashSet of(long l, long l2) {
        LongLinkedOpenHashSet longLinkedOpenHashSet = new LongLinkedOpenHashSet(2, 0.75f);
        longLinkedOpenHashSet.add(l);
        if (!longLinkedOpenHashSet.add(l2)) {
            throw new IllegalArgumentException("Duplicate element: " + l2);
        }
        return longLinkedOpenHashSet;
    }

    public static LongLinkedOpenHashSet of(long l, long l2, long l3) {
        LongLinkedOpenHashSet longLinkedOpenHashSet = new LongLinkedOpenHashSet(3, 0.75f);
        longLinkedOpenHashSet.add(l);
        if (!longLinkedOpenHashSet.add(l2)) {
            throw new IllegalArgumentException("Duplicate element: " + l2);
        }
        if (!longLinkedOpenHashSet.add(l3)) {
            throw new IllegalArgumentException("Duplicate element: " + l3);
        }
        return longLinkedOpenHashSet;
    }

    public static LongLinkedOpenHashSet of(long ... lArray) {
        LongLinkedOpenHashSet longLinkedOpenHashSet = new LongLinkedOpenHashSet(lArray.length, 0.75f);
        for (long l : lArray) {
            if (longLinkedOpenHashSet.add(l)) continue;
            throw new IllegalArgumentException("Duplicate element " + l);
        }
        return longLinkedOpenHashSet;
    }

    public static LongLinkedOpenHashSet toSet(LongStream longStream) {
        return longStream.collect(LongLinkedOpenHashSet::new, LongLinkedOpenHashSet::add, LongLinkedOpenHashSet::addAll);
    }

    public static LongLinkedOpenHashSet toSetWithExpectedSize(LongStream longStream, int n2) {
        if (n2 <= 16) {
            return LongLinkedOpenHashSet.toSet(longStream);
        }
        return longStream.collect(new LongCollections.SizeDecreasingSupplier<LongLinkedOpenHashSet>(n2, n -> n <= 16 ? new LongLinkedOpenHashSet() : new LongLinkedOpenHashSet(n)), LongLinkedOpenHashSet::add, LongLinkedOpenHashSet::addAll);
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
        int n;
        if (l == 0L) {
            if (this.containsNull) {
                return false;
            }
            n = this.n;
            this.containsNull = true;
        } else {
            long[] lArray = this.key;
            n = (int)HashCommon.mix(l) & this.mask;
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
        if (this.size == 0) {
            this.first = this.last = n;
            this.link[n] = -1L;
        } else {
            int n2 = this.last;
            this.link[n2] = this.link[n2] ^ (this.link[this.last] ^ (long)n & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            this.link[n] = ((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL;
            this.last = n;
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
            this.fixPointers(n, n2);
        }
    }

    private boolean removeEntry(int n) {
        --this.size;
        this.fixPointers(n);
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
        this.fixPointers(this.n);
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

    public long removeFirstLong() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int n = this.first;
        if (this.size == 1) {
            this.last = -1;
            this.first = -1;
        } else {
            this.first = (int)this.link[n];
            if (0 <= this.first) {
                int n2 = this.first;
                this.link[n2] = this.link[n2] | 0xFFFFFFFF00000000L;
            }
        }
        long l = this.key[n];
        --this.size;
        if (l == 0L) {
            this.containsNull = false;
            this.key[this.n] = 0L;
        } else {
            this.shiftKeys(n);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return l;
    }

    public long removeLastLong() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int n = this.last;
        if (this.size == 1) {
            this.last = -1;
            this.first = -1;
        } else {
            this.last = (int)(this.link[n] >>> 32);
            if (0 <= this.last) {
                int n2 = this.last;
                this.link[n2] = this.link[n2] | 0xFFFFFFFFL;
            }
        }
        long l = this.key[n];
        --this.size;
        if (l == 0L) {
            this.containsNull = false;
            this.key[this.n] = 0L;
        } else {
            this.shiftKeys(n);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return l;
    }

    private void moveIndexToFirst(int n) {
        if (this.size == 1 || this.first == n) {
            return;
        }
        if (this.last == n) {
            int n2 = this.last = (int)(this.link[n] >>> 32);
            this.link[n2] = this.link[n2] | 0xFFFFFFFFL;
        } else {
            long l = this.link[n];
            int n3 = (int)(l >>> 32);
            int n4 = (int)l;
            int n5 = n3;
            this.link[n5] = this.link[n5] ^ (this.link[n3] ^ l & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            int n6 = n4;
            this.link[n6] = this.link[n6] ^ (this.link[n4] ^ l & 0xFFFFFFFF00000000L) & 0xFFFFFFFF00000000L;
        }
        int n7 = this.first;
        this.link[n7] = this.link[n7] ^ (this.link[this.first] ^ ((long)n & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
        this.link[n] = 0xFFFFFFFF00000000L | (long)this.first & 0xFFFFFFFFL;
        this.first = n;
    }

    private void moveIndexToLast(int n) {
        if (this.size == 1 || this.last == n) {
            return;
        }
        if (this.first == n) {
            int n2 = this.first = (int)this.link[n];
            this.link[n2] = this.link[n2] | 0xFFFFFFFF00000000L;
        } else {
            long l = this.link[n];
            int n3 = (int)(l >>> 32);
            int n4 = (int)l;
            int n5 = n3;
            this.link[n5] = this.link[n5] ^ (this.link[n3] ^ l & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            int n6 = n4;
            this.link[n6] = this.link[n6] ^ (this.link[n4] ^ l & 0xFFFFFFFF00000000L) & 0xFFFFFFFF00000000L;
        }
        int n7 = this.last;
        this.link[n7] = this.link[n7] ^ (this.link[this.last] ^ (long)n & 0xFFFFFFFFL) & 0xFFFFFFFFL;
        this.link[n] = ((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL;
        this.last = n;
    }

    public boolean addAndMoveToFirst(long l) {
        int n;
        if (l == 0L) {
            if (this.containsNull) {
                this.moveIndexToFirst(this.n);
                return false;
            }
            this.containsNull = true;
            n = this.n;
        } else {
            long[] lArray = this.key;
            n = (int)HashCommon.mix(l) & this.mask;
            while (lArray[n] != 0L) {
                if (l == lArray[n]) {
                    this.moveIndexToFirst(n);
                    return false;
                }
                n = n + 1 & this.mask;
            }
        }
        this.key[n] = l;
        if (this.size == 0) {
            this.first = this.last = n;
            this.link[n] = -1L;
        } else {
            int n2 = this.first;
            this.link[n2] = this.link[n2] ^ (this.link[this.first] ^ ((long)n & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
            this.link[n] = 0xFFFFFFFF00000000L | (long)this.first & 0xFFFFFFFFL;
            this.first = n;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return true;
    }

    public boolean addAndMoveToLast(long l) {
        int n;
        if (l == 0L) {
            if (this.containsNull) {
                this.moveIndexToLast(this.n);
                return false;
            }
            this.containsNull = true;
            n = this.n;
        } else {
            long[] lArray = this.key;
            n = (int)HashCommon.mix(l) & this.mask;
            while (lArray[n] != 0L) {
                if (l == lArray[n]) {
                    this.moveIndexToLast(n);
                    return false;
                }
                n = n + 1 & this.mask;
            }
        }
        this.key[n] = l;
        if (this.size == 0) {
            this.first = this.last = n;
            this.link[n] = -1L;
        } else {
            int n2 = this.last;
            this.link[n2] = this.link[n2] ^ (this.link[this.last] ^ (long)n & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            this.link[n] = ((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL;
            this.last = n;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
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
        this.last = -1;
        this.first = -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    protected void fixPointers(int n) {
        if (this.size == 0) {
            this.last = -1;
            this.first = -1;
            return;
        }
        if (this.first == n) {
            this.first = (int)this.link[n];
            if (0 <= this.first) {
                int n2 = this.first;
                this.link[n2] = this.link[n2] | 0xFFFFFFFF00000000L;
            }
            return;
        }
        if (this.last == n) {
            this.last = (int)(this.link[n] >>> 32);
            if (0 <= this.last) {
                int n3 = this.last;
                this.link[n3] = this.link[n3] | 0xFFFFFFFFL;
            }
            return;
        }
        long l = this.link[n];
        int n4 = (int)(l >>> 32);
        int n5 = (int)l;
        int n6 = n4;
        this.link[n6] = this.link[n6] ^ (this.link[n4] ^ l & 0xFFFFFFFFL) & 0xFFFFFFFFL;
        int n7 = n5;
        this.link[n7] = this.link[n7] ^ (this.link[n5] ^ l & 0xFFFFFFFF00000000L) & 0xFFFFFFFF00000000L;
    }

    protected void fixPointers(int n, int n2) {
        if (this.size == 1) {
            this.first = this.last = n2;
            this.link[n2] = -1L;
            return;
        }
        if (this.first == n) {
            this.first = n2;
            int n3 = (int)this.link[n];
            this.link[n3] = this.link[n3] ^ (this.link[(int)this.link[n]] ^ ((long)n2 & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
            this.link[n2] = this.link[n];
            return;
        }
        if (this.last == n) {
            this.last = n2;
            int n4 = (int)(this.link[n] >>> 32);
            this.link[n4] = this.link[n4] ^ (this.link[(int)(this.link[n] >>> 32)] ^ (long)n2 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            this.link[n2] = this.link[n];
            return;
        }
        long l = this.link[n];
        int n5 = (int)(l >>> 32);
        int n6 = (int)l;
        int n7 = n5;
        this.link[n7] = this.link[n7] ^ (this.link[n5] ^ (long)n2 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
        int n8 = n6;
        this.link[n8] = this.link[n8] ^ (this.link[n6] ^ ((long)n2 & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
        this.link[n2] = l;
    }

    @Override
    public long firstLong() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }

    @Override
    public long lastLong() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }

    @Override
    public LongSortedSet tailSet(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongSortedSet headSet(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongSortedSet subSet(long l, long l2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongComparator comparator() {
        return null;
    }

    @Override
    public LongListIterator iterator(long l) {
        return new SetIterator(l);
    }

    @Override
    public LongListIterator iterator() {
        return new SetIterator();
    }

    @Override
    public LongSpliterator spliterator() {
        return LongSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(this), 337);
    }

    @Override
    public void forEach(LongConsumer longConsumer) {
        int n = this.first;
        while (n != -1) {
            int n2 = n;
            n = (int)this.link[n2];
            longConsumer.accept(this.key[n2]);
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
        int n3 = this.first;
        int n4 = -1;
        int n5 = -1;
        long[] lArray3 = this.link;
        long[] lArray4 = new long[n + 1];
        this.first = -1;
        int n6 = this.size;
        while (n6-- != 0) {
            int n7;
            if (lArray[n3] == 0L) {
                n7 = n;
            } else {
                n7 = (int)HashCommon.mix(lArray[n3]) & n2;
                while (lArray2[n7] != 0L) {
                    n7 = n7 + 1 & n2;
                }
            }
            lArray2[n7] = lArray[n3];
            if (n4 != -1) {
                int n8 = n5;
                lArray4[n8] = lArray4[n8] ^ (lArray4[n5] ^ (long)n7 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
                int n9 = n7;
                lArray4[n9] = lArray4[n9] ^ (lArray4[n7] ^ ((long)n5 & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
                n5 = n7;
            } else {
                n5 = this.first = n7;
                lArray4[n7] = -1L;
            }
            int n10 = n3;
            n3 = (int)lArray3[n3];
            n4 = n10;
        }
        this.link = lArray4;
        this.last = n5;
        if (n5 != -1) {
            int n11 = n5;
            lArray4[n11] = lArray4[n11] | 0xFFFFFFFFL;
        }
        this.n = n;
        this.mask = n2;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lArray2;
    }

    public LongLinkedOpenHashSet clone() {
        LongLinkedOpenHashSet longLinkedOpenHashSet;
        try {
            longLinkedOpenHashSet = (LongLinkedOpenHashSet)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        longLinkedOpenHashSet.key = (long[])this.key.clone();
        longLinkedOpenHashSet.containsNull = this.containsNull;
        longLinkedOpenHashSet.link = (long[])this.link.clone();
        return longLinkedOpenHashSet;
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
        LongListIterator longListIterator = this.iterator();
        objectOutputStream.defaultWriteObject();
        int n = this.size;
        while (n-- != 0) {
            objectOutputStream.writeLong(longListIterator.nextLong());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        this.key = new long[this.n + 1];
        long[] lArray = this.key;
        this.link = new long[this.n + 1];
        long[] lArray2 = this.link;
        int n = -1;
        this.last = -1;
        this.first = -1;
        int n2 = this.size;
        while (n2-- != 0) {
            int n3;
            long l = objectInputStream.readLong();
            if (l == 0L) {
                n3 = this.n;
                this.containsNull = true;
            } else {
                n3 = (int)HashCommon.mix(l) & this.mask;
                if (lArray[n3] != 0L) {
                    while (lArray[n3 = n3 + 1 & this.mask] != 0L) {
                    }
                }
            }
            lArray[n3] = l;
            if (this.first != -1) {
                int n4 = n;
                lArray2[n4] = lArray2[n4] ^ (lArray2[n] ^ (long)n3 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
                int n5 = n3;
                lArray2[n5] = lArray2[n5] ^ (lArray2[n3] ^ ((long)n & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
                n = n3;
                continue;
            }
            n = this.first = n3;
            int n6 = n3;
            lArray2[n6] = lArray2[n6] | 0xFFFFFFFF00000000L;
        }
        this.last = n;
        if (n != -1) {
            int n7 = n;
            lArray2[n7] = lArray2[n7] | 0xFFFFFFFFL;
        }
    }

    private void checkTable() {
    }

    private final class SetIterator
    implements LongListIterator {
        int prev = -1;
        int next = -1;
        int curr = -1;
        int index = -1;

        SetIterator() {
            this.next = LongLinkedOpenHashSet.this.first;
            this.index = 0;
        }

        SetIterator(long l) {
            if (l == 0L) {
                if (LongLinkedOpenHashSet.this.containsNull) {
                    this.next = (int)LongLinkedOpenHashSet.this.link[LongLinkedOpenHashSet.this.n];
                    this.prev = LongLinkedOpenHashSet.this.n;
                    return;
                }
                throw new NoSuchElementException("The key " + l + " does not belong to this set.");
            }
            if (LongLinkedOpenHashSet.this.key[LongLinkedOpenHashSet.this.last] == l) {
                this.prev = LongLinkedOpenHashSet.this.last;
                this.index = LongLinkedOpenHashSet.this.size;
                return;
            }
            long[] lArray = LongLinkedOpenHashSet.this.key;
            int n = (int)HashCommon.mix(l) & LongLinkedOpenHashSet.this.mask;
            while (lArray[n] != 0L) {
                if (lArray[n] == l) {
                    this.next = (int)LongLinkedOpenHashSet.this.link[n];
                    this.prev = n;
                    return;
                }
                n = n + 1 & LongLinkedOpenHashSet.this.mask;
            }
            throw new NoSuchElementException("The key " + l + " does not belong to this set.");
        }

        @Override
        public boolean hasNext() {
            return this.next != -1;
        }

        @Override
        public boolean hasPrevious() {
            return this.prev != -1;
        }

        @Override
        public long nextLong() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)LongLinkedOpenHashSet.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                ++this.index;
            }
            return LongLinkedOpenHashSet.this.key[this.curr];
        }

        @Override
        public long previousLong() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(LongLinkedOpenHashSet.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return LongLinkedOpenHashSet.this.key[this.curr];
        }

        @Override
        public void forEachRemaining(LongConsumer longConsumer) {
            long[] lArray = LongLinkedOpenHashSet.this.key;
            long[] lArray2 = LongLinkedOpenHashSet.this.link;
            while (this.next != -1) {
                this.curr = this.next;
                this.next = (int)lArray2[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    ++this.index;
                }
                longConsumer.accept(lArray[this.curr]);
            }
        }

        private final void ensureIndexKnown() {
            if (this.index >= 0) {
                return;
            }
            if (this.prev == -1) {
                this.index = 0;
                return;
            }
            if (this.next == -1) {
                this.index = LongLinkedOpenHashSet.this.size;
                return;
            }
            int n = LongLinkedOpenHashSet.this.first;
            this.index = 1;
            while (n != this.prev) {
                n = (int)LongLinkedOpenHashSet.this.link[n];
                ++this.index;
            }
        }

        @Override
        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
        }

        @Override
        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }

        @Override
        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(LongLinkedOpenHashSet.this.link[this.curr] >>> 32);
            } else {
                this.next = (int)LongLinkedOpenHashSet.this.link[this.curr];
            }
            --LongLinkedOpenHashSet.this.size;
            if (this.prev == -1) {
                LongLinkedOpenHashSet.this.first = this.next;
            } else {
                int n = this.prev;
                LongLinkedOpenHashSet.this.link[n] = LongLinkedOpenHashSet.this.link[n] ^ (LongLinkedOpenHashSet.this.link[this.prev] ^ (long)this.next & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            }
            if (this.next == -1) {
                LongLinkedOpenHashSet.this.last = this.prev;
            } else {
                int n = this.next;
                LongLinkedOpenHashSet.this.link[n] = LongLinkedOpenHashSet.this.link[n] ^ (LongLinkedOpenHashSet.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
            }
            int n = this.curr;
            this.curr = -1;
            if (n != LongLinkedOpenHashSet.this.n) {
                long[] lArray = LongLinkedOpenHashSet.this.key;
                while (true) {
                    long l;
                    int n2 = n;
                    n = n2 + 1 & LongLinkedOpenHashSet.this.mask;
                    while (true) {
                        if ((l = lArray[n]) == 0L) {
                            lArray[n2] = 0L;
                            return;
                        }
                        int n3 = (int)HashCommon.mix(l) & LongLinkedOpenHashSet.this.mask;
                        if (n2 <= n ? n2 >= n3 || n3 > n : n2 >= n3 && n3 > n) break;
                        n = n + 1 & LongLinkedOpenHashSet.this.mask;
                    }
                    lArray[n2] = l;
                    if (this.next == n) {
                        this.next = n2;
                    }
                    if (this.prev == n) {
                        this.prev = n2;
                    }
                    LongLinkedOpenHashSet.this.fixPointers(n, n2);
                }
            }
            LongLinkedOpenHashSet.this.containsNull = false;
            LongLinkedOpenHashSet.this.key[LongLinkedOpenHashSet.this.n] = 0L;
        }
    }
}

