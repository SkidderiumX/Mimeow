/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;
import java.lang.reflect.Type;

public class HoverEventSerializer_v1_16
implements JsonSerializer<HoverEvent> {
    private final TextComponentSerializer textComponentSerializer;
    private final SNbt<?> sNbt;

    public HoverEventSerializer_v1_16(TextComponentSerializer textComponentSerializer, SNbt<?> sNbt) {
        this.textComponentSerializer = textComponentSerializer;
        this.sNbt = sNbt;
    }

    @Override
    public JsonElement serialize(HoverEvent hoverEvent, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("action", hoverEvent.getAction().getName());
        if (hoverEvent instanceof TextHoverEvent) {
            TextHoverEvent textHoverEvent = (TextHoverEvent)hoverEvent;
            jsonObject.add("contents", this.textComponentSerializer.serializeJson(textHoverEvent.getText()));
        } else if (hoverEvent instanceof ItemHoverEvent) {
            ItemHoverEvent itemHoverEvent = (ItemHoverEvent)hoverEvent;
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("id", itemHoverEvent.asModern().getId().get());
            if (itemHoverEvent.asModern().getCount() != 1) {
                jsonObject2.addProperty("count", itemHoverEvent.asModern().getCount());
            }
            if (itemHoverEvent.asModern().getTag() != null) {
                jsonObject2.addProperty("tag", this.sNbt.trySerialize(itemHoverEvent.asModern().getTag()));
            }
            jsonObject.add("contents", jsonObject2);
        } else if (hoverEvent instanceof EntityHoverEvent) {
            EntityHoverEvent entityHoverEvent = (EntityHoverEvent)hoverEvent;
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("type", entityHoverEvent.asModern().getType().get());
            jsonObject3.addProperty("id", entityHoverEvent.asModern().getUuid().toString());
            if (entityHoverEvent.asModern().getName() != null) {
                jsonObject3.add("name", this.textComponentSerializer.serializeJson(entityHoverEvent.asModern().getName()));
            }
            jsonObject.add("contents", jsonObject3);
        }
        return jsonObject;
    }
}

