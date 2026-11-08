/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerRareBiome
extends GenLayer {
    public GenLayerRareBiome(long l, GenLayer genLayer) {
        super(l);
        this.parent = genLayer;
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        int[] nArray = this.parent.getInts(n - 1, n2 - 1, n3 + 2, n4 + 2);
        int[] nArray2 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.initChunkSeed(j + n, i + n2);
                int n5 = nArray[j + 1 + (i + 1) * (n3 + 2)];
                if (this.nextInt(57) == 0) {
                    if (n5 == BiomeGenBase.plains.biomeID) {
                        nArray2[j + i * n3] = BiomeGenBase.plains.biomeID + 128;
                        continue;
                    }
                    nArray2[j + i * n3] = n5;
                    continue;
                }
                nArray2[j + i * n3] = n5;
            }
        }
        return nArray2;
    }
}

