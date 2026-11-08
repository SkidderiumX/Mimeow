/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatNewlineRewriter {
    private static final String[] STYLE_KEYS = new String[]{"color", "bold", "italic", "underlined", "strikethrough", "obfuscated", "clickEvent", "hoverEvent", "insertion"};

    public static List<JsonObject> splitChatComponentByNewline(JsonElement jsonElement) {
        return ChatNewlineRewriter.splitChatComponentByNewline(jsonElement, new JsonObject());
    }

    private static List<JsonObject> splitChatComponentByNewline(JsonElement jsonElement, JsonObject jsonObject) {
        Object object;
        Object object222;
        ArrayList<JsonObject> arrayList = new ArrayList<JsonObject>();
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return arrayList;
        }
        if (jsonElement.isJsonPrimitive()) {
            String string = jsonElement.getAsString();
            for (String string2 : string.split("\n", -1)) {
                JsonObject jsonObject2 = jsonObject.deepCopy();
                jsonObject2.addProperty("text", string2);
                arrayList.add(jsonObject2);
            }
            return arrayList;
        }
        if (jsonElement.isJsonArray()) {
            ArrayList<JsonObject> arrayList2 = new ArrayList<JsonObject>();
            JsonObject jsonObject3 = jsonObject;
            boolean bl = false;
            for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                List<JsonObject> list = ChatNewlineRewriter.splitChatComponentByNewline(jsonElement2, jsonObject3);
                for (int i = 0; i < list.size(); ++i) {
                    arrayList2.add(list.get(i));
                    if (i >= list.size() - 1) continue;
                    arrayList.add(ChatNewlineRewriter.mergeLine(arrayList2));
                    arrayList2.clear();
                }
                if (bl || jsonElement2 == null || jsonElement2.isJsonNull()) continue;
                jsonObject3 = ChatNewlineRewriter.rootStyle(jsonObject, jsonElement2);
                bl = true;
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(ChatNewlineRewriter.mergeLine(arrayList2));
            }
            return arrayList;
        }
        if (!jsonElement.isJsonObject()) {
            return arrayList;
        }
        JsonObject jsonObject4 = jsonElement.getAsJsonObject();
        JsonObject jsonObject5 = ChatNewlineRewriter.mergeStyle(jsonObject, jsonObject4);
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        if (jsonObject4.has("text")) {
            arrayList3.add(jsonObject4.get("text"));
        }
        if (jsonObject4.has("extra") && jsonObject4.get("extra").isJsonArray()) {
            for (Object object222 : jsonObject4.getAsJsonArray("extra")) {
                arrayList3.add(object222);
            }
        }
        if (arrayList3.isEmpty()) {
            object = ChatNewlineRewriter.copyComponentWithoutExtra(jsonObject4, jsonObject5);
            arrayList.add((JsonObject)(object != null ? object : jsonObject5));
            return arrayList;
        }
        object = new ArrayList();
        if (!jsonObject4.has("text") && (object222 = ChatNewlineRewriter.copyComponentWithoutExtra(jsonObject4, jsonObject5)) != null) {
            object.add((Object)object222);
        }
        for (JsonElement jsonElement3 : arrayList3) {
            Object object3;
            if (jsonElement3 == null || jsonElement3.isJsonNull()) continue;
            if (jsonElement3.isJsonPrimitive()) {
                object3 = jsonElement3.getAsString();
                String[] stringArray = ((String)object3).split("\n", -1);
                for (int i = 0; i < stringArray.length; ++i) {
                    JsonObject jsonObject6 = jsonObject5.deepCopy();
                    jsonObject6.addProperty("text", stringArray[i]);
                    object.add((JsonObject)jsonObject6);
                    if (i >= stringArray.length - 1) continue;
                    arrayList.add(ChatNewlineRewriter.mergeLine(object));
                    object.clear();
                }
                continue;
            }
            if (!jsonElement3.isJsonObject() && !jsonElement3.isJsonArray()) continue;
            object3 = ChatNewlineRewriter.splitChatComponentByNewline(jsonElement3, jsonObject5);
            for (int i = 0; i < object3.size(); ++i) {
                object.add((JsonObject)((JsonObject)object3.get(i)));
                if (i >= object3.size() - 1) continue;
                arrayList.add(ChatNewlineRewriter.mergeLine(object));
                object.clear();
            }
        }
        if (!object.isEmpty()) {
            arrayList.add(ChatNewlineRewriter.mergeLine(object));
        }
        return arrayList;
    }

    private static JsonObject rootStyle(JsonObject jsonObject, JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return jsonObject;
        }
        if (jsonElement.isJsonObject()) {
            return ChatNewlineRewriter.mergeStyle(jsonObject, jsonElement.getAsJsonObject());
        }
        if (jsonElement.isJsonArray()) {
            for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                if (jsonElement2 == null || jsonElement2.isJsonNull()) continue;
                return ChatNewlineRewriter.rootStyle(jsonObject, jsonElement2);
            }
        }
        return jsonObject;
    }

    private static JsonObject mergeStyle(JsonObject jsonObject, JsonObject jsonObject2) {
        JsonObject jsonObject3 = jsonObject.deepCopy();
        for (String string : STYLE_KEYS) {
            if (!jsonObject2.has(string)) continue;
            jsonObject3.add(string, jsonObject2.get(string).deepCopy());
        }
        return jsonObject3;
    }

    private static JsonObject copyComponentWithoutExtra(JsonObject jsonObject, JsonObject jsonObject2) {
        JsonObject jsonObject3 = jsonObject2.deepCopy();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String string = entry.getKey();
            if ("extra".equals(string) || ChatNewlineRewriter.isStyleKey(string)) continue;
            jsonObject3.add(string, entry.getValue().deepCopy());
        }
        return jsonObject3.size() == jsonObject2.size() ? null : jsonObject3;
    }

    private static boolean isStyleKey(String string) {
        for (String string2 : STYLE_KEYS) {
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    private static JsonObject mergeLine(List<JsonObject> list) {
        if (list.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("text", "");
            return jsonObject;
        }
        JsonObject jsonObject = list.get(0);
        if (list.size() == 1) {
            return jsonObject;
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("text", "");
        JsonArray jsonArray = new JsonArray();
        for (JsonObject jsonObject3 : list) {
            jsonArray.add(jsonObject3);
        }
        jsonObject2.add("extra", jsonArray);
        return jsonObject2;
    }
}

