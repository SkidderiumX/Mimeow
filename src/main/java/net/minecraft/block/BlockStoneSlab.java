/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
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
import net.minecraft.world.World;

public abstract class BlockStoneSlab
extends BlockSlab {
    public static final PropertyBool SEAMLESS = PropertyBool.create("seamless");
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockStoneSlab() {
        super(Material.rock);
        IBlockState iBlockState = this.blockState.getBaseState();
        iBlockState = this.isDouble() ? iBlockState.withProperty(SEAMLESS, false) : iBlockState.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        this.setDefaultState(iBlockState.withProperty(VARIANT, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Item.getItemFromBlock(Blocks.stone_slab);
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Item.getItemFromBlock(Blocks.stone_slab);
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
        if (item != Item.getItemFromBlock(Blocks.double_stone_slab)) {
            for (EnumType enumType : EnumType.values()) {
                if (enumType == EnumType.WOOD) continue;
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
    public int damageDropped(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).getMetadata();
    }

    @Override
    public MapColor getMapColor(IBlockState iBlockState) {
        return iBlockState.getValue(VARIANT).func_181074_c();
    }

    public static enum EnumType implements IStringSerializable
    {
        STONE(0, MapColor.stoneColor, "stone"),
        SAND(1, MapColor.sandColor, "sandstone", "sand"),
        WOOD(2, MapColor.woodColor, "wood_old", "wood"),
        COBBLESTONE(3, MapColor.stoneColor, "cobblestone", "cobble"),
        BRICK(4, MapColor.redColor, "brick"),
        SMOOTHBRICK(5, MapColor.stoneColor, "stone_brick", "smoothStoneBrick"),
        NETHERBRICK(6, MapColor.netherrackColor, "nether_brick", "netherBrick"),
        QUARTZ(7, MapColor.quartzColor, "quartz");

        private static final EnumType[] META_LOOKUP;
        private final int meta;
        private final MapColor field_181075_k;
        private final String name;
        private final String unlocalizedName;

        private EnumType(int n2, MapColor mapColor, String string2) {
            this(n2, mapColor, string2, string2);
        }

        private EnumType(int n2, MapColor mapColor, String string2, String string3) {
            this.meta = n2;
            this.field_181075_k = mapColor;
            this.name = string2;
            this.unlocalizedName = string3;
        }

        public int getMetadata() {
            return this.meta;
        }

        public MapColor func_181074_c() {
            return this.field_181075_k;
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

