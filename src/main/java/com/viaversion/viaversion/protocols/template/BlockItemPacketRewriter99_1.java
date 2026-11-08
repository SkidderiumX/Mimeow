/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.template;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.protocols.template.Protocol98_1To99_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;

public class BlockItemPacketRewriter99_1
extends StructuredItemRewriter<ClientboundPacket26_1, ServerboundPacket1_21_9, Protocol98_1To99_1> {
    public BlockItemPacketRewriter99_1(Protocol98_1To99_1 protocol98_1To99_1) {
        super(protocol98_1To99_1);
    }

    @Override
    public void registerPackets() {
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter99_1.upgradeData(structuredDataContainer);
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter99_1.downgradeData(structuredDataContainer);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    public static void upgradeData(StructuredDataContainer structuredDataContainer) {
    }

    public static void downgradeData(StructuredDataContainer structuredDataContainer) {
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
    }
}

