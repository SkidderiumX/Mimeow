/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.Protocol1_19To1_18_2;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DimensionRegistryStorage
implements StorableObject {
    private final Map<String, CompoundTag> dimensions = new HashMap<String, CompoundTag>();
    private final Int2ObjectMap<CompoundTag> chatTypes = new Int2ObjectOpenHashMap<CompoundTag>();

    public @Nullable CompoundTag dimension(String string) {
        CompoundTag compoundTag = this.dimensions.get(Key.stripMinecraftNamespace(string));
        return compoundTag != null ? compoundTag.copy() : null;
    }

    public void addDimension(String string, CompoundTag compoundTag) {
        this.dimensions.put(string, compoundTag);
    }

    public @Nullable CompoundTag chatType(int n) {
        return this.chatTypes.isEmpty() ? Protocol1_19To1_18_2.MAPPINGS.chatType(n) : (CompoundTag)this.chatTypes.get(n);
    }

    public void addChatType(int n, CompoundTag compoundTag) {
        this.chatTypes.put(n, compoundTag);
    }

    public void clear() {
        this.dimensions.clear();
        this.chatTypes.clear();
    }
}

