/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_21_5;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashBuilder;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashCode;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashFunction;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class HashConverter_v1_21_5
implements DataConverter<HashCode> {
    private static final byte TAG_EMPTY = 1;
    private static final byte TAG_MAP_START = 2;
    private static final byte TAG_MAP_END = 3;
    private static final byte TAG_LIST_START = 4;
    private static final byte TAG_LIST_END = 5;
    private static final byte TAG_BYTE = 6;
    private static final byte TAG_SHORT = 7;
    private static final byte TAG_INT = 8;
    private static final byte TAG_LONG = 9;
    private static final byte TAG_FLOAT = 10;
    private static final byte TAG_DOUBLE = 11;
    private static final byte TAG_STRING = 12;
    private static final byte TAG_BOOLEAN = 13;
    private static final byte TAG_BYTE_ARRAY_START = 14;
    private static final byte TAG_BYTE_ARRAY_END = 15;
    private static final byte TAG_INT_ARRAY_START = 16;
    private static final byte TAG_INT_ARRAY_END = 17;
    private static final byte TAG_LONG_ARRAY_START = 18;
    private static final byte TAG_LONG_ARRAY_END = 19;
    private static final byte[] EMPTY_HASH = new byte[]{1};
    private static final byte[] EMPTY_MAP = new byte[]{2, 3};
    private static final byte[] EMPTY_LIST = new byte[]{4, 5};
    private static final byte[] FALSE = new byte[]{13, 0};
    private static final byte[] TRUE = new byte[]{13, 1};
    private static final Comparator<HashCode> HASH_CODE_COMPARATOR = Comparator.comparingLong(HashCode::asLong);
    private static final Comparator<Map.Entry<HashCode, HashCode>> MAP_COMPARATOR = Map.Entry.comparingByKey(HASH_CODE_COMPARATOR).thenComparing(Map.Entry.comparingByValue(HASH_CODE_COMPARATOR));
    private static final String TAG_ERROR = "Unable to convert HashCode to %s";
    public static final HashConverter_v1_21_5 CRC32C = new HashConverter_v1_21_5(HashFunction.CRC32C);
    private final HashFunction hashFunction;
    private final HashCode emptyHash;
    private final HashCode emptyMapHash;
    private final HashCode emptyListHash;
    private final HashCode trueHash;
    private final HashCode falseHash;

    public HashConverter_v1_21_5(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        this.emptyHash = hashFunction.hash(EMPTY_HASH);
        this.emptyMapHash = hashFunction.hash(EMPTY_MAP);
        this.emptyListHash = hashFunction.hash(EMPTY_LIST);
        this.trueHash = hashFunction.hash(TRUE);
        this.falseHash = hashFunction.hash(FALSE);
    }

    @Override
    public <N> N convertTo(DataConverter<N> dataConverter, @Nullable HashCode hashCode) {
        throw new UnsupportedOperationException("Can't convert HashCode to other types");
    }

    @Override
    public HashCode empty() {
        return this.emptyHash;
    }

    @Override
    public HashCode emptyList() {
        return this.emptyListHash;
    }

    @Override
    public HashCode emptyMap() {
        return this.emptyMapHash;
    }

    @Override
    public HashCode createBoolean(boolean bl) {
        return bl ? this.trueHash : this.falseHash;
    }

    @Override
    public HashCode createByte(byte by) {
        return this.hashFunction.builder(2).addByte((byte)6).addByte(by).hash();
    }

    @Override
    public HashCode createShort(short s) {
        return this.hashFunction.builder(3).addByte((byte)7).addShort(s).hash();
    }

    @Override
    public HashCode createInt(int n) {
        return this.hashFunction.builder(5).addByte((byte)8).addInt(n).hash();
    }

    @Override
    public HashCode createLong(long l) {
        return this.hashFunction.builder(9).addByte((byte)9).addLong(l).hash();
    }

    @Override
    public HashCode createFloat(float f) {
        return this.hashFunction.builder(5).addByte((byte)10).addFloat(f).hash();
    }

    @Override
    public HashCode createDouble(double d) {
        return this.hashFunction.builder(9).addByte((byte)11).addDouble(d).hash();
    }

    @Override
    public HashCode createString(String string) {
        return this.hashFunction.builder().addByte((byte)12).addInt(string.length()).addCharSequence(string).hash();
    }

    @Override
    public HashCode createNumber(Number number) {
        if (number instanceof Byte) {
            return this.createByte((Byte)number);
        }
        if (number instanceof Short) {
            return this.createShort((Short)number);
        }
        if (number instanceof Integer) {
            return this.createInt((Integer)number);
        }
        if (number instanceof Long) {
            return this.createLong((Long)number);
        }
        if (number instanceof Float) {
            return this.createFloat(((Float)number).floatValue());
        }
        if (number instanceof Double) {
            return this.createDouble((Double)number);
        }
        return this.createDouble(number.doubleValue());
    }

    @Override
    public HashCode createList(List<HashCode> list) {
        HashBuilder hashBuilder = this.hashFunction.builder().addByte((byte)4);
        for (HashCode hashCode : list) {
            hashBuilder.addBytes(hashCode.asBytes());
        }
        return hashBuilder.addByte((byte)5).hash();
    }

    @Override
    public Result<HashCode> mergeList(@Nullable HashCode hashCode, List<HashCode> list) {
        return Result.error("Can't merge already hashed lists");
    }

    @Override
    public HashCode createByteArray(byte[] byArray) {
        return this.hashFunction.builder(byArray.length + 2).addByte((byte)14).addBytes(byArray).addByte((byte)15).hash();
    }

    @Override
    public HashCode createIntArray(int[] nArray) {
        HashBuilder hashBuilder = this.hashFunction.builder(nArray.length * 4 + 2).addByte((byte)16);
        for (int n : nArray) {
            hashBuilder.addInt(n);
        }
        return hashBuilder.addByte((byte)17).hash();
    }

    @Override
    public HashCode createLongArray(long[] lArray) {
        HashBuilder hashBuilder = this.hashFunction.builder(lArray.length * 8 + 2).addByte((byte)18);
        for (long l : lArray) {
            hashBuilder.addLong(l);
        }
        return hashBuilder.addByte((byte)19).hash();
    }

    @Override
    public HashCode createUnsafeMap(Map<HashCode, HashCode> map) {
        return this.createMergedMap(map).get();
    }

    @Override
    public Result<HashCode> createMergedMap(Map<HashCode, HashCode> map) {
        HashBuilder hashBuilder = this.hashFunction.builder();
        hashBuilder.addByte((byte)2);
        map.entrySet().stream().sorted(MAP_COMPARATOR).forEach(entry -> hashBuilder.addBytes(((HashCode)entry.getKey()).asBytes()).addBytes(((HashCode)entry.getValue()).asBytes()));
        return Result.success(hashBuilder.addByte((byte)3).hash());
    }

    @Override
    public Result<HashCode> mergeMap(@Nullable HashCode hashCode, Map<HashCode, HashCode> map) {
        return Result.error("Can't merge already hashed maps");
    }

    @Override
    public Result<Boolean> asBoolean(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "boolean"));
    }

    @Override
    public Result<Number> asNumber(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "number"));
    }

    @Override
    public Result<String> asString(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "string"));
    }

    @Override
    public Result<List<HashCode>> asList(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "list"));
    }

    @Override
    public Result<Map<HashCode, HashCode>> asMap(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "map"));
    }

    @Override
    public Result<Map<String, HashCode>> asStringTypeMap(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "string type map"));
    }

    @Override
    public Result<byte[]> asByteArray(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "byte array"));
    }

    @Override
    public Result<int[]> asIntArray(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "int array"));
    }

    @Override
    public Result<long[]> asLongArray(HashCode hashCode) {
        return Result.error(String.format(TAG_ERROR, "long array"));
    }
}

