/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class ByteArrayType
extends Type<byte[]> {
    private final int length;

    public ByteArrayType(int n) {
        super(byte[].class);
        this.length = n;
    }

    public ByteArrayType() {
        super(byte[].class);
        this.length = -1;
    }

    @Override
    public void write(ByteBuf byteBuf, byte[] byArray) {
        if (this.length != -1) {
            Preconditions.checkArgument(this.length == byArray.length, "Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, byArray.length);
        }
        byteBuf.writeBytes(byArray);
    }

    @Override
    public byte[] read(ByteBuf byteBuf) {
        int n = this.length == -1 ? Types.VAR_INT.readPrimitive(byteBuf) : this.length;
        Preconditions.checkArgument(byteBuf.isReadable(n), "Length is fewer than readable bytes");
        byte[] byArray = new byte[n];
        byteBuf.readBytes(byArray);
        return byArray;
    }

    @Override
    public void write(Ops ops, byte[] byArray) {
        ops.writeBytes(byArray);
    }

    public static final class OptionalByteArrayType
    extends OptionalType<byte[]> {
        public OptionalByteArrayType() {
            super(Types.BYTE_ARRAY_PRIMITIVE);
        }

        public OptionalByteArrayType(int n) {
            super(new ByteArrayType(n));
        }
    }
}

