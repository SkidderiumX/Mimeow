/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ChangePageClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.CopyToClipboardClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenFileClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenUrlClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.RunCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.SuggestCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.font.ResourceFont;
import java.lang.reflect.Type;

public class StyleSerializer_v1_16
implements JsonSerializer<Style> {
    @Override
    public JsonElement serialize(Style style, Type type, JsonSerializationContext jsonSerializationContext) {
        if (style.isEmpty()) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        if (style.getBold() != null) {
            jsonObject.addProperty("bold", style.isBold());
        }
        if (style.getItalic() != null) {
            jsonObject.addProperty("italic", style.isItalic());
        }
        if (style.getUnderlined() != null) {
            jsonObject.addProperty("underlined", style.isUnderlined());
        }
        if (style.getStrikethrough() != null) {
            jsonObject.addProperty("strikethrough", style.isStrikethrough());
        }
        if (style.getObfuscated() != null) {
            jsonObject.addProperty("obfuscated", style.isObfuscated());
        }
        if (style.getColor() != null) {
            jsonObject.addProperty("color", style.getColor().serialize());
        }
        if (style.getInsertion() != null) {
            jsonObject.add("insertion", jsonSerializationContext.serialize(style.getInsertion()));
        }
        if (style.getClickEvent() != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("action", style.getClickEvent().getAction().getName());
            jsonObject2.addProperty("value", this.serializeClickEvent(style.getClickEvent()));
            jsonObject.add("clickEvent", jsonObject2);
        }
        if (style.getHoverEvent() != null) {
            jsonObject.add("hoverEvent", jsonSerializationContext.serialize(style.getHoverEvent()));
        }
        if (style.getFont() != null) {
            if (style.getFont() instanceof ResourceFont) {
                jsonObject.addProperty("font", ((ResourceFont)style.getFont()).getId().get());
            } else {
                throw new IllegalStateException("Unsupported font type: " + style.getFont().getClass().getName());
            }
        }
        return jsonObject;
    }

    private String serializeClickEvent(ClickEvent clickEvent) {
        if (clickEvent instanceof OpenUrlClickEvent) {
            return ((OpenUrlClickEvent)clickEvent).asString();
        }
        if (clickEvent instanceof OpenFileClickEvent) {
            return ((OpenFileClickEvent)clickEvent).getPath();
        }
        if (clickEvent instanceof RunCommandClickEvent) {
            return ((RunCommandClickEvent)clickEvent).getCommand();
        }
        if (clickEvent instanceof SuggestCommandClickEvent) {
            return ((SuggestCommandClickEvent)clickEvent).getCommand();
        }
        if (clickEvent instanceof ChangePageClickEvent) {
            return ((ChangePageClickEvent)clickEvent).asString();
        }
        if (clickEvent instanceof CopyToClipboardClickEvent) {
            return ((CopyToClipboardClickEvent)clickEvent).getValue();
        }
        throw new IllegalArgumentException("Unknown click event type: " + clickEvent.getClass().getName());
    }
}

