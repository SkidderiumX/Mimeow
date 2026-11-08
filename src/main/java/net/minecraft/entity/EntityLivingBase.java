/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.viamcp.ViaMCP;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.ServersideAttributeMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.network.play.server.S04PacketEntityEquipment;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.network.play.server.S0DPacketCollectItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import x.oc09673369f7;
import x.oc25aa89b91f;
import x.oc4c5a4d3446;
import x.oc743046ab41;
import x.oc75d51ec7eb;
import x.oc85310462f3;
import x.oc9341368218;
import x.oc9755810e45;
import x.occ52191e479;
import x.ocd2ceabdd9a;
import x.ocea775c9d5c;
import x.ocee33618a8d;

public abstract class EntityLivingBase
extends Entity
implements oc09673369f7 {
    private static final UUID sprintingSpeedBoostModifierUUID = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
    private static final AttributeModifier sprintingSpeedBoostModifier = new AttributeModifier(sprintingSpeedBoostModifierUUID, "Sprinting speed boost", 0.3f, 2).setSaved(false);
    private BaseAttributeMap attributeMap;
    private final CombatTracker _combatTracker = new CombatTracker(this);
    private final Map<Integer, PotionEffect> activePotionsMap = Maps.newHashMap();
    private final ItemStack[] previousEquipment = new ItemStack[5];
    public boolean isSwingInProgress;
    public int swingProgressInt;
    public int arrowHitTimer;
    public int hurtTime;
    public int maxHurtTime;
    public float attackedAtYaw;
    public int deathTime;
    public float prevSwingProgress;
    public float swingProgress;
    public float prevLimbSwingAmount;
    public float limbSwingAmount;
    public float limbSwing;
    public int maxHurtResistantTime = 20;
    public float prevCameraPitch;
    public float cameraPitch;
    public float randomUnused2;
    public float randomUnused1;
    public float renderYawOffset;
    public float prevRenderYawOffset;
    public float rotationYawHead;
    public float prevRotationYawHead;
    public float jumpMovementFactor = 0.02f;
    protected EntityPlayer attackingPlayer;
    protected int recentlyHit;
    protected boolean dead;
    protected int entityAge;
    protected float prevOnGroundSpeedFactor;
    protected float onGroundSpeedFactor;
    protected float movedDistance;
    protected float prevMovedDistance;
    protected float unused180;
    protected int scoreValue;
    protected float lastDamage;
    protected boolean isJumping;
    public float moveStrafing;
    public float moveForward;
    protected float randomYawVelocity;
    protected int newPosRotationIncrements;
    protected double newPosX;
    protected double newPosY;
    protected double newPosZ;
    protected double newRotationYaw;
    protected double newRotationPitch;
    private boolean potionsNeedUpdate = true;
    private EntityLivingBase entityLivingToAttack;
    private int revengeTimer;
    private EntityLivingBase lastAttacker;
    private int lastAttackerTime;
    private float landMovementFactor;
    private int jumpTicks;
    private float absorptionAmount;

    @Override
    public void onKillCommand() {
        this.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
    }

    public EntityLivingBase(World world2) {
        super(world2);
        this.applyEntityAttributes();
        this.setHealth(this.getMaxHealth());
        this.preventEntitySpawning = true;
        this.randomUnused1 = (float)((Math.random() + 1.0) * (double)0.01f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.randomUnused2 = (float)Math.random() * 12398.0f;
        this.rotationYawHead = this.rotationYaw = (float)(Math.random() * Math.PI * 2.0);
        this.stepHeight = 0.6f;
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(7, 0);
        this.dataWatcher.addObject(8, (byte)0);
        this.dataWatcher.addObject(9, (byte)0);
        this.dataWatcher.addObject(6, Float.valueOf(1.0f));
    }

    protected void applyEntityAttributes() {
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.maxHealth);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.knockbackResistance);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.movementSpeed);
    }

    @Override
    protected void updateFallState(double d, boolean bl, Block block, BlockPos blockPos) {
        if (!this.isInWater()) {
            this.handleWaterMovement();
        }
        if (!this.worldObj.isRemote && this.fallDistance > 3.0f && bl) {
            IBlockState iBlockState = this.worldObj.getBlockState(blockPos);
            Block block2 = iBlockState.getBlock();
            float f = MathHelper.ceiling_float_int(this.fallDistance - 3.0f);
            if (block2.getMaterial() != Material.air) {
                double d2 = Math.min(0.2f + f / 15.0f, 10.0f);
                if (d2 > 2.5) {
                    d2 = 2.5;
                }
                int n = (int)(150.0 * d2);
                ((WorldServer)this.worldObj).spawnParticle(EnumParticleTypes.BLOCK_DUST, this.posX, this.posY, this.posZ, n, 0.0, 0.0, 0.0, (double)0.15f, Block.getStateId(iBlockState));
            }
        }
        super.updateFallState(d, bl, block, blockPos);
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    public void onEntityUpdate() {
        boolean bl;
        this.prevSwingProgress = this.swingProgress;
        super.onEntityUpdate();
        this.worldObj.theProfiler.startSection("livingEntityBaseTick");
        boolean bl2 = this instanceof EntityPlayer;
        if (this.isEntityAlive()) {
            double d;
            if (this.isEntityInsideOpaqueBlock()) {
                this.attackEntityFrom(DamageSource.inWall, 1.0f);
            } else if (bl2 && !this.worldObj.getWorldBorder().contains(this.getEntityBoundingBox()) && (d = this.worldObj.getWorldBorder().getClosestDistance(this) + this.worldObj.getWorldBorder().getDamageBuffer()) < 0.0) {
                this.attackEntityFrom(DamageSource.inWall, Math.max(1, MathHelper.floor_double(-d * this.worldObj.getWorldBorder().getDamageAmount())));
            }
        }
        if (this.isImmuneToFire() || this.worldObj.isRemote) {
            this.extinguish();
        }
        boolean bl3 = bl = bl2 && ((EntityPlayer)this).capabilities.disableDamage;
        if (this.isEntityAlive()) {
            if (this.isInsideOfMaterial(Material.water)) {
                if (!(this.canBreatheUnderwater() || this.isPotionActive(Potion.waterBreathing.id) || bl)) {
                    this.setAir(this.decreaseAirSupply(this.getAir()));
                    if (this.getAir() == -20) {
                        this.setAir(0);
                        for (int i = 0; i < 8; ++i) {
                            float f = this.rand.nextFloat() - this.rand.nextFloat();
                            float f2 = this.rand.nextFloat() - this.rand.nextFloat();
                            float f3 = this.rand.nextFloat() - this.rand.nextFloat();
                            this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (double)f, this.posY + (double)f2, this.posZ + (double)f3, this.motionX, this.motionY, this.motionZ, new int[0]);
                        }
                        this.attackEntityFrom(DamageSource.drown, 2.0f);
                    }
                }
                if (!this.worldObj.isRemote && this.isRiding() && this.ridingEntity instanceof EntityLivingBase) {
                    this.mountEntity(null);
                }
            } else {
                this.setAir(300);
            }
        }
        if (this.isEntityAlive() && this.isWet()) {
            this.extinguish();
        }
        this.prevCameraPitch = this.cameraPitch;
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
        if (this.hurtResistantTime > 0 && !(this instanceof EntityPlayerMP)) {
            --this.hurtResistantTime;
        }
        if (this.getHealth() <= 0.0f) {
            this.onDeathUpdate();
        }
        if (this.recentlyHit > 0) {
            --this.recentlyHit;
        } else {
            this.attackingPlayer = null;
        }
        if (this.lastAttacker != null && !this.lastAttacker.isEntityAlive()) {
            this.lastAttacker = null;
        }
        if (this.entityLivingToAttack != null) {
            if (!this.entityLivingToAttack.isEntityAlive()) {
                this.setRevengeTarget(null);
            } else if (this.ticksExisted - this.revengeTimer > 100) {
                this.setRevengeTarget(null);
            }
        }
        this.updatePotionEffects();
        this.prevMovedDistance = this.movedDistance;
        this.prevRenderYawOffset = this.renderYawOffset;
        this.prevRotationYawHead = this.rotationYawHead;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.worldObj.theProfiler.endSection();
    }

    public boolean isChild() {
        return false;
    }

    protected void onDeathUpdate() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            int n;
            if (!this.worldObj.isRemote && (this.recentlyHit > 0 || this.isPlayer()) && this.canDropLoot() && this.worldObj.getGameRules().getBoolean("doMobLoot")) {
                int n2;
                for (n = this.getExperiencePoints(this.attackingPlayer); n > 0; n -= n2) {
                    n2 = EntityXPOrb.getXPSplit(n);
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n2));
                }
            }
            this.setDead();
            for (n = 0; n < 20; ++n) {
                double d = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                double d3 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3, new int[0]);
            }
        }
    }

    protected boolean canDropLoot() {
        return !this.isChild();
    }

    protected int decreaseAirSupply(int n) {
        int n2 = EnchantmentHelper.getRespiration(this);
        return n2 > 0 && this.rand.nextInt(n2 + 1) > 0 ? n : n - 1;
    }

    protected int getExperiencePoints(EntityPlayer entityPlayer) {
        return 0;
    }

    protected boolean isPlayer() {
        return false;
    }

    public Random getRNG() {
        return this.rand;
    }

    public EntityLivingBase getAITarget() {
        return this.entityLivingToAttack;
    }

    public int getRevengeTimer() {
        return this.revengeTimer;
    }

    public void setRevengeTarget(EntityLivingBase entityLivingBase) {
        this.entityLivingToAttack = entityLivingBase;
        this.revengeTimer = this.ticksExisted;
    }

    public EntityLivingBase getLastAttacker() {
        return this.lastAttacker;
    }

    public int getLastAttackerTime() {
        return this.lastAttackerTime;
    }

    public void setLastAttacker(Entity entity) {
        this.lastAttacker = entity instanceof EntityLivingBase ? (EntityLivingBase)entity : null;
        this.lastAttackerTime = this.ticksExisted;
    }

    public int getAge() {
        return this.entityAge;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.setFloat("HealF", this.getHealth());
        nBTTagCompound.setShort("Health", (short)Math.ceil(this.getHealth()));
        nBTTagCompound.setShort("HurtTime", (short)this.hurtTime);
        nBTTagCompound.setInteger("HurtByTimestamp", this.revengeTimer);
        nBTTagCompound.setShort("DeathTime", (short)this.deathTime);
        nBTTagCompound.setFloat("AbsorptionAmount", this.getAbsorptionAmount());
        for (ItemStack itemStack : this.getInventory()) {
            if (itemStack == null) continue;
            this.attributeMap.removeAttributeModifiers(itemStack.getAttributeModifiers());
        }
        nBTTagCompound.setTag("Attributes", SharedMonsterAttributes.writeBaseAttributeMapToNBT(this.getAttributeMap()));
        for (ItemStack itemStack : this.getInventory()) {
            if (itemStack == null) continue;
            this.attributeMap.applyAttributeModifiers(itemStack.getAttributeModifiers());
        }
        if (!this.activePotionsMap.isEmpty()) {
            NBTTagList nBTTagList = new NBTTagList();
            for (PotionEffect potionEffect : this.activePotionsMap.values()) {
                nBTTagList.appendTag(potionEffect.writeCustomPotionEffectToNBT(new NBTTagCompound()));
            }
            nBTTagCompound.setTag("ActiveEffects", nBTTagList);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        NBTBase nBTBase;
        this.setAbsorptionAmount(nBTTagCompound.getFloat("AbsorptionAmount"));
        if (nBTTagCompound.hasKey("Attributes", 9) && this.worldObj != null && !this.worldObj.isRemote) {
            SharedMonsterAttributes.setAttributeModifiers(this.getAttributeMap(), nBTTagCompound.getTagList("Attributes", 10));
        }
        if (nBTTagCompound.hasKey("ActiveEffects", 9)) {
            nBTBase = nBTTagCompound.getTagList("ActiveEffects", 10);
            for (int i = 0; i < ((NBTTagList)nBTBase).tagCount(); ++i) {
                NBTTagCompound nBTTagCompound2 = ((NBTTagList)nBTBase).getCompoundTagAt(i);
                PotionEffect potionEffect = PotionEffect.readCustomPotionEffectFromNBT(nBTTagCompound2);
                if (potionEffect == null) continue;
                this.activePotionsMap.put(potionEffect.getPotionID(), potionEffect);
            }
        }
        if (nBTTagCompound.hasKey("HealF", 99)) {
            this.setHealth(nBTTagCompound.getFloat("HealF"));
        } else {
            nBTBase = nBTTagCompound.getTag("Health");
            if (nBTBase == null) {
                this.setHealth(this.getMaxHealth());
            } else if (nBTBase.getId() == 5) {
                this.setHealth(((NBTTagFloat)nBTBase).getFloat());
            } else if (nBTBase.getId() == 2) {
                this.setHealth(((NBTTagShort)nBTBase).getShort());
            }
        }
        this.hurtTime = nBTTagCompound.getShort("HurtTime");
        this.deathTime = nBTTagCompound.getShort("DeathTime");
        this.revengeTimer = nBTTagCompound.getInteger("HurtByTimestamp");
    }

    protected void updatePotionEffects() {
        boolean bl;
        Iterator<Integer> iterator2 = this.activePotionsMap.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer n = iterator2.next();
            PotionEffect potionEffect = this.activePotionsMap.get(n);
            if (!potionEffect.onUpdate(this)) {
                if (this.worldObj.isRemote) continue;
                iterator2.remove();
                this.onFinishedPotionEffect(potionEffect);
                continue;
            }
            if (potionEffect.getDuration() % 600 != 0) continue;
            this.onChangedPotionEffect(potionEffect, false);
        }
        if (this.potionsNeedUpdate) {
            if (!this.worldObj.isRemote) {
                this.updatePotionMetadata();
            }
            this.potionsNeedUpdate = false;
        }
        int n = this.dataWatcher.getWatchableObjectInt(7);
        boolean bl2 = bl = this.dataWatcher.getWatchableObjectByte(8) > 0;
        if (n > 0) {
            boolean bl3 = false;
            if (!this.isInvisible()) {
                bl3 = this.rand.nextBoolean();
            } else {
                boolean bl4 = bl3 = this.rand.nextInt(15) == 0;
            }
            if (bl) {
                bl3 &= this.rand.nextInt(5) == 0;
            }
            if (bl3 && n > 0) {
                double d = (double)(n >> 16 & 0xFF) / 255.0;
                double d2 = (double)(n >> 8 & 0xFF) / 255.0;
                double d3 = (double)(n >> 0 & 0xFF) / 255.0;
                this.worldObj.spawnParticle(bl ? EnumParticleTypes.SPELL_MOB_AMBIENT : EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, d, d2, d3, new int[0]);
            }
        }
    }

    protected void updatePotionMetadata() {
        if (this.activePotionsMap.isEmpty()) {
            this.resetPotionEffectMetadata();
            this.setInvisible(false);
        } else {
            int n = PotionHelper.calcPotionLiquidColor(this.activePotionsMap.values());
            this.dataWatcher.updateObject(8, (byte)(PotionHelper.getAreAmbient(this.activePotionsMap.values()) ? 1 : 0));
            this.dataWatcher.updateObject(7, n);
            this.setInvisible(this.isPotionActive(Potion.invisibility.id));
        }
    }

    protected void resetPotionEffectMetadata() {
        this.dataWatcher.updateObject(8, (byte)0);
        this.dataWatcher.updateObject(7, 0);
    }

    public void clearActivePotions() {
        Iterator<Integer> iterator2 = this.activePotionsMap.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer n = iterator2.next();
            PotionEffect potionEffect = this.activePotionsMap.get(n);
            if (this.worldObj.isRemote) continue;
            iterator2.remove();
            this.onFinishedPotionEffect(potionEffect);
        }
    }

    public Collection<PotionEffect> getActivePotionEffects() {
        return this.activePotionsMap.values();
    }

    public boolean isPotionActive(int n) {
        return this.activePotionsMap.containsKey(n);
    }

    public boolean isPotionActive(Potion potion) {
        occ52191e479 occ52191e4792 = new occ52191e479("isPotionActive", true);
        this.mimeow$isPotionActive(potion, occ52191e4792);
        return occ52191e4792.z$24lpjeeur71n9() ? occ52191e4792.\u016f() : this.activePotionsMap.containsKey(potion.id);
    }

    public PotionEffect getActivePotionEffect(Potion potion) {
        return this.activePotionsMap.get(potion.id);
    }

    public void addPotionEffect(PotionEffect potionEffect) {
        if (this.isPotionApplicable(potionEffect)) {
            if (this.activePotionsMap.containsKey(potionEffect.getPotionID())) {
                this.activePotionsMap.get(potionEffect.getPotionID()).combine(potionEffect);
                this.onChangedPotionEffect(this.activePotionsMap.get(potionEffect.getPotionID()), true);
            } else {
                this.activePotionsMap.put(potionEffect.getPotionID(), potionEffect);
                this.onNewPotionEffect(potionEffect);
            }
        }
    }

    public boolean isPotionApplicable(PotionEffect potionEffect) {
        int n;
        return this.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD || (n = potionEffect.getPotionID()) != Potion.regeneration.id && n != Potion.poison.id;
    }

    public boolean isEntityUndead() {
        return this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD;
    }

    public void removePotionEffectClient(int n) {
        this.activePotionsMap.remove(n);
    }

    public void removePotionEffect(int n) {
        PotionEffect potionEffect = this.activePotionsMap.remove(n);
        if (potionEffect != null) {
            this.onFinishedPotionEffect(potionEffect);
        }
    }

    protected void onNewPotionEffect(PotionEffect potionEffect) {
        this.potionsNeedUpdate = true;
        if (!this.worldObj.isRemote) {
            Potion.potionTypes[potionEffect.getPotionID()].applyAttributesModifiersToEntity(this, this.getAttributeMap(), potionEffect.getAmplifier());
        }
    }

    protected void onChangedPotionEffect(PotionEffect potionEffect, boolean bl) {
        this.potionsNeedUpdate = true;
        if (bl && !this.worldObj.isRemote) {
            Potion.potionTypes[potionEffect.getPotionID()].removeAttributesModifiersFromEntity(this, this.getAttributeMap(), potionEffect.getAmplifier());
            Potion.potionTypes[potionEffect.getPotionID()].applyAttributesModifiersToEntity(this, this.getAttributeMap(), potionEffect.getAmplifier());
        }
    }

    protected void onFinishedPotionEffect(PotionEffect potionEffect) {
        this.potionsNeedUpdate = true;
        if (!this.worldObj.isRemote) {
            Potion.potionTypes[potionEffect.getPotionID()].removeAttributesModifiersFromEntity(this, this.getAttributeMap(), potionEffect.getAmplifier());
        }
    }

    public void heal(float f) {
        float f2 = this.getHealth();
        if (f2 > 0.0f) {
            this.setHealth(f2 + f);
        }
    }

    public final float getHealth() {
        return this.dataWatcher.getWatchableObjectFloat(6);
    }

    public void setHealth(float f) {
        this.dataWatcher.updateObject(6, Float.valueOf(MathHelper.clamp_float(f, 0.0f, this.getMaxHealth())));
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        Object object;
        if (this.isEntityInvulnerable(damageSource)) {
            return false;
        }
        if (this.worldObj.isRemote) {
            return false;
        }
        this.entityAge = 0;
        if (this.getHealth() <= 0.0f) {
            return false;
        }
        if (damageSource.isFireDamage() && this.isPotionActive(Potion.fireResistance)) {
            return false;
        }
        if ((damageSource == DamageSource.anvil || damageSource == DamageSource.fallingBlock) && this.getEquipmentInSlot(4) != null) {
            this.getEquipmentInSlot(4).damageItem((int)(f * 4.0f + this.rand.nextFloat() * f * 2.0f), this);
            f *= 0.75f;
        }
        this.limbSwingAmount = 1.5f;
        boolean bl = true;
        if ((float)this.hurtResistantTime > (float)this.maxHurtResistantTime / 2.0f) {
            if (f <= this.lastDamage) {
                return false;
            }
            this.damageEntity(damageSource, f - this.lastDamage);
            this.lastDamage = f;
            bl = false;
        } else {
            this.lastDamage = f;
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.damageEntity(damageSource, f);
            this.maxHurtTime = 10;
            this.hurtTime = 10;
        }
        this.attackedAtYaw = 0.0f;
        Entity entity = damageSource.getEntity();
        if (entity != null) {
            if (entity instanceof EntityLivingBase) {
                this.setRevengeTarget((EntityLivingBase)entity);
            }
            if (entity instanceof EntityPlayer) {
                this.recentlyHit = 100;
                this.attackingPlayer = (EntityPlayer)entity;
            } else if (entity instanceof EntityWolf && ((EntityTameable)(object = (EntityWolf)entity)).isTamed()) {
                this.recentlyHit = 100;
                this.attackingPlayer = null;
            }
        }
        if (bl) {
            this.worldObj.setEntityState(this, (byte)2);
            if (damageSource != DamageSource.drown) {
                this.setBeenAttacked();
            }
            if (entity != null) {
                double d = entity.posX - this.posX;
                double d2 = entity.posZ - this.posZ;
                while (d * d + d2 * d2 < 1.0E-4) {
                    d = (Math.random() - Math.random()) * 0.01;
                    d2 = (Math.random() - Math.random()) * 0.01;
                }
                this.attackedAtYaw = (float)(MathHelper.atan2(d2, d) * 180.0 / Math.PI - (double)this.rotationYaw);
                this.knockBack(entity, f, d, d2);
            } else {
                this.attackedAtYaw = (int)(Math.random() * 2.0) * 180;
            }
        }
        if (this.getHealth() <= 0.0f) {
            object = this.getDeathSound();
            if (bl && object != null) {
                this.playSound((String)object, this.getSoundVolume(), this.getSoundPitch());
            }
            this.onDeath(damageSource);
        } else {
            object = this.getHurtSound();
            if (bl && object != null) {
                this.playSound((String)object, this.getSoundVolume(), this.getSoundPitch());
            }
        }
        return true;
    }

    public void renderBrokenItemStack(ItemStack itemStack) {
        this.playSound("random.break", 0.8f, 0.8f + this.worldObj.rand.nextFloat() * 0.4f);
        for (int i = 0; i < 5; ++i) {
            Vec3 vec3 = new Vec3(((double)this.rand.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            vec3 = vec3.rotatePitch(-this.rotationPitch * (float)Math.PI / 180.0f);
            vec3 = vec3.rotateYaw(-this.rotationYaw * (float)Math.PI / 180.0f);
            double d = (double)(-this.rand.nextFloat()) * 0.6 - 0.3;
            Vec3 vec32 = new Vec3(((double)this.rand.nextFloat() - 0.5) * 0.3, d, 0.6);
            vec32 = vec32.rotatePitch(-this.rotationPitch * (float)Math.PI / 180.0f);
            vec32 = vec32.rotateYaw(-this.rotationYaw * (float)Math.PI / 180.0f);
            vec32 = vec32.addVector(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, vec32.xCoord, vec32.yCoord, vec32.zCoord, vec3.xCoord, vec3.yCoord + 0.05, vec3.zCoord, Item.getIdFromItem(itemStack.getItem()));
        }
    }

    public void onDeath(DamageSource damageSource) {
        Entity entity = damageSource.getEntity();
        EntityLivingBase entityLivingBase = this.getAttackingEntity();
        if (this.scoreValue >= 0 && entityLivingBase != null) {
            entityLivingBase.addToPlayerScore(this, this.scoreValue);
        }
        if (entity != null) {
            entity.onKillEntity(this);
        }
        this.dead = true;
        this.getCombatTracker().reset();
        if (!this.worldObj.isRemote) {
            int n = 0;
            if (entity instanceof EntityPlayer) {
                n = EnchantmentHelper.getLootingModifier((EntityLivingBase)entity);
            }
            if (this.canDropLoot() && this.worldObj.getGameRules().getBoolean("doMobLoot")) {
                this.dropFewItems(this.recentlyHit > 0, n);
                this.dropEquipment(this.recentlyHit > 0, n);
                if (this.recentlyHit > 0 && this.rand.nextFloat() < 0.025f + (float)n * 0.01f) {
                    this.addRandomDrop();
                }
            }
        }
        this.worldObj.setEntityState(this, (byte)3);
    }

    protected void dropEquipment(boolean bl, int n) {
    }

    public void knockBack(Entity entity, float f, double d, double d2) {
        if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue()) {
            this.isAirBorne = true;
            float f2 = MathHelper.sqrt_double(d * d + d2 * d2);
            float f3 = 0.4f;
            this.motionX /= 2.0;
            this.motionY /= 2.0;
            this.motionZ /= 2.0;
            this.motionX -= d / (double)f2 * (double)f3;
            this.motionY += (double)f3;
            this.motionZ -= d2 / (double)f2 * (double)f3;
            if (this.motionY > (double)0.4f) {
                this.motionY = 0.4f;
            }
        }
    }

    protected String getHurtSound() {
        return "game.neutral.hurt";
    }

    protected String getDeathSound() {
        return "game.neutral.die";
    }

    protected void addRandomDrop() {
    }

    protected void dropFewItems(boolean bl, int n) {
    }

    public boolean isOnLadder() {
        int n;
        int n2;
        int n3 = MathHelper.floor_double(this.posX);
        Block block = this.worldObj.getBlockState(new BlockPos(n3, n2 = MathHelper.floor_double(this.getEntityBoundingBox().minY), n = MathHelper.floor_double(this.posZ))).getBlock();
        return !(block != Blocks.ladder && block != Blocks.vine || this instanceof EntityPlayer && ((EntityPlayer)this).isSpectator());
    }

    @Override
    public boolean isEntityAlive() {
        return !this.isDead && this.getHealth() > 0.0f;
    }

    @Override
    public void fall(float f, float f2) {
        super.fall(f, f2);
        PotionEffect potionEffect = this.getActivePotionEffect(Potion.jump);
        float f3 = potionEffect != null ? (float)(potionEffect.getAmplifier() + 1) : 0.0f;
        int n = MathHelper.ceiling_float_int((f - 3.0f - f3) * f2);
        if (n > 0) {
            this.playSound(this.getFallSoundString(n), 1.0f, 1.0f);
            this.attackEntityFrom(DamageSource.fall, n);
            int n2 = MathHelper.floor_double(this.posX);
            int n3 = MathHelper.floor_double(this.posY - (double)0.2f);
            int n4 = MathHelper.floor_double(this.posZ);
            Block block = this.worldObj.getBlockState(new BlockPos(n2, n3, n4)).getBlock();
            if (block.getMaterial() != Material.air) {
                Block.SoundType soundType = block.stepSound;
                this.playSound(soundType.getStepSound(), soundType.getVolume() * 0.5f, soundType.getFrequency() * 0.75f);
            }
        }
    }

    protected String getFallSoundString(int n) {
        return n > 4 ? "game.neutral.hurt.fall.big" : "game.neutral.hurt.fall.small";
    }

    @Override
    public void performHurtAnimation() {
        this.maxHurtTime = 10;
        this.hurtTime = 10;
        this.attackedAtYaw = 0.0f;
    }

    public int getTotalArmorValue() {
        int n = 0;
        for (ItemStack itemStack : this.getInventory()) {
            if (itemStack == null || !(itemStack.getItem() instanceof ItemArmor)) continue;
            int n2 = ((ItemArmor)itemStack.getItem()).damageReduceAmount;
            n += n2;
        }
        return n;
    }

    protected void damageArmor(float f) {
    }

    protected float applyArmorCalculations(DamageSource damageSource, float f) {
        if (!damageSource.isUnblockable()) {
            int n = 25 - this.getTotalArmorValue();
            float f2 = f * (float)n;
            this.damageArmor(f);
            f = f2 / 25.0f;
        }
        return f;
    }

    protected float applyPotionDamageCalculations(DamageSource damageSource, float f) {
        float f2;
        int n;
        int n2;
        if (damageSource.isDamageAbsolute()) {
            return f;
        }
        if (this.isPotionActive(Potion.resistance) && damageSource != DamageSource.outOfWorld) {
            n2 = (this.getActivePotionEffect(Potion.resistance).getAmplifier() + 1) * 5;
            n = 25 - n2;
            f2 = f * (float)n;
            f = f2 / 25.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        n2 = EnchantmentHelper.getEnchantmentModifierDamage(this.getInventory(), damageSource);
        if (n2 > 20) {
            n2 = 20;
        }
        if (n2 > 0 && n2 <= 20) {
            n = 25 - n2;
            f2 = f * (float)n;
            f = f2 / 25.0f;
        }
        return f;
    }

    protected void damageEntity(DamageSource damageSource, float f) {
        if (!this.isEntityInvulnerable(damageSource)) {
            f = this.applyArmorCalculations(damageSource, f);
            float f2 = f = this.applyPotionDamageCalculations(damageSource, f);
            f = Math.max(f - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f2 - f));
            if (f != 0.0f) {
                float f3 = this.getHealth();
                this.setHealth(f3 - f);
                this.getCombatTracker().trackDamage(damageSource, f3, f);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - f);
            }
        }
    }

    public CombatTracker getCombatTracker() {
        return this._combatTracker;
    }

    public EntityLivingBase getAttackingEntity() {
        return this._combatTracker.func_94550_c() != null ? this._combatTracker.func_94550_c() : (this.attackingPlayer != null ? this.attackingPlayer : (this.entityLivingToAttack != null ? this.entityLivingToAttack : null));
    }

    public final float getMaxHealth() {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
    }

    public final int getArrowCountInEntity() {
        return this.dataWatcher.getWatchableObjectByte(9);
    }

    public final void setArrowCountInEntity(int n) {
        this.dataWatcher.updateObject(9, (byte)n);
    }

    private int getArmSwingAnimationEnd() {
        occ52191e479 occ52191e4792 = new occ52191e479("getArmSwingAnimationEnd", true);
        this.mimeow$onGetArmSwingAnimationEnd(occ52191e4792);
        return occ52191e4792.z$24lpjeeur71n9() ? occ52191e4792.\u0102() : (this.isPotionActive(Potion.digSpeed) ? 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1 : (this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6));
    }

    public void swingItem() {
        if (!this.isSwingInProgress || this.swingProgressInt >= this.getArmSwingAnimationEnd() / 2 || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwingInProgress = true;
            if (this.worldObj instanceof WorldServer) {
                ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S0BPacketAnimation(this, 0));
            }
        }
    }

    @Override
    public void handleStatusUpdate(byte by) {
        if (by == 2) {
            this.limbSwingAmount = 1.5f;
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.maxHurtTime = 10;
            this.hurtTime = 10;
            this.attackedAtYaw = 0.0f;
            String string = this.getHurtSound();
            if (string != null) {
                this.playSound(this.getHurtSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.attackEntityFrom(DamageSource.generic, 0.0f);
        } else if (by == 3) {
            String string = this.getDeathSound();
            if (string != null) {
                this.playSound(this.getDeathSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.setHealth(0.0f);
            this.onDeath(DamageSource.generic);
        } else {
            super.handleStatusUpdate(by);
        }
    }

    @Override
    protected void kill() {
        this.attackEntityFrom(DamageSource.outOfWorld, 4.0f);
    }

    protected void updateArmSwingProgress() {
        int n = this.getArmSwingAnimationEnd();
        if (this.isSwingInProgress) {
            ++this.swingProgressInt;
            if (this.swingProgressInt >= n) {
                this.swingProgressInt = 0;
                this.isSwingInProgress = false;
            }
        } else {
            this.swingProgressInt = 0;
        }
        this.swingProgress = (float)this.swingProgressInt / (float)n;
    }

    public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
        return this.getAttributeMap().getAttributeInstance(iAttribute);
    }

    public BaseAttributeMap getAttributeMap() {
        if (this.attributeMap == null) {
            this.attributeMap = new ServersideAttributeMap();
        }
        return this.attributeMap;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    public abstract ItemStack getHeldItem();

    public abstract ItemStack getEquipmentInSlot(int var1);

    public abstract ItemStack getCurrentArmor(int var1);

    @Override
    public abstract void setCurrentItemOrArmor(int var1, ItemStack var2);

    @Override
    public void setSprinting(boolean bl) {
        super.setSprinting(bl);
        IAttributeInstance iAttributeInstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
        if (iAttributeInstance.getModifier(sprintingSpeedBoostModifierUUID) != null) {
            iAttributeInstance.removeModifier(sprintingSpeedBoostModifier);
        }
        if (bl) {
            iAttributeInstance.applyModifier(sprintingSpeedBoostModifier);
        }
    }

    @Override
    public abstract ItemStack[] getInventory();

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float getSoundPitch() {
        return this.isChild() ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.5f : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f;
    }

    protected boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f;
    }

    public void dismountEntity(Entity entity) {
        double d = entity.posX;
        double d2 = entity.getEntityBoundingBox().minY + (double)entity.height;
        double d3 = entity.posZ;
        int n = 1;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j < n; ++j) {
                if (i == 0 && j == 0) continue;
                int n2 = (int)(this.posX + (double)i);
                int n3 = (int)(this.posZ + (double)j);
                AxisAlignedBB axisAlignedBB = this.getEntityBoundingBox().offset(i, 1.0, j);
                if (!this.worldObj.getCollisionBoxes(axisAlignedBB).isEmpty()) continue;
                if (World.doesBlockHaveSolidTopSurface(this.worldObj, new BlockPos(n2, (int)this.posY, n3))) {
                    this.setPositionAndUpdate(this.posX + (double)i, this.posY + 1.0, this.posZ + (double)j);
                    return;
                }
                if (!World.doesBlockHaveSolidTopSurface(this.worldObj, new BlockPos(n2, (int)this.posY - 1, n3)) && this.worldObj.getBlockState(new BlockPos(n2, (int)this.posY - 1, n3)).getBlock().getMaterial() != Material.water) continue;
                d = this.posX + (double)i;
                d2 = this.posY + 1.0;
                d3 = this.posZ + (double)j;
            }
        }
        this.setPositionAndUpdate(d, d2, d3);
    }

    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return false;
    }

    protected float getJumpUpwardsMotion() {
        return 0.42f;
    }

    protected void updateAITick() {
        this.motionY += (double)0.04f;
    }

    protected void handleJumpLava() {
        this.motionY += (double)0.04f;
    }

    public void moveEntityWithHeading(float f, float f2) {
        if (this.isServerWorld()) {
            if (!this.isInWater() || this instanceof EntityPlayer && ((EntityPlayer)this).capabilities.isFlying) {
                if (!this.isInLava() || this instanceof EntityPlayer && ((EntityPlayer)this).capabilities.isFlying) {
                    float f3 = 0.91f;
                    if (this.onGround) {
                        f3 = this.worldObj.getBlockState((BlockPos)new BlockPos((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.getEntityBoundingBox().minY) - 1), (int)MathHelper.floor_double((double)this.posZ))).getBlock().slipperiness * 0.91f;
                    }
                    float f4 = 0.16277136f / (f3 * f3 * f3);
                    var5_8 = this.onGround ? this.getAIMoveSpeed() * f4 : this.jumpMovementFactor;
                    this.moveFlying(f, f2, var5_8);
                    f3 = 0.91f;
                    if (this.onGround) {
                        f3 = this.worldObj.getBlockState((BlockPos)new BlockPos((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.getEntityBoundingBox().minY) - 1), (int)MathHelper.floor_double((double)this.posZ))).getBlock().slipperiness * 0.91f;
                    }
                    if (this.isOnLadder()) {
                        boolean bl;
                        float f5 = 0.15f;
                        this.motionX = MathHelper.clamp_double(this.motionX, -f5, f5);
                        this.motionZ = MathHelper.clamp_double(this.motionZ, -f5, f5);
                        this.fallDistance = 0.0f;
                        if (this.motionY < -0.15) {
                            this.motionY = -0.15;
                        }
                        boolean bl2 = bl = this.isSneaking() && this instanceof EntityPlayer;
                        if (bl && this.motionY < 0.0) {
                            this.motionY = 0.0;
                        }
                    }
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                    if (this.isCollidedHorizontally && this.isOnLadder()) {
                        this.motionY = 0.2;
                    }
                    this.motionY = !(!this.worldObj.isRemote || this.worldObj.isBlockLoaded(new BlockPos((int)this.posX, 0, (int)this.posZ)) && this.worldObj.getChunkFromBlockCoords(new BlockPos((int)this.posX, 0, (int)this.posZ)).isLoaded()) ? (this.posY > 0.0 ? -0.1 : 0.0) : (this.motionY -= 0.08);
                    this.motionY *= (double)0.98f;
                    this.motionX *= (double)f3;
                    this.motionZ *= (double)f3;
                } else {
                    double d = this.posY;
                    this.moveFlying(f, f2, 0.02f);
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                    this.motionY -= 0.02;
                    if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + (double)0.6f - this.posY + d, this.motionZ)) {
                        this.motionY = 0.3f;
                    }
                }
            } else {
                double d = this.posY;
                var5_8 = 0.8f;
                float f6 = 0.02f;
                float f7 = EnchantmentHelper.getDepthStriderModifier(this);
                if (f7 > 3.0f) {
                    f7 = 3.0f;
                }
                if (!this.onGround) {
                    f7 *= 0.5f;
                }
                if (f7 > 0.0f) {
                    var5_8 += (0.54600006f - var5_8) * f7 / 3.0f;
                    f6 += (this.getAIMoveSpeed() * 1.0f - f6) * f7 / 3.0f;
                }
                this.moveFlying(f, f2, f6);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= (double)var5_8;
                this.motionY *= (double)0.8f;
                this.motionZ *= (double)var5_8;
                this.motionY -= 0.02;
                if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + (double)0.6f - this.posY + d, this.motionZ)) {
                    this.motionY = 0.3f;
                }
            }
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        float f8 = MathHelper.sqrt_double(d * d + d2 * d2) * 4.0f;
        if (f8 > 1.0f) {
            f8 = 1.0f;
        }
        this.limbSwingAmount += (f8 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }

    public float getAIMoveSpeed() {
        return this.landMovementFactor;
    }

    @Override
    public float getLandMovementFactor() {
        return this.landMovementFactor;
    }

    public void setAIMoveSpeed(float f) {
        this.landMovementFactor = f;
    }

    public boolean attackEntityAsMob(Entity entity) {
        this.setLastAttacker(entity);
        return false;
    }

    public boolean isPlayerSleeping() {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            int n = this.getArrowCountInEntity();
            if (n > 0) {
                if (this.arrowHitTimer <= 0) {
                    this.arrowHitTimer = 20 * (30 - n);
                }
                --this.arrowHitTimer;
                if (this.arrowHitTimer <= 0) {
                    this.setArrowCountInEntity(n - 1);
                }
            }
            for (int i = 0; i < 5; ++i) {
                ItemStack itemStack = this.previousEquipment[i];
                ItemStack itemStack2 = this.getEquipmentInSlot(i);
                if (ItemStack.areItemStacksEqual(itemStack2, itemStack)) continue;
                ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S04PacketEntityEquipment(this.getEntityId(), i, itemStack2));
                if (itemStack != null) {
                    this.attributeMap.removeAttributeModifiers(itemStack.getAttributeModifiers());
                }
                if (itemStack2 != null) {
                    this.attributeMap.applyAttributeModifiers(itemStack2.getAttributeModifiers());
                }
                this.previousEquipment[i] = itemStack2 == null ? null : itemStack2.copy();
            }
            if (this.ticksExisted % 20 == 0) {
                this.getCombatTracker().reset();
            }
        }
        this.onLivingUpdate();
        double d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        float f = (float)(d * d + d2 * d2);
        float f2 = this.renderYawOffset;
        float f3 = 0.0f;
        this.prevOnGroundSpeedFactor = this.onGroundSpeedFactor;
        float f4 = 0.0f;
        if (f > 0.0025000002f) {
            f4 = 1.0f;
            f3 = (float)Math.sqrt(f) * 3.0f;
            f2 = (float)MathHelper.atan2(d2, d) * 180.0f / (float)Math.PI - 90.0f;
        }
        if (this.swingProgress > 0.0f) {
            f2 = this.rotationYaw;
        }
        if (!this.onGround) {
            f4 = 0.0f;
        }
        this.onGroundSpeedFactor += (f4 - this.onGroundSpeedFactor) * 0.3f;
        this.worldObj.theProfiler.startSection("headTurn");
        f3 = this.updateDistance(f2, f3);
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("rangeChecks");
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset < -180.0f) {
            this.prevRenderYawOffset -= 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180.0f) {
            this.prevRenderYawOffset += 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead < -180.0f) {
            this.prevRotationYawHead -= 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead >= 180.0f) {
            this.prevRotationYawHead += 360.0f;
        }
        this.worldObj.theProfiler.endSection();
        this.movedDistance += f3;
    }

    protected float updateDistance(float f, float f2) {
        boolean bl;
        occ52191e479 occ52191e4792 = new occ52191e479("updateDistance", true);
        this.mimeow$injectUpdateDistance(f, f2, occ52191e4792);
        if (occ52191e4792.z$24lpjeeur71n9()) {
            return occ52191e4792.\u0439();
        }
        float f3 = MathHelper.wrapAngleTo180_float(f - this.renderYawOffset);
        this.renderYawOffset += f3 * 0.3f;
        float f4 = MathHelper.wrapAngleTo180_float(this.rotationYaw - this.renderYawOffset);
        boolean bl2 = bl = f4 < -90.0f || f4 >= 90.0f;
        if (f4 < -75.0f) {
            f4 = -75.0f;
        }
        if (f4 >= 75.0f) {
            f4 = 75.0f;
        }
        this.renderYawOffset = this.rotationYaw - f4;
        if (f4 * f4 > 2500.0f) {
            this.renderYawOffset += f4 * 0.2f;
        }
        if (bl) {
            f2 *= -1.0f;
        }
        return f2;
    }

    public void onLivingUpdate() {
        double d;
        this.mimeow$livingUpdate(new ocee33618a8d("onLivingUpdate", false));
        if (this.jumpTicks > 0) {
            --this.jumpTicks;
        }
        if (this.newPosRotationIncrements > 0) {
            d = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
            double d2 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
            double d3 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
            double d4 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d4 / (double)this.newPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.setPosition(d, d2, d3);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        } else if (!this.isServerWorld()) {
            this.motionX *= 0.98;
            this.motionY *= 0.98;
            this.motionZ *= 0.98;
        }
        double d5 = d = ViaMCP.isTargetVersionAtLeast(ProtocolVersion.v1_9) ? 0.003 : 0.005;
        if (Math.abs(this.motionX) < d) {
            this.motionX = 0.0;
        }
        if (Math.abs(this.motionY) < d) {
            this.motionY = 0.0;
        }
        if (Math.abs(this.motionZ) < d) {
            this.motionZ = 0.0;
        }
        this.worldObj.theProfiler.startSection("ai");
        if (this.isMovementBlocked()) {
            this.isJumping = false;
            this.moveStrafing = 0.0f;
            this.moveForward = 0.0f;
            this.randomYawVelocity = 0.0f;
        } else if (this.isServerWorld()) {
            this.worldObj.theProfiler.startSection("newAi");
            this.updateEntityActionState();
            this.worldObj.theProfiler.endSection();
        }
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("jump");
        if (this.isJumping) {
            if (this.isInWater()) {
                this.updateAITick();
            } else if (this.isInLava()) {
                this.handleJumpLava();
            } else if (this.onGround && this.jumpTicks == 0) {
                this.jump();
                this.jumpTicks = 10;
            }
        } else {
            this.jumpTicks = 0;
        }
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("travel");
        this.moveStrafing *= 0.98f;
        this.moveForward *= 0.98f;
        this.randomYawVelocity *= 0.9f;
        float f = this.moveForward;
        float f2 = this.moveStrafing;
        this.mimeow$redirect$onMoveEntityWithHeadingRedirect(this, f2, f);
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("push");
        if (!this.worldObj.isRemote) {
            this.collideWithNearbyEntities();
        }
        this.worldObj.theProfiler.endSection();
    }

    protected void updateEntityActionState() {
    }

    protected void collideWithNearbyEntities() {
        List<Entity> list = this.worldObj.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(0.2f, 0.0, 0.2f), Predicates.and(EntitySelectors.NOT_SPECTATING, new Predicate<Entity>(){

            @Override
            public boolean apply(Entity entity) {
                return entity.canBePushed();
            }
        }));
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = list.get(i);
                this.collideWithEntity(entity);
            }
        }
    }

    protected void collideWithEntity(Entity entity) {
        entity.applyEntityCollision(this);
    }

    @Override
    public void mountEntity(Entity entity) {
        if (this.ridingEntity != null && entity == null) {
            if (!this.worldObj.isRemote) {
                this.dismountEntity(this.ridingEntity);
            }
            if (this.ridingEntity != null) {
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
        } else {
            super.mountEntity(entity);
        }
    }

    @Override
    public void updateRidden() {
        super.updateRidden();
        this.prevOnGroundSpeedFactor = this.onGroundSpeedFactor;
        this.onGroundSpeedFactor = 0.0f;
        this.fallDistance = 0.0f;
    }

    @Override
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n, boolean bl) {
        this.newPosX = d;
        this.newPosY = d2;
        this.newPosZ = d3;
        this.newRotationYaw = f;
        this.newRotationPitch = f2;
        this.newPosRotationIncrements = n;
    }

    public void setJumping(boolean bl) {
        this.isJumping = bl;
    }

    public void onItemPickup(Entity entity, int n) {
        if (!entity.isDead && !this.worldObj.isRemote) {
            EntityTracker entityTracker = ((WorldServer)this.worldObj).getEntityTracker();
            if (entity instanceof EntityItem) {
                entityTracker.sendToAllTrackingEntity(entity, new S0DPacketCollectItem(entity.getEntityId(), this.getEntityId()));
            }
            if (entity instanceof EntityArrow) {
                entityTracker.sendToAllTrackingEntity(entity, new S0DPacketCollectItem(entity.getEntityId(), this.getEntityId()));
            }
            if (entity instanceof EntityXPOrb) {
                entityTracker.sendToAllTrackingEntity(entity, new S0DPacketCollectItem(entity.getEntityId(), this.getEntityId()));
            }
        }
    }

    public boolean canEntityBeSeen(Entity entity) {
        return this.worldObj.rayTraceBlocks(new Vec3(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ), new Vec3(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ)) == null;
    }

    @Override
    public Vec3 getLookVec() {
        return this.getLook(1.0f);
    }

    @Override
    public Vec3 getLook(float f) {
        if (f == 1.0f) {
            return this.getVectorForRotation(this.rotationPitch, this.rotationYawHead);
        }
        float f2 = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * f;
        float f3 = this.prevRotationYawHead + (this.rotationYawHead - this.prevRotationYawHead) * f;
        return this.getVectorForRotation(f2, f3);
    }

    public float getSwingProgress(float f) {
        float f2 = this.swingProgress - this.prevSwingProgress;
        if (f2 < 0.0f) {
            f2 += 1.0f;
        }
        return this.prevSwingProgress + f2 * f;
    }

    public boolean isServerWorld() {
        return !this.worldObj.isRemote;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public boolean canBePushed() {
        return !this.isDead;
    }

    @Override
    protected void setBeenAttacked() {
        this.velocityChanged = this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();
    }

    @Override
    public float getRotationYawHead() {
        return this.rotationYawHead;
    }

    @Override
    public void setRotationYawHead(float f) {
        this.rotationYawHead = f;
    }

    @Override
    public void setRenderYawOffset(float f) {
        this.renderYawOffset = f;
    }

    public float getAbsorptionAmount() {
        return this.absorptionAmount;
    }

    public void setAbsorptionAmount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.absorptionAmount = f;
    }

    public Team getTeam() {
        return this.worldObj.getScoreboard().getPlayersTeam(this.getUniqueID().toString());
    }

    public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
        return this.isOnTeam(entityLivingBase.getTeam());
    }

    public boolean isOnTeam(Team team) {
        return this.getTeam() != null ? this.getTeam().isSameTeam(team) : false;
    }

    public void sendEnterCombat() {
    }

    public void sendEndCombat() {
    }

    protected void markPotionsDirty() {
        this.potionsNeedUpdate = true;
    }

    protected void mimeow$injectUpdateDistance(float f, float f2, occ52191e479 occ52191e4792) {
        boolean bl;
        float f3 = this.rotationYaw;
        if (this instanceof EntityPlayerSP && oc25aa89b91f.\u0171()) {
            if (this.swingProgress > 0.0f) {
                f = oc75d51ec7eb.\u014f;
            }
            f3 = oc75d51ec7eb.\u014f;
            this.rotationYawHead = oc75d51ec7eb.\u014f;
        }
        float f4 = MathHelper.wrapAngleTo180_float(f - this.renderYawOffset);
        this.renderYawOffset += f4 * 0.3f;
        float f5 = MathHelper.wrapAngleTo180_float(f3 - this.renderYawOffset);
        boolean bl2 = bl = f5 < -90.0f || f5 >= 90.0f;
        if (f5 < -75.0f) {
            f5 = -75.0f;
        }
        if (f5 >= 75.0f) {
            f5 = 75.0f;
        }
        this.renderYawOffset = f3 - f5;
        if (f5 * f5 > 2500.0f) {
            this.renderYawOffset += f5 * 0.2f;
        }
        if (bl) {
            f2 *= -1.0f;
        }
        occ52191e4792.\u04ea(Float.valueOf(f2));
    }

    protected void jump() {
        oc4c5a4d3446 oc4c5a4d34462 = new oc4c5a4d3446(this, this.getJumpUpwardsMotion(), this.rotationYaw, this.isSprinting());
        ocea775c9d5c.\u0173.post(oc4c5a4d34462);
        if (!oc4c5a4d34462.isCanceled()) {
            this.motionY = oc4c5a4d34462.\u041f();
            if (this.isPotionActive(Potion.jump)) {
                this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1f);
            }
            if (oc4c5a4d34462.\u0159()) {
                float f = oc4c5a4d34462.\u0446() * ((float)Math.PI / 180);
                this.motionX -= (double)(MathHelper.sin(f) * 0.2f);
                this.motionZ += (double)(MathHelper.cos(f) * 0.2f);
            }
            this.isAirBorne = true;
            ocd2ceabdd9a.\u016d(this);
        }
    }

    private void mimeow$isPotionActive(Potion potion, occ52191e479 occ52191e4792) {
        if (oc9755810e45.\u0205 != null && oc9755810e45.\u0205.z$3rzb3dil7uydr() && (potion == Potion.confusion && oc9755810e45.\u0205.\u0585.\u01ed() || potion == Potion.blindness && oc9755810e45.\u0205.\u0144.\u01ed()) && oc9755810e45.\u0205.\u04d0.\u01ed()) {
            occ52191e4792.\u04ea(false);
        }
    }

    private void mimeow$onGetArmSwingAnimationEnd(occ52191e479 occ52191e4792) {
        if (oc743046ab41.\u03b7()) {
            int n = this.isPotionActive(Potion.digSpeed) ? 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) : (this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6);
            occ52191e4792.\u04ea(oc743046ab41.\u0140(this, n));
        }
    }

    private void mimeow$redirect$onMoveEntityWithHeadingRedirect(EntityLivingBase entityLivingBase, float f, float f2) {
        if (entityLivingBase instanceof EntityPlayerSP) {
            oc85310462f3 oc85310462f32 = new oc85310462f3(f2, f);
            ocea775c9d5c.\u0173.post(oc85310462f32);
            entityLivingBase.moveEntityWithHeading(oc85310462f32.\u043c, oc85310462f32.\u0159);
        } else {
            entityLivingBase.moveEntityWithHeading(f, f2);
        }
    }

    private void mimeow$livingUpdate(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc9341368218(this));
    }

    @Override
    public void setJumpTicks(int n) {
        this.jumpTicks = n;
    }

    @Override
    public int getJumpTicks() {
        return this.jumpTicks;
    }
}

