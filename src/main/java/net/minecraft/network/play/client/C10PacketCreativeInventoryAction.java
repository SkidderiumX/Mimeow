/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C10PacketCreativeInventoryAction
implements Packet<INetHandlerPlayServer> {
    private int slotId;
    private ItemStack stack;

    public C10PacketCreativeInventoryAction() {
    }

    public C10PacketCreativeInventoryAction(int n, ItemStack itemStack) {
        this.slotId = n;
        this.stack = itemStack != null ? itemStack.copy() : null;
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processCreativeInventoryAction(this);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.slotId = packetBuffer.readShort();
        this.stack = packetBuffer.readItemStackFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeShort(this.slotId);
        packetBuffer.writeItemStackToBuffer(this.stack);
    }

    public int getSlotId() {
        return this.slotId;
    }

    public ItemStack getStack() {
        return this.stack;
    }
}

