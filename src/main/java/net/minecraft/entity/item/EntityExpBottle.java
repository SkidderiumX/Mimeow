/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityExpBottle
extends EntityThrowable {
    public EntityExpBottle(World world2) {
        super(world2);
    }

    public EntityExpBottle(World world2, EntityLivingBase entityLivingBase) {
        super(world2, entityLivingBase);
    }

    public EntityExpBottle(World world2, double d, double d2, double d3) {
        super(world2, d, d2, d3);
    }

    @Override
    protected float getGravityVelocity() {
        return 0.07f;
    }

    @Override
    protected float getVelocity() {
        return 0.7f;
    }

    @Override
    protected float getInaccuracy() {
        return -20.0f;
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (!this.worldObj.isRemote) {
            int n;
            this.worldObj.playAuxSFX(2002, new BlockPos(this), 0);
            for (int i = 3 + this.worldObj.rand.nextInt(5) + this.worldObj.rand.nextInt(5); i > 0; i -= n) {
                n = EntityXPOrb.getXPSplit(i);
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n));
            }
            this.setDead();
        }
    }
}

