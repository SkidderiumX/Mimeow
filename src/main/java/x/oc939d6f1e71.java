/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.oc41720aed4a;
import x.ocaba452434e;
import x.occ99cc6cd9f;

public class oc939d6f1e71 {
    final List<oc41720aed4a> \u0273 = new ArrayList<oc41720aed4a>();
    final occ99cc6cd9f \u0148 = new occ99cc6cd9f(0x6F4C70D308DD7BE4L ^ 0x6F4C70D308DD7B1EL, ocaba452434e.\u0144);
    String \u0546 = "";
    boolean \u018c;
    boolean \u0154;
    float \u03cf;

    private oc939d6f1e71() {
    }

    float \u03df(float f) {
        return Math.max(0.0f, (float)(this.\u0273.size() * (0x35D8A9B4 ^ 0x35D8A998)) - f);
    }

    void \u0141(float f) {
        float f2 = Math.max(0.0f, Math.min(this.\u03df(f), this.\u03cf));
        if (f2 != this.\u03cf) {
            this.\u03cf = f2;
            this.\u0148.\u0540(this.\u03cf);
        }
    }
}

