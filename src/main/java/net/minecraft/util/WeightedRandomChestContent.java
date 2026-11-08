/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.WeightedRandom;

public class WeightedRandomChestContent
extends WeightedRandom.Item {
    private ItemStack theItemId;
    private int minStackSize;
    private int maxStackSize;

    public WeightedRandomChestContent(Item item, int n, int n2, int n3, int n4) {
        super(n4);
        this.theItemId = new ItemStack(item, 1, n);
        this.minStackSize = n2;
        this.maxStackSize = n3;
    }

    public WeightedRandomChestContent(ItemStack itemStack, int n, int n2, int n3) {
        super(n3);
        this.theItemId = itemStack;
        this.minStackSize = n;
        this.maxStackSize = n2;
    }

    public static void generateChestContents(Random random, List<WeightedRandomChestContent> list, IInventory iInventory, int n) {
        for (int i = 0; i < n; ++i) {
            WeightedRandomChestContent weightedRandomChestContent = WeightedRandom.getRandomItem(random, list);
            int n2 = weightedRandomChestContent.minStackSize + random.nextInt(weightedRandomChestContent.maxStackSize - weightedRandomChestContent.minStackSize + 1);
            if (weightedRandomChestContent.theItemId.getMaxStackSize() >= n2) {
                ItemStack itemStack = weightedRandomChestContent.theItemId.copy();
                itemStack.stackSize = n2;
                iInventory.setInventorySlotContents(random.nextInt(iInventory.getSizeInventory()), itemStack);
                continue;
            }
            for (int j = 0; j < n2; ++j) {
                ItemStack itemStack = weightedRandomChestContent.theItemId.copy();
                itemStack.stackSize = 1;
                iInventory.setInventorySlotContents(random.nextInt(iInventory.getSizeInventory()), itemStack);
            }
        }
    }

    public static void generateDispenserContents(Random random, List<WeightedRandomChestContent> list, TileEntityDispenser tileEntityDispenser, int n) {
        for (int i = 0; i < n; ++i) {
            WeightedRandomChestContent weightedRandomChestContent = WeightedRandom.getRandomItem(random, list);
            int n2 = weightedRandomChestContent.minStackSize + random.nextInt(weightedRandomChestContent.maxStackSize - weightedRandomChestContent.minStackSize + 1);
            if (weightedRandomChestContent.theItemId.getMaxStackSize() >= n2) {
                ItemStack itemStack = weightedRandomChestContent.theItemId.copy();
                itemStack.stackSize = n2;
                tileEntityDispenser.setInventorySlotContents(random.nextInt(tileEntityDispenser.getSizeInventory()), itemStack);
                continue;
            }
            for (int j = 0; j < n2; ++j) {
                ItemStack itemStack = weightedRandomChestContent.theItemId.copy();
                itemStack.stackSize = 1;
                tileEntityDispenser.setInventorySlotContents(random.nextInt(tileEntityDispenser.getSizeInventory()), itemStack);
            }
        }
    }

    public static List<WeightedRandomChestContent> func_177629_a(List<WeightedRandomChestContent> list, WeightedRandomChestContent ... weightedRandomChestContentArray) {
        ArrayList<WeightedRandomChestContent> arrayList = Lists.newArrayList(list);
        Collections.addAll(arrayList, weightedRandomChestContentArray);
        return arrayList;
    }
}

