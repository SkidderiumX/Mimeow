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
import com.viaversion.viaversion.util.ChunkUtil;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.logging.Level;

public class ChunkType1_9_1
extends Type<Chunk> {
    private static final ChunkType1_9_1 WITH_SKYLIGHT = new ChunkType1_9_1(true);
    private static final ChunkType1_9_1 WITHOUT_SKYLIGHT = new ChunkType1_9_1(false);
    private final boolean hasSkyLight;

    public ChunkType1_9_1(boolean bl) {
        super(Chunk.class);
        this.hasSkyLight = bl;
    }

    public static ChunkType1_9_1 forEnvironment(Environment environment) {
        return environment == Environment.NORMAL ? WITH_SKYLIGHT : WITHOUT_SKYLIGHT;
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int n = byteBuf.readInt();
        int n2 = byteBuf.readInt();
        boolean bl = byteBuf.readBoolean();
        int n3 = Types.VAR_INT.readPrimitive(byteBuf);
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        ChunkSection[] chunkSectionArray = new ChunkSection[16];
        int[] nArray = bl ? new int[256] : null;
        try {
            int n4;
            BitSet bitSet = new BitSet(16);
            for (n4 = 0; n4 < 16; ++n4) {
                if ((n3 & 1 << n4) == 0) continue;
                bitSet.set(n4);
            }
            for (n4 = 0; n4 < 16; ++n4) {
                ChunkSection chunkSection;
                if (!bitSet.get(n4)) continue;
                chunkSectionArray[n4] = chunkSection = (ChunkSection)Types.CHUNK_SECTION1_9.read(byteBuf2);
                chunkSection.getLight().readBlockLight(byteBuf2);
                if (!this.hasSkyLight) continue;
                chunkSection.getLight().readSkyLight(byteBuf2);
            }
            if (bl) {
                for (n4 = 0; n4 < 256; ++n4) {
                    nArray[n4] = byteBuf2.readByte() & 0xFF;
                }
            }
        }
        catch (Throwable throwable) {
            Via.getPlatform().getLogger().log(Level.WARNING, "The server sent an invalid chunk data packet, returning an empty chunk instead", throwable);
            return ChunkUtil.createEmptyChunk(n, n2);
        }
        return new BaseChunk(n, n2, bl, false, n3, chunkSectionArray, nArray, new ArrayList<CompoundTag>());
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
                Types.CHUNK_SECTION1_9.write(byteBuf2, chunkSection);
                chunkSection.getLight().writeBlockLight(byteBuf2);
                if (!chunkSection.getLight().hasSkyLight()) continue;
                chunkSection.getLight().writeSkyLight(byteBuf2);
            }
            byteBuf2.readerIndex(0);
            Types.VAR_INT.writePrimitive(byteBuf, byteBuf2.readableBytes() + (chunk.isBiomeData() ? 256 : 0));
            byteBuf.writeBytes(byteBuf2);
        }
        finally {
            byteBuf2.release();
        }
        if (chunk.isBiomeData()) {
            for (int n : chunk.getBiomeData()) {
                byteBuf.writeByte((byte)n);
            }
        }
    }
}

