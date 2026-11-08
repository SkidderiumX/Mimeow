/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenOcean
extends BiomeGenBase {
    public BiomeGenOcean(int n) {
        super(n);
        this.spawnableCreatureList.clear();
    }

    @Override
    public BiomeGenBase.TempCategory getTempCategory() {
        return BiomeGenBase.TempCategory.OCEAN;
    }

    @Override
    public void genTerrainBlocks(World world2, Random random, ChunkPrimer chunkPrimer, int n, int n2, double d) {
        super.genTerrainBlocks(world2, random, chunkPrimer, n, n2, d);
    }
}

