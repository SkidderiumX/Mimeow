/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.status.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.status.INetHandlerStatusServer;

public class C01PacketPing
implements Packet<INetHandlerStatusServer> {
    private long clientTime;

    public C01PacketPing() {
    }

    public C01PacketPing(long l) {
        this.clientTime = l;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.clientTime = packetBuffer.readLong();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeLong(this.clientTime);
    }

    @Override
    public void processPacket(INetHandlerStatusServer iNetHandlerStatusServer) {
        iNetHandlerStatusServer.processPing(this);
    }

    public long getClientTime() {
        return this.clientTime;
    }
}

