/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import x.oc4e1b577a95;

public class S2EPacketCloseWindow
implements Packet<INetHandlerPlayClient> {
    private int windowId;

    public S2EPacketCloseWindow() {
    }

    public S2EPacketCloseWindow(int n) {
        this.windowId = n;
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        if (oc4e1b577a95.f() && Minecraft.getMinecraft().currentScreen instanceof GuiChat) {
            return;
        }
        iNetHandlerPlayClient.handleCloseWindow(this);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.windowId = packetBuffer.readUnsignedByte();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeByte(this.windowId);
    }
}

