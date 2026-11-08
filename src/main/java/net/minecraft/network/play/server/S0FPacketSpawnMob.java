/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.MathHelper;

public class S0FPacketSpawnMob
implements Packet<INetHandlerPlayClient> {
    private int entityId;
    private int type;
    private int x;
    private int y;
    private int z;
    private int velocityX;
    private int velocityY;
    private int velocityZ;
    private byte yaw;
    private byte pitch;
    private byte headPitch;
    private DataWatcher field_149043_l;
    private List<DataWatcher.WatchableObject> watcher;

    public S0FPacketSpawnMob() {
    }

    public S0FPacketSpawnMob(EntityLivingBase entityLivingBase) {
        this.entityId = entityLivingBase.getEntityId();
        this.type = (byte)EntityList.getEntityID(entityLivingBase);
        this.x = MathHelper.floor_double(entityLivingBase.posX * 32.0);
        this.y = MathHelper.floor_double(entityLivingBase.posY * 32.0);
        this.z = MathHelper.floor_double(entityLivingBase.posZ * 32.0);
        this.yaw = (byte)(entityLivingBase.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(entityLivingBase.rotationPitch * 256.0f / 360.0f);
        this.headPitch = (byte)(entityLivingBase.rotationYawHead * 256.0f / 360.0f);
        double d = 3.9;
        double d2 = entityLivingBase.motionX;
        double d3 = entityLivingBase.motionY;
        double d4 = entityLivingBase.motionZ;
        if (d2 < -d) {
            d2 = -d;
        }
        if (d3 < -d) {
            d3 = -d;
        }
        if (d4 < -d) {
            d4 = -d;
        }
        if (d2 > d) {
            d2 = d;
        }
        if (d3 > d) {
            d3 = d;
        }
        if (d4 > d) {
            d4 = d;
        }
        this.velocityX = (int)(d2 * 8000.0);
        this.velocityY = (int)(d3 * 8000.0);
        this.velocityZ = (int)(d4 * 8000.0);
        this.field_149043_l = entityLivingBase.getDataWatcher();
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.entityId = packetBuffer.readVarIntFromBuffer();
        this.type = packetBuffer.readByte() & 0xFF;
        this.x = packetBuffer.readInt();
        this.y = packetBuffer.readInt();
        this.z = packetBuffer.readInt();
        this.yaw = packetBuffer.readByte();
        this.pitch = packetBuffer.readByte();
        this.headPitch = packetBuffer.readByte();
        this.velocityX = packetBuffer.readShort();
        this.velocityY = packetBuffer.readShort();
        this.velocityZ = packetBuffer.readShort();
        this.watcher = DataWatcher.readWatchedListFromPacketBuffer(packetBuffer);
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.entityId);
        packetBuffer.writeByte(this.type & 0xFF);
        packetBuffer.writeInt(this.x);
        packetBuffer.writeInt(this.y);
        packetBuffer.writeInt(this.z);
        packetBuffer.writeByte(this.yaw);
        packetBuffer.writeByte(this.pitch);
        packetBuffer.writeByte(this.headPitch);
        packetBuffer.writeShort(this.velocityX);
        packetBuffer.writeShort(this.velocityY);
        packetBuffer.writeShort(this.velocityZ);
        if (this.field_149043_l != null) {
            this.field_149043_l.writeTo(packetBuffer);
        } else {
            DataWatcher.writeWatchedListToPacketBuffer(this.watcher, packetBuffer);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleSpawnMob(this);
    }

    public List<DataWatcher.WatchableObject> func_149027_c() {
        if (this.watcher == null && this.field_149043_l != null) {
            this.watcher = this.field_149043_l.getAllWatched();
        }
        return this.watcher;
    }

    public int getEntityID() {
        return this.entityId;
    }

    public int getEntityType() {
        return this.type;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public int getVelocityX() {
        return this.velocityX;
    }

    public int getVelocityY() {
        return this.velocityY;
    }

    public int getVelocityZ() {
        return this.velocityZ;
    }

    public byte getYaw() {
        return this.yaw;
    }

    public byte getPitch() {
        return this.pitch;
    }

    public byte getHeadPitch() {
        return this.headPitch;
    }
}

