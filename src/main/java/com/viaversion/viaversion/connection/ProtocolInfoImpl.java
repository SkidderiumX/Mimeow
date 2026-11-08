/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.protocol.ProtocolPipeline;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.UUID;

public class ProtocolInfoImpl
implements ProtocolInfo {
    private State clientState = State.HANDSHAKE;
    private State serverState = State.HANDSHAKE;
    private ProtocolVersion serverProtocolVersion = ProtocolVersion.unknown;
    private ProtocolVersion protocolVersion = ProtocolVersion.unknown;
    private String username;
    private UUID uuid;
    private ProtocolPipeline pipeline;
    private boolean compressionEnabled;

    @Override
    public State getClientState() {
        return this.clientState;
    }

    @Override
    public void setClientState(State state) {
        if (Via.getManager().debugHandler().enabled()) {
            Via.getPlatform().getLogger().info("Client state changed from " + String.valueOf((Object)this.clientState) + " to " + String.valueOf((Object)state) + " for " + String.valueOf(this.uuid));
        }
        this.clientState = state;
    }

    @Override
    public State getServerState() {
        return this.serverState;
    }

    @Override
    public void setServerState(State state) {
        if (Via.getManager().debugHandler().enabled()) {
            Via.getPlatform().getLogger().info("Server state changed from " + String.valueOf((Object)this.serverState) + " to " + String.valueOf((Object)state) + " for " + String.valueOf(this.uuid));
        }
        this.serverState = state;
    }

    @Override
    public ProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    @Override
    public ProtocolVersion serverProtocolVersion() {
        return this.serverProtocolVersion;
    }

    @Override
    public void setServerProtocolVersion(ProtocolVersion protocolVersion) {
        this.serverProtocolVersion = protocolVersion;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String string) {
        this.username = string;
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public void setUuid(UUID uUID) {
        this.uuid = uUID;
    }

    @Override
    public boolean compressionEnabled() {
        return this.compressionEnabled;
    }

    @Override
    public void setCompressionEnabled(boolean bl) {
        this.compressionEnabled = bl;
    }

    @Override
    public ProtocolPipeline getPipeline() {
        return this.pipeline;
    }

    @Override
    public void setPipeline(ProtocolPipeline protocolPipeline) {
        this.pipeline = protocolPipeline;
    }

    public String toString() {
        return "ProtocolInfo{clientState=" + String.valueOf((Object)this.clientState) + ", serverState=" + String.valueOf((Object)this.serverState) + ", protocolVersion=" + String.valueOf(this.protocolVersion) + ", serverProtocolVersion=" + String.valueOf(this.serverProtocolVersion) + ", username='" + this.username + "', uuid=" + String.valueOf(this.uuid) + "}";
    }
}

