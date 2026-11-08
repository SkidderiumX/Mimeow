/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import x.oc4d46a99983;
import x.oc668fce0dbf;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.oce4cea752dd;

public class ocd2c4efd8d9
extends oc69da1aa7f5 {
    private final occc831eff22 \u0539 = new occc831eff22("Condition");
    private final occ2f8dff8d8 \u0562;
    private final occ2f8dff8d8 \u0217;
    private final occ2f8dff8d8 \u02a9;
    private final occ2f8dff8d8 \u03eb;
    public static int j;

    public ocd2c4efd8d9() {
        super("Sprint", oce4cea752dd.\u0495, 0);
        this.\u0105("Automatically sprints when movement allows it.");
        this.\u028c(new oc4d46a99983("Allow while"));
        this.\u028c(this.\u0539);
        this.\u0562 = new occ2f8dff8d8(this.\u0539, "Using item", false);
        this.\u028c(this.\u0562);
        this.\u0217 = new occ2f8dff8d8(this.\u0539, "Backwards", false);
        this.\u028c(this.\u0217);
        this.\u02a9 = new occ2f8dff8d8(this.\u0539, "Sideways", false);
        this.\u028c(this.\u02a9);
        this.\u03eb = new occ2f8dff8d8(this.\u0539, "In inventory", false);
        this.\u028c(this.\u03eb);
        this.\u026e = true;
    }

    @Override
    public void onDisable() {
        block5: {
            int n;
            block4: {
                boolean bl = false;
                n = oc7ab2161b9f.\u00d0();
                if (bl) break block4;
                if (n == 0) break block5;
                n = oc69da1aa7f5.\u0151.gameSettings.keyBindSprint.getKeyCode();
            }
            KeyBinding.setKeyBindState(n, false);
        }
    }

    @Override
    public void z$1m9j3ewef9s() {
        int n;
        block31: {
            block30: {
                oc668fce0dbf oc668fce0dbf2;
                boolean bl;
                block29: {
                    block28: {
                        boolean bl2;
                        block27: {
                            boolean bl3;
                            boolean bl4;
                            block25: {
                                block24: {
                                    block26: {
                                        block23: {
                                            boolean bl5;
                                            block21: {
                                                block22: {
                                                    bl = false;
                                                    bl5 = oc7ab2161b9f.\u00d0();
                                                    if (bl) break block21;
                                                    if (bl5) break block22;
                                                    return;
                                                }
                                                bl5 = oc69da1aa7f5.\u0151.inGameHasFocus;
                                            }
                                            bl4 = bl5;
                                            bl3 = this.\u03eb.\u01ed();
                                            if (bl) break block23;
                                            if (!bl3) break block24;
                                            bl3 = oc69da1aa7f5.\u0151.currentScreen instanceof GuiInventory;
                                        }
                                        if (bl) break block25;
                                        if (bl3) break block26;
                                        bl3 = oc69da1aa7f5.\u0151.currentScreen instanceof GuiChest;
                                        if (bl) break block25;
                                        if (!bl3) break block24;
                                    }
                                    bl3 = true;
                                    break block25;
                                }
                                bl3 = false;
                            }
                            boolean bl6 = bl3;
                            bl2 = bl4;
                            if (bl) break block27;
                            if (bl2) break block28;
                            bl2 = bl6;
                        }
                        if (!bl2) {
                            return;
                        }
                    }
                    oc668fce0dbf2 = oc9755810e45.\u01dc;
                    if (bl) break block29;
                    if (oc668fce0dbf2 == null) break block30;
                    oc668fce0dbf2 = oc9755810e45.\u01dc;
                }
                n = oc668fce0dbf2.\u0551();
                if (bl) break block31;
                if (n != 0) break block30;
                KeyBinding.setKeyBindState(oc69da1aa7f5.\u0151.gameSettings.keyBindSprint.getKeyCode(), false);
                oc69da1aa7f5.\u0151.thePlayer.resetSprintToggleTimer();
                oc69da1aa7f5.\u0151.thePlayer.setSprinting(false);
                return;
            }
            n = oc69da1aa7f5.\u0151.gameSettings.keyBindSprint.getKeyCode();
        }
        KeyBinding.setKeyBindState(n, true);
    }

    public boolean \u010c() {
        boolean bl;
        block8: {
            block7: {
                ocd2c4efd8d9 ocd2c4efd8d92;
                boolean bl2;
                block6: {
                    bl2 = false;
                    ocd2c4efd8d92 = this;
                    if (bl2) break block6;
                    if (!ocd2c4efd8d92.z$3rzb3dil7uydr()) break block7;
                    ocd2c4efd8d92 = this;
                }
                bl = ocd2c4efd8d92.\u0562.\u01ed();
                if (bl2) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u011d() {
        boolean bl;
        block8: {
            block7: {
                ocd2c4efd8d9 ocd2c4efd8d92;
                boolean bl2;
                block6: {
                    bl2 = false;
                    ocd2c4efd8d92 = this;
                    if (bl2) break block6;
                    if (!ocd2c4efd8d92.z$3rzb3dil7uydr()) break block7;
                    ocd2c4efd8d92 = this;
                }
                bl = ocd2c4efd8d92.\u0217.\u01ed();
                if (bl2) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0295() {
        boolean bl;
        block8: {
            block7: {
                ocd2c4efd8d9 ocd2c4efd8d92;
                boolean bl2;
                block6: {
                    bl2 = false;
                    ocd2c4efd8d92 = this;
                    if (bl2) break block6;
                    if (!ocd2c4efd8d92.z$3rzb3dil7uydr()) break block7;
                    ocd2c4efd8d92 = this;
                }
                bl = ocd2c4efd8d92.\u02a9.\u01ed();
                if (bl2) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }
}

