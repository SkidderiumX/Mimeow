/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class FilledStructuredData<T>
implements StructuredData<T> {
    private final StructuredDataKey<T> key;
    private T value;
    private int id;

    FilledStructuredData(StructuredDataKey<T> structuredDataKey, T t, int n) {
        Preconditions.checkNotNull(structuredDataKey);
        this.key = structuredDataKey;
        this.value = t;
        this.id = n;
    }

    @Override
    public void setValue(T t) {
        this.value = t;
    }

    @Override
    public void write(ByteBuf byteBuf) {
        this.key.type().write(byteBuf, this.value);
    }

    @Override
    public void setId(int n) {
        this.id = n;
    }

    @Override
    public StructuredDataKey<T> key() {
        return this.key;
    }

    @Override
    public StructuredData<T> copy() {
        return new FilledStructuredData<T>(this.key, Copyable.copy(this.value), this.id);
    }

    @Override
    public T value() {
        return this.value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int id() {
        return this.id;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        FilledStructuredData filledStructuredData = (FilledStructuredData)object;
        if (this.id != filledStructuredData.id) {
            return false;
        }
        if (!this.key.equals(filledStructuredData.key)) {
            return false;
        }
        return Objects.equals(this.value, filledStructuredData.value);
    }

    public int hashCode() {
        int n = this.key.hashCode();
        n = 31 * n + (this.value != null ? this.value.hashCode() : 0);
        n = 31 * n + this.id;
        return n;
    }

    public String toString() {
        return "FilledStructuredData{key=" + String.valueOf(this.key) + ", value=" + ArrayUtil.toString(this.value) + ", id=" + this.id + "}";
    }
}

