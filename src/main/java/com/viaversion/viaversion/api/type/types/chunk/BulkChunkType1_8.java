/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_8;
import io.netty.buffer.ByteBuf;

public class BulkChunkType1_8
extends Type<Chunk[]> {
    public static final Type<Chunk[]> TYPE = new BulkChunkType1_8();
    private static final int BLOCKS_PER_SECTION = 4096;
    private static final int BLOCKS_BYTES = 8192;
    private static final int LIGHT_BYTES = 2048;
    private static final int BIOME_BYTES = 256;

    public BulkChunkType1_8() {
        super(Chunk[].class);
    }

    @Override
    public Chunk[] read(ByteBuf byteBuf) {
        int n;
        boolean bl = byteBuf.readBoolean();
        int n2 = Types.VAR_INT.readPrimitive(byteBuf);
        Chunk[] chunkArray = new Chunk[n2];
        ChunkBulkSection[] chunkBulkSectionArray = new ChunkBulkSection[n2];
        for (n = 0; n < chunkBulkSectionArray.length; ++n) {
            chunkBulkSectionArray[n] = new ChunkBulkSection(byteBuf, bl);
        }
        for (n = 0; n < chunkArray.length; ++n) {
            ChunkBulkSection chunkBulkSection = chunkBulkSectionArray[n];
            chunkBulkSection.readData(byteBuf);
            chunkArray[n] = ChunkType1_8.deserialize(chunkBulkSection.chunkX, chunkBulkSection.chunkZ, true, bl, chunkBulkSection.bitmask, chunkBulkSection.data());
        }
        return chunkArray;
    }

    @Override
    public void write(ByteBuf byteBuf, Chunk[] chunkArray) {
        boolean bl = false;
        block0: for (Chunk chunk : chunkArray) {
            for (ChunkSection chunkSection : chunk.getSections()) {
                if (chunkSection == null || !chunkSection.getLight().hasSkyLight()) continue;
                bl = true;
                break block0;
            }
        }
        byteBuf.writeBoolean(bl);
        Types.VAR_INT.writePrimitive(byteBuf, chunkArray.length);
        for (Chunk chunk : chunkArray) {
            byteBuf.writeInt(chunk.getX());
            byteBuf.writeInt(chunk.getZ());
            byteBuf.writeShort(chunk.getBitmask());
        }
        for (Chunk chunk : chunkArray) {
            byteBuf.writeBytes(ChunkType1_8.serialize(chunk));
        }
    }

    public static final class ChunkBulkSection {
        private final int chunkX;
        private final int chunkZ;
        private final int bitmask;
        private final byte[] data;

        public ChunkBulkSection(ByteBuf byteBuf, boolean bl) {
            this.chunkX = byteBuf.readInt();
            this.chunkZ = byteBuf.readInt();
            this.bitmask = byteBuf.readUnsignedShort();
            int n = Integer.bitCount(this.bitmask);
            this.data = new byte[n * (8192 + (bl ? 4096 : 2048)) + 256];
        }

        public void readData(ByteBuf byteBuf) {
            byteBuf.readBytes(this.data);
        }

        public int chunkX() {
            return this.chunkX;
        }

        public int chunkZ() {
            return this.chunkZ;
        }

        public int bitmask() {
            return this.bitmask;
        }

        public byte[] data() {
            return this.data;
        }
    }
}

