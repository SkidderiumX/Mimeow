/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.handshake.client;

import java.io.IOException;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.handshake.INetHandlerHandshakeServer;

public class C00Handshake
implements Packet<INetHandlerHandshakeServer> {
    private int protocolVersion;
    private String ip;
    private int port;
    private EnumConnectionState requestedState;

    public C00Handshake() {
    }

    public C00Handshake(int n, String string, int n2, EnumConnectionState enumConnectionState) {
        this.protocolVersion = n;
        this.ip = string;
        this.port = n2;
        this.requestedState = enumConnectionState;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.protocolVersion = packetBuffer.readVarIntFromBuffer();
        this.ip = packetBuffer.readStringFromBuffer(255);
        this.port = packetBuffer.readUnsignedShort();
        this.requestedState = EnumConnectionState.getById(packetBuffer.readVarIntFromBuffer());
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.protocolVersion);
        packetBuffer.writeString(this.ip);
        packetBuffer.writeShort(this.port);
        packetBuffer.writeVarIntToBuffer(this.requestedState.getId());
    }

    @Override
    public void processPacket(INetHandlerHandshakeServer iNetHandlerHandshakeServer) {
        iNetHandlerHandshakeServer.processHandshake(this);
    }

    public EnumConnectionState getRequestedState() {
        return this.requestedState;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }
}

