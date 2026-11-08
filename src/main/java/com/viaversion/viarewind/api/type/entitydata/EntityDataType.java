/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type.entitydata;

import com.viaversion.viarewind.api.minecraft.entitydata.EntityDataTypes1_7_6_10;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.type.types.entitydata.EntityDataTypeTemplate;
import io.netty.buffer.ByteBuf;

public class EntityDataType
extends EntityDataTypeTemplate {
    @Override
    public EntityData read(ByteBuf byteBuf) {
        byte by = byteBuf.readByte();
        if (by == 127) {
            return null;
        }
        int n = (by & 0xE0) >> 5;
        EntityDataTypes1_7_6_10 entityDataTypes1_7_6_10 = EntityDataTypes1_7_6_10.byId(n);
        int n2 = by & 0x1F;
        return new EntityData(n2, entityDataTypes1_7_6_10, entityDataTypes1_7_6_10.type().read(byteBuf));
    }

    @Override
    public void write(ByteBuf byteBuf, EntityData entityData) {
        int n = (entityData.dataType().typeId() << 5 | entityData.id() & 0x1F) & 0xFF;
        byteBuf.writeByte(n);
        entityData.dataType().type().write(byteBuf, entityData.getValue());
    }
}

