/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.oc1cb76bf763;
import x.oc4f21845252;
import x.oc84fe78a972;
import x.ocaba452434e;
import x.occ99cc6cd9f;

public class oc7af2e0512e {
    final String \u0467;
    final String \u029d;
    final List<oc84fe78a972> \u039b;
    final occ99cc6cd9f \u0163;
    final occ99cc6cd9f \u00c4;
    float \u0446;
    float \u0278;
    float \u0417;
    float \u0159;
    final oc1cb76bf763 this$0;

    oc7af2e0512e(oc1cb76bf763 oc1cb76bf7632, String string, String string2, int n) {
        this.this$0 = oc1cb76bf7632;
        this.\u039b = new ArrayList<oc84fe78a972>();
        this.\u00c4 = new occ99cc6cd9f(0xFF2EEDF856C85AB2L ^ 0xFF2EEDF856C85A48L, ocaba452434e.\u0144);
        this.\u0467 = string;
        this.\u029d = string2;
        this.\u0163 = new occ99cc6cd9f((0xFF2EEDF856C85AC4L ^ 0xFF2EEDF856C85A48L) + (long)n * (0xFF2EEDF856C85A65L ^ 0xFF2EEDF856C85A48L), ocaba452434e.\u04ee);
    }

    void \u021e(float f, float f2) {
        this.\u0278 = 0.0f;
        for (oc84fe78a972 oc84fe78a9722 : this.\u039b) {
            oc84fe78a9722.\u04fb = 110.0f;
            this.\u0278 += oc84fe78a9722.\u00d8() + 2.0f;
        }
        if (!this.\u039b.isEmpty()) {
            this.\u0278 -= 2.0f;
        }
        float f3 = this.\u0163.\u0540(this.this$0.\u012e ? 0.0f : 1.0f);
        float f4 = Math.max(0.0f, this.this$0.\u00da - 68.0f - 16.0f);
        this.\u0417 = Math.min(f4, this.\u0278) * f3;
        float f5 = Math.max(-this.\u027c(), Math.min(0.0f, this.\u0159));
        if (this.\u0159 != f5) {
            this.\u0159 = f5;
            this.\u00c4.\u0540(f5);
        }
        float f6 = Math.max(-this.\u027c(), Math.min(0.0f, this.\u00c4.\u047f()));
        this.this$0.\u0526.\u0459(f3);
        this.this$0.\u0526.\u0454(this.\u0446, 44.0f, 110.0f, 20.0f, 5.0f, 5.0f);
        this.this$0.\u0526.\u027e(this.\u0446, 44.0f, 110.0f, 20.0f, 5.0f, 0x6DAEF6D8 ^ 0xB4A1F9D7);
        this.this$0.\u0526.\u0456("productsans-bold", this.\u0467, this.\u0446 + 5.0f, 57.0f, 9.0f, -1);
        this.this$0.\u0526.\u0456("materialicons-outlined", this.\u029d, this.\u0446 + 110.0f - 15.5f, 59.0f, 10.0f, -1);
        this.this$0.\u0526.\u023a(this.\u0446, 68.0f, 110.0f, this.\u0417, () -> this.q32ku5fff45rdi(f6, f, f2));
        this.this$0.\u0526.\u0459(1.0f);
    }

    float \u027c() {
        return Math.max(0.0f, this.\u0278 - Math.max(0.0f, this.this$0.\u00da - 68.0f - 16.0f));
    }

    boolean \u04f0(float f, float f2) {
        return oc4f21845252.\u0392(f, f2, this.\u0446, 68.0f, 110.0f, this.\u0417);
    }

    void \u0135(float f, float f2, int n) {
        for (oc84fe78a972 oc84fe78a9722 : this.\u039b) {
            if (!oc4f21845252.\u0392(f, f2, oc84fe78a9722.\u01d3, oc84fe78a9722.\u0419, oc84fe78a9722.\u04fb, oc84fe78a9722.\u03fd)) continue;
            oc84fe78a9722.\u0551(f, f2, n);
            return;
        }
    }

    private void q32ku5fff45rdi(float f, float f2, float f3) {
        float f4 = 68.0f + f;
        for (oc84fe78a972 oc84fe78a9722 : this.\u039b) {
            oc84fe78a9722.\u01d3 = this.\u0446;
            oc84fe78a9722.\u0419 = f4;
            oc84fe78a9722.\u0539(f2, f3);
            f4 += oc84fe78a9722.\u03fd + 2.0f;
        }
    }
}

