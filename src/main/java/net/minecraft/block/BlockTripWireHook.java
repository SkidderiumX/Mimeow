/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.base.Objects;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTripWireHook
extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyBool ATTACHED = PropertyBool.create("attached");
    public static final PropertyBool SUSPENDED = PropertyBool.create("suspended");

    public BlockTripWireHook() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(POWERED, false).withProperty(ATTACHED, false).withProperty(SUSPENDED, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setTickRandomly(true);
    }

    @Override
    public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        return iBlockState.withProperty(SUSPENDED, !World.doesBlockHaveSolidTopSurface(iBlockAccess, blockPos.down()));
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return null;
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
    public boolean canPlaceBlockOnSide(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        return enumFacing.getAxis().isHorizontal() && world2.getBlockState(blockPos.offset(enumFacing.getOpposite())).getBlock().isNormalCube();
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
            if (!world2.getBlockState(blockPos.offset(enumFacing)).getBlock().isNormalCube()) continue;
            return true;
        }
        return false;
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        IBlockState iBlockState = this.getDefaultState().withProperty(POWERED, false).withProperty(ATTACHED, false).withProperty(SUSPENDED, false);
        if (enumFacing.getAxis().isHorizontal()) {
            iBlockState = iBlockState.withProperty(FACING, enumFacing);
        }
        return iBlockState;
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        this.func_176260_a(world2, blockPos, iBlockState, false, false, -1, null);
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        EnumFacing enumFacing;
        if (block != this && this.checkForDrop(world2, blockPos, iBlockState) && !world2.getBlockState(blockPos.offset((enumFacing = iBlockState.getValue(FACING)).getOpposite())).getBlock().isNormalCube()) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
        }
    }

    public void func_176260_a(World world2, BlockPos blockPos, IBlockState iBlockState, boolean bl, boolean bl2, int n, IBlockState iBlockState2) {
        Object object;
        BlockPos blockPos2;
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        boolean bl3 = iBlockState.getValue(ATTACHED);
        boolean bl4 = iBlockState.getValue(POWERED);
        boolean bl5 = !World.doesBlockHaveSolidTopSurface(world2, blockPos.down());
        boolean bl6 = !bl;
        boolean bl7 = false;
        int n2 = 0;
        IBlockState[] iBlockStateArray = new IBlockState[42];
        for (int i = 1; i < 42; ++i) {
            blockPos2 = blockPos.offset(enumFacing, i);
            object = world2.getBlockState(blockPos2);
            if (object.getBlock() == Blocks.tripwire_hook) {
                if (object.getValue(FACING) != enumFacing.getOpposite()) break;
                n2 = i;
                break;
            }
            if (object.getBlock() != Blocks.tripwire && i != n) {
                iBlockStateArray[i] = null;
                bl6 = false;
                continue;
            }
            if (i == n) {
                object = Objects.firstNonNull(iBlockState2, object);
            }
            boolean bl8 = object.getValue(BlockTripWire.DISARMED) == false;
            boolean bl9 = object.getValue(BlockTripWire.POWERED);
            boolean bl10 = object.getValue(BlockTripWire.SUSPENDED);
            bl6 &= bl10 == bl5;
            bl7 |= bl8 && bl9;
            iBlockStateArray[i] = object;
            if (i != n) continue;
            world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
            bl6 &= bl8;
        }
        IBlockState iBlockState3 = this.getDefaultState().withProperty(ATTACHED, bl6).withProperty(POWERED, bl7 &= (bl6 &= n2 > 1));
        if (n2 > 0) {
            blockPos2 = blockPos.offset(enumFacing, n2);
            object = enumFacing.getOpposite();
            world2.setBlockState(blockPos2, iBlockState3.withProperty(FACING, object), 3);
            this.func_176262_b(world2, blockPos2, (EnumFacing)object);
            this.func_180694_a(world2, blockPos2, bl6, bl7, bl3, bl4);
        }
        this.func_180694_a(world2, blockPos, bl6, bl7, bl3, bl4);
        if (!bl) {
            world2.setBlockState(blockPos, iBlockState3.withProperty(FACING, enumFacing), 3);
            if (bl2) {
                this.func_176262_b(world2, blockPos, enumFacing);
            }
        }
        if (bl3 != bl6) {
            for (int i = 1; i < n2; ++i) {
                object = blockPos.offset(enumFacing, i);
                IBlockState iBlockState4 = iBlockStateArray[i];
                if (iBlockState4 == null || world2.getBlockState((BlockPos)object).getBlock() == Blocks.air) continue;
                world2.setBlockState((BlockPos)object, iBlockState4.withProperty(ATTACHED, bl6), 3);
            }
        }
    }

    @Override
    public void randomTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        this.func_176260_a(world2, blockPos, iBlockState, false, true, -1, null);
    }

    private void func_180694_a(World world2, BlockPos blockPos, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl2 && !bl4) {
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.1, (double)blockPos.getZ() + 0.5, "random.click", 0.4f, 0.6f);
        } else if (!bl2 && bl4) {
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.1, (double)blockPos.getZ() + 0.5, "random.click", 0.4f, 0.5f);
        } else if (bl && !bl3) {
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.1, (double)blockPos.getZ() + 0.5, "random.click", 0.4f, 0.7f);
        } else if (!bl && bl3) {
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.1, (double)blockPos.getZ() + 0.5, "random.bowhit", 0.4f, 1.2f / (world2.rand.nextFloat() * 0.2f + 0.9f));
        }
    }

    private void func_176262_b(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        world2.notifyNeighborsOfStateChange(blockPos, this);
        world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing.getOpposite()), this);
    }

    private boolean checkForDrop(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!this.canPlaceBlockAt(world2, blockPos)) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
            return false;
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        float f = 0.1875f;
        switch (iBlockAccess.getBlockState(blockPos).getValue(FACING)) {
            case EAST: {
                this.setBlockBounds(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
                break;
            }
            case WEST: {
                this.setBlockBounds(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
                break;
            }
            case SOUTH: {
                this.setBlockBounds(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
                break;
            }
            case NORTH: {
                this.setBlockBounds(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
            }
        }
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        boolean bl = iBlockState.getValue(ATTACHED);
        boolean bl2 = iBlockState.getValue(POWERED);
        if (bl || bl2) {
            this.func_176260_a(world2, blockPos, iBlockState, true, false, -1, null);
        }
        if (bl2) {
            world2.notifyNeighborsOfStateChange(blockPos, this);
            world2.notifyNeighborsOfStateChange(blockPos.offset(iBlockState.getValue(FACING).getOpposite()), this);
        }
        super.breakBlock(world2, blockPos, iBlockState);
    }

    @Override
    public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return iBlockState.getValue(POWERED) != false ? 15 : 0;
    }

    @Override
    public int getStrongPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return iBlockState.getValue(POWERED) == false ? 0 : (iBlockState.getValue(FACING) == enumFacing ? 15 : 0);
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(n & 3)).withProperty(POWERED, (n & 8) > 0).withProperty(ATTACHED, (n & 4) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(FACING).getHorizontalIndex();
        if (iBlockState.getValue(POWERED).booleanValue()) {
            n |= 8;
        }
        if (iBlockState.getValue(ATTACHED).booleanValue()) {
            n |= 4;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, POWERED, ATTACHED, SUSPENDED);
    }
}

