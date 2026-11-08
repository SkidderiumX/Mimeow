/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class FloatArrayType
extends Type<float[]> {
    private final int length;

    public FloatArrayType(int n) {
        super(float[].class);
        this.length = n;
    }

    public FloatArrayType() {
        super(float[].class);
        this.length = -1;
    }

    @Override
    public void write(ByteBuf byteBuf, float[] fArray) {
        if (this.length != -1) {
            Preconditions.checkArgument(this.length == fArray.length, "Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, fArray.length);
        }
        for (float f : fArray) {
            byteBuf.writeFloat(f);
        }
    }

    @Override
    public float[] read(ByteBuf byteBuf) {
        int n = this.length == -1 ? Types.VAR_INT.readPrimitive(byteBuf) : this.length;
        Preconditions.checkArgument(byteBuf.isReadable(n), "Length is fewer than readable bytes");
        float[] fArray = new float[n];
        for (int i = 0; i < n; ++i) {
            fArray[i] = byteBuf.readFloat();
        }
        return fArray;
    }
}

