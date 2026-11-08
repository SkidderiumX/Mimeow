/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class BlockBrewingStand
extends BlockContainer {
    public static final PropertyBool[] HAS_BOTTLE = new PropertyBool[]{PropertyBool.create("has_bottle_0"), PropertyBool.create("has_bottle_1"), PropertyBool.create("has_bottle_2")};

    public BlockBrewingStand() {
        super(Material.iron);
        this.setDefaultState(this.blockState.getBaseState().withProperty(HAS_BOTTLE[0], false).withProperty(HAS_BOTTLE[1], false).withProperty(HAS_BOTTLE[2], false));
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal("item.brewingStand.name");
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
        return new TileEntityBrewingStand();
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void addCollisionBoxesToList(World world2, BlockPos blockPos, IBlockState iBlockState, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, Entity entity) {
        this.setBlockBounds(0.4375f, 0.0f, 0.4375f, 0.5625f, 0.875f, 0.5625f);
        super.addCollisionBoxesToList(world2, blockPos, iBlockState, axisAlignedBB, list, entity);
        this.setBlockBoundsForItemRender();
        super.addCollisionBoxesToList(world2, blockPos, iBlockState, axisAlignedBB, list, entity);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (world2.isRemote) {
            return true;
        }
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityBrewingStand) {
            entityPlayer.displayGUIChest((TileEntityBrewingStand)tileEntity);
            entityPlayer.triggerAchievement(StatList.field_181729_M);
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntity tileEntity;
        if (itemStack.hasDisplayName() && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntityBrewingStand) {
            ((TileEntityBrewingStand)tileEntity).setName(itemStack.getDisplayName());
        }
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        double d = (float)blockPos.getX() + 0.4f + random.nextFloat() * 0.2f;
        double d2 = (float)blockPos.getY() + 0.7f + random.nextFloat() * 0.3f;
        double d3 = (float)blockPos.getZ() + 0.4f + random.nextFloat() * 0.2f;
        world2.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d, d2, d3, 0.0, 0.0, 0.0, new int[0]);
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityBrewingStand) {
            InventoryHelper.dropInventoryItems(world2, blockPos, (IInventory)((TileEntityBrewingStand)tileEntity));
        }
        super.breakBlock(world2, blockPos, iBlockState);
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Items.brewing_stand;
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Items.brewing_stand;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world2, BlockPos blockPos) {
        return Container.calcRedstone(world2.getTileEntity(blockPos));
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        IBlockState iBlockState = this.getDefaultState();
        for (int i = 0; i < 3; ++i) {
            iBlockState = iBlockState.withProperty(HAS_BOTTLE[i], (n & 1 << i) > 0);
        }
        return iBlockState;
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (!iBlockState.getValue(HAS_BOTTLE[i]).booleanValue()) continue;
            n |= 1 << i;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, HAS_BOTTLE[0], HAS_BOTTLE[1], HAS_BOTTLE[2]);
    }
}

