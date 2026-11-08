/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.template;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.template.Protocol99_1To98_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;

public class BlockItemPacketRewriter99_1
extends BackwardsStructuredItemRewriter<ClientboundPacket26_1, ServerboundPacket1_21_9, Protocol99_1To98_1> {
    public BlockItemPacketRewriter99_1(Protocol99_1To98_1 protocol99_1To98_1) {
        super(protocol99_1To98_1);
    }

    @Override
    public void registerPackets() {
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
    }
}

