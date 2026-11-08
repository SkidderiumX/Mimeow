/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.Vector;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class VectorType
extends Type<Vector> {
    public VectorType() {
        super(Vector.class);
    }

    @Override
    public Vector read(ByteBuf byteBuf) {
        int n = Types.INT.read(byteBuf);
        int n2 = Types.INT.read(byteBuf);
        int n3 = Types.INT.read(byteBuf);
        return new Vector(n, n2, n3);
    }

    @Override
    public void write(ByteBuf byteBuf, Vector vector) {
        Types.INT.write(byteBuf, (Integer)vector.blockX());
        Types.INT.write(byteBuf, (Integer)vector.blockY());
        Types.INT.write(byteBuf, (Integer)vector.blockZ());
    }
}

