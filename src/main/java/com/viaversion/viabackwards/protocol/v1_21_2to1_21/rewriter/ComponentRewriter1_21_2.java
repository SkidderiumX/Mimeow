/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;

public class ComponentRewriter1_21_2
extends JsonNBTComponentRewriter<ClientboundPacket1_21_2> {
    public ComponentRewriter1_21_2(Protocol1_21_2To1_21 protocol1_21_2To1_21) {
        super(protocol1_21_2To1_21, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.ComponentRewriter1_21_2.convertAttributes(compoundTag2, this.protocol.getMappingData().getAttributeMappings());
        CompoundTag compoundTag3 = TagUtil.getNamespacedCompoundTag(compoundTag2, "instrument");
        if (compoundTag3 != null) {
            compoundTag3.remove("description");
        }
        CompoundTag compoundTag4 = TagUtil.getNamespacedCompoundTag(compoundTag2, "use_remainder");
        CompoundTag compoundTag5 = TagUtil.getNamespacedCompoundTag(compoundTag2, "food");
        if (compoundTag5 != null) {
            if (compoundTag4 != null) {
                compoundTag5.put("using_converts_to", compoundTag4);
            }
            compoundTag5.putFloat("eat_seconds", 1.6f);
        }
        this.removeDataComponents(compoundTag2, BlockItemPacketRewriter1_21_2.NEW_DATA_TO_REMOVE);
        this.removeDataComponents(compoundTag2, StructuredDataKey.DAMAGE_RESISTANT1_21_2, StructuredDataKey.LOCK1_21_2);
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }
}

