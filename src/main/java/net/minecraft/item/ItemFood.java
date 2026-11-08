/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import x.oc94a01ae980;

public class ItemFood
extends Item
implements oc94a01ae980 {
    public final int itemUseDuration;
    private final int healAmount;
    private final float saturationModifier;
    private final boolean isWolfsFavoriteMeat;
    private boolean alwaysEdible;
    private int potionId;
    private int potionDuration;
    private int potionAmplifier;
    private float potionEffectProbability;

    public ItemFood(int n, float f, boolean bl) {
        this.itemUseDuration = 32;
        this.healAmount = n;
        this.isWolfsFavoriteMeat = bl;
        this.saturationModifier = f;
        this.setCreativeTab(CreativeTabs.tabFood);
    }

    public ItemFood(int n, boolean bl) {
        this(n, 0.6f, bl);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        --itemStack.stackSize;
        entityPlayer.getFoodStats().addStats(this, itemStack);
        world2.playSoundAtEntity(entityPlayer, "random.burp", 0.5f, world2.rand.nextFloat() * 0.1f + 0.9f);
        this.onFoodEaten(itemStack, world2, entityPlayer);
        entityPlayer.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return itemStack;
    }

    protected void onFoodEaten(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        if (!world2.isRemote && this.potionId > 0 && world2.rand.nextFloat() < this.potionEffectProbability) {
            entityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.EAT;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        if (entityPlayer.canEat(this.alwaysEdible)) {
            entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }
        return itemStack;
    }

    public int getHealAmount(ItemStack itemStack) {
        return this.healAmount;
    }

    public float getSaturationModifier(ItemStack itemStack) {
        return this.saturationModifier;
    }

    public boolean isWolfsFavoriteMeat() {
        return this.isWolfsFavoriteMeat;
    }

    public ItemFood setPotionEffect(int n, int n2, int n3, float f) {
        this.potionId = n;
        this.potionDuration = n2;
        this.potionAmplifier = n3;
        this.potionEffectProbability = f;
        return this;
    }

    public ItemFood setAlwaysEdible() {
        this.alwaysEdible = true;
        return this;
    }

    @Override
    public boolean getAlwaysEdible() {
        return this.alwaysEdible;
    }
}

