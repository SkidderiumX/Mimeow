/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIceSpike
extends WorldGenerator {
    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n;
        int n2;
        while (world2.isAirBlock(blockPos) && blockPos.getY() > 2) {
            blockPos = blockPos.down();
        }
        if (world2.getBlockState(blockPos).getBlock() != Blocks.snow) {
            return false;
        }
        blockPos = blockPos.up(random.nextInt(4));
        int n3 = random.nextInt(4) + 7;
        int n4 = n3 / 4 + random.nextInt(2);
        if (n4 > 1 && random.nextInt(60) == 0) {
            blockPos = blockPos.up(10 + random.nextInt(30));
        }
        for (n2 = 0; n2 < n3; ++n2) {
            float f = (1.0f - (float)n2 / (float)n3) * (float)n4;
            n = MathHelper.ceiling_float_int(f);
            for (int i = -n; i <= n; ++i) {
                float f2 = (float)MathHelper.abs_int(i) - 0.25f;
                for (int j = -n; j <= n; ++j) {
                    float f3 = (float)MathHelper.abs_int(j) - 0.25f;
                    if ((i != 0 || j != 0) && !(f2 * f2 + f3 * f3 <= f * f) || (i == -n || i == n || j == -n || j == n) && !(random.nextFloat() <= 0.75f)) continue;
                    Block block = world2.getBlockState(blockPos.add(i, n2, j)).getBlock();
                    if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice) {
                        this.setBlockAndNotifyAdequately(world2, blockPos.add(i, n2, j), Blocks.packed_ice.getDefaultState());
                    }
                    if (n2 == 0 || n <= 1 || (block = world2.getBlockState(blockPos.add(i, -n2, j)).getBlock()).getMaterial() != Material.air && block != Blocks.dirt && block != Blocks.snow && block != Blocks.ice) continue;
                    this.setBlockAndNotifyAdequately(world2, blockPos.add(i, -n2, j), Blocks.packed_ice.getDefaultState());
                }
            }
        }
        n2 = n4 - 1;
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > 1) {
            n2 = 1;
        }
        for (int i = -n2; i <= n2; ++i) {
            for (n = -n2; n <= n2; ++n) {
                Block block;
                BlockPos blockPos2 = blockPos.add(i, -1, n);
                int n5 = 50;
                if (Math.abs(i) == 1 && Math.abs(n) == 1) {
                    n5 = random.nextInt(5);
                }
                while (blockPos2.getY() > 50 && ((block = world2.getBlockState(blockPos2).getBlock()).getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice || block == Blocks.packed_ice)) {
                    this.setBlockAndNotifyAdequately(world2, blockPos2, Blocks.packed_ice.getDefaultState());
                    blockPos2 = blockPos2.down();
                    if (--n5 > 0) continue;
                    blockPos2 = blockPos2.down(random.nextInt(5) + 1);
                    n5 = random.nextInt(5);
                }
            }
        }
        return true;
    }
}

