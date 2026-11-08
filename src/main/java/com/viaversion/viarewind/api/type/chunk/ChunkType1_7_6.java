/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type.chunk;

import com.viaversion.viarewind.api.compression.ThreadLocalCompressionProvider;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.zip.DataFormatException;

public class ChunkType1_7_6
extends Type<Chunk> {
    public static final ChunkType1_7_6 TYPE = new ChunkType1_7_6();

    public ChunkType1_7_6() {
        super(Chunk.class);
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, Chunk chunk) {
        int n = chunk.getBitmask();
        int n2 = ChunkType1_7_6.getAddBitMask(chunk);
        boolean bl = ChunkType1_7_6.hasSkyLight(chunk);
        boolean bl2 = chunk.isFullChunk() && chunk.getBiomeData() != null;
        int n3 = ChunkType1_7_6.calcSize(n, n2, bl, bl2);
        ByteBuf byteBuf2 = byteBuf.alloc().buffer(n3);
        try {
            ChunkType1_7_6.serialize(chunk, byteBuf2, n2, bl, bl2);
            byteBuf.writeInt(chunk.getX());
            byteBuf.writeInt(chunk.getZ());
            byteBuf.writeBoolean(chunk.isFullChunk());
            byteBuf.writeShort(n);
            byteBuf.writeShort(n2);
            int n4 = byteBuf.writerIndex();
            byteBuf.writeInt(0);
            int n5 = byteBuf.writerIndex();
            try {
                ThreadLocalCompressionProvider.deflate(byteBuf2, byteBuf);
            }
            catch (DataFormatException dataFormatException) {
                throw new RuntimeException("Failed to compress chunk data", dataFormatException);
            }
            int n6 = byteBuf.writerIndex() - n5;
            int n7 = byteBuf.writerIndex();
            byteBuf.writerIndex(n4);
            byteBuf.writeInt(n6);
            byteBuf.writerIndex(n7);
        }
        finally {
            byteBuf2.release();
        }
    }

    public static void serialize(Chunk chunk, ByteBuf byteBuf, int n, boolean bl, boolean bl2) {
        int n2;
        Object object;
        int n3;
        DataPalette dataPalette;
        Object object2;
        int n4;
        ChunkSection[] chunkSectionArray = chunk.getSections();
        int n5 = chunk.getBitmask();
        for (n4 = 0; n4 < 16; ++n4) {
            if ((n5 & 1 << n4) == 0) continue;
            object2 = chunkSectionArray[n4];
            dataPalette = object2.palette(PaletteType.BLOCKS);
            for (n3 = 0; n3 < 4096; ++n3) {
                object = dataPalette.idAt(n3);
                byteBuf.writeByte(object >> 4 & 0xFF);
            }
        }
        for (n4 = 0; n4 < 16; ++n4) {
            if ((n5 & 1 << n4) == 0) continue;
            object2 = chunkSectionArray[n4];
            dataPalette = object2.palette(PaletteType.BLOCKS);
            for (n3 = 0; n3 < 4096; n3 += 2) {
                object = dataPalette.idAt(n3) & 0xF;
                n2 = dataPalette.idAt(n3 + 1) & 0xF;
                byteBuf.writeByte(object | n2 << 4);
            }
        }
        for (n4 = 0; n4 < 16; ++n4) {
            if ((n5 & 1 << n4) == 0) continue;
            object2 = chunkSectionArray[n4].getLight().getBlockLight();
            byteBuf.writeBytes((byte[])object2);
        }
        if (bl) {
            for (n4 = 0; n4 < 16; ++n4) {
                if ((n5 & 1 << n4) == 0) continue;
                if (chunkSectionArray[n4].getLight().hasSkyLight()) {
                    object2 = chunkSectionArray[n4].getLight().getSkyLight();
                    byteBuf.writeBytes((byte[])object2);
                    continue;
                }
                byteBuf.writeZero(2048);
            }
        }
        if (n != 0) {
            for (n4 = 0; n4 < 16; ++n4) {
                if ((n5 & 1 << n4) == 0 || (n & 1 << n4) == 0) continue;
                object2 = chunkSectionArray[n4];
                dataPalette = object2.palette(PaletteType.BLOCKS);
                for (n3 = 0; n3 < 4096; n3 += 2) {
                    object = dataPalette.idAt(n3) >> 12 & 0xF;
                    n2 = dataPalette.idAt(n3 + 1) >> 12 & 0xF;
                    byteBuf.writeByte(object | n2 << 4);
                }
            }
        }
        if (bl2 && chunk.getBiomeData() != null) {
            int[] nArray = chunk.getBiomeData();
            object2 = nArray;
            int n6 = ((Object)object2).length;
            for (n3 = 0; n3 < n6; ++n3) {
                object = object2[n3];
                byteBuf.writeByte((int)object);
            }
        }
    }

    public static int calcSize(int n, int n2, boolean bl, boolean bl2) {
        int n3 = 0;
        int n4 = Integer.bitCount(n);
        n3 += n4 * 4096;
        n3 += n4 * 2048;
        n3 += n4 * 2048;
        if (bl) {
            n3 += n4 * 2048;
        }
        if (n2 != 0) {
            n3 += Integer.bitCount(n2) * 2048;
        }
        if (bl2) {
            n3 += 256;
        }
        return n3;
    }

    public static int getAddBitMask(Chunk chunk) {
        int n = 0;
        block0: for (int i = 0; i < 16; ++i) {
            if ((chunk.getBitmask() & 1 << i) == 0) continue;
            ChunkSection chunkSection = chunk.getSections()[i];
            DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
            for (int j = 0; j < 4096; ++j) {
                int n2 = dataPalette.idAt(j);
                if (n2 >> 12 == 0) continue;
                n |= 1 << i;
                continue block0;
            }
        }
        return n;
    }

    public static boolean hasSkyLight(Chunk chunk) {
        for (ChunkSection chunkSection : chunk.getSections()) {
            if (chunkSection == null || !chunkSection.getLight().hasSkyLight()) continue;
            return true;
        }
        return false;
    }
}

