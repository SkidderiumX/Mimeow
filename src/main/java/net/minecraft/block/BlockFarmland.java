/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockStem;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFarmland
extends Block {
    public static final PropertyInteger MOISTURE = PropertyInteger.create("moisture", 0, 7);

    protected BlockFarmland() {
        super(Material.ground);
        this.setDefaultState(this.blockState.getBaseState().withProperty(MOISTURE, 0));
        this.setTickRandomly(true);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.setLightOpacity(255);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return new AxisAlignedBB(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos.getX() + 1, blockPos.getY() + 1, blockPos.getZ() + 1);
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
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        int n = iBlockState.getValue(MOISTURE);
        if (!this.hasWater(world2, blockPos) && !world2.isRainingAt(blockPos.up())) {
            if (n > 0) {
                world2.setBlockState(blockPos, iBlockState.withProperty(MOISTURE, n - 1), 2);
            } else if (!this.hasCrops(world2, blockPos)) {
                world2.setBlockState(blockPos, Blocks.dirt.getDefaultState());
            }
        } else if (n < 7) {
            world2.setBlockState(blockPos, iBlockState.withProperty(MOISTURE, 7), 2);
        }
    }

    @Override
    public void onFallenUpon(World world2, BlockPos blockPos, Entity entity, float f) {
        if (entity instanceof EntityLivingBase) {
            if (!world2.isRemote && world2.rand.nextFloat() < f - 0.5f) {
                if (!(entity instanceof EntityPlayer) && !world2.getGameRules().getBoolean("mobGriefing")) {
                    return;
                }
                world2.setBlockState(blockPos, Blocks.dirt.getDefaultState());
            }
            super.onFallenUpon(world2, blockPos, entity, f);
        }
    }

    private boolean hasCrops(World world2, BlockPos blockPos) {
        Block block = world2.getBlockState(blockPos.up()).getBlock();
        return block instanceof BlockCrops || block instanceof BlockStem;
    }

    private boolean hasWater(World world2, BlockPos blockPos) {
        for (BlockPos.MutableBlockPos mutableBlockPos : BlockPos.getAllInBoxMutable(blockPos.add(-4, 0, -4), blockPos.add(4, 1, 4))) {
            if (world2.getBlockState(mutableBlockPos).getBlock().getMaterial() != Material.water) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        super.onNeighborBlockChange(world2, blockPos, iBlockState, block);
        if (world2.getBlockState(blockPos.up()).getBlock().getMaterial().isSolid()) {
            world2.setBlockState(blockPos, Blocks.dirt.getDefaultState());
        }
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
        switch (enumFacing) {
            case UP: {
                return true;
            }
            case NORTH: 
            case SOUTH: 
            case WEST: 
            case EAST: {
                Block block = iBlockAccess.getBlockState(blockPos).getBlock();
                return !block.isOpaqueCube() && block != Blocks.farmland;
            }
        }
        return super.shouldSideBeRendered(iBlockAccess, blockPos, enumFacing);
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Blocks.dirt.getItemDropped(Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), random, n);
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Item.getItemFromBlock(Blocks.dirt);
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(MOISTURE, n & 7);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(MOISTURE);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, MOISTURE);
    }
}

