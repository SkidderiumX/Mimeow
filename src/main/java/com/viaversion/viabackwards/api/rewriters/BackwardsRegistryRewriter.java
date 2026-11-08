/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;

public class BackwardsRegistryRewriter
extends RegistryDataRewriter {
    private final BackwardsProtocol<?, ?, ?, ?> protocol;

    public BackwardsRegistryRewriter(BackwardsProtocol<?, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
        this.protocol = backwardsProtocol;
    }

    @Override
    public RegistryEntry[] handle(UserConnection userConnection, String string, RegistryEntry[] registryEntryArray) {
        if (Key.stripMinecraftNamespace(string).equals("worldgen/biome")) {
            for (RegistryEntry registryEntry : registryEntryArray) {
                CompoundTag compoundTag = (CompoundTag)registryEntry.tag();
                if (compoundTag == null) continue;
                CompoundTag compoundTag2 = compoundTag.getCompoundTag("effects");
                this.updateBiomeEffects(compoundTag2);
                CompoundTag compoundTag3 = compoundTag.getCompoundTag("attributes");
                if (compoundTag3 == null) continue;
                this.updateAttributes(compoundTag3);
            }
        }
        return super.handle(userConnection, string, registryEntryArray);
    }

    @Override
    public void updateJukeboxSongs(RegistryEntry[] registryEntryArray) {
        for (RegistryEntry registryEntry : registryEntryArray) {
            if (registryEntry.tag() == null) continue;
            this.updateSound((CompoundTag)registryEntry.tag(), "sound_event");
        }
    }

    private void updateBiomeEffects(CompoundTag compoundTag) {
        this.updateSound(compoundTag.getCompoundTag("mood_sound"), "sound");
        this.updateSound(compoundTag.getCompoundTag("additions_sound"), "sound");
        this.updateSound(compoundTag.getCompoundTag("music"), "sound");
        this.updateSound(compoundTag, "ambient_sound");
    }

    private void updateAttributes(CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        CompoundTag compoundTag3 = TagUtil.getNamespacedCompoundTag(compoundTag, "audio/background_music");
        if (compoundTag3 != null) {
            this.updateSound(compoundTag3.getCompoundTag("default"), "sound");
        }
        if ((compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, "audio/ambient_sounds")) != null) {
            this.updateSound(compoundTag2, "loop");
            this.updateSound(compoundTag2, "mood");
            this.updateSound(compoundTag2, "additions");
        }
    }

    private void updateSound(CompoundTag compoundTag, String string) {
        if (compoundTag == null) {
            return;
        }
        String string2 = compoundTag.getString(string);
        if (string2 == null) {
            return;
        }
        String string3 = this.protocol.getMappingData().getMappedNamedSound(string2);
        if (string3 == null) {
            compoundTag.putString(string, "minecraft:intentionally_empty");
        } else {
            compoundTag.putString(string, string3);
        }
    }
}

