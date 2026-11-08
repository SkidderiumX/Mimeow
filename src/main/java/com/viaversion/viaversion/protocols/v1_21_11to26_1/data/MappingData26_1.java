/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_11to26_1.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.data.IdRanges;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;

public class MappingData26_1
extends MappingDataBase {
    private IntSet fluidBlockStates;
    private CompoundTag catSoundVariants;
    private CompoundTag cowSoundVariants;
    private CompoundTag pigSoundVariants;
    private CompoundTag chickenSoundVariants;

    public MappingData26_1() {
        super("1.21.11", "26.1");
    }

    @Override
    protected void loadExtras(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = MappingDataLoader.INSTANCE.loadNBTFromFile("sound-variant-registries-26.1.nbt");
        this.catSoundVariants = compoundTag2.getCompoundTag("cat_sound_variant");
        this.cowSoundVariants = compoundTag2.getCompoundTag("cow_sound_variant");
        this.pigSoundVariants = compoundTag2.getCompoundTag("pig_sound_variant");
        this.chickenSoundVariants = compoundTag2.getCompoundTag("chicken_sound_variant");
        this.fluidBlockStates = IdRanges.decode(MappingDataLoader.INSTANCE.loadNBTFromFile("fluids-26.1.nbt").getByteArrayTag("fluids"));
    }

    public CompoundTag catSoundVariants() {
        return this.catSoundVariants;
    }

    public CompoundTag cowSoundVariants() {
        return this.cowSoundVariants;
    }

    public CompoundTag pigSoundVariants() {
        return this.pigSoundVariants;
    }

    public CompoundTag chickenSoundVariants() {
        return this.chickenSoundVariants;
    }

    public IntSet fluidBlockStates() {
        return this.fluidBlockStates;
    }
}

