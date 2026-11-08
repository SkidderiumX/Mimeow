/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item.crafting;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class RecipeFireworks
implements IRecipe {
    private ItemStack field_92102_a;

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world2) {
        Object object;
        this.field_92102_a = null;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            object = inventoryCrafting.getStackInSlot(i);
            if (object == null) continue;
            if (((ItemStack)object).getItem() == Items.gunpowder) {
                ++n2;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.firework_charge) {
                ++n4;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.dye) {
                ++n3;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.paper) {
                ++n;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.glowstone_dust) {
                ++n5;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.diamond) {
                ++n5;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.fire_charge) {
                ++n6;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.feather) {
                ++n6;
                continue;
            }
            if (((ItemStack)object).getItem() == Items.gold_nugget) {
                ++n6;
                continue;
            }
            if (((ItemStack)object).getItem() != Items.skull) {
                return false;
            }
            ++n6;
        }
        n5 = n5 + n3 + n6;
        if (n2 <= 3 && n <= 1) {
            if (n2 >= 1 && n == 1 && n5 == 0) {
                this.field_92102_a = new ItemStack(Items.fireworks);
                if (n4 > 0) {
                    NBTTagCompound nBTTagCompound = new NBTTagCompound();
                    object = new NBTTagCompound();
                    NBTTagList nBTTagList = new NBTTagList();
                    for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                        ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                        if (itemStack == null || itemStack.getItem() != Items.firework_charge || !itemStack.hasTagCompound() || !itemStack.getTagCompound().hasKey("Explosion", 10)) continue;
                        nBTTagList.appendTag(itemStack.getTagCompound().getCompoundTag("Explosion"));
                    }
                    ((NBTTagCompound)object).setTag("Explosions", nBTTagList);
                    ((NBTTagCompound)object).setByte("Flight", (byte)n2);
                    nBTTagCompound.setTag("Fireworks", (NBTBase)object);
                    this.field_92102_a.setTagCompound(nBTTagCompound);
                }
                return true;
            }
            if (n2 == 1 && n == 0 && n4 == 0 && n3 > 0 && n6 <= 1) {
                this.field_92102_a = new ItemStack(Items.firework_charge);
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                object = new NBTTagCompound();
                int n7 = 0;
                ArrayList<Integer> arrayList = Lists.newArrayList();
                for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                    ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                    if (itemStack == null) continue;
                    if (itemStack.getItem() == Items.dye) {
                        arrayList.add(ItemDye.dyeColors[itemStack.getMetadata() & 0xF]);
                        continue;
                    }
                    if (itemStack.getItem() == Items.glowstone_dust) {
                        ((NBTTagCompound)object).setBoolean("Flicker", true);
                        continue;
                    }
                    if (itemStack.getItem() == Items.diamond) {
                        ((NBTTagCompound)object).setBoolean("Trail", true);
                        continue;
                    }
                    if (itemStack.getItem() == Items.fire_charge) {
                        n7 = 1;
                        continue;
                    }
                    if (itemStack.getItem() == Items.feather) {
                        n7 = 4;
                        continue;
                    }
                    if (itemStack.getItem() == Items.gold_nugget) {
                        n7 = 2;
                        continue;
                    }
                    if (itemStack.getItem() != Items.skull) continue;
                    n7 = 3;
                }
                int[] nArray = new int[arrayList.size()];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = (Integer)arrayList.get(i);
                }
                ((NBTTagCompound)object).setIntArray("Colors", nArray);
                ((NBTTagCompound)object).setByte("Type", (byte)n7);
                nBTTagCompound.setTag("Explosion", (NBTBase)object);
                this.field_92102_a.setTagCompound(nBTTagCompound);
                return true;
            }
            if (n2 == 0 && n == 0 && n4 == 1 && n3 > 0 && n3 == n5) {
                ArrayList<Integer> arrayList = Lists.newArrayList();
                for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                    ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                    if (itemStack == null) continue;
                    if (itemStack.getItem() == Items.dye) {
                        arrayList.add(ItemDye.dyeColors[itemStack.getMetadata() & 0xF]);
                        continue;
                    }
                    if (itemStack.getItem() != Items.firework_charge) continue;
                    this.field_92102_a = itemStack.copy();
                    this.field_92102_a.stackSize = 1;
                }
                int[] nArray = new int[arrayList.size()];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = (Integer)arrayList.get(i);
                }
                if (this.field_92102_a != null && this.field_92102_a.hasTagCompound()) {
                    NBTTagCompound nBTTagCompound = this.field_92102_a.getTagCompound().getCompoundTag("Explosion");
                    if (nBTTagCompound == null) {
                        return false;
                    }
                    nBTTagCompound.setIntArray("FadeColors", nArray);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return this.field_92102_a.copy();
    }

    @Override
    public int getRecipeSize() {
        return 10;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.field_92102_a;
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

