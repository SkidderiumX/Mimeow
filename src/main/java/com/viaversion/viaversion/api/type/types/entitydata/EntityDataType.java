/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.entitydata;

import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes;
import com.viaversion.viaversion.api.type.types.entitydata.ModernEntityDataType;

public class EntityDataType
extends ModernEntityDataType {
    private final EntityDataTypes dataTypes;

    public EntityDataType(EntityDataTypes entityDataTypes) {
        this.dataTypes = entityDataTypes;
    }

    @Override
    protected com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType getType(int n) {
        return this.dataTypes.byId(n);
    }
}

