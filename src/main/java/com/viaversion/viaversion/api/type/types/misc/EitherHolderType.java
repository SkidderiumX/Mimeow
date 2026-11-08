/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public class EitherHolderType<T>
extends Type<EitherHolder<T>> {
    private final HolderType<T> holderType;

    public EitherHolderType(HolderType<T> holderType) {
        super(EitherHolder.class);
        this.holderType = holderType;
    }

    @Override
    public EitherHolder<T> read(ByteBuf byteBuf) {
        return EitherHolderType.read(byteBuf, this.holderType);
    }

    @Override
    public void write(ByteBuf byteBuf, EitherHolder<T> eitherHolder) {
        EitherHolderType.write(byteBuf, eitherHolder, this.holderType);
    }

    @Override
    public void write(Ops ops, EitherHolder<T> eitherHolder) {
        EitherHolderType.write(ops, eitherHolder, this.holderType);
    }

    public static <T> EitherHolder<T> read(ByteBuf byteBuf, HolderType<T> holderType) {
        if (byteBuf.readBoolean()) {
            return EitherHolder.of(holderType.read(byteBuf));
        }
        return EitherHolder.of((String)Types.STRING.read(byteBuf));
    }

    public static <T> void write(ByteBuf byteBuf, EitherHolder<T> eitherHolder, HolderType<T> holderType) {
        if (eitherHolder.hasHolder()) {
            byteBuf.writeBoolean(true);
            holderType.write(byteBuf, eitherHolder.holder());
        } else {
            byteBuf.writeBoolean(false);
            Types.STRING.write(byteBuf, eitherHolder.key());
        }
    }

    public static <T> void write(Ops ops, EitherHolder<T> eitherHolder, HolderType<T> holderType) {
        if (eitherHolder.hasHolder()) {
            holderType.write(ops, eitherHolder.holder());
        } else {
            ops.write(Types.IDENTIFIER, Key.of(eitherHolder.key()));
        }
    }
}

