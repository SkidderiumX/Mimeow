/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.storage;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandBlockStorage
implements StorableObject {
    private final Map<Long, Map<BlockPosition, CompoundTag>> storedCommandBlocks = new Long2ObjectOpenHashMap<Map<BlockPosition, CompoundTag>>();
    private boolean permissions;

    public void unloadChunk(int n, int n2) {
        this.storedCommandBlocks.remove(ChunkPosition.chunkKey(n, n2));
    }

    public void addOrUpdateBlock(BlockPosition blockPosition, CompoundTag compoundTag) {
        long l2 = ChunkPosition.chunkKeyForBlock(blockPosition.x(), blockPosition.z());
        Map map = this.storedCommandBlocks.computeIfAbsent(l2, l -> new HashMap());
        map.put(blockPosition, compoundTag);
    }

    public Optional<CompoundTag> getCommandBlock(BlockPosition blockPosition) {
        Map<BlockPosition, CompoundTag> map = this.storedCommandBlocks.get(ChunkPosition.chunkKeyForBlock(blockPosition.x(), blockPosition.z()));
        if (map == null) {
            return Optional.empty();
        }
        CompoundTag compoundTag = map.get(blockPosition);
        if (compoundTag == null) {
            return Optional.empty();
        }
        compoundTag = compoundTag.copy();
        compoundTag.put("powered", new ByteTag(0));
        compoundTag.put("auto", new ByteTag(0));
        compoundTag.put("conditionMet", new ByteTag(0));
        return Optional.of(compoundTag);
    }

    public void unloadChunks() {
        this.storedCommandBlocks.clear();
    }

    public boolean isPermissions() {
        return this.permissions;
    }

    public void setPermissions(boolean bl) {
        this.permissions = bl;
    }
}

