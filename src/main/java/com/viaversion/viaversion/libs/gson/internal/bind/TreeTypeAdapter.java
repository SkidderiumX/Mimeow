/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.TypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.Streams;
import com.viaversion.viaversion.libs.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

public class TreeTypeAdapter<T>
extends SerializationDelegatingTypeAdapter<T> {
    private final JsonSerializer<T> serializer;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final TypeToken<T> typeToken;
    private final TypeAdapterFactory skipPastForGetDelegateAdapter;
    private final GsonContextImpl context = new GsonContextImpl();
    private final boolean nullSafe;
    private volatile TypeAdapter<T> delegate;

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory, boolean bl) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPastForGetDelegateAdapter = typeAdapterFactory;
        this.nullSafe = bl;
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, true);
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        if (this.deserializer == null) {
            return this.delegate().read(jsonReader);
        }
        JsonElement jsonElement = Streams.parse(jsonReader);
        if (this.nullSafe && jsonElement.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(jsonElement, this.typeToken.getType(), this.context);
    }

    @Override
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (this.serializer == null) {
            this.delegate().write(jsonWriter, t);
            return;
        }
        if (this.nullSafe && t == null) {
            jsonWriter.nullValue();
            return;
        }
        JsonElement jsonElement = this.serializer.serialize(t, this.typeToken.getType(), this.context);
        Streams.write(jsonElement, jsonWriter);
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter == null) {
            typeAdapter = this.delegate = this.gson.getDelegateAdapter(this.skipPastForGetDelegateAdapter, this.typeToken);
        }
        return typeAdapter;
    }

    @Override
    public TypeAdapter<T> getSerializationDelegate() {
        return this.serializer != null ? this : this.delegate();
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object object) {
        return new SingleTypeFactory(object, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object object) {
        boolean bl = typeToken.getType() == typeToken.getRawType();
        return new SingleTypeFactory(object, typeToken, bl, null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> clazz, Object object) {
        return new SingleTypeFactory(object, null, false, clazz);
    }

    private final class GsonContextImpl
    implements JsonSerializationContext,
    JsonDeserializationContext {
        private GsonContextImpl() {
        }

        @Override
        public JsonElement serialize(Object object) {
            return TreeTypeAdapter.this.gson.toJsonTree(object);
        }

        @Override
        public JsonElement serialize(Object object, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(object, type);
        }

        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R)TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }
    }

    private static final class SingleTypeFactory
    implements TypeAdapterFactory {
        private final TypeToken<?> exactType;
        private final boolean matchRawType;
        private final Class<?> hierarchyType;
        private final JsonSerializer<?> serializer;
        private final JsonDeserializer<?> deserializer;

        SingleTypeFactory(Object object, TypeToken<?> typeToken, boolean bl, Class<?> clazz) {
            this.serializer = object instanceof JsonSerializer ? (JsonSerializer)object : null;
            JsonDeserializer jsonDeserializer = this.deserializer = object instanceof JsonDeserializer ? (JsonDeserializer)object : null;
            if (this.serializer == null && this.deserializer == null) {
                Objects.requireNonNull(object);
                throw new IllegalArgumentException("Type adapter " + object.getClass().getName() + " must implement JsonSerializer or JsonDeserializer");
            }
            this.exactType = typeToken;
            this.matchRawType = bl;
            this.hierarchyType = clazz;
        }

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean bl = this.exactType != null ? this.exactType.equals(typeToken) || this.matchRawType && this.exactType.getType() == typeToken.getRawType() : this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            return bl ? new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this) : null;
        }
    }
}

