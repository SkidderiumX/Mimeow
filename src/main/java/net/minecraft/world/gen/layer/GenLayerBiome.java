/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiome
extends GenLayer {
    private BiomeGenBase[] field_151623_c = new BiomeGenBase[]{BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.savanna, BiomeGenBase.savanna, BiomeGenBase.plains};
    private BiomeGenBase[] field_151621_d = new BiomeGenBase[]{BiomeGenBase.forest, BiomeGenBase.roofedForest, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.birchForest, BiomeGenBase.swampland};
    private BiomeGenBase[] field_151622_e = new BiomeGenBase[]{BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.taiga, BiomeGenBase.plains};
    private BiomeGenBase[] field_151620_f = new BiomeGenBase[]{BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.coldTaiga};
    private final ChunkProviderSettings field_175973_g;

    public GenLayerBiome(long l, GenLayer genLayer, WorldType worldType, String string) {
        super(l);
        this.parent = genLayer;
        if (worldType == WorldType.DEFAULT_1_1) {
            this.field_151623_c = new BiomeGenBase[]{BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga};
            this.field_175973_g = null;
        } else {
            this.field_175973_g = worldType == WorldType.CUSTOMIZED ? ChunkProviderSettings.Factory.jsonToFactory(string).func_177864_b() : null;
        }
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        int[] nArray = this.parent.getInts(n, n2, n3, n4);
        int[] nArray2 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.initChunkSeed(j + n, i + n2);
                int n5 = nArray[j + i * n3];
                int n6 = (n5 & 0xF00) >> 8;
                n5 &= 0xFFFFF0FF;
                if (this.field_175973_g != null && this.field_175973_g.fixedBiome >= 0) {
                    nArray2[j + i * n3] = this.field_175973_g.fixedBiome;
                    continue;
                }
                if (GenLayerBiome.isBiomeOceanic(n5)) {
                    nArray2[j + i * n3] = n5;
                    continue;
                }
                if (n5 == BiomeGenBase.mushroomIsland.biomeID) {
                    nArray2[j + i * n3] = n5;
                    continue;
                }
                if (n5 == 1) {
                    if (n6 > 0) {
                        if (this.nextInt(3) == 0) {
                            nArray2[j + i * n3] = BiomeGenBase.mesaPlateau.biomeID;
                            continue;
                        }
                        nArray2[j + i * n3] = BiomeGenBase.mesaPlateau_F.biomeID;
                        continue;
                    }
                    nArray2[j + i * n3] = this.field_151623_c[this.nextInt((int)this.field_151623_c.length)].biomeID;
                    continue;
                }
                if (n5 == 2) {
                    if (n6 > 0) {
                        nArray2[j + i * n3] = BiomeGenBase.jungle.biomeID;
                        continue;
                    }
                    nArray2[j + i * n3] = this.field_151621_d[this.nextInt((int)this.field_151621_d.length)].biomeID;
                    continue;
                }
                if (n5 == 3) {
                    if (n6 > 0) {
                        nArray2[j + i * n3] = BiomeGenBase.megaTaiga.biomeID;
                        continue;
                    }
                    nArray2[j + i * n3] = this.field_151622_e[this.nextInt((int)this.field_151622_e.length)].biomeID;
                    continue;
                }
                nArray2[j + i * n3] = n5 == 4 ? this.field_151620_f[this.nextInt((int)this.field_151620_f.length)].biomeID : BiomeGenBase.mushroomIsland.biomeID;
            }
        }
        return nArray2;
    }
}

