/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public record DyedColor(int rgb, boolean showInTooltip) {
    public static final Type<DyedColor> TYPE1_20_5 = new Type<DyedColor>(DyedColor.class){

        @Override
        public DyedColor read(ByteBuf byteBuf) {
            int n = byteBuf.readInt();
            boolean bl = byteBuf.readBoolean();
            return new DyedColor(n, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, DyedColor dyedColor) {
            byteBuf.writeInt(dyedColor.rgb);
            byteBuf.writeBoolean(dyedColor.showInTooltip);
        }
    };
    public static final Type<DyedColor> TYPE1_21_5 = new Type<DyedColor>(DyedColor.class){

        @Override
        public DyedColor read(ByteBuf byteBuf) {
            int n = byteBuf.readInt();
            return new DyedColor(n);
        }

        @Override
        public void write(ByteBuf byteBuf, DyedColor dyedColor) {
            byteBuf.writeInt(dyedColor.rgb);
        }

        @Override
        public void write(Ops ops, DyedColor dyedColor) {
            ops.write(Types.INT, dyedColor.rgb);
        }
    };

    public DyedColor(int n) {
        this(n, true);
    }
}

