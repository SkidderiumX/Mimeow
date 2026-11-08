/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.misc.EitherHolderType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record ProvidesTrimMaterial(EitherHolder<ArmorTrimMaterial> material) implements Rewritable
{
    public static final Type<ProvidesTrimMaterial> TYPE = new Type<ProvidesTrimMaterial>(ProvidesTrimMaterial.class){

        @Override
        public ProvidesTrimMaterial read(ByteBuf byteBuf) {
            EitherHolder<ArmorTrimMaterial> eitherHolder = EitherHolderType.read(byteBuf, ArmorTrimMaterial.TYPE1_21_5);
            return new ProvidesTrimMaterial(eitherHolder);
        }

        @Override
        public void write(ByteBuf byteBuf, ProvidesTrimMaterial providesTrimMaterial) {
            EitherHolderType.write(byteBuf, providesTrimMaterial.material, ArmorTrimMaterial.TYPE1_21_5);
        }

        @Override
        public void write(Ops ops, ProvidesTrimMaterial providesTrimMaterial) {
            EitherHolderType.write(ops, providesTrimMaterial.material, ArmorTrimMaterial.TYPE1_21_5);
        }
    };

    @Override
    public ProvidesTrimMaterial rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        if (this.material.hasKey() || this.material.holder().hasId()) {
            return this;
        }
        ArmorTrimMaterial armorTrimMaterial = this.material.holder().value();
        return new ProvidesTrimMaterial(EitherHolder.of(Holder.of(armorTrimMaterial.rewrite(userConnection, (Protocol)protocol, bl))));
    }
}

