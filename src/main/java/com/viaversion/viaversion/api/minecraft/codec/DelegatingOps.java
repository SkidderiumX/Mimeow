/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import java.util.function.Consumer;

public class DelegatingOps
implements Ops {
    private final Ops delegate;

    public DelegatingOps(Ops ops) {
        this.delegate = ops;
    }

    @Override
    public CodecContext context() {
        return this.delegate.context();
    }

    @Override
    public void writeByte(byte by) {
        this.delegate.writeByte(by);
    }

    @Override
    public void writeBytes(byte[] byArray) {
        this.delegate.writeBytes(byArray);
    }

    @Override
    public void writeBoolean(boolean bl) {
        this.delegate.writeBoolean(bl);
    }

    @Override
    public void writeShort(short s) {
        this.delegate.writeShort(s);
    }

    @Override
    public void writeString(CharSequence charSequence) {
        this.delegate.writeString(charSequence);
    }

    @Override
    public void writeInt(int n) {
        this.delegate.writeInt(n);
    }

    @Override
    public void writeLong(long l) {
        this.delegate.writeLong(l);
    }

    @Override
    public void writeFloat(float f) {
        this.delegate.writeFloat(f);
    }

    @Override
    public void writeDouble(double d) {
        this.delegate.writeDouble(d);
    }

    @Override
    public void writeInts(int[] nArray) {
        this.delegate.writeInts(nArray);
    }

    @Override
    public void writeLongs(long[] lArray) {
        this.delegate.writeLongs(lArray);
    }

    @Override
    public void writeList(Consumer<Ops.ListSerializer> consumer) {
        this.delegate.writeList(consumer);
    }

    @Override
    public void writeMap(Consumer<Ops.MapSerializer> consumer) {
        this.delegate.writeMap(consumer);
    }

    @Override
    public <V> void write(Type<V> type, V v) {
        this.delegate.write(type, v);
    }
}

