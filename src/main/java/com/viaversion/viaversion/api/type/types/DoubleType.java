/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class DoubleType
extends Type<Double>
implements TypeConverter<Double> {
    public DoubleType() {
        super(Double.class);
    }

    @Override
    @Deprecated
    public Double read(ByteBuf byteBuf) {
        return byteBuf.readDouble();
    }

    public double readPrimitive(ByteBuf byteBuf) {
        return byteBuf.readDouble();
    }

    @Override
    @Deprecated
    public void write(ByteBuf byteBuf, Double d) {
        byteBuf.writeDouble(d);
    }

    public void writePrimitive(ByteBuf byteBuf, double d) {
        byteBuf.writeDouble(d);
    }

    @Override
    public void write(Ops ops, Double d) {
        ops.writeDouble(d);
    }

    @Override
    public Double from(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.doubleValue();
        }
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return bl != false ? 1.0 : 0.0;
        }
        throw new UnsupportedOperationException();
    }
}

