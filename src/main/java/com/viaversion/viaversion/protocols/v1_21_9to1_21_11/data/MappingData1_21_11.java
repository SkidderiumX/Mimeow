/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_9to1_21_11.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;

public class MappingData1_21_11
extends MappingDataBase {
    private CompoundTag timelineRegistry;

    public MappingData1_21_11() {
        super("1.21.9", "1.21.11");
    }

    @Override
    protected void loadExtras(CompoundTag compoundTag) {
        this.timelineRegistry = MappingDataLoader.INSTANCE.loadNBTFromFile("timeline-registry-1.21.11.nbt");
    }

    public CompoundTag timelineRegistry() {
        return this.timelineRegistry;
    }
}

