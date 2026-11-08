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

public class ChunkType1_14
extends Type<Chunk> {
    public static final Type<Chunk> TYPE = new ChunkType1_14();

    public ChunkType1_14() {
        super(Chunk.class);
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int[] nArray;
        int n;
        int n2 = byteBuf.readInt();
        int n3 = byteBuf.readInt();
        boolean bl = byteBuf.readBoolean();
        int n4 = Types.VAR_INT.readPrimitive(byteBuf);
        CompoundTag compoundTag = (CompoundTag)Types.NAMED_COMPOUND_TAG.read(byteBuf);
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        ChunkSection[] chunkSectionArray = new ChunkSection[16];
        for (int i = 0; i < 16; ++i) {
            if ((n4 & 1 << i) == 0) continue;
            n = byteBuf2.readShort();
            ChunkSection chunkSection = (ChunkSection)Types.CHUNK_SECTION1_13.read(byteBuf2);
            chunkSection.setNonAirBlocksCount(n);
            chunkSectionArray[i] = chunkSection;
        }
        int[] nArray2 = nArray = bl ? new int[256] : null;
        if (bl) {
            for (n = 0; n < 256; ++n) {
                nArray[n] = byteBuf2.readInt();
            }
        }
        ArrayList<CompoundTag> arrayList = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Types.NAMED_COMPOUND_TAG_ARRAY.read(byteBuf)));
        return new BaseChunk(n2, n3, bl, false, n4, chunkSectionArray, nArray, compoundTag, arrayList);
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
        ByteBuf byteBuf2 = byteBuf.alloc().buffer();
        try {
            for (int i = 0; i < 16; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection == null) continue;
                byteBuf2.writeShort(chunkSection.getNonAirBlocksCount());
                Types.CHUNK_SECTION1_13.write(byteBuf2, chunkSection);
            }
            byteBuf2.readerIndex(0);
            Types.VAR_INT.writePrimitive(byteBuf, byteBuf2.readableBytes() + (chunk.isBiomeData() ? 1024 : 0));
            byteBuf.writeBytes(byteBuf2);
        }
        finally {
            byteBuf2.release();
        }
        if (chunk.isBiomeData()) {
            for (int n : chunk.getBiomeData()) {
                byteBuf.writeInt(n & 0xFF);
            }
        }
        Types.NAMED_COMPOUND_TAG_ARRAY.write(byteBuf, chunk.getBlockEntities().toArray(new CompoundTag[0]));
    }
}

