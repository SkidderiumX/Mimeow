/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.entitydata;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityData {
    private int id;
    private EntityDataType dataType;
    private Object value;

    public EntityData(int n, EntityDataType entityDataType, @Nullable Object object) {
        this.id = n;
        this.dataType = entityDataType;
        this.value = this.checkValue(entityDataType, object);
    }

    public int id() {
        return this.id;
    }

    public void setId(int n) {
        this.id = n;
    }

    public EntityDataType dataType() {
        return this.dataType;
    }

    public void setDataType(EntityDataType entityDataType) {
        this.checkValue(entityDataType, this.value);
        this.dataType = entityDataType;
    }

    public <T> @Nullable T value() {
        return (T)this.value;
    }

    public @Nullable Object getValue() {
        return this.value;
    }

    public void setValue(@Nullable Object object) {
        this.value = this.checkValue(this.dataType, object);
    }

    public void setTypeAndValue(EntityDataType entityDataType, @Nullable Object object) {
        this.value = this.checkValue(entityDataType, object);
        this.dataType = entityDataType;
    }

    private Object checkValue(EntityDataType entityDataType, @Nullable Object object) {
        Preconditions.checkNotNull(entityDataType);
        if (object != null && !entityDataType.type().getOutputClass().isAssignableFrom(object.getClass())) {
            throw new IllegalArgumentException("Entity data value and dataType are incompatible. Type=" + String.valueOf(entityDataType) + ", value=" + String.valueOf(object) + " (" + object.getClass().getSimpleName() + ")");
        }
        return object;
    }

    @Deprecated
    public void setDataTypeUnsafe(EntityDataType entityDataType) {
        this.dataType = entityDataType;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        EntityData entityData = (EntityData)object;
        if (this.id != entityData.id) {
            return false;
        }
        if (this.dataType != entityData.dataType) {
            return false;
        }
        return Objects.equals(this.value, entityData.value);
    }

    public int hashCode() {
        int n = this.id;
        n = 31 * n + this.dataType.hashCode();
        n = 31 * n + (this.value != null ? this.value.hashCode() : 0);
        return n;
    }

    public String toString() {
        return "EntityData{id=" + this.id + ", dataType=" + String.valueOf(this.dataType) + ", value=" + String.valueOf(this.value) + "}";
    }
}

