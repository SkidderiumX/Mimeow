/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockJukebox
extends BlockContainer {
    public static final PropertyBool HAS_RECORD = PropertyBool.create("has_record");

    protected BlockJukebox() {
        super(Material.wood, MapColor.dirtColor);
        this.setDefaultState(this.blockState.getBaseState().withProperty(HAS_RECORD, false));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (iBlockState.getValue(HAS_RECORD).booleanValue()) {
            this.dropRecord(world2, blockPos, iBlockState);
            iBlockState = iBlockState.withProperty(HAS_RECORD, false);
            world2.setBlockState(blockPos, iBlockState, 2);
            return true;
        }
        return false;
    }

    public void insertRecord(World world2, BlockPos blockPos, IBlockState iBlockState, ItemStack itemStack) {
        TileEntity tileEntity;
        if (!world2.isRemote && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntityJukebox) {
            ((TileEntityJukebox)tileEntity).setRecord(new ItemStack(itemStack.getItem(), 1, itemStack.getMetadata()));
            world2.setBlockState(blockPos, iBlockState.withProperty(HAS_RECORD, true), 2);
        }
    }

    private void dropRecord(World world2, BlockPos blockPos, IBlockState iBlockState) {
        TileEntityJukebox tileEntityJukebox;
        ItemStack itemStack;
        TileEntity tileEntity;
        if (!world2.isRemote && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntityJukebox && (itemStack = (tileEntityJukebox = (TileEntityJukebox)tileEntity).getRecord()) != null) {
            world2.playAuxSFX(1005, blockPos, 0);
            world2.playRecord(blockPos, null);
            tileEntityJukebox.setRecord(null);
            float f = 0.7f;
            double d = (double)(world2.rand.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            double d2 = (double)(world2.rand.nextFloat() * f) + (double)(1.0f - f) * 0.2 + 0.6;
            double d3 = (double)(world2.rand.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            ItemStack itemStack2 = itemStack.copy();
            EntityItem entityItem = new EntityItem(world2, (double)blockPos.getX() + d, (double)blockPos.getY() + d2, (double)blockPos.getZ() + d3, itemStack2);
            entityItem.setDefaultPickupDelay();
            world2.spawnEntityInWorld(entityItem);
        }
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.dropRecord(world2, blockPos, iBlockState);
        super.breakBlock(world2, blockPos, iBlockState);
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        if (!world2.isRemote) {
            super.dropBlockAsItemWithChance(world2, blockPos, iBlockState, f, 0);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world2, int n) {
        return new TileEntityJukebox();
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world2, BlockPos blockPos) {
        ItemStack itemStack;
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityJukebox && (itemStack = ((TileEntityJukebox)tileEntity).getRecord()) != null) {
            return Item.getIdFromItem(itemStack.getItem()) + 1 - Item.getIdFromItem(Items.record_13);
        }
        return 0;
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(HAS_RECORD, n > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(HAS_RECORD) != false ? 1 : 0;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, HAS_RECORD);
    }

    public static class TileEntityJukebox
    extends TileEntity {
        private ItemStack f67f6116135;

        @Override
        public void readFromNBT(NBTTagCompound nBTTagCompound) {
            super.readFromNBT(nBTTagCompound);
            if (nBTTagCompound.hasKey("RecordItem", 10)) {
                this.setRecord(ItemStack.loadItemStackFromNBT(nBTTagCompound.getCompoundTag("RecordItem")));
            } else if (nBTTagCompound.getInteger("Record") > 0) {
                this.setRecord(new ItemStack(Item.getItemById(nBTTagCompound.getInteger("Record")), 1, 0));
            }
        }

        @Override
        public void writeToNBT(NBTTagCompound nBTTagCompound) {
            super.writeToNBT(nBTTagCompound);
            if (this.getRecord() != null) {
                nBTTagCompound.setTag("RecordItem", this.getRecord().writeToNBT(new NBTTagCompound()));
            }
        }

        public ItemStack getRecord() {
            return this.f67f6116135;
        }

        public void setRecord(ItemStack itemStack) {
            this.f67f6116135 = itemStack;
            this.markDirty();
        }
    }
}

