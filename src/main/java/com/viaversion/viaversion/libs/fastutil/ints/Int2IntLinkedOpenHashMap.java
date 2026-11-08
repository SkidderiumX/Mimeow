/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Hash;
import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.ints.AbstractInt2IntSortedMap;
import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntSortedSet;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntSortedMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.IntComparator;
import com.viaversion.viaversion.libs.fastutil.ints.IntIntPair;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntListIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSortedSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectSortedSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectListIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSortedSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class Int2IntLinkedOpenHashMap
extends AbstractInt2IntSortedMap
implements Serializable,
Cloneable,
Hash {
    private static final long serialVersionUID = 0L;
    private static final boolean ASSERTS = false;
    protected transient int[] key;
    protected transient int[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first = -1;
    protected transient int last = -1;
    protected transient long[] link;
    protected transient int n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;
    protected final float f;
    protected transient Int2IntSortedMap.FastSortedEntrySet entries;
    protected transient IntSortedSet keys;
    protected transient IntCollection values;

    public Int2IntLinkedOpenHashMap(int n, float f) {
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
        this.key = new int[this.n + 1];
        this.value = new int[this.n + 1];
        this.link = new long[this.n + 1];
    }

    public Int2IntLinkedOpenHashMap(int n) {
        this(n, 0.75f);
    }

    public Int2IntLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Int2IntLinkedOpenHashMap(Map<? extends Integer, ? extends Integer> map, float f) {
        this(map.size(), f);
        this.putAll(map);
    }

    public Int2IntLinkedOpenHashMap(Map<? extends Integer, ? extends Integer> map) {
        this(map, 0.75f);
    }

    public Int2IntLinkedOpenHashMap(Int2IntMap int2IntMap, float f) {
        this(int2IntMap.size(), f);
        this.putAll(int2IntMap);
    }

    public Int2IntLinkedOpenHashMap(Int2IntMap int2IntMap) {
        this(int2IntMap, 0.75f);
    }

    public Int2IntLinkedOpenHashMap(int[] nArray, int[] nArray2, float f) {
        this(nArray.length, f);
        if (nArray.length != nArray2.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + nArray.length + " and " + nArray2.length + ")");
        }
        for (int i = 0; i < nArray.length; ++i) {
            this.put(nArray[i], nArray2[i]);
        }
    }

    public Int2IntLinkedOpenHashMap(int[] nArray, int[] nArray2) {
        this(nArray, nArray2, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
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

    private int removeEntry(int n) {
        int n2 = this.value[n];
        --this.size;
        this.fixPointers(n);
        this.shiftKeys(n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return n2;
    }

    private int removeNullEntry() {
        this.containsNullKey = false;
        int n = this.value[this.n];
        --this.size;
        this.fixPointers(this.n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return n;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Integer> map) {
        if ((double)this.f <= 0.5) {
            this.ensureCapacity(map.size());
        } else {
            this.tryCapacity(this.size() + map.size());
        }
        super.putAll(map);
    }

    private int find(int n) {
        if (n == 0) {
            return this.containsNullKey ? this.n : -(this.n + 1);
        }
        int[] nArray = this.key;
        int n2 = HashCommon.mix(n) & this.mask;
        int n3 = nArray[n2];
        if (n3 == 0) {
            return -(n2 + 1);
        }
        if (n == n3) {
            return n2;
        }
        do {
            if ((n3 = nArray[n2 = n2 + 1 & this.mask]) != 0) continue;
            return -(n2 + 1);
        } while (n != n3);
        return n2;
    }

    private void insert(int n, int n2, int n3) {
        if (n == this.n) {
            this.containsNullKey = true;
        }
        this.key[n] = n2;
        this.value[n] = n3;
        if (this.size == 0) {
            this.first = this.last = n;
            this.link[n] = -1L;
        } else {
            int n4 = this.last;
            this.link[n4] = this.link[n4] ^ (this.link[this.last] ^ (long)n & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            this.link[n] = ((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL;
            this.last = n;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }

    @Override
    public int put(int n, int n2) {
        int n3 = this.find(n);
        if (n3 < 0) {
            this.insert(-n3 - 1, n, n2);
            return this.defRetValue;
        }
        int n4 = this.value[n3];
        this.value[n3] = n2;
        return n4;
    }

    private int addToValue(int n, int n2) {
        int n3 = this.value[n];
        this.value[n] = n3 + n2;
        return n3;
    }

    public int addTo(int n, int n2) {
        int n3;
        if (n == 0) {
            if (this.containsNullKey) {
                return this.addToValue(this.n, n2);
            }
            n3 = this.n;
            this.containsNullKey = true;
        } else {
            int[] nArray = this.key;
            n3 = HashCommon.mix(n) & this.mask;
            int n4 = nArray[n3];
            if (n4 != 0) {
                if (n4 == n) {
                    return this.addToValue(n3, n2);
                }
                while ((n4 = nArray[n3 = n3 + 1 & this.mask]) != 0) {
                    if (n4 != n) continue;
                    return this.addToValue(n3, n2);
                }
            }
        }
        this.key[n3] = n;
        this.value[n3] = this.defRetValue + n2;
        if (this.size == 0) {
            this.first = this.last = n3;
            this.link[n3] = -1L;
        } else {
            int n5 = this.last;
            this.link[n5] = this.link[n5] ^ (this.link[this.last] ^ (long)n3 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            this.link[n3] = ((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL;
            this.last = n3;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int n) {
        int[] nArray = this.key;
        int[] nArray2 = this.value;
        while (true) {
            int n2;
            int n3 = n;
            n = n3 + 1 & this.mask;
            while (true) {
                if ((n2 = nArray[n]) == 0) {
                    nArray[n3] = 0;
                    return;
                }
                int n4 = HashCommon.mix(n2) & this.mask;
                if (n3 <= n ? n3 >= n4 || n4 > n : n3 >= n4 && n4 > n) break;
                n = n + 1 & this.mask;
            }
            nArray[n3] = n2;
            nArray2[n3] = nArray2[n];
            this.fixPointers(n, n3);
        }
    }

    @Override
    public int remove(int n) {
        if (n == 0) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        int[] nArray = this.key;
        int n2 = HashCommon.mix(n) & this.mask;
        int n3 = nArray[n2];
        if (n3 == 0) {
            return this.defRetValue;
        }
        if (n == n3) {
            return this.removeEntry(n2);
        }
        do {
            if ((n3 = nArray[n2 = n2 + 1 & this.mask]) != 0) continue;
            return this.defRetValue;
        } while (n != n3);
        return this.removeEntry(n2);
    }

    private int setValue(int n, int n2) {
        int n3 = this.value[n];
        this.value[n] = n2;
        return n3;
    }

    public int removeFirstInt() {
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
        --this.size;
        int n3 = this.value[n];
        if (n == this.n) {
            this.containsNullKey = false;
        } else {
            this.shiftKeys(n);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return n3;
    }

    public int removeLastInt() {
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
        --this.size;
        int n3 = this.value[n];
        if (n == this.n) {
            this.containsNullKey = false;
        } else {
            this.shiftKeys(n);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return n3;
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

    public int getAndMoveToFirst(int n) {
        if (n == 0) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        int[] nArray = this.key;
        int n2 = HashCommon.mix(n) & this.mask;
        int n3 = nArray[n2];
        if (n3 == 0) {
            return this.defRetValue;
        }
        if (n == n3) {
            this.moveIndexToFirst(n2);
            return this.value[n2];
        }
        do {
            if ((n3 = nArray[n2 = n2 + 1 & this.mask]) != 0) continue;
            return this.defRetValue;
        } while (n != n3);
        this.moveIndexToFirst(n2);
        return this.value[n2];
    }

    public int getAndMoveToLast(int n) {
        if (n == 0) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        int[] nArray = this.key;
        int n2 = HashCommon.mix(n) & this.mask;
        int n3 = nArray[n2];
        if (n3 == 0) {
            return this.defRetValue;
        }
        if (n == n3) {
            this.moveIndexToLast(n2);
            return this.value[n2];
        }
        do {
            if ((n3 = nArray[n2 = n2 + 1 & this.mask]) != 0) continue;
            return this.defRetValue;
        } while (n != n3);
        this.moveIndexToLast(n2);
        return this.value[n2];
    }

    public int putAndMoveToFirst(int n, int n2) {
        int n3;
        if (n == 0) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.setValue(this.n, n2);
            }
            this.containsNullKey = true;
            n3 = this.n;
        } else {
            int[] nArray = this.key;
            n3 = HashCommon.mix(n) & this.mask;
            int n4 = nArray[n3];
            if (n4 != 0) {
                if (n4 == n) {
                    this.moveIndexToFirst(n3);
                    return this.setValue(n3, n2);
                }
                while ((n4 = nArray[n3 = n3 + 1 & this.mask]) != 0) {
                    if (n4 != n) continue;
                    this.moveIndexToFirst(n3);
                    return this.setValue(n3, n2);
                }
            }
        }
        this.key[n3] = n;
        this.value[n3] = n2;
        if (this.size == 0) {
            this.first = this.last = n3;
            this.link[n3] = -1L;
        } else {
            int n5 = this.first;
            this.link[n5] = this.link[n5] ^ (this.link[this.first] ^ ((long)n3 & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
            this.link[n3] = 0xFFFFFFFF00000000L | (long)this.first & 0xFFFFFFFFL;
            this.first = n3;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }

    public int putAndMoveToLast(int n, int n2) {
        int n3;
        if (n == 0) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.setValue(this.n, n2);
            }
            this.containsNullKey = true;
            n3 = this.n;
        } else {
            int[] nArray = this.key;
            n3 = HashCommon.mix(n) & this.mask;
            int n4 = nArray[n3];
            if (n4 != 0) {
                if (n4 == n) {
                    this.moveIndexToLast(n3);
                    return this.setValue(n3, n2);
                }
                while ((n4 = nArray[n3 = n3 + 1 & this.mask]) != 0) {
                    if (n4 != n) continue;
                    this.moveIndexToLast(n3);
                    return this.setValue(n3, n2);
                }
            }
        }
        this.key[n3] = n;
        this.value[n3] = n2;
        if (this.size == 0) {
            this.first = this.last = n3;
            this.link[n3] = -1L;
        } else {
            int n5 = this.last;
            this.link[n5] = this.link[n5] ^ (this.link[this.last] ^ (long)n3 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            this.link[n3] = ((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL;
            this.last = n3;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }

    @Override
    public int get(int n) {
        if (n == 0) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        int[] nArray = this.key;
        int n2 = HashCommon.mix(n) & this.mask;
        int n3 = nArray[n2];
        if (n3 == 0) {
            return this.defRetValue;
        }
        if (n == n3) {
            return this.value[n2];
        }
        do {
            if ((n3 = nArray[n2 = n2 + 1 & this.mask]) != 0) continue;
            return this.defRetValue;
        } while (n != n3);
        return this.value[n2];
    }

    @Override
    public boolean containsKey(int n) {
        if (n == 0) {
            return this.containsNullKey;
        }
        int[] nArray = this.key;
        int n2 = HashCommon.mix(n) & this.mask;
        int n3 = nArray[n2];
        if (n3 == 0) {
            return false;
        }
        if (n == n3) {
            return true;
        }
        do {
            if ((n3 = nArray[n2 = n2 + 1 & this.mask]) != 0) continue;
            return false;
        } while (n != n3);
        return true;
    }

    @Override
    public boolean containsValue(int n) {
        int[] nArray = this.key;
        int[] nArray2 = this.value;
        if (this.containsNullKey && nArray2[this.n] == n) {
            return true;
        }
        int n2 = this.n;
        while (n2-- != 0) {
            if (nArray[n2] == 0 || nArray2[n2] != n) continue;
            return true;
        }
        return false;
    }

    @Override
    public int getOrDefault(int n, int n2) {
        if (n == 0) {
            return this.containsNullKey ? this.value[this.n] : n2;
        }
        int[] nArray = this.key;
        int n3 = HashCommon.mix(n) & this.mask;
        int n4 = nArray[n3];
        if (n4 == 0) {
            return n2;
        }
        if (n == n4) {
            return this.value[n3];
        }
        do {
            if ((n4 = nArray[n3 = n3 + 1 & this.mask]) != 0) continue;
            return n2;
        } while (n != n4);
        return this.value[n3];
    }

    @Override
    public int putIfAbsent(int n, int n2) {
        int n3 = this.find(n);
        if (n3 >= 0) {
            return this.value[n3];
        }
        this.insert(-n3 - 1, n, n2);
        return this.defRetValue;
    }

    @Override
    public boolean remove(int n, int n2) {
        if (n == 0) {
            if (this.containsNullKey && n2 == this.value[this.n]) {
                this.removeNullEntry();
                return true;
            }
            return false;
        }
        int[] nArray = this.key;
        int n3 = HashCommon.mix(n) & this.mask;
        int n4 = nArray[n3];
        if (n4 == 0) {
            return false;
        }
        if (n == n4 && n2 == this.value[n3]) {
            this.removeEntry(n3);
            return true;
        }
        do {
            if ((n4 = nArray[n3 = n3 + 1 & this.mask]) != 0) continue;
            return false;
        } while (n != n4 || n2 != this.value[n3]);
        this.removeEntry(n3);
        return true;
    }

    @Override
    public boolean replace(int n, int n2, int n3) {
        int n4 = this.find(n);
        if (n4 < 0 || n2 != this.value[n4]) {
            return false;
        }
        this.value[n4] = n3;
        return true;
    }

    @Override
    public int replace(int n, int n2) {
        int n3 = this.find(n);
        if (n3 < 0) {
            return this.defRetValue;
        }
        int n4 = this.value[n3];
        this.value[n3] = n2;
        return n4;
    }

    @Override
    public int computeIfAbsent(int n, IntUnaryOperator intUnaryOperator) {
        Objects.requireNonNull(intUnaryOperator);
        int n2 = this.find(n);
        if (n2 >= 0) {
            return this.value[n2];
        }
        int n3 = intUnaryOperator.applyAsInt(n);
        this.insert(-n2 - 1, n, n3);
        return n3;
    }

    @Override
    public int computeIfAbsent(int n, Int2IntFunction int2IntFunction) {
        Objects.requireNonNull(int2IntFunction);
        int n2 = this.find(n);
        if (n2 >= 0) {
            return this.value[n2];
        }
        if (!int2IntFunction.containsKey(n)) {
            return this.defRetValue;
        }
        int n3 = int2IntFunction.get(n);
        this.insert(-n2 - 1, n, n3);
        return n3;
    }

    @Override
    public int computeIfAbsentNullable(int n, IntFunction<? extends Integer> intFunction) {
        Objects.requireNonNull(intFunction);
        int n2 = this.find(n);
        if (n2 >= 0) {
            return this.value[n2];
        }
        Integer n3 = intFunction.apply(n);
        if (n3 == null) {
            return this.defRetValue;
        }
        int n4 = n3;
        this.insert(-n2 - 1, n, n4);
        return n4;
    }

    @Override
    public int computeIfPresent(int n, BiFunction<? super Integer, ? super Integer, ? extends Integer> biFunction) {
        Objects.requireNonNull(biFunction);
        int n2 = this.find(n);
        if (n2 < 0) {
            return this.defRetValue;
        }
        Integer n3 = biFunction.apply((Integer)n, (Integer)this.value[n2]);
        if (n3 == null) {
            if (n == 0) {
                this.removeNullEntry();
            } else {
                this.removeEntry(n2);
            }
            return this.defRetValue;
        }
        this.value[n2] = n3;
        return this.value[n2];
    }

    @Override
    public int compute(int n, BiFunction<? super Integer, ? super Integer, ? extends Integer> biFunction) {
        Objects.requireNonNull(biFunction);
        int n2 = this.find(n);
        Integer n3 = biFunction.apply((Integer)n, n2 >= 0 ? Integer.valueOf(this.value[n2]) : null);
        if (n3 == null) {
            if (n2 >= 0) {
                if (n == 0) {
                    this.removeNullEntry();
                } else {
                    this.removeEntry(n2);
                }
            }
            return this.defRetValue;
        }
        int n4 = n3;
        if (n2 < 0) {
            this.insert(-n2 - 1, n, n4);
            return n4;
        }
        this.value[n2] = n4;
        return this.value[n2];
    }

    @Override
    public int merge(int n, int n2, BiFunction<? super Integer, ? super Integer, ? extends Integer> biFunction) {
        Objects.requireNonNull(biFunction);
        int n3 = this.find(n);
        if (n3 < 0) {
            if (n3 < 0) {
                this.insert(-n3 - 1, n, n2);
            } else {
                this.value[n3] = n2;
            }
            return n2;
        }
        Integer n4 = biFunction.apply((Integer)this.value[n3], (Integer)n2);
        if (n4 == null) {
            if (n == 0) {
                this.removeNullEntry();
            } else {
                this.removeEntry(n3);
            }
            return this.defRetValue;
        }
        this.value[n3] = n4;
        return this.value[n3];
    }

    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        Arrays.fill(this.key, 0);
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
    public int firstIntKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }

    @Override
    public int lastIntKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }

    @Override
    public Int2IntSortedMap tailMap(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Int2IntSortedMap headMap(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Int2IntSortedMap subMap(int n, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntComparator comparator() {
        return null;
    }

    @Override
    public Int2IntSortedMap.FastSortedEntrySet int2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    @Override
    public IntSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    @Override
    public IntCollection values() {
        if (this.values == null) {
            this.values = new AbstractIntCollection(){
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override
                public IntIterator iterator() {
                    return new ValueIterator();
                }

                @Override
                public IntSpliterator spliterator() {
                    return IntSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(Int2IntLinkedOpenHashMap.this), 336);
                }

                @Override
                public void forEach(IntConsumer intConsumer) {
                    long[] lArray = Int2IntLinkedOpenHashMap.this.link;
                    int[] nArray = Int2IntLinkedOpenHashMap.this.value;
                    int n = Int2IntLinkedOpenHashMap.this.size;
                    int n2 = Int2IntLinkedOpenHashMap.this.first;
                    while (n-- != 0) {
                        int n3 = n2;
                        n2 = (int)lArray[n3];
                        intConsumer.accept(nArray[n3]);
                    }
                }

                @Override
                public int size() {
                    return Int2IntLinkedOpenHashMap.this.size;
                }

                @Override
                public boolean contains(int n) {
                    return Int2IntLinkedOpenHashMap.this.containsValue(n);
                }

                @Override
                public void clear() {
                    Int2IntLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
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
        int[] nArray = this.key;
        int[] nArray2 = this.value;
        int n2 = n - 1;
        int[] nArray3 = new int[n + 1];
        int[] nArray4 = new int[n + 1];
        int n3 = this.first;
        int n4 = -1;
        int n5 = -1;
        long[] lArray = this.link;
        long[] lArray2 = new long[n + 1];
        this.first = -1;
        int n6 = this.size;
        while (n6-- != 0) {
            int n7;
            if (nArray[n3] == 0) {
                n7 = n;
            } else {
                n7 = HashCommon.mix(nArray[n3]) & n2;
                while (nArray3[n7] != 0) {
                    n7 = n7 + 1 & n2;
                }
            }
            nArray3[n7] = nArray[n3];
            nArray4[n7] = nArray2[n3];
            if (n4 != -1) {
                int n8 = n5;
                lArray2[n8] = lArray2[n8] ^ (lArray2[n5] ^ (long)n7 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
                int n9 = n7;
                lArray2[n9] = lArray2[n9] ^ (lArray2[n7] ^ ((long)n5 & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
                n5 = n7;
            } else {
                n5 = this.first = n7;
                lArray2[n7] = -1L;
            }
            int n10 = n3;
            n3 = (int)lArray[n3];
            n4 = n10;
        }
        this.link = lArray2;
        this.last = n5;
        if (n5 != -1) {
            int n11 = n5;
            lArray2[n11] = lArray2[n11] | 0xFFFFFFFFL;
        }
        this.n = n;
        this.mask = n2;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = nArray3;
        this.value = nArray4;
    }

    public Int2IntLinkedOpenHashMap clone() {
        Int2IntLinkedOpenHashMap int2IntLinkedOpenHashMap;
        try {
            int2IntLinkedOpenHashMap = (Int2IntLinkedOpenHashMap)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        int2IntLinkedOpenHashMap.keys = null;
        int2IntLinkedOpenHashMap.values = null;
        int2IntLinkedOpenHashMap.entries = null;
        int2IntLinkedOpenHashMap.containsNullKey = this.containsNullKey;
        int2IntLinkedOpenHashMap.key = (int[])this.key.clone();
        int2IntLinkedOpenHashMap.value = (int[])this.value.clone();
        int2IntLinkedOpenHashMap.link = (long[])this.link.clone();
        return int2IntLinkedOpenHashMap;
    }

    @Override
    public int hashCode() {
        int n = 0;
        int[] nArray = this.key;
        int[] nArray2 = this.value;
        int n2 = this.realSize();
        int n3 = 0;
        int n4 = 0;
        while (n2-- != 0) {
            while (nArray[n3] == 0) {
                ++n3;
            }
            n4 = nArray[n3];
            n += (n4 ^= nArray2[n3]);
            ++n3;
        }
        if (this.containsNullKey) {
            n += nArray2[this.n];
        }
        return n;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int[] nArray = this.key;
        int[] nArray2 = this.value;
        EntryIterator entryIterator = new EntryIterator();
        objectOutputStream.defaultWriteObject();
        int n = this.size;
        while (n-- != 0) {
            int n2 = entryIterator.nextEntry();
            objectOutputStream.writeInt(nArray[n2]);
            objectOutputStream.writeInt(nArray2[n2]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        this.key = new int[this.n + 1];
        int[] nArray = this.key;
        this.value = new int[this.n + 1];
        int[] nArray2 = this.value;
        this.link = new long[this.n + 1];
        long[] lArray = this.link;
        int n = -1;
        this.last = -1;
        this.first = -1;
        int n2 = this.size;
        while (n2-- != 0) {
            int n3;
            int n4 = objectInputStream.readInt();
            int n5 = objectInputStream.readInt();
            if (n4 == 0) {
                n3 = this.n;
                this.containsNullKey = true;
            } else {
                n3 = HashCommon.mix(n4) & this.mask;
                while (nArray[n3] != 0) {
                    n3 = n3 + 1 & this.mask;
                }
            }
            nArray[n3] = n4;
            nArray2[n3] = n5;
            if (this.first != -1) {
                int n6 = n;
                lArray[n6] = lArray[n6] ^ (lArray[n] ^ (long)n3 & 0xFFFFFFFFL) & 0xFFFFFFFFL;
                int n7 = n3;
                lArray[n7] = lArray[n7] ^ (lArray[n3] ^ ((long)n & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
                n = n3;
                continue;
            }
            n = this.first = n3;
            int n8 = n3;
            lArray[n8] = lArray[n8] | 0xFFFFFFFF00000000L;
        }
        this.last = n;
        if (n != -1) {
            int n9 = n;
            lArray[n9] = lArray[n9] | 0xFFFFFFFFL;
        }
    }

    private void checkTable() {
    }

    private final class MapEntrySet
    extends AbstractObjectSortedSet<Int2IntMap.Entry>
    implements Int2IntSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override
        public ObjectBidirectionalIterator<Int2IntMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override
        public ObjectSpliterator<Int2IntMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(Int2IntLinkedOpenHashMap.this), 81);
        }

        @Override
        public Comparator<? super Int2IntMap.Entry> comparator() {
            return null;
        }

        @Override
        public ObjectSortedSet<Int2IntMap.Entry> subSet(Int2IntMap.Entry entry, Int2IntMap.Entry entry2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ObjectSortedSet<Int2IntMap.Entry> headSet(Int2IntMap.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ObjectSortedSet<Int2IntMap.Entry> tailSet(Int2IntMap.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Int2IntMap.Entry first() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Int2IntLinkedOpenHashMap.this.first);
        }

        @Override
        public Int2IntMap.Entry last() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Int2IntLinkedOpenHashMap.this.last);
        }

        @Override
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            if (entry.getKey() == null || !(entry.getKey() instanceof Integer)) {
                return false;
            }
            if (entry.getValue() == null || !(entry.getValue() instanceof Integer)) {
                return false;
            }
            int n = (Integer)entry.getKey();
            int n2 = (Integer)entry.getValue();
            if (n == 0) {
                return Int2IntLinkedOpenHashMap.this.containsNullKey && Int2IntLinkedOpenHashMap.this.value[Int2IntLinkedOpenHashMap.this.n] == n2;
            }
            int[] nArray = Int2IntLinkedOpenHashMap.this.key;
            int n3 = HashCommon.mix(n) & Int2IntLinkedOpenHashMap.this.mask;
            int n4 = nArray[n3];
            if (n4 == 0) {
                return false;
            }
            if (n == n4) {
                return Int2IntLinkedOpenHashMap.this.value[n3] == n2;
            }
            do {
                if ((n4 = nArray[n3 = n3 + 1 & Int2IntLinkedOpenHashMap.this.mask]) != 0) continue;
                return false;
            } while (n != n4);
            return Int2IntLinkedOpenHashMap.this.value[n3] == n2;
        }

        @Override
        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            if (entry.getKey() == null || !(entry.getKey() instanceof Integer)) {
                return false;
            }
            if (entry.getValue() == null || !(entry.getValue() instanceof Integer)) {
                return false;
            }
            int n = (Integer)entry.getKey();
            int n2 = (Integer)entry.getValue();
            if (n == 0) {
                if (Int2IntLinkedOpenHashMap.this.containsNullKey && Int2IntLinkedOpenHashMap.this.value[Int2IntLinkedOpenHashMap.this.n] == n2) {
                    Int2IntLinkedOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            int[] nArray = Int2IntLinkedOpenHashMap.this.key;
            int n3 = HashCommon.mix(n) & Int2IntLinkedOpenHashMap.this.mask;
            int n4 = nArray[n3];
            if (n4 == 0) {
                return false;
            }
            if (n4 == n) {
                if (Int2IntLinkedOpenHashMap.this.value[n3] == n2) {
                    Int2IntLinkedOpenHashMap.this.removeEntry(n3);
                    return true;
                }
                return false;
            }
            do {
                if ((n4 = nArray[n3 = n3 + 1 & Int2IntLinkedOpenHashMap.this.mask]) != 0) continue;
                return false;
            } while (n4 != n || Int2IntLinkedOpenHashMap.this.value[n3] != n2);
            Int2IntLinkedOpenHashMap.this.removeEntry(n3);
            return true;
        }

        @Override
        public int size() {
            return Int2IntLinkedOpenHashMap.this.size;
        }

        @Override
        public void clear() {
            Int2IntLinkedOpenHashMap.this.clear();
        }

        @Override
        public ObjectListIterator<Int2IntMap.Entry> iterator(Int2IntMap.Entry entry) {
            return new EntryIterator(entry.getIntKey());
        }

        @Override
        public ObjectListIterator<Int2IntMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        public ObjectListIterator<Int2IntMap.Entry> fastIterator(Int2IntMap.Entry entry) {
            return new FastEntryIterator(entry.getIntKey());
        }

        @Override
        public void forEach(Consumer<? super Int2IntMap.Entry> consumer) {
            long[] lArray = Int2IntLinkedOpenHashMap.this.link;
            int n = Int2IntLinkedOpenHashMap.this.size;
            int n2 = Int2IntLinkedOpenHashMap.this.first;
            while (n-- != 0) {
                int n3 = n2;
                n2 = (int)lArray[n3];
                consumer.accept(new MapEntry(n3));
            }
        }

        @Override
        public void fastForEach(Consumer<? super Int2IntMap.Entry> consumer) {
            MapEntry mapEntry = new MapEntry();
            long[] lArray = Int2IntLinkedOpenHashMap.this.link;
            int n = Int2IntLinkedOpenHashMap.this.size;
            int n2 = Int2IntLinkedOpenHashMap.this.first;
            while (n-- != 0) {
                mapEntry.index = n2;
                n2 = (int)lArray[n2];
                consumer.accept(mapEntry);
            }
        }
    }

    private final class KeySet
    extends AbstractIntSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override
        public IntListIterator iterator(int n) {
            return new KeyIterator(n);
        }

        @Override
        public IntListIterator iterator() {
            return new KeyIterator();
        }

        @Override
        public IntSpliterator spliterator() {
            return IntSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(Int2IntLinkedOpenHashMap.this), 337);
        }

        @Override
        public void forEach(IntConsumer intConsumer) {
            long[] lArray = Int2IntLinkedOpenHashMap.this.link;
            int[] nArray = Int2IntLinkedOpenHashMap.this.key;
            int n = Int2IntLinkedOpenHashMap.this.size;
            int n2 = Int2IntLinkedOpenHashMap.this.first;
            while (n-- != 0) {
                int n3 = n2;
                n2 = (int)lArray[n3];
                intConsumer.accept(nArray[n3]);
            }
        }

        @Override
        public int size() {
            return Int2IntLinkedOpenHashMap.this.size;
        }

        @Override
        public boolean contains(int n) {
            return Int2IntLinkedOpenHashMap.this.containsKey(n);
        }

        @Override
        public boolean remove(int n) {
            int n2 = Int2IntLinkedOpenHashMap.this.size;
            Int2IntLinkedOpenHashMap.this.remove(n);
            return Int2IntLinkedOpenHashMap.this.size != n2;
        }

        @Override
        public void clear() {
            Int2IntLinkedOpenHashMap.this.clear();
        }

        @Override
        public int firstInt() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Int2IntLinkedOpenHashMap.this.key[Int2IntLinkedOpenHashMap.this.first];
        }

        @Override
        public int lastInt() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Int2IntLinkedOpenHashMap.this.key[Int2IntLinkedOpenHashMap.this.last];
        }

        @Override
        public IntComparator comparator() {
            return null;
        }

        @Override
        public IntSortedSet tailSet(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public IntSortedSet headSet(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public IntSortedSet subSet(int n, int n2) {
            throw new UnsupportedOperationException();
        }
    }

    private final class EntryIterator
    extends MapIterator<Consumer<? super Int2IntMap.Entry>>
    implements ObjectListIterator<Int2IntMap.Entry> {
        private MapEntry entry;

        public EntryIterator() {
        }

        public EntryIterator(int n) {
            super(n);
        }

        @Override
        final void acceptOnIndex(Consumer<? super Int2IntMap.Entry> consumer, int n) {
            consumer.accept(new MapEntry(n));
        }

        @Override
        public MapEntry next() {
            this.entry = new MapEntry(this.nextEntry());
            return this.entry;
        }

        @Override
        public MapEntry previous() {
            this.entry = new MapEntry(this.previousEntry());
            return this.entry;
        }

        @Override
        public void remove() {
            super.remove();
            this.entry.index = -1;
        }
    }

    private final class ValueIterator
    extends MapIterator<IntConsumer>
    implements IntListIterator {
        @Override
        public int previousInt() {
            return Int2IntLinkedOpenHashMap.this.value[this.previousEntry()];
        }

        @Override
        final void acceptOnIndex(IntConsumer intConsumer, int n) {
            intConsumer.accept(Int2IntLinkedOpenHashMap.this.value[n]);
        }

        @Override
        public int nextInt() {
            return Int2IntLinkedOpenHashMap.this.value[this.nextEntry()];
        }
    }

    private final class KeyIterator
    extends MapIterator<IntConsumer>
    implements IntListIterator {
        public KeyIterator(int n) {
            super(n);
        }

        @Override
        public int previousInt() {
            return Int2IntLinkedOpenHashMap.this.key[this.previousEntry()];
        }

        public KeyIterator() {
        }

        @Override
        final void acceptOnIndex(IntConsumer intConsumer, int n) {
            intConsumer.accept(Int2IntLinkedOpenHashMap.this.key[n]);
        }

        @Override
        public int nextInt() {
            return Int2IntLinkedOpenHashMap.this.key[this.nextEntry()];
        }
    }

    private final class FastEntryIterator
    extends MapIterator<Consumer<? super Int2IntMap.Entry>>
    implements ObjectListIterator<Int2IntMap.Entry> {
        final MapEntry entry;

        public FastEntryIterator() {
            this.entry = new MapEntry();
        }

        public FastEntryIterator(int n) {
            super(n);
            this.entry = new MapEntry();
        }

        @Override
        final void acceptOnIndex(Consumer<? super Int2IntMap.Entry> consumer, int n) {
            this.entry.index = n;
            consumer.accept(this.entry);
        }

        @Override
        public MapEntry next() {
            this.entry.index = this.nextEntry();
            return this.entry;
        }

        @Override
        public MapEntry previous() {
            this.entry.index = this.previousEntry();
            return this.entry;
        }
    }

    private abstract class MapIterator<ConsumerType> {
        int prev = -1;
        int next = -1;
        int curr = -1;
        int index = -1;

        abstract void acceptOnIndex(ConsumerType var1, int var2);

        protected MapIterator() {
            this.next = Int2IntLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(int n) {
            if (n == 0) {
                if (Int2IntLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int)Int2IntLinkedOpenHashMap.this.link[Int2IntLinkedOpenHashMap.this.n];
                    this.prev = Int2IntLinkedOpenHashMap.this.n;
                    return;
                }
                throw new NoSuchElementException("The key " + n + " does not belong to this map.");
            }
            if (Int2IntLinkedOpenHashMap.this.key[Int2IntLinkedOpenHashMap.this.last] == n) {
                this.prev = Int2IntLinkedOpenHashMap.this.last;
                this.index = Int2IntLinkedOpenHashMap.this.size;
                return;
            }
            int n2 = HashCommon.mix(n) & Int2IntLinkedOpenHashMap.this.mask;
            while (Int2IntLinkedOpenHashMap.this.key[n2] != 0) {
                if (Int2IntLinkedOpenHashMap.this.key[n2] == n) {
                    this.next = (int)Int2IntLinkedOpenHashMap.this.link[n2];
                    this.prev = n2;
                    return;
                }
                n2 = n2 + 1 & Int2IntLinkedOpenHashMap.this.mask;
            }
            throw new NoSuchElementException("The key " + n + " does not belong to this map.");
        }

        public boolean hasNext() {
            return this.next != -1;
        }

        public boolean hasPrevious() {
            return this.prev != -1;
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
                this.index = Int2IntLinkedOpenHashMap.this.size;
                return;
            }
            int n = Int2IntLinkedOpenHashMap.this.first;
            this.index = 1;
            while (n != this.prev) {
                n = (int)Int2IntLinkedOpenHashMap.this.link[n];
                ++this.index;
            }
        }

        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
        }

        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }

        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)Int2IntLinkedOpenHashMap.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                ++this.index;
            }
            return this.curr;
        }

        public int previousEntry() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(Int2IntLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType ConsumerType) {
            while (this.hasNext()) {
                this.curr = this.next;
                this.next = (int)Int2IntLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    ++this.index;
                }
                this.acceptOnIndex(ConsumerType, this.curr);
            }
        }

        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(Int2IntLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int)Int2IntLinkedOpenHashMap.this.link[this.curr];
            }
            --Int2IntLinkedOpenHashMap.this.size;
            if (this.prev == -1) {
                Int2IntLinkedOpenHashMap.this.first = this.next;
            } else {
                int n = this.prev;
                Int2IntLinkedOpenHashMap.this.link[n] = Int2IntLinkedOpenHashMap.this.link[n] ^ (Int2IntLinkedOpenHashMap.this.link[this.prev] ^ (long)this.next & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            }
            if (this.next == -1) {
                Int2IntLinkedOpenHashMap.this.last = this.prev;
            } else {
                int n = this.next;
                Int2IntLinkedOpenHashMap.this.link[n] = Int2IntLinkedOpenHashMap.this.link[n] ^ (Int2IntLinkedOpenHashMap.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L;
            }
            int n = this.curr;
            this.curr = -1;
            if (n != Int2IntLinkedOpenHashMap.this.n) {
                int[] nArray = Int2IntLinkedOpenHashMap.this.key;
                int[] nArray2 = Int2IntLinkedOpenHashMap.this.value;
                while (true) {
                    int n2;
                    int n3 = n;
                    n = n3 + 1 & Int2IntLinkedOpenHashMap.this.mask;
                    while (true) {
                        if ((n2 = nArray[n]) == 0) {
                            nArray[n3] = 0;
                            return;
                        }
                        int n4 = HashCommon.mix(n2) & Int2IntLinkedOpenHashMap.this.mask;
                        if (n3 <= n ? n3 >= n4 || n4 > n : n3 >= n4 && n4 > n) break;
                        n = n + 1 & Int2IntLinkedOpenHashMap.this.mask;
                    }
                    nArray[n3] = n2;
                    nArray2[n3] = nArray2[n];
                    if (this.next == n) {
                        this.next = n3;
                    }
                    if (this.prev == n) {
                        this.prev = n3;
                    }
                    Int2IntLinkedOpenHashMap.this.fixPointers(n, n3);
                }
            }
            Int2IntLinkedOpenHashMap.this.containsNullKey = false;
        }

        public int skip(int n) {
            int n2 = n;
            while (n2-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return n - n2 - 1;
        }

        public int back(int n) {
            int n2 = n;
            while (n2-- != 0 && this.hasPrevious()) {
                this.previousEntry();
            }
            return n - n2 - 1;
        }

        public void set(Int2IntMap.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public void add(Int2IntMap.Entry entry) {
            throw new UnsupportedOperationException();
        }
    }

    public final class MapEntry
    implements Int2IntMap.Entry,
    Map.Entry<Integer, Integer>,
    IntIntPair {
        int index;

        MapEntry(int n) {
            this.index = n;
        }

        MapEntry() {
        }

        @Override
        public int getIntKey() {
            return Int2IntLinkedOpenHashMap.this.key[this.index];
        }

        @Override
        public int leftInt() {
            return Int2IntLinkedOpenHashMap.this.key[this.index];
        }

        @Override
        public int getIntValue() {
            return Int2IntLinkedOpenHashMap.this.value[this.index];
        }

        @Override
        public int rightInt() {
            return Int2IntLinkedOpenHashMap.this.value[this.index];
        }

        @Override
        public int setValue(int n) {
            int n2 = Int2IntLinkedOpenHashMap.this.value[this.index];
            Int2IntLinkedOpenHashMap.this.value[this.index] = n;
            return n2;
        }

        @Override
        public IntIntPair right(int n) {
            Int2IntLinkedOpenHashMap.this.value[this.index] = n;
            return this;
        }

        @Override
        @Deprecated
        public Integer getKey() {
            return Int2IntLinkedOpenHashMap.this.key[this.index];
        }

        @Override
        @Deprecated
        public Integer getValue() {
            return Int2IntLinkedOpenHashMap.this.value[this.index];
        }

        @Override
        @Deprecated
        public Integer setValue(Integer n) {
            return this.setValue((int)n);
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            return Int2IntLinkedOpenHashMap.this.key[this.index] == (Integer)entry.getKey() && Int2IntLinkedOpenHashMap.this.value[this.index] == (Integer)entry.getValue();
        }

        @Override
        public int hashCode() {
            return Int2IntLinkedOpenHashMap.this.key[this.index] ^ Int2IntLinkedOpenHashMap.this.value[this.index];
        }

        public String toString() {
            return Int2IntLinkedOpenHashMap.this.key[this.index] + "=>" + Int2IntLinkedOpenHashMap.this.value[this.index];
        }
    }
}

