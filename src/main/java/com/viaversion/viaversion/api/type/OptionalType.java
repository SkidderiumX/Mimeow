/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public class OptionalType<T>
extends Type<T> {
    private final Type<T> type;

    public OptionalType(Type<T> type) {
        super(type.getOutputClass());
        this.type = type;
    }

    @Override
    public @Nullable T read(ByteBuf byteBuf) {
        return byteBuf.readBoolean() ? (T)this.type.read(byteBuf) : null;
    }

    @Override
    public void write(ByteBuf byteBuf, @Nullable T t) {
        if (t == null) {
            byteBuf.writeBoolean(false);
        } else {
            byteBuf.writeBoolean(true);
            this.type.write(byteBuf, t);
        }
    }

    @Override
    public void write(Ops ops, T t) {
        this.type.write(ops, t);
    }
}

