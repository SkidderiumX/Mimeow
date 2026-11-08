/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.BlockStandingSign;
import net.minecraft.block.BlockWallSign;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSign
extends Item {
    public ItemSign() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        if (enumFacing == EnumFacing.DOWN) {
            return false;
        }
        if (!world2.getBlockState(blockPos).getBlock().getMaterial().isSolid()) {
            return false;
        }
        if (!entityPlayer.canPlayerEdit(blockPos = blockPos.offset(enumFacing), enumFacing, itemStack)) {
            return false;
        }
        if (!Blocks.standing_sign.canPlaceBlockAt(world2, blockPos)) {
            return false;
        }
        if (world2.isRemote) {
            return true;
        }
        if (enumFacing == EnumFacing.UP) {
            int n = MathHelper.floor_double((double)((entityPlayer.rotationYaw + 180.0f) * 16.0f / 360.0f) + 0.5) & 0xF;
            world2.setBlockState(blockPos, Blocks.standing_sign.getDefaultState().withProperty(BlockStandingSign.ROTATION, n), 3);
        } else {
            world2.setBlockState(blockPos, Blocks.wall_sign.getDefaultState().withProperty(BlockWallSign.FACING, enumFacing), 3);
        }
        --itemStack.stackSize;
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntitySign && !ItemBlock.setTileEntityNBT(world2, entityPlayer, blockPos, itemStack)) {
            entityPlayer.openEditSign((TileEntitySign)tileEntity);
        }
        return true;
    }
}

