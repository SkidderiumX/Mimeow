/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeEdge
extends GenLayer {
    public GenLayerBiomeEdge(long l, GenLayer genLayer) {
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
                if (this.replaceBiomeEdgeIfNecessary(nArray, nArray2, j, i, n3, n9, BiomeGenBase.extremeHills.biomeID, BiomeGenBase.extremeHillsEdge.biomeID) || this.replaceBiomeEdge(nArray, nArray2, j, i, n3, n9, BiomeGenBase.mesaPlateau_F.biomeID, BiomeGenBase.mesa.biomeID) || this.replaceBiomeEdge(nArray, nArray2, j, i, n3, n9, BiomeGenBase.mesaPlateau.biomeID, BiomeGenBase.mesa.biomeID) || this.replaceBiomeEdge(nArray, nArray2, j, i, n3, n9, BiomeGenBase.megaTaiga.biomeID, BiomeGenBase.taiga.biomeID)) continue;
                if (n9 == BiomeGenBase.desert.biomeID) {
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n8 != BiomeGenBase.icePlains.biomeID && n7 != BiomeGenBase.icePlains.biomeID && n6 != BiomeGenBase.icePlains.biomeID && n5 != BiomeGenBase.icePlains.biomeID) {
                        nArray2[j + i * n3] = n9;
                        continue;
                    }
                    nArray2[j + i * n3] = BiomeGenBase.extremeHillsPlus.biomeID;
                    continue;
                }
                if (n9 == BiomeGenBase.swampland.biomeID) {
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n8 != BiomeGenBase.desert.biomeID && n7 != BiomeGenBase.desert.biomeID && n6 != BiomeGenBase.desert.biomeID && n5 != BiomeGenBase.desert.biomeID && n8 != BiomeGenBase.coldTaiga.biomeID && n7 != BiomeGenBase.coldTaiga.biomeID && n6 != BiomeGenBase.coldTaiga.biomeID && n5 != BiomeGenBase.coldTaiga.biomeID && n8 != BiomeGenBase.icePlains.biomeID && n7 != BiomeGenBase.icePlains.biomeID && n6 != BiomeGenBase.icePlains.biomeID && n5 != BiomeGenBase.icePlains.biomeID) {
                        if (n8 != BiomeGenBase.jungle.biomeID && n5 != BiomeGenBase.jungle.biomeID && n7 != BiomeGenBase.jungle.biomeID && n6 != BiomeGenBase.jungle.biomeID) {
                            nArray2[j + i * n3] = n9;
                            continue;
                        }
                        nArray2[j + i * n3] = BiomeGenBase.jungleEdge.biomeID;
                        continue;
                    }
                    nArray2[j + i * n3] = BiomeGenBase.plains.biomeID;
                    continue;
                }
                nArray2[j + i * n3] = n9;
            }
        }
        return nArray2;
    }

    private boolean replaceBiomeEdgeIfNecessary(int[] nArray, int[] nArray2, int n, int n2, int n3, int n4, int n5, int n6) {
        if (!GenLayerBiomeEdge.biomesEqualOrMesaPlateau(n4, n5)) {
            return false;
        }
        int n7 = nArray[n + 1 + (n2 + 1 - 1) * (n3 + 2)];
        int n8 = nArray[n + 1 + 1 + (n2 + 1) * (n3 + 2)];
        int n9 = nArray[n + 1 - 1 + (n2 + 1) * (n3 + 2)];
        int n10 = nArray[n + 1 + (n2 + 1 + 1) * (n3 + 2)];
        nArray2[n + n2 * n3] = this.canBiomesBeNeighbors(n7, n5) && this.canBiomesBeNeighbors(n8, n5) && this.canBiomesBeNeighbors(n9, n5) && this.canBiomesBeNeighbors(n10, n5) ? n4 : n6;
        return true;
    }

    private boolean replaceBiomeEdge(int[] nArray, int[] nArray2, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n4 != n5) {
            return false;
        }
        int n7 = nArray[n + 1 + (n2 + 1 - 1) * (n3 + 2)];
        int n8 = nArray[n + 1 + 1 + (n2 + 1) * (n3 + 2)];
        int n9 = nArray[n + 1 - 1 + (n2 + 1) * (n3 + 2)];
        int n10 = nArray[n + 1 + (n2 + 1 + 1) * (n3 + 2)];
        nArray2[n + n2 * n3] = GenLayerBiomeEdge.biomesEqualOrMesaPlateau(n7, n5) && GenLayerBiomeEdge.biomesEqualOrMesaPlateau(n8, n5) && GenLayerBiomeEdge.biomesEqualOrMesaPlateau(n9, n5) && GenLayerBiomeEdge.biomesEqualOrMesaPlateau(n10, n5) ? n4 : n6;
        return true;
    }

    private boolean canBiomesBeNeighbors(int n, int n2) {
        if (GenLayerBiomeEdge.biomesEqualOrMesaPlateau(n, n2)) {
            return true;
        }
        BiomeGenBase biomeGenBase = BiomeGenBase.getBiome(n);
        BiomeGenBase biomeGenBase2 = BiomeGenBase.getBiome(n2);
        if (biomeGenBase != null && biomeGenBase2 != null) {
            BiomeGenBase.TempCategory tempCategory;
            BiomeGenBase.TempCategory tempCategory2 = biomeGenBase.getTempCategory();
            return tempCategory2 == (tempCategory = biomeGenBase2.getTempCategory()) || tempCategory2 == BiomeGenBase.TempCategory.MEDIUM || tempCategory == BiomeGenBase.TempCategory.MEDIUM;
        }
        return false;
    }
}

