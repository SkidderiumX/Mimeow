/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.Environment;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class ChunkType1_13
extends Type<Chunk> {
    private static final ChunkType1_13 WITH_SKYLIGHT = new ChunkType1_13(true);
    private static final ChunkType1_13 WITHOUT_SKYLIGHT = new ChunkType1_13(false);
    private final boolean hasSkyLight;

    public ChunkType1_13(boolean bl) {
        super(Chunk.class);
        this.hasSkyLight = bl;
    }

    public static ChunkType1_13 forEnvironment(Environment environment) {
        return environment == Environment.NORMAL ? WITH_SKYLIGHT : WITHOUT_SKYLIGHT;
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int[] nArray;
        int n = byteBuf.readInt();
        int n2 = byteBuf.readInt();
        boolean bl = byteBuf.readBoolean();
        int n3 = Types.VAR_INT.readPrimitive(byteBuf);
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        ChunkSection[] chunkSectionArray = new ChunkSection[16];
        for (int i = 0; i < 16; ++i) {
            ChunkSection chunkSection;
            if ((n3 & 1 << i) == 0) continue;
            chunkSectionArray[i] = chunkSection = (ChunkSection)Types.CHUNK_SECTION1_13.read(byteBuf2);
            chunkSection.getLight().readBlockLight(byteBuf2);
            if (!this.hasSkyLight) continue;
            chunkSection.getLight().readSkyLight(byteBuf2);
        }
        int[] nArray2 = nArray = bl ? new int[256] : null;
        if (bl) {
            if (byteBuf2.readableBytes() >= 1024) {
                for (int i = 0; i < 256; ++i) {
                    nArray[i] = byteBuf2.readInt();
                }
            } else {
                Via.getPlatform().getLogger().log(Level.WARNING, "Chunk x=" + n + " z=" + n2 + " doesn't have biome data!");
            }
        }
        ArrayList<CompoundTag> arrayList = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Types.NAMED_COMPOUND_TAG_ARRAY.read(byteBuf)));
        return new BaseChunk(n, n2, bl, false, n3, chunkSectionArray, nArray, arrayList);
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
        ByteBuf byteBuf2 = byteBuf.alloc().buffer();
        try {
            for (int i = 0; i < 16; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection == null) continue;
                Types.CHUNK_SECTION1_13.write(byteBuf2, chunkSection);
                chunkSection.getLight().writeBlockLight(byteBuf2);
                if (!chunkSection.getLight().hasSkyLight()) continue;
                chunkSection.getLight().writeSkyLight(byteBuf2);
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
                byteBuf.writeInt(n);
            }
        }
        Types.NAMED_COMPOUND_TAG_ARRAY.write(byteBuf, chunk.getBlockEntities().toArray(new CompoundTag[0]));
    }
}

