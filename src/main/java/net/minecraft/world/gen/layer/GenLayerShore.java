/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerShore
extends GenLayer {
    public GenLayerShore(long l, GenLayer genLayer) {
        super(l);
        this.parent = genLayer;
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        int[] nArray = this.parent.getInts(n - 1, n2 - 1, n3 + 2, n4 + 2);
        int[] nArray2 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n5;
                int n6;
                int n7;
                int n8;
                this.initChunkSeed(j + n, i + n2);
                int n9 = nArray[j + 1 + (i + 1) * (n3 + 2)];
                BiomeGenBase biomeGenBase = BiomeGenBase.getBiome(n9);
                if (n9 == BiomeGenBase.mushroomIsland.biomeID) {
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n8 != BiomeGenBase.ocean.biomeID && n7 != BiomeGenBase.ocean.biomeID && n6 != BiomeGenBase.ocean.biomeID && n5 != BiomeGenBase.ocean.biomeID) {
                        nArray2[j + i * n3] = n9;
                        continue;
                    }
                    nArray2[j + i * n3] = BiomeGenBase.mushroomIslandShore.biomeID;
                    continue;
                }
                if (biomeGenBase != null && biomeGenBase.getBiomeClass() == BiomeGenJungle.class) {
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (this.func_151631_c(n8) && this.func_151631_c(n7) && this.func_151631_c(n6) && this.func_151631_c(n5)) {
                        if (!(GenLayerShore.isBiomeOceanic(n8) || GenLayerShore.isBiomeOceanic(n7) || GenLayerShore.isBiomeOceanic(n6) || GenLayerShore.isBiomeOceanic(n5))) {
                            nArray2[j + i * n3] = n9;
                            continue;
                        }
                        nArray2[j + i * n3] = BiomeGenBase.beach.biomeID;
                        continue;
                    }
                    nArray2[j + i * n3] = BiomeGenBase.jungleEdge.biomeID;
                    continue;
                }
                if (n9 != BiomeGenBase.extremeHills.biomeID && n9 != BiomeGenBase.extremeHillsPlus.biomeID && n9 != BiomeGenBase.extremeHillsEdge.biomeID) {
                    if (biomeGenBase != null && biomeGenBase.isSnowyBiome()) {
                        this.func_151632_a(nArray, nArray2, j, i, n3, n9, BiomeGenBase.coldBeach.biomeID);
                        continue;
                    }
                    if (n9 != BiomeGenBase.mesa.biomeID && n9 != BiomeGenBase.mesaPlateau_F.biomeID) {
                        if (n9 != BiomeGenBase.ocean.biomeID && n9 != BiomeGenBase.deepOcean.biomeID && n9 != BiomeGenBase.river.biomeID && n9 != BiomeGenBase.swampland.biomeID) {
                            n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                            n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                            n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                            n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                            if (!(GenLayerShore.isBiomeOceanic(n8) || GenLayerShore.isBiomeOceanic(n7) || GenLayerShore.isBiomeOceanic(n6) || GenLayerShore.isBiomeOceanic(n5))) {
                                nArray2[j + i * n3] = n9;
                                continue;
                            }
                            nArray2[j + i * n3] = BiomeGenBase.beach.biomeID;
                            continue;
                        }
                        nArray2[j + i * n3] = n9;
                        continue;
                    }
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (!(GenLayerShore.isBiomeOceanic(n8) || GenLayerShore.isBiomeOceanic(n7) || GenLayerShore.isBiomeOceanic(n6) || GenLayerShore.isBiomeOceanic(n5))) {
                        if (this.func_151633_d(n8) && this.func_151633_d(n7) && this.func_151633_d(n6) && this.func_151633_d(n5)) {
                            nArray2[j + i * n3] = n9;
                            continue;
                        }
                        nArray2[j + i * n3] = BiomeGenBase.desert.biomeID;
                        continue;
                    }
                    nArray2[j + i * n3] = n9;
                    continue;
                }
                this.func_151632_a(nArray, nArray2, j, i, n3, n9, BiomeGenBase.stoneBeach.biomeID);
            }
        }
        return nArray2;
    }

    private void func_151632_a(int[] nArray, int[] nArray2, int n, int n2, int n3, int n4, int n5) {
        if (GenLayerShore.isBiomeOceanic(n4)) {
            nArray2[n + n2 * n3] = n4;
        } else {
            int n6 = nArray[n + 1 + (n2 + 1 - 1) * (n3 + 2)];
            int n7 = nArray[n + 1 + 1 + (n2 + 1) * (n3 + 2)];
            int n8 = nArray[n + 1 - 1 + (n2 + 1) * (n3 + 2)];
            int n9 = nArray[n + 1 + (n2 + 1 + 1) * (n3 + 2)];
            nArray2[n + n2 * n3] = !GenLayerShore.isBiomeOceanic(n6) && !GenLayerShore.isBiomeOceanic(n7) && !GenLayerShore.isBiomeOceanic(n8) && !GenLayerShore.isBiomeOceanic(n9) ? n4 : n5;
        }
    }

    private boolean func_151631_c(int n) {
        return BiomeGenBase.getBiome(n) != null && BiomeGenBase.getBiome(n).getBiomeClass() == BiomeGenJungle.class ? true : n == BiomeGenBase.jungleEdge.biomeID || n == BiomeGenBase.jungle.biomeID || n == BiomeGenBase.jungleHills.biomeID || n == BiomeGenBase.forest.biomeID || n == BiomeGenBase.taiga.biomeID || GenLayerShore.isBiomeOceanic(n);
    }

    private boolean func_151633_d(int n) {
        return BiomeGenBase.getBiome(n) instanceof BiomeGenMesa;
    }
}

