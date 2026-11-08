/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenSwamp
extends WorldGenAbstractTree {
    private static final IBlockState field_181648_a = Blocks.log.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    private static final IBlockState field_181649_b = Blocks.leaves.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockOldLeaf.CHECK_DECAY, false);

    public WorldGenSwamp() {
        super(false);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = random.nextInt(4) + 5;
        while (world2.getBlockState(blockPos.down()).getBlock().getMaterial() == Material.water) {
            blockPos = blockPos.down();
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
                    n4 = 3;
                }
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                for (n3 = blockPos.getX() - n4; n3 <= blockPos.getX() + n4 && bl; ++n3) {
                    for (n2 = blockPos.getZ() - n4; n2 <= blockPos.getZ() + n4 && bl; ++n2) {
                        if (i >= 0 && i < 256) {
                            Block block = world2.getBlockState(mutableBlockPos.set(n3, i, n2)).getBlock();
                            if (block.getMaterial() == Material.air || block.getMaterial() == Material.leaves) continue;
                            if (block != Blocks.water && block != Blocks.flowing_water) {
                                bl = false;
                                continue;
                            }
                            if (i <= blockPos.getY()) continue;
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
                BlockPos blockPos2;
                int n5;
                this.func_175921_a(world2, blockPos.down());
                for (n4 = blockPos.getY() - 3 + n; n4 <= blockPos.getY() + n; ++n4) {
                    int n6 = n4 - (blockPos.getY() + n);
                    n3 = 2 - n6 / 2;
                    for (n2 = blockPos.getX() - n3; n2 <= blockPos.getX() + n3; ++n2) {
                        int n7 = n2 - blockPos.getX();
                        for (n5 = blockPos.getZ() - n3; n5 <= blockPos.getZ() + n3; ++n5) {
                            int n8 = n5 - blockPos.getZ();
                            if (Math.abs(n7) == n3 && Math.abs(n8) == n3 && (random.nextInt(2) == 0 || n6 == 0) || world2.getBlockState(blockPos2 = new BlockPos(n2, n4, n5)).getBlock().isFullBlock()) continue;
                            this.setBlockAndNotifyAdequately(world2, blockPos2, field_181649_b);
                        }
                    }
                }
                for (n4 = 0; n4 < n; ++n4) {
                    Block block2 = world2.getBlockState(blockPos.up(n4)).getBlock();
                    if (block2.getMaterial() != Material.air && block2.getMaterial() != Material.leaves && block2 != Blocks.flowing_water && block2 != Blocks.water) continue;
                    this.setBlockAndNotifyAdequately(world2, blockPos.up(n4), field_181648_a);
                }
                for (n4 = blockPos.getY() - 3 + n; n4 <= blockPos.getY() + n; ++n4) {
                    int n9 = n4 - (blockPos.getY() + n);
                    n3 = 2 - n9 / 2;
                    BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                    for (int i = blockPos.getX() - n3; i <= blockPos.getX() + n3; ++i) {
                        for (n5 = blockPos.getZ() - n3; n5 <= blockPos.getZ() + n3; ++n5) {
                            mutableBlockPos.set(i, n4, n5);
                            if (world2.getBlockState(mutableBlockPos).getBlock().getMaterial() != Material.leaves) continue;
                            BlockPos blockPos3 = mutableBlockPos.west();
                            blockPos2 = mutableBlockPos.east();
                            BlockPos blockPos4 = mutableBlockPos.north();
                            BlockPos blockPos5 = mutableBlockPos.south();
                            if (random.nextInt(4) == 0 && world2.getBlockState(blockPos3).getBlock().getMaterial() == Material.air) {
                                this.func_181647_a(world2, blockPos3, BlockVine.EAST);
                            }
                            if (random.nextInt(4) == 0 && world2.getBlockState(blockPos2).getBlock().getMaterial() == Material.air) {
                                this.func_181647_a(world2, blockPos2, BlockVine.WEST);
                            }
                            if (random.nextInt(4) == 0 && world2.getBlockState(blockPos4).getBlock().getMaterial() == Material.air) {
                                this.func_181647_a(world2, blockPos4, BlockVine.SOUTH);
                            }
                            if (random.nextInt(4) != 0 || world2.getBlockState(blockPos5).getBlock().getMaterial() != Material.air) continue;
                            this.func_181647_a(world2, blockPos5, BlockVine.NORTH);
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void func_181647_a(World world2, BlockPos blockPos, PropertyBool propertyBool) {
        IBlockState iBlockState = Blocks.vine.getDefaultState().withProperty(propertyBool, true);
        this.setBlockAndNotifyAdequately(world2, blockPos, iBlockState);
        blockPos = blockPos.down();
        for (int i = 4; world2.getBlockState(blockPos).getBlock().getMaterial() == Material.air && i > 0; --i) {
            this.setBlockAndNotifyAdequately(world2, blockPos, iBlockState);
            blockPos = blockPos.down();
        }
    }
}

