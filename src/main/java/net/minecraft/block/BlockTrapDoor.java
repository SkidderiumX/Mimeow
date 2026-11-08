/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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

public class BlockTrapDoor
extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyEnum<DoorHalf> HALF = PropertyEnum.create("half", DoorHalf.class);

    protected BlockTrapDoor(Material material) {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, false).withProperty(HALF, DoorHalf.BOTTOM));
        float f = 0.5f;
        float f2 = 1.0f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
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
    public boolean isPassable(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return iBlockAccess.getBlockState(blockPos).getValue(OPEN) == false;
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
        this.setBounds(iBlockAccess.getBlockState(blockPos));
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.1875f;
        this.setBlockBounds(0.0f, 0.40625f, 0.0f, 1.0f, 0.59375f, 1.0f);
    }

    public void setBounds(IBlockState iBlockState) {
        if (iBlockState.getBlock() == this) {
            boolean bl = iBlockState.getValue(HALF) == DoorHalf.TOP;
            Boolean bl2 = iBlockState.getValue(OPEN);
            EnumFacing enumFacing = iBlockState.getValue(FACING);
            float f = 0.1875f;
            if (bl) {
                this.setBlockBounds(0.0f, 0.8125f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.1875f, 1.0f);
            }
            if (bl2.booleanValue()) {
                if (enumFacing == EnumFacing.NORTH) {
                    this.setBlockBounds(0.0f, 0.0f, 0.8125f, 1.0f, 1.0f, 1.0f);
                }
                if (enumFacing == EnumFacing.SOUTH) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875f);
                }
                if (enumFacing == EnumFacing.WEST) {
                    this.setBlockBounds(0.8125f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
                if (enumFacing == EnumFacing.EAST) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.1875f, 1.0f, 1.0f);
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (this.blockMaterial == Material.iron) {
            return true;
        }
        iBlockState = iBlockState.cycleProperty(OPEN);
        world2.setBlockState(blockPos, iBlockState, 2);
        world2.playAuxSFXAtEntity(entityPlayer, iBlockState.getValue(OPEN) != false ? 1003 : 1006, blockPos, 0);
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!world2.isRemote) {
            BlockPos blockPos2 = blockPos.offset(iBlockState.getValue(FACING).getOpposite());
            if (!BlockTrapDoor.isValidSupportBlock(world2.getBlockState(blockPos2).getBlock())) {
                world2.setBlockToAir(blockPos);
                this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            } else {
                boolean bl;
                boolean bl2 = world2.isBlockPowered(blockPos);
                if ((bl2 || block.canProvidePower()) && (bl = iBlockState.getValue(OPEN).booleanValue()) != bl2) {
                    world2.setBlockState(blockPos, iBlockState.withProperty(OPEN, bl2), 2);
                    world2.playAuxSFXAtEntity(null, bl2 ? 1003 : 1006, blockPos, 0);
                }
            }
        }
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world2, BlockPos blockPos, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.collisionRayTrace(world2, blockPos, vec3, vec32);
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        IBlockState iBlockState = this.getDefaultState();
        if (enumFacing.getAxis().isHorizontal()) {
            iBlockState = iBlockState.withProperty(FACING, enumFacing).withProperty(OPEN, false);
            iBlockState = iBlockState.withProperty(HALF, f2 > 0.5f ? DoorHalf.TOP : DoorHalf.BOTTOM);
        }
        return iBlockState;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        return !enumFacing.getAxis().isVertical() && BlockTrapDoor.isValidSupportBlock(world2.getBlockState(blockPos.offset(enumFacing.getOpposite())).getBlock());
    }

    protected static EnumFacing getFacing(int n) {
        switch (n & 3) {
            case 0: {
                return EnumFacing.NORTH;
            }
            case 1: {
                return EnumFacing.SOUTH;
            }
            case 2: {
                return EnumFacing.WEST;
            }
        }
        return EnumFacing.EAST;
    }

    protected static int getMetaForFacing(EnumFacing enumFacing) {
        switch (enumFacing) {
            case NORTH: {
                return 0;
            }
            case SOUTH: {
                return 1;
            }
            case WEST: {
                return 2;
            }
        }
        return 3;
    }

    private static boolean isValidSupportBlock(Block block) {
        return block.blockMaterial.isOpaque() && block.isFullCube() || block == Blocks.glowstone || block instanceof BlockSlab || block instanceof BlockStairs;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, BlockTrapDoor.getFacing(n)).withProperty(OPEN, (n & 4) != 0).withProperty(HALF, (n & 8) == 0 ? DoorHalf.BOTTOM : DoorHalf.TOP);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= BlockTrapDoor.getMetaForFacing(iBlockState.getValue(FACING));
        if (iBlockState.getValue(OPEN).booleanValue()) {
            n |= 4;
        }
        if (iBlockState.getValue(HALF) == DoorHalf.TOP) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, OPEN, HALF);
    }

    public static enum DoorHalf implements IStringSerializable
    {
        TOP("top"),
        BOTTOM("bottom");

        private final String name;

        private DoorHalf(String string2) {
            this.name = string2;
        }

        public String toString() {
            return this.name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}

