/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage;

import com.viaversion.viabackwards.api.entities.storage.EntityPositionStorage;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.Protocol1_19_4To1_19_3;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import org.checkerframework.checker.nullness.qual.Nullable;

public class LinkedEntityStorage
extends EntityPositionStorage
implements StorableObject {
    private int[] entities;
    private int[] passengers;
    private Integer vehicleId;

    public int @Nullable [] entities() {
        return this.entities;
    }

    public void setEntities(int ... nArray) {
        this.entities = nArray;
    }

    public int @Nullable [] passengers() {
        return this.passengers;
    }

    public void setPassengers(int ... nArray) {
        this.passengers = nArray;
    }

    public @Nullable Integer vehicleId() {
        return this.vehicleId;
    }

    public boolean isVehicle(int n) {
        return this.vehicleId != null && this.vehicleId == n;
    }

    public void setVehicleId(@Nullable Integer n) {
        this.vehicleId = n;
    }

    public void remove(UserConnection userConnection) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.REMOVE_ENTITIES, userConnection);
        packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, this.entities);
        packetWrapper.send(Protocol1_19_4To1_19_3.class);
        this.entities = null;
    }
}

