/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;

public class WorldGenMegaPineTree
extends WorldGenHugeTrees {
    private static final IBlockState field_181633_e = Blocks.log.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    private static final IBlockState field_181634_f = Blocks.leaves.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.CHECK_DECAY, false);
    private static final IBlockState field_181635_g = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
    private boolean useBaseHeight;

    public WorldGenMegaPineTree(boolean bl, boolean bl2) {
        super(bl, 13, 15, field_181633_e, field_181634_f);
        this.useBaseHeight = bl2;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = this.func_150533_a(random);
        if (!this.func_175929_a(world2, random, blockPos, n)) {
            return false;
        }
        this.func_150541_c(world2, blockPos.getX(), blockPos.getZ(), blockPos.getY() + n, 0, random);
        for (int i = 0; i < n; ++i) {
            Block block = world2.getBlockState(blockPos.up(i)).getBlock();
            if (block.getMaterial() == Material.air || block.getMaterial() == Material.leaves) {
                this.setBlockAndNotifyAdequately(world2, blockPos.up(i), this.woodMetadata);
            }
            if (i >= n - 1) continue;
            block = world2.getBlockState(blockPos.add(1, i, 0)).getBlock();
            if (block.getMaterial() == Material.air || block.getMaterial() == Material.leaves) {
                this.setBlockAndNotifyAdequately(world2, blockPos.add(1, i, 0), this.woodMetadata);
            }
            if ((block = world2.getBlockState(blockPos.add(1, i, 1)).getBlock()).getMaterial() == Material.air || block.getMaterial() == Material.leaves) {
                this.setBlockAndNotifyAdequately(world2, blockPos.add(1, i, 1), this.woodMetadata);
            }
            if ((block = world2.getBlockState(blockPos.add(0, i, 1)).getBlock()).getMaterial() != Material.air && block.getMaterial() != Material.leaves) continue;
            this.setBlockAndNotifyAdequately(world2, blockPos.add(0, i, 1), this.woodMetadata);
        }
        return true;
    }

    private void func_150541_c(World world2, int n, int n2, int n3, int n4, Random random) {
        int n5 = random.nextInt(5) + (this.useBaseHeight ? this.baseHeight : 3);
        int n6 = 0;
        for (int i = n3 - n5; i <= n3; ++i) {
            int n7 = n3 - i;
            int n8 = n4 + MathHelper.floor_float((float)n7 / (float)n5 * 3.5f);
            this.func_175925_a(world2, new BlockPos(n, i, n2), n8 + (n7 > 0 && n8 == n6 && (i & 1) == 0 ? 1 : 0));
            n6 = n8;
        }
    }

    @Override
    public void func_180711_a(World world2, Random random, BlockPos blockPos) {
        this.func_175933_b(world2, blockPos.west().north());
        this.func_175933_b(world2, blockPos.east(2).north());
        this.func_175933_b(world2, blockPos.west().south(2));
        this.func_175933_b(world2, blockPos.east(2).south(2));
        for (int i = 0; i < 5; ++i) {
            int n = random.nextInt(64);
            int n2 = n % 8;
            int n3 = n / 8;
            if (n2 != 0 && n2 != 7 && n3 != 0 && n3 != 7) continue;
            this.func_175933_b(world2, blockPos.add(-3 + n2, 0, -3 + n3));
        }
    }

    private void func_175933_b(World world2, BlockPos blockPos) {
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                if (Math.abs(i) == 2 && Math.abs(j) == 2) continue;
                this.func_175934_c(world2, blockPos.add(i, 0, j));
            }
        }
    }

    private void func_175934_c(World world2, BlockPos blockPos) {
        for (int i = 2; i >= -3; --i) {
            BlockPos blockPos2 = blockPos.up(i);
            Block block = world2.getBlockState(blockPos2).getBlock();
            if (block == Blocks.grass || block == Blocks.dirt) {
                this.setBlockAndNotifyAdequately(world2, blockPos2, field_181635_g);
                break;
            }
            if (block.getMaterial() != Material.air && i < 0) break;
        }
    }
}

