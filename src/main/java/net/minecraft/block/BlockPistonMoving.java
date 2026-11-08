/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonMoving
extends BlockContainer {
    public static final PropertyDirection FACING = BlockPistonExtension.FACING;
    public static final PropertyEnum<BlockPistonExtension.EnumPistonType> TYPE = BlockPistonExtension.TYPE;

    public BlockPistonMoving() {
        super(Material.piston);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(TYPE, BlockPistonExtension.EnumPistonType.DEFAULT));
        this.setHardness(-1.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World world2, int n) {
        return null;
    }

    public static TileEntity newTileEntity(IBlockState iBlockState, EnumFacing enumFacing, boolean bl, boolean bl2) {
        return new TileEntityPiston(iBlockState, enumFacing, bl, bl2);
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityPiston) {
            ((TileEntityPiston)tileEntity).clearPistonTileEntity();
        } else {
            super.breakBlock(world2, blockPos, iBlockState);
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return false;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        return false;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world2, BlockPos blockPos, IBlockState iBlockState) {
        BlockPos blockPos2 = blockPos.offset(iBlockState.getValue(FACING).getOpposite());
        IBlockState iBlockState2 = world2.getBlockState(blockPos2);
        if (iBlockState2.getBlock() instanceof BlockPistonBase && iBlockState2.getValue(BlockPistonBase.EXTENDED).booleanValue()) {
            world2.setBlockToAir(blockPos2);
        }
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
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (!world2.isRemote && world2.getTileEntity(blockPos) == null) {
            world2.setBlockToAir(blockPos);
            return true;
        }
        return false;
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return null;
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        TileEntityPiston tileEntityPiston;
        if (!world2.isRemote && (tileEntityPiston = this.getTileEntity(world2, blockPos)) != null) {
            IBlockState iBlockState2 = tileEntityPiston.getPistonState();
            iBlockState2.getBlock().dropBlockAsItem(world2, blockPos, iBlockState2, 0);
        }
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world2, BlockPos blockPos, Vec3 vec3, Vec3 vec32) {
        return null;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!world2.isRemote) {
            world2.getTileEntity(blockPos);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        TileEntityPiston tileEntityPiston = this.getTileEntity(world2, blockPos);
        if (tileEntityPiston == null) {
            return null;
        }
        float f = tileEntityPiston.getProgress(0.0f);
        if (tileEntityPiston.isExtending()) {
            f = 1.0f - f;
        }
        return this.getBoundingBox(world2, blockPos, tileEntityPiston.getPistonState(), f, tileEntityPiston.getFacing());
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        TileEntityPiston tileEntityPiston = this.getTileEntity(iBlockAccess, blockPos);
        if (tileEntityPiston != null) {
            IBlockState iBlockState = tileEntityPiston.getPistonState();
            Block block = iBlockState.getBlock();
            if (block == this || block.getMaterial() == Material.air) {
                return;
            }
            float f = tileEntityPiston.getProgress(0.0f);
            if (tileEntityPiston.isExtending()) {
                f = 1.0f - f;
            }
            block.setBlockBoundsBasedOnState(iBlockAccess, blockPos);
            if (block == Blocks.piston || block == Blocks.sticky_piston) {
                f = 0.0f;
            }
            EnumFacing enumFacing = tileEntityPiston.getFacing();
            this.minX = block.getBlockBoundsMinX() - (double)((float)enumFacing.getFrontOffsetX() * f);
            this.minY = block.getBlockBoundsMinY() - (double)((float)enumFacing.getFrontOffsetY() * f);
            this.minZ = block.getBlockBoundsMinZ() - (double)((float)enumFacing.getFrontOffsetZ() * f);
            this.maxX = block.getBlockBoundsMaxX() - (double)((float)enumFacing.getFrontOffsetX() * f);
            this.maxY = block.getBlockBoundsMaxY() - (double)((float)enumFacing.getFrontOffsetY() * f);
            this.maxZ = block.getBlockBoundsMaxZ() - (double)((float)enumFacing.getFrontOffsetZ() * f);
        }
    }

    public AxisAlignedBB getBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState, float f, EnumFacing enumFacing) {
        if (iBlockState.getBlock() != this && iBlockState.getBlock().getMaterial() != Material.air) {
            AxisAlignedBB axisAlignedBB = iBlockState.getBlock().getCollisionBoundingBox(world2, blockPos, iBlockState);
            if (axisAlignedBB == null) {
                return null;
            }
            double d = axisAlignedBB.minX;
            double d2 = axisAlignedBB.minY;
            double d3 = axisAlignedBB.minZ;
            double d4 = axisAlignedBB.maxX;
            double d5 = axisAlignedBB.maxY;
            double d6 = axisAlignedBB.maxZ;
            if (enumFacing.getFrontOffsetX() < 0) {
                d -= (double)((float)enumFacing.getFrontOffsetX() * f);
            } else {
                d4 -= (double)((float)enumFacing.getFrontOffsetX() * f);
            }
            if (enumFacing.getFrontOffsetY() < 0) {
                d2 -= (double)((float)enumFacing.getFrontOffsetY() * f);
            } else {
                d5 -= (double)((float)enumFacing.getFrontOffsetY() * f);
            }
            if (enumFacing.getFrontOffsetZ() < 0) {
                d3 -= (double)((float)enumFacing.getFrontOffsetZ() * f);
            } else {
                d6 -= (double)((float)enumFacing.getFrontOffsetZ() * f);
            }
            return new AxisAlignedBB(d, d2, d3, d4, d5, d6);
        }
        return null;
    }

    private TileEntityPiston getTileEntity(IBlockAccess iBlockAccess, BlockPos blockPos) {
        TileEntity tileEntity = iBlockAccess.getTileEntity(blockPos);
        return tileEntity instanceof TileEntityPiston ? (TileEntityPiston)tileEntity : null;
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return null;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, BlockPistonExtension.getFacing(n)).withProperty(TYPE, (n & 8) > 0 ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(FACING).getIndex();
        if (iBlockState.getValue(TYPE) == BlockPistonExtension.EnumPistonType.STICKY) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, TYPE);
    }
}

