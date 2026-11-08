/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.protocol.shared_registration.PacketBound;
import java.util.function.Consumer;
import org.checkerframework.checker.nullness.qual.Nullable;

public record RegistrationContext<CU extends ClientboundPacketType, SU extends ServerboundPacketType>(AbstractProtocol<CU, ?, ?, SU> protocol, ProtocolVersion min, @Nullable ProtocolVersion max) {
    public <P extends AbstractProtocol<CU, ?, ?, SU>> P protocol(Class<P> clazz) {
        return (P)this.protocol;
    }

    public <P extends AbstractProtocol<CU, ?, ?, SU>> P castProtocol() {
        return (P)this.protocol;
    }

    public void clientbound(ClientboundPacketType clientboundPacketType, Consumer<CU> consumer) {
        consumer.accept(this.clientboundPacketType(clientboundPacketType));
    }

    public void clientbound(ClientboundPacketType clientboundPacketType, Consumer<CU> consumer, PacketBound ... packetBoundArray) {
        if (!this.shouldSkip(packetBoundArray)) {
            consumer.accept(this.clientboundPacketType(clientboundPacketType));
        }
    }

    public void clientboundHandler(ClientboundPacketType clientboundPacketType, PacketHandler packetHandler) {
        this.protocol.registerClientbound(this.clientboundPacketType(clientboundPacketType), packetHandler);
    }

    public void clientboundHandler(ClientboundPacketType clientboundPacketType, PacketHandler packetHandler, PacketBound ... packetBoundArray) {
        if (!this.shouldSkip(packetBoundArray)) {
            this.protocol.registerClientbound(this.clientboundPacketType(clientboundPacketType), packetHandler);
        }
    }

    public void serverbound(ServerboundPacketType serverboundPacketType, Consumer<SU> consumer) {
        consumer.accept(this.serverboundPacketType(serverboundPacketType));
    }

    public void serverbound(ServerboundPacketType serverboundPacketType, Consumer<SU> consumer, PacketBound ... packetBoundArray) {
        if (!this.shouldSkip(packetBoundArray)) {
            consumer.accept(this.serverboundPacketType(serverboundPacketType));
        }
    }

    public void serverboundHandler(ServerboundPacketType serverboundPacketType, PacketHandler packetHandler) {
        this.protocol.registerServerbound(this.serverboundPacketType(serverboundPacketType), packetHandler);
    }

    public void serverboundHandler(ServerboundPacketType serverboundPacketType, PacketHandler packetHandler, PacketBound ... packetBoundArray) {
        if (!this.shouldSkip(packetBoundArray)) {
            this.protocol.registerServerbound(this.serverboundPacketType(serverboundPacketType), packetHandler);
        }
    }

    private boolean shouldSkip(PacketBound ... packetBoundArray) {
        ProtocolVersion protocolVersion;
        if (packetBoundArray.length == 0) {
            return false;
        }
        ProtocolVersion protocolVersion2 = this.protocol.getServerVersion();
        ProtocolVersion protocolVersion3 = protocolVersion2.olderThan(protocolVersion = this.protocol.getClientVersion()) ? protocolVersion2 : protocolVersion;
        ProtocolVersion protocolVersion4 = protocolVersion2.newerThan(protocolVersion) ? protocolVersion2 : protocolVersion;
        block4: for (PacketBound packetBound : packetBoundArray) {
            switch (packetBound) {
                case ADDED_AT_MIN: {
                    if (!protocolVersion3.olderThan(this.min)) continue block4;
                    return true;
                }
                case REMOVED_AT_MAX: {
                    Preconditions.checkArgument(this.max != null, "Cannot use REMOVED_AT_MAX in an open-ended range");
                    if (!protocolVersion4.newerThanOrEqualTo(this.max)) continue block4;
                    return true;
                }
            }
        }
        return false;
    }

    public SU serverboundPacketType(ServerboundPacketType serverboundPacketType) {
        SU SU = this.protocol.getPacketTypesProvider().unmappedServerboundType(serverboundPacketType.state(), serverboundPacketType.getName());
        if (SU == null) {
            throw new IllegalArgumentException("Could not find serverbound packet type for " + String.valueOf((Object)serverboundPacketType.state()) + " " + serverboundPacketType.getName());
        }
        return SU;
    }

    public CU clientboundPacketType(ClientboundPacketType clientboundPacketType) {
        CU CU = this.protocol.getPacketTypesProvider().unmappedClientboundType(clientboundPacketType.state(), clientboundPacketType.getName());
        if (CU == null) {
            throw new IllegalArgumentException("Could not find clientbound packet type for " + String.valueOf((Object)clientboundPacketType.state()) + " " + clientboundPacketType.getName() + " in " + this.protocol.getClass().getSimpleName());
        }
        return CU;
    }
}

