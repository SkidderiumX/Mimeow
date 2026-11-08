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

public class WorldGenLiquids
extends WorldGenerator {
    private Block block;

    public WorldGenLiquids(Block block) {
        this.block = block;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        if (world2.getBlockState(blockPos.up()).getBlock() != Blocks.stone) {
            return false;
        }
        if (world2.getBlockState(blockPos.down()).getBlock() != Blocks.stone) {
            return false;
        }
        if (world2.getBlockState(blockPos).getBlock().getMaterial() != Material.air && world2.getBlockState(blockPos).getBlock() != Blocks.stone) {
            return false;
        }
        int n = 0;
        if (world2.getBlockState(blockPos.west()).getBlock() == Blocks.stone) {
            ++n;
        }
        if (world2.getBlockState(blockPos.east()).getBlock() == Blocks.stone) {
            ++n;
        }
        if (world2.getBlockState(blockPos.north()).getBlock() == Blocks.stone) {
            ++n;
        }
        if (world2.getBlockState(blockPos.south()).getBlock() == Blocks.stone) {
            ++n;
        }
        int n2 = 0;
        if (world2.isAirBlock(blockPos.west())) {
            ++n2;
        }
        if (world2.isAirBlock(blockPos.east())) {
            ++n2;
        }
        if (world2.isAirBlock(blockPos.north())) {
            ++n2;
        }
        if (world2.isAirBlock(blockPos.south())) {
            ++n2;
        }
        if (n == 3 && n2 == 1) {
            world2.setBlockState(blockPos, this.block.getDefaultState(), 2);
            world2.forceBlockUpdateTick(this.block, blockPos, random);
        }
        return true;
    }
}

