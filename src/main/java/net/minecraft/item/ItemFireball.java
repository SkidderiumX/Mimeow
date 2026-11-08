/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemFireball
extends Item {
    public ItemFireball() {
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        if (world2.isRemote) {
            return true;
        }
        if (!entityPlayer.canPlayerEdit(blockPos = blockPos.offset(enumFacing), enumFacing, itemStack)) {
            return false;
        }
        if (world2.getBlockState(blockPos).getBlock().getMaterial() == Material.air) {
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, "item.fireCharge.use", 1.0f, (itemRand.nextFloat() - itemRand.nextFloat()) * 0.2f + 1.0f);
            world2.setBlockState(blockPos, Blocks.fire.getDefaultState());
        }
        if (!entityPlayer.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }
        return true;
    }
}

