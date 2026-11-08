/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ComponentRewriter1_20_5
extends JsonNBTComponentRewriter<ClientboundPacket1_20_5> {
    private final com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.ComponentRewriter1_20_5<ClientboundPacket1_20_5> vvRewriter;

    public ComponentRewriter1_20_5(BackwardsProtocol<ClientboundPacket1_20_5, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol, ComponentRewriterBase.ReadType.NBT);
        this.vvRewriter = new com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.ComponentRewriter1_20_5<ClientboundPacket1_20_5>(backwardsProtocol, VersionedTypes.V1_20_5.structuredData());
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, @Nullable CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        StringTag stringTag = compoundTag.getStringTag("id");
        if (stringTag == null) {
            return;
        }
        List<StructuredData<?>> list = this.vvRewriter.toData(userConnection, compoundTag2);
        if (list.isEmpty()) {
            return;
        }
        int n = this.protocol.getMappingData().getFullItemMappings().id(stringTag.getValue());
        StructuredItem structuredItem = new StructuredItem(n, 1, new StructuredDataContainer((StructuredData[])list.toArray(StructuredData[]::new)));
        Item item = this.protocol.getItemRewriter().handleItemToClient(userConnection, structuredItem);
        if (item.tag() == null) {
            return;
        }
        compoundTag.remove("components");
        StringTag stringTag2 = new StringTag(this.outputSerializerVersion().toSNBT(item.tag()));
        compoundTag.put("tag", ComponentUtil.trimStrings(stringTag2));
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }

    @Override
    protected SerializerVersion outputSerializerVersion() {
        return SerializerVersion.V1_20_3;
    }
}

