/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class WorldGenShrub
extends WorldGenTrees {
    private final IBlockState leavesMetadata;
    private final IBlockState woodMetadata;

    public WorldGenShrub(IBlockState iBlockState, IBlockState iBlockState2) {
        super(false);
        this.woodMetadata = iBlockState;
        this.leavesMetadata = iBlockState2;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        Block block;
        while (((block = world2.getBlockState(blockPos).getBlock()).getMaterial() == Material.air || block.getMaterial() == Material.leaves) && blockPos.getY() > 0) {
            blockPos = blockPos.down();
        }
        Block block2 = world2.getBlockState(blockPos).getBlock();
        if (block2 == Blocks.dirt || block2 == Blocks.grass) {
            blockPos = blockPos.up();
            this.setBlockAndNotifyAdequately(world2, blockPos, this.woodMetadata);
            for (int i = blockPos.getY(); i <= blockPos.getY() + 2; ++i) {
                int n = i - blockPos.getY();
                int n2 = 2 - n;
                for (int j = blockPos.getX() - n2; j <= blockPos.getX() + n2; ++j) {
                    int n3 = j - blockPos.getX();
                    for (int k = blockPos.getZ() - n2; k <= blockPos.getZ() + n2; ++k) {
                        BlockPos blockPos2;
                        int n4 = k - blockPos.getZ();
                        if (Math.abs(n3) == n2 && Math.abs(n4) == n2 && random.nextInt(2) == 0 || world2.getBlockState(blockPos2 = new BlockPos(j, i, k)).getBlock().isFullBlock()) continue;
                        this.setBlockAndNotifyAdequately(world2, blockPos2, this.leavesMetadata);
                    }
                }
            }
        }
        return true;
    }
}

