/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.debug;

import com.viaversion.viaversion.api.debug.DebugHandler;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import java.util.HashSet;
import java.util.Set;

public class DebugHandlerImpl
implements DebugHandler {
    private final Set<String> packetTypesToLog = new HashSet<String>();
    private final Set<PacketType> clientboundPacketsToLog = new HashSet<PacketType>();
    private final Set<PacketType> serverboundPacketsToLog = new HashSet<PacketType>();
    private boolean logPrePacketTransform = true;
    private boolean logPostPacketTransform;
    private boolean enabled;

    @Override
    public boolean enabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    @Override
    public void addPacketTypeNameToLog(String string) {
        this.packetTypesToLog.add(string);
    }

    @Override
    public void addPacketTypeToLog(PacketType packetType) {
        (packetType.direction() == Direction.SERVERBOUND ? this.serverboundPacketsToLog : this.clientboundPacketsToLog).add(packetType);
    }

    @Override
    public boolean removePacketTypeNameToLog(String string) {
        return this.packetTypesToLog.remove(string);
    }

    @Override
    public boolean removePacketTypeToLog(PacketType packetType) {
        return (packetType.direction() == Direction.SERVERBOUND ? this.serverboundPacketsToLog : this.clientboundPacketsToLog).remove(packetType);
    }

    @Override
    public void clearPacketTypesToLog() {
        this.packetTypesToLog.clear();
        this.serverboundPacketsToLog.clear();
        this.clientboundPacketsToLog.clear();
    }

    @Override
    public boolean logPrePacketTransform() {
        return this.logPrePacketTransform;
    }

    @Override
    public void setLogPrePacketTransform(boolean bl) {
        this.logPrePacketTransform = bl;
    }

    @Override
    public boolean logPostPacketTransform() {
        return this.logPostPacketTransform;
    }

    @Override
    public void setLogPostPacketTransform(boolean bl) {
        this.logPostPacketTransform = bl;
    }

    @Override
    public boolean shouldLog(PacketWrapper packetWrapper, Direction direction) {
        Set<PacketType> set;
        if (this.packetTypesToLog.isEmpty() && this.serverboundPacketsToLog.isEmpty() && this.clientboundPacketsToLog.isEmpty()) {
            return true;
        }
        Set<PacketType> set2 = set = direction == Direction.SERVERBOUND ? this.serverboundPacketsToLog : this.clientboundPacketsToLog;
        if (packetWrapper.getPacketType() != null) {
            return this.packetTypesToLog.contains(packetWrapper.getPacketType().getName()) || set.contains(packetWrapper.getPacketType());
        }
        State state = packetWrapper.user().getProtocolInfo().getState(direction);
        for (PacketType packetType : set) {
            if (packetType.getId() != packetWrapper.getId() || packetType.state() != state) continue;
            return true;
        }
        return false;
    }
}

