/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGeneratorBonusChest
extends WorldGenerator {
    private final List<WeightedRandomChestContent> chestItems;
    private final int itemsToGenerateInBonusChest;

    public WorldGeneratorBonusChest(List<WeightedRandomChestContent> list, int n) {
        this.chestItems = list;
        this.itemsToGenerateInBonusChest = n;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        Block block;
        while (((block = world2.getBlockState(blockPos).getBlock()).getMaterial() == Material.air || block.getMaterial() == Material.leaves) && blockPos.getY() > 1) {
            blockPos = blockPos.down();
        }
        if (blockPos.getY() < 1) {
            return false;
        }
        blockPos = blockPos.up();
        for (int i = 0; i < 4; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(4) - random.nextInt(4), random.nextInt(3) - random.nextInt(3), random.nextInt(4) - random.nextInt(4));
            if (!world2.isAirBlock(blockPos2) || !World.doesBlockHaveSolidTopSurface(world2, blockPos2.down())) continue;
            world2.setBlockState(blockPos2, Blocks.chest.getDefaultState(), 2);
            TileEntity tileEntity = world2.getTileEntity(blockPos2);
            if (tileEntity instanceof TileEntityChest) {
                WeightedRandomChestContent.generateChestContents(random, this.chestItems, (TileEntityChest)tileEntity, this.itemsToGenerateInBonusChest);
            }
            BlockPos blockPos3 = blockPos2.east();
            BlockPos blockPos4 = blockPos2.west();
            BlockPos blockPos5 = blockPos2.north();
            BlockPos blockPos6 = blockPos2.south();
            if (world2.isAirBlock(blockPos4) && World.doesBlockHaveSolidTopSurface(world2, blockPos4.down())) {
                world2.setBlockState(blockPos4, Blocks.torch.getDefaultState(), 2);
            }
            if (world2.isAirBlock(blockPos3) && World.doesBlockHaveSolidTopSurface(world2, blockPos3.down())) {
                world2.setBlockState(blockPos3, Blocks.torch.getDefaultState(), 2);
            }
            if (world2.isAirBlock(blockPos5) && World.doesBlockHaveSolidTopSurface(world2, blockPos5.down())) {
                world2.setBlockState(blockPos5, Blocks.torch.getDefaultState(), 2);
            }
            if (world2.isAirBlock(blockPos6) && World.doesBlockHaveSolidTopSurface(world2, blockPos6.down())) {
                world2.setBlockState(blockPos6, Blocks.torch.getDefaultState(), 2);
            }
            return true;
        }
        return false;
    }
}

