/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public abstract class BlockStoneSlabNew
extends BlockSlab {
    public static final PropertyBool SEAMLESS = PropertyBool.create("seamless");
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockStoneSlabNew() {
        super(Material.rock);
        IBlockState iBlockState = this.blockState.getBaseState();
        iBlockState = this.isDouble() ? iBlockState.withProperty(SEAMLESS, false) : iBlockState.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        this.setDefaultState(iBlockState.withProperty(VARIANT, EnumType.RED_SANDSTONE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + ".red_sandstone.name");
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Item.getItemFromBlock(Blocks.stone_slab2);
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Item.getItemFromBlock(Blocks.stone_slab2);
    }

    @Override
    public String getUnlocalizedName(int n) {
        return super.getUnlocalizedName() + "." + EnumType.byMetadata(n).getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Override
    public Object getVariant(ItemStack itemStack) {
        return EnumType.byMetadata(itemStack.getMetadata() & 7);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        if (item != Item.getItemFromBlock(Blocks.double_stone_slab2)) {
            for (EnumType enumType : EnumType.values()) {
                list.add(new ItemStack(item, 1, enumType.getMetadata()));
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        IBlockState iBlockState = this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata(n & 7));
        iBlockState = this.isDouble() ? iBlockState.withProperty(SEAMLESS, (n & 8) != 0) : iBlockState.withProperty(HALF, (n & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        return iBlockState;
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(VARIANT).getMetadata();
        if (this.isDouble()) {
            if (iBlockState.getValue(SEAMLESS).booleanValue()) {
                n |= 8;
            }
        } else if (iBlockState.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return this.isDouble() ? new BlockState(this, SEAMLESS, VARIANT) : new BlockState(this, HALF, VARIANT);
    }

    @Override
    public MapColor getMapColor(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).func_181068_c();
    }

    @Override
    public int damageDropped(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).getMetadata();
    }

    public static enum EnumType implements IStringSerializable
    {
        RED_SANDSTONE(0, "red_sandstone", BlockSand.EnumType.RED_SAND.getMapColor());

        private static final EnumType[] META_LOOKUP;
        private final int meta;
        private final String name;
        private final MapColor field_181069_e;

        private EnumType(int n2, String string2, MapColor mapColor) {
            this.meta = n2;
            this.name = string2;
            this.field_181069_e = mapColor;
        }

        public int getMetadata() {
            return this.meta;
        }

        public MapColor func_181068_c() {
            return this.field_181069_e;
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
            return this.name;
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

