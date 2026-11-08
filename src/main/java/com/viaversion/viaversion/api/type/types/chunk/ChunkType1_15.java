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

public class ChunkType1_15
extends Type<Chunk> {
    public static final Type<Chunk> TYPE = new ChunkType1_15();
    private static final CompoundTag[] EMPTY_COMPOUNDS = new CompoundTag[0];

    public ChunkType1_15() {
        super(Chunk.class);
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int[] nArray;
        int n = byteBuf.readInt();
        int n2 = byteBuf.readInt();
        boolean bl = byteBuf.readBoolean();
        int n3 = Types.VAR_INT.readPrimitive(byteBuf);
        CompoundTag compoundTag = (CompoundTag)Types.NAMED_COMPOUND_TAG.read(byteBuf);
        int[] nArray2 = nArray = bl ? new int[1024] : null;
        if (bl) {
            for (int i = 0; i < 1024; ++i) {
                nArray[i] = byteBuf.readInt();
            }
        }
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        ChunkSection[] chunkSectionArray = new ChunkSection[16];
        for (int i = 0; i < 16; ++i) {
            if ((n3 & 1 << i) == 0) continue;
            short s = byteBuf2.readShort();
            ChunkSection chunkSection = (ChunkSection)Types.CHUNK_SECTION1_13.read(byteBuf2);
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
            for (int n : chunk.getBiomeData()) {
                byteBuf.writeInt(n);
            }
        }
        Object object = byteBuf.alloc().buffer();
        try {
            for (int i = 0; i < 16; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection == null) continue;
                ((ByteBuf)object).writeShort(chunkSection.getNonAirBlocksCount());
                Types.CHUNK_SECTION1_13.write((ByteBuf)object, chunkSection);
            }
            ((ByteBuf)object).readerIndex(0);
            Types.VAR_INT.writePrimitive(byteBuf, ((ByteBuf)object).readableBytes());
            byteBuf.writeBytes((ByteBuf)object);
        }
        finally {
            object.release();
        }
        Types.NAMED_COMPOUND_TAG_ARRAY.write(byteBuf, chunk.getBlockEntities().toArray(EMPTY_COMPOUNDS));
    }
}

