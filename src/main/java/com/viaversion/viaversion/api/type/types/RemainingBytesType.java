/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class RemainingBytesType
extends Type<byte[]> {
    private final int maxLength;

    public RemainingBytesType() {
        this(-1);
    }

    public RemainingBytesType(int n) {
        super(byte[].class);
        this.maxLength = n;
    }

    @Override
    public byte[] read(ByteBuf byteBuf) {
        int n = byteBuf.readableBytes();
        if (this.maxLength != -1 && n > this.maxLength) {
            throw new RuntimeException("Remaining bytes cannot be longer than " + this.maxLength + " (got " + n + ")");
        }
        byte[] byArray = new byte[n];
        byteBuf.readBytes(byArray);
        return byArray;
    }

    @Override
    public void write(ByteBuf byteBuf, byte[] byArray) {
        if (this.maxLength != -1 && byArray.length > this.maxLength) {
            throw new RuntimeException("Remaining bytes cannot be longer than " + this.maxLength + " (got " + byArray.length + ")");
        }
        byteBuf.writeBytes(byArray);
    }
}

