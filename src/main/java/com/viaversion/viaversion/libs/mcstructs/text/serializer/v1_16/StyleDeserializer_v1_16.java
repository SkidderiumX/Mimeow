/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16;

import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ChangePageClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenUrlClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.utils.JsonUtils;
import java.lang.reflect.Type;

public class StyleDeserializer_v1_16
implements JsonDeserializer<Style> {
    @Override
    public Style deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Object object;
        Object object2;
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject == null) {
            return null;
        }
        Style style = new Style();
        if (jsonObject.has("bold")) {
            style.setBold(jsonObject.get("bold").getAsBoolean());
        }
        if (jsonObject.has("italic")) {
            style.setItalic(jsonObject.get("italic").getAsBoolean());
        }
        if (jsonObject.has("underlined")) {
            style.setUnderlined(jsonObject.get("underlined").getAsBoolean());
        }
        if (jsonObject.has("strikethrough")) {
            style.setStrikethrough(jsonObject.get("strikethrough").getAsBoolean());
        }
        if (jsonObject.has("obfuscated")) {
            style.setObfuscated(jsonObject.get("obfuscated").getAsBoolean());
        }
        if (jsonObject.has("color")) {
            style.setFormatting(TextFormatting.parse(JsonUtils.getString(jsonObject, "color")));
        }
        if (jsonObject.has("insertion")) {
            style.setInsertion(JsonUtils.getString(jsonObject, "insertion", null));
        }
        if (jsonObject.has("clickEvent")) {
            object2 = JsonUtils.getJsonObject(jsonObject, "clickEvent");
            object = JsonUtils.getString((JsonObject)object2, "action");
            ClickEventAction clickEventAction = null;
            String string = JsonUtils.getString((JsonObject)object2, "value");
            if (object != null) {
                clickEventAction = ClickEventAction.byName((String)object);
            }
            if (clickEventAction != null && string != null && clickEventAction.isUserDefinable()) {
                style.setClickEvent(this.deserializeClickEvent(clickEventAction, string));
            }
        }
        if (jsonObject.has("hoverEvent") && (object = (HoverEvent)jsonDeserializationContext.deserialize((JsonElement)(object2 = JsonUtils.getJsonObject(jsonObject, "hoverEvent")), (Type)((Object)HoverEvent.class))) != null && ((HoverEvent)object).getAction().isUserDefinable()) {
            style.setHoverEvent((HoverEvent)object);
        }
        if (jsonObject.has("font")) {
            object2 = JsonUtils.getString(jsonObject, "font");
            try {
                style.setFont(Identifier.of((String)object2));
            }
            catch (Throwable throwable) {
                throw new JsonSyntaxException("Invalid font name: " + (String)object2);
            }
        }
        return style;
    }

    private ClickEvent deserializeClickEvent(ClickEventAction clickEventAction, String string) {
        switch (clickEventAction) {
            case OPEN_URL: {
                return new OpenUrlClickEvent(string);
            }
            case OPEN_FILE: {
                return ClickEvent.openFile(string);
            }
            case RUN_COMMAND: {
                return ClickEvent.runCommand(string);
            }
            case SUGGEST_COMMAND: {
                return ClickEvent.suggestCommand(string);
            }
            case CHANGE_PAGE: {
                return new ChangePageClickEvent(string);
            }
            case COPY_TO_CLIPBOARD: {
                return ClickEvent.copyToClipboard(string);
            }
        }
        throw new IllegalArgumentException("Unknown click event action: " + clickEventAction.getName());
    }
}

