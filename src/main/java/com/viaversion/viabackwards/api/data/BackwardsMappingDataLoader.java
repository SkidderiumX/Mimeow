/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsMappingDataLoader
extends MappingDataLoader {
    public static final BackwardsMappingDataLoader INSTANCE = new BackwardsMappingDataLoader(BackwardsMappingDataLoader.class, "assets/viabackwards/data/");

    public BackwardsMappingDataLoader(Class<?> clazz, String string) {
        super(clazz, string);
    }

    public @Nullable CompoundTag loadNBTFromDir(String string) {
        CompoundTag compoundTag = this.loadNBT(string);
        File file = new File(this.getDataFolder(), string);
        if (!file.exists()) {
            return compoundTag;
        }
        this.getLogger().info("Loading " + string + " from plugin folder");
        try {
            CompoundTag compoundTag2 = (CompoundTag)MAPPINGS_READER.read(file.toPath(), false);
            return this.mergeTags(compoundTag, compoundTag2);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    private CompoundTag mergeTags(CompoundTag compoundTag, CompoundTag compoundTag2) {
        for (Map.Entry<String, Tag> entry : compoundTag2.entrySet()) {
            CompoundTag compoundTag3;
            if (entry.getValue() instanceof CompoundTag && (compoundTag3 = compoundTag.getCompoundTag(entry.getKey())) != null) {
                this.mergeTags(compoundTag3, (CompoundTag)entry.getValue());
                continue;
            }
            compoundTag.put(entry.getKey(), entry.getValue());
        }
        return compoundTag;
    }

    @Override
    public Logger getLogger() {
        return ViaBackwards.getPlatform().getLogger();
    }

    @Override
    public File getDataFolder() {
        return ViaBackwards.getPlatform().getDataFolder();
    }
}

