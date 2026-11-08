/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PotionEffect {
    private static final Logger LOGGER = LogManager.getLogger();
    private int potionID;
    private int duration;
    private int amplifier;
    private boolean isSplashPotion;
    private boolean isAmbient;
    private boolean isPotionDurationMax;
    private boolean showParticles;

    public PotionEffect(int n, int n2) {
        this(n, n2, 0);
    }

    public PotionEffect(int n, int n2, int n3) {
        this(n, n2, n3, false, true);
    }

    public PotionEffect(int n, int n2, int n3, boolean bl, boolean bl2) {
        this.potionID = n;
        this.duration = n2;
        this.amplifier = n3;
        this.isAmbient = bl;
        this.showParticles = bl2;
    }

    public PotionEffect(PotionEffect potionEffect) {
        this.potionID = potionEffect.potionID;
        this.duration = potionEffect.duration;
        this.amplifier = potionEffect.amplifier;
        this.isAmbient = potionEffect.isAmbient;
        this.showParticles = potionEffect.showParticles;
    }

    public void combine(PotionEffect potionEffect) {
        if (this.potionID != potionEffect.potionID) {
            LOGGER.warn("This method should only be called for matching effects!");
        }
        if (potionEffect.amplifier > this.amplifier) {
            this.amplifier = potionEffect.amplifier;
            this.duration = potionEffect.duration;
        } else if (potionEffect.amplifier == this.amplifier && this.duration < potionEffect.duration) {
            this.duration = potionEffect.duration;
        } else if (!potionEffect.isAmbient && this.isAmbient) {
            this.isAmbient = potionEffect.isAmbient;
        }
        this.showParticles = potionEffect.showParticles;
    }

    public int getPotionID() {
        return this.potionID;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    public void setSplashPotion(boolean bl) {
        this.isSplashPotion = bl;
    }

    public boolean getIsAmbient() {
        return this.isAmbient;
    }

    public boolean getIsShowParticles() {
        return this.showParticles;
    }

    public boolean onUpdate(EntityLivingBase entityLivingBase) {
        if (this.duration > 0) {
            if (Potion.potionTypes[this.potionID].isReady(this.duration, this.amplifier)) {
                this.performEffect(entityLivingBase);
            }
            this.deincrementDuration();
        }
        return this.duration > 0;
    }

    private int deincrementDuration() {
        return --this.duration;
    }

    public void performEffect(EntityLivingBase entityLivingBase) {
        if (this.duration > 0) {
            Potion.potionTypes[this.potionID].performEffect(entityLivingBase, this.amplifier);
        }
    }

    public String getEffectName() {
        return Potion.potionTypes[this.potionID].getName();
    }

    public int hashCode() {
        return this.potionID;
    }

    public String toString() {
        Object object = "";
        object = this.getAmplifier() > 0 ? this.getEffectName() + " x " + (this.getAmplifier() + 1) + ", Duration: " + this.getDuration() : this.getEffectName() + ", Duration: " + this.getDuration();
        if (this.isSplashPotion) {
            object = (String)object + ", Splash: true";
        }
        if (!this.showParticles) {
            object = (String)object + ", Particles: false";
        }
        return Potion.potionTypes[this.potionID].isUsable() ? "(" + (String)object + ")" : object;
    }

    public boolean equals(Object object) {
        if (!(object instanceof PotionEffect)) {
            return false;
        }
        PotionEffect potionEffect = (PotionEffect)object;
        return this.potionID == potionEffect.potionID && this.amplifier == potionEffect.amplifier && this.duration == potionEffect.duration && this.isSplashPotion == potionEffect.isSplashPotion && this.isAmbient == potionEffect.isAmbient;
    }

    public NBTTagCompound writeCustomPotionEffectToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.setByte("Id", (byte)this.getPotionID());
        nBTTagCompound.setByte("Amplifier", (byte)this.getAmplifier());
        nBTTagCompound.setInteger("Duration", this.getDuration());
        nBTTagCompound.setBoolean("Ambient", this.getIsAmbient());
        nBTTagCompound.setBoolean("ShowParticles", this.getIsShowParticles());
        return nBTTagCompound;
    }

    public static PotionEffect readCustomPotionEffectFromNBT(NBTTagCompound nBTTagCompound) {
        byte by = nBTTagCompound.getByte("Id");
        if (by >= 0 && by < Potion.potionTypes.length && Potion.potionTypes[by] != null) {
            byte by2 = nBTTagCompound.getByte("Amplifier");
            int n = nBTTagCompound.getInteger("Duration");
            boolean bl = nBTTagCompound.getBoolean("Ambient");
            boolean bl2 = true;
            if (nBTTagCompound.hasKey("ShowParticles", 1)) {
                bl2 = nBTTagCompound.getBoolean("ShowParticles");
            }
            return new PotionEffect(by, n, by2, bl, bl2);
        }
        return null;
    }

    public void setPotionDurationMax(boolean bl) {
        this.isPotionDurationMax = bl;
    }

    public boolean getIsPotionDurationMax() {
        return this.isPotionDurationMax;
    }
}

