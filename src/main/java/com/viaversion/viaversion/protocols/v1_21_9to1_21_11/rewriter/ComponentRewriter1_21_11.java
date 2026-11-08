/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.Protocol1_21_9To1_21_11;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;
import com.viaversion.viaversion.util.Key;

public class ComponentRewriter1_21_11
extends NBTComponentRewriter<ClientboundPacket1_21_9> {
    public ComponentRewriter1_21_11(Protocol1_21_9To1_21_11 protocol1_21_9To1_21_11) {
        super(protocol1_21_9To1_21_11);
    }

    @Override
    protected void processCompoundTag(UserConnection userConnection, CompoundTag compoundTag) {
        super.processCompoundTag(userConnection, compoundTag);
        StringTag stringTag = compoundTag.getStringTag("sprite");
        if (stringTag != null) {
            String string = Key.stripNamespace(stringTag.getValue());
            if (string.startsWith("item/")) {
                compoundTag.putString("atlas", "items");
            } else if (string.startsWith("block/")) {
                compoundTag.putString("atlas", "blocks");
            }
        }
    }
}

