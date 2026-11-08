/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import x.oc110d7f376c;
import x.oc1378bc114d;
import x.oc1b46ea259e;
import x.oc2cf3d80e17;
import x.oc3ebac73392;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.ocd2958dac48;
import x.ocd9533bdf8b;
import x.oce4cea752dd;
import x.oce6044968f8;
import x.ocf923d5a814;

public class oced2c93b93e
extends oc69da1aa7f5 {
    private static final String \u0201 = "Miau";
    private final occ2f8dff8d8 \u0476 = new occ2f8dff8d8("Glow shadow", true);
    private final oca9cc61aada \u04f6 = new oca9cc61aada("Scale", 2.0, 0.5, 3.0, 0.1);
    private double \u0470 = 0.02;
    private double e = 0.02;
    private boolean \u042c;
    private double \u04b3;
    private double \u0271;
    private double \u0461;
    private double \u017e;
    public static int \u02a5;

    public oced2c93b93e() {
        super("Watermark", oce4cea752dd.\u014e);
        this.\u0105("Meowww !?!?!??!");
        this.\u028c(this.\u0476);
        this.\u028c(this.\u04f6);
    }

    public double \u01cc() {
        return this.\u0470;
    }

    public double \u029a() {
        return this.e;
    }

    public void \u025e(double d, double d2) {
        double d3;
        block7: {
            block8: {
                boolean bl = oce6044968f8.\u0452;
                d3 = d;
                if (bl) break block7;
                if (!Double.isFinite(d3)) break block8;
                this.\u0470 = Math.max(0.0, Math.min(1.0, d));
            }
            d3 = d2;
        }
        if (Double.isFinite(d3)) {
            this.e = Math.max(0.0, Math.min(1.0, d2));
        }
    }

    @Override
    public void onDisable() {
        this.\u042c = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0214(ocf923d5a814 ocf923d5a8142) {
        block15: {
            block12: {
                Minecraft minecraft;
                block14: {
                    boolean bl;
                    block13: {
                        boolean bl2;
                        block11: {
                            bl = oce6044968f8.\u0452;
                            if (ocf923d5a8142.\u04b0 != oc110d7f376c.END) {
                                return;
                            }
                            bl2 = oc7ab2161b9f.\u00d0();
                            if (bl) break block11;
                            if (!bl2) break block12;
                            minecraft = oc69da1aa7f5.\u0151;
                            if (bl) break block13;
                            bl2 = minecraft.gameSettings.showDebugInfo;
                        }
                        if (bl2) break block12;
                        minecraft = oc69da1aa7f5.\u0151;
                    }
                    if (bl) break block14;
                    if (minecraft.currentScreen == null) break block15;
                    minecraft = oc69da1aa7f5.\u0151;
                }
                if (minecraft.currentScreen instanceof GuiChat) break block15;
            }
            this.\u042c = false;
            return;
        }
        this.\u0142();
    }

    private void \u0142() {
        block10: {
            ocd9533bdf8b ocd9533bdf8b2;
            float f;
            float f2;
            oc1378bc114d oc1378bc114d2;
            block11: {
                boolean bl;
                block9: {
                    int n2;
                    float f5;
                    float f6;
                    block8: {
                        ScaledResolution scaledResolution = new ScaledResolution(oc69da1aa7f5.\u0151);
                        int n3 = Math.max(1, scaledResolution.getScaledWidth());
                        int n4 = Math.max(1, scaledResolution.getScaledHeight());
                        oc1378bc114d2 = oc3ebac73392.\u022f("MetalGothic", (float)this.\u04f6.\u04c1());
                        bl = oce6044968f8.\u0452;
                        f6 = oc1378bc114d2.z$toz8pt08w0nc("Miau");
                        f5 = oc1378bc114d2.z$1tqmx4tpnr6lq();
                        this.\u00d6(scaledResolution, f6, f5);
                        f2 = (float)(this.\u0470 * (double)n3);
                        f = (float)(this.e * (double)n4);
                        n2 = oc69da1aa7f5.\u0151.currentScreen instanceof GuiChat;
                        if (bl) break block8;
                        if (n2 == false) break block9;
                        n2 = (int)f2;
                    }
                    Gui.drawRect(n2, (int)f, (int)(f2 + f6), (int)(f + f5), 0xFE89EB65 ^ 0xBE76149A);
                }
                ocd9533bdf8b2 = (c, f3, f4, n) -> ocd2958dac48.\u02b0(f2 + f3, f + f3);
                if (bl) break block10;
                if (!this.\u0476.\u01ed()) break block11;
                oc1b46ea259e.\u0406(() -> oc1378bc114d2.z$22eyp2803ejhs("Miau", f2, f, ocd9533bdf8b2, false), 0xBE761498 ^ 0xBE76149A, 2.0f);
            }
            oc1378bc114d2.z$22eyp2803ejhs("Miau", f2, f, ocd9533bdf8b2, true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u00d6(ScaledResolution scaledResolution, float f, float f2) {
        block36: {
            double d;
            double d2;
            block35: {
                oced2c93b93e oced2c93b93e2;
                double d3;
                double d4;
                int n;
                int n2;
                boolean bl;
                block31: {
                    block32: {
                        double d5;
                        double d6;
                        block34: {
                            double d7;
                            block33: {
                                int n3;
                                block29: {
                                    block30: {
                                        block28: {
                                            boolean bl2;
                                            block27: {
                                                bl = oce6044968f8.\u0452;
                                                bl2 = oc69da1aa7f5.\u0151.currentScreen instanceof GuiChat;
                                                if (bl) break block27;
                                                if (!bl2) break block28;
                                                n3 = 0;
                                                if (bl) break block29;
                                                bl2 = Mouse.isButtonDown(n3);
                                            }
                                            if (bl2) break block30;
                                        }
                                        this.\u042c = false;
                                        return;
                                    }
                                    n3 = Math.max(1, scaledResolution.getScaledWidth());
                                }
                                n2 = n3;
                                n = Math.max(1, scaledResolution.getScaledHeight());
                                d4 = (double)(Mouse.getX() * n2) / (double)oc69da1aa7f5.\u0151.displayWidth;
                                d3 = (double)n - (double)(Mouse.getY() * n) / (double)oc69da1aa7f5.\u0151.displayHeight - 1.0;
                                double d8 = this.\u0470 * (double)n2;
                                d6 = this.e * (double)n;
                                oced2c93b93e2 = this;
                                if (bl) break block31;
                                if (oced2c93b93e2.\u042c) break block32;
                                d5 = d4;
                                if (!bl) {
                                    if (d5 < d8) return;
                                    d5 = d4;
                                }
                                d7 = d8;
                                if (bl) break block33;
                                if (d5 > d7 + (double)f) return;
                                d5 = d3;
                                if (bl) break block34;
                                d7 = d6;
                            }
                            if (d5 < d7) return;
                            d5 = d3;
                        }
                        if (d5 > d6 + (double)f2) {
                            return;
                        }
                        this.\u042c = true;
                        this.\u04b3 = this.\u0470;
                        this.\u0271 = this.e;
                        this.\u0461 = d4;
                        this.\u017e = d3;
                    }
                    oced2c93b93e2 = this;
                }
                double d9 = oced2c93b93e2.\u0470;
                double d10 = this.e;
                this.\u025e(this.\u04b3 + (d4 - this.\u0461) / (double)n2, this.\u0271 + (d3 - this.\u017e) / (double)n);
                d2 = d9;
                d = this.\u0470;
                if (bl) break block35;
                if (Double.compare(d2, d) != 0) break block36;
                d2 = d10;
                d = this.e;
            }
            if (Double.compare(d2, d) == 0) return;
        }
        oc2cf3d80e17.\u04eb();
    }
}

