/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import keystrokesmod.script.model.ItemStack;
import keystrokesmod.script.model.NetworkPlayer;
import keystrokesmod.script.model.Vec3;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.PotionEffect;
import x.oc7ab2161b9f;

public class Entity {
    public net.minecraft.entity.Entity entity;
    public String type;
    public int entityId;
    public boolean isLiving;
    public boolean isPlayer;
    public boolean isUser;
    private static HashMap<Integer, Entity> cache = new HashMap();

    public Entity(net.minecraft.entity.Entity entity) {
        this.entity = entity;
        if (entity == null) {
            return;
        }
        this.type = entity.getClass().getSimpleName();
        this.entityId = entity.getEntityId();
        this.isLiving = entity instanceof EntityLivingBase;
        this.isPlayer = entity instanceof EntityPlayer;
        if (this.isPlayer && Minecraft.getMinecraft().thePlayer != null && entity.getUniqueID().equals(Minecraft.getMinecraft().thePlayer.getUniqueID())) {
            this.isUser = true;
        }
    }

    public static Entity convert(net.minecraft.entity.Entity entity) {
        if (entity == null) {
            return null;
        }
        int n = entity.getEntityId() + System.identityHashCode(entity);
        Entity entity2 = cache.get(n);
        if (entity2 == null) {
            entity2 = new Entity(entity);
            cache.put(n, entity2);
        }
        return entity2;
    }

    public static void clearCache() {
        cache.clear();
    }

    public boolean allowEditing() {
        if (!(this.entity instanceof EntityPlayer)) {
            return false;
        }
        return ((EntityPlayer)this.entity).capabilities.allowEdit;
    }

    public double distanceTo(Vec3 vec3) {
        return this.entity.getDistance(vec3.x, vec3.y, vec3.z);
    }

    public double distanceToSq(Vec3 vec3) {
        return this.entity.getDistanceSq(vec3.x, vec3.y, vec3.z);
    }

    public double distanceToGround() {
        return oc7ab2161b9f.\u041f(this.entity);
    }

    public boolean isHoldingBlock() {
        return this.isLiving && ((EntityLivingBase)this.entity).getHeldItem() != null && ((EntityLivingBase)this.entity).getHeldItem().getItem() instanceof ItemBlock;
    }

    public boolean isHoldingWeapon() {
        return this.isLiving && oc7ab2161b9f.\u016d((EntityLivingBase)this.entity);
    }

    public float getAbsorption() {
        if (!(this.entity instanceof EntityLivingBase)) {
            return -1.0f;
        }
        return ((EntityLivingBase)this.entity).getAbsorptionAmount();
    }

    public Vec3 getBlockPosition() {
        return new Vec3(this.entity.getPosition().getX(), this.entity.getPosition().getY(), this.entity.getPosition().getZ());
    }

    public String getDisplayName() {
        if (this.entity instanceof EntityItem) {
            return ((EntityItem)this.entity).getEntityItem().getDisplayName();
        }
        return this.entity.getDisplayName().getUnformattedText();
    }

    public Entity getRidingEntity() {
        return Entity.convert(this.entity.ridingEntity);
    }

    public Entity getRiddenByEntity() {
        return Entity.convert(this.entity.riddenByEntity);
    }

    public Vec3 getServerPosition() {
        return new Vec3(this.entity.serverPosX, this.entity.serverPosY, this.entity.serverPosZ);
    }

    public int getExperienceLevel() {
        if (!(this.entity instanceof EntityPlayer)) {
            return 0;
        }
        return ((EntityPlayer)this.entity).experienceLevel;
    }

    public float getExperience() {
        if (!(this.entity instanceof EntityPlayer)) {
            return 0.0f;
        }
        return ((EntityPlayer)this.entity).experience;
    }

    public float getFallDistance() {
        return this.entity.fallDistance;
    }

    public String getUUID() {
        return this.entity.getUniqueID().toString();
    }

    public String getCustomNameTag() {
        return this.entity.getCustomNameTag();
    }

    public double getBPS() {
        if (!this.isLiving) {
            return 0.0;
        }
        double d = this.entity.posX - this.entity.prevPosX;
        double d2 = this.entity.posZ - this.entity.prevPosZ;
        return Math.sqrt(d * d + d2 * d2) * 20.0;
    }

    public String getFacing() {
        return this.entity.getHorizontalFacing().name();
    }

    public float getHealth() {
        if (!(this.entity instanceof EntityLivingBase)) {
            return -1.0f;
        }
        return ((EntityLivingBase)this.entity).getHealth();
    }

    public boolean isSleeping() {
        if (this.isPlayer) {
            return ((EntityPlayer)this.entity).isPlayerSleeping();
        }
        return false;
    }

