/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScoreObjective;

public class S3BPacketScoreboardObjective
implements Packet<INetHandlerPlayClient> {
    private String objectiveName;
    private String objectiveValue;
    private IScoreObjectiveCriteria.EnumRenderType type;
    private int field_149342_c;

    public S3BPacketScoreboardObjective() {
    }

    public S3BPacketScoreboardObjective(ScoreObjective scoreObjective, int n) {
        this.objectiveName = scoreObjective.getName();
        this.objectiveValue = scoreObjective.getDisplayName();
        this.type = scoreObjective.getCriteria().getRenderType();
        this.field_149342_c = n;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.objectiveName = packetBuffer.readStringFromBuffer(16);
        this.field_149342_c = packetBuffer.readByte();
        if (this.field_149342_c == 0 || this.field_149342_c == 2) {
            this.objectiveValue = packetBuffer.readStringFromBuffer(32);
            this.type = IScoreObjectiveCriteria.EnumRenderType.func_178795_a(packetBuffer.readStringFromBuffer(16));
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeString(this.objectiveName);
        packetBuffer.writeByte(this.field_149342_c);
        if (this.field_149342_c == 0 || this.field_149342_c == 2) {
            packetBuffer.writeString(this.objectiveValue);
            packetBuffer.writeString(this.type.func_178796_a());
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleScoreboardObjective(this);
    }

    public String func_149339_c() {
        return this.objectiveName;
    }

    public String func_149337_d() {
        return this.objectiveValue;
    }

    public int func_149338_e() {
        return this.field_149342_c;
    }

    public IScoreObjectiveCriteria.EnumRenderType func_179817_d() {
        return this.type;
    }
}

