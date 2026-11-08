/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenReed
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        for (int i = 0; i < 20; ++i) {
            BlockPos blockPos2;
            BlockPos blockPos3 = blockPos.add(random.nextInt(4) - random.nextInt(4), 0, random.nextInt(4) - random.nextInt(4));
            if (!world2.isAirBlock(blockPos3) || world2.getBlockState((blockPos2 = blockPos3.down()).west()).getBlock().getMaterial() != Material.water && world2.getBlockState(blockPos2.east()).getBlock().getMaterial() != Material.water && world2.getBlockState(blockPos2.north()).getBlock().getMaterial() != Material.water && world2.getBlockState(blockPos2.south()).getBlock().getMaterial() != Material.water) continue;
            int n = 2 + random.nextInt(random.nextInt(3) + 1);
            for (int j = 0; j < n; ++j) {
                if (!Blocks.reeds.canBlockStay(world2, blockPos3)) continue;
                world2.setBlockState(blockPos3.up(j), Blocks.reeds.getDefaultState(), 2);
            }
        }
        return true;
    }
}

