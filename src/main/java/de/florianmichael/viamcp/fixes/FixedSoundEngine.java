/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.viamcp.fixes;

import de.florianmichael.viamcp.ViaMCP;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class FixedSoundEngine {
    private FixedSoundEngine() {
    }

    public static boolean destroyBlock(World world2, BlockPos blockPos, boolean bl) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        world2.playAuxSFX(2001, blockPos, Block.getStateId(iBlockState));
        if (block.getMaterial() == Material.air) {
            return false;
        }
        if (bl) {
            block.dropBlockAsItem(world2, blockPos, iBlockState, 0);
        }
        return world2.setBlockState(blockPos, Blocks.air.getDefaultState(), 3);
    }

    public static boolean onItemUse(ItemBlock itemBlock, ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (!iBlockState.getBlock().isReplaceable(world2, blockPos)) {
            blockPos = blockPos.offset(enumFacing);
        }
        if (itemStack.stackSize == 0 || !entityPlayer.canPlayerEdit(blockPos, enumFacing, itemStack)) {
            return false;
        }
        if (!world2.canBlockBePlaced(itemBlock.getBlock(), blockPos, false, enumFacing, null, itemStack)) {
            return false;
        }
        int n = itemBlock.getMetadata(itemStack.getMetadata());
        IBlockState iBlockState2 = itemBlock.getBlock().onBlockPlaced(world2, blockPos, enumFacing, f, f2, f3, n, entityPlayer);
        if (world2.setBlockState(blockPos, iBlockState2, 3)) {
            iBlockState2 = world2.getBlockState(blockPos);
            if (iBlockState2.getBlock() == itemBlock.getBlock()) {
                ItemBlock.setTileEntityNBT(world2, entityPlayer, blockPos, itemStack);
                itemBlock.getBlock().onBlockPlacedBy(world2, blockPos, iBlockState2, entityPlayer, itemStack);
            }
            Block.SoundType soundType = itemBlock.getBlock().stepSound;
            if (ViaMCP.isTargetVersionNewerThanNative() && Minecraft.getMinecraft().theWorld != null) {
                Minecraft.getMinecraft().theWorld.playSoundAtPos(blockPos.add(0.5, 0.5, 0.5), soundType.getPlaceSound(), (soundType.getVolume() + 1.0f) / 2.0f, soundType.getFrequency() * 0.8f, false);
            } else {
                world2.playSoundEffect((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, soundType.getPlaceSound(), (soundType.getVolume() + 1.0f) / 2.0f, soundType.getFrequency() * 0.8f);
            }
            --itemStack.stackSize;
        }
        return true;
    }
}

