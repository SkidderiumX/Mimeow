/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityTracker1_21_2
extends EntityTrackerBase {
    private double playerMaxHealthAttributeValue = 20.0;

    public EntityTracker1_21_2(UserConnection userConnection) {
        super(userConnection, EntityTypes1_21_2.PLAYER);
    }

    public BoatEntity trackBoatEntity(int n, UUID uUID, int n2) {
        BoatEntity boatEntity = new BoatEntity(uUID, n2);
        this.entity(n).put(boatEntity);
        return boatEntity;
    }

    public @Nullable BoatEntity trackedBoatEntity(int n) {
        TrackedEntity trackedEntity = this.entity(n);
        return trackedEntity != null ? trackedEntity.get(BoatEntity.class) : null;
    }

    public void updateBoatType(int n, EntityType entityType) {
        BoatEntity boatEntity = this.trackedBoatEntity(n);
        this.removeEntity(n);
        TrackedEntity trackedEntity = this.addEntity(n, entityType);
        trackedEntity.put(boatEntity);
    }

    public double playerMaxHealthAttributeValue() {
        return this.playerMaxHealthAttributeValue;
    }

    public void setPlayerMaxHealthAttributeValue(double d) {
        this.playerMaxHealthAttributeValue = d;
    }

    public static final class BoatEntity
    implements StorableObject {
        private final List<EntityData> entityData = new ArrayList<EntityData>();
        private final UUID uuid;
        private final int data;
        private double x;
        private double y;
        private double z;
        private float yaw;
        private float pitch;
        private int[] passengers;

        public BoatEntity(UUID uUID, int n) {
            this.uuid = uUID;
            this.data = n;
        }

        public void setPosition(double d, double d2, double d3) {
            this.x = d;
            this.y = d2;
            this.z = d3;
        }

        public void setRotation(float f, float f2) {
            this.yaw = f;
            this.pitch = f2;
        }

        public void setPassengers(int[] nArray) {
            this.passengers = nArray;
        }

        public UUID uuid() {
            return this.uuid;
        }

        public int data() {
            return this.data;
        }

        public double x() {
            return this.x;
        }

        public double y() {
            return this.y;
        }

        public double z() {
            return this.z;
        }

        public float yaw() {
            return this.yaw;
        }

        public float pitch() {
            return this.pitch;
        }

        public List<EntityData> entityData() {
            return this.entityData;
        }

        public int @Nullable [] passengers() {
            return this.passengers;
        }
    }
}

