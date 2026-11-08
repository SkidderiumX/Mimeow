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

public class S19PacketEntityHeadLook
implements Packet<INetHandlerPlayClient> {
    private int entityId;
    private byte yaw;

    public S19PacketEntityHeadLook() {
    }

    public S19PacketEntityHeadLook(Entity entity, byte by) {
        this.entityId = entity.getEntityId();
        this.yaw = by;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.entityId = packetBuffer.readVarIntFromBuffer();
        this.yaw = packetBuffer.readByte();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.entityId);
        packetBuffer.writeByte(this.yaw);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleEntityHeadLook(this);
    }

    public Entity getEntity(World world2) {
        return world2.getEntityByID(this.entityId);
    }

    public byte getYaw() {
        return this.yaw;
    }
}

