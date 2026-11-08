/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_19_4;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.NbtComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ScoreComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.SelectorComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.BlockNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.EntityNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.StorageNbtSource;
import java.lang.reflect.Type;

public class TextSerializer_v1_19_4
implements JsonSerializer<TextComponent> {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public JsonElement serialize(TextComponent textComponent, Type type, JsonSerializationContext jsonSerializationContext) {
        Object object;
        Object object2;
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
            return jsonObject;
        } else if (textComponent instanceof TranslationComponent) {
            Object[] objectArray;
            object2 = (TranslationComponent)textComponent;
            jsonObject.addProperty("translate", ((TranslationComponent)object2).getKey());
            if (((TranslationComponent)object2).getFallback() != null) {
                jsonObject.addProperty("fallback", ((TranslationComponent)object2).getFallback());
            }
            if (((TranslationComponent)object2).getArgs().length <= 0) return jsonObject;
            object = new JsonArray();
            for (Object object3 : objectArray = ((TranslationComponent)object2).getArgs()) {
                if (object3 instanceof TextComponent) {
                    ((JsonArray)object).add(this.serialize((TextComponent)object3, (Type)object3.getClass(), jsonSerializationContext));
                    continue;
                }
                ((JsonArray)object).add(new JsonPrimitive(String.valueOf(object3)));
            }
            jsonObject.add("with", (JsonElement)object);
            return jsonObject;
        } else if (textComponent instanceof ScoreComponent) {
            object2 = (ScoreComponent)textComponent;
            object = new JsonObject();
            ((JsonObject)object).addProperty("name", ((ScoreComponent)object2).getName());
            ((JsonObject)object).addProperty("objective", ((ScoreComponent)object2).getObjective());
            jsonObject.add("score", (JsonElement)object);
            return jsonObject;
        } else if (textComponent instanceof SelectorComponent) {
            object2 = (SelectorComponent)textComponent;
            jsonObject.addProperty("selector", ((SelectorComponent)object2).getSelector());
            if (((SelectorComponent)object2).getSeparator() == null) return jsonObject;
            jsonObject.add("separator", this.serialize(((SelectorComponent)object2).getSeparator(), type, jsonSerializationContext));
            return jsonObject;
        } else if (textComponent instanceof KeybindComponent) {
            jsonObject.addProperty("keybind", ((KeybindComponent)textComponent).getKeybind());
            return jsonObject;
        } else {
            if (!(textComponent instanceof NbtComponent)) throw new JsonParseException("Don't know how to serialize " + textComponent + " as a Component");
            object2 = (NbtComponent)textComponent;
            jsonObject.addProperty("nbt", ((NbtComponent)object2).getComponent());
            jsonObject.addProperty("interpret", ((NbtComponent)object2).isResolve());
            if (((NbtComponent)object2).getSeparator() != null) {
                jsonObject.add("separator", this.serialize(((NbtComponent)object2).getSeparator(), type, jsonSerializationContext));
            }
            if (((NbtComponent)object2).getDataSource() instanceof BlockNbtSource) {
                jsonObject.addProperty("block", ((BlockNbtSource)((NbtComponent)object2).getDataSource()).getPos());
                return jsonObject;
            } else if (((NbtComponent)object2).getDataSource() instanceof EntityNbtSource) {
                jsonObject.addProperty("entity", ((EntityNbtSource)((NbtComponent)object2).getDataSource()).getSelector());
                return jsonObject;
            } else {
                if (!(((NbtComponent)object2).getDataSource() instanceof StorageNbtSource)) throw new JsonParseException("Don't know how to serialize " + textComponent + " as a Component");
                jsonObject.addProperty("storage", ((StorageNbtSource)((NbtComponent)object2).getDataSource()).getId().get());
            }
        }
        return jsonObject;
    }
}

