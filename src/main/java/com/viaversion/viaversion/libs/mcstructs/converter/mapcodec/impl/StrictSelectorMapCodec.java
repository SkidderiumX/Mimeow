/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Map;

public class StrictSelectorMapCodec<T>
implements MapCodec<T> {
    private final String fieldName;
    private final MapCodec<T> primary;
    private final MapCodec<T> secondary;

    public StrictSelectorMapCodec(String string, MapCodec<T> mapCodec, MapCodec<T> mapCodec2) {
        this.fieldName = string;
        this.primary = mapCodec;
        this.secondary = mapCodec2;
    }

    @Override
    public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, T t) {
        return this.secondary.serialize(dataConverter, map, t);
    }

    @Override
    public <S> Result<T> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
        if (map.containsKey(dataConverter.createString(this.fieldName))) {
            return this.primary.deserialize(dataConverter, map);
        }
        return this.secondary.deserialize(dataConverter, map);
    }
}

