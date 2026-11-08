/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.W;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.occ2f8dff8d8;

public class oc30c8fb3a16
extends oc5e2e2031b5 {
    private static final float \u04f0 = 16.0f;
    private static final float \u040a = 8.0f;
    private static final float \u04c8 = 6.0f;
    private final occ2f8dff8d8 \u03b4;

    oc30c8fb3a16(occ2f8dff8d8 occ2f8dff8d82, oc69da1aa7f5 oc69da1aa7f52) {
        super(occ2f8dff8d82, oc69da1aa7f52);
        this.\u03b4 = occ2f8dff8d82;
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        oc255ab955c3.\u04df(this.\u0152 - 3.0f, this.\u0417, this.\u016d, n, n2);
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(this.\u03b4.z$18nrktuqeiysv(), oc1378bc114d2, (int)this.\u016d - (0x45F8E1FC ^ 0x45F8E1E0)), this.\u0152 + 2.0f, oc255ab955c3.\u0544((int)this.\u0417, 0x45F8E1EF ^ 0x45F8E1E0, oc1378bc114d2), -1, false);
        if (this.\u03b4.\u04fd) {
            oc1378bc114d2.z$ao2ykh4tuw6w(">", this.\u0152 + this.\u016d - 10.0f, this.\u0417 + 3.0f, -1, false);
            return;
        }
        float f = this.\u0152 + this.\u016d - 16.0f - 4.0f;
        float f2 = this.\u0417 + 3.5f;
        if (this.\u03b4.\u01ed()) {
            int n3 = oc255ab955c3.\u01ea((double)f + 8.0, (double)f2 + 4.0);
            W.\u02e0(f, f2, 16.0f, 8.0f, 4.0f, oc255ab955c3.\u0515(n3, 0x45F8E128 ^ 0x45F8E1E0));
            W.\u02e0(f + 16.0f - 6.0f - 1.0f, f2 + 1.0f, 6.0f, 6.0f, 3.0f, -1);
        } else {
            W.\u02e0(f, f2, 16.0f, 8.0f, 4.0f, 0xBACBD2D3 ^ 0x45F8E1E0);
            W.\u02e0(f + 1.0f, f2 + 1.0f, 6.0f, 6.0f, 3.0f, 0xBA667F7E ^ 0x45F8E1E0);
        }
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (!this.\u01f7(n, n2) || n3 != 0) {
            return false;
        }
        if (this.\u03b4.\u04fd) {
            this.\u03b4.\u0568();
        } else {
            this.\u03b4.\u045d();
        }
        this.\u0273.guiButtonToggled(this.\u03b4);
        this.\u0416();
        return true;
    }
}

