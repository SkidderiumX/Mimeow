/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDeadBush
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        Block block;
        while (((block = world2.getBlockState(blockPos).getBlock()).getMaterial() == Material.air || block.getMaterial() == Material.leaves) && blockPos.getY() > 0) {
            blockPos = blockPos.down();
        }
        for (int i = 0; i < 4; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (!world2.isAirBlock(blockPos2) || !Blocks.deadbush.canBlockStay(world2, blockPos2, Blocks.deadbush.getDefaultState())) continue;
            world2.setBlockState(blockPos2, Blocks.deadbush.getDefaultState(), 2);
        }
        return true;
    }
}

