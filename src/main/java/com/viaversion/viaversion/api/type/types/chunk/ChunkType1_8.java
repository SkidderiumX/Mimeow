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
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.logging.Level;

public class ChunkType1_8
extends Type<Chunk> {
    private static final ChunkType1_8 WITH_SKYLIGHT = new ChunkType1_8(true);
    private static final ChunkType1_8 WITHOUT_SKYLIGHT = new ChunkType1_8(false);
    private final boolean hasSkyLight;

    public ChunkType1_8(boolean bl) {
        super(Chunk.class);
        this.hasSkyLight = bl;
    }

    public static ChunkType1_8 forEnvironment(Environment environment) {
        return environment == Environment.NORMAL ? WITH_SKYLIGHT : WITHOUT_SKYLIGHT;
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        int n = byteBuf.readInt();
        int n2 = byteBuf.readInt();
        boolean bl = byteBuf.readBoolean();
        int n3 = byteBuf.readUnsignedShort();
        int n4 = Types.VAR_INT.readPrimitive(byteBuf);
        byte[] byArray = new byte[n4];
        byteBuf.readBytes(byArray);
        if (bl && n3 == 0) {
            return new BaseChunk(n, n2, true, false, 0, new ChunkSection[16], null, new ArrayList<CompoundTag>());
        }
        try {
            return ChunkType1_8.deserialize(n, n2, bl, this.hasSkyLight, n3, byArray);
        }
        catch (Throwable throwable) {
            Via.getPlatform().getLogger().log(Level.WARNING, "The server sent an invalid chunk data packet, returning an empty chunk instead", throwable);
            return ChunkUtil.createEmptyChunk(n, n2);
        }
    }

    @Override
    public void write(ByteBuf byteBuf, Chunk chunk) {
        byteBuf.writeInt(chunk.getX());
        byteBuf.writeInt(chunk.getZ());
        byteBuf.writeBoolean(chunk.isFullChunk());
        byteBuf.writeShort(chunk.getBitmask());
        byte[] byArray = ChunkType1_8.serialize(chunk);
        Types.VAR_INT.writePrimitive(byteBuf, byArray.length);
        byteBuf.writeBytes(byArray);
    }

    public static Chunk deserialize(int n, int n2, boolean bl, boolean bl2, int n3, byte[] byArray) {
        int n4;
        ByteBuf byteBuf = Unpooled.wrappedBuffer(byArray);
        ChunkSection[] chunkSectionArray = new ChunkSection[16];
        int[] nArray = null;
        for (n4 = 0; n4 < chunkSectionArray.length; ++n4) {
            if ((n3 & 1 << n4) == 0) continue;
            chunkSectionArray[n4] = (ChunkSection)Types.CHUNK_SECTION1_8.read(byteBuf);
        }
        for (n4 = 0; n4 < chunkSectionArray.length; ++n4) {
            if ((n3 & 1 << n4) == 0) continue;
            chunkSectionArray[n4].getLight().readBlockLight(byteBuf);
        }
        if (bl2) {
            for (n4 = 0; n4 < chunkSectionArray.length; ++n4) {
                if ((n3 & 1 << n4) == 0) continue;
                chunkSectionArray[n4].getLight().readSkyLight(byteBuf);
            }
        }
        if (bl) {
            nArray = new int[256];
            for (n4 = 0; n4 < 256; ++n4) {
                nArray[n4] = byteBuf.readUnsignedByte();
            }
        }
        byteBuf.release();
        return new BaseChunk(n, n2, bl, false, n3, chunkSectionArray, nArray, new ArrayList<CompoundTag>());
    }

    public static byte[] serialize(Chunk chunk) {
        int n;
        ByteBuf byteBuf = Unpooled.buffer();
        for (n = 0; n < chunk.getSections().length; ++n) {
            if ((chunk.getBitmask() & 1 << n) == 0) continue;
            Types.CHUNK_SECTION1_8.write(byteBuf, chunk.getSections()[n]);
        }
        for (n = 0; n < chunk.getSections().length; ++n) {
            if ((chunk.getBitmask() & 1 << n) == 0) continue;
            chunk.getSections()[n].getLight().writeBlockLight(byteBuf);
        }
        for (n = 0; n < chunk.getSections().length; ++n) {
            if ((chunk.getBitmask() & 1 << n) == 0 || !chunk.getSections()[n].getLight().hasSkyLight()) continue;
            chunk.getSections()[n].getLight().writeSkyLight(byteBuf);
        }
        if (chunk.isFullChunk() && chunk.getBiomeData() != null) {
            for (int n2 : chunk.getBiomeData()) {
                byteBuf.writeByte((byte)n2);
            }
        }
        byte[] byArray = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(byArray);
        byteBuf.release();
        return byArray;
    }
}

