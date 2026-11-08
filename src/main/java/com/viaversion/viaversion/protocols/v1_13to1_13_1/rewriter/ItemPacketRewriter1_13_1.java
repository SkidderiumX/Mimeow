/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13to1_13_1.rewriter;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.Protocol1_13To1_13_1;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;

public class ItemPacketRewriter1_13_1
extends ItemRewriter<ClientboundPackets1_13, ServerboundPackets1_13, Protocol1_13To1_13_1> {
    public ItemPacketRewriter1_13_1(Protocol1_13To1_13_1 protocol1_13To1_13_1) {
        super(protocol1_13To1_13_1, Types.ITEM1_13, Types.ITEM1_13_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_13To1_13_1)this.protocol).registerClientbound(ClientboundPackets1_13.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    String string = Key.namespaced(packetWrapper.get(Types.STRING, 0));
                    if (string.equals("minecraft:trader_list")) {
                        packetWrapper.passthrough(Types.INT);
                        int n = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
                        for (int i = 0; i < n; ++i) {
                            ItemPacketRewriter1_13_1.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13));
                            ItemPacketRewriter1_13_1.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13));
                            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
                            if (bl) {
                                ItemPacketRewriter1_13_1.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13));
                            }
                            packetWrapper.passthrough(Types.BOOLEAN);
                            packetWrapper.passthrough(Types.INT);
                            packetWrapper.passthrough(Types.INT);
                        }
                    }
                });
            }
        });
        RecipeRewriter<ClientboundPackets1_13> recipeRewriter = new RecipeRewriter<ClientboundPackets1_13>(this.protocol){

            @Override
            protected Type<Item> itemType() {
                return Types.ITEM1_13;
            }

            @Override
            protected Type<Item[]> itemArrayType() {
                return Types.ITEM1_13_ARRAY;
            }
        };
        ((Protocol1_13To1_13_1)this.protocol).registerClientbound(ClientboundPackets1_13.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.STRING);
                String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
                recipeRewriter.handleRecipeType(packetWrapper, string);
            }
        });
    }
}

