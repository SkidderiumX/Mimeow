/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class ChunkType1_17
extends Type<Chunk> {
    private static final CompoundTag[] EMPTY_COMPOUNDS = new CompoundTag[0];
    private final int ySectionCount;

    public ChunkType1_17(int n) {
        super(Chunk.class);
        Preconditions.checkArgument(n > 0);
        this.ySectionCount = n;
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int n = byteBuf.readInt();
        int n2 = byteBuf.readInt();
        BitSet bitSet = BitSet.valueOf((long[])Types.LONG_ARRAY_PRIMITIVE.read(byteBuf));
        CompoundTag compoundTag = (CompoundTag)Types.NAMED_COMPOUND_TAG.read(byteBuf);
        int[] nArray = (int[])Types.VAR_INT_ARRAY_PRIMITIVE.read(byteBuf);
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        ChunkSection[] chunkSectionArray = new ChunkSection[this.ySectionCount];
        for (int i = 0; i < this.ySectionCount; ++i) {
            if (!bitSet.get(i)) continue;
            short s = byteBuf2.readShort();
            ChunkSection chunkSection = (ChunkSection)Types.CHUNK_SECTION1_16.read(byteBuf2);
            chunkSection.setNonAirBlocksCount(s);
            chunkSectionArray[i] = chunkSection;
        }
        ArrayList<CompoundTag> arrayList = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Types.NAMED_COMPOUND_TAG_ARRAY.read(byteBuf)));
        return new BaseChunk(n, n2, true, false, bitSet, chunkSectionArray, nArray, compoundTag, arrayList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, Chunk chunk) {
        byteBuf.writeInt(chunk.getX());
        byteBuf.writeInt(chunk.getZ());
        Types.LONG_ARRAY_PRIMITIVE.write(byteBuf, chunk.getChunkMask().toLongArray());
        Types.NAMED_COMPOUND_TAG.write(byteBuf, chunk.getHeightMap());
        Types.VAR_INT_ARRAY_PRIMITIVE.write(byteBuf, chunk.getBiomeData());
        ByteBuf byteBuf2 = byteBuf.alloc().buffer();
        try {
            ChunkSection[] chunkSectionArray;
            for (ChunkSection chunkSection : chunkSectionArray = chunk.getSections()) {
                if (chunkSection == null) continue;
                byteBuf2.writeShort(chunkSection.getNonAirBlocksCount());
                Types.CHUNK_SECTION1_16.write(byteBuf2, chunkSection);
            }
            byteBuf2.readerIndex(0);
            Types.VAR_INT.writePrimitive(byteBuf, byteBuf2.readableBytes());
            byteBuf.writeBytes(byteBuf2);
        }
        finally {
            byteBuf2.release();
        }
        Types.NAMED_COMPOUND_TAG_ARRAY.write(byteBuf, chunk.getBlockEntities().toArray(EMPTY_COMPOUNDS));
    }
}

