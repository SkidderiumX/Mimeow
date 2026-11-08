/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityEnderChest;

public class InventoryEnderChest
extends InventoryBasic {
    private TileEntityEnderChest associatedChest;

    public InventoryEnderChest() {
        super("container.enderchest", false, 27);
    }

    public void setChestTileEntity(TileEntityEnderChest tileEntityEnderChest) {
        this.associatedChest = tileEntityEnderChest;
    }

    public void loadInventoryFromNBT(NBTTagList nBTTagList) {
        int n;
        for (n = 0; n < this.getSizeInventory(); ++n) {
            this.setInventorySlotContents(n, null);
        }
        for (n = 0; n < nBTTagList.tagCount(); ++n) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(n);
            int n2 = nBTTagCompound.getByte("Slot") & 0xFF;
            if (n2 < 0 || n2 >= this.getSizeInventory()) continue;
            this.setInventorySlotContents(n2, ItemStack.loadItemStackFromNBT(nBTTagCompound));
        }
    }

    public NBTTagList saveInventoryToNBT() {
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            ItemStack itemStack = this.getStackInSlot(i);
            if (itemStack == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setByte("Slot", (byte)i);
            itemStack.writeToNBT(nBTTagCompound);
            nBTTagList.appendTag(nBTTagCompound);
        }
        return nBTTagList;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.associatedChest != null && !this.associatedChest.canBeUsed(entityPlayer) ? false : super.isUseableByPlayer(entityPlayer);
    }

    @Override
    public void openInventory(EntityPlayer entityPlayer) {
        if (this.associatedChest != null) {
            this.associatedChest.openChest();
        }
        super.openInventory(entityPlayer);
    }

    @Override
    public void closeInventory(EntityPlayer entityPlayer) {
        if (this.associatedChest != null) {
            this.associatedChest.closeChest();
        }
        super.closeInventory(entityPlayer);
        this.associatedChest = null;
    }
}

