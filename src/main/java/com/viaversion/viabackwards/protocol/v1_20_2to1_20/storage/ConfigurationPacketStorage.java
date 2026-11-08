/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_2to1_20.storage;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.Protocol1_20_2To1_20;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ConfigurationPacketStorage
implements StorableObject {
    private final List<QueuedPacket> rawPackets = new ArrayList<QueuedPacket>();
    private CompoundTag registry;
    private String[] enabledFeatures;
    private boolean finished;
    private QueuedPacket resourcePack;

    public void setResourcePack(PacketWrapper packetWrapper) {
        this.resourcePack = this.toQueuedPacket(packetWrapper, ClientboundPackets1_19_4.RESOURCE_PACK);
    }

    public CompoundTag registry() {
        Preconditions.checkNotNull(this.registry);
        return this.registry;
    }

    public void setRegistry(CompoundTag compoundTag) {
        this.registry = compoundTag;
    }

    public String @Nullable [] enabledFeatures() {
        return this.enabledFeatures;
    }

    public void setEnabledFeatures(String[] stringArray) {
        this.enabledFeatures = stringArray;
    }

    public void addRawPacket(PacketWrapper packetWrapper, PacketType packetType) {
        this.rawPackets.add(this.toQueuedPacket(packetWrapper, packetType));
    }

    private QueuedPacket toQueuedPacket(PacketWrapper packetWrapper, PacketType packetType) {
        Preconditions.checkArgument(!packetWrapper.isCancelled(), "Wrapper should be cancelled AFTER calling toQueuedPacket");
        ByteBuf byteBuf = Unpooled.buffer();
        packetWrapper.setId(-1);
        packetWrapper.writeToBuffer(byteBuf);
        return new QueuedPacket(byteBuf, packetType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendQueuedPackets(UserConnection userConnection) {
        List<QueuedPacket> list = this.rawPackets;
        if (this.resourcePack != null) {
            list = new ArrayList<QueuedPacket>(this.rawPackets);
            list.add(this.resourcePack);
            this.resourcePack = null;
        }
        for (QueuedPacket queuedPacket : list) {
            ByteBuf byteBuf = queuedPacket.buf().copy();
            try {
                PacketWrapper packetWrapper = PacketWrapper.create(queuedPacket.packetType(), byteBuf, userConnection);
                packetWrapper.send(Protocol1_20_2To1_20.class);
            }
            finally {
                byteBuf.release();
            }
        }
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void setFinished(boolean bl) {
        this.finished = bl;
    }

    public record QueuedPacket(ByteBuf buf, PacketType packetType) {
    }
}

