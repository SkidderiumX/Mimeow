/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.world.World;

public class EntityMinecartHopper
extends EntityMinecartContainer
implements IHopper {
    private boolean isBlocked = true;
    private int transferTicker = -1;
    private BlockPos field_174900_c = BlockPos.ORIGIN;

    public EntityMinecartHopper(World world2) {
        super(world2);
    }

    public EntityMinecartHopper(World world2, double d, double d2, double d3) {
        super(world2, d, d2, d3);
    }

    @Override
    public EntityMinecart.EnumMinecartType getMinecartType() {
        return EntityMinecart.EnumMinecartType.HOPPER;
    }

    @Override
    public IBlockState getDefaultDisplayTile() {
        return Blocks.hopper.getDefaultState();
    }

    @Override
    public int getDefaultDisplayTileOffset() {
        return 1;
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (!this.worldObj.isRemote) {
            entityPlayer.displayGUIChest(this);
        }
        return true;
    }

    @Override
    public void onActivatorRailPass(int n, int n2, int n3, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = !bl;
        if (bl2 != this.getBlocked()) {
            this.setBlocked(bl2);
        }
    }

    public boolean getBlocked() {
        return this.isBlocked;
    }

    public void setBlocked(boolean bl) {
        this.isBlocked = bl;
    }

    @Override
    public World getWorld() {
        return this.worldObj;
    }

    @Override
    public double getXPos() {
        return this.posX;
    }

    @Override
    public double getYPos() {
        return this.posY + 0.5;
    }

    @Override
    public double getZPos() {
        return this.posZ;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.isEntityAlive() && this.getBlocked()) {
            BlockPos blockPos = new BlockPos(this);
            if (blockPos.equals(this.field_174900_c)) {
                --this.transferTicker;
            } else {
                this.setTransferTicker(0);
            }
            if (!this.canTransfer()) {
                this.setTransferTicker(0);
                if (this.func_96112_aD()) {
                    this.setTransferTicker(4);
                    this.markDirty();
                }
            }
        }
    }

    public boolean func_96112_aD() {
        if (TileEntityHopper.captureDroppedItems(this)) {
            return true;
        }
        List<Entity> list = this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(0.25, 0.0, 0.25), EntitySelectors.selectAnything);
        if (list.size() > 0) {
            TileEntityHopper.putDropInInventoryAllSlots(this, (EntityItem)list.get(0));
        }
        return false;
    }

    @Override
    public void killMinecart(DamageSource damageSource) {
        super.killMinecart(damageSource);
        if (this.worldObj.getGameRules().getBoolean("doEntityDrops")) {
            this.dropItemWithOffset(Item.getItemFromBlock(Blocks.hopper), 1, 0.0f);
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound.setInteger("TransferCooldown", this.transferTicker);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.transferTicker = nBTTagCompound.getInteger("TransferCooldown");
    }

    public void setTransferTicker(int n) {
        this.transferTicker = n;
    }

    public boolean canTransfer() {
        return this.transferTicker > 0;
    }

    @Override
    public String getGuiID() {
        return "minecraft:hopper";
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
        return new ContainerHopper(inventoryPlayer, this, entityPlayer);
    }
}

