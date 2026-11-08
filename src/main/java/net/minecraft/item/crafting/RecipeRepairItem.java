/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item.crafting;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeRepairItem
implements IRecipe {
    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world2) {
        ArrayList<ItemStack> arrayList = Lists.newArrayList();
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
            if (itemStack == null) continue;
            arrayList.add(itemStack);
            if (arrayList.size() <= 1) continue;
            ItemStack itemStack2 = (ItemStack)arrayList.get(0);
            if (itemStack.getItem() == itemStack2.getItem() && itemStack2.stackSize == 1 && itemStack.stackSize == 1 && itemStack2.getItem().isDamageable()) continue;
            return false;
        }
        return arrayList.size() == 2;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        Object object;
        ItemStack itemStack;
        ArrayList<ItemStack> arrayList = Lists.newArrayList();
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            itemStack = inventoryCrafting.getStackInSlot(i);
            if (itemStack == null) continue;
            arrayList.add(itemStack);
            if (arrayList.size() <= 1) continue;
            object = (ItemStack)arrayList.get(0);
            if (itemStack.getItem() == ((ItemStack)object).getItem() && ((ItemStack)object).stackSize == 1 && itemStack.stackSize == 1 && ((ItemStack)object).getItem().isDamageable()) continue;
            return null;
        }
        if (arrayList.size() == 2) {
            ItemStack itemStack2 = (ItemStack)arrayList.get(0);
            itemStack = (ItemStack)arrayList.get(1);
            if (itemStack2.getItem() == itemStack.getItem() && itemStack2.stackSize == 1 && itemStack.stackSize == 1 && itemStack2.getItem().isDamageable()) {
                object = itemStack2.getItem();
                int n = ((Item)object).getMaxDamage() - itemStack2.getItemDamage();
                int n2 = ((Item)object).getMaxDamage() - itemStack.getItemDamage();
                int n3 = n + n2 + ((Item)object).getMaxDamage() * 5 / 100;
                int n4 = ((Item)object).getMaxDamage() - n3;
                if (n4 < 0) {
                    n4 = 0;
                }
                return new ItemStack(itemStack2.getItem(), 1, n4);
            }
        }
        return null;
    }

    @Override
    public int getRecipeSize() {
        return 4;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inventoryCrafting) {
        ItemStack[] itemStackArray = new ItemStack[inventoryCrafting.getSizeInventory()];
        for (int i = 0; i < itemStackArray.length; ++i) {
            ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
            if (itemStack == null || !itemStack.getItem().hasContainerItem()) continue;
            itemStackArray[i] = new ItemStack(itemStack.getItem().getContainerItem());
        }
        return itemStackArray;
    }
}