    public float getEyeHeight() {
        return this.entity.getEyeHeight();
    }

    public float getHeight() {
        return this.entity.height;
    }

    public float getWidth() {
        return this.entity.width;
    }

    public boolean isBurning() {
        return this.entity.isBurning();
    }

    public int getStackSize() {
        if (this.entity instanceof EntityItem) {
            net.minecraft.item.ItemStack itemStack = ((EntityItem)this.entity).getEntityItem();
            if (itemStack == null) {
                return -1;
            }
            return itemStack.stackSize;
        }
        if (!(this.entity instanceof EntityLivingBase)) {
            return -1;
        }
        net.minecraft.item.ItemStack itemStack = ((EntityLivingBase)this.entity).getHeldItem();
        if (itemStack == null) {
            return -1;
        }
        return itemStack.stackSize;
    }

    public ItemStack getHeldItem() {
        if (this.entity instanceof EntityItem) {
            net.minecraft.item.ItemStack itemStack = ((EntityItem)this.entity).getEntityItem();
            if (itemStack == null) {
                return null;
            }
            return new ItemStack(itemStack, 0);
        }
        if (!(this.entity instanceof EntityLivingBase)) {
            return null;
        }
        net.minecraft.item.ItemStack itemStack = ((EntityLivingBase)this.entity).getHeldItem();
        if (itemStack == null) {
            return null;
        }
        return new ItemStack(itemStack, 0);
    }

    public int getHurtTime() {
        if (!(this.entity instanceof EntityLivingBase)) {
            return -1;
        }
        return ((EntityLivingBase)this.entity).hurtTime;
    }

    public boolean isConsuming() {
        return oc7ab2161b9f.\u0180(this.entity);
    }

    public Vec3 getLastPosition() {
        return new Vec3(this.entity.lastTickPosX, this.entity.lastTickPosY, this.entity.lastTickPosZ);
    }

    public float getMaxHealth() {
        if (!(this.entity instanceof EntityLivingBase)) {
            return -1.0f;
        }
        return ((EntityLivingBase)this.entity).getMaxHealth();
    }

    public int getMaxHurtTime() {
        if (!(this.entity instanceof EntityLivingBase)) {
            return -1;
        }
        return ((EntityLivingBase)this.entity).maxHurtTime;
    }

    public String getName() {
        if (this.entity instanceof EntityItem) {
            return ((EntityItem)this.entity).getEntityItem().getItem().getRegistryName().substring(0x5736DF2C ^ 0x5736DF26);
        }
        return this.entity.getName();
    }

    public NetworkPlayer getNetworkPlayer() {
        return NetworkPlayer.convert(Minecraft.getMinecraft().getNetHandler().getPlayerInfo(this.entity.getUniqueID()));
    }

    public float getPitch() {
        return this.entity.rotationPitch;
    }

    public Vec3 getPosition() {
        if (this.entity == null) {
            return null;
        }
        return new Vec3(this.entity.posX, this.entity.posY, this.entity.posZ);
    }

    public List<Object[]> getPotionEffects() {
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        if (!(this.entity instanceof EntityLivingBase)) {
            return arrayList;
        }
        for (PotionEffect potionEffect : ((EntityLivingBase)this.entity).getActivePotionEffects()) {
            Object[] objectArray = new Object[0x13B310BA ^ 0x13B310BE];
            objectArray[0] = potionEffect.getPotionID();
            objectArray[1] = potionEffect.getEffectName();
            objectArray[0x13B310BC ^ 0x13B310BE] = potionEffect.getAmplifier();
            objectArray[0x13B310BD ^ 0x13B310BE] = potionEffect.getDuration();
            Object[] objectArray2 = objectArray;
            arrayList.add(objectArray2);
        }
        return arrayList;
    }

    public ItemStack getArmorInSlot(int n) {
        return this.isPlayer && n >= 0 && n <= (0x53839F57 ^ 0x53839F54) ? ItemStack.convert(((EntityPlayer)this.entity).inventory.armorInventory[n]) : null;
    }

    public double getSpeed() {
        return oc7ab2161b9f.\u03e8(this.entity);
    }

    public int getSwingProgress() {
        return this.isLiving ? ((EntityLivingBase)this.entity).swingProgressInt : -1;
    }

    public float getPrevSwingProgress() {
        return this.isLiving ? ((EntityLivingBase)this.entity).prevSwingProgress : -1.0f;
    }

    public int getTicksExisted() {
        return this.entity.ticksExisted;
    }

    public float getYaw() {
        return this.entity.rotationYaw;
    }

    public int getFireResistance() {
        return this.entity.fireResistance;
    }

    public float getPrevYaw() {
        return this.entity.prevRotationYaw;
    }

