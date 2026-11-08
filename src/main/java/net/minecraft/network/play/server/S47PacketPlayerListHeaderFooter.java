/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.IChatComponent;

public class S47PacketPlayerListHeaderFooter
implements Packet<INetHandlerPlayClient> {
    private IChatComponent header;
    private IChatComponent footer;

    public S47PacketPlayerListHeaderFooter() {
    }

    public S47PacketPlayerListHeaderFooter(IChatComponent iChatComponent) {
        this.header = iChatComponent;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.header = packetBuffer.readChatComponent();
        this.footer = packetBuffer.readChatComponent();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeChatComponent(this.header);
        packetBuffer.writeChatComponent(this.footer);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handlePlayerListHeaderFooter(this);
    }

    public IChatComponent getHeader() {
        return this.header;
    }

    public IChatComponent getFooter() {
        return this.footer;
    }
}

