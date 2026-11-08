/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ReportedException;
import x.oc718fd4d503;

public class InventoryPlayer
implements IInventory {
    public ItemStack[] mainInventory = new ItemStack[36];
    public ItemStack[] armorInventory = new ItemStack[4];
    public int currentItem;
    public EntityPlayer player;
    private ItemStack itemStack;
    public boolean inventoryChanged;

    public InventoryPlayer(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
    }

    public ItemStack getCurrentItem() {
        int n = oc718fd4d503.\u014c.\u0548(this);
        return n < 9 && n >= 0 ? this.mainInventory[n] : null;
    }

    public static int getHotbarSize() {
        return 9;
    }

    private int getInventorySlotContainItem(Item item) {
        for (int i = 0; i < this.mainInventory.length; ++i) {
            if (this.mainInventory[i] == null || this.mainInventory[i].getItem() != item) continue;
            return i;
        }
        return -1;
    }

    private int getInventorySlotContainItemAndDamage(Item item, int n) {
        for (int i = 0; i < this.mainInventory.length; ++i) {
            if (this.mainInventory[i] == null || this.mainInventory[i].getItem() != item || this.mainInventory[i].getMetadata() != n) continue;
            return i;
        }
        return -1;
    }

    private int storeItemStack(ItemStack itemStack) {
        for (int i = 0; i < this.mainInventory.length; ++i) {
            if (this.mainInventory[i] == null || this.mainInventory[i].getItem() != itemStack.getItem() || !this.mainInventory[i].isStackable() || this.mainInventory[i].stackSize >= this.mainInventory[i].getMaxStackSize() || this.mainInventory[i].stackSize >= this.getInventoryStackLimit() || this.mainInventory[i].getHasSubtypes() && this.mainInventory[i].getMetadata() != itemStack.getMetadata() || !ItemStack.areItemStackTagsEqual(this.mainInventory[i], itemStack)) continue;
            return i;
        }
        return -1;
    }

    public int getFirstEmptyStack() {
        for (int i = 0; i < this.mainInventory.length; ++i) {
            if (this.mainInventory[i] != null) continue;
            return i;
        }
        return -1;
    }

    public void setCurrentItem(Item item, int n, boolean bl, boolean bl2) {
        int n2;
        ItemStack itemStack = this.getCurrentItem();
        int n3 = n2 = bl ? this.getInventorySlotContainItemAndDamage(item, n) : this.getInventorySlotContainItem(item);
        if (n2 >= 0 && n2 < 9) {
            this.currentItem = n2;
        } else if (bl2 && item != null) {
            int n4 = this.getFirstEmptyStack();
            if (n4 >= 0 && n4 < 9) {
                this.currentItem = n4;
            }
            if (itemStack == null || !itemStack.isItemEnchantable() || this.getInventorySlotContainItemAndDamage(itemStack.getItem(), itemStack.getItemDamage()) != this.currentItem) {
                int n5;
                int n6 = this.getInventorySlotContainItemAndDamage(item, n);
                if (n6 >= 0) {
                    n5 = this.mainInventory[n6].stackSize;
                    this.mainInventory[n6] = this.mainInventory[this.currentItem];
                } else {
                    n5 = 1;
                }
                this.mainInventory[this.currentItem] = new ItemStack(item, n5, n);
            }
        }
    }

    public void changeCurrentItem(int n) {
        if (n > 0) {
            n = 1;
        }
        if (n < 0) {
            n = -1;
        }
        this.currentItem -= n;
        while (this.currentItem < 0) {
            this.currentItem += 9;
        }
        while (this.currentItem >= 9) {
            this.currentItem -= 9;
        }
    }

    public int clearMatchingItems(Item item, int n, int n2, NBTTagCompound nBTTagCompound) {
        int n3;
        ItemStack itemStack;
        int n4;
        int n5 = 0;
        for (n4 = 0; n4 < this.mainInventory.length; ++n4) {
            itemStack = this.mainInventory[n4];
            if (itemStack == null || item != null && itemStack.getItem() != item || n > -1 && itemStack.getMetadata() != n || nBTTagCompound != null && !NBTUtil.func_181123_a(nBTTagCompound, itemStack.getTagCompound(), true)) continue;
            n3 = n2 <= 0 ? itemStack.stackSize : Math.min(n2 - n5, itemStack.stackSize);
            n5 += n3;
            if (n2 == 0) continue;
            this.mainInventory[n4].stackSize -= n3;
            if (this.mainInventory[n4].stackSize == 0) {
                this.mainInventory[n4] = null;
            }
            if (n2 <= 0 || n5 < n2) continue;
            return n5;
        }
        for (n4 = 0; n4 < this.armorInventory.length; ++n4) {
            itemStack = this.armorInventory[n4];
            if (itemStack == null || item != null && itemStack.getItem() != item || n > -1 && itemStack.getMetadata() != n || nBTTagCompound != null && !NBTUtil.func_181123_a(nBTTagCompound, itemStack.getTagCompound(), false)) continue;
            n3 = n2 <= 0 ? itemStack.stackSize : Math.min(n2 - n5, itemStack.stackSize);
            n5 += n3;
            if (n2 == 0) continue;
            this.armorInventory[n4].stackSize -= n3;
            if (this.armorInventory[n4].stackSize == 0) {
                this.armorInventory[n4] = null;
            }
            if (n2 <= 0 || n5 < n2) continue;
            return n5;
        }
        if (this.itemStack != null) {
            if (item != null && this.itemStack.getItem() != item) {
                return n5;
            }
            if (n > -1 && this.itemStack.getMetadata() != n) {
                return n5;
            }
            if (nBTTagCompound != null && !NBTUtil.func_181123_a(nBTTagCompound, this.itemStack.getTagCompound(), false)) {
                return n5;
            }
            n4 = n2 <= 0 ? this.itemStack.stackSize : Math.min(n2 - n5, this.itemStack.stackSize);
            n5 += n4;
            if (n2 != 0) {
                this.itemStack.stackSize -= n4;
                if (this.itemStack.stackSize == 0) {
                    this.itemStack = null;
                }
                if (n2 > 0 && n5 >= n2) {
                    return n5;
                }
            }
        }
        return n5;
    }

    private int storePartialItemStack(ItemStack itemStack) {
        Item item = itemStack.getItem();
        int n = itemStack.stackSize;
        int n2 = this.storeItemStack(itemStack);
        if (n2 < 0) {
            n2 = this.getFirstEmptyStack();
        }
        if (n2 < 0) {
            return n;
        }
        if (this.mainInventory[n2] == null) {
            this.mainInventory[n2] = new ItemStack(item, 0, itemStack.getMetadata());
            if (itemStack.hasTagCompound()) {
                this.mainInventory[n2].setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
            }
        }
        int n3 = n;
        if (n > this.mainInventory[n2].getMaxStackSize() - this.mainInventory[n2].stackSize) {
            n3 = this.mainInventory[n2].getMaxStackSize() - this.mainInventory[n2].stackSize;
        }
        if (n3 > this.getInventoryStackLimit() - this.mainInventory[n2].stackSize) {
            n3 = this.getInventoryStackLimit() - this.mainInventory[n2].stackSize;
        }
        if (n3 == 0) {
            return n;
        }
        this.mainInventory[n2].stackSize += n3;
        this.mainInventory[n2].animationsToGo = 5;
        return n -= n3;
    }

    public void decrementAnimations() {
        int n = oc718fd4d503.\u014c.\u0548(this);
        for (int i = 0; i < this.mainInventory.length; ++i) {
            if (this.mainInventory[i] == null) continue;
            this.mainInventory[i].updateAnimation(this.player.worldObj, this.player, i, n == i);
        }
    }

    public boolean consumeInventoryItem(Item item) {
        int n = this.getInventorySlotContainItem(item);
        if (n < 0) {
            return false;
        }
        if (--this.mainInventory[n].stackSize <= 0) {
            this.mainInventory[n] = null;
        }
        return true;
    }

    public boolean hasItem(Item item) {
        int n = this.getInventorySlotContainItem(item);
        return n >= 0;
    }

    public boolean addItemStackToInventory(final ItemStack itemStack) {
        if (itemStack != null && itemStack.stackSize != 0 && itemStack.getItem() != null) {
            try {
                int n;
                if (itemStack.isItemDamaged()) {
                    int n2 = this.getFirstEmptyStack();
                    if (n2 >= 0) {
                        this.mainInventory[n2] = ItemStack.copyItemStack(itemStack);
                        this.mainInventory[n2].animationsToGo = 5;
                        itemStack.stackSize = 0;
                        return true;
                    }
                    if (this.player.capabilities.isCreativeMode) {
                        itemStack.stackSize = 0;
                        return true;
                    }
                    return false;
                }
                do {
                    n = itemStack.stackSize;
                    itemStack.stackSize = this.storePartialItemStack(itemStack);
                } while (itemStack.stackSize > 0 && itemStack.stackSize < n);
                if (itemStack.stackSize == n && this.player.capabilities.isCreativeMode) {
                    itemStack.stackSize = 0;
                    return true;
                }
                return itemStack.stackSize < n;
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Adding item to inventory");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Item being added");
                crashReportCategory.addCrashSection("Item ID", Item.getIdFromItem(itemStack.getItem()));
                crashReportCategory.addCrashSection("Item data", itemStack.getMetadata());
                crashReportCategory.addCrashSectionCallable("Item name", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return itemStack.getDisplayName();
                    }
                });
                throw new ReportedException(crashReport);
            }
        }
        return false;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (n >= this.mainInventory.length) {
            itemStackArray = this.armorInventory;
            n -= this.mainInventory.length;
        }
        if (itemStackArray[n] != null) {
            if (itemStackArray[n].stackSize <= n2) {
                ItemStack itemStack = itemStackArray[n];
                itemStackArray[n] = null;
                return itemStack;
            }
            ItemStack itemStack = itemStackArray[n].splitStack(n2);
            if (itemStackArray[n].stackSize == 0) {
                itemStackArray[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int n) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (n >= this.mainInventory.length) {
            itemStackArray = this.armorInventory;
            n -= this.mainInventory.length;
        }
        if (itemStackArray[n] != null) {
            ItemStack itemStack = itemStackArray[n];
            itemStackArray[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (n >= itemStackArray.length) {
            n -= itemStackArray.length;
            itemStackArray = this.armorInventory;
        }
        itemStackArray[n] = itemStack;
    }

    public float getStrVsBlock(Block block) {
        float f = 1.0f;
        int n = oc718fd4d503.\u014c.\u0548(this);
        if (this.mainInventory[n] != null) {
            f *= this.mainInventory[n].getStrVsBlock(block);
        }
        return f;
    }

    public NBTTagList writeToNBT(NBTTagList nBTTagList) {
        NBTTagCompound nBTTagCompound;
        int n;
        for (n = 0; n < this.mainInventory.length; ++n) {
            if (this.mainInventory[n] == null) continue;
            nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setByte("Slot", (byte)n);
            this.mainInventory[n].writeToNBT(nBTTagCompound);
            nBTTagList.appendTag(nBTTagCompound);
        }
        for (n = 0; n < this.armorInventory.length; ++n) {
            if (this.armorInventory[n] == null) continue;
            nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setByte("Slot", (byte)(n + 100));
            this.armorInventory[n].writeToNBT(nBTTagCompound);
            nBTTagList.appendTag(nBTTagCompound);
        }
        return nBTTagList;
    }

    public void readFromNBT(NBTTagList nBTTagList) {
        this.mainInventory = new ItemStack[36];
        this.armorInventory = new ItemStack[4];
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
            int n = nBTTagCompound.getByte("Slot") & 0xFF;
            ItemStack itemStack = ItemStack.loadItemStackFromNBT(nBTTagCompound);
            if (itemStack == null) continue;
            if (n >= 0 && n < this.mainInventory.length) {
                this.mainInventory[n] = itemStack;
            }
            if (n < 100 || n >= this.armorInventory.length + 100) continue;
            this.armorInventory[n - 100] = itemStack;
        }
    }

    @Override
    public int getSizeInventory() {
        return this.mainInventory.length + 4;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (n >= itemStackArray.length) {
            n -= itemStackArray.length;
            itemStackArray = this.armorInventory;
        }
        return itemStackArray[n];
    }

    @Override
    public String getName() {
        return "container.inventory";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean canHeldItemHarvest(Block block) {
        if (block.getMaterial().isToolNotRequired()) {
            return true;
        }
        ItemStack itemStack = this.getStackInSlot(oc718fd4d503.\u014c.\u0548(this));
        return itemStack != null ? itemStack.canHarvestBlock(block) : false;
    }

    public ItemStack armorItemInSlot(int n) {
        return this.armorInventory[n];
    }

    public int getTotalArmorValue() {
        int n = 0;
        for (int i = 0; i < this.armorInventory.length; ++i) {
            if (this.armorInventory[i] == null || !(this.armorInventory[i].getItem() instanceof ItemArmor)) continue;
            int n2 = ((ItemArmor)this.armorInventory[i].getItem()).damageReduceAmount;
            n += n2;
        }
        return n;
    }

    public void damageArmor(float f) {
        if ((f /= 4.0f) < 1.0f) {
            f = 1.0f;
        }
        for (int i = 0; i < this.armorInventory.length; ++i) {
            if (this.armorInventory[i] == null || !(this.armorInventory[i].getItem() instanceof ItemArmor)) continue;
            this.armorInventory[i].damageItem((int)f, this.player);
            if (this.armorInventory[i].stackSize != 0) continue;
            this.armorInventory[i] = null;
        }
    }

    public void dropAllItems() {
        int n;
        for (n = 0; n < this.mainInventory.length; ++n) {
            if (this.mainInventory[n] == null) continue;
            this.player.dropItem(this.mainInventory[n], true, false);
            this.mainInventory[n] = null;
        }
        for (n = 0; n < this.armorInventory.length; ++n) {
            if (this.armorInventory[n] == null) continue;
            this.player.dropItem(this.armorInventory[n], true, false);
            this.armorInventory[n] = null;
        }
    }

    @Override
    public void markDirty() {
        this.inventoryChanged = true;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.player.isDead ? false : entityPlayer.getDistanceSqToEntity(this.player) <= 64.0;
    }

    public boolean hasItemStack(ItemStack itemStack) {
        int n;
        for (n = 0; n < this.armorInventory.length; ++n) {
            if (this.armorInventory[n] == null || !this.armorInventory[n].isItemEqual(itemStack)) continue;
            return true;
        }
        for (n = 0; n < this.mainInventory.length; ++n) {
            if (this.mainInventory[n] == null || !this.mainInventory[n].isItemEqual(itemStack)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void openInventory(EntityPlayer entityPlayer) {
    }

    @Override
    public void closeInventory(EntityPlayer entityPlayer) {
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }

    public void copyInventory(InventoryPlayer inventoryPlayer) {
        int n;
        for (n = 0; n < this.mainInventory.length; ++n) {
            this.mainInventory[n] = ItemStack.copyItemStack(inventoryPlayer.mainInventory[n]);
        }
        for (n = 0; n < this.armorInventory.length; ++n) {
            this.armorInventory[n] = ItemStack.copyItemStack(inventoryPlayer.armorInventory[n]);
        }
        this.currentItem = inventoryPlayer.currentItem;
    }

    @Override
    public int getField(int n) {
        return 0;
    }

    @Override
    public void setField(int n, int n2) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        int n;
        for (n = 0; n < this.mainInventory.length; ++n) {
            this.mainInventory[n] = null;
        }
        for (n = 0; n < this.armorInventory.length; ++n) {
            this.armorInventory[n] = null;
        }
    }
}

