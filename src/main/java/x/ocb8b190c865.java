/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc2922be51da;
import x.oc497d0cdf29;
import x.oca6eae151db;
import x.ocd299de7725;

public class ocb8b190c865 {
    private final ocd299de7725 \u044c = new ocd299de7725();
    private final ocd299de7725 \u04cf = new ocd299de7725();
    public static int \u03a1;

    public float \u0288(float f, double d, oca6eae151db oca6eae151db2) {
        float f2 = oc497d0cdf29.\u04b0(0.0f, f - this.\u044c.\u0536(0.0f, 0.5f, 5.0, d, oca6eae151db2));
        if (this.\u04cf.\u00c8(0.01f, 0.03f, 30.0, d, oca6eae151db2)) {
            f2 += oca6eae151db2.\u015d(0.5f, 1.0f);
        }
        return f2;
    }

    public float \u01e3(float f, float f2, double d, oca6eae151db oca6eae151db2) {
        float f3 = this.\u044c.\u0536(0.0f, 0.5f, 60.0, d, oca6eae151db2);
        float f4 = this.\u044c.\u0536(0.0f, 0.5f, 5.0, d, oca6eae151db2);
        int n = oc2922be51da.\u0431;
        float f5 = f4 + f3;
        if (this.\u04cf.\u00c8(0.03f, 0.06f, 60.0, d, oca6eae151db2)) {
            f5 += oca6eae151db2.\u015d(0.5f, 2.5f);
        }
        float f6 = f5 * f2 + f;
        if (false) {
            oc2922be51da.\u0431 = ++n;
        }
        return f6;
    }
}

