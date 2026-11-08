/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public abstract class BlockFlower
extends BlockBush {
    protected PropertyEnum<EnumFlowerType> type;

    protected BlockFlower() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTypeProperty(), this.getBlockType() == EnumFlowerColor.RED ? EnumFlowerType.POPPY : EnumFlowerType.DANDELION));
    }

    @Override
    public int damageDropped(IBlockState iBlockState) {
        return iBlockState.getValue(this.getTypeProperty()).getMeta();
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (EnumFlowerType enumFlowerType : EnumFlowerType.getTypes(this.getBlockType())) {
            list.add(new ItemStack(item, 1, enumFlowerType.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(this.getTypeProperty(), EnumFlowerType.getType(this.getBlockType(), n));
    }

    public abstract EnumFlowerColor getBlockType();

    public IProperty<EnumFlowerType> getTypeProperty() {
        if (this.type == null) {
            this.type = PropertyEnum.create("type", EnumFlowerType.class, new Predicate<EnumFlowerType>(){

                @Override
                public boolean apply(EnumFlowerType enumFlowerType) {
                    return enumFlowerType.getBlockType() == BlockFlower.this.getBlockType();
                }
            });
        }
        return this.type;
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(this.getTypeProperty()).getMeta();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, this.getTypeProperty());
    }

    @Override
    public Block.EnumOffsetType getOffsetType() {
        return Block.EnumOffsetType.XZ;
    }

    public static enum EnumFlowerColor {
        YELLOW,
        RED;


        public BlockFlower getBlock() {
            return this == YELLOW ? Blocks.yellow_flower : Blocks.red_flower;
        }
    }

    public static enum EnumFlowerType implements IStringSerializable
    {
        DANDELION(EnumFlowerColor.YELLOW, 0, "dandelion"),
        POPPY(EnumFlowerColor.RED, 0, "poppy"),
        BLUE_ORCHID(EnumFlowerColor.RED, 1, "blue_orchid", "blueOrchid"),
        ALLIUM(EnumFlowerColor.RED, 2, "allium"),
        HOUSTONIA(EnumFlowerColor.RED, 3, "houstonia"),
        RED_TULIP(EnumFlowerColor.RED, 4, "red_tulip", "tulipRed"),
        ORANGE_TULIP(EnumFlowerColor.RED, 5, "orange_tulip", "tulipOrange"),
        WHITE_TULIP(EnumFlowerColor.RED, 6, "white_tulip", "tulipWhite"),
        PINK_TULIP(EnumFlowerColor.RED, 7, "pink_tulip", "tulipPink"),
        OXEYE_DAISY(EnumFlowerColor.RED, 8, "oxeye_daisy", "oxeyeDaisy");

        private static final EnumFlowerType[][] TYPES_FOR_BLOCK;
        private final EnumFlowerColor blockType;
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumFlowerType(EnumFlowerColor enumFlowerColor, int n2, String string2) {
            this(enumFlowerColor, n2, string2, string2);
        }

        private EnumFlowerType(EnumFlowerColor enumFlowerColor, int n2, String string2, String string3) {
            this.blockType = enumFlowerColor;
            this.meta = n2;
            this.name = string2;
            this.unlocalizedName = string3;
        }

        public EnumFlowerColor getBlockType() {
            return this.blockType;
        }

        public int getMeta() {
            return this.meta;
        }

        public static EnumFlowerType getType(EnumFlowerColor enumFlowerColor, int n) {
            EnumFlowerType[] enumFlowerTypeArray = TYPES_FOR_BLOCK[enumFlowerColor.ordinal()];
            if (n < 0 || n >= enumFlowerTypeArray.length) {
                n = 0;
            }
            return enumFlowerTypeArray[n];
        }

        public static EnumFlowerType[] getTypes(EnumFlowerColor enumFlowerColor) {
            return TYPES_FOR_BLOCK[enumFlowerColor.ordinal()];
        }

        public String toString() {
            return this.name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

        static {
            TYPES_FOR_BLOCK = new EnumFlowerType[EnumFlowerColor.values().length][];
            for (final EnumFlowerColor enumFlowerColor : EnumFlowerColor.values()) {
                Collection<EnumFlowerType> collection = Collections2.filter(Lists.newArrayList(EnumFlowerType.values()), new Predicate<EnumFlowerType>(){

                    @Override
                    public boolean apply(EnumFlowerType enumFlowerType) {
                        return enumFlowerType.getBlockType() == enumFlowerColor;
                    }
                });
                EnumFlowerType.TYPES_FOR_BLOCK[enumFlowerColor.ordinal()] = collection.toArray(new EnumFlowerType[collection.size()]);
            }
        }
    }
}

