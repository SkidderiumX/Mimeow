/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import de.florianmichael.viamcp.fixes.FixedSoundEngine;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemBlock
extends Item {
    protected final Block block;

    public ItemBlock(Block block) {
        this.block = block;
    }

    @Override
    public ItemBlock setUnlocalizedName(String string) {
        super.setUnlocalizedName(string);
        return this;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        return FixedSoundEngine.onItemUse(this, itemStack, entityPlayer, world2, blockPos, enumFacing, f, f2, f3);
    }

    public static boolean setTileEntityNBT(World world2, EntityPlayer entityPlayer, BlockPos blockPos, ItemStack itemStack) {
        TileEntity tileEntity;
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        if (minecraftServer == null) {
            return false;
        }
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("BlockEntityTag", 10) && (tileEntity = world2.getTileEntity(blockPos)) != null) {
            if (!world2.isRemote && tileEntity.func_183000_F() && !minecraftServer.getConfigurationManager().canSendCommands(entityPlayer.getGameProfile())) {
                return false;
            }
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagCompound.copy();
            tileEntity.writeToNBT(nBTTagCompound);
            NBTTagCompound nBTTagCompound3 = (NBTTagCompound)itemStack.getTagCompound().getTag("BlockEntityTag");
            nBTTagCompound.merge(nBTTagCompound3);
            nBTTagCompound.setInteger("x", blockPos.getX());
            nBTTagCompound.setInteger("y", blockPos.getY());
            nBTTagCompound.setInteger("z", blockPos.getZ());
            if (!nBTTagCompound.equals(nBTTagCompound2)) {
                tileEntity.readFromNBT(nBTTagCompound);
                tileEntity.markDirty();
                return true;
            }
        }
        return false;
    }

    public boolean canPlaceBlockOnSide(World world2, BlockPos blockPos, EnumFacing enumFacing, EntityPlayer entityPlayer, ItemStack itemStack) {
        Block block = world2.getBlockState(blockPos).getBlock();
        if (block == Blocks.snow_layer) {
            enumFacing = EnumFacing.UP;
        } else if (!block.isReplaceable(world2, blockPos)) {
            blockPos = blockPos.offset(enumFacing);
        }
        return world2.canBlockBePlaced(this.block, blockPos, false, enumFacing, null, itemStack);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return this.block.getUnlocalizedName();
    }

    @Override
    public String getUnlocalizedName() {
        return this.block.getUnlocalizedName();
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return this.block.getCreativeTabToDisplayOn();
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        this.block.getSubBlocks(item, creativeTabs, list);
    }

    public Block getBlock() {
        return this.block;
    }
}

