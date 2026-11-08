/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data.entity;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface TrackedEntity {
    public EntityType entityType();

    public boolean has(Class<? extends StorableObject> var1);

    public <T extends StorableObject> @Nullable T get(Class<T> var1);

    public <T extends StorableObject> @Nullable T remove(Class<T> var1);

    public void put(StorableObject var1);

    public boolean hasSentEntityData();

    public void sentEntityData(boolean var1);
}

