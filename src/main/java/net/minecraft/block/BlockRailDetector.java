/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityMinecartCommandBlock;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRailDetector
extends BlockRailBase {
    public static final PropertyEnum<BlockRailBase.EnumRailDirection> SHAPE = PropertyEnum.create("shape", BlockRailBase.EnumRailDirection.class, new Predicate<BlockRailBase.EnumRailDirection>(){

        @Override
        public boolean apply(BlockRailBase.EnumRailDirection enumRailDirection) {
            return enumRailDirection != BlockRailBase.EnumRailDirection.NORTH_EAST && enumRailDirection != BlockRailBase.EnumRailDirection.NORTH_WEST && enumRailDirection != BlockRailBase.EnumRailDirection.SOUTH_EAST && enumRailDirection != BlockRailBase.EnumRailDirection.SOUTH_WEST;
        }
    });
    public static final PropertyBool POWERED = PropertyBool.create("powered");

    public BlockRailDetector() {
        super(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false).withProperty(SHAPE, BlockRailBase.EnumRailDirection.NORTH_SOUTH));
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(World world2) {
        return 20;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void onEntityCollidedWithBlock(World world2, BlockPos blockPos, IBlockState iBlockState, Entity entity) {
        if (!world2.isRemote && !iBlockState.getValue(POWERED).booleanValue()) {
            this.updatePoweredState(world2, blockPos, iBlockState);
        }
    }

    @Override
    public void randomTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (!world2.isRemote && iBlockState.getValue(POWERED).booleanValue()) {
            this.updatePoweredState(world2, blockPos, iBlockState);
        }
    }

    @Override
    public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return iBlockState.getValue(POWERED) != false ? 15 : 0;
    }

    @Override
    public int getStrongPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return iBlockState.getValue(POWERED) == false ? 0 : (enumFacing == EnumFacing.UP ? 15 : 0);
    }

    private void updatePoweredState(World world2, BlockPos blockPos, IBlockState iBlockState) {
        boolean bl = iBlockState.getValue(POWERED);
        boolean bl2 = false;
        List<EntityMinecart> list = this.findMinecarts(world2, blockPos, EntityMinecart.class, new Predicate[0]);
        if (!list.isEmpty()) {
            bl2 = true;
        }
        if (bl2 && !bl) {
            world2.setBlockState(blockPos, iBlockState.withProperty(POWERED, true), 3);
            world2.notifyNeighborsOfStateChange(blockPos, this);
            world2.notifyNeighborsOfStateChange(blockPos.down(), this);
            world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
        }
        if (!bl2 && bl) {
            world2.setBlockState(blockPos, iBlockState.withProperty(POWERED, false), 3);
            world2.notifyNeighborsOfStateChange(blockPos, this);
            world2.notifyNeighborsOfStateChange(blockPos.down(), this);
            world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
        }
        if (bl2) {
            world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
        }
        world2.updateComparatorOutputLevel(blockPos, this);
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        super.onBlockAdded(world2, blockPos, iBlockState);
        this.updatePoweredState(world2, blockPos, iBlockState);
    }

    @Override
    public IProperty<BlockRailBase.EnumRailDirection> getShapeProperty() {
        return SHAPE;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world2, BlockPos blockPos) {
        if (world2.getBlockState(blockPos).getValue(POWERED).booleanValue()) {
            List<EntityMinecartCommandBlock> list = this.findMinecarts(world2, blockPos, EntityMinecartCommandBlock.class, new Predicate[0]);
            if (!list.isEmpty()) {
                return list.get(0).getCommandBlockLogic().getSuccessCount();
            }
            List<EntityMinecart> list2 = this.findMinecarts(world2, blockPos, EntityMinecart.class, EntitySelectors.selectInventories);
            if (!list2.isEmpty()) {
                return Container.calcRedstoneFromInventory((IInventory)((Object)list2.get(0)));
            }
        }
        return 0;
    }

    protected <T extends EntityMinecart> List<T> findMinecarts(World world2, BlockPos blockPos, Class<T> clazz, Predicate<Entity> ... predicateArray) {
        AxisAlignedBB axisAlignedBB = this.getDectectionBox(blockPos);
        return predicateArray.length != 1 ? world2.getEntitiesWithinAABB(clazz, axisAlignedBB) : world2.getEntitiesWithinAABB(clazz, axisAlignedBB, predicateArray[0]);
    }

    private AxisAlignedBB getDectectionBox(BlockPos blockPos) {
        float f = 0.2f;
        return new AxisAlignedBB((float)blockPos.getX() + 0.2f, blockPos.getY(), (float)blockPos.getZ() + 0.2f, (float)(blockPos.getX() + 1) - 0.2f, (float)(blockPos.getY() + 1) - 0.2f, (float)(blockPos.getZ() + 1) - 0.2f);
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(SHAPE, BlockRailBase.EnumRailDirection.byMetadata(n & 7)).withProperty(POWERED, (n & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(SHAPE).getMetadata();
        if (iBlockState.getValue(POWERED).booleanValue()) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, SHAPE, POWERED);
    }
}

