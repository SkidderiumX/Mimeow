/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotMerchantResult;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMerchant
extends Container {
    private IMerchant theMerchant;
    private InventoryMerchant merchantInventory;
    private final World theWorld;

    public ContainerMerchant(InventoryPlayer inventoryPlayer, IMerchant iMerchant, World world2) {
        int n;
        this.theMerchant = iMerchant;
        this.theWorld = world2;
        this.merchantInventory = new InventoryMerchant(inventoryPlayer.player, iMerchant);
        this.addSlotToContainer(new Slot(this.merchantInventory, 0, 36, 53));
        this.addSlotToContainer(new Slot(this.merchantInventory, 1, 62, 53));
        this.addSlotToContainer(new SlotMerchantResult(inventoryPlayer.player, iMerchant, this.merchantInventory, 2, 120, 53));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n, 8 + n * 18, 142));
        }
    }

    public InventoryMerchant getMerchantInventory() {
        return this.merchantInventory;
    }

    @Override
    public void onCraftGuiOpened(ICrafting iCrafting) {
        super.onCraftGuiOpened(iCrafting);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        this.merchantInventory.resetRecipeAndSlots();
        super.onCraftMatrixChanged(iInventory);
    }

    public void setCurrentRecipeIndex(int n) {
        this.merchantInventory.setCurrentRecipeIndex(n);
    }

    @Override
    public void updateProgressBar(int n, int n2) {
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.theMerchant.getCustomer() == entityPlayer;
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
            } else if (n != 0 && n != 1 ? (n >= 3 && n < 30 ? !this.mergeItemStack(itemStack2, 30, 39, false) : n >= 30 && n < 39 && !this.mergeItemStack(itemStack2, 3, 30, false)) : !this.mergeItemStack(itemStack2, 3, 39, false)) {
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

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        this.theMerchant.setCustomer(null);
        super.onContainerClosed(entityPlayer);
        if (!this.theWorld.isRemote) {
            ItemStack itemStack = this.merchantInventory.removeStackFromSlot(0);
            if (itemStack != null) {
                entityPlayer.dropPlayerItemWithRandomChoice(itemStack, false);
            }
            if ((itemStack = this.merchantInventory.removeStackFromSlot(1)) != null) {
                entityPlayer.dropPlayerItemWithRandomChoice(itemStack, false);
            }
        }
    }
}

