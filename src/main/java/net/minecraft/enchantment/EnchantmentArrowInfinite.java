/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.ResourceLocation;

public class EnchantmentArrowInfinite
extends Enchantment {
    public EnchantmentArrowInfinite(int n, ResourceLocation resourceLocation, int n2) {
        super(n, resourceLocation, n2, EnumEnchantmentType.BOW);
        this.setName("arrowInfinite");
    }

    @Override
    public int getMinEnchantability(int n) {
        return 20;
    }

    @Override
    public int getMaxEnchantability(int n) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}

