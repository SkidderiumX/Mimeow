/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;

public class JsonElementTypeAdapter
extends TypeAdapter<JsonElement> {
    public static final JsonElementTypeAdapter ADAPTER = new JsonElementTypeAdapter();

    private JsonElementTypeAdapter() {
    }

    private JsonElement tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        switch (jsonToken) {
            case BEGIN_ARRAY: {
                jsonReader.beginArray();
                return new JsonArray();
            }
            case BEGIN_OBJECT: {
                jsonReader.beginObject();
                return new JsonObject();
            }
        }
        return null;
    }

    private JsonElement readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        switch (jsonToken) {
            case STRING: {
                return new JsonPrimitive(jsonReader.nextString());
            }
            case NUMBER: {
                String string = jsonReader.nextString();
                return new JsonPrimitive(new LazilyParsedNumber(string));
            }
            case BOOLEAN: {
                return new JsonPrimitive(jsonReader.nextBoolean());
            }
            case NULL: {
                jsonReader.nextNull();
                return JsonNull.INSTANCE;
            }
        }
        throw new IllegalStateException("Unexpected token: " + (Object)((Object)jsonToken));
    }

    @Override
    public JsonElement read(JsonReader jsonReader) throws IOException {
        if (jsonReader instanceof JsonTreeReader) {
            return ((JsonTreeReader)jsonReader).nextJsonElement();
        }
        JsonToken jsonToken = jsonReader.peek();
        JsonElement jsonElement = this.tryBeginNesting(jsonReader, jsonToken);
        if (jsonElement == null) {
            return this.readTerminal(jsonReader, jsonToken);
        }
        ArrayDeque<JsonElement> arrayDeque = new ArrayDeque<JsonElement>();
        while (true) {
            if (jsonReader.hasNext()) {
                JsonElement jsonElement2;
                boolean bl;
                String string = null;
                if (jsonElement instanceof JsonObject) {
                    string = jsonReader.nextName();
                }
                boolean bl2 = bl = (jsonElement2 = this.tryBeginNesting(jsonReader, jsonToken = jsonReader.peek())) != null;
                if (jsonElement2 == null) {
                    jsonElement2 = this.readTerminal(jsonReader, jsonToken);
                }
                if (jsonElement instanceof JsonArray) {
                    ((JsonArray)jsonElement).add(jsonElement2);
                } else {
                    ((JsonObject)jsonElement).add(string, jsonElement2);
                }
                if (!bl) continue;
                arrayDeque.addLast(jsonElement);
                jsonElement = jsonElement2;
                continue;
            }
            if (jsonElement instanceof JsonArray) {
                jsonReader.endArray();
            } else {
                jsonReader.endObject();
            }
            if (arrayDeque.isEmpty()) {
                return jsonElement;
            }
            jsonElement = (JsonElement)arrayDeque.removeLast();
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            jsonWriter.nullValue();
        } else if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (jsonPrimitive.isNumber()) {
                jsonWriter.value(jsonPrimitive.getAsNumber());
            } else if (jsonPrimitive.isBoolean()) {
                jsonWriter.value(jsonPrimitive.getAsBoolean());
            } else {
                jsonWriter.value(jsonPrimitive.getAsString());
            }
        } else if (jsonElement.isJsonArray()) {
            jsonWriter.beginArray();
            for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                this.write(jsonWriter, jsonElement2);
            }
            jsonWriter.endArray();
        } else if (jsonElement.isJsonObject()) {
            jsonWriter.beginObject();
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                jsonWriter.name(entry.getKey());
                this.write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
        } else {
            throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
        }
    }
}

