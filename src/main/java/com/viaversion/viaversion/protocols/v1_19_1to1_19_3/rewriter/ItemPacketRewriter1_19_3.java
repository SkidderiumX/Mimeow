/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.Protocol1_19_1To1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;

public class ItemPacketRewriter1_19_3
extends ItemRewriter<ClientboundPackets1_19_1, ServerboundPackets1_19_3, Protocol1_19_1To1_19_3> {
    private static final int MISC_CRAFTING_BOOK_CATEGORY = 0;

    public ItemPacketRewriter1_19_3(Protocol1_19_1To1_19_3 protocol1_19_1To1_19_3) {
        super(protocol1_19_1To1_19_3, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        RecipeRewriter recipeRewriter = new RecipeRewriter(this.protocol);
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            block27: for (int i = 0; i < n; ++i) {
                String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
                packetWrapper.passthrough(Types.STRING);
                switch (string) {
                    case "crafting_shapeless": {
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.write(Types.VAR_INT, 0);
                        int n2 = packetWrapper.passthrough(Types.VAR_INT);
                        for (int j = 0; j < n2; ++j) {
                            Item[] itemArray;
                            for (Item item : itemArray = packetWrapper.passthrough(Types.ITEM1_13_2_ARRAY)) {
                                this.handleItemToClient(packetWrapper.user(), item);
                            }
                        }
                        this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                        continue block27;
                    }
                    case "crafting_shaped": {
                        int n3 = packetWrapper.passthrough(Types.VAR_INT) * packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.write(Types.VAR_INT, 0);
                        for (int j = 0; j < n3; ++j) {
                            Item[] itemArray;
                            for (Item item : itemArray = packetWrapper.passthrough(Types.ITEM1_13_2_ARRAY)) {
                                this.handleItemToClient(packetWrapper.user(), item);
                            }
                        }
                        this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                        continue block27;
                    }
                    case "smelting": 
                    case "campfire_cooking": 
                    case "blasting": 
                    case "smoking": {
                        Item[] itemArray;
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.write(Types.VAR_INT, 0);
                        for (Item item : itemArray = packetWrapper.passthrough(Types.ITEM1_13_2_ARRAY)) {
                            this.handleItemToClient(packetWrapper.user(), item);
                        }
                        this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.VAR_INT);
                        continue block27;
                    }
                    case "crafting_special_armordye": 
                    case "crafting_special_bookcloning": 
                    case "crafting_special_mapcloning": 
                    case "crafting_special_mapextending": 
                    case "crafting_special_firework_rocket": 
                    case "crafting_special_firework_star": 
                    case "crafting_special_firework_star_fade": 
                    case "crafting_special_tippedarrow": 
                    case "crafting_special_bannerduplicate": 
                    case "crafting_special_shielddecoration": 
                    case "crafting_special_shulkerboxcoloring": 
                    case "crafting_special_suspiciousstew": 
                    case "crafting_special_repairitem": {
                        packetWrapper.write(Types.VAR_INT, 0);
                        continue block27;
                    }
                    default: {
                        recipeRewriter.handleRecipeType(packetWrapper, string);
                    }
                }
            }
        });
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT, Types.DOUBLE);
            }
        });
    }
}

