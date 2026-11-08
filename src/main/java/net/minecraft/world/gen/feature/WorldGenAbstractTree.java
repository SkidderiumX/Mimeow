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

public abstract class WorldGenAbstractTree
extends WorldGenerator {
    public WorldGenAbstractTree(boolean bl) {
        super(bl);
    }

    protected boolean func_150523_a(Block block) {
        Material material = block.getMaterial();
        return material == Material.air || material == Material.leaves || block == Blocks.grass || block == Blocks.dirt || block == Blocks.log || block == Blocks.log2 || block == Blocks.sapling || block == Blocks.vine;
    }

    public void func_180711_a(World world2, Random random, BlockPos blockPos) {
    }

    protected void func_175921_a(World world2, BlockPos blockPos) {
        if (world2.getBlockState(blockPos).getBlock() != Blocks.dirt) {
            this.setBlockAndNotifyAdequately(world2, blockPos, Blocks.dirt.getDefaultState());
        }
    }
}

