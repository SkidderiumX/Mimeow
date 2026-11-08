/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;

public record WolfVariant(String wildTexture, String tameTexture, String angryTexture, HolderSet biomes) {
    public static HolderType<WolfVariant> TYPE = new HolderType<WolfVariant>(){

        @Override
        public WolfVariant readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            String string2 = (String)Types.STRING.read(byteBuf);
            String string3 = (String)Types.STRING.read(byteBuf);
            HolderSet holderSet = (HolderSet)Types.HOLDER_SET.read(byteBuf);
            return new WolfVariant(string, string2, string3, holderSet);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, WolfVariant wolfVariant) {
            Types.STRING.write(byteBuf, wolfVariant.wildTexture());
            Types.STRING.write(byteBuf, wolfVariant.tameTexture());
            Types.STRING.write(byteBuf, wolfVariant.angryTexture());
            Types.HOLDER_SET.write(byteBuf, wolfVariant.biomes());
        }
    };
}

