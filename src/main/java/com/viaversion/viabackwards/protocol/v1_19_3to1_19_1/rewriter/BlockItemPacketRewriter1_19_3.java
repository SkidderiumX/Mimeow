/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.rewriter;

import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.Protocol1_19_3To1_19_1;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ServerboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;

public class BlockItemPacketRewriter1_19_3
extends BackwardsItemRewriter<ClientboundPackets1_19_3, ServerboundPackets1_19_1, Protocol1_19_3To1_19_1> {
    public BlockItemPacketRewriter1_19_3(Protocol1_19_3To1_19_1 protocol1_19_3To1_19_1) {
        super(protocol1_19_3To1_19_1, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_3.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE, Types.FLOAT);
                this.map(Types.DOUBLE, Types.FLOAT);
                this.map(Types.DOUBLE, Types.FLOAT);
            }
        });
        RecipeRewriter recipeRewriter = new RecipeRewriter(this.protocol);
        ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_3.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            block27: for (int i = 0; i < n; ++i) {
                String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
                packetWrapper.passthrough(Types.STRING);
                switch (string) {
                    case "crafting_shapeless": {
                        int n2;
                        Item[] itemArray;
                        int n3;
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.read(Types.VAR_INT);
                        int n4 = packetWrapper.passthrough(Types.VAR_INT);
                        for (n3 = 0; n3 < n4; ++n3) {
                            itemArray = packetWrapper.passthrough(Types.ITEM1_13_2_ARRAY);
                            for (n2 = 0; n2 < itemArray.length; ++n2) {
                                itemArray[n2] = this.handleItemToClient(packetWrapper.user(), itemArray[n2]);
                            }
                        }
                        this.passthroughClientboundItem(packetWrapper);
                        continue block27;
                    }
                    case "crafting_shaped": {
                        int n2;
                        Item[] itemArray;
                        int n3;
                        int n5 = packetWrapper.passthrough(Types.VAR_INT) * packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.read(Types.VAR_INT);
                        for (n3 = 0; n3 < n5; ++n3) {
                            itemArray = packetWrapper.passthrough(Types.ITEM1_13_2_ARRAY);
                            for (n2 = 0; n2 < itemArray.length; ++n2) {
                                itemArray[n2] = this.handleItemToClient(packetWrapper.user(), itemArray[n2]);
                            }
                        }
                        this.passthroughClientboundItem(packetWrapper);
                        continue block27;
                    }
                    case "smelting": 
                    case "campfire_cooking": 
                    case "blasting": 
                    case "smoking": {
                        int n3;
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.read(Types.VAR_INT);
                        Item[] itemArray = packetWrapper.passthrough(Types.ITEM1_13_2_ARRAY);
                        for (n3 = 0; n3 < itemArray.length; ++n3) {
                            itemArray[n3] = this.handleItemToClient(packetWrapper.user(), itemArray[n3]);
                        }
                        this.passthroughClientboundItem(packetWrapper);
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
                        packetWrapper.read(Types.VAR_INT);
                        continue block27;
                    }
                    default: {
                        recipeRewriter.handleRecipeType(packetWrapper, string);
                    }
                }
            }
        });
    }
}

