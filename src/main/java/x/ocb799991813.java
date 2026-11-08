/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import x.oc49ecc1974e;
import x.oc69da1aa7f5;
import x.oc7fbc83d9b3;
import x.oc8c6f2e1f3c;
import x.oca9cc61aada;
import x.occ4cfb65507;
import x.oce4cea752dd;
import x.oce736e6cfcd;

public class ocb799991813
extends oc69da1aa7f5 {
    private static final int \u0199 = 9;
    private static final int \u0100 = 36;
    private static final int \u0265 = 36;
    private static final int \u0466 = 45;
    private static final String[] \u0497;
    private final oca9cc61aada \u027a;
    private final oca9cc61aada \u040d;
    private final oca9cc61aada \u0461;
    private final oca9cc61aada \u0149;
    private final oca9cc61aada \u04f0;
    private final oca9cc61aada \u046b;
    private final oca9cc61aada \u01a7;
    private final oca9cc61aada \u03ea;
    private final oca9cc61aada \u0407;
    private final oca9cc61aada \u023d;
    private final oca9cc61aada[] \u01b5;
    private long \u037b;
    private boolean \u0184;
    public static boolean \u0432;

    public ocb799991813() {
        super("BedInventory", oce4cea752dd.\u04a9);
        this.\u0105("Organizes BedWars items into your chosen hotbar slots.");
        this.\u027a = new oca9cc61aada("Delay (ms)", 100.0, 0.0, 1000.0, 10.0);
        this.\u028c(this.\u027a);
        this.\u040d = new occ4cfb65507("Slot 1", 1, \u0497);
        this.\u028c(this.\u040d);
        this.\u0461 = new occ4cfb65507("Slot 2", 0x2ADF01E1 ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u0461);
        this.\u0149 = new occ4cfb65507("Slot 3", 0x2ADF01E0 ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u0149);
        this.\u04f0 = new occ4cfb65507("Slot 4", 0x2ADF01E7 ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u04f0);
        this.\u046b = new occ4cfb65507("Slot 5", 0x2ADF01E6 ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u046b);
        this.\u01a7 = new occ4cfb65507("Slot 6", 0x2ADF01E5 ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u01a7);
        this.\u03ea = new occ4cfb65507("Slot 7", 0x2ADF01E4 ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u03ea);
        this.\u0407 = new occ4cfb65507("Slot 8", 0x2ADF01EB ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u0407);
        this.\u023d = new occ4cfb65507("Slot 9", 0x2ADF01EA ^ 0x2ADF01E3, \u0497);
        this.\u028c(this.\u023d);
        oca9cc61aada[] oca9cc61aadaArray = new oca9cc61aada[0x2ADF01EA ^ 0x2ADF01E3];
        oca9cc61aadaArray[0] = this.\u040d;
        oca9cc61aadaArray[1] = this.\u0461;
        oca9cc61aadaArray[0x2ADF01E1 ^ 0x2ADF01E3] = this.\u0149;
        oca9cc61aadaArray[0x2ADF01E0 ^ 0x2ADF01E3] = this.\u04f0;
        oca9cc61aadaArray[0x2ADF01E7 ^ 0x2ADF01E3] = this.\u046b;
        oca9cc61aadaArray[0x2ADF01E6 ^ 0x2ADF01E3] = this.\u01a7;
        oca9cc61aadaArray[0x2ADF01E5 ^ 0x2ADF01E3] = this.\u03ea;
        oca9cc61aadaArray[0x2ADF01E4 ^ 0x2ADF01E3] = this.\u0407;
        oca9cc61aadaArray[0x2ADF01EB ^ 0x2ADF01E3] = this.\u023d;
        this.\u01b5 = oca9cc61aadaArray;
    }

    @Override
    public void onDisable() {
        this.\u0184 = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$1m9j3ewef9s() {
        boolean bl;
        block62: {
            block61: {
                boolean bl2;
                block59: {
                    ocb799991813 ocb7999918132;
                    block60: {
                        List<Slot> list;
                        Container container;
                        long l;
                        block58: {
                            int n;
                            block53: {
                                block54: {
                                    block57: {
                                        ocb799991813 ocb7999918133;
                                        block51: {
                                            long l2;
                                            block52: {
                                                List<Slot> list2;
                                                block50: {
                                                    Container container2;
                                                    block48: {
                                                        block49: {
                                                            block47: {
                                                                long l3;
                                                                long l4;
                                                                block46: {
                                                                    boolean bl3;
                                                                    block44: {
                                                                        block45: {
                                                                            bl2 = oce736e6cfcd.\u03ba;
                                                                            bl3 = oc69da1aa7f5.\u0151.currentScreen instanceof GuiInventory;
                                                                            if (bl2) break block44;
                                                                            if (bl3) break block45;
                                                                            this.\u0184 = false;
                                                                            return;
                                                                        }
                                                                        bl3 = this.\u0184;
                                                                    }
                                                                    if (bl3) {
                                                                        return;
                                                                    }
                                                                    l = System.currentTimeMillis();
                                                                    l2 = (long)this.\u027a.\u04c1();
                                                                    l4 = l2;
                                                                    l3 = 0L;
                                                                    if (bl2) break block46;
                                                                    if (l4 <= l3) break block47;
                                                                    l4 = l - this.\u037b;
                                                                    l3 = l2;
                                                                }
                                                                if (l4 < l3) {
                                                                    return;
                                                                }
                                                            }
                                                            container = oc69da1aa7f5.\u0151.thePlayer.openContainer;
                                                            container2 = container;
                                                            if (bl2) break block48;
                                                            if (container2 != null) break block49;
                                                            return;
                                                        }
                                                        container2 = container;
                                                    }
                                                    list = container2.inventorySlots;
                                                    list2 = list;
                                                    if (bl2) break block50;
                                                    if (list2 == null) return;
                                                    list2 = list;
                                                }
                                                n = list2.size();
                                                if (bl2) break block51;
                                                if (n >= (0xA8C693FE ^ 0xA8C693D3)) break block52;
                                                return;
                                            }
                                            long l5 = l2 - 0L;
                                            n = l5 == 0L ? 0 : (l5 < 0L ? -1 : 1);
                                        }
                                        if (bl2) break block53;
                                        if (n > 0) break block54;
                                        int n2 = 0xA8C693E1 ^ 0xA8C693D3;
                                        while (n2-- > 0) {
                                            Container container3;
                                            block55: {
                                                block56: {
                                                    if (bl2) return;
                                                    ocb7999918133 = this;
                                                    container3 = container;
                                                    if (bl2) break block55;
                                                    if (!ocb7999918133.\u01ce(container3, list, l)) break block56;
                                                    if (!bl2) continue;
                                                }
                                                ocb7999918133 = this;
                                                if (bl2) break block57;
                                                container3 = container;
                                            }
                                            if (ocb7999918133.N(container3, list, l) && !bl2) continue;
                                            break;
                                        }
                                        ocb7999918133 = this;
                                    }
                                    ocb7999918133.\u0184 = true;
                                    return;
                                }
                                ocb7999918132 = this;
                                if (bl2) break block58;
                                n = ocb7999918132.\u01ce(container, list, l) ? 1 : 0;
                            }
                            if (n != 0) {
                                return;
                            }
                            ocb7999918132 = this;
                        }
                        if (bl2) break block59;
                        if (!ocb7999918132.N(container, list, l)) break block60;
                        return;
                    }
                    ocb7999918132 = this;
                }
                ocb7999918132.\u0184 = true;
                if (!false) return;
                if (!bl2) break block61;
                bl = false;
                break block62;
            }
            bl = true;
        }
        oce736e6cfcd.\u03ba = bl;
    }

    private boolean \u01ce(Container container, List<Slot> list, long l) {
        boolean bl;
        block14: {
            int n = 0xA5EFE2BE ^ 0xA5EFE29A;
            boolean bl2 = oce736e6cfcd.\u03ba;
            while (n < (0xA5EFE2B7 ^ 0xA5EFE29A)) {
                block13: {
                    block15: {
                        block16: {
                            ocb799991813 ocb7999918132;
                            block17: {
                                ItemStack itemStack = this.\u04a1(list, n);
                                if (bl2) break block13;
                                bl = this.\u04a6(itemStack);
                                if (bl2) break block14;
                                if (!bl) break block15;
                                ocb7999918132 = this;
                                if (bl2) break block16;
                                if (ocb7999918132.\u03ca(list, itemStack)) break block17;
                                if (!bl2) break block15;
                            }
                            oc69da1aa7f5.\u0151.playerController.windowClick(container.windowId, n, 0, 1, oc69da1aa7f5.\u0151.thePlayer);
                            ocb7999918132 = this;
                        }
                        ocb7999918132.\u037b = l;
                        return true;
                    }
                    ++n;
                }
                if (!bl2) continue;
            }
            bl = false;
        }
        return bl;
    }

    private boolean N(Container container, List<Slot> list, long l) {
        boolean[] blArray = new boolean[0xE924BC73 ^ 0xE924BC5E];
        boolean bl = oce736e6cfcd.\u03ba;
        for (int i = 0; i < this.\u01b5.length; ++i) {
            int n;
            block17: {
                int n2;
                block18: {
                    int n3;
                    block15: {
                        block16: {
                            oc49ecc1974e oc49ecc1974e2 = this.\u020c(this.\u01b5[i]);
                            if (oc49ecc1974e2 == oc49ecc1974e.\u04b5 && !bl) continue;
                            n3 = (0xE924BC7A ^ 0xE924BC5E) + i;
                            n2 = this.\u019e(list, oc49ecc1974e2, n3, blArray);
                            n = n2;
                            if (bl) break block15;
                            if (n != -1) break block16;
                            if (!bl) continue;
                        }
                        n = n2;
                    }
                    if (bl) break block17;
                    if (n != n3) break block18;
                    blArray[n3] = true;
                    if (!bl) continue;
                }
                oc69da1aa7f5.\u0151.playerController.windowClick(container.windowId, n2, i, 0xE924BC5C ^ 0xE924BC5E, oc69da1aa7f5.\u0151.thePlayer);
                this.\u037b = l;
                n = 1;
            }
            return n != 0;
        }
        return false;
    }

    private int \u019e(List<Slot> list, oc49ecc1974e oc49ecc1974e2, int n, boolean[] blArray) {
        int n2;
        block25: {
            int n3;
            boolean bl;
            double d;
            int n4;
            block23: {
                int n5;
                block24: {
                    n4 = -1;
                    d = Double.NEGATIVE_INFINITY;
                    ItemStack itemStack = this.\u04a1(list, n);
                    bl = oce736e6cfcd.\u03ba;
                    n5 = blArray[n];
                    if (bl) break block23;
                    if (n5 != 0) break block24;
                    n5 = this.\u03b4(oc49ecc1974e2, itemStack) ? 1 : 0;
                    if (bl) break block23;
                    if (n5 == 0) break block24;
                    n4 = n;
                    d = this.\u0386(oc49ecc1974e2, itemStack);
                }
                n5 = n3 = 0x2D24F8B ^ 0x2D24F82;
            }
            while (n3 < (0x2D24FAF ^ 0x2D24F82)) {
                block30: {
                    block27: {
                        oc49ecc1974e oc49ecc1974e3;
                        ocb799991813 ocb7999918132;
                        ItemStack itemStack;
                        block28: {
                            block29: {
                                boolean bl2;
                                block26: {
                                    n2 = n3;
                                    if (bl) break block25;
                                    if (bl) break block26;
                                    if (n2 == n) break block27;
                                    bl2 = blArray[n3];
                                }
                                if (bl2 && !bl) break block27;
                                itemStack = this.\u04a1(list, n3);
                                ocb7999918132 = this;
                                oc49ecc1974e3 = oc49ecc1974e2;
                                if (bl) break block28;
                                if (ocb7999918132.\u03b4(oc49ecc1974e3, itemStack)) break block29;
                                if (!bl) break block27;
                            }
                            ocb7999918132 = this;
                            oc49ecc1974e3 = oc49ecc1974e2;
                        }
                        double d2 = ocb7999918132.\u0386(oc49ecc1974e3, itemStack);
                        if (bl) break block30;
                        if (!(d2 > d)) break block27;
                        n4 = n3;
                        d = d2;
                    }
                    ++n3;
                }
                if (!bl) continue;
            }
            n2 = n4;
        }
        return n2;
    }

    private boolean \u03ca(List<Slot> list, ItemStack itemStack) {
        int n = 0xBFD9F6D7 ^ 0xBFD9F6DE;
        boolean bl = oce736e6cfcd.\u03ba;
        while (n < (0xBFD9F6FA ^ 0xBFD9F6DE)) {
            block32: {
                block29: {
                    int n2;
                    block35: {
                        ItemStack itemStack2;
                        ItemStack itemStack3;
                        Slot slot;
                        block34: {
                            block33: {
                                Slot slot2;
                                block30: {
                                    block31: {
                                        block27: {
                                            block28: {
                                                slot = list.get(n);
                                                slot2 = slot;
                                                if (bl) break block27;
                                                if (slot2 != null) break block28;
                                                if (!bl) break block29;
                                            }
                                            slot2 = slot;
                                        }
                                        if (bl) break block30;
                                        if (slot2.getHasStack()) break block31;
                                        return true;
                                    }
                                    slot2 = slot;
                                }
                                itemStack3 = slot2.getStack();
                                if (bl) break block32;
                                if (itemStack3 == null) break block29;
                                itemStack2 = itemStack3;
                                if (bl) break block33;
                                if (!itemStack2.isItemEqual(itemStack)) break block29;
                                itemStack2 = itemStack3;
                            }
                            if (bl) break block34;
                            if (!ItemStack.areItemStackTagsEqual(itemStack2, itemStack)) break block29;
                            itemStack2 = itemStack3;
                        }
                        n2 = itemStack2.stackSize;
                        if (bl) break block35;
                        if (n2 >= Math.min(itemStack3.getMaxStackSize(), slot.getItemStackLimit(itemStack3))) break block29;
                        n2 = 1;
                    }
                    return n2 != 0;
                }
                ++n;
            }
            if (!bl) continue;
        }
        return false;
    }

    private ItemStack \u04a1(List<Slot> list, int n) {
        ItemStack itemStack;
        block9: {
            block7: {
                Slot slot;
                block8: {
                    boolean bl;
                    Slot slot2;
                    block6: {
                        slot2 = list.get(n);
                        bl = oce736e6cfcd.\u03ba;
                        slot = slot2;
                        if (bl) break block6;
                        if (slot == null) break block7;
                        slot = slot2;
                    }
                    if (bl) break block8;
                    if (!slot.getHasStack()) break block7;
                    slot = slot2;
                }
                itemStack = slot.getStack();
                break block9;
            }
            itemStack = null;
        }
        return itemStack;
    }

    private oc49ecc1974e \u020c(oca9cc61aada oca9cc61aada2) {
        oc49ecc1974e oc49ecc1974e2;
        block6: {
            block5: {
                int n;
                oc49ecc1974e[] oc49ecc1974eArray;
                int n2;
                block4: {
                    n2 = (int)oca9cc61aada2.\u04c1();
                    oc49ecc1974eArray = oc49ecc1974e.values();
                    boolean bl = oce736e6cfcd.\u03ba;
                    n = n2;
                    if (bl) break block4;
                    if (n < 0) break block5;
                    n = n2;
                }
                if (n >= oc49ecc1974eArray.length) break block5;
                oc49ecc1974e2 = oc49ecc1974eArray[n2];
                break block6;
            }
            oc49ecc1974e2 = oc49ecc1974e.\u04b5;
        }
        return oc49ecc1974e2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean \u03b4(oc49ecc1974e oc49ecc1974e2, ItemStack itemStack) {
        boolean bl = oce736e6cfcd.\u03ba;
        ItemStack itemStack2 = itemStack;
        if (!bl) {
            if (itemStack2 == null) return false;
            itemStack2 = itemStack;
        }
        if (!bl) {
            if (itemStack2.stackSize <= 0) {
                return false;
            }
            itemStack2 = itemStack;
        }
        Item item = itemStack2.getItem();
        boolean bl2 = oc8c6f2e1f3c.\u00d8[oc49ecc1974e2.ordinal()];
        if (bl) return bl2;
        switch (bl2) {
            case 1: {
                return item instanceof ItemSword;
            }
            case 2: {
                return item instanceof ItemPickaxe;
            }
            case 3: {
                return item instanceof ItemAxe;
            }
            case 4: {
                return item instanceof ItemShears;
            }
            case 5: {
                return item instanceof ItemBow;
            }
            case 6: {
                return item instanceof ItemBlock;
            }
            case 7: {
                if (item != Items.arrow) return false;
                return true;
            }
            case 8: {
                return item instanceof ItemAppleGold;
            }
            case 9: {
                return item instanceof ItemPotion;
            }
            case 10: {
                return ocb799991813.\u048f(item);
            }
            case 11: {
                if (item != Items.stick) return false;
                return true;
            }
        }
        return false;
    }

    static boolean \u048f(Item item) {
        boolean bl = item == Items.fire_charge;
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private double \u0386(oc49ecc1974e oc49ecc1974e2, ItemStack itemStack) {
        boolean bl = oce736e6cfcd.\u03ba;
        int n = oc8c6f2e1f3c.\u00d8[oc49ecc1974e2.ordinal()];
        if (!bl) {
            switch (n) {
                case 1: {
                    return oc7fbc83d9b3.\u02b2(itemStack);
                }
                case 2: 
                case 3: {
                    return oc7fbc83d9b3.\u03bd(itemStack);
                }
                case 4: {
                    return 1.0 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, itemStack);
                }
                case 5: {
                    return oc7fbc83d9b3.\u039a(itemStack);
                }
                case 11: {
                    return EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, itemStack);
                }
            }
            n = itemStack.stackSize;
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u04a6(ItemStack itemStack) {
        Item item;
        block22: {
            Item item2;
            boolean bl;
            block21: {
                block20: {
                    ItemStack itemStack2;
                    block18: {
                        block19: {
                            bl = oce736e6cfcd.\u03ba;
                            itemStack2 = itemStack;
                            if (bl) break block18;
                            if (itemStack2 != null) break block19;
                            return false;
                        }
                        itemStack2 = itemStack;
                    }
                    item2 = itemStack2.getItem();
                    item = item2;
                    if (bl) break block20;
                    if (item == Items.iron_ingot) return true;
                    item = item2;
                }
                if (bl) break block21;
                if (item == Items.gold_ingot) return true;
                item = item2;
            }
            if (bl) break block22;
            if (item == Items.diamond) return true;
            item = item2;
        }
        if (item != Items.emerald) return false;
        return true;
    }

    static {
        String[] stringArray = new String[0x2AAF78F1 ^ 0x2AAF78FD];
        stringArray[0] = "None";
        stringArray[1] = "Sword";
        stringArray[0x2AAF78FF ^ 0x2AAF78FD] = "Pickaxe";
        stringArray[0x2AAF78FE ^ 0x2AAF78FD] = "Axe";
        stringArray[0x2AAF78F9 ^ 0x2AAF78FD] = "Shears";
        stringArray[0x2AAF78F8 ^ 0x2AAF78FD] = "Bow";
        stringArray[0x2AAF78FB ^ 0x2AAF78FD] = "Blocks";
        stringArray[0x2AAF78FA ^ 0x2AAF78FD] = "Arrow";
        stringArray[0x2AAF78F5 ^ 0x2AAF78FD] = "Gapple";
        stringArray[0x2AAF78F4 ^ 0x2AAF78FD] = "Potion";
        stringArray[0x2AAF78F7 ^ 0x2AAF78FD] = "Fireball";
        stringArray[0x2AAF78F6 ^ 0x2AAF78FD] = "KnockBack Stick";
        \u0497 = stringArray;
    }
}

