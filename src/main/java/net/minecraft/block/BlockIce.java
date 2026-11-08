/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class BlockIce
extends BlockBreakable {
    public BlockIce() {
        super(Material.ice, false);
        this.slipperiness = 0.98f;
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public void harvestBlock(World world2, EntityPlayer entityPlayer, BlockPos blockPos, IBlockState iBlockState, TileEntity tileEntity) {
        entityPlayer.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
        entityPlayer.addExhaustion(0.025f);
        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(entityPlayer)) {
            ItemStack itemStack = this.createStackedBlock(iBlockState);
            if (itemStack != null) {
                BlockIce.spawnAsEntity(world2, blockPos, itemStack);
            }
        } else {
            if (world2.provider.doesWaterVaporize()) {
                world2.setBlockToAir(blockPos);
                return;
            }
            int n = EnchantmentHelper.getFortuneModifier(entityPlayer);
            this.dropBlockAsItem(world2, blockPos, iBlockState, n);
            Material material = world2.getBlockState(blockPos.down()).getBlock().getMaterial();
            if (material.blocksMovement() || material.isLiquid()) {
                world2.setBlockState(blockPos, Blocks.flowing_water.getDefaultState());
            }
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (world2.getLightFor(EnumSkyBlock.BLOCK, blockPos) > 11 - this.getLightOpacity()) {
            if (world2.provider.doesWaterVaporize()) {
                world2.setBlockToAir(blockPos);
            } else {
                this.dropBlockAsItem(world2, blockPos, world2.getBlockState(blockPos), 0);
                world2.setBlockState(blockPos, Blocks.water.getDefaultState());
            }
        }
    }

    @Override
    public int getMobilityFlag() {
        return 0;
    }
}

