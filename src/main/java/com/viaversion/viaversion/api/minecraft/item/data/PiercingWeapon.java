/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record PiercingWeapon(boolean dealsKnockback, boolean dismounts, @Nullable Holder<SoundEvent> sound, @Nullable Holder<SoundEvent> hitSound) {
    public static final Type<PiercingWeapon> TYPE = new Type<PiercingWeapon>(PiercingWeapon.class){

        @Override
        public PiercingWeapon read(ByteBuf byteBuf) {
            boolean bl = Types.BOOLEAN.read(byteBuf);
            boolean bl2 = Types.BOOLEAN.read(byteBuf);
            Object object = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            Object object2 = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            return new PiercingWeapon(bl, bl2, (Holder<SoundEvent>)object, (Holder<SoundEvent>)object2);
        }

        @Override
        public void write(ByteBuf byteBuf, PiercingWeapon piercingWeapon) {
            Types.BOOLEAN.write(byteBuf, (Boolean)piercingWeapon.dealsKnockback);
            Types.BOOLEAN.write(byteBuf, (Boolean)piercingWeapon.dismounts);
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, piercingWeapon.sound);
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, piercingWeapon.hitSound);
        }

        @Override
        public void write(Ops ops, PiercingWeapon piercingWeapon) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("deals_knockback", Types.BOOLEAN, piercingWeapon.dealsKnockback, true).writeOptional("dismounts", Types.BOOLEAN, piercingWeapon.dismounts, false).writeOptional("sound", Types.SOUND_EVENT, piercingWeapon.sound).writeOptional("hit_sound", Types.SOUND_EVENT, piercingWeapon.hitSound));
        }
    };
}

