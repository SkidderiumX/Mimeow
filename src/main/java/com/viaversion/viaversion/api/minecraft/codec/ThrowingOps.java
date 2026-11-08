/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import java.util.function.Consumer;

public class ThrowingOps
implements Ops {
    @Override
    public CodecContext context() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeByte(byte by) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeBytes(byte[] byArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeBoolean(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeShort(short s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeString(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeInt(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeLong(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeFloat(float f) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeDouble(double d) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeInts(int[] nArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeLongs(long[] lArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeList(Consumer<Ops.ListSerializer> consumer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeMap(Consumer<Ops.MapSerializer> consumer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <V> void write(Type<V> type, V v) {
        throw new UnsupportedOperationException();
    }
}

