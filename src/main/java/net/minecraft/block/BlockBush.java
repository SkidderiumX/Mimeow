/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class BlockBush
extends Block {
    protected BlockBush() {
        this(Material.plants);
    }

    protected BlockBush(Material material) {
        this(material, material.getMaterialMapColor());
    }

    protected BlockBush(Material material, MapColor mapColor) {
        super(material, mapColor);
        this.setTickRandomly(true);
        float f = 0.2f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return super.canPlaceBlockAt(world2, blockPos) && this.canPlaceBlockOn(world2.getBlockState(blockPos.down()).getBlock());
    }

    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        super.onNeighborBlockChange(world2, blockPos, iBlockState, block);
        this.checkAndDropBlock(world2, blockPos, iBlockState);
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        this.checkAndDropBlock(world2, blockPos, iBlockState);
    }

    protected void checkAndDropBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!this.canBlockStay(world2, blockPos, iBlockState)) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockState(blockPos, Blocks.air.getDefaultState(), 3);
        }
    }

    public boolean canBlockStay(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return this.canPlaceBlockOn(world2.getBlockState(blockPos.down()).getBlock());
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
        return EnumWorldBlockLayer.CUTOUT;
    }
}

