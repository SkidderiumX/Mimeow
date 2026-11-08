/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.longs.LongOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSet;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ChunkLightStorage
implements StorableObject {
    private final Long2ObjectMap<ChunkLight> lightPackets = new Long2ObjectOpenHashMap<ChunkLight>();
    private final LongSet loadedChunks = new LongOpenHashSet();

    public void storeLight(int n, int n2, ChunkLight chunkLight) {
        this.lightPackets.put(ChunkPosition.chunkKey(n, n2), chunkLight);
    }

    public @Nullable ChunkLight removeLight(int n, int n2) {
        return (ChunkLight)this.lightPackets.remove(ChunkPosition.chunkKey(n, n2));
    }

    public @Nullable ChunkLight getLight(int n, int n2) {
        return (ChunkLight)this.lightPackets.get(ChunkPosition.chunkKey(n, n2));
    }

    public boolean addLoadedChunk(int n, int n2) {
        return this.loadedChunks.add(ChunkPosition.chunkKey(n, n2));
    }

    public boolean isLoaded(int n, int n2) {
        return this.loadedChunks.contains(ChunkPosition.chunkKey(n, n2));
    }

    public void clear(int n, int n2) {
        long l = ChunkPosition.chunkKey(n, n2);
        this.lightPackets.remove(l);
        this.loadedChunks.remove(l);
    }

    public void clear() {
        this.loadedChunks.clear();
        this.lightPackets.clear();
    }

    public record ChunkLight(boolean trustEdges, long[] skyLightMask, long[] blockLightMask, long[] emptySkyLightMask, long[] emptyBlockLightMask, byte[][] skyLight, byte[][] blockLight) {
    }
}

