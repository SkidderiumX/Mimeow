/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.BigArrays;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrays;
import com.viaversion.viaversion.libs.fastutil.ints.IntBigArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectList;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class IntArrayFrontCodedList
extends AbstractObjectList<int[]>
implements Serializable,
Cloneable,
RandomAccess {
    private static final long serialVersionUID = 1L;
    protected final int n;
    protected final int ratio;
    protected final int[][] array;
    protected transient long[] p;

    public IntArrayFrontCodedList(Iterator<int[]> iterator2, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Illegal ratio (" + n + ")");
        }
        int[][] nArray = IntBigArrays.EMPTY_BIG_ARRAY;
        long[] lArray = LongArrays.EMPTY_ARRAY;
        int[][] nArrayArray = new int[2][];
        long l = 0L;
        int n2 = 0;
        int n3 = 0;
        while (iterator2.hasNext()) {
            nArrayArray[n3] = iterator2.next();
            int n4 = nArrayArray[n3].length;
            if (n2 % n == 0) {
                lArray = LongArrays.grow(lArray, n2 / n + 1);
                lArray[n2 / n] = l;
                nArray = BigArrays.grow((int[][])nArray, (long)(l + (long)IntArrayFrontCodedList.count(n4) + (long)n4), (long)l);
                l += (long)IntArrayFrontCodedList.writeInt(nArray, n4, l);
                BigArrays.copyToBig((int[])nArrayArray[n3], (int)0, (int[][])nArray, (long)l, (long)n4);
                l += (long)n4;
            } else {
                int n5;
                int n6 = Math.min(nArrayArray[1 - n3].length, n4);
                for (n5 = 0; n5 < n6 && nArrayArray[0][n5] == nArrayArray[1][n5]; ++n5) {
                }
                nArray = BigArrays.grow((int[][])nArray, (long)(l + (long)IntArrayFrontCodedList.count(n4 -= n5) + (long)IntArrayFrontCodedList.count(n5) + (long)n4), (long)l);
                l += (long)IntArrayFrontCodedList.writeInt(nArray, n4, l);
                l += (long)IntArrayFrontCodedList.writeInt(nArray, n5, l);
                BigArrays.copyToBig((int[])nArrayArray[n3], (int)n5, (int[][])nArray, (long)l, (long)n4);
                l += (long)n4;
            }
            n3 = 1 - n3;
            ++n2;
        }
        this.n = n2;
        this.ratio = n;
        this.array = BigArrays.trim((int[][])nArray, (long)l);
        this.p = LongArrays.trim(lArray, (n2 + n - 1) / n);
    }

    public IntArrayFrontCodedList(Collection<int[]> collection, int n) {
        this(collection.iterator(), n);
    }

    static int readInt(int[][] nArray, long l) {
        return BigArrays.get((int[][])nArray, (long)l);
    }

    static int count(int n) {
        return 1;
    }

    static int writeInt(int[][] nArray, int n, long l) {
        BigArrays.set((int[][])nArray, (long)l, (int)n);
        return 1;
    }

    public int ratio() {
        return this.ratio;
    }

    private int length(int n) {
        int[][] nArray = this.array;
        int n2 = n % this.ratio;
        long l = this.p[n / this.ratio];
        int n3 = IntArrayFrontCodedList.readInt(nArray, l);
        if (n2 == 0) {
            return n3;
        }
        l += (long)(IntArrayFrontCodedList.count(n3) + n3);
        n3 = IntArrayFrontCodedList.readInt(nArray, l);
        int n4 = IntArrayFrontCodedList.readInt(nArray, l + (long)IntArrayFrontCodedList.count(n3));
        for (int i = 0; i < n2 - 1; ++i) {
            n3 = IntArrayFrontCodedList.readInt(nArray, l += (long)(IntArrayFrontCodedList.count(n3) + IntArrayFrontCodedList.count(n4) + n3));
            n4 = IntArrayFrontCodedList.readInt(nArray, l + (long)IntArrayFrontCodedList.count(n3));
        }
        return n3 + n4;
    }

    public int arrayLength(int n) {
        this.ensureRestrictedIndex(n);
        return this.length(n);
    }

    private int extract(int n, int[] nArray, int n2, int n3) {
        long l;
        int n4 = n % this.ratio;
        long l2 = l = this.p[n / this.ratio];
        int n5 = IntArrayFrontCodedList.readInt(this.array, l2);
        int n6 = 0;
        if (n4 == 0) {
            l2 = this.p[n / this.ratio] + (long)IntArrayFrontCodedList.count(n5);
            BigArrays.copyFromBig((int[][])this.array, (long)l2, (int[])nArray, (int)n2, (int)Math.min(n3, n5));
            return n5;
        }
        int n7 = 0;
        for (int i = 0; i < n4; ++i) {
            long l3 = l2 + (long)IntArrayFrontCodedList.count(n5) + (long)(i != 0 ? IntArrayFrontCodedList.count(n7) : 0);
            n7 = IntArrayFrontCodedList.readInt(this.array, (l2 = l3 + (long)n5) + (long)IntArrayFrontCodedList.count(n5 = IntArrayFrontCodedList.readInt(this.array, l2)));
            int n8 = Math.min(n7, n3);
            if (n8 <= n6) {
                n6 = n8;
                continue;
            }
            BigArrays.copyFromBig((int[][])this.array, (long)l3, (int[])nArray, (int)(n6 + n2), (int)(n8 - n6));
            n6 = n8;
        }
        if (n6 < n3) {
            BigArrays.copyFromBig((int[][])this.array, (long)(l2 + (long)IntArrayFrontCodedList.count(n5) + (long)IntArrayFrontCodedList.count(n7)), (int[])nArray, (int)(n6 + n2), (int)Math.min(n5, n3 - n6));
        }
        return n5 + n7;
    }

    @Override
    public int[] get(int n) {
        return this.getArray(n);
    }

    public int[] getArray(int n) {
        this.ensureRestrictedIndex(n);
        int n2 = this.length(n);
        int[] nArray = new int[n2];
        this.extract(n, nArray, 0, n2);
        return nArray;
    }

    public int get(int n, int[] nArray, int n2, int n3) {
        this.ensureRestrictedIndex(n);
        IntArrays.ensureOffsetLength(nArray, n2, n3);
        int n4 = this.extract(n, nArray, n2, n3);
        if (n3 >= n4) {
            return n4;
        }
        return n3 - n4;
    }

    public int get(int n, int[] nArray) {
        return this.get(n, nArray, 0, nArray.length);
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public ObjectListIterator<int[]> listIterator(final int n) {
        this.ensureIndex(n);
        return new ObjectListIterator<int[]>(){
            int[] s = IntArrays.EMPTY_ARRAY;
            int i = 0;
            long pos = 0L;
            boolean inSync;
            {
                if (n != 0) {
                    if (n == IntArrayFrontCodedList.this.n) {
                        this.i = n;
                    } else {
                        this.pos = IntArrayFrontCodedList.this.p[n / IntArrayFrontCodedList.this.ratio];
                        int n2 = n % IntArrayFrontCodedList.this.ratio;
                        this.i = n - n2;
                        while (n2-- != 0) {
                            this.next();
                        }
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return this.i < IntArrayFrontCodedList.this.n;
            }

            @Override
            public boolean hasPrevious() {
                return this.i > 0;
            }

            @Override
            public int previousIndex() {
                return this.i - 1;
            }

            @Override
            public int nextIndex() {
                return this.i;
            }

            @Override
            public int[] next() {
                int n3;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.i % IntArrayFrontCodedList.this.ratio == 0) {
                    this.pos = IntArrayFrontCodedList.this.p[this.i / IntArrayFrontCodedList.this.ratio];
                    n3 = IntArrayFrontCodedList.readInt(IntArrayFrontCodedList.this.array, this.pos);
                    this.s = IntArrays.ensureCapacity(this.s, n3, 0);
                    BigArrays.copyFromBig((int[][])IntArrayFrontCodedList.this.array, (long)(this.pos + (long)IntArrayFrontCodedList.count(n3)), (int[])this.s, (int)0, (int)n3);
                    this.pos += (long)(n3 + IntArrayFrontCodedList.count(n3));
                    this.inSync = true;
                } else if (this.inSync) {
                    n3 = IntArrayFrontCodedList.readInt(IntArrayFrontCodedList.this.array, this.pos);
                    int n2 = IntArrayFrontCodedList.readInt(IntArrayFrontCodedList.this.array, this.pos + (long)IntArrayFrontCodedList.count(n3));
                    this.s = IntArrays.ensureCapacity(this.s, n3 + n2, n2);
                    BigArrays.copyFromBig((int[][])IntArrayFrontCodedList.this.array, (long)(this.pos + (long)IntArrayFrontCodedList.count(n3) + (long)IntArrayFrontCodedList.count(n2)), (int[])this.s, (int)n2, (int)n3);
                    this.pos += (long)(IntArrayFrontCodedList.count(n3) + IntArrayFrontCodedList.count(n2) + n3);
                    n3 += n2;
                } else {
                    n3 = IntArrayFrontCodedList.this.length(this.i);
                    this.s = IntArrays.ensureCapacity(this.s, n3, 0);
                    IntArrayFrontCodedList.this.extract(this.i, this.s, 0, n3);
                }
                ++this.i;
                return IntArrays.copy(this.s, 0, n3);
            }

            @Override
            public int[] previous() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                return IntArrayFrontCodedList.this.getArray(--this.i);
            }
        };
    }

    public IntArrayFrontCodedList clone() {
        return this;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < this.n; ++i) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(IntArrayList.wrap(this.getArray(i)).toString());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    protected long[] rebuildPointerArray() {
        long[] lArray = new long[(this.n + this.ratio - 1) / this.ratio];
        int[][] nArray = this.array;
        long l = 0L;
        int n = 0;
        int n2 = this.ratio - 1;
        for (int i = 0; i < this.n; ++i) {
            int n3 = IntArrayFrontCodedList.readInt(nArray, l);
            int n4 = IntArrayFrontCodedList.count(n3);
            if (++n2 == this.ratio) {
                n2 = 0;
                lArray[n++] = l;
                l += (long)(n4 + n3);
                continue;
            }
            l += (long)(n4 + IntArrayFrontCodedList.count(IntArrayFrontCodedList.readInt(nArray, l + (long)n4)) + n3);
        }
        return lArray;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.p = this.rebuildPointerArray();
    }
}

