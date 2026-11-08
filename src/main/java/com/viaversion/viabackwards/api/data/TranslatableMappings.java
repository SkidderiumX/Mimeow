/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.data;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.data.BackwardsMappingDataLoader;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class TranslatableMappings {
    private static final Map<String, Map<String, String>> TRANSLATABLES = new HashMap<String, Map<String, String>>();

    public static void loadTranslatables() {
        if (!TRANSLATABLES.isEmpty()) {
            throw new IllegalStateException("Translatables already loaded!");
        }
        TranslatableMappings.fillTranslatables(BackwardsMappingDataLoader.INSTANCE.loadFromDataDir("translation-mappings.json"), TRANSLATABLES);
    }

    public static void fillTranslatables(JsonObject jsonObject, Map<String, Map<String, String>> map) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            map.put(entry.getKey(), hashMap);
            for (Map.Entry<String, JsonElement> entry2 : entry.getValue().getAsJsonObject().entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue().getAsString());
            }
        }
    }

    public static Map<String, String> translatablesFor(Protocol<?, ?, ?, ?> protocol) {
        String string = protocol.getClass().getSimpleName().replace("Protocol", "").split("To")[0].replace("_", ".");
        return TranslatableMappings.translatablesFor(string);
    }

    public static Map<String, String> translatablesFor(String string) {
        Map<String, String> map = TranslatableMappings.getTranslatableMappings(string);
        if (map == null) {
            ViaBackwards.getPlatform().getLogger().warning("Missing " + string + " translatables!");
            return new HashMap<String, String>();
        }
        return map;
    }

    public static @Nullable Map<String, String> getTranslatableMappings(String string) {
        return TRANSLATABLES.get(string);
    }
}

