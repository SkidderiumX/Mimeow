/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record Weapon(int itemDamagePerAttack, float disableBlockingForSeconds) {
    public static final Type<Weapon> TYPE = new Type<Weapon>(Weapon.class){

        @Override
        public Weapon read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            float f = byteBuf.readFloat();
            return new Weapon(n, f);
        }

        @Override
        public void write(ByteBuf byteBuf, Weapon weapon) {
            Types.VAR_INT.writePrimitive(byteBuf, weapon.itemDamagePerAttack());
            byteBuf.writeFloat(weapon.disableBlockingForSeconds());
        }

        @Override
        public void write(Ops ops, Weapon weapon) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("item_damage_per_attack", Types.INT, weapon.itemDamagePerAttack, 1).writeOptional("disable_blocking_for_seconds", Types.FLOAT, Float.valueOf(weapon.disableBlockingForSeconds), Float.valueOf(0.0f)));
        }
    };
}

