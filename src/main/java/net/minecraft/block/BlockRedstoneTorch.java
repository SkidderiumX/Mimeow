/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneTorch
extends BlockTorch {
    private static Map<World, List<Toggle>> toggles = new WeakHashMap<World, List<Toggle>>();
    private final boolean isOn;

    private boolean isBurnedOut(World world2, BlockPos blockPos, boolean bl) {
        if (!toggles.containsKey(world2)) {
            toggles.put(world2, Lists.newArrayList());
        }
        List<Toggle> list = toggles.get(world2);
        if (bl) {
            list.add(new Toggle(blockPos, world2.getTotalWorldTime()));
        }
        int n = 0;
        for (int i = 0; i < list.size(); ++i) {
            Toggle toggle = list.get(i);
            if (!toggle.pos.equals(blockPos) || ++n < 8) continue;
            return true;
        }
        return false;
    }

    protected BlockRedstoneTorch(boolean bl) {
        this.isOn = bl;
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }

    @Override
    public int tickRate(World world2) {
        return 2;
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (this.isOn) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing), this);
            }
        }
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (this.isOn) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing), this);
            }
        }
    }

    @Override
    public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return this.isOn && iBlockState.getValue(FACING) != enumFacing ? 15 : 0;
    }

    private boolean shouldBeOff(World world2, BlockPos blockPos, IBlockState iBlockState) {
        EnumFacing enumFacing = iBlockState.getValue(FACING).getOpposite();
        return world2.isSidePowered(blockPos.offset(enumFacing), enumFacing);
    }

    @Override
    public void randomTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        boolean bl = this.shouldBeOff(world2, blockPos, iBlockState);
        List<Toggle> list = toggles.get(world2);
        while (list != null && !list.isEmpty() && world2.getTotalWorldTime() - list.get((int)0).time > 60L) {
            list.remove(0);
        }
        if (this.isOn) {
            if (bl) {
                world2.setBlockState(blockPos, Blocks.unlit_redstone_torch.getDefaultState().withProperty(FACING, iBlockState.getValue(FACING)), 3);
                if (this.isBurnedOut(world2, blockPos, true)) {
                    world2.playSoundEffect((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.5f, (float)blockPos.getZ() + 0.5f, "random.fizz", 0.5f, 2.6f + (world2.rand.nextFloat() - world2.rand.nextFloat()) * 0.8f);
                    for (int i = 0; i < 5; ++i) {
                        double d = (double)blockPos.getX() + random.nextDouble() * 0.6 + 0.2;
                        double d2 = (double)blockPos.getY() + random.nextDouble() * 0.6 + 0.2;
                        double d3 = (double)blockPos.getZ() + random.nextDouble() * 0.6 + 0.2;
                        world2.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d, d2, d3, 0.0, 0.0, 0.0, new int[0]);
                    }
                    world2.scheduleUpdate(blockPos, world2.getBlockState(blockPos).getBlock(), 160);
                }
            }
        } else if (!bl && !this.isBurnedOut(world2, blockPos, false)) {
            world2.setBlockState(blockPos, Blocks.redstone_torch.getDefaultState().withProperty(FACING, iBlockState.getValue(FACING)), 3);
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!this.onNeighborChangeInternal(world2, blockPos, iBlockState) && this.isOn == this.shouldBeOff(world2, blockPos, iBlockState)) {
            world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
        }
    }

    @Override
    public int getStrongPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return enumFacing == EnumFacing.DOWN ? this.getWeakPower(iBlockAccess, blockPos, iBlockState, enumFacing) : 0;
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Item.getItemFromBlock(Blocks.redstone_torch);
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (this.isOn) {
            double d = (double)blockPos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            double d2 = (double)blockPos.getY() + 0.7 + (random.nextDouble() - 0.5) * 0.2;
            double d3 = (double)blockPos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            EnumFacing enumFacing = iBlockState.getValue(FACING);
            if (enumFacing.getAxis().isHorizontal()) {
                EnumFacing enumFacing2 = enumFacing.getOpposite();
                double d4 = 0.27;
                d += 0.27 * (double)enumFacing2.getFrontOffsetX();
                d2 += 0.22;
                d3 += 0.27 * (double)enumFacing2.getFrontOffsetZ();
            }
            world2.spawnParticle(EnumParticleTypes.REDSTONE, d, d2, d3, 0.0, 0.0, 0.0, new int[0]);
        }
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Item.getItemFromBlock(Blocks.redstone_torch);
    }

    @Override
    public boolean isAssociatedBlock(Block block) {
        return block == Blocks.unlit_redstone_torch || block == Blocks.redstone_torch;
    }

    public static class Toggle {
        BlockPos pos;
        long time;

        public Toggle(BlockPos blockPos, long l) {
            this.pos = blockPos;
            this.time = l;
        }
    }
}

