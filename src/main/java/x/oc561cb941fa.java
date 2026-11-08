/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import x.oc75d51ec7eb;

public class oc561cb941fa {
    private static final double \u0534 = 4.0;
    private static final double \u04a6 = 4.0;
    private static final double \u0118 = 0.15;
    private static final double \u0422 = 0.1;
    private static final double \u056e = 3.0;
    private static final double \u0553 = 2.0;
    public static int D;

    private oc561cb941fa() {
    }

    public static double \u0187(ItemStack itemStack) {
        ItemStack itemStack2;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                itemStack2 = itemStack;
                if (n != 0) break block4;
                if (itemStack2 != null) break block5;
                return 0.0;
            }
            itemStack2 = itemStack;
        }
        double d = oc561cb941fa.\u045b(itemStack2);
        d += (double)EnchantmentHelper.getModifierForCreature(itemStack, EnumCreatureAttribute.UNDEFINED);
        return d += (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, itemStack) * 4.0;
    }

    public static double \u04bf(ItemStack itemStack) {
        ItemStack itemStack2;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                itemStack2 = itemStack;
                if (n != 0) break block4;
                if (itemStack2 != null) break block5;
                return 0.0;
            }
            itemStack2 = itemStack;
        }
        double d = oc561cb941fa.\u0187(itemStack2);
        d += (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, itemStack) * 0.1;
        return d += oc561cb941fa.x(itemStack);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static double \u048f(ItemStack itemStack) {
        int n;
        block7: {
            block8: {
                ItemStack itemStack2;
                int n2;
                block6: {
                    n2 = oc75d51ec7eb.\u03e9;
                    itemStack2 = itemStack;
                    if (n2 != 0) break block6;
                    if (itemStack2 == null) return 0.0;
                    itemStack2 = itemStack;
                }
                n = itemStack2.getItem() instanceof ItemBow;
                if (n2 != 0) break block7;
                if (n != 0) break block8;
                return 0.0;
            }
            n = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);
        }
        int n3 = n;
        int n4 = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack);
        double d = 2.0 + (double)n3 * 0.5 + 0.5;
        double d2 = 3.0 * d;
        double d3 = d2 + d2 * 0.25 + 0.5;
        return d3 += (double)n4 * 4.0;
    }

    public static double \u0138(ItemStack itemStack) {
        ItemStack itemStack2;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                itemStack2 = itemStack;
                if (n != 0) break block4;
                if (itemStack2 != null) break block5;
                return 0.0;
            }
            itemStack2 = itemStack;
        }
        double d = oc561cb941fa.\u048f(itemStack2);
        d += (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack) * 0.15;
        return d += oc561cb941fa.x(itemStack);
    }

    public static double \u00d3(ItemStack itemStack) {
        return Math.max(Math.max(oc561cb941fa.\u0223(itemStack), oc561cb941fa.\u01ec(itemStack)), Math.max(Math.max(oc561cb941fa.\u0463(itemStack), oc561cb941fa.\u0391(itemStack)), oc561cb941fa.\u02a7(itemStack)));
    }

    public static double \u0223(ItemStack itemStack) {
        return oc561cb941fa.\u0283(itemStack, Blocks.log);
    }

    public static double \u01ec(ItemStack itemStack) {
        return oc561cb941fa.\u0283(itemStack, Blocks.stone);
    }

    public static double \u0463(ItemStack itemStack) {
        return oc561cb941fa.\u0283(itemStack, Blocks.dirt);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static double \u0391(ItemStack itemStack) {
        ItemStack itemStack2;
        block7: {
            block8: {
                int n;
                block6: {
                    n = oc75d51ec7eb.\u03e9;
                    itemStack2 = itemStack;
                    if (n != 0) break block6;
                    if (itemStack2 == null) return 0.0;
                    itemStack2 = itemStack;
                }
                if (n != 0) break block7;
                if (itemStack2.getItem() instanceof ItemHoe) break block8;
                return 0.0;
            }
            itemStack2 = itemStack;
        }
        double d = itemStack2.getMaxDamage();
        return d += oc561cb941fa.x(itemStack);
    }

    public static double \u02a7(ItemStack itemStack) {
        return oc561cb941fa.\u0283(itemStack, Blocks.web);
    }

    public static double \u0283(ItemStack itemStack, Block block) {
        float f;
        block25: {
            float f2;
            block24: {
                int n;
                block22: {
                    block23: {
                        block21: {
                            float f3;
                            float f4;
                            block19: {
                                block20: {
                                    block18: {
                                        n = oc75d51ec7eb.\u03e9;
                                        if (itemStack != null && block != null) break block18;
                                        return 0.0;
                                    }
                                    f = itemStack.getStrVsBlock(block);
                                    f4 = f;
                                    if (n != 0) break block19;
                                    if (!(f4 > 1.0f)) break block20;
                                    f2 = Enchantment.efficiency.effectId;
                                    if (n != 0) break block21;
                                    int n2 = EnchantmentHelper.getEnchantmentLevel((int)f2, itemStack);
                                    if (n2 > 0) {
                                        f += (float)(n2 * n2 + 1);
                                    }
                                }
                                f4 = f;
                            }
                            f2 = (f3 = f4 - 1.0f) == 0.0f ? 0 : (f3 < 0.0f ? -1 : 1);
                        }
                        if (n != 0) break block22;
                        if (f2 > 0) break block23;
                        return 0.0;
                    }
                    f2 = (float)block.getMaterial().isToolNotRequired();
                }
                if (n != 0) break block24;
                if (f2 != false) break block25;
                f2 = (float)itemStack.canHarvestBlock(block);
            }
            if (f2 == false) {
                f *= 0.3f;
            }
        }
        return (double)f + oc561cb941fa.x(itemStack);
    }

    private static double \u045b(ItemStack itemStack) {
        ItemStack itemStack2;
        int n;
        block9: {
            block10: {
                n = oc75d51ec7eb.\u03e9;
                itemStack2 = itemStack;
                if (n != 0) break block9;
                if (itemStack2 != null) break block10;
                return 0.0;
            }
            itemStack2 = itemStack;
        }
        for (Map.Entry<String, AttributeModifier> entry : itemStack2.getAttributeModifiers().entries()) {
            block12: {
                Object object;
                block11: {
                    object = SharedMonsterAttributes.attackDamage;
                    if (n != 0) break block11;
                    if (!object.getAttributeUnlocalizedName().equals(entry.getKey())) break block12;
                    object = entry.getValue();
                }
                return ((AttributeModifier)object).getAmount();
            }
            if (n == 0) continue;
        }
        return 0.0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static double x(ItemStack itemStack) {
        int n;
        int n2;
        block13: {
            block14: {
                ItemStack itemStack2;
                int n3;
                block11: {
                    block12: {
                        block10: {
                            n3 = oc75d51ec7eb.\u03e9;
                            itemStack2 = itemStack;
                            if (n3 != 0) break block10;
                            if (itemStack2 == null) return 0.0;
                            itemStack2 = itemStack;
                        }
                        if (n3 != 0) break block11;
                        if (itemStack2.isItemStackDamageable()) break block12;
                        return 0.0;
                    }
                    itemStack2 = itemStack;
                }
                n2 = itemStack2.getMaxDamage();
                n = n2;
                if (n3 != 0) break block13;
                if (n > 0) break block14;
                return 0.0;
            }
            n = n2 - itemStack.getItemDamage();
        }
        int n4 = n;
        return (double)n4 / (double)n2 / 1000.0;
    }
}

