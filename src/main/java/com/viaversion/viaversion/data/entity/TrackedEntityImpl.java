/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.data.entity;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectArrayMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class TrackedEntityImpl
implements TrackedEntity {
    private final EntityType entityType;
    private Map<Class<?>, StorableObject> storedObjects;
    private boolean sentEntityData;

    public TrackedEntityImpl(EntityType entityType) {
        this.entityType = entityType;
    }

    @Override
    public EntityType entityType() {
        return this.entityType;
    }

    @Override
    public boolean has(Class<? extends StorableObject> clazz) {
        return this.storedObjects != null && this.storedObjects.containsKey(clazz);
    }

    @Override
    public <T extends StorableObject> @Nullable T get(Class<T> clazz) {
        return (T)(this.storedObjects != null ? this.storedObjects.get(clazz) : null);
    }

    @Override
    public void put(StorableObject storableObject) {
        this.storedObjects().put(storableObject.getClass(), storableObject);
    }

    @Override
    public <T extends StorableObject> @Nullable T remove(Class<T> clazz) {
        return (T)(this.storedObjects != null ? this.storedObjects.remove(clazz) : null);
    }

    private Map<Class<?>, StorableObject> storedObjects() {
        if (this.storedObjects == null) {
            this.storedObjects = new Reference2ObjectArrayMap();
        }
        return this.storedObjects;
    }

    @Override
    public boolean hasSentEntityData() {
        return this.sentEntityData;
    }

    @Override
    public void sentEntityData(boolean bl) {
        this.sentEntityData = bl;
    }

    public String toString() {
        return "TrackedEntityImpl{entityType=" + String.valueOf(this.entityType) + ", storedObjects=" + String.valueOf(this.storedObjects) + ", sentEntityData=" + this.sentEntityData + "}";
    }
}

