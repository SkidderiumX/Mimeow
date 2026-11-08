/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public class BlockHugeMushroom
extends Block {
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);
    private final Block smallBlock;

    public BlockHugeMushroom(Material material, MapColor mapColor, Block block) {
        super(material, mapColor);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.ALL_OUTSIDE));
        this.smallBlock = block;
    }

    @Override
    public int quantityDropped(Random random) {
        return Math.max(0, random.nextInt(10) - 7);
    }

    @Override
    public MapColor getMapColor(IBlockState iBlockState) {
        switch (iBlockState.getValue(VARIANT)) {
            case ALL_STEM: {
                return MapColor.clothColor;
            }
            case ALL_INSIDE: {
                return MapColor.sandColor;
            }
            case STEM: {
                return MapColor.sandColor;
            }
        }
        return super.getMapColor(iBlockState);
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Item.getItemFromBlock(this.smallBlock);
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Item.getItemFromBlock(this.smallBlock);
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        return this.getDefaultState();
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
        NORTH_WEST(1, "north_west"),
        NORTH(2, "north"),
        NORTH_EAST(3, "north_east"),
        WEST(4, "west"),
        CENTER(5, "center"),
        EAST(6, "east"),
        SOUTH_WEST(7, "south_west"),
        SOUTH(8, "south"),
        SOUTH_EAST(9, "south_east"),
        STEM(10, "stem"),
        ALL_INSIDE(0, "all_inside"),
        ALL_OUTSIDE(14, "all_outside"),
        ALL_STEM(15, "all_stem");

        private static final EnumType[] META_LOOKUP;
        private final int meta;
        private final String name;

        private EnumType(int n2, String string2) {
            this.meta = n2;
            this.name = string2;
        }

        public int getMetadata() {
            return this.meta;
        }

        public String toString() {
            return this.name;
        }

        public static EnumType byMetadata(int n) {
            EnumType enumType;
            if (n < 0 || n >= META_LOOKUP.length) {
                n = 0;
            }
            return (enumType = META_LOOKUP[n]) == null ? META_LOOKUP[0] : enumType;
        }

        @Override
        public String getName() {
            return this.name;
        }

        static {
            META_LOOKUP = new EnumType[16];
            EnumType[] enumTypeArray = EnumType.values();
            int n = enumTypeArray.length;
            for (int i = 0; i < n; ++i) {
                EnumType enumType;
                EnumType.META_LOOKUP[enumType.getMetadata()] = enumType = enumTypeArray[i];
            }
        }
    }
}

