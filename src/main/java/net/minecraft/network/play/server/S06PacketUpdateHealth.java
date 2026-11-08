/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S06PacketUpdateHealth
implements Packet<INetHandlerPlayClient> {
    private float health;
    private int foodLevel;
    private float saturationLevel;

    public S06PacketUpdateHealth() {
    }

    public S06PacketUpdateHealth(float f, int n, float f2) {
        this.health = f;
        this.foodLevel = n;
        this.saturationLevel = f2;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.health = packetBuffer.readFloat();
        this.foodLevel = packetBuffer.readVarIntFromBuffer();
        this.saturationLevel = packetBuffer.readFloat();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeFloat(this.health);
        packetBuffer.writeVarIntToBuffer(this.foodLevel);
        packetBuffer.writeFloat(this.saturationLevel);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleUpdateHealth(this);
    }

    public float getHealth() {
        return this.health;
    }

    public int getFoodLevel() {
        return this.foodLevel;
    }

    public float getSaturationLevel() {
        return this.saturationLevel;
    }
}

