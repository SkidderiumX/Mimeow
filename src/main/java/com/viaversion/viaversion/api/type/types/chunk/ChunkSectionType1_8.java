/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.nio.ByteOrder;

public class ChunkSectionType1_8
extends Type<ChunkSection> {
    public ChunkSectionType1_8() {
        super(ChunkSection.class);
    }

    @Override
    public ChunkSection read(ByteBuf byteBuf) {
        ChunkSectionImpl chunkSectionImpl = new ChunkSectionImpl(true);
        DataPalette dataPalette = chunkSectionImpl.palette(PaletteType.BLOCKS);
        dataPalette.addId(0);
        ByteBuf byteBuf2 = byteBuf.order(ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < 4096; ++i) {
            dataPalette.setIdAt(i, byteBuf2.readUnsignedShort());
        }
        return chunkSectionImpl;
    }

    @Override
    public void write(ByteBuf byteBuf, ChunkSection chunkSection) {
        DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
        ByteBuf byteBuf2 = byteBuf.order(ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < 4096; ++i) {
            byteBuf2.writeShort(dataPalette.idAt(i));
        }
    }
}

