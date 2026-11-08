/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockButton
extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    private final boolean wooden;

    protected BlockButton(boolean bl) {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(POWERED, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.wooden = bl;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return null;
    }

    @Override
    public int tickRate(World world2) {
        return this.wooden ? 30 : 20;
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
        return BlockButton.func_181088_a(world2, blockPos, enumFacing.getOpposite());
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (!BlockButton.func_181088_a(world2, blockPos, enumFacing)) continue;
            return true;
        }
        return false;
    }

    protected static boolean func_181088_a(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        return enumFacing == EnumFacing.DOWN ? World.doesBlockHaveSolidTopSurface(world2, blockPos2) : world2.getBlockState(blockPos2).getBlock().isNormalCube();
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        return BlockButton.func_181088_a(world2, blockPos, enumFacing.getOpposite()) ? this.getDefaultState().withProperty(FACING, enumFacing).withProperty(POWERED, false) : this.getDefaultState().withProperty(FACING, EnumFacing.DOWN).withProperty(POWERED, false);
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (this.checkForDrop(world2, blockPos, iBlockState) && !BlockButton.func_181088_a(world2, blockPos, iBlockState.getValue(FACING).getOpposite())) {
            this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            world2.setBlockToAir(blockPos);
        }
    }

    private boolean checkForDrop(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (this.canPlaceBlockAt(world2, blockPos)) {
            return true;
        }
        this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
        world2.setBlockToAir(blockPos);
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        this.updateBlockBounds(iBlockAccess.getBlockState(blockPos));
    }

    private void updateBlockBounds(IBlockState iBlockState) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        boolean bl = iBlockState.getValue(POWERED);
        float f = 0.25f;
        float f2 = 0.375f;
        float f3 = (float)(bl ? 1 : 2) / 16.0f;
        float f4 = 0.125f;
        float f5 = 0.1875f;
        switch (enumFacing) {
            case EAST: {
                this.setBlockBounds(0.0f, 0.375f, 0.3125f, f3, 0.625f, 0.6875f);
                break;
            }
            case WEST: {
                this.setBlockBounds(1.0f - f3, 0.375f, 0.3125f, 1.0f, 0.625f, 0.6875f);
                break;
            }
            case SOUTH: {
                this.setBlockBounds(0.3125f, 0.375f, 0.0f, 0.6875f, 0.625f, f3);
                break;
            }
            case NORTH: {
                this.setBlockBounds(0.3125f, 0.375f, 1.0f - f3, 0.6875f, 0.625f, 1.0f);
                break;
            }
            case UP: {
                this.setBlockBounds(0.3125f, 0.0f, 0.375f, 0.6875f, 0.0f + f3, 0.625f);
                break;
            }
            case DOWN: {
                this.setBlockBounds(0.3125f, 1.0f - f3, 0.375f, 0.6875f, 1.0f, 0.625f);
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (iBlockState.getValue(POWERED).booleanValue()) {
            return true;
        }
        world2.setBlockState(blockPos, iBlockState.withProperty(POWERED, true), 3);
        world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
        world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, "random.click", 0.3f, 0.6f);
        this.notifyNeighbors(world2, blockPos, iBlockState.getValue(FACING));
        world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
        return true;
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (iBlockState.getValue(POWERED).booleanValue()) {
            this.notifyNeighbors(world2, blockPos, iBlockState.getValue(FACING));
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
    public void randomTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (!world2.isRemote && iBlockState.getValue(POWERED).booleanValue()) {
            if (this.wooden) {
                this.checkForArrows(world2, blockPos, iBlockState);
            } else {
                world2.setBlockState(blockPos, iBlockState.withProperty(POWERED, false));
                this.notifyNeighbors(world2, blockPos, iBlockState.getValue(FACING));
                world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, "random.click", 0.3f, 0.5f);
                world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
            }
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.1875f;
        float f2 = 0.125f;
        float f3 = 0.125f;
        this.setBlockBounds(0.5f - f, 0.5f - f2, 0.5f - f3, 0.5f + f, 0.5f + f2, 0.5f + f3);
    }

    @Override
    public void onEntityCollidedWithBlock(World world2, BlockPos blockPos, IBlockState iBlockState, Entity entity) {
        if (!world2.isRemote && this.wooden && !iBlockState.getValue(POWERED).booleanValue()) {
            this.checkForArrows(world2, blockPos, iBlockState);
        }
    }

    private void checkForArrows(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.updateBlockBounds(iBlockState);
        List<EntityArrow> list = world2.getEntitiesWithinAABB(EntityArrow.class, new AxisAlignedBB((double)blockPos.getX() + this.minX, (double)blockPos.getY() + this.minY, (double)blockPos.getZ() + this.minZ, (double)blockPos.getX() + this.maxX, (double)blockPos.getY() + this.maxY, (double)blockPos.getZ() + this.maxZ));
        boolean bl = !list.isEmpty();
        boolean bl2 = iBlockState.getValue(POWERED);
        if (bl && !bl2) {
            world2.setBlockState(blockPos, iBlockState.withProperty(POWERED, true));
            this.notifyNeighbors(world2, blockPos, iBlockState.getValue(FACING));
            world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (!bl && bl2) {
            world2.setBlockState(blockPos, iBlockState.withProperty(POWERED, false));
            this.notifyNeighbors(world2, blockPos, iBlockState.getValue(FACING));
            world2.markBlockRangeForRenderUpdate(blockPos, blockPos);
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, "random.click", 0.3f, 0.5f);
        }
        if (bl) {
            world2.scheduleUpdate(blockPos, this, this.tickRate(world2));
        }
    }

    private void notifyNeighbors(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        world2.notifyNeighborsOfStateChange(blockPos, this);
        world2.notifyNeighborsOfStateChange(blockPos.offset(enumFacing.getOpposite()), this);
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, switch (n & 7) {
            case 0 -> EnumFacing.DOWN;
            case 1 -> EnumFacing.EAST;
            case 2 -> EnumFacing.WEST;
            case 3 -> EnumFacing.SOUTH;
            case 4 -> EnumFacing.NORTH;
            default -> EnumFacing.UP;
        }).withProperty(POWERED, (n & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = switch (iBlockState.getValue(FACING)) {
            case EnumFacing.EAST -> 1;
            case EnumFacing.WEST -> 2;
            case EnumFacing.SOUTH -> 3;
            case EnumFacing.NORTH -> 4;
            default -> 5;
            case EnumFacing.DOWN -> 0;
        };
        if (iBlockState.getValue(POWERED).booleanValue()) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, POWERED);
    }
}

