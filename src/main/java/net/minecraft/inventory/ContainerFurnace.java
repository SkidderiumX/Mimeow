/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerFurnace
extends Container {
    private final IInventory tileFurnace;
    private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;

    public ContainerFurnace(InventoryPlayer inventoryPlayer, IInventory iInventory) {
        int n;
        this.tileFurnace = iInventory;
        this.addSlotToContainer(new Slot(iInventory, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(iInventory, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(inventoryPlayer.player, iInventory, 2, 116, 35));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n, 8 + n * 18, 142));
        }
    }

    @Override
    public void onCraftGuiOpened(ICrafting iCrafting) {
        super.onCraftGuiOpened(iCrafting);
        iCrafting.sendAllWindowProperties(this, this.tileFurnace);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting iCrafting = (ICrafting)this.crafters.get(i);
            if (this.cookTime != this.tileFurnace.getField(2)) {
                iCrafting.sendProgressBarUpdate(this, 2, this.tileFurnace.getField(2));
            }
            if (this.furnaceBurnTime != this.tileFurnace.getField(0)) {
                iCrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }
            if (this.currentItemBurnTime != this.tileFurnace.getField(1)) {
                iCrafting.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
            }
            if (this.totalCookTime == this.tileFurnace.getField(3)) continue;
            iCrafting.sendProgressBarUpdate(this, 3, this.tileFurnace.getField(3));
        }
        this.cookTime = this.tileFurnace.getField(2);
        this.furnaceBurnTime = this.tileFurnace.getField(0);
        this.currentItemBurnTime = this.tileFurnace.getField(1);
        this.totalCookTime = this.tileFurnace.getField(3);
    }

    @Override
    public void updateProgressBar(int n, int n2) {
        this.tileFurnace.setField(n, n2);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.tileFurnace.isUseableByPlayer(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();
            if (n == 2) {
                if (!this.mergeItemStack(itemStack2, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n != 1 && n != 0 ? (FurnaceRecipes.instance().getSmeltingResult(itemStack2) != null ? !this.mergeItemStack(itemStack2, 0, 1, false) : (TileEntityFurnace.isItemFuel(itemStack2) ? !this.mergeItemStack(itemStack2, 1, 2, false) : (n >= 3 && n < 30 ? !this.mergeItemStack(itemStack2, 30, 39, false) : n >= 30 && n < 39 && !this.mergeItemStack(itemStack2, 3, 30, false)))) : !this.mergeItemStack(itemStack2, 3, 39, false)) {
                return null;
            }
            if (itemStack2.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemStack2.stackSize == itemStack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack2);
        }
        return itemStack;
    }
}

