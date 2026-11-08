/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.UUID;

public class ComponentRewriter1_21
extends JsonNBTComponentRewriter<ClientboundPacket1_20_5> {
    public ComponentRewriter1_21(Protocol1_20_5To1_21 protocol1_20_5To1_21) {
        super(protocol1_20_5To1_21, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        String string = Key.stripMinecraftNamespace(compoundTag.getString("id"));
        if (string.equals("trident") || string.equals("piglin_banner_pattern")) {
            if (compoundTag2 == null) {
                compoundTag2 = new CompoundTag();
                compoundTag.put("components", compoundTag2);
            }
            if (!TagUtil.containsNamespaced(compoundTag2, "rarity")) {
                compoundTag2.put("minecraft:rarity", new StringTag("common"));
            }
        }
        if (compoundTag2 == null) {
            return;
        }
        CompoundTag compoundTag3 = TagUtil.getNamespacedCompoundTag(compoundTag2, "attribute_modifiers");
        if (compoundTag3 == null) {
            return;
        }
        ListTag<CompoundTag> listTag = compoundTag3.getListTag("modifiers", CompoundTag.class);
        for (CompoundTag compoundTag4 : listTag) {
            String string2 = compoundTag4.getString("name");
            UUID uUID = UUIDUtil.fromIntArray(compoundTag4.getIntArrayTag("uuid").getValue());
            String string3 = Protocol1_20_5To1_21.mapAttributeUUID(uUID, string2);
            compoundTag4.putString("id", string3);
        }
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }
}

