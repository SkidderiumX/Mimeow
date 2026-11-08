/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.viamcp.ViaMCP;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLadder
extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected BlockLadder() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.getCollisionBoundingBox(world2, blockPos, iBlockState);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world2, BlockPos blockPos) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.getSelectedBoundingBox(world2, blockPos);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        if (iBlockState.getBlock() == this) {
            float f = ViaMCP.isTargetVersionAtLeast(ProtocolVersion.v1_9) ? 0.1875f : 0.125f;
            switch (iBlockState.getValue(FACING)) {
                case NORTH: {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case SOUTH: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                    break;
                }
                case WEST: {
                    this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                default: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                }
            }
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
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return world2.getBlockState(blockPos.west()).getBlock().isNormalCube() ? true : (world2.getBlockState(blockPos.east()).getBlock().isNormalCube() ? true : (world2.getBlockState(blockPos.north()).getBlock().isNormalCube() ? true : world2.getBlockState(blockPos.south()).getBlock().isNormalCube()));
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        if (enumFacing.getAxis().isHorizontal() && this.canBlockStay(world2, blockPos, enumFacing)) {
            return this.getDefaultState().withProperty(FACING, enumFacing);
        }
        for (EnumFacing enumFacing2 : EnumFacing.Plane.HORIZONTAL) {
            if (!this.canBlockStay(world2, blockPos, enumFacing2)) continue;
            return this.getDefaultState().withProperty(FACING, enumFacing2);
        }
        return this.getDefaultState();
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        if (!this.canBlockStay(world2, blockPos, enumFacing)) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
        }
        super.onNeighborBlockChange(world2, blockPos, iBlockState, block);
    }

    protected boolean canBlockStay(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        return world2.getBlockState(blockPos.offset(enumFacing.getOpposite())).getBlock().isNormalCube();
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        EnumFacing enumFacing = EnumFacing.getFront(n);
        if (enumFacing.getAxis() == EnumFacing.Axis.Y) {
            enumFacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumFacing);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(FACING).getIndex();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING);
    }
}

