/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Map;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import x.oc75d51ec7eb;
import x.occadfec20a1;

public class oce5883ca002 {
    private static final DamageSource \u046d = DamageSource.setExplosionSource(null);
    public static int \u04b4;

    private oce5883ca002() {
    }

    public static float \u04f1(World world2, Vec3 vec3, float f, EntityPlayer entityPlayer) {
        return oce5883ca002.\u03e4(world2, vec3, f, entityPlayer, true);
    }

    public static float \u04f8(EntityTNTPrimed entityTNTPrimed, float f, EntityPlayer entityPlayer) {
        boolean bl;
        EntityPlayer entityPlayer2;
        float f2;
        Vec3 vec3;
        World world2;
        block2: {
            block3: {
                Vec3 vec32 = new Vec3(entityTNTPrimed.posX, entityTNTPrimed.posY + (double)(entityTNTPrimed.height / 16.0f), entityTNTPrimed.posZ);
                int n = oc75d51ec7eb.\u03e9;
                world2 = entityTNTPrimed.worldObj;
                vec3 = vec32;
                f2 = f;
                entityPlayer2 = entityPlayer;
                bl = entityTNTPrimed.getTntPlacedBy() instanceof EntityPlayer;
                if (n != 0) break block2;
                if (bl) break block3;
                bl = true;
                break block2;
            }
            bl = false;
        }
        return oce5883ca002.\u03e4(world2, vec3, f2, entityPlayer2, bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static float \u03e4(World world2, Vec3 vec3, float f, EntityPlayer entityPlayer, boolean n) {
        float f2;
        float f3;
        EntityPlayer entityPlayer2;
        block40: {
            int n2;
            float f4;
            int n3;
            block38: {
                block39: {
                    double d;
                    EntityPlayer entityPlayer3;
                    block37: {
                        block36: {
                            n3 = oc75d51ec7eb.\u03e9;
                            if (world2 == null) return 0.0f;
                            if (entityPlayer == null) return 0.0f;
                            float f5 = f;
                            if (n3 != 0) return f5;
                            if (f5 <= 0.0f) return 0.0f;
                            entityPlayer3 = entityPlayer;
                            if (n3 != 0) break block36;
                            if (entityPlayer3.capabilities.disableDamage) return 0.0f;
                            entityPlayer3 = entityPlayer;
                            if (n3 != 0) break block37;
                        }
                        if (entityPlayer3.isSpectator()) return 0.0f;
                        entityPlayer3 = entityPlayer;
                    }
                    if (n3 == 0) {
                        if (entityPlayer3.isImmuneToExplosions()) return 0.0f;
                        entityPlayer3 = entityPlayer;
                    }
                    if (n3 == 0) {
                        if (entityPlayer3.isEntityInvulnerable(\u046d)) {
                            return 0.0f;
                        }
                        entityPlayer3 = entityPlayer;
                    }
                    double d2 = d = entityPlayer3.getDistance(vec3.xCoord, vec3.yCoord, vec3.zCoord) / ((double)f * 2.0);
                    if (n3 == 0) {
                        if (d2 > 1.0) {
                            return 0.0f;
                        }
                        d2 = world2.getBlockDensity(vec3, entityPlayer.getEntityBoundingBox());
                    }
                    double d3 = d2;
                    double d4 = (1.0 - d) * d3;
                    f4 = (int)((d4 * d4 + d4) * 0.5 * 8.0 * ((double)f * 2.0) + 1.0);
                    n2 = n;
                    if (n3 != 0) break block38;
                    if (n2 == 0) break block39;
                    n2 = occadfec20a1.\u029f[world2.getDifficulty().ordinal()];
                    if (n3 != 0) break block38;
                    switch (n2) {
                        case 1: {
                            return 0.0f;
                        }
                        case 2: {
                            f4 = f4 * 0.5f + 1.0f;
                            if (n3 == 0) break;
                        }
                        case 3: {
                            f4 *= 1.5f;
                            break;
                        }
                    }
                }
                entityPlayer2 = entityPlayer;
                if (n3 != 0) break block40;
                n2 = entityPlayer2.isBlocking() ? 1 : 0;
            }
            if (n2 != 0) {
                f4 = (f4 + 1.0f) * 0.5f;
            }
            f3 = f4;
            f2 = 25.0f;
            if (n3 != 0) return Math.max(f3, f2);
            f4 = f3 * ((f2 - (float)entityPlayer.getTotalArmorValue()) / 25.0f);
            entityPlayer2 = entityPlayer;
        }
        if (entityPlayer2.isPotionActive(Potion.resistance)) {
            int n4 = entityPlayer.getActivePotionEffect(Potion.resistance).getAmplifier() + 1;
            f4 *= Math.max(0.0f, 1.0f - (float)n4 * 0.2f);
        }
        f3 = 0.0f;
        f2 = (f4 *= 1.0f - oce5883ca002.\u0428(entityPlayer.inventory.armorInventory) / 25.0f) - entityPlayer.getAbsorptionAmount();
        return Math.max(f3, f2);
    }

    private static float \u0428(ItemStack[] itemStackArray) {
        float f;
        float f2;
        block18: {
            int n;
            int n2;
            int n3;
            block14: {
                n3 = 0;
                ItemStack[] itemStackArray2 = itemStackArray;
                n2 = itemStackArray2.length;
                n = oc75d51ec7eb.\u03e9;
                int n4 = 0;
                block8: while (true) {
                    int n5 = n4;
                    block9: while (n5 < n2) {
                        block17: {
                            ItemStack itemStack;
                            block15: {
                                ItemStack itemStack2;
                                block16: {
                                    itemStack2 = itemStackArray2[n4];
                                    if (n != 0) break block14;
                                    itemStack = itemStack2;
                                    if (n != 0) break block15;
                                    if (itemStack != null) break block16;
                                    if (n == 0) break block17;
                                }
                                itemStack = itemStack2;
                            }
                            for (Map.Entry<Integer, Integer> entry : EnchantmentHelper.getEnchantments(itemStack).entrySet()) {
                                n5 = entry.getKey();
                                if (n != 0) continue block9;
                                Enchantment enchantment = Enchantment.getEnchantmentById(n5);
                                if (enchantment != null) {
                                    n3 += enchantment.calcModifierDamage(entry.getValue(), \u046d);
                                }
                                if (n == 0) continue;
                            }
                        }
                        ++n4;
                        if (n == 0) continue block8;
                    }
                    break;
                }
                n3 = Math.max(0, Math.min(0xBB29DB5B ^ 0xBB29DB42, n3));
            }
            int n6 = (n3 + 1) / (0xBB29DB40 ^ 0xBB29DB42);
            n2 = n3 / (0xBB29DB40 ^ 0xBB29DB42) + 1;
            float f3 = 0.0f;
            for (int i = 0; i < n2; ++i) {
                f2 = f3;
                f = Math.min(0xBB29DB56 ^ 0xBB29DB42, n6 + i);
                if (n == 0) {
                    f3 = f2 + f;
                    if (n == 0) continue;
                }
                break block18;
            }
            f2 = f3;
            f = n2;
        }
        return f2 / f;
    }
}

