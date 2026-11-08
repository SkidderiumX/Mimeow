/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_1to1_19.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.Protocol1_18_2To1_19;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ChatRegistryStorage
implements StorableObject {
    private final Int2ObjectMap<CompoundTag> chatTypes = new Int2ObjectOpenHashMap<CompoundTag>();

    public @Nullable CompoundTag chatType(int n) {
        return this.chatTypes.isEmpty() ? Protocol1_18_2To1_19.MAPPINGS.chatType(n) : (CompoundTag)this.chatTypes.get(n);
    }

    public void addChatType(int n, CompoundTag compoundTag) {
        this.chatTypes.put(n, compoundTag);
    }

    public void clear() {
        this.chatTypes.clear();
    }
}

