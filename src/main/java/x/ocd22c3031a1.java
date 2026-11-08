/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.ocb23d192a35;

public class ocd22c3031a1
extends oc4f21845252 {
    private final ocb23d192a35 \u022a;

    ocd22c3031a1(ocb23d192a35 ocb23d192a352, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        super(ocb23d192a352, oc69da1aa7f52, oc1cb76bf7632);
        this.\u022a = ocb23d192a352;
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        String string = this.\u049a.\u04d1(this) ? "[...]" : "[" + oc1cb76bf763.Q(this.\u022a.\u01fa()) + "]";
        float f3 = oc8aaacef5d62.\u01f1("productsans-medium", string, 6.0f);
        oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", this.\u04b3.z$18nrktuqeiysv(), 7.0f, this.\u03c8 - f3 - 14.0f), this.\u01e7 + 5.0f, this.\u0575 + 10.5f, 7.0f, -1);
        oc8aaacef5d62.\u0456("productsans-medium", string, this.\u01e7 + this.\u03c8 - f3 - 5.0f, this.\u0575 + 10.5f, 6.0f, 0x30D3CB4D ^ 0xCF1F0781);
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        this.\u049a.\u04a6(this);
        return true;
    }

    @Override
    boolean z$16m0yo633oydp(char c, int n) {
        this.\u022a.\u00c8(n == 1 || n == (0x220B319C ^ 0x220B314F) ? 0 : n);
        this.\u049a.\u04b7(this);
        this.z$3e974bso21r1k();
        return true;
    }
}

