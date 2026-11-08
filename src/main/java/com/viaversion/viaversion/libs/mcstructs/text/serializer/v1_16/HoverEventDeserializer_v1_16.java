/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.utils.JsonUtils;
import java.lang.reflect.Type;
import java.util.UUID;

public class HoverEventDeserializer_v1_16
implements JsonDeserializer<HoverEvent> {
    protected TextComponentSerializer textComponentSerializer;
    protected final SNbt<?> sNbt;

    public HoverEventDeserializer_v1_16(TextComponentSerializer textComponentSerializer, SNbt<?> sNbt) {
        this.textComponentSerializer = textComponentSerializer;
        this.sNbt = sNbt;
    }

    @Override
    public HoverEvent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jsonObject, "action", null);
        if (string == null) {
            return null;
        }
        HoverEventAction hoverEventAction = HoverEventAction.byName(string);
        if (hoverEventAction == null) {
            return null;
        }
        JsonElement jsonElement2 = jsonObject.get("contents");
        if (jsonElement2 != null) {
            return this.deserialize(hoverEventAction, jsonElement2);
        }
        TextComponent textComponent = this.textComponentSerializer.deserialize(jsonObject.get("value"));
        if (textComponent == null) {
            return null;
        }
        return this.deserializeLegacy(hoverEventAction, textComponent);
    }

    protected HoverEvent deserialize(HoverEventAction hoverEventAction, JsonElement jsonElement) {
        switch (hoverEventAction) {
            case SHOW_TEXT: {
                return new TextHoverEvent(this.textComponentSerializer.deserialize(jsonElement));
            }
            case SHOW_ITEM: {
                if (jsonElement.isJsonPrimitive()) {
                    return new ItemHoverEvent(Identifier.of(jsonElement.getAsString()), 1, null);
                }
                JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "item");
                Identifier identifier = Identifier.of(JsonUtils.getString(jsonObject, "id"));
                int n = JsonUtils.getInt(jsonObject, "count", 1);
                if (jsonObject.has("tag")) {
                    String string = JsonUtils.getString(jsonObject, "tag");
                    return new ItemHoverEvent(identifier, n, (CompoundTag)this.sNbt.tryDeserialize(string));
                }
                return new ItemHoverEvent(identifier, n, null);
            }
            case SHOW_ENTITY: {
                if (!jsonElement.isJsonObject()) {
                    return null;
                }
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                Identifier identifier = Identifier.of(JsonUtils.getString(jsonObject, "type"));
                UUID uUID = UUID.fromString(JsonUtils.getString(jsonObject, "id"));
                TextComponent textComponent = this.textComponentSerializer.deserialize(jsonObject.get("name"));
                return new EntityHoverEvent(identifier, uUID, textComponent);
            }
        }
        return null;
    }

    protected HoverEvent deserializeLegacy(HoverEventAction hoverEventAction, TextComponent textComponent) {
        switch (hoverEventAction) {
            case SHOW_TEXT: {
                return new TextHoverEvent(textComponent);
            }
            case SHOW_ITEM: {
                CompoundTag compoundTag = (CompoundTag)this.sNbt.tryDeserialize(textComponent.asUnformattedString());
                if (compoundTag == null) {
                    return null;
                }
                Identifier identifier = Identifier.of(compoundTag.get("id") instanceof StringTag ? ((StringTag)compoundTag.get("id")).getValue() : "");
                byte by = compoundTag.get("count") instanceof ByteTag ? ((ByteTag)compoundTag.get("count")).asByte() : (byte)0;
                CompoundTag compoundTag2 = null;
                if (compoundTag.get("tag") instanceof CompoundTag) {
                    compoundTag2 = compoundTag.get("tag") instanceof CompoundTag ? (CompoundTag)compoundTag.get("tag") : new CompoundTag();
                }
                return new ItemHoverEvent(identifier, by, compoundTag2);
            }
            case SHOW_ENTITY: {
                try {
                    this.textComponentSerializer = this.textComponentSerializer.forkIfDefault();
                    CompoundTag compoundTag = (CompoundTag)this.sNbt.deserialize(textComponent.asUnformattedString(this.textComponentSerializer));
                    TextComponent textComponent2 = this.textComponentSerializer.deserialize(compoundTag.get("name") instanceof StringTag ? ((StringTag)compoundTag.get("name")).getValue() : "");
                    Identifier identifier = Identifier.of(compoundTag.get("type") instanceof StringTag ? ((StringTag)compoundTag.get("type")).getValue() : "");
                    UUID uUID = UUID.fromString(compoundTag.get("id") instanceof StringTag ? ((StringTag)compoundTag.get("id")).getValue() : "");
                    return new EntityHoverEvent(identifier, uUID, textComponent2);
                }
                catch (JsonSyntaxException | SNbtDeserializeException exception) {
                    return null;
                }
            }
        }
        return null;
    }
}

