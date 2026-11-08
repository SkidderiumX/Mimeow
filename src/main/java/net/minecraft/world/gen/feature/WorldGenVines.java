/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenVines
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        while (blockPos.getY() < 128) {
            if (world2.isAirBlock(blockPos)) {
                for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL.facings()) {
                    if (!Blocks.vine.canPlaceBlockOnSide(world2, blockPos, enumFacing)) continue;
                    IBlockState iBlockState = Blocks.vine.getDefaultState().withProperty(BlockVine.NORTH, enumFacing == EnumFacing.NORTH).withProperty(BlockVine.EAST, enumFacing == EnumFacing.EAST).withProperty(BlockVine.SOUTH, enumFacing == EnumFacing.SOUTH).withProperty(BlockVine.WEST, enumFacing == EnumFacing.WEST);
                    world2.setBlockState(blockPos, iBlockState, 2);
                    break;
                }
            } else {
                blockPos = blockPos.add(random.nextInt(4) - random.nextInt(4), 0, random.nextInt(4) - random.nextInt(4));
            }
            blockPos = blockPos.up();
        }
        return true;
    }
}

