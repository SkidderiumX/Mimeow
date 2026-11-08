/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPattern;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;

public record BannerPatternLayer(Holder<BannerPattern> pattern, int dyeColor) {
    public static final Type<BannerPatternLayer> TYPE = new Type<BannerPatternLayer>(BannerPatternLayer.class){

        @Override
        public BannerPatternLayer read(ByteBuf byteBuf) {
            Object object = BannerPattern.TYPE.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            return new BannerPatternLayer((Holder<BannerPattern>)object, n);
        }

        @Override
        public void write(ByteBuf byteBuf, BannerPatternLayer bannerPatternLayer) {
            BannerPattern.TYPE.write(byteBuf, bannerPatternLayer.pattern);
            Types.VAR_INT.writePrimitive(byteBuf, bannerPatternLayer.dyeColor);
        }

        @Override
        public void write(Ops ops, BannerPatternLayer bannerPatternLayer) {
            ops.writeMap(mapSerializer -> mapSerializer.write("pattern", BannerPattern.TYPE, bannerPatternLayer.pattern).write("color", EnumTypes.DYE_COLOR, bannerPatternLayer.dyeColor));
        }
    };
    public static final Type<BannerPatternLayer[]> ARRAY_TYPE = new ArrayType<BannerPatternLayer>(TYPE);
}

