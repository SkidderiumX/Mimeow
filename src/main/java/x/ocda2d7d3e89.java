/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.oca9cc61aada;
import x.ocaba452434e;
import x.occ99cc6cd9f;

public class ocda2d7d3e89
extends oc4f21845252 {
    private final oca9cc61aada \u023c;
    private final occ99cc6cd9f \u0114 = new occ99cc6cd9f(0xF2773CCFEA0E5981L ^ 0xF2773CCFEA0E59FCL, ocaba452434e.\u03df);
    private boolean \u040b;

    ocda2d7d3e89(oca9cc61aada oca9cc61aada2, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        super(oca9cc61aada2, oc69da1aa7f52, oc1cb76bf7632);
        this.\u023c = oca9cc61aada2;
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        return 32.0f + (float)(Math.max(0, this.\u023c.\u04be().length - 1) * (0x55897CEC ^ 0x55897CE1)) * this.\u0114.\u0540(this.\u040b ? 1.0f : 0.0f);
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        this.\u0548(oc8aaacef5d62, 9.5f);
        oc8aaacef5d62.\u027e(this.\u01e7 + 3.0f, this.\u0575 + 13.5f, this.\u03c8 - 7.0f, this.\u041a - 17.0f, 4.0f, 0xFDE46F75 ^ 0xBDE46F75);
        int n = (int)this.\u023c.\u04c1();
        String[] stringArray = this.\u023c.\u04be();
        if (n >= 0 && n < stringArray.length) {
            oc8aaacef5d62.\u0456("productsans-bold", oc8aaacef5d62.\u0398("productsans-bold", stringArray[n], 7.0f, this.\u03c8 - 27.0f), this.\u01e7 + 7.0f, this.\u0575 + 23.5f, 7.0f, -1);
        }
        oc8aaacef5d62.\u025e(this.\u01e7 + this.\u03c8 - 12.0f, this.\u0575 + 21.5f, 9.0f, this.\u0114.\u047f(), -1);
        if (this.\u0114.\u047f() <= 0.0f) {
            return;
        }
        oc8aaacef5d62.\u023a(this.\u01e7, this.\u0575 + 28.0f, this.\u03c8, this.\u041a - 28.0f, () -> {
            float f = this.\u0575 + 36.0f;
            for (int i = 0; i < stringArray.length; ++i) {
                if (i == n) continue;
                oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", stringArray[i], 7.0f, this.\u03c8 - 14.0f), this.\u01e7 + 7.0f, f, 7.0f, -1);
                f += 13.0f;
            }
        });
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        int n2;
        if (f2 < this.\u0575 + 32.0f && n == 1) {
            this.\u040b = !this.\u040b;
            this.\u0114.\u0540(this.\u040b ? 1.0f : 0.0f);
            return true;
        }
        if (!this.\u040b || n != 0 || f2 < this.\u0575 + 26.5f) {
            return false;
        }
        int n3 = (int)((f2 - this.\u0575 - 26.5f) / 13.0f);
        int n4 = (int)this.\u023c.\u04c1();
        int n5 = n2 = n3 >= n4 ? n3 + 1 : n3;
        if (n2 >= this.\u023c.\u04be().length) {
            return false;
        }
        this.\u023c.\u02ab(n2);
        this.s.z$1sehylui0i4ix(this.\u023c);
        this.\u040b = false;
        this.\u0114.\u0540(0.0f);
        this.z$3e974bso21r1k();
        return true;
    }
}

