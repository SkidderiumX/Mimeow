/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_18;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16.HoverEventDeserializer_v1_16;
import java.util.UUID;

public class HoverEventDeserializer_v1_18
extends HoverEventDeserializer_v1_16 {
    public HoverEventDeserializer_v1_18(TextComponentSerializer textComponentSerializer, SNbt<?> sNbt) {
        super(textComponentSerializer, sNbt);
    }

    @Override
    protected HoverEvent deserializeLegacy(HoverEventAction hoverEventAction, TextComponent textComponent) {
        if (hoverEventAction == HoverEventAction.SHOW_ENTITY) {
            try {
                this.textComponentSerializer = this.textComponentSerializer.forkIfDefault();
                CompoundTag compoundTag = (CompoundTag)this.sNbt.deserialize(textComponent.asUnformattedString(this.textComponentSerializer));
                TextComponent textComponent2 = this.textComponentSerializer.deserialize(compoundTag.get("name") instanceof StringTag ? ((StringTag)compoundTag.get("name")).getValue() : "");
                Identifier identifier = Identifier.of(compoundTag.get("type") instanceof StringTag ? ((StringTag)compoundTag.get("type")).getValue() : "");
                UUID uUID = UUID.fromString(compoundTag.get("id") instanceof StringTag ? ((StringTag)compoundTag.get("id")).getValue() : "");
                return new EntityHoverEvent(identifier, uUID, textComponent2);
            }
            catch (Exception exception) {
                return null;
            }
        }
        return super.deserializeLegacy(hoverEventAction, textComponent);
    }
}

