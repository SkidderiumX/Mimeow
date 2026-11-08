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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockReed
extends Block {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);

    protected BlockReed() {
        super(Material.plants);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        float f = 0.375f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if ((world2.getBlockState(blockPos.down()).getBlock() == Blocks.reeds || this.checkForDrop(world2, blockPos, iBlockState)) && world2.isAirBlock(blockPos.up())) {
            int n = 1;
            while (world2.getBlockState(blockPos.down(n)).getBlock() == this) {
                ++n;
            }
            if (n < 3) {
                int n2 = iBlockState.getValue(AGE);
                if (n2 == 15) {
                    world2.setBlockState(blockPos.up(), this.getDefaultState());
                    world2.setBlockState(blockPos, iBlockState.withProperty(AGE, 0), 4);
                } else {
                    world2.setBlockState(blockPos, iBlockState.withProperty(AGE, n2 + 1), 4);
                }
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        Block block = world2.getBlockState(blockPos.down()).getBlock();
        if (block == this) {
            return true;
        }
        if (block != Blocks.grass && block != Blocks.dirt && block != Blocks.sand) {
            return false;
        }
        for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
            if (world2.getBlockState(blockPos.offset(enumFacing).down()).getBlock().getMaterial() != Material.water) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        this.checkForDrop(world2, blockPos, iBlockState);
    }

    protected final boolean checkForDrop(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (this.canBlockStay(world2, blockPos)) {
            return true;
        }
        this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
        world2.setBlockToAir(blockPos);
        return false;
    }

    public boolean canBlockStay(World world2, BlockPos blockPos) {
        return this.canPlaceBlockAt(world2, blockPos);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return null;
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Items.reeds;
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
    public Item getItem(World world2, BlockPos blockPos) {
        return Items.reeds;
    }

    @Override
    public int colorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos, int n) {
        return iBlockAccess.getBiomeGenForCoords(blockPos).getGrassColorAtPos(blockPos);
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

