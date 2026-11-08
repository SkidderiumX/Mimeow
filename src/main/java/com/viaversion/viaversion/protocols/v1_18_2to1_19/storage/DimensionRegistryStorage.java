/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DimensionRegistryStorage
implements StorableObject {
    private Map<CompoundTag, String> dimensions;

    public @Nullable String dimensionKey(CompoundTag compoundTag) {
        return this.dimensions.get(compoundTag);
    }

    public void setDimensions(Map<CompoundTag, String> map) {
        this.dimensions = map;
    }

    public Map<CompoundTag, String> dimensions() {
        return this.dimensions;
    }
}

