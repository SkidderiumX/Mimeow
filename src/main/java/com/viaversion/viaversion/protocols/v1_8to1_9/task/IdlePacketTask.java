/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.task;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.MovementTransmitterProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.MovementTracker;

public class IdlePacketTask
implements Runnable {
    @Override
    public void run() {
        for (UserConnection userConnection : Via.getManager().getConnectionManager().getConnections()) {
            long l;
            MovementTracker movementTracker;
            if (!userConnection.isActive() || (movementTracker = userConnection.get(MovementTracker.class)) == null || (l = movementTracker.getNextIdlePacket()) > System.currentTimeMillis()) continue;
            Via.getManager().getProviders().get(MovementTransmitterProvider.class).sendPlayer(userConnection);
        }
    }
}

