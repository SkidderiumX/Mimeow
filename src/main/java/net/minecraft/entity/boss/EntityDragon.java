/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityDragon
extends EntityLiving
implements IBossDisplayData,
IEntityMultiPart,
IMob {
    public double targetX;
    public double targetY;
    public double targetZ;
    public double[][] ringBuffer = new double[64][3];
    public int ringBufferIndex = -1;
    public EntityDragonPart[] dragonPartArray;
    public EntityDragonPart dragonPartHead = new EntityDragonPart(this, "head", 6.0f, 6.0f);
    public EntityDragonPart dragonPartBody = new EntityDragonPart(this, "body", 8.0f, 8.0f);
    public EntityDragonPart dragonPartTail1 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart dragonPartTail2 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart dragonPartTail3 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart dragonPartWing1 = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
    public EntityDragonPart dragonPartWing2 = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
    public float prevAnimTime;
    public float animTime;
    public boolean forceNewTarget;
    public boolean slowed;
    private Entity target;
    public int deathTicks;
    public EntityEnderCrystal healingEnderCrystal;

    public EntityDragon(World world2) {
        super(world2);
        this.dragonPartArray = new EntityDragonPart[]{this.dragonPartHead, this.dragonPartBody, this.dragonPartTail1, this.dragonPartTail2, this.dragonPartTail3, this.dragonPartWing1, this.dragonPartWing2};
        this.setHealth(this.getMaxHealth());
        this.setSize(16.0f, 8.0f);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.targetY = 100.0;
        this.ignoreFrustumCheck = true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    public double[] getMovementOffsets(int n, float f) {
        if (this.getHealth() <= 0.0f) {
            f = 0.0f;
        }
        f = 1.0f - f;
        int n2 = this.ringBufferIndex - n * 1 & 0x3F;
        int n3 = this.ringBufferIndex - n * 1 - 1 & 0x3F;
        double[] dArray = new double[3];
        double d = this.ringBuffer[n2][0];
        double d2 = MathHelper.wrapAngleTo180_double(this.ringBuffer[n3][0] - d);
        dArray[0] = d + d2 * (double)f;
        d = this.ringBuffer[n2][1];
        d2 = this.ringBuffer[n3][1] - d;
        dArray[1] = d + d2 * (double)f;
        dArray[2] = this.ringBuffer[n2][2] + (this.ringBuffer[n3][2] - this.ringBuffer[n2][2]) * (double)f;
        return dArray;
    }

    @Override
    public void onLivingUpdate() {
        float f;
        float f2;
        if (this.worldObj.isRemote) {
            f2 = MathHelper.cos(this.animTime * (float)Math.PI * 2.0f);
            f = MathHelper.cos(this.prevAnimTime * (float)Math.PI * 2.0f);
            if (f <= -0.3f && f2 >= -0.3f && !this.isSilent()) {
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "mob.enderdragon.wings", 5.0f, 0.8f + this.rand.nextFloat() * 0.3f, false);
            }
        }
        this.prevAnimTime = this.animTime;
        if (this.getHealth() <= 0.0f) {
            f2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            f = (this.rand.nextFloat() - 0.5f) * 4.0f;
            float f3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + (double)f2, this.posY + 2.0 + (double)f, this.posZ + (double)f3, 0.0, 0.0, 0.0, new int[0]);
        } else {
            this.updateDragonEnderCrystal();
            f2 = 0.2f / (MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0f + 1.0f);
            this.animTime = this.slowed ? (this.animTime += f2 * 0.5f) : (this.animTime += (f2 *= (float)Math.pow(2.0, this.motionY)));
            this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw);
            if (this.isAIDisabled()) {
                this.animTime = 0.5f;
            } else {
                float f4;
                float f5;
                if (this.ringBufferIndex < 0) {
                    for (int i = 0; i < this.ringBuffer.length; ++i) {
                        this.ringBuffer[i][0] = this.rotationYaw;
                        this.ringBuffer[i][1] = this.posY;
                    }
                }
                if (++this.ringBufferIndex == this.ringBuffer.length) {
                    this.ringBufferIndex = 0;
                }
                this.ringBuffer[this.ringBufferIndex][0] = this.rotationYaw;
                this.ringBuffer[this.ringBufferIndex][1] = this.posY;
                if (this.worldObj.isRemote) {
                    if (this.newPosRotationIncrements > 0) {
                        double d = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
                        var4_8 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
                        var6_10 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
                        var8_12 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
                        this.rotationYaw = (float)((double)this.rotationYaw + var8_12 / (double)this.newPosRotationIncrements);
                        this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
                        --this.newPosRotationIncrements;
                        this.setPosition(d, var4_8, var6_10);
                        this.setRotation(this.rotationYaw, this.rotationPitch);
                    }
                } else {
                    double d;
                    double d2 = this.targetX - this.posX;
                    var4_8 = this.targetY - this.posY;
                    var6_10 = this.targetZ - this.posZ;
                    var8_12 = d2 * d2 + var4_8 * var4_8 + var6_10 * var6_10;
                    if (this.target != null) {
                        this.targetX = this.target.posX;
                        this.targetZ = this.target.posZ;
                        double d3 = this.targetX - this.posX;
                        double d4 = this.targetZ - this.posZ;
                        double d5 = Math.sqrt(d3 * d3 + d4 * d4);
                        d = (double)0.4f + d5 / 80.0 - 1.0;
                        if (d > 10.0) {
                            d = 10.0;
                        }
                        this.targetY = this.target.getEntityBoundingBox().minY + d;
                    } else {
                        this.targetX += this.rand.nextGaussian() * 2.0;
                        this.targetZ += this.rand.nextGaussian() * 2.0;
                    }
                    if (this.forceNewTarget || var8_12 < 100.0 || var8_12 > 22500.0 || this.isCollidedHorizontally || this.isCollidedVertically) {
                        this.setNewTarget();
                    }
                    var4_8 /= (double)MathHelper.sqrt_double(d2 * d2 + var6_10 * var6_10);
                    f5 = 0.6f;
                    var4_8 = MathHelper.clamp_double(var4_8, -f5, f5);
                    this.motionY += var4_8 * (double)0.1f;
                    this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw);
                    double d6 = 180.0 - MathHelper.atan2(d2, var6_10) * 180.0 / Math.PI;
                    double d7 = MathHelper.wrapAngleTo180_double(d6 - (double)this.rotationYaw);
                    if (d7 > 50.0) {
                        d7 = 50.0;
                    }
                    if (d7 < -50.0) {
                        d7 = -50.0;
                    }
                    Vec3 vec3 = new Vec3(this.targetX - this.posX, this.targetY - this.posY, this.targetZ - this.posZ).normalize();
                    d = -MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0f);
                    Vec3 vec32 = new Vec3(MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0f), this.motionY, d).normalize();
                    f4 = ((float)vec32.dotProduct(vec3) + 0.5f) / 1.5f;
                    if (f4 < 0.0f) {
                        f4 = 0.0f;
                    }
                    this.randomYawVelocity *= 0.8f;
                    float f6 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0f + 1.0f;
                    double d8 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0 + 1.0;
                    if (d8 > 40.0) {
                        d8 = 40.0;
                    }
                    this.randomYawVelocity = (float)((double)this.randomYawVelocity + d7 * ((double)0.7f / d8 / (double)f6));
                    this.rotationYaw += this.randomYawVelocity * 0.1f;
                    float f7 = (float)(2.0 / (d8 + 1.0));
                    float f8 = 0.06f;
                    this.moveFlying(0.0f, -1.0f, f8 * (f4 * f7 + (1.0f - f7)));
                    if (this.slowed) {
                        this.moveEntity(this.motionX * (double)0.8f, this.motionY * (double)0.8f, this.motionZ * (double)0.8f);
                    } else {
                        this.moveEntity(this.motionX, this.motionY, this.motionZ);
                    }
                    Vec3 vec33 = new Vec3(this.motionX, this.motionY, this.motionZ).normalize();
                    float f9 = ((float)vec33.dotProduct(vec32) + 1.0f) / 2.0f;
                    f9 = 0.8f + 0.15f * f9;
                    this.motionX *= (double)f9;
                    this.motionZ *= (double)f9;
                    this.motionY *= (double)0.91f;
                }
                this.renderYawOffset = this.rotationYaw;
                this.dragonPartHead.height = 3.0f;
                this.dragonPartHead.width = 3.0f;
                this.dragonPartTail1.height = 2.0f;
                this.dragonPartTail1.width = 2.0f;
                this.dragonPartTail2.height = 2.0f;
                this.dragonPartTail2.width = 2.0f;
                this.dragonPartTail3.height = 2.0f;
                this.dragonPartTail3.width = 2.0f;
                this.dragonPartBody.height = 3.0f;
                this.dragonPartBody.width = 5.0f;
                this.dragonPartWing1.height = 2.0f;
                this.dragonPartWing1.width = 4.0f;
                this.dragonPartWing2.height = 3.0f;
                this.dragonPartWing2.width = 4.0f;
                f = (float)(this.getMovementOffsets(5, 1.0f)[1] - this.getMovementOffsets(10, 1.0f)[1]) * 10.0f / 180.0f * (float)Math.PI;
                float f10 = MathHelper.cos(f);
                float f11 = -MathHelper.sin(f);
                float f12 = this.rotationYaw * (float)Math.PI / 180.0f;
                float f13 = MathHelper.sin(f12);
                float f14 = MathHelper.cos(f12);
                this.dragonPartBody.onUpdate();
                this.dragonPartBody.setLocationAndAngles(this.posX + (double)(f13 * 0.5f), this.posY, this.posZ - (double)(f14 * 0.5f), 0.0f, 0.0f);
                this.dragonPartWing1.onUpdate();
                this.dragonPartWing1.setLocationAndAngles(this.posX + (double)(f14 * 4.5f), this.posY + 2.0, this.posZ + (double)(f13 * 4.5f), 0.0f, 0.0f);
                this.dragonPartWing2.onUpdate();
                this.dragonPartWing2.setLocationAndAngles(this.posX - (double)(f14 * 4.5f), this.posY + 2.0, this.posZ - (double)(f13 * 4.5f), 0.0f, 0.0f);
                if (!this.worldObj.isRemote && this.hurtTime == 0) {
                    this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing1.getEntityBoundingBox().expand(4.0, 2.0, 4.0).offset(0.0, -2.0, 0.0)));
                    this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing2.getEntityBoundingBox().expand(4.0, 2.0, 4.0).offset(0.0, -2.0, 0.0)));
                    this.attackEntitiesInList(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartHead.getEntityBoundingBox().expand(1.0, 1.0, 1.0)));
                }
                double[] dArray = this.getMovementOffsets(5, 1.0f);
                double[] dArray2 = this.getMovementOffsets(0, 1.0f);
                f5 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0f - this.randomYawVelocity * 0.01f);
                float f15 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0f - this.randomYawVelocity * 0.01f);
                this.dragonPartHead.onUpdate();
                this.dragonPartHead.setLocationAndAngles(this.posX + (double)(f5 * 5.5f * f10), this.posY + (dArray2[1] - dArray[1]) * 1.0 + (double)(f11 * 5.5f), this.posZ - (double)(f15 * 5.5f * f10), 0.0f, 0.0f);
                for (int i = 0; i < 3; ++i) {
                    EntityDragonPart entityDragonPart = null;
                    if (i == 0) {
                        entityDragonPart = this.dragonPartTail1;
                    }
                    if (i == 1) {
                        entityDragonPart = this.dragonPartTail2;
                    }
                    if (i == 2) {
                        entityDragonPart = this.dragonPartTail3;
                    }
                    double[] dArray3 = this.getMovementOffsets(12 + i * 2, 1.0f);
                    float f16 = this.rotationYaw * (float)Math.PI / 180.0f + this.simplifyAngle(dArray3[0] - dArray[0]) * (float)Math.PI / 180.0f * 1.0f;
                    float f17 = MathHelper.sin(f16);
                    float f18 = MathHelper.cos(f16);
                    float f19 = 1.5f;
                    f4 = (float)(i + 1) * 2.0f;
                    entityDragonPart.onUpdate();
                    entityDragonPart.setLocationAndAngles(this.posX - (double)((f13 * f19 + f17 * f4) * f10), this.posY + (dArray3[1] - dArray[1]) * 1.0 - (double)((f4 + f19) * f11) + 1.5, this.posZ + (double)((f14 * f19 + f18 * f4) * f10), 0.0f, 0.0f);
                }
                if (!this.worldObj.isRemote) {
                    this.slowed = this.destroyBlocksInAABB(this.dragonPartHead.getEntityBoundingBox()) | this.destroyBlocksInAABB(this.dragonPartBody.getEntityBoundingBox());
                }
            }
        }
    }

    private void updateDragonEnderCrystal() {
        if (this.healingEnderCrystal != null) {
            if (this.healingEnderCrystal.isDead) {
                if (!this.worldObj.isRemote) {
                    this.attackEntityFromPart(this.dragonPartHead, DamageSource.setExplosionSource(null), 10.0f);
                }
                this.healingEnderCrystal = null;
            } else if (this.ticksExisted % 10 == 0 && this.getHealth() < this.getMaxHealth()) {
                this.setHealth(this.getHealth() + 1.0f);
            }
        }
        if (this.rand.nextInt(10) == 0) {
            float f = 32.0f;
            List<EntityEnderCrystal> list = this.worldObj.getEntitiesWithinAABB(EntityEnderCrystal.class, this.getEntityBoundingBox().expand(f, f, f));
            EntityEnderCrystal entityEnderCrystal = null;
            double d = Double.MAX_VALUE;
            for (EntityEnderCrystal entityEnderCrystal2 : list) {
                double d2 = entityEnderCrystal2.getDistanceSqToEntity(this);
                if (!(d2 < d)) continue;
                d = d2;
                entityEnderCrystal = entityEnderCrystal2;
            }
            this.healingEnderCrystal = entityEnderCrystal;
        }
    }

    private void collideWithEntities(List<Entity> list) {
        double d = (this.dragonPartBody.getEntityBoundingBox().minX + this.dragonPartBody.getEntityBoundingBox().maxX) / 2.0;
        double d2 = (this.dragonPartBody.getEntityBoundingBox().minZ + this.dragonPartBody.getEntityBoundingBox().maxZ) / 2.0;
        for (Entity entity : list) {
            if (!(entity instanceof EntityLivingBase)) continue;
            double d3 = entity.posX - d;
            double d4 = entity.posZ - d2;
            double d5 = d3 * d3 + d4 * d4;
            entity.addVelocity(d3 / d5 * 4.0, 0.2f, d4 / d5 * 4.0);
        }
    }

    private void attackEntitiesInList(List<Entity> list) {
        for (int i = 0; i < list.size(); ++i) {
            Entity entity = list.get(i);
            if (!(entity instanceof EntityLivingBase)) continue;
            entity.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0f);
            this.applyEnchantments(this, entity);
        }
    }

    private void setNewTarget() {
        this.forceNewTarget = false;
        ArrayList<EntityPlayer> arrayList = Lists.newArrayList(this.worldObj.playerEntities);
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            if (!((EntityPlayer)iterator2.next()).isSpectator()) continue;
            iterator2.remove();
        }
        if (this.rand.nextInt(2) == 0 && !arrayList.isEmpty()) {
            this.target = (Entity)arrayList.get(this.rand.nextInt(arrayList.size()));
        } else {
            double d;
            double d2;
            double d3;
            boolean bl;
            do {
                this.targetX = 0.0;
                this.targetY = 70.0f + this.rand.nextFloat() * 50.0f;
                this.targetZ = 0.0;
                this.targetX += (double)(this.rand.nextFloat() * 120.0f - 60.0f);
                this.targetZ += (double)(this.rand.nextFloat() * 120.0f - 60.0f);
            } while (!(bl = (d3 = this.posX - this.targetX) * d3 + (d2 = this.posY - this.targetY) * d2 + (d = this.posZ - this.targetZ) * d > 100.0));
            this.target = null;
        }
    }

    private float simplifyAngle(double d) {
        return (float)MathHelper.wrapAngleTo180_double(d);
    }

    private boolean destroyBlocksInAABB(AxisAlignedBB axisAlignedBB) {
        int n = MathHelper.floor_double(axisAlignedBB.minX);
        int n2 = MathHelper.floor_double(axisAlignedBB.minY);
        int n3 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxX);
        int n5 = MathHelper.floor_double(axisAlignedBB.maxY);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxZ);
        boolean bl = false;
        boolean bl2 = false;
        for (int i = n; i <= n4; ++i) {
            for (int j = n2; j <= n5; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    BlockPos blockPos = new BlockPos(i, j, k);
                    Block block = this.worldObj.getBlockState(blockPos).getBlock();
                    if (block.getMaterial() == Material.air) continue;
                    if (block != Blocks.barrier && block != Blocks.obsidian && block != Blocks.end_stone && block != Blocks.bedrock && block != Blocks.command_block && this.worldObj.getGameRules().getBoolean("mobGriefing")) {
                        bl2 = this.worldObj.setBlockToAir(blockPos) || bl2;
                        continue;
                    }
                    bl = true;
                }
            }
        }
        if (bl2) {
            double d = axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * (double)this.rand.nextFloat();
            double d2 = axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * (double)this.rand.nextFloat();
            double d3 = axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * (double)this.rand.nextFloat();
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, d, d2, d3, 0.0, 0.0, 0.0, new int[0]);
        }
        return bl;
    }

    @Override
    public boolean attackEntityFromPart(EntityDragonPart entityDragonPart, DamageSource damageSource, float f) {
        if (entityDragonPart != this.dragonPartHead) {
            f = f / 4.0f + 1.0f;
        }
        float f2 = this.rotationYaw * (float)Math.PI / 180.0f;
        float f3 = MathHelper.sin(f2);
        float f4 = MathHelper.cos(f2);
        this.targetX = this.posX + (double)(f3 * 5.0f) + (double)((this.rand.nextFloat() - 0.5f) * 2.0f);
        this.targetY = this.posY + (double)(this.rand.nextFloat() * 3.0f) + 1.0;
        this.targetZ = this.posZ - (double)(f4 * 5.0f) + (double)((this.rand.nextFloat() - 0.5f) * 2.0f);
        this.target = null;
        if (damageSource.getEntity() instanceof EntityPlayer || damageSource.isExplosion()) {
            this.attackDragonFrom(damageSource, f);
        }
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (damageSource instanceof EntityDamageSource && ((EntityDamageSource)damageSource).getIsThornsDamage()) {
            this.attackDragonFrom(damageSource, f);
        }
        return false;
    }

    protected boolean attackDragonFrom(DamageSource damageSource, float f) {
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void onKillCommand() {
        this.setDead();
    }

    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float f = (this.rand.nextFloat() - 0.5f) * 8.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            float f3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + (double)f, this.posY + 2.0 + (double)f2, this.posZ + (double)f3, 0.0, 0.0, 0.0, new int[0]);
        }
        boolean bl = this.worldObj.getGameRules().getBoolean("doMobLoot");
        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0 && bl) {
                int n;
                for (int i = 1000; i > 0; i -= n) {
                    n = EntityXPOrb.getXPSplit(i);
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n));
                }
            }
            if (this.deathTicks == 1) {
                this.worldObj.playBroadcastSound(1018, new BlockPos(this), 0);
            }
        }
        this.moveEntity(0.0, 0.1f, 0.0);
        this.renderYawOffset = this.rotationYaw += 20.0f;
        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            if (bl) {
                int n;
                for (int i = 2000; i > 0; i -= n) {
                    n = EntityXPOrb.getXPSplit(i);
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n));
                }
            }
            this.generatePortal(new BlockPos(this.posX, 64.0, this.posZ));
            this.setDead();
        }
    }

    private void generatePortal(BlockPos blockPos) {
        int n = 4;
        double d = 12.25;
        double d2 = 6.25;
        for (int i = -1; i <= 32; ++i) {
            for (int j = -4; j <= 4; ++j) {
                for (int k = -4; k <= 4; ++k) {
                    double d3 = j * j + k * k;
                    if (!(d3 <= 12.25)) continue;
                    BlockPos blockPos2 = blockPos.add(j, i, k);
                    if (i < 0) {
                        if (!(d3 <= 6.25)) continue;
                        this.worldObj.setBlockState(blockPos2, Blocks.bedrock.getDefaultState());
                        continue;
                    }
                    if (i > 0) {
                        this.worldObj.setBlockState(blockPos2, Blocks.air.getDefaultState());
                        continue;
                    }
                    if (d3 > 6.25) {
                        this.worldObj.setBlockState(blockPos2, Blocks.bedrock.getDefaultState());
                        continue;
                    }
                    this.worldObj.setBlockState(blockPos2, Blocks.end_portal.getDefaultState());
                }
            }
        }
        this.worldObj.setBlockState(blockPos, Blocks.bedrock.getDefaultState());
        this.worldObj.setBlockState(blockPos.up(), Blocks.bedrock.getDefaultState());
        BlockPos blockPos3 = blockPos.up(2);
        this.worldObj.setBlockState(blockPos3, Blocks.bedrock.getDefaultState());
        this.worldObj.setBlockState(blockPos3.west(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.EAST));
        this.worldObj.setBlockState(blockPos3.east(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.WEST));
        this.worldObj.setBlockState(blockPos3.north(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.SOUTH));
        this.worldObj.setBlockState(blockPos3.south(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.NORTH));
        this.worldObj.setBlockState(blockPos.up(3), Blocks.bedrock.getDefaultState());
        this.worldObj.setBlockState(blockPos.up(4), Blocks.dragon_egg.getDefaultState());
    }

    @Override
    protected void despawnEntity() {
    }

    @Override
    public Entity[] getParts() {
        return this.dragonPartArray;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public World getWorld() {
        return this.worldObj;
    }

    @Override
    protected String getLivingSound() {
        return "mob.enderdragon.growl";
    }

    @Override
    protected String getHurtSound() {
        return "mob.enderdragon.hit";
    }

    @Override
    protected float getSoundVolume() {
        return 5.0f;
    }
}

