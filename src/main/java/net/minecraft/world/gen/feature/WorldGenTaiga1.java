/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenTaiga1
extends WorldGenAbstractTree {
    private static final IBlockState field_181636_a = Blocks.log.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    private static final IBlockState field_181637_b = Blocks.leaves.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.CHECK_DECAY, false);

    public WorldGenTaiga1() {
        super(false);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = random.nextInt(5) + 7;
        int n2 = n - random.nextInt(2) - 3;
        int n3 = n - n2;
        int n4 = 1 + random.nextInt(n3 + 1);
        boolean bl = true;
        if (blockPos.getY() >= 1 && blockPos.getY() + n + 1 <= 256) {
            int n5;
            int n6;
            int n7;
            for (int i = blockPos.getY(); i <= blockPos.getY() + 1 + n && bl; ++i) {
                n7 = 1;
                n7 = i - blockPos.getY() < n2 ? 0 : n4;
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                for (n6 = blockPos.getX() - n7; n6 <= blockPos.getX() + n7 && bl; ++n6) {
                    for (n5 = blockPos.getZ() - n7; n5 <= blockPos.getZ() + n7 && bl; ++n5) {
                        if (i >= 0 && i < 256) {
                            if (this.func_150523_a(world2.getBlockState(mutableBlockPos.set(n6, i, n5)).getBlock())) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            Block block = world2.getBlockState(blockPos.down()).getBlock();
            if ((block == Blocks.grass || block == Blocks.dirt) && blockPos.getY() < 256 - n - 1) {
                int n8;
                this.func_175921_a(world2, blockPos.down());
                n7 = 0;
                for (n8 = blockPos.getY() + n; n8 >= blockPos.getY() + n2; --n8) {
                    for (n6 = blockPos.getX() - n7; n6 <= blockPos.getX() + n7; ++n6) {
                        n5 = n6 - blockPos.getX();
                        for (int i = blockPos.getZ() - n7; i <= blockPos.getZ() + n7; ++i) {
                            BlockPos blockPos2;
                            int n9 = i - blockPos.getZ();
                            if (Math.abs(n5) == n7 && Math.abs(n9) == n7 && n7 > 0 || world2.getBlockState(blockPos2 = new BlockPos(n6, n8, i)).getBlock().isFullBlock()) continue;
                            this.setBlockAndNotifyAdequately(world2, blockPos2, field_181637_b);
                        }
                    }
                    if (n7 >= 1 && n8 == blockPos.getY() + n2 + 1) {
                        --n7;
                        continue;
                    }
                    if (n7 >= n4) continue;
                    ++n7;
                }
                for (n8 = 0; n8 < n - 1; ++n8) {
                    Block block2 = world2.getBlockState(blockPos.up(n8)).getBlock();
                    if (block2.getMaterial() != Material.air && block2.getMaterial() != Material.leaves) continue;
                    this.setBlockAndNotifyAdequately(world2, blockPos.up(n8), field_181636_a);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

