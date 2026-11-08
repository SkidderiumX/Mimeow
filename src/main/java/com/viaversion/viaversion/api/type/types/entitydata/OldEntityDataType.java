/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.entitydata;

import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.type.types.entitydata.EntityDataTypeTemplate;
import io.netty.buffer.ByteBuf;

public abstract class OldEntityDataType
extends EntityDataTypeTemplate {
    private static final int END = 127;

    @Override
    public EntityData read(ByteBuf byteBuf) {
        byte by = byteBuf.readByte();
        if (by == 127) {
            return null;
        }
        EntityDataType entityDataType = this.getType((by & 0xE0) >> 5);
        return new EntityData(by & 0x1F, entityDataType, entityDataType.type().read(byteBuf));
    }

    protected abstract EntityDataType getType(int var1);

    @Override
    public void write(ByteBuf byteBuf, EntityData entityData) {
        if (entityData == null) {
            byteBuf.writeByte(127);
        } else {
            int n = (entityData.dataType().typeId() << 5 | entityData.id() & 0x1F) & 0xFF;
            byteBuf.writeByte(n);
            entityData.dataType().type().write(byteBuf, entityData.getValue());
        }
    }
}

