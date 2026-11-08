/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter;

import com.viaversion.viaversion.libs.mcstructs.converter.ConsumerTracking;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public interface DataConverter<T>
extends ConsumerTracking {
    @Override
    default public DataConverter<T> forkIfDefault() {
        return this;
    }

    public <N> N convertTo(DataConverter<N> var1, @Nullable T var2);

    default public <N> T convertFrom(DataConverter<N> dataConverter, @Nullable N n) {
        return (T)dataConverter.convertTo(this, n);
    }

    default public <N> N convertList(DataConverter<N> dataConverter, T t) {
        List list = this.asList(t).orElse(new ArrayList());
        ArrayList<N> arrayList = new ArrayList<N>();
        for (Object e : list) {
            arrayList.add(this.convertTo(dataConverter, e));
        }
        return dataConverter.createList(arrayList);
    }

    default public <N> N convertMap(DataConverter<N> dataConverter, T t) {
        Map map = this.asMap(t).orElse(new HashMap());
        HashMap<N, N> hashMap = new HashMap<N, N>();
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put(this.convertTo(dataConverter, entry.getKey()), this.convertTo(dataConverter, entry.getValue()));
        }
        return dataConverter.createUnsafeMap(hashMap);
    }

    default public T empty() {
        return null;
    }

    public T createBoolean(boolean var1);

    public Result<Boolean> asBoolean(T var1);

    public T createNumber(Number var1);

    public Result<Number> asNumber(T var1);

    default public T createByte(byte by) {
        return this.createNumber(by);
    }

    default public T createShort(short s) {
        return this.createNumber(s);
    }

    default public T createInt(int n) {
        return this.createNumber(n);
    }

    default public T createLong(long l) {
        return this.createNumber(l);
    }

    default public T createFloat(float f) {
        return this.createNumber(Float.valueOf(f));
    }

    default public T createDouble(double d) {
        return this.createNumber(d);
    }

    public T createString(String var1);

    public Result<String> asString(T var1);

    default public T createList(List<T> list) {
        return this.mergeList((T)null, list).get();
    }

    default public T emptyList() {
        return this.createList(Collections.emptyList());
    }

    public Result<T> mergeList(@Nullable T var1, List<T> var2);

    default public Result<T> mergeList(@Nullable T t, T ... TArray) {
        return this.mergeList(t, Arrays.asList(TArray));
    }

    public Result<List<T>> asList(T var1);

    public T createUnsafeMap(Map<T, T> var1);

    default public T emptyMap() {
        return (T)this.createUnsafeMap(Collections.emptyMap());
    }

    default public Result<T> createMergedMap(Map<T, T> map) {
        T t = this.emptyMap();
        for (Map.Entry<T, T> entry : map.entrySet()) {
            Result<T> result = this.mergeMap(t, entry.getKey(), entry.getValue());
            if (result.isError()) {
                return result;
            }
            t = result.get();
        }
        return Result.success(t);
    }

    public Result<T> mergeMap(@Nullable T var1, Map<T, T> var2);

    default public Result<T> mergeMap(@Nullable T t, T t2, T t3) {
        return this.mergeMap(t, Collections.singletonMap(t2, t3));
    }

    default public Result<T> mergeMap(@Nullable T t, T ... TArray) {
        if (TArray.length % 2 != 0) {
            return Result.error("Key-Value pairs must be even");
        }
        HashMap<T, T> hashMap = new HashMap<T, T>();
        for (int i = 0; i < TArray.length; i += 2) {
            hashMap.put(TArray[i], TArray[i + 1]);
        }
        return this.mergeMap(t, (Map<T, T>)hashMap);
    }

    public Result<Map<T, T>> asMap(T var1);

    public Result<Map<String, T>> asStringTypeMap(T var1);

    public T createByteArray(byte[] var1);

    public Result<byte[]> asByteArray(T var1);

    public T createIntArray(int[] var1);

    public Result<int[]> asIntArray(T var1);

    public T createLongArray(long[] var1);

    public Result<long[]> asLongArray(T var1);

    default public Codec<T> toCodec() {
        return new Codec<T>(){

            @Override
            public <S> Result<T> deserialize(DataConverter<S> dataConverter, S s) {
                try {
                    return Result.success(DataConverter.this.fork(dataConverter).convertTo(DataConverter.this, s));
                }
                catch (Throwable throwable) {
                    return Result.error(throwable);
                }
            }

            @Override
            public <S> Result<S> serialize(DataConverter<S> dataConverter, T t) {
                try {
                    return Result.success(dataConverter.fork(dataConverter).convertFrom(DataConverter.this, t));
                }
                catch (Throwable throwable) {
                    return Result.error(throwable);
                }
            }
        };
    }

    default public <O> DataConverter<O> fork(DataConverter<O> dataConverter) {
        if (this.currentConsumer() != null) {
            ConsumerTracking consumerTracking = dataConverter.forkIfDefault();
            consumerTracking.setCurrentConsumer(this.currentConsumer());
            return consumerTracking;
        }
        return dataConverter;
    }
}

