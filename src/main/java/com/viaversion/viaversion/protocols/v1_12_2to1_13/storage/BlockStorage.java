/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.HashMap;
import java.util.Map;

public class BlockStorage
implements StorableObject {
    private static final IntSet WHITELIST;
    private final Long2ObjectMap<Map<BlockPosition, ReplacementData>> blocks = new Long2ObjectOpenHashMap<Map<BlockPosition, ReplacementData>>();

    public void store(BlockPosition blockPosition, int n) {
        this.store(blockPosition, n, -1);
    }

    public void store(BlockPosition blockPosition, int n, int n2) {
        if (!WHITELIST.contains(n)) {
            return;
        }
        long l2 = ChunkPosition.chunkKeyForBlock(blockPosition.x(), blockPosition.z());
        this.blocks.computeIfAbsent(l2, l -> new HashMap()).put(blockPosition, new ReplacementData(n, n2));
    }

    public boolean isWelcome(int n) {
        return WHITELIST.contains(n);
    }

    public boolean contains(BlockPosition blockPosition) {
        Map map = (Map)this.blocks.get(ChunkPosition.chunkKeyForBlock(blockPosition.x(), blockPosition.z()));
        return map != null && map.containsKey(blockPosition);
    }

    public ReplacementData get(BlockPosition blockPosition) {
        Map map = (Map)this.blocks.get(ChunkPosition.chunkKeyForBlock(blockPosition.x(), blockPosition.z()));
        return map != null ? (ReplacementData)map.get(blockPosition) : null;
    }

    public ReplacementData remove(BlockPosition blockPosition) {
        long l = ChunkPosition.chunkKeyForBlock(blockPosition.x(), blockPosition.z());
        Map map = (Map)this.blocks.get(l);
        if (map == null) {
            return null;
        }
        ReplacementData replacementData = (ReplacementData)map.remove(blockPosition);
        if (map.isEmpty()) {
            this.blocks.remove(l);
        }
        return replacementData;
    }

    public void removeChunk(int n, int n2) {
        this.blocks.remove(ChunkPosition.chunkKey(n, n2));
    }

    public void clear() {
        this.blocks.clear();
    }

    static {
        int n;
        WHITELIST = new IntOpenHashSet(46);
        WHITELIST.add(5266);
        for (n = 0; n < 16; ++n) {
            WHITELIST.add(972 + n);
        }
        for (n = 0; n < 20; ++n) {
            WHITELIST.add(6854 + n);
        }
        for (n = 0; n < 4; ++n) {
            WHITELIST.add(7110 + n);
        }
        for (n = 0; n < 5; ++n) {
            WHITELIST.add(5447 + n);
        }
    }

    public static final class ReplacementData {
        private final int original;
        private int replacement;

        public ReplacementData(int n, int n2) {
            this.original = n;
            this.replacement = n2;
        }

        public int getOriginal() {
            return this.original;
        }

        public int getReplacement() {
            return this.replacement;
        }

        public void setReplacement(int n) {
            this.replacement = n;
        }
    }
}

