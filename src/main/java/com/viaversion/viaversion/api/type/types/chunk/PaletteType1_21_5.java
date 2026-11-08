/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.DataPaletteImpl;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.types.LongArrayType;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_18;
import com.viaversion.viaversion.util.CompactArrayUtil;
import io.netty.buffer.ByteBuf;

public class PaletteType1_21_5
extends PaletteType1_18 {
    public PaletteType1_21_5(PaletteType paletteType, int n) {
        super(paletteType, n);
    }

    @Override
    protected void readValues(ByteBuf byteBuf, int n, DataPaletteImpl dataPaletteImpl) {
        if (n == 0) {
            return;
        }
        char c = (char)(64 / n);
        int n2 = (this.type.size() + c - 1) / c;
        long[] lArray = LongArrayType.readFixedLength(byteBuf, n2);
        if (lArray.length != 0) {
            if (n == this.globalPaletteBits) {
                CompactArrayUtil.iterateCompactArrayWithPadding(n, this.type.size(), lArray, dataPaletteImpl::setIdAt);
            } else {
                dataPaletteImpl.setPaletteIndexes(lArray, n, c);
            }
        }
    }

    @Override
    protected void writeValues(ByteBuf byteBuf, DataPalette dataPalette, int n) {
        if (n == 0) {
            return;
        }
        long[] lArray = dataPalette.createPackedValues(n, this.type.size(), n == this.globalPaletteBits);
        LongArrayType.writeFixedLength(byteBuf, lArray);
    }

    @Override
    protected int serializedValuesSize(int n) {
        return 8 * n;
    }
}

