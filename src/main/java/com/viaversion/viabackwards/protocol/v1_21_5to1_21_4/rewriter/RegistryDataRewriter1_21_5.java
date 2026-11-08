/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import java.util.List;

public class RegistryDataRewriter1_21_5
extends BackwardsRegistryRewriter {
    public RegistryDataRewriter1_21_5(BackwardsProtocol<?, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
        List<String> list = List.of("pig_variant", "cow_variant", "frog_variant", "cat_variant", "chicken_variant", "test_environment", "test_instance", "wolf_sound_variant");
        for (String string : list) {
            this.remove(string);
        }
    }

    @Override
    public RegistryEntry[] handle(UserConnection userConnection, String string, RegistryEntry[] registryEntryArray) {
        boolean bl = string.equals("trim_pattern");
        if (bl || string.equals("trim_material")) {
            this.updateTrim(registryEntryArray, bl ? "template_item" : "ingredient");
        } else if (string.equals("enchantment")) {
            this.updateEnchantment(registryEntryArray);
        } else if (string.equals("wolf_variant")) {
            for (RegistryEntry registryEntry : registryEntryArray) {
                if (registryEntry.tag() == null) continue;
                CompoundTag compoundTag = (CompoundTag)registryEntry.tag();
                CompoundTag compoundTag2 = (CompoundTag)compoundTag.remove("assets");
                compoundTag.put("wild_texture", compoundTag2.get("wild"));
                compoundTag.put("tame_texture", compoundTag2.get("tame"));
                compoundTag.put("angry_texture", compoundTag2.get("angry"));
                compoundTag.put("biomes", new ListTag<StringTag>(StringTag.class));
            }
        }
        return super.handle(userConnection, string, registryEntryArray);
    }

    private void updateTrim(RegistryEntry[] registryEntryArray, String string) {
        for (RegistryEntry registryEntry : registryEntryArray) {
            if (registryEntry.tag() == null) continue;
            CompoundTag compoundTag = (CompoundTag)registryEntry.tag();
            compoundTag.putString(string, "stone");
        }
    }

    private void updateEnchantment(RegistryEntry[] registryEntryArray) {
        for (RegistryEntry registryEntry : registryEntryArray) {
            CompoundTag compoundTag;
            ListTag<StringTag> listTag;
            if (registryEntry.tag() == null || (listTag = (compoundTag = (CompoundTag)registryEntry.tag()).getListTag("slots", StringTag.class)) == null) continue;
            listTag.getValue().removeIf(stringTag -> stringTag.getValue().equals("saddle"));
        }
    }
}

