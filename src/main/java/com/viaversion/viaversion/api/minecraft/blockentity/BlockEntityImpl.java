/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.blockentity;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;

public record BlockEntityImpl(byte packedXZ, short y, int typeId, CompoundTag tag) implements BlockEntity
{
    @Override
    public BlockEntity withTypeId(int n) {
        return new BlockEntityImpl(this.packedXZ, this.y, n, this.tag);
    }
}

