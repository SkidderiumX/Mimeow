/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S3APacketTabComplete
implements Packet<INetHandlerPlayClient> {
    private String[] matches;

    public S3APacketTabComplete() {
    }

    public S3APacketTabComplete(String[] stringArray) {
        this.matches = stringArray;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.matches = new String[packetBuffer.readVarIntFromBuffer()];
        for (int i = 0; i < this.matches.length; ++i) {
            this.matches[i] = packetBuffer.readStringFromBuffer(Short.MAX_VALUE);
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.matches.length);
        for (String string : this.matches) {
            packetBuffer.writeString(string);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleTabComplete(this);
    }

    public String[] func_149630_c() {
        return this.matches;
    }
}

