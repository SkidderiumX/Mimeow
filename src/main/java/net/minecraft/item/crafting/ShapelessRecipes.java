/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item.crafting;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ShapelessRecipes
implements IRecipe {
    private final ItemStack recipeOutput;
    private final List<ItemStack> recipeItems;

    public ShapelessRecipes(ItemStack itemStack, List<ItemStack> list) {
        this.recipeOutput = itemStack;
        this.recipeItems = list;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
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

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world2) {
        ArrayList<ItemStack> arrayList = Lists.newArrayList(this.recipeItems);
        for (int i = 0; i < inventoryCrafting.getHeight(); ++i) {
            for (int j = 0; j < inventoryCrafting.getWidth(); ++j) {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(j, i);
                if (itemStack == null) continue;
                boolean bl = false;
                for (ItemStack itemStack2 : arrayList) {
                    if (itemStack.getItem() != itemStack2.getItem() || itemStack2.getMetadata() != Short.MAX_VALUE && itemStack.getMetadata() != itemStack2.getMetadata()) continue;
                    bl = true;
                    arrayList.remove(itemStack2);
                    break;
                }
                if (bl) continue;
                return false;
            }
        }
        return arrayList.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return this.recipeOutput.copy();
    }

    @Override
    public int getRecipeSize() {
        return this.recipeItems.size();
    }
}

