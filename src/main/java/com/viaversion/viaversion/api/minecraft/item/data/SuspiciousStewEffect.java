/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;

public record SuspiciousStewEffect(int mobEffect, int duration) {
    public static final Type<SuspiciousStewEffect> TYPE = new Type<SuspiciousStewEffect>(SuspiciousStewEffect.class){

        @Override
        public SuspiciousStewEffect read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            return new SuspiciousStewEffect(n, n2);
        }

        @Override
        public void write(ByteBuf byteBuf, SuspiciousStewEffect suspiciousStewEffect) {
            Types.VAR_INT.writePrimitive(byteBuf, suspiciousStewEffect.mobEffect);
            Types.VAR_INT.writePrimitive(byteBuf, suspiciousStewEffect.duration);
        }

        @Override
        public void write(Ops ops, SuspiciousStewEffect suspiciousStewEffect) {
            ops.writeMap(mapSerializer -> mapSerializer.write("id", EnumTypes.MOB_EFFECT, suspiciousStewEffect.mobEffect).writeOptional("duration", Types.INT, suspiciousStewEffect.duration, 160));
        }
    };
    public static final Type<SuspiciousStewEffect[]> ARRAY_TYPE = new ArrayType<SuspiciousStewEffect>(TYPE);
}

