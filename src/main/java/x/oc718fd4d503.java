/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import x.oc110d7f376c;
import x.oc142aa368f4;
import x.oc2922be51da;
import x.oc51cbcffcfe;
import x.oc66fa4f2195;
import x.oc8ce2882092;
import x.oc9adb807c19;
import x.oc9ca56f2b8b;
import x.oc9d4393f3ce;
import x.ocbab3c9954b;
import x.occ9a2be31f2;
import x.oce79181588d;

public class oc718fd4d503 {
    public static final oc718fd4d503 \u014c = new oc718fd4d503();
    private final Minecraft \u0283 = Minecraft.getMinecraft();
    private oc9ca56f2b8b \u0413;
    private int \u020e;
    public static int \u0533;

    private oc718fd4d503() {
    }

    public synchronized void \u03db(Object object, int n, Integer n2, boolean bl, boolean bl2, boolean bl3) {
        this.\u0392(object, n, null, n2, bl, bl2, bl3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public synchronized void \u0392(Object object, int n, Integer n2, Integer n3, boolean bl, boolean bl2, boolean bl3) {
        oc718fd4d503 oc718fd4d5032;
        block23: {
            int n4;
            block22: {
                int n5;
                block19: {
                    block21: {
                        Integer n6;
                        block20: {
                            block18: {
                                block17: {
                                    int n7;
                                    block16: {
                                        n5 = oc2922be51da.\u0431;
                                        n7 = n;
                                        if (n5 != 0) break block16;
                                        if (n7 < 0) return;
                                        n7 = n;
                                    }
                                    if (n7 < InventoryPlayer.getHotbarSize() && this.\u0283.thePlayer != null) break block17;
                                    return;
                                }
                                n6 = n2;
                                if (n5 != 0) break block18;
                                if (n6 == null) break block19;
                                n6 = n2;
                                if (n5 != 0) break block20;
                            }
                            if (n6 < 0) break block21;
                            n6 = n2;
                        }
                        n4 = n6;
                        if (n5 != 0) break block22;
                        if (n4 < InventoryPlayer.getHotbarSize()) break block19;
                    }
                    n2 = null;
                }
                oc718fd4d5032 = this;
                if (n5 != 0) break block23;
                oc718fd4d5032.\u0413 = new oc9ca56f2b8b(n, n2, object, n3, bl2, bl3);
                this.\u020e = 0;
                n4 = bl ? 1 : 0;
            }
            if (n4 == 0) return;
            oc718fd4d5032 = this;
        }
        oc718fd4d5032.E();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public synchronized void \u00e0(Object object, boolean bl) {
        oc718fd4d503 oc718fd4d5032;
        block21: {
            block20: {
                oc718fd4d503 oc718fd4d5033;
                int n;
                block19: {
                    Object object2;
                    block18: {
                        block17: {
                            n = oc2922be51da.\u0431;
                            object2 = this;
                            if (n != 0) break block17;
                            if (((oc718fd4d503)object2).\u0413 == null) return;
                            object2 = object;
                        }
                        if (n != 0) break block18;
                        if (object2 == null) break block19;
                        oc718fd4d5033 = this;
                        if (n != 0) break block20;
                        object2 = oc718fd4d5033.\u0413.\u01ed;
                    }
                    if (object2 != object) {
                        return;
                    }
                }
                oc718fd4d5032 = this;
                if (n != 0) break block21;
                oc718fd4d5032.\u0413 = null;
                oc718fd4d5033 = this;
            }
            oc718fd4d5033.\u020e = 0;
            if (!bl) return;
            oc718fd4d5032 = this;
        }
        oc718fd4d5032.E();
    }

    public synchronized boolean \u00eb(Object object) {
        boolean bl;
        block8: {
            block7: {
                Object object2;
                block6: {
                    int n = oc2922be51da.\u0431;
                    object2 = this;
                    if (n != 0) break block6;
                    if (((oc718fd4d503)object2).\u0413 == null) break block7;
                    object2 = this.\u0413.\u01ed;
                }
                if (object2 != object) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public synchronized boolean \u023f() {
        boolean bl = this.\u0413 != null;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public synchronized int \u0532() {
        oc718fd4d503 oc718fd4d5032;
        block15: {
            block16: {
                int n;
                block14: {
                    block12: {
                        block13: {
                            n = oc2922be51da.\u0431;
                            oc718fd4d5032 = this;
                            if (n != 0) break block12;
                            if (oc718fd4d5032.\u0413 == null) break block13;
                            return this.\u0413.\u03c7;
                        }
                        oc718fd4d5032 = this;
                    }
                    if (n != 0) break block14;
                    if (oc718fd4d5032.\u0283 == null) return 0;
                    oc718fd4d5032 = this;
                }
                if (n != 0) break block15;
                if (oc718fd4d5032.\u0283.thePlayer != null) break block16;
                return 0;
            }
            oc718fd4d5032 = this;
        }
        int n = oc718fd4d5032.\u0283.thePlayer.inventory.currentItem;
        return n;
    }

    public synchronized int \u0548(InventoryPlayer inventoryPlayer) {
        int n;
        block31: {
            InventoryPlayer inventoryPlayer2;
            block29: {
                block30: {
                    int n2;
                    block24: {
                        block25: {
                            oc718fd4d503 oc718fd4d5032;
                            block28: {
                                EntityPlayer entityPlayer;
                                block27: {
                                    oc718fd4d503 oc718fd4d5033;
                                    block26: {
                                        n2 = oc2922be51da.\u0431;
                                        inventoryPlayer2 = inventoryPlayer;
                                        if (n2 != 0) break block24;
                                        if (inventoryPlayer2 == null) break block25;
                                        oc718fd4d5033 = this;
                                        if (n2 != 0) break block26;
                                        if (oc718fd4d5033.\u0283 == null) break block25;
                                        oc718fd4d5033 = this;
                                    }
                                    entityPlayer = oc718fd4d5033.\u0283.thePlayer;
                                    if (n2 != 0) break block27;
                                    if (entityPlayer == null) break block25;
                                    inventoryPlayer2 = inventoryPlayer;
                                    if (n2 != 0) break block24;
                                    entityPlayer = inventoryPlayer2.player;
                                }
                                if (entityPlayer != this.\u0283.thePlayer) break block25;
                                oc718fd4d5032 = this;
                                if (n2 != 0) break block28;
                                if (oc718fd4d5032.\u0413 == null) break block25;
                                oc718fd4d5032 = this;
                            }
                            return oc718fd4d5032.\u0413.\u03c7;
                        }
                        inventoryPlayer2 = inventoryPlayer;
                    }
                    if (n2 != 0) break block29;
                    if (inventoryPlayer2 != null) break block30;
                    n = 0;
                    break block31;
                }
                inventoryPlayer2 = inventoryPlayer;
            }
            n = inventoryPlayer2.currentItem;
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public synchronized int \u0274(boolean bl) {
        oc718fd4d503 oc718fd4d5032;
        int n;
        block34: {
            block33: {
                int n2;
                oc718fd4d503 oc718fd4d5033;
                block35: {
                    block36: {
                        int n3;
                        block31: {
                            block32: {
                                block29: {
                                    block30: {
                                        block28: {
                                            n3 = oc2922be51da.\u0431;
                                            oc718fd4d5033 = this;
                                            if (n3 != 0) break block28;
                                            if (oc718fd4d5033.\u0283 == null) return 0;
                                            oc718fd4d5033 = this;
                                        }
                                        if (n3 != 0) break block29;
                                        if (oc718fd4d5033.\u0283.thePlayer != null) break block30;
                                        return 0;
                                    }
                                    oc718fd4d5033 = this;
                                }
                                if (n3 != 0) break block31;
                                if (oc718fd4d5033.\u0413 == null) break block32;
                                n = bl;
                                if (n3 != 0) return n;
                                if (n != 0) break block33;
                                oc718fd4d5032 = this;
                                if (n3 != 0) break block34;
                                if (oc718fd4d5032.\u0413.Z) break block33;
                            }
                            oc718fd4d5033 = this;
                        }
                        if (n3 != 0) break block35;
                        if (oc718fd4d5033.\u0413 == null) break block36;
                        oc718fd4d5033 = this;
                        if (n3 != 0) break block35;
                        if (oc718fd4d5033.\u0413.\u01b3 == null) break block36;
                        n2 = this.\u0413.\u01b3;
                        return n2;
                    }
                    oc718fd4d5033 = this;
                }
                n2 = oc718fd4d5033.\u0283.thePlayer.inventory.currentItem;
                return n2;
            }
            oc718fd4d5032 = this;
        }
        n = oc718fd4d5032.\u0413.\u03c7;
        return n;
    }

    public synchronized ItemStack \u0435(InventoryPlayer inventoryPlayer) {
        ItemStack itemStack;
        block18: {
            block17: {
                int n;
                int n2;
                block16: {
                    int n3;
                    int n4;
                    block15: {
                        InventoryPlayer inventoryPlayer2;
                        block14: {
                            block13: {
                                n4 = oc2922be51da.\u0431;
                                if (inventoryPlayer == null) {
                                    return null;
                                }
                                if (this.\u0283 == null) break block13;
                                inventoryPlayer2 = inventoryPlayer;
                                if (n4 != 0) break block14;
                                if (inventoryPlayer2.player != this.\u0283.thePlayer) break block13;
                                n3 = this.\u0274(false);
                                break block15;
                            }
                            inventoryPlayer2 = inventoryPlayer;
                        }
                        n3 = inventoryPlayer2.currentItem;
                    }
                    n2 = n3;
                    n = n2;
                    if (n4 != 0) break block16;
                    if (n < 0) break block17;
                    n = n2;
                }
                if (n >= inventoryPlayer.mainInventory.length) break block17;
                itemStack = inventoryPlayer.getStackInSlot(n2);
                break block18;
            }
            itemStack = null;
        }
        return itemStack;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0136(oc9adb807c19 oc9adb807c192) {
        int n = oc2922be51da.\u0431;
        if (oc9adb807c192.\u04b0 != oc110d7f376c.START) {
            return;
        }
        oc718fd4d503 oc718fd4d5032 = this;
        synchronized (oc718fd4d5032) {
            oc9ca56f2b8b oc9ca56f2b8b2 = this.\u0413;
            if (n == 0) {
                if (oc9ca56f2b8b2 == null) {
                    return;
                }
                oc9ca56f2b8b2 = this.\u0413;
            }
            if (oc9ca56f2b8b2.\u04fc != null && this.\u020e >= this.\u0413.\u04fc) {
                this.\u00e0(this.\u0413.\u01ed, false);
                return;
            }
            ++this.\u020e;
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0572(occ9a2be31f2 occ9a2be31f22) {
        this.\u01c7();
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0386(oc142aa368f4 oc142aa368f42) {
        this.\u01c7();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0135(oc9d4393f3ce oc9d4393f3ce2) {
        block12: {
            int n = oc2922be51da.\u0431;
            if (!(oc9d4393f3ce2.\u025f() instanceof C09PacketHeldItemChange)) {
                return;
            }
            oc718fd4d503 oc718fd4d5032 = this;
            synchronized (oc718fd4d5032) {
                int n2;
                block13: {
                    oc9ca56f2b8b oc9ca56f2b8b2;
                    C09PacketHeldItemChange c09PacketHeldItemChange;
                    block11: {
                        c09PacketHeldItemChange = (C09PacketHeldItemChange)oc9d4393f3ce2.\u025f();
                        oc9ca56f2b8b2 = this.\u0413;
                        if (n != 0) break block11;
                        if (oc9ca56f2b8b2 == null) break block12;
                        oc9ca56f2b8b2 = this.\u0413;
                    }
                    n2 = oc9ca56f2b8b2.\u0422;
                    if (n != 0) break block13;
                    if (n2 == 0) break block12;
                    n2 = c09PacketHeldItemChange.getSlotId();
                }
                if (n2 != this.\u0413.\u03c7) {
                    this.\u00e0(null, false);
                }
            }
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void R(oce79181588d oce79181588d2) {
        if (oce79181588d2.\u04a0() instanceof S09PacketHeldItemChange) {
            this.\u00e0(null, false);
        }
    }

    @oc66fa4f2195
    public void \u00de(ocbab3c9954b ocbab3c9954b2) {
        this.\u00e0(null, false);
    }

    private synchronized void \u01c7() {
        block9: {
            oc718fd4d503 oc718fd4d5032;
            block10: {
                int n;
                block8: {
                    n = oc2922be51da.\u0431;
                    oc718fd4d5032 = this;
                    if (n != 0) break block8;
                    if (oc718fd4d5032.\u0413 == null) break block9;
                    oc718fd4d5032 = this;
                }
                if (n != 0) break block10;
                if (!oc718fd4d5032.\u0413.\u0422) break block9;
                oc718fd4d5032 = this;
            }
            oc718fd4d5032.\u00e0(null, false);
        }
    }

    private void E() {
        block9: {
            Minecraft minecraft;
            block10: {
                oc718fd4d503 oc718fd4d5032;
                int n;
                block8: {
                    n = oc2922be51da.\u0431;
                    oc718fd4d5032 = this;
                    if (n != 0) break block8;
                    if (oc718fd4d5032.\u0283.thePlayer == null) break block9;
                    oc718fd4d5032 = this;
                }
                minecraft = oc718fd4d5032.\u0283;
                if (n != 0) break block10;
                if (!(minecraft.playerController instanceof oc51cbcffcfe)) break block9;
                minecraft = this.\u0283;
            }
            minecraft.playerController.callSyncCurrentPlayItem();
        }
    }
}

