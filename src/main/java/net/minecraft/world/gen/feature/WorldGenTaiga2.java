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

public class WorldGenTaiga2
extends WorldGenAbstractTree {
    private static final IBlockState field_181645_a = Blocks.log.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    private static final IBlockState field_181646_b = Blocks.leaves.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.CHECK_DECAY, false);

    public WorldGenTaiga2(boolean bl) {
        super(bl);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = random.nextInt(4) + 6;
        int n2 = 1 + random.nextInt(2);
        int n3 = n - n2;
        int n4 = 2 + random.nextInt(2);
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
                            Block block = world2.getBlockState(mutableBlockPos.set(n6, i, n5)).getBlock();
                            if (block.getMaterial() == Material.air || block.getMaterial() == Material.leaves) continue;
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
            if ((block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland) && blockPos.getY() < 256 - n - 1) {
                this.func_175921_a(world2, blockPos.down());
                n7 = random.nextInt(2);
                int n8 = 1;
                n6 = 0;
                for (n5 = 0; n5 <= n3; ++n5) {
                    int n9 = blockPos.getY() + n - n5;
                    for (int i = blockPos.getX() - n7; i <= blockPos.getX() + n7; ++i) {
                        int n10 = i - blockPos.getX();
                        for (int j = blockPos.getZ() - n7; j <= blockPos.getZ() + n7; ++j) {
                            BlockPos blockPos2;
                            int n11 = j - blockPos.getZ();
                            if (Math.abs(n10) == n7 && Math.abs(n11) == n7 && n7 > 0 || world2.getBlockState(blockPos2 = new BlockPos(i, n9, j)).getBlock().isFullBlock()) continue;
                            this.setBlockAndNotifyAdequately(world2, blockPos2, field_181646_b);
                        }
                    }
                    if (n7 >= n8) {
                        n7 = n6;
                        n6 = 1;
                        if (++n8 <= n4) continue;
                        n8 = n4;
                        continue;
                    }
                    ++n7;
                }
                n5 = random.nextInt(3);
                for (int i = 0; i < n - n5; ++i) {
                    Block block2 = world2.getBlockState(blockPos.up(i)).getBlock();
                    if (block2.getMaterial() != Material.air && block2.getMaterial() != Material.leaves) continue;
                    this.setBlockAndNotifyAdequately(world2, blockPos.up(i), field_181645_a);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

