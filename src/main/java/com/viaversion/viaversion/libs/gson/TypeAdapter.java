/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonIOException;
import com.viaversion.viaversion.libs.gson.internal.Streams;
import com.viaversion.viaversion.libs.gson.internal.bind.JsonTreeReader;
import com.viaversion.viaversion.libs.gson.internal.bind.JsonTreeWriter;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.JsonToken;
import com.viaversion.viaversion.libs.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

public abstract class TypeAdapter<T> {
    public abstract void write(JsonWriter var1, T var2) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        JsonWriter jsonWriter = new JsonWriter(writer);
        this.write(jsonWriter, t);
    }

    public final String toJson(T t) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            this.toJson(Streams.writerForAppendable(stringBuilder), t);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        return stringBuilder.toString();
    }

    public final JsonElement toJsonTree(T t) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            this.write(jsonTreeWriter, t);
            return jsonTreeWriter.get();
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public abstract T read(JsonReader var1) throws IOException;

    public final T fromJson(Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        return this.read(jsonReader);
    }

    public final T fromJson(String string) throws IOException {
        return this.fromJson(new StringReader(string));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            JsonTreeReader jsonTreeReader = new JsonTreeReader(jsonElement);
            return this.read(jsonTreeReader);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        if (!(this instanceof NullSafeTypeAdapter)) {
            return new NullSafeTypeAdapter();
        }
        return this;
    }

    private final class NullSafeTypeAdapter
    extends TypeAdapter<T> {
        private NullSafeTypeAdapter() {
        }

        @Override
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter.this.write(jsonWriter, t);
            }
        }

        @Override
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return TypeAdapter.this.read(jsonReader);
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + TypeAdapter.this + "]";
        }
    }
}

