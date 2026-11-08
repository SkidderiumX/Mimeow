/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data;

import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import io.netty.buffer.ByteBuf;

public class EmptyStructuredData<T>
implements StructuredData<T> {
    private final StructuredDataKey<T> key;
    private int id;

    EmptyStructuredData(StructuredDataKey<T> structuredDataKey, int n) {
        this.key = structuredDataKey;
        this.id = n;
    }

    @Override
    public void setValue(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(ByteBuf byteBuf) {
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
        return new EmptyStructuredData<T>(this.key, this.id);
    }

    @Override
    public T value() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
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
        EmptyStructuredData emptyStructuredData = (EmptyStructuredData)object;
        if (this.id != emptyStructuredData.id) {
            return false;
        }
        return this.key.equals(emptyStructuredData.key);
    }

    public int hashCode() {
        int n = this.key.hashCode();
        n = 31 * n + this.id;
        return n;
    }

    public String toString() {
        return "EmptyStructuredData{key=" + String.valueOf(this.key) + ", id=" + this.id + "}";
    }
}

