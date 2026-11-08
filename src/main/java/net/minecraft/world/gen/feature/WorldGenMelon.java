/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMelon
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        for (int i = 0; i < 64; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (!Blocks.melon_block.canPlaceBlockAt(world2, blockPos2) || world2.getBlockState(blockPos2.down()).getBlock() != Blocks.grass) continue;
            world2.setBlockState(blockPos2, Blocks.melon_block.getDefaultState(), 2);
        }
        return true;
    }
}

