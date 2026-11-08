/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_8;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_8.EventSerializers_v1_8;
import java.lang.reflect.Type;

public class StyleSerializer_v1_8
extends EventSerializers_v1_8
implements JsonSerializer<Style> {
    public StyleSerializer_v1_8(SNbt<?> sNbt) {
        super(sNbt);
    }

    @Override
    public JsonElement serialize(Style style, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject;
        if (style.isEmpty()) {
            return null;
        }
        JsonObject jsonObject2 = new JsonObject();
        if (style.getBold() != null) {
            jsonObject2.addProperty("bold", style.isBold());
        }
        if (style.getItalic() != null) {
            jsonObject2.addProperty("italic", style.isItalic());
        }
        if (style.getUnderlined() != null) {
            jsonObject2.addProperty("underlined", style.isUnderlined());
        }
        if (style.getStrikethrough() != null) {
            jsonObject2.addProperty("strikethrough", style.isStrikethrough());
        }
        if (style.getObfuscated() != null) {
            jsonObject2.addProperty("obfuscated", style.isObfuscated());
        }
        if (style.getColor() != null && !style.getColor().isRGBColor()) {
            jsonObject2.addProperty("color", style.getColor().serialize());
        }
        if (style.getInsertion() != null) {
            jsonObject2.add("insertion", jsonSerializationContext.serialize(style.getInsertion()));
        }
        if (style.getClickEvent() != null) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("action", style.getClickEvent().getAction().getName());
            jsonObject.addProperty("value", (String)this.clickEventSerializer.serialize(style.getClickEvent()));
            jsonObject2.add("clickEvent", jsonObject);
        }
        if (style.getHoverEvent() != null) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("action", style.getHoverEvent().getAction().getName());
            jsonObject.add("value", jsonSerializationContext.serialize(this.hoverEventSerializer.serialize(style.getHoverEvent())));
            jsonObject2.add("hoverEvent", jsonObject);
        }
        return jsonObject2;
    }
}

