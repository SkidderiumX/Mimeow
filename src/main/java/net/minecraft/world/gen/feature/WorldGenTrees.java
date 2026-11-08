/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenTrees
extends WorldGenAbstractTree {
    private static final IBlockState field_181653_a = Blocks.log.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    private static final IBlockState field_181654_b = Blocks.leaves.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, false);
    private final int minTreeHeight;
    private final boolean vinesGrow;
    private final IBlockState metaWood;
    private final IBlockState metaLeaves;

    public WorldGenTrees(boolean bl) {
        this(bl, 4, field_181653_a, field_181654_b, false);
    }

    public WorldGenTrees(boolean bl, int n, IBlockState iBlockState, IBlockState iBlockState2, boolean bl2) {
        super(bl);
        this.minTreeHeight = n;
        this.metaWood = iBlockState;
        this.metaLeaves = iBlockState2;
        this.vinesGrow = bl2;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = random.nextInt(3) + this.minTreeHeight;
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
                BlockPos blockPos2;
                Object object;
                int n5;
                int n6;
                int n7;
                this.func_175921_a(world2, blockPos.down());
                n4 = 3;
                int n8 = 0;
                for (n3 = blockPos.getY() - n4 + n; n3 <= blockPos.getY() + n; ++n3) {
                    n2 = n3 - (blockPos.getY() + n);
                    n7 = n8 + 1 - n2 / 2;
                    for (int i = blockPos.getX() - n7; i <= blockPos.getX() + n7; ++i) {
                        n6 = i - blockPos.getX();
                        for (n5 = blockPos.getZ() - n7; n5 <= blockPos.getZ() + n7; ++n5) {
                            int n9 = n5 - blockPos.getZ();
                            if (Math.abs(n6) == n7 && Math.abs(n9) == n7 && (random.nextInt(2) == 0 || n2 == 0) || ((Block)(object = world2.getBlockState(blockPos2 = new BlockPos(i, n3, n5)).getBlock())).getMaterial() != Material.air && ((Block)object).getMaterial() != Material.leaves && ((Block)object).getMaterial() != Material.vine) continue;
                            this.setBlockAndNotifyAdequately(world2, blockPos2, this.metaLeaves);
                        }
                    }
                }
                for (n3 = 0; n3 < n; ++n3) {
                    Block block2 = world2.getBlockState(blockPos.up(n3)).getBlock();
                    if (block2.getMaterial() != Material.air && block2.getMaterial() != Material.leaves && block2.getMaterial() != Material.vine) continue;
                    this.setBlockAndNotifyAdequately(world2, blockPos.up(n3), this.metaWood);
                    if (!this.vinesGrow || n3 <= 0) continue;
                    if (random.nextInt(3) > 0 && world2.isAirBlock(blockPos.add(-1, n3, 0))) {
                        this.func_181651_a(world2, blockPos.add(-1, n3, 0), BlockVine.EAST);
                    }
                    if (random.nextInt(3) > 0 && world2.isAirBlock(blockPos.add(1, n3, 0))) {
                        this.func_181651_a(world2, blockPos.add(1, n3, 0), BlockVine.WEST);
                    }
                    if (random.nextInt(3) > 0 && world2.isAirBlock(blockPos.add(0, n3, -1))) {
                        this.func_181651_a(world2, blockPos.add(0, n3, -1), BlockVine.SOUTH);
                    }
                    if (random.nextInt(3) <= 0 || !world2.isAirBlock(blockPos.add(0, n3, 1))) continue;
                    this.func_181651_a(world2, blockPos.add(0, n3, 1), BlockVine.NORTH);
                }
                if (this.vinesGrow) {
                    for (n3 = blockPos.getY() - 3 + n; n3 <= blockPos.getY() + n; ++n3) {
                        int n10 = n3 - (blockPos.getY() + n);
                        n7 = 2 - n10 / 2;
                        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                        for (n6 = blockPos.getX() - n7; n6 <= blockPos.getX() + n7; ++n6) {
                            for (n5 = blockPos.getZ() - n7; n5 <= blockPos.getZ() + n7; ++n5) {
                                mutableBlockPos.set(n6, n3, n5);
                                if (world2.getBlockState(mutableBlockPos).getBlock().getMaterial() != Material.leaves) continue;
                                BlockPos blockPos3 = mutableBlockPos.west();
                                blockPos2 = mutableBlockPos.east();
                                object = mutableBlockPos.north();
                                BlockPos blockPos4 = mutableBlockPos.south();
                                if (random.nextInt(4) == 0 && world2.getBlockState(blockPos3).getBlock().getMaterial() == Material.air) {
                                    this.func_181650_b(world2, blockPos3, BlockVine.EAST);
                                }
                                if (random.nextInt(4) == 0 && world2.getBlockState(blockPos2).getBlock().getMaterial() == Material.air) {
                                    this.func_181650_b(world2, blockPos2, BlockVine.WEST);
                                }
                                if (random.nextInt(4) == 0 && world2.getBlockState((BlockPos)object).getBlock().getMaterial() == Material.air) {
                                    this.func_181650_b(world2, (BlockPos)object, BlockVine.SOUTH);
                                }
                                if (random.nextInt(4) != 0 || world2.getBlockState(blockPos4).getBlock().getMaterial() != Material.air) continue;
                                this.func_181650_b(world2, blockPos4, BlockVine.NORTH);
                            }
                        }
                    }
                    if (random.nextInt(5) == 0 && n > 5) {
                        for (n3 = 0; n3 < 2; ++n3) {
                            for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                                if (random.nextInt(4 - n3) != 0) continue;
                                EnumFacing enumFacing2 = enumFacing.getOpposite();
                                this.func_181652_a(world2, random.nextInt(3), blockPos.add(enumFacing2.getFrontOffsetX(), n - 5 + n3, enumFacing2.getFrontOffsetZ()), enumFacing);
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

    private void func_181652_a(World world2, int n, BlockPos blockPos, EnumFacing enumFacing) {
        this.setBlockAndNotifyAdequately(world2, blockPos, Blocks.cocoa.getDefaultState().withProperty(BlockCocoa.AGE, n).withProperty(BlockCocoa.FACING, enumFacing));
    }

    private void func_181651_a(World world2, BlockPos blockPos, PropertyBool propertyBool) {
        this.setBlockAndNotifyAdequately(world2, blockPos, Blocks.vine.getDefaultState().withProperty(propertyBool, true));
    }

    private void func_181650_b(World world2, BlockPos blockPos, PropertyBool propertyBool) {
        this.func_181651_a(world2, blockPos, propertyBool);
        blockPos = blockPos.down();
        for (int i = 4; world2.getBlockState(blockPos).getBlock().getMaterial() == Material.air && i > 0; --i) {
            this.func_181651_a(world2, blockPos, propertyBool);
            blockPos = blockPos.down();
        }
    }
}

