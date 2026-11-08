/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.libs.fastutil.longs.LongOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSet;

public class ChunkLoadTracker
implements StorableObject {
    private final LongSet loadedChunks = new LongOpenHashSet();

    public void addChunk(int n, int n2) {
        this.loadedChunks.add(ChunkPosition.chunkKey(n, n2));
    }

    public void removeChunk(int n, int n2) {
        this.loadedChunks.remove(ChunkPosition.chunkKey(n, n2));
    }

    public boolean isChunkLoaded(int n, int n2) {
        return this.loadedChunks.contains(ChunkPosition.chunkKey(n, n2));
    }

    public void clear() {
        this.loadedChunks.clear();
    }
}

