/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import x.oc4e1b577a95;

public class C01PacketChatMessage
implements Packet<INetHandlerPlayServer> {
    private String message;

    public C01PacketChatMessage() {
    }

    public C01PacketChatMessage(String string) {
        int n;
        int n2 = n = oc4e1b577a95.\u041a() ? 256 : 100;
        if (string.length() > n) {
            string = string.substring(0, n);
        }
        this.message = string;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        int n = oc4e1b577a95.\u041a() ? 256 : 100;
        this.message = packetBuffer.readStringFromBuffer(n);
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeString(this.message);
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processChatMessage(this);
    }

    public String getMessage() {
        return this.message;
    }
}

