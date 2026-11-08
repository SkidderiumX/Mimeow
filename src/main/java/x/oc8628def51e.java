/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import x.oc1cb76bf763;
import x.oc38495530cc;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc84fe78a972;
import x.oc8aaacef5d6;
import x.ocaba452434e;
import x.occ99cc6cd9f;

public class oc8628def51e {
    private final oc1cb76bf763 \u03e1;
    private final List<oc84fe78a972> \u0141 = new ArrayList<oc84fe78a972>();
    private final occ99cc6cd9f \u0449 = new occ99cc6cd9f(0x7F5AD60284818549L ^ 0x7F5AD602848185B3L, ocaba452434e.\u0144);
    private float \u0156;
    private float \u019a;
    private float \u00ef;
    private float \u04ba;
    private float \u0115;
    private float \u04b5;

    oc8628def51e(oc1cb76bf763 oc1cb76bf7632) {
        this.\u03e1 = oc1cb76bf7632;
    }

    void \u03bb(List<oc69da1aa7f5> list) {
        ArrayList<oc69da1aa7f5> arrayList = new ArrayList<oc69da1aa7f5>(list);
        arrayList.sort(Comparator.comparing(oc69da1aa7f5::z$3i8m9vxwuvqj0, String.CASE_INSENSITIVE_ORDER));
        HashMap hashMap = new HashMap();
        this.\u0141.forEach(oc84fe78a9722 -> hashMap.put(oc84fe78a9722.\u026e.\u0452() + "\u0000" + oc84fe78a9722.\u026e.z$3i8m9vxwuvqj0(), oc84fe78a9722));
        this.\u0141.clear();
        for (oc69da1aa7f5 oc69da1aa7f52 : arrayList) {
            oc84fe78a972 oc84fe78a9723 = this.\u03e1.\u0465(oc69da1aa7f52);
            oc84fe78a972 oc84fe78a9724 = (oc84fe78a972)hashMap.get(oc69da1aa7f52.\u0452() + "\u0000" + oc69da1aa7f52.z$3i8m9vxwuvqj0());
            if (oc84fe78a9724 != null && oc84fe78a9724 != oc84fe78a9723) {
                oc84fe78a9723.\u0428 = oc84fe78a9724.\u0428;
                oc84fe78a9723.\u0259.\u020e(oc84fe78a9724.\u0259.\u047f());
                oc84fe78a9723.\u0259.\u0540(oc84fe78a9723.\u0428 ? 1.0f : 0.0f);
            }
            this.\u0141.add(oc84fe78a9723);
        }
    }

    void \u04f9(oc8aaacef5d6 oc8aaacef5d62, float f, float f2, float f3, float f4, float f5, float f6) {
        this.\u0156 = f;
        this.\u019a = f2;
        this.\u00ef = f3;
        this.\u04ba = Math.max(0.0f, f4);
        this.\u0115 = 0.0f;
        for (oc84fe78a972 oc84fe78a9722 : this.\u0141) {
            oc84fe78a9722.\u04fb = f3 - 6.0f;
            this.\u0115 += oc84fe78a9722.\u00d8() + 2.0f;
        }
        if (!this.\u0141.isEmpty()) {
            this.\u0115 -= 2.0f;
        }
        this.\u0105();
        float f7 = Math.max(-this.\u044f(), Math.min(0.0f, this.\u0449.\u047f()));
        oc8aaacef5d62.\u023a(f, f2, f3, this.\u04ba, () -> {
            float f6 = f2 + f7;
            for (int i = 0; i < this.\u0141.size(); ++i) {
                oc84fe78a972 oc84fe78a9722 = this.\u0141.get(i);
                oc84fe78a9722.\u01d3 = f;
                oc84fe78a9722.\u0419 = f6;
                oc84fe78a9722.\u0539(f5, f6);
                f6 += oc84fe78a9722.\u03fd + 2.0f;
            }
        });
        if (this.\u0141.isEmpty()) {
            oc8aaacef5d62.\u0456("productsans-medium", "No entries found", f + 10.0f, f2 + 18.0f, 9.0f, 0xE13641FB ^ 0x1E9CEB51);
        }
        oc38495530cc.u(oc8aaacef5d62, f + f3 - 2.0f, f2, this.\u04ba, this.\u0115, -f7);
    }

    void \u03bc(float f, float f2, int n) {
        if (!oc4f21845252.\u0392(f, f2, this.\u0156, this.\u019a, this.\u00ef - 6.0f, this.\u04ba)) {
            return;
        }
        for (oc84fe78a972 oc84fe78a9722 : new ArrayList<oc84fe78a972>(this.\u0141)) {
            if (!oc4f21845252.\u0392(f, f2, oc84fe78a9722.\u01d3, oc84fe78a9722.\u0419, oc84fe78a9722.\u04fb, oc84fe78a9722.\u03fd)) continue;
            oc84fe78a9722.\u0551(f, f2, n);
            return;
        }
    }

    void \u024f(float f, float f2, float f3) {
        if (!oc4f21845252.\u0392(f, f2, this.\u0156, this.\u019a, this.\u00ef, this.\u04ba)) {
            return;
        }
        this.\u04b5 += f3 * 50.0f;
        this.\u0105();
        this.\u0449.\u0540(this.\u04b5);
    }

    void \u0540() {
        this.\u0141.forEach(oc84fe78a9722 -> oc84fe78a9722.q.\u02a2());
    }

    private float \u044f() {
        return Math.max(0.0f, this.\u0115 - this.\u04ba);
    }

    private void \u0105() {
        float f = Math.max(-this.\u044f(), Math.min(0.0f, this.\u04b5));
        if (f != this.\u04b5) {
            this.\u04b5 = f;
            this.\u0449.\u0540(this.\u04b5);
        }
    }
}

