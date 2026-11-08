/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JsonAdapterAnnotationTypeAdapterFactory
implements TypeAdapterFactory {
    private static final TypeAdapterFactory TREE_TYPE_CLASS_DUMMY_FACTORY = new DummyTypeAdapterFactory();
    private static final TypeAdapterFactory TREE_TYPE_FIELD_DUMMY_FACTORY = new DummyTypeAdapterFactory();
    private final ConstructorConstructor constructorConstructor;
    private final ConcurrentMap<Class<?>, TypeAdapterFactory> adapterFactoryMap;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
        this.adapterFactoryMap = new ConcurrentHashMap();
    }

    private static JsonAdapter getAnnotation(Class<?> clazz) {
        return clazz.getAnnotation(JsonAdapter.class);
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<T> clazz = typeToken.getRawType();
        JsonAdapter jsonAdapter = JsonAdapterAnnotationTypeAdapterFactory.getAnnotation(clazz);
        if (jsonAdapter == null) {
            return null;
        }
        return this.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter, true);
    }

    private static Object createAdapter(ConstructorConstructor constructorConstructor, Class<?> clazz) {
        boolean bl = true;
        return constructorConstructor.get(TypeToken.get(clazz), bl).construct();
    }

    private TypeAdapterFactory putFactoryAndGetCurrent(Class<?> clazz, TypeAdapterFactory typeAdapterFactory) {
        TypeAdapterFactory typeAdapterFactory2 = this.adapterFactoryMap.putIfAbsent(clazz, typeAdapterFactory);
        return typeAdapterFactory2 != null ? typeAdapterFactory2 : typeAdapterFactory;
    }

    TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter, boolean bl) {
        TypeAdapter<Object> typeAdapter;
        Object object = JsonAdapterAnnotationTypeAdapterFactory.createAdapter(constructorConstructor, jsonAdapter.value());
        boolean bl2 = jsonAdapter.nullSafe();
        if (object instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter)object;
        } else if (object instanceof TypeAdapterFactory) {
            TypeAdapterFactory typeAdapterFactory = (TypeAdapterFactory)object;
            if (bl) {
                typeAdapterFactory = this.putFactoryAndGetCurrent(typeToken.getRawType(), typeAdapterFactory);
            }
            typeAdapter = typeAdapterFactory.create(gson, typeToken);
        } else if (object instanceof JsonSerializer || object instanceof JsonDeserializer) {
            JsonSerializer jsonSerializer = object instanceof JsonSerializer ? (JsonSerializer)object : null;
            JsonDeserializer jsonDeserializer = object instanceof JsonDeserializer ? (JsonDeserializer)object : null;
            TypeAdapterFactory typeAdapterFactory = bl ? TREE_TYPE_CLASS_DUMMY_FACTORY : TREE_TYPE_FIELD_DUMMY_FACTORY;
            TreeTypeAdapter treeTypeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, bl2);
            typeAdapter = treeTypeAdapter;
            bl2 = false;
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + object.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (typeAdapter != null && bl2) {
            typeAdapter = typeAdapter.nullSafe();
        }
        return typeAdapter;
    }

    public boolean isClassJsonAdapterFactory(TypeToken<?> typeToken, TypeAdapterFactory typeAdapterFactory) {
        Objects.requireNonNull(typeToken);
        Objects.requireNonNull(typeAdapterFactory);
        if (typeAdapterFactory == TREE_TYPE_CLASS_DUMMY_FACTORY) {
            return true;
        }
        Class<?> clazz = typeToken.getRawType();
        TypeAdapterFactory typeAdapterFactory2 = (TypeAdapterFactory)this.adapterFactoryMap.get(clazz);
        if (typeAdapterFactory2 != null) {
            return typeAdapterFactory2 == typeAdapterFactory;
        }
        JsonAdapter jsonAdapter = JsonAdapterAnnotationTypeAdapterFactory.getAnnotation(clazz);
        if (jsonAdapter == null) {
            return false;
        }
        Class<?> clazz2 = jsonAdapter.value();
        if (!TypeAdapterFactory.class.isAssignableFrom(clazz2)) {
            return false;
        }
        Object object = JsonAdapterAnnotationTypeAdapterFactory.createAdapter(this.constructorConstructor, clazz2);
        TypeAdapterFactory typeAdapterFactory3 = (TypeAdapterFactory)object;
        return this.putFactoryAndGetCurrent(clazz, typeAdapterFactory3) == typeAdapterFactory;
    }

    private static class DummyTypeAdapterFactory
    implements TypeAdapterFactory {
        private DummyTypeAdapterFactory() {
        }

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            throw new AssertionError((Object)"Factory should not be used");
        }
    }
}

