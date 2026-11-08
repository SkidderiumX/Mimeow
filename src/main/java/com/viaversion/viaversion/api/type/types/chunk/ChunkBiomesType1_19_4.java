/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_18;
import com.viaversion.viaversion.api.type.types.chunk.PaletteTypeBase;
import io.netty.buffer.ByteBuf;

public class ChunkBiomesType1_19_4
extends Type<DataPalette[]> {
    private final PaletteTypeBase paletteType;
    private final int ySectionCount;

    public ChunkBiomesType1_19_4(int n, int n2) {
        this(n, new PaletteType1_18(PaletteType.BIOMES, n2));
    }

    protected ChunkBiomesType1_19_4(int n, PaletteTypeBase paletteTypeBase) {
        super(DataPalette[].class);
        this.paletteType = paletteTypeBase;
        this.ySectionCount = n;
    }

    @Override
    public DataPalette[] read(ByteBuf byteBuf) {
        ByteBuf byteBuf2 = byteBuf.readSlice(Types.VAR_INT.readPrimitive(byteBuf));
        DataPalette[] dataPaletteArray = new DataPalette[this.ySectionCount];
        for (int i = 0; i < this.ySectionCount; ++i) {
            dataPaletteArray[i] = (DataPalette)this.paletteType.read(byteBuf2);
        }
        return dataPaletteArray;
    }

    @Override
    public void write(ByteBuf byteBuf, DataPalette[] dataPaletteArray) {
        int n = 0;
        for (DataPalette dataPalette : dataPaletteArray) {
            n += this.paletteType.serializedSize(dataPalette);
        }
        Types.VAR_INT.writePrimitive(byteBuf, n);
        for (DataPalette dataPalette : dataPaletteArray) {
            this.paletteType.write(byteBuf, dataPalette);
        }
    }
}

