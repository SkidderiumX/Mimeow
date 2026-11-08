/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class ShortType
extends Type<Short>
implements TypeConverter<Short> {
    public ShortType() {
        super(Short.class);
    }

    public short readPrimitive(ByteBuf byteBuf) {
        return byteBuf.readShort();
    }

    public void writePrimitive(ByteBuf byteBuf, short s) {
        byteBuf.writeShort(s);
    }

    @Override
    @Deprecated
    public Short read(ByteBuf byteBuf) {
        return byteBuf.readShort();
    }

    @Override
    @Deprecated
    public void write(ByteBuf byteBuf, Short s) {
        byteBuf.writeShort(s.shortValue());
    }

    @Override
    public void write(Ops ops, Short s) {
        ops.writeShort(s);
    }

    @Override
    public Short from(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.shortValue();
        }
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return bl != false ? (short)1 : 0;
        }
        throw new UnsupportedOperationException();
    }
}

