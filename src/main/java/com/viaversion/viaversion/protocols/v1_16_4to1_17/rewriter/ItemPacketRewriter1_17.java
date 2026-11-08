/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.Protocol1_16_4To1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;

public class ItemPacketRewriter1_17
extends ItemRewriter<ClientboundPackets1_16_2, ServerboundPackets1_17, Protocol1_16_4To1_17> {
    public ItemPacketRewriter1_17(Protocol1_16_4To1_17 protocol1_16_4To1_17) {
        super(protocol1_16_4To1_17, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        new RecipeRewriter<ClientboundPackets1_16_2>(this.protocol).register(ClientboundPackets1_16_2.UPDATE_RECIPES);
        ((Protocol1_16_4To1_17)this.protocol).registerServerbound(ServerboundPackets1_17.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
        ((Protocol1_16_4To1_17)this.protocol).replaceServerbound(ServerboundPackets1_17.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> packetWrapper.write(Types.SHORT, (short)0));
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        packetWrapper.read(Types.SHORT);
                        packetWrapper.read(Types.ITEM1_13_2);
                    }
                    Item item = packetWrapper.read(Types.ITEM1_13_2);
                    int n2 = packetWrapper.get(Types.VAR_INT, 0);
                    if (n2 == 5 || n2 == 1) {
                        item = null;
                    } else {
                        ItemPacketRewriter1_17.this.handleItemToServer(packetWrapper.user(), item);
                    }
                    packetWrapper.write(Types.ITEM1_13_2, item);
                });
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).registerClientbound(ClientboundPackets1_16_2.CONTAINER_ACK, null, packetWrapper -> {
            short s = packetWrapper.read(Types.UNSIGNED_BYTE);
            short s2 = packetWrapper.read(Types.SHORT);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            if (!bl) {
                int n = 0x40000000 | s << 16 | s2 & 0xFFFF;
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_17.PING);
                packetWrapper2.write(Types.INT, n);
                packetWrapper2.send(Protocol1_16_4To1_17.class);
            }
            packetWrapper.cancel();
        });
        ((Protocol1_16_4To1_17)this.protocol).registerServerbound(ServerboundPackets1_17.PONG, null, packetWrapper -> {
            int n = packetWrapper.read(Types.INT);
            if ((n & 0x40000000) != 0) {
                byte by = (byte)(n >> 16 & 0xFF);
                short s = (short)(n & 0xFFFF);
                PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_16_2.CONTAINER_ACK);
                packetWrapper2.write(Types.BYTE, by);
                packetWrapper2.write(Types.SHORT, s);
                packetWrapper2.write(Types.BOOLEAN, true);
                packetWrapper2.sendToServer(Protocol1_16_4To1_17.class);
            }
            packetWrapper.cancel();
        });
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = item.tag();
        if (item.identifier() == 733) {
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
                item.setTag(compoundTag);
            }
            if (compoundTag.getNumberTag("map") == null) {
                compoundTag.put("map", new IntTag(0));
            }
        }
        item.setIdentifier(((Protocol1_16_4To1_17)this.protocol).getMappingData().getNewItemId(item.identifier()));
        return item;
    }
}

