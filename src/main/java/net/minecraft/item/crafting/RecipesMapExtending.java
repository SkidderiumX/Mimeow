/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item.crafting;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class RecipesMapExtending
extends ShapedRecipes {
    public RecipesMapExtending() {
        super(3, 3, new ItemStack[]{new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.filled_map, 0, Short.MAX_VALUE), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper)}, new ItemStack(Items.map, 0, 0));
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world2) {
        if (!super.matches(inventoryCrafting, world2)) {
            return false;
        }
        ItemStack itemStack = null;
        for (int i = 0; i < inventoryCrafting.getSizeInventory() && itemStack == null; ++i) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
            if (itemStack2 == null || itemStack2.getItem() != Items.filled_map) continue;
            itemStack = itemStack2;
        }
        if (itemStack == null) {
            return false;
        }
        MapData mapData = Items.filled_map.getMapData(itemStack, world2);
        return mapData == null ? false : mapData.scale < 4;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        ItemStack itemStack = null;
        for (int i = 0; i < inventoryCrafting.getSizeInventory() && itemStack == null; ++i) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
            if (itemStack2 == null || itemStack2.getItem() != Items.filled_map) continue;
            itemStack = itemStack2;
        }
        itemStack = itemStack.copy();
        itemStack.stackSize = 1;
        if (itemStack.getTagCompound() == null) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
        itemStack.getTagCompound().setBoolean("map_is_scaling", true);
        return itemStack;
    }
}

