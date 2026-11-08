/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.IdRanges;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;

public class MappingData1_14
extends MappingDataBase {
    private IntSet motionBlocking;
    private IntSet nonFullBlocks;

    public MappingData1_14() {
        super("1.13.2", "1.14");
    }

    @Override
    public void loadExtras(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = MappingDataLoader.INSTANCE.loadNBT("heightmap-1.14.nbt");
        this.motionBlocking = IdRanges.decode(compoundTag2.getByteArrayTag("motionBlocking"));
        if (Via.getConfig().isNonFullBlockLightFix()) {
            this.nonFullBlocks = IdRanges.decode(compoundTag2.getByteArrayTag("nonFullBlocks"));
        }
    }

    public IntSet getMotionBlocking() {
        return this.motionBlocking;
    }

    public IntSet getNonFullBlocks() {
        return this.nonFullBlocks;
    }
}

