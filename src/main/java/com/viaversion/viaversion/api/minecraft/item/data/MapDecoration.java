/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record MapDecoration(String type, double x, double z, float rotation) {
    public static final Type<MapDecoration> TYPE = new Type<MapDecoration>(MapDecoration.class){

        @Override
        public MapDecoration read(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            double d = Types.DOUBLE.readPrimitive(byteBuf);
            double d2 = Types.DOUBLE.readPrimitive(byteBuf);
            float f = Types.FLOAT.readPrimitive(byteBuf);
            return new MapDecoration(string, d, d2, f);
        }

        @Override
        public void write(ByteBuf byteBuf, MapDecoration mapDecoration) {
            Types.STRING.write(byteBuf, mapDecoration.type);
            byteBuf.writeDouble(mapDecoration.x);
            byteBuf.writeDouble(mapDecoration.z);
            byteBuf.writeFloat(mapDecoration.rotation);
        }
    };
}

