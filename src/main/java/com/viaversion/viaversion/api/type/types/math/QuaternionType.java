/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.Quaternion;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class QuaternionType
extends Type<Quaternion> {
    public QuaternionType() {
        super(Quaternion.class);
    }

    @Override
    public Quaternion read(ByteBuf byteBuf) {
        float f = byteBuf.readFloat();
        float f2 = byteBuf.readFloat();
        float f3 = byteBuf.readFloat();
        float f4 = byteBuf.readFloat();
        return new Quaternion(f, f2, f3, f4);
    }

    @Override
    public void write(ByteBuf byteBuf, Quaternion quaternion) {
        byteBuf.writeFloat(quaternion.x());
        byteBuf.writeFloat(quaternion.y());
        byteBuf.writeFloat(quaternion.z());
        byteBuf.writeFloat(quaternion.w());
    }
}

