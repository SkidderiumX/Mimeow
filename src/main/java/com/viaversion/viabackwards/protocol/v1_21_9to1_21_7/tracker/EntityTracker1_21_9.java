/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.tracker;

import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.Protocol1_21_9To1_21_7;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage.MannequinData;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityTracker1_21_9
extends EntityTrackerBase {
    public EntityTracker1_21_9(UserConnection userConnection, @Nullable EntityType entityType) {
        super(userConnection, entityType);
    }

    @Override
    public @Nullable TrackedEntity removeEntity(int n) {
        TrackedEntity trackedEntity = super.removeEntity(n);
        if (trackedEntity != null) {
            this.sendRemovePacket(trackedEntity);
        }
        return trackedEntity;
    }

    public void sendRemovePacket(TrackedEntity trackedEntity) {
        MannequinData mannequinData = trackedEntity.get(MannequinData.class);
        if (mannequinData != null) {
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_6.PLAYER_INFO_REMOVE, this.user());
            packetWrapper.write(Types.UUID_ARRAY, new UUID[]{mannequinData.uuid()});
            packetWrapper.send(Protocol1_21_9To1_21_7.class);
            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_21_6.SET_PLAYER_TEAM, this.user());
            packetWrapper2.write(Types.STRING, mannequinData.name());
            packetWrapper2.write(Types.BYTE, (byte)1);
            packetWrapper2.send(Protocol1_21_9To1_21_7.class);
        }
    }
}

