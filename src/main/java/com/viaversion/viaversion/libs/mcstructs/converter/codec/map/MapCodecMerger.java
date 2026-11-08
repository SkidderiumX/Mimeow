/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec.map;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Map;
import java.util.function.Function;

public class MapCodecMerger {
    public static <T1, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final I1<T1, O> i1) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                return Result.success(i1.apply(result.get()));
            }
        };
    }

    public static <T1, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, I1<T1, O> i1) {
        return MapCodecMerger.mapCodec(mapCodec, function, i1).asCodec();
    }

    public static <T1, T2, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final I2<T1, T2, O> i2) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                return Result.success(i2.apply(result.get(), result2.get()));
            }
        };
    }

    public static <T1, T2, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, I2<T1, T2, O> i2) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, i2).asCodec();
    }

    public static <T1, T2, T3, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final I3<T1, T2, T3, O> i3) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                return Result.success(i3.apply(result.get(), result2.get(), result3.get()));
            }
        };
    }

    public static <T1, T2, T3, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, I3<T1, T2, T3, O> i3) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, i3).asCodec();
    }

    public static <T1, T2, T3, T4, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final I4<T1, T2, T3, T4, O> i4) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                return Result.success(i4.apply(result.get(), result2.get(), result3.get(), result4.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, I4<T1, T2, T3, T4, O> i4) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, i4).asCodec();
    }

    public static <T1, T2, T3, T4, T5, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final MapCodec<T5> mapCodec5, final Function<O, T5> function5, final I5<T1, T2, T3, T4, T5, O> i5) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec5.serialize(dataConverter, result.get(), function5.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = mapCodec5.deserialize(dataConverter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                return Result.success(i5.apply(result.get(), result2.get(), result3.get(), result4.get(), result5.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, MapCodec<T5> mapCodec5, Function<O, T5> function5, I5<T1, T2, T3, T4, T5, O> i5) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, mapCodec5, function5, i5).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final MapCodec<T5> mapCodec5, final Function<O, T5> function5, final MapCodec<T6> mapCodec6, final Function<O, T6> function6, final I6<T1, T2, T3, T4, T5, T6, O> i6) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec5.serialize(dataConverter, result.get(), function5.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec6.serialize(dataConverter, result.get(), function6.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = mapCodec5.deserialize(dataConverter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = mapCodec6.deserialize(dataConverter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                return Result.success(i6.apply(result.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, MapCodec<T5> mapCodec5, Function<O, T5> function5, MapCodec<T6> mapCodec6, Function<O, T6> function6, I6<T1, T2, T3, T4, T5, T6, O> i6) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, mapCodec5, function5, mapCodec6, function6, i6).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final MapCodec<T5> mapCodec5, final Function<O, T5> function5, final MapCodec<T6> mapCodec6, final Function<O, T6> function6, final MapCodec<T7> mapCodec7, final Function<O, T7> function7, final I7<T1, T2, T3, T4, T5, T6, T7, O> i7) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec5.serialize(dataConverter, result.get(), function5.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec6.serialize(dataConverter, result.get(), function6.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec7.serialize(dataConverter, result.get(), function7.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = mapCodec5.deserialize(dataConverter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = mapCodec6.deserialize(dataConverter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = mapCodec7.deserialize(dataConverter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                return Result.success(i7.apply(result.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, MapCodec<T5> mapCodec5, Function<O, T5> function5, MapCodec<T6> mapCodec6, Function<O, T6> function6, MapCodec<T7> mapCodec7, Function<O, T7> function7, I7<T1, T2, T3, T4, T5, T6, T7, O> i7) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, mapCodec5, function5, mapCodec6, function6, mapCodec7, function7, i7).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final MapCodec<T5> mapCodec5, final Function<O, T5> function5, final MapCodec<T6> mapCodec6, final Function<O, T6> function6, final MapCodec<T7> mapCodec7, final Function<O, T7> function7, final MapCodec<T8> mapCodec8, final Function<O, T8> function8, final I8<T1, T2, T3, T4, T5, T6, T7, T8, O> i8) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec5.serialize(dataConverter, result.get(), function5.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec6.serialize(dataConverter, result.get(), function6.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec7.serialize(dataConverter, result.get(), function7.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec8.serialize(dataConverter, result.get(), function8.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = mapCodec5.deserialize(dataConverter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = mapCodec6.deserialize(dataConverter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = mapCodec7.deserialize(dataConverter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = mapCodec8.deserialize(dataConverter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                return Result.success(i8.apply(result.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, MapCodec<T5> mapCodec5, Function<O, T5> function5, MapCodec<T6> mapCodec6, Function<O, T6> function6, MapCodec<T7> mapCodec7, Function<O, T7> function7, MapCodec<T8> mapCodec8, Function<O, T8> function8, I8<T1, T2, T3, T4, T5, T6, T7, T8, O> i8) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, mapCodec5, function5, mapCodec6, function6, mapCodec7, function7, mapCodec8, function8, i8).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final MapCodec<T5> mapCodec5, final Function<O, T5> function5, final MapCodec<T6> mapCodec6, final Function<O, T6> function6, final MapCodec<T7> mapCodec7, final Function<O, T7> function7, final MapCodec<T8> mapCodec8, final Function<O, T8> function8, final MapCodec<T9> mapCodec9, final Function<O, T9> function9, final I9<T1, T2, T3, T4, T5, T6, T7, T8, T9, O> i9) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec5.serialize(dataConverter, result.get(), function5.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec6.serialize(dataConverter, result.get(), function6.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec7.serialize(dataConverter, result.get(), function7.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec8.serialize(dataConverter, result.get(), function8.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec9.serialize(dataConverter, result.get(), function9.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = mapCodec5.deserialize(dataConverter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = mapCodec6.deserialize(dataConverter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = mapCodec7.deserialize(dataConverter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = mapCodec8.deserialize(dataConverter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                Result result9 = mapCodec9.deserialize(dataConverter, map);
                if (result9.isError()) {
                    return result9.mapError();
                }
                return Result.success(i9.apply(result.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get(), result9.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, MapCodec<T5> mapCodec5, Function<O, T5> function5, MapCodec<T6> mapCodec6, Function<O, T6> function6, MapCodec<T7> mapCodec7, Function<O, T7> function7, MapCodec<T8> mapCodec8, Function<O, T8> function8, MapCodec<T9> mapCodec9, Function<O, T9> function9, I9<T1, T2, T3, T4, T5, T6, T7, T8, T9, O> i9) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, mapCodec5, function5, mapCodec6, function6, mapCodec7, function7, mapCodec8, function8, mapCodec9, function9, i9).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final MapCodec<T5> mapCodec5, final Function<O, T5> function5, final MapCodec<T6> mapCodec6, final Function<O, T6> function6, final MapCodec<T7> mapCodec7, final Function<O, T7> function7, final MapCodec<T8> mapCodec8, final Function<O, T8> function8, final MapCodec<T9> mapCodec9, final Function<O, T9> function9, final MapCodec<T10> mapCodec10, final Function<O, T10> function10, final I10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> i10) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec5.serialize(dataConverter, result.get(), function5.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec6.serialize(dataConverter, result.get(), function6.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec7.serialize(dataConverter, result.get(), function7.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec8.serialize(dataConverter, result.get(), function8.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec9.serialize(dataConverter, result.get(), function9.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec10.serialize(dataConverter, result.get(), function10.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = mapCodec5.deserialize(dataConverter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = mapCodec6.deserialize(dataConverter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = mapCodec7.deserialize(dataConverter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = mapCodec8.deserialize(dataConverter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                Result result9 = mapCodec9.deserialize(dataConverter, map);
                if (result9.isError()) {
                    return result9.mapError();
                }
                Result result10 = mapCodec10.deserialize(dataConverter, map);
                if (result10.isError()) {
                    return result10.mapError();
                }
                return Result.success(i10.apply(result.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get(), result9.get(), result10.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, MapCodec<T5> mapCodec5, Function<O, T5> function5, MapCodec<T6> mapCodec6, Function<O, T6> function6, MapCodec<T7> mapCodec7, Function<O, T7> function7, MapCodec<T8> mapCodec8, Function<O, T8> function8, MapCodec<T9> mapCodec9, Function<O, T9> function9, MapCodec<T10> mapCodec10, Function<O, T10> function10, I10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> i10) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, mapCodec5, function5, mapCodec6, function6, mapCodec7, function7, mapCodec8, function8, mapCodec9, function9, mapCodec10, function10, i10).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> MapCodec<O> mapCodec(final MapCodec<T1> mapCodec, final Function<O, T1> function, final MapCodec<T2> mapCodec2, final Function<O, T2> function2, final MapCodec<T3> mapCodec3, final Function<O, T3> function3, final MapCodec<T4> mapCodec4, final Function<O, T4> function4, final MapCodec<T5> mapCodec5, final Function<O, T5> function5, final MapCodec<T6> mapCodec6, final Function<O, T6> function6, final MapCodec<T7> mapCodec7, final Function<O, T7> function7, final MapCodec<T8> mapCodec8, final Function<O, T8> function8, final MapCodec<T9> mapCodec9, final Function<O, T9> function9, final MapCodec<T10> mapCodec10, final Function<O, T10> function10, final MapCodec<T11> mapCodec11, final Function<O, T11> function11, final I11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> i11) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> dataConverter, Map<S, S> map, O o) {
                Result<Map<S, S>> result = mapCodec.serialize(dataConverter, map, function.apply(o));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec2.serialize(dataConverter, result.get(), function2.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec3.serialize(dataConverter, result.get(), function3.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec4.serialize(dataConverter, result.get(), function4.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec5.serialize(dataConverter, result.get(), function5.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec6.serialize(dataConverter, result.get(), function6.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec7.serialize(dataConverter, result.get(), function7.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec8.serialize(dataConverter, result.get(), function8.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec9.serialize(dataConverter, result.get(), function9.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec10.serialize(dataConverter, result.get(), function10.apply(o))).isError()) {
                    return result.mapError();
                }
                if ((result = mapCodec11.serialize(dataConverter, result.get(), function11.apply(o))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> dataConverter, Map<S, S> map) {
                Result result = mapCodec.deserialize(dataConverter, map);
                if (result.isError()) {
                    return result.mapError();
                }
                Result result2 = mapCodec2.deserialize(dataConverter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = mapCodec3.deserialize(dataConverter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = mapCodec4.deserialize(dataConverter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = mapCodec5.deserialize(dataConverter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = mapCodec6.deserialize(dataConverter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = mapCodec7.deserialize(dataConverter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = mapCodec8.deserialize(dataConverter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                Result result9 = mapCodec9.deserialize(dataConverter, map);
                if (result9.isError()) {
                    return result9.mapError();
                }
                Result result10 = mapCodec10.deserialize(dataConverter, map);
                if (result10.isError()) {
                    return result10.mapError();
                }
                Result result11 = mapCodec11.deserialize(dataConverter, map);
                if (result11.isError()) {
                    return result11.mapError();
                }
                return Result.success(i11.apply(result.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get(), result9.get(), result10.get(), result11.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> Codec<O> codec(MapCodec<T1> mapCodec, Function<O, T1> function, MapCodec<T2> mapCodec2, Function<O, T2> function2, MapCodec<T3> mapCodec3, Function<O, T3> function3, MapCodec<T4> mapCodec4, Function<O, T4> function4, MapCodec<T5> mapCodec5, Function<O, T5> function5, MapCodec<T6> mapCodec6, Function<O, T6> function6, MapCodec<T7> mapCodec7, Function<O, T7> function7, MapCodec<T8> mapCodec8, Function<O, T8> function8, MapCodec<T9> mapCodec9, Function<O, T9> function9, MapCodec<T10> mapCodec10, Function<O, T10> function10, MapCodec<T11> mapCodec11, Function<O, T11> function11, I11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> i11) {
        return MapCodecMerger.mapCodec(mapCodec, function, mapCodec2, function2, mapCodec3, function3, mapCodec4, function4, mapCodec5, function5, mapCodec6, function6, mapCodec7, function7, mapCodec8, function8, mapCodec9, function9, mapCodec10, function10, mapCodec11, function11, i11).asCodec();
    }

    @FunctionalInterface
    public static interface I11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8, T9 var9, T10 var10, T11 var11);
    }

    @FunctionalInterface
    public static interface I10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8, T9 var9, T10 var10);
    }

    @FunctionalInterface
    public static interface I9<T1, T2, T3, T4, T5, T6, T7, T8, T9, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8, T9 var9);
    }

    @FunctionalInterface
    public static interface I8<T1, T2, T3, T4, T5, T6, T7, T8, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8);
    }

    @FunctionalInterface
    public static interface I7<T1, T2, T3, T4, T5, T6, T7, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7);
    }

    @FunctionalInterface
    public static interface I6<T1, T2, T3, T4, T5, T6, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6);
    }

    @FunctionalInterface
    public static interface I5<T1, T2, T3, T4, T5, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5);
    }

    @FunctionalInterface
    public static interface I4<T1, T2, T3, T4, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4);
    }

    @FunctionalInterface
    public static interface I3<T1, T2, T3, O> {
        public O apply(T1 var1, T2 var2, T3 var3);
    }

    @FunctionalInterface
    public static interface I2<T1, T2, O> {
        public O apply(T1 var1, T2 var2);
    }

    @FunctionalInterface
    public static interface I1<T1, O> {
        public O apply(T1 var1);
    }
}

