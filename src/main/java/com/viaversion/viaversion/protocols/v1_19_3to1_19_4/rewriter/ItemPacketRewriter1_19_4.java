/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter.RecipeRewriter1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.Protocol1_19_3To1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.rewriter.ItemRewriter;

public class ItemPacketRewriter1_19_4
extends ItemRewriter<ClientboundPackets1_19_3, ServerboundPackets1_19_4, Protocol1_19_3To1_19_4> {
    public ItemPacketRewriter1_19_4(Protocol1_19_3To1_19_4 protocol1_19_3To1_19_4) {
        super(protocol1_19_3To1_19_4, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_19_3To1_19_4)this.protocol).replaceClientbound(ClientboundPackets1_19_3.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 1);
                    if (n == 1010) {
                        if (n2 >= 1092 && n2 <= 1106) {
                            packetWrapper.set(Types.INT, 1, ((Protocol1_19_3To1_19_4)ItemPacketRewriter1_19_4.this.protocol).getMappingData().getNewItemId(n2));
                        } else {
                            packetWrapper.set(Types.INT, 0, 1011);
                            packetWrapper.set(Types.INT, 1, 0);
                        }
                    } else if (n == 2001) {
                        packetWrapper.set(Types.INT, 1, ((Protocol1_19_3To1_19_4)ItemPacketRewriter1_19_4.this.protocol).getMappingData().getNewBlockStateId(n2));
                    }
                });
            }
        });
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.COMPONENT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n >= 21) {
                        packetWrapper.set(Types.VAR_INT, 1, n + 1);
                    }
                });
            }
        });
        new RecipeRewriter1_19_3<ClientboundPackets1_19_3>(this.protocol){

            @Override
            public void handleCraftingShaped(PacketWrapper packetWrapper) {
                super.handleCraftingShaped(packetWrapper);
                packetWrapper.write(Types.BOOLEAN, true);
            }
        }.register(ClientboundPackets1_19_3.UPDATE_RECIPES);
    }
}

