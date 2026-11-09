/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import x.oc2ef79a3df1;
import x.oc920065c394;
import x.oc75d51ec7eb;

public enum ocb50cc94190 {
    \u00c1("@fist", "Fist", null) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack == null;
        }
    },
    \u0153("@category:sword", "Sword", new ItemStack(Items.diamond_sword)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && itemStack.getItem() instanceof ItemSword;
        }
    },
    \u0544("@category:bow", "Bow", new ItemStack(Items.bow)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && itemStack.getItem() instanceof ItemBow;
        }
    },
    \u0283("@category:tool", "Tool", new ItemStack(Items.diamond_pickaxe)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && oc920065c394.\u040b(itemStack.getItem());
        }
    },
    \u0390("@category:axe", "Axe", new ItemStack(Items.diamond_axe)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && itemStack.getItem() instanceof ItemAxe;
        }
    },
    \u0434("@category:pickaxe", "Pickaxe", new ItemStack(Items.diamond_pickaxe)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && itemStack.getItem() instanceof ItemPickaxe;
        }
    },
    \u013e("@category:shovel", "Shovel", new ItemStack(Items.diamond_shovel)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && itemStack.getItem() instanceof ItemSpade;
        }
    },
    \u046b("@category:hoe", "Hoe", new ItemStack(Items.diamond_hoe)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && itemStack.getItem() instanceof ItemHoe;
        }
    },
    \u00f2("@category:shears", "Shears", new ItemStack(Items.shears)) {
        @Override
        boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
            return itemStack != null && itemStack.getItem() instanceof ItemShears;
        }
    };
    private final String \u03d7;
    private final String \u051b;
    private final ItemStack \u0580;
    private static final ocb50cc94190[] $VALUES_REF;
    static {
        $VALUES_REF = ocb50cc94190.\u056c();
    }

    private ocb50cc94190(String string2, String string3, ItemStack itemStack) {
        this.\u03d7 = string2;
        this.\u051b = string3;
        this.\u0580 = itemStack;
    }

    abstract boolean z$2opx8s6bbbs2u(ItemStack var1);

    oc2ef79a3df1 \u01ff() {
        return new oc2ef79a3df1(null, 0, this.\u051b, this.\u03d7, this.\u0580);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean \u0578(List<String> list) {
        boolean bl;
        int n;
        block23: {
            ocb50cc94190 ocb50cc941902;
            block22: {
                block21: {
                    List<String> list2;
                    block19: {
                        block20: {
                            block18: {
                                n = oc75d51ec7eb.\u03e9;
                                list2 = list;
                                if (n != 0) break block18;
                                if (list2 == null) return false;
                                list2 = list;
                            }
                            if (n != 0) break block19;
                            if (!list2.isEmpty()) break block20;
                            return false;
                        }
                        list2 = list;
                    }
                    boolean bl2 = list2.contains(this.\u03d7);
                    if (n != 0) return bl2;
                    if (!bl2) break block21;
                    return true;
                }
                ocb50cc941902 = this;
                if (n != 0) break block22;
                if (ocb50cc941902 == \u0283) return false;
                ocb50cc941902 = this;
            }
            bl = ocb50cc941902.\u0136();
            if (n != 0) break block23;
            if (!bl) return false;
            bl = list.contains(ocb50cc94190.\u0283.\u03d7);
        }
        if (n != 0) return bl;
        if (!bl) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u0136() {
        ocb50cc94190 ocb50cc941902;
        block21: {
            int n;
            block20: {
                block19: {
                    block18: {
                        n = oc75d51ec7eb.\u03e9;
                        ocb50cc941902 = this;
                        if (n != 0) break block18;
                        if (ocb50cc941902 == \u0390) return true;
                        ocb50cc941902 = this;
                    }
                    if (n != 0) break block19;
                    if (ocb50cc941902 == \u0434) return true;
                    ocb50cc941902 = this;
                }
                if (n != 0) break block20;
                if (ocb50cc941902 == \u013e) return true;
                ocb50cc941902 = this;
            }
            if (n != 0) break block21;
            if (ocb50cc941902 == \u046b) return true;
            ocb50cc941902 = this;
        }
        if (ocb50cc941902 != \u00f2) return false;
        return true;
    }

    static ocb50cc94190 \u0213(String string) {
        int n = oc75d51ec7eb.\u03e9;
        if (string == null) {
            return null;
        }
        ocb50cc94190[] ocb50cc94190Array = ocb50cc94190.values();
        int n2 = ocb50cc94190Array.length;
        int n3 = 0;
        while (n3 < n2) {
            block8: {
                block9: {
                    ocb50cc94190 ocb50cc941902 = ocb50cc94190Array[n3];
                    if (n != 0) break block8;
                    if (!ocb50cc941902.\u03d7.equals(string)) break block9;
                    return ocb50cc941902;
                }
                ++n3;
            }
            if (n == 0) continue;
        }
        return null;
    }

    private static ocb50cc94190[] \u056c() {
        ocb50cc94190[] ocb50cc94190Array = new ocb50cc94190[0xBDB34495 ^ 0xBDB3449C];
        ocb50cc94190Array[0] = \u00c1;
        ocb50cc94190Array[1] = \u0153;
        ocb50cc94190Array[0xBDB3449E ^ 0xBDB3449C] = \u0544;
        ocb50cc94190Array[0xBDB3449F ^ 0xBDB3449C] = \u0283;
        ocb50cc94190Array[0xBDB34498 ^ 0xBDB3449C] = \u0390;
        ocb50cc94190Array[0xBDB34499 ^ 0xBDB3449C] = \u0434;
        ocb50cc94190Array[0xBDB3449A ^ 0xBDB3449C] = \u013e;
        ocb50cc94190Array[0xBDB3449B ^ 0xBDB3449C] = \u046b;
        ocb50cc94190Array[0xBDB34494 ^ 0xBDB3449C] = \u00f2;
        return ocb50cc94190Array;
    }
}
