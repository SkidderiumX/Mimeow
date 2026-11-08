/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySnowball
extends EntityThrowable {
    public EntitySnowball(World world2) {
        super(world2);
    }

    public EntitySnowball(World world2, EntityLivingBase entityLivingBase) {
        super(world2, entityLivingBase);
    }

    public EntitySnowball(World world2, double d, double d2, double d3) {
        super(world2, d, d2, d3);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        int n;
        if (movingObjectPosition.entityHit != null) {
            n = 0;
            if (movingObjectPosition.entityHit instanceof EntityBlaze) {
                n = 3;
            }
            movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), n);
        }
        for (n = 0; n < 8; ++n) {
            this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}

