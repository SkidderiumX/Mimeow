/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.Protocol1_21To1_20_5;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Attributes1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.AttributeModifierMappings1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.UUID;

public class ComponentRewriter1_21
extends JsonNBTComponentRewriter<ClientboundPacket1_21> {
    public ComponentRewriter1_21(Protocol1_21To1_20_5 protocol1_21To1_20_5) {
        super(protocol1_21To1_20_5, ComponentRewriterBase.ReadType.NBT);
    }

    private void convertAttributeModifiersComponent(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, "attribute_modifiers");
        if (compoundTag2 == null) {
            return;
        }
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("modifiers", CompoundTag.class);
        int n = listTag.size();
        for (int i = 0; i < n; ++i) {
            CompoundTag compoundTag3 = listTag.get(i);
            String string = Key.stripMinecraftNamespace(compoundTag3.getString("type"));
            if (Attributes1_20_5.keyToId(string) == -1) {
                listTag.remove(i--);
                --n;
                continue;
            }
            String string2 = compoundTag3.getString("id");
            UUID uUID = Protocol1_20_5To1_21.mapAttributeId(string2);
            String string3 = AttributeModifierMappings1_21.idToName(string2);
            compoundTag3.put("uuid", new IntArrayTag(UUIDUtil.toIntArray(uUID)));
            compoundTag3.putString("name", string3 != null ? string3 : string2);
        }
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 != null) {
            this.removeDataComponents(compoundTag2, StructuredDataKey.JUKEBOX_PLAYABLE1_21);
            this.convertAttributeModifiersComponent(compoundTag2);
        }
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }

    @Override
    protected SerializerVersion outputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }
}

