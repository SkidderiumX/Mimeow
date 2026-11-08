/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec.impl;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.function.Supplier;

public class LazyInitCodec<T>
implements Codec<T> {
    private final Supplier<Codec<T>> codecSupplier;
    private Codec<T> codec;
    private volatile boolean initialized = false;

    public LazyInitCodec(Supplier<Codec<T>> supplier) {
        this.codecSupplier = supplier;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Codec<T> getCodec() {
        if (!this.initialized) {
            Supplier<Codec<T>> supplier = this.codecSupplier;
            synchronized (supplier) {
                if (!this.initialized) {
                    this.codec = this.codecSupplier.get();
                    this.initialized = true;
                }
            }
        }
        return this.codec;
    }

    @Override
    public <S> Result<S> serialize(DataConverter<S> dataConverter, T t) {
        return this.getCodec().serialize(dataConverter, t);
    }

    @Override
    public <S> Result<T> deserialize(DataConverter<S> dataConverter, S s) {
        return this.getCodec().deserialize(dataConverter, s);
    }
}

