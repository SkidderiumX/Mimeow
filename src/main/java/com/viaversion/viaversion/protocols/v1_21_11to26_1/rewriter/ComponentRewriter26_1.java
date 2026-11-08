/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.Protocol1_21_11To26_1;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;

public class ComponentRewriter26_1
extends NBTComponentRewriter<ClientboundPacket1_21_11> {
    public ComponentRewriter26_1(Protocol1_21_11To26_1 protocol1_21_11To26_1) {
        super(protocol1_21_11To26_1);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        int n = compoundTag.getInt("count");
        if (n == 0) {
            compoundTag.putInt("count", 1);
        }
    }

    @Override
    protected void handleTranslate(UserConnection userConnection, CompoundTag compoundTag, StringTag stringTag) {
        switch (stringTag.getValue()) {
            case "commands.time.set": {
                stringTag.setValue("Set the time to %s");
                break;
            }
            case "commands.time.query": {
                stringTag.setValue("The time is %s");
            }
        }
    }
}

