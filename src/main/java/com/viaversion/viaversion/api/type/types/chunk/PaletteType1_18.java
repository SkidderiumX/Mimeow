/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.DataPaletteImpl;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.api.type.types.chunk.PaletteTypeBase;
import com.viaversion.viaversion.util.CompactArrayUtil;
import com.viaversion.viaversion.util.MathUtil;
import io.netty.buffer.ByteBuf;

public class PaletteType1_18
extends PaletteTypeBase {
    protected final int globalPaletteBits;
    protected final PaletteType type;

    public PaletteType1_18(PaletteType paletteType, int n) {
        this.globalPaletteBits = n;
        this.type = paletteType;
    }

    @Override
    public DataPalette read(ByteBuf byteBuf) {
        DataPaletteImpl dataPaletteImpl;
        int n = byteBuf.readByte();
        if (n == 0) {
            DataPaletteImpl dataPaletteImpl2 = new DataPaletteImpl(this.type.size(), 1);
            dataPaletteImpl2.addId(Types.VAR_INT.readPrimitive(byteBuf));
            this.readValues(byteBuf, 0, dataPaletteImpl2);
            return dataPaletteImpl2;
        }
        if (n < 0 || n > this.type.highestBitsPerValue()) {
            n = this.globalPaletteBits;
        } else if (this.type == PaletteType.BLOCKS && n < 4) {
            n = 4;
        }
        if (n != this.globalPaletteBits) {
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            dataPaletteImpl = new DataPaletteImpl(this.type.size(), n2);
            for (int i = 0; i < n2; ++i) {
                dataPaletteImpl.addId(Types.VAR_INT.readPrimitive(byteBuf));
            }
        } else {
            dataPaletteImpl = new DataPaletteImpl(this.type.size());
        }
        this.readValues(byteBuf, n, dataPaletteImpl);
        return dataPaletteImpl;
    }

    protected void readValues(ByteBuf byteBuf, int n, DataPaletteImpl dataPaletteImpl) {
        long[] lArray = (long[])Types.LONG_ARRAY_PRIMITIVE.read(byteBuf);
        if (lArray.length == 0 || n == 0) {
            return;
        }
        char c = (char)(64 / n);
        int n2 = (this.type.size() + c - 1) / c;
        if (lArray.length == n2) {
            if (n == this.globalPaletteBits) {
                CompactArrayUtil.iterateCompactArrayWithPadding(n, this.type.size(), lArray, dataPaletteImpl::setIdAt);
            } else {
                dataPaletteImpl.setPaletteIndexes(lArray, n, c);
            }
        }
    }

    @Override
    public void write(ByteBuf byteBuf, DataPalette dataPalette) {
        int n = dataPalette.size();
        if (n == 1) {
            byteBuf.writeByte(0);
            Types.VAR_INT.writePrimitive(byteBuf, dataPalette.idByIndex(0));
            this.writeValues(byteBuf, dataPalette, 0);
            return;
        }
        int n2 = this.bitsPerValue(n);
        byteBuf.writeByte(n2);
        if (n2 != this.globalPaletteBits) {
            Types.VAR_INT.writePrimitive(byteBuf, n);
            for (int i = 0; i < n; ++i) {
                Types.VAR_INT.writePrimitive(byteBuf, dataPalette.idByIndex(i));
            }
        }
        this.writeValues(byteBuf, dataPalette, n2);
    }

    protected void writeValues(ByteBuf byteBuf, DataPalette dataPalette, int n) {
        if (n == 0) {
            Types.VAR_INT.writePrimitive(byteBuf, 0);
            return;
        }
        long[] lArray = dataPalette.createPackedValues(n, this.type.size(), n == this.globalPaletteBits);
        Types.LONG_ARRAY_PRIMITIVE.write(byteBuf, lArray);
    }

    private int bitsPerValue(int n) {
        int n2 = this.type == PaletteType.BLOCKS ? 4 : 1;
        int n3 = Math.max(n2, MathUtil.ceilLog2(n));
        if (n3 > this.type.highestBitsPerValue()) {
            n3 = this.globalPaletteBits;
        }
        return n3;
    }

    @Override
    public int serializedSize(DataPalette dataPalette) {
        int n;
        int n2 = dataPalette.size();
        int n3 = this.bitsPerValue(n2);
        int n4 = 0;
        if (n2 == 1) {
            n4 = VarIntType.varIntLength(dataPalette.idByIndex(0));
            n = this.serializedValuesSize(0);
        } else {
            int n5;
            if (n3 != this.globalPaletteBits) {
                n4 = VarIntType.varIntLength(n2);
                for (n5 = 0; n5 < n2; ++n5) {
                    n4 += VarIntType.varIntLength(dataPalette.idByIndex(n5));
                }
            }
            n5 = 64 / n3;
            int n6 = (this.type.size() + n5 - 1) / n5;
            n = this.serializedValuesSize(n6);
        }
        return 1 + n4 + n;
    }

    protected int serializedValuesSize(int n) {
        return VarIntType.varIntLength(n) + 8 * n;
    }
}

