/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;

public abstract class EntityMinecartContainer
extends EntityMinecart
implements ILockableContainer {
    private ItemStack[] minecartContainerItems = new ItemStack[36];
    private boolean dropContentsWhenDead = true;

    public EntityMinecartContainer(World world2) {
        super(world2);
    }

    public EntityMinecartContainer(World world2, double d, double d2, double d3) {
        super(world2, d, d2, d3);
    }

    @Override
    public void killMinecart(DamageSource damageSource) {
        super.killMinecart(damageSource);
        if (this.worldObj.getGameRules().getBoolean("doEntityDrops")) {
            InventoryHelper.dropInventoryItems(this.worldObj, this, (IInventory)this);
        }
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.minecartContainerItems[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.minecartContainerItems[n] != null) {
            if (this.minecartContainerItems[n].stackSize <= n2) {
                ItemStack itemStack = this.minecartContainerItems[n];
                this.minecartContainerItems[n] = null;
                return itemStack;
            }
            ItemStack itemStack = this.minecartContainerItems[n].splitStack(n2);
            if (this.minecartContainerItems[n].stackSize == 0) {
                this.minecartContainerItems[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int n) {
        if (this.minecartContainerItems[n] != null) {
            ItemStack itemStack = this.minecartContainerItems[n];
            this.minecartContainerItems[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.minecartContainerItems[n] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.isDead ? false : entityPlayer.getDistanceSqToEntity(this) <= 64.0;
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
    public String getName() {
        return this.hasCustomName() ? this.getCustomNameTag() : "container.minecart";
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void travelToDimension(int n) {
        this.dropContentsWhenDead = false;
        super.travelToDimension(n);
    }

    @Override
    public void setDead() {
        if (this.dropContentsWhenDead) {
            InventoryHelper.dropInventoryItems(this.worldObj, this, (IInventory)this);
        }
        super.setDead();
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.minecartContainerItems.length; ++i) {
            if (this.minecartContainerItems[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.setByte("Slot", (byte)i);
            this.minecartContainerItems[i].writeToNBT(nBTTagCompound2);
            nBTTagList.appendTag(nBTTagCompound2);
        }
        nBTTagCompound.setTag("Items", nBTTagList);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound.getTagList("Items", 10);
        this.minecartContainerItems = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound2 = nBTTagList.getCompoundTagAt(i);
            int n = nBTTagCompound2.getByte("Slot") & 0xFF;
            if (n < 0 || n >= this.minecartContainerItems.length) continue;
            this.minecartContainerItems[n] = ItemStack.loadItemStackFromNBT(nBTTagCompound2);
        }
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (!this.worldObj.isRemote) {
            entityPlayer.displayGUIChest(this);
        }
        return true;
    }

    @Override
    protected void applyDrag() {
        int n = 15 - Container.calcRedstoneFromInventory(this);
        float f = 0.98f + (float)n * 0.001f;
        this.motionX *= (double)f;
        this.motionY *= 0.0;
        this.motionZ *= (double)f;
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
    public boolean isLocked() {
        return false;
    }

    @Override
    public void setLockCode(LockCode lockCode) {
    }

    @Override
    public LockCode getLockCode() {
        return LockCode.EMPTY_CODE;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.minecartContainerItems.length; ++i) {
            this.minecartContainerItems[i] = null;
        }
    }
}

