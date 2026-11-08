/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import net.minecraft.enchantment.Enchantment;
import net.optifine.config.IParserInt;

public class ParserEnchantmentId
implements IParserInt {
    @Override
    public int parse(String string, int n) {
        Enchantment enchantment = Enchantment.getEnchantmentByLocation(string);
        return enchantment == null ? n : enchantment.effectId;
    }
}

