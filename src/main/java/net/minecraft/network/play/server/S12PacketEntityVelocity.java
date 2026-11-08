/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S12PacketEntityVelocity
implements Packet<INetHandlerPlayClient> {
    private int entityID;
    private int motionX;
    private int motionY;
    private int motionZ;

    public S12PacketEntityVelocity() {
    }

    public S12PacketEntityVelocity(Entity entity) {
        this(entity.getEntityId(), entity.motionX, entity.motionY, entity.motionZ);
    }

    public S12PacketEntityVelocity(int n, double d, double d2, double d3) {
        this.entityID = n;
        double d4 = 3.9;
        if (d < -d4) {
            d = -d4;
        }
        if (d2 < -d4) {
            d2 = -d4;
        }
        if (d3 < -d4) {
            d3 = -d4;
        }
        if (d > d4) {
            d = d4;
        }
        if (d2 > d4) {
            d2 = d4;
        }
        if (d3 > d4) {
            d3 = d4;
        }
        this.motionX = (int)(d * 8000.0);
        this.motionY = (int)(d2 * 8000.0);
        this.motionZ = (int)(d3 * 8000.0);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.entityID = packetBuffer.readVarIntFromBuffer();
        this.motionX = packetBuffer.readShort();
        this.motionY = packetBuffer.readShort();
        this.motionZ = packetBuffer.readShort();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.entityID);
        packetBuffer.writeShort(this.motionX);
        packetBuffer.writeShort(this.motionY);
        packetBuffer.writeShort(this.motionZ);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleEntityVelocity(this);
    }

    public int getEntityID() {
        return this.entityID;
    }

    public int getMotionX() {
        return this.motionX;
    }

    public int getMotionY() {
        return this.motionY;
    }

    public int getMotionZ() {
        return this.motionZ;
    }

    public void setMotionX(int n) {
        this.motionX = n;
    }

    public void setMotionY(int n) {
        this.motionY = n;
    }

    public void setMotionZ(int n) {
        this.motionZ = n;
    }
}

