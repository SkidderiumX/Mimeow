/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record AttackRange(float minRange, float maxRange, float minCreativeRange, float maxCreativeRange, float hitboxMargin, float mobFactor) {
    public static final Type<AttackRange> TYPE = new Type<AttackRange>(AttackRange.class){

        @Override
        public AttackRange read(ByteBuf byteBuf) {
            float f = Types.FLOAT.readPrimitive(byteBuf);
            float f2 = Types.FLOAT.readPrimitive(byteBuf);
            float f3 = Types.FLOAT.readPrimitive(byteBuf);
            float f4 = Types.FLOAT.readPrimitive(byteBuf);
            float f5 = Types.FLOAT.readPrimitive(byteBuf);
            float f6 = Types.FLOAT.readPrimitive(byteBuf);
            return new AttackRange(f, f2, f3, f4, f5, f6);
        }

        @Override
        public void write(ByteBuf byteBuf, AttackRange attackRange) {
            Types.FLOAT.writePrimitive(byteBuf, attackRange.minRange);
            Types.FLOAT.writePrimitive(byteBuf, attackRange.maxRange);
            Types.FLOAT.writePrimitive(byteBuf, attackRange.minCreativeRange);
            Types.FLOAT.writePrimitive(byteBuf, attackRange.maxCreativeRange);
            Types.FLOAT.writePrimitive(byteBuf, attackRange.hitboxMargin);
            Types.FLOAT.writePrimitive(byteBuf, attackRange.mobFactor);
        }

        @Override
        public void write(Ops ops, AttackRange attackRange) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("min_reach", Types.FLOAT, Float.valueOf(attackRange.minRange), Float.valueOf(0.0f)).writeOptional("max_reach", Types.FLOAT, Float.valueOf(attackRange.maxRange), Float.valueOf(3.0f)).writeOptional("min_creative_reach", Types.FLOAT, Float.valueOf(attackRange.minCreativeRange), Float.valueOf(0.0f)).writeOptional("max_creative_reach", Types.FLOAT, Float.valueOf(attackRange.maxCreativeRange), Float.valueOf(5.0f)).writeOptional("hitbox_margin", Types.FLOAT, Float.valueOf(attackRange.hitboxMargin), Float.valueOf(0.3f)).writeOptional("mob_factor", Types.FLOAT, Float.valueOf(attackRange.mobFactor), Float.valueOf(1.0f)));
        }
    };
}

