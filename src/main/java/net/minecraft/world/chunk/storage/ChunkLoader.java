/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.NibbleArrayReader;

public class ChunkLoader {
    public static AnvilConverterData load(NBTTagCompound nBTTagCompound) {
        int n = nBTTagCompound.getInteger("xPos");
        int n2 = nBTTagCompound.getInteger("zPos");
        AnvilConverterData anvilConverterData = new AnvilConverterData(n, n2);
        anvilConverterData.blocks = nBTTagCompound.getByteArray("Blocks");
        anvilConverterData.data = new NibbleArrayReader(nBTTagCompound.getByteArray("Data"), 7);
        anvilConverterData.skyLight = new NibbleArrayReader(nBTTagCompound.getByteArray("SkyLight"), 7);
        anvilConverterData.blockLight = new NibbleArrayReader(nBTTagCompound.getByteArray("BlockLight"), 7);
        anvilConverterData.heightmap = nBTTagCompound.getByteArray("HeightMap");
        anvilConverterData.terrainPopulated = nBTTagCompound.getBoolean("TerrainPopulated");
        anvilConverterData.entities = nBTTagCompound.getTagList("Entities", 10);
        anvilConverterData.tileEntities = nBTTagCompound.getTagList("TileEntities", 10);
        anvilConverterData.tileTicks = nBTTagCompound.getTagList("TileTicks", 10);
        try {
            anvilConverterData.lastUpdated = nBTTagCompound.getLong("LastUpdate");
        }
        catch (ClassCastException classCastException) {
            anvilConverterData.lastUpdated = nBTTagCompound.getInteger("LastUpdate");
        }
        return anvilConverterData;
    }

    public static void convertToAnvilFormat(AnvilConverterData anvilConverterData, NBTTagCompound nBTTagCompound, WorldChunkManager worldChunkManager) {
        int n;
        nBTTagCompound.setInteger("xPos", anvilConverterData.x);
        nBTTagCompound.setInteger("zPos", anvilConverterData.z);
        nBTTagCompound.setLong("LastUpdate", anvilConverterData.lastUpdated);
        int[] nArray = new int[anvilConverterData.heightmap.length];
        for (int i = 0; i < anvilConverterData.heightmap.length; ++i) {
            nArray[i] = anvilConverterData.heightmap[i];
        }
        nBTTagCompound.setIntArray("HeightMap", nArray);
        nBTTagCompound.setBoolean("TerrainPopulated", anvilConverterData.terrainPopulated);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < 8; ++i) {
            int n2;
            boolean bl = true;
            for (n = 0; n < 16 && bl; ++n) {
                block3: for (int j = 0; j < 16 && bl; ++j) {
                    for (int k = 0; k < 16; ++k) {
                        int n3 = n << 11 | k << 7 | j + (i << 4);
                        n2 = anvilConverterData.blocks[n3];
                        if (n2 == 0) continue;
                        bl = false;
                        continue block3;
                    }
                }
            }
            if (bl) continue;
            byte[] byArray = new byte[4096];
            NibbleArray nibbleArray = new NibbleArray();
            NibbleArray nibbleArray2 = new NibbleArray();
            NibbleArray nibbleArray3 = new NibbleArray();
            for (n2 = 0; n2 < 16; ++n2) {
                for (int j = 0; j < 16; ++j) {
                    for (int k = 0; k < 16; ++k) {
                        int n4 = n2 << 11 | k << 7 | j + (i << 4);
                        byte by = anvilConverterData.blocks[n4];
                        byArray[j << 8 | k << 4 | n2] = (byte)(by & 0xFF);
                        nibbleArray.set(n2, j, k, anvilConverterData.data.get(n2, j + (i << 4), k));
                        nibbleArray2.set(n2, j, k, anvilConverterData.skyLight.get(n2, j + (i << 4), k));
                        nibbleArray3.set(n2, j, k, anvilConverterData.blockLight.get(n2, j + (i << 4), k));
                    }
                }
            }
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.setByte("Y", (byte)(i & 0xFF));
            nBTTagCompound2.setByteArray("Blocks", byArray);
            nBTTagCompound2.setByteArray("Data", nibbleArray.getData());
            nBTTagCompound2.setByteArray("SkyLight", nibbleArray2.getData());
            nBTTagCompound2.setByteArray("BlockLight", nibbleArray3.getData());
            nBTTagList.appendTag(nBTTagCompound2);
        }
        nBTTagCompound.setTag("Sections", nBTTagList);
        byte[] byArray = new byte[256];
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (n = 0; n < 16; ++n) {
            for (int i = 0; i < 16; ++i) {
                mutableBlockPos.set(anvilConverterData.x << 4 | n, 0, anvilConverterData.z << 4 | i);
                byArray[i << 4 | n] = (byte)(worldChunkManager.getBiomeGenerator((BlockPos)mutableBlockPos, (BiomeGenBase)BiomeGenBase.field_180279_ad).biomeID & 0xFF);
            }
        }
        nBTTagCompound.setByteArray("Biomes", byArray);
        nBTTagCompound.setTag("Entities", anvilConverterData.entities);
        nBTTagCompound.setTag("TileEntities", anvilConverterData.tileEntities);
        if (anvilConverterData.tileTicks != null) {
            nBTTagCompound.setTag("TileTicks", anvilConverterData.tileTicks);
        }
    }

    public static class AnvilConverterData {
        public long lastUpdated;
        public boolean terrainPopulated;
        public byte[] heightmap;
        public NibbleArrayReader blockLight;
        public NibbleArrayReader skyLight;
        public NibbleArrayReader data;
        public byte[] blocks;
        public NBTTagList entities;
        public NBTTagList tileEntities;
        public NBTTagList tileTicks;
        public final int x;
        public final int z;

        public AnvilConverterData(int n, int n2) {
            this.x = n;
            this.z = n2;
        }
    }
}

