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

public class WorldGenCanopyTree
extends WorldGenAbstractTree {
    private static final IBlockState field_181640_a = Blocks.log2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    private static final IBlockState field_181641_b = Blocks.leaves2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockLeaves.CHECK_DECAY, false);

    public WorldGenCanopyTree(boolean bl) {
        super(bl);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n = random.nextInt(3) + random.nextInt(2) + 6;
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        if (n3 >= 1 && n3 + n + 1 < 256) {
            int n5;
            int n6;
            BlockPos blockPos2 = blockPos.down();
            Block block = world2.getBlockState(blockPos2).getBlock();
            if (block != Blocks.grass && block != Blocks.dirt) {
                return false;
            }
            if (!this.func_181638_a(world2, blockPos, n)) {
                return false;
            }
            this.func_175921_a(world2, blockPos2);
            this.func_175921_a(world2, blockPos2.east());
            this.func_175921_a(world2, blockPos2.south());
            this.func_175921_a(world2, blockPos2.south().east());
            EnumFacing enumFacing = EnumFacing.Plane.HORIZONTAL.random(random);
            int n7 = n - random.nextInt(4);
            int n8 = 2 - random.nextInt(3);
            int n9 = n2;
            int n10 = n4;
            int n11 = n3 + n - 1;
            for (n6 = 0; n6 < n; ++n6) {
                BlockPos blockPos3;
                Material material;
                if (n6 >= n7 && n8 > 0) {
                    n9 += enumFacing.getFrontOffsetX();
                    n10 += enumFacing.getFrontOffsetZ();
                    --n8;
                }
                if ((material = world2.getBlockState(blockPos3 = new BlockPos(n9, n5 = n3 + n6, n10)).getBlock().getMaterial()) != Material.air && material != Material.leaves) continue;
                this.func_181639_b(world2, blockPos3);
                this.func_181639_b(world2, blockPos3.east());
                this.func_181639_b(world2, blockPos3.south());
                this.func_181639_b(world2, blockPos3.east().south());
            }
            for (n6 = -2; n6 <= 0; ++n6) {
                for (n5 = -2; n5 <= 0; ++n5) {
                    int n12 = -1;
                    this.func_150526_a(world2, n9 + n6, n11 + n12, n10 + n5);
                    this.func_150526_a(world2, 1 + n9 - n6, n11 + n12, n10 + n5);
                    this.func_150526_a(world2, n9 + n6, n11 + n12, 1 + n10 - n5);
                    this.func_150526_a(world2, 1 + n9 - n6, n11 + n12, 1 + n10 - n5);
                    if (n6 <= -2 && n5 <= -1 || n6 == -1 && n5 == -2) continue;
                    n12 = 1;
                    this.func_150526_a(world2, n9 + n6, n11 + n12, n10 + n5);
                    this.func_150526_a(world2, 1 + n9 - n6, n11 + n12, n10 + n5);
                    this.func_150526_a(world2, n9 + n6, n11 + n12, 1 + n10 - n5);
                    this.func_150526_a(world2, 1 + n9 - n6, n11 + n12, 1 + n10 - n5);
                }
            }
            if (random.nextBoolean()) {
                this.func_150526_a(world2, n9, n11 + 2, n10);
                this.func_150526_a(world2, n9 + 1, n11 + 2, n10);
                this.func_150526_a(world2, n9 + 1, n11 + 2, n10 + 1);
                this.func_150526_a(world2, n9, n11 + 2, n10 + 1);
            }
            for (n6 = -3; n6 <= 4; ++n6) {
                for (n5 = -3; n5 <= 4; ++n5) {
                    if (n6 == -3 && n5 == -3 || n6 == -3 && n5 == 4 || n6 == 4 && n5 == -3 || n6 == 4 && n5 == 4 || Math.abs(n6) >= 3 && Math.abs(n5) >= 3) continue;
                    this.func_150526_a(world2, n9 + n6, n11, n10 + n5);
                }
            }
            for (n6 = -1; n6 <= 2; ++n6) {
                for (n5 = -1; n5 <= 2; ++n5) {
                    int n13;
                    int n14;
                    if (n6 >= 0 && n6 <= 1 && n5 >= 0 && n5 <= 1 || random.nextInt(3) > 0) continue;
                    int n15 = random.nextInt(3) + 2;
                    for (n14 = 0; n14 < n15; ++n14) {
                        this.func_181639_b(world2, new BlockPos(n2 + n6, n11 - n14 - 1, n4 + n5));
                    }
                    for (n14 = -1; n14 <= 1; ++n14) {
                        for (n13 = -1; n13 <= 1; ++n13) {
                            this.func_150526_a(world2, n9 + n6 + n14, n11, n10 + n5 + n13);
                        }
                    }
                    for (n14 = -2; n14 <= 2; ++n14) {
                        for (n13 = -2; n13 <= 2; ++n13) {
                            if (Math.abs(n14) == 2 && Math.abs(n13) == 2) continue;
                            this.func_150526_a(world2, n9 + n6 + n14, n11 - 1, n10 + n5 + n13);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean func_181638_a(World world2, BlockPos blockPos, int n) {
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = 0; i <= n + 1; ++i) {
            int n5 = 1;
            if (i == 0) {
                n5 = 0;
            }
            if (i >= n - 1) {
                n5 = 2;
            }
            for (int j = -n5; j <= n5; ++j) {
                for (int k = -n5; k <= n5; ++k) {
                    if (this.func_150523_a(world2.getBlockState(mutableBlockPos.set(n2 + j, n3 + i, n4 + k)).getBlock())) continue;
                    return false;
                }
            }
        }
        return true;
    }

    private void func_181639_b(World world2, BlockPos blockPos) {
        if (this.func_150523_a(world2.getBlockState(blockPos).getBlock())) {
            this.setBlockAndNotifyAdequately(world2, blockPos, field_181640_a);
        }
    }

    private void func_150526_a(World world2, int n, int n2, int n3) {
        BlockPos blockPos = new BlockPos(n, n2, n3);
        Block block = world2.getBlockState(blockPos).getBlock();
        if (block.getMaterial() == Material.air) {
            this.setBlockAndNotifyAdequately(world2, blockPos, field_181641_b);
        }
    }
}

