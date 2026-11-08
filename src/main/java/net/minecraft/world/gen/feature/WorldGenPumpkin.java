/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPumpkin
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        for (int i = 0; i < 64; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (!world2.isAirBlock(blockPos2) || world2.getBlockState(blockPos2.down()).getBlock() != Blocks.grass || !Blocks.pumpkin.canPlaceBlockAt(world2, blockPos2)) continue;
            world2.setBlockState(blockPos2, Blocks.pumpkin.getDefaultState().withProperty(BlockPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(random)), 2);
        }
        return true;
    }
}

