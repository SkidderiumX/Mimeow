/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ClickEvents;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;

public class ComponentRewriter1_21_6
extends NBTComponentRewriter<ClientboundPacket1_21_6> {
    public ComponentRewriter1_21_6(BackwardsProtocol<ClientboundPacket1_21_6, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
    }

    @Override
    protected void handleClickEvent(UserConnection userConnection, CompoundTag compoundTag) {
        String string = compoundTag.getString("action");
        if ("show_dialog".equals(string)) {
            ClickEvents clickEvents = userConnection.get(ClickEvents.class);
            String string2 = clickEvents.storeClickEvent(compoundTag.copy());
            compoundTag.putString("action", "run_command");
            compoundTag.putString("command", string2);
            compoundTag.remove("dialog");
        } else if ("custom".equals(string)) {
            ClickEvents clickEvents = userConnection.get(ClickEvents.class);
            String string3 = clickEvents.storeClickEvent(compoundTag.copy());
            compoundTag.putString("action", "run_command");
            compoundTag.putString("command", string3);
            compoundTag.remove("id");
            compoundTag.remove("payload");
        }
    }
}

