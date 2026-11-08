/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.world.World;

public class RecipesBanners {
    void addRecipes(CraftingManager craftingManager) {
        for (EnumDyeColor enumDyeColor : EnumDyeColor.values()) {
            craftingManager.addRecipe(new ItemStack(Items.banner, 1, enumDyeColor.getDyeDamage()), "###", "###", " | ", Character.valueOf('#'), new ItemStack(Blocks.wool, 1, enumDyeColor.getMetadata()), Character.valueOf('|'), Items.stick);
        }
        craftingManager.addRecipe(new RecipeDuplicatePattern());
        craftingManager.addRecipe(new RecipeAddPattern());
    }

    public static class RecipeDuplicatePattern
    implements IRecipe {
        private RecipeDuplicatePattern() {
        }

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world2) {
            ItemStack itemStack = null;
            ItemStack itemStack2 = null;
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                boolean bl;
                ItemStack itemStack3 = inventoryCrafting.getStackInSlot(i);
                if (itemStack3 == null) continue;
                if (itemStack3.getItem() != Items.banner) {
                    return false;
                }
                if (itemStack != null && itemStack2 != null) {
                    return false;
                }
                int n = TileEntityBanner.getBaseColor(itemStack3);
                boolean bl2 = bl = TileEntityBanner.getPatterns(itemStack3) > 0;
                if (itemStack != null) {
                    if (bl) {
                        return false;
                    }
                    if (n != TileEntityBanner.getBaseColor(itemStack)) {
                        return false;
                    }
                    itemStack2 = itemStack3;
                    continue;
                }
                if (itemStack2 != null) {
                    if (!bl) {
                        return false;
                    }
                    if (n != TileEntityBanner.getBaseColor(itemStack2)) {
                        return false;
                    }
                    itemStack = itemStack3;
                    continue;
                }
                if (bl) {
                    itemStack = itemStack3;
                    continue;
                }
                itemStack2 = itemStack3;
            }
            return itemStack != null && itemStack2 != null;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack == null || TileEntityBanner.getPatterns(itemStack) <= 0) continue;
                ItemStack itemStack2 = itemStack.copy();
                itemStack2.stackSize = 1;
                return itemStack2;
            }
            return null;
        }

        @Override
        public int getRecipeSize() {
            return 2;
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
                if (itemStack == null) continue;
                if (itemStack.getItem().hasContainerItem()) {
                    itemStackArray[i] = new ItemStack(itemStack.getItem().getContainerItem());
                    continue;
                }
                if (!itemStack.hasTagCompound() || TileEntityBanner.getPatterns(itemStack) <= 0) continue;
                itemStackArray[i] = itemStack.copy();
                itemStackArray[i].stackSize = 1;
            }
            return itemStackArray;
        }
    }

    public static class RecipeAddPattern
    implements IRecipe {
        private RecipeAddPattern() {
        }

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world2) {
            boolean bl = false;
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack == null || itemStack.getItem() != Items.banner) continue;
                if (bl) {
                    return false;
                }
                if (TileEntityBanner.getPatterns(itemStack) >= 6) {
                    return false;
                }
                bl = true;
            }
            if (!bl) {
                return false;
            }
            return this.func_179533_c(inventoryCrafting) != null;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            TileEntityBanner.EnumBannerPattern enumBannerPattern;
            ItemStack itemStack = null;
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
                if (itemStack2 == null || itemStack2.getItem() != Items.banner) continue;
                itemStack = itemStack2.copy();
                itemStack.stackSize = 1;
                break;
            }
            if ((enumBannerPattern = this.func_179533_c(inventoryCrafting)) != null) {
                Object object;
                int n = 0;
                for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                    object = inventoryCrafting.getStackInSlot(i);
                    if (object == null || ((ItemStack)object).getItem() != Items.dye) continue;
                    n = ((ItemStack)object).getMetadata();
                    break;
                }
                NBTTagCompound nBTTagCompound = itemStack.getSubCompound("BlockEntityTag", true);
                object = null;
                if (nBTTagCompound.hasKey("Patterns", 9)) {
                    object = nBTTagCompound.getTagList("Patterns", 10);
                } else {
                    object = new NBTTagList();
                    nBTTagCompound.setTag("Patterns", (NBTBase)object);
                }
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                nBTTagCompound2.setString("Pattern", enumBannerPattern.getPatternID());
                nBTTagCompound2.setInteger("Color", n);
                ((NBTTagList)object).appendTag(nBTTagCompound2);
            }
            return itemStack;
        }

        @Override
        public int getRecipeSize() {
            return 10;
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

        /*
         * Enabled aggressive block sorting
         */
        private TileEntityBanner.EnumBannerPattern func_179533_c(InventoryCrafting inventoryCrafting) {
            TileEntityBanner.EnumBannerPattern[] enumBannerPatternArray = TileEntityBanner.EnumBannerPattern.values();
            int n = enumBannerPatternArray.length;
            int n2 = 0;
            while (true) {
                block12: {
                    boolean bl;
                    TileEntityBanner.EnumBannerPattern enumBannerPattern;
                    block17: {
                        int n3;
                        int n4;
                        int n5;
                        block16: {
                            block14: {
                                block15: {
                                    block13: {
                                        if (n2 >= n) {
                                            return null;
                                        }
                                        enumBannerPattern = enumBannerPatternArray[n2];
                                        if (!enumBannerPattern.hasValidCrafting()) break block12;
                                        bl = true;
                                        if (!enumBannerPattern.hasCraftingStack()) break block13;
                                        n5 = 0;
                                        n4 = 0;
                                        break block14;
                                    }
                                    if (inventoryCrafting.getSizeInventory() != enumBannerPattern.getCraftingLayers().length * enumBannerPattern.getCraftingLayers()[0].length()) break block15;
                                    n5 = -1;
                                    break block16;
                                }
                                bl = false;
                                break block17;
                            }
                            for (n3 = 0; n3 < inventoryCrafting.getSizeInventory() && bl; ++n3) {
                                ItemStack itemStack = inventoryCrafting.getStackInSlot(n3);
                                if (itemStack == null || itemStack.getItem() == Items.banner) continue;
                                if (itemStack.getItem() == Items.dye) {
                                    if (n4 != 0) {
                                        bl = false;
                                        break;
                                    }
                                    n4 = 1;
                                    continue;
                                }
                                if (n5 != 0 || !itemStack.isItemEqual(enumBannerPattern.getCraftingStack())) {
                                    bl = false;
                                    break;
                                }
                                n5 = 1;
                            }
                            if (n5 != 0) break block17;
                            bl = false;
                            break block17;
                        }
                        for (n4 = 0; n4 < inventoryCrafting.getSizeInventory() && bl; ++n4) {
                            n3 = n4 / 3;
                            int n6 = n4 % 3;
                            ItemStack itemStack = inventoryCrafting.getStackInSlot(n4);
                            if (itemStack != null && itemStack.getItem() != Items.banner) {
                                if (itemStack.getItem() != Items.dye) {
                                    bl = false;
                                    break;
                                }
                                if (n5 != -1 && n5 != itemStack.getMetadata()) {
                                    bl = false;
                                    break;
                                }
                                if (enumBannerPattern.getCraftingLayers()[n3].charAt(n6) == ' ') {
                                    bl = false;
                                    break;
                                }
                                n5 = itemStack.getMetadata();
                                continue;
                            }
                            if (enumBannerPattern.getCraftingLayers()[n3].charAt(n6) == ' ') continue;
                            bl = false;
                            break;
                        }
                    }
                    if (bl) {
                        return enumBannerPattern;
                    }
                }
                ++n2;
            }
        }
    }
}

