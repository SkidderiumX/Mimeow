/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockFalling
extends Block {
    public static boolean fallInstantly;

    public BlockFalling() {
        super(Material.sand);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public BlockFalling(Material material) {
        super(material);
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
        if (!world2.isRemote) {
            this.checkFallable(world2, blockPos);
        }
    }

    private void checkFallable(World world2, BlockPos blockPos) {
        if (BlockFalling.canFallInto(world2, blockPos.down()) && blockPos.getY() >= 0) {
            int n = 32;
            if (!fallInstantly && world2.isAreaLoaded(blockPos.add(-n, -n, -n), blockPos.add(n, n, n))) {
                if (!world2.isRemote) {
                    EntityFallingBlock entityFallingBlock = new EntityFallingBlock(world2, (double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, world2.getBlockState(blockPos));
                    this.onStartFalling(entityFallingBlock);
                    world2.spawnEntityInWorld(entityFallingBlock);
                }
            } else {
                world2.setBlockToAir(blockPos);
                BlockPos blockPos2 = blockPos.down();
                while (BlockFalling.canFallInto(world2, blockPos2) && blockPos2.getY() > 0) {
                    blockPos2 = blockPos2.down();
                }
                if (blockPos2.getY() > 0) {
                    world2.setBlockState(blockPos2.up(), this.getDefaultState());
                }
            }
        }
    }

    protected void onStartFalling(EntityFallingBlock entityFallingBlock) {
    }

    @Override
    public int tickRate(World world2) {
        return 2;
    }

    public static boolean canFallInto(World world2, BlockPos blockPos) {
        Block block = world2.getBlockState(blockPos).getBlock();
        Material material = block.blockMaterial;
        return block == Blocks.fire || material == Material.air || material == Material.water || material == Material.lava;
    }

    public void onEndFalling(World world2, BlockPos blockPos) {
    }
}

