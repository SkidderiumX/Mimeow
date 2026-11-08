/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockRailBase
extends Block {
    protected final boolean isPowered;

    public static boolean isRailBlock(World world2, BlockPos blockPos) {
        return BlockRailBase.isRailBlock(world2.getBlockState(blockPos));
    }

    public static boolean isRailBlock(IBlockState iBlockState) {
        Block block = iBlockState.getBlock();
        return block == Blocks.rail || block == Blocks.golden_rail || block == Blocks.detector_rail || block == Blocks.activator_rail;
    }

    protected BlockRailBase(boolean bl) {
        super(Material.circuits);
        this.isPowered = bl;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.setCreativeTab(CreativeTabs.tabTransport);
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
    public MovingObjectPosition collisionRayTrace(World world2, BlockPos blockPos, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.collisionRayTrace(world2, blockPos, vec3, vec32);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        EnumRailDirection enumRailDirection;
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        EnumRailDirection enumRailDirection2 = enumRailDirection = iBlockState.getBlock() == this ? iBlockState.getValue(this.getShapeProperty()) : null;
        if (enumRailDirection != null && enumRailDirection.isAscending()) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return World.doesBlockHaveSolidTopSurface(world2, blockPos.down());
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote) {
            iBlockState = this.func_176564_a(world2, blockPos, iBlockState, true);
            if (this.isPowered) {
                this.onNeighborBlockChange(world2, blockPos, iBlockState, this);
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!world2.isRemote) {
            EnumRailDirection enumRailDirection = iBlockState.getValue(this.getShapeProperty());
            boolean bl = false;
            if (!World.doesBlockHaveSolidTopSurface(world2, blockPos.down())) {
                bl = true;
            }
            if (enumRailDirection == EnumRailDirection.ASCENDING_EAST && !World.doesBlockHaveSolidTopSurface(world2, blockPos.east())) {
                bl = true;
            } else if (enumRailDirection == EnumRailDirection.ASCENDING_WEST && !World.doesBlockHaveSolidTopSurface(world2, blockPos.west())) {
                bl = true;
            } else if (enumRailDirection == EnumRailDirection.ASCENDING_NORTH && !World.doesBlockHaveSolidTopSurface(world2, blockPos.north())) {
                bl = true;
            } else if (enumRailDirection == EnumRailDirection.ASCENDING_SOUTH && !World.doesBlockHaveSolidTopSurface(world2, blockPos.south())) {
                bl = true;
            }
            if (bl) {
                this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
                world2.setBlockToAir(blockPos);
            } else {
                this.onNeighborChangedInternal(world2, blockPos, iBlockState, block);
            }
        }
    }

    protected void onNeighborChangedInternal(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
    }

    protected IBlockState func_176564_a(World world2, BlockPos blockPos, IBlockState iBlockState, boolean bl) {
        return world2.isRemote ? iBlockState : new Rail(world2, blockPos, iBlockState).func_180364_a(world2.isBlockPowered(blockPos), bl).getBlockState();
    }

    @Override
    public int getMobilityFlag() {
        return 0;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        super.breakBlock(world2, blockPos, iBlockState);
        if (iBlockState.getValue(this.getShapeProperty()).isAscending()) {
            world2.notifyNeighborsOfStateChange(blockPos.up(), this);
        }
        if (this.isPowered) {
            world2.notifyNeighborsOfStateChange(blockPos, this);
            world2.notifyNeighborsOfStateChange(blockPos.down(), this);
        }
    }

    public abstract IProperty<EnumRailDirection> getShapeProperty();

    public static enum EnumRailDirection implements IStringSerializable
    {
        NORTH_SOUTH(0, "north_south"),
        EAST_WEST(1, "east_west"),
        ASCENDING_EAST(2, "ascending_east"),
        ASCENDING_WEST(3, "ascending_west"),
        ASCENDING_NORTH(4, "ascending_north"),
        ASCENDING_SOUTH(5, "ascending_south"),
        SOUTH_EAST(6, "south_east"),
        SOUTH_WEST(7, "south_west"),
        NORTH_WEST(8, "north_west"),
        NORTH_EAST(9, "north_east");

        private static final EnumRailDirection[] META_LOOKUP;
        private final int meta;
        private final String name;

        private EnumRailDirection(int n2, String string2) {
            this.meta = n2;
            this.name = string2;
        }

        public int getMetadata() {
            return this.meta;
        }

        public String toString() {
            return this.name;
        }

        public boolean isAscending() {
            return this == ASCENDING_NORTH || this == ASCENDING_EAST || this == ASCENDING_SOUTH || this == ASCENDING_WEST;
        }

        public static EnumRailDirection byMetadata(int n) {
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
            META_LOOKUP = new EnumRailDirection[EnumRailDirection.values().length];
            EnumRailDirection[] enumRailDirectionArray = EnumRailDirection.values();
            int n = enumRailDirectionArray.length;
            for (int i = 0; i < n; ++i) {
                EnumRailDirection enumRailDirection;
                EnumRailDirection.META_LOOKUP[enumRailDirection.getMetadata()] = enumRailDirection = enumRailDirectionArray[i];
            }
        }
    }

    public class Rail {
        private final World world;
        private final BlockPos pos;
        private final BlockRailBase block;
        private IBlockState state;
        private final boolean isPowered;
        private final List<BlockPos> field_150657_g = Lists.newArrayList();

        public Rail(World world2, BlockPos blockPos, IBlockState iBlockState) {
            this.world = world2;
            this.pos = blockPos;
            this.state = iBlockState;
            this.block = (BlockRailBase)iBlockState.getBlock();
            EnumRailDirection enumRailDirection = iBlockState.getValue(BlockRailBase.this.getShapeProperty());
            this.isPowered = this.block.isPowered;
            this.func_180360_a(enumRailDirection);
        }

        private void func_180360_a(EnumRailDirection enumRailDirection) {
            this.field_150657_g.clear();
            switch (enumRailDirection) {
                case NORTH_SOUTH: {
                    this.field_150657_g.add(this.pos.north());
                    this.field_150657_g.add(this.pos.south());
                    break;
                }
                case EAST_WEST: {
                    this.field_150657_g.add(this.pos.west());
                    this.field_150657_g.add(this.pos.east());
                    break;
                }
                case ASCENDING_EAST: {
                    this.field_150657_g.add(this.pos.west());
                    this.field_150657_g.add(this.pos.east().up());
                    break;
                }
                case ASCENDING_WEST: {
                    this.field_150657_g.add(this.pos.west().up());
                    this.field_150657_g.add(this.pos.east());
                    break;
                }
                case ASCENDING_NORTH: {
                    this.field_150657_g.add(this.pos.north().up());
                    this.field_150657_g.add(this.pos.south());
                    break;
                }
                case ASCENDING_SOUTH: {
                    this.field_150657_g.add(this.pos.north());
                    this.field_150657_g.add(this.pos.south().up());
                    break;
                }
                case SOUTH_EAST: {
                    this.field_150657_g.add(this.pos.east());
                    this.field_150657_g.add(this.pos.south());
                    break;
                }
                case SOUTH_WEST: {
                    this.field_150657_g.add(this.pos.west());
                    this.field_150657_g.add(this.pos.south());
                    break;
                }
                case NORTH_WEST: {
                    this.field_150657_g.add(this.pos.west());
                    this.field_150657_g.add(this.pos.north());
                    break;
                }
                case NORTH_EAST: {
                    this.field_150657_g.add(this.pos.east());
                    this.field_150657_g.add(this.pos.north());
                }
            }
        }

        private void func_150651_b() {
            for (int i = 0; i < this.field_150657_g.size(); ++i) {
                Rail rail = this.findRailAt(this.field_150657_g.get(i));
                if (rail != null && rail.func_150653_a(this)) {
                    this.field_150657_g.set(i, rail.pos);
                    continue;
                }
                this.field_150657_g.remove(i--);
            }
        }

        private boolean hasRailAt(BlockPos blockPos) {
            return BlockRailBase.isRailBlock(this.world, blockPos) || BlockRailBase.isRailBlock(this.world, blockPos.up()) || BlockRailBase.isRailBlock(this.world, blockPos.down());
        }

        private Rail findRailAt(BlockPos blockPos) {
            Rail rail;
            IBlockState iBlockState = this.world.getBlockState(blockPos);
            if (BlockRailBase.isRailBlock(iBlockState)) {
                BlockRailBase blockRailBase = BlockRailBase.this;
                Objects.requireNonNull(blockRailBase);
                return blockRailBase.new Rail(this.world, blockPos, iBlockState);
            }
            BlockPos blockPos2 = blockPos.up();
            iBlockState = this.world.getBlockState(blockPos2);
            if (BlockRailBase.isRailBlock(iBlockState)) {
                BlockRailBase blockRailBase = BlockRailBase.this;
                Objects.requireNonNull(blockRailBase);
                return blockRailBase.new Rail(this.world, blockPos2, iBlockState);
            }
            blockPos2 = blockPos.down();
            iBlockState = this.world.getBlockState(blockPos2);
            if (BlockRailBase.isRailBlock(iBlockState)) {
                BlockRailBase blockRailBase = BlockRailBase.this;
                Objects.requireNonNull(blockRailBase);
                rail = blockRailBase.new Rail(this.world, blockPos2, iBlockState);
            } else {
                rail = null;
            }
            return rail;
        }

        private boolean func_150653_a(Rail rail) {
            return this.func_180363_c(rail.pos);
        }

        private boolean func_180363_c(BlockPos blockPos) {
            for (int i = 0; i < this.field_150657_g.size(); ++i) {
                BlockPos blockPos2 = this.field_150657_g.get(i);
                if (blockPos2.getX() != blockPos.getX() || blockPos2.getZ() != blockPos.getZ()) continue;
                return true;
            }
            return false;
        }

        protected int countAdjacentRails() {
            int n = 0;
            for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                if (!this.hasRailAt(this.pos.offset(enumFacing))) continue;
                ++n;
            }
            return n;
        }

        private boolean func_150649_b(Rail rail) {
            return this.func_150653_a(rail) || this.field_150657_g.size() != 2;
        }

        private void func_150645_c(Rail rail) {
            this.field_150657_g.add(rail.pos);
            BlockPos blockPos = this.pos.north();
            BlockPos blockPos2 = this.pos.south();
            BlockPos blockPos3 = this.pos.west();
            BlockPos blockPos4 = this.pos.east();
            boolean bl = this.func_180363_c(blockPos);
            boolean bl2 = this.func_180363_c(blockPos2);
            boolean bl3 = this.func_180363_c(blockPos3);
            boolean bl4 = this.func_180363_c(blockPos4);
            EnumRailDirection enumRailDirection = null;
            if (bl || bl2) {
                enumRailDirection = EnumRailDirection.NORTH_SOUTH;
            }
            if (bl3 || bl4) {
                enumRailDirection = EnumRailDirection.EAST_WEST;
            }
            if (!this.isPowered) {
                if (bl2 && bl4 && !bl && !bl3) {
                    enumRailDirection = EnumRailDirection.SOUTH_EAST;
                }
                if (bl2 && bl3 && !bl && !bl4) {
                    enumRailDirection = EnumRailDirection.SOUTH_WEST;
                }
                if (bl && bl3 && !bl2 && !bl4) {
                    enumRailDirection = EnumRailDirection.NORTH_WEST;
                }
                if (bl && bl4 && !bl2 && !bl3) {
                    enumRailDirection = EnumRailDirection.NORTH_EAST;
                }
            }
            if (enumRailDirection == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.isRailBlock(this.world, blockPos.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.isRailBlock(this.world, blockPos2.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (enumRailDirection == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.isRailBlock(this.world, blockPos4.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.isRailBlock(this.world, blockPos3.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (enumRailDirection == null) {
                enumRailDirection = EnumRailDirection.NORTH_SOUTH;
            }
            this.state = this.state.withProperty(this.block.getShapeProperty(), enumRailDirection);
            this.world.setBlockState(this.pos, this.state, 3);
        }

        private boolean func_180361_d(BlockPos blockPos) {
            Rail rail = this.findRailAt(blockPos);
            if (rail == null) {
                return false;
            }
            rail.func_150651_b();
            return rail.func_150649_b(this);
        }

        public Rail func_180364_a(boolean bl, boolean bl2) {
            BlockPos blockPos = this.pos.north();
            BlockPos blockPos2 = this.pos.south();
            BlockPos blockPos3 = this.pos.west();
            BlockPos blockPos4 = this.pos.east();
            boolean bl3 = this.func_180361_d(blockPos);
            boolean bl4 = this.func_180361_d(blockPos2);
            boolean bl5 = this.func_180361_d(blockPos3);
            boolean bl6 = this.func_180361_d(blockPos4);
            EnumRailDirection enumRailDirection = null;
            if ((bl3 || bl4) && !bl5 && !bl6) {
                enumRailDirection = EnumRailDirection.NORTH_SOUTH;
            }
            if ((bl5 || bl6) && !bl3 && !bl4) {
                enumRailDirection = EnumRailDirection.EAST_WEST;
            }
            if (!this.isPowered) {
                if (bl4 && bl6 && !bl3 && !bl5) {
                    enumRailDirection = EnumRailDirection.SOUTH_EAST;
                }
                if (bl4 && bl5 && !bl3 && !bl6) {
                    enumRailDirection = EnumRailDirection.SOUTH_WEST;
                }
                if (bl3 && bl5 && !bl4 && !bl6) {
                    enumRailDirection = EnumRailDirection.NORTH_WEST;
                }
                if (bl3 && bl6 && !bl4 && !bl5) {
                    enumRailDirection = EnumRailDirection.NORTH_EAST;
                }
            }
            if (enumRailDirection == null) {
                if (bl3 || bl4) {
                    enumRailDirection = EnumRailDirection.NORTH_SOUTH;
                }
                if (bl5 || bl6) {
                    enumRailDirection = EnumRailDirection.EAST_WEST;
                }
                if (!this.isPowered) {
                    if (bl) {
                        if (bl4 && bl6) {
                            enumRailDirection = EnumRailDirection.SOUTH_EAST;
                        }
                        if (bl5 && bl4) {
                            enumRailDirection = EnumRailDirection.SOUTH_WEST;
                        }
                        if (bl6 && bl3) {
                            enumRailDirection = EnumRailDirection.NORTH_EAST;
                        }
                        if (bl3 && bl5) {
                            enumRailDirection = EnumRailDirection.NORTH_WEST;
                        }
                    } else {
                        if (bl3 && bl5) {
                            enumRailDirection = EnumRailDirection.NORTH_WEST;
                        }
                        if (bl6 && bl3) {
                            enumRailDirection = EnumRailDirection.NORTH_EAST;
                        }
                        if (bl5 && bl4) {
                            enumRailDirection = EnumRailDirection.SOUTH_WEST;
                        }
                        if (bl4 && bl6) {
                            enumRailDirection = EnumRailDirection.SOUTH_EAST;
                        }
                    }
                }
            }
            if (enumRailDirection == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.isRailBlock(this.world, blockPos.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.isRailBlock(this.world, blockPos2.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (enumRailDirection == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.isRailBlock(this.world, blockPos4.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.isRailBlock(this.world, blockPos3.up())) {
                    enumRailDirection = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (enumRailDirection == null) {
                enumRailDirection = EnumRailDirection.NORTH_SOUTH;
            }
            this.func_180360_a(enumRailDirection);
            this.state = this.state.withProperty(this.block.getShapeProperty(), enumRailDirection);
            if (bl2 || this.world.getBlockState(this.pos) != this.state) {
                this.world.setBlockState(this.pos, this.state, 3);
                for (int i = 0; i < this.field_150657_g.size(); ++i) {
                    Rail rail = this.findRailAt(this.field_150657_g.get(i));
                    if (rail == null) continue;
                    rail.func_150651_b();
                    if (!rail.func_150649_b(this)) continue;
                    rail.func_150645_c(this);
                }
            }
            return this;
        }

        public IBlockState getBlockState() {
            return this.state;
        }
    }
}

