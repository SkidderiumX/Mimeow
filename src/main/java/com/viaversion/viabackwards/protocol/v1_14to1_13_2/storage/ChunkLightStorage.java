/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Arrays;

public class ChunkLightStorage
implements StorableObject {
    public static final byte[] FULL_LIGHT = new byte[2048];
    public static final byte[] EMPTY_LIGHT = new byte[2048];
    private final Long2ObjectMap<ChunkLight> storedLight = new Long2ObjectOpenHashMap<ChunkLight>();

    public void setStoredLight(byte[][] byArray, byte[][] byArray2, int n, int n2) {
        this.storedLight.put(this.getChunkSectionIndex(n, n2), new ChunkLight(byArray, byArray2));
    }

    public ChunkLight getStoredLight(int n, int n2) {
        return (ChunkLight)this.storedLight.get(this.getChunkSectionIndex(n, n2));
    }

    public void clear() {
        this.storedLight.clear();
    }

    public void unloadChunk(int n, int n2) {
        this.storedLight.remove(this.getChunkSectionIndex(n, n2));
    }

    private long getChunkSectionIndex(int n, int n2) {
        return ((long)n & 0x3FFFFFFL) << 38 | (long)n2 & 0x3FFFFFFL;
    }

    static {
        Arrays.fill(FULL_LIGHT, (byte)-1);
        Arrays.fill(EMPTY_LIGHT, (byte)0);
    }

    public record ChunkLight(byte[][] skyLight, byte[][] blockLight) {
        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            ChunkLight chunkLight = (ChunkLight)object;
            if (!Arrays.deepEquals((Object[])this.skyLight, (Object[])chunkLight.skyLight)) {
                return false;
            }
            return Arrays.deepEquals((Object[])this.blockLight, (Object[])chunkLight.blockLight);
        }

        @Override
        public int hashCode() {
            int n = Arrays.deepHashCode((Object[])this.skyLight);
            n = 31 * n + Arrays.deepHashCode((Object[])this.blockLight);
            return n;
        }
    }
}

