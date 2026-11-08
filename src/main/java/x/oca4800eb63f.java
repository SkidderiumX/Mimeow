/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.network.play.server.S2EPacketCloseWindow;
import net.minecraft.util.ResourceLocation;
import x.oc110d7f376c;
import x.oc24a0a5bddf;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc6af36febc3;
import x.oc89eb238246;
import x.oc8ce2882092;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.ocdf771dc334;
import x.oce0b21f0f13;
import x.oce4cea752dd;
import x.oce4fccf5a38;
import x.oce79181588d;
import x.ocf923d5a814;

public class oca4800eb63f
extends oc69da1aa7f5 {
    private static final String \u03b5 = "/assets/idle.miau/textures/gui/tv_off.png";
    private static final int \u0271 = 16;
    private static final float \u0402 = 0.5f;
    private static final float \u0539 = 0.05f;
    private static final int \u01f7 = -1;
    private final oc24a0a5bddf \u016b;
    private final oca9cc61aada \u027e;
    private final occ2f8dff8d8 \u0208;
    private final occ2f8dff8d8 \u02a4;
    private final oc6af36febc3 \u017d;
    private GuiContainer \u0207;
    private float \u0197 = Float.NaN;
    private float \u0561 = Float.NaN;
    private float \u0180 = Float.NaN;
    private float \u04b4 = Float.NaN;
    public static boolean \u0213;

    public oca4800eb63f() {
        super("HideWindow", oce4cea752dd.\u04a6);
        this.\u0105("Hides container menus while keeping the container open.");
        this.\u016b = new oc24a0a5bddf("Icon color", 0x758997D1 ^ 0x7589972E, 0x758997D1 ^ 0x7589972E, 0x758997D1 ^ 0x7589972E);
        this.\u028c(this.\u016b);
        this.\u027e = new oca9cc61aada("Icon scale", 1.0, 0.5, 3.0, 0.1);
        this.\u028c(this.\u027e);
        this.\u028c(new occ2f8dff8d8("Edit position", () -> oc69da1aa7f5.\u0151.displayGuiScreen(new oce0b21f0f13(this))));
        this.\u0208 = new occ2f8dff8d8("Only while crouching", false);
        this.\u028c(this.\u0208);
        this.\u02a4 = new occ2f8dff8d8("Whitelist", false);
        this.\u028c(this.\u02a4);
        this.\u017d = new oc6af36febc3("Whitelist names", "e.g. Upgrades & Traps", 0x758997AE ^ 0x7589972E);
        this.\u028c(this.\u017d);
        this.\u017d.\u04c0 = false;
    }

    @Override
    public String getInfo() {
        String string = this.\u0207 == null ? "" : "Hidden";
        return string;
    }

    @Override
    public void z$2u87utkr1isxg() {
        this.\u017d.\u0209(this.\u02a4.\u01ed(), this);
    }

    @Override
    public void onDisable() {
        block8: {
            oca4800eb63f oca4800eb63f2;
            block9: {
                Minecraft minecraft;
                block10: {
                    int n = oc89eb238246.\u0127;
                    oca4800eb63f2 = this;
                    if (n != 0) break block8;
                    if (oca4800eb63f2.\u0207 == null) break block9;
                    minecraft = oc69da1aa7f5.\u0151;
                    if (n != 0) break block10;
                    if (minecraft.thePlayer == null) break block9;
                    minecraft = oc69da1aa7f5.\u0151;
                }
                minecraft.thePlayer.closeScreen();
            }
            oca4800eb63f2 = this;
        }
        oca4800eb63f2.\u0207 = null;
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u03e1(ocdf771dc334 ocdf771dc3342) {
        block46: {
            block47: {
                GuiScreen guiScreen;
                int n;
                block37: {
                    block38: {
                        GuiContainer guiContainer;
                        block44: {
                            oca4800eb63f oca4800eb63f2;
                            block45: {
                                boolean bl;
                                block43: {
                                    block41: {
                                        block42: {
                                            GuiScreen guiScreen2;
                                            block39: {
                                                block40: {
                                                    block36: {
                                                        n = oc89eb238246.\u0127;
                                                        if (ocdf771dc3342.\u0190 != null && oc69da1aa7f5.\u0151.thePlayer != null) break block36;
                                                        return;
                                                    }
                                                    guiScreen = ocdf771dc3342.\u0190;
                                                    if (n != 0) break block37;
                                                    if (!(guiScreen instanceof GuiContainer)) break block38;
                                                    guiScreen = ocdf771dc3342.\u0190;
                                                    if (n != 0) break block37;
                                                    if (guiScreen instanceof GuiInventory) break block38;
                                                    guiScreen2 = oc69da1aa7f5.\u0151.currentScreen;
                                                    if (n != 0) break block39;
                                                    if (!(guiScreen2 instanceof GuiContainer)) break block40;
                                                    this.\u0207 = null;
                                                    return;
                                                }
                                                guiScreen2 = ocdf771dc3342.\u0190;
                                            }
                                            guiContainer = (GuiContainer)guiScreen2;
                                            oca4800eb63f2 = this;
                                            if (n != 0) break block41;
                                            if (!oca4800eb63f2.\u0208.\u01ed()) break block42;
                                            bl = oc69da1aa7f5.\u0151.thePlayer.isSneaking();
                                            if (n != 0) break block43;
                                            if (bl) break block42;
                                            return;
                                        }
                                        oca4800eb63f2 = this;
                                    }
                                    if (n != 0) break block44;
                                    bl = oca4800eb63f2.\u02a4.\u01ed();
                                }
                                if (!bl) break block45;
                                oca4800eb63f2 = this;
                                if (n != 0) break block44;
                                if (oca4800eb63f2.\u03a3(guiContainer)) break block45;
                                return;
                            }
                            oca4800eb63f2 = this;
                        }
                        oca4800eb63f2.\u0207 = guiContainer;
                        oc69da1aa7f5.\u0151.thePlayer.openContainer = this.\u0207.inventorySlots;
                        ocdf771dc3342.setCanceled(true);
                        return;
                    }
                    guiScreen = ocdf771dc3342.\u0190;
                }
                if (!(guiScreen instanceof GuiInventory)) break block46;
                oca4800eb63f oca4800eb63f3 = this;
                if (n != 0) break block47;
                if (oca4800eb63f3.\u0207 == null) break block46;
                ocdf771dc3342.\u0190 = this.\u0207;
                oca4800eb63f3 = this;
            }
            oca4800eb63f3.\u0207 = null;
        }
    }

    @oc66fa4f2195
    public void \u0240(oce79181588d oce79181588d2) {
        if (oce79181588d2.\u04a0() instanceof S2EPacketCloseWindow) {
            this.\u0207 = null;
        }
    }

    @oc66fa4f2195
    public void \u03eb(oce4fccf5a38 oce4fccf5a382) {
        this.\u0207 = null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u020f(ocf923d5a814 ocf923d5a8142) {
        Minecraft minecraft;
        block13: {
            GuiScreen guiScreen;
            block12: {
                int n = oc89eb238246.\u0127;
                if (ocf923d5a8142.\u04b0 != oc110d7f376c.END) {
                    return;
                }
                guiScreen = this.\u0207;
                if (n != 0) break block12;
                if (guiScreen == null) return;
                minecraft = oc69da1aa7f5.\u0151;
                if (n != 0) break block13;
                guiScreen = minecraft.currentScreen;
            }
            if (guiScreen != null) return;
            minecraft = oc69da1aa7f5.\u0151;
        }
        if (minecraft.gameSettings.showDebugInfo) {
            return;
        }
        this.\u04bc(false);
    }

    public float \u0189() {
        this.\u044f();
        return this.\u0197;
    }

    public float \u01de() {
        this.\u044f();
        return this.\u0561;
    }

    public float \u0159() {
        this.\u044f();
        return this.\u0180;
    }

    public float \u03fa() {
        this.\u044f();
        return this.\u04b4;
    }

    public void \u04d1(float f, float f2) {
        this.\u0180 = f;
        this.\u04b4 = f2;
        this.\u044f();
    }

    public void \u04c1(float f, float f2) {
        this.\u050c(f, f2, new ScaledResolution(oc69da1aa7f5.\u0151));
    }

    public void \u0496() {
        this.\u04d1(0.5f, 0.05f);
    }

    private void \u04bc(boolean bl) {
        this.\u044f();
        ResourceLocation resourceLocation = ocbd4917c4b1.\u02b8("/assets/idle.miau/textures/gui/tv_off.png");
        if (resourceLocation == null) {
            return;
        }
        float f = (float)this.\u027e.\u04c1();
        int n = Math.round(16.0f * f);
        float f2 = this.\u0197 - (float)n / 2.0f;
        float f3 = this.\u0561 - (float)n / 2.0f;
        ocbd4917c4b1.\u00ec(resourceLocation, f2, f3, n, 0x25EAB308 ^ 0xDAEAB308 | this.\u016b.\u01d0());
        if (bl) {
            float f4 = f2 - 2.0f;
            float f5 = f3 - 2.0f;
            float f6 = f2 + (float)n + 2.0f;
            float f7 = f3 + (float)n + 2.0f;
            ocbd4917c4b1.\u0109(f4, f5, f6, f5 + 1.0f, -1);
            ocbd4917c4b1.\u0109(f4, f7 - 1.0f, f6, f7, -1);
            ocbd4917c4b1.\u0109(f4, f5, f4 + 1.0f, f7, -1);
            ocbd4917c4b1.\u0109(f6 - 1.0f, f5, f6, f7, -1);
        }
    }

    private void \u044f() {
        this.\u00d1(new ScaledResolution(oc69da1aa7f5.\u0151));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u00d1(ScaledResolution scaledResolution) {
        int n;
        block13: {
            oca4800eb63f oca4800eb63f2;
            int n2;
            block14: {
                block17: {
                    oca4800eb63f oca4800eb63f3;
                    block18: {
                        int n3;
                        block15: {
                            oca4800eb63f oca4800eb63f4;
                            block16: {
                                block11: {
                                    block12: {
                                        n2 = Math.max(1, scaledResolution.getScaledWidth());
                                        n3 = oc89eb238246.\u0127;
                                        n = Math.max(1, scaledResolution.getScaledHeight());
                                        oca4800eb63f4 = this;
                                        if (n3 != 0) break block11;
                                        if (Float.isNaN(oca4800eb63f4.\u0180)) break block12;
                                        oca4800eb63f2 = this;
                                        if (n3 != 0) break block13;
                                        if (!Float.isNaN(oca4800eb63f2.\u04b4)) break block14;
                                    }
                                    oca4800eb63f4 = this;
                                }
                                if (n3 != 0) break block15;
                                if (Float.isNaN(oca4800eb63f4.\u0197)) break block16;
                                oca4800eb63f3 = this;
                                if (n3 != 0) break block17;
                                if (!Float.isNaN(oca4800eb63f3.\u0561)) break block18;
                            }
                            this.\u0180 = 0.5f;
                            oca4800eb63f4 = this;
                        }
                        oca4800eb63f4.\u04b4 = 0.05f;
                        if (n3 == 0) break block14;
                    }
                    this.\u0180 = this.\u0197 / (float)n2;
                    oca4800eb63f3 = this;
                }
                oca4800eb63f3.\u04b4 = this.\u0561 / (float)n;
            }
            this.\u0197 = this.\u0180 * (float)n2;
            oca4800eb63f2 = this;
        }
        oca4800eb63f2.\u0561 = this.\u04b4 * (float)n;
    }

    private void \u050c(float f, float f2, ScaledResolution scaledResolution) {
        this.\u0197 = f;
        this.\u0561 = f2;
        int n = Math.max(1, scaledResolution.getScaledWidth());
        int n2 = Math.max(1, scaledResolution.getScaledHeight());
        this.\u0180 = f / (float)n;
        this.\u04b4 = f2 / (float)n2;
    }

    private boolean \u03a3(GuiContainer guiContainer) {
        boolean bl;
        block15: {
            String string;
            int n;
            List<String> list;
            block13: {
                String string2;
                block14: {
                    block12: {
                        boolean bl2;
                        block11: {
                            list = this.\u017d.\u010e();
                            n = oc89eb238246.\u0127;
                            bl2 = list.isEmpty();
                            if (n != 0) break block11;
                            if (!bl2) break block12;
                            bl2 = false;
                        }
                        return bl2;
                    }
                    string2 = oca4800eb63f.\u015f(guiContainer);
                    string = string2;
                    if (n != 0) break block13;
                    if (!string.isEmpty()) break block14;
                    return false;
                }
                string = string2.toLowerCase();
            }
            String string3 = string;
            for (String string4 : list) {
                block17: {
                    boolean bl3;
                    block16: {
                        bl = string3.contains(string4.toLowerCase());
                        if (n != 0) break block15;
                        if (n != 0) break block16;
                        if (!bl) break block17;
                        bl3 = true;
                    }
                    return bl3;
                }
                if (n == 0) continue;
            }
            bl = false;
        }
        return bl;
    }

    private static String \u015f(GuiContainer guiContainer) {
        GuiContainer guiContainer2;
        block4: {
            block5: {
                int n = oc89eb238246.\u0127;
                guiContainer2 = guiContainer;
                if (n != 0) break block4;
                if (guiContainer2.inventorySlots instanceof ContainerChest) break block5;
                return "";
            }
            guiContainer2 = guiContainer;
        }
        return ((ContainerChest)guiContainer2.inventorySlots).getLowerChestInventory().getDisplayName().getUnformattedText();
    }
}

