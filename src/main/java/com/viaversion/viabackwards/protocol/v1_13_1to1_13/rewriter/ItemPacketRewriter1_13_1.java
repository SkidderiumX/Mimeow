/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13_1to1_13.rewriter;

import com.viaversion.viabackwards.protocol.v1_13_1to1_13.Protocol1_13_1To1_13;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.rewriter.ItemRewriter;

public class ItemPacketRewriter1_13_1
extends ItemRewriter<ClientboundPackets1_13, ServerboundPackets1_13, Protocol1_13_1To1_13> {
    public ItemPacketRewriter1_13_1(Protocol1_13_1To1_13 protocol1_13_1To1_13) {
        super(protocol1_13_1To1_13, Types.ITEM1_13, Types.ITEM1_13_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_13_1To1_13)this.protocol).registerClientbound(ClientboundPackets1_13.CUSTOM_PAYLOAD, packetWrapper -> {
            String string = packetWrapper.passthrough(Types.STRING);
            if (string.equals("minecraft:trader_list")) {
                packetWrapper.passthrough(Types.INT);
                int n = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
                for (int i = 0; i < n; ++i) {
                    this.passthroughClientboundItem(packetWrapper);
                    this.passthroughClientboundItem(packetWrapper);
                    boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
                    if (bl) {
                        this.passthroughClientboundItem(packetWrapper);
                    }
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.passthrough(Types.INT);
                    packetWrapper.passthrough(Types.INT);
                }
            }
        });
    }
}

