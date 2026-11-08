/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1131978c8d;
import x.ocbb1bc27172;

public class oc5395d7bb80 {
    public static final oc5395d7bb80 Z = new oc5395d7bb80(oc1131978c8d.C, "Disconnected", "", 0L);
    private final oc1131978c8d \u041a;
    private final String \u04d4;
    private final String \u0408;
    private final long \u0127;
    public static boolean \u0122;

    public oc5395d7bb80(oc1131978c8d oc1131978c8d2, String string, String string2, long l) {
        this.\u041a = oc1131978c8d2 == null ? oc1131978c8d.C : oc1131978c8d2;
        this.\u04d4 = string == null ? "" : string;
        this.\u0408 = string2 == null ? "" : string2;
        this.\u0127 = Math.max(0L, l);
    }

    public oc1131978c8d \u0135() {
        return this.\u041a;
    }

    public String \u04bd() {
        return this.\u04d4;
    }

    public String \u03e2() {
        return this.\u0408;
    }

    public long \u04ca() {
        return this.\u0127;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean \u048a() {
        oc1131978c8d oc1131978c8d2;
        block11: {
            oc5395d7bb80 oc5395d7bb802;
            int n;
            block10: {
                n = ocbb1bc27172.\u050d;
                oc5395d7bb802 = this;
                if (n != 0) break block10;
                if (oc5395d7bb802.\u041a == oc1131978c8d.\u028f) return true;
                oc5395d7bb802 = this;
            }
            oc1131978c8d2 = oc5395d7bb802.\u041a;
            if (n != 0) break block11;
            if (oc1131978c8d2 == oc1131978c8d.\u0423) return true;
            oc1131978c8d2 = this.\u041a;
        }
        if (oc1131978c8d2 != oc1131978c8d.\u0490) return false;
        return true;
    }
}

