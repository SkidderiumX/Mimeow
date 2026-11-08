/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class JsonUtils {
    public static boolean getBoolean(JsonElement jsonElement, String string) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
            return jsonElement.getAsBoolean();
        }
        throw new JsonSyntaxException("Expected " + string + " to be a boolean, was " + jsonElement);
    }

    public static boolean getBoolean(JsonObject jsonObject, String string) {
        if (jsonObject.has(string)) {
            return JsonUtils.getBoolean(jsonObject.get(string), string);
        }
        throw new JsonSyntaxException("Missing " + string + ", expected to find a boolean");
    }

    public static boolean getBoolean(JsonObject jsonObject, String string, boolean bl) {
        if (jsonObject.has(string)) {
            return JsonUtils.getBoolean(jsonObject, string);
        }
        return bl;
    }

    public static int getInt(JsonElement jsonElement, String string) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            return jsonElement.getAsInt();
        }
        throw new JsonSyntaxException("Expected " + string + " to be a boolean, was " + jsonElement);
    }

    public static int getInt(JsonObject jsonObject, String string) {
        if (jsonObject.has(string)) {
            return JsonUtils.getInt(jsonObject.get(string), string);
        }
        throw new JsonSyntaxException("Missing " + string + ", expected to find a boolean");
    }

    public static int getInt(JsonObject jsonObject, String string, int n) {
        if (jsonObject.has(string)) {
            return JsonUtils.getInt(jsonObject, string);
        }
        return n;
    }

    public static String getString(JsonElement jsonElement, String string) {
        if (jsonElement.isJsonPrimitive()) {
            return jsonElement.getAsString();
        }
        throw new JsonSyntaxException("Expected " + string + " to be a string, was " + jsonElement);
    }

    public static String getString(JsonObject jsonObject, String string) {
        if (jsonObject.has(string)) {
            return JsonUtils.getString(jsonObject.get(string), string);
        }
        throw new JsonSyntaxException("Missing " + string + ", expected to find a string");
    }

    public static String getString(JsonObject jsonObject, String string, String string2) {
        if (jsonObject.has(string)) {
            return JsonUtils.getString(jsonObject, string);
        }
        return string2;
    }

    public static JsonObject getJsonObject(JsonElement jsonElement, String string) {
        if (jsonElement.isJsonObject()) {
            return jsonElement.getAsJsonObject();
        }
        throw new JsonSyntaxException("Expected " + string + " to be a JsonObject, was " + jsonElement);
    }

    public static JsonObject getJsonObject(JsonObject jsonObject, String string) {
        if (jsonObject.has(string)) {
            return JsonUtils.getJsonObject(jsonObject.get(string), string);
        }
        throw new JsonSyntaxException("Missing " + string + ", expected to find a JsonObject");
    }

    public static String toSortedString(@Nullable JsonElement jsonElement, @Nullable Comparator<String> comparator) {
        if (jsonElement == null) {
            return null;
        }
        if (comparator != null) {
            return JsonUtils.sort(jsonElement, comparator).toString();
        }
        return JsonUtils.sort(jsonElement, Comparator.naturalOrder()).toString();
    }

    public static JsonElement sort(@Nullable JsonElement jsonElement, @Nonnull Comparator<String> comparator) {
        if (jsonElement == null) {
            return null;
        }
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); ++i) {
                jsonArray.set(i, JsonUtils.sort(jsonArray.get(i), comparator));
            }
            return jsonArray;
        }
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonObject jsonObject2 = new JsonObject();
            ArrayList<String> arrayList = new ArrayList<String>(jsonObject.keySet());
            arrayList.sort(comparator);
            for (String string : arrayList) {
                jsonObject2.add(string, JsonUtils.sort(jsonObject.get(string), comparator));
            }
            return jsonObject2;
        }
        return jsonElement;
    }
}

