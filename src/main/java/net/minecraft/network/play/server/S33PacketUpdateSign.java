/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class S33PacketUpdateSign
implements Packet<INetHandlerPlayClient> {
    private World world;
    private BlockPos blockPos;
    private IChatComponent[] lines;

    public S33PacketUpdateSign() {
    }

    public S33PacketUpdateSign(World world2, BlockPos blockPos, IChatComponent[] iChatComponentArray) {
        this.world = world2;
        this.blockPos = blockPos;
        this.lines = new IChatComponent[]{iChatComponentArray[0], iChatComponentArray[1], iChatComponentArray[2], iChatComponentArray[3]};
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.blockPos = packetBuffer.readBlockPos();
        this.lines = new IChatComponent[4];
        for (int i = 0; i < 4; ++i) {
            this.lines[i] = packetBuffer.readChatComponent();
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeBlockPos(this.blockPos);
        for (int i = 0; i < 4; ++i) {
            packetBuffer.writeChatComponent(this.lines[i]);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleUpdateSign(this);
    }

    public BlockPos getPos() {
        return this.blockPos;
    }

    public IChatComponent[] getLines() {
        return this.lines;
    }
}

