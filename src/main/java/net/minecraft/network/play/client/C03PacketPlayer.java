/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C03PacketPlayer
implements Packet<INetHandlerPlayServer> {
    protected double x;
    protected double y;
    protected double z;
    protected float yaw;
    protected float pitch;
    protected boolean onGround;
    protected boolean moving;
    protected boolean rotating;

    public C03PacketPlayer() {
    }

    public C03PacketPlayer(boolean bl) {
        this.onGround = bl;
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processPlayer(this);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.onGround = packetBuffer.readUnsignedByte() != 0;
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeByte(this.onGround ? 1 : 0);
    }

    public double getPositionX() {
        return this.x;
    }

    public double getPositionY() {
        return this.y;
    }

    public double getPositionZ() {
        return this.z;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

    public boolean isMoving() {
        return this.moving;
    }

    public boolean getRotating() {
        return this.rotating;
    }

    public void setMoving(boolean bl) {
        this.moving = bl;
    }

    public static class C06PacketPlayerPosLook
    extends C03PacketPlayer {
        public C06PacketPlayerPosLook() {
            this.moving = true;
            this.rotating = true;
        }

        public C06PacketPlayerPosLook(double d, double d2, double d3, float f, float f2, boolean bl) {
            this.x = d;
            this.y = d2;
            this.z = d3;
            this.yaw = f;
            this.pitch = f2;
            this.onGround = bl;
            this.rotating = true;
            this.moving = true;
        }

        @Override
        public void readPacketData(PacketBuffer packetBuffer) throws IOException {
            this.x = packetBuffer.readDouble();
            this.y = packetBuffer.readDouble();
            this.z = packetBuffer.readDouble();
            this.yaw = packetBuffer.readFloat();
            this.pitch = packetBuffer.readFloat();
            super.readPacketData(packetBuffer);
        }

        @Override
        public void writePacketData(PacketBuffer packetBuffer) throws IOException {
            packetBuffer.writeDouble(this.x);
            packetBuffer.writeDouble(this.y);
            packetBuffer.writeDouble(this.z);
            packetBuffer.writeFloat(this.yaw);
            packetBuffer.writeFloat(this.pitch);
            super.writePacketData(packetBuffer);
        }
    }

    public static class C05PacketPlayerLook
    extends C03PacketPlayer {
        public C05PacketPlayerLook() {
            this.rotating = true;
        }

        public C05PacketPlayerLook(float f, float f2, boolean bl) {
            this.yaw = f;
            this.pitch = f2;
            this.onGround = bl;
            this.rotating = true;
        }

        @Override
        public void readPacketData(PacketBuffer packetBuffer) throws IOException {
            this.yaw = packetBuffer.readFloat();
            this.pitch = packetBuffer.readFloat();
            super.readPacketData(packetBuffer);
        }

        @Override
        public void writePacketData(PacketBuffer packetBuffer) throws IOException {
            packetBuffer.writeFloat(this.yaw);
            packetBuffer.writeFloat(this.pitch);
            super.writePacketData(packetBuffer);
        }
    }

    public static class C04PacketPlayerPosition
    extends C03PacketPlayer {
        public C04PacketPlayerPosition() {
            this.moving = true;
        }

        public C04PacketPlayerPosition(double d, double d2, double d3, boolean bl) {
            this.x = d;
            this.y = d2;
            this.z = d3;
            this.onGround = bl;
            this.moving = true;
        }

        @Override
        public void readPacketData(PacketBuffer packetBuffer) throws IOException {
            this.x = packetBuffer.readDouble();
            this.y = packetBuffer.readDouble();
            this.z = packetBuffer.readDouble();
            super.readPacketData(packetBuffer);
        }

        @Override
        public void writePacketData(PacketBuffer packetBuffer) throws IOException {
            packetBuffer.writeDouble(this.x);
            packetBuffer.writeDouble(this.y);
            packetBuffer.writeDouble(this.z);
            super.writePacketData(packetBuffer);
        }
    }
}

