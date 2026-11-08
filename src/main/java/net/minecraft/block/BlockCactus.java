/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import x.oc4e1b577a95;

public class BlockCactus
extends Block {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);

    protected BlockCactus() {
        super(Material.cactus);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        BlockPos blockPos2 = blockPos.up();
        if (world2.isAirBlock(blockPos2)) {
            int n = 1;
            while (world2.getBlockState(blockPos.down(n)).getBlock() == this) {
                ++n;
            }
            if (n < 3) {
                int n2 = iBlockState.getValue(AGE);
                if (n2 == 15) {
                    world2.setBlockState(blockPos2, this.getDefaultState());
                    IBlockState iBlockState2 = iBlockState.withProperty(AGE, 0);
                    world2.setBlockState(blockPos, iBlockState2, 4);
                    this.onNeighborBlockChange(world2, blockPos2, iBlockState2, this);
                } else {
                    world2.setBlockState(blockPos, iBlockState.withProperty(AGE, n2 + 1), 4);
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        float f = 0.0625f;
        return new AxisAlignedBB((float)blockPos.getX() + f, blockPos.getY(), (float)blockPos.getZ() + f, (float)(blockPos.getX() + 1) - f, (float)(blockPos.getY() + 1) - f, (float)(blockPos.getZ() + 1) - f);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world2, BlockPos blockPos) {
        float f = 0.0625f;
        return new AxisAlignedBB((float)blockPos.getX() + f, blockPos.getY(), (float)blockPos.getZ() + f, (float)(blockPos.getX() + 1) - f, blockPos.getY() + 1, (float)(blockPos.getZ() + 1) - f);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        if (oc4e1b577a95.\u021c()) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
            return;
        }
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return super.canPlaceBlockAt(world2, blockPos) ? this.canBlockStay(world2, blockPos) : false;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!this.canBlockStay(world2, blockPos)) {
            world2.destroyBlock(blockPos, true);
        }
    }

    public boolean canBlockStay(World world2, BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
            if (!world2.getBlockState(blockPos.offset(enumFacing)).getBlock().getMaterial().isSolid()) continue;
            return false;
        }
        Block block = world2.getBlockState(blockPos.down()).getBlock();
        return block == Blocks.cactus || block == Blocks.sand;
    }

    @Override
    public void onEntityCollidedWithBlock(World world2, BlockPos blockPos, IBlockState iBlockState, Entity entity) {
        entity.attackEntityFrom(DamageSource.cactus, 1.0f);
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(AGE, n);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(AGE);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, AGE);
    }
}

