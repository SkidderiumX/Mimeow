/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_7to1_21_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.Protocol1_21_7To1_21_9;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;

public class ComponentRewriter1_21_9
extends NBTComponentRewriter<ClientboundPacket1_21_6> {
    public ComponentRewriter1_21_9(Protocol1_21_7To1_21_9 protocol1_21_7To1_21_9) {
        super(protocol1_21_7To1_21_9);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        this.removeDataComponents(compoundTag2, StructuredDataKey.ENTITY_DATA1_20_5, StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, StructuredDataKey.BEES1_20_5);
    }
}

