/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.ByteBufReader;
import com.viaversion.viaversion.api.type.ByteBufWriter;
import com.viaversion.viaversion.api.type.CodecWriter;

public abstract class Type<T>
implements ByteBufReader<T>,
ByteBufWriter<T>,
CodecWriter<T> {
    private final Class<? super T> outputClass;
    private final String typeName;

    protected Type(Class<? super T> clazz) {
        this(null, clazz);
    }

    protected Type(String string, Class<? super T> clazz) {
        this.outputClass = clazz;
        this.typeName = string;
    }

    public Class<? super T> getOutputClass() {
        return this.outputClass;
    }

    public String getTypeName() {
        return this.typeName != null && !this.typeName.isEmpty() ? this.typeName : this.getClass().getName();
    }

    @Override
    public void write(Ops ops, T t) {
        throw new UnsupportedOperationException("Write operation not supported for type: " + this.getTypeName());
    }

    public Class<? extends Type> getBaseClass() {
        return this.getClass();
    }

    public String toString() {
        return this.getTypeName();
    }
}

