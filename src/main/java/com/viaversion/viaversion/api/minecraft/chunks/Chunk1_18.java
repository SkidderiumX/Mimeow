/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import java.util.BitSet;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Chunk1_18
implements Chunk {
    protected final int x;
    protected final int z;
    protected ChunkSection[] sections;
    protected CompoundTag heightMap;
    protected final List<BlockEntity> blockEntities;

    public Chunk1_18(int n, int n2, ChunkSection[] chunkSectionArray, CompoundTag compoundTag, List<BlockEntity> list) {
        this.x = n;
        this.z = n2;
        this.sections = chunkSectionArray;
        this.heightMap = compoundTag;
        this.blockEntities = list;
    }

    @Override
    public boolean isBiomeData() {
        return false;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getZ() {
        return this.z;
    }

    @Override
    public boolean isFullChunk() {
        return true;
    }

    @Override
    public boolean isIgnoreOldLightData() {
        return false;
    }

    @Override
    public void setIgnoreOldLightData(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBitmask() {
        return -1;
    }

    @Override
    public void setBitmask(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable BitSet getChunkMask() {
        return null;
    }

    @Override
    public void setChunkMask(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChunkSection[] getSections() {
        return this.sections;
    }

    @Override
    public void setSections(ChunkSection[] chunkSectionArray) {
        this.sections = chunkSectionArray;
    }

    @Override
    public int @Nullable [] getBiomeData() {
        return null;
    }

    @Override
    public void setBiomeData(int @Nullable [] nArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable CompoundTag getHeightMap() {
        return this.heightMap;
    }

    @Override
    public void setHeightMap(CompoundTag compoundTag) {
        this.heightMap = compoundTag;
    }

    @Override
    public Heightmap[] heightmaps() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setHeightmaps(Heightmap[] heightmapArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CompoundTag> getBlockEntities() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BlockEntity> blockEntities() {
        return this.blockEntities;
    }
}

