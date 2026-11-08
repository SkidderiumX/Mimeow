/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class VarLongType
extends Type<Long>
implements TypeConverter<Long> {
    public VarLongType() {
        super("VarLong", Long.class);
    }

    public long readPrimitive(ByteBuf byteBuf) {
        byte by;
        long l = 0L;
        int n = 0;
        do {
            by = byteBuf.readByte();
            l |= (long)(by & 0x7F) << n++ * 7;
            if (n <= 10) continue;
            throw new RuntimeException("VarLong too big");
        } while ((by & 0x80) == 128);
        return l;
    }

    public void writePrimitive(ByteBuf byteBuf, long l) {
        do {
            int n = (int)(l & 0x7FL);
            if ((l >>>= 7) != 0L) {
                n |= 0x80;
            }
            byteBuf.writeByte(n);
        } while (l != 0L);
    }

    @Override
    @Deprecated
    public Long read(ByteBuf byteBuf) {
        return this.readPrimitive(byteBuf);
    }

    @Override
    @Deprecated
    public void write(ByteBuf byteBuf, Long l) {
        this.writePrimitive(byteBuf, l);
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

