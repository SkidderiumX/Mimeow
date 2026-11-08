/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityAIFindEntityNearest
extends EntityAIBase {
    private static final Logger LOGGER = LogManager.getLogger();
    private EntityLiving mob;
    private final Predicate<EntityLivingBase> field_179443_c;
    private final EntityAINearestAttackableTarget.Sorter field_179440_d;
    private EntityLivingBase target;
    private Class<? extends EntityLivingBase> field_179439_f;

    public EntityAIFindEntityNearest(EntityLiving entityLiving, Class<? extends EntityLivingBase> clazz) {
        this.mob = entityLiving;
        this.field_179439_f = clazz;
        if (entityLiving instanceof EntityCreature) {
            LOGGER.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
        }
        this.field_179443_c = new Predicate<EntityLivingBase>(){

            @Override
            public boolean apply(EntityLivingBase entityLivingBase) {
                double d = EntityAIFindEntityNearest.this.getFollowRange();
                if (entityLivingBase.isSneaking()) {
                    d *= (double)0.8f;
                }
                return entityLivingBase.isInvisible() ? false : ((double)entityLivingBase.getDistanceToEntity(EntityAIFindEntityNearest.this.mob) > d ? false : EntityAITarget.isSuitableTarget(EntityAIFindEntityNearest.this.mob, entityLivingBase, false, true));
            }
        };
        this.field_179440_d = new EntityAINearestAttackableTarget.Sorter(entityLiving);
    }

    @Override
    public boolean shouldExecute() {
        double d = this.getFollowRange();
        List<EntityLivingBase> list = this.mob.worldObj.getEntitiesWithinAABB(this.field_179439_f, this.mob.getEntityBoundingBox().expand(d, 4.0, d), this.field_179443_c);
        Collections.sort(list, this.field_179440_d);
        if (list.isEmpty()) {
            return false;
        }
        this.target = list.get(0);
        return true;
    }

    @Override
    public boolean continueExecuting() {
        EntityLivingBase entityLivingBase = this.mob.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.isEntityAlive()) {
            return false;
        }
        double d = this.getFollowRange();
        return this.mob.getDistanceSqToEntity(entityLivingBase) > d * d ? false : !(entityLivingBase instanceof EntityPlayerMP) || !((EntityPlayerMP)entityLivingBase).theItemInWorldManager.isCreative();
    }

    @Override
    public void startExecuting() {
        this.mob.setAttackTarget(this.target);
        super.startExecuting();
    }

    @Override
    public void resetTask() {
        this.mob.setAttackTarget(null);
        super.startExecuting();
    }

    protected double getFollowRange() {
        IAttributeInstance iAttributeInstance = this.mob.getEntityAttribute(SharedMonsterAttributes.followRange);
        return iAttributeInstance == null ? 16.0 : iAttributeInstance.getAttributeValue();
    }
}

