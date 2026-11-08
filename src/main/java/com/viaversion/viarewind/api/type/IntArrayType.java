/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class IntArrayType
extends Type<int[]> {
    public IntArrayType() {
        super(int[].class);
    }

    @Override
    public int[] read(ByteBuf byteBuf) {
        byte by = byteBuf.readByte();
        int[] nArray = new int[by];
        for (byte by2 = 0; by2 < by; by2 = (byte)(by2 + 1)) {
            nArray[by2] = byteBuf.readInt();
        }
        return nArray;
    }

    @Override
    public void write(ByteBuf byteBuf, int[] nArray) {
        byteBuf.writeByte(nArray.length);
        for (int n : nArray) {
            byteBuf.writeInt(n);
        }
    }
}

