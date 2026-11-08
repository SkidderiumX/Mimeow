/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashSet;
import java.util.Set;

public class Ops {
    public Set<String> ops = new HashSet<String>();

    public static Ops parse(String string) {
        Ops ops = new Ops();
        JsonParser jsonParser = new JsonParser();
        try {
            JsonElement jsonElement = jsonParser.parse(string);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = jsonObject.get("ops");
            if (jsonElement2.isJsonArray()) {
                for (JsonElement jsonElement3 : jsonElement2.getAsJsonArray()) {
                    ops.ops.add(jsonElement3.getAsString());
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return ops;
    }
}

