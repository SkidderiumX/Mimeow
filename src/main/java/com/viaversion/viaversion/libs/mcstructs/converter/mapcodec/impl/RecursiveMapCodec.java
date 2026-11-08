/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Map;
import java.util.function.Function;

public class RecursiveMapCodec<T>
implements MapCodec<T> {
    private final MapCodec<T> codec;

    public RecursiveMapCodec(Function<Codec<T>, MapCodec<T>> function) {
        this.codec = function.apply(this.asCodec());
    }

    @Override
    public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, T t) {
        return this.codec.serialize(dataConverter, map, t);
    }

    @Override
    public <S> Result<T> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
        return this.codec.deserialize(dataConverter, map);
    }
}

