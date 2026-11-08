/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.task;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.PlayerStorage;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.connection.StorableObjectTask;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ClientVehicleStorage;
import java.util.logging.Level;

public class PlayerPacketsTickTask
extends StorableObjectTask<PlayerStorage> {
    public PlayerPacketsTickTask() {
        super(PlayerStorage.class);
    }

    @Override
    public void run(UserConnection userConnection, PlayerStorage playerStorage) {
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        if (protocolInfo.getClientState() != State.PLAY || protocolInfo.getServerState() != State.PLAY) {
            return;
        }
        Object t = userConnection.getEntityTracker(Protocol1_21_2To1_21.class);
        if (!t.hasClientEntityId()) {
            return;
        }
        try {
            if (!userConnection.has(ClientVehicleStorage.class)) {
                playerStorage.tick(userConnection);
            }
        }
        catch (Throwable throwable) {
            ViaBackwards.getPlatform().getLogger().log(Level.SEVERE, "Error while sending player input packet.", throwable);
        }
        try {
            PacketWrapper packetWrapper = PacketWrapper.create(ServerboundPackets1_21_2.CLIENT_TICK_END, userConnection);
            packetWrapper.sendToServer(Protocol1_21_2To1_21.class);
        }
        catch (Throwable throwable) {
            ViaBackwards.getPlatform().getLogger().log(Level.SEVERE, "Error while sending client tick end packet.", throwable);
        }
    }
}

