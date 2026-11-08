/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class UnsignedShortType
extends Type<Integer>
implements TypeConverter<Integer> {
    public UnsignedShortType() {
        super(Integer.class);
    }

    @Override
    public Integer read(ByteBuf byteBuf) {
        return byteBuf.readUnsignedShort();
    }

    @Override
    public void write(ByteBuf byteBuf, Integer n) {
        byteBuf.writeShort(n);
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

