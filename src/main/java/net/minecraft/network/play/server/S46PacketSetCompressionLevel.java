/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S46PacketSetCompressionLevel
implements Packet<INetHandlerPlayClient> {
    private int threshold;

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.threshold = packetBuffer.readVarIntFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.threshold);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleSetCompressionLevel(this);
    }

    public int getThreshold() {
        return this.threshold;
    }
}

