/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_14_3to1_14_2;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;

public class Protocol1_14_3To1_14_2
extends BackwardsProtocol<ClientboundPackets1_14, ClientboundPackets1_14, ServerboundPackets1_14, ServerboundPackets1_14> {
    public Protocol1_14_3To1_14_2() {
        super(ClientboundPackets1_14.class, ClientboundPackets1_14.class, ServerboundPackets1_14.class, ServerboundPackets1_14.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_14.MERCHANT_OFFERS, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.ITEM1_13_2);
                packetWrapper.passthrough(Types.ITEM1_13_2);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.ITEM1_13_2);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.FLOAT);
            }
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.read(Types.BOOLEAN);
        });
        RecipeRewriter<ClientboundPackets1_14> recipeRewriter = new RecipeRewriter<ClientboundPackets1_14>(this);
        this.registerClientbound(ClientboundPackets1_14.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                String string2 = Key.stripMinecraftNamespace(string);
                String string3 = packetWrapper.read(Types.STRING);
                if (string2.equals("crafting_special_repairitem")) {
                    ++n2;
                    continue;
                }
                packetWrapper.write(Types.STRING, string);
                packetWrapper.write(Types.STRING, string3);
                recipeRewriter.handleRecipeType(packetWrapper, string2);
            }
            packetWrapper.set(Types.VAR_INT, 0, n - n2);
        });
    }
}

