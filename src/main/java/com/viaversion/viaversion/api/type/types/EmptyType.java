/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Unit;
import io.netty.buffer.ByteBuf;

public class EmptyType
extends Type<Unit> {
    public EmptyType() {
        super(Unit.class);
    }

    @Override
    public Unit read(ByteBuf byteBuf) {
        return Unit.INSTANCE;
    }

    @Override
    public void write(ByteBuf byteBuf, Unit unit) {
    }

    @Override
    public void write(Ops ops, Unit unit) {
        ops.writeMap(mapSerializer -> {});
    }
}

