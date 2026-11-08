/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S04PacketEntityEquipment
implements Packet<INetHandlerPlayClient> {
    private int entityID;
    private int equipmentSlot;
    private ItemStack itemStack;

    public S04PacketEntityEquipment() {
    }

    public S04PacketEntityEquipment(int n, int n2, ItemStack itemStack) {
        this.entityID = n;
        this.equipmentSlot = n2;
        this.itemStack = itemStack == null ? null : itemStack.copy();
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.entityID = packetBuffer.readVarIntFromBuffer();
        this.equipmentSlot = packetBuffer.readShort();
        this.itemStack = packetBuffer.readItemStackFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.entityID);
        packetBuffer.writeShort(this.equipmentSlot);
        packetBuffer.writeItemStackToBuffer(this.itemStack);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleEntityEquipment(this);
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public int getEntityID() {
        return this.entityID;
    }

    public int getEquipmentSlot() {
        return this.equipmentSlot;
    }
}

