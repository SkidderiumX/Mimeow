/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ItemDye
extends Item {
    public static final int[] dyeColors = new int[]{0x1E1B1B, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 0xABABAB, 0x434343, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 0xF0F0F0};

    public ItemDye() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int n = itemStack.getMetadata();
        return super.getUnlocalizedName() + "." + EnumDyeColor.byDyeDamage(n).getUnlocalizedName();
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        IBlockState iBlockState;
        Block block;
        if (!entityPlayer.canPlayerEdit(blockPos.offset(enumFacing), enumFacing, itemStack)) {
            return false;
        }
        EnumDyeColor enumDyeColor = EnumDyeColor.byDyeDamage(itemStack.getMetadata());
        if (enumDyeColor == EnumDyeColor.WHITE) {
            if (ItemDye.applyBonemeal(itemStack, world2, blockPos)) {
                if (!world2.isRemote) {
                    world2.playAuxSFX(2005, blockPos, 0);
                }
                return true;
            }
        } else if (enumDyeColor == EnumDyeColor.BROWN && (block = (iBlockState = world2.getBlockState(blockPos)).getBlock()) == Blocks.log && iBlockState.getValue(BlockPlanks.VARIANT) == BlockPlanks.EnumType.JUNGLE) {
            if (enumFacing == EnumFacing.DOWN) {
                return false;
            }
            if (enumFacing == EnumFacing.UP) {
                return false;
            }
            if (world2.isAirBlock(blockPos = blockPos.offset(enumFacing))) {
                IBlockState iBlockState2 = Blocks.cocoa.onBlockPlaced(world2, blockPos, enumFacing, f, f2, f3, 0, entityPlayer);
                world2.setBlockState(blockPos, iBlockState2, 2);
                if (!entityPlayer.capabilities.isCreativeMode) {
                    --itemStack.stackSize;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean applyBonemeal(ItemStack itemStack, World world2, BlockPos blockPos) {
        IGrowable iGrowable;
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (iBlockState.getBlock() instanceof IGrowable && (iGrowable = (IGrowable)((Object)iBlockState.getBlock())).canGrow(world2, blockPos, iBlockState, world2.isRemote)) {
            if (!world2.isRemote) {
                if (iGrowable.canUseBonemeal(world2, world2.rand, blockPos, iBlockState)) {
                    iGrowable.grow(world2, world2.rand, blockPos, iBlockState);
                }
                --itemStack.stackSize;
            }
            return true;
        }
        return false;
    }

    public static void spawnBonemealParticles(World world2, BlockPos blockPos, int n) {
        Block block;
        if (n == 0) {
            n = 15;
        }
        if ((block = world2.getBlockState(blockPos).getBlock()).getMaterial() != Material.air) {
            block.setBlockBoundsBasedOnState(world2, blockPos);
            for (int i = 0; i < n; ++i) {
                double d = itemRand.nextGaussian() * 0.02;
                double d2 = itemRand.nextGaussian() * 0.02;
                double d3 = itemRand.nextGaussian() * 0.02;
                world2.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, (float)blockPos.getX() + itemRand.nextFloat(), (double)blockPos.getY() + (double)itemRand.nextFloat() * block.getBlockBoundsMaxY(), (double)((float)blockPos.getZ() + itemRand.nextFloat()), d, d2, d3, new int[0]);
            }
        }
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntitySheep) {
            EntitySheep entitySheep = (EntitySheep)entityLivingBase;
            EnumDyeColor enumDyeColor = EnumDyeColor.byDyeDamage(itemStack.getMetadata());
            if (!entitySheep.getSheared() && entitySheep.getFleeceColor() != enumDyeColor) {
                entitySheep.setFleeceColor(enumDyeColor);
                --itemStack.stackSize;
            }
            return true;
        }
        return false;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (int i = 0; i < 16; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}

