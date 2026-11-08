/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class ShortByteArrayType
extends Type<byte[]> {
    public ShortByteArrayType() {
        super(byte[].class);
    }

    @Override
    public void write(ByteBuf byteBuf, byte[] byArray) {
        byteBuf.writeShort(byArray.length);
        byteBuf.writeBytes(byArray);
    }

    @Override
    public byte[] read(ByteBuf byteBuf) {
        byte[] byArray = new byte[byteBuf.readShort()];
        byteBuf.readBytes(byArray);
        return byArray;
    }
}

