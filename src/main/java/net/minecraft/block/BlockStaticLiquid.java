/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockStaticLiquid
extends BlockLiquid {
    protected BlockStaticLiquid(Material material) {
        super(material);
        this.setTickRandomly(false);
        if (material == Material.lava) {
            this.setTickRandomly(true);
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!this.checkForMixing(world2, blockPos, iBlockState)) {
            this.updateLiquid(world2, blockPos, iBlockState);
        }
    }

    private void updateLiquid(World world2, BlockPos blockPos, IBlockState iBlockState) {
        BlockDynamicLiquid blockDynamicLiquid = BlockStaticLiquid.getFlowingBlock(this.blockMaterial);
        world2.setBlockState(blockPos, blockDynamicLiquid.getDefaultState().withProperty(LEVEL, iBlockState.getValue(LEVEL)), 2);
        world2.scheduleUpdate(blockPos, blockDynamicLiquid, this.tickRate(world2));
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        block5: {
            if (this.blockMaterial != Material.lava || !world2.getGameRules().getBoolean("doFireTick")) break block5;
            int n = random.nextInt(3);
            if (n > 0) {
                BlockPos blockPos2 = blockPos;
                for (int i = 0; i < n; ++i) {
                    blockPos2 = blockPos2.add(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    Block block = world2.getBlockState(blockPos2).getBlock();
                    if (block.blockMaterial == Material.air) {
                        if (!this.isSurroundingBlockFlammable(world2, blockPos2)) continue;
                        world2.setBlockState(blockPos2, Blocks.fire.getDefaultState());
                        return;
                    }
                    if (!block.blockMaterial.blocksMovement()) continue;
                    return;
                }
            } else {
                for (int i = 0; i < 3; ++i) {
                    BlockPos blockPos3 = blockPos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    if (!world2.isAirBlock(blockPos3.up()) || !this.getCanBlockBurn(world2, blockPos3)) continue;
                    world2.setBlockState(blockPos3.up(), Blocks.fire.getDefaultState());
                }
            }
        }
    }

    protected boolean isSurroundingBlockFlammable(World world2, BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (!this.getCanBlockBurn(world2, blockPos.offset(enumFacing))) continue;
            return true;
        }
        return false;
    }

    private boolean getCanBlockBurn(World world2, BlockPos blockPos) {
        return world2.getBlockState(blockPos).getBlock().getMaterial().getCanBurn();
    }
}

