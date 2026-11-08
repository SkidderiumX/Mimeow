/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public record BannerPattern(String assetId, String translationKey) {
    public static final HolderType<BannerPattern> TYPE = new HolderType<BannerPattern>(){

        @Override
        public BannerPattern readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            String string2 = (String)Types.STRING.read(byteBuf);
            return new BannerPattern(string, string2);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, BannerPattern bannerPattern) {
            Types.STRING.write(byteBuf, bannerPattern.assetId);
            Types.STRING.write(byteBuf, bannerPattern.translationKey);
        }

        @Override
        public void writeDirect(Ops ops, BannerPattern bannerPattern) {
            ops.writeMap(mapSerializer -> mapSerializer.write("asset_id", Types.IDENTIFIER, Key.of(bannerPattern.assetId)).write("translation_key", Types.STRING, bannerPattern.translationKey));
        }

        @Override
        protected Key identifier(Ops ops, int n) {
            return ops.context().registryAccess().registryKey("banner_pattern", n);
        }
    };
}

