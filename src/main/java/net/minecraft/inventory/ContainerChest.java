/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerChest
extends Container {
    private IInventory lowerChestInventory;
    private int numRows;

    public ContainerChest(IInventory iInventory, IInventory iInventory2, EntityPlayer entityPlayer) {
        int n;
        int n2;
        this.lowerChestInventory = iInventory2;
        this.numRows = iInventory2.getSizeInventory() / 9;
        iInventory2.openInventory(entityPlayer);
        int n3 = (this.numRows - 4) * 18;
        for (n2 = 0; n2 < this.numRows; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(iInventory2, n + n2 * 9, 8 + n * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(iInventory, n + n2 * 9 + 9, 8 + n * 18, 103 + n2 * 18 + n3));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(iInventory, n2, 8 + n2 * 18, 161 + n3));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.lowerChestInventory.isUseableByPlayer(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();
            if (n < this.numRows * 9 ? !this.mergeItemStack(itemStack2, this.numRows * 9, this.inventorySlots.size(), true) : !this.mergeItemStack(itemStack2, 0, this.numRows * 9, false)) {
                return null;
            }
            if (itemStack2.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        this.lowerChestInventory.closeInventory(entityPlayer);
    }

    public IInventory getLowerChestInventory() {
        return this.lowerChestInventory;
    }
}

