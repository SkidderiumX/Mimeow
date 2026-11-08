/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCactus
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        for (int i = 0; i < 10; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (!world2.isAirBlock(blockPos2)) continue;
            int n = 1 + random.nextInt(random.nextInt(3) + 1);
            for (int j = 0; j < n; ++j) {
                if (!Blocks.cactus.canBlockStay(world2, blockPos2)) continue;
                world2.setBlockState(blockPos2.up(j), Blocks.cactus.getDefaultState(), 2);
            }
        }
        return true;
    }
}

