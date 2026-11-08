/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class BlockMobSpawner
extends BlockContainer {
    protected BlockMobSpawner() {
        super(Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(World world2, int n) {
        return new TileEntityMobSpawner();
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return null;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        super.dropBlockAsItemWithChance(world2, blockPos, iBlockState, f, n);
        int n2 = 15 + world2.rand.nextInt(15) + world2.rand.nextInt(15);
        this.dropXpOnBlockBreak(world2, blockPos, n2);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return null;
    }
}

