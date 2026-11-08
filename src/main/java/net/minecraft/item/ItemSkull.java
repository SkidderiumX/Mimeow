/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSkull
extends Item {
    private static final String[] skullTypes = new String[]{"skeleton", "wither", "zombie", "char", "creeper"};

    public ItemSkull() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        if (enumFacing == EnumFacing.DOWN) {
            return false;
        }
        IBlockState iBlockState = world2.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        boolean bl = block.isReplaceable(world2, blockPos);
        if (!bl) {
            if (!world2.getBlockState(blockPos).getBlock().getMaterial().isSolid()) {
                return false;
            }
            blockPos = blockPos.offset(enumFacing);
        }
        if (!entityPlayer.canPlayerEdit(blockPos, enumFacing, itemStack)) {
            return false;
        }
        if (!Blocks.skull.canPlaceBlockAt(world2, blockPos)) {
            return false;
        }
        if (!world2.isRemote) {
            TileEntity tileEntity;
            world2.setBlockState(blockPos, Blocks.skull.getDefaultState().withProperty(BlockSkull.FACING, enumFacing), 3);
            int n = 0;
            if (enumFacing == EnumFacing.UP) {
                n = MathHelper.floor_double((double)(entityPlayer.rotationYaw * 16.0f / 360.0f) + 0.5) & 0xF;
            }
            if ((tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntitySkull) {
                TileEntitySkull tileEntitySkull = (TileEntitySkull)tileEntity;
                if (itemStack.getMetadata() == 3) {
                    GameProfile gameProfile = null;
                    if (itemStack.hasTagCompound()) {
                        NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
                        if (nBTTagCompound.hasKey("SkullOwner", 10)) {
                            gameProfile = NBTUtil.readGameProfileFromNBT(nBTTagCompound.getCompoundTag("SkullOwner"));
                        } else if (nBTTagCompound.hasKey("SkullOwner", 8) && nBTTagCompound.getString("SkullOwner").length() > 0) {
                            gameProfile = new GameProfile(null, nBTTagCompound.getString("SkullOwner"));
                        }
                    }
                    tileEntitySkull.setPlayerProfile(gameProfile);
                } else {
                    tileEntitySkull.setType(itemStack.getMetadata());
                }
                tileEntitySkull.setSkullRotation(n);
                Blocks.skull.checkWitherSpawn(world2, blockPos, tileEntitySkull);
            }
            --itemStack.stackSize;
        }
        return true;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (int i = 0; i < skullTypes.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int getMetadata(int n) {
        return n;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int n = itemStack.getMetadata();
        if (n < 0 || n >= skullTypes.length) {
            n = 0;
        }
        return super.getUnlocalizedName() + "." + skullTypes[n];
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        if (itemStack.getMetadata() == 3 && itemStack.hasTagCompound()) {
            NBTTagCompound nBTTagCompound;
            if (itemStack.getTagCompound().hasKey("SkullOwner", 8)) {
                return StatCollector.translateToLocalFormatted("item.skull.player.name", itemStack.getTagCompound().getString("SkullOwner"));
            }
            if (itemStack.getTagCompound().hasKey("SkullOwner", 10) && (nBTTagCompound = itemStack.getTagCompound().getCompoundTag("SkullOwner")).hasKey("Name", 8)) {
                return StatCollector.translateToLocalFormatted("item.skull.player.name", nBTTagCompound.getString("Name"));
            }
        }
        return super.getItemStackDisplayName(itemStack);
    }

    @Override
    public boolean updateItemStackNBT(NBTTagCompound nBTTagCompound) {
        super.updateItemStackNBT(nBTTagCompound);
        if (nBTTagCompound.hasKey("SkullOwner", 8) && nBTTagCompound.getString("SkullOwner").length() > 0) {
            GameProfile gameProfile = new GameProfile(null, nBTTagCompound.getString("SkullOwner"));
            gameProfile = TileEntitySkull.updateGameprofile(gameProfile);
            nBTTagCompound.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), gameProfile));
            return true;
        }
        return false;
    }
}

