/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class S0APacketUseBed
implements Packet<INetHandlerPlayClient> {
    private int playerID;
    private BlockPos bedPos;

    public S0APacketUseBed() {
    }

    public S0APacketUseBed(EntityPlayer entityPlayer, BlockPos blockPos) {
        this.playerID = entityPlayer.getEntityId();
        this.bedPos = blockPos;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.playerID = packetBuffer.readVarIntFromBuffer();
        this.bedPos = packetBuffer.readBlockPos();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.playerID);
        packetBuffer.writeBlockPos(this.bedPos);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleUseBed(this);
    }

    public EntityPlayer getPlayer(World world2) {
        return (EntityPlayer)world2.getEntityByID(this.playerID);
    }

    public BlockPos getBedPosition() {
        return this.bedPos;
    }
}

