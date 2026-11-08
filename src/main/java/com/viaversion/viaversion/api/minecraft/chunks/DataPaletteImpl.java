/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.chunks;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.util.CompactArrayUtil;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class DataPaletteImpl
implements DataPalette {
    private static final int DEFAULT_INITIAL_SIZE = 16;
    private final IntArrayList palette;
    private final int sizeBits;
    private Int2IntMap inversePalette;
    private ChunkData values;
    private static final ThreadLocal<boolean[]> MATCHING_INDEXES = ThreadLocal.withInitial(() -> new boolean[4096]);

    public DataPaletteImpl(int n) {
        this(n, 16);
    }

    public DataPaletteImpl(int n, int n2) {
        this.values = new SingleChunkData(n);
        this.sizeBits = Integer.numberOfTrailingZeros(n) / 3;
        this.palette = new IntArrayList(n2);
    }

    private Int2IntMap inversePalette() {
        if (this.inversePalette == null) {
            this.inversePalette = new Int2IntOpenHashMap(this.palette.size());
            this.inversePalette.defaultReturnValue(-1);
            for (int i = 0; i < this.palette.size(); ++i) {
                this.inversePalette.put(this.palette.getInt(i), i);
            }
        }
        return this.inversePalette;
    }

    private Int2IntMap emptyInversePalette() {
        if (this.inversePalette == null) {
            this.inversePalette = new Int2IntOpenHashMap(this.palette.size());
            this.inversePalette.defaultReturnValue(-1);
        } else {
            this.inversePalette.clear();
        }
        return this.inversePalette;
    }

    @Override
    public int index(int n, int n2, int n3) {
        return (n2 << this.sizeBits | n3) << this.sizeBits | n;
    }

    @Override
    public int idAt(int n) {
        int n2 = this.values.get(n);
        return this.palette.getInt(n2);
    }

    @Override
    public void setIdAt(int n, int n2) {
        int n3 = this.inversePalette().get(n2);
        if (n3 == -1) {
            n3 = this.palette.size();
            this.palette.add(n2);
            this.inversePalette.put(n2, n3);
        }
        this.values.set(n, n3);
    }

    @Override
    public int paletteIndexAt(int n) {
        return this.values.get(n);
    }

    @Override
    public void setPaletteIndexAt(int n, int n2) {
        this.values.set(n, n2);
    }

    public void setPaletteIndexes(long[] lArray, int n, int n2) {
        Preconditions.checkArgument(n <= 8, "Cannot pack global palette");
        this.values = new PackedChunkData(lArray, n, n2, this.values.size());
    }

    @Override
    public long[] createPackedValues(int n, int n2, boolean bl) {
        if (bl) {
            return CompactArrayUtil.createCompactArrayWithPadding(n, n2, this::idAt);
        }
        Object object = this.values;
        if (object instanceof PackedChunkData) {
            PackedChunkData packedChunkData = (PackedChunkData)object;
            if (packedChunkData.bitsPerValue == n) {
                return packedChunkData.data;
            }
        }
        char c = (char)(64 / n);
        object = new long[(n2 + c - 1) / c];
        this.values.packInto((long[])object, n);
        return object;
    }

    @Override
    public int size() {
        return this.palette.size();
    }

    @Override
    public int idByIndex(int n) {
        return this.palette.getInt(n);
    }

    @Override
    public void setIdByIndex(int n, int n2) {
        int n3 = this.palette.set(n, n2);
        if (n3 == n2 || this.inversePalette == null) {
            return;
        }
        this.inversePalette.put(n2, n);
        if (this.inversePalette.get(n3) == n) {
            this.inversePalette.remove(n3);
            for (int i = 0; i < this.palette.size(); ++i) {
                if (this.palette.getInt(i) != n3) continue;
                this.inversePalette.put(n3, i);
                break;
            }
        }
    }

    @Override
    public void replaceId(int n, int n2) {
        int n3 = this.inversePalette().remove(n);
        if (n3 == -1) {
            return;
        }
        this.inversePalette.put(n2, n3);
        for (int i = 0; i < this.palette.size(); ++i) {
            if (this.palette.getInt(i) != n) continue;
            this.palette.set(i, n2);
        }
    }

    @Override
    public void replaceIds(IntUnaryOperator intUnaryOperator) {
        int n;
        int n2;
        int n3;
        int n4 = this.palette.size();
        if (n4 == 0) {
            return;
        }
        int n5 = 0;
        int[] nArray = null;
        int n6 = 0;
        int[] nArray2 = this.palette.elements();
        Int2IntMap int2IntMap = this.emptyInversePalette();
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = intUnaryOperator.applyAsInt(nArray2[n3]);
            n = int2IntMap.putIfAbsent(n2, n5);
            if (n == -1) {
                nArray2[n5] = n2;
                if (nArray != null) {
                    nArray[n3 - n6] = n5;
                }
                ++n5;
                continue;
            }
            if (nArray == null) {
                nArray = new int[n4 - n3];
                n6 = n3;
            }
            nArray[n3 - n6] = n;
        }
        if (nArray != null) {
            this.palette.removeElements(n5, n4);
            n3 = this.values.size();
            for (n2 = 0; n2 < n3; ++n2) {
                n = this.values.get(n2);
                if (n < n6) continue;
                this.values.set(n2, nArray[n - n6]);
            }
        }
    }

    @Override
    public void addId(int n) {
        if (this.inversePalette != null) {
            this.inversePalette.put(n, this.palette.size());
        }
        this.palette.add(n);
    }

    @Override
    public void forEachMatchingCoordinate(IntPredicate intPredicate, IntConsumer intConsumer) {
        int n;
        int n2;
        int n3 = this.size();
        if (n3 > 4096) {
            int n4 = this.values.size();
            for (int i = 0; i < n4; ++i) {
                if (!intPredicate.test(this.idAt(i))) continue;
                intConsumer.accept(i);
            }
            return;
        }
        boolean[] blArray = MATCHING_INDEXES.get();
        int n5 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            blArray[n2] = n = intPredicate.test(this.idByIndex(n2));
            n5 |= n;
        }
        if (n5 == 0) {
            return;
        }
        n = this.values.size();
        for (n2 = 0; n2 < n; ++n2) {
            if (!blArray[this.paletteIndexAt(n2)]) continue;
            intConsumer.accept(n2);
        }
    }

    @Override
    public void clear() {
        this.palette.clear();
        this.inversePalette = null;
    }

    private final class SingleChunkData
    implements ChunkData {
        private final int size;

        public SingleChunkData(int n) {
            this.size = n;
        }

        @Override
        public int get(int n) {
            return 0;
        }

        @Override
        public void set(int n, int n2) {
            if (n2 != 0) {
                DataPaletteImpl.this.values = new ByteChunkData(this.size);
                DataPaletteImpl.this.values.set(n, n2);
            }
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public void packInto(long[] lArray, int n) {
        }
    }

    public static interface ChunkData {
        public int get(int var1);

        public void set(int var1, int var2);

        public int size();

        public void packInto(long[] var1, int var2);
    }

    private final class PackedChunkData
    implements ChunkData {
        private final long[] data;
        private final int bitsPerValue;
        private final int valuesPerLong;
        private final long maxEntryValue;
        private final int size;

        private PackedChunkData(long[] lArray, int n, int n2, int n3) {
            this.data = lArray;
            this.bitsPerValue = n;
            this.valuesPerLong = n2;
            this.size = n3;
            this.maxEntryValue = (1L << n) - 1L;
        }

        @Override
        public int get(int n) {
            int n2 = n / this.valuesPerLong;
            int n3 = (n - n2 * this.valuesPerLong) * this.bitsPerValue;
            return (int)(this.data[n2] >>> n3 & this.maxEntryValue);
        }

        @Override
        public void set(int n, int n2) {
            ChunkData chunkData;
            DataPaletteImpl.this.values = chunkData = this.extractData();
            chunkData.set(n, n2);
        }

        private ChunkData extractData() {
            byte[] byArray = new byte[this.size];
            CompactArrayUtil.unpackWithPadding(this.data, byArray, this.bitsPerValue);
            return new ByteChunkData(byArray);
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public void packInto(long[] lArray, int n) {
            this.extractData().packInto(lArray, n);
        }
    }

    private static final class ShortChunkData
    implements ChunkData {
        private final short[] data;

        public ShortChunkData(byte[] byArray) {
            this.data = new short[byArray.length];
            for (int i = 0; i < byArray.length; ++i) {
                this.data[i] = (short)(byArray[i] & 0xFF);
            }
        }

        @Override
        public int get(int n) {
            return this.data[n];
        }

        @Override
        public void set(int n, int n2) {
            this.data[n] = (short)n2;
        }

        @Override
        public int size() {
            return this.data.length;
        }

        @Override
        public void packInto(long[] lArray, int n) {
            CompactArrayUtil.packWithPadding(this.data, lArray, n);
        }
    }

    private final class ByteChunkData
    implements ChunkData {
        private final byte[] data;

        public ByteChunkData(int n) {
            this.data = new byte[n];
        }

        public ByteChunkData(byte[] byArray) {
            this.data = byArray;
        }

        @Override
        public int get(int n) {
            return this.data[n] & 0xFF;
        }

        @Override
        public void set(int n, int n2) {
            if (n2 > 255) {
                DataPaletteImpl.this.values = new ShortChunkData(this.data);
                DataPaletteImpl.this.values.set(n, n2);
                return;
            }
            this.data[n] = (byte)n2;
        }

        @Override
        public int size() {
            return this.data.length;
        }

        @Override
        public void packInto(long[] lArray, int n) {
            CompactArrayUtil.packWithPadding(this.data, lArray, n);
        }
    }
}

