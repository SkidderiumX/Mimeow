/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoor
extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyEnum<EnumHingePosition> HINGE = PropertyEnum.create("hinge", EnumHingePosition.class);
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyEnum<EnumDoorHalf> HALF = PropertyEnum.create("half", EnumDoorHalf.class);

    protected BlockDoor(Material material) {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, false).withProperty(HINGE, EnumHingePosition.LEFT).withProperty(POWERED, false).withProperty(HALF, EnumDoorHalf.LOWER));
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal((this.getUnlocalizedName() + ".name").replaceAll("tile", "item"));
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return BlockDoor.isOpen(BlockDoor.combineMetadata(iBlockAccess, blockPos));
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world2, BlockPos blockPos) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.getSelectedBoundingBox(world2, blockPos);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.getCollisionBoundingBox(world2, blockPos, iBlockState);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        this.setBoundBasedOnMeta(BlockDoor.combineMetadata(iBlockAccess, blockPos));
    }

    private void setBoundBasedOnMeta(int n) {
        float f = 0.1875f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        EnumFacing enumFacing = BlockDoor.getFacing(n);
        boolean bl = BlockDoor.isOpen(n);
        boolean bl2 = BlockDoor.isHingeLeft(n);
        if (bl) {
            if (enumFacing == EnumFacing.EAST) {
                if (!bl2) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                } else {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                }
            } else if (enumFacing == EnumFacing.SOUTH) {
                if (!bl2) {
                    this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                } else {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                }
            } else if (enumFacing == EnumFacing.WEST) {
                if (!bl2) {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                } else {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                }
            } else if (enumFacing == EnumFacing.NORTH) {
                if (!bl2) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                } else {
                    this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
            }
        } else if (enumFacing == EnumFacing.EAST) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        } else if (enumFacing == EnumFacing.SOUTH) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        } else if (enumFacing == EnumFacing.WEST) {
            this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else if (enumFacing == EnumFacing.NORTH) {
            this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        IBlockState iBlockState2;
        if (this.blockMaterial == Material.iron) {
            return true;
        }
        BlockPos blockPos2 = iBlockState.getValue(HALF) == EnumDoorHalf.LOWER ? blockPos : blockPos.down();
        IBlockState iBlockState3 = iBlockState2 = blockPos.equals(blockPos2) ? iBlockState : world2.getBlockState(blockPos2);
        if (iBlockState2.getBlock() != this) {
            return false;
        }
        iBlockState = iBlockState2.cycleProperty(OPEN);
        world2.setBlockState(blockPos2, iBlockState, 2);
        world2.markBlockRangeForRenderUpdate(blockPos2, blockPos);
        world2.playAuxSFXAtEntity(entityPlayer, iBlockState.getValue(OPEN) != false ? 1003 : 1006, blockPos, 0);
        return true;
    }

    public void toggleDoor(World world2, BlockPos blockPos, boolean bl) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (iBlockState.getBlock() == this) {
            IBlockState iBlockState2;
            BlockPos blockPos2 = iBlockState.getValue(HALF) == EnumDoorHalf.LOWER ? blockPos : blockPos.down();
            IBlockState iBlockState3 = iBlockState2 = blockPos == blockPos2 ? iBlockState : world2.getBlockState(blockPos2);
            if (iBlockState2.getBlock() == this && iBlockState2.getValue(OPEN) != bl) {
                world2.setBlockState(blockPos2, iBlockState2.withProperty(OPEN, bl), 2);
                world2.markBlockRangeForRenderUpdate(blockPos2, blockPos);
                world2.playAuxSFXAtEntity(null, bl ? 1003 : 1006, blockPos, 0);
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (iBlockState.getValue(HALF) == EnumDoorHalf.UPPER) {
            BlockPos blockPos2 = blockPos.down();
            IBlockState iBlockState2 = world2.getBlockState(blockPos2);
            if (iBlockState2.getBlock() != this) {
                world2.setBlockToAir(blockPos);
            } else if (block != this) {
                this.onNeighborBlockChange(world2, blockPos2, iBlockState2, block);
            }
        } else {
            boolean bl = false;
            BlockPos blockPos3 = blockPos.up();
            IBlockState iBlockState3 = world2.getBlockState(blockPos3);
            if (iBlockState3.getBlock() != this) {
                world2.setBlockToAir(blockPos);
                bl = true;
            }
            if (!World.doesBlockHaveSolidTopSurface(world2, blockPos.down())) {
                world2.setBlockToAir(blockPos);
                bl = true;
                if (iBlockState3.getBlock() == this) {
                    world2.setBlockToAir(blockPos3);
                }
            }
            if (bl) {
                if (!world2.isRemote) {
                    this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
                }
            } else {
                boolean bl2;
                boolean bl3 = bl2 = world2.isBlockPowered(blockPos) || world2.isBlockPowered(blockPos3);
                if ((bl2 || block.canProvidePower()) && block != this && bl2 != iBlockState3.getValue(POWERED)) {
                    world2.setBlockState(blockPos3, iBlockState3.withProperty(POWERED, bl2), 2);
                    if (bl2 != iBlockState.getValue(OPEN)) {
                        world2.setBlockState(blockPos, iBlockState.withProperty(OPEN, bl2), 2);
                        world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
                        world2.playAuxSFXAtEntity(null, bl2 ? 1003 : 1006, blockPos, 0);
                    }
                }
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return iBlockState.getValue(HALF) == EnumDoorHalf.UPPER ? null : this.getItem();
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world2, BlockPos blockPos, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.collisionRayTrace(world2, blockPos, vec3, vec32);
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return blockPos.getY() >= 255 ? false : World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) && super.canPlaceBlockAt(world2, blockPos) && super.canPlaceBlockAt(world2, blockPos.up());
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    public static int combineMetadata(IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        int n = iBlockState.getBlock().getMetaFromState(iBlockState);
        boolean bl = BlockDoor.isTop(n);
        IBlockState iBlockState2 = iBlockAccess.getBlockState(blockPos.down());
        int n2 = iBlockState2.getBlock().getMetaFromState(iBlockState2);
        int n3 = bl ? n2 : n;
        IBlockState iBlockState3 = iBlockAccess.getBlockState(blockPos.up());
        int n4 = iBlockState3.getBlock().getMetaFromState(iBlockState3);
        int n5 = bl ? n : n4;
        boolean bl2 = (n5 & 1) != 0;
        boolean bl3 = (n5 & 2) != 0;
        return BlockDoor.removeHalfBit(n3) | (bl ? 8 : 0) | (bl2 ? 16 : 0) | (bl3 ? 32 : 0);
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return this.getItem();
    }

    private Item getItem() {
        return this == Blocks.iron_door ? Items.iron_door : (this == Blocks.spruce_door ? Items.spruce_door : (this == Blocks.birch_door ? Items.birch_door : (this == Blocks.jungle_door ? Items.jungle_door : (this == Blocks.acacia_door ? Items.acacia_door : (this == Blocks.dark_oak_door ? Items.dark_oak_door : Items.oak_door)))));
    }

    @Override
    public void onBlockHarvested(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
        BlockPos blockPos2 = blockPos.down();
        if (entityPlayer.capabilities.isCreativeMode && iBlockState.getValue(HALF) == EnumDoorHalf.UPPER && world2.getBlockState(blockPos2).getBlock() == this) {
            world2.setBlockToAir(blockPos2);
        }
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        if (iBlockState.getValue(HALF) == EnumDoorHalf.LOWER) {
            IBlockState iBlockState2 = iBlockAccess.getBlockState(blockPos.up());
            if (iBlockState2.getBlock() == this) {
                iBlockState = iBlockState.withProperty(HINGE, iBlockState2.getValue(HINGE)).withProperty(POWERED, iBlockState2.getValue(POWERED));
            }
        } else {
            IBlockState iBlockState3 = iBlockAccess.getBlockState(blockPos.down());
            if (iBlockState3.getBlock() == this) {
                iBlockState = iBlockState.withProperty(FACING, iBlockState3.getValue(FACING)).withProperty(OPEN, iBlockState3.getValue(OPEN));
            }
        }
        return iBlockState;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return (n & 8) > 0 ? this.getDefaultState().withProperty(HALF, EnumDoorHalf.UPPER).withProperty(HINGE, (n & 1) > 0 ? EnumHingePosition.RIGHT : EnumHingePosition.LEFT).withProperty(POWERED, (n & 2) > 0) : this.getDefaultState().withProperty(HALF, EnumDoorHalf.LOWER).withProperty(FACING, EnumFacing.getHorizontal(n & 3).rotateYCCW()).withProperty(OPEN, (n & 4) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        if (iBlockState.getValue(HALF) == EnumDoorHalf.UPPER) {
            n |= 8;
            if (iBlockState.getValue(HINGE) == EnumHingePosition.RIGHT) {
                n |= 1;
            }
            if (iBlockState.getValue(POWERED).booleanValue()) {
                n |= 2;
            }
        } else {
            n |= iBlockState.getValue(FACING).rotateY().getHorizontalIndex();
            if (iBlockState.getValue(OPEN).booleanValue()) {
                n |= 4;
            }
        }
        return n;
    }

    protected static int removeHalfBit(int n) {
        return n & 7;
    }

    public static boolean isOpen(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return BlockDoor.isOpen(BlockDoor.combineMetadata(iBlockAccess, blockPos));
    }

    public static EnumFacing getFacing(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return BlockDoor.getFacing(BlockDoor.combineMetadata(iBlockAccess, blockPos));
    }

    public static EnumFacing getFacing(int n) {
        return EnumFacing.getHorizontal(n & 3).rotateYCCW();
    }

    protected static boolean isOpen(int n) {
        return (n & 4) != 0;
    }

    protected static boolean isTop(int n) {
        return (n & 8) != 0;
    }

    protected static boolean isHingeLeft(int n) {
        return (n & 0x10) != 0;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, HALF, FACING, OPEN, HINGE, POWERED);
    }

    public static enum EnumHingePosition implements IStringSerializable
    {
        LEFT,
        RIGHT;


        public String toString() {
            return this.getName();
        }

        @Override
        public String getName() {
            return this == LEFT ? "left" : "right";
        }
    }

    public static enum EnumDoorHalf implements IStringSerializable
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

