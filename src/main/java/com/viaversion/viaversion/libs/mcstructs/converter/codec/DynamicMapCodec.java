/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DynamicMapCodec<K, V>
implements Codec<Map<K, V>> {
    private final Codec<K> keyCodec;
    private final Function<K, Codec<? extends V>> keyToValueCodec;

    public DynamicMapCodec(Codec<K> codec, Function<K, Codec<? extends V>> function) {
        this.keyCodec = codec;
        this.keyToValueCodec = function;
    }

    @Override
    public <S> Result<S> serialize(DataConverter<S> dataConverter, Map<K, V> map) {
        HashMap<S, S> hashMap = new HashMap<S, S>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            Result<S> result = this.keyCodec.serialize(dataConverter, entry.getKey());
            if (result.isError()) {
                return result.mapError();
            }
            Codec<V> codec = this.keyToValueCodec.apply(entry.getKey());
            Result<S> result2 = codec.serialize(dataConverter, entry.getValue());
            if (result2.isError()) {
                return result2.mapError();
            }
            hashMap.put(result.get(), result2.get());
        }
        return dataConverter.createMergedMap(hashMap);
    }

    @Override
    public <S> Result<Map<K, V>> deserialize(DataConverter<S> dataConverter, S s) {
        Result<Map<S, S>> result = dataConverter.asMap(s);
        return result.mapResult(map -> {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : map.entrySet()) {
                Result result = this.keyCodec.deserialize(dataConverter, entry.getKey());
                if (result.isError()) {
                    return result.mapError();
                }
                Codec<V> codec = this.keyToValueCodec.apply(result.get());
                if (codec == null) {
                    return Result.error("No codec found for key: " + result.get());
                }
                Result result2 = codec.deserialize(dataConverter, entry.getValue());
                if (result2.isError()) {
                    return result2.mapError();
                }
                hashMap.put(result.get(), result2.get());
            }
            return Result.success(hashMap);
        });
    }
}

