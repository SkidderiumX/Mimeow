/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerRiverMix
extends GenLayer {
    private GenLayer biomePatternGeneratorChain;
    private GenLayer riverPatternGeneratorChain;

    public GenLayerRiverMix(long l, GenLayer genLayer, GenLayer genLayer2) {
        super(l);
        this.biomePatternGeneratorChain = genLayer;
        this.riverPatternGeneratorChain = genLayer2;
    }

    @Override
    public void initWorldGenSeed(long l) {
        this.biomePatternGeneratorChain.initWorldGenSeed(l);
        this.riverPatternGeneratorChain.initWorldGenSeed(l);
        super.initWorldGenSeed(l);
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        int[] nArray = this.biomePatternGeneratorChain.getInts(n, n2, n3, n4);
        int[] nArray2 = this.riverPatternGeneratorChain.getInts(n, n2, n3, n4);
        int[] nArray3 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n3 * n4; ++i) {
            if (nArray[i] != BiomeGenBase.ocean.biomeID && nArray[i] != BiomeGenBase.deepOcean.biomeID) {
                if (nArray2[i] == BiomeGenBase.river.biomeID) {
                    if (nArray[i] == BiomeGenBase.icePlains.biomeID) {
                        nArray3[i] = BiomeGenBase.frozenRiver.biomeID;
                        continue;
                    }
                    if (nArray[i] != BiomeGenBase.mushroomIsland.biomeID && nArray[i] != BiomeGenBase.mushroomIslandShore.biomeID) {
                        nArray3[i] = nArray2[i] & 0xFF;
                        continue;
                    }
                    nArray3[i] = BiomeGenBase.mushroomIslandShore.biomeID;
                    continue;
                }
                nArray3[i] = nArray[i];
                continue;
            }
            nArray3[i] = nArray[i];
        }
        return nArray3;
    }
}

