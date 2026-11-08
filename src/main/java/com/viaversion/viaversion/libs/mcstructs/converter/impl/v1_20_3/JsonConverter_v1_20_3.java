/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonNull;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;
import javax.annotation.Nullable;

public class JsonConverter_v1_20_3
implements DataConverter<JsonElement> {
    public static final JsonConverter_v1_20_3 INSTANCE = new JsonConverter_v1_20_3();
    private Consumer<String> stringConsumer;

    @Override
    @Nullable
    public Consumer<String> currentConsumer() {
        return this.stringConsumer;
    }

    @Override
    public void setCurrentConsumer(Consumer<String> consumer) {
        this.stringConsumer = consumer;
    }

    @Override
    public DataConverter<JsonElement> forkIfDefault() {
        return this == INSTANCE ? new JsonConverter_v1_20_3() : this;
    }

    @Override
    public <N> N convertTo(DataConverter<N> dataConverter, @Nullable JsonElement jsonElement) {
        if (dataConverter == this) {
            return (N)jsonElement;
        }
        if (jsonElement == null || jsonElement instanceof JsonNull) {
            return dataConverter.empty();
        }
        if (jsonElement instanceof JsonObject) {
            return this.convertMap(dataConverter, jsonElement);
        }
        if (jsonElement instanceof JsonArray) {
            return this.convertList(dataConverter, jsonElement);
        }
        JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
        if (jsonPrimitive.isString()) {
            return dataConverter.createString(jsonPrimitive.getAsString());
        }
        if (jsonPrimitive.isBoolean()) {
            return dataConverter.createBoolean(jsonPrimitive.getAsBoolean());
        }
        BigDecimal bigDecimal = jsonPrimitive.getAsBigDecimal();
        try {
            long l = bigDecimal.longValueExact();
            if ((long)((byte)l) == l) {
                return dataConverter.createByte((byte)l);
            }
            if ((long)((short)l) == l) {
                return dataConverter.createShort((short)l);
            }
            if ((long)((int)l) == l) {
                return dataConverter.createInt((int)l);
            }
            return dataConverter.createLong(l);
        }
        catch (ArithmeticException arithmeticException) {
            double d = bigDecimal.doubleValue();
            if ((double)((float)d) == d) {
                return dataConverter.createFloat((float)d);
            }
            return dataConverter.createDouble(d);
        }
    }

    @Override
    public JsonElement empty() {
        return JsonNull.INSTANCE;
    }

    @Override
    public JsonElement createBoolean(boolean bl) {
        return new JsonPrimitive(bl);
    }

    @Override
    public Result<Boolean> asBoolean(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (jsonPrimitive.isBoolean()) {
                return Result.success(jsonPrimitive.getAsBoolean());
            }
            if (jsonPrimitive.isNumber()) {
                return Result.success(jsonPrimitive.getAsNumber().byteValue() != 0);
            }
        }
        return Result.unexpected((Object)jsonElement, "boolean");
    }

    @Override
    public JsonElement createNumber(Number number) {
        return new JsonPrimitive(number);
    }

    @Override
    public Result<Number> asNumber(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (jsonPrimitive.isBoolean()) {
                return Result.success(jsonPrimitive.getAsBoolean() ? 1 : 0);
            }
            if (jsonPrimitive.isNumber()) {
                return Result.success(jsonPrimitive.getAsNumber());
            }
        }
        return Result.unexpected((Object)jsonElement, "number");
    }

    @Override
    public JsonElement createString(String string) {
        return new JsonPrimitive(string);
    }

    @Override
    public Result<String> asString(JsonElement jsonElement) {
        if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            return Result.unexpected((Object)jsonElement, "string");
        }
        return Result.success(jsonElement.getAsJsonPrimitive().getAsString());
    }

    @Override
    public Result<JsonElement> mergeList(@Nullable JsonElement jsonElement, List<JsonElement> list) {
        if (jsonElement == null) {
            jsonElement = new JsonArray();
        }
        if (!jsonElement.isJsonArray()) {
            return Result.unexpected((Object)jsonElement, JsonArray.class);
        }
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        for (JsonElement jsonElement2 : list) {
            jsonArray.add(jsonElement2);
        }
        return Result.success(jsonArray);
    }

    @Override
    public Result<List<JsonElement>> asList(JsonElement jsonElement) {
        if (!jsonElement.isJsonArray()) {
            return Result.unexpected((Object)jsonElement, JsonArray.class);
        }
        return Result.success(jsonElement.getAsJsonArray().asList());
    }

    @Override
    public JsonElement createUnsafeMap(Map<JsonElement, JsonElement> map) {
        JsonObject jsonObject = new JsonObject();
        map.forEach((jsonElement, jsonElement2) -> jsonObject.add(jsonElement.getAsString(), (JsonElement)jsonElement2));
        return jsonObject;
    }

    @Override
    public Result<JsonElement> mergeMap(@Nullable JsonElement jsonElement, Map<JsonElement, JsonElement> map) {
        if (jsonElement == null) {
            jsonElement = new JsonObject();
        }
        if (!jsonElement.isJsonObject()) {
            return Result.unexpected((Object)jsonElement, JsonObject.class);
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<JsonElement, JsonElement> entry : map.entrySet()) {
            if (!entry.getKey().isJsonPrimitive() || !entry.getKey().getAsJsonPrimitive().isString()) {
                return Result.unexpected((Object)entry.getKey(), "string");
            }
            jsonObject.add(entry.getKey().getAsString(), entry.getValue());
        }
        return Result.success(jsonObject);
    }

    @Override
    public Result<Map<JsonElement, JsonElement>> asMap(JsonElement jsonElement) {
        if (!jsonElement.isJsonObject()) {
            return Result.unexpected((Object)jsonElement, JsonObject.class);
        }
        HashMap hashMap = new HashMap();
        jsonElement.getAsJsonObject().entrySet().forEach(entry -> {
            JsonElement cfr_ignored_0 = (JsonElement)hashMap.put(this.createString((String)entry.getKey()), entry.getValue());
        });
        return Result.success(hashMap);
    }

    @Override
    public Result<Map<String, JsonElement>> asStringTypeMap(JsonElement jsonElement) {
        if (!jsonElement.isJsonObject()) {
            return Result.unexpected((Object)jsonElement, JsonObject.class);
        }
        HashMap hashMap = new HashMap();
        jsonElement.getAsJsonObject().entrySet().forEach(entry -> {
            JsonElement cfr_ignored_0 = (JsonElement)hashMap.put(entry.getKey(), entry.getValue());
        });
        return Result.success(hashMap);
    }

    @Override
    public JsonElement createByteArray(byte[] byArray) {
        JsonArray jsonArray = new JsonArray();
        for (byte by : byArray) {
            jsonArray.add(by);
        }
        return jsonArray;
    }

    @Override
    public Result<byte[]> asByteArray(JsonElement jsonElement2) {
        if (!jsonElement2.isJsonArray()) {
            return Result.unexpected((Object)jsonElement2, JsonArray.class);
        }
        JsonArray jsonArray = jsonElement2.getAsJsonArray();
        if (StreamSupport.stream(jsonArray.spliterator(), false).anyMatch(jsonElement -> jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber())) {
            byte[] byArray = new byte[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); ++i) {
                byArray[i] = jsonArray.get(i).getAsByte();
            }
            return Result.success(byArray);
        }
        return Result.unexpected((Object)jsonElement2, byte[].class);
    }

    @Override
    public JsonElement createIntArray(int[] nArray) {
        JsonArray jsonArray = new JsonArray();
        for (int n : nArray) {
            jsonArray.add(n);
        }
        return jsonArray;
    }

    @Override
    public Result<int[]> asIntArray(JsonElement jsonElement2) {
        if (!jsonElement2.isJsonArray()) {
            return Result.unexpected((Object)jsonElement2, JsonArray.class);
        }
        JsonArray jsonArray = jsonElement2.getAsJsonArray();
        if (StreamSupport.stream(jsonArray.spliterator(), false).anyMatch(jsonElement -> jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber())) {
            int[] nArray = new int[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); ++i) {
                nArray[i] = jsonArray.get(i).getAsInt();
            }
            return Result.success(nArray);
        }
        return Result.unexpected((Object)jsonElement2, int[].class);
    }

    @Override
    public JsonElement createLongArray(long[] lArray) {
        JsonArray jsonArray = new JsonArray();
        for (long l : lArray) {
            jsonArray.add(l);
        }
        return jsonArray;
    }

    @Override
    public Result<long[]> asLongArray(JsonElement jsonElement2) {
        if (!jsonElement2.isJsonArray()) {
            return Result.unexpected((Object)jsonElement2, JsonArray.class);
        }
        JsonArray jsonArray = jsonElement2.getAsJsonArray();
        if (StreamSupport.stream(jsonArray.spliterator(), false).anyMatch(jsonElement -> jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber())) {
            long[] lArray = new long[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); ++i) {
                lArray[i] = jsonArray.get(i).getAsLong();
            }
            return Result.success(lArray);
        }
        return Result.unexpected((Object)jsonElement2, long[].class);
    }
}

