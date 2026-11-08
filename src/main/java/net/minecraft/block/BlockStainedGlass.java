/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class BlockStainedGlass
extends BlockBreakable {
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    public BlockStainedGlass(Material material) {
        super(material, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int damageDropped(IBlockState iBlockState) {
        return iBlockState.getValue(COLOR).getMetadata();
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (EnumDyeColor enumDyeColor : EnumDyeColor.values()) {
            list.add(new ItemStack(item, 1, enumDyeColor.getMetadata()));
        }
    }

    @Override
    public MapColor getMapColor(IBlockState iBlockState) {
        return iBlockState.getValue(COLOR).getMapColor();
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    protected boolean canSilkHarvest() {
        return true;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(n));
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote) {
            BlockBeacon.updateColorAsync(world2, blockPos);
        }
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote) {
            BlockBeacon.updateColorAsync(world2, blockPos);
        }
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(COLOR).getMetadata();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, COLOR);
    }
}

