/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.HttpUtil;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

public class BlockBeacon
extends BlockContainer {
    public BlockBeacon() {
        super(Material.glass, MapColor.diamondColor);
        this.setHardness(3.0f);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public TileEntity createNewTileEntity(World world2, int n) {
        return new TileEntityBeacon();
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        if (world2.isRemote) {
            return true;
        }
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityBeacon) {
            entityPlayer.displayGUIChest((TileEntityBeacon)tileEntity);
            entityPlayer.triggerAchievement(StatList.field_181730_N);
        }
        return true;
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
    public int getRenderType() {
        return 3;
    }

    @Override
    public void onBlockPlacedBy(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntity tileEntity;
        super.onBlockPlacedBy(world2, blockPos, iBlockState, entityLivingBase, itemStack);
        if (itemStack.hasDisplayName() && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntityBeacon) {
            ((TileEntityBeacon)tileEntity).setName(itemStack.getDisplayName());
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        TileEntity tileEntity = world2.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityBeacon) {
            ((TileEntityBeacon)tileEntity).updateBeacon();
            world2.addBlockEvent(blockPos, this, 1, 0);
        }
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    public static void updateColorAsync(final World world2, final BlockPos blockPos) {
        HttpUtil.field_180193_a.submit(new Runnable(){

            @Override
            public void run() {
                BlockPos blockPos2;
                Chunk chunk = world2.getChunkFromBlockCoords(blockPos);
                for (int i = blockPos.getY() - 1; i >= 0 && chunk.canSeeSky(blockPos2 = new BlockPos(blockPos.getX(), i, blockPos.getZ())); --i) {
                    IBlockState iBlockState = world2.getBlockState(blockPos2);
                    if (iBlockState.getBlock() != Blocks.beacon) continue;
                    ((WorldServer)world2).addScheduledTask(new Runnable(){

                        @Override
                        public void run() {
                            TileEntity tileEntity = world2.getTileEntity(blockPos2);
                            if (tileEntity instanceof TileEntityBeacon) {
                                ((TileEntityBeacon)tileEntity).updateBeacon();
                                world2.addBlockEvent(blockPos2, Blocks.beacon, 1, 0);
                            }
                        }
                    });
                }
            }
        });
    }
}

