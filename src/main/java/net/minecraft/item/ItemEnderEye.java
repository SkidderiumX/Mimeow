/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemEnderEye
extends Item {
    public ItemEnderEye() {
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (entityPlayer.canPlayerEdit(blockPos.offset(enumFacing), enumFacing, itemStack) && iBlockState.getBlock() == Blocks.end_portal_frame && !iBlockState.getValue(BlockEndPortalFrame.EYE).booleanValue()) {
            Object object;
            if (world2.isRemote) {
                return true;
            }
            world2.setBlockState(blockPos, iBlockState.withProperty(BlockEndPortalFrame.EYE, true), 2);
            world2.updateComparatorOutputLevel(blockPos, Blocks.end_portal_frame);
            --itemStack.stackSize;
            for (int i = 0; i < 16; ++i) {
                double d = (float)blockPos.getX() + (5.0f + itemRand.nextFloat() * 6.0f) / 16.0f;
                double d2 = (float)blockPos.getY() + 0.8125f;
                double d3 = (float)blockPos.getZ() + (5.0f + itemRand.nextFloat() * 6.0f) / 16.0f;
                double d4 = 0.0;
                double d5 = 0.0;
                double d6 = 0.0;
                world2.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d, d2, d3, d4, d5, d6, new int[0]);
            }
            EnumFacing enumFacing2 = iBlockState.getValue(BlockEndPortalFrame.FACING);
            int n = 0;
            int n2 = 0;
            boolean bl = false;
            boolean bl2 = true;
            EnumFacing enumFacing3 = enumFacing2.rotateY();
            for (int i = -2; i <= 2; ++i) {
                BlockPos blockPos2 = blockPos.offset(enumFacing3, i);
                object = world2.getBlockState(blockPos2);
                if (object.getBlock() != Blocks.end_portal_frame) continue;
                if (!object.getValue(BlockEndPortalFrame.EYE).booleanValue()) {
                    bl2 = false;
                    break;
                }
                n2 = i;
                if (bl) continue;
                n = i;
                bl = true;
            }
            if (bl2 && n2 == n + 2) {
                int n3;
                BlockPos blockPos3 = blockPos.offset(enumFacing2, 4);
                for (n3 = n; n3 <= n2; ++n3) {
                    object = blockPos3.offset(enumFacing3, n3);
                    IBlockState iBlockState2 = world2.getBlockState((BlockPos)object);
                    if (iBlockState2.getBlock() == Blocks.end_portal_frame && iBlockState2.getValue(BlockEndPortalFrame.EYE).booleanValue()) continue;
                    bl2 = false;
                    break;
                }
                block3: for (n3 = n - 1; n3 <= n2 + 1; n3 += 4) {
                    blockPos3 = blockPos.offset(enumFacing3, n3);
                    for (int i = 1; i <= 3; ++i) {
                        BlockPos blockPos4 = blockPos3.offset(enumFacing2, i);
                        IBlockState iBlockState3 = world2.getBlockState(blockPos4);
                        if (iBlockState3.getBlock() == Blocks.end_portal_frame && iBlockState3.getValue(BlockEndPortalFrame.EYE).booleanValue()) continue;
                        bl2 = false;
                        continue block3;
                    }
                }
                if (bl2) {
                    for (n3 = n; n3 <= n2; ++n3) {
                        blockPos3 = blockPos.offset(enumFacing3, n3);
                        for (int i = 1; i <= 3; ++i) {
                            BlockPos blockPos5 = blockPos3.offset(enumFacing2, i);
                            world2.setBlockState(blockPos5, Blocks.end_portal.getDefaultState(), 2);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        BlockPos blockPos;
        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world2, entityPlayer, false);
        if (movingObjectPosition != null && movingObjectPosition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && world2.getBlockState(movingObjectPosition.getBlockPos()).getBlock() == Blocks.end_portal_frame) {
            return itemStack;
        }
        if (!world2.isRemote && (blockPos = world2.getStrongholdPos("Stronghold", new BlockPos(entityPlayer))) != null) {
            EntityEnderEye entityEnderEye = new EntityEnderEye(world2, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
            entityEnderEye.moveTowards(blockPos);
            world2.spawnEntityInWorld(entityEnderEye);
            world2.playSoundAtEntity(entityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            world2.playAuxSFXAtEntity(null, 1002, new BlockPos(entityPlayer), 0);
            if (!entityPlayer.capabilities.isCreativeMode) {
                --itemStack.stackSize;
            }
            entityPlayer.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        }
        return itemStack;
    }
}

