/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record FoodProperties1_21_2(int nutrition, float saturationModifier, boolean canAlwaysEat) {
    public static final Type<FoodProperties1_21_2> TYPE = new Type<FoodProperties1_21_2>(FoodProperties1_21_2.class){

        @Override
        public FoodProperties1_21_2 read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            float f = byteBuf.readFloat();
            boolean bl = byteBuf.readBoolean();
            return new FoodProperties1_21_2(n, f, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, FoodProperties1_21_2 foodProperties1_21_2) {
            Types.VAR_INT.writePrimitive(byteBuf, foodProperties1_21_2.nutrition);
            byteBuf.writeFloat(foodProperties1_21_2.saturationModifier);
            byteBuf.writeBoolean(foodProperties1_21_2.canAlwaysEat);
        }

        @Override
        public void write(Ops ops, FoodProperties1_21_2 foodProperties1_21_2) {
            ops.writeMap(mapSerializer -> mapSerializer.write("nutrition", Types.VAR_INT, foodProperties1_21_2.nutrition).write("saturation", Types.FLOAT, Float.valueOf(foodProperties1_21_2.saturationModifier)).writeOptional("can_always_eat", Types.BOOLEAN, foodProperties1_21_2.canAlwaysEat, false));
        }
    };
}

