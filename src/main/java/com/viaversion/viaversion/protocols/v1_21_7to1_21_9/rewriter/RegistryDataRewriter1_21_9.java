/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_7to1_21_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.storage.DimensionScaleStorage;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;

public class RegistryDataRewriter1_21_9
extends RegistryDataRewriter {
    public RegistryDataRewriter1_21_9(Protocol<?, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    protected void handleParticleData(CompoundTag compoundTag) {
        String string = compoundTag.getString("type");
        if (string != null && Key.stripMinecraftNamespace(string).equals("flash")) {
            compoundTag.putInt("color", -1);
        }
        super.handleParticleData(compoundTag);
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

