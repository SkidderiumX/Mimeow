/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

public class EntityDamageSource
extends DamageSource {
    protected Entity damageSourceEntity;
    private boolean isThornsDamage = false;

    public EntityDamageSource(String string, Entity entity) {
        super(string);
        this.damageSourceEntity = entity;
    }

    public EntityDamageSource setIsThornsDamage() {
        this.isThornsDamage = true;
        return this;
    }

    public boolean getIsThornsDamage() {
        return this.isThornsDamage;
    }

    @Override
    public Entity getEntity() {
        return this.damageSourceEntity;
    }

    @Override
    public IChatComponent getDeathMessage(EntityLivingBase entityLivingBase) {
        ItemStack itemStack = this.damageSourceEntity instanceof EntityLivingBase ? ((EntityLivingBase)this.damageSourceEntity).getHeldItem() : null;
        String string = "death.attack." + this.damageType;
        String string2 = string + ".item";
        return itemStack != null && itemStack.hasDisplayName() && StatCollector.canTranslate(string2) ? new ChatComponentTranslation(string2, entityLivingBase.getDisplayName(), this.damageSourceEntity.getDisplayName(), itemStack.getChatComponent()) : new ChatComponentTranslation(string, entityLivingBase.getDisplayName(), this.damageSourceEntity.getDisplayName());
    }

    @Override
    public boolean isDifficultyScaled() {
        return this.damageSourceEntity != null && this.damageSourceEntity instanceof EntityLivingBase && !(this.damageSourceEntity instanceof EntityPlayer);
    }
}

