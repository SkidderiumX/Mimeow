/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc8aaacef5d6;

public abstract class oc38495530cc {
    final oc1cb76bf763 \u0291;
    float \u00e3;
    float \u04b4;
    float \u03bc;
    float \u0514;

    oc38495530cc(oc1cb76bf763 oc1cb76bf7632) {
        this.\u0291 = oc1cb76bf7632;
    }

    final void H(oc8aaacef5d6 oc8aaacef5d62, float f, float f2, float f3, float f4) {
        this.\u03bc = Math.min(420.0f, f3 - 24.0f);
        this.\u0514 = Math.min(320.0f, Math.max(80.0f, f4 - 64.0f));
        this.\u00e3 = (f3 - this.\u03bc) / 2.0f;
        this.\u04b4 = Math.max(44.0f, (f4 - this.\u0514) / 2.0f);
        oc8aaacef5d62.\u0454(this.\u00e3, this.\u04b4, this.\u03bc, this.\u0514, 5.0f, 5.0f);
        oc8aaacef5d62.\u0145(this.\u00e3, this.\u04b4, this.\u03bc, 26.0f, 5.0f, 0.0f, 0x6383F3A7 ^ 0xBA8CFCA8);
        oc8aaacef5d62.\u0145(this.\u00e3, this.\u04b4 + 26.0f, this.\u03bc, this.\u0514 - 26.0f, 0.0f, 5.0f, 0x992E285 ^ 0xBA8CFCA8);
        this.z$1h526f5jynsva(oc8aaacef5d62, f, f2);
    }

    final void \u047f(oc8aaacef5d6 oc8aaacef5d62, String string, String string2, String string3) {
        oc8aaacef5d62.\u0456("materialicons-outlined", string2, this.\u00e3 + 10.0f, this.\u04b4 + 18.0f, 12.0f, oc8aaacef5d6.\u012d());
        oc8aaacef5d62.\u0456("productsans-bold", string, this.\u00e3 + 29.0f, this.\u04b4 + 17.0f, 10.0f, -1);
        oc8aaacef5d62.\u0456("productsans-medium", string3, this.\u00e3 + this.\u03bc - 10.0f - oc8aaacef5d62.\u01f1("productsans-medium", string3, 8.0f), this.\u04b4 + 17.0f, 8.0f, 0xB307A502 ^ 0x4CAD0FA8);
    }

    final void \u041e(oc8aaacef5d6 oc8aaacef5d62, String string) {
        oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", string, 8.0f, this.\u03bc - 20.0f), this.\u00e3 + 10.0f, this.\u04b4 + this.\u0514 - 9.0f, 8.0f, 0x90F14A1B ^ 0x6F5BE0B1);
    }

    static void \u0138(oc8aaacef5d6 oc8aaacef5d62, String string, float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        if (bl) {
            oc8aaacef5d62.\u0419(f, f2, f3, f4, 3.0f, 3.0f, oc8aaacef5d6.\u0161(oc8aaacef5d6.\u012d(), 0.4f), oc8aaacef5d6.\u0161(oc8aaacef5d6.\u0173(), 0.4f), false);
        } else {
            oc8aaacef5d62.\u027e(f, f2, f3, f4, 3.0f, oc4f21845252.\u0392(f5, f6, f, f2, f3, f4) ? 0x8BE298EB ^ 0xAE1D6714 : 0xEE1D6714 ^ 0xAE1D6714);
        }
        oc8aaacef5d62.\u0456(bl ? "productsans-bold" : "productsans-medium", string, f + (f3 - oc8aaacef5d62.\u01f1("productsans-medium", string, 8.0f)) / 2.0f, f2 + f4 / 2.0f + 3.0f, 8.0f, bl ? -1 : 0x51D1ABD8 ^ 0xAE1D6714);
    }

    static void u(oc8aaacef5d6 oc8aaacef5d62, float f, float f2, float f3, float f4, float f5) {
        if (f4 <= f3 || f3 <= 0.0f) {
            return;
        }
        float f6 = Math.max(12.0f, f3 * f3 / f4);
        float f7 = f2 + (f3 - f6) * Math.min(1.0f, Math.max(0.0f, f5 / (f4 - f3)));
        oc8aaacef5d62.\u027e(f, f2, 2.0f, f3, 1.0f, 0x77474EE6 ^ 0x47474EE6);
        oc8aaacef5d62.\u027e(f, f7, 2.0f, f6, 1.0f, oc8aaacef5d6.\u0161(oc8aaacef5d6.\u012d(), 0.7f));
    }

    abstract void z$ohfkdtvsjxqf();

    abstract void z$1h526f5jynsva(oc8aaacef5d6 var1, float var2, float var3);

    abstract void z$10zmr5yjmvvef(float var1, float var2, int var3);

    abstract void z$1zwd02zrw5ico(float var1, float var2, float var3);

    abstract void z$3mqeupmq4p81d();
}

