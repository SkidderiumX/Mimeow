/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record Enchantable(int value) {
    public static final Type<Enchantable> TYPE = new Type<Enchantable>(Enchantable.class){

        @Override
        public Enchantable read(ByteBuf byteBuf) {
            return new Enchantable(Types.VAR_INT.readPrimitive(byteBuf));
        }

        @Override
        public void write(ByteBuf byteBuf, Enchantable enchantable) {
            Types.VAR_INT.writePrimitive(byteBuf, enchantable.value);
        }

        @Override
        public void write(Ops ops, Enchantable enchantable) {
            ops.writeMap(mapSerializer -> mapSerializer.write("value", Types.INT, enchantable.value));
        }
    };
}

