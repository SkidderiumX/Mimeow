/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityAIAttackOnCollide
extends EntityAIBase {
    World worldObj;
    protected EntityCreature attacker;
    int attackTick;
    double speedTowardsTarget;
    boolean longMemory;
    PathEntity entityPathEntity;
    Class<? extends Entity> classTarget;
    private int delayCounter;
    private double targetX;
    private double targetY;
    private double targetZ;

    public EntityAIAttackOnCollide(EntityCreature entityCreature, Class<? extends Entity> clazz, double d, boolean bl) {
        this(entityCreature, d, bl);
        this.classTarget = clazz;
    }

    public EntityAIAttackOnCollide(EntityCreature entityCreature, double d, boolean bl) {
        this.attacker = entityCreature;
        this.worldObj = entityCreature.worldObj;
        this.speedTowardsTarget = d;
        this.longMemory = bl;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this.attacker.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.isEntityAlive()) {
            return false;
        }
        if (this.classTarget != null && !this.classTarget.isAssignableFrom(entityLivingBase.getClass())) {
            return false;
        }
        this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entityLivingBase);
        return this.entityPathEntity != null;
    }

    @Override
    public boolean continueExecuting() {
        EntityLivingBase entityLivingBase = this.attacker.getAttackTarget();
        return entityLivingBase == null ? false : (!entityLivingBase.isEntityAlive() ? false : (!this.longMemory ? !this.attacker.getNavigator().noPath() : this.attacker.isWithinHomeDistanceFromPosition(new BlockPos(entityLivingBase))));
    }

    @Override
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
        this.delayCounter = 0;
    }

    @Override
    public void resetTask() {
        this.attacker.getNavigator().clearPathEntity();
    }

    @Override
    public void updateTask() {
        EntityLivingBase entityLivingBase = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(entityLivingBase, 30.0f, 30.0f);
        double d = this.attacker.getDistanceSq(entityLivingBase.posX, entityLivingBase.getEntityBoundingBox().minY, entityLivingBase.posZ);
        double d2 = this.func_179512_a(entityLivingBase);
        --this.delayCounter;
        if ((this.longMemory || this.attacker.getEntitySenses().canSee(entityLivingBase)) && this.delayCounter <= 0 && (this.targetX == 0.0 && this.targetY == 0.0 && this.targetZ == 0.0 || entityLivingBase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0 || this.attacker.getRNG().nextFloat() < 0.05f)) {
            this.targetX = entityLivingBase.posX;
            this.targetY = entityLivingBase.getEntityBoundingBox().minY;
            this.targetZ = entityLivingBase.posZ;
            this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
            if (d > 1024.0) {
                this.delayCounter += 10;
            } else if (d > 256.0) {
                this.delayCounter += 5;
            }
            if (!this.attacker.getNavigator().tryMoveToEntityLiving(entityLivingBase, this.speedTowardsTarget)) {
                this.delayCounter += 15;
            }
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        if (d <= d2 && this.attackTick <= 0) {
            this.attackTick = 20;
            if (this.attacker.getHeldItem() != null) {
                this.attacker.swingItem();
            }
            this.attacker.attackEntityAsMob(entityLivingBase);
        }
    }

    protected double func_179512_a(EntityLivingBase entityLivingBase) {
        return this.attacker.width * 2.0f * this.attacker.width * 2.0f + entityLivingBase.width;
    }
}

