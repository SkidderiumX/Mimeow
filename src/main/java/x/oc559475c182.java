/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.ocada7dda290;
import x.occb76dd375e;

public class oc559475c182
extends oc4f21845252 {
    private final ocada7dda290 \u019e;
    private final List<occb76dd375e> \u03c2 = new ArrayList<occb76dd375e>();

    oc559475c182(ocada7dda290 ocada7dda2902, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        super(ocada7dda2902, oc69da1aa7f52, oc1cb76bf7632);
        this.\u019e = ocada7dda2902;
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        this.\u03c2.clear();
        float f = 2.0f;
        float f2 = 0.0f;
        for (String string : this.\u019e.\u01e5()) {
            float f3 = Math.min(this.\u03c8 - 12.0f, oc8aaacef5d62.\u01f1("productsans-medium", string, 6.0f) + 8.75f);
            if (f > 2.0f && f + f3 > this.\u03c8 - 10.0f) {
                f = 2.0f;
                f2 += 10.0f;
            }
            this.\u03c2.add(new occb76dd375e(string, f, f2, f3 - 4.0f));
            f += f3 - 2.5f;
        }
        return 28.5f + f2;
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        this.\u0548(oc8aaacef5d62, 8.5f);
        oc8aaacef5d62.\u04ce(this.\u01e7 + 5.0f, this.\u0575 + 13.0f, this.\u03c8 - 10.0f, this.\u041a - 17.0f, 2.5f, 1.5f, 0x89AC2D0B ^ 0x76FC7D5B);
        oc8aaacef5d62.\u027e(this.\u01e7 + 5.0f, this.\u0575 + 13.0f, this.\u03c8 - 10.0f, this.\u041a - 17.0f, 2.5f, 0x89E56442 ^ 0x76FC7D5B);
        for (occb76dd375e occb76dd375e2 : this.\u03c2) {
            oc8aaacef5d62.\u027e(this.\u01e7 + 4.5f + occb76dd375e2.\u03c4, this.\u0575 + 14.5f + occb76dd375e2.\u024b, occb76dd375e2.\u03e1, 8.5f, 2.5f, this.\u019e.\u01e9(occb76dd375e2.\u0491) ? oc8aaacef5d6.\u0161(oc8aaacef5d6.\u012d(), 0.4f) : 0x89CF4E68 ^ 0x76FC7D5B);
            oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", occb76dd375e2.\u0491, 6.0f, occb76dd375e2.\u03e1 - 4.0f), this.\u01e7 + 7.0f + occb76dd375e2.\u03c4, this.\u0575 + 21.0f + occb76dd375e2.\u024b, 6.0f, this.\u019e.\u01e9(occb76dd375e2.\u0491) ? 0x900382A4 ^ 0x76FC7D5B : 0x8930B197 ^ 0x76FC7D5B);
        }
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        for (occb76dd375e occb76dd375e2 : this.\u03c2) {
            if (!oc4f21845252.\u0392(f, f2, this.\u01e7 + 4.5f + occb76dd375e2.\u03c4, this.\u0575 + 14.5f + occb76dd375e2.\u024b, occb76dd375e2.\u03e1, 8.5f)) continue;
            this.\u019e.\u0465(occb76dd375e2.\u0491);
            this.z$3e974bso21r1k();
            return true;
        }
        return false;
    }
}

