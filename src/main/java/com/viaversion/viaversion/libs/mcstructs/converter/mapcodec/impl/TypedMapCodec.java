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

public class TypedMapCodec<K, V>
implements MapCodec<V> {
    private final String typeKey;
    private final Codec<K> keyCodec;
    private final Function<V, K> typeMapper;
    private final Function<K, MapCodec<? extends V>> continuation;

    public TypedMapCodec(String string, Codec<K> codec, Function<V, K> function, Function<K, MapCodec<? extends V>> function2) {
        this.typeKey = string;
        this.keyCodec = codec;
        this.typeMapper = function;
        this.continuation = function2;
    }

    @Override
    public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, V v) {
        K k = this.typeMapper.apply(v);
        if (k == null) {
            return Result.error("No key found for element: " + v);
        }
        MapCodec<V> mapCodec = this.continuation.apply(k);
        if (mapCodec == null) {
            return Result.error("No codec found for key '" + k + "'");
        }
        Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, v);
        if (result.isError()) {
            return result.mapError();
        }
        map = result.get();
        Result<S> result2 = this.keyCodec.serialize(dataConverter, k);
        if (result2.isError()) {
            return result2.mapError();
        }
        map.put(dataConverter.createString(this.typeKey), result2.get());
        return Result.success(map);
    }

    @Override
    public <S> Result<V> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
        S s = map.get(dataConverter.createString(this.typeKey));
        if (s == null) {
            return Result.error("Input does not contain key '" + this.typeKey + "': " + map);
        }
        Result result = this.keyCodec.deserialize(dataConverter, s);
        if (result.isError()) {
            return result.mapError();
        }
        MapCodec<V> mapCodec = this.continuation.apply(result.get());
        if (mapCodec == null) {
            return Result.error("No codec found for key '" + result.get() + "'");
        }
        return mapCodec.deserialize(dataConverter, map);
    }
}

