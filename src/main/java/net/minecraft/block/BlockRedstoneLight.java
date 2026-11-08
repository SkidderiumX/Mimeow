/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockRedstoneLight
extends Block {
    private final boolean isOn;

    public BlockRedstoneLight(boolean bl) {
        super(Material.redstoneLight);
        this.isOn = bl;
        if (bl) {
            this.setLightLevel(1.0f);
        }
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote) {
            if (this.isOn && !world2.isBlockPowered(blockPos)) {
                world2.setBlockState(blockPos, Blocks.redstone_lamp.getDefaultState(), 2);
            } else if (!this.isOn && world2.isBlockPowered(blockPos)) {
                world2.setBlockState(blockPos, Blocks.lit_redstone_lamp.getDefaultState(), 2);
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!world2.isRemote) {
            if (this.isOn && !world2.isBlockPowered(blockPos)) {
                world2.scheduleUpdate(blockPos, this, 4);
            } else if (!this.isOn && world2.isBlockPowered(blockPos)) {
                world2.setBlockState(blockPos, Blocks.lit_redstone_lamp.getDefaultState(), 2);
            }
        }
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (!world2.isRemote && this.isOn && !world2.isBlockPowered(blockPos)) {
            world2.setBlockState(blockPos, Blocks.redstone_lamp.getDefaultState(), 2);
        }
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Item.getItemFromBlock(Blocks.redstone_lamp);
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Item.getItemFromBlock(Blocks.redstone_lamp);
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState iBlockState) {
        return new ItemStack(Blocks.redstone_lamp);
    }
}

