/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_6;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import java.lang.reflect.Type;

public class TextSerializer_v1_6
implements JsonSerializer<TextComponent> {
    @Override
    public JsonElement serialize(TextComponent textComponent, Type type, JsonSerializationContext jsonSerializationContext) {
        Style style = textComponent.getStyle();
        JsonObject jsonObject = new JsonObject();
        if (style.getColor() != null && !style.getColor().isRGBColor()) {
            jsonObject.addProperty("color", style.getColor().serialize());
        }
        if (style.getBold() != null) {
            jsonObject.addProperty("bold", style.isBold());
        }
        if (style.getItalic() != null) {
            jsonObject.addProperty("italic", style.isItalic());
        }
        if (style.getUnderlined() != null) {
            jsonObject.addProperty("underlined", style.isUnderlined());
        }
        if (style.getObfuscated() != null) {
            jsonObject.addProperty("obfuscated", style.isObfuscated());
        }
        if (textComponent instanceof StringComponent) {
            StringComponent stringComponent = (StringComponent)textComponent;
            if (stringComponent.getSiblings().isEmpty()) {
                jsonObject.addProperty("text", stringComponent.getText());
            } else {
                JsonArray jsonArray = new JsonArray();
                jsonArray.add(stringComponent.getText());
                for (TextComponent textComponent2 : stringComponent.getSiblings()) {
                    if (textComponent2 instanceof StringComponent && textComponent2.getStyle().isEmpty() && textComponent2.getSiblings().isEmpty()) {
                        jsonArray.add(((StringComponent)textComponent2).getText());
                        continue;
                    }
                    jsonArray.add(this.serialize(textComponent2, type, jsonSerializationContext));
                }
                jsonObject.add("text", jsonArray);
            }
        } else if (textComponent instanceof TranslationComponent) {
            TranslationComponent translationComponent = (TranslationComponent)textComponent;
            jsonObject.addProperty("translate", translationComponent.getKey());
            Object[] objectArray = translationComponent.getArgs();
            if (objectArray != null && objectArray.length > 0) {
                if (objectArray.length == 1 && objectArray[0] instanceof String) {
                    jsonObject.addProperty("using", (String)objectArray[0]);
                } else {
                    JsonArray jsonArray = new JsonArray();
                    for (Object object : objectArray) {
                        if (object instanceof String) {
                            jsonArray.add((String)object);
                            continue;
                        }
                        if (object instanceof Boolean) {
                            jsonArray.add((Boolean)object);
                            continue;
                        }
                        if (object instanceof Character) {
                            jsonArray.add((Character)object);
                            continue;
                        }
                        if (object instanceof Number) {
                            jsonArray.add((Number)object);
                            continue;
                        }
                        if (object instanceof StringComponent) {
                            StringComponent stringComponent = (StringComponent)object;
                            if ((stringComponent.getStyle() == null || stringComponent.getStyle().isEmpty()) && stringComponent.getSiblings().isEmpty()) {
                                jsonArray.add(stringComponent.getText());
                                continue;
                            }
                            jsonArray.add(this.serialize(stringComponent, type, jsonSerializationContext));
                            continue;
                        }
                        if (object instanceof TranslationComponent) {
                            jsonArray.add(this.serialize((TranslationComponent)object, type, jsonSerializationContext));
                            continue;
                        }
                        throw new IllegalArgumentException("Minecraft 1.9 did not support translation arguments of type " + object.getClass().getName());
                    }
                    jsonObject.add("using", jsonArray);
                }
            }
        }
        return jsonObject;
    }
}

