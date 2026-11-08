/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import java.util.Arrays;
import java.util.Random;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenMesa
extends BiomeGenBase {
    private IBlockState[] field_150621_aC;
    private long field_150622_aD;
    private NoiseGeneratorPerlin field_150623_aE;
    private NoiseGeneratorPerlin field_150624_aF;
    private NoiseGeneratorPerlin field_150625_aG;
    private boolean field_150626_aH;
    private boolean field_150620_aI;

    public BiomeGenMesa(int n, boolean bl, boolean bl2) {
        super(n);
        this.field_150626_aH = bl;
        this.field_150620_aI = bl2;
        this.setDisableRain();
        this.setTemperatureRainfall(2.0f, 0.0f);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.sand.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
        this.fillerBlock = Blocks.stained_hardened_clay.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 20;
        this.theBiomeDecorator.reedsPerChunk = 3;
        this.theBiomeDecorator.cactiPerChunk = 5;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.spawnableCreatureList.clear();
        if (bl2) {
            this.theBiomeDecorator.treesPerChunk = 5;
        }
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random random) {
        return this.worldGeneratorTrees;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos blockPos) {
        return 10387789;
    }

    @Override
    public int getGrassColorAtPos(BlockPos blockPos) {
        return 9470285;
    }

    @Override
    public void decorate(World world2, Random random, BlockPos blockPos) {
        super.decorate(world2, random, blockPos);
    }

    @Override
    public void genTerrainBlocks(World world2, Random random, ChunkPrimer chunkPrimer, int n, int n2, double d) {
        int n3;
        int n4;
        if (this.field_150621_aC == null || this.field_150622_aD != world2.getSeed()) {
            this.func_150619_a(world2.getSeed());
        }
        if (this.field_150623_aE == null || this.field_150624_aF == null || this.field_150622_aD != world2.getSeed()) {
            Random random2 = new Random(this.field_150622_aD);
            this.field_150623_aE = new NoiseGeneratorPerlin(random2, 4);
            this.field_150624_aF = new NoiseGeneratorPerlin(random2, 1);
        }
        this.field_150622_aD = world2.getSeed();
        double d2 = 0.0;
        if (this.field_150626_aH) {
            n4 = (n & 0xFFFFFFF0) + (n2 & 0xF);
            n3 = (n2 & 0xFFFFFFF0) + (n & 0xF);
            double d3 = Math.min(Math.abs(d), this.field_150623_aE.func_151601_a((double)n4 * 0.25, (double)n3 * 0.25));
            if (d3 > 0.0) {
                d2 = d3 * d3 * 2.5;
                double d4 = 0.001953125;
                double d5 = Math.abs(this.field_150624_aF.func_151601_a((double)n4 * d4, (double)n3 * d4));
                double d6 = Math.ceil(d5 * 50.0) + 14.0;
                if (d2 > d6) {
                    d2 = d6;
                }
                d2 += 64.0;
            }
        }
        n4 = n & 0xF;
        n3 = n2 & 0xF;
        int n5 = world2.getSeaLevel();
        IBlockState iBlockState = Blocks.stained_hardened_clay.getDefaultState();
        IBlockState iBlockState2 = this.fillerBlock;
        int n6 = (int)(d / 3.0 + 3.0 + random.nextDouble() * 0.25);
        boolean bl = Math.cos(d / 3.0 * Math.PI) > 0.0;
        int n7 = -1;
        boolean bl2 = false;
        for (int i = 255; i >= 0; --i) {
            IBlockState iBlockState3;
            if (chunkPrimer.getBlockState(n3, i, n4).getBlock().getMaterial() == Material.air && i < (int)d2) {
                chunkPrimer.setBlockState(n3, i, n4, Blocks.stone.getDefaultState());
            }
            if (i <= random.nextInt(5)) {
                chunkPrimer.setBlockState(n3, i, n4, Blocks.bedrock.getDefaultState());
                continue;
            }
            IBlockState iBlockState4 = chunkPrimer.getBlockState(n3, i, n4);
            if (iBlockState4.getBlock().getMaterial() == Material.air) {
                n7 = -1;
                continue;
            }
            if (iBlockState4.getBlock() != Blocks.stone) continue;
            if (n7 == -1) {
                bl2 = false;
                if (n6 <= 0) {
                    iBlockState = null;
                    iBlockState2 = Blocks.stone.getDefaultState();
                } else if (i >= n5 - 4 && i <= n5 + 1) {
                    iBlockState = Blocks.stained_hardened_clay.getDefaultState();
                    iBlockState2 = this.fillerBlock;
                }
                if (i < n5 && (iBlockState == null || iBlockState.getBlock().getMaterial() == Material.air)) {
                    iBlockState = Blocks.water.getDefaultState();
                }
                n7 = n6 + Math.max(0, i - n5);
                if (i < n5 - 1) {
                    chunkPrimer.setBlockState(n3, i, n4, iBlockState2);
                    if (iBlockState2.getBlock() != Blocks.stained_hardened_clay) continue;
                    chunkPrimer.setBlockState(n3, i, n4, iBlockState2.getBlock().getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE));
                    continue;
                }
                if (this.field_150620_aI && i > 86 + n6 * 2) {
                    if (bl) {
                        chunkPrimer.setBlockState(n3, i, n4, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT));
                        continue;
                    }
                    chunkPrimer.setBlockState(n3, i, n4, Blocks.grass.getDefaultState());
                    continue;
                }
                if (i <= n5 + 3 + n6) {
                    chunkPrimer.setBlockState(n3, i, n4, this.topBlock);
                    bl2 = true;
                    continue;
                }
                iBlockState3 = i >= 64 && i <= 127 ? (bl ? Blocks.hardened_clay.getDefaultState() : this.func_180629_a(n, i, n2)) : Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
                chunkPrimer.setBlockState(n3, i, n4, iBlockState3);
                continue;
            }
            if (n7 <= 0) continue;
            --n7;
            if (bl2) {
                chunkPrimer.setBlockState(n3, i, n4, Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE));
                continue;
            }
            iBlockState3 = this.func_180629_a(n, i, n2);
            chunkPrimer.setBlockState(n3, i, n4, iBlockState3);
        }
    }

    private void func_150619_a(long l) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        this.field_150621_aC = new IBlockState[64];
        Arrays.fill(this.field_150621_aC, Blocks.hardened_clay.getDefaultState());
        Random random = new Random(l);
        this.field_150625_aG = new NoiseGeneratorPerlin(random, 1);
        for (n7 = 0; n7 < 64; ++n7) {
            if ((n7 += random.nextInt(5) + 1) >= 64) continue;
            this.field_150621_aC[n7] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
        }
        n7 = random.nextInt(4) + 2;
        for (n6 = 0; n6 < n7; ++n6) {
            n5 = random.nextInt(3) + 1;
            n4 = random.nextInt(64);
            for (n3 = 0; n4 + n3 < 64 && n3 < n5; ++n3) {
                this.field_150621_aC[n4 + n3] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);
            }
        }
        n6 = random.nextInt(4) + 2;
        for (n5 = 0; n5 < n6; ++n5) {
            n4 = random.nextInt(3) + 2;
            n3 = random.nextInt(64);
            for (n2 = 0; n3 + n2 < 64 && n2 < n4; ++n2) {
                this.field_150621_aC[n3 + n2] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
            }
        }
        n5 = random.nextInt(4) + 2;
        for (n4 = 0; n4 < n5; ++n4) {
            n3 = random.nextInt(3) + 1;
            n2 = random.nextInt(64);
            for (n = 0; n2 + n < 64 && n < n3; ++n) {
                this.field_150621_aC[n2 + n] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED);
            }
        }
        n4 = random.nextInt(3) + 3;
        n3 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            n = 1;
            n3 += random.nextInt(16) + 4;
            for (int i = 0; n3 + i < 64 && i < n; ++i) {
                this.field_150621_aC[n3 + i] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
                if (n3 + i > 1 && random.nextBoolean()) {
                    this.field_150621_aC[n3 + i - 1] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
                if (n3 + i >= 63 || !random.nextBoolean()) continue;
                this.field_150621_aC[n3 + i + 1] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
            }
        }
    }

    private IBlockState func_180629_a(int n, int n2, int n3) {
        int n4 = (int)Math.round(this.field_150625_aG.func_151601_a((double)n * 1.0 / 512.0, (double)n * 1.0 / 512.0) * 2.0);
        return this.field_150621_aC[(n2 + n4 + 64) % 64];
    }

    @Override
    protected BiomeGenBase createMutatedBiome(int n) {
        boolean bl = this.biomeID == BiomeGenBase.mesa.biomeID;
        BiomeGenMesa biomeGenMesa = new BiomeGenMesa(n, bl, this.field_150620_aI);
        if (!bl) {
            biomeGenMesa.setHeight(height_LowHills);
            biomeGenMesa.setBiomeName(this.biomeName + " M");
        } else {
            biomeGenMesa.setBiomeName(this.biomeName + " (Bryce)");
        }
        biomeGenMesa.func_150557_a(this.color, true);
        return biomeGenMesa;
    }
}

