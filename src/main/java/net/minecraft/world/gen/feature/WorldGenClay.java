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

public class WorldGenClay
extends WorldGenerator {
    private Block field_150546_a = Blocks.clay;
    private int numberOfBlocks;

    public WorldGenClay(int n) {
        this.numberOfBlocks = n;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        if (world2.getBlockState(blockPos).getBlock().getMaterial() != Material.water) {
            return false;
        }
        int n = random.nextInt(this.numberOfBlocks - 2) + 2;
        int n2 = 1;
        for (int i = blockPos.getX() - n; i <= blockPos.getX() + n; ++i) {
            for (int j = blockPos.getZ() - n; j <= blockPos.getZ() + n; ++j) {
                int n3;
                int n4 = i - blockPos.getX();
                if (n4 * n4 + (n3 = j - blockPos.getZ()) * n3 > n * n) continue;
                for (int k = blockPos.getY() - n2; k <= blockPos.getY() + n2; ++k) {
                    BlockPos blockPos2 = new BlockPos(i, k, j);
                    Block block = world2.getBlockState(blockPos2).getBlock();
                    if (block != Blocks.dirt && block != Blocks.clay) continue;
                    world2.setBlockState(blockPos2, this.field_150546_a.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}

