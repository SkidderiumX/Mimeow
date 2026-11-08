/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.packet.mapping;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.mapping.PacketMapping;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PacketIdMapping
implements PacketMapping {
    private final int mappedPacketId;
    private PacketHandler handler;

    PacketIdMapping(int n, @Nullable PacketHandler packetHandler) {
        this.mappedPacketId = n;
        this.handler = packetHandler;
    }

    @Override
    public void applyType(PacketWrapper packetWrapper) {
        packetWrapper.setId(this.mappedPacketId);
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

