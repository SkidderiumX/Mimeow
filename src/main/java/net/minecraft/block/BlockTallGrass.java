/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTallGrass
extends BlockBush
implements IGrowable {
    public static final PropertyEnum<EnumType> TYPE = PropertyEnum.create("type", EnumType.class);

    protected BlockTallGrass() {
        super(Material.vine);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.DEAD_BUSH));
        float f = 0.4f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.8f, 0.5f + f);
    }

    @Override
    public int getBlockColor() {
        return ColorizerGrass.getGrassColor(0.5, 1.0);
    }

    @Override
    public boolean canBlockStay(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return this.canPlaceBlockOn(world2.getBlockState(blockPos.down()).getBlock());
    }

    @Override
    public boolean isReplaceable(World world2, BlockPos blockPos) {
        return true;
    }

    @Override
    public int getRenderColor(IBlockState iBlockState) {
        if (iBlockState.getBlock() != this) {
            return super.getRenderColor(iBlockState);
        }
        EnumType enumType = iBlockState.getValue(TYPE);
        return enumType == EnumType.DEAD_BUSH ? 0xFFFFFF : ColorizerGrass.getGrassColor(0.5, 1.0);
    }

    @Override
    public int colorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos, int n) {
        return iBlockAccess.getBiomeGenForCoords(blockPos).getGrassColorAtPos(blockPos);
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return random.nextInt(8) == 0 ? Items.wheat_seeds : null;
    }

    @Override
    public int quantityDroppedWithBonus(int n, Random random) {
        return 1 + random.nextInt(n * 2 + 1);
    }

    @Override
    public void harvestBlock(World world2, EntityPlayer entityPlayer, BlockPos blockPos, IBlockState iBlockState, TileEntity tileEntity) {
        if (!world2.isRemote && entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().getItem() == Items.shears) {
            entityPlayer.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
            BlockTallGrass.spawnAsEntity(world2, blockPos, new ItemStack(Blocks.tallgrass, 1, iBlockState.getValue(TYPE).getMeta()));
        } else {
            super.harvestBlock(world2, entityPlayer, blockPos, iBlockState, tileEntity);
        }
    }

    @Override
    public int getDamageValue(World world2, BlockPos blockPos) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        return iBlockState.getBlock().getMetaFromState(iBlockState);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (int i = 1; i < 3; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public boolean canGrow(World world2, BlockPos blockPos, IBlockState iBlockState, boolean bl) {
        return iBlockState.getValue(TYPE) != EnumType.DEAD_BUSH;
    }

    @Override
    public boolean canUseBonemeal(World world2, Random random, BlockPos blockPos, IBlockState iBlockState) {
        return true;
    }

    @Override
    public void grow(World world2, Random random, BlockPos blockPos, IBlockState iBlockState) {
        BlockDoublePlant.EnumPlantType enumPlantType = BlockDoublePlant.EnumPlantType.GRASS;
        if (iBlockState.getValue(TYPE) == EnumType.FERN) {
            enumPlantType = BlockDoublePlant.EnumPlantType.FERN;
        }
        if (Blocks.double_plant.canPlaceBlockAt(world2, blockPos)) {
            Blocks.double_plant.placeAt(world2, blockPos, enumPlantType, 2);
        }
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(TYPE, EnumType.byMetadata(n));
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(TYPE).getMeta();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, TYPE);
    }

    @Override
    public Block.EnumOffsetType getOffsetType() {
        return Block.EnumOffsetType.XYZ;
    }

    public static enum EnumType implements IStringSerializable
    {
        DEAD_BUSH(0, "dead_bush"),
        GRASS(1, "tall_grass"),
        FERN(2, "fern");

        private static final EnumType[] META_LOOKUP;
        private final int meta;
        private final String name;

        private EnumType(int n2, String string2) {
            this.meta = n2;
            this.name = string2;
        }

        public int getMeta() {
            return this.meta;
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

        static {
            META_LOOKUP = new EnumType[EnumType.values().length];
            EnumType[] enumTypeArray = EnumType.values();
            int n = enumTypeArray.length;
            for (int i = 0; i < n; ++i) {
                EnumType enumType;
                EnumType.META_LOOKUP[enumType.getMeta()] = enumType = enumTypeArray[i];
            }
        }
    }
}

