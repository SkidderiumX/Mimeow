/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.storage;

import com.google.common.collect.EvictingQueue;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Queue;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockConnectionStorage
implements StorableObject {
    private final Long2ObjectMap<SectionData> blockStorage = new Long2ObjectOpenHashMap<SectionData>();
    private final Queue<BlockPosition> modified = EvictingQueue.create(5);
    private long lastIndex = -1L;
    private SectionData lastSection;

    public static void init() {
    }

    public void store(int n, int n2, int n3, int n4) {
        long l = BlockConnectionStorage.getChunkSectionIndex(n, n2, n3);
        SectionData sectionData = this.getSection(l);
        if (sectionData == null) {
            if (n4 == 0) {
                return;
            }
            sectionData = new SectionData();
            this.blockStorage.put(l, sectionData);
            this.lastSection = sectionData;
            this.lastIndex = l;
        }
        sectionData.setBlockAt(n, n2, n3, n4);
    }

    public int get(int n, int n2, int n3) {
        long l = BlockConnectionStorage.getChunkSectionIndex(n, n2, n3);
        SectionData sectionData = this.getSection(l);
        if (sectionData == null) {
            return 0;
        }
        return sectionData.blockAt(n, n2, n3);
    }

    public void remove(int n, int n2, int n3) {
        long l = BlockConnectionStorage.getChunkSectionIndex(n, n2, n3);
        SectionData sectionData = this.getSection(l);
        if (sectionData == null) {
            return;
        }
        sectionData.setBlockAt(n, n2, n3, 0);
        if (sectionData.nonEmptyBlocks() == 0) {
            this.removeSection(l);
        }
    }

    public void markModified(BlockPosition blockPosition) {
        if (!this.modified.contains(blockPosition)) {
            this.modified.add(blockPosition);
        }
    }

    public boolean recentlyModified(BlockPosition blockPosition) {
        for (BlockPosition blockPosition2 : this.modified) {
            if (Math.abs(blockPosition.x() - blockPosition2.x()) + Math.abs(blockPosition.y() - blockPosition2.y()) + Math.abs(blockPosition.z() - blockPosition2.z()) > 2) continue;
            return true;
        }
        return false;
    }

    public void clear() {
        this.blockStorage.clear();
        this.lastSection = null;
        this.lastIndex = -1L;
        this.modified.clear();
    }

    public void unloadChunk(int n, int n2) {
        for (int i = 0; i < 16; ++i) {
            this.unloadSection(n, i, n2);
        }
    }

    public void unloadSection(int n, int n2, int n3) {
        this.removeSection(BlockConnectionStorage.getChunkSectionIndex(n << 4, n2 << 4, n3 << 4));
    }

    private @Nullable SectionData getSection(long l) {
        if (this.lastIndex == l) {
            return this.lastSection;
        }
        this.lastIndex = l;
        this.lastSection = (SectionData)this.blockStorage.get(l);
        return this.lastSection;
    }

    private void removeSection(long l) {
        this.blockStorage.remove(l);
        if (this.lastIndex == l) {
            this.lastIndex = -1L;
            this.lastSection = null;
        }
    }

    private static long getChunkSectionIndex(int n, int n2, int n3) {
        return ((long)(n >> 4) & 0x3FFFFFFL) << 38 | ((long)(n2 >> 4) & 0xFFFL) << 26 | (long)(n3 >> 4) & 0x3FFFFFFL;
    }

    private static final class SectionData {
        private final short[] blockStates = new short[4096];
        private short nonEmptyBlocks;

        private SectionData() {
        }

        public int blockAt(int n, int n2, int n3) {
            return this.blockStates[SectionData.encodeBlockPos(n, n2, n3)];
        }

        public void setBlockAt(int n, int n2, int n3, int n4) {
            int n5 = SectionData.encodeBlockPos(n, n2, n3);
            if (n4 == this.blockStates[n5]) {
                return;
            }
            this.blockStates[n5] = (short)n4;
            this.nonEmptyBlocks = n4 == 0 ? (short)(this.nonEmptyBlocks - 1) : (short)(this.nonEmptyBlocks + 1);
        }

        public short nonEmptyBlocks() {
            return this.nonEmptyBlocks;
        }

        private static int encodeBlockPos(int n, int n2, int n3) {
            return (n2 & 0xF) << 8 | (n & 0xF) << 4 | n3 & 0xF;
        }
    }
}

