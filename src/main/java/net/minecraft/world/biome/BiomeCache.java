/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class BiomeCache {
    private final WorldChunkManager chunkManager;
    private long lastCleanupTime;
    private LongHashMap<Block> cacheMap = new LongHashMap();
    private List<Block> cache = Lists.newArrayList();

    public BiomeCache(WorldChunkManager worldChunkManager) {
        this.chunkManager = worldChunkManager;
    }

    public Block getBiomeCacheBlock(int n, int n2) {
        long l = (long)(n >>= 4) & 0xFFFFFFFFL | ((long)(n2 >>= 4) & 0xFFFFFFFFL) << 32;
        Block block = this.cacheMap.getValueByKey(l);
        if (block == null) {
            block = new Block(n, n2);
            this.cacheMap.add(l, block);
            this.cache.add(block);
        }
        block.lastAccessTime = MinecraftServer.getCurrentTimeMillis();
        return block;
    }

    public BiomeGenBase func_180284_a(int n, int n2, BiomeGenBase biomeGenBase) {
        BiomeGenBase biomeGenBase2 = this.getBiomeCacheBlock(n, n2).getBiomeGenAt(n, n2);
        return biomeGenBase2 == null ? biomeGenBase : biomeGenBase2;
    }

    public void cleanupCache() {
        long l = MinecraftServer.getCurrentTimeMillis();
        long l2 = l - this.lastCleanupTime;
        if (l2 > 7500L || l2 < 0L) {
            this.lastCleanupTime = l;
            for (int i = 0; i < this.cache.size(); ++i) {
                Block block = this.cache.get(i);
                long l3 = l - block.lastAccessTime;
                if (l3 <= 30000L && l3 >= 0L) continue;
                this.cache.remove(i--);
                long l4 = (long)block.xPosition & 0xFFFFFFFFL | ((long)block.zPosition & 0xFFFFFFFFL) << 32;
                this.cacheMap.remove(l4);
            }
        }
    }

    public BiomeGenBase[] getCachedBiomes(int n, int n2) {
        return this.getBiomeCacheBlock((int)n, (int)n2).biomes;
    }

    public class Block {
        public float[] rainfallValues = new float[256];
        public BiomeGenBase[] biomes = new BiomeGenBase[256];
        public int xPosition;
        public int zPosition;
        public long lastAccessTime;

        public Block(int n, int n2) {
            this.xPosition = n;
            this.zPosition = n2;
            BiomeCache.this.chunkManager.getRainfall(this.rainfallValues, n << 4, n2 << 4, 16, 16);
            BiomeCache.this.chunkManager.getBiomeGenAt(this.biomes, n << 4, n2 << 4, 16, 16, false);
        }

        public BiomeGenBase getBiomeGenAt(int n, int n2) {
            return this.biomes[n & 0xF | (n2 & 0xF) << 4];
        }
    }
}

