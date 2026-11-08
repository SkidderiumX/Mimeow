/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterlily
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        for (int i = 0; i < 10; ++i) {
            int n;
            int n2;
            int n3 = blockPos.getX() + random.nextInt(8) - random.nextInt(8);
            if (!world2.isAirBlock(new BlockPos(n3, n2 = blockPos.getY() + random.nextInt(4) - random.nextInt(4), n = blockPos.getZ() + random.nextInt(8) - random.nextInt(8))) || !Blocks.waterlily.canPlaceBlockAt(world2, new BlockPos(n3, n2, n))) continue;
            world2.setBlockState(new BlockPos(n3, n2, n), Blocks.waterlily.getDefaultState(), 2);
        }
        return true;
    }
}

