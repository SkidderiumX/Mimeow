/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import java.lang.reflect.Type;

public class TextDeserializer_v1_7
implements JsonDeserializer<TextComponent> {
    @Override
    public TextComponent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonPrimitive()) {
            return new StringComponent(jsonElement.getAsString());
        }
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            TextComponent textComponent = null;
            for (JsonElement jsonElement2 : jsonArray) {
                TextComponent textComponent2 = this.deserialize(jsonElement2, jsonElement2.getClass(), jsonDeserializationContext);
                if (textComponent == null) {
                    textComponent = textComponent2;
                    continue;
                }
                textComponent.append(textComponent2);
            }
            return textComponent;
        }
        if (jsonElement.isJsonObject()) {
            Object[] objectArray;
            Object object;
            Object object2;
            TextComponent textComponent;
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("text")) {
                textComponent = new StringComponent(jsonObject.get("text").getAsString());
            } else if (jsonObject.has("translate")) {
                object2 = jsonObject.get("translate").getAsString();
                if (jsonObject.has("with")) {
                    object = jsonObject.getAsJsonArray("with");
                    objectArray = new Object[((JsonArray)object).size()];
                    for (int i = 0; i < ((JsonArray)object).size(); ++i) {
                        StringComponent stringComponent;
                        TextComponent textComponent3 = this.deserialize(((JsonArray)object).get(i), type, jsonDeserializationContext);
                        objectArray[i] = textComponent3;
                        if (!(textComponent3 instanceof StringComponent) || !(stringComponent = (StringComponent)textComponent3).getStyle().isEmpty() || !stringComponent.getSiblings().isEmpty()) continue;
                        objectArray[i] = stringComponent.getText();
                    }
                    textComponent = new TranslationComponent((String)object2, objectArray);
                } else {
                    textComponent = new TranslationComponent((String)object2, new Object[0]);
                }
            } else {
                throw new JsonParseException("Don't know how to turn " + jsonElement + " into a Component");
            }
            if (jsonObject.has("extra")) {
                object2 = jsonObject.getAsJsonArray("extra");
                if (((JsonArray)object2).isEmpty()) {
                    throw new JsonParseException("Unexpected empty array of components");
                }
                object = ((JsonArray)object2).iterator();
                while (object.hasNext()) {
                    objectArray = (JsonElement)object.next();
                    textComponent.append(this.deserialize((JsonElement)objectArray, type, jsonDeserializationContext));
                }
            }
            if ((object2 = (Style)jsonDeserializationContext.deserialize(jsonObject, (Type)((Object)Style.class))) != null) {
                textComponent.setStyle((Style)object2);
            }
            return textComponent;
        }
        throw new JsonParseException("Don't know how to turn " + jsonElement + " into a Component");
    }
}

