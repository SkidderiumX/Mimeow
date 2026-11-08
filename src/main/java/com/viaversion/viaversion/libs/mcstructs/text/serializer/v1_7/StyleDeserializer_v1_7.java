/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7;

import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7.EventSerializers_v1_7;
import java.lang.reflect.Type;

public class StyleDeserializer_v1_7
extends EventSerializers_v1_7
implements JsonDeserializer<Style> {
    public StyleDeserializer_v1_7(SNbt<?> sNbt) {
        super(sNbt);
    }

    @Override
    public Style deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonObject()) {
            Object object;
            Object object2;
            JsonPrimitive jsonPrimitive;
            JsonObject jsonObject;
            JsonObject jsonObject2 = jsonElement.getAsJsonObject();
            Style style = new Style();
            if (jsonObject2.has("bold")) {
                style.setBold(jsonObject2.get("bold").getAsBoolean());
            }
            if (jsonObject2.has("italic")) {
                style.setItalic(jsonObject2.get("italic").getAsBoolean());
            }
            if (jsonObject2.has("underlined")) {
                style.setUnderlined(jsonObject2.get("underlined").getAsBoolean());
            }
            if (jsonObject2.has("strikethrough")) {
                style.setStrikethrough(jsonObject2.get("strikethrough").getAsBoolean());
            }
            if (jsonObject2.has("obfuscated")) {
                style.setObfuscated(jsonObject2.get("obfuscated").getAsBoolean());
            }
            if (jsonObject2.has("color")) {
                style.setFormatting(TextFormatting.getByName(jsonObject2.get("color").getAsString()));
            }
            if (jsonObject2.has("clickEvent") && (jsonObject = jsonObject2.getAsJsonObject("clickEvent")) != null) {
                jsonPrimitive = jsonObject.getAsJsonPrimitive("action");
                object2 = jsonObject.getAsJsonPrimitive("value");
                object = null;
                String string = null;
                if (jsonPrimitive != null) {
                    object = ClickEventAction.byName(jsonPrimitive.getAsString());
                }
                if (object2 != null) {
                    string = ((JsonPrimitive)object2).getAsString();
                }
                if (object != null && string != null && ((ClickEventAction)object).isUserDefinable()) {
                    style.setClickEvent((ClickEvent)this.clickEventSerializer.deserialize(object, string));
                }
            }
            if (jsonObject2.has("hoverEvent") && (jsonObject = jsonObject2.getAsJsonObject("hoverEvent")) != null) {
                jsonPrimitive = jsonObject.getAsJsonPrimitive("action");
                object2 = null;
                object = (TextComponent)jsonDeserializationContext.deserialize(jsonObject.get("value"), (Type)((Object)TextComponent.class));
                if (jsonPrimitive != null) {
                    object2 = HoverEventAction.byName(jsonPrimitive.getAsString());
                }
                if (object2 != null && object != null && ((HoverEventAction)object2).isUserDefinable()) {
                    style.setHoverEvent((HoverEvent)this.hoverEventSerializer.deserialize(object2, object));
                }
            }
            return style;
        }
        return null;
    }
}

