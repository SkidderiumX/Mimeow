/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import java.lang.reflect.Type;

public class TextSerializer_v1_7
implements JsonSerializer<TextComponent> {
    @Override
    public JsonElement serialize(TextComponent textComponent, Type type, JsonSerializationContext jsonSerializationContext) {
        Object object;
        Object object2;
        if (textComponent instanceof StringComponent && textComponent.getStyle().isEmpty() && textComponent.getSiblings().isEmpty()) {
            return new JsonPrimitive(((StringComponent)textComponent).getText());
        }
        JsonObject jsonObject = new JsonObject();
        if (!textComponent.getStyle().isEmpty() && ((JsonElement)(object2 = jsonSerializationContext.serialize(textComponent.getStyle()))).isJsonObject()) {
            object = ((JsonElement)object2).getAsJsonObject();
            for (Object[] objectArray : ((JsonObject)object).entrySet()) {
                jsonObject.add(objectArray.getKey(), objectArray.getValue());
            }
        }
        if (!textComponent.getSiblings().isEmpty()) {
            object2 = new JsonArray();
            for (TextComponent textComponent2 : textComponent.getSiblings()) {
                ((JsonArray)object2).add(this.serialize(textComponent2, (Type)textComponent2.getClass(), jsonSerializationContext));
            }
            jsonObject.add("extra", (JsonElement)object2);
        }
        if (textComponent instanceof StringComponent) {
            jsonObject.addProperty("text", ((StringComponent)textComponent).getText());
        } else if (textComponent instanceof TranslationComponent) {
            object2 = (TranslationComponent)textComponent;
            jsonObject.addProperty("translate", ((TranslationComponent)object2).getKey());
            if (((TranslationComponent)object2).getArgs().length > 0) {
                Object[] objectArray;
                object = new JsonArray();
                for (Object object3 : objectArray = ((TranslationComponent)object2).getArgs()) {
                    if (object3 instanceof TextComponent) {
                        ((JsonArray)object).add(this.serialize((TextComponent)object3, (Type)object3.getClass(), jsonSerializationContext));
                        continue;
                    }
                    ((JsonArray)object).add(new JsonPrimitive(String.valueOf(object3)));
                }
                jsonObject.add("with", (JsonElement)object);
            }
        } else {
            throw new JsonParseException("Don't know how to serialize " + textComponent + " as a Component");
        }
        return jsonObject;
    }
}

