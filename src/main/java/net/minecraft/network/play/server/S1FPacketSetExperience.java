/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S1FPacketSetExperience
implements Packet<INetHandlerPlayClient> {
    private float field_149401_a;
    private int totalExperience;
    private int level;

    public S1FPacketSetExperience() {
    }

    public S1FPacketSetExperience(float f, int n, int n2) {
        this.field_149401_a = f;
        this.totalExperience = n;
        this.level = n2;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.field_149401_a = packetBuffer.readFloat();
        this.level = packetBuffer.readVarIntFromBuffer();
        this.totalExperience = packetBuffer.readVarIntFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeFloat(this.field_149401_a);
        packetBuffer.writeVarIntToBuffer(this.level);
        packetBuffer.writeVarIntToBuffer(this.totalExperience);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleSetExperience(this);
    }

    public float func_149397_c() {
        return this.field_149401_a;
    }

    public int getTotalExperience() {
        return this.totalExperience;
    }

    public int getLevel() {
        return this.level;
    }
}

