/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;

public class ChunkType1_16_2
extends Type<Chunk> {
    public static final Type<Chunk> TYPE = new ChunkType1_16_2();
    private static final CompoundTag[] EMPTY_COMPOUNDS = new CompoundTag[0];

    public ChunkType1_16_2() {
        super(Chunk.class);
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int n = byteBuf.readInt();
        int n2 = byteBuf.readInt();
        boolean bl = byteBuf.readBoolean();
        int n3 = Types.VAR_INT.readPrimitive(byteBuf);
        CompoundTag compoundTag = (CompoundTag)Types.NAMED_COMPOUND_TAG.read(byteBuf);
        int[] nArray = null;
        if (bl) {
            nArray = (int[])Types.VAR_INT_ARRAY_PRIMITIVE.read(byteBuf);
        }
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        ChunkSection[] chunkSectionArray = new ChunkSection[16];
        for (int i = 0; i < 16; ++i) {
            if ((n3 & 1 << i) == 0) continue;
            short s = byteBuf2.readShort();
            ChunkSection chunkSection = (ChunkSection)Types.CHUNK_SECTION1_16.read(byteBuf2);
            chunkSection.setNonAirBlocksCount(s);
            chunkSectionArray[i] = chunkSection;
        }
        ArrayList<CompoundTag> arrayList = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Types.NAMED_COMPOUND_TAG_ARRAY.read(byteBuf)));
        return new BaseChunk(n, n2, bl, false, n3, chunkSectionArray, nArray, compoundTag, arrayList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, Chunk chunk) {
        byteBuf.writeInt(chunk.getX());
        byteBuf.writeInt(chunk.getZ());
        byteBuf.writeBoolean(chunk.isFullChunk());
        Types.VAR_INT.writePrimitive(byteBuf, chunk.getBitmask());
        Types.NAMED_COMPOUND_TAG.write(byteBuf, chunk.getHeightMap());
        if (chunk.isBiomeData()) {
            Types.VAR_INT_ARRAY_PRIMITIVE.write(byteBuf, chunk.getBiomeData());
        }
        ByteBuf byteBuf2 = byteBuf.alloc().buffer();
        try {
            for (int i = 0; i < 16; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
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

