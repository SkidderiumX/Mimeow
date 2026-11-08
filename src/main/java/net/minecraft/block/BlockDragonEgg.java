/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDragonEgg
extends Block {
    public BlockDragonEgg() {
        super(Material.dragonEgg, MapColor.blackColor);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        this.checkFall(world2, blockPos);
    }

    private void checkFall(World world2, BlockPos blockPos) {
        if (BlockFalling.canFallInto(world2, blockPos.down()) && blockPos.getY() >= 0) {
            int n = 32;
            if (!BlockFalling.fallInstantly && world2.isAreaLoaded(blockPos.add(-n, -n, -n), blockPos.add(n, n, n))) {
                world2.spawnEntityInWorld(new EntityFallingBlock(world2, (float)blockPos.getX() + 0.5f, blockPos.getY(), (float)blockPos.getZ() + 0.5f, this.getDefaultState()));
            } else {
                world2.setBlockToAir(blockPos);
                BlockPos blockPos2 = blockPos;
                while (BlockFalling.canFallInto(world2, blockPos2) && blockPos2.getY() > 0) {
                    blockPos2 = blockPos2.down();
                }
                if (blockPos2.getY() > 0) {
                    world2.setBlockState(blockPos2, this.getDefaultState(), 2);
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        this.teleport(world2, blockPos);
        return true;
    }

    @Override
    public void onBlockClicked(World world2, BlockPos blockPos, EntityPlayer entityPlayer) {
        this.teleport(world2, blockPos);
    }

    private void teleport(World world2, BlockPos blockPos) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (iBlockState.getBlock() == this) {
            for (int i = 0; i < 1000; ++i) {
                BlockPos blockPos2 = blockPos.add(world2.rand.nextInt(16) - world2.rand.nextInt(16), world2.rand.nextInt(8) - world2.rand.nextInt(8), world2.rand.nextInt(16) - world2.rand.nextInt(16));
                if (world2.getBlockState((BlockPos)blockPos2).getBlock().blockMaterial != Material.air) continue;
                if (world2.isRemote) {
                    for (int j = 0; j < 128; ++j) {
                        double d = world2.rand.nextDouble();
                        float f = (world2.rand.nextFloat() - 0.5f) * 0.2f;
                        float f2 = (world2.rand.nextFloat() - 0.5f) * 0.2f;
                        float f3 = (world2.rand.nextFloat() - 0.5f) * 0.2f;
                        double d2 = (double)blockPos2.getX() + (double)(blockPos.getX() - blockPos2.getX()) * d + (world2.rand.nextDouble() - 0.5) * 1.0 + 0.5;
                        double d3 = (double)blockPos2.getY() + (double)(blockPos.getY() - blockPos2.getY()) * d + world2.rand.nextDouble() * 1.0 - 0.5;
                        double d4 = (double)blockPos2.getZ() + (double)(blockPos.getZ() - blockPos2.getZ()) * d + (world2.rand.nextDouble() - 0.5) * 1.0 + 0.5;
                        world2.spawnParticle(EnumParticleTypes.PORTAL, d2, d3, d4, (double)f, (double)f2, (double)f3, new int[0]);
                    }
                } else {
                    world2.setBlockState(blockPos2, iBlockState, 2);
                    world2.setBlockToAir(blockPos);
                }
                return;
            }
        }
    }

    @Override
    public int tickRate(World world2) {
        return 5;
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
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
        return true;
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return null;
    }
}

