/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.W;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc5e2e2031b5;
import x.oc67f8865952;
import x.oc69da1aa7f5;
import x.ocb23d192a35;

public class oc93f6136fee
extends oc5e2e2031b5 {
    private final ocb23d192a35 \u0586;
    private boolean \u0259;

    oc93f6136fee(ocb23d192a35 ocb23d192a352, oc69da1aa7f5 oc69da1aa7f52) {
        super(ocb23d192a352, oc69da1aa7f52);
        this.\u0586 = ocb23d192a352;
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        oc255ab955c3.\u04df(this.\u0152 - 3.0f, this.\u0417, this.\u016d, n, n2);
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        String string = this.\u0259 ? "Press a key..." : oc67f8865952.\u017f(this.\u0586.\u01fa());
        int n3 = oc1378bc114d2.z$toz8pt08w0nc(string);
        int n4 = n3 + (0xFE49900B ^ 0xFE499003);
        int n5 = oc255ab955c3.\u01ea((double)this.\u0152 + (double)this.\u016d * 0.5, (double)this.\u0417 + 7.5);
        W.\u02e0(this.\u0152 + this.\u016d - (float)n4 - 3.0f, this.\u0417 + 3.0f, n4, 9.0f, 3.0f, oc255ab955c3.\u0515(0x150891A ^ 0xFE499003, 0xFE4990FC ^ 0xFE499003));
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(this.\u0586.z$18nrktuqeiysv(), oc1378bc114d2, (int)this.\u016d - n4 - (0xFE49900F ^ 0xFE499003)), this.\u0152 + 2.0f, oc255ab955c3.\u0544((int)this.\u0417, 0xFE49900C ^ 0xFE499003, oc1378bc114d2), -1, false);
        oc1378bc114d2.z$ao2ykh4tuw6w(string, this.\u0152 + this.\u016d - 3.0f - (float)n3, oc255ab955c3.\u0544((int)this.\u0417, 0xFE49900C ^ 0xFE499003, oc1378bc114d2), this.\u0259 ? -1 : n5, false);
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (!this.\u01f7(n, n2)) {
            return false;
        }
        if (this.\u0259 && n3 > 1) {
            this.\u0586.\u00c8(n3 + (0xF16BCA21 ^ 0xF16BC9C9));
            this.\u0259 = false;
            this.\u0416();
        } else if (n3 == 0) {
            this.\u0259 = !this.\u0259;
        }
        return true;
    }

    @Override
    boolean z$3twgyf5k61sst(char c, int n) {
        if (!this.\u0259) {
            return false;
        }
        this.\u0586.\u00c8(n == 1 || n == (0xB58254A9 ^ 0xB58254A2) ? 0 : n);
        this.\u0259 = false;
        this.\u0416();
        return true;
    }

    @Override
    boolean z$3kj7psbv4c9hb(int n, int n2, int n3) {
        if (!this.\u0259) {
            return false;
        }
        this.\u0586.\u00c8(n3 > 0 ? 0x53D2EAAA ^ 0x53D2EE87 : 0x53D2EAA9 ^ 0x53D2EE87);
        this.\u0259 = false;
        this.\u0416();
        return true;
    }

    @Override
    void z$3hwl7t34zws09() {
        this.\u0259 = false;
    }
}

