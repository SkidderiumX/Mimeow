/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record KineticWeapon(int contactCooldownTicks, int delayTicks, @Nullable Condition dismountConditions, @Nullable Condition knockbackConditions, @Nullable Condition damageConditions, float forwardMovement, float damageMultiplier, @Nullable Holder<SoundEvent> sound, @Nullable Holder<SoundEvent> hitSound) {
    public static final Type<KineticWeapon> TYPE = new Type<KineticWeapon>(KineticWeapon.class){

        @Override
        public KineticWeapon read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            Condition condition = (Condition)Condition.OPTIONAL_TYPE.read(byteBuf);
            Condition condition2 = (Condition)Condition.OPTIONAL_TYPE.read(byteBuf);
            Condition condition3 = (Condition)Condition.OPTIONAL_TYPE.read(byteBuf);
            float f = Types.FLOAT.readPrimitive(byteBuf);
            float f2 = Types.FLOAT.readPrimitive(byteBuf);
            Object object = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            Object object2 = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            return new KineticWeapon(n, n2, condition, condition2, condition3, f, f2, (Holder<SoundEvent>)object, (Holder<SoundEvent>)object2);
        }

        @Override
        public void write(ByteBuf byteBuf, KineticWeapon kineticWeapon) {
            Types.VAR_INT.writePrimitive(byteBuf, kineticWeapon.contactCooldownTicks);
            Types.VAR_INT.writePrimitive(byteBuf, kineticWeapon.delayTicks);
            Condition.OPTIONAL_TYPE.write(byteBuf, kineticWeapon.dismountConditions);
            Condition.OPTIONAL_TYPE.write(byteBuf, kineticWeapon.knockbackConditions);
            Condition.OPTIONAL_TYPE.write(byteBuf, kineticWeapon.damageConditions);
            Types.FLOAT.writePrimitive(byteBuf, kineticWeapon.forwardMovement);
            Types.FLOAT.writePrimitive(byteBuf, kineticWeapon.damageMultiplier);
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, kineticWeapon.sound);
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, kineticWeapon.hitSound);
        }

        @Override
        public void write(Ops ops, KineticWeapon kineticWeapon) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("contact_cooldown_ticks", Types.INT, kineticWeapon.contactCooldownTicks, 10).writeOptional("delay_ticks", Types.INT, kineticWeapon.delayTicks, 0).writeOptional("dismount_conditions", Condition.TYPE, kineticWeapon.dismountConditions).writeOptional("knockback_conditions", Condition.TYPE, kineticWeapon.knockbackConditions).writeOptional("damage_conditions", Condition.TYPE, kineticWeapon.damageConditions).writeOptional("forward_movement", Types.FLOAT, Float.valueOf(kineticWeapon.forwardMovement), Float.valueOf(0.0f)).writeOptional("damage_multiplier", Types.FLOAT, Float.valueOf(kineticWeapon.damageMultiplier), Float.valueOf(1.0f)).writeOptional("sound", Types.SOUND_EVENT, kineticWeapon.sound).writeOptional("hit_sound", Types.SOUND_EVENT, kineticWeapon.hitSound));
        }
    };

    public record Condition(int maxDurationTicks, float minSpeed, float minRelativeSpeed) {
        public static final Type<Condition> TYPE = new Type<Condition>(Condition.class){

            @Override
            public Condition read(ByteBuf byteBuf) {
                int n = Types.VAR_INT.readPrimitive(byteBuf);
                float f = Types.FLOAT.readPrimitive(byteBuf);
                float f2 = Types.FLOAT.readPrimitive(byteBuf);
                return new Condition(n, f, f2);
            }

            @Override
            public void write(ByteBuf byteBuf, Condition condition) {
                Types.VAR_INT.writePrimitive(byteBuf, condition.maxDurationTicks);
                Types.FLOAT.writePrimitive(byteBuf, condition.minSpeed);
                Types.FLOAT.writePrimitive(byteBuf, condition.minRelativeSpeed);
            }

            @Override
            public void write(Ops ops, Condition condition) {
                ops.writeMap(mapSerializer -> mapSerializer.write("max_duration_ticks", Types.INT, condition.maxDurationTicks).writeOptional("min_speed", Types.FLOAT, Float.valueOf(condition.minSpeed), Float.valueOf(0.0f)).writeOptional("min_relative_speed", Types.FLOAT, Float.valueOf(condition.minRelativeSpeed), Float.valueOf(0.0f)));
            }
        };
        public static final Type<Condition> OPTIONAL_TYPE = new OptionalType<Condition>(TYPE){};
    }
}

