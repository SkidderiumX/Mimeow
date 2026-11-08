/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1079614cc6;
import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.ocaba452434e;
import x.occ99cc6cd9f;
import x.occc831eff22;

public class ocb24b6f6ca5
extends oc4f21845252 {
    private final occc831eff22 \u04f4;
    private final oc1079614cc6 \u01fd;
    private final occ99cc6cd9f \u04e5 = new occ99cc6cd9f(0x40BB08EE903ED4AFL ^ 0x40BB08EE903ED4D2L, ocaba452434e.\u03df);

    ocb24b6f6ca5(occc831eff22 occc831eff222, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632, oc1079614cc6 oc1079614cc62) {
        super(occc831eff222, oc69da1aa7f52, oc1cb76bf7632);
        this.\u04f4 = occc831eff222;
        this.\u01fd = oc1079614cc62;
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        float f = this.\u04e5.\u0540(this.\u04f4.\u01ab() ? 1.0f : 0.0f);
        return 22.0f + (f > 0.0f ? this.\u01fd.\u0116(oc8aaacef5d62, this.\u03c8) * f : 0.0f);
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        float f3 = this.\u04e5.\u047f();
        float f4 = 3.0f * (1.0f - f3);
        oc8aaacef5d62.\u027e(this.\u01e7 + f4, this.\u0575 + f4, this.\u03c8 - f4 * 2.0f, 22.0f - f4 * 2.0f, 4.0f * (1.0f - f3), 0xA44091C7 ^ 0x974091C7);
        String string = oc8aaacef5d62.\u0398("productsans-bold", this.\u04b3.z$18nrktuqeiysv(), 7.0f, this.\u03c8 - 28.0f);
        oc8aaacef5d62.\u0456("productsans-bold", string, this.\u01e7 + (this.\u03c8 - oc8aaacef5d62.\u01f1("productsans-bold", string, 7.0f)) / 2.0f, this.\u0575 + 13.5f, 7.0f, -1);
        oc8aaacef5d62.\u025e(this.\u01e7 + this.\u03c8 - 13.0f, this.\u0575 + 11.0f, 12.0f, f3, -1);
        if (f3 > 0.0f) {
            oc8aaacef5d62.\u023a(this.\u01e7, this.\u0575 + 22.0f, this.\u03c8, this.\u041a - 22.0f, () -> this.\u01fd.\u011d(oc8aaacef5d62, this.\u01e7, this.\u0575 + 22.0f, this.\u03c8, f, f2, this.\u039b));
        }
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (f2 < this.\u0575 + 22.0f) {
            this.\u04f4.\u04f6(!this.\u04f4.\u01ab());
            this.\u04e5.\u0540(this.\u04f4.\u01ab() ? 1.0f : 0.0f);
            this.\u01fd.\u02a2();
            this.s.z$2u87utkr1isxg();
            return true;
        }
        return this.\u04f4.\u01ab() && this.\u01fd.\u0446(f, f2, n);
    }

    @Override
    void z$jjpp51h3b2lm() {
        this.\u01fd.s();
    }

    @Override
    void z$21n2hyuutt37u() {
        super.z$21n2hyuutt37u();
        this.\u01fd.\u02a2();
    }
}

