/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.gson;

import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.Reader;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonElement;

public class GsonParser {
    public static GsonElement parse(String string) {
        return GsonElement.wrap(JsonParser.parseString(string));
    }

    public static GsonElement parse(Reader reader) {
        return GsonElement.wrap(JsonParser.parseReader(reader));
    }

    public static GsonElement parse(JsonReader jsonReader) {
        return GsonElement.wrap(JsonParser.parseReader(jsonReader));
    }

    @Generated
    private GsonParser() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

