/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.oc74760d9133;
import x.occ2f8dff8d8;
import x.ocdf3e495c45;
import x.oce4cea752dd;

public class ocd3ffe14280
extends oc69da1aa7f5 {
    private final occ2f8dff8d8 \u01c6;
    public static int S;

    public ocd3ffe14280() {
        super("IRC", oce4cea752dd.\u04a6);
        this.\u0105("Connects you to the shared client chat.");
        this.\u01c6 = new occ2f8dff8d8("Hide my presence", false);
        this.\u028c(this.\u01c6);
    }

    public boolean \u00f3() {
        boolean bl;
        block13: {
            block11: {
                ocd3ffe14280 ocd3ffe142802;
                int n;
                block12: {
                    block10: {
                        n = oc74760d9133.\u019e;
                        ocd3ffe142802 = this;
                        if (n != 0) break block10;
                        if (!ocd3ffe142802.z$3rzb3dil7uydr()) break block11;
                        ocd3ffe142802 = this;
                    }
                    if (n != 0) break block12;
                    if (ocd3ffe142802.\u01c6 == null) break block11;
                    ocd3ffe142802 = this;
                }
                bl = ocd3ffe142802.\u01c6.\u01ed();
                if (n != 0) break block13;
                if (!bl) break block11;
                bl = true;
                break block13;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    public void onEnable() {
        ocdf3e495c45 ocdf3e495c452 = ocdf3e495c45.\u03dd();
        ocdf3e495c452.\u0576(true);
        ocdf3e495c452.\u01a1();
    }

    @Override
    public void onDisable() {
        ocdf3e495c45 ocdf3e495c452 = ocdf3e495c45.\u03dd();
        ocdf3e495c452.\u0576(false);
        ocdf3e495c452.\u0534();
    }
}

