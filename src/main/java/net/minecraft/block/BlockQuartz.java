/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public class BlockQuartz
extends Block {
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockQuartz() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        if (n == EnumType.LINES_Y.getMetadata()) {
            switch (enumFacing.getAxis()) {
                case Z: {
                    return this.getDefaultState().withProperty(VARIANT, EnumType.LINES_Z);
                }
                case X: {
                    return this.getDefaultState().withProperty(VARIANT, EnumType.LINES_X);
                }
            }
            return this.getDefaultState().withProperty(VARIANT, EnumType.LINES_Y);
        }
        return n == EnumType.CHISELED.getMetadata() ? this.getDefaultState().withProperty(VARIANT, EnumType.CHISELED) : this.getDefaultState().withProperty(VARIANT, EnumType.DEFAULT);
    }

    @Override
    public int damageDropped(IBlockState iBlockState) {
        EnumType enumType = iBlockState.getValue(VARIANT);
        return enumType != EnumType.LINES_X && enumType != EnumType.LINES_Z ? enumType.getMetadata() : EnumType.LINES_Y.getMetadata();
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState iBlockState) {
        EnumType enumType = iBlockState.getValue(VARIANT);
        return enumType != EnumType.LINES_X && enumType != EnumType.LINES_Z ? super.createStackedBlock(iBlockState) : new ItemStack(Item.getItemFromBlock(this), 1, EnumType.LINES_Y.getMetadata());
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        list.add(new ItemStack(item, 1, EnumType.DEFAULT.getMetadata()));
        list.add(new ItemStack(item, 1, EnumType.CHISELED.getMetadata()));
        list.add(new ItemStack(item, 1, EnumType.LINES_Y.getMetadata()));
    }

    @Override
    public MapColor getMapColor(IBlockState iBlockState) {
        return MapColor.quartzColor;
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
        DEFAULT(0, "default", "default"),
        CHISELED(1, "chiseled", "chiseled"),
        LINES_Y(2, "lines_y", "lines"),
        LINES_X(3, "lines_x", "lines"),
        LINES_Z(4, "lines_z", "lines");

        private static final EnumType[] META_LOOKUP;
        private final int meta;
        private final String field_176805_h;
        private final String unlocalizedName;

        private EnumType(int n2, String string2, String string3) {
            this.meta = n2;
            this.field_176805_h = string2;
            this.unlocalizedName = string3;
        }

        public int getMetadata() {
            return this.meta;
        }

        public String toString() {
            return this.unlocalizedName;
        }

        public static EnumType byMetadata(int n) {
            if (n < 0 || n >= META_LOOKUP.length) {
                n = 0;
            }
            return META_LOOKUP[n];
        }

        @Override
        public String getName() {
            return this.field_176805_h;
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

