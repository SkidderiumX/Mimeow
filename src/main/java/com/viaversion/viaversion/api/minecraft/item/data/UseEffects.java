/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record UseEffects(boolean canSprint, boolean interactVibrations, float speedMultiplier) {
    public static final Type<UseEffects> TYPE = new Type<UseEffects>(UseEffects.class){

        @Override
        public UseEffects read(ByteBuf byteBuf) {
            boolean bl = Types.BOOLEAN.read(byteBuf);
            boolean bl2 = Types.BOOLEAN.read(byteBuf);
            float f = Types.FLOAT.readPrimitive(byteBuf);
            return new UseEffects(bl, bl2, f);
        }

        @Override
        public void write(ByteBuf byteBuf, UseEffects useEffects) {
            Types.BOOLEAN.write(byteBuf, (Boolean)useEffects.canSprint());
            Types.BOOLEAN.write(byteBuf, (Boolean)useEffects.interactVibrations());
            Types.FLOAT.writePrimitive(byteBuf, useEffects.speedMultiplier());
        }

        @Override
        public void write(Ops ops, UseEffects useEffects) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("can_sprint", Types.BOOLEAN, useEffects.canSprint, false).writeOptional("interact_vibrations", Types.BOOLEAN, useEffects.interactVibrations, true).writeOptional("speed_multiplier", Types.FLOAT, Float.valueOf(useEffects.speedMultiplier), Float.valueOf(0.2f)));
        }
    };
}

