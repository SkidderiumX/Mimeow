/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class LongArrayType
extends Type<long[]> {
    private final int length;

    public LongArrayType(int n) {
        super(long[].class);
        this.length = n;
    }

    public LongArrayType() {
        this(-1);
    }

    @Override
    public long[] read(ByteBuf byteBuf) {
        int n = this.length == -1 ? Types.VAR_INT.readPrimitive(byteBuf) : this.length;
        Preconditions.checkArgument(byteBuf.isReadable(n), "Length is fewer than readable bytes");
        return LongArrayType.readFixedLength(byteBuf, n);
    }

    public static long[] readFixedLength(ByteBuf byteBuf, int n) {
        long[] lArray = new long[n];
        for (int i = 0; i < n; ++i) {
            lArray[i] = byteBuf.readLong();
        }
        return lArray;
    }

    @Override
    public void write(ByteBuf byteBuf, long[] lArray) {
        if (this.length != -1) {
            Preconditions.checkArgument(this.length == lArray.length, "Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, lArray.length);
        }
        LongArrayType.writeFixedLength(byteBuf, lArray);
    }

    public static void writeFixedLength(ByteBuf byteBuf, long[] lArray) {
        for (long l : lArray) {
            byteBuf.writeLong(l);
        }
    }

    @Override
    public void write(Ops ops, long[] lArray) {
        ops.writeLongs(lArray);
    }
}

