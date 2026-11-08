/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v26_1to26_2.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys26_2;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPacket26_1;
import com.viaversion.viaversion.protocols.v26_1to26_2.Protocol26_1To26_2;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;

public class BlockItemPacketRewriter26_2
extends StructuredItemRewriter<ClientboundPacket26_1, ServerboundPacket26_1, Protocol26_1To26_2> {
    public BlockItemPacketRewriter26_2(Protocol26_1To26_2 protocol26_1To26_2) {
        super(protocol26_1To26_2);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter26_2.upgradeData(structuredDataContainer);
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter26_2.downgradeData((StructuredDataKeys26_2)((Types1_20_5)((Protocol26_1To26_2)this.protocol).mappedTypes()).structuredDataKeys(), structuredDataContainer);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    public static void upgradeData(StructuredDataContainer structuredDataContainer) {
    }

    public static void downgradeData(StructuredDataKeys26_2 structuredDataKeys26_2, StructuredDataContainer structuredDataContainer) {
        structuredDataContainer.remove(structuredDataKeys26_2.sulfurCubeContent);
    }
}

