/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkProviderEnd
implements IChunkProvider {
    private Random endRNG;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    public NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    private World endWorld;
    private double[] densities;
    private BiomeGenBase[] biomesForGeneration;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;

    public ChunkProviderEnd(World world2, long l) {
        this.endWorld = world2;
        this.endRNG = new Random(l);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);
    }

    public void func_180520_a(int n, int n2, ChunkPrimer chunkPrimer) {
        int n3 = 2;
        int n4 = n3 + 1;
        int n5 = 33;
        int n6 = n3 + 1;
        this.densities = this.initializeNoiseField(this.densities, n * n3, 0, n2 * n3, n4, n5, n6);
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < 32; ++k) {
                    double d = 0.25;
                    double d2 = this.densities[((i + 0) * n6 + j + 0) * n5 + k + 0];
                    double d3 = this.densities[((i + 0) * n6 + j + 1) * n5 + k + 0];
                    double d4 = this.densities[((i + 1) * n6 + j + 0) * n5 + k + 0];
                    double d5 = this.densities[((i + 1) * n6 + j + 1) * n5 + k + 0];
                    double d6 = (this.densities[((i + 0) * n6 + j + 0) * n5 + k + 1] - d2) * d;
                    double d7 = (this.densities[((i + 0) * n6 + j + 1) * n5 + k + 1] - d3) * d;
                    double d8 = (this.densities[((i + 1) * n6 + j + 0) * n5 + k + 1] - d4) * d;
                    double d9 = (this.densities[((i + 1) * n6 + j + 1) * n5 + k + 1] - d5) * d;
                    for (int i2 = 0; i2 < 4; ++i2) {
                        double d10 = 0.125;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 8; ++i3) {
                            double d15 = 0.125;
                            double d16 = d11;
                            double d17 = (d12 - d11) * d15;
                            for (int i4 = 0; i4 < 8; ++i4) {
                                IBlockState iBlockState = null;
                                if (d16 > 0.0) {
                                    iBlockState = Blocks.end_stone.getDefaultState();
                                }
                                int n7 = i3 + i * 8;
                                int n8 = i2 + k * 4;
                                int n9 = i4 + j * 8;
                                chunkPrimer.setBlockState(n7, n8, n9, iBlockState);
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

    public void func_180519_a(ChunkPrimer chunkPrimer) {
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int n = 1;
                int n2 = -1;
                IBlockState iBlockState = Blocks.end_stone.getDefaultState();
                IBlockState iBlockState2 = Blocks.end_stone.getDefaultState();
                for (int k = 127; k >= 0; --k) {
                    IBlockState iBlockState3 = chunkPrimer.getBlockState(i, k, j);
                    if (iBlockState3.getBlock().getMaterial() == Material.air) {
                        n2 = -1;
                        continue;
                    }
                    if (iBlockState3.getBlock() != Blocks.stone) continue;
                    if (n2 == -1) {
                        if (n <= 0) {
                            iBlockState = Blocks.air.getDefaultState();
                            iBlockState2 = Blocks.end_stone.getDefaultState();
                        }
                        n2 = n;
                        if (k >= 0) {
                            chunkPrimer.setBlockState(i, k, j, iBlockState);
                            continue;
                        }
                        chunkPrimer.setBlockState(i, k, j, iBlockState2);
                        continue;
                    }
                    if (n2 <= 0) continue;
                    --n2;
                    chunkPrimer.setBlockState(i, k, j, iBlockState2);
                }
            }
        }
    }

    @Override
    public Chunk provideChunk(int n, int n2) {
        this.endRNG.setSeed((long)n * 341873128712L + (long)n2 * 132897987541L);
        ChunkPrimer chunkPrimer = new ChunkPrimer();
        this.biomesForGeneration = this.endWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, n * 16, n2 * 16, 16, 16);
        this.func_180520_a(n, n2, chunkPrimer);
        this.func_180519_a(chunkPrimer);
        Chunk chunk = new Chunk(this.endWorld, chunkPrimer, n, n2);
        byte[] byArray = chunk.getBiomeArray();
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = (byte)this.biomesForGeneration[i].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }

    private double[] initializeNoiseField(double[] dArray, int n, int n2, int n3, int n4, int n5, int n6) {
        if (dArray == null) {
            dArray = new double[n4 * n5 * n6];
        }
        double d = 684.412;
        double d2 = 684.412;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, n, n3, n4, n6, 1.121, 1.121, 0.5);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, n, n3, n4, n6, 200.0, 200.0, 0.5);
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, n, n2, n3, n4, n5, n6, (d *= 2.0) / 80.0, d2 / 160.0, d / 80.0);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, n, n2, n3, n4, n5, n6, d, d2, d);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, n, n2, n3, n4, n5, n6, d, d2, d);
        int n7 = 0;
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n6; ++j) {
                float f = (float)(i + n) / 1.0f;
                float f2 = (float)(j + n3) / 1.0f;
                float f3 = 100.0f - MathHelper.sqrt_float(f * f + f2 * f2) * 8.0f;
                if (f3 > 80.0f) {
                    f3 = 80.0f;
                }
                if (f3 < -100.0f) {
                    f3 = -100.0f;
                }
                for (int k = 0; k < n5; ++k) {
                    double d3;
                    double d4 = 0.0;
                    double d5 = this.noiseData2[n7] / 512.0;
                    double d6 = this.noiseData3[n7] / 512.0;
                    double d7 = (this.noiseData1[n7] / 10.0 + 1.0) / 2.0;
                    d4 = d7 < 0.0 ? d5 : (d7 > 1.0 ? d6 : d5 + (d6 - d5) * d7);
                    d4 -= 8.0;
                    d4 += (double)f3;
                    int n8 = 2;
                    if (k > n5 / 2 - n8) {
                        d3 = (float)(k - (n5 / 2 - n8)) / 64.0f;
                        d3 = MathHelper.clamp_double(d3, 0.0, 1.0);
                        d4 = d4 * (1.0 - d3) + -3000.0 * d3;
                    }
                    if (k < (n8 = 8)) {
                        d3 = (float)(n8 - k) / ((float)n8 - 1.0f);
                        d4 = d4 * (1.0 - d3) + -30.0 * d3;
                    }
                    dArray[n7] = d4;
                    ++n7;
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
        BlockFalling.fallInstantly = true;
        BlockPos blockPos = new BlockPos(n * 16, 0, n2 * 16);
        this.endWorld.getBiomeGenForCoords(blockPos.add(16, 0, 16)).decorate(this.endWorld, this.endWorld.rand, blockPos);
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
        return "RandomLevelSource";
    }

    @Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType enumCreatureType, BlockPos blockPos) {
        return this.endWorld.getBiomeGenForCoords(blockPos).getSpawnableList(enumCreatureType);
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
    }

    @Override
    public Chunk provideChunk(BlockPos blockPos) {
        return this.provideChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4);
    }
}

