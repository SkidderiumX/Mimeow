/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class HeightmapType
extends Type<Heightmap> {
    public HeightmapType() {
        super(Heightmap.class);
    }

    @Override
    public Heightmap read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        long[] lArray = (long[])Types.LONG_ARRAY_PRIMITIVE.read(byteBuf);
        return new Heightmap(n, lArray);
    }

    @Override
    public void write(ByteBuf byteBuf, Heightmap heightmap) {
        Types.VAR_INT.writePrimitive(byteBuf, heightmap.type());
        Types.LONG_ARRAY_PRIMITIVE.write(byteBuf, heightmap.data());
    }
}

