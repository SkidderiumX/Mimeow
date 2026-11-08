/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.ThrowingFunction;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapDeserializer;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapSerializer;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.FieldMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.RecursiveMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Either;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface MapCodec<T>
extends MapSerializer<T>,
MapDeserializer<T> {
    public static final MapCodec<Boolean> UNIT = MapCodec.unit(() -> true);

    public static <N> MapCodec<N> unit(final Supplier<N> supplier) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, N n) {
                return Result.success(map);
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                return Result.success(supplier.get());
            }
        };
    }

    public static <N> MapCodec<N> failing(final String string) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, N n) {
                return Result.error(string);
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                return Result.error(string);
            }
        };
    }

    public static <N> MapCodec<N> requiredKey(Codec<N> codec, String string) {
        return new FieldMapCodec<N>(codec, string, false, false);
    }

    public static <N> MapCodec<N> optionalKey(Codec<N> codec, String string) {
        return new FieldMapCodec<N>(codec, string, true, false);
    }

    public static <N> MapCodec<N> optionalLenientKey(Codec<N> codec, String string) {
        return new FieldMapCodec<N>(codec, string, true, true);
    }

    public static <T> MapCodec<T> recursive(Function<Codec<T>, MapCodec<T>> function) {
        return new RecursiveMapCodec<T>(function);
    }

    public static <T> MapCodec<T> lazyInit(final Supplier<MapCodec<T>> supplier) {
        return new MapCodec<T>(){
            private MapCodec<T> codec;

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, T t) {
                if (this.codec == null) {
                    this.codec = (MapCodec)supplier.get();
                }
                return this.codec.serialize(dataConverter, map, t);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                if (this.codec == null) {
                    this.codec = (MapCodec)supplier.get();
                }
                return this.codec.deserialize(dataConverter, map);
            }
        };
    }

    public static <L, R> MapCodec<Either<L, R>> either(final MapCodec<L> mapCodec, final MapCodec<R> mapCodec2) {
        return new MapCodec<Either<L, R>>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, Either<L, R> either) {
                return either.xmap(object -> mapCodec.serialize(dataConverter, map, object), object -> mapCodec2.serialize(dataConverter, map, object));
            }

            @Override
            public <S> Result<Either<L, R>> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result<Object> result = mapCodec.deserialize(dataConverter, map);
                if (result.isSuccessful()) {
                    return result.map(Either::left);
                }
                Result<Object> result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isSuccessful()) {
                    return result2.map(Either::right);
                }
                return Result.mergeErrors("Failed to deserialize as either left or right", Arrays.asList(result, result2));
            }
        };
    }

    default public FieldMapCodec.Builder.Stage1<T> field(String string) {
        return this.asCodec().mapCodec(string);
    }

    default public <N> MapCodec<N> map(final Function<N, T> function, final Function<T, N> function2) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, N n) {
                return MapCodec.this.serialize(dataConverter, map, function.apply(n));
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                return MapCodec.this.deserialize(dataConverter, map).map(function2);
            }
        };
    }

    default public <N> MapCodec<N> mapThrowing(final ThrowingFunction<N, T> throwingFunction, final ThrowingFunction<T, N> throwingFunction2) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, N n) {
                try {
                    return MapCodec.this.serialize(dataConverter, map, throwingFunction.apply(n));
                }
                catch (Throwable throwable) {
                    return Result.error(throwable);
                }
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                return MapCodec.this.deserialize(dataConverter, map).mapResult(object -> {
                    try {
                        return Result.success(throwingFunction2.apply(object));
                    }
                    catch (Throwable throwable) {
                        return Result.error(throwable);
                    }
                });
            }
        };
    }

    default public MapCodec<T> verified(final Function<T, Result<Void>> function) {
        return new MapCodec<T>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, T t) {
                Result result = (Result)function.apply(t);
                if (result != null && result.isError()) {
                    return result.mapError();
                }
                return MapCodec.this.serialize(dataConverter, map, t);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = MapCodec.this.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result;
                }
                Result result2 = (Result)function.apply(result.get());
                if (result2 != null && result2.isError()) {
                    return result2.mapError();
                }
                return result;
            }
        };
    }

    default public MapCodec<T> defaulted(T t) {
        return this.map(object2 -> Objects.equals(object2, t) ? null : object2, object2 -> object2 == null ? t : object2);
    }

    default public MapCodec<T> defaulted(Predicate<T> predicate, Supplier<T> supplier) {
        return this.map(object -> predicate.test(object) ? null : object, object -> object == null ? supplier.get() : object);
    }

    default public MapCodec<T> elseGet(Supplier<T> supplier) {
        return this.map(object -> object, object -> object == null ? supplier.get() : object);
    }

    default public Codec<T> asCodec() {
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> dataConverter, T t) {
                HashMap hashMap = new HashMap();
                Result<Map<S, S>> result = MapCodec.this.serialize(dataConverter, hashMap, t);
                return result.mapResult(dataConverter::createMergedMap);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> dataConverter, S s) {
                Result<Map<S, S>> result = dataConverter.asMap(s);
                if (result.isError()) {
                    return result.mapError();
                }
                return MapCodec.this.deserialize(dataConverter, result.get());
            }
        };
    }
}

