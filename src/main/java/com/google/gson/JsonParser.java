/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.errorprone.annotations.InlineMe;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Strictness;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static JsonElement parseString(String string) throws JsonSyntaxException {
        return JsonParser.parseReader(new StringReader(string));
    }

    public static JsonElement parseReader(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement jsonElement = JsonParser.parseReader(jsonReader);
            if (!jsonElement.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return jsonElement;
        }
        catch (MalformedJsonException | NumberFormatException exception) {
            throw new JsonSyntaxException(exception);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public static JsonElement parseReader(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        Strictness strictness = jsonReader.getStrictness();
        if (strictness == Strictness.LEGACY_STRICT) {
            jsonReader.setStrictness(Strictness.LENIENT);
        }
        try {
            JsonElement jsonElement = Streams.parse(jsonReader);
            return jsonElement;
        }
        catch (OutOfMemoryError | StackOverflowError virtualMachineError) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", virtualMachineError);
        }
        finally {
            jsonReader.setStrictness(strictness);
        }
    }

    @Deprecated
    @InlineMe(replacement="JsonParser.parseString(json)", imports={"com.google.gson.JsonParser"})
    public JsonElement parse(String string) throws JsonSyntaxException {
        return JsonParser.parseString(string);
    }

    @Deprecated
    @InlineMe(replacement="JsonParser.parseReader(json)", imports={"com.google.gson.JsonParser"})
    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        return JsonParser.parseReader(reader);
    }

    @Deprecated
    @InlineMe(replacement="JsonParser.parseReader(json)", imports={"com.google.gson.JsonParser"})
    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        return JsonParser.parseReader(jsonReader);
    }
}

