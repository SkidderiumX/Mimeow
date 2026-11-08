/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;

public class BlockDoublePlant
extends BlockBush
implements IGrowable {
    public static final PropertyEnum<EnumPlantType> VARIANT = PropertyEnum.create("variant", EnumPlantType.class);
    public static final PropertyEnum<EnumBlockHalf> HALF = PropertyEnum.create("half", EnumBlockHalf.class);
    public static final PropertyEnum<EnumFacing> FACING = BlockDirectional.FACING;

    public BlockDoublePlant() {
        super(Material.vine);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumPlantType.SUNFLOWER).withProperty(HALF, EnumBlockHalf.LOWER).withProperty(FACING, EnumFacing.NORTH));
        this.setHardness(0.0f);
        this.setStepSound(soundTypeGrass);
        this.setUnlocalizedName("doublePlant");
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    public EnumPlantType getVariant(IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        if (iBlockState.getBlock() == this) {
            iBlockState = this.getActualState(iBlockState, iBlockAccess, blockPos);
            return iBlockState.getValue(VARIANT);
        }
        return EnumPlantType.FERN;
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return super.canPlaceBlockAt(world2, blockPos) && world2.isAirBlock(blockPos.up());
    }

    @Override
    public boolean isReplaceable(World world2, BlockPos blockPos) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (iBlockState.getBlock() != this) {
            return true;
        }
        EnumPlantType enumPlantType = this.getActualState(iBlockState, world2, blockPos).getValue(VARIANT);
        return enumPlantType == EnumPlantType.FERN || enumPlantType == EnumPlantType.GRASS;
    }

    @Override
    protected void checkAndDropBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!this.canBlockStay(world2, blockPos, iBlockState)) {
            BlockDoublePlant blockDoublePlant;
            boolean bl = iBlockState.getValue(HALF) == EnumBlockHalf.UPPER;
            BlockPos blockPos2 = bl ? blockPos : blockPos.up();
            BlockPos blockPos3 = bl ? blockPos.down() : blockPos;
            BlockDoublePlant blockDoublePlant2 = bl ? this : world2.getBlockState(blockPos2).getBlock();
            Block block = blockDoublePlant = bl ? world2.getBlockState(blockPos3).getBlock() : this;
            if (blockDoublePlant2 == this) {
                world2.setBlockState(blockPos2, Blocks.air.getDefaultState(), 2);
            }
            if (blockDoublePlant == this) {
                world2.setBlockState(blockPos3, Blocks.air.getDefaultState(), 3);
                if (!bl) {
                    this.dropBlockAsItem(world2, blockPos3, iBlockState, 0);
                }
            }
        }
    }

    @Override
    public boolean canBlockStay(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (iBlockState.getValue(HALF) == EnumBlockHalf.UPPER) {
            return world2.getBlockState(blockPos.down()).getBlock() == this;
        }
        IBlockState iBlockState2 = world2.getBlockState(blockPos.up());
        return iBlockState2.getBlock() == this && super.canBlockStay(world2, blockPos, iBlockState2);
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        if (iBlockState.getValue(HALF) == EnumBlockHalf.UPPER) {
            return null;
        }
        EnumPlantType enumPlantType = iBlockState.getValue(VARIANT);
        return enumPlantType == EnumPlantType.FERN ? null : (enumPlantType == EnumPlantType.GRASS ? (random.nextInt(8) == 0 ? Items.wheat_seeds : null) : Item.getItemFromBlock(this));
    }

    @Override
    public int damageDropped(IBlockState iBlockState) {
        return iBlockState.getValue(HALF) != EnumBlockHalf.UPPER && iBlockState.getValue(VARIANT) != EnumPlantType.GRASS ? iBlockState.getValue(VARIANT).getMeta() : 0;
    }

    @Override
    public int colorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos, int n) {
        EnumPlantType enumPlantType = this.getVariant(iBlockAccess, blockPos);
        return enumPlantType != EnumPlantType.GRASS && enumPlantType != EnumPlantType.FERN ? 0xFFFFFF : BiomeColorHelper.getGrassColorAtPos(iBlockAccess, blockPos);
    }

    public void placeAt(World world2, BlockPos blockPos, EnumPlantType enumPlantType, int n) {
        world2.setBlockState(blockPos, this.getDefaultState().withProperty(HALF, EnumBlockHalf.LOWER).withProperty(VARIANT, enumPlantType), n);
        world2.setBlockState(blockPos.up(), this.getDefaultState().withProperty(HALF, EnumBlockHalf.UPPER), n);
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        world2.setBlockState(blockPos.up(), this.getDefaultState().withProperty(HALF, EnumBlockHalf.UPPER), 2);
    }

    @Override
    public void harvestBlock(World world2, EntityPlayer entityPlayer, BlockPos blockPos, IBlockState iBlockState, TileEntity tileEntity) {
        if (world2.isRemote || entityPlayer.getCurrentEquippedItem() == null || entityPlayer.getCurrentEquippedItem().getItem() != Items.shears || iBlockState.getValue(HALF) != EnumBlockHalf.LOWER || !this.onHarvest(world2, blockPos, iBlockState, entityPlayer)) {
            super.harvestBlock(world2, entityPlayer, blockPos, iBlockState, tileEntity);
        }
    }

    @Override
    public void onBlockHarvested(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
        if (iBlockState.getValue(HALF) == EnumBlockHalf.UPPER) {
            if (world2.getBlockState(blockPos.down()).getBlock() == this) {
                if (!entityPlayer.capabilities.isCreativeMode) {
                    IBlockState iBlockState2 = world2.getBlockState(blockPos.down());
                    EnumPlantType enumPlantType = iBlockState2.getValue(VARIANT);
                    if (enumPlantType != EnumPlantType.FERN && enumPlantType != EnumPlantType.GRASS) {
                        world2.destroyBlock(blockPos.down(), true);
                    } else if (!world2.isRemote) {
                        if (entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().getItem() == Items.shears) {
                            this.onHarvest(world2, blockPos, iBlockState2, entityPlayer);
                            world2.setBlockToAir(blockPos.down());
                        } else {
                            world2.destroyBlock(blockPos.down(), true);
                        }
                    } else {
                        world2.setBlockToAir(blockPos.down());
                    }
                } else {
                    world2.setBlockToAir(blockPos.down());
                }
            }
        } else if (entityPlayer.capabilities.isCreativeMode && world2.getBlockState(blockPos.up()).getBlock() == this) {
            world2.setBlockState(blockPos.up(), Blocks.air.getDefaultState(), 2);
        }
        super.onBlockHarvested(world2, blockPos, iBlockState, entityPlayer);
    }

    private boolean onHarvest(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
        EnumPlantType enumPlantType = iBlockState.getValue(VARIANT);
        if (enumPlantType != EnumPlantType.FERN && enumPlantType != EnumPlantType.GRASS) {
            return false;
        }
        entityPlayer.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
        int n = (enumPlantType == EnumPlantType.GRASS ? BlockTallGrass.EnumType.GRASS : BlockTallGrass.EnumType.FERN).getMeta();
        BlockDoublePlant.spawnAsEntity(world2, blockPos, new ItemStack(Blocks.tallgrass, 2, n));
        return true;
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (EnumPlantType enumPlantType : EnumPlantType.values()) {
            list.add(new ItemStack(item, 1, enumPlantType.getMeta()));
        }
    }

    @Override
    public int getDamageValue(World world2, BlockPos blockPos) {
        return this.getVariant(world2, blockPos).getMeta();
    }

    @Override
    public boolean canGrow(World world2, BlockPos blockPos, IBlockState iBlockState, boolean bl) {
        EnumPlantType enumPlantType = this.getVariant(world2, blockPos);
        return enumPlantType != EnumPlantType.GRASS && enumPlantType != EnumPlantType.FERN;
    }

    @Override
    public boolean canUseBonemeal(World world2, Random random, BlockPos blockPos, IBlockState iBlockState) {
        return true;
    }

    @Override
    public void grow(World world2, Random random, BlockPos blockPos, IBlockState iBlockState) {
        BlockDoublePlant.spawnAsEntity(world2, blockPos, new ItemStack(this, 1, this.getVariant(world2, blockPos).getMeta()));
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return (n & 8) > 0 ? this.getDefaultState().withProperty(HALF, EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(HALF, EnumBlockHalf.LOWER).withProperty(VARIANT, EnumPlantType.byMetadata(n & 7));
    }

    @Override
    public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState2;
        if (iBlockState.getValue(HALF) == EnumBlockHalf.UPPER && (iBlockState2 = iBlockAccess.getBlockState(blockPos.down())).getBlock() == this) {
            iBlockState = iBlockState.withProperty(VARIANT, iBlockState2.getValue(VARIANT));
        }
        return iBlockState;
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(HALF) == EnumBlockHalf.UPPER ? 8 | iBlockState.getValue(FACING).getHorizontalIndex() : iBlockState.getValue(VARIANT).getMeta();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, HALF, VARIANT, FACING);
    }

    @Override
    public Block.EnumOffsetType getOffsetType() {
        return Block.EnumOffsetType.XZ;
    }

    public static enum EnumPlantType implements IStringSerializable
    {
        SUNFLOWER(0, "sunflower"),
        SYRINGA(1, "syringa"),
        GRASS(2, "double_grass", "grass"),
        FERN(3, "double_fern", "fern"),
        ROSE(4, "double_rose", "rose"),
        PAEONIA(5, "paeonia");

        private static final EnumPlantType[] META_LOOKUP;
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumPlantType(int n2, String string2) {
            this(n2, string2, string2);
        }

        private EnumPlantType(int n2, String string2, String string3) {
            this.meta = n2;
            this.name = string2;
            this.unlocalizedName = string3;
        }

        public int getMeta() {
            return this.meta;
        }

        public String toString() {
            return this.name;
        }

        public static EnumPlantType byMetadata(int n) {
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
            META_LOOKUP = new EnumPlantType[EnumPlantType.values().length];
            EnumPlantType[] enumPlantTypeArray = EnumPlantType.values();
            int n = enumPlantTypeArray.length;
            for (int i = 0; i < n; ++i) {
                EnumPlantType enumPlantType;
                EnumPlantType.META_LOOKUP[enumPlantType.getMeta()] = enumPlantType = enumPlantTypeArray[i];
            }
        }
    }

    public static enum EnumBlockHalf implements IStringSerializable
    {
        UPPER,
        LOWER;


        public String toString() {
            return this.getName();
        }

        @Override
        public String getName() {
            return this == UPPER ? "upper" : "lower";
        }
    }
}

