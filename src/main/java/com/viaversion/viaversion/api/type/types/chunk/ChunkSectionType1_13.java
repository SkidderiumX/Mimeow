/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.CompactArrayUtil;
import io.netty.buffer.ByteBuf;

public class ChunkSectionType1_13
extends Type<ChunkSection> {
    private static final int GLOBAL_PALETTE = 14;

    public ChunkSectionType1_13() {
        super(ChunkSection.class);
    }

    @Override
    public ChunkSection read(ByteBuf byteBuf) {
        int n;
        long[] lArray;
        ChunkSectionImpl chunkSectionImpl;
        int n2 = byteBuf.readUnsignedByte();
        if (n2 > 8) {
            n2 = 14;
        } else if (n2 < 4) {
            n2 = 4;
        }
        if (n2 != 14) {
            int n3 = Types.VAR_INT.readPrimitive(byteBuf);
            chunkSectionImpl = new ChunkSectionImpl(true, n3);
            DataPalette dataPalette = chunkSectionImpl.palette(PaletteType.BLOCKS);
            for (int i = 0; i < n3; ++i) {
                dataPalette.addId(Types.VAR_INT.readPrimitive(byteBuf));
            }
        } else {
            chunkSectionImpl = new ChunkSectionImpl(true);
        }
        if ((lArray = (long[])Types.LONG_ARRAY_PRIMITIVE.read(byteBuf)).length > 0 && lArray.length == (n = (int)Math.ceil((double)(4096 * n2) / 64.0))) {
            DataPalette dataPalette = chunkSectionImpl.palette(PaletteType.BLOCKS);
            CompactArrayUtil.iterateCompactArray(n2, 4096, lArray, n2 == 14 ? dataPalette::setIdAt : dataPalette::setPaletteIndexAt);
        }
        return chunkSectionImpl;
    }

    @Override
    public void write(ByteBuf byteBuf, ChunkSection chunkSection) {
        int n = 4;
        DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
        while (dataPalette.size() > 1 << n) {
            ++n;
        }
        if (n > 8) {
            n = 14;
        }
        byteBuf.writeByte(n);
        if (n != 14) {
            Types.VAR_INT.writePrimitive(byteBuf, dataPalette.size());
            for (int i = 0; i < dataPalette.size(); ++i) {
                Types.VAR_INT.writePrimitive(byteBuf, dataPalette.idByIndex(i));
            }
        }
        long[] lArray = CompactArrayUtil.createCompactArray(n, 4096, n == 14 ? dataPalette::idAt : dataPalette::paletteIndexAt);
        Types.LONG_ARRAY_PRIMITIVE.write(byteBuf, lArray);
    }
}

