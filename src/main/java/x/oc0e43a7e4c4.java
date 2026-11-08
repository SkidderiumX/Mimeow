/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc32b50dcd85;

public class oc0e43a7e4c4 {
    final oc32b50dcd85 \u01af;
    int \u01eb;
    int \u0253;

    oc0e43a7e4c4(oc32b50dcd85 oc32b50dcd852) {
        this.\u01af = oc32b50dcd852;
    }

    boolean \u0545() {
        if (this.\u0253 > 0) {
            --this.\u0253;
            return true;
        }
        if (this.\u01eb > 0) {
            --this.\u01eb;
            return true;
        }
        if (this.\u01af.\u0416 >= (0xDD273D17 ^ 0xDD262FE6)) {
            this.\u01af.\u0523.run();
            return false;
        }
        this.\u01af.\u0416 += 0xDD264BF6 ^ 0xDD262FE6;
        if (!this.\u01af.\u0514) {
            return false;
        }
        this.\u01eb = 0xDD262CF9 ^ 0xDD262FE6;
        return true;
    }

    void \u0167() {
        ++this.\u0253;
    }
}

