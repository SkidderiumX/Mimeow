/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandom;

public class EnchantmentHelper {
    private static final Random enchantmentRand = new Random();
    private static final ModifierDamage enchantmentModifierDamage = new ModifierDamage();
    private static final ModifierLiving enchantmentModifierLiving = new ModifierLiving();
    private static final HurtIterator ENCHANTMENT_ITERATOR_HURT = new HurtIterator();
    private static final DamageIterator ENCHANTMENT_ITERATOR_DAMAGE = new DamageIterator();

    public static int getEnchantmentLevel(int n, ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        NBTTagList nBTTagList = itemStack.getEnchantmentTagList();
        if (nBTTagList == null) {
            return 0;
        }
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            short s = nBTTagList.getCompoundTagAt(i).getShort("id");
            short s2 = nBTTagList.getCompoundTagAt(i).getShort("lvl");
            if (s != n) continue;
            return s2;
        }
        return 0;
    }

    public static Map<Integer, Integer> getEnchantments(ItemStack itemStack) {
        NBTTagList nBTTagList;
        LinkedHashMap<Integer, Integer> linkedHashMap = Maps.newLinkedHashMap();
        NBTTagList nBTTagList2 = nBTTagList = itemStack.getItem() == Items.enchanted_book ? Items.enchanted_book.getEnchantments(itemStack) : itemStack.getEnchantmentTagList();
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                short s = nBTTagList.getCompoundTagAt(i).getShort("id");
                short s2 = nBTTagList.getCompoundTagAt(i).getShort("lvl");
                linkedHashMap.put(Integer.valueOf(s), Integer.valueOf(s2));
            }
        }
        return linkedHashMap;
    }

    public static void setEnchantments(Map<Integer, Integer> map, ItemStack itemStack) {
        NBTTagList nBTTagList = new NBTTagList();
        for (int n : map.keySet()) {
            Enchantment enchantment = Enchantment.getEnchantmentById(n);
            if (enchantment == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setShort("id", (short)n);
            nBTTagCompound.setShort("lvl", (short)map.get(n).intValue());
            nBTTagList.appendTag(nBTTagCompound);
            if (itemStack.getItem() != Items.enchanted_book) continue;
            Items.enchanted_book.addEnchantment(itemStack, new EnchantmentData(enchantment, map.get(n)));
        }
        if (nBTTagList.tagCount() > 0) {
            if (itemStack.getItem() != Items.enchanted_book) {
                itemStack.setTagInfo("ench", nBTTagList);
            }
        } else if (itemStack.hasTagCompound()) {
            itemStack.getTagCompound().removeTag("ench");
        }
    }

    public static int getMaxEnchantmentLevel(int n, ItemStack[] itemStackArray) {
        if (itemStackArray == null) {
            return 0;
        }
        int n2 = 0;
        for (ItemStack itemStack : itemStackArray) {
            int n3 = EnchantmentHelper.getEnchantmentLevel(n, itemStack);
            if (n3 <= n2) continue;
            n2 = n3;
        }
        return n2;
    }

    private static void applyEnchantmentModifier(IModifier iModifier, ItemStack itemStack) {
        NBTTagList nBTTagList;
        if (itemStack != null && (nBTTagList = itemStack.getEnchantmentTagList()) != null) {
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                short s = nBTTagList.getCompoundTagAt(i).getShort("id");
                short s2 = nBTTagList.getCompoundTagAt(i).getShort("lvl");
                if (Enchantment.getEnchantmentById(s) == null) continue;
                iModifier.calculateModifier(Enchantment.getEnchantmentById(s), s2);
            }
        }
    }

    private static void applyEnchantmentModifierArray(IModifier iModifier, ItemStack[] itemStackArray) {
        for (ItemStack itemStack : itemStackArray) {
            EnchantmentHelper.applyEnchantmentModifier(iModifier, itemStack);
        }
    }

    public static int getEnchantmentModifierDamage(ItemStack[] itemStackArray, DamageSource damageSource) {
        EnchantmentHelper.enchantmentModifierDamage.damageModifier = 0;
        EnchantmentHelper.enchantmentModifierDamage.source = damageSource;
        try {
            EnchantmentHelper.applyEnchantmentModifierArray(enchantmentModifierDamage, itemStackArray);
            if (EnchantmentHelper.enchantmentModifierDamage.damageModifier > 25) {
                EnchantmentHelper.enchantmentModifierDamage.damageModifier = 25;
            } else if (EnchantmentHelper.enchantmentModifierDamage.damageModifier < 0) {
                EnchantmentHelper.enchantmentModifierDamage.damageModifier = 0;
            }
            int n = (EnchantmentHelper.enchantmentModifierDamage.damageModifier + 1 >> 1) + enchantmentRand.nextInt((EnchantmentHelper.enchantmentModifierDamage.damageModifier >> 1) + 1);
            return n;
        }
        finally {
            EnchantmentHelper.enchantmentModifierDamage.source = null;
        }
    }

    public static float getModifierForCreature(ItemStack itemStack, EnumCreatureAttribute enumCreatureAttribute) {
        EnchantmentHelper.enchantmentModifierLiving.livingModifier = 0.0f;
        EnchantmentHelper.enchantmentModifierLiving.entityLiving = enumCreatureAttribute;
        try {
            EnchantmentHelper.applyEnchantmentModifier(enchantmentModifierLiving, itemStack);
            float f = EnchantmentHelper.enchantmentModifierLiving.livingModifier;
            return f;
        }
        finally {
            EnchantmentHelper.enchantmentModifierLiving.entityLiving = null;
        }
    }

    public static void applyThornEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
        EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.attacker = entity;
        EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.user = entityLivingBase;
        try {
            if (entityLivingBase != null) {
                EnchantmentHelper.applyEnchantmentModifierArray(ENCHANTMENT_ITERATOR_HURT, entityLivingBase.getInventory());
            }
            if (entity instanceof EntityPlayer) {
                EnchantmentHelper.applyEnchantmentModifier(ENCHANTMENT_ITERATOR_HURT, entityLivingBase.getHeldItem());
            }
        }
        finally {
            EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.attacker = null;
            EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.user = null;
        }
    }

    public static void applyArthropodEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
        EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.user = entityLivingBase;
        EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.target = entity;
        try {
            if (entityLivingBase != null) {
                EnchantmentHelper.applyEnchantmentModifierArray(ENCHANTMENT_ITERATOR_DAMAGE, entityLivingBase.getInventory());
            }
            if (entityLivingBase instanceof EntityPlayer) {
                EnchantmentHelper.applyEnchantmentModifier(ENCHANTMENT_ITERATOR_DAMAGE, entityLivingBase.getHeldItem());
            }
        }
        finally {
            EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.user = null;
            EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.target = null;
        }
    }

    public static int getKnockbackModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, entityLivingBase.getHeldItem());
    }

    public static int getFireAspectModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, entityLivingBase.getHeldItem());
    }

    public static int getRespiration(Entity entity) {
        return EnchantmentHelper.getMaxEnchantmentLevel(Enchantment.respiration.effectId, entity.getInventory());
    }

    public static int getDepthStriderModifier(Entity entity) {
        return EnchantmentHelper.getMaxEnchantmentLevel(Enchantment.depthStrider.effectId, entity.getInventory());
    }

    public static int getEfficiencyModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, entityLivingBase.getHeldItem());
    }

    public static boolean getSilkTouchModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, entityLivingBase.getHeldItem()) > 0;
    }

    public static int getFortuneModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, entityLivingBase.getHeldItem());
    }

    public static int getLuckOfSeaModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.luckOfTheSea.effectId, entityLivingBase.getHeldItem());
    }

    public static int getLureModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.lure.effectId, entityLivingBase.getHeldItem());
    }

    public static int getLootingModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, entityLivingBase.getHeldItem());
    }

    public static boolean getAquaAffinityModifier(EntityLivingBase entityLivingBase) {
        return EnchantmentHelper.getMaxEnchantmentLevel(Enchantment.aquaAffinity.effectId, entityLivingBase.getInventory()) > 0;
    }

    public static ItemStack getEnchantedItem(Enchantment enchantment, EntityLivingBase entityLivingBase) {
        for (ItemStack itemStack : entityLivingBase.getInventory()) {
            if (itemStack == null || EnchantmentHelper.getEnchantmentLevel(enchantment.effectId, itemStack) <= 0) continue;
            return itemStack;
        }
        return null;
    }

    public static int calcItemStackEnchantability(Random random, int n, int n2, ItemStack itemStack) {
        Item item = itemStack.getItem();
        int n3 = item.getItemEnchantability();
        if (n3 <= 0) {
            return 0;
        }
        if (n2 > 15) {
            n2 = 15;
        }
        int n4 = random.nextInt(8) + 1 + (n2 >> 1) + random.nextInt(n2 + 1);
        return n == 0 ? Math.max(n4 / 3, 1) : (n == 1 ? n4 * 2 / 3 + 1 : Math.max(n4, n2 * 2));
    }

    public static ItemStack addRandomEnchantment(Random random, ItemStack itemStack, int n) {
        boolean bl;
        List<EnchantmentData> list = EnchantmentHelper.buildEnchantmentList(random, itemStack, n);
        boolean bl2 = bl = itemStack.getItem() == Items.book;
        if (bl) {
            itemStack.setItem(Items.enchanted_book);
        }
        if (list != null) {
            for (EnchantmentData enchantmentData : list) {
                if (bl) {
                    Items.enchanted_book.addEnchantment(itemStack, enchantmentData);
                    continue;
                }
                itemStack.addEnchantment(enchantmentData.enchantmentobj, enchantmentData.enchantmentLevel);
            }
        }
        return itemStack;
    }

    public static List<EnchantmentData> buildEnchantmentList(Random random, ItemStack itemStack, int n) {
        EnchantmentData enchantmentData;
        float f;
        Item item = itemStack.getItem();
        int n2 = item.getItemEnchantability();
        if (n2 <= 0) {
            return null;
        }
        n2 /= 2;
        int n3 = (n2 = 1 + random.nextInt((n2 >> 1) + 1) + random.nextInt((n2 >> 1) + 1)) + n;
        int n4 = (int)((float)n3 * (1.0f + (f = (random.nextFloat() + random.nextFloat() - 1.0f) * 0.15f)) + 0.5f);
        if (n4 < 1) {
            n4 = 1;
        }
        ArrayList<Object> arrayList = null;
        Map<Integer, EnchantmentData> map = EnchantmentHelper.mapEnchantmentData(n4, itemStack);
        if (map != null && !map.isEmpty() && (enchantmentData = WeightedRandom.getRandomItem(random, map.values())) != null) {
            arrayList = Lists.newArrayList();
            arrayList.add(enchantmentData);
            for (int i = n4; random.nextInt(50) <= i; i >>= 1) {
                Object object;
                Iterator<Integer> iterator2 = map.keySet().iterator();
                while (iterator2.hasNext()) {
                    object = iterator2.next();
                    boolean bl = true;
                    for (EnchantmentData enchantmentData2 : arrayList) {
                        if (enchantmentData2.enchantmentobj.canApplyTogether(Enchantment.getEnchantmentById((Integer)object))) continue;
                        bl = false;
                        break;
                    }
                    if (bl) continue;
                    iterator2.remove();
                }
                if (map.isEmpty()) continue;
                object = WeightedRandom.getRandomItem(random, map.values());
                arrayList.add(object);
            }
        }
        return arrayList;
    }

    public static Map<Integer, EnchantmentData> mapEnchantmentData(int n, ItemStack itemStack) {
        Item item = itemStack.getItem();
        HashMap<Integer, EnchantmentData> hashMap = null;
        boolean bl = itemStack.getItem() == Items.book;
        for (Enchantment enchantment : Enchantment.enchantmentsBookList) {
            if (enchantment == null || !enchantment.type.canEnchantItem(item) && !bl) continue;
            for (int i = enchantment.getMinLevel(); i <= enchantment.getMaxLevel(); ++i) {
                if (n < enchantment.getMinEnchantability(i) || n > enchantment.getMaxEnchantability(i)) continue;
                if (hashMap == null) {
                    hashMap = Maps.newHashMap();
                }
                hashMap.put(enchantment.effectId, new EnchantmentData(enchantment, i));
            }
        }
        return hashMap;
    }

    public static interface IModifier {
        public void calculateModifier(Enchantment var1, int var2);
    }

    public static final class ModifierDamage
    implements IModifier {
        public int damageModifier;
        public DamageSource source;

        private ModifierDamage() {
        }

        @Override
        public void calculateModifier(Enchantment enchantment, int n) {
            this.damageModifier += enchantment.calcModifierDamage(n, this.source);
        }
    }

    public static final class ModifierLiving
    implements IModifier {
        public float livingModifier;
        public EnumCreatureAttribute entityLiving;

        private ModifierLiving() {
        }

        @Override
        public void calculateModifier(Enchantment enchantment, int n) {
            this.livingModifier += enchantment.calcDamageByCreature(n, this.entityLiving);
        }
    }

    public static final class HurtIterator
    implements IModifier {
        public EntityLivingBase user;
        public Entity attacker;

        private HurtIterator() {
        }

        @Override
        public void calculateModifier(Enchantment enchantment, int n) {
            enchantment.onUserHurt(this.user, this.attacker, n);
        }
    }

    public static final class DamageIterator
    implements IModifier {
        public EntityLivingBase user;
        public Entity target;

        private DamageIterator() {
        }

        @Override
        public void calculateModifier(Enchantment enchantment, int n) {
            enchantment.onEntityDamaged(this.user, this.target, n);
        }
    }
}

