/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import java.util.Objects;

public class ChunkPosition {
    private final int chunkX;
    private final int chunkZ;

    public ChunkPosition(int n, int n2) {
        this.chunkX = n;
        this.chunkZ = n2;
    }

    public ChunkPosition(long l) {
        this.chunkX = (int)l;
        this.chunkZ = (int)(l >> 32);
    }

    public int chunkX() {
        return this.chunkX;
    }

    public int chunkZ() {
        return this.chunkZ;
    }

    public long chunkKey() {
        return ChunkPosition.chunkKey(this.chunkX, this.chunkZ);
    }

    public static long chunkKey(int n, int n2) {
        return (long)n & 0xFFFFFFFFL | ((long)n2 & 0xFFFFFFFFL) << 32;
    }

    public static long chunkKeyForBlock(int n, int n2) {
        return ChunkPosition.chunkKey(n >> 4, n2 >> 4);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ChunkPosition chunkPosition = (ChunkPosition)object;
        return this.chunkX == chunkPosition.chunkX && this.chunkZ == chunkPosition.chunkZ;
    }

    public int hashCode() {
        return Objects.hash(this.chunkX, this.chunkZ);
    }

    public String toString() {
        return "ChunkPosition{chunkX=" + this.chunkX + ", chunkZ=" + this.chunkZ + "}";
    }
}

