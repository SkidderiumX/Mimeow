/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.AchievementList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3i;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSkull
extends BlockContainer {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool NODROP = PropertyBool.create("nodrop");
    private static final Predicate<BlockWorldState> IS_WITHER_SKELETON = new Predicate<BlockWorldState>(){

        @Override
        public boolean apply(BlockWorldState blockWorldState) {
            return blockWorldState.getBlockState() != null && blockWorldState.getBlockState().getBlock() == Blocks.skull && blockWorldState.getTileEntity() instanceof TileEntitySkull && ((TileEntitySkull)blockWorldState.getTileEntity()).getSkullType() == 1;
        }
    };
    private BlockPattern witherBasePattern;
    private BlockPattern witherPattern;

    protected BlockSkull() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(NODROP, false));
        this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal("tile.skull.skeleton.name");
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        switch (iBlockAccess.getBlockState(blockPos).getValue(FACING)) {
            default: {
                this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                break;
            }
            case NORTH: {
                this.setBlockBounds(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
                break;
            }
            case SOUTH: {
                this.setBlockBounds(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
                break;
            }
            case WEST: {
                this.setBlockBounds(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                break;
            }
            case EAST: {
                this.setBlockBounds(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.getCollisionBoundingBox(world2, blockPos, iBlockState);
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        return this.getDefaultState().withProperty(FACING, entityLivingBase.getHorizontalFacing()).withProperty(NODROP, false);
    }

    @Override
    public TileEntity createNewTileEntity(World world2, int n) {
        return new TileEntitySkull();
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Items.skull;
    }

    @Override
    public int getDamageValue(World world2, BlockPos blockPos) {
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        return tileEntity instanceof TileEntitySkull ? ((TileEntitySkull)tileEntity).getSkullType() : super.getDamageValue(world2, blockPos);
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
    }

    @Override
    public void onBlockHarvested(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
        if (entityPlayer.capabilities.isCreativeMode) {
            iBlockState = iBlockState.withProperty(NODROP, true);
            world2.setBlockState(blockPos, iBlockState, 4);
        }
        super.onBlockHarvested(world2, blockPos, iBlockState, entityPlayer);
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote) {
            TileEntity tileEntity;
            if (!iBlockState.getValue(NODROP).booleanValue() && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntitySkull) {
                TileEntitySkull tileEntitySkull = (TileEntitySkull)tileEntity;
                ItemStack itemStack = new ItemStack(Items.skull, 1, this.getDamageValue(world2, blockPos));
                if (tileEntitySkull.getSkullType() == 3 && tileEntitySkull.getPlayerProfile() != null) {
                    itemStack.setTagCompound(new NBTTagCompound());
                    NBTTagCompound nBTTagCompound = new NBTTagCompound();
                    NBTUtil.writeGameProfile(nBTTagCompound, tileEntitySkull.getPlayerProfile());
                    itemStack.getTagCompound().setTag("SkullOwner", nBTTagCompound);
                }
                BlockSkull.spawnAsEntity(world2, blockPos, itemStack);
            }
            super.breakBlock(world2, blockPos, iBlockState);
        }
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Items.skull;
    }

    public boolean canDispenserPlace(World world2, BlockPos blockPos, ItemStack itemStack) {
        return itemStack.getMetadata() == 1 && blockPos.getY() >= 2 && world2.getDifficulty() != EnumDifficulty.PEACEFUL && !world2.isRemote ? this.getWitherBasePattern().match(world2, blockPos) != null : false;
    }

    public void checkWitherSpawn(World world2, BlockPos blockPos, TileEntitySkull tileEntitySkull) {
        BlockPattern blockPattern;
        BlockPattern.PatternHelper patternHelper;
        if (tileEntitySkull.getSkullType() == 1 && blockPos.getY() >= 2 && world2.getDifficulty() != EnumDifficulty.PEACEFUL && !world2.isRemote && (patternHelper = (blockPattern = this.getWitherPattern()).match(world2, blockPos)) != null) {
            int n;
            Object object;
            int n2;
            for (n2 = 0; n2 < 3; ++n2) {
                BlockWorldState blockWorldState = patternHelper.translateOffset(n2, 0, 0);
                world2.setBlockState(blockWorldState.getPos(), blockWorldState.getBlockState().withProperty(NODROP, true), 2);
            }
            for (n2 = 0; n2 < blockPattern.getPalmLength(); ++n2) {
                for (int i = 0; i < blockPattern.getThumbLength(); ++i) {
                    object = patternHelper.translateOffset(n2, i, 0);
                    world2.setBlockState(((BlockWorldState)object).getPos(), Blocks.air.getDefaultState(), 2);
                }
            }
            BlockPos blockPos2 = patternHelper.translateOffset(1, 0, 0).getPos();
            EntityWither entityWither = new EntityWither(world2);
            object = patternHelper.translateOffset(1, 2, 0).getPos();
            entityWither.setLocationAndAngles((double)((Vec3i)object).getX() + 0.5, (double)((Vec3i)object).getY() + 0.55, (double)((Vec3i)object).getZ() + 0.5, patternHelper.getFinger().getAxis() == EnumFacing.Axis.X ? 0.0f : 90.0f, 0.0f);
            entityWither.renderYawOffset = patternHelper.getFinger().getAxis() == EnumFacing.Axis.X ? 0.0f : 90.0f;
            entityWither.func_82206_m();
            for (EntityPlayer entityPlayer : world2.getEntitiesWithinAABB(EntityPlayer.class, entityWither.getEntityBoundingBox().expand(50.0, 50.0, 50.0))) {
                entityPlayer.triggerAchievement(AchievementList.spawnWither);
            }
            world2.spawnEntityInWorld(entityWither);
            for (n = 0; n < 120; ++n) {
                world2.spawnParticle(EnumParticleTypes.SNOWBALL, (double)blockPos2.getX() + world2.rand.nextDouble(), (double)(blockPos2.getY() - 2) + world2.rand.nextDouble() * 3.9, (double)blockPos2.getZ() + world2.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
            }
            for (n = 0; n < blockPattern.getPalmLength(); ++n) {
                for (int i = 0; i < blockPattern.getThumbLength(); ++i) {
                    BlockWorldState blockWorldState = patternHelper.translateOffset(n, i, 0);
                    world2.notifyNeighborsRespectDebug(blockWorldState.getPos(), Blocks.air);
                }
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(n & 7)).withProperty(NODROP, (n & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(FACING).getIndex();
        if (iBlockState.getValue(NODROP).booleanValue()) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, NODROP);
    }

    protected BlockPattern getWitherBasePattern() {
        if (this.witherBasePattern == null) {
            this.witherBasePattern = FactoryBlockPattern.start().aisle("   ", "###", "~#~").where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.soul_sand))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.witherBasePattern;
    }

    protected BlockPattern getWitherPattern() {
        if (this.witherPattern == null) {
            this.witherPattern = FactoryBlockPattern.start().aisle("^^^", "###", "~#~").where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.soul_sand))).where('^', IS_WITHER_SKELETON).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.witherPattern;
    }
}

