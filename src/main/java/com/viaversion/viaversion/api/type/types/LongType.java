/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class LongType
extends Type<Long>
implements TypeConverter<Long> {
    public LongType() {
        super(Long.class);
    }

    @Override
    @Deprecated
    public Long read(ByteBuf byteBuf) {
        return byteBuf.readLong();
    }

    @Override
    @Deprecated
    public void write(ByteBuf byteBuf, Long l) {
        byteBuf.writeLong(l);
    }

    @Override
    public void write(Ops ops, Long l) {
        ops.writeLong(l);
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

    public long readPrimitive(ByteBuf byteBuf) {
        return byteBuf.readLong();
    }

    public void writePrimitive(ByteBuf byteBuf, long l) {
        byteBuf.writeLong(l);
    }

    public static final class OptionalLongType
    extends OptionalType<Long> {
        public OptionalLongType() {
            super(Types.LONG);
        }
    }
}

