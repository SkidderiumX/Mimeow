/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

public class BlockDispenser
extends BlockContainer {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool TRIGGERED = PropertyBool.create("triggered");
    public static final RegistryDefaulted<Item, IBehaviorDispenseItem> dispenseBehaviorRegistry = new RegistryDefaulted(new BehaviorDefaultDispenseItem());
    protected Random rand = new Random();

    protected BlockDispenser() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(TRIGGERED, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public int tickRate(World world2) {
        return 4;
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        super.onBlockAdded(world2, blockPos, iBlockState);
        this.setDefaultDirection(world2, blockPos, iBlockState);
    }

    private void setDefaultDirection(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote) {
            EnumFacing enumFacing = iBlockState.getValue(FACING);
            boolean bl = world2.getBlockState(blockPos.north()).getBlock().isFullBlock();
            boolean bl2 = world2.getBlockState(blockPos.south()).getBlock().isFullBlock();
            if (enumFacing == EnumFacing.NORTH && bl && !bl2) {
                enumFacing = EnumFacing.SOUTH;
            } else if (enumFacing == EnumFacing.SOUTH && bl2 && !bl) {
                enumFacing = EnumFacing.NORTH;
            } else {
                boolean bl3 = world2.getBlockState(blockPos.west()).getBlock().isFullBlock();
                boolean bl4 = world2.getBlockState(blockPos.east()).getBlock().isFullBlock();
                if (enumFacing == EnumFacing.WEST && bl3 && !bl4) {
                    enumFacing = EnumFacing.EAST;
                } else if (enumFacing == EnumFacing.EAST && bl4 && !bl3) {
                    enumFacing = EnumFacing.WEST;
                }
            }
            world2.setBlockState(blockPos, iBlockState.withProperty(FACING, enumFacing).withProperty(TRIGGERED, false), 2);
        }
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (world2.isRemote) {
            return true;
        }
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityDispenser) {
            entityPlayer.displayGUIChest((TileEntityDispenser)tileEntity);
            if (tileEntity instanceof TileEntityDropper) {
                entityPlayer.triggerAchievement(StatList.field_181731_O);
            } else {
                entityPlayer.triggerAchievement(StatList.field_181733_Q);
            }
        }
        return true;
    }

    protected void dispense(World world2, BlockPos blockPos) {
        BlockSourceImpl blockSourceImpl = new BlockSourceImpl(world2, blockPos);
        TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)blockSourceImpl.getBlockTileEntity();
        if (tileEntityDispenser != null) {
            int n = tileEntityDispenser.getDispenseSlot();
            if (n < 0) {
                world2.playAuxSFX(1001, blockPos, 0);
            } else {
                ItemStack itemStack = tileEntityDispenser.getStackInSlot(n);
                IBehaviorDispenseItem iBehaviorDispenseItem = this.getBehavior(itemStack);
                if (iBehaviorDispenseItem != IBehaviorDispenseItem.itemDispenseBehaviorProvider) {
                    ItemStack itemStack2 = iBehaviorDispenseItem.dispense(blockSourceImpl, itemStack);
                    tileEntityDispenser.setInventorySlotContents(n, itemStack2.stackSize <= 0 ? null : itemStack2);
                }
            }
        }
    }

    protected IBehaviorDispenseItem getBehavior(ItemStack itemStack) {
        return dispenseBehaviorRegistry.getObject(itemStack == null ? null : itemStack.getItem());
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        boolean bl = world2.isBlockPowered(blockPos) || world2.isBlockPowered(blockPos.up());
        boolean bl2 = iBlockState.getValue(TRIGGERED);
        if (bl && !bl2) {
            world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
            world2.setBlockState(blockPos, iBlockState.withProperty(TRIGGERED, true), 4);
        } else if (!bl && bl2) {
            world2.setBlockState(blockPos, iBlockState.withProperty(TRIGGERED, false), 4);
        }
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (!world2.isRemote) {
            this.dispense(world2, blockPos);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world2, int n) {
        return new TileEntityDispenser();
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        return this.getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(world2, blockPos, entityLivingBase)).withProperty(TRIGGERED, false);
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntity tileEntity;
        world2.setBlockState(blockPos, iBlockState.withProperty(FACING, BlockPistonBase.getFacingFromEntity(world2, blockPos, entityLivingBase)), 2);
        if (itemStack.hasDisplayName() && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntityDispenser) {
            ((TileEntityDispenser)tileEntity).setCustomName(itemStack.getDisplayName());
        }
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityDispenser) {
            InventoryHelper.dropInventoryItems(world2, blockPos, (IInventory)((TileEntityDispenser)tileEntity));
            world2.updateComparatorOutputLevel(blockPos, this);
        }
        super.breakBlock(world2, blockPos, iBlockState);
    }

    public static IPosition getDispensePosition(IBlockSource iBlockSource) {
        EnumFacing enumFacing = BlockDispenser.getFacing(iBlockSource.getBlockMetadata());
        double d = iBlockSource.getX() + 0.7 * (double)enumFacing.getFrontOffsetX();
        double d2 = iBlockSource.getY() + 0.7 * (double)enumFacing.getFrontOffsetY();
        double d3 = iBlockSource.getZ() + 0.7 * (double)enumFacing.getFrontOffsetZ();
        return new PositionImpl(d, d2, d3);
    }

    public static EnumFacing getFacing(int n) {
        return EnumFacing.getFront(n & 7);
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
    public int getRenderType() {
        return 3;
    }

    @Override
    public IBlockState getStateForEntityRender(IBlockState iBlockState) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, BlockDispenser.getFacing(n)).withProperty(TRIGGERED, (n & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(FACING).getIndex();
        if (iBlockState.getValue(TRIGGERED).booleanValue()) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, TRIGGERED);
    }
}

