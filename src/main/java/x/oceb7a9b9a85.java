/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc84f20a0bc5;
import x.ocbce5ea28a3;

public class oceb7a9b9a85 {
    final float \u0113;
    final float \u04e5;
    final float \u0187;
    final float \u0110;
    final float \u03bb;
    final float \u04c4;
    final boolean \u00da;
    final boolean \u015a;

    oceb7a9b9a85(float f, float f2, float f3, float f4, float f5, float f6, boolean bl, boolean bl2) {
        this.\u0113 = f;
        this.\u04e5 = f2;
        this.\u0187 = f3;
        this.\u0110 = f4;
        this.\u03bb = f5;
        this.\u04c4 = f6;
        this.\u00da = bl;
        this.\u015a = bl2;
    }

    boolean \u0451() {
        float f;
        block6: {
            block8: {
                block7: {
                    int n = oc84f20a0bc5.\u0117;
                    float f2 = Math.abs(this.\u03bb) - 1.0E-4f;
                    f = f2 == 0.0f ? 0 : (f2 > 0.0f ? 1 : -1);
                    if (n != 0) break block6;
                    if (f > 0) break block7;
                    float f3 = Math.abs(this.\u04c4) - 1.0E-4f;
                    f = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                    if (n != 0) break block6;
                    if (f <= 0) break block8;
                }
                f = 1.0f;
                break block6;
            }
            f = 0.0f;
        }
        return (boolean)f;
    }

    double[] \u01eb() {
        double[] dArray;
        block4: {
            double[] dArray2;
            block5: {
                dArray2 = ocbce5ea28a3.\u04d2(this.\u04e5, this.\u03bb, this.\u04c4);
                int n = oc84f20a0bc5.\u0117;
                dArray = dArray2;
                if (n != 0) break block4;
                if (dArray != null) break block5;
                double[] dArray3 = new double[0xFD9D872D ^ 0xFD9D872F];
                dArray3[0] = 0.0;
                dArray = dArray3;
                dArray3[1] = 0.0;
                break block4;
            }
            dArray = dArray2;
        }
        return dArray;
    }
}

