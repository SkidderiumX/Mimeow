/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import x.L;
import x.oc03814b0e1a;
import x.oc040dee6e11;
import x.oc1e7298eef6;
import x.oc25e9d31d7d;
import x.oc2d39c317eb;
import x.oc417716753f;
import x.oc56e3ec4ee3;
import x.oc59f9452a5e;
import x.oc5f397ea265;
import x.oc7f6c6f758e;
import x.oc9bcf1497a7;
import x.oca0f68927a8;
import x.ocad69c23202;
import x.ocae3bb6ecc0;
import x.ocd63c3dcb1b;
import x.ocdc39746a92;
import x.oce7a77f7e99;

public class oc293826be15 {
    private final oca0f68927a8 \u014a;
    private final oce7a77f7e99 \u015f;
    private final oc03814b0e1a \u011b;
    private final Map<Integer, int[]> \u0115 = new HashMap<Integer, int[]>();
    private final Map<Integer, byte[]> \u03f0 = new HashMap<Integer, byte[]>();
    private final Map<Integer, int[]> \u0435 = new HashMap<Integer, int[]>();
    private static int \u0398 = 1;

    public oc293826be15(ocae3bb6ecc0 ocae3bb6ecc02, oc25e9d31d7d oc25e9d31d7d2, int n, int n2) {
        this.\u011b = oc25e9d31d7d2 instanceof oc03814b0e1a ? (oc03814b0e1a)oc25e9d31d7d2 : null;
        oc5f397ea265 oc5f397ea2652 = new oc5f397ea265(new ocdc39746a92(n, n2), new byte[n * n2], n, n, n2, 0, 0, null);
        oc7f6c6f758e oc7f6c6f758e2 = new oc7f6c6f758e(oc5f397ea2652, n, n2, Arrays.asList(ocae3bb6ecc02), oc293826be15::qrrwijygfy9vq);
        oc59f9452a5e oc59f9452a5e2 = new oc59f9452a5e(this);
        int n3 = oc59f9452a5e2.z$8519guy0xkde(1, n, n2, 0, null);
        int[] nArray = new int[0x60C35E84 ^ 0x60C35E80];
        nArray[0] = n3;
        nArray[1] = 0;
        nArray[0x60C35E82 ^ 0x60C35E80] = 0;
        nArray[0x60C35E83 ^ 0x60C35E80] = 0;
        this.\u015f = new oce7a77f7e99(oc7f6c6f758e2, 0, nArray, oc59f9452a5e2, n, n2, 0, 0);
        oc040dee6e11.\u047b(oc7f6c6f758e2, n, n2, 0, 0);
        this.\u014a = new oca0f68927a8(oc5f397ea2652, ocae3bb6ecc02, oc25e9d31d7d2);
    }

    public float \u02e3(String string, float f, float f2, float f3, int n, float[] fArray) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        return ocd63c3dcb1b.\u04c3(this.\u014a, 0, f, f2, byArray, byArray.length, f3, 0.0f, 0.0f, n, true, this.\u015f.\u0151.v, this.\u015f.\u0151.\u0525, oc1e7298eef6.\u0272, 1.0f, fArray);
    }

    public ocad69c23202 \u00ba(String string, float f, float f2, float f3, int n, float[] fArray) {
        float f4 = ocd63c3dcb1b.\u0538(fArray, L.\u026d(0x5BA64204 ^ 0x5B8D1514), L.\u026d(0x5BA64200 ^ 0x5B8D1514), L.\u026d(0x5BA6420C ^ 0x5B8D1514), 1.0f);
        oc56e3ec4ee3 oc56e3ec4ee32 = new oc56e3ec4ee3(this.\u014a, f * f4, f2 * f4, string.getBytes(StandardCharsets.UTF_8), f3 * f4, 0.0f, 0.0f, n, 0x5B8D1516 ^ 0x5B8D1514, true, this.\u015f.\u0151.v, this.\u015f.\u0151.\u0525);
        ArrayList<oc9bcf1497a7> arrayList = new ArrayList<oc9bcf1497a7>();
        float f5 = ocd63c3dcb1b.\u02e3(oc56e3ec4ee32, f, f4, oc1e7298eef6.\u0272, new oc417716753f(this, oc56e3ec4ee32, arrayList), new oc2d39c317eb());
        return new ocad69c23202(string, arrayList, f5);
    }

    private static byte[] qrrwijygfy9vq(byte[] byArray, long l) {
        return new byte[(int)l];
    }
}

