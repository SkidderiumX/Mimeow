/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.VillagerData;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class VillagerDataType
extends Type<VillagerData> {
    public VillagerDataType() {
        super(VillagerData.class);
    }

    @Override
    public VillagerData read(ByteBuf byteBuf) {
        return new VillagerData(Types.VAR_INT.readPrimitive(byteBuf), Types.VAR_INT.readPrimitive(byteBuf), Types.VAR_INT.readPrimitive(byteBuf));
    }

    @Override
    public void write(ByteBuf byteBuf, VillagerData villagerData) {
        Types.VAR_INT.writePrimitive(byteBuf, villagerData.type());
        Types.VAR_INT.writePrimitive(byteBuf, villagerData.profession());
        Types.VAR_INT.writePrimitive(byteBuf, villagerData.level());
    }
}

