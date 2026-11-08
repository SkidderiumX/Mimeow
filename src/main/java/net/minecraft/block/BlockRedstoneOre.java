/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class BlockRedstoneOre
extends Block {
    private final boolean isOn;

    public BlockRedstoneOre(boolean bl) {
        super(Material.rock);
        if (bl) {
            this.setTickRandomly(true);
        }
        this.isOn = bl;
    }

    @Override
    public int tickRate(World world2) {
        return 30;
    }

    @Override
    public void onBlockClicked(World world2, BlockPos blockPos, EntityPlayer entityPlayer) {
        this.activate(world2, blockPos);
        super.onBlockClicked(world2, blockPos, entityPlayer);
    }

    @Override
    public void onEntityCollidedWithBlock(World world2, BlockPos blockPos, Entity entity) {
        this.activate(world2, blockPos);
        super.onEntityCollidedWithBlock(world2, blockPos, entity);
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        this.activate(world2, blockPos);
        return super.onBlockActivated(world2, blockPos, iBlockState, entityPlayer, enumFacing, f, f2, f3);
    }

    private void activate(World world2, BlockPos blockPos) {
        this.spawnParticles(world2, blockPos);
        if (this == Blocks.redstone_ore) {
            world2.setBlockState(blockPos, Blocks.lit_redstone_ore.getDefaultState());
        }
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (this == Blocks.lit_redstone_ore) {
            world2.setBlockState(blockPos, Blocks.redstone_ore.getDefaultState());
        }
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Items.redstone;
    }

    @Override
    public int quantityDroppedWithBonus(int n, Random random) {
        return this.quantityDropped(random) + random.nextInt(n + 1);
    }

    @Override
    public int quantityDropped(Random random) {
        return 4 + random.nextInt(2);
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        super.dropBlockAsItemWithChance(world2, blockPos, iBlockState, f, n);
        if (this.getItemDropped(iBlockState, world2.rand, n) != Item.getItemFromBlock(this)) {
            int n2 = 1 + world2.rand.nextInt(5);
            this.dropXpOnBlockBreak(world2, blockPos, n2);
        }
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (this.isOn) {
            this.spawnParticles(world2, blockPos);
        }
    }

    private void spawnParticles(World world2, BlockPos blockPos) {
        Random random = world2.rand;
        double d = 0.0625;
        for (int i = 0; i < 6; ++i) {
            double d2 = (float)blockPos.getX() + random.nextFloat();
            double d3 = (float)blockPos.getY() + random.nextFloat();
            double d4 = (float)blockPos.getZ() + random.nextFloat();
            if (i == 0 && !world2.getBlockState(blockPos.up()).getBlock().isOpaqueCube()) {
                d3 = (double)blockPos.getY() + d + 1.0;
            }
            if (i == 1 && !world2.getBlockState(blockPos.down()).getBlock().isOpaqueCube()) {
                d3 = (double)blockPos.getY() - d;
            }
            if (i == 2 && !world2.getBlockState(blockPos.south()).getBlock().isOpaqueCube()) {
                d4 = (double)blockPos.getZ() + d + 1.0;
            }
            if (i == 3 && !world2.getBlockState(blockPos.north()).getBlock().isOpaqueCube()) {
                d4 = (double)blockPos.getZ() - d;
            }
            if (i == 4 && !world2.getBlockState(blockPos.east()).getBlock().isOpaqueCube()) {
                d2 = (double)blockPos.getX() + d + 1.0;
            }
            if (i == 5 && !world2.getBlockState(blockPos.west()).getBlock().isOpaqueCube()) {
                d2 = (double)blockPos.getX() - d;
            }
            if (!(d2 < (double)blockPos.getX() || d2 > (double)(blockPos.getX() + 1) || d3 < 0.0 || d3 > (double)(blockPos.getY() + 1) || d4 < (double)blockPos.getZ()) && !(d4 > (double)(blockPos.getZ() + 1))) continue;
            world2.spawnParticle(EnumParticleTypes.REDSTONE, d2, d3, d4, 0.0, 0.0, 0.0, new int[0]);
        }
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState iBlockState) {
        return new ItemStack(Blocks.redstone_ore);
    }
}

