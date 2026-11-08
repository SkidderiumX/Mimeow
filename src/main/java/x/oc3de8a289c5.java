/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.oce4cea752dd;

public class oc3de8a289c5
extends oc69da1aa7f5 {
    private static volatile boolean o;
    public static int \u0194;

    public oc3de8a289c5() {
        super("MovementFix", oce4cea752dd.\u0495);
        this.\u0105("Keeps movement aligned with modified rotations.");
    }

    public static boolean \u04d4() {
        boolean bl;
        block8: {
            block11: {
                block9: {
                    oc3de8a289c5 oc3de8a289c52;
                    boolean bl2;
                    block10: {
                        bl2 = false;
                        bl = o;
                        if (bl2) break block8;
                        if (bl) break block9;
                        oc3de8a289c52 = oc9755810e45.\u0105;
                        if (bl2) break block10;
                        if (oc3de8a289c52 == null) break block11;
                        oc3de8a289c52 = oc9755810e45.\u0105;
                    }
                    bl = oc3de8a289c52.z$3rzb3dil7uydr();
                    if (bl2) break block8;
                    if (!bl) break block11;
                }
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static void \u0298(boolean bl) {
        o = bl;
    }

    public static boolean o(boolean bl) {
        boolean bl2;
        block6: {
            block5: {
                boolean bl3;
                block4: {
                    bl3 = false;
                    bl2 = oc3de8a289c5.\u04d4();
                    if (bl3) break block4;
                    if (!bl2) break block5;
                    bl2 = bl;
                }
                if (bl3) break block6;
                if (!bl2) break block5;
                bl2 = true;
                break block6;
            }
            bl2 = false;
        }
        return bl2;
    }
}

