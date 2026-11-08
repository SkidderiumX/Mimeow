/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ViaListener {
    protected final Class<? extends Protocol> requiredPipeline;
    private boolean registered;

    protected ViaListener(Class<? extends Protocol> clazz) {
        this.requiredPipeline = clazz;
    }

    protected @Nullable UserConnection getUserConnection(UUID uUID) {
        return Via.getManager().getConnectionManager().getServerConnection(uUID);
    }

    protected boolean isOnPipe(UUID uUID) {
        return this.isOnPipe(this.getUserConnection(uUID));
    }

    protected boolean isOnPipe(UserConnection userConnection) {
        return userConnection != null && (this.requiredPipeline == null || userConnection.getProtocolInfo().getPipeline().contains(this.requiredPipeline));
    }

    public abstract void register();

    protected boolean isRegistered() {
        return this.registered;
    }

    protected void setRegistered(boolean bl) {
        this.registered = bl;
    }
}

