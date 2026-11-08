/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;

public class oc9bcf1497a7 {
    public final int \u03e9;
    public final int \u0424;
    public final int \u0133;
    public final byte[] \u03ee;
    public final List<float[]> \u0129;
    final int[] \u00f9;

    oc9bcf1497a7(int n, int n2, int n3, byte[] byArray, List<float[]> list) {
        this(n, n2, n3, byArray, new int[1], list);
    }

    oc9bcf1497a7(int n, int n2, int n3, byte[] byArray, int[] nArray, List<float[]> list) {
        this.\u03e9 = n;
        this.\u0424 = n2;
        this.\u0133 = n3;
        this.\u03ee = byArray;
        this.\u00f9 = nArray;
        this.\u0129 = new ArrayList<float[]>();
        for (float[] fArray : list) {
            this.\u0129.add((float[])fArray.clone());
        }
    }
}

