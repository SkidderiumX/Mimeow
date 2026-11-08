/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.rewriter;

import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.Protocol1_19_4To1_19_3;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter.RecipeRewriter1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;

public class BlockItemPacketRewriter1_19_4
extends BackwardsItemRewriter<ClientboundPackets1_19_4, ServerboundPackets1_19_3, Protocol1_19_4To1_19_3> {
    public BlockItemPacketRewriter1_19_4(Protocol1_19_4To1_19_3 protocol1_19_4To1_19_3) {
        super(protocol1_19_4To1_19_3, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_19_4To1_19_3)this.protocol).replaceClientbound(ClientboundPackets1_19_4.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.COMPONENT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n == 21) {
                        packetWrapper.cancel();
                    } else if (n > 21) {
                        packetWrapper.set(Types.VAR_INT, 1, n - 1);
                    }
                    ((ComponentRewriterBase)((Protocol1_19_4To1_19_3)BlockItemPacketRewriter1_19_4.this.protocol).getComponentRewriter()).processText(packetWrapper.user(), packetWrapper.get(Types.COMPONENT, 0));
                });
            }
        });
        RecipeRewriter1_19_3<ClientboundPackets1_19_4> recipeRewriter1_19_3 = new RecipeRewriter1_19_3<ClientboundPackets1_19_4>(this.protocol){

            @Override
            public void handleCraftingShaped(PacketWrapper packetWrapper) {
                int n = packetWrapper.passthrough(Types.VAR_INT) * packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.VAR_INT);
                for (int i = 0; i < n; ++i) {
                    this.handleIngredient(packetWrapper);
                }
                this.rewrite(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                packetWrapper.read(Types.BOOLEAN);
            }
        };
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.UPDATE_RECIPES, packetWrapper -> {
            int n;
            int n2 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                String string2 = Key.stripMinecraftNamespace(string);
                if (string2.equals("smithing_transform") || string2.equals("smithing_trim")) {
                    --n2;
                    packetWrapper.read(Types.STRING);
                    packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                    packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                    packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                    if (!string2.equals("smithing_transform")) continue;
                    packetWrapper.read(Types.ITEM1_13_2);
                    continue;
                }
                if (string2.equals("crafting_decorated_pot")) {
                    --n2;
                    packetWrapper.read(Types.STRING);
                    packetWrapper.read(Types.VAR_INT);
                    continue;
                }
                packetWrapper.write(Types.STRING, string);
                packetWrapper.passthrough(Types.STRING);
                recipeRewriter1_19_3.handleRecipeType(packetWrapper, string2);
            }
            packetWrapper.set(Types.VAR_INT, 0, n2);
        });
    }
}

