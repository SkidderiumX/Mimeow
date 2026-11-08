/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.login.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginClient;

public class S03PacketEnableCompression
implements Packet<INetHandlerLoginClient> {
    private int compressionTreshold;

    public S03PacketEnableCompression() {
    }

    public S03PacketEnableCompression(int n) {
        this.compressionTreshold = n;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.compressionTreshold = packetBuffer.readVarIntFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.compressionTreshold);
    }

    @Override
    public void processPacket(INetHandlerLoginClient iNetHandlerLoginClient) {
        iNetHandlerLoginClient.handleEnableCompression(this);
    }

    public int getCompressionTreshold() {
        return this.compressionTreshold;
    }
}

