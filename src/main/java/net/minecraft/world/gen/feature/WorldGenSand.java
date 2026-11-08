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

public class WorldGenSand
extends WorldGenerator {
    private Block block;
    private int radius;

    public WorldGenSand(Block block, int n) {
        this.block = block;
        this.radius = n;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        if (world2.getBlockState(blockPos).getBlock().getMaterial() != Material.water) {
            return false;
        }
        int n = random.nextInt(this.radius - 2) + 2;
        int n2 = 2;
        for (int i = blockPos.getX() - n; i <= blockPos.getX() + n; ++i) {
            for (int j = blockPos.getZ() - n; j <= blockPos.getZ() + n; ++j) {
                int n3;
                int n4 = i - blockPos.getX();
                if (n4 * n4 + (n3 = j - blockPos.getZ()) * n3 > n * n) continue;
                for (int k = blockPos.getY() - n2; k <= blockPos.getY() + n2; ++k) {
                    BlockPos blockPos2 = new BlockPos(i, k, j);
                    Block block = world2.getBlockState(blockPos2).getBlock();
                    if (block != Blocks.dirt && block != Blocks.grass) continue;
                    world2.setBlockState(blockPos2, this.block.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}

