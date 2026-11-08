/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_1to1_13_2;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_1to1_13_2.rewriter.EntityPacketRewriter1_13_2;
import com.viaversion.viaversion.protocols.v1_13_1to1_13_2.rewriter.ItemPacketRewriter1_13_2;
import com.viaversion.viaversion.protocols.v1_13_1to1_13_2.rewriter.WorldPacketRewriter1_13_2;

public class Protocol1_13_1To1_13_2
extends AbstractProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13> {
    public Protocol1_13_1To1_13_2() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
    }

    @Override
    protected void registerPackets() {
        ItemPacketRewriter1_13_2.register(this);
        WorldPacketRewriter1_13_2.register(this);
        EntityPacketRewriter1_13_2.register(this);
        this.registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.ITEM1_13_2, Types.ITEM1_13);
            }
        });
        this.registerClientbound(ClientboundPackets1_13.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.COMPONENT);
                    packetWrapper.passthrough(Types.COMPONENT);
                    Item item = packetWrapper.read(Types.ITEM1_13);
                    packetWrapper.write(Types.ITEM1_13_2, item);
                    packetWrapper.passthrough(Types.VAR_INT);
                    n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                packetWrapper.passthrough(Types.STRING_ARRAY);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (n2 = 0; n2 < n3; ++n2) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
            }
        });
    }
}

