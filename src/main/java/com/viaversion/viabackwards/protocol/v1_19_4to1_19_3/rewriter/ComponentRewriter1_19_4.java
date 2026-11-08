/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.rewriter;

import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.Protocol1_19_4To1_19_3;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;

public class ComponentRewriter1_19_4
extends JsonNBTComponentRewriter<ClientboundPackets1_19_4> {
    public ComponentRewriter1_19_4(Protocol1_19_4To1_19_3 protocol1_19_4To1_19_3) {
        super(protocol1_19_4To1_19_3, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    protected void handleTranslate(JsonObject jsonObject, String string) {
        super.handleTranslate(jsonObject, string);
        if ((string.startsWith("vb.item.") || string.startsWith("vb.entity.")) && jsonObject.has("fallback")) {
            JsonElement jsonElement = jsonObject.remove("fallback");
            jsonObject.add("translate", jsonElement);
        }
    }
}

