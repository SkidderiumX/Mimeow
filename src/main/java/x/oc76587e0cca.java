/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc76587e0cca
extends oc69da1aa7f5 {
    public static boolean \u0432;

    public oc76587e0cca() {
        super("NoBreakParticles", oce4cea752dd.\u014e);
        this.\u0105("Removes particles produced by breaking blocks.");
    }

    public static boolean \u0107() {
        boolean bl;
        block6: {
            block5: {
                oc76587e0cca oc76587e0cca2;
                boolean bl2;
                block4: {
                    bl2 = oce6044968f8.\u0452;
                    oc76587e0cca2 = oc9755810e45.\u0141;
                    if (bl2) break block4;
                    if (oc76587e0cca2 == null) break block5;
                    oc76587e0cca2 = oc9755810e45.\u0141;
                }
                bl = oc76587e0cca2.z$3rzb3dil7uydr();
                if (bl2) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }
}

