/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import x.oc22bed258fa;
import x.oc4e1b577a95;

public class BlockNetherWart
extends BlockBush {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);

    protected BlockNetherWart() {
        super(Material.plants, MapColor.redColor);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        this.setTickRandomly(true);
        float f = 0.5f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.setCreativeTab(null);
    }

    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.soul_sand;
    }

    @Override
    public boolean canBlockStay(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return this.canPlaceBlockOn(world2.getBlockState(blockPos.down()).getBlock());
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world2, BlockPos blockPos) {
        if (oc4e1b577a95.\u021c()) {
            return oc22bed258fa.\u0142(blockPos, world2.getBlockState(blockPos));
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
            if (n > 3) {
                n = 3;
            }
            AxisAlignedBB axisAlignedBB = oc22bed258fa.\u020c[n];
            this.setBlockBounds((float)axisAlignedBB.minX, (float)axisAlignedBB.minY, (float)axisAlignedBB.minZ, (float)axisAlignedBB.maxX, (float)axisAlignedBB.maxY, (float)axisAlignedBB.maxZ);
            return;
        }
        super.setBlockBoundsBasedOnState(iBlockAccess, blockPos);
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        int n = iBlockState.getValue(AGE);
        if (n < 3 && random.nextInt(10) == 0) {
            iBlockState = iBlockState.withProperty(AGE, n + 1);
            world2.setBlockState(blockPos, iBlockState, 2);
        }
        super.updateTick(world2, blockPos, iBlockState, random);
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        if (!world2.isRemote) {
            int n2 = 1;
            if (iBlockState.getValue(AGE) >= 3) {
                n2 = 2 + world2.rand.nextInt(3);
                if (n > 0) {
                    n2 += world2.rand.nextInt(n + 1);
                }
            }
            for (int i = 0; i < n2; ++i) {
                BlockNetherWart.spawnAsEntity(world2, blockPos, new ItemStack(Items.nether_wart));
            }
        }
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
    public Item getItem(World world2, BlockPos blockPos) {
        return Items.nether_wart;
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

