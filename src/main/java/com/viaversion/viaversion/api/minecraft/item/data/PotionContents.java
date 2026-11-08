/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record PotionContents(@Nullable Integer potion, @Nullable Integer customColor, PotionEffect[] customEffects, @Nullable String customName) implements Copyable
{
    public static final Type<PotionContents> TYPE1_20_5 = new Type<PotionContents>(PotionContents.class){

        @Override
        public PotionContents read(ByteBuf byteBuf) {
            Integer n = byteBuf.readBoolean() ? Integer.valueOf(Types.VAR_INT.readPrimitive(byteBuf)) : null;
            Integer n2 = byteBuf.readBoolean() ? Integer.valueOf(byteBuf.readInt()) : null;
            PotionEffect[] potionEffectArray = (PotionEffect[])PotionEffect.ARRAY_TYPE.read(byteBuf);
            return new PotionContents(n, n2, potionEffectArray, null);
        }

        @Override
        public void write(ByteBuf byteBuf, PotionContents potionContents) {
            byteBuf.writeBoolean(potionContents.potion != null);
            if (potionContents.potion != null) {
                Types.VAR_INT.writePrimitive(byteBuf, potionContents.potion);
            }
            byteBuf.writeBoolean(potionContents.customColor != null);
            if (potionContents.customColor != null) {
                byteBuf.writeInt(potionContents.customColor);
            }
            PotionEffect.ARRAY_TYPE.write(byteBuf, potionContents.customEffects);
        }
    };
    public static final Type<PotionContents> TYPE1_21_2 = new Type<PotionContents>(PotionContents.class){

        @Override
        public PotionContents read(ByteBuf byteBuf) {
            Integer n = byteBuf.readBoolean() ? Integer.valueOf(Types.VAR_INT.readPrimitive(byteBuf)) : null;
            Integer n2 = byteBuf.readBoolean() ? Integer.valueOf(byteBuf.readInt()) : null;
            PotionEffect[] potionEffectArray = (PotionEffect[])PotionEffect.ARRAY_TYPE.read(byteBuf);
            String string = (String)Types.OPTIONAL_STRING.read(byteBuf);
            return new PotionContents(n, n2, potionEffectArray, string);
        }

        @Override
        public void write(ByteBuf byteBuf, PotionContents potionContents) {
            byteBuf.writeBoolean(potionContents.potion != null);
            if (potionContents.potion != null) {
                Types.VAR_INT.writePrimitive(byteBuf, potionContents.potion);
            }
            byteBuf.writeBoolean(potionContents.customColor != null);
            if (potionContents.customColor != null) {
                byteBuf.writeInt(potionContents.customColor);
            }
            PotionEffect.ARRAY_TYPE.write(byteBuf, potionContents.customEffects);
            Types.OPTIONAL_STRING.write(byteBuf, potionContents.customName);
        }

        @Override
        public void write(Ops ops, PotionContents potionContents) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("potion", EnumTypes.POTION, potionContents.potion).writeOptional("custom_color", Types.INT, potionContents.customColor).writeOptional("custom_effects", PotionEffect.ARRAY_TYPE, potionContents.customEffects, new PotionEffect[0]).writeOptional("custom_name", Types.STRING, potionContents.customName));
        }
    };

    public PotionContents(@Nullable Integer n, @Nullable Integer n2, PotionEffect[] potionEffectArray) {
        this(n, n2, potionEffectArray, null);
    }

    @Override
    public PotionContents copy() {
        return new PotionContents(this.potion, this.customColor, Copyable.copy(this.customEffects), this.customName);
    }
}

