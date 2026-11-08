/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class IntArrayType
extends Type<int[]> {
    private final int length;

    public IntArrayType(int n) {
        super(int[].class);
        this.length = n;
    }

    public IntArrayType() {
        super(int[].class);
        this.length = -1;
    }

    @Override
    public void write(ByteBuf byteBuf, int[] nArray) {
        if (this.length != -1) {
            Preconditions.checkArgument(this.length == nArray.length, "Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, nArray.length);
        }
        for (int n : nArray) {
            byteBuf.writeInt(n);
        }
    }

    @Override
    public int[] read(ByteBuf byteBuf) {
        int n = this.length == -1 ? Types.VAR_INT.readPrimitive(byteBuf) : this.length;
        Preconditions.checkArgument(byteBuf.isReadable(n), "Length is fewer than readable bytes");
        int[] nArray = new int[n];
        for (int i = 0; i < n; ++i) {
            nArray[i] = byteBuf.readInt();
        }
        return nArray;
    }

    @Override
    public void write(Ops ops, int[] nArray) {
        ops.writeInts(nArray);
    }
}

