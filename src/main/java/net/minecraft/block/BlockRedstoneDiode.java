/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockRedstoneDiode
extends BlockDirectional {
    protected final boolean isRepeaterPowered;

    protected BlockRedstoneDiode(boolean bl) {
        super(Material.circuits);
        this.isRepeaterPowered = bl;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) ? super.canPlaceBlockAt(world2, blockPos) : false;
    }

    public boolean canBlockStay(World world2, BlockPos blockPos) {
        return World.doesBlockHaveSolidTopSurface(world2, blockPos.down());
    }

    @Override
    public void randomTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (!this.isLocked(world2, blockPos, iBlockState)) {
            boolean bl = this.shouldBePowered(world2, blockPos, iBlockState);
            if (this.isRepeaterPowered && !bl) {
                world2.setBlockState(blockPos, this.getUnpoweredState(iBlockState), 2);
            } else if (!this.isRepeaterPowered) {
                world2.setBlockState(blockPos, this.getPoweredState(iBlockState), 2);
                if (!bl) {
                    world2.updateBlockTick(blockPos, this.getPoweredState(iBlockState).getBlock(), this.getTickDelay(iBlockState), -1);
                }
            }
        }
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
        return enumFacing.getAxis() != EnumFacing.Axis.Y;
    }

    protected boolean isPowered(IBlockState iBlockState) {
        return this.isRepeaterPowered;
    }

    @Override
    public int getStrongPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return this.getWeakPower(iBlockAccess, blockPos, iBlockState, enumFacing);
    }

    @Override
    public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return !this.isPowered(iBlockState) ? 0 : (iBlockState.getValue(FACING) == enumFacing ? this.getActiveSignal(iBlockAccess, blockPos, iBlockState) : 0);
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (this.canBlockStay(world2, blockPos)) {
            this.updateState(world2, blockPos, iBlockState);
        } else {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
            for (EnumFacing enumFacing : EnumFacing.values()) {
                world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing), this);
            }
        }
    }

    protected void updateState(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!this.isLocked(world2, blockPos, iBlockState)) {
            boolean bl = this.shouldBePowered(world2, blockPos, iBlockState);
            if ((this.isRepeaterPowered && !bl || !this.isRepeaterPowered && bl) && !world2.isBlockTickPending(blockPos, this)) {
                int n = -1;
                if (this.isFacingTowardsRepeater(world2, blockPos, iBlockState)) {
                    n = -3;
                } else if (this.isRepeaterPowered) {
                    n = -2;
                }
                world2.updateBlockTick(blockPos, this, this.getDelay(iBlockState), n);
            }
        }
    }

    public boolean isLocked(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState) {
        return false;
    }

    protected boolean shouldBePowered(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return this.calculateInputStrength(world2, blockPos, iBlockState) > 0;
    }

    protected int calculateInputStrength(World world2, BlockPos blockPos, IBlockState iBlockState) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        int n = world2.getRedstonePower(blockPos2, enumFacing);
        if (n >= 15) {
            return n;
        }
        IBlockState iBlockState2 = world2.getBlockState(blockPos2);
        return Math.max(n, iBlockState2.getBlock() == Blocks.redstone_wire ? iBlockState2.getValue(BlockRedstoneWire.POWER) : 0);
    }

    protected int getPowerOnSides(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        EnumFacing enumFacing2 = enumFacing.rotateY();
        EnumFacing enumFacing3 = enumFacing.rotateYCCW();
        return Math.max(this.getPowerOnSide(iBlockAccess, blockPos.offset(enumFacing2), enumFacing2), this.getPowerOnSide(iBlockAccess, blockPos.offset(enumFacing3), enumFacing3));
    }

    protected int getPowerOnSide(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return this.canPowerSide(block) ? (block == Blocks.redstone_wire ? iBlockState.getValue(BlockRedstoneWire.POWER).intValue() : iBlockAccess.getStrongPower(blockPos, enumFacing)) : 0;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        return this.getDefaultState().withProperty(FACING, entityLivingBase.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (this.shouldBePowered(world2, blockPos, iBlockState)) {
            world2.scheduleUpdate(blockPos, this, 1);
        }
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.notifyNeighbors(world2, blockPos, iBlockState);
    }

    protected void notifyNeighbors(World world2, BlockPos blockPos, IBlockState iBlockState) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        BlockPos blockPos2 = blockPos.offset(enumFacing.getOpposite());
        world2.notifyBlockOfStateChange(blockPos2, this);
        world2.notifyNeighborsOfStateExcept(blockPos2, this, enumFacing);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (this.isRepeaterPowered) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing), this);
            }
        }
        super.onBlockDestroyedByPlayer(world2, blockPos, iBlockState);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    protected boolean canPowerSide(Block block) {
        return block.canProvidePower();
    }

    protected int getActiveSignal(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState) {
        return 15;
    }

    public static boolean isRedstoneRepeaterBlockID(Block block) {
        return Blocks.unpowered_repeater.isAssociated(block) || Blocks.unpowered_comparator.isAssociated(block);
    }

    public boolean isAssociated(Block block) {
        return block == this.getPoweredState(this.getDefaultState()).getBlock() || block == this.getUnpoweredState(this.getDefaultState()).getBlock();
    }

    public boolean isFacingTowardsRepeater(World world2, BlockPos blockPos, IBlockState iBlockState) {
        EnumFacing enumFacing = iBlockState.getValue(FACING).getOpposite();
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        return BlockRedstoneDiode.isRedstoneRepeaterBlockID(world2.getBlockState(blockPos2).getBlock()) ? world2.getBlockState(blockPos2).getValue(FACING) != enumFacing : false;
    }

    protected int getTickDelay(IBlockState iBlockState) {
        return this.getDelay(iBlockState);
    }

    protected abstract int getDelay(IBlockState var1);

    protected abstract IBlockState getPoweredState(IBlockState var1);

    protected abstract IBlockState getUnpoweredState(IBlockState var1);

    @Override
    public boolean isAssociatedBlock(Block block) {
        return this.isAssociated(block);
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
}

