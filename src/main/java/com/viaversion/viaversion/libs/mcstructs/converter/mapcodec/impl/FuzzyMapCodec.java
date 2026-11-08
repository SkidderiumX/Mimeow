/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FuzzyMapCodec<T>
implements MapCodec<T> {
    private final List<MapCodec<? extends T>> codecs;
    private final Function<T, MapCodec<? extends T>> selector;

    public FuzzyMapCodec(List<MapCodec<? extends T>> list, Function<T, MapCodec<? extends T>> function) {
        this.codecs = list;
        this.selector = function;
    }

    @Override
    public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, T t) {
        MapCodec<T> mapCodec = this.selector.apply(t);
        return mapCodec.serialize(dataConverter, map, t);
    }

    @Override
    public <S> Result<T> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
        for (MapCodec<T> mapCodec : this.codecs) {
            Result result = mapCodec.deserialize(dataConverter, map);
            if (!result.isSuccessful()) continue;
            return Result.success(result.get());
        }
        return Result.error("No codec could deserialize the given map");
    }
}

