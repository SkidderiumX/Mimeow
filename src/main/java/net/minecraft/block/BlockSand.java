/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockSand
extends BlockFalling {
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockSand() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.SAND));
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
    public MapColor getMapColor(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).getMapColor();
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
        SAND(0, "sand", "default", MapColor.sandColor),
        RED_SAND(1, "red_sand", "red", MapColor.adobeColor);

        private static final EnumType[] META_LOOKUP;
        private final int meta;
        private final String name;
        private final MapColor mapColor;
        private final String unlocalizedName;

        private EnumType(int n2, String string2, String string3, MapColor mapColor) {
            this.meta = n2;
            this.name = string2;
            this.mapColor = mapColor;
            this.unlocalizedName = string3;
        }

        public int getMetadata() {
            return this.meta;
        }

        public String toString() {
            return this.name;
        }

        public MapColor getMapColor() {
            return this.mapColor;
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

