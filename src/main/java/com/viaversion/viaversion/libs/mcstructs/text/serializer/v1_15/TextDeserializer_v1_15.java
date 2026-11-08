/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_15;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.NbtComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ScoreComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.SelectorComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.BlockNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.EntityNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.StorageNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.utils.JsonUtils;
import java.lang.reflect.Type;
import java.util.Iterator;

public class TextDeserializer_v1_15
implements JsonDeserializer<TextComponent> {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public TextComponent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Object[] objectArray;
        Object object;
        TextComponent textComponent;
        if (jsonElement.isJsonPrimitive()) {
            return new StringComponent(jsonElement.getAsString());
        }
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            TextComponent textComponent2 = null;
            for (JsonElement jsonElement2 : jsonArray) {
                TextComponent textComponent3 = this.deserialize(jsonElement2, jsonElement2.getClass(), jsonDeserializationContext);
                if (textComponent2 == null) {
                    textComponent2 = textComponent3;
                    continue;
                }
                textComponent2.append(textComponent3);
            }
            return textComponent2;
        }
        if (!jsonElement.isJsonObject()) throw new JsonParseException("Don't know how to turn " + jsonElement + " into a Component");
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.has("text")) {
            textComponent = new StringComponent(JsonUtils.getString(jsonObject, "text"));
        } else if (jsonObject.has("translate")) {
            object = JsonUtils.getString(jsonObject, "translate");
            if (jsonObject.has("with")) {
                JsonArray jsonArray = jsonObject.getAsJsonArray("with");
                objectArray = new Object[jsonArray.size()];
                for (int i = 0; i < jsonArray.size(); ++i) {
                    StringComponent stringComponent;
                    TextComponent textComponent4 = this.deserialize(jsonArray.get(i), type, jsonDeserializationContext);
                    objectArray[i] = textComponent4;
                    if (!(textComponent4 instanceof StringComponent) || !(stringComponent = (StringComponent)textComponent4).getStyle().isEmpty() || !stringComponent.getSiblings().isEmpty()) continue;
                    objectArray[i] = stringComponent.getText();
                }
                textComponent = new TranslationComponent((String)object, objectArray);
            } else {
                textComponent = new TranslationComponent((String)object, new Object[0]);
            }
        } else if (jsonObject.has("score")) {
            object = jsonObject.getAsJsonObject("score");
            if (!((JsonObject)object).has("name") || !((JsonObject)object).has("objective")) {
                throw new JsonParseException("A score component needs at least a name and an objective");
            }
            textComponent = new ScoreComponent(JsonUtils.getString((JsonObject)object, "name"), JsonUtils.getString((JsonObject)object, "objective"));
            if (((JsonObject)object).has("value")) {
                ((ScoreComponent)textComponent).setValue(JsonUtils.getString((JsonObject)object, "value"));
            }
        } else if (jsonObject.has("selector")) {
            textComponent = new SelectorComponent(JsonUtils.getString(jsonObject, "selector"), null);
        } else if (jsonObject.has("keybind")) {
            textComponent = new KeybindComponent(JsonUtils.getString(jsonObject, "keybind"));
        } else {
            if (!jsonObject.has("nbt")) throw new JsonParseException("Don't know how to turn " + jsonElement + " into a Component");
            object = JsonUtils.getString(jsonObject, "nbt");
            boolean bl = JsonUtils.getBoolean(jsonObject, "interpret", false);
            if (jsonObject.has("block")) {
                textComponent = new NbtComponent((String)object, bl, null, (NbtDataSource)new BlockNbtSource(JsonUtils.getString(jsonObject, "block")));
            } else if (jsonObject.has("entity")) {
                textComponent = new NbtComponent((String)object, bl, null, (NbtDataSource)new EntityNbtSource(JsonUtils.getString(jsonObject, "entity")));
            } else {
                if (!jsonObject.has("storage")) throw new JsonParseException("Don't know how to turn " + jsonElement + " into a Component");
                textComponent = new NbtComponent((String)object, bl, null, (NbtDataSource)new StorageNbtSource(Identifier.of(JsonUtils.getString(jsonObject, "storage"))));
            }
        }
        if (jsonObject.has("extra")) {
            object = jsonObject.getAsJsonArray("extra");
            if (((JsonArray)object).isEmpty()) {
                throw new JsonParseException("Unexpected empty array of components");
            }
            Iterator<JsonElement> iterator2 = ((JsonArray)object).iterator();
            while (iterator2.hasNext()) {
                objectArray = iterator2.next();
                textComponent.append(this.deserialize((JsonElement)objectArray, type, jsonDeserializationContext));
            }
        }
        if ((object = (Style)jsonDeserializationContext.deserialize(jsonObject, (Type)((Object)Style.class))) == null) return textComponent;
        textComponent.setStyle((Style)object);
        return textComponent;
    }
}

