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

public class BooleanType
extends Type<Boolean>
implements TypeConverter<Boolean> {
    public BooleanType() {
        super(Boolean.class);
    }

    @Override
    public Boolean read(ByteBuf byteBuf) {
        return byteBuf.readBoolean();
    }

    @Override
    public void write(ByteBuf byteBuf, Boolean bl) {
        byteBuf.writeBoolean(bl);
    }

    @Override
    public Boolean from(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.intValue() == 1;
        }
        return (Boolean)object;
    }

    @Override
    public void write(Ops ops, Boolean bl) {
        ops.writeBoolean(bl);
    }

    public static final class OptionalBooleanType
    extends OptionalType<Boolean> {
        public OptionalBooleanType() {
            super(Types.BOOLEAN);
        }
    }
}

