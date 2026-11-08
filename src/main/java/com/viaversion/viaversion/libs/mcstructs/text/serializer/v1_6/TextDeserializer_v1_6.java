/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_6;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public class TextDeserializer_v1_6
implements JsonDeserializer<TextComponent> {
    @Override
    public TextComponent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Object object;
        TextComponent textComponent = null;
        Style style = new Style();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = jsonObject.get("text");
        JsonElement jsonElement3 = jsonObject.get("translate");
        JsonElement jsonElement4 = jsonObject.get("color");
        JsonElement jsonElement5 = jsonObject.get("bold");
        JsonElement jsonElement6 = jsonObject.get("italic");
        JsonElement jsonElement7 = jsonObject.get("underlined");
        JsonElement jsonElement8 = jsonObject.get("obfuscated");
        if (jsonElement4 != null && jsonElement4.isJsonPrimitive()) {
            object = TextFormatting.getByName(jsonElement4.getAsString());
            if (object == null) {
                throw new JsonParseException("Given color (" + jsonElement4.getAsString() + ") is not a valid selection");
            }
            style.setFormatting((TextFormatting)object);
        }
        if (jsonElement5 != null && jsonElement5.isJsonPrimitive()) {
            style.setBold(Boolean.valueOf(jsonElement5.getAsString()));
        }
        if (jsonElement6 != null && jsonElement6.isJsonPrimitive()) {
            style.setItalic(Boolean.valueOf(jsonElement6.getAsString()));
        }
        if (jsonElement7 != null && jsonElement7.isJsonPrimitive()) {
            style.setUnderlined(Boolean.valueOf(jsonElement7.getAsString()));
        }
        if (jsonElement8 != null && jsonElement8.isJsonPrimitive()) {
            style.setObfuscated(Boolean.valueOf(jsonElement8.getAsString()));
        }
        if (jsonElement2 != null) {
            if (jsonElement2.isJsonArray()) {
                object = jsonElement2.getAsJsonArray();
                Iterator<JsonElement> iterator2 = ((JsonArray)object).iterator();
                while (iterator2.hasNext()) {
                    JsonElement jsonElement9 = iterator2.next();
                    if (jsonElement9.isJsonPrimitive()) {
                        if (textComponent == null) {
                            textComponent = new StringComponent(jsonElement9.getAsString());
                            continue;
                        }
                        textComponent.append(jsonElement9.getAsString());
                        continue;
                    }
                    if (!jsonElement9.isJsonObject()) continue;
                    if (textComponent == null) {
                        textComponent = this.deserialize(jsonElement9, type, jsonDeserializationContext);
                        continue;
                    }
                    textComponent.append(this.deserialize(jsonElement9, type, jsonDeserializationContext));
                }
            } else if (jsonElement2.isJsonPrimitive()) {
                textComponent = new StringComponent(jsonElement2.getAsString());
            }
        } else if (jsonElement3 != null && jsonElement3.isJsonPrimitive()) {
            object = jsonObject.get("using");
            if (object != null) {
                if (((JsonElement)object).isJsonArray()) {
                    JsonArray jsonArray = ((JsonElement)object).getAsJsonArray();
                    ArrayList<Object> arrayList = new ArrayList<Object>();
                    for (JsonElement jsonElement10 : jsonArray) {
                        if (jsonElement10.isJsonPrimitive()) {
                            arrayList.add(jsonElement10.getAsString());
                            continue;
                        }
                        arrayList.add(this.deserialize(jsonElement10, type, jsonDeserializationContext));
                    }
                    textComponent = new TranslationComponent(jsonElement3.getAsString(), arrayList);
                } else if (((JsonElement)object).isJsonPrimitive()) {
                    textComponent = new TranslationComponent(jsonElement3.getAsString(), ((JsonElement)object).getAsString());
                }
            } else {
                textComponent = new TranslationComponent(jsonElement3.getAsString(), new Object[0]);
            }
        }
        if (textComponent != null) {
            textComponent.setStyle(style);
        }
        return textComponent;
    }
}

