/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMinecartEmpty
extends EntityMinecart {
    public EntityMinecartEmpty(World world2) {
        super(world2);
    }

    public EntityMinecartEmpty(World world2, double d, double d2, double d3) {
        super(world2, d, d2, d3);
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityPlayer) {
            return true;
        }
        if (this.riddenByEntity != null && this.riddenByEntity != entityPlayer) {
            return false;
        }
        if (!this.worldObj.isRemote) {
            entityPlayer.mountEntity(this);
        }
        return true;
    }

    @Override
    public void onActivatorRailPass(int n, int n2, int n3, boolean bl) {
        if (bl) {
            if (this.riddenByEntity != null) {
                this.riddenByEntity.mountEntity(null);
            }
            if (this.getRollingAmplitude() == 0) {
                this.setRollingDirection(-this.getRollingDirection());
                this.setRollingAmplitude(10);
                this.setDamage(50.0f);
                this.setBeenAttacked();
            }
        }
    }

    @Override
    public EntityMinecart.EnumMinecartType getMinecartType() {
        return EntityMinecart.EnumMinecartType.RIDEABLE;
    }
}

