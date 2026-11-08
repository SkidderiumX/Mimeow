/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;

public record Fireworks(int flightDuration, FireworkExplosion[] explosions) implements Copyable
{
    public static final Type<Fireworks> TYPE = new Type<Fireworks>(Fireworks.class){

        @Override
        public Fireworks read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            FireworkExplosion[] fireworkExplosionArray = (FireworkExplosion[])FireworkExplosion.ARRAY_TYPE.read(byteBuf);
            return new Fireworks(n, fireworkExplosionArray);
        }

        @Override
        public void write(ByteBuf byteBuf, Fireworks fireworks) {
            Types.VAR_INT.writePrimitive(byteBuf, fireworks.flightDuration);
            FireworkExplosion.ARRAY_TYPE.write(byteBuf, fireworks.explosions);
        }

        @Override
        public void write(Ops ops, Fireworks fireworks) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("flight_duration", Types.UNSIGNED_BYTE, (short)fireworks.flightDuration, (short)0).writeOptional("explosions", FireworkExplosion.ARRAY_TYPE, fireworks.explosions, new FireworkExplosion[0]));
        }
    };

    @Override
    public Fireworks copy() {
        return new Fireworks(this.flightDuration, Copyable.copy(this.explosions));
    }
}

