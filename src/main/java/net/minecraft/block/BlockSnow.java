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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSnow
extends Block {
    public static final PropertyInteger LAYERS = PropertyInteger.create("layers", 1, 8);

    protected BlockSnow() {
        super(Material.snow);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LAYERS, 1));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBoundsForItemRender();
    }

    @Override
    public boolean isPassable(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return iBlockAccess.getBlockState(blockPos).getValue(LAYERS) < 5;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        int n = iBlockState.getValue(LAYERS) - 1;
        float f = 0.125f;
        return new AxisAlignedBB((double)blockPos.getX() + this.minX, (double)blockPos.getY() + this.minY, (double)blockPos.getZ() + this.minZ, (double)blockPos.getX() + this.maxX, (float)blockPos.getY() + (float)n * f, (double)blockPos.getZ() + this.maxZ);
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
    public void setBlockBoundsForItemRender() {
        this.getBoundsForLayers(0);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        this.getBoundsForLayers(iBlockState.getValue(LAYERS));
    }

    protected void getBoundsForLayers(int n) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, (float)n / 8.0f, 1.0f);
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        IBlockState iBlockState = world2.getBlockState(blockPos.down());
        Block block = iBlockState.getBlock();
        return block != Blocks.ice && block != Blocks.packed_ice ? (block.getMaterial() == Material.leaves ? true : (block == this && iBlockState.getValue(LAYERS) >= 7 ? true : block.isOpaqueCube() && block.blockMaterial.blocksMovement())) : false;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        this.checkAndDropBlock(world2, blockPos, iBlockState);
    }

    private boolean checkAndDropBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!this.canPlaceBlockAt(world2, blockPos)) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
            return false;
        }
        return true;
    }

    @Override
    public void harvestBlock(World world2, EntityPlayer entityPlayer, BlockPos blockPos, IBlockState iBlockState, TileEntity tileEntity) {
        BlockSnow.spawnAsEntity(world2, blockPos, new ItemStack(Items.snowball, iBlockState.getValue(LAYERS) + 1, 0));
        world2.setBlockToAir(blockPos);
        entityPlayer.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Items.snowball;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (world2.getLightFor(EnumSkyBlock.BLOCK, blockPos) > 11) {
            this.dropBlockAsItem(world2, blockPos, world2.getBlockState(blockPos), 0);
            world2.setBlockToAir(blockPos);
        }
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
        return enumFacing == EnumFacing.UP ? true : super.shouldSideBeRendered(iBlockAccess, blockPos, enumFacing);
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(LAYERS, (n & 7) + 1);
    }

    @Override
    public boolean isReplaceable(World world2, BlockPos blockPos) {
        return world2.getBlockState(blockPos).getValue(LAYERS) == 1;
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(LAYERS) - 1;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, LAYERS);
    }
}

