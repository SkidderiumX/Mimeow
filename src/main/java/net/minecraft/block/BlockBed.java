/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BlockBed
extends BlockDirectional {
    public static final PropertyEnum<EnumPartType> PART = PropertyEnum.create("part", EnumPartType.class);
    public static final PropertyBool OCCUPIED = PropertyBool.create("occupied");

    public BlockBed() {
        super(Material.cloth);
        this.setDefaultState(this.blockState.getBaseState().withProperty(PART, EnumPartType.FOOT).withProperty(OCCUPIED, false));
        this.setBedBounds();
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (world2.isRemote) {
            return true;
        }
        if (iBlockState.getValue(PART) != EnumPartType.HEAD && (iBlockState = world2.getBlockState(blockPos = blockPos.offset(iBlockState.getValue(FACING)))).getBlock() != this) {
            return true;
        }
        if (world2.provider.canRespawnHere() && world2.getBiomeGenForCoords(blockPos) != BiomeGenBase.hell) {
            Object object;
            if (iBlockState.getValue(OCCUPIED).booleanValue()) {
                object = this.getPlayerInBed(world2, blockPos);
                if (object != null) {
                    entityPlayer.addChatComponentMessage(new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
                    return true;
                }
                iBlockState = iBlockState.withProperty(OCCUPIED, false);
                world2.setBlockState(blockPos, iBlockState, 4);
            }
            if ((object = entityPlayer.trySleep(blockPos)) == EntityPlayer.EnumStatus.OK) {
                iBlockState = iBlockState.withProperty(OCCUPIED, true);
                world2.setBlockState(blockPos, iBlockState, 4);
                return true;
            }
            if (object == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW) {
                entityPlayer.addChatComponentMessage(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
            } else if (object == EntityPlayer.EnumStatus.NOT_SAFE) {
                entityPlayer.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
            }
            return true;
        }
        world2.setBlockToAir(blockPos);
        BlockPos blockPos2 = blockPos.offset(iBlockState.getValue(FACING).getOpposite());
        if (world2.getBlockState(blockPos2).getBlock() == this) {
            world2.setBlockToAir(blockPos2);
        }
        world2.newExplosion(null, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, 5.0f, true, true);
        return true;
    }

    private EntityPlayer getPlayerInBed(World world2, BlockPos blockPos) {
        for (EntityPlayer entityPlayer : world2.playerEntities) {
            if (!entityPlayer.isPlayerSleeping() || !entityPlayer.playerLocation.equals(blockPos)) continue;
            return entityPlayer;
        }
        return null;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
        this.setBedBounds();
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        EnumFacing enumFacing = iBlockState.getValue(FACING);
        if (iBlockState.getValue(PART) == EnumPartType.HEAD) {
            if (world2.getBlockState(blockPos.offset(enumFacing.getOpposite())).getBlock() != this) {
                world2.setBlockToAir(blockPos);
            }
        } else if (world2.getBlockState(blockPos.offset(enumFacing)).getBlock() != this) {
            world2.setBlockToAir(blockPos);
            if (!world2.isRemote) {
                this.dropBlockAsItem(world2, blockPos, iBlockState, 0);
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return iBlockState.getValue(PART) == EnumPartType.HEAD ? null : Items.bed;
    }

    private void setBedBounds() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5625f, 1.0f);
    }

    public static BlockPos getSafeExitLocation(World world2, BlockPos blockPos, int n) {
        EnumFacing enumFacing = world2.getBlockState(blockPos).getValue(FACING);
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        for (int i = 0; i <= 1; ++i) {
            int n5 = n2 - enumFacing.getFrontOffsetX() * i - 1;
            int n6 = n4 - enumFacing.getFrontOffsetZ() * i - 1;
            int n7 = n5 + 2;
            int n8 = n6 + 2;
            for (int j = n5; j <= n7; ++j) {
                for (int k = n6; k <= n8; ++k) {
                    BlockPos blockPos2 = new BlockPos(j, n3, k);
                    if (!BlockBed.hasRoomForPlayer(world2, blockPos2)) continue;
                    if (n <= 0) {
                        return blockPos2;
                    }
                    --n;
                }
            }
        }
        return null;
    }

    protected static boolean hasRoomForPlayer(World world2, BlockPos blockPos) {
        return World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) && !world2.getBlockState(blockPos).getBlock().getMaterial().isSolid() && !world2.getBlockState(blockPos.up()).getBlock().getMaterial().isSolid();
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        if (iBlockState.getValue(PART) == EnumPartType.FOOT) {
            super.dropBlockAsItemWithChance(world2, blockPos, iBlockState, f, 0);
        }
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public Item getItem(World world2, BlockPos blockPos) {
        return Items.bed;
    }

    @Override
    public void onBlockHarvested(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
        BlockPos blockPos2;
        if (entityPlayer.capabilities.isCreativeMode && iBlockState.getValue(PART) == EnumPartType.HEAD && world2.getBlockState(blockPos2 = blockPos.offset(iBlockState.getValue(FACING).getOpposite())).getBlock() == this) {
            world2.setBlockToAir(blockPos2);
        }
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        EnumFacing enumFacing = EnumFacing.getHorizontal(n);
        return (n & 8) > 0 ? this.getDefaultState().withProperty(PART, EnumPartType.HEAD).withProperty(FACING, enumFacing).withProperty(OCCUPIED, (n & 4) > 0) : this.getDefaultState().withProperty(PART, EnumPartType.FOOT).withProperty(FACING, enumFacing);
    }

    @Override
    public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState2;
        if (iBlockState.getValue(PART) == EnumPartType.FOOT && (iBlockState2 = iBlockAccess.getBlockState(blockPos.offset(iBlockState.getValue(FACING)))).getBlock() == this) {
            iBlockState = iBlockState.withProperty(OCCUPIED, iBlockState2.getValue(OCCUPIED));
        }
        return iBlockState;
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        int n = 0;
        n |= iBlockState.getValue(FACING).getHorizontalIndex();
        if (iBlockState.getValue(PART) == EnumPartType.HEAD) {
            n |= 8;
            if (iBlockState.getValue(OCCUPIED).booleanValue()) {
                n |= 4;
            }
        }
        return n;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING, PART, OCCUPIED);
    }

    public static enum EnumPartType implements IStringSerializable
    {
        HEAD("head"),
        FOOT("foot");

        private final String name;

        private EnumPartType(String string2) {
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

