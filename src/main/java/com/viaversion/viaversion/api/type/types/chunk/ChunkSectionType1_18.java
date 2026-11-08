/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_18;
import com.viaversion.viaversion.api.type.types.chunk.PaletteTypeBase;
import io.netty.buffer.ByteBuf;

public class ChunkSectionType1_18
extends Type<ChunkSection> {
    protected final PaletteTypeBase blockPaletteType;
    protected final PaletteTypeBase biomePaletteType;

    public ChunkSectionType1_18(int n, int n2) {
        super(ChunkSection.class);
        this.blockPaletteType = new PaletteType1_18(PaletteType.BLOCKS, n);
        this.biomePaletteType = new PaletteType1_18(PaletteType.BIOMES, n2);
    }

    protected ChunkSectionType1_18(PaletteTypeBase paletteTypeBase, PaletteTypeBase paletteTypeBase2) {
        super(ChunkSection.class);
        this.blockPaletteType = paletteTypeBase;
        this.biomePaletteType = paletteTypeBase2;
    }

    @Override
    public ChunkSection read(ByteBuf byteBuf) {
        ChunkSectionImpl chunkSectionImpl = new ChunkSectionImpl();
        chunkSectionImpl.setNonAirBlocksCount(byteBuf.readShort());
        chunkSectionImpl.addPalette(PaletteType.BLOCKS, (DataPalette)this.blockPaletteType.read(byteBuf));
        chunkSectionImpl.addPalette(PaletteType.BIOMES, (DataPalette)this.biomePaletteType.read(byteBuf));
        return chunkSectionImpl;
    }

    @Override
    public void write(ByteBuf byteBuf, ChunkSection chunkSection) {
        byteBuf.writeShort(chunkSection.getNonAirBlocksCount());
        this.blockPaletteType.write(byteBuf, chunkSection.palette(PaletteType.BLOCKS));
        this.biomePaletteType.write(byteBuf, chunkSection.palette(PaletteType.BIOMES));
    }

    public int serializedSize(Chunk chunk) {
        int n = 0;
        for (ChunkSection chunkSection : chunk.getSections()) {
            n += 2 + this.blockPaletteType.serializedSize(chunkSection.palette(PaletteType.BLOCKS)) + this.biomePaletteType.serializedSize(chunkSection.palette(PaletteType.BIOMES));
        }
        return n;
    }
}

