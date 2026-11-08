/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public class EnumTypeAdapterFactory
implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<T> clazz = typeToken.getRawType();
        if (!clazz.isEnum()) {
            return null;
        }
        final HashMap<String, T> hashMap = Maps.newHashMap();
        for (T t : clazz.getEnumConstants()) {
            hashMap.put(this.func_151232_a(t), t);
        }
        return new TypeAdapter<T>(){

            @Override
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(EnumTypeAdapterFactory.this.func_151232_a(t));
                }
            }

            @Override
            public T read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return hashMap.get(jsonReader.nextString());
            }
        };
    }

    private String func_151232_a(Object object) {
        return object instanceof Enum ? ((Enum)object).name().toLowerCase(Locale.US) : object.toString().toLowerCase(Locale.US);
    }
}

