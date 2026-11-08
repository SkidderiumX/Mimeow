/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.oc8aaacef5d6;
import x.oca9cc61aada;
import x.ocaba452434e;
import x.occ99cc6cd9f;

public class ocb29e26d1a9
extends oc4f21845252 {
    private final oca9cc61aada \u01cd;
    private final occ99cc6cd9f \u0259 = new occ99cc6cd9f(0x7EAC1D2CCA6A6C6BL ^ 0x7EAC1D2CCA6A6C59L, ocaba452434e.\u01cd);
    private boolean \u01f1;
    private boolean \u016c;
    private double \u040b;

    ocb29e26d1a9(oca9cc61aada oca9cc61aada2, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        super(oca9cc61aada2, oc69da1aa7f52, oc1cb76bf7632);
        this.\u01cd = oca9cc61aada2;
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        return 26.0f;
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        if (this.\u01f1) {
            this.\u0577(f);
        }
        this.\u045f(oc8aaacef5d62);
        this.\u0548(oc8aaacef5d62, 8.5f);
        double d = this.\u0466() && this.\u01f1 ? this.\u040b : this.\u01cd.\u04c1();
        float f3 = oc4f21845252.\u0499((float)((d - this.\u01cd.\u0515()) / Math.max(1.0E-6, this.\u01cd.\u0236() - this.\u01cd.\u0515()))) * (this.\u03c8 - 12.0f);
        if (!this.\u016c) {
            this.\u0259.\u020e(f3);
            this.\u016c = true;
        }
        float f4 = this.\u0259.\u0540(f3);
        ocb29e26d1a9.\u01cd(oc8aaacef5d62, this.\u01e7 + 6.0f, this.\u0575 + 13.0f, this.\u03c8 - 12.0f, 0.0f, f4);
        String string = d == -1.0 && this.\u01cd.\u01fb ? "Disabled" : (d == this.\u01cd.\u0515() && this.\u01cd.\u0505() != null ? this.\u01cd.\u0505() : oc4f21845252.\u00d2(d, this.\u01cd.\u011c()));
        ocb29e26d1a9.\u0260(oc8aaacef5d62, this.\u01e7 + 6.0f + f4, this.\u0575, string);
    }

    static void \u01cd(oc8aaacef5d6 oc8aaacef5d62, float f, float f2, float f3, float f4, float f5) {
        oc8aaacef5d62.\u027e(f, f2, f3, 2.5f, 1.25f, 0xF2BECA9E ^ 0xD89FDA9);
        if (f5 - f4 > 1.0f) {
            oc8aaacef5d62.\u0419(f + f4, f2, f5 - f4, 2.5f, 1.25f, 1.25f, oc8aaacef5d6.\u012d(), oc8aaacef5d6.z(oc8aaacef5d6.\u012d(), 0.5f), true);
        }
    }

    static void \u0260(oc8aaacef5d6 oc8aaacef5d62, float f, float f2, String string) {
        oc8aaacef5d62.\u0419(f - 1.0f, f2 + 11.7f, 2.0f, 5.0f, 1.0f, 1.0f, -1, 0x3225065B ^ 0xCDC0E3BE, true);
        oc8aaacef5d62.\u0456("productsans-medium", string, f - oc8aaacef5d62.\u01f1("productsans-medium", string, 5.5f) / 2.0f, f2 + 22.0f, 5.5f, 0x13F1C41 ^ 0xCDC0E3BE);
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (n == 1 && this.\u01cd.\u01fb) {
            this.\u01cd.f(this.\u01cd.\u04c1() == -1.0 ? this.\u01cd.\u0515() : -1.0);
            this.s.z$1sehylui0i4ix(this.\u01cd);
            this.z$3e974bso21r1k();
            return true;
        }
        if (n != 0) {
            return false;
        }
        this.\u01f1 = true;
        this.\u040b = this.\u01cd.\u04c1();
        this.\u0577(f);
        return true;
    }

    private boolean \u0466() {
        return this.\u01cd == oc6a43806f12.\u0413;
    }

    private void \u0577(float f) {
        double d = this.\u01cd.\u0515() + (double)oc4f21845252.\u0499((f - this.\u01e7 - 6.0f) / (this.\u03c8 - 12.0f)) * (this.\u01cd.\u0236() - this.\u01cd.\u0515());
        if (this.\u0466()) {
            this.\u040b = (double)Math.round(d / this.\u01cd.\u03d3()) * this.\u01cd.\u03d3();
        } else if (d != this.\u01cd.\u04c1()) {
            this.\u01cd.\u02ab(d);
            this.s.z$1sehylui0i4ix(this.\u01cd);
            this.z$3e974bso21r1k();
        }
    }

    @Override
    void z$jjpp51h3b2lm() {
        if (this.\u01f1 && this.\u0466()) {
            this.\u01cd.\u02ab(this.\u040b);
            this.s.z$1sehylui0i4ix(this.\u01cd);
            this.z$3e974bso21r1k();
        }
        this.\u01f1 = false;
    }

    @Override
    void z$21n2hyuutt37u() {
        this.\u01f1 = false;
        super.z$21n2hyuutt37u();
    }
}

