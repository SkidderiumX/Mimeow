/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTripWireHook;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTripWire
extends Block {
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyBool SUSPENDED = PropertyBool.create("suspended");
    public static final PropertyBool ATTACHED = PropertyBool.create("attached");
    public static final PropertyBool DISARMED = PropertyBool.create("disarmed");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");

    public BlockTripWire() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false).withProperty(SUSPENDED, false).withProperty(ATTACHED, false).withProperty(DISARMED, false).withProperty(NORTH, false).withProperty(EAST, false).withProperty(SOUTH, false).withProperty(WEST, false));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.15625f, 1.0f);
        this.setTickRandomly(true);
    }

    @Override
    public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        return iBlockState.withProperty(NORTH, BlockTripWire.isConnectedTo(iBlockAccess, blockPos, iBlockState, EnumFacing.NORTH)).withProperty(EAST, BlockTripWire.isConnectedTo(iBlockAccess, blockPos, iBlockState, EnumFacing.EAST)).withProperty(SOUTH, BlockTripWire.isConnectedTo(iBlockAccess, blockPos, iBlockState, EnumFacing.SOUTH)).withProperty(WEST, BlockTripWire.isConnectedTo(iBlockAccess, blockPos, iBlockState, EnumFacing.WEST));
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Items.string;
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Items.string;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        boolean bl;
        boolean bl2 = iBlockState.getValue(SUSPENDED);
        boolean bl3 = bl = !World.doesBlockHaveSolidTopSurface(world2, blockPos.down());
        if (bl2 != bl) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        boolean bl = iBlockState.getValue(ATTACHED);
        boolean bl2 = iBlockState.getValue(SUSPENDED);
        if (!bl2) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.09375f, 1.0f);
        } else if (!bl) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0625f, 0.0f, 1.0f, 0.15625f, 1.0f);
        }
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        iBlockState = iBlockState.withProperty(SUSPENDED, !World.doesBlockHaveSolidTopSurface(world2, blockPos.down()));
        world2.setBlockState(blockPos, iBlockState, 3);
        this.notifyHook(world2, blockPos, iBlockState);
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.notifyHook(world2, blockPos, iBlockState.withProperty(POWERED, true));
    }

    @Override
    public void onBlockHarvested(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
        if (!world2.isRemote && entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().getItem() == Items.shears) {
            world2.setBlockState(blockPos, iBlockState.withProperty(DISARMED, true), 4);
        }
    }

    private void notifyHook(World world2, BlockPos blockPos, IBlockState iBlockState) {
        block0: for (EnumFacing enumFacing : new EnumFacing[]{EnumFacing.SOUTH, EnumFacing.WEST}) {
            for (int i = 1; i < 42; ++i) {
                BlockPos blockPos2 = blockPos.offset(enumFacing, i);
                IBlockState iBlockState2 = world2.getBlockState(blockPos2);
                if (iBlockState2.getBlock() == Blocks.tripwire_hook) {
                    if (iBlockState2.getValue(BlockTripWireHook.FACING) != enumFacing.getOpposite()) continue block0;
                    Blocks.tripwire_hook.func_176260_a(world2, blockPos2, iBlockState2, false, true, i, iBlockState);
                    continue block0;
                }
                if (iBlockState2.getBlock() != Blocks.tripwire) continue block0;
            }
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world2, BlockPos blockPos, IBlockState iBlockState, Entity entity) {
        if (!world2.isRemote && !iBlockState.getValue(POWERED).booleanValue()) {
            this.updateState(world2, blockPos);
        }
    }

    @Override
    public void randomTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (!world2.isRemote && world2.getBlockState(blockPos).getValue(POWERED).booleanValue()) {
            this.updateState(world2, blockPos);
        }
    }

    private void updateState(World world2, BlockPos blockPos) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        boolean bl = iBlockState.getValue(POWERED);
        boolean bl2 = false;
        List<Entity> list = world2.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB((double)blockPos.getX() + this.minX, (double)blockPos.getY() + this.minY, (double)blockPos.getZ() + this.minZ, (double)blockPos.getX() + this.maxX, (double)blockPos.getY() + this.maxY, (double)blockPos.getZ() + this.maxZ));
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (entity.doesEntityNotTriggerPressurePlate()) continue;
                bl2 = true;
                break;
            }
        }
        if (bl2 != bl) {
            iBlockState = iBlockState.withProperty(POWERED, bl2);
            world2.setBlockState(blockPos, iBlockState, 3);
            this.notifyHook(world2, blockPos, iBlockState);
        }
        if (bl2) {
            world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
        }
    }

    public static boolean isConnectedTo(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        IBlockState iBlockState2 = iBlockAccess.getBlockState(blockPos2);
        Block block = iBlockState2.getBlock();
        if (block == Blocks.tripwire_hook) {
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            return iBlockState2.getValue(BlockTripWireHook.FACING) == enumFacing2;
        }
        if (block == Blocks.tripwire) {
            boolean bl;
            boolean bl2 = iBlockState.getValue(SUSPENDED);
            return bl2 == (bl = iBlockState2.getValue(SUSPENDED).booleanValue());
        }
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(POWERED, (n & 1) > 0).withProperty(SUSPENDED, (n & 2) > 0).withProperty(ATTACHED, (n & 4) > 0).withProperty(DISARMED, (n & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        if (iBlockState.getValue(POWERED).booleanValue()) {
            n |= 1;
        }
        if (iBlockState.getValue(SUSPENDED).booleanValue()) {
            n |= 2;
        }
        if (iBlockState.getValue(ATTACHED).booleanValue()) {
            n |= 4;
        }
        if (iBlockState.getValue(DISARMED).booleanValue()) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, POWERED, SUSPENDED, ATTACHED, DISARMED, NORTH, EAST, WEST, SOUTH);
    }
}

