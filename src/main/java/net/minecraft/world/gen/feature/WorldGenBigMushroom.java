/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBigMushroom
extends WorldGenerator {
    private Block mushroomType;

    public WorldGenBigMushroom(Block block) {
        super(true);
        this.mushroomType = block;
    }

    public WorldGenBigMushroom() {
        super(false);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        if (this.mushroomType == null) {
            this.mushroomType = random.nextBoolean() ? Blocks.brown_mushroom_block : Blocks.red_mushroom_block;
        }
        int n = random.nextInt(3) + 4;
        boolean bl = true;
        if (blockPos.getY() >= 1 && blockPos.getY() + n + 1 < 256) {
            int n2;
            int n3;
            int n4;
            int n5;
            for (int i = blockPos.getY(); i <= blockPos.getY() + 1 + n; ++i) {
                n5 = 3;
                if (i <= blockPos.getY() + 3) {
                    n5 = 0;
                }
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                for (n4 = blockPos.getX() - n5; n4 <= blockPos.getX() + n5 && bl; ++n4) {
                    for (n3 = blockPos.getZ() - n5; n3 <= blockPos.getZ() + n5 && bl; ++n3) {
                        if (i >= 0 && i < 256) {
                            Block block = world2.getBlockState(mutableBlockPos.set(n4, i, n3)).getBlock();
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
            if (block != Blocks.dirt && block != Blocks.grass && block != Blocks.mycelium) {
                return false;
            }
            n5 = blockPos.getY() + n;
            if (this.mushroomType == Blocks.red_mushroom_block) {
                n5 = blockPos.getY() + n - 3;
            }
            for (n2 = n5; n2 <= blockPos.getY() + n; ++n2) {
                n4 = 1;
                if (n2 < blockPos.getY() + n) {
                    ++n4;
                }
                if (this.mushroomType == Blocks.brown_mushroom_block) {
                    n4 = 3;
                }
                n3 = blockPos.getX() - n4;
                int n6 = blockPos.getX() + n4;
                int n7 = blockPos.getZ() - n4;
                int n8 = blockPos.getZ() + n4;
                for (int i = n3; i <= n6; ++i) {
                    for (int j = n7; j <= n8; ++j) {
                        BlockPos blockPos2;
                        int n9 = 5;
                        if (i == n3) {
                            --n9;
                        } else if (i == n6) {
                            ++n9;
                        }
                        if (j == n7) {
                            n9 -= 3;
                        } else if (j == n8) {
                            n9 += 3;
                        }
                        BlockHugeMushroom.EnumType enumType = BlockHugeMushroom.EnumType.byMetadata(n9);
                        if (this.mushroomType == Blocks.brown_mushroom_block || n2 < blockPos.getY() + n) {
                            if ((i == n3 || i == n6) && (j == n7 || j == n8)) continue;
                            if (i == blockPos.getX() - (n4 - 1) && j == n7) {
                                enumType = BlockHugeMushroom.EnumType.NORTH_WEST;
                            }
                            if (i == n3 && j == blockPos.getZ() - (n4 - 1)) {
                                enumType = BlockHugeMushroom.EnumType.NORTH_WEST;
                            }
                            if (i == blockPos.getX() + (n4 - 1) && j == n7) {
                                enumType = BlockHugeMushroom.EnumType.NORTH_EAST;
                            }
                            if (i == n6 && j == blockPos.getZ() - (n4 - 1)) {
                                enumType = BlockHugeMushroom.EnumType.NORTH_EAST;
                            }
                            if (i == blockPos.getX() - (n4 - 1) && j == n8) {
                                enumType = BlockHugeMushroom.EnumType.SOUTH_WEST;
                            }
                            if (i == n3 && j == blockPos.getZ() + (n4 - 1)) {
                                enumType = BlockHugeMushroom.EnumType.SOUTH_WEST;
                            }
                            if (i == blockPos.getX() + (n4 - 1) && j == n8) {
                                enumType = BlockHugeMushroom.EnumType.SOUTH_EAST;
                            }
                            if (i == n6 && j == blockPos.getZ() + (n4 - 1)) {
                                enumType = BlockHugeMushroom.EnumType.SOUTH_EAST;
                            }
                        }
                        if (enumType == BlockHugeMushroom.EnumType.CENTER && n2 < blockPos.getY() + n) {
                            enumType = BlockHugeMushroom.EnumType.ALL_INSIDE;
                        }
                        if (blockPos.getY() < blockPos.getY() + n - 1 && enumType == BlockHugeMushroom.EnumType.ALL_INSIDE || world2.getBlockState(blockPos2 = new BlockPos(i, n2, j)).getBlock().isFullBlock()) continue;
                        this.setBlockAndNotifyAdequately(world2, blockPos2, this.mushroomType.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, enumType));
                    }
                }
            }
            for (n2 = 0; n2 < n; ++n2) {
                Block block2 = world2.getBlockState(blockPos.up(n2)).getBlock();
                if (block2.isFullBlock()) continue;
                this.setBlockAndNotifyAdequately(world2, blockPos.up(n2), this.mushroomType.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, BlockHugeMushroom.EnumType.STEM));
            }
            return true;
        }
        return false;
    }
}

