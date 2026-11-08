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

public class ChunkSectionType1_9
extends Type<ChunkSection> {
    private static final int GLOBAL_PALETTE = 13;

    public ChunkSectionType1_9() {
        super(ChunkSection.class);
    }

    @Override
    public ChunkSection read(ByteBuf byteBuf) {
        int n;
        int n2 = byteBuf.readUnsignedByte();
        if (n2 < 4) {
            n2 = 4;
        }
        if (n2 > 8) {
            n2 = 13;
        }
        int n3 = Types.VAR_INT.readPrimitive(byteBuf);
        ChunkSectionImpl chunkSectionImpl = n2 != 13 ? new ChunkSectionImpl(true, n3) : new ChunkSectionImpl(true);
        DataPalette dataPalette = chunkSectionImpl.palette(PaletteType.BLOCKS);
        for (int i = 0; i < n3; ++i) {
            if (n2 != 13) {
                dataPalette.addId(Types.VAR_INT.readPrimitive(byteBuf));
                continue;
            }
            Types.VAR_INT.readPrimitive(byteBuf);
        }
        long[] lArray = (long[])Types.LONG_ARRAY_PRIMITIVE.read(byteBuf);
        if (lArray.length > 0 && lArray.length == (n = (int)Math.ceil((double)(4096 * n2) / 64.0))) {
            CompactArrayUtil.iterateCompactArray(n2, 4096, lArray, n2 == 13 ? dataPalette::setIdAt : dataPalette::setPaletteIndexAt);
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
            n = 13;
        }
        byteBuf.writeByte(n);
        if (n != 13) {
            Types.VAR_INT.writePrimitive(byteBuf, dataPalette.size());
            for (int i = 0; i < dataPalette.size(); ++i) {
                Types.VAR_INT.writePrimitive(byteBuf, dataPalette.idByIndex(i));
            }
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, 0);
        }
        long[] lArray = CompactArrayUtil.createCompactArray(n, 4096, n == 13 ? dataPalette::idAt : dataPalette::paletteIndexAt);
        Types.LONG_ARRAY_PRIMITIVE.write(byteBuf, lArray);
    }
}

