/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage;

import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.Protocol1_19_4To1_19_3;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage.LinkedEntityStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityTracker1_19_4
extends EntityTrackerBase {
    private final IntSet generatedEntities = new IntOpenHashSet();

    public EntityTracker1_19_4(UserConnection userConnection) {
        super(userConnection, EntityTypes1_19_4.PLAYER);
    }

    public int spawnEntity(EntityTypes1_19_3 entityTypes1_19_3, double d, double d2, double d3, int n) {
        int n2 = this.nextEntityId();
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.ADD_ENTITY, this.user());
        packetWrapper.write(Types.VAR_INT, n2);
        packetWrapper.write(Types.UUID, UUID.randomUUID());
        packetWrapper.write(Types.VAR_INT, entityTypes1_19_3.getId());
        packetWrapper.write(Types.DOUBLE, d);
        packetWrapper.write(Types.DOUBLE, d2);
        packetWrapper.write(Types.DOUBLE, d3);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.send(Protocol1_19_4To1_19_3.class);
        return n2;
    }

    @Override
    public @Nullable TrackedEntity removeEntity(int n) {
        TrackedEntity trackedEntity = super.removeEntity(n);
        if (trackedEntity != null) {
            this.clearLinkedEntities(trackedEntity.get(LinkedEntityStorage.class));
        }
        return trackedEntity;
    }

    public void clearLinkedEntities(LinkedEntityStorage linkedEntityStorage) {
        if (linkedEntityStorage != null && linkedEntityStorage.entities() != null) {
            for (int n : linkedEntityStorage.entities()) {
                this.generatedEntities.remove(n);
            }
            linkedEntityStorage.remove(this.user());
        }
    }

    public @Nullable LinkedEntityStorage linkedEntityStorage(int n) {
        TrackedEntity trackedEntity = this.entity(n);
        return trackedEntity != null ? trackedEntity.get(LinkedEntityStorage.class) : null;
    }

    private int nextEntityId() {
        int n = ThreadLocalRandom.current().nextInt(-1000000, -1);
        if (!this.generatedEntities.add(n)) {
            return this.nextEntityId();
        }
        return n;
    }
}

