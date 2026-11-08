/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.task;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.LevitationStorage;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import java.util.logging.Level;

public class LevitationUpdateTask
implements Runnable {
    @Override
    public void run() {
        if (!ViaRewind.getConfig().emulateLevitationEffect()) {
            return;
        }
        for (UserConnection userConnection : Via.getManager().getConnectionManager().getConnections()) {
            LevitationStorage levitationStorage = userConnection.get(LevitationStorage.class);
            if (levitationStorage == null || !levitationStorage.isActive()) continue;
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_8.SET_ENTITY_MOTION, userConnection);
            packetWrapper.write(Types.VAR_INT, userConnection.getEntityTracker(Protocol1_9To1_8.class).clientEntityId());
            packetWrapper.write(Types.SHORT, (short)0);
            packetWrapper.write(Types.SHORT, (short)((levitationStorage.getAmplifier() + 1) * 360));
            packetWrapper.write(Types.SHORT, (short)0);
            try {
                packetWrapper.scheduleSend(Protocol1_9To1_8.class);
            }
            catch (Exception exception) {
                ViaRewind.getPlatform().getLogger().log(Level.SEVERE, "Failed to send levitation packet", exception);
            }
        }
    }
}

