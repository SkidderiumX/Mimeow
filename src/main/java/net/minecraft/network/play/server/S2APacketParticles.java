/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.EnumParticleTypes;

public class S2APacketParticles
implements Packet<INetHandlerPlayClient> {
    private EnumParticleTypes particleType;
    private float xCoord;
    private float yCoord;
    private float zCoord;
    private float xOffset;
    private float yOffset;
    private float zOffset;
    private float particleSpeed;
    private int particleCount;
    private boolean longDistance;
    private int[] particleArguments;

    public S2APacketParticles() {
    }

    public S2APacketParticles(EnumParticleTypes enumParticleTypes, boolean bl, float f, float f2, float f3, float f4, float f5, float f6, float f7, int n, int ... nArray) {
        this.particleType = enumParticleTypes;
        this.longDistance = bl;
        this.xCoord = f;
        this.yCoord = f2;
        this.zCoord = f3;
        this.xOffset = f4;
        this.yOffset = f5;
        this.zOffset = f6;
        this.particleSpeed = f7;
        this.particleCount = n;
        this.particleArguments = nArray;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.particleType = EnumParticleTypes.getParticleFromId(packetBuffer.readInt());
        if (this.particleType == null) {
            this.particleType = EnumParticleTypes.BARRIER;
        }
        this.longDistance = packetBuffer.readBoolean();
        this.xCoord = packetBuffer.readFloat();
        this.yCoord = packetBuffer.readFloat();
        this.zCoord = packetBuffer.readFloat();
        this.xOffset = packetBuffer.readFloat();
        this.yOffset = packetBuffer.readFloat();
        this.zOffset = packetBuffer.readFloat();
        this.particleSpeed = packetBuffer.readFloat();
        this.particleCount = packetBuffer.readInt();
        int n = this.particleType.getArgumentCount();
        this.particleArguments = new int[n];
        for (int i = 0; i < n; ++i) {
            this.particleArguments[i] = packetBuffer.readVarIntFromBuffer();
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeInt(this.particleType.getParticleID());
        packetBuffer.writeBoolean(this.longDistance);
        packetBuffer.writeFloat(this.xCoord);
        packetBuffer.writeFloat(this.yCoord);
        packetBuffer.writeFloat(this.zCoord);
        packetBuffer.writeFloat(this.xOffset);
        packetBuffer.writeFloat(this.yOffset);
        packetBuffer.writeFloat(this.zOffset);
        packetBuffer.writeFloat(this.particleSpeed);
        packetBuffer.writeInt(this.particleCount);
        int n = this.particleType.getArgumentCount();
        for (int i = 0; i < n; ++i) {
            packetBuffer.writeVarIntToBuffer(this.particleArguments[i]);
        }
    }

    public EnumParticleTypes getParticleType() {
        return this.particleType;
    }

    public boolean isLongDistance() {
        return this.longDistance;
    }

    public double getXCoordinate() {
        return this.xCoord;
    }

    public double getYCoordinate() {
        return this.yCoord;
    }

    public double getZCoordinate() {
        return this.zCoord;
    }

    public float getXOffset() {
        return this.xOffset;
    }

    public float getYOffset() {
        return this.yOffset;
    }

    public float getZOffset() {
        return this.zOffset;
    }

    public float getParticleSpeed() {
        return this.particleSpeed;
    }

    public int getParticleCount() {
        return this.particleCount;
    }

    public int[] getParticleArgs() {
        return this.particleArguments;
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleParticles(this);
    }
}

