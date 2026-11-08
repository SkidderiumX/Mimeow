/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPacket1_21_6;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;

public class BlockItemPacketRewriter1_21_6
extends StructuredItemRewriter<ClientboundPacket1_21_5, ServerboundPacket1_21_6, Protocol1_21_5To1_21_6> {
    public BlockItemPacketRewriter1_21_6(Protocol1_21_5To1_21_6 protocol1_21_5To1_21_6) {
        super(protocol1_21_5To1_21_6);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter1_21_6.upgradeItemData(item);
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter1_21_6.downgradeItemData(item);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    public static void upgradeItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_5, StructuredDataKey.EQUIPPABLE1_21_6);
        structuredDataContainer.replaceKey(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6);
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_6, StructuredDataKey.EQUIPPABLE1_21_5);
        structuredDataContainer.replaceKey(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5);
    }
}

