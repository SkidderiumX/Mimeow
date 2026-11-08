/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.entitydata;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.entitydata.EntityDataListTypeTemplate;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;

public class EntityDataListType
extends EntityDataListTypeTemplate {
    private final Type<EntityData> type;

    public EntityDataListType(Type<EntityData> type) {
        Preconditions.checkNotNull(type);
        this.type = type;
    }

    @Override
    public List<EntityData> read(ByteBuf byteBuf) {
        EntityData entityData;
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        do {
            if ((entityData = (EntityData)this.type.read(byteBuf)) == null) continue;
            arrayList.add(entityData);
        } while (entityData != null);
        return arrayList;
    }

    @Override
    public void write(ByteBuf byteBuf, List<EntityData> list) {
        for (EntityData entityData : list) {
            this.type.write(byteBuf, entityData);
        }
        this.type.write(byteBuf, null);
    }
}

