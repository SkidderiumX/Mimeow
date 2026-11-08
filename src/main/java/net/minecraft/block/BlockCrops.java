/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockPotato;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import x.oc22bed258fa;
import x.oc4e1b577a95;

public class BlockCrops
extends BlockBush
implements IGrowable {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

    protected BlockCrops() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        this.setTickRandomly(true);
        float f = 0.5f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.setCreativeTab(null);
        this.setHardness(0.0f);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
    }

    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.farmland;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world2, BlockPos blockPos) {
        if (oc4e1b577a95.\u021c()) {
            return oc22bed258fa.\u011d(blockPos, world2.getBlockState(blockPos));
        }
        return super.getSelectedBoundingBox(world2, blockPos);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        if (oc4e1b577a95.\u021c()) {
            IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
            int n = iBlockState.getValue(AGE);
            if (n < 0) {
                n = 0;
            }
            if (n > 7) {
                n = 7;
            }
            AxisAlignedBB axisAlignedBB = iBlockState.getBlock() instanceof BlockPotato || iBlockState.getBlock() instanceof BlockCarrot ? oc22bed258fa.\u042d[n] : oc22bed258fa.\u00e5[n];
            this.setBlockBounds((float)axisAlignedBB.minX, (float)axisAlignedBB.minY, (float)axisAlignedBB.minZ, (float)axisAlignedBB.maxX, (float)axisAlignedBB.maxY, (float)axisAlignedBB.maxZ);
            return;
        }
        super.setBlockBoundsBasedOnState(iBlockAccess, blockPos);
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        float f;
        int n;
        super.updateTick(world2, blockPos, iBlockState, random);
        if (world2.getLightFromNeighbors(blockPos.up()) >= 9 && (n = iBlockState.getValue(AGE).intValue()) < 7 && random.nextInt((int)(25.0f / (f = BlockCrops.getGrowthChance(this, world2, blockPos))) + 1) == 0) {
            world2.setBlockState(blockPos, iBlockState.withProperty(AGE, n + 1), 2);
        }
    }

    public void grow(World world2, BlockPos blockPos, IBlockState iBlockState) {
        int n = iBlockState.getValue(AGE) + MathHelper.getRandomIntegerInRange(world2.rand, 2, 5);
        if (n > 7) {
            n = 7;
        }
        world2.setBlockState(blockPos, iBlockState.withProperty(AGE, n), 2);
    }

    protected static float getGrowthChance(Block block, World world2, BlockPos blockPos) {
        boolean bl;
        Object object;
        float f = 1.0f;
        BlockPos blockPos2 = blockPos.down();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f2 = 0.0f;
                object = world2.getBlockState(blockPos2.add(i, 0, j));
                if (object.getBlock() == Blocks.farmland) {
                    f2 = 1.0f;
                    if (object.getValue(BlockFarmland.MOISTURE) > 0) {
                        f2 = 3.0f;
                    }
                }
                if (i != 0 || j != 0) {
                    f2 /= 4.0f;
                }
                f += f2;
            }
        }
        BlockPos blockPos3 = blockPos.north();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        object = blockPos.east();
        boolean bl2 = block == world2.getBlockState(blockPos5).getBlock() || block == world2.getBlockState((BlockPos)object).getBlock();
        boolean bl3 = bl = block == world2.getBlockState(blockPos3).getBlock() || block == world2.getBlockState(blockPos4).getBlock();
        if (bl2 && bl) {
            f /= 2.0f;
        } else {
            boolean bl4;
            boolean bl5 = bl4 = block == world2.getBlockState(blockPos5.north()).getBlock() || block == world2.getBlockState(((BlockPos)object).north()).getBlock() || block == world2.getBlockState(((BlockPos)object).south()).getBlock() || block == world2.getBlockState(blockPos5.south()).getBlock();
            if (bl4) {
                f /= 2.0f;
            }
        }
        return f;
    }

    @Override
    public boolean canBlockStay(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return (world2.getLight(blockPos) >= 8 || world2.canSeeSky(blockPos)) && this.canPlaceBlockOn(world2.getBlockState(blockPos.down()).getBlock());
    }

    protected Item getSeed() {
        return Items.wheat_seeds;
    }

    protected Item getCrop() {
        return Items.wheat;
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        int n2;
        super.dropBlockAsItemWithChance(world2, blockPos, iBlockState, f, 0);
        if (!world2.isRemote && (n2 = iBlockState.getValue(AGE).intValue()) >= 7) {
            int n3 = 3 + n;
            for (int i = 0; i < n3; ++i) {
                if (world2.rand.nextInt(15) > n2) continue;
                BlockCrops.spawnAsEntity(world2, blockPos, new ItemStack(this.getSeed(), 1, 0));
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return iBlockState.getValue(AGE) == 7 ? this.getCrop() : this.getSeed();
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return this.getSeed();
    }

    @Override
    public boolean canGrow(World world2, BlockPos blockPos, IBlockState iBlockState, boolean bl) {
        return iBlockState.getValue(AGE) < 7;
    }

    @Override
    public boolean canUseBonemeal(World world2, Random random, BlockPos blockPos, IBlockState iBlockState) {
        return true;
    }

    @Override
    public void grow(World world2, Random random, BlockPos blockPos, IBlockState iBlockState) {
        this.grow(world2, blockPos, iBlockState);
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

