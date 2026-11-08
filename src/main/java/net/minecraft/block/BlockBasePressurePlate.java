/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockBasePressurePlate
extends Block {
    protected BlockBasePressurePlate(Material material) {
        this(material, material.getMaterialMapColor());
    }

    protected BlockBasePressurePlate(Material material, MapColor mapColor) {
        super(material, mapColor);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setTickRandomly(true);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        this.setBlockBoundsBasedOnState0(iBlockAccess.getBlockState(blockPos));
    }

    protected void setBlockBoundsBasedOnState0(IBlockState iBlockState) {
        boolean bl = this.getRedstoneStrength(iBlockState) > 0;
        float f = 0.0625f;
        if (bl) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.03125f, 0.9375f);
        } else {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.0625f, 0.9375f);
        }
    }

    @Override
    public int tickRate(World world2) {
        return 20;
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
    public boolean isPassable(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return true;
    }

    @Override
    public boolean canSpawnInBlock() {
        return true;
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return this.canBePlacedOn(world2, blockPos.down());
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!this.canBePlacedOn(world2, blockPos.down())) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
        }
    }

    private boolean canBePlacedOn(World world2, BlockPos blockPos) {
        return World.doesBlockHaveSolidTopSurface(world2, blockPos) || world2.getBlockState(blockPos).getBlock() instanceof BlockFence;
    }

    @Override
    public void randomTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        int n;
        if (!world2.isRemote && (n = this.getRedstoneStrength(iBlockState)) > 0) {
            this.updateState(world2, blockPos, iBlockState, n);
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world2, BlockPos blockPos, IBlockState iBlockState, Entity entity) {
        int n;
        if (!world2.isRemote && (n = this.getRedstoneStrength(iBlockState)) == 0) {
            this.updateState(world2, blockPos, iBlockState, n);
        }
    }

    protected void updateState(World world2, BlockPos blockPos, IBlockState iBlockState, int n) {
        boolean bl;
        int n2 = this.computeRedstoneStrength(world2, blockPos);
        boolean bl2 = n > 0;
        boolean bl3 = bl = n2 > 0;
        if (n != n2) {
            iBlockState = this.setRedstoneStrength(iBlockState, n2);
            world2.setBlockState(blockPos, iBlockState, 2);
            this.updateNeighbors(world2, blockPos);
            world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
        }
        if (!bl && bl2) {
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.1, (double)blockPos.getZ() + 0.5, "random.click", 0.3f, 0.5f);
        } else if (bl && !bl2) {
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.1, (double)blockPos.getZ() + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (bl) {
            world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
        }
    }

    protected AxisAlignedBB getSensitiveAABB(BlockPos blockPos) {
        float f = 0.125f;
        return new AxisAlignedBB((float)blockPos.getX() + 0.125f, blockPos.getY(), (float)blockPos.getZ() + 0.125f, (float)(blockPos.getX() + 1) - 0.125f, (double)blockPos.getY() + 0.25, (float)(blockPos.getZ() + 1) - 0.125f);
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (this.getRedstoneStrength(iBlockState) > 0) {
            this.updateNeighbors(world2, blockPos);
        }
        super.breakBlock(world2, blockPos, iBlockState);
    }

    protected void updateNeighbors(World world2, BlockPos blockPos) {
        world2.notifyNeighborsOfStateChange(blockPos, this);
        world2.notifyNeighborsOfStateChange(blockPos.down(), this);
    }

    @Override
    public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return this.getRedstoneStrength(iBlockState);
    }

    @Override
    public int getStrongPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return enumFacing == EnumFacing.UP ? this.getRedstoneStrength(iBlockState) : 0;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.5f;
        float f2 = 0.125f;
        float f3 = 0.5f;
        this.setBlockBounds(0.0f, 0.375f, 0.0f, 1.0f, 0.625f, 1.0f);
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    protected abstract int computeRedstoneStrength(World var1, BlockPos var2);

    protected abstract int getRedstoneStrength(IBlockState var1);

    protected abstract IBlockState setRedstoneStrength(IBlockState var1, int var2);
}

