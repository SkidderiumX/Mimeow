/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.storage;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.Vector;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import java.util.List;
import java.util.Map;

public class EntityTracker1_9
extends EntityTrackerBase {
    private final Int2ObjectMap<IntList> vehicles = new Int2ObjectOpenHashMap<IntList>();
    private final Int2ObjectMap<Vector> offsets = new Int2ObjectOpenHashMap<Vector>();
    private final Int2IntMap status = new Int2IntOpenHashMap();

    public EntityTracker1_9(UserConnection userConnection) {
        super(userConnection, EntityTypes1_9.EntityType.PLAYER);
    }

    @Override
    public TrackedEntity removeEntity(int n) {
        this.vehicles.remove(n);
        this.offsets.remove(n);
        this.status.remove(n);
        this.vehicles.forEach((n2, intList) -> intList.rem(n));
        this.vehicles.int2ObjectEntrySet().removeIf(entry -> ((IntList)entry.getValue()).isEmpty());
        return super.removeEntity(n);
    }

    public void resetEntityOffset(int n) {
        this.offsets.remove(n);
    }

    public Vector getEntityOffset(int n) {
        return (Vector)this.offsets.get(n);
    }

    public void setEntityOffset(int n, Vector vector) {
        this.offsets.put(n, vector);
    }

    public IntList getPassengers(int n) {
        return this.vehicles.getOrDefault(n, (IntList)new IntArrayList());
    }

    public void setPassengers(int n, IntList intList) {
        this.vehicles.put(n, intList);
    }

    public boolean isInsideVehicle(int n) {
        for (List list : this.vehicles.values()) {
            if (!list.contains(n)) continue;
            return true;
        }
        return false;
    }

    public Integer getVehicle(int n) {
        for (Map.Entry entry : this.vehicles.int2ObjectEntrySet()) {
            if (!((IntList)entry.getValue()).contains(n)) continue;
            return (Integer)entry.getKey();
        }
        return null;
    }

    public Int2IntMap getStatus() {
        return this.status;
    }
}

