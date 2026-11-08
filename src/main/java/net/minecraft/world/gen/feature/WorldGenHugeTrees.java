/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenHugeTrees
extends WorldGenAbstractTree {
    protected final int baseHeight;
    protected final IBlockState woodMetadata;
    protected final IBlockState leavesMetadata;
    protected int extraRandomHeight;

    public WorldGenHugeTrees(boolean bl, int n, int n2, IBlockState iBlockState, IBlockState iBlockState2) {
        super(bl);
        this.baseHeight = n;
        this.extraRandomHeight = n2;
        this.woodMetadata = iBlockState;
        this.leavesMetadata = iBlockState2;
    }

    protected int func_150533_a(Random random) {
        int n = random.nextInt(3) + this.baseHeight;
        if (this.extraRandomHeight > 1) {
            n += random.nextInt(this.extraRandomHeight);
        }
        return n;
    }

    private boolean func_175926_c(World world2, BlockPos blockPos, int n) {
        boolean bl = true;
        if (blockPos.getY() >= 1 && blockPos.getY() + n + 1 <= 256) {
            for (int i = 0; i <= 1 + n; ++i) {
                int n2 = 2;
                if (i == 0) {
                    n2 = 1;
                } else if (i >= 1 + n - 2) {
                    n2 = 2;
                }
                for (int j = -n2; j <= n2 && bl; ++j) {
                    for (int k = -n2; k <= n2 && bl; ++k) {
                        if (blockPos.getY() + i >= 0 && blockPos.getY() + i < 256 && this.func_150523_a(world2.getBlockState(blockPos.add(j, i, k)).getBlock())) continue;
                        bl = false;
                    }
                }
            }
            return bl;
        }
        return false;
    }

    private boolean func_175927_a(BlockPos blockPos, World world2) {
        BlockPos blockPos2 = blockPos.down();
        Block block = world2.getBlockState(blockPos2).getBlock();
        if ((block == Blocks.grass || block == Blocks.dirt) && blockPos.getY() >= 2) {
            this.func_175921_a(world2, blockPos2);
            this.func_175921_a(world2, blockPos2.east());
            this.func_175921_a(world2, blockPos2.south());
            this.func_175921_a(world2, blockPos2.south().east());
            return true;
        }
        return false;
    }

    protected boolean func_175929_a(World world2, Random random, BlockPos blockPos, int n) {
        return this.func_175926_c(world2, blockPos, n) && this.func_175927_a(blockPos, world2);
    }

    protected void func_175925_a(World world2, BlockPos blockPos, int n) {
        int n2 = n * n;
        for (int i = -n; i <= n + 1; ++i) {
            for (int j = -n; j <= n + 1; ++j) {
                BlockPos blockPos2;
                Material material;
                int n3 = i - 1;
                int n4 = j - 1;
                if (i * i + j * j > n2 && n3 * n3 + n4 * n4 > n2 && i * i + n4 * n4 > n2 && n3 * n3 + j * j > n2 || (material = world2.getBlockState(blockPos2 = blockPos.add(i, 0, j)).getBlock().getMaterial()) != Material.air && material != Material.leaves) continue;
                this.setBlockAndNotifyAdequately(world2, blockPos2, this.leavesMetadata);
            }
        }
    }

    protected void func_175928_b(World world2, BlockPos blockPos, int n) {
        int n2 = n * n;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                BlockPos blockPos2;
                Material material;
                if (i * i + j * j > n2 || (material = world2.getBlockState(blockPos2 = blockPos.add(i, 0, j)).getBlock().getMaterial()) != Material.air && material != Material.leaves) continue;
                this.setBlockAndNotifyAdequately(world2, blockPos2, this.leavesMetadata);
            }
        }
    }
}

