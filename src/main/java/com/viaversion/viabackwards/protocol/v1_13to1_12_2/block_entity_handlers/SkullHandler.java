/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.provider.BackwardsBlockEntityProvider;

public class SkullHandler
implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler {
    private static final int SKULL_START = 5447;

    @Override
    public CompoundTag transform(int n, CompoundTag compoundTag) {
        int n2 = n - 5447;
        int n3 = n2 % 20;
        byte by = (byte)Math.floor((float)n2 / 20.0f);
        compoundTag.putByte("SkullType", by);
        if (n3 < 4) {
            return compoundTag;
        }
        compoundTag.putByte("Rot", (byte)(n3 - 4 & 0xFF));
        return compoundTag;
    }
}

