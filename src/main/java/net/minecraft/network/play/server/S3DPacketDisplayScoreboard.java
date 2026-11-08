/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.scoreboard.ScoreObjective;

public class S3DPacketDisplayScoreboard
implements Packet<INetHandlerPlayClient> {
    private int position;
    private String scoreName;

    public S3DPacketDisplayScoreboard() {
    }

    public S3DPacketDisplayScoreboard(int n, ScoreObjective scoreObjective) {
        this.position = n;
        this.scoreName = scoreObjective == null ? "" : scoreObjective.getName();
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.position = packetBuffer.readByte();
        this.scoreName = packetBuffer.readStringFromBuffer(16);
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeByte(this.position);
        packetBuffer.writeString(this.scoreName);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleDisplayScoreboard(this);
    }

    public int func_149371_c() {
        return this.position;
    }

    public String func_149370_d() {
        return this.scoreName;
    }
}

