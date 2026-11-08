/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class FixedByteArrayType
extends Type<byte[]> {
    private final int arrayLength;

    public FixedByteArrayType(int n) {
        super(byte[].class);
        this.arrayLength = n;
    }

    @Override
    public byte[] read(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < this.arrayLength) {
            throw new RuntimeException("Readable bytes does not match expected!");
        }
        byte[] byArray = new byte[this.arrayLength];
        byteBuf.readBytes(byArray);
        return byArray;
    }

    @Override
    public void write(ByteBuf byteBuf, byte[] byArray) {
        byteBuf.writeBytes(byArray);
    }
}

