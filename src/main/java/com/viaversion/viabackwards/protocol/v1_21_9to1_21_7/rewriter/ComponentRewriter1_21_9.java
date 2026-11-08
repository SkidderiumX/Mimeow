/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;

public class ComponentRewriter1_21_9
extends NBTComponentRewriter<ClientboundPacket1_21_9> {
    public ComponentRewriter1_21_9(BackwardsProtocol<ClientboundPacket1_21_9, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
    }

    @Override
    protected void processCompoundTag(UserConnection userConnection, CompoundTag compoundTag) {
        super.processCompoundTag(userConnection, compoundTag);
        String string = compoundTag.getString("type");
        Tag tag = compoundTag.get("fallback");
        if (tag == null) {
            tag = new StringTag("");
        }
        if ("object".equals(string)) {
            compoundTag.put("text", tag);
            compoundTag.remove("type");
        }
        if (compoundTag.remove("sprite") != null) {
            compoundTag.put("text", tag);
        }
        if (compoundTag.remove("player") != null) {
            compoundTag.put("text", tag);
        }
        compoundTag.remove("atlas");
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        this.removeDataComponents(compoundTag2, StructuredDataKey.ENTITY_DATA1_21_9, StructuredDataKey.BLOCK_ENTITY_DATA1_21_9);
    }
}

