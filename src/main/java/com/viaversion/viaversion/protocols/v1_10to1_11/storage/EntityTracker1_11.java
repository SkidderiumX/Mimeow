/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_10to1_11.storage;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_11;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityTracker1_11
extends EntityTrackerBase {
    private final IntSet holograms = new IntOpenHashSet();

    public EntityTracker1_11(UserConnection userConnection) {
        super(userConnection, EntityTypes1_11.EntityType.PLAYER);
    }

    @Override
    public @Nullable TrackedEntity removeEntity(int n) {
        this.removeHologram(n);
        return super.removeEntity(n);
    }

    public boolean addHologram(int n) {
        return this.holograms.add(n);
    }

    public boolean isHologram(int n) {
        return this.holograms.contains(n);
    }

    public void removeHologram(int n) {
        this.holograms.remove(n);
    }
}

