/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.World;
import x.oc1553ad102e;

public class S14PacketEntity
implements Packet<INetHandlerPlayClient>,
oc1553ad102e {
    protected int entityId;
    protected byte posX;
    protected byte posY;
    protected byte posZ;
    protected byte yaw;
    protected byte pitch;
    protected boolean onGround;
    protected boolean field_149069_g;

    public S14PacketEntity() {
    }

    public S14PacketEntity(int n) {
        this.entityId = n;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.entityId = packetBuffer.readVarIntFromBuffer();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.entityId);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleEntityMovement(this);
    }

    public String toString() {
        return "Entity_" + super.toString();
    }

    public Entity getEntity(World world2) {
        return world2.getEntityByID(this.entityId);
    }

    public byte func_149062_c() {
        return this.posX;
    }

    public byte func_149061_d() {
        return this.posY;
    }

    public byte func_149064_e() {
        return this.posZ;
    }

    public byte func_149066_f() {
        return this.yaw;
    }

    public byte func_149063_g() {
        return this.pitch;
    }

    public boolean func_149060_h() {
        return this.field_149069_g;
    }

    public boolean getOnGround() {
        return this.onGround;
    }

    @Override
    public int getEntityId() {
        return this.entityId;
    }

    public static class S17PacketEntityLookMove
    extends S14PacketEntity {
        public S17PacketEntityLookMove() {
            this.field_149069_g = true;
        }

        public S17PacketEntityLookMove(int n, byte by, byte by2, byte by3, byte by4, byte by5, boolean bl) {
            super(n);
            this.posX = by;
            this.posY = by2;
            this.posZ = by3;
            this.yaw = by4;
            this.pitch = by5;
            this.onGround = bl;
            this.field_149069_g = true;
        }

        @Override
        public void readPacketData(PacketBuffer packetBuffer) throws IOException {
            super.readPacketData(packetBuffer);
            this.posX = packetBuffer.readByte();
            this.posY = packetBuffer.readByte();
            this.posZ = packetBuffer.readByte();
            this.yaw = packetBuffer.readByte();
            this.pitch = packetBuffer.readByte();
            this.onGround = packetBuffer.readBoolean();
        }

        @Override
        public void writePacketData(PacketBuffer packetBuffer) throws IOException {
            super.writePacketData(packetBuffer);
            packetBuffer.writeByte(this.posX);
            packetBuffer.writeByte(this.posY);
            packetBuffer.writeByte(this.posZ);
            packetBuffer.writeByte(this.yaw);
            packetBuffer.writeByte(this.pitch);
            packetBuffer.writeBoolean(this.onGround);
        }
    }

    public static class S16PacketEntityLook
    extends S14PacketEntity {
        public S16PacketEntityLook() {
            this.field_149069_g = true;
        }

        public S16PacketEntityLook(int n, byte by, byte by2, boolean bl) {
            super(n);
            this.yaw = by;
            this.pitch = by2;
            this.field_149069_g = true;
            this.onGround = bl;
        }

        @Override
        public void readPacketData(PacketBuffer packetBuffer) throws IOException {
            super.readPacketData(packetBuffer);
            this.yaw = packetBuffer.readByte();
            this.pitch = packetBuffer.readByte();
            this.onGround = packetBuffer.readBoolean();
        }

        @Override
        public void writePacketData(PacketBuffer packetBuffer) throws IOException {
            super.writePacketData(packetBuffer);
            packetBuffer.writeByte(this.yaw);
            packetBuffer.writeByte(this.pitch);
            packetBuffer.writeBoolean(this.onGround);
        }
    }

    public static class S15PacketEntityRelMove
    extends S14PacketEntity {
        public S15PacketEntityRelMove() {
        }

        public S15PacketEntityRelMove(int n, byte by, byte by2, byte by3, boolean bl) {
            super(n);
            this.posX = by;
            this.posY = by2;
            this.posZ = by3;
            this.onGround = bl;
        }

        @Override
        public void readPacketData(PacketBuffer packetBuffer) throws IOException {
            super.readPacketData(packetBuffer);
            this.posX = packetBuffer.readByte();
            this.posY = packetBuffer.readByte();
            this.posZ = packetBuffer.readByte();
            this.onGround = packetBuffer.readBoolean();
        }

        @Override
        public void writePacketData(PacketBuffer packetBuffer) throws IOException {
            super.writePacketData(packetBuffer);
            packetBuffer.writeByte(this.posX);
            packetBuffer.writeByte(this.posY);
            packetBuffer.writeByte(this.posZ);
            packetBuffer.writeBoolean(this.onGround);
        }
    }
}

