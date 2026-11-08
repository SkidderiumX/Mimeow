/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;

public record PotionEffect(int effect, PotionEffectData effectData) {
    public static final Type<PotionEffect> TYPE = new Type<PotionEffect>(PotionEffect.class){

        @Override
        public PotionEffect read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            PotionEffectData potionEffectData = (PotionEffectData)PotionEffectData.TYPE.read(byteBuf);
            return new PotionEffect(n, potionEffectData);
        }

        @Override
        public void write(ByteBuf byteBuf, PotionEffect potionEffect) {
            Types.VAR_INT.writePrimitive(byteBuf, potionEffect.effect);
            PotionEffectData.TYPE.write(byteBuf, potionEffect.effectData);
        }

        @Override
        public void write(Ops ops, PotionEffect potionEffect) {
            ops.writeMap(mapSerializer -> mapSerializer.write("id", EnumTypes.MOB_EFFECT, potionEffect.effect).writeInlinedMap(PotionEffectData.TYPE, potionEffect.effectData));
        }
    };
    public static final Type<PotionEffect[]> ARRAY_TYPE = new ArrayType<PotionEffect>(TYPE);
}

