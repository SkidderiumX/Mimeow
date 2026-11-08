/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class OptionalVarIntType
extends Type<Integer> {
    public OptionalVarIntType() {
        super(Integer.class);
    }

    @Override
    public Integer read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        return n == 0 ? null : Integer.valueOf(n - 1);
    }

    @Override
    public void write(ByteBuf byteBuf, Integer n) {
        if (n == null) {
            Types.VAR_INT.writePrimitive(byteBuf, 0);
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, n + 1);
        }
    }
}

