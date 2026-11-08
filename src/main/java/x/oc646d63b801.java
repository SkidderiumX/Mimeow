/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import x.oc69da1aa7f5;
import x.oca9cc61aada;
import x.ocb23d192a35;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.oce736e6cfcd;

public class oc646d63b801
extends oc69da1aa7f5 {
    private final oca9cc61aada \u018e;
    private final ocb23d192a35 \u0540;
    private final ocb23d192a35 \u02a8;
    private final occ2f8dff8d8 \u0249;
    private final occ2f8dff8d8 \u018a;
    private final occ2f8dff8d8 \u051d;
    private final occ2f8dff8d8 \u01c6;
    private final occ2f8dff8d8 \u049b;
    private oce736e6cfcd \u0172 = oce736e6cfcd.\u0241;
    private long \u02a6 = 0L;
    public static boolean \u04e7;

    public oc646d63b801() {
        super("AutoEnder", oce4cea752dd.\u04a9);
        this.\u0105("Deposits or withdraws resources using an ender chest.");
        this.\u018e = new oca9cc61aada("Speed (ms)", 100.0, 0.0, 1000.0, 10.0);
        this.\u028c(this.\u018e);
        this.\u0540 = new ocb23d192a35("Deposit Key", 0);
        this.\u028c(this.\u0540);
        this.\u02a8 = new ocb23d192a35("Withdraw Key", 0);
        this.\u028c(this.\u02a8);
        this.\u0249 = new occ2f8dff8d8("Gold", true);
        this.\u028c(this.\u0249);
        this.\u018a = new occ2f8dff8d8("Iron", true);
        this.\u028c(this.\u018a);
        this.\u051d = new occ2f8dff8d8("Emerald", true);
        this.\u028c(this.\u051d);
        this.\u01c6 = new occ2f8dff8d8("Diamond", true);
        this.\u028c(this.\u01c6);
        this.\u049b = new occ2f8dff8d8("Auto Close", true);
        this.\u028c(this.\u049b);
        this.\u026e = true;
    }

    public oce736e6cfcd d() {
        return this.\u0172;
    }

    @Override
    public void onDisable() {
        this.\u0172 = oce736e6cfcd.\u0241;
    }

    @Override
    public void z$1m9j3ewef9s() {
        block108: {
            long l;
            block113: {
                long l2;
                int n;
                int n2;
                long l3;
                ContainerChest containerChest;
                boolean bl;
                block106: {
                    block107: {
                        long l4;
                        long l5;
                        block100: {
                            block101: {
                                block102: {
                                    int n3;
                                    block98: {
                                        int n4;
                                        block99: {
                                            int n5;
                                            int n6;
                                            block96: {
                                                block97: {
                                                    IInventory iInventory;
                                                    block95: {
                                                        block94: {
                                                            block93: {
                                                                block92: {
                                                                    EntityPlayerSP entityPlayerSP;
                                                                    block90: {
                                                                        block91: {
                                                                            Minecraft minecraft;
                                                                            block88: {
                                                                                block89: {
                                                                                    oc646d63b801 oc646d63b8012;
                                                                                    block87: {
                                                                                        block84: {
                                                                                            ocb23d192a35 ocb23d192a352;
                                                                                            block82: {
                                                                                                block83: {
                                                                                                    boolean bl2;
                                                                                                    block86: {
                                                                                                        block85: {
                                                                                                            bl = oce736e6cfcd.\u03ba;
                                                                                                            ocb23d192a352 = this.\u0540;
                                                                                                            if (bl) break block82;
                                                                                                            if (!ocb23d192a352.\u0190()) break block83;
                                                                                                            this.\u0172 = oce736e6cfcd.l;
                                                                                                            if (!bl) break block84;
                                                                                                            if (!false) break block85;
                                                                                                            bl2 = false;
                                                                                                            break block86;
                                                                                                        }
                                                                                                        bl2 = true;
                                                                                                    }
                                                                                                    oc69da1aa7f5.\u04ac = bl2;
                                                                                                }
                                                                                                oc646d63b8012 = this;
                                                                                                if (bl) break block87;
                                                                                                ocb23d192a352 = oc646d63b8012.\u02a8;
                                                                                            }
                                                                                            if (ocb23d192a352.\u0190()) {
                                                                                                this.\u0172 = oce736e6cfcd.\u029f;
                                                                                            }
                                                                                        }
                                                                                        oc646d63b8012 = this;
                                                                                    }
                                                                                    if (oc646d63b8012.\u0172 == oce736e6cfcd.\u0241) {
                                                                                        return;
                                                                                    }
                                                                                    minecraft = oc69da1aa7f5.\u0151;
                                                                                    if (bl) break block88;
                                                                                    if (minecraft.currentScreen instanceof GuiChest) break block89;
                                                                                    this.\u0172 = oce736e6cfcd.\u0241;
                                                                                    return;
                                                                                }
                                                                                minecraft = oc69da1aa7f5.\u0151;
                                                                            }
                                                                            entityPlayerSP = minecraft.thePlayer;
                                                                            if (bl) break block90;
                                                                            if (entityPlayerSP.openContainer instanceof ContainerChest) break block91;
                                                                            this.\u0172 = oce736e6cfcd.\u0241;
                                                                            return;
                                                                        }
                                                                        entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                                                                    }
                                                                    containerChest = (ContainerChest)entityPlayerSP.openContainer;
                                                                    iInventory = containerChest.getLowerChestInventory();
                                                                    if (bl) break block92;
                                                                    if (iInventory != null) break block93;
                                                                    this.\u0172 = oce736e6cfcd.\u0241;
                                                                }
                                                                return;
                                                            }
                                                            oc646d63b801 oc646d63b8013 = this;
                                                            if (bl) break block94;
                                                            if (oc646d63b8013.\u0413(iInventory)) break block95;
                                                            oc646d63b8013 = this;
                                                        }
                                                        oc646d63b8013.\u0172 = oce736e6cfcd.\u0241;
                                                        return;
                                                    }
                                                    l3 = System.currentTimeMillis();
                                                    l5 = (long)this.\u018e.\u04c1();
                                                    int n7 = this.\u0172 == oce736e6cfcd.l ? 1 : 0;
                                                    n6 = n7;
                                                    n4 = iInventory.getSizeInventory();
                                                    n5 = n6;
                                                    if (bl) break block96;
                                                    if (n5 == 0) break block97;
                                                    n5 = n4;
                                                    break block96;
                                                }
                                                n5 = 0;
                                            }
                                            n2 = n5;
                                            n3 = n6;
                                            if (bl) break block98;
                                            if (n3 == 0) break block99;
                                            n3 = containerChest.inventorySlots.size();
                                            break block98;
                                        }
                                        n3 = n4;
                                    }
                                    n = n3;
                                    l4 = l5;
                                    if (bl) break block100;
                                    if (l4 > 0L) break block101;
                                    int n8 = n2;
                                    while (n8 < n) {
                                        block103: {
                                            block104: {
                                                boolean bl3;
                                                block105: {
                                                    if (bl) break block102;
                                                    Slot slot = (Slot)containerChest.inventorySlots.get(n8);
                                                    if (bl) break block103;
                                                    if (slot == null) break block104;
                                                    bl3 = slot.getHasStack();
                                                    if (bl) break block105;
                                                    if (!bl3) break block104;
                                                    bl3 = this.\u04b0(slot.getStack());
                                                }
                                                if (!bl3 && !bl) break block104;
                                                oc69da1aa7f5.\u0151.playerController.windowClick(containerChest.windowId, n8, 0, 1, oc69da1aa7f5.\u0151.thePlayer);
                                            }
                                            ++n8;
                                        }
                                        if (!bl) continue;
                                    }
                                    this.\u0172 = oce736e6cfcd.\u0241;
                                }
                                if (this.\u049b.\u01ed()) {
                                    oc69da1aa7f5.\u0151.thePlayer.closeScreen();
                                }
                                return;
                            }
                            l4 = l3 - this.\u02a6;
                        }
                        long l6 = l4 - l5;
                        l2 = l6 == 0L ? 0 : (l6 < 0L ? -1 : 1);
                        if (bl) break block106;
                        if (l2 >= 0) break block107;
                        return;
                    }
                    l2 = 0;
                }
                long l7 = l2;
                int n9 = n2;
                while (n9 < n) {
                    block109: {
                        block110: {
                            block112: {
                                oc646d63b801 oc646d63b8014;
                                boolean bl4;
                                block111: {
                                    if (bl) break block108;
                                    Slot slot = (Slot)containerChest.inventorySlots.get(n9);
                                    if (bl) break block109;
                                    if (slot == null) break block110;
                                    bl4 = slot.getHasStack();
                                    if (bl) break block111;
                                    if (!bl4) break block110;
                                    oc646d63b8014 = this;
                                    if (bl) break block112;
                                    bl4 = oc646d63b8014.\u04b0(slot.getStack());
                                }
                                if (!bl4 && !bl) break block110;
                                oc69da1aa7f5.\u0151.playerController.windowClick(containerChest.windowId, n9, 0, 1, oc69da1aa7f5.\u0151.thePlayer);
                                oc646d63b8014 = this;
                            }
                            oc646d63b8014.\u02a6 = l3;
                            l7 = 1;
                            return;
                        }
                        ++n9;
                    }
                    if (!bl) continue;
                }
                l = l7;
                if (bl) break block113;
                if (l != false) break block108;
                this.\u0172 = oce736e6cfcd.\u0241;
                l = (long)this.\u049b.\u01ed();
            }
            if (l != false) {
                oc69da1aa7f5.\u0151.thePlayer.closeScreen();
            }
        }
    }

    private boolean \u0413(IInventory iInventory) {
        boolean bl;
        block14: {
            block16: {
                block15: {
                    String string = iInventory.getName();
                    boolean bl2 = oce736e6cfcd.\u03ba;
                    String string2 = iInventory.getDisplayName().getUnformattedText();
                    bl = string.contains("Ender Chest");
                    if (bl2) break block14;
                    if (bl) break block15;
                    bl = string.contains("container.enderchest");
                    if (bl2) break block14;
                    if (bl) break block15;
                    bl = string2.contains("Ender Chest");
                    if (bl2) break block14;
                    if (bl) break block15;
                    bl = string2.contains("enderChest");
                    if (bl2) break block14;
                    if (!bl) break block16;
                }
                bl = true;
                break block14;
            }
            bl = false;
        }
        return bl;
    }

    private boolean \u04b0(ItemStack itemStack) {
        boolean bl;
        block34: {
            block40: {
                block35: {
                    ItemStack itemStack2;
                    boolean bl2;
                    block38: {
                        block39: {
                            Item item;
                            block36: {
                                block37: {
                                    block32: {
                                        block33: {
                                            ItemStack itemStack3;
                                            block30: {
                                                block31: {
                                                    bl2 = oce736e6cfcd.\u03ba;
                                                    itemStack3 = itemStack;
                                                    if (bl2) break block30;
                                                    if (itemStack3 != null) break block31;
                                                    return false;
                                                }
                                                itemStack3 = itemStack;
                                            }
                                            item = itemStack3.getItem();
                                            if (bl2) break block32;
                                            if (item != Items.gold_ingot) break block33;
                                            bl = this.\u0249.\u01ed();
                                            if (bl2) break block34;
                                            if (bl) break block35;
                                        }
                                        item = itemStack.getItem();
                                    }
                                    if (bl2) break block36;
                                    if (item != Items.iron_ingot) break block37;
                                    bl = this.\u018a.\u01ed();
                                    if (bl2) break block34;
                                    if (bl) break block35;
                                }
                                itemStack2 = itemStack;
                                if (bl2) break block38;
                                item = itemStack2.getItem();
                            }
                            if (item != Items.emerald) break block39;
                            bl = this.\u051d.\u01ed();
                            if (bl2) break block34;
                            if (bl) break block35;
                        }
                        itemStack2 = itemStack;
                    }
                    if (itemStack2.getItem() != Items.diamond) break block40;
                    bl = this.\u01c6.\u01ed();
                    if (bl2) break block34;
                    if (!bl) break block40;
                }
                bl = true;
                break block34;
            }
            bl = false;
        }
        return bl;
    }
}

