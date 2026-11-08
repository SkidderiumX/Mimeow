/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class UnsignedIntType
extends Type<Long>
implements TypeConverter<Long> {
    public static final long MAX_UNSIGNED_INT = 0xFFFFFFFFL;

    public UnsignedIntType() {
        super(Long.class);
    }

    @Override
    public Long read(ByteBuf byteBuf) {
        return byteBuf.readUnsignedInt();
    }

    public long readPrimitive(ByteBuf byteBuf) {
        return byteBuf.readUnsignedInt();
    }

    @Override
    public void write(ByteBuf byteBuf, Long l) {
        byteBuf.writeInt(l.intValue());
    }

    public void writePrimitive(ByteBuf byteBuf, long l) {
        byteBuf.writeInt((int)l);
    }

    @Override
    public Long from(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.longValue();
        }
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return bl != false ? 1L : 0L;
        }
        throw new UnsupportedOperationException();
    }
}

