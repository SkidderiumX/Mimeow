/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import net.minecraft.enchantment.EnchantmentArrowDamage;
import net.minecraft.enchantment.EnchantmentArrowFire;
import net.minecraft.enchantment.EnchantmentArrowInfinite;
import net.minecraft.enchantment.EnchantmentArrowKnockback;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnchantmentDigging;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.enchantment.EnchantmentFireAspect;
import net.minecraft.enchantment.EnchantmentFishingSpeed;
import net.minecraft.enchantment.EnchantmentKnockback;
import net.minecraft.enchantment.EnchantmentLootBonus;
import net.minecraft.enchantment.EnchantmentOxygen;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.enchantment.EnchantmentUntouching;
import net.minecraft.enchantment.EnchantmentWaterWalker;
import net.minecraft.enchantment.EnchantmentWaterWorker;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public abstract class Enchantment {
    private static final Enchantment[] enchantmentsList = new Enchantment[256];
    public static final Enchantment[] enchantmentsBookList;
    private static final Map<ResourceLocation, Enchantment> locationEnchantments;
    public static final Enchantment protection;
    public static final Enchantment fireProtection;
    public static final Enchantment featherFalling;
    public static final Enchantment blastProtection;
    public static final Enchantment projectileProtection;
    public static final Enchantment respiration;
    public static final Enchantment aquaAffinity;
    public static final Enchantment thorns;
    public static final Enchantment depthStrider;
    public static final Enchantment sharpness;
    public static final Enchantment smite;
    public static final Enchantment baneOfArthropods;
    public static final Enchantment knockback;
    public static final Enchantment fireAspect;
    public static final Enchantment looting;
    public static final Enchantment efficiency;
    public static final Enchantment silkTouch;
    public static final Enchantment unbreaking;
    public static final Enchantment fortune;
    public static final Enchantment power;
    public static final Enchantment punch;
    public static final Enchantment flame;
    public static final Enchantment infinity;
    public static final Enchantment luckOfTheSea;
    public static final Enchantment lure;
    public final int effectId;
    private final int weight;
    public EnumEnchantmentType type;
    protected String name;

    public static Enchantment getEnchantmentById(int n) {
        return n >= 0 && n < enchantmentsList.length ? enchantmentsList[n] : null;
    }

    protected Enchantment(int n, ResourceLocation resourceLocation, int n2, EnumEnchantmentType enumEnchantmentType) {
        this.effectId = n;
        this.weight = n2;
        this.type = enumEnchantmentType;
        if (enchantmentsList[n] != null) {
            throw new IllegalArgumentException("Duplicate enchantment id!");
        }
        Enchantment.enchantmentsList[n] = this;
        locationEnchantments.put(resourceLocation, this);
    }

    public static Enchantment getEnchantmentByLocation(String string) {
        return locationEnchantments.get(new ResourceLocation(string));
    }

    public static Set<ResourceLocation> func_181077_c() {
        return locationEnchantments.keySet();
    }

    public int getWeight() {
        return this.weight;
    }

    public int getMinLevel() {
        return 1;
    }

    public int getMaxLevel() {
        return 1;
    }

    public int getMinEnchantability(int n) {
        return 1 + n * 10;
    }

    public int getMaxEnchantability(int n) {
        return this.getMinEnchantability(n) + 5;
    }

    public int calcModifierDamage(int n, DamageSource damageSource) {
        return 0;
    }

    public float calcDamageByCreature(int n, EnumCreatureAttribute enumCreatureAttribute) {
        return 0.0f;
    }

    public boolean canApplyTogether(Enchantment enchantment) {
        return this != enchantment;
    }

    public Enchantment setName(String string) {
        this.name = string;
        return this;
    }

    public String getName() {
        return "enchantment." + this.name;
    }

    public String getTranslatedName(int n) {
        String string = StatCollector.translateToLocal(this.getName());
        return string + " " + StatCollector.translateToLocal("enchantment.level." + n);
    }

    public boolean canApply(ItemStack itemStack) {
        return this.type.canEnchantItem(itemStack.getItem());
    }

    public void onEntityDamaged(EntityLivingBase entityLivingBase, Entity entity, int n) {
    }

    public void onUserHurt(EntityLivingBase entityLivingBase, Entity entity, int n) {
    }

    static {
        locationEnchantments = Maps.newHashMap();
        protection = new EnchantmentProtection(0, new ResourceLocation("protection"), 10, 0);
        fireProtection = new EnchantmentProtection(1, new ResourceLocation("fire_protection"), 5, 1);
        featherFalling = new EnchantmentProtection(2, new ResourceLocation("feather_falling"), 5, 2);
        blastProtection = new EnchantmentProtection(3, new ResourceLocation("blast_protection"), 2, 3);
        projectileProtection = new EnchantmentProtection(4, new ResourceLocation("projectile_protection"), 5, 4);
        respiration = new EnchantmentOxygen(5, new ResourceLocation("respiration"), 2);
        aquaAffinity = new EnchantmentWaterWorker(6, new ResourceLocation("aqua_affinity"), 2);
        thorns = new EnchantmentThorns(7, new ResourceLocation("thorns"), 1);
        depthStrider = new EnchantmentWaterWalker(8, new ResourceLocation("depth_strider"), 2);
        sharpness = new EnchantmentDamage(16, new ResourceLocation("sharpness"), 10, 0);
        smite = new EnchantmentDamage(17, new ResourceLocation("smite"), 5, 1);
        baneOfArthropods = new EnchantmentDamage(18, new ResourceLocation("bane_of_arthropods"), 5, 2);
        knockback = new EnchantmentKnockback(19, new ResourceLocation("knockback"), 5);
        fireAspect = new EnchantmentFireAspect(20, new ResourceLocation("fire_aspect"), 2);
        looting = new EnchantmentLootBonus(21, new ResourceLocation("looting"), 2, EnumEnchantmentType.WEAPON);
        efficiency = new EnchantmentDigging(32, new ResourceLocation("efficiency"), 10);
        silkTouch = new EnchantmentUntouching(33, new ResourceLocation("silk_touch"), 1);
        unbreaking = new EnchantmentDurability(34, new ResourceLocation("unbreaking"), 5);
        fortune = new EnchantmentLootBonus(35, new ResourceLocation("fortune"), 2, EnumEnchantmentType.DIGGER);
        power = new EnchantmentArrowDamage(48, new ResourceLocation("power"), 10);
        punch = new EnchantmentArrowKnockback(49, new ResourceLocation("punch"), 2);
        flame = new EnchantmentArrowFire(50, new ResourceLocation("flame"), 2);
        infinity = new EnchantmentArrowInfinite(51, new ResourceLocation("infinity"), 1);
        luckOfTheSea = new EnchantmentLootBonus(61, new ResourceLocation("luck_of_the_sea"), 2, EnumEnchantmentType.FISHING_ROD);
        lure = new EnchantmentFishingSpeed(62, new ResourceLocation("lure"), 2, EnumEnchantmentType.FISHING_ROD);
        ArrayList<Enchantment> arrayList = Lists.newArrayList();
        for (Enchantment enchantment : enchantmentsList) {
            if (enchantment == null) continue;
            arrayList.add(enchantment);
        }
        enchantmentsBookList = arrayList.toArray(new Enchantment[arrayList.size()]);
    }
}

