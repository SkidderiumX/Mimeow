/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record SwingAnimation(int type, int duration) {
    private static final int DEFAULT_TYPE = EnumTypes.SWING_ANIMATION.idFromName("whack");
    public static final Type<SwingAnimation> TYPE = new Type<SwingAnimation>(SwingAnimation.class){

        @Override
        public SwingAnimation read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            return new SwingAnimation(n, n2);
        }

        @Override
        public void write(ByteBuf byteBuf, SwingAnimation swingAnimation) {
            Types.VAR_INT.writePrimitive(byteBuf, swingAnimation.type);
            Types.VAR_INT.writePrimitive(byteBuf, swingAnimation.duration);
        }

        @Override
        public void write(Ops ops, SwingAnimation swingAnimation) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("type", EnumTypes.SWING_ANIMATION, swingAnimation.type, DEFAULT_TYPE).writeOptional("duration", Types.INT, swingAnimation.duration, 6));
        }
    };
}

