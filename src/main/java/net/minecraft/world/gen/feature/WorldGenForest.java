/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenForest
extends WorldGenAbstractTree {
    private static final IBlockState field_181629_a = Blocks.log.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
    private static final IBlockState field_181630_b = Blocks.leaves.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty(BlockOldLeaf.CHECK_DECAY, false);
    private boolean useExtraRandomHeight;

    public WorldGenForest(boolean bl, boolean bl2) {
        super(bl);
        this.useExtraRandomHeight = bl2;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = random.nextInt(3) + 5;
        if (this.useExtraRandomHeight) {
            n += random.nextInt(7);
        }
        boolean bl = true;
        if (blockPos.getY() >= 1 && blockPos.getY() + n + 1 <= 256) {
            int n2;
            int n3;
            int n4;
            for (int i = blockPos.getY(); i <= blockPos.getY() + 1 + n; ++i) {
                n4 = 1;
                if (i == blockPos.getY()) {
                    n4 = 0;
                }
                if (i >= blockPos.getY() + 1 + n - 2) {
                    n4 = 2;
                }
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                for (n3 = blockPos.getX() - n4; n3 <= blockPos.getX() + n4 && bl; ++n3) {
                    for (n2 = blockPos.getZ() - n4; n2 <= blockPos.getZ() + n4 && bl; ++n2) {
                        if (i >= 0 && i < 256) {
                            if (this.func_150523_a(world2.getBlockState(mutableBlockPos.set(n3, i, n2)).getBlock())) continue;
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
                for (n4 = blockPos.getY() - 3 + n; n4 <= blockPos.getY() + n; ++n4) {
                    int n5 = n4 - (blockPos.getY() + n);
                    n3 = 1 - n5 / 2;
                    for (n2 = blockPos.getX() - n3; n2 <= blockPos.getX() + n3; ++n2) {
                        int n6 = n2 - blockPos.getX();
                        for (int i = blockPos.getZ() - n3; i <= blockPos.getZ() + n3; ++i) {
                            BlockPos blockPos2;
                            Block block2;
                            int n7 = i - blockPos.getZ();
                            if (Math.abs(n6) == n3 && Math.abs(n7) == n3 && (random.nextInt(2) == 0 || n5 == 0) || (block2 = world2.getBlockState(blockPos2 = new BlockPos(n2, n4, i)).getBlock()).getMaterial() != Material.air && block2.getMaterial() != Material.leaves) continue;
                            this.setBlockAndNotifyAdequately(world2, blockPos2, field_181630_b);
                        }
                    }
                }
                for (n4 = 0; n4 < n; ++n4) {
                    Block block3 = world2.getBlockState(blockPos.up(n4)).getBlock();
                    if (block3.getMaterial() != Material.air && block3.getMaterial() != Material.leaves) continue;
                    this.setBlockAndNotifyAdequately(world2, blockPos.up(n4), field_181629_a);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

