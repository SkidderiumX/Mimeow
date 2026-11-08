/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class JavaConverter_v1_20_3
implements DataConverter<Object> {
    public static final JavaConverter_v1_20_3 INSTANCE = new JavaConverter_v1_20_3();

    @Override
    public <N> N convertTo(DataConverter<N> dataConverter, @Nullable Object object) {
        if (object == null) {
            return dataConverter.empty();
        }
        if (object instanceof Boolean) {
            return dataConverter.createBoolean((Boolean)object);
        }
        if (object instanceof Byte) {
            return dataConverter.createByte((Byte)object);
        }
        if (object instanceof Short) {
            return dataConverter.createShort((Short)object);
        }
        if (object instanceof Integer) {
            return dataConverter.createInt((Integer)object);
        }
        if (object instanceof Long) {
            return dataConverter.createLong((Long)object);
        }
        if (object instanceof Float) {
            return dataConverter.createFloat(((Float)object).floatValue());
        }
        if (object instanceof Double) {
            return dataConverter.createDouble((Double)object);
        }
        if (object instanceof Number) {
            return dataConverter.createNumber((Number)object);
        }
        if (object instanceof String) {
            return dataConverter.createString((String)object);
        }
        if (object instanceof byte[]) {
            return dataConverter.createByteArray((byte[])object);
        }
        if (object instanceof int[]) {
            return dataConverter.createIntArray((int[])object);
        }
        if (object instanceof long[]) {
            return dataConverter.createLongArray((long[])object);
        }
        if (object instanceof List) {
            return this.convertList(dataConverter, object);
        }
        if (object instanceof Map) {
            return this.convertMap(dataConverter, object);
        }
        throw new IllegalArgumentException("Unknown element type: " + object.getClass().getName());
    }

    @Override
    public Object createBoolean(boolean bl) {
        return bl;
    }

    @Override
    public Result<Boolean> asBoolean(Object object) {
        if (object instanceof Boolean) {
            return Result.success((Boolean)object);
        }
        return Result.unexpected(object, Boolean.class);
    }

    @Override
    public Object createNumber(Number number) {
        return number;
    }

    @Override
    public Result<Number> asNumber(Object object) {
        if (object instanceof Number) {
            return Result.success((Number)object);
        }
        return Result.unexpected(object, Number.class);
    }

    @Override
    public Object createString(String string) {
        return string;
    }

    @Override
    public Result<String> asString(Object object) {
        if (object instanceof String) {
            return Result.success((String)object);
        }
        return Result.unexpected(object, String.class);
    }

    @Override
    public Result<Object> mergeList(@Nullable Object object, List<Object> list) {
        if (object == null) {
            return Result.success(list);
        }
        if (!(object instanceof List)) {
            return Result.unexpected(object, List.class);
        }
        List list2 = (List)object;
        if (list2.isEmpty()) {
            return Result.success(list);
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.addAll(list2);
        arrayList.addAll(list);
        return Result.success(arrayList);
    }

    @Override
    public Result<List<Object>> asList(Object object) {
        if (object instanceof List) {
            return Result.success((List)object);
        }
        return Result.unexpected(object, List.class);
    }

    @Override
    public Object createUnsafeMap(Map<Object, Object> map) {
        return map;
    }

    @Override
    public Result<Object> mergeMap(@Nullable Object object, Map<Object, Object> map) {
        if (object == null) {
            return Result.success(map);
        }
        if (!(object instanceof Map)) {
            return Result.unexpected(object, Map.class);
        }
        Map map2 = (Map)object;
        if (map2.isEmpty()) {
            return Result.success(map);
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.putAll(map2);
        hashMap.putAll(map);
        return Result.success(hashMap);
    }

    @Override
    public Result<Map<Object, Object>> asMap(Object object) {
        if (object instanceof Map) {
            return Result.success((Map)object);
        }
        return Result.unexpected(object, Map.class);
    }

    @Override
    public Result<Map<String, Object>> asStringTypeMap(Object object) {
        if (!(object instanceof Map)) {
            return Result.unexpected(object, Map.class);
        }
        Map map = (Map)object;
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                return Result.unexpected(entry.getKey(), String.class);
            }
            hashMap.put((String)entry.getKey(), entry.getValue());
        }
        return Result.success(hashMap);
    }

    @Override
    public Object createByteArray(byte[] byArray) {
        return byArray;
    }

    @Override
    public Result<byte[]> asByteArray(Object object) {
        if (object instanceof byte[]) {
            return Result.success((byte[])object);
        }
        return Result.unexpected(object, byte[].class);
    }

    @Override
    public Object createIntArray(int[] nArray) {
        return nArray;
    }

    @Override
    public Result<int[]> asIntArray(Object object) {
        if (object instanceof int[]) {
            return Result.success((int[])object);
        }
        return Result.unexpected(object, int[].class);
    }

    @Override
    public Object createLongArray(long[] lArray) {
        return lArray;
    }

    @Override
    public Result<long[]> asLongArray(Object object) {
        if (object instanceof long[]) {
            return Result.success((long[])object);
        }
        return Result.unexpected(object, long[].class);
    }
}

