/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1079614cc6;
import x.oc1cb76bf763;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.ocaba452434e;
import x.occ99cc6cd9f;

public class oc84fe78a972 {
    private final oc1cb76bf763 \u053c;
    private final oc8aaacef5d6 \u0227;
    final oc69da1aa7f5 \u026e;
    final oc1079614cc6 q;
    final occ99cc6cd9f \u0259 = new occ99cc6cd9f(0x36EFB898A981338AL ^ 0x36EFB898A98133F7L, ocaba452434e.\u03df);
    final occ99cc6cd9f \u0282 = new occ99cc6cd9f(0x36EFB898A9813361L ^ 0x36EFB898A98133F7L, ocaba452434e.\u03df);
    boolean \u0428;
    float \u01d3;
    float \u0419;
    float \u04fb = 110.0f;
    float \u03fd;

    oc84fe78a972(oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632, oc8aaacef5d6 oc8aaacef5d62) {
        this.\u053c = oc1cb76bf7632;
        this.\u0227 = oc8aaacef5d62;
        this.\u026e = oc69da1aa7f52;
        this.q = new oc1079614cc6(oc69da1aa7f52, oc1cb76bf7632);
        this.\u0282.\u020e(oc69da1aa7f52.z$3rzb3dil7uydr() ? 1.0f : 0.0f);
    }

    float \u00d8() {
        float f = this.\u0259.\u0540(this.\u0428 ? 1.0f : 0.0f);
        this.\u03fd = 24.0f + (f > 0.0f ? f * (this.q.\u0116(this.\u0227, this.\u04fb - 10.0f) + 6.0f) : 0.0f);
        return this.\u03fd;
    }

    void \u0539(float f, float f2) {
        this.\u0227.\u0454(this.\u01d3, this.\u0419, this.\u04fb, this.\u03fd, 7.0f, 7.0f);
        this.\u0227.\u027e(this.\u01d3, this.\u0419, this.\u04fb, this.\u03fd, 7.0f, 0xCB23BFE7 ^ 0x783DA1CA);
        float f3 = this.\u0282.\u0540(this.\u026e.z$3rzb3dil7uydr() ? 1.0f : 0.0f);
        this.\u0227.\u0419(this.\u01d3, this.\u0419, this.\u04fb, this.\u03fd, 7.0f, 7.0f, oc8aaacef5d6.\u0161(oc8aaacef5d6.\u012d(), f3 * 0.4f), oc8aaacef5d6.\u0161(oc8aaacef5d6.\u0173(), f3 * 0.4f), false);
        this.\u0227.\u023a(this.\u01d3, this.\u0419, this.\u04fb, this.\u03fd, () -> {
            String string;
            int n;
            String string2 = this.\u026e.z$3rzb3dil7uydr() ? "productsans-bold" : "productsans-medium";
            int n2 = n = this.\u026e.z$3rzb3dil7uydr() ? -1 : 0xE3053350 ^ 0x1CC9FF9C;
            String string3 = this.\u053c.\u040e(this) ? "[...]" : (string = this.\u053c.\u04d7() && this.\u026e.\u027d() != 0 ? "[" + oc1cb76bf763.Q(this.\u026e.\u027d()) + "]" : null);
            float f3 = string == null ? (this.q.\u0169() ? this.\u04fb - 18.0f : this.\u04fb - 31.0f) : this.\u04fb - 18.0f - this.\u0227.\u01f1("productsans-medium", string, 7.0f);
            this.\u0227.\u0456(string2, this.\u0227.\u0398(string2, this.\u026e.z$3i8m9vxwuvqj0(), 8.5f, f3), this.\u01d3 + 9.0f, this.\u0419 + 15.0f, 8.5f, n);
            if (string != null) {
                this.\u0227.\u0456("productsans-medium", string, this.\u01d3 + this.\u04fb - 5.0f - this.\u0227.\u01f1("productsans-medium", string, 7.0f), this.\u0419 + 15.0f, 7.0f, -1);
            } else if (!this.q.\u0169()) {
                this.\u0227.\u025e(this.\u01d3 + this.\u04fb - 11.0f, this.\u0419 + 12.0f, 10.0f, this.\u0259.\u047f(), n);
            }
            if (this.\u0259.\u047f() > 0.0f) {
                this.q.\u011d(this.\u0227, this.\u01d3 + 5.0f, this.\u0419 + 24.0f, this.\u04fb - 10.0f, f, f2, true);
            }
        });
    }

    void \u0551(float f, float f2, int n) {
        if (f2 < this.\u0419 + 24.0f) {
            if (n == 0) {
                this.\u026e.z$11p1yfisf2riw();
            } else if (n == 1 && !this.q.\u0169()) {
                this.\u0428 = !this.\u0428;
                this.\u0259.\u0540(this.\u0428 ? 1.0f : 0.0f);
                if (!this.\u0428) {
                    this.q.\u02a2();
                }
            } else if (n == (0xBB0FCFF4 ^ 0xBB0FCFF6)) {
                this.\u053c.\u0464(this);
            }
            return;
        }
        if (this.\u0428) {
            this.q.\u0446(f, f2, n);
        }
    }
}

