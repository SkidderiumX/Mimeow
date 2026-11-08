/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class VarIntArrayType
extends Type<int[]> {
    private final int length;

    public VarIntArrayType(int n) {
        super(int[].class);
        this.length = n;
    }

    public VarIntArrayType() {
        this(-1);
    }

    @Override
    public int[] read(ByteBuf byteBuf) {
        int n = this.length == -1 ? Types.VAR_INT.readPrimitive(byteBuf) : this.length;
        Preconditions.checkArgument(byteBuf.isReadable(n));
        int[] nArray = new int[n];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = Types.VAR_INT.readPrimitive(byteBuf);
        }
        return nArray;
    }

    @Override
    public void write(ByteBuf byteBuf, int[] nArray) {
        if (this.length != -1) {
            Preconditions.checkArgument(this.length == nArray.length, "Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, nArray.length);
        }
        for (int n : nArray) {
            Types.VAR_INT.writePrimitive(byteBuf, n);
        }
    }
}

