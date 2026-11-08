/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record FoodProperties1_20_5(int nutrition, float saturationModifier, boolean canAlwaysEat, float eatSeconds, @Nullable Item usingConvertsTo, FoodEffect[] possibleEffects) implements Copyable
{
    public static final Type<FoodProperties1_20_5> TYPE1_20_5 = new Type<FoodProperties1_20_5>(FoodProperties1_20_5.class){

        @Override
        public FoodProperties1_20_5 read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            float f = byteBuf.readFloat();
            boolean bl = byteBuf.readBoolean();
            float f2 = byteBuf.readFloat();
            FoodEffect[] foodEffectArray = (FoodEffect[])FoodEffect.ARRAY_TYPE.read(byteBuf);
            return new FoodProperties1_20_5(n, f, bl, f2, null, foodEffectArray);
        }

        @Override
        public void write(ByteBuf byteBuf, FoodProperties1_20_5 foodProperties1_20_5) {
            Types.VAR_INT.writePrimitive(byteBuf, foodProperties1_20_5.nutrition);
            byteBuf.writeFloat(foodProperties1_20_5.saturationModifier);
            byteBuf.writeBoolean(foodProperties1_20_5.canAlwaysEat);
            byteBuf.writeFloat(foodProperties1_20_5.eatSeconds);
            FoodEffect.ARRAY_TYPE.write(byteBuf, foodProperties1_20_5.possibleEffects);
        }
    };
    public static final Type<FoodProperties1_20_5> TYPE1_21 = new Type<FoodProperties1_20_5>(FoodProperties1_20_5.class){

        @Override
        public FoodProperties1_20_5 read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            float f = byteBuf.readFloat();
            boolean bl = byteBuf.readBoolean();
            float f2 = byteBuf.readFloat();
            Item item = (Item)VersionedTypes.V1_21.optionalItem.read(byteBuf);
            FoodEffect[] foodEffectArray = (FoodEffect[])FoodEffect.ARRAY_TYPE.read(byteBuf);
            return new FoodProperties1_20_5(n, f, bl, f2, item, foodEffectArray);
        }

        @Override
        public void write(ByteBuf byteBuf, FoodProperties1_20_5 foodProperties1_20_5) {
            Types.VAR_INT.writePrimitive(byteBuf, foodProperties1_20_5.nutrition);
            byteBuf.writeFloat(foodProperties1_20_5.saturationModifier);
            byteBuf.writeBoolean(foodProperties1_20_5.canAlwaysEat);
            byteBuf.writeFloat(foodProperties1_20_5.eatSeconds);
            VersionedTypes.V1_21.optionalItem.write(byteBuf, foodProperties1_20_5.usingConvertsTo);
            FoodEffect.ARRAY_TYPE.write(byteBuf, foodProperties1_20_5.possibleEffects);
        }
    };

    @Override
    public FoodProperties1_20_5 copy() {
        return new FoodProperties1_20_5(this.nutrition, this.saturationModifier, this.canAlwaysEat, this.eatSeconds, this.usingConvertsTo == null ? null : this.usingConvertsTo.copy(), Copyable.copy(this.possibleEffects));
    }

    public record FoodEffect(PotionEffect effect, float probability) {
        public static final Type<FoodEffect> TYPE = new Type<FoodEffect>(FoodEffect.class){

            @Override
            public FoodEffect read(ByteBuf byteBuf) {
                PotionEffect potionEffect = (PotionEffect)PotionEffect.TYPE.read(byteBuf);
                float f = byteBuf.readFloat();
                return new FoodEffect(potionEffect, f);
            }

            @Override
            public void write(ByteBuf byteBuf, FoodEffect foodEffect) {
                PotionEffect.TYPE.write(byteBuf, foodEffect.effect);
                byteBuf.writeFloat(foodEffect.probability);
            }
        };
        public static final Type<FoodEffect[]> ARRAY_TYPE = new ArrayType<FoodEffect>(TYPE);
    }
}

