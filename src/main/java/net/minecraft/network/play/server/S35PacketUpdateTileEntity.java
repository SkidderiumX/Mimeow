/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

public class S35PacketUpdateTileEntity
implements Packet<INetHandlerPlayClient> {
    private BlockPos blockPos;
    private int metadata;
    private NBTTagCompound nbt;

    public S35PacketUpdateTileEntity() {
    }

    public S35PacketUpdateTileEntity(BlockPos blockPos, int n, NBTTagCompound nBTTagCompound) {
        this.blockPos = blockPos;
        this.metadata = n;
        this.nbt = nBTTagCompound;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.blockPos = packetBuffer.readBlockPos();
        this.metadata = packetBuffer.readUnsignedByte();
        this.nbt = packetBuffer.readNBTTagCompoundFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeBlockPos(this.blockPos);
        packetBuffer.writeByte((byte)this.metadata);
        packetBuffer.writeNBTTagCompoundToBuffer(this.nbt);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleUpdateTileEntity(this);
    }

    public BlockPos getPos() {
        return this.blockPos;
    }

    public int getTileEntityType() {
        return this.metadata;
    }

    public NBTTagCompound getNbtCompound() {
        return this.nbt;
    }
}

