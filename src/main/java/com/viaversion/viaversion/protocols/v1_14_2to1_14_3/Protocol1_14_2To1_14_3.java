/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_14_2to1_14_3;

import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;

public class Protocol1_14_2To1_14_3
extends AbstractProtocol<ClientboundPackets1_14, ClientboundPackets1_14, ServerboundPackets1_14, ServerboundPackets1_14> {
    public Protocol1_14_2To1_14_3() {
        super(ClientboundPackets1_14.class, ClientboundPackets1_14.class, null, null);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_14.MERCHANT_OFFERS, packetWrapper -> {
            int n;
            packetWrapper.passthrough(Types.VAR_INT);
            int n2 = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
            for (n = 0; n < n2; ++n) {
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
            n = packetWrapper.passthrough(Types.BOOLEAN).booleanValue() ? 1 : 0;
            packetWrapper.write(Types.BOOLEAN, n != 0);
        });
    }
}

