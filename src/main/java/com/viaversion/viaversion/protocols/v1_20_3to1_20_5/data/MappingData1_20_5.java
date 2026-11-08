/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSet;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MappingData1_20_5
extends MappingDataBase {
    private final Object2ObjectMap<String, CompoundTag> damageTypes = new Object2ObjectOpenHashMap<String, CompoundTag>();

    public MappingData1_20_5() {
        super("1.20.3", "1.20.5");
    }

    @Override
    protected void loadExtras(CompoundTag compoundTag) {
        super.loadExtras(compoundTag);
        CompoundTag compoundTag2 = MappingDataLoader.INSTANCE.loadNBT("damage-types-1.20.3.nbt");
        for (String string : compoundTag2.keySet()) {
            this.damageTypes.put(string, compoundTag2.getCompoundTag(string));
        }
    }

    public int blockId(String string) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullBlockMappings().id(string);
    }

    public @Nullable String blockName(int n) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullBlockMappings().identifier(n);
    }

    public int soundId(String string) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullSoundMappings().id(string);
    }

    public @Nullable String soundName(int n) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullSoundMappings().identifier(n);
    }

    public CompoundTag damageType(String string) {
        return ((CompoundTag)this.damageTypes.get(string)).copy();
    }

    public ObjectSet<String> damageKeys() {
        return this.damageTypes.keySet();
    }
}

