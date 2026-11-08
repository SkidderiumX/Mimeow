/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class InventoryBasic
implements IInventory {
    private String inventoryTitle;
    private int slotsCount;
    private ItemStack[] inventoryContents;
    private List<IInvBasic> changeListeners;
    private boolean hasCustomName;

    public InventoryBasic(String string, boolean bl, int n) {
        this.inventoryTitle = string;
        this.hasCustomName = bl;
        this.slotsCount = n;
        this.inventoryContents = new ItemStack[n];
    }

    public InventoryBasic(IChatComponent iChatComponent, int n) {
        this(iChatComponent.getUnformattedText(), true, n);
    }

    public void addInventoryChangeListener(IInvBasic iInvBasic) {
        if (this.changeListeners == null) {
            this.changeListeners = Lists.newArrayList();
        }
        this.changeListeners.add(iInvBasic);
    }

    public void removeInventoryChangeListener(IInvBasic iInvBasic) {
        this.changeListeners.remove(iInvBasic);
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return n >= 0 && n < this.inventoryContents.length ? this.inventoryContents[n] : null;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.inventoryContents[n] != null) {
            if (this.inventoryContents[n].stackSize <= n2) {
                ItemStack itemStack = this.inventoryContents[n];
                this.inventoryContents[n] = null;
                this.markDirty();
                return itemStack;
            }
            ItemStack itemStack = this.inventoryContents[n].splitStack(n2);
            if (this.inventoryContents[n].stackSize == 0) {
                this.inventoryContents[n] = null;
            }
            this.markDirty();
            return itemStack;
        }
        return null;
    }

    public ItemStack func_174894_a(ItemStack itemStack) {
        ItemStack itemStack2 = itemStack.copy();
        for (int i = 0; i < this.slotsCount; ++i) {
            int n;
            int n2;
            ItemStack itemStack3 = this.getStackInSlot(i);
            if (itemStack3 == null) {
                this.setInventorySlotContents(i, itemStack2);
                this.markDirty();
                return null;
            }
            if (!ItemStack.areItemsEqual(itemStack3, itemStack2) || (n2 = Math.min(itemStack2.stackSize, (n = Math.min(this.getInventoryStackLimit(), itemStack3.getMaxStackSize())) - itemStack3.stackSize)) <= 0) continue;
            itemStack3.stackSize += n2;
            itemStack2.stackSize -= n2;
            if (itemStack2.stackSize > 0) continue;
            this.markDirty();
            return null;
        }
        if (itemStack2.stackSize != itemStack.stackSize) {
            this.markDirty();
        }
        return itemStack2;
    }

    @Override
    public ItemStack removeStackFromSlot(int n) {
        if (this.inventoryContents[n] != null) {
            ItemStack itemStack = this.inventoryContents[n];
            this.inventoryContents[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.inventoryContents[n] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }

    @Override
    public int getSizeInventory() {
        return this.slotsCount;
    }

    @Override
    public String getName() {
        return this.inventoryTitle;
    }

    @Override
    public boolean hasCustomName() {
        return this.hasCustomName;
    }

    public void setCustomName(String string) {
        this.hasCustomName = true;
        this.inventoryTitle = string;
    }

    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
        if (this.changeListeners != null) {
            for (int i = 0; i < this.changeListeners.size(); ++i) {
                this.changeListeners.get(i).onInventoryChanged(this);
            }
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
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
        for (int i = 0; i < this.inventoryContents.length; ++i) {
            this.inventoryContents[i] = null;
        }
    }
}

