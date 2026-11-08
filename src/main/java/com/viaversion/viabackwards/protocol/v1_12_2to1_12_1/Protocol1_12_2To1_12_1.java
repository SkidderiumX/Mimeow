/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12_2to1_12_1;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.protocol.v1_12_2to1_12_1.storage.KeepAliveTracker;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ServerboundPackets1_12_1;

public class Protocol1_12_2To1_12_1
extends BackwardsProtocol<ClientboundPackets1_12_1, ClientboundPackets1_12_1, ServerboundPackets1_12_1, ServerboundPackets1_12_1> {
    public Protocol1_12_2To1_12_1() {
        super(ClientboundPackets1_12_1.class, ClientboundPackets1_12_1.class, ServerboundPackets1_12_1.class, ServerboundPackets1_12_1.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_12_1.KEEP_ALIVE, packetWrapper -> {
            long l = packetWrapper.read(Types.LONG);
            int n = packetWrapper.user().get(KeepAliveTracker.class).track(l);
            packetWrapper.write(Types.VAR_INT, n);
        });
        this.registerServerbound(ServerboundPackets1_12_1.KEEP_ALIVE, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            Long l = packetWrapper.user().get(KeepAliveTracker.class).consume(n);
            if (l == null) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.LONG, l);
        });
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new KeepAliveTracker());
    }
}

