/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S30PacketWindowItems
implements Packet<INetHandlerPlayClient> {
    private int windowId;
    private ItemStack[] itemStacks;

    public S30PacketWindowItems() {
    }

    public S30PacketWindowItems(int n, List<ItemStack> list) {
        this.windowId = n;
        this.itemStacks = new ItemStack[list.size()];
        for (int i = 0; i < this.itemStacks.length; ++i) {
            ItemStack itemStack = list.get(i);
            this.itemStacks[i] = itemStack == null ? null : itemStack.copy();
        }
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.windowId = packetBuffer.readUnsignedByte();
        int n = packetBuffer.readShort();
        this.itemStacks = new ItemStack[n];
        for (int i = 0; i < n; ++i) {
            this.itemStacks[i] = packetBuffer.readItemStackFromBuffer();
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeByte(this.windowId);
        packetBuffer.writeShort(this.itemStacks.length);
        for (ItemStack itemStack : this.itemStacks) {
            packetBuffer.writeItemStackToBuffer(itemStack);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleWindowItems(this);
    }

    public int func_148911_c() {
        return this.windowId;
    }

    public ItemStack[] getItemStacks() {
        return this.itemStacks;
    }
}

