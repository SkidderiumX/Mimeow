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

public class FloatType
extends Type<Float>
implements TypeConverter<Float> {
    public FloatType() {
        super(Float.class);
    }

    public float readPrimitive(ByteBuf byteBuf) {
        return byteBuf.readFloat();
    }

    public void writePrimitive(ByteBuf byteBuf, float f) {
        byteBuf.writeFloat(f);
    }

    @Override
    @Deprecated
    public Float read(ByteBuf byteBuf) {
        return Float.valueOf(byteBuf.readFloat());
    }

    @Override
    @Deprecated
    public void write(ByteBuf byteBuf, Float f) {
        byteBuf.writeFloat(f.floatValue());
    }

    @Override
    public Float from(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return Float.valueOf(number.floatValue());
        }
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return Float.valueOf(bl != false ? 1.0f : 0.0f);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(Ops ops, Float f) {
        ops.writeFloat(f.floatValue());
    }

    public static final class OptionalFloatType
    extends OptionalType<Float> {
        public OptionalFloatType() {
            super(Types.FLOAT);
        }
    }
}

