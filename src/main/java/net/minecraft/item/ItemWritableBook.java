/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemWritableBook
extends Item {
    public ItemWritableBook() {
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        entityPlayer.displayGUIBook(itemStack);
        entityPlayer.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return itemStack;
    }

    public static boolean isNBTValid(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound == null) {
            return false;
        }
        if (!nBTTagCompound.hasKey("pages", 9)) {
            return false;
        }
        NBTTagList nBTTagList = nBTTagCompound.getTagList("pages", 8);
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            String string = nBTTagList.getStringTagAt(i);
            if (string == null) {
                return false;
            }
            if (string.length() <= Short.MAX_VALUE) continue;
            return false;
        }
        return true;
    }
}

