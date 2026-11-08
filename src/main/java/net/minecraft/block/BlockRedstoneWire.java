/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneWire
extends Block {
    public static final PropertyEnum<EnumAttachPosition> NORTH = PropertyEnum.create("north", EnumAttachPosition.class);
    public static final PropertyEnum<EnumAttachPosition> EAST = PropertyEnum.create("east", EnumAttachPosition.class);
    public static final PropertyEnum<EnumAttachPosition> SOUTH = PropertyEnum.create("south", EnumAttachPosition.class);
    public static final PropertyEnum<EnumAttachPosition> WEST = PropertyEnum.create("west", EnumAttachPosition.class);
    public static final PropertyInteger POWER = PropertyInteger.create("power", 0, 15);
    private boolean canProvidePower = true;
    private final Set<BlockPos> blocksNeedingUpdate = Sets.newHashSet();

    public BlockRedstoneWire() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, EnumAttachPosition.NONE).withProperty(EAST, EnumAttachPosition.NONE).withProperty(SOUTH, EnumAttachPosition.NONE).withProperty(WEST, EnumAttachPosition.NONE).withProperty(POWER, 0));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
    }

    @Override
    public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        iBlockState = iBlockState.withProperty(WEST, this.getAttachPosition(iBlockAccess, blockPos, EnumFacing.WEST));
        iBlockState = iBlockState.withProperty(EAST, this.getAttachPosition(iBlockAccess, blockPos, EnumFacing.EAST));
        iBlockState = iBlockState.withProperty(NORTH, this.getAttachPosition(iBlockAccess, blockPos, EnumFacing.NORTH));
        iBlockState = iBlockState.withProperty(SOUTH, this.getAttachPosition(iBlockAccess, blockPos, EnumFacing.SOUTH));
        return iBlockState;
    }

    private EnumAttachPosition getAttachPosition(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        Block block = iBlockAccess.getBlockState(blockPos.offset(enumFacing)).getBlock();
        if (!(BlockRedstoneWire.canConnectTo(iBlockAccess.getBlockState(blockPos2), enumFacing) || !block.isBlockNormalCube() && BlockRedstoneWire.canConnectUpwardsTo(iBlockAccess.getBlockState(blockPos2.down())))) {
            Block block2 = iBlockAccess.getBlockState(blockPos.up()).getBlock();
            return !block2.isBlockNormalCube() && block.isBlockNormalCube() && BlockRedstoneWire.canConnectUpwardsTo(iBlockAccess.getBlockState(blockPos2.up())) ? EnumAttachPosition.UP : EnumAttachPosition.NONE;
        }
        return EnumAttachPosition.SIDE;
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
    public int colorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos, int n) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        return iBlockState.getBlock() != this ? super.colorMultiplier(iBlockAccess, blockPos, n) : this.colorMultiplier(iBlockState.getValue(POWER));
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) || world2.getBlockState(blockPos.down()).getBlock() == Blocks.glowstone;
    }

    private IBlockState updateSurroundingRedstone(World world2, BlockPos blockPos, IBlockState iBlockState) {
        iBlockState = this.calculateCurrentChanges(world2, blockPos, blockPos, iBlockState);
        ArrayList<BlockPos> arrayList = Lists.newArrayList(this.blocksNeedingUpdate);
        this.blocksNeedingUpdate.clear();
        for (BlockPos blockPos2 : arrayList) {
            world2.notifyNeighborsOfStateChange(blockPos2, this);
        }
        return iBlockState;
    }

    private IBlockState calculateCurrentChanges(World world2, BlockPos blockPos, BlockPos blockPos2, IBlockState iBlockState) {
        IBlockState iBlockState2 = iBlockState;
        int n = iBlockState.getValue(POWER);
        int n2 = 0;
        n2 = this.getMaxCurrentStrength(world2, blockPos2, n2);
        this.canProvidePower = false;
        int n3 = world2.isBlockIndirectlyGettingPowered(blockPos);
        this.canProvidePower = true;
        if (n3 > 0 && n3 > n2 - 1) {
            n2 = n3;
        }
        int n4 = 0;
        for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
            boolean bl;
            BlockPos blockPos3 = blockPos.offset(enumFacing);
            boolean bl2 = bl = blockPos3.getX() != blockPos2.getX() || blockPos3.getZ() != blockPos2.getZ();
            if (bl) {
                n4 = this.getMaxCurrentStrength(world2, blockPos3, n4);
            }
            if (world2.getBlockState(blockPos3).getBlock().isNormalCube() && !world2.getBlockState(blockPos.up()).getBlock().isNormalCube()) {
                if (!bl || blockPos.getY() < blockPos2.getY()) continue;
                n4 = this.getMaxCurrentStrength(world2, blockPos3.up(), n4);
                continue;
            }
            if (world2.getBlockState(blockPos3).getBlock().isNormalCube() || !bl || blockPos.getY() > blockPos2.getY()) continue;
            n4 = this.getMaxCurrentStrength(world2, blockPos3.down(), n4);
        }
        n2 = n4 > n2 ? n4 - 1 : (n2 > 0 ? --n2 : 0);
        if (n3 > n2 - 1) {
            n2 = n3;
        }
        if (n != n2) {
            iBlockState = iBlockState.withProperty(POWER, n2);
            if (world2.getBlockState(blockPos) == iBlockState2) {
                world2.setBlockState(blockPos, iBlockState, 2);
            }
            this.blocksNeedingUpdate.add(blockPos);
            for (EnumFacing enumFacing : EnumFacing.values()) {
                this.blocksNeedingUpdate.add(blockPos.offset(enumFacing));
            }
        }
        return iBlockState;
    }

    private void notifyWireNeighborsOfStateChange(World world2, BlockPos blockPos) {
        if (world2.getBlockState(blockPos).getBlock() == this) {
            world2.notifyNeighborsOfStateChange(blockPos, this);
            for (EnumFacing enumFacing : EnumFacing.values()) {
                world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing), this);
            }
        }
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote) {
            this.updateSurroundingRedstone(world2, blockPos, iBlockState);
            for (EnumFacing enumFacing : EnumFacing.Plane.VERTICAL) {
                world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing), this);
            }
            for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                this.notifyWireNeighborsOfStateChange(world2, blockPos.offset(enumFacing));
            }
            for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                if (world2.getBlockState(blockPos2).getBlock().isNormalCube()) {
                    this.notifyWireNeighborsOfStateChange(world2, blockPos2.up());
                    continue;
                }
                this.notifyWireNeighborsOfStateChange(world2, blockPos2.down());
            }
        }
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        super.breakBlock(world2, blockPos, iBlockState);
        if (!world2.isRemote) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing), this);
            }
            this.updateSurroundingRedstone(world2, blockPos, iBlockState);
            for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                this.notifyWireNeighborsOfStateChange(world2, blockPos.offset(enumFacing));
            }
            for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                if (world2.getBlockState(blockPos2).getBlock().isNormalCube()) {
                    this.notifyWireNeighborsOfStateChange(world2, blockPos2.up());
                    continue;
                }
                this.notifyWireNeighborsOfStateChange(world2, blockPos2.down());
            }
        }
    }

    private int getMaxCurrentStrength(World world2, BlockPos blockPos, int n) {
        if (world2.getBlockState(blockPos).getBlock() != this) {
            return n;
        }
        int n2 = world2.getBlockState(blockPos).getValue(POWER);
        return n2 > n ? n2 : n;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!world2.isRemote) {
            if (this.canPlaceBlockAt(world2, blockPos)) {
                this.updateSurroundingRedstone(world2, blockPos, iBlockState);
            } else {
                this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
                world2.setBlockToAir(blockPos);
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Items.redstone;
    }

    @Override
    public int getStrongPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        return !this.canProvidePower ? 0 : this.getWeakPower(iBlockAccess, blockPos, iBlockState, enumFacing);
    }

    @Override
    public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
        if (!this.canProvidePower) {
            return 0;
        }
        int n = iBlockState.getValue(POWER);
        if (n == 0) {
            return 0;
        }
        if (enumFacing == EnumFacing.UP) {
            return n;
        }
        EnumSet<EnumFacing> enumSet = EnumSet.noneOf(EnumFacing.class);
        for (EnumFacing enumFacing2 : EnumFacing.Plane.HORIZONTAL) {
            if (!this.func_176339_d(iBlockAccess, blockPos, enumFacing2)) continue;
            enumSet.add(enumFacing2);
        }
        if (enumFacing.getAxis().isHorizontal() && enumSet.isEmpty()) {
            return n;
        }
        if (enumSet.contains(enumFacing) && !enumSet.contains(enumFacing.rotateYCCW()) && !enumSet.contains(enumFacing.rotateY())) {
            return n;
        }
        return 0;
    }

    private boolean func_176339_d(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos2);
        Block block = iBlockState.getBlock();
        boolean bl = block.isNormalCube();
        boolean bl2 = iBlockAccess.getBlockState(blockPos.up()).getBlock().isNormalCube();
        return !bl2 && bl && BlockRedstoneWire.canConnectUpwardsTo(iBlockAccess, blockPos2.up()) ? true : (BlockRedstoneWire.canConnectTo(iBlockState, enumFacing) ? true : (block == Blocks.powered_repeater && iBlockState.getValue(BlockRedstoneDiode.FACING) == enumFacing ? true : !bl && BlockRedstoneWire.canConnectUpwardsTo(iBlockAccess, blockPos2.down())));
    }

    protected static boolean canConnectUpwardsTo(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return BlockRedstoneWire.canConnectUpwardsTo(iBlockAccess.getBlockState(blockPos));
    }

    protected static boolean canConnectUpwardsTo(IBlockState iBlockState) {
        return BlockRedstoneWire.canConnectTo(iBlockState, null);
    }

    protected static boolean canConnectTo(IBlockState iBlockState, EnumFacing enumFacing) {
        Block block = iBlockState.getBlock();
        if (block == Blocks.redstone_wire) {
            return true;
        }
        if (Blocks.unpowered_repeater.isAssociated(block)) {
            EnumFacing enumFacing2 = iBlockState.getValue(BlockRedstoneRepeater.FACING);
            return enumFacing2 == enumFacing || enumFacing2.getOpposite() == enumFacing;
        }
        return block.canProvidePower() && enumFacing != null;
    }

    @Override
    public boolean canProvidePower() {
        return this.canProvidePower;
    }

    private int colorMultiplier(int n) {
        float f = (float)n / 15.0f;
        float f2 = f * 0.6f + 0.4f;
        if (n == 0) {
            f2 = 0.3f;
        }
        float f3 = f * f * 0.7f - 0.5f;
        float f4 = f * f * 0.6f - 0.7f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        int n2 = MathHelper.clamp_int((int)(f2 * 255.0f), 0, 255);
        int n3 = MathHelper.clamp_int((int)(f3 * 255.0f), 0, 255);
        int n4 = MathHelper.clamp_int((int)(f4 * 255.0f), 0, 255);
        return 0xFF000000 | n2 << 16 | n3 << 8 | n4;
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        int n = iBlockState.getValue(POWER);
        if (n != 0) {
            double d = (double)blockPos.getX() + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            double d2 = (float)blockPos.getY() + 0.0625f;
            double d3 = (double)blockPos.getZ() + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            float f = (float)n / 15.0f;
            float f2 = f * 0.6f + 0.4f;
            float f3 = Math.max(0.0f, f * f * 0.7f - 0.5f);
            float f4 = Math.max(0.0f, f * f * 0.6f - 0.7f);
            world2.spawnParticle(EnumParticleTypes.REDSTONE, d, d2, d3, (double)f2, (double)f3, (double)f4, new int[0]);
        }
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Items.redstone;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(POWER, n);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(POWER);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, NORTH, EAST, SOUTH, WEST, POWER);
    }

    public static enum EnumAttachPosition implements IStringSerializable
    {
        UP("up"),
        SIDE("side"),
        NONE("none");

        private final String name;

        private EnumAttachPosition(String string2) {
            this.name = string2;
        }

        public String toString() {
            return this.getName();
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}

