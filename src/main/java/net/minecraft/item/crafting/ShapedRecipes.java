/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ShapedRecipes
implements IRecipe {
    private final int recipeWidth;
    private final int recipeHeight;
    private final ItemStack[] recipeItems;
    private final ItemStack recipeOutput;
    private boolean copyIngredientNBT;

    public ShapedRecipes(int n, int n2, ItemStack[] itemStackArray, ItemStack itemStack) {
        this.recipeWidth = n;
        this.recipeHeight = n2;
        this.recipeItems = itemStackArray;
        this.recipeOutput = itemStack;
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
        for (int i = 0; i <= 3 - this.recipeWidth; ++i) {
            for (int j = 0; j <= 3 - this.recipeHeight; ++j) {
                if (this.checkMatch(inventoryCrafting, i, j, true)) {
                    return true;
                }
                if (!this.checkMatch(inventoryCrafting, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean checkMatch(InventoryCrafting inventoryCrafting, int n, int n2, boolean bl) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack;
                int n3 = i - n;
                int n4 = j - n2;
                ItemStack itemStack2 = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this.recipeWidth && n4 < this.recipeHeight) {
                    itemStack2 = bl ? this.recipeItems[this.recipeWidth - n3 - 1 + n4 * this.recipeWidth] : this.recipeItems[n3 + n4 * this.recipeWidth];
                }
                if ((itemStack = inventoryCrafting.getStackInRowAndColumn(i, j)) == null && itemStack2 == null) continue;
                if (itemStack == null && itemStack2 != null || itemStack != null && itemStack2 == null) {
                    return false;
                }
                if (itemStack2.getItem() != itemStack.getItem()) {
                    return false;
                }
                if (itemStack2.getMetadata() == Short.MAX_VALUE || itemStack2.getMetadata() == itemStack.getMetadata()) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        ItemStack itemStack = this.getRecipeOutput().copy();
        if (this.copyIngredientNBT) {
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
                if (itemStack2 == null || !itemStack2.hasTagCompound()) continue;
                itemStack.setTagCompound((NBTTagCompound)itemStack2.getTagCompound().copy());
            }
        }
        return itemStack;
    }

    @Override
    public int getRecipeSize() {
        return this.recipeWidth * this.recipeHeight;
    }
}

