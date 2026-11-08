/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C09PacketHeldItemChange
implements Packet<INetHandlerPlayServer> {
    private int slotId;

    public C09PacketHeldItemChange() {
    }

    public C09PacketHeldItemChange(int n) {
        this.slotId = n;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.slotId = packetBuffer.readShort();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeShort(this.slotId);
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processHeldItemChange(this);
    }

    public int getSlotId() {
        return this.slotId;
    }
}

