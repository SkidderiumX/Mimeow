/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class UnsignedByteType
extends Type<Short>
implements TypeConverter<Short> {
    public static final int MAX_VALUE = 255;

    public UnsignedByteType() {
        super("Unsigned Byte", Short.class);
    }

    @Override
    public Short read(ByteBuf byteBuf) {
        return byteBuf.readUnsignedByte();
    }

    @Override
    public void write(ByteBuf byteBuf, Short s) {
        byteBuf.writeByte(s.shortValue());
    }

    @Override
    public void write(Ops ops, Short s) {
        Types.BYTE.write(ops, (Byte)((byte)(s & 0xFF)));
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

