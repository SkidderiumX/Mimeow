/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenLayerHills
extends GenLayer {
    private static final Logger logger = LogManager.getLogger();
    private GenLayer field_151628_d;

    public GenLayerHills(long l, GenLayer genLayer, GenLayer genLayer2) {
        super(l);
        this.parent = genLayer;
        this.field_151628_d = genLayer2;
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        int[] nArray = this.parent.getInts(n - 1, n2 - 1, n3 + 2, n4 + 2);
        int[] nArray2 = this.field_151628_d.getInts(n - 1, n2 - 1, n3 + 2, n4 + 2);
        int[] nArray3 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n5;
                boolean bl;
                this.initChunkSeed(j + n, i + n2);
                int n6 = nArray[j + 1 + (i + 1) * (n3 + 2)];
                int n7 = nArray2[j + 1 + (i + 1) * (n3 + 2)];
                boolean bl2 = bl = (n7 - 2) % 29 == 0;
                if (n6 > 255) {
                    logger.debug("old! " + n6);
                }
                if (n6 != 0 && n7 >= 2 && (n7 - 2) % 29 == 1 && n6 < 128) {
                    if (BiomeGenBase.getBiome(n6 + 128) != null) {
                        nArray3[j + i * n3] = n6 + 128;
                        continue;
                    }
                    nArray3[j + i * n3] = n6;
                    continue;
                }
                if (this.nextInt(3) != 0 && !bl) {
                    nArray3[j + i * n3] = n6;
                    continue;
                }
                int n8 = n6;
                if (n6 == BiomeGenBase.desert.biomeID) {
                    n8 = BiomeGenBase.desertHills.biomeID;
                } else if (n6 == BiomeGenBase.forest.biomeID) {
                    n8 = BiomeGenBase.forestHills.biomeID;
                } else if (n6 == BiomeGenBase.birchForest.biomeID) {
                    n8 = BiomeGenBase.birchForestHills.biomeID;
                } else if (n6 == BiomeGenBase.roofedForest.biomeID) {
                    n8 = BiomeGenBase.plains.biomeID;
                } else if (n6 == BiomeGenBase.taiga.biomeID) {
                    n8 = BiomeGenBase.taigaHills.biomeID;
                } else if (n6 == BiomeGenBase.megaTaiga.biomeID) {
                    n8 = BiomeGenBase.megaTaigaHills.biomeID;
                } else if (n6 == BiomeGenBase.coldTaiga.biomeID) {
                    n8 = BiomeGenBase.coldTaigaHills.biomeID;
                } else if (n6 == BiomeGenBase.plains.biomeID) {
                    n8 = this.nextInt(3) == 0 ? BiomeGenBase.forestHills.biomeID : BiomeGenBase.forest.biomeID;
                } else if (n6 == BiomeGenBase.icePlains.biomeID) {
                    n8 = BiomeGenBase.iceMountains.biomeID;
                } else if (n6 == BiomeGenBase.jungle.biomeID) {
                    n8 = BiomeGenBase.jungleHills.biomeID;
                } else if (n6 == BiomeGenBase.ocean.biomeID) {
                    n8 = BiomeGenBase.deepOcean.biomeID;
                } else if (n6 == BiomeGenBase.extremeHills.biomeID) {
                    n8 = BiomeGenBase.extremeHillsPlus.biomeID;
                } else if (n6 == BiomeGenBase.savanna.biomeID) {
                    n8 = BiomeGenBase.savannaPlateau.biomeID;
                } else if (GenLayerHills.biomesEqualOrMesaPlateau(n6, BiomeGenBase.mesaPlateau_F.biomeID)) {
                    n8 = BiomeGenBase.mesa.biomeID;
                } else if (n6 == BiomeGenBase.deepOcean.biomeID && this.nextInt(3) == 0) {
                    n5 = this.nextInt(2);
                    n8 = n5 == 0 ? BiomeGenBase.plains.biomeID : BiomeGenBase.forest.biomeID;
                }
                if (bl && n8 != n6) {
                    n8 = BiomeGenBase.getBiome(n8 + 128) != null ? (n8 += 128) : n6;
                }
                if (n8 == n6) {
                    nArray3[j + i * n3] = n6;
                    continue;
                }
                n5 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                int n9 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                int n10 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                int n11 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                int n12 = 0;
                if (GenLayerHills.biomesEqualOrMesaPlateau(n5, n6)) {
                    ++n12;
                }
                if (GenLayerHills.biomesEqualOrMesaPlateau(n9, n6)) {
                    ++n12;
                }
                if (GenLayerHills.biomesEqualOrMesaPlateau(n10, n6)) {
                    ++n12;
                }
                if (GenLayerHills.biomesEqualOrMesaPlateau(n11, n6)) {
                    ++n12;
                }
                nArray3[j + i * n3] = n12 >= 3 ? n8 : n6;
            }
        }
        return nArray3;
    }
}

