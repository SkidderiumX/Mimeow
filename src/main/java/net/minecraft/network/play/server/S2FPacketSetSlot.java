/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S2FPacketSetSlot
implements Packet<INetHandlerPlayClient> {
    private int windowId;
    private int slot;
    private ItemStack item;

    public S2FPacketSetSlot() {
    }

    public S2FPacketSetSlot(int n, int n2, ItemStack itemStack) {
        this.windowId = n;
        this.slot = n2;
        this.item = itemStack == null ? null : itemStack.copy();
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleSetSlot(this);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.windowId = packetBuffer.readByte();
        this.slot = packetBuffer.readShort();
        this.item = packetBuffer.readItemStackFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeByte(this.windowId);
        packetBuffer.writeShort(this.slot);
        packetBuffer.writeItemStackToBuffer(this.item);
    }

    public int func_149175_c() {
        return this.windowId;
    }

    public int func_149173_d() {
        return this.slot;
    }

    public ItemStack func_149174_e() {
        return this.item;
    }
}

