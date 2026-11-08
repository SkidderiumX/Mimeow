/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class BlockEnchantmentTable
extends BlockContainer {
    protected BlockEnchantmentTable() {
        super(Material.rock, MapColor.redColor);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        super.randomDisplayTick(world2, blockPos, iBlockState, random);
        for (int i = -2; i <= 2; ++i) {
            block1: for (int j = -2; j <= 2; ++j) {
                if (i > -2 && i < 2 && j == -1) {
                    j = 2;
                }
                if (random.nextInt(16) != 0) continue;
                for (int k = 0; k <= 1; ++k) {
                    BlockPos blockPos2 = blockPos.add(i, k, j);
                    if (world2.getBlockState(blockPos2).getBlock() != Blocks.bookshelf) continue;
                    if (!world2.isAirBlock(blockPos.add(i / 2, 0, j / 2))) continue block1;
                    world2.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 2.0, (double)blockPos.getZ() + 0.5, (double)((float)i + random.nextFloat()) - 0.5, (double)((float)k - random.nextFloat() - 1.0f), (double)((float)j + random.nextFloat()) - 0.5, new int[0]);
                }
            }
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @Override
    public TileEntity createNewTileEntity(World world2, int n) {
        return new TileEntityEnchantmentTable();
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (world2.isRemote) {
            return true;
        }
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityEnchantmentTable) {
            entityPlayer.displayGui((TileEntityEnchantmentTable)tileEntity);
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntity tileEntity;
        super.onBlockPlacedBy(world2, blockPos, iBlockState, entityLivingBase, itemStack);
        if (itemStack.hasDisplayName() && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntityEnchantmentTable) {
            ((TileEntityEnchantmentTable)tileEntity).setCustomName(itemStack.getDisplayName());
        }
    }
}

