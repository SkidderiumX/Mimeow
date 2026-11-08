/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.ocaae9de8508;

public class oc9a8b5c2e88
extends oc161f4adba4 {
    public static int \u01a9;

    public oc9a8b5c2e88() {
        String[] stringArray = new String[0xAD8BBD45 ^ 0xAD8BBD47];
        stringArray[0] = "show";
        stringArray[1] = "show all";
        super("show", "Show every module in the HUD list.", oc17aaf5d285.\u0127, stringArray, "showall");
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        block19: {
            int n;
            int n2;
            block17: {
                block18: {
                    n2 = oc24b4725b15.\u0395;
                    n = ocaae9de85082.\u04fe();
                    if (n2 != 0) break block17;
                    if (n <= 0) break block18;
                    n = "all".equalsIgnoreCase(ocaae9de85082.\u044c(0)) ? 1 : 0;
                    if (n2 != 0) break block17;
                    if (n != 0) break block18;
                    this.\u01fb();
                    return;
                }
                n = 0;
            }
            int n3 = n;
            for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
                block21: {
                    block20: {
                        if (n2 != 0) break block19;
                        if (n2 != 0) break block20;
                        if (!oc69da1aa7f52.\u056c()) break block21;
                        oc69da1aa7f52.\u01e4(false);
                    }
                    ++n3;
                }
                if (n2 == 0) continue;
            }
            oc9a8b5c2e88 oc9a8b5c2e882 = this;
            int n4 = n3;
            String string = n3 == 1 ? "" : "s";
            oc9a8b5c2e882.\u0247("&7Made &a" + n4 + " &7module" + string + " visible in HUD.");
        }
    }
}

