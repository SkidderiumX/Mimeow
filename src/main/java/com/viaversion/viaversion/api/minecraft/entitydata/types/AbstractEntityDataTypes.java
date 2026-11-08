/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.entitydata.types;

import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes;
import com.viaversion.viaversion.api.type.Type;

public abstract class AbstractEntityDataTypes
implements EntityDataTypes {
    private final EntityDataType[] values;

    protected AbstractEntityDataTypes(int n) {
        this.values = new EntityDataType[n];
    }

    @Override
    public EntityDataType byId(int n) {
        return this.values[n];
    }

    @Override
    public EntityDataType[] values() {
        return this.values;
    }

    public Class<? extends EntityDataType> getDataTypeClass() {
        return this.byId(0).getClass();
    }

    protected EntityDataType add(int n, Type<?> type) {
        EntityDataType entityDataType;
        if (this.values[n] != null) {
            throw new IllegalArgumentException("Entity data type ID " + n + " is already registered as " + String.valueOf(this.values[n]));
        }
        this.values[n] = entityDataType = EntityDataType.create(n, type);
        return entityDataType;
    }
}

