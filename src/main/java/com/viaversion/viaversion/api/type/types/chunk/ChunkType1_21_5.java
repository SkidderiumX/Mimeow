/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_21_5;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkSectionType1_18;
import com.viaversion.viaversion.api.type.types.chunk.ChunkSectionType1_21_5;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;

public class ChunkType1_21_5
extends Type<Chunk> {
    private final ChunkSectionType1_18 sectionType;
    private final int ySectionCount;

    public ChunkType1_21_5(int n, int n2, int n3) {
        this(new ChunkSectionType1_21_5(n2, n3), n);
    }

    protected ChunkType1_21_5(ChunkSectionType1_18 chunkSectionType1_18, int n) {
        super(Chunk.class);
        Preconditions.checkArgument(n > 0);
        this.sectionType = chunkSectionType1_18;
        this.ySectionCount = n;
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int n;
        int n2 = byteBuf.readInt();
        int n3 = byteBuf.readInt();
        Heightmap[] heightmapArray = (Heightmap[])Types.HEIGHTMAP_ARRAY.read(byteBuf);
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        ChunkSection[] chunkSectionArray = new ChunkSection[this.ySectionCount];
        for (n = 0; n < this.ySectionCount; ++n) {
            chunkSectionArray[n] = this.sectionType.read(byteBuf2);
        }
        n = Types.VAR_INT.readPrimitive(byteBuf);
        ArrayList<BlockEntity> arrayList = new ArrayList<BlockEntity>(n);
        for (int i = 0; i < n; ++i) {
            arrayList.add((BlockEntity)Types.BLOCK_ENTITY1_20_2.read(byteBuf));
        }
        return new Chunk1_21_5(n2, n3, chunkSectionArray, heightmapArray, arrayList);
    }

    @Override
    public void write(ByteBuf byteBuf, Chunk chunk) {
        byteBuf.writeInt(chunk.getX());
        byteBuf.writeInt(chunk.getZ());
        Types.HEIGHTMAP_ARRAY.write(byteBuf, chunk.heightmaps());
        Types.VAR_INT.writePrimitive(byteBuf, this.sectionType.serializedSize(chunk));
        for (ChunkSection chunkSection : chunk.getSections()) {
            this.sectionType.write(byteBuf, chunkSection);
        }
        Types.VAR_INT.writePrimitive(byteBuf, chunk.blockEntities().size());
        for (BlockEntity blockEntity : chunk.blockEntities()) {
            Types.BLOCK_ENTITY1_20_2.write(byteBuf, blockEntity);
        }
    }
}

