/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class IntType
extends Type<Integer>
implements TypeConverter<Integer> {
    public IntType() {
        super(Integer.class);
    }

    @Override
    public Integer read(ByteBuf byteBuf) {
        return byteBuf.readInt();
    }

    public int readPrimitive(ByteBuf byteBuf) {
        return byteBuf.readInt();
    }

    @Override
    public void write(ByteBuf byteBuf, Integer n) {
        byteBuf.writeInt(n);
    }

    public void writePrimitive(ByteBuf byteBuf, int n) {
        byteBuf.writeInt(n);
    }

    @Override
    public void write(Ops ops, Integer n) {
        ops.writeInt(n);
    }

    @Override
    public Integer from(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.intValue();
        }
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return bl != false ? 1 : 0;
        }
        throw new UnsupportedOperationException();
    }
}

