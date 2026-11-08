/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.util.ComponentUtil;

public class CommandBlockHandler
implements BlockEntityProvider.BlockEntityHandler {
    private final Protocol1_12_2To1_13 protocol = Via.getManager().getProtocolManager().getProtocol(Protocol1_12_2To1_13.class);

    @Override
    public int transform(UserConnection userConnection, CompoundTag compoundTag) {
        StringTag stringTag;
        StringTag stringTag2 = compoundTag.getStringTag("CustomName");
        if (stringTag2 != null) {
            stringTag2.setValue(ComponentUtil.legacyToJsonString(stringTag2.getValue()));
        }
        if ((stringTag = compoundTag.getStringTag("LastOutput")) != null) {
            JsonElement jsonElement = JsonParser.parseString(stringTag.getValue());
            this.protocol.getComponentRewriter().processText(userConnection, jsonElement);
            stringTag.setValue(jsonElement.toString());
        }
        return -1;
    }
}

