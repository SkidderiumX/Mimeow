/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenSavannaTree
extends WorldGenAbstractTree {
    private static final IBlockState field_181643_a = Blocks.log2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA);
    private static final IBlockState field_181644_b = Blocks.leaves2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLeaves.CHECK_DECAY, false);

    public WorldGenSavannaTree(boolean bl) {
        super(bl);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = random.nextInt(3) + random.nextInt(3) + 5;
        boolean bl = true;
        if (blockPos.getY() >= 1 && blockPos.getY() + n + 1 <= 256) {
            int n2;
            int n3;
            for (int i = blockPos.getY(); i <= blockPos.getY() + 1 + n; ++i) {
                int n4 = 1;
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
            if ((block == Blocks.grass || block == Blocks.dirt) && blockPos.getY() < 256 - n - 1) {
                int n5;
                this.func_175921_a(world2, blockPos.down());
                EnumFacing enumFacing = EnumFacing.Plane.HORIZONTAL.random(random);
                int n6 = n - random.nextInt(4) - 1;
                n3 = 3 - random.nextInt(3);
                n2 = blockPos.getX();
                int n7 = blockPos.getZ();
                int n8 = 0;
                for (int i = 0; i < n; ++i) {
                    BlockPos blockPos2;
                    Material material;
                    n5 = blockPos.getY() + i;
                    if (i >= n6 && n3 > 0) {
                        n2 += enumFacing.getFrontOffsetX();
                        n7 += enumFacing.getFrontOffsetZ();
                        --n3;
                    }
                    if ((material = world2.getBlockState(blockPos2 = new BlockPos(n2, n5, n7)).getBlock().getMaterial()) != Material.air && material != Material.leaves) continue;
                    this.func_181642_b(world2, blockPos2);
                    n8 = n5;
                }
                BlockPos blockPos3 = new BlockPos(n2, n8, n7);
                for (n5 = -3; n5 <= 3; ++n5) {
                    for (int i = -3; i <= 3; ++i) {
                        if (Math.abs(n5) == 3 && Math.abs(i) == 3) continue;
                        this.func_175924_b(world2, blockPos3.add(n5, 0, i));
                    }
                }
                blockPos3 = blockPos3.up();
                for (n5 = -1; n5 <= 1; ++n5) {
                    for (int i = -1; i <= 1; ++i) {
                        this.func_175924_b(world2, blockPos3.add(n5, 0, i));
                    }
                }
                this.func_175924_b(world2, blockPos3.east(2));
                this.func_175924_b(world2, blockPos3.west(2));
                this.func_175924_b(world2, blockPos3.south(2));
                this.func_175924_b(world2, blockPos3.north(2));
                n2 = blockPos.getX();
                n7 = blockPos.getZ();
                EnumFacing enumFacing2 = EnumFacing.Plane.HORIZONTAL.random(random);
                if (enumFacing2 != enumFacing) {
                    int n9;
                    int n10 = n6 - random.nextInt(2) - 1;
                    int n11 = 1 + random.nextInt(3);
                    n8 = 0;
                    for (int i = n10; i < n && n11 > 0; ++i, --n11) {
                        if (i < 1) continue;
                        n9 = blockPos.getY() + i;
                        BlockPos blockPos4 = new BlockPos(n2 += enumFacing2.getFrontOffsetX(), n9, n7 += enumFacing2.getFrontOffsetZ());
                        Material material = world2.getBlockState(blockPos4).getBlock().getMaterial();
                        if (material != Material.air && material != Material.leaves) continue;
                        this.func_181642_b(world2, blockPos4);
                        n8 = n9;
                    }
                    if (n8 > 0) {
                        BlockPos blockPos5 = new BlockPos(n2, n8, n7);
                        for (n9 = -2; n9 <= 2; ++n9) {
                            for (int i = -2; i <= 2; ++i) {
                                if (Math.abs(n9) == 2 && Math.abs(i) == 2) continue;
                                this.func_175924_b(world2, blockPos5.add(n9, 0, i));
                            }
                        }
                        blockPos5 = blockPos5.up();
                        for (n9 = -1; n9 <= 1; ++n9) {
                            for (int i = -1; i <= 1; ++i) {
                                this.func_175924_b(world2, blockPos5.add(n9, 0, i));
                            }
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void func_181642_b(World world2, BlockPos blockPos) {
        this.setBlockAndNotifyAdequately(world2, blockPos, field_181643_a);
    }

    private void func_175924_b(World world2, BlockPos blockPos) {
        Material material = world2.getBlockState(blockPos).getBlock().getMaterial();
        if (material == Material.air || material == Material.leaves) {
            this.setBlockAndNotifyAdequately(world2, blockPos, field_181644_b);
        }
    }
}

