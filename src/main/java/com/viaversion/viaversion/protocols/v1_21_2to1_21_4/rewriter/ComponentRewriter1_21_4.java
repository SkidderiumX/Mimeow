/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.SerializerVersion;

public class ComponentRewriter1_21_4
extends JsonNBTComponentRewriter<ClientboundPacket1_21_2> {
    public ComponentRewriter1_21_4(Protocol1_21_2To1_21_4 protocol1_21_2To1_21_4) {
        super(protocol1_21_2To1_21_4, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        this.removeDataComponents(compoundTag2, StructuredDataKey.CUSTOM_MODEL_DATA1_20_5);
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }
}

