/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

public class S28PacketEffect
implements Packet<INetHandlerPlayClient> {
    private int soundType;
    private BlockPos soundPos;
    private int soundData;
    private boolean serverWide;

    public S28PacketEffect() {
    }

    public S28PacketEffect(int n, BlockPos blockPos, int n2, boolean bl) {
        this.soundType = n;
        this.soundPos = blockPos;
        this.soundData = n2;
        this.serverWide = bl;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.soundType = packetBuffer.readInt();
        this.soundPos = packetBuffer.readBlockPos();
        this.soundData = packetBuffer.readInt();
        this.serverWide = packetBuffer.readBoolean();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeInt(this.soundType);
        packetBuffer.writeBlockPos(this.soundPos);
        packetBuffer.writeInt(this.soundData);
        packetBuffer.writeBoolean(this.serverWide);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleEffect(this);
    }

    public boolean isSoundServerwide() {
        return this.serverWide;
    }

    public int getSoundType() {
        return this.soundType;
    }

    public int getSoundData() {
        return this.soundData;
    }

    public BlockPos getSoundPos() {
        return this.soundPos;
    }
}

