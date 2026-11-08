/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class BooleanArrayType
extends Type<boolean[]> {
    private final int length;

    public BooleanArrayType(int n) {
        super(boolean[].class);
        this.length = n;
    }

    public BooleanArrayType() {
        super(boolean[].class);
        this.length = -1;
    }

    @Override
    public void write(ByteBuf byteBuf, boolean[] blArray) {
        if (this.length != -1) {
            Preconditions.checkArgument(this.length == blArray.length, "Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, blArray.length);
        }
        for (boolean bl : blArray) {
            byteBuf.writeBoolean(bl);
        }
    }

    @Override
    public boolean[] read(ByteBuf byteBuf) {
        int n = this.length == -1 ? Types.VAR_INT.readPrimitive(byteBuf) : this.length;
        Preconditions.checkArgument(byteBuf.isReadable(n), "Length is fewer than readable bytes");
        boolean[] blArray = new boolean[n];
        for (int i = 0; i < n; ++i) {
            blArray[i] = byteBuf.readBoolean();
        }
        return blArray;
    }
}

