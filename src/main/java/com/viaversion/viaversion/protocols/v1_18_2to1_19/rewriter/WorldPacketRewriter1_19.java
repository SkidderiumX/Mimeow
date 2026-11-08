/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter;

import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.Protocol1_18_2To1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;

public class WorldPacketRewriter1_19 {
    public static void register(Protocol1_18_2To1_19 protocol1_18_2To1_19) {
        protocol1_18_2To1_19.cancelClientbound(ClientboundPackets1_18.BLOCK_BREAK_ACK);
        protocol1_18_2To1_19.registerServerbound(ServerboundPackets1_19.SET_BEACON, packetWrapper -> {
            if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                packetWrapper.passthrough(Types.VAR_INT);
            } else {
                packetWrapper.write(Types.VAR_INT, -1);
            }
            if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                packetWrapper.passthrough(Types.VAR_INT);
            } else {
                packetWrapper.write(Types.VAR_INT, -1);
            }
        });
    }
}

