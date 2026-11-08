/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import x.oc2f61de30bc;
import x.oc507025139f;
import x.oc5e549848f3;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc7fbc83d9b3;
import x.oc86de9e2892;
import x.oc8ce2882092;
import x.oc9755810e45;
import x.oca9cc61aada;
import x.ocb23d192a35;
import x.ocbab3c9954b;
import x.occ48acb5d22;
import x.oce4cea752dd;

public class oc7a57fbe3a8
extends oc69da1aa7f5 {
    private final ocb23d192a35 \u0113;
    private final oca9cc61aada \u0537;
    private final oca9cc61aada l;
    private final oca9cc61aada \u0570;
    private int \u03eb;
    private int \u0177;
    private long \u01cd;
    private boolean \u0531;
    private boolean \u012c;
    private int \u044b = -1;
    private int \u04e2;
    private int \u0498 = -1;
    private int \u03b0 = -1;
    private int \u021c;
    public static boolean \u023d;

    public oc7a57fbe3a8() {
        super("AutoPot", oce4cea752dd.\u0201);
        this.\u0105("Throws healing potions.");
        this.\u0113 = new ocb23d192a35("Active Keybind", 0);
        this.\u028c(this.\u0113);
        this.\u0537 = new oca9cc61aada("Health", 15.0, 1.0, 20.0, 1.0);
        this.\u028c(this.\u0537);
        this.l = new oca9cc61aada("Delay", 0.0, 0.0, 100.0, 5.0);
        this.\u028c(this.l);
        this.\u0570 = new oca9cc61aada("Max aim ticks", 10.0, 2.0, 30.0, 1.0);
        this.\u028c(this.\u0570);
    }

    @Override
    public void onEnable() {
        this.\u04c4(true);
    }

    @Override
    public void onDisable() {
        this.\u04c4(true);
    }

    @oc66fa4f2195
    public void \u0267(oc2f61de30bc oc2f61de30bc2) {
        int n;
        block76: {
            block77: {
                block72: {
                    int n2;
                    block75: {
                        oc7a57fbe3a8 oc7a57fbe3a82;
                        block74: {
                            int n3;
                            block73: {
                                block71: {
                                    oc7a57fbe3a8 oc7a57fbe3a83;
                                    block65: {
                                        block66: {
                                            block69: {
                                                oc7a57fbe3a8 oc7a57fbe3a84;
                                                block70: {
                                                    block67: {
                                                        block68: {
                                                            block63: {
                                                                block64: {
                                                                    block60: {
                                                                        block62: {
                                                                            oc7a57fbe3a8 oc7a57fbe3a85;
                                                                            block61: {
                                                                                block59: {
                                                                                    int n4;
                                                                                    block78: {
                                                                                        block58: {
                                                                                            int n5;
                                                                                            int n6;
                                                                                            block57: {
                                                                                                n2 = oc5e549848f3.\u0130;
                                                                                                if (!oc7ab2161b9f.\u00d0()) {
                                                                                                    this.\u04c4(false);
                                                                                                    return;
                                                                                                }
                                                                                                oc7a57fbe3a8 oc7a57fbe3a86 = this;
                                                                                                int n5 = 0xE67281D ^ 0x7198D7E2;
                                                                                                n5 = this.\u03eb + 1;
                                                                                                if (n2 != 0) break block57;
                                                                                                oc7a57fbe3a86.\u03eb = Math.min(n6, n5);
                                                                                                oc7a57fbe3a86 = this;
                                                                                                if (!oc69da1aa7f5.\u0151.thePlayer.onGround) break block58;
                                                                                                int n5 = 0xE67281D ^ 0x7198D7E2;
                                                                                                n5 = this.\u0177 + 1;
                                                                                            }
                                                                                            n4 = Math.min(n6, n5);
                                                                                            break block78;
                                                                                        }
                                                                                        n4 = 0;
                                                                                    }
                                                                                    oc7a57fbe3a86.\u0177 = n4;
                                                                                    if (n2 != 0) break block59;
                                                                                    if (this.\u021c <= 0) break block60;
                                                                                    oc7a57fbe3a85 = this;
                                                                                    if (n2 != 0) break block61;
                                                                                    --oc7a57fbe3a85.\u021c;
                                                                                }
                                                                                if (this.\u021c != 0) break block62;
                                                                                oc7a57fbe3a85 = this;
                                                                            }
                                                                            oc7a57fbe3a85.\u012c();
                                                                        }
                                                                        return;
                                                                    }
                                                                    if (oc69da1aa7f5.\u0151.currentScreen != null) {
                                                                        this.\u03eb = 0;
                                                                        this.\u0295();
                                                                        return;
                                                                    }
                                                                    oc7a57fbe3a83 = this;
                                                                    if (n2 != 0) break block63;
                                                                    if (oc7a57fbe3a83.\u0113.\u0190()) break block64;
                                                                    this.\u0295();
                                                                    return;
                                                                }
                                                                oc7a57fbe3a83 = this;
                                                            }
                                                            if (n2 != 0) break block65;
                                                            if (!oc7a57fbe3a83.\u0531) break block66;
                                                            ++this.\u04e2;
                                                            oc7a57fbe3a84 = this;
                                                            if (n2 != 0) break block67;
                                                            if (!oc7a57fbe3a84.\u012c) break block68;
                                                            this.\u0292();
                                                            if (n2 == 0) break block69;
                                                        }
                                                        oc7a57fbe3a84 = this;
                                                    }
                                                    if (n2 != 0) break block70;
                                                    if (oc7a57fbe3a84.\u04e2 < (int)this.\u0570.\u04c1()) break block69;
                                                    oc7a57fbe3a84 = this;
                                                }
                                                oc7a57fbe3a84.\u0295();
                                            }
                                            return;
                                        }
                                        oc7a57fbe3a83 = this;
                                    }
                                    n3 = oc7a57fbe3a83.\u0177;
                                    if (n2 != 0) break block71;
                                    if (n3 <= 1) break block72;
                                    long l = System.currentTimeMillis() - this.\u01cd;
                                    n3 = l == 0L ? 0 : (l < 0L ? -1 : 1);
                                }
                                if (n2 != 0) break block73;
                                if (n3 < 0) break block72;
                                oc7a57fbe3a82 = this;
                                if (n2 != 0) break block74;
                                n3 = oc7a57fbe3a82.\u03eb;
                            }
                            if (n3 < (0x7198D7E8 ^ 0x7198D7E2)) break block72;
                            oc7a57fbe3a82 = this;
                        }
                        n = oc7a57fbe3a82.\u0116();
                        if (n2 != 0) break block75;
                        if (n != 0) break block72;
                        n = oc69da1aa7f5.\u0151.thePlayer.isUsingItem();
                    }
                    if (n2 != 0) break block76;
                    if (n == 0) break block77;
                }
                return;
            }
            n = this.\u0262();
        }
        int n7 = n;
        if (n7 != -1) {
            this.\u012d(n7);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u04af(oc86de9e2892 oc86de9e28922) {
        block32: {
            float f;
            block33: {
                block34: {
                    float[] fArray;
                    int n;
                    block31: {
                        float f2;
                        float f3;
                        block37: {
                            block30: {
                                oc86de9e2892 oc86de9e28923;
                                block29: {
                                    float f4;
                                    block36: {
                                        block28: {
                                            oc86de9e2892 oc86de9e28924;
                                            block27: {
                                                block35: {
                                                    oc7a57fbe3a8 oc7a57fbe3a82;
                                                    block26: {
                                                        boolean bl;
                                                        block24: {
                                                            block25: {
                                                                block23: {
                                                                    block22: {
                                                                        n = oc5e549848f3.\u0130;
                                                                        bl = this.\u0531;
                                                                        if (n != 0) break block22;
                                                                        if (!bl) break block23;
                                                                        bl = oc7ab2161b9f.\u00d0();
                                                                    }
                                                                    if (n != 0) break block24;
                                                                    if (bl) break block25;
                                                                }
                                                                return;
                                                            }
                                                            oc7a57fbe3a82 = this;
                                                            if (n != 0) break block26;
                                                            bl = oc7a57fbe3a82.\u0113.\u0190();
                                                        }
                                                        if (bl) break block35;
                                                        oc7a57fbe3a82 = this;
                                                    }
                                                    oc7a57fbe3a82.\u0295();
                                                    return;
                                                }
                                                oc86de9e28924 = oc86de9e28922;
                                                if (n != 0) break block27;
                                                if (oc86de9e28924.\u04dc == null) break block28;
                                                oc86de9e28924 = oc86de9e28922;
                                            }
                                            f4 = oc86de9e28924.\u04dc.floatValue();
                                            break block36;
                                        }
                                        f4 = oc75d51ec7eb.d[0];
                                    }
                                    f3 = f4;
                                    oc86de9e28923 = oc86de9e28922;
                                    if (n != 0) break block29;
                                    if (oc86de9e28923.\u0177 == null) break block30;
                                    oc86de9e28923 = oc86de9e28922;
                                }
                                f2 = oc86de9e28923.\u0177.floatValue();
                                break block37;
                            }
                            f2 = oc75d51ec7eb.d[1];
                        }
                        float f5 = f2;
                        float[] fArray2 = new float[0x38B930EA ^ 0x38B930E8];
                        fArray2[0] = f3;
                        fArray2[1] = f5;
                        float[] fArray3 = new float[0x38B930EA ^ 0x38B930E8];
                        fArray3[0] = f3;
                        fArray3[1] = 90.0f;
                        fArray = oc75d51ec7eb.\u01d0(fArray2, fArray3, 10.0f);
                        if (n != 0) break block31;
                        if (!oc86de9e28922.\u043b(this, 0x38B9311C ^ 0x38B930E8, Float.valueOf(fArray[0]), Float.valueOf(fArray[1]))) break block32;
                        oc86de9e28922.\u0290(true);
                    }
                    oc7a57fbe3a8 oc7a57fbe3a83 = this;
                    float f6 = fArray[1] - 85.0f;
                    f = f6 == 0.0f ? 0 : (f6 > 0.0f ? 1 : -1);
                    if (n != 0) break block33;
                    if (f <= 0) break block34;
                    f = 1.0f;
                    break block33;
                }
                f = 0.0f;
            }
            oc7a57fbe3a83.\u012c = f;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u04af(oc507025139f oc507025139f2) {
        block6: {
            oc7a57fbe3a8 oc7a57fbe3a82;
            block5: {
                int n = oc5e549848f3.\u0130;
                oc7a57fbe3a82 = this;
                if (n != 0) break block5;
                if (oc7a57fbe3a82.\u0531) break block6;
                oc7a57fbe3a82 = this;
            }
            if (oc7a57fbe3a82.\u021c <= 0) return;
        }
        oc507025139f2.setCanceled(true);
    }

    @oc66fa4f2195
    public void \u041c(occ48acb5d22 occ48acb5d222) {
        if (occ48acb5d222.\u01d5 == oc69da1aa7f5.\u0151.thePlayer) {
            this.\u03eb = 0;
        }
    }

    @oc66fa4f2195
    public void \u04d7(ocbab3c9954b ocbab3c9954b2) {
        this.\u04c4(false);
    }

    private void \u012d(int n) {
        this.\u0531 = true;
        this.\u012c = false;
        this.\u044b = n;
        this.\u04e2 = 0;
    }

    private void \u0295() {
        this.\u0531 = false;
        this.\u012c = false;
        this.\u044b = -1;
        this.\u04e2 = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0292() {
        block14: {
            block12: {
                int n;
                block13: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    block11: {
                        ItemStack itemStack3 = oc69da1aa7f5.\u0151.thePlayer.inventory.getStackInSlot(this.\u044b);
                        n = oc5e549848f3.\u0130;
                        oc7a57fbe3a8 oc7a57fbe3a82 = this;
                        if (n == 0) {
                            if (!oc7a57fbe3a82.\u03af(itemStack3)) {
                                this.\u0295();
                                return;
                            }
                            this.\u0498 = oc69da1aa7f5.\u0151.thePlayer.inventory.currentItem;
                            this.\u03b0 = this.\u044b;
                            oc7a57fbe3a82 = this;
                        }
                        oc7ab2161b9f.\u0101(oc7a57fbe3a82.\u044b, true);
                        itemStack = itemStack2 = oc69da1aa7f5.\u0151.thePlayer.inventory.getCurrentItem();
                        if (n != 0) break block11;
                        if (itemStack == null) break block12;
                        itemStack = itemStack2;
                    }
                    boolean bl = itemStack.getItem() instanceof ItemPotion;
                    if (n != 0) break block13;
                    if (!bl) break block12;
                    bl = oc69da1aa7f5.\u0151.playerController.sendUseItem(oc69da1aa7f5.\u0151.thePlayer, oc69da1aa7f5.\u0151.theWorld, itemStack2);
                }
                this.\u01cd = System.currentTimeMillis() + (long)this.l.\u04c1() * (0x82BD26FCAB4F53C6L ^ 0x82BD26FCAB4F53CCL);
                this.\u021c = 1;
                if (n == 0) break block14;
            }
            this.\u012c();
        }
        this.\u0295();
    }

    private int \u0262() {
        int n;
        block5: {
            int n2 = oc5e549848f3.\u0130;
            for (int i = 0; i < (0xE4893620 ^ 0xE4893629); ++i) {
                int n3;
                block6: {
                    n = this.\u03af(oc69da1aa7f5.\u0151.thePlayer.inventory.getStackInSlot(i)) ? 1 : 0;
                    if (n2 != 0) break block5;
                    if (n2 != 0) break block6;
                    if (n == 0) continue;
                    n3 = i;
                }
                return n3;
            }
            n = -1;
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u03af(ItemStack itemStack) {
        PotionEffect potionEffect;
        int n;
        block60: {
            Potion potion;
            block59: {
                block58: {
                    int n2;
                    int n3;
                    block57: {
                        block55: {
                            block56: {
                                int n4;
                                block52: {
                                    block54: {
                                        block53: {
                                            Object object;
                                            block50: {
                                                List<PotionEffect> list;
                                                block51: {
                                                    block49: {
                                                        ItemStack itemStack2;
                                                        block47: {
                                                            block48: {
                                                                ItemStack itemStack3;
                                                                block46: {
                                                                    n = oc5e549848f3.\u0130;
                                                                    itemStack3 = itemStack;
                                                                    if (n != 0) break block46;
                                                                    if (itemStack3 == null) return 0 != 0;
                                                                    itemStack3 = itemStack;
                                                                }
                                                                int n5 = itemStack3.getItem() instanceof ItemPotion;
                                                                if (n != 0) return n5 != 0;
                                                                if (n5 == 0) return 0 != 0;
                                                                n5 = itemStack.getMetadata();
                                                                if (n != 0) return n5 != 0;
                                                                if (!ItemPotion.isSplash(n5)) return 0 != 0;
                                                                itemStack2 = itemStack;
                                                                if (n != 0) break block47;
                                                                if (oc7fbc83d9b3.\u0177(itemStack2)) break block48;
                                                                return 0 != 0;
                                                            }
                                                            itemStack2 = itemStack;
                                                        }
                                                        list = ((ItemPotion)itemStack2.getItem()).getEffects(itemStack);
                                                        object = list;
                                                        if (n != 0) break block49;
                                                        if (object == null) return false;
                                                        object = list;
                                                    }
                                                    if (n != 0) break block50;
                                                    if (!object.isEmpty()) break block51;
                                                    return false;
                                                }
                                                object = list.get(0);
                                            }
                                            PotionEffect potionEffect2 = (PotionEffect)object;
                                            n3 = potionEffect2.getPotionID();
                                            n4 = n3;
                                            if (n != 0) break block52;
                                            if (n4 == Potion.regeneration.id) break block53;
                                            n4 = n3;
                                            if (n != 0) break block52;
                                            if (n4 != Potion.heal.id) break block54;
                                        }
                                        n4 = 1;
                                        break block52;
                                    }
                                    n4 = 0;
                                }
                                int n6 = n4;
                                n2 = n6;
                                if (n != 0) break block55;
                                if (n2 == 0) break block56;
                                double d = (double)oc69da1aa7f5.\u0151.thePlayer.getHealth() - this.\u0537.\u04c1();
                                n2 = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
                                if (n != 0) break block55;
                                if (n2 <= 0) break block56;
                                return false;
                            }
                            n2 = n3;
                        }
                        if (n != 0) break block57;
                        if (n2 < 0) break block58;
                        n2 = n3;
                    }
                    if (n2 >= Potion.potionTypes.length) break block58;
                    potion = Potion.potionTypes[n3];
                    break block59;
                }
                potion = null;
            }
            Potion potion2 = potion;
            PotionEffect potionEffect3 = potion2 == null ? null : oc69da1aa7f5.\u0151.thePlayer.getActivePotionEffect(potion2);
            PotionEffect potionEffect4 = potionEffect3;
            potionEffect = potionEffect4;
            if (n != 0) break block60;
            if (potionEffect == null) return 1 != 0;
            potionEffect = potionEffect4;
        }
        int n7 = potionEffect.getDuration();
        if (n != 0) return n7 != 0;
        if (n7 != 0) return 0 != 0;
        return 1 != 0;
    }

    private boolean \u0116() {
        int n = oc5e549848f3.\u0130;
        int n2 = 0x4C5C36EA ^ 0xA2670D9B;
        block8: while (true) {
            int n3;
            block10: {
                block11: {
                    switch (n2) {
                        default: {
                            throw null;
                        }
                        case -362993082: {
                            return true;
                        }
                        case -298108047: {
                            if (oc9755810e45.\u01dc != null) {
                                n2 = 0x8077ECB2 ^ 0xA2670D9B;
                                if (n == 0) continue block8;
                            }
                            n2 = 0xC268444 ^ 0xA2670D9B;
                            if (n == 0) continue block8;
                        }
                        case -1371436577: {
                            return false;
                        }
                        case 571531561: 
                    }
                    n3 = oc9755810e45.\u01dc.z$3rzb3dil7uydr();
                    if (n != 0) break block10;
                    if (n3 == 0) break block11;
                    n2 = 0x483A27DD ^ 0xA2670D9B;
                    if (n == 0) continue;
                }
                n3 = 0xC268444 ^ 0xA2670D9B;
            }
            n2 = n3;
        }
    }

    private void \u012c() {
        block18: {
            oc7a57fbe3a8 oc7a57fbe3a82;
            block17: {
                int n;
                block19: {
                    int n2;
                    int n3;
                    block16: {
                        n3 = oc5e549848f3.\u0130;
                        n2 = oc7ab2161b9f.\u00d0();
                        if (n3 != 0) break block16;
                        if (n2 == 0) break block17;
                        oc7a57fbe3a82 = this;
                        if (n3 != 0) break block18;
                        n2 = oc7a57fbe3a82.\u0498;
                    }
                    if (n2 < 0) break block17;
                    oc7a57fbe3a82 = this;
                    if (n3 != 0) break block18;
                    if (oc7a57fbe3a82.\u0498 >= (0xFF8198F6 ^ 0xFF8198FF)) break block17;
                    n = oc69da1aa7f5.\u0151.thePlayer.inventory.currentItem;
                    if (n3 != 0) break block19;
                    if (n != this.\u03b0) break block17;
                    n = this.\u0498;
                }
                oc7ab2161b9f.\u0101(n, true);
            }
            this.\u0498 = -1;
            oc7a57fbe3a82 = this;
        }
        oc7a57fbe3a82.\u03b0 = -1;
    }

    private void \u04c4(boolean bl) {
        if (bl) {
            this.\u012c();
        }
        this.\u0295();
        this.\u03eb = 0;
        this.\u0177 = 0;
        this.\u01cd = 0L;
        this.\u021c = 0;
        this.\u0498 = -1;
        this.\u03b0 = -1;
    }
}

