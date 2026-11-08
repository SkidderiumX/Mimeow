/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C17PacketCustomPayload
implements Packet<INetHandlerPlayServer> {
    private String channel;
    private PacketBuffer data;

    public C17PacketCustomPayload() {
    }

    public C17PacketCustomPayload(String string, PacketBuffer packetBuffer) {
        this.channel = string;
        this.data = packetBuffer;
        if (packetBuffer.writerIndex() > Short.MAX_VALUE) {
            throw new IllegalArgumentException("Payload may not be larger than 32767 bytes");
        }
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.channel = packetBuffer.readStringFromBuffer(20);
        int n = packetBuffer.readableBytes();
        if (n < 0 || n > Short.MAX_VALUE) {
            throw new IOException("Payload may not be larger than 32767 bytes");
        }
        this.data = new PacketBuffer(packetBuffer.readBytes(n));
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeString(this.channel);
        packetBuffer.writeBytes(this.data);
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processVanilla250Packet(this);
        if (this.data != null && this.data.refCnt() > 0) {
            this.data.release();
        }
    }

    public String getChannelName() {
        return this.channel;
    }

    public PacketBuffer getBufferData() {
        return this.data;
    }
}

