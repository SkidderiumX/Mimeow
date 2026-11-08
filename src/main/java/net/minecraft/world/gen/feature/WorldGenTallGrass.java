/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTallGrass
extends WorldGenerator {
    private final IBlockState tallGrassState;

    public WorldGenTallGrass(BlockTallGrass.EnumType enumType) {
        this.tallGrassState = Blocks.tallgrass.getDefaultState().withProperty(BlockTallGrass.TYPE, enumType);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        Block block;
        while (((block = world2.getBlockState(blockPos).getBlock()).getMaterial() == Material.air || block.getMaterial() == Material.leaves) && blockPos.getY() > 0) {
            blockPos = blockPos.down();
        }
        for (int i = 0; i < 128; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (!world2.isAirBlock(blockPos2) || !Blocks.tallgrass.canBlockStay(world2, blockPos2, this.tallGrassState)) continue;
            world2.setBlockState(blockPos2, this.tallGrassState, 2);
        }
        return true;
    }
}

