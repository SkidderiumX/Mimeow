/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage.DimensionScaleStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;

public class RegistryDataRewriter1_21_9
extends BackwardsRegistryRewriter {
    public RegistryDataRewriter1_21_9(BackwardsProtocol<?, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
    }

    @Override
    public void trackDimensionAndBiomes(UserConnection userConnection, String string, RegistryEntry[] registryEntryArray) {
        super.trackDimensionAndBiomes(userConnection, string, registryEntryArray);
        if (!string.equals("dimension_type")) {
            return;
        }
        DimensionScaleStorage dimensionScaleStorage = userConnection.get(DimensionScaleStorage.class);
        for (int i = 0; i < registryEntryArray.length; ++i) {
            RegistryEntry registryEntry = registryEntryArray[i];
            CompoundTag compoundTag = (CompoundTag)registryEntry.tag();
            if (compoundTag == null) continue;
            double d = compoundTag.getDouble("coordinate_scale", 1.0);
            dimensionScaleStorage.setScale(i, d);
        }
    }
}

