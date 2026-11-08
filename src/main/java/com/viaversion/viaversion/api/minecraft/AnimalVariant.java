/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record AnimalVariant(int modelType, String texture, @Nullable HolderSet biomes) {
    public static HolderType<AnimalVariant> TYPE = new HolderType<AnimalVariant>(){

        @Override
        public AnimalVariant readDirect(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            String string = (String)Types.STRING.read(byteBuf);
            HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
            return new AnimalVariant(n, string, holderSet);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, AnimalVariant animalVariant) {
            Types.VAR_INT.writePrimitive(byteBuf, animalVariant.modelType());
            Types.STRING.write(byteBuf, animalVariant.texture());
            Types.OPTIONAL_HOLDER_SET.write(byteBuf, animalVariant.biomes());
        }
    };
}

