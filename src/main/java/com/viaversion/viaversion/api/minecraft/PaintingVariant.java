/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record PaintingVariant(int width, int height, String assetId, @Nullable Tag title, @Nullable Tag author) {
    public static HolderType<PaintingVariant> TYPE1_21 = new HolderType<PaintingVariant>(){

        @Override
        public PaintingVariant readDirect(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            String string = (String)Types.STRING.read(byteBuf);
            return new PaintingVariant(n, n2, string);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, PaintingVariant paintingVariant) {
            Types.VAR_INT.writePrimitive(byteBuf, paintingVariant.width());
            Types.VAR_INT.writePrimitive(byteBuf, paintingVariant.height());
            Types.STRING.write(byteBuf, paintingVariant.assetId());
        }
    };
    public static HolderType<PaintingVariant> TYPE1_21_2 = new HolderType<PaintingVariant>(){

        @Override
        public PaintingVariant readDirect(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            String string = (String)Types.STRING.read(byteBuf);
            Tag tag = (Tag)Types.TRUSTED_OPTIONAL_TAG.read(byteBuf);
            Tag tag2 = (Tag)Types.TRUSTED_OPTIONAL_TAG.read(byteBuf);
            return new PaintingVariant(n, n2, string, tag, tag2);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, PaintingVariant paintingVariant) {
            Types.VAR_INT.writePrimitive(byteBuf, paintingVariant.width());
            Types.VAR_INT.writePrimitive(byteBuf, paintingVariant.height());
            Types.STRING.write(byteBuf, paintingVariant.assetId());
            Types.TRUSTED_OPTIONAL_TAG.write(byteBuf, paintingVariant.title());
            Types.TRUSTED_OPTIONAL_TAG.write(byteBuf, paintingVariant.author());
        }

        @Override
        public void writeDirect(Ops ops, PaintingVariant paintingVariant) {
            ops.writeMap(mapSerializer -> mapSerializer.write("width", Types.INT, paintingVariant.width()).write("height", Types.INT, paintingVariant.height()).write("asset_id", Types.IDENTIFIER, Key.of(paintingVariant.assetId())).writeOptional("title", Types.TRUSTED_TAG, paintingVariant.title()).writeOptional("author", Types.TRUSTED_TAG, paintingVariant.author()));
        }

        @Override
        protected Key identifier(Ops ops, int n) {
            return ops.context().registryAccess().registryKey("painting_variant", n);
        }
    };

    public PaintingVariant(int n, int n2, String string) {
        this(n, n2, string, null, null);
    }
}

