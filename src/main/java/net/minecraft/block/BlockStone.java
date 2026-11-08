/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.StatCollector;

public class BlockStone
extends Block {
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockStone() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + "." + EnumType.STONE.getUnlocalizedName() + ".name");
    }

    @Override
    public MapColor getMapColor(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).func_181072_c();
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return iBlockState.getValue(VARIANT) == EnumType.STONE ? Item.getItemFromBlock(Blocks.cobblestone) : Item.getItemFromBlock(Blocks.stone);
    }

    @Override
    public int damageDropped(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).getMetadata();
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (EnumType enumType : EnumType.values()) {
            list.add(new ItemStack(item, 1, enumType.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata(n));
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).getMetadata();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, VARIANT);
    }

    public static enum EnumType implements IStringSerializable
    {
        STONE(0, MapColor.stoneColor, "stone"),
        GRANITE(1, MapColor.dirtColor, "granite"),
        GRANITE_SMOOTH(2, MapColor.dirtColor, "smooth_granite", "graniteSmooth"),
        DIORITE(3, MapColor.quartzColor, "diorite"),
        DIORITE_SMOOTH(4, MapColor.quartzColor, "smooth_diorite", "dioriteSmooth"),
        ANDESITE(5, MapColor.stoneColor, "andesite"),
        ANDESITE_SMOOTH(6, MapColor.stoneColor, "smooth_andesite", "andesiteSmooth");

        private static final EnumType[] META_LOOKUP;
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final MapColor field_181073_l;

        private EnumType(int n2, MapColor mapColor, String string2) {
            this(n2, mapColor, string2, string2);
        }

        private EnumType(int n2, MapColor mapColor, String string2, String string3) {
            this.meta = n2;
            this.name = string2;
            this.unlocalizedName = string3;
            this.field_181073_l = mapColor;
        }

        public int getMetadata() {
            return this.meta;
        }

        public MapColor func_181072_c() {
            return this.field_181073_l;
        }

        public String toString() {
            return this.name;
        }

        public static EnumType byMetadata(int n) {
            if (n < 0 || n >= META_LOOKUP.length) {
                n = 0;
            }
            return META_LOOKUP[n];
        }

        @Override
        public String getName() {
            return this.name;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

        static {
            META_LOOKUP = new EnumType[EnumType.values().length];
            EnumType[] enumTypeArray = EnumType.values();
            int n = enumTypeArray.length;
            for (int i = 0; i < n; ++i) {
                EnumType enumType;
                EnumType.META_LOOKUP[enumType.getMetadata()] = enumType = enumTypeArray[i];
            }
        }
    }
}

