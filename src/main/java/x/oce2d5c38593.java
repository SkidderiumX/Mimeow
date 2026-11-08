/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.ocaba452434e;
import x.ocb29e26d1a9;
import x.occ99cc6cd9f;
import x.ocf1568fef75;

public class oce2d5c38593
extends oc4f21845252 {
    private final ocf1568fef75 p;
    private final occ99cc6cd9f \u026c = new occ99cc6cd9f(0x5D812F459FC455EDL ^ 0x5D812F459FC455DFL, ocaba452434e.\u01cd);
    private final occ99cc6cd9f \u0159 = new occ99cc6cd9f(0x5D812F459FC455EDL ^ 0x5D812F459FC455DFL, ocaba452434e.\u01cd);
    private int \u0110;
    private boolean \u029e;

    oce2d5c38593(ocf1568fef75 ocf1568fef752, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        super(ocf1568fef752, oc69da1aa7f52, oc1cb76bf7632);
        this.p = ocf1568fef752;
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        return 26.0f;
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        if (this.\u0110 != 0) {
            this.\u048b(f);
        }
        this.\u045f(oc8aaacef5d62);
        this.\u0548(oc8aaacef5d62, 8.5f);
        float f3 = this.\u0287(this.p.\u00f6());
        float f4 = this.\u0287(this.p.\u0456());
        if (!this.\u029e) {
            this.\u026c.\u020e(f3);
            this.\u0159.\u020e(f4);
            this.\u029e = true;
        }
        float f5 = this.\u026c.\u0540(f3);
        float f6 = this.\u0159.\u0540(f4);
        ocb29e26d1a9.\u01cd(oc8aaacef5d62, this.\u01e7 + 6.0f, this.\u0575 + 13.0f, this.\u03c8 - 12.0f, f5, f6);
        ocb29e26d1a9.\u0260(oc8aaacef5d62, this.\u01e7 + 6.0f + f5, this.\u0575, oc4f21845252.\u00d2(this.p.\u00f6(), this.p.\u041c()));
        ocb29e26d1a9.\u0260(oc8aaacef5d62, this.\u01e7 + 6.0f + f6, this.\u0575, oc4f21845252.\u00d2(this.p.\u0456(), this.p.\u041c()));
    }

    private float \u0287(double d) {
        return oc4f21845252.\u0499((float)((d - this.p.\u03b8()) / Math.max(1.0E-6, this.p.\u0276() - this.p.\u03b8()))) * (this.\u03c8 - 12.0f);
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        float f3 = f - this.\u01e7 - 6.0f;
        float f4 = this.\u0287(this.p.\u00f6());
        float f5 = this.\u0287(this.p.\u0456());
        this.\u0110 = Math.abs(f3 - f4) < Math.abs(f3 - f5) || f4 == f5 && f3 < f4 ? 1 : 0xABD24499 ^ 0xABD2449B;
        this.\u048b(f);
        return true;
    }

    private void \u048b(float f) {
        double d = this.p.\u03b8() + (double)oc4f21845252.\u0499((f - this.\u01e7 - 6.0f) / (this.\u03c8 - 12.0f)) * (this.p.\u0276() - this.p.\u03b8());
        if (this.\u0110 == 1) {
            this.p.\u01f9(Math.min(d, this.p.\u0456()));
        } else {
            this.p.\u0437(Math.max(d, this.p.\u00f6()));
        }
        this.z$3e974bso21r1k();
    }

    @Override
    void z$jjpp51h3b2lm() {
        this.\u0110 = 0;
    }

    @Override
    void z$21n2hyuutt37u() {
        this.\u0110 = 0;
        super.z$21n2hyuutt37u();
    }
}

