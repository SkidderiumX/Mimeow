/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkManager {
    private GenLayer genBiomes;
    private GenLayer biomeIndexLayer;
    private BiomeCache biomeCache = new BiomeCache(this);
    private List<BiomeGenBase> biomesToSpawnIn = Lists.newArrayList();
    private String generatorOptions = "";

    protected WorldChunkManager() {
        this.biomesToSpawnIn.add(BiomeGenBase.forest);
        this.biomesToSpawnIn.add(BiomeGenBase.plains);
        this.biomesToSpawnIn.add(BiomeGenBase.taiga);
        this.biomesToSpawnIn.add(BiomeGenBase.taigaHills);
        this.biomesToSpawnIn.add(BiomeGenBase.forestHills);
        this.biomesToSpawnIn.add(BiomeGenBase.jungle);
        this.biomesToSpawnIn.add(BiomeGenBase.jungleHills);
    }

    public WorldChunkManager(long l, WorldType worldType, String string) {
        this();
        this.generatorOptions = string;
        GenLayer[] genLayerArray = GenLayer.initializeAllBiomeGenerators(l, worldType, string);
        this.genBiomes = genLayerArray[0];
        this.biomeIndexLayer = genLayerArray[1];
    }

    public WorldChunkManager(World world2) {
        this(world2.getSeed(), world2.getWorldInfo().getTerrainType(), world2.getWorldInfo().getGeneratorOptions());
    }

    public List<BiomeGenBase> getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenerator(BlockPos blockPos) {
        return this.getBiomeGenerator(blockPos, null);
    }

    public BiomeGenBase getBiomeGenerator(BlockPos blockPos, BiomeGenBase biomeGenBase) {
        return this.biomeCache.func_180284_a(blockPos.getX(), blockPos.getZ(), biomeGenBase);
    }

    public float[] getRainfall(float[] fArray, int n, int n2, int n3, int n4) {
        IntCache.resetIntCache();
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        int[] nArray = this.biomeIndexLayer.getInts(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            try {
                float f = (float)BiomeGenBase.getBiomeFromBiomeList(nArray[i], BiomeGenBase.field_180279_ad).getIntRainfall() / 65536.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                fArray[i] = f;
                continue;
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("DownfallBlock");
                crashReportCategory.addCrashSection("biome id", i);
                crashReportCategory.addCrashSection("downfalls[] size", fArray.length);
                crashReportCategory.addCrashSection("x", n);
                crashReportCategory.addCrashSection("z", n2);
                crashReportCategory.addCrashSection("w", n3);
                crashReportCategory.addCrashSection("h", n4);
                throw new ReportedException(crashReport);
            }
        }
        return fArray;
    }

    public float getTemperatureAtHeight(float f, int n) {
        return f;
    }

    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4) {
        IntCache.resetIntCache();
        if (biomeGenBaseArray == null || biomeGenBaseArray.length < n3 * n4) {
            biomeGenBaseArray = new BiomeGenBase[n3 * n4];
        }
        int[] nArray = this.genBiomes.getInts(n, n2, n3, n4);
        try {
            for (int i = 0; i < n3 * n4; ++i) {
                biomeGenBaseArray[i] = BiomeGenBase.getBiomeFromBiomeList(nArray[i], BiomeGenBase.field_180279_ad);
            }
            return biomeGenBaseArray;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("RawBiomeBlock");
            crashReportCategory.addCrashSection("biomes[] size", biomeGenBaseArray.length);
            crashReportCategory.addCrashSection("x", n);
            crashReportCategory.addCrashSection("z", n2);
            crashReportCategory.addCrashSection("w", n3);
            crashReportCategory.addCrashSection("h", n4);
            throw new ReportedException(crashReport);
        }
    }

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4) {
        return this.getBiomeGenAt(biomeGenBaseArray, n, n2, n3, n4, true);
    }

    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4, boolean bl) {
        IntCache.resetIntCache();
        if (biomeGenBaseArray == null || biomeGenBaseArray.length < n3 * n4) {
            biomeGenBaseArray = new BiomeGenBase[n3 * n4];
        }
        if (bl && n3 == 16 && n4 == 16 && (n & 0xF) == 0 && (n2 & 0xF) == 0) {
            BiomeGenBase[] biomeGenBaseArray2 = this.biomeCache.getCachedBiomes(n, n2);
            System.arraycopy(biomeGenBaseArray2, 0, biomeGenBaseArray, 0, n3 * n4);
            return biomeGenBaseArray;
        }
        int[] nArray = this.biomeIndexLayer.getInts(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            biomeGenBaseArray[i] = BiomeGenBase.getBiomeFromBiomeList(nArray[i], BiomeGenBase.field_180279_ad);
        }
        return biomeGenBaseArray;
    }

    public boolean areBiomesViable(int n, int n2, int n3, List<BiomeGenBase> list) {
        IntCache.resetIntCache();
        int n4 = n - n3 >> 2;
        int n5 = n2 - n3 >> 2;
        int n6 = n + n3 >> 2;
        int n7 = n2 + n3 >> 2;
        int n8 = n6 - n4 + 1;
        int n9 = n7 - n5 + 1;
        int[] nArray = this.genBiomes.getInts(n4, n5, n8, n9);
        try {
            for (int i = 0; i < n8 * n9; ++i) {
                BiomeGenBase biomeGenBase = BiomeGenBase.getBiome(nArray[i]);
                if (list.contains(biomeGenBase)) continue;
                return false;
            }
            return true;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Layer");
            crashReportCategory.addCrashSection("Layer", this.genBiomes.toString());
            crashReportCategory.addCrashSection("x", n);
            crashReportCategory.addCrashSection("z", n2);
            crashReportCategory.addCrashSection("radius", n3);
            crashReportCategory.addCrashSection("allowed", list);
            throw new ReportedException(crashReport);
        }
    }

    public BlockPos findBiomePosition(int n, int n2, int n3, List<BiomeGenBase> list, Random random) {
        IntCache.resetIntCache();
        int n4 = n - n3 >> 2;
        int n5 = n2 - n3 >> 2;
        int n6 = n + n3 >> 2;
        int n7 = n2 + n3 >> 2;
        int n8 = n6 - n4 + 1;
        int n9 = n7 - n5 + 1;
        int[] nArray = this.genBiomes.getInts(n4, n5, n8, n9);
        BlockPos blockPos = null;
        int n10 = 0;
        for (int i = 0; i < n8 * n9; ++i) {
            int n11 = n4 + i % n8 << 2;
            int n12 = n5 + i / n8 << 2;
            BiomeGenBase biomeGenBase = BiomeGenBase.getBiome(nArray[i]);
            if (!list.contains(biomeGenBase) || blockPos != null && random.nextInt(n10 + 1) != 0) continue;
            blockPos = new BlockPos(n11, 0, n12);
            ++n10;
        }
        return blockPos;
    }

    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
}

