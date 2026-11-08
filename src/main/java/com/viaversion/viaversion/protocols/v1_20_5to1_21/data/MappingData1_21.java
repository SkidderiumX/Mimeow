/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import java.util.Map;

public class MappingData1_21
extends MappingDataBase {
    private ListTag<CompoundTag> enchantments;
    private CompoundTag jukeboxSongs;

    public MappingData1_21() {
        super("1.20.5", "1.21");
    }

    @Override
    protected void loadExtras(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = MappingDataLoader.INSTANCE.loadNBT("enchantments-1.21.nbt");
        this.enchantments = compoundTag2.getListTag("entries", CompoundTag.class);
        this.jukeboxSongs = MappingDataLoader.INSTANCE.loadNBT("jukebox-songs-1.21.nbt");
    }

    public CompoundTag enchantment(int n) {
        return this.enchantments.get(n).copy();
    }

    public RegistryEntry[] jukeboxSongs() {
        RegistryEntry[] registryEntryArray = new RegistryEntry[this.jukeboxSongs.size()];
        int n = 0;
        for (Map.Entry<String, Tag> entry : this.jukeboxSongs.entrySet()) {
            CompoundTag compoundTag = (CompoundTag)entry.getValue();
            registryEntryArray[n++] = new RegistryEntry(entry.getKey(), compoundTag.copy());
        }
        return registryEntryArray;
    }
}

