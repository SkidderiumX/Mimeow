/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class BlockContainer
extends Block
implements ITileEntityProvider {
    protected BlockContainer(Material material) {
        this(material, material.getMaterialMapColor());
    }

    protected BlockContainer(Material material, MapColor mapColor) {
        super(material, mapColor);
        this.isBlockContainer = true;
    }

    protected boolean isInvalidNeighbor(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        return world2.getBlockState(blockPos.offset(enumFacing)).getBlock().getMaterial() == Material.cactus;
    }

    protected boolean hasInvalidNeighbor(World world2, BlockPos blockPos) {
        return this.isInvalidNeighbor(world2, blockPos, EnumFacing.NORTH) || this.isInvalidNeighbor(world2, blockPos, EnumFacing.SOUTH) || this.isInvalidNeighbor(world2, blockPos, EnumFacing.WEST) || this.isInvalidNeighbor(world2, blockPos, EnumFacing.EAST);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        super.breakBlock(world2, blockPos, iBlockState);
        world2.removeTileEntity(blockPos);
    }

    @Override
    public boolean onBlockEventReceived(World world2, BlockPos blockPos, IBlockState iBlockState, int n, int n2) {
        super.onBlockEventReceived(world2, blockPos, iBlockState, n, n2);
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        return tileEntity == null ? false : tileEntity.receiveClientEvent(n, n2);
    }
}

