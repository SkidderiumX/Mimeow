/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.GeneratorBushFeature;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenNetherBridge;

public class ChunkProviderHell
implements IChunkProvider {
    private final World worldObj;
    private final boolean field_177466_i;
    private final Random hellRNG;
    private double[] slowsandNoise = new double[256];
    private double[] gravelNoise = new double[256];
    private double[] netherrackExclusivityNoise = new double[256];
    private double[] noiseField;
    private final NoiseGeneratorOctaves netherNoiseGen1;
    private final NoiseGeneratorOctaves netherNoiseGen2;
    private final NoiseGeneratorOctaves netherNoiseGen3;
    private final NoiseGeneratorOctaves slowsandGravelNoiseGen;
    private final NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
    public final NoiseGeneratorOctaves netherNoiseGen6;
    public final NoiseGeneratorOctaves netherNoiseGen7;
    private final WorldGenFire field_177470_t = new WorldGenFire();
    private final WorldGenGlowStone1 field_177469_u = new WorldGenGlowStone1();
    private final WorldGenGlowStone2 field_177468_v = new WorldGenGlowStone2();
    private final WorldGenerator field_177467_w = new WorldGenMinable(Blocks.quartz_ore.getDefaultState(), 14, BlockHelper.forBlock(Blocks.netherrack));
    private final WorldGenHellLava field_177473_x = new WorldGenHellLava(Blocks.flowing_lava, true);
    private final WorldGenHellLava field_177472_y = new WorldGenHellLava(Blocks.flowing_lava, false);
    private final GeneratorBushFeature field_177471_z = new GeneratorBushFeature(Blocks.brown_mushroom);
    private final GeneratorBushFeature field_177465_A = new GeneratorBushFeature(Blocks.red_mushroom);
    private final MapGenNetherBridge genNetherBridge = new MapGenNetherBridge();
    private final MapGenBase netherCaveGenerator = new MapGenCavesHell();
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;

    public ChunkProviderHell(World world2, boolean bl, long l) {
        this.worldObj = world2;
        this.field_177466_i = bl;
        this.hellRNG = new Random(l);
        this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
        this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
        this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
        this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
        this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        world2.setSeaLevel(63);
    }

    public void func_180515_a(int n, int n2, ChunkPrimer chunkPrimer) {
        int n3 = 4;
        int n4 = this.worldObj.getSeaLevel() / 2 + 1;
        int n5 = n3 + 1;
        int n6 = 17;
        int n7 = n3 + 1;
        this.noiseField = this.initializeNoiseField(this.noiseField, n * n3, 0, n2 * n3, n5, n6, n7);
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < 16; ++k) {
                    double d = 0.125;
                    double d2 = this.noiseField[((i + 0) * n7 + j + 0) * n6 + k + 0];
                    double d3 = this.noiseField[((i + 0) * n7 + j + 1) * n6 + k + 0];
                    double d4 = this.noiseField[((i + 1) * n7 + j + 0) * n6 + k + 0];
                    double d5 = this.noiseField[((i + 1) * n7 + j + 1) * n6 + k + 0];
                    double d6 = (this.noiseField[((i + 0) * n7 + j + 0) * n6 + k + 1] - d2) * d;
                    double d7 = (this.noiseField[((i + 0) * n7 + j + 1) * n6 + k + 1] - d3) * d;
                    double d8 = (this.noiseField[((i + 1) * n7 + j + 0) * n6 + k + 1] - d4) * d;
                    double d9 = (this.noiseField[((i + 1) * n7 + j + 1) * n6 + k + 1] - d5) * d;
                    for (int i2 = 0; i2 < 8; ++i2) {
                        double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            double d15 = 0.25;
                            double d16 = d11;
                            double d17 = (d12 - d11) * d15;
                            for (int i4 = 0; i4 < 4; ++i4) {
                                IBlockState iBlockState = null;
                                if (k * 8 + i2 < n4) {
                                    iBlockState = Blocks.lava.getDefaultState();
                                }
                                if (d16 > 0.0) {
                                    iBlockState = Blocks.netherrack.getDefaultState();
                                }
                                int n8 = i3 + i * 4;
                                int n9 = i2 + k * 8;
                                int n10 = i4 + j * 4;
                                chunkPrimer.setBlockState(n8, n9, n10, iBlockState);
                                d16 += d17;
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }

    public void func_180516_b(int n, int n2, ChunkPrimer chunkPrimer) {
        int n3 = this.worldObj.getSeaLevel() + 1;
        double d = 0.03125;
        this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, n * 16, n2 * 16, 0, 16, 16, 1, d, d, 1.0);
        this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, n * 16, 109, n2 * 16, 16, 1, 16, d, 1.0, d);
        this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.netherrackExclusivityNoise, n * 16, n2 * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                boolean bl = this.slowsandNoise[i + j * 16] + this.hellRNG.nextDouble() * 0.2 > 0.0;
                boolean bl2 = this.gravelNoise[i + j * 16] + this.hellRNG.nextDouble() * 0.2 > 0.0;
                int n4 = (int)(this.netherrackExclusivityNoise[i + j * 16] / 3.0 + 3.0 + this.hellRNG.nextDouble() * 0.25);
                int n5 = -1;
                IBlockState iBlockState = Blocks.netherrack.getDefaultState();
                IBlockState iBlockState2 = Blocks.netherrack.getDefaultState();
                for (int k = 127; k >= 0; --k) {
                    if (k < 127 - this.hellRNG.nextInt(5) && k > this.hellRNG.nextInt(5)) {
                        IBlockState iBlockState3 = chunkPrimer.getBlockState(j, k, i);
                        if (iBlockState3.getBlock() != null && iBlockState3.getBlock().getMaterial() != Material.air) {
                            if (iBlockState3.getBlock() != Blocks.netherrack) continue;
                            if (n5 == -1) {
                                if (n4 <= 0) {
                                    iBlockState = null;
                                    iBlockState2 = Blocks.netherrack.getDefaultState();
                                } else if (k >= n3 - 4 && k <= n3 + 1) {
                                    iBlockState = Blocks.netherrack.getDefaultState();
                                    iBlockState2 = Blocks.netherrack.getDefaultState();
                                    if (bl2) {
                                        iBlockState = Blocks.gravel.getDefaultState();
                                        iBlockState2 = Blocks.netherrack.getDefaultState();
                                    }
                                    if (bl) {
                                        iBlockState = Blocks.soul_sand.getDefaultState();
                                        iBlockState2 = Blocks.soul_sand.getDefaultState();
                                    }
                                }
                                if (k < n3 && (iBlockState == null || iBlockState.getBlock().getMaterial() == Material.air)) {
                                    iBlockState = Blocks.lava.getDefaultState();
                                }
                                n5 = n4;
                                if (k >= n3 - 1) {
                                    chunkPrimer.setBlockState(j, k, i, iBlockState);
                                    continue;
                                }
                                chunkPrimer.setBlockState(j, k, i, iBlockState2);
                                continue;
                            }
                            if (n5 <= 0) continue;
                            --n5;
                            chunkPrimer.setBlockState(j, k, i, iBlockState2);
                            continue;
                        }
                        n5 = -1;
                        continue;
                    }
                    chunkPrimer.setBlockState(j, k, i, Blocks.bedrock.getDefaultState());
                }
            }
        }
    }

    @Override
    public Chunk provideChunk(int n, int n2) {
        this.hellRNG.setSeed((long)n * 341873128712L + (long)n2 * 132897987541L);
        ChunkPrimer chunkPrimer = new ChunkPrimer();
        this.func_180515_a(n, n2, chunkPrimer);
        this.func_180516_b(n, n2, chunkPrimer);
        this.netherCaveGenerator.generate(this, this.worldObj, n, n2, chunkPrimer);
        if (this.field_177466_i) {
            this.genNetherBridge.generate(this, this.worldObj, n, n2, chunkPrimer);
        }
        Chunk chunk = new Chunk(this.worldObj, chunkPrimer, n, n2);
        BiomeGenBase[] biomeGenBaseArray = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, n * 16, n2 * 16, 16, 16);
        byte[] byArray = chunk.getBiomeArray();
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = (byte)biomeGenBaseArray[i].biomeID;
        }
        chunk.resetRelightChecks();
        return chunk;
    }

    private double[] initializeNoiseField(double[] dArray, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        if (dArray == null) {
            dArray = new double[n4 * n5 * n6];
        }
        double d = 684.412;
        double d2 = 2053.236;
        this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, n, n2, n3, n4, 1, n6, 1.0, 0.0, 1.0);
        this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, n, n2, n3, n4, 1, n6, 100.0, 0.0, 100.0);
        this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, n, n2, n3, n4, n5, n6, d / 80.0, d2 / 60.0, d / 80.0);
        this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, n, n2, n3, n4, n5, n6, d, d2, d);
        this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, n, n2, n3, n4, n5, n6, d, d2, d);
        int n8 = 0;
        double[] dArray2 = new double[n5];
        for (n7 = 0; n7 < n5; ++n7) {
            dArray2[n7] = Math.cos((double)n7 * Math.PI * 6.0 / (double)n5) * 2.0;
            double d3 = n7;
            if (n7 > n5 / 2) {
                d3 = n5 - 1 - n7;
            }
            if (!(d3 < 4.0)) continue;
            d3 = 4.0 - d3;
            int n9 = n7;
            dArray2[n9] = dArray2[n9] - d3 * d3 * d3 * 10.0;
        }
        for (n7 = 0; n7 < n4; ++n7) {
            for (int i = 0; i < n6; ++i) {
                double d4 = 0.0;
                for (int j = 0; j < n5; ++j) {
                    double d5;
                    double d6 = 0.0;
                    double d7 = dArray2[j];
                    double d8 = this.noiseData2[n8] / 512.0;
                    double d9 = this.noiseData3[n8] / 512.0;
                    double d10 = (this.noiseData1[n8] / 10.0 + 1.0) / 2.0;
                    d6 = d10 < 0.0 ? d8 : (d10 > 1.0 ? d9 : d8 + (d9 - d8) * d10);
                    d6 -= d7;
                    if (j > n5 - 4) {
                        d5 = (float)(j - (n5 - 4)) / 3.0f;
                        d6 = d6 * (1.0 - d5) + -10.0 * d5;
                    }
                    if ((double)j < d4) {
                        d5 = (d4 - (double)j) / 4.0;
                        d5 = MathHelper.clamp_double(d5, 0.0, 1.0);
                        d6 = d6 * (1.0 - d5) + -10.0 * d5;
                    }
                    dArray[n8] = d6;
                    ++n8;
                }
            }
        }
        return dArray;
    }

    @Override
    public boolean chunkExists(int n, int n2) {
        return true;
    }

    @Override
    public void populate(IChunkProvider iChunkProvider, int n, int n2) {
        int n3;
        BlockFalling.fallInstantly = true;
        BlockPos blockPos = new BlockPos(n * 16, 0, n2 * 16);
        ChunkCoordIntPair chunkCoordIntPair = new ChunkCoordIntPair(n, n2);
        this.genNetherBridge.generateStructure(this.worldObj, this.hellRNG, chunkCoordIntPair);
        for (n3 = 0; n3 < 8; ++n3) {
            this.field_177472_y.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
        }
        for (n3 = 0; n3 < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1) + 1; ++n3) {
            this.field_177470_t.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
        }
        for (n3 = 0; n3 < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1); ++n3) {
            this.field_177469_u.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
        }
        for (n3 = 0; n3 < 10; ++n3) {
            this.field_177468_v.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
        }
        if (this.hellRNG.nextBoolean()) {
            this.field_177471_z.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
        }
        if (this.hellRNG.nextBoolean()) {
            this.field_177465_A.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
        }
        for (n3 = 0; n3 < 16; ++n3) {
            this.field_177467_w.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
        }
        for (n3 = 0; n3 < 16; ++n3) {
            this.field_177473_x.generate(this.worldObj, this.hellRNG, blockPos.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
        }
        BlockFalling.fallInstantly = false;
    }

    @Override
    public boolean populateChunk(IChunkProvider iChunkProvider, Chunk chunk, int n, int n2) {
        return false;
    }

    @Override
    public boolean saveChunks(boolean bl, IProgressUpdate iProgressUpdate) {
        return true;
    }

    @Override
    public void saveExtraData() {
    }

    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public String makeString() {
        return "HellRandomLevelSource";
    }

    @Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType enumCreatureType, BlockPos blockPos) {
        if (enumCreatureType == EnumCreatureType.MONSTER) {
            if (this.genNetherBridge.func_175795_b(blockPos)) {
                return this.genNetherBridge.getSpawnList();
            }
            if (this.genNetherBridge.isPositionInStructure(this.worldObj, blockPos) && this.worldObj.getBlockState(blockPos.down()).getBlock() == Blocks.nether_brick) {
                return this.genNetherBridge.getSpawnList();
            }
        }
        BiomeGenBase biomeGenBase = this.worldObj.getBiomeGenForCoords(blockPos);
        return biomeGenBase.getSpawnableList(enumCreatureType);
    }

    @Override
    public BlockPos getStrongholdGen(World world2, String string, BlockPos blockPos) {
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(Chunk chunk, int n, int n2) {
        this.genNetherBridge.generate(this, this.worldObj, n, n2, null);
    }

    @Override
    public Chunk provideChunk(BlockPos blockPos) {
        return this.provideChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4);
    }
}

