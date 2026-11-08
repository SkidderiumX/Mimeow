/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.EntityNameMappings1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.provider.BackwardsBlockEntityProvider;

public class SpawnerHandler
implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler {
    @Override
    public CompoundTag transform(int n, CompoundTag compoundTag) {
        StringTag stringTag;
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("SpawnData");
        if (compoundTag2 != null && (stringTag = compoundTag2.getStringTag("id")) != null) {
            stringTag.setValue(EntityNameMappings1_12_2.rewrite(stringTag.getValue()));
        }
        return compoundTag;
    }
}

