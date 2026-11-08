/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBoat
extends Entity {
    private boolean isBoatEmpty = true;
    private double speedMultiplier = 0.07;
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double velocityX;
    private double velocityY;
    private double velocityZ;

    public EntityBoat(World world2) {
        super(world2);
        this.preventEntitySpawning = true;
        this.setSize(1.5f, 0.6f);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(17, new Integer(0));
        this.dataWatcher.addObject(18, new Integer(1));
        this.dataWatcher.addObject(19, new Float(0.0f));
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        return entity.getEntityBoundingBox();
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return this.getEntityBoundingBox();
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    public EntityBoat(World world2, double d, double d2, double d3) {
        this(world2);
        this.setPosition(d, d2, d3);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = d;
        this.prevPosY = d2;
        this.prevPosZ = d3;
    }

    @Override
    public double getMountedYOffset() {
        return -0.3;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable(damageSource)) {
            return false;
        }
        if (!this.worldObj.isRemote && !this.isDead) {
            boolean bl;
            if (this.riddenByEntity != null && this.riddenByEntity == damageSource.getEntity() && damageSource instanceof EntityDamageSourceIndirect) {
                return false;
            }
            this.setForwardDirection(-this.getForwardDirection());
            this.setTimeSinceHit(10);
            this.setDamageTaken(this.getDamageTaken() + f * 10.0f);
            this.setBeenAttacked();
            boolean bl2 = bl = damageSource.getEntity() instanceof EntityPlayer && ((EntityPlayer)damageSource.getEntity()).capabilities.isCreativeMode;
            if (bl || this.getDamageTaken() > 40.0f) {
                if (this.riddenByEntity != null) {
                    this.riddenByEntity.mountEntity(this);
                }
                if (!bl && this.worldObj.getGameRules().getBoolean("doEntityDrops")) {
                    this.dropItemWithOffset(Items.boat, 1, 0.0f);
                }
                this.setDead();
            }
            return true;
        }
        return true;
    }

    @Override
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0f);
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n, boolean bl) {
        if (bl && this.riddenByEntity != null) {
            this.prevPosX = this.posX = d;
            this.prevPosY = this.posY = d2;
            this.prevPosZ = this.posZ = d3;
            this.rotationYaw = f;
            this.rotationPitch = f2;
            this.boatPosRotationIncrements = 0;
            this.setPosition(d, d2, d3);
            this.velocityX = 0.0;
            this.motionX = 0.0;
            this.velocityY = 0.0;
            this.motionY = 0.0;
            this.velocityZ = 0.0;
            this.motionZ = 0.0;
        } else {
            if (this.isBoatEmpty) {
                this.boatPosRotationIncrements = n + 5;
            } else {
                double d4 = d - this.posX;
                double d5 = d2 - this.posY;
                double d6 = d3 - this.posZ;
                double d7 = d4 * d4 + d5 * d5 + d6 * d6;
                if (d7 <= 1.0) {
                    return;
                }
                this.boatPosRotationIncrements = 3;
            }
            this.boatX = d;
            this.boatY = d2;
            this.boatZ = d3;
            this.boatYaw = f;
            this.boatPitch = f2;
            this.motionX = this.velocityX;
            this.motionY = this.velocityY;
            this.motionZ = this.velocityZ;
        }
    }

    @Override
    public void setVelocity(double d, double d2, double d3) {
        this.velocityX = this.motionX = d;
        this.velocityY = this.motionY = d2;
        this.velocityZ = this.motionZ = d3;
    }

    @Override
    public void onUpdate() {
        int n;
        double d;
        double d2;
        super.onUpdate();
        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        if (this.getDamageTaken() > 0.0f) {
            this.setDamageTaken(this.getDamageTaken() - 1.0f);
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        int n2 = 5;
        double d3 = 0.0;
        for (int i = 0; i < n2; ++i) {
            double d4 = this.getEntityBoundingBox().minY + (this.getEntityBoundingBox().maxY - this.getEntityBoundingBox().minY) * (double)(i + 0) / (double)n2 - 0.125;
            double d5 = this.getEntityBoundingBox().minY + (this.getEntityBoundingBox().maxY - this.getEntityBoundingBox().minY) * (double)(i + 1) / (double)n2 - 0.125;
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(this.getEntityBoundingBox().minX, d4, this.getEntityBoundingBox().minZ, this.getEntityBoundingBox().maxX, d5, this.getEntityBoundingBox().maxZ);
            if (!this.worldObj.isAABBInMaterial(axisAlignedBB, Material.water)) continue;
            d3 += 1.0 / (double)n2;
        }
        double d6 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (d6 > 0.2975) {
            d2 = Math.cos((double)this.rotationYaw * Math.PI / 180.0);
            d = Math.sin((double)this.rotationYaw * Math.PI / 180.0);
            n = 0;
            while ((double)n < 1.0 + d6 * 60.0) {
                double d7 = this.rand.nextFloat() * 2.0f - 1.0f;
                double d8 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7;
                if (this.rand.nextBoolean()) {
                    var15_24 = this.posX - d2 * d7 * 0.8 + d * d8;
                    var17_25 = this.posZ - d * d7 * 0.8 - d2 * d8;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, var15_24, this.posY - 0.125, var17_25, this.motionX, this.motionY, this.motionZ, new int[0]);
                } else {
                    var15_24 = this.posX + d2 + d * d7 * 0.7;
                    var17_25 = this.posZ + d - d2 * d7 * 0.7;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, var15_24, this.posY - 0.125, var17_25, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
                ++n;
            }
        }
        if (this.worldObj.isRemote && this.isBoatEmpty) {
            if (this.boatPosRotationIncrements > 0) {
                d2 = this.posX + (this.boatX - this.posX) / (double)this.boatPosRotationIncrements;
                d = this.posY + (this.boatY - this.posY) / (double)this.boatPosRotationIncrements;
                double d9 = this.posZ + (this.boatZ - this.posZ) / (double)this.boatPosRotationIncrements;
                double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - (double)this.rotationYaw);
                this.rotationYaw = (float)((double)this.rotationYaw + d10 / (double)this.boatPosRotationIncrements);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.boatPitch - (double)this.rotationPitch) / (double)this.boatPosRotationIncrements);
                --this.boatPosRotationIncrements;
                this.setPosition(d2, d, d9);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            } else {
                d2 = this.posX + this.motionX;
                d = this.posY + this.motionY;
                double d11 = this.posZ + this.motionZ;
                this.setPosition(d2, d, d11);
                if (this.onGround) {
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                }
                this.motionX *= (double)0.99f;
                this.motionY *= (double)0.95f;
                this.motionZ *= (double)0.99f;
            }
        } else {
            double d12;
            int n3;
            double d13;
            if (d3 < 1.0) {
                d2 = d3 * 2.0 - 1.0;
                this.motionY += (double)0.04f * d2;
            } else {
                if (this.motionY < 0.0) {
                    this.motionY /= 2.0;
                }
                this.motionY += (double)0.007f;
            }
            if (this.riddenByEntity instanceof EntityLivingBase) {
                EntityLivingBase entityLivingBase = (EntityLivingBase)this.riddenByEntity;
                float f = this.riddenByEntity.rotationYaw + -entityLivingBase.moveStrafing * 90.0f;
                this.motionX += -Math.sin(f * (float)Math.PI / 180.0f) * this.speedMultiplier * (double)entityLivingBase.moveForward * (double)0.05f;
                this.motionZ += Math.cos(f * (float)Math.PI / 180.0f) * this.speedMultiplier * (double)entityLivingBase.moveForward * (double)0.05f;
            }
            if ((d13 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ)) > 0.35) {
                d = 0.35 / d13;
                this.motionX *= d;
                this.motionZ *= d;
                d13 = 0.35;
            }
            if (d13 > d6 && this.speedMultiplier < 0.35) {
                this.speedMultiplier += (0.35 - this.speedMultiplier) / 35.0;
                if (this.speedMultiplier > 0.35) {
                    this.speedMultiplier = 0.35;
                }
            } else {
                this.speedMultiplier -= (this.speedMultiplier - 0.07) / 35.0;
                if (this.speedMultiplier < 0.07) {
                    this.speedMultiplier = 0.07;
                }
            }
            for (n3 = 0; n3 < 4; ++n3) {
                int n4 = MathHelper.floor_double(this.posX + ((double)(n3 % 2) - 0.5) * 0.8);
                n = MathHelper.floor_double(this.posZ + ((double)(n3 / 2) - 0.5) * 0.8);
                for (int i = 0; i < 2; ++i) {
                    int n5 = MathHelper.floor_double(this.posY) + i;
                    BlockPos blockPos = new BlockPos(n4, n5, n);
                    Block block = this.worldObj.getBlockState(blockPos).getBlock();
                    if (block == Blocks.snow_layer) {
                        this.worldObj.setBlockToAir(blockPos);
                        this.isCollidedHorizontally = false;
                        continue;
                    }
                    if (block != Blocks.waterlily) continue;
                    this.worldObj.destroyBlock(blockPos, true);
                    this.isCollidedHorizontally = false;
                }
            }
            if (this.onGround) {
                this.motionX *= 0.5;
                this.motionY *= 0.5;
                this.motionZ *= 0.5;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.isCollidedHorizontally && d6 > 0.2975) {
                if (!this.worldObj.isRemote && !this.isDead) {
                    this.setDead();
                    if (this.worldObj.getGameRules().getBoolean("doEntityDrops")) {
                        for (n3 = 0; n3 < 3; ++n3) {
                            this.dropItemWithOffset(Item.getItemFromBlock(Blocks.planks), 1, 0.0f);
                        }
                        for (n3 = 0; n3 < 2; ++n3) {
                            this.dropItemWithOffset(Items.stick, 1, 0.0f);
                        }
                    }
                }
            } else {
                this.motionX *= (double)0.99f;
                this.motionY *= (double)0.95f;
                this.motionZ *= (double)0.99f;
            }
            this.rotationPitch = 0.0f;
            double d14 = this.rotationYaw;
            double d15 = this.prevPosX - this.posX;
            double d16 = this.prevPosZ - this.posZ;
            if (d15 * d15 + d16 * d16 > 0.001) {
                d14 = (float)(MathHelper.atan2(d16, d15) * 180.0 / Math.PI);
            }
            if ((d12 = MathHelper.wrapAngleTo180_double(d14 - (double)this.rotationYaw)) > 20.0) {
                d12 = 20.0;
            }
            if (d12 < -20.0) {
                d12 = -20.0;
            }
            this.rotationYaw = (float)((double)this.rotationYaw + d12);
            this.setRotation(this.rotationYaw, this.rotationPitch);
            if (!this.worldObj.isRemote) {
                List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.2f, 0.0, 0.2f));
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); ++i) {
                        Entity entity = list.get(i);
                        if (entity == this.riddenByEntity || !entity.canBePushed() || !(entity instanceof EntityBoat)) continue;
                        entity.applyEntityCollision(this);
                    }
                }
                if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                    this.riddenByEntity = null;
                }
            }
        }
    }

    @Override
    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            double d = Math.cos((double)this.rotationYaw * Math.PI / 180.0) * 0.4;
            double d2 = Math.sin((double)this.rotationYaw * Math.PI / 180.0) * 0.4;
            this.riddenByEntity.setPosition(this.posX + d, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + d2);
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityPlayer) {
            return true;
        }
        if (!this.worldObj.isRemote) {
            entityPlayer.mountEntity(this);
        }
        return true;
    }

    @Override
    protected void updateFallState(double d, boolean bl, Block block, BlockPos blockPos) {
        if (bl) {
            if (this.fallDistance > 3.0f) {
                this.fall(this.fallDistance, 1.0f);
                if (!this.worldObj.isRemote && !this.isDead) {
                    this.setDead();
                    if (this.worldObj.getGameRules().getBoolean("doEntityDrops")) {
                        int n;
                        for (n = 0; n < 3; ++n) {
                            this.dropItemWithOffset(Item.getItemFromBlock(Blocks.planks), 1, 0.0f);
                        }
                        for (n = 0; n < 2; ++n) {
                            this.dropItemWithOffset(Items.stick, 1, 0.0f);
                        }
                    }
                }
                this.fallDistance = 0.0f;
            }
        } else if (this.worldObj.getBlockState(new BlockPos(this).down()).getBlock().getMaterial() != Material.water && d < 0.0) {
            this.fallDistance = (float)((double)this.fallDistance - d);
        }
    }

    public void setDamageTaken(float f) {
        this.dataWatcher.updateObject(19, Float.valueOf(f));
    }

    public float getDamageTaken() {
        return this.dataWatcher.getWatchableObjectFloat(19);
    }

    public void setTimeSinceHit(int n) {
        this.dataWatcher.updateObject(17, n);
    }

    public int getTimeSinceHit() {
        return this.dataWatcher.getWatchableObjectInt(17);
    }

    public void setForwardDirection(int n) {
        this.dataWatcher.updateObject(18, n);
    }

    public int getForwardDirection() {
        return this.dataWatcher.getWatchableObjectInt(18);
    }

    public void setIsBoatEmpty(boolean bl) {
        this.isBoatEmpty = bl;
    }
}

