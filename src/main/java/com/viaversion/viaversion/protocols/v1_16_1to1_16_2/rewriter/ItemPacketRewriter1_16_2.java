/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_1to1_16_2.rewriter;

import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;

public class ItemPacketRewriter1_16_2
extends ItemRewriter<ClientboundPackets1_16, ServerboundPackets1_16_2, Protocol1_16_1To1_16_2> {
    public ItemPacketRewriter1_16_2(Protocol1_16_1To1_16_2 protocol1_16_1To1_16_2) {
        super(protocol1_16_1To1_16_2, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_16_1To1_16_2)this.protocol).registerClientbound(ClientboundPackets1_16.RECIPE, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.write(Types.BOOLEAN, false);
            packetWrapper.write(Types.BOOLEAN, false);
            packetWrapper.write(Types.BOOLEAN, false);
            packetWrapper.write(Types.BOOLEAN, false);
        });
        new RecipeRewriter<ClientboundPackets1_16>(this.protocol).register(ClientboundPackets1_16.UPDATE_RECIPES);
        ((Protocol1_16_1To1_16_2)this.protocol).registerServerbound(ServerboundPackets1_16_2.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
    }
}

