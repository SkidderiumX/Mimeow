/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

public class UUIDTypeAdapter
extends TypeAdapter<UUID> {
    @Override
    public void write(JsonWriter jsonWriter, UUID uUID) throws IOException {
        jsonWriter.value(UUIDTypeAdapter.fromUUID(uUID));
    }

    @Override
    public UUID read(JsonReader jsonReader) throws IOException {
        return UUIDTypeAdapter.fromString(jsonReader.nextString());
    }

    public static String fromUUID(UUID uUID) {
        return uUID.toString().replace("-", "");
    }

    public static UUID fromString(String string) {
        return UUID.fromString(string.replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
    }
}

