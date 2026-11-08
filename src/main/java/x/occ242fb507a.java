/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.ocaba452434e;
import x.occ2f8dff8d8;
import x.occ99cc6cd9f;

public class occ242fb507a
extends oc4f21845252 {
    private final occ2f8dff8d8 \u050e;
    private final occ99cc6cd9f \u03fc = new occ99cc6cd9f(0x1A5F41EE0A023C3DL ^ 0x1A5F41EE0A023CABL, ocaba452434e.\u03df);

    occ242fb507a(occ2f8dff8d8 occ2f8dff8d82, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        super(occ2f8dff8d82, oc69da1aa7f52, oc1cb76bf7632);
        this.\u050e = occ2f8dff8d82;
        this.\u03fc.\u020e(this.\u050e.\u01ed() ? 1.0f : 0.0f);
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", this.\u04b3.z$18nrktuqeiysv(), 7.0f, this.\u050e.\u04fd ? this.\u03c8 - 10.0f : this.\u03c8 - 29.0f), this.\u01e7 + 5.0f, this.\u0575 + 10.5f, 7.0f, -1);
        if (this.\u050e.\u04fd) {
            return;
        }
        float f3 = this.\u03fc.\u0540(this.\u050e.\u01ed() ? 1.0f : 0.0f);
        int n = occ242fb507a.\u0576(0xADE087C3 ^ 0x52DCBBFF, oc8aaacef5d6.\u012d(), f3);
        oc8aaacef5d62.\u0419(this.\u01e7 + this.\u03c8 - 20.5f, this.\u0575 + 4.55f, 17.0f, 8.5f, 4.25f, 4.25f, n, oc8aaacef5d6.z(n, 0.4f), true);
        oc8aaacef5d62.\u0419(this.\u01e7 + this.\u03c8 - 19.65f + f3 * 8.075f, this.\u0575 + 5.4f, 6.8f, 6.8f, 3.4f, 3.4f, -1, 0xAD395E1A ^ 0x52DCBBFF, true);
    }

    private static int \u0576(int n, int n2, float f) {
        int n3 = (int)((float)(n >> (0xBC4B7FAC ^ 0xBC4B7FBC) & (0xBC4B7F43 ^ 0xBC4B7FBC)) + (float)((n2 >> (0xBC4B7FAC ^ 0xBC4B7FBC) & (0xBC4B7F43 ^ 0xBC4B7FBC)) - (n >> (0xBC4B7FAC ^ 0xBC4B7FBC) & (0xBC4B7F43 ^ 0xBC4B7FBC))) * f);
        int n4 = (int)((float)(n >> (0xBC4B7FB4 ^ 0xBC4B7FBC) & (0xBC4B7F43 ^ 0xBC4B7FBC)) + (float)((n2 >> (0xBC4B7FB4 ^ 0xBC4B7FBC) & (0xBC4B7F43 ^ 0xBC4B7FBC)) - (n >> (0xBC4B7FB4 ^ 0xBC4B7FBC) & (0xBC4B7F43 ^ 0xBC4B7FBC))) * f);
        int n5 = (int)((float)(n & (0xBC4B7F43 ^ 0xBC4B7FBC)) + (float)((n2 & (0xBC4B7F43 ^ 0xBC4B7FBC)) - (n & (0xBC4B7F43 ^ 0xBC4B7FBC))) * f);
        return 0x434B7FBC ^ 0xBC4B7FBC | n3 << (0xBC4B7FAC ^ 0xBC4B7FBC) | n4 << (0xBC4B7FB4 ^ 0xBC4B7FBC) | n5;
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        if (this.\u050e.\u04fd) {
            this.\u050e.\u0568();
            return true;
        }
        this.\u050e.\u045d();
        this.s.guiButtonToggled(this.\u050e);
        this.z$3e974bso21r1k();
        return true;
    }
}

