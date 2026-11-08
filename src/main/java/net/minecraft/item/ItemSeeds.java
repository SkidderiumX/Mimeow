/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemSeeds
extends Item {
    private Block crops;
    private Block soilBlockID;

    public ItemSeeds(Block block, Block block2) {
        this.crops = block;
        this.soilBlockID = block2;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        if (enumFacing != EnumFacing.UP) {
            return false;
        }
        if (!entityPlayer.canPlayerEdit(blockPos.offset(enumFacing), enumFacing, itemStack)) {
            return false;
        }
        if (world2.getBlockState(blockPos).getBlock() == this.soilBlockID && world2.isAirBlock(blockPos.up())) {
            world2.setBlockState(blockPos.up(), this.crops.getDefaultState());
            --itemStack.stackSize;
            return true;
        }
        return false;
    }
}

