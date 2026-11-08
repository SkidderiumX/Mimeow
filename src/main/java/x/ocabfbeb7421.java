/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.oca9cc61aada;
import x.oce4cea752dd;

public class ocabfbeb7421
extends oc69da1aa7f5 {
    private oca9cc61aada \u0399;
    public static boolean \u038f;

    public ocabfbeb7421() {
        super("Timer", oce4cea752dd.\u0495);
        this.\u0105("Changes the speed at which your game runs.");
        this.\u0399 = new oca9cc61aada("Speed", 1.0, 0.0, 2.0, 0.1);
        this.\u028c(this.\u0399);
    }

    @Override
    public String getInfo() {
        return oc7ab2161b9f.\u0251(this.\u0399.\u04c1());
    }

    public float \u01d9() {
        return (float)this.\u0399.\u04c1();
    }

    @Override
    public void onEnable() {
        block6: {
            int n;
            block5: {
                boolean bl = false;
                n = oc7ab2161b9f.\u00d0();
                if (bl) break block5;
                if (n == 0) break block6;
                double d = this.\u0399.\u04c1() - 0.0;
                n = d == 0.0 ? 0 : (d < 0.0 ? -1 : 1);
            }
            if (n <= 0) {
                oc7ab2161b9f.\u0481();
            }
        }
    }

    @Override
    public void onDisable() {
        oc7ab2161b9f.\u0481();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$1m9j3ewef9s() {
        block9: {
            boolean bl;
            block8: {
                bl = false;
                if (!oc7ab2161b9f.\u00d0()) {
                    return;
                }
                float f = (float)this.\u0399.\u04c1();
                if (bl) break block8;
                if (!(f > 0.0f)) break block9;
                oc69da1aa7f5.\u0151.getTimer().timerSpeed = f;
            }
            if (!bl) return;
        }
        oc7ab2161b9f.\u0481();
    }

    public static int \u0259() {
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u02b0() {
        boolean bl;
        boolean bl2;
        block15: {
            ocabfbeb7421 ocabfbeb74212;
            block16: {
                block13: {
                    block14: {
                        ocabfbeb7421 ocabfbeb74213;
                        block12: {
                            ocabfbeb74212 = oc9755810e45.\u016f;
                            bl2 = false;
                            ocabfbeb74213 = ocabfbeb74212;
                            if (bl2) break block12;
                            if (ocabfbeb74213 == null) return false;
                            ocabfbeb74213 = ocabfbeb74212;
                        }
                        bl = ocabfbeb74213.z$3rzb3dil7uydr();
                        if (bl2) break block13;
                        if (bl) break block14;
                        return false;
                    }
                    bl = oc7ab2161b9f.\u00d0();
                }
                if (bl2) break block15;
                if (bl) break block16;
                return false;
            }
            double d = ocabfbeb74212.\u0399.\u04c1() - 0.0;
            bl = d == 0.0 ? 0 : (d < 0.0 ? -1 : 1);
        }
        if (bl2) return bl;
        if (bl > false) return false;
        return true;
    }
}

