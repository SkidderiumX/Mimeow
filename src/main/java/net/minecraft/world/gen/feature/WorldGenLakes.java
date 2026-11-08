/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLakes
extends WorldGenerator {
    private Block block;

    public WorldGenLakes(Block block) {
        this.block = block;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        Object object;
        int n;
        int n2;
        blockPos = blockPos.add(-8, 0, -8);
        while (blockPos.getY() > 5 && world2.isAirBlock(blockPos)) {
            blockPos = blockPos.down();
        }
        if (blockPos.getY() <= 4) {
            return false;
        }
        blockPos = blockPos.down(4);
        boolean[] blArray = new boolean[2048];
        int n3 = random.nextInt(4) + 4;
        for (n2 = 0; n2 < n3; ++n2) {
            double d = random.nextDouble() * 6.0 + 3.0;
            double d2 = random.nextDouble() * 4.0 + 2.0;
            double d3 = random.nextDouble() * 6.0 + 3.0;
            double d4 = random.nextDouble() * (16.0 - d - 2.0) + 1.0 + d / 2.0;
            double d5 = random.nextDouble() * (8.0 - d2 - 4.0) + 2.0 + d2 / 2.0;
            double d6 = random.nextDouble() * (16.0 - d3 - 2.0) + 1.0 + d3 / 2.0;
            for (int i = 1; i < 15; ++i) {
                for (int j = 1; j < 15; ++j) {
                    for (int k = 1; k < 7; ++k) {
                        double d7 = ((double)i - d4) / (d / 2.0);
                        double d8 = ((double)k - d5) / (d2 / 2.0);
                        double d9 = ((double)j - d6) / (d3 / 2.0);
                        double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                        if (!(d10 < 1.0)) continue;
                        blArray[(i * 16 + j) * 8 + k] = true;
                    }
                }
            }
        }
        for (n2 = 0; n2 < 16; ++n2) {
            for (int i = 0; i < 16; ++i) {
                for (n = 0; n < 8; ++n) {
                    boolean bl;
                    boolean bl2 = bl = !blArray[(n2 * 16 + i) * 8 + n] && (n2 < 15 && blArray[((n2 + 1) * 16 + i) * 8 + n] || n2 > 0 && blArray[((n2 - 1) * 16 + i) * 8 + n] || i < 15 && blArray[(n2 * 16 + i + 1) * 8 + n] || i > 0 && blArray[(n2 * 16 + (i - 1)) * 8 + n] || n < 7 && blArray[(n2 * 16 + i) * 8 + n + 1] || n > 0 && blArray[(n2 * 16 + i) * 8 + (n - 1)]);
                    if (!bl) continue;
                    object = world2.getBlockState(blockPos.add(n2, n, i)).getBlock().getMaterial();
                    if (n >= 4 && ((Material)object).isLiquid()) {
                        return false;
                    }
                    if (n >= 4 || ((Material)object).isSolid() || world2.getBlockState(blockPos.add(n2, n, i)).getBlock() == this.block) continue;
                    return false;
                }
            }
        }
        for (n2 = 0; n2 < 16; ++n2) {
            for (int i = 0; i < 16; ++i) {
                for (n = 0; n < 8; ++n) {
                    if (!blArray[(n2 * 16 + i) * 8 + n]) continue;
                    world2.setBlockState(blockPos.add(n2, n, i), n >= 4 ? Blocks.air.getDefaultState() : this.block.getDefaultState(), 2);
                }
            }
        }
        for (n2 = 0; n2 < 16; ++n2) {
            for (int i = 0; i < 16; ++i) {
                for (n = 4; n < 8; ++n) {
                    BlockPos blockPos2;
                    if (!blArray[(n2 * 16 + i) * 8 + n] || world2.getBlockState(blockPos2 = blockPos.add(n2, n - 1, i)).getBlock() != Blocks.dirt || world2.getLightFor(EnumSkyBlock.SKY, blockPos.add(n2, n, i)) <= 0) continue;
                    object = world2.getBiomeGenForCoords(blockPos2);
                    if (((BiomeGenBase)object).topBlock.getBlock() == Blocks.mycelium) {
                        world2.setBlockState(blockPos2, Blocks.mycelium.getDefaultState(), 2);
                        continue;
                    }
                    world2.setBlockState(blockPos2, Blocks.grass.getDefaultState(), 2);
                }
            }
        }
        if (this.block.getMaterial() == Material.lava) {
            for (n2 = 0; n2 < 16; ++n2) {
                for (int i = 0; i < 16; ++i) {
                    for (n = 0; n < 8; ++n) {
                        boolean bl;
                        boolean bl3 = bl = !blArray[(n2 * 16 + i) * 8 + n] && (n2 < 15 && blArray[((n2 + 1) * 16 + i) * 8 + n] || n2 > 0 && blArray[((n2 - 1) * 16 + i) * 8 + n] || i < 15 && blArray[(n2 * 16 + i + 1) * 8 + n] || i > 0 && blArray[(n2 * 16 + (i - 1)) * 8 + n] || n < 7 && blArray[(n2 * 16 + i) * 8 + n + 1] || n > 0 && blArray[(n2 * 16 + i) * 8 + (n - 1)]);
                        if (!bl || n >= 4 && random.nextInt(2) == 0 || !world2.getBlockState(blockPos.add(n2, n, i)).getBlock().getMaterial().isSolid()) continue;
                        world2.setBlockState(blockPos.add(n2, n, i), Blocks.stone.getDefaultState(), 2);
                    }
                }
            }
        }
        if (this.block.getMaterial() == Material.water) {
            for (n2 = 0; n2 < 16; ++n2) {
                for (int i = 0; i < 16; ++i) {
                    n = 4;
                    if (!world2.canBlockFreezeWater(blockPos.add(n2, n, i))) continue;
                    world2.setBlockState(blockPos.add(n2, n, i), Blocks.ice.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}

