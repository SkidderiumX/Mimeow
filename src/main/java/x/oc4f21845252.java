/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.math.BigDecimal;
import x.N;
import x.oc1cb76bf763;
import x.oc2cf3d80e17;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;

public class oc4f21845252 {
    final N \u04b3;
    final oc69da1aa7f5 s;
    final oc1cb76bf763 \u049a;
    float \u01e7;
    float \u0575;
    float \u03c8;
    float \u041a;
    boolean \u039b;

    oc4f21845252(N n, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        this.\u04b3 = n;
        this.s = oc69da1aa7f52;
        this.\u049a = oc1cb76bf7632;
    }

    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        return 17.0f;
    }

    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        this.\u0548(oc8aaacef5d62, 10.5f);
    }

    void \u045f(oc8aaacef5d6 oc8aaacef5d62) {
        oc8aaacef5d62.\u0145(this.\u01e7, this.\u0575, this.\u03c8, this.\u041a, 0.0f, this.\u039b ? 5.0f : 0.0f, 0xB375D0CF ^ 0xF375D0CF);
    }

    void \u0548(oc8aaacef5d6 oc8aaacef5d62, float f) {
        oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", this.\u04b3.z$18nrktuqeiysv(), 7.0f, this.\u03c8 - 10.0f), this.\u01e7 + 5.0f, this.\u0575 + f, 7.0f, -1);
    }

    boolean \u00c0(float f, float f2) {
        return oc4f21845252.\u0392(f, f2, this.\u01e7, this.\u0575, this.\u03c8, this.\u041a);
    }

    static boolean \u0392(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f < f3 + f5 && f2 >= f4 && f2 < f4 + f6;
    }

    boolean z$3iwy342velf2h(float f, float f2, int n) {
        return false;
    }

    boolean z$16m0yo633oydp(char c, int n) {
        return false;
    }

    void z$jjpp51h3b2lm() {
    }

    void z$21n2hyuutt37u() {
        this.\u049a.\u04b7(this);
    }

    void z$3e974bso21r1k() {
        this.s.z$3tl278wzjcayb(this.\u04b3);
        this.s.z$2u87utkr1isxg();
        oc2cf3d80e17.\u04eb();
    }

    static String \u00d2(double d, String string) {
        return BigDecimal.valueOf(d).stripTrailingZeros().toPlainString() + (string == null ? "" : string);
    }

    static float \u0499(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }
}

