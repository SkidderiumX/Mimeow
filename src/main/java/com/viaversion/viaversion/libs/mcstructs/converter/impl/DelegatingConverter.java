/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.impl;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class DelegatingConverter<T>
implements DataConverter<T> {
    private final DataConverter<T> delegate;

    public DelegatingConverter(DataConverter<T> dataConverter) {
        this.delegate = dataConverter;
    }

    public DataConverter<T> getDelegate() {
        return this.delegate;
    }

    @Override
    public <N> N convertTo(DataConverter<N> dataConverter, @Nullable T t) {
        return this.delegate.convertTo(dataConverter, t);
    }

    @Override
    public <N> T convertFrom(DataConverter<N> dataConverter, @Nullable N n) {
        return this.delegate.convertFrom(dataConverter, n);
    }

    @Override
    public <N> N convertList(DataConverter<N> dataConverter, T t) {
        return this.delegate.convertList(dataConverter, t);
    }

    @Override
    public <N> N convertMap(DataConverter<N> dataConverter, T t) {
        return this.delegate.convertMap(dataConverter, t);
    }

    @Override
    public T createBoolean(boolean bl) {
        return this.delegate.createBoolean(bl);
    }

    @Override
    public Result<Boolean> asBoolean(T t) {
        return this.delegate.asBoolean(t);
    }

    @Override
    public T createNumber(Number number) {
        return this.delegate.createNumber(number);
    }

    @Override
    public Result<Number> asNumber(T t) {
        return this.delegate.asNumber(t);
    }

    @Override
    public T createByte(byte by) {
        return this.delegate.createByte(by);
    }

    @Override
    public T createShort(short s) {
        return this.delegate.createShort(s);
    }

    @Override
    public T createInt(int n) {
        return this.delegate.createInt(n);
    }

    @Override
    public T createLong(long l) {
        return this.delegate.createLong(l);
    }

    @Override
    public T createFloat(float f) {
        return this.delegate.createFloat(f);
    }

    @Override
    public T createDouble(double d) {
        return this.delegate.createDouble(d);
    }

    @Override
    public T createString(String string) {
        return this.delegate.createString(string);
    }

    @Override
    public Result<String> asString(T t) {
        return this.delegate.asString(t);
    }

    @Override
    public T createList(List<T> list) {
        return this.delegate.createList(list);
    }

    @Override
    public T emptyList() {
        return this.delegate.emptyList();
    }

    @Override
    public Result<T> mergeList(@Nullable T t, List<T> list) {
        return this.delegate.mergeList(t, list);
    }

    @Override
    @SafeVarargs
    public final Result<T> mergeList(@Nullable T t, T ... TArray) {
        return this.delegate.mergeList(t, TArray);
    }

    @Override
    public Result<List<T>> asList(T t) {
        return this.delegate.asList(t);
    }

    @Override
    public T createUnsafeMap(Map<T, T> map) {
        return this.delegate.createUnsafeMap(map);
    }

    @Override
    public T emptyMap() {
        return this.delegate.emptyMap();
    }

    @Override
    public Result<T> createMergedMap(Map<T, T> map) {
        return this.delegate.createMergedMap(map);
    }

    @Override
    public Result<T> mergeMap(@Nullable T t, Map<T, T> map) {
        return this.delegate.mergeMap(t, map);
    }

    @Override
    public Result<T> mergeMap(@Nullable T t, T t2, T t3) {
        return this.delegate.mergeMap(t, t2, t3);
    }

    @Override
    @SafeVarargs
    public final Result<T> mergeMap(@Nullable T t, T ... TArray) {
        return this.delegate.mergeMap(t, TArray);
    }

    @Override
    public Result<Map<T, T>> asMap(T t) {
        return this.delegate.asMap(t);
    }

    @Override
    public Result<Map<String, T>> asStringTypeMap(T t) {
        return this.delegate.asStringTypeMap(t);
    }

    @Override
    public T createByteArray(byte[] byArray) {
        return this.delegate.createByteArray(byArray);
    }

    @Override
    public Result<byte[]> asByteArray(T t) {
        return this.delegate.asByteArray(t);
    }

    @Override
    public T createIntArray(int[] nArray) {
        return this.delegate.createIntArray(nArray);
    }

    @Override
    public Result<int[]> asIntArray(T t) {
        return this.delegate.asIntArray(t);
    }

    @Override
    public T createLongArray(long[] lArray) {
        return this.delegate.createLongArray(lArray);
    }

    @Override
    public Result<long[]> asLongArray(T t) {
        return this.delegate.asLongArray(t);
    }

    @Override
    public Codec<T> toCodec() {
        return this.delegate.toCodec();
    }

    @Override
    public <O> DataConverter<O> fork(DataConverter<O> dataConverter) {
        return this.delegate.fork(dataConverter);
    }
}

