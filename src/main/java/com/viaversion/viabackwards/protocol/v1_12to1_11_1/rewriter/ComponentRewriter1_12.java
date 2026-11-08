/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12to1_11_1.rewriter;

import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.Protocol1_12To1_11_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ClientboundPackets1_12;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;

public class ComponentRewriter1_12
extends JsonNBTComponentRewriter<ClientboundPackets1_12> {
    public ComponentRewriter1_12(Protocol1_12To1_11_1 protocol1_12To1_11_1) {
        super(protocol1_12To1_11_1, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    public void processText(UserConnection userConnection, JsonElement jsonElement) {
        super.processText(userConnection, jsonElement);
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = jsonObject.remove("keybind");
        if (jsonElement2 == null) {
            return;
        }
        jsonObject.addProperty("text", jsonElement2.getAsString());
    }
}

