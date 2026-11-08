/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_11_1to1_12.rewriter;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.Protocol1_11_1To1_12;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ServerboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.provider.InventoryQuickMoveProvider;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemPacketRewriter1_12
extends ItemRewriter<ClientboundPackets1_9_3, ServerboundPackets1_12, Protocol1_11_1To1_12> {
    public ItemPacketRewriter1_12(Protocol1_11_1To1_12 protocol1_11_1To1_12) {
        super(protocol1_11_1To1_12, Types.ITEM1_8, Types.ITEM1_8_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        this.registerSetSlot(ClientboundPackets1_9_3.CONTAINER_SET_SLOT);
        this.registerSetContent(ClientboundPackets1_9_3.CONTAINER_SET_CONTENT);
        this.registerSetEquippedItem(ClientboundPackets1_9_3.SET_EQUIPPED_ITEM);
        this.registerCustomPayloadTradeList(ClientboundPackets1_9_3.CUSTOM_PAYLOAD);
        ((Protocol1_11_1To1_12)this.protocol).registerServerbound(ServerboundPackets1_12.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.VAR_INT);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> {
                    Item item = packetWrapper.get(Types.ITEM1_8, 0);
                    if (!Via.getConfig().is1_12QuickMoveActionFix()) {
                        ItemPacketRewriter1_12.this.handleItemToServer(packetWrapper.user(), item);
                        return;
                    }
                    byte by = packetWrapper.get(Types.BYTE, 1);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 1 && by == 0 && item == null) {
                        short s = packetWrapper.get(Types.BYTE, 0).byteValue();
                        short s2 = packetWrapper.get(Types.SHORT, 0);
                        short s3 = packetWrapper.get(Types.SHORT, 1);
                        InventoryQuickMoveProvider inventoryQuickMoveProvider = Via.getManager().getProviders().get(InventoryQuickMoveProvider.class);
                        boolean bl = inventoryQuickMoveProvider.registerQuickMoveAction(s, s2, s3, packetWrapper.user());
                        if (bl) {
                            packetWrapper.cancel();
                        }
                    } else {
                        ItemPacketRewriter1_12.this.handleItemToServer(packetWrapper.user(), item);
                    }
                });
            }
        });
        this.registerSetCreativeModeSlot(ServerboundPackets1_12.SET_CREATIVE_MODE_SLOT);
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        if (item.identifier() == 355) {
            item.setData((short)0);
        }
        boolean bl = item.identifier() >= 235 && item.identifier() <= 252;
        if (bl |= item.identifier() == 453) {
            item.setIdentifier(1);
            item.setData((short)0);
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if (item.identifier() == 355) {
            item.setData((short)14);
        }
        return item;
    }
}

