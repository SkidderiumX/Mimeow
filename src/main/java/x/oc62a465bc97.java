/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.L;
import x.oc057476a9f5;
import x.oc2a44055d35;

public class oc62a465bc97 {
    private oc62a465bc97() {
    }

    private static float \u01ab(float[] fArray, int n, float f, float f2, float f3) {
        return fArray[n + (0x32DB0EBD ^ 0x32DB0EB5)] * f3 + (fArray[n] * f + fArray[n + (0x32DB0EB1 ^ 0x32DB0EB5)] * f2) + fArray[n + (0x32DB0EB9 ^ 0x32DB0EB5)];
    }

    private static float \u00ec(float[] fArray, int n, float f, float f2, float f3, float f4) {
        return fArray[n + (0x99AAD915 ^ 0x99AAD919)] * f4 + (fArray[n + (0x99AAD911 ^ 0x99AAD919)] * f3 + (fArray[n] * f + fArray[n + (0x99AAD91D ^ 0x99AAD919)] * f2));
    }

    public static oc2a44055d35 \u0151(double[] dArray, float[] fArray, float[] fArray2, float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6 = (float)dArray[0];
        float f7 = (float)dArray[1];
        float f8 = (float)dArray[0xC26FB90A ^ 0xC26FB908];
        float f9 = oc62a465bc97.\u01ab(fArray, 0, f6, f7, f8);
        float f10 = oc62a465bc97.\u00ec(fArray2, 0xC26FB90B ^ 0xC26FB908, f9, f5 = oc62a465bc97.\u01ab(fArray, 1, f6, f7, f8), f4 = oc62a465bc97.\u01ab(fArray, 0xC26FB90A ^ 0xC26FB908, f6, f7, f8), f3 = f8 * fArray[0xC26FB903 ^ 0xC26FB908] + (f6 * fArray[0xC26FB90B ^ 0xC26FB908] + f7 * fArray[0xC26FB90F ^ 0xC26FB908]) + fArray[0xC26FB907 ^ 0xC26FB908]);
        if (f10 == 0.0f) {
            return null;
        }
        float f11 = L.\u026d(0xC27B4508 ^ 0xC26FB908);
        float f12 = L.\u026d(0xC27B450C ^ 0xC26FB908);
        float f13 = f11 / f10 * f12;
        float f14 = oc62a465bc97.\u00ec(fArray2, 0xC26FB90A ^ 0xC26FB908, f9, f5, f4, f3) * f13 + f12;
        if (!(0.0f >= f14) && !(f14 >= f11)) {
            float f15 = oc62a465bc97.\u00ec(fArray2, 1, f9, f5, f4, f3) * f13 + f12;
            float f16 = (f3 * fArray2[0xC26FB904 ^ 0xC26FB908] + (f4 * fArray2[0xC26FB900 ^ 0xC26FB908] + (f9 * fArray2[0] + f5 * fArray2[0xC26FB90C ^ 0xC26FB908]))) * f13 + f12;
            return new oc2a44055d35(f16 * f, f2 - f15 * f2, f13);
        }
        return null;
    }

    public static float \u0479(float f, float f2, float f3) {
        return f + f3 * (f2 - f);
    }

    public static double[] \u0206(double[] dArray, double[] dArray2, double d) {
        double[] dArray3 = new double[0xA8C0D814 ^ 0xA8C0D817];
        dArray3[0] = dArray[0] + d * (dArray2[0] - dArray[0]);
        dArray3[1] = dArray[1] + d * (dArray2[1] - dArray[1]);
        dArray3[0xA8C0D815 ^ 0xA8C0D817] = dArray[0xA8C0D815 ^ 0xA8C0D817] + d * (dArray2[0xA8C0D815 ^ 0xA8C0D817] - dArray[0xA8C0D815 ^ 0xA8C0D817]);
        return dArray3;
    }

    public static double[] \u043c(double[] dArray, double[] dArray2) {
        double[] dArray3 = new double[0x65F4FE12 ^ 0x65F4FE11];
        dArray3[0] = dArray[0] - dArray2[0];
        dArray3[1] = dArray[1] - dArray2[1];
        dArray3[0x65F4FE13 ^ 0x65F4FE11] = dArray[0x65F4FE13 ^ 0x65F4FE11] - dArray2[0x65F4FE13 ^ 0x65F4FE11];
        return dArray3;
    }

    public static double[] \u012f(double[] dArray, double[] dArray2) {
        double[] dArray3 = new double[0x33B985C ^ 0x33B985F];
        dArray3[0] = dArray[0] + dArray2[0];
        dArray3[1] = dArray[1] + dArray2[1];
        dArray3[0x33B985D ^ 0x33B985F] = dArray[0x33B985D ^ 0x33B985F] + dArray2[0x33B985D ^ 0x33B985F];
        return dArray3;
    }

    public static double[] \u0234(double[] dArray, double d) {
        double[] dArray2 = new double[0xDCCA0B06 ^ 0xDCCA0B05];
        dArray2[0] = dArray[0] * d;
        dArray2[1] = dArray[1] * d;
        dArray2[0xDCCA0B07 ^ 0xDCCA0B05] = dArray[0xDCCA0B07 ^ 0xDCCA0B05] * d;
        return dArray2;
    }

    public static double \u03e8(double[] dArray, double[] dArray2) {
        double d = dArray[0] - dArray2[0];
        double d2 = dArray[1] - dArray2[1];
        double d3 = dArray[0xB3D6458 ^ 0xB3D645A] - dArray2[0xB3D6458 ^ 0xB3D645A];
        return d3 * d3 + (d * d + d2 * d2);
    }

    public static float \u0517(float f, float f2) {
        return f < f2 ? f : f2;
    }

    public static float \u057f(float f, float f2) {
        return f > f2 ? f : f2;
    }

    public static float \u0496(float f, float f2, float f3) {
        return f3 < f ? f : oc62a465bc97.\u0517(f2, f3);
    }

    public static float \u0181(float f) {
        float f2 = f * f;
        return (L.\u026d(0xF827C104 ^ 0xF83429D0) - (f + f)) * f2;
    }

    public static int \u045e(float f, float f2) {
        return Float.compare(f2, f);
    }

    public static oc057476a9f5 z(oc057476a9f5 oc057476a9f52, oc057476a9f5 oc057476a9f53, float f) {
        return new oc057476a9f5(oc62a465bc97.\u0479(oc057476a9f52.\u0130, oc057476a9f53.\u0130, f), oc62a465bc97.\u0479(oc057476a9f52.\u0562, oc057476a9f53.\u0562, f), oc62a465bc97.\u0479(oc057476a9f52.\u01b8, oc057476a9f53.\u01b8, f));
    }

    public static boolean \u01ef(float f, float f2, float f3, float f4, float f5, float f6) {
        return !((0.0f > f || 0.0f > f2 || f > f5 || f2 > f6) && (0.0f > f3 || f3 > f5 || 0.0f > f4 || f4 > f6));
    }

    public static boolean \u041f(int n) {
        int n2 = n & (0x38BDF736 ^ 0x38BDF7C9);
        return ((n2 & (0x38BDF716 ^ 0x38BDF7C9)) + (0x38BDF776 ^ 0x38BDF7C9) & (0x38BDF736 ^ 0x38BDF7C9)) < (0x38BDF7D3 ^ 0x38BDF7C9) || n2 == (0x38BDF7E9 ^ 0x38BDF7C9) || (n2 - (0x38BDF7F9 ^ 0x38BDF7C9) & (0x38BDF736 ^ 0x38BDF7C9)) < (0x38BDF7C3 ^ 0x38BDF7C9);
    }
}

