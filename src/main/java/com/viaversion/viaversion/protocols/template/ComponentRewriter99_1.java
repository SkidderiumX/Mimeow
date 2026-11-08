/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.template;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.template.Protocol98_1To99_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;

public class ComponentRewriter99_1
extends NBTComponentRewriter<ClientboundPacket26_1> {
    public ComponentRewriter99_1(Protocol98_1To99_1 protocol98_1To99_1) {
        super(protocol98_1To99_1);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
    }
}

