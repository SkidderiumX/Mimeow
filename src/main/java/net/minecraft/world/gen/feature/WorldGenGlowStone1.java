/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGlowStone1
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        if (!world2.isAirBlock(blockPos)) {
            return false;
        }
        if (world2.getBlockState(blockPos.up()).getBlock() != Blocks.netherrack) {
            return false;
        }
        world2.setBlockState(blockPos, Blocks.glowstone.getDefaultState(), 2);
        for (int i = 0; i < 1500; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
            if (world2.getBlockState(blockPos2).getBlock().getMaterial() != Material.air) continue;
            int n = 0;
            for (EnumFacing enumFacing : EnumFacing.values()) {
                if (world2.getBlockState(blockPos2.offset(enumFacing)).getBlock() == Blocks.glowstone) {
                    ++n;
                }
                if (n > 1) break;
            }
            if (n != true) continue;
            world2.setBlockState(blockPos2, Blocks.glowstone.getDefaultState(), 2);
        }
        return true;
    }
}

