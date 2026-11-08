/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.EulerAngle;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class EulerAngleType
extends Type<EulerAngle> {
    public EulerAngleType() {
        super(EulerAngle.class);
    }

    @Override
    public EulerAngle read(ByteBuf byteBuf) {
        float f = Types.FLOAT.readPrimitive(byteBuf);
        float f2 = Types.FLOAT.readPrimitive(byteBuf);
        float f3 = Types.FLOAT.readPrimitive(byteBuf);
        return new EulerAngle(f, f2, f3);
    }

    @Override
    public void write(ByteBuf byteBuf, EulerAngle eulerAngle) {
        Types.FLOAT.writePrimitive(byteBuf, eulerAngle.x());
        Types.FLOAT.writePrimitive(byteBuf, eulerAngle.y());
        Types.FLOAT.writePrimitive(byteBuf, eulerAngle.z());
    }
}

