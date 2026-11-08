/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Tuple;
import net.minecraft.world.World;

public class BlockSponge
extends Block {
    public static final PropertyBool WET = PropertyBool.create("wet");

    protected BlockSponge() {
        super(Material.sponge);
        this.setDefaultState(this.blockState.getBaseState().withProperty(WET, false));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + ".dry.name");
    }

    @Override
    public int damageDropped(IBlockState iBlockState) {
        return iBlockState.getValue(WET) != false ? 1 : 0;
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.tryAbsorb(world2, blockPos, iBlockState);
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        this.tryAbsorb(world2, blockPos, iBlockState);
        super.onNeighborBlockChange(world2, blockPos, iBlockState, block);
    }

    protected void tryAbsorb(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!iBlockState.getValue(WET).booleanValue() && this.absorb(world2, blockPos)) {
            world2.setBlockState(blockPos, iBlockState.withProperty(WET, true), 2);
            world2.playAuxSFX(2001, blockPos, Block.getIdFromBlock(Blocks.water));
        }
    }

    private boolean absorb(World world2, BlockPos blockPos) {
        LinkedList<Tuple<BlockPos, Integer>> linkedList = Lists.newLinkedList();
        ArrayList<BlockPos> arrayList = Lists.newArrayList();
        linkedList.add(new Tuple<BlockPos, Integer>(blockPos, 0));
        int n = 0;
        while (!linkedList.isEmpty()) {
            Tuple tuple = (Tuple)linkedList.poll();
            BlockPos blockPos2 = (BlockPos)tuple.getFirst();
            int n2 = (Integer)tuple.getSecond();
            for (EnumFacing enumFacing : EnumFacing.values()) {
                BlockPos blockPos3 = blockPos2.offset(enumFacing);
                if (world2.getBlockState(blockPos3).getBlock().getMaterial() != Material.water) continue;
                world2.setBlockState(blockPos3, Blocks.air.getDefaultState(), 2);
                arrayList.add(blockPos3);
                ++n;
                if (n2 >= 6) continue;
                linkedList.add(new Tuple<BlockPos, Integer>(blockPos3, n2 + 1));
            }
            if (n <= 64) continue;
            break;
        }
        for (BlockPos blockPos2 : arrayList) {
            world2.notifyNeighborsOfStateChange(blockPos2, Blocks.air);
        }
        return n > 0;
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(WET, (n & 1) == 1);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(WET) != false ? 1 : 0;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, WET);
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        EnumFacing enumFacing;
        if (iBlockState.getValue(WET).booleanValue() && (enumFacing = EnumFacing.random(random)) != EnumFacing.UP && !World.doesBlockHaveSolidTopSurface(world2, blockPos.offset(enumFacing))) {
            double d = blockPos.getX();
            double d2 = blockPos.getY();
            double d3 = blockPos.getZ();
            if (enumFacing == EnumFacing.DOWN) {
                d2 -= 0.05;
                d += random.nextDouble();
                d3 += random.nextDouble();
            } else {
                d2 += random.nextDouble() * 0.8;
                if (enumFacing.getAxis() == EnumFacing.Axis.X) {
                    d3 += random.nextDouble();
                    d = enumFacing == EnumFacing.EAST ? (d += 1.0) : (d += 0.05);
                } else {
                    d += random.nextDouble();
                    d3 = enumFacing == EnumFacing.SOUTH ? (d3 += 1.0) : (d3 += 0.05);
                }
            }
            world2.spawnParticle(EnumParticleTypes.DRIP_WATER, d, d2, d3, 0.0, 0.0, 0.0, new int[0]);
        }
    }
}

