/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class Slot {
    private final int slotIndex;
    public final IInventory inventory;
    public int slotNumber;
    public int xDisplayPosition;
    public int yDisplayPosition;

    public Slot(IInventory iInventory, int n, int n2, int n3) {
        this.inventory = iInventory;
        this.slotIndex = n;
        this.xDisplayPosition = n2;
        this.yDisplayPosition = n3;
    }

    public void onSlotChange(ItemStack itemStack, ItemStack itemStack2) {
        int n;
        if (itemStack != null && itemStack2 != null && itemStack.getItem() == itemStack2.getItem() && (n = itemStack2.stackSize - itemStack.stackSize) > 0) {
            this.onCrafting(itemStack, n);
        }
    }

    protected void onCrafting(ItemStack itemStack, int n) {
    }

    protected void onCrafting(ItemStack itemStack) {
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        this.onSlotChanged();
    }

    public boolean isItemValid(ItemStack itemStack) {
        return true;
    }

    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.slotIndex);
    }

    public boolean getHasStack() {
        return this.getStack() != null;
    }

    public void putStack(ItemStack itemStack) {
        this.inventory.setInventorySlotContents(this.slotIndex, itemStack);
        this.onSlotChanged();
    }

    public void onSlotChanged() {
        this.inventory.markDirty();
    }

    public int getSlotStackLimit() {
        return this.inventory.getInventoryStackLimit();
    }

    public int getItemStackLimit(ItemStack itemStack) {
        return this.getSlotStackLimit();
    }

    public String getSlotTexture() {
        return null;
    }

    public ItemStack decrStackSize(int n) {
        return this.inventory.decrStackSize(this.slotIndex, n);
    }

    public boolean isHere(IInventory iInventory, int n) {
        return iInventory == this.inventory && n == this.slotIndex;
    }

    public boolean canTakeStack(EntityPlayer entityPlayer) {
        return true;
    }

    public boolean canBeHovered() {
        return true;
    }
}

