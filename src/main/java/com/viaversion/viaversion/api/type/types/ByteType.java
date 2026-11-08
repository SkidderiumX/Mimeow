/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class ByteType
extends Type<Byte>
implements TypeConverter<Byte> {
    public ByteType() {
        super(Byte.class);
    }

    public byte readPrimitive(ByteBuf byteBuf) {
        return byteBuf.readByte();
    }

    public void writePrimitive(ByteBuf byteBuf, byte by) {
        byteBuf.writeByte(by);
    }

    @Override
    @Deprecated
    public Byte read(ByteBuf byteBuf) {
        return byteBuf.readByte();
    }

    @Override
    @Deprecated
    public void write(ByteBuf byteBuf, Byte by) {
        byteBuf.writeByte(by.byteValue());
    }

    @Override
    public void write(Ops ops, Byte by) {
        ops.writeByte(by);
    }

    @Override
    public Byte from(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.byteValue();
        }
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return bl != false ? (byte)1 : 0;
        }
        throw new UnsupportedOperationException();
    }
}

