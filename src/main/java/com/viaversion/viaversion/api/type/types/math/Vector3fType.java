/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.Vector3f;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class Vector3fType
extends Type<Vector3f> {
    public Vector3fType() {
        super(Vector3f.class);
    }

    @Override
    public Vector3f read(ByteBuf byteBuf) {
        float f = byteBuf.readFloat();
        float f2 = byteBuf.readFloat();
        float f3 = byteBuf.readFloat();
        return new Vector3f(f, f2, f3);
    }

    @Override
    public void write(ByteBuf byteBuf, Vector3f vector3f) {
        byteBuf.writeFloat(vector3f.x());
        byteBuf.writeFloat(vector3f.y());
        byteBuf.writeFloat(vector3f.z());
    }
}

