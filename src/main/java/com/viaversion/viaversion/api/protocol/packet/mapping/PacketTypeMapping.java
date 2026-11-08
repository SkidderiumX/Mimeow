/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.packet.mapping;

import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.mapping.PacketMapping;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PacketTypeMapping
implements PacketMapping {
    private final PacketType mappedPacketType;
    private PacketHandler handler;

    PacketTypeMapping(@Nullable PacketType packetType, @Nullable PacketHandler packetHandler) {
        this.mappedPacketType = packetType;
        this.handler = packetHandler;
    }

    @Override
    public void applyType(PacketWrapper packetWrapper) {
        if (this.mappedPacketType != null) {
            packetWrapper.setPacketType(this.mappedPacketType);
        }
    }

    @Override
    public void appendHandler(PacketHandler packetHandler) {
        this.handler = this.handler == null ? packetHandler : this.handler.then(packetHandler);
    }

    @Override
    public void setHandler(@Nullable PacketHandler packetHandler) {
        this.handler = packetHandler;
    }

    @Override
    public @Nullable PacketHandler handler() {
        return this.handler;
    }
}

