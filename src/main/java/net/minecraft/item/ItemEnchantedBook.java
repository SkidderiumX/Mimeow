/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.WeightedRandomChestContent;

public class ItemEnchantedBook
extends Item {
    @Override
    public boolean hasEffect(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean isItemTool(ItemStack itemStack) {
        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        return this.getEnchantments(itemStack).tagCount() > 0 ? EnumRarity.UNCOMMON : super.getRarity(itemStack);
    }

    public NBTTagList getEnchantments(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
        return nBTTagCompound != null && nBTTagCompound.hasKey("StoredEnchantments", 9) ? (NBTTagList)nBTTagCompound.getTag("StoredEnchantments") : new NBTTagList();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list, boolean bl) {
        super.addInformation(itemStack, entityPlayer, list, bl);
        NBTTagList nBTTagList = this.getEnchantments(itemStack);
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                short s = nBTTagList.getCompoundTagAt(i).getShort("id");
                short s2 = nBTTagList.getCompoundTagAt(i).getShort("lvl");
                if (Enchantment.getEnchantmentById(s) == null) continue;
                list.add(Enchantment.getEnchantmentById(s).getTranslatedName(s2));
            }
        }
    }

    public void addEnchantment(ItemStack itemStack, EnchantmentData enchantmentData) {
        NBTTagList nBTTagList = this.getEnchantments(itemStack);
        boolean bl = true;
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
            if (nBTTagCompound.getShort("id") != enchantmentData.enchantmentobj.effectId) continue;
            if (nBTTagCompound.getShort("lvl") < enchantmentData.enchantmentLevel) {
                nBTTagCompound.setShort("lvl", (short)enchantmentData.enchantmentLevel);
            }
            bl = false;
            break;
        }
        if (bl) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setShort("id", (short)enchantmentData.enchantmentobj.effectId);
            nBTTagCompound.setShort("lvl", (short)enchantmentData.enchantmentLevel);
            nBTTagList.appendTag(nBTTagCompound);
        }
        if (!itemStack.hasTagCompound()) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
        itemStack.getTagCompound().setTag("StoredEnchantments", nBTTagList);
    }

    public ItemStack getEnchantedItemStack(EnchantmentData enchantmentData) {
        ItemStack itemStack = new ItemStack(this);
        this.addEnchantment(itemStack, enchantmentData);
        return itemStack;
    }

    public void getAll(Enchantment enchantment, List<ItemStack> list) {
        for (int i = enchantment.getMinLevel(); i <= enchantment.getMaxLevel(); ++i) {
            list.add(this.getEnchantedItemStack(new EnchantmentData(enchantment, i)));
        }
    }

    public WeightedRandomChestContent getRandom(Random random) {
        return this.getRandom(random, 1, 1, 1);
    }

    public WeightedRandomChestContent getRandom(Random random, int n, int n2, int n3) {
        ItemStack itemStack = new ItemStack(Items.book, 1, 0);
        EnchantmentHelper.addRandomEnchantment(random, itemStack, 30);
        return new WeightedRandomChestContent(itemStack, n, n2, n3);
    }
}

