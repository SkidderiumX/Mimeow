/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockPistonStructureHelper;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonBase
extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool EXTENDED = PropertyBool.create("extended");
    private final boolean isSticky;

    public BlockPistonBase(boolean bl) {
        super(Material.piston);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(EXTENDED, false));
        this.isSticky = bl;
        this.setStepSound(soundTypePiston);
        this.setHardness(0.5f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        world2.setBlockState(blockPos, iBlockState.withProperty(FACING, BlockPistonBase.getFacingFromEntity(world2, blockPos, entityLivingBase)), 2);
        if (!world2.isRemote) {
            this.checkForMove(world2, blockPos, iBlockState);
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!world2.isRemote) {
            this.checkForMove(world2, blockPos, iBlockState);
        }
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (!world2.isRemote && world2.getTileEntity(blockPos) == null) {
            this.checkForMove(world2, blockPos, iBlockState);
        }
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        return this.getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(world2, blockPos, entityLivingBase)).withProperty(EXTENDED, false);
    }

    private void checkForMove(World world2, BlockPos blockPos, IBlockState iBlockState) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        boolean bl = this.shouldBeExtended(world2, blockPos, enumFacing);
        if (bl && !iBlockState.getValue(EXTENDED).booleanValue()) {
            if (new BlockPistonStructureHelper(world2, blockPos, enumFacing, true).canMove()) {
                world2.addBlockEvent(blockPos, this, 0, enumFacing.getIndex());
            }
        } else if (!bl && iBlockState.getValue(EXTENDED).booleanValue()) {
            world2.setBlockState(blockPos, iBlockState.withProperty(EXTENDED, false), 2);
            world2.addBlockEvent(blockPos, this, 1, enumFacing.getIndex());
        }
    }

    private boolean shouldBeExtended(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        for (EnumFacing enumFacing2 : EnumFacing.values()) {
            if (enumFacing2 == enumFacing || !world2.isSidePowered(blockPos.offset(enumFacing2), enumFacing2)) continue;
            return true;
        }
        if (world2.isSidePowered(blockPos, EnumFacing.DOWN)) {
            return true;
        }
        BlockPos blockPos2 = blockPos.up();
        for (EnumFacing enumFacing3 : EnumFacing.values()) {
            if (enumFacing3 == EnumFacing.DOWN || !world2.isSidePowered(blockPos2.offset(enumFacing3), enumFacing3)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean onBlockEventReceived(World world2, BlockPos blockPos, IBlockState iBlockState, int n, int n2) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        if (!world2.isRemote) {
            boolean bl = this.shouldBeExtended(world2, blockPos, enumFacing);
            if (bl && n == 1) {
                world2.setBlockState(blockPos, iBlockState.withProperty(EXTENDED, true), 2);
                return false;
            }
            if (!bl && n == 0) {
                return false;
            }
        }
        if (n == 0) {
            if (!this.doMove(world2, blockPos, enumFacing, true)) {
                return false;
            }
            world2.setBlockState(blockPos, iBlockState.withProperty(EXTENDED, true), 2);
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, "tile.piston.out", 0.5f, world2.rand.nextFloat() * 0.25f + 0.6f);
        } else if (n == 1) {
            TileEntity tileEntity = world2.getTileEntity(blockPos.offset(enumFacing));
            if (tileEntity instanceof TileEntityPiston) {
                ((TileEntityPiston)tileEntity).clearPistonTileEntity();
            }
            world2.setBlockState(blockPos, Blocks.piston_extension.getDefaultState().withProperty(BlockPistonMoving.FACING, enumFacing).withProperty(BlockPistonMoving.TYPE, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT), 3);
            world2.setTileEntity(blockPos, BlockPistonMoving.newTileEntity(this.getStateFromMeta(n2), enumFacing, false, true));
            if (this.isSticky) {
                TileEntityPiston tileEntityPiston;
                TileEntity tileEntity2;
                BlockPos blockPos2 = blockPos.add(enumFacing.getFrontOffsetX() * 2, enumFacing.getFrontOffsetY() * 2, enumFacing.getFrontOffsetZ() * 2);
                Block block = world2.getBlockState(blockPos2).getBlock();
                boolean bl = false;
                if (block == Blocks.piston_extension && (tileEntity2 = world2.getTileEntity(blockPos2)) instanceof TileEntityPiston && (tileEntityPiston = (TileEntityPiston)tileEntity2).getFacing() == enumFacing && tileEntityPiston.isExtending()) {
                    tileEntityPiston.clearPistonTileEntity();
                    bl = true;
                }
                if (!bl && block.getMaterial() != Material.air && BlockPistonBase.canPush(block, world2, blockPos2, enumFacing.getOpposite(), false) && (block.getMobilityFlag() == 0 || block == Blocks.piston || block == Blocks.sticky_piston)) {
                    this.doMove(world2, blockPos, enumFacing, false);
                }
            } else {
                world2.setBlockToAir(blockPos.offset(enumFacing));
            }
            world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, "tile.piston.in", 0.5f, world2.rand.nextFloat() * 0.15f + 0.6f);
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        if (iBlockState.getBlock() == this && iBlockState.getValue(EXTENDED).booleanValue()) {
            float f = 0.25f;
            EnumFacing enumFacing = iBlockState.getValue(FACING);
            if (enumFacing != null) {
                switch (enumFacing) {
                    case DOWN: {
                        this.setBlockBounds(0.0f, 0.25f, 0.0f, 1.0f, 1.0f, 1.0f);
                        break;
                    }
                    case UP: {
                        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
                        break;
                    }
                    case NORTH: {
                        this.setBlockBounds(0.0f, 0.0f, 0.25f, 1.0f, 1.0f, 1.0f);
                        break;
                    }
                    case SOUTH: {
                        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.75f);
                        break;
                    }
                    case WEST: {
                        this.setBlockBounds(0.25f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                        break;
                    }
                    case EAST: {
                        this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.75f, 1.0f, 1.0f);
                    }
                }
            }
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void addCollisionBoxesToList(World world2, BlockPos blockPos, IBlockState iBlockState, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, Entity entity) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world2, blockPos, iBlockState, axisAlignedBB, list, entity);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.setBlockBoundsBasedOnState(world2, blockPos);
        return super.getCollisionBoundingBox(world2, blockPos, iBlockState);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    public static EnumFacing getFacing(int n) {
        int n2 = n & 7;
        return n2 > 5 ? null : EnumFacing.getFront(n2);
    }

    public static EnumFacing getFacingFromEntity(World world2, BlockPos blockPos, EntityLivingBase entityLivingBase) {
        if (MathHelper.abs((float)entityLivingBase.posX - (float)blockPos.getX()) < 2.0f && MathHelper.abs((float)entityLivingBase.posZ - (float)blockPos.getZ()) < 2.0f) {
            double d = entityLivingBase.posY + (double)entityLivingBase.getEyeHeight();
            if (d - (double)blockPos.getY() > 2.0) {
                return EnumFacing.UP;
            }
            if ((double)blockPos.getY() - d > 0.0) {
                return EnumFacing.DOWN;
            }
        }
        return entityLivingBase.getHorizontalFacing().getOpposite();
    }

    public static boolean canPush(Block block, World world2, BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        if (block == Blocks.obsidian) {
            return false;
        }
        if (!world2.getWorldBorder().contains(blockPos)) {
            return false;
        }
        if (blockPos.getY() >= 0 && (enumFacing != EnumFacing.DOWN || blockPos.getY() != 0)) {
            if (blockPos.getY() <= world2.getHeight() - 1 && (enumFacing != EnumFacing.UP || blockPos.getY() != world2.getHeight() - 1)) {
                if (block != Blocks.piston && block != Blocks.sticky_piston) {
                    if (block.getBlockHardness(world2, blockPos) == -1.0f) {
                        return false;
                    }
                    if (block.getMobilityFlag() == 2) {
                        return false;
                    }
                    if (block.getMobilityFlag() == 1) {
                        return bl;
                    }
                } else if (world2.getBlockState(blockPos).getValue(EXTENDED).booleanValue()) {
                    return false;
                }
                return !(block instanceof ITileEntityProvider);
            }
            return false;
        }
        return false;
    }

    private boolean doMove(World world2, BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        int n;
        Object object;
        Object object2;
        Object object3;
        int n2;
        if (!bl) {
            world2.setBlockToAir(blockPos.offset(enumFacing));
        }
        BlockPistonStructureHelper blockPistonStructureHelper = new BlockPistonStructureHelper(world2, blockPos, enumFacing, bl);
        List<BlockPos> list = blockPistonStructureHelper.getBlocksToMove();
        List<BlockPos> list2 = blockPistonStructureHelper.getBlocksToDestroy();
        if (!blockPistonStructureHelper.canMove()) {
            return false;
        }
        int n3 = list.size() + list2.size();
        Block[] blockArray = new Block[n3];
        EnumFacing enumFacing2 = bl ? enumFacing : enumFacing.getOpposite();
        for (n2 = list2.size() - 1; n2 >= 0; --n2) {
            object3 = list2.get(n2);
            object2 = world2.getBlockState((BlockPos)object3).getBlock();
            ((Block)object2).dropBlockAsItem(world2, (BlockPos)object3, world2.getBlockState((BlockPos)object3), 0);
            world2.setBlockToAir((BlockPos)object3);
            blockArray[--n3] = object2;
        }
        for (n2 = list.size() - 1; n2 >= 0; --n2) {
            object3 = list.get(n2);
            object2 = world2.getBlockState((BlockPos)object3);
            object = object2.getBlock();
            ((Block)object).getMetaFromState((IBlockState)object2);
            world2.setBlockToAir((BlockPos)object3);
            object3 = ((BlockPos)object3).offset(enumFacing2);
            world2.setBlockState((BlockPos)object3, Blocks.piston_extension.getDefaultState().withProperty(FACING, enumFacing), 4);
            world2.setTileEntity((BlockPos)object3, BlockPistonMoving.newTileEntity((IBlockState)object2, enumFacing, bl, false));
            blockArray[--n3] = object;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        if (bl) {
            object3 = this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT;
            object2 = Blocks.piston_head.getDefaultState().withProperty(BlockPistonExtension.FACING, enumFacing).withProperty(BlockPistonExtension.TYPE, object3);
            object = Blocks.piston_extension.getDefaultState().withProperty(BlockPistonMoving.FACING, enumFacing).withProperty(BlockPistonMoving.TYPE, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
            world2.setBlockState(blockPos2, (IBlockState)object, 4);
            world2.setTileEntity(blockPos2, BlockPistonMoving.newTileEntity((IBlockState)object2, enumFacing, true, false));
        }
        for (n = list2.size() - 1; n >= 0; --n) {
            world2.notifyNeighborsOfStateChange(list2.get(n), blockArray[n3++]);
        }
        for (n = list.size() - 1; n >= 0; --n) {
            world2.notifyNeighborsOfStateChange(list.get(n), blockArray[n3++]);
        }
        if (bl) {
            world2.notifyNeighborsOfStateChange(blockPos2, Blocks.piston_head);
            world2.notifyNeighborsOfStateChange(blockPos, this);
        }
        return true;
    }

    @Override
    public IBlockState getStateForEntityRender(IBlockState iBlockState) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.UP);
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, BlockPistonBase.getFacing(n)).withProperty(EXTENDED, (n & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(FACING).getIndex();
        if (iBlockState.getValue(EXTENDED).booleanValue()) {
            n |= 8;
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, EXTENDED);
    }
}

