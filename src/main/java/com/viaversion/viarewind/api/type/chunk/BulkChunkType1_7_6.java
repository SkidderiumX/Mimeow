/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type.chunk;

import com.viaversion.viarewind.api.compression.ThreadLocalCompressionProvider;
import com.viaversion.viarewind.api.type.chunk.ChunkType1_7_6;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.zip.DataFormatException;

public class BulkChunkType1_7_6
extends Type<Chunk[]> {
    public static final BulkChunkType1_7_6 TYPE = new BulkChunkType1_7_6();

    public BulkChunkType1_7_6() {
        super(Chunk[].class);
    }

    @Override
    public Chunk[] read(ByteBuf byteBuf) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, Chunk[] chunkArray) {
        int n;
        int n2 = chunkArray.length;
        int[] nArray = new int[n2];
        int n3 = 0;
        boolean bl = false;
        Chunk[] chunkArray2 = chunkArray;
        int n4 = chunkArray2.length;
        for (n = 0; n < n4; ++n) {
            Chunk chunk = chunkArray2[n];
            if (!ChunkType1_7_6.hasSkyLight(chunk)) continue;
            bl = true;
            break;
        }
        for (int i = 0; i < n2; ++i) {
            Chunk chunk = chunkArray[i];
            nArray[i] = ChunkType1_7_6.getAddBitMask(chunk);
            n = chunk.isFullChunk() && chunk.getBiomeData() != null ? 1 : 0;
            n3 += ChunkType1_7_6.calcSize(chunk.getBitmask(), nArray[i], bl, n != 0);
        }
        ByteBuf byteBuf2 = byteBuf.alloc().buffer(n3);
        try {
            for (n4 = 0; n4 < n2; ++n4) {
                Chunk chunk = chunkArray[n4];
                boolean bl2 = chunk.isFullChunk() && chunk.getBiomeData() != null;
                ChunkType1_7_6.serialize(chunk, byteBuf2, nArray[n4], bl, bl2);
            }
            byteBuf.writeShort(n2);
            n4 = byteBuf.writerIndex();
            byteBuf.writeInt(0);
            byteBuf.writeBoolean(bl);
            int n5 = byteBuf.writerIndex();
            try {
                ThreadLocalCompressionProvider.deflate(byteBuf2, byteBuf);
            }
            catch (DataFormatException dataFormatException) {
                throw new RuntimeException("Failed to compress bulk chunk data", dataFormatException);
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
        for (n4 = 0; n4 < n2; ++n4) {
            Chunk chunk = chunkArray[n4];
            byteBuf.writeInt(chunk.getX());
            byteBuf.writeInt(chunk.getZ());
            byteBuf.writeShort(chunk.getBitmask());
            byteBuf.writeShort(nArray[n4]);
        }
    }
}

