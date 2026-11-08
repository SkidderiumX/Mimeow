/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.types.chunk.ChunkSectionType1_18;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_21_5;
import io.netty.buffer.ByteBuf;

public class ChunkSectionType26_1
extends ChunkSectionType1_18 {
    public ChunkSectionType26_1(int n, int n2) {
        super(new PaletteType1_21_5(PaletteType.BLOCKS, n), new PaletteType1_21_5(PaletteType.BIOMES, n2));
    }

    @Override
    public ChunkSection read(ByteBuf byteBuf) {
        ChunkSectionImpl chunkSectionImpl = new ChunkSectionImpl();
        chunkSectionImpl.setNonAirBlocksCount(byteBuf.readShort());
        chunkSectionImpl.setFluidCount(byteBuf.readShort());
        chunkSectionImpl.addPalette(PaletteType.BLOCKS, (DataPalette)this.blockPaletteType.read(byteBuf));
        chunkSectionImpl.addPalette(PaletteType.BIOMES, (DataPalette)this.biomePaletteType.read(byteBuf));
        return chunkSectionImpl;
    }

    @Override
    public void write(ByteBuf byteBuf, ChunkSection chunkSection) {
        byteBuf.writeShort(chunkSection.getNonAirBlocksCount());
        byteBuf.writeShort(chunkSection.getFluidCount());
        this.blockPaletteType.write(byteBuf, chunkSection.palette(PaletteType.BLOCKS));
        this.biomePaletteType.write(byteBuf, chunkSection.palette(PaletteType.BIOMES));
    }

    @Override
    public int serializedSize(Chunk chunk) {
        int n = 0;
        for (ChunkSection chunkSection : chunk.getSections()) {
            n += 4 + this.blockPaletteType.serializedSize(chunkSection.palette(PaletteType.BLOCKS)) + this.biomePaletteType.serializedSize(chunkSection.palette(PaletteType.BIOMES));
        }
        return n;
    }
}

