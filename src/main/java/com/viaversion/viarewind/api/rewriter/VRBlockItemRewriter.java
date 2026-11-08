/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.rewriter;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.LegacyBlockItemRewriter;
import com.viaversion.viarewind.api.data.RewindMappingDataLoader;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonObject;

public class VRBlockItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends LegacyBlockItemRewriter<C, S, T> {
    protected VRBlockItemRewriter(T t, String string) {
        super(t, string);
    }

    @Override
    protected JsonObject readMappingsFile(String string) {
        return RewindMappingDataLoader.INSTANCE.loadFromDataDir(string);
    }

    @Override
    public String nbtTagName() {
        return "VR|" + ((BackwardsProtocol)this.protocol).getClass().getSimpleName();
    }
}

