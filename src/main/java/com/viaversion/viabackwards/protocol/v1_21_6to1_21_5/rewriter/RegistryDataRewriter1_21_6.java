/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.RegistryAndTags;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;

public class RegistryDataRewriter1_21_6
extends BackwardsRegistryRewriter {
    public RegistryDataRewriter1_21_6(BackwardsProtocol<?, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
        this.remove("dialog");
    }

    @Override
    public RegistryEntry[] handle(UserConnection userConnection, String string, RegistryEntry[] registryEntryArray) {
        if (Key.stripMinecraftNamespace(string).equals("dialog")) {
            String[] stringArray = new String[registryEntryArray.length];
            for (int i = 0; i < registryEntryArray.length; ++i) {
                stringArray[i] = Key.stripMinecraftNamespace(registryEntryArray[i].key());
            }
            Object2ObjectArrayMap<String, CompoundTag> object2ObjectArrayMap = new Object2ObjectArrayMap<String, CompoundTag>();
            for (RegistryEntry registryEntry : registryEntryArray) {
                Tag tag = registryEntry.tag();
                if (!(tag instanceof CompoundTag)) continue;
                CompoundTag compoundTag = (CompoundTag)tag;
                object2ObjectArrayMap.put(Key.stripMinecraftNamespace(registryEntry.key()), compoundTag);
            }
            RegistryAndTags registryAndTags = userConnection.get(RegistryAndTags.class);
            registryAndTags.storeRegistry(new KeyMappings(stringArray), object2ObjectArrayMap);
        }
        return super.handle(userConnection, string, registryEntryArray);
    }
}

