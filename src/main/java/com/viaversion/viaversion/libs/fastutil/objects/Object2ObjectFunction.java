/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Function;
import com.viaversion.viaversion.libs.fastutil.bytes.Byte2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.chars.Char2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.doubles.Double2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.floats.Float2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ByteFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2CharFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2DoubleFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2FloatFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2LongFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ReferenceFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ShortFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.shorts.Short2ObjectFunction;

@FunctionalInterface
public interface Object2ObjectFunction<K, V>
extends Function<K, V> {
    @Override
    default public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(Object var1);

    @Override
    default public V getOrDefault(Object object, V v) {
        V v2 = this.get(object);
        return v2 != this.defaultReturnValue() || this.containsKey(object) ? v2 : v;
    }

    @Override
    default public V remove(Object object) {
        throw new UnsupportedOperationException();
    }

    default public void defaultReturnValue(V v) {
        throw new UnsupportedOperationException();
    }

    default public V defaultReturnValue() {
        return null;
    }

    default public Object2ByteFunction<K> andThenByte(Object2ByteFunction<V> object2ByteFunction) {
        return object -> object2ByteFunction.getByte(this.get(object));
    }

    default public Byte2ObjectFunction<V> composeByte(Byte2ObjectFunction<K> byte2ObjectFunction) {
        return by -> this.get(byte2ObjectFunction.get(by));
    }

    default public Object2ShortFunction<K> andThenShort(Object2ShortFunction<V> object2ShortFunction) {
        return object -> object2ShortFunction.getShort(this.get(object));
    }

    default public Short2ObjectFunction<V> composeShort(Short2ObjectFunction<K> short2ObjectFunction) {
        return s -> this.get(short2ObjectFunction.get(s));
    }

    default public Object2IntFunction<K> andThenInt(Object2IntFunction<V> object2IntFunction) {
        return object -> object2IntFunction.getInt(this.get(object));
    }

    default public Int2ObjectFunction<V> composeInt(Int2ObjectFunction<K> int2ObjectFunction) {
        return n -> this.get(int2ObjectFunction.get(n));
    }

    default public Object2LongFunction<K> andThenLong(Object2LongFunction<V> object2LongFunction) {
        return object -> object2LongFunction.getLong(this.get(object));
    }

    default public Long2ObjectFunction<V> composeLong(Long2ObjectFunction<K> long2ObjectFunction) {
        return l -> this.get(long2ObjectFunction.get(l));
    }

    default public Object2CharFunction<K> andThenChar(Object2CharFunction<V> object2CharFunction) {
        return object -> object2CharFunction.getChar(this.get(object));
    }

    default public Char2ObjectFunction<V> composeChar(Char2ObjectFunction<K> char2ObjectFunction) {
        return c -> this.get(char2ObjectFunction.get(c));
    }

    default public Object2FloatFunction<K> andThenFloat(Object2FloatFunction<V> object2FloatFunction) {
        return object -> object2FloatFunction.getFloat(this.get(object));
    }

    default public Float2ObjectFunction<V> composeFloat(Float2ObjectFunction<K> float2ObjectFunction) {
        return f -> this.get(float2ObjectFunction.get(f));
    }

    default public Object2DoubleFunction<K> andThenDouble(Object2DoubleFunction<V> object2DoubleFunction) {
        return object -> object2DoubleFunction.getDouble(this.get(object));
    }

    default public Double2ObjectFunction<V> composeDouble(Double2ObjectFunction<K> double2ObjectFunction) {
        return d -> this.get(double2ObjectFunction.get(d));
    }

    default public <T> Object2ObjectFunction<K, T> andThenObject(Object2ObjectFunction<? super V, ? extends T> object2ObjectFunction) {
        return object -> object2ObjectFunction.get(this.get(object));
    }

    default public <T> Object2ObjectFunction<T, V> composeObject(Object2ObjectFunction<? super T, ? extends K> object2ObjectFunction) {
        return object -> this.get(object2ObjectFunction.get(object));
    }

    default public <T> Object2ReferenceFunction<K, T> andThenReference(Object2ReferenceFunction<? super V, ? extends T> object2ReferenceFunction) {
        return object -> object2ReferenceFunction.get(this.get(object));
    }

    default public <T> Reference2ObjectFunction<T, V> composeReference(Reference2ObjectFunction<? super T, ? extends K> reference2ObjectFunction) {
        return object -> this.get(reference2ObjectFunction.get(object));
    }
}

