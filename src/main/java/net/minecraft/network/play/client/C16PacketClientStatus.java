/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C16PacketClientStatus
implements Packet<INetHandlerPlayServer> {
    private EnumState status;

    public C16PacketClientStatus() {
    }

    public C16PacketClientStatus(EnumState enumState) {
        this.status = enumState;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.status = packetBuffer.readEnumValue(EnumState.class);
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeEnumValue(this.status);
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processClientStatus(this);
    }

    public EnumState getStatus() {
        return this.status;
    }

    public static enum EnumState {
        PERFORM_RESPAWN,
        REQUEST_STATS,
        OPEN_INVENTORY_ACHIEVEMENT;

    }
}