    public void setPrevYaw(float f) {
        this.entity.prevRotationYaw = f;
    }

    public void setPrevPitch(float f) {
        this.entity.prevRotationPitch = f;
    }

    public float getPrevPitch() {
        return this.entity.prevRotationPitch;
    }

    public boolean isCreative() {
        if (!(this.entity instanceof EntityPlayer)) {
            return false;
        }
        return ((EntityPlayer)this.entity).capabilities.isCreativeMode;
    }

    public boolean isCollided() {
        if (!(this.entity instanceof EntityPlayer)) {
            return Minecraft.getMinecraft().theWorld.checkBlockCollision(this.entity.getEntityBoundingBox().expand(0.05, 0.0, 0.05));
        }
        return this.entity.isCollided;
    }

    public boolean isCollidedHorizontally() {
        return this.entity.isCollidedHorizontally;
    }

    public boolean isCollidedVertically() {
        return this.entity.isCollidedVertically;
    }

    public boolean isDead() {
        return this.entity.isDead || this.isLiving && ((EntityLivingBase)this.entity).deathTime > 0;
    }

    public int getHunger() {
        if (!this.isPlayer || ((EntityPlayer)this.entity).getFoodStats() == null) {
            return 0;
        }
        return ((EntityPlayer)this.entity).getFoodStats().getFoodLevel();
    }

    public float getSaturation() {
        if (!this.isPlayer || ((EntityPlayer)this.entity).getFoodStats() == null) {
            return 0.0f;
        }
        return ((EntityPlayer)this.entity).getFoodStats().getSaturationLevel();
    }

    public float getAir() {
        return this.entity.getAir();
    }

    public boolean isInvisible() {
        return this.entity.isInvisible();
    }

    public boolean isInWater() {
        return this.entity.isInWater();
    }

    public boolean isInLava() {
        return this.entity.isInLava();
    }

    public Entity getFisher() {
        if (this.entity instanceof EntityFishHook) {
            return Entity.convert(((EntityFishHook)this.entity).angler);
        }
        return null;
    }

    public boolean isInLiquid() {
        return !this.entity.isOffsetPositionInLiquid(0.0, 0.0, 0.0);
    }

    public boolean isOnLadder() {
        return this.isLiving && ((EntityLivingBase)this.entity).isOnLadder();
    }

    public boolean isOnEdge() {
        return oc7ab2161b9f.\u04c2(this.entity);
    }

    public boolean isSprinting() {
        return this.entity.isSprinting();
    }

    public boolean isSneaking() {
        return this.entity.isSneaking();
    }

    public boolean isUsingItem() {
        if (!(this.entity instanceof EntityPlayer)) {
            return false;
        }
        return ((EntityPlayer)this.entity).isUsingItem();
    }

    public boolean onGround() {
        return this.entity.onGround;
    }

    public void setMotion(double d, double d2, double d3) {
        this.entity.motionX = d;
        this.entity.motionY = d2;
        this.entity.motionZ = d3;
    }

    public Vec3 getMotion() {
        return new Vec3(this.entity.motionX, this.entity.motionY, this.entity.motionZ);
    }

    public void setPitch(float f) {
        this.entity.rotationPitch = f;
    }

    public void setYaw(float f) {
        this.entity.rotationYaw = f;
    }

    public void moveTo(Vec3 vec3) {
        if (vec3 == null) {
            return;
        }
        this.moveTo(vec3.x, vec3.y, vec3.z);
    }

    public void moveTo(double d, double d2, double d3) {
        this.entity.setPositionAndRotation(d, d2, d3, this.entity.rotationYaw, this.entity.rotationPitch);
    }

    public void moveTo(Vec3 vec3, float f, float f2) {
        if (vec3 == null) {
            return;
        }
        this.moveTo(vec3.x, vec3.y, vec3.z, f, f2);
    }

    public void moveTo(double d, double d2, double d3, float f, float f2) {
        this.entity.setPositionAndRotation(d, d2, d3, f, f2);
    }

    public void moveTo(Vec3 vec3, float f, float f2, int n) {
        if (vec3 == null) {
            return;
        }
        this.moveTo(vec3.x, vec3.y, vec3.z, f, f2, n);
    }

    public void moveTo(double d, double d2, double d3, float f, float f2, int n) {
        if (n <= 0) {
            this.moveTo(d, d2, d3, f, f2);
            return;
        }
        this.entity.setPositionAndRotation2(d, d2, d3, f, f2, n, false);
    }

    public void setPosition(Vec3 vec3) {
        this.entity.setPosition(vec3.x, vec3.y, vec3.z);
    }

    public void setPosition(double d, double d2, double d3) {
        this.entity.setPosition(d, d2, d3);
    }
}

