/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public record WrappedEntityData(List<EntityData> entityDataList) {
    public boolean has(EntityData entityData) {
        return this.entityDataList.contains(entityData);
    }

    public void remove(EntityData entityData) {
        this.entityDataList.remove(entityData);
    }

    public void remove(int n) {
        this.entityDataList.removeIf(entityData -> entityData.id() == n);
    }

    public void add(EntityData entityData) {
        this.entityDataList.add(entityData);
    }

    public @Nullable EntityData get(int n) {
        for (EntityData entityData : this.entityDataList) {
            if (n != entityData.id()) continue;
            return entityData;
        }
        return null;
    }
}

