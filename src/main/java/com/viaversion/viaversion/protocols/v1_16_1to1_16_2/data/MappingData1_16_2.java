/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_1to1_16_2.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.util.TagUtil;
import java.util.HashMap;
import java.util.Map;

public class MappingData1_16_2
extends MappingDataBase {
    private final Map<String, CompoundTag> dimensionDataMap = new HashMap<String, CompoundTag>();
    private CompoundTag dimensionRegistry;

    public MappingData1_16_2() {
        super("1.16", "1.16.2");
    }

    @Override
    public void loadExtras(CompoundTag compoundTag) {
        this.dimensionRegistry = MappingDataLoader.INSTANCE.loadNBTFromFile("dimension-registry-1.16.2.nbt");
        ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(this.dimensionRegistry, "dimension_type");
        for (CompoundTag compoundTag2 : listTag) {
            CompoundTag compoundTag3 = compoundTag2.getCompoundTag("element").copy();
            this.dimensionDataMap.put(compoundTag2.getStringTag("name").getValue(), compoundTag3);
        }
    }

    public Map<String, CompoundTag> getDimensionDataMap() {
        return this.dimensionDataMap;
    }

    public CompoundTag getDimensionRegistry() {
        return this.dimensionRegistry.copy();
    }
}

