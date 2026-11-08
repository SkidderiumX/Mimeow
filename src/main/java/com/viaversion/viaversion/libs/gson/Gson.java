/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.FieldNamingStrategy;
import com.viaversion.viaversion.libs.gson.FormattingStyle;
import com.viaversion.viaversion.libs.gson.GsonBuilder;
import com.viaversion.viaversion.libs.gson.InstanceCreator;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonIOException;
import com.viaversion.viaversion.libs.gson.JsonNull;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.libs.gson.LongSerializationPolicy;
import com.viaversion.viaversion.libs.gson.ReflectionAccessFilter;
import com.viaversion.viaversion.libs.gson.Strictness;
import com.viaversion.viaversion.libs.gson.ToNumberStrategy;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.TypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.ConstructorConstructor;
import com.viaversion.viaversion.libs.gson.internal.Excluder;
import com.viaversion.viaversion.libs.gson.internal.Primitives;
import com.viaversion.viaversion.libs.gson.internal.Streams;
import com.viaversion.viaversion.libs.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.bind.JsonTreeReader;
import com.viaversion.viaversion.libs.gson.internal.bind.JsonTreeWriter;
import com.viaversion.viaversion.libs.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.JsonToken;
import com.viaversion.viaversion.libs.gson.stream.JsonWriter;
import com.viaversion.viaversion.libs.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Gson {
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults = new ThreadLocal();
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache = new ConcurrentHashMap();
    private final ConstructorConstructor constructorConstructor;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final List<TypeAdapterFactory> factories;
    final Excluder excluder;
    final FieldNamingStrategy fieldNamingStrategy;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    final boolean serializeNulls;
    final boolean complexMapKeySerialization;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final FormattingStyle formattingStyle;
    final Strictness strictness;
    final boolean serializeSpecialFloatingPointValues;
    final boolean useJdkUnsafe;
    final String datePattern;
    final int dateStyle;
    final int timeStyle;
    final LongSerializationPolicy longSerializationPolicy;
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    final ToNumberStrategy objectToNumberStrategy;
    final ToNumberStrategy numberToNumberStrategy;
    final List<ReflectionAccessFilter> reflectionFilters;

    public Gson() {
        this(GsonBuilder.DEFAULT);
    }

    Gson(GsonBuilder gsonBuilder) {
        this.excluder = gsonBuilder.excluder;
        this.fieldNamingStrategy = gsonBuilder.fieldNamingPolicy;
        this.instanceCreators = new HashMap(gsonBuilder.instanceCreators);
        this.serializeNulls = gsonBuilder.serializeNulls;
        this.complexMapKeySerialization = gsonBuilder.complexMapKeySerialization;
        this.generateNonExecutableJson = gsonBuilder.generateNonExecutableJson;
        this.htmlSafe = gsonBuilder.escapeHtmlChars;
        this.formattingStyle = gsonBuilder.formattingStyle;
        this.strictness = gsonBuilder.strictness;
        this.serializeSpecialFloatingPointValues = gsonBuilder.serializeSpecialFloatingPointValues;
        this.useJdkUnsafe = gsonBuilder.useJdkUnsafe;
        this.longSerializationPolicy = gsonBuilder.longSerializationPolicy;
        this.datePattern = gsonBuilder.datePattern;
        this.dateStyle = gsonBuilder.dateStyle;
        this.timeStyle = gsonBuilder.timeStyle;
        this.builderFactories = GsonBuilder.newImmutableList(gsonBuilder.factories);
        this.builderHierarchyFactories = GsonBuilder.newImmutableList(gsonBuilder.hierarchyFactories);
        this.objectToNumberStrategy = gsonBuilder.objectToNumberStrategy;
        this.numberToNumberStrategy = gsonBuilder.numberToNumberStrategy;
        this.reflectionFilters = GsonBuilder.newImmutableList(gsonBuilder.reflectionFilters);
        if (gsonBuilder == GsonBuilder.DEFAULT) {
            this.constructorConstructor = GsonBuilder.DEFAULT_CONSTRUCTOR_CONSTRUCTOR;
            this.jsonAdapterFactory = GsonBuilder.DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY;
            this.factories = GsonBuilder.DEFAULT_TYPE_ADAPTER_FACTORIES;
        } else {
            this.constructorConstructor = new ConstructorConstructor(this.instanceCreators, this.useJdkUnsafe, this.reflectionFilters);
            this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
            this.factories = gsonBuilder.createFactories(this.constructorConstructor, this.jsonAdapterFactory);
        }
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        TypeAdapter<Object> typeAdapter;
        Objects.requireNonNull(typeToken, "type must not be null");
        TypeAdapter typeAdapter2 = (TypeAdapter)this.typeTokenCache.get(typeToken);
        if (typeAdapter2 != null) {
            TypeAdapter typeAdapter3 = typeAdapter2;
            return typeAdapter3;
        }
        Map<TypeToken<?>, TypeAdapter<?>> map = this.threadLocalAdapterResults.get();
        boolean bl = false;
        if (map == null) {
            map = new HashMap();
            this.threadLocalAdapterResults.set(map);
            bl = true;
        } else {
            typeAdapter = map.get(typeToken);
            if (typeAdapter != null) {
                return typeAdapter;
            }
        }
        typeAdapter = null;
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            for (TypeAdapterFactory typeAdapterFactory : this.factories) {
                typeAdapter = typeAdapterFactory.create(this, typeToken);
                if (typeAdapter == null) continue;
                futureTypeAdapter.setDelegate(typeAdapter);
                map.put(typeToken, typeAdapter);
                break;
            }
        }
        finally {
            if (bl) {
                this.threadLocalAdapterResults.remove();
            }
        }
        if (typeAdapter == null) {
            throw new IllegalArgumentException("GSON (2.14.0) cannot handle " + typeToken);
        }
        if (bl) {
            this.typeTokenCache.putAll(map);
        }
        return typeAdapter;
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> clazz) {
        return this.getAdapter(TypeToken.get(clazz));
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        Objects.requireNonNull(typeAdapterFactory, "skipPast must not be null");
        Objects.requireNonNull(typeToken, "type must not be null");
        if (this.jsonAdapterFactory.isClassJsonAdapterFactory(typeToken, typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean bl = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (!bl) {
                if (typeAdapterFactory2 != typeAdapterFactory) continue;
                bl = true;
                continue;
            }
            TypeAdapter<T> typeAdapter = typeAdapterFactory2.create(this, typeToken);
            if (typeAdapter == null) continue;
            return typeAdapter;
        }
        if (bl) {
            throw new IllegalArgumentException("GSON cannot serialize or deserialize " + typeToken);
        }
        return this.getAdapter(typeToken);
    }

    public JsonElement toJsonTree(Object object) {
        if (object == null) {
            return JsonNull.INSTANCE;
        }
        return this.toJsonTree(object, object.getClass());
    }

    public JsonElement toJsonTree(Object object, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        this.toJson(object, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toJson(Object object) {
        if (object == null) {
            return this.toJson(JsonNull.INSTANCE);
        }
        return this.toJson(object, object.getClass());
    }

    public String toJson(Object object, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        this.toJson(object, type, stringBuilder);
        return stringBuilder.toString();
    }

    public void toJson(Object object, Appendable appendable) throws JsonIOException {
        if (object != null) {
            this.toJson(object, object.getClass(), appendable);
        } else {
            this.toJson((JsonElement)JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object object, Type type, Appendable appendable) throws JsonIOException {
        try {
            JsonWriter jsonWriter = this.newJsonWriter(Streams.writerForAppendable(appendable));
            this.toJson(object, type, jsonWriter);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public void toJson(Object object, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter<?> typeAdapter = this.getAdapter(TypeToken.get(type));
        Strictness strictness = jsonWriter.getStrictness();
        if (this.strictness != null) {
            jsonWriter.setStrictness(this.strictness);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        boolean bl = jsonWriter.isHtmlSafe();
        boolean bl2 = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            typeAdapter.write(jsonWriter, object);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        catch (AssertionError assertionError) {
            throw new AssertionError("AssertionError (GSON 2.14.0): " + ((Throwable)((Object)assertionError)).getMessage(), (Throwable)((Object)assertionError));
        }
        finally {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(bl);
            jsonWriter.setSerializeNulls(bl2);
        }
    }

    public String toJson(JsonElement jsonElement) {
        StringBuilder stringBuilder = new StringBuilder();
        this.toJson(jsonElement, (Appendable)stringBuilder);
        return stringBuilder.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            JsonWriter jsonWriter = this.newJsonWriter(Streams.writerForAppendable(appendable));
            this.toJson(jsonElement, jsonWriter);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        Strictness strictness = jsonWriter.getStrictness();
        boolean bl = jsonWriter.isHtmlSafe();
        boolean bl2 = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        if (this.strictness != null) {
            jsonWriter.setStrictness(this.strictness);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        try {
            Streams.write(jsonElement, jsonWriter);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        catch (AssertionError assertionError) {
            throw new AssertionError("AssertionError (GSON 2.14.0): " + ((Throwable)((Object)assertionError)).getMessage(), (Throwable)((Object)assertionError));
        }
        finally {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(bl);
            jsonWriter.setSerializeNulls(bl2);
        }
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.setFormattingStyle(this.formattingStyle);
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setStrictness(this.strictness == null ? Strictness.LEGACY_STRICT : this.strictness);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setStrictness(this.strictness == null ? Strictness.LEGACY_STRICT : this.strictness);
        return jsonReader;
    }

    public <T> T fromJson(String string, Class<T> clazz) throws JsonSyntaxException {
        return this.fromJson(string, TypeToken.get(clazz));
    }

    public <T> T fromJson(String string, Type type) throws JsonSyntaxException {
        return (T)this.fromJson(string, TypeToken.get(type));
    }

    public <T> T fromJson(String string, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (string == null) {
            return null;
        }
        StringReader stringReader = new StringReader(string);
        return this.fromJson((Reader)stringReader, typeToken);
    }

    public <T> T fromJson(Reader reader, Class<T> clazz) throws JsonSyntaxException, JsonIOException {
        return this.fromJson(reader, TypeToken.get(clazz));
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        return (T)this.fromJson(reader, TypeToken.get(type));
    }

    public <T> T fromJson(Reader reader, TypeToken<T> typeToken) throws JsonIOException, JsonSyntaxException {
        JsonReader jsonReader = this.newJsonReader(reader);
        T t = this.fromJson(jsonReader, typeToken);
        Gson.assertFullConsumption(t, jsonReader);
        return t;
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        return (T)this.fromJson(jsonReader, TypeToken.get(type));
    }

    public <T> T fromJson(JsonReader jsonReader, TypeToken<T> typeToken) throws JsonIOException, JsonSyntaxException {
        boolean bl = true;
        Strictness strictness = jsonReader.getStrictness();
        if (this.strictness != null) {
            jsonReader.setStrictness(this.strictness);
        } else if (jsonReader.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonReader.setStrictness(Strictness.LENIENT);
        }
        try {
            JsonToken jsonToken = jsonReader.peek();
            bl = false;
            TypeAdapter<T> typeAdapter = this.getAdapter(typeToken);
            T t = typeAdapter.read(jsonReader);
            Class<T> clazz = Primitives.wrap(typeToken.getRawType());
            if (t != null && !clazz.isInstance(t)) {
                throw new ClassCastException("Type adapter '" + typeAdapter + "' returned wrong type; requested " + typeToken.getRawType() + " but got instance of " + t.getClass() + "\nVerify that the adapter was registered for the correct type.");
            }
            T t2 = t;
            return t2;
        }
        catch (EOFException eOFException) {
            if (bl) {
                T t = null;
                return t;
            }
            throw new JsonSyntaxException(eOFException);
        }
        catch (IllegalStateException illegalStateException) {
            throw new JsonSyntaxException(illegalStateException);
        }
        catch (IOException iOException) {
            throw new JsonSyntaxException(iOException);
        }
        catch (AssertionError assertionError) {
            throw new AssertionError("AssertionError (GSON 2.14.0): " + ((Throwable)((Object)assertionError)).getMessage(), (Throwable)((Object)assertionError));
        }
        finally {
            jsonReader.setStrictness(strictness);
        }
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> clazz) throws JsonSyntaxException {
        return this.fromJson(jsonElement, TypeToken.get(clazz));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        return (T)this.fromJson(jsonElement, TypeToken.get(type));
    }

    public <T> T fromJson(JsonElement jsonElement, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return this.fromJson((JsonReader)new JsonTreeReader(jsonElement), typeToken);
    }

    private static void assertFullConsumption(Object object, JsonReader jsonReader) {
        try {
            if (object != null && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("JSON document was not fully consumed.");
            }
        }
        catch (MalformedJsonException malformedJsonException) {
            throw new JsonSyntaxException(malformedJsonException);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public static class FutureTypeAdapter<T>
    extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate = null;

        FutureTypeAdapter() {
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError((Object)"Delegate is already set");
            }
            this.delegate = typeAdapter;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
            }
            return typeAdapter;
        }

        @Override
        public TypeAdapter<T> getSerializationDelegate() {
            return this.delegate();
        }

        @Override
        public T read(JsonReader jsonReader) throws IOException {
            return this.delegate().read(jsonReader);
        }

        @Override
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            this.delegate().write(jsonWriter, t);
        }
    }
}

