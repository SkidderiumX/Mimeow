/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;

public class BackwardsFullStructuredItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends BackwardsStructuredItemRewriter<C, S, T> {
    public BackwardsFullStructuredItemRewriter(T t) {
        super(t);
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (Item.isEmpty(item)) {
            return item;
        }
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        if (protocolInfo.serverProtocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_5) && !((BackwardsProtocol)this.protocol).getEntityRewriter().tracker(userConnection).canInstaBuild()) {
            CompoundTag compoundTag = item.dataContainer().get(StructuredDataKey.CUSTOM_DATA);
            if (compoundTag == null) {
                item.dataContainer().data().clear();
            } else {
                compoundTag.keySet().removeIf(string -> !string.equals("VV|original_hashes"));
                item.dataContainer().data().keySet().removeIf(structuredDataKey -> structuredDataKey != StructuredDataKey.CUSTOM_DATA);
            }
        }
        return super.handleItemToServer(userConnection, item);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Tag tag = compoundTag.get("VV|original_hashes");
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
        if (tag != null) {
            compoundTag.put("VV|original_hashes", tag);
            if (!structuredDataContainer.has(StructuredDataKey.CUSTOM_DATA)) {
                structuredDataContainer.set(StructuredDataKey.CUSTOM_DATA, compoundTag);
                compoundTag.putBoolean("VV|custom_data", true);
            }
        }
    }
}

