/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Arrays;
import java.util.Comparator;

public class oc07d263d49a {
    private oc07d263d49a() {
    }

    static float[] \u0442(float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, boolean[] blArray, float f) {
        int n2 = fArray.length;
        if (fArray2.length != n2 || fArray3.length != n2 || fArray4.length != n2 || blArray.length != n2) {
            throw new IllegalArgumentException("Mismatched category layout arrays");
        }
        Integer[] integerArray = new Integer[n2];
        for (int i = 0; i < n2; ++i) {
            integerArray[i] = i;
        }
        Arrays.sort(integerArray, Comparator.comparingDouble(n -> fArray2[n]).thenComparingDouble(n -> fArray[n]));
        float[] fArray5 = (float[])fArray2.clone();
        for (int i = 0; i < integerArray.length; ++i) {
            int n3 = integerArray[i];
            float f2 = fArray2[n3];
            if (!blArray[n3]) {
                for (int j = 0; j < i; ++j) {
                    int n4 = integerArray[j];
                    float f3 = fArray5[n4] + fArray4[n4];
                    if (fArray2[n3] >= f3 || !oc07d263d49a.\u014b(fArray[n3], fArray3[n3], fArray[n4], fArray3[n4])) continue;
                    f2 = Math.max(f2, f3 + f);
                }
            }
            fArray5[n3] = f2;
        }
        return fArray5;
    }

    private static boolean \u014b(float f, float f2, float f3, float f4) {
        float f5 = Math.min(f + f2, f3 + f4) - Math.max(f, f3);
        return f5 >= Math.min(f2, f4) * 0.5f;
    }
}

