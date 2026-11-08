/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record PotionEffectData(int amplifier, int duration, boolean ambient, boolean showParticles, boolean showIcon, @Nullable PotionEffectData hiddenEffect) {
    public static final Type<PotionEffectData> TYPE = new Type<PotionEffectData>(PotionEffectData.class){

        @Override
        public PotionEffectData read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            boolean bl = byteBuf.readBoolean();
            boolean bl2 = byteBuf.readBoolean();
            boolean bl3 = byteBuf.readBoolean();
            PotionEffectData potionEffectData = (PotionEffectData)OPTIONAL_TYPE.read(byteBuf);
            return new PotionEffectData(n, n2, bl, bl2, bl3, potionEffectData);
        }

        @Override
        public void write(ByteBuf byteBuf, PotionEffectData potionEffectData) {
            Types.VAR_INT.writePrimitive(byteBuf, potionEffectData.amplifier);
            Types.VAR_INT.writePrimitive(byteBuf, potionEffectData.duration);
            byteBuf.writeBoolean(potionEffectData.ambient);
            byteBuf.writeBoolean(potionEffectData.showParticles);
            byteBuf.writeBoolean(potionEffectData.showIcon);
            OPTIONAL_TYPE.write(byteBuf, potionEffectData.hiddenEffect);
        }

        @Override
        public void write(Ops ops, PotionEffectData potionEffectData) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("amplifier", Types.UNSIGNED_BYTE, (short)potionEffectData.amplifier, (short)0).writeOptional("duration", Types.INT, potionEffectData.duration, 0).writeOptional("ambient", Types.BOOLEAN, potionEffectData.ambient, false).writeOptional("show_particles", Types.BOOLEAN, potionEffectData.showParticles, true).writeOptional("show_icon", Types.BOOLEAN, potionEffectData.showIcon).writeOptional("hidden_effect", TYPE, potionEffectData.hiddenEffect));
        }
    };
    public static final Type<PotionEffectData> OPTIONAL_TYPE = new OptionalType<PotionEffectData>(TYPE){};
}

