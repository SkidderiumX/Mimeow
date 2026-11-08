/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public record Unbreakable(boolean showInTooltip) {
    public static final Type<Unbreakable> TYPE = new Type<Unbreakable>(Unbreakable.class){

        @Override
        public Unbreakable read(ByteBuf byteBuf) {
            return new Unbreakable(byteBuf.readBoolean());
        }

        @Override
        public void write(ByteBuf byteBuf, Unbreakable unbreakable) {
            byteBuf.writeBoolean(unbreakable.showInTooltip());
        }
    };
}

