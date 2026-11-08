/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.entitydata;

import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.entitydata.EntityDataTypeTemplate;
import io.netty.buffer.ByteBuf;

public abstract class ModernEntityDataType
extends EntityDataTypeTemplate {
    private static final int END = 255;

    @Override
    public EntityData read(ByteBuf byteBuf) {
        short s = byteBuf.readUnsignedByte();
        if (s == 255) {
            return null;
        }
        EntityDataType entityDataType = this.getType(Types.VAR_INT.readPrimitive(byteBuf));
        return new EntityData(s, entityDataType, entityDataType.type().read(byteBuf));
    }

    protected abstract EntityDataType getType(int var1);

    @Override
    public void write(ByteBuf byteBuf, EntityData entityData) {
        if (entityData == null) {
            byteBuf.writeByte(255);
        } else {
            byteBuf.writeByte(entityData.id());
            EntityDataType entityDataType = entityData.dataType();
            Types.VAR_INT.writePrimitive(byteBuf, entityDataType.typeId());
            entityDataType.type().write(byteBuf, entityData.getValue());
        }
    }
}

