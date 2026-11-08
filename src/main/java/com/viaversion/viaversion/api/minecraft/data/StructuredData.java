/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data;

import com.viaversion.viaversion.api.minecraft.data.EmptyStructuredData;
import com.viaversion.viaversion.api.minecraft.data.FilledStructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.IdHolder;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface StructuredData<T>
extends IdHolder,
Copyable {
    public static <T> StructuredData<T> of(StructuredDataKey<T> structuredDataKey, T t, int n) {
        return new FilledStructuredData<T>(structuredDataKey, t, n);
    }

    public static <T> StructuredData<T> empty(StructuredDataKey<T> structuredDataKey, int n) {
        return new EmptyStructuredData<T>(structuredDataKey, n);
    }

    public @Nullable T value();

    public void setValue(T var1);

    public void setId(int var1);

    public StructuredDataKey<T> key();

    @Override
    public StructuredData<T> copy();

    default public boolean isPresent() {
        return !this.isEmpty();
    }

    public boolean isEmpty();

    public void write(ByteBuf var1);
}

