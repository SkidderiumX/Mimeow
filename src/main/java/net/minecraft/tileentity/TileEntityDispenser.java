/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;

public class TileEntityDispenser
extends TileEntityLockable
implements IInventory {
    private static final Random RNG = new Random();
    private ItemStack[] stacks = new ItemStack[9];
    protected String customName;

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.stacks[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.stacks[n] != null) {
            if (this.stacks[n].stackSize <= n2) {
                ItemStack itemStack = this.stacks[n];
                this.stacks[n] = null;
                this.markDirty();
                return itemStack;
            }
            ItemStack itemStack = this.stacks[n].splitStack(n2);
            if (this.stacks[n].stackSize == 0) {
                this.stacks[n] = null;
            }
            this.markDirty();
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int n) {
        if (this.stacks[n] != null) {
            ItemStack itemStack = this.stacks[n];
            this.stacks[n] = null;
            return itemStack;
        }
        return null;
    }

    public int getDispenseSlot() {
        int n = -1;
        int n2 = 1;
        for (int i = 0; i < this.stacks.length; ++i) {
            if (this.stacks[i] == null || RNG.nextInt(n2++) != 0) continue;
            n = i;
        }
        return n;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.stacks[n] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }

    public int addItemStack(ItemStack itemStack) {
        for (int i = 0; i < this.stacks.length; ++i) {
            if (this.stacks[i] != null && this.stacks[i].getItem() != null) continue;
            this.setInventorySlotContents(i, itemStack);
            return i;
        }
        return -1;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.dispenser";
    }

    public void setCustomName(String string) {
        this.customName = string;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound.getTagList("Items", 10);
        this.stacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound2 = nBTTagList.getCompoundTagAt(i);
            int n = nBTTagCompound2.getByte("Slot") & 0xFF;
            if (n < 0 || n >= this.stacks.length) continue;
            this.stacks[n] = ItemStack.loadItemStackFromNBT(nBTTagCompound2);
        }
        if (nBTTagCompound.hasKey("CustomName", 8)) {
            this.customName = nBTTagCompound.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.stacks.length; ++i) {
            if (this.stacks[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.setByte("Slot", (byte)i);
            this.stacks[i].writeToNBT(nBTTagCompound2);
            nBTTagList.appendTag(nBTTagCompound2);
        }
        nBTTagCompound.setTag("Items", nBTTagList);
        if (this.hasCustomName()) {
            nBTTagCompound.setString("CustomName", this.customName);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : entityPlayer.getDistanceSq((double)this.pos.getX() + 0.5, (double)this.pos.getY() + 0.5, (double)this.pos.getZ() + 0.5) <= 64.0;
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
    public String getGuiID() {
        return "minecraft:dispenser";
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
        return new ContainerDispenser(inventoryPlayer, this);
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
        for (int i = 0; i < this.stacks.length; ++i) {
            this.stacks[i] = null;
        }
    }
}

